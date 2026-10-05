'use strict';
const { test, beforeEach } = require('node:test');
const assert = require('node:assert/strict');
const Module = require('node:module');
const records = new Map();
const copy = (value) => value === undefined ? undefined : structuredClone(value);
function ref(path) {
  return { path, id: path.split('/').at(-1), collection: (name) => collection(`${path}/${name}`) };
}
function collection(path) {
  return {
    path, doc: (name) => ref(`${path}/${name}`),
    where(field, operator, value) { return { query: true, path, field, value, limit: (count) => ({ query: true, path, field, value, count }) }; },
  };
}
function snapshot(reference) {
  const data = copy(records.get(reference.path));
  return { ...reference, ref: reference, exists: data !== undefined, get: (name) => data?.[name], data: () => data };
}
const db = {
  collection,
  async runTransaction(body) {
    const writes = [];
    const tx = {
      async get(reference) {
        assert.equal(writes.length, 0, 'Firestore transaction reads must precede writes');
        if (!reference.query) return snapshot(reference);
        const docs = [...records.keys()].filter((key) => key.startsWith(`${reference.path}/`) && key.split('/').length === reference.path.split('/').length + 1)
          .map((key) => snapshot(ref(key))).filter((item) => item.get(reference.field) === reference.value).slice(0, reference.count ?? Infinity);
        return { docs, size: docs.length };
      },
      set: (reference, data) => writes.push(['set', reference.path, copy(data)]),
      update: (reference, data) => writes.push(['update', reference.path, copy(data)]),
      create: (reference, data) => writes.push(['create', reference.path, copy(data)]),
      delete: (reference) => writes.push(['delete', reference.path]),
    };
    const result = await body(tx);
    for (const [type, path, data] of writes) {
      if (type === 'create') assert.equal(records.has(path), false, 'duplicate activity id');
      if (type === 'delete') records.delete(path);
      else records.set(path, type === 'update' ? { ...records.get(path), ...data } : data);
    }
    return result;
  },
};
class HttpsError extends Error { constructor(code, message) { super(message); this.code = code; } }
const stubs = {
  'firebase-admin/app': { initializeApp() {} },
  'firebase-admin/auth': { getAuth() {} },
  'firebase-admin/firestore': { getFirestore: () => db, Timestamp: {}, FieldValue: {} },
  'firebase-functions/v2/https': { onCall: (_options, body) => body, HttpsError },
  'firebase-functions/v2/firestore': { onDocumentCreated: (_path, body) => body },
  'firebase-functions/v2/pubsub': { onMessagePublished: (_options, body) => body },
  'firebase-functions/v2': { setGlobalOptions() {} },
  'google-auth-library': { GoogleAuth: class {} },
};
const originalLoad = Module._load;
let handlers;
try {
  Module._load = function (name, ...args) { return Object.hasOwn(stubs, name) ? stubs[name] : originalLoad.call(this, name, ...args); };
  handlers = require('../src/index');
} finally { Module._load = originalLoad; }
beforeEach(() => {
  records.clear();
  records.set('users/alice', { uid: 'alice', verifiedXp: 0 });
  records.set('leaderboard/alice', { uid: 'alice', username: 'alice_tr', avatar: 'g=1' });
  records.set('usernames/alice_tr', { uid: 'alice' });
});
const request = (data, uid = 'alice') => ({ auth: { uid }, data: { uid, ...data } });
const fails = (promise, code) => assert.rejects(promise, (error) => error.code === code);

test('claim rejects unauthenticated users and another learners reserved name', async () => {
  await fails(handlers.claimUsername({ data: { username: 'new_name' } }), 'unauthenticated');
  records.set('usernames/bob_name', { uid: 'bob' });
  await fails(handlers.claimUsername(request({ username: 'bob_name' })), 'already-exists');
  assert.equal(records.get('usernames/bob_name').uid, 'bob');
});
test('claim releases old aliases and updates the board atomically', async () => {
  records.set('usernames/old_alias', { uid: 'alice' });
  await handlers.claimUsername(request({ username: 'new_name' }));
  assert.equal(records.has('usernames/alice_tr'), false);
  assert.equal(records.has('usernames/old_alias'), false);
  assert.equal(records.get('usernames/new_name').uid, 'alice');
  assert.equal(records.get('usernameOwners/alice').name, 'new_name');
  assert.equal(records.get('leaderboard/alice').username, 'new_name');
  await handlers.claimUsername(request({ username: 'new_name' }));
  await fails(handlers.claimUsername(request({ username: 'next_name' })), 'resource-exhausted');
});
test('deleting accounts cannot reserve names or publish activity', async () => {
  records.set('users/alice', { deletionRequested: true });
  await fails(handlers.claimUsername(request({ username: 'new_name' })), 'failed-precondition');
  await fails(handlers.postActivity(request({ kind: 'story' })), 'failed-precondition');
});
test('activity enforces five posts and ignores user-provided identity and caption', async () => {
  for (let index = 0; index < 5; index++) {
    await handlers.postActivity(request({ kind: 'story', text: 'arbitrary text', username: 'bob', avatar: 'fake' }));
  }
  await fails(handlers.postActivity(request({ kind: 'story' })), 'resource-exhausted');
  const items = [...records.entries()].filter(([path]) => path.startsWith('activity/')).map(([, data]) => data);
  assert.equal(items.length, 5);
  assert.equal(items.every((item) => item.uid === 'alice' && item.username === 'alice_tr' && item.avatar === 'g=1'), true);
  assert.equal(items.every((item) => item.text === 'Bir hikâye çalışması tamamladı! 📖'), true);
});
test('activity requires an owned username and an allowed template', async () => {
  await fails(handlers.postActivity(request({ kind: 'free text' })), 'invalid-argument');
  records.set('usernames/alice_tr', { uid: 'bob' });
  await fails(handlers.postActivity(request({ kind: 'story' })), 'failed-precondition');
  assert.equal(records.get('users/alice').activityCount, undefined);
});

test('stale account actions cannot mutate a newly signed-in account', async () => {
  await fails(handlers.claimUsername(request({ uid: 'bob', username: 'new_name' })), 'permission-denied');
  await fails(handlers.postActivity(request({ uid: 'bob', kind: 'story' })), 'permission-denied');
  assert.equal(records.has('usernames/new_name'), false);
  assert.equal(records.get('users/alice').activityCount, undefined);
});
