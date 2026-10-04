const fs = require('node:fs');
const path = require('node:path');
const { after, before, beforeEach, test } = require('node:test');
const {
  assertFails,
  assertSucceeds,
  initializeTestEnvironment,
} = require('@firebase/rules-unit-testing');
const {
  collection,
  deleteDoc,
  doc,
  getDoc,
  getDocs,
  increment,
  serverTimestamp,
  setDoc,
  updateDoc,
} = require('firebase/firestore');

let env;
const rules = fs.readFileSync(path.join(__dirname, '../../firestore.rules'), 'utf8');

before(async () => {
  env = await initializeTestEnvironment({
    projectId: 'demo-linguapro-rules',
    firestore: { rules },
  });
});

beforeEach(async () => {
  await env.clearFirestore();
});

after(async () => {
  if (env) await env.cleanup();
});

function profile(uid, overrides = {}) {
  return {
    uid,
    displayName: 'Test Learner',
    email: `${uid}@example.test`,
    cefrLevel: 'A1',
    completedLessons: 0,
    completedByLevelA1: 0,
    completedByLevelA2: 0,
    completedByLevelB1: 0,
    completedByLevelB2: 0,
    completedByLevelC1: 0,
    completedByLevelC2: 0,
    skillMastery: {},
    onboardingComplete: false,
    createdAt: serverTimestamp(),
    updatedAt: serverTimestamp(),
    ...overrides,
  };
}

test('authenticated learner can create and read only their own profile', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  const bob = env.authenticatedContext('bob').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await assertSucceeds(getDoc(doc(alice, 'users/alice')));
  await assertFails(getDoc(doc(alice, 'users/bob')));
  await assertFails(setDoc(doc(bob, 'users/alice'), profile('alice')));
});

test('profile updates are owner-only, validated, and cannot write entitlement', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await assertSucceeds(updateDoc(doc(alice, 'users/alice'), {
    cefrLevel: 'A2',
    updatedAt: serverTimestamp(),
  }));
  await assertSucceeds(updateDoc(doc(alice, 'users/alice'), {
    cefrLevel: 'C2',
    updatedAt: serverTimestamp(),
  }));
  await assertFails(updateDoc(doc(alice, 'users/alice'), {
    cefrLevel: 'D1',
    updatedAt: serverTimestamp(),
  }));
  await assertFails(updateDoc(doc(alice, 'users/alice'), {
    'entitlement.active': true,
    updatedAt: serverTimestamp(),
  }));
  const bob = env.authenticatedContext('bob').firestore();
  await assertFails(updateDoc(doc(bob, 'users/alice'), { displayName: 'Intruder' }));
});

test('learner can append own bounded lesson events but cannot edit them; owner may delete for account removal', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  const event = doc(collection(alice, 'users/alice/lessonEvents'));
  await assertSucceeds(setDoc(event, {
    lessonId: 'A1-U1-L1', score: 75, completedAt: serverTimestamp(),
  }));
  await assertSucceeds(setDoc(doc(alice, 'users/alice/lessonEvents/ungraded-writing'), {
    lessonId: 'A1-U1-L2', completedAt: serverTimestamp(),
  }));
  await assertFails(setDoc(doc(alice, 'users/alice/lessonEvents/bad-score'), {
    lessonId: 'A1-U1-L1', score: 101, completedAt: serverTimestamp(),
  }));
  await assertFails(updateDoc(event, { score: 100 }));
  // Hesap silme icin sahibinin kendi olayini silmesine izin verilir; yabanci silemez.
  const mallory = env.authenticatedContext('mallory').firestore();
  await assertFails(deleteDoc(doc(mallory, event.path)));
  await assertSucceeds(deleteDoc(event));
  await assertSucceeds(updateDoc(doc(alice, 'users/alice'), {
    completedLessons: increment(1), completedByLevelA1: increment(1),
    lastStudiedAt: serverTimestamp(), updatedAt: serverTimestamp(),
  }));
});

test('unauthenticated users cannot read or write learner data', async () => {
  const db = env.unauthenticatedContext().firestore();
  await assertFails(getDoc(doc(db, 'users/alice')));
  await assertFails(setDoc(doc(db, 'users/alice'), profile('alice')));
});

test('course content is authenticated read-only', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  const anonymous = env.unauthenticatedContext().firestore();
  await env.withSecurityRulesDisabled(async (ctx) => {
    await setDoc(doc(ctx.firestore(), 'courseContent/a1'), { title: 'A1 seed' });
  });
  await assertSucceeds(getDocs(collection(alice, 'courseContent')));
  await assertFails(setDoc(doc(alice, 'courseContent/a1'), { title: 'tampered' }));
  await assertFails(getDocs(collection(anonymous, 'courseContent')));
});

test('owner can delete own profile but strangers cannot', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  const mallory = env.authenticatedContext('mallory').firestore();
  await assertFails(deleteDoc(doc(mallory, 'users/alice')));
  await assertSucceeds(deleteDoc(doc(alice, 'users/alice')));
});

test('leaderboard: owner writes own entry, strangers cannot, signed-in users can read', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await assertSucceeds(setDoc(doc(alice, 'usernames/alice_tr'), { uid: 'alice' }));
  const entry = { uid: 'alice', username: 'alice_tr', displayName: 'Alice', avatar: 'g=0;t=1' };
  await assertSucceeds(setDoc(doc(alice, 'leaderboard/alice'), entry));
  await assertFails(updateDoc(doc(alice, 'leaderboard/alice'), { totalXp: 99999 }));
  await assertFails(updateDoc(doc(alice, 'leaderboard/alice'), { verifiedXp: 99999 }));
  await assertFails(updateDoc(doc(alice, 'leaderboard/alice'), { level: 200 }));
  await assertFails(updateDoc(doc(alice, 'leaderboard/alice'), { username: 'someone_else' }));
  await env.withSecurityRulesDisabled(async (ctx) => {
    await updateDoc(doc(ctx.firestore(), 'leaderboard/alice'), { verifiedXp: 40, level: 1 });
  });
  await assertSucceeds(updateDoc(doc(alice, 'leaderboard/alice'), { avatar: 'g=1' }));
  const mallory = env.authenticatedContext('mallory').firestore();
  await assertFails(setDoc(doc(mallory, 'leaderboard/alice'), { ...entry, totalXp: 99999 }));
  const bob = env.authenticatedContext('bob').firestore();
  await assertSucceeds(getDoc(doc(bob, 'leaderboard/alice')));
  const anon = env.unauthenticatedContext().firestore();
  await assertFails(getDoc(doc(anon, 'leaderboard/alice')));
});

test('activity: users post only as themselves and cannot edit posts', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await assertSucceeds(setDoc(doc(alice, 'usernames/alice_tr'), { uid: 'alice' }));
  const item = doc(collection(alice, 'activity'));
  await assertSucceeds(setDoc(item, { uid: 'alice', username: 'alice_tr', avatar: '', text: 'Seviye 3 oldu!', createdAt: 1700000000000 }));
  await assertFails(setDoc(doc(collection(alice, 'activity')), { uid: 'bob', username: 'sahte', avatar: '', text: 'x', createdAt: 1 }));
  await assertFails(updateDoc(item, { text: 'degisti' }));
  const bob = env.authenticatedContext('bob').firestore();
  await assertSucceeds(getDoc(item));
  await assertFails(deleteDoc(doc(bob, item.path)));
  await assertSucceeds(deleteDoc(item));
});

test('paid access and ranked XP evidence can only be written by the backend', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  const bob = env.authenticatedContext('bob').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await assertFails(updateDoc(doc(alice, 'users/alice'), { verifiedXp: 5000 }));
  await assertFails(setDoc(doc(alice, 'users/alice/private/entitlement'), { active: true }));
  await assertFails(setDoc(doc(alice, 'users/alice/xpAwards/fake'), { xp: 5000 }));
  await env.withSecurityRulesDisabled(async (ctx) => {
    await setDoc(doc(ctx.firestore(), 'users/alice/private/entitlement'), { active: true });
  });
  await assertSucceeds(getDoc(doc(alice, 'users/alice/private/entitlement')));
  await assertFails(getDoc(doc(bob, 'users/alice/private/entitlement')));
});

test('reserved names cannot be impersonated in the leaderboard or activity feed', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  const bob = env.authenticatedContext('bob').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await assertSucceeds(setDoc(doc(alice, 'usernames/alice_tr'), { uid: 'alice' }));
  await assertFails(setDoc(doc(bob, 'leaderboard/bob'), { uid: 'bob', username: 'alice_tr', displayName: 'Fake', avatar: '' }));
  await assertFails(setDoc(doc(collection(bob, 'activity')), { uid: 'bob', username: 'alice_tr', avatar: '', text: 'Fake', createdAt: 1 }));
});

test('friends: only the owner manages their own list', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  const bob = env.authenticatedContext('bob').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await assertSucceeds(setDoc(doc(bob, 'users/bob'), profile('bob')));
  await assertSucceeds(setDoc(doc(alice, 'users/alice/friends/bob'), { uid: 'bob', username: 'bob_tr', avatar: '', addedAt: 1 }));
  const mallory = env.authenticatedContext('mallory').firestore();
  await assertFails(setDoc(doc(mallory, 'users/alice/friends/mallory'), { uid: 'mallory', username: 'm', avatar: '', addedAt: 1 }));
  await assertFails(getDocs(collection(mallory, 'users/alice/friends')));
  await assertSucceeds(deleteDoc(doc(alice, 'users/alice/friends/bob')));
  await env.withSecurityRulesDisabled(async (ctx) => {
    await updateDoc(doc(ctx.firestore(), 'users/bob'), { deletionRequested: true });
  });
  await assertFails(setDoc(doc(alice, 'users/alice/friends/bob'), { uid: 'bob', username: 'bob_tr', avatar: '', addedAt: 1 }));
});

test('usernames: first claim wins, cannot be overwritten, owner can release', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'usernames/kaptan'), { uid: 'alice' }));
  const bob = env.authenticatedContext('bob').firestore();
  await assertFails(setDoc(doc(bob, 'usernames/kaptan'), { uid: 'bob' }));
  await assertFails(setDoc(doc(alice, 'usernames/kaptan'), { uid: 'alice' })); // update de kapali
  await assertFails(deleteDoc(doc(bob, 'usernames/kaptan')));
  await assertSucceeds(deleteDoc(doc(alice, 'usernames/kaptan')));
});

test('course completions are owner-scoped, bounded and immutable', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  const bob = env.authenticatedContext('bob').firestore();
  const completion = doc(alice, 'users/alice/lessonCompletions/A1-U1-L1');
  await assertSucceeds(setDoc(completion, { lessonId: 'A1-U1-L1', score: 90, completedAt: serverTimestamp() }));
  await assertFails(setDoc(completion, { lessonId: 'A1-U1-L1', score: 100, completedAt: serverTimestamp() }));
  await assertFails(setDoc(doc(alice, 'users/alice/lessonCompletions/A1-U1-L2'), { lessonId: 'another-id', score: 90, completedAt: serverTimestamp() }));
  await assertFails(setDoc(doc(alice, 'users/alice/lessonCompletions/A1-U1-L3'), { lessonId: 'A1-U1-L3', score: 101, completedAt: serverTimestamp() }));
  await assertFails(getDoc(doc(bob, completion.path)));
  await assertFails(deleteDoc(doc(bob, completion.path)));
  await assertSucceeds(deleteDoc(completion));
});

test('account deletion marker prevents new writes racing with server cleanup', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await env.withSecurityRulesDisabled(async (ctx) => {
    await updateDoc(doc(ctx.firestore(), 'users/alice'), { deletionRequested: true });
  });
  await assertFails(updateDoc(doc(alice, 'users/alice'), { completedLessons: increment(1) }));
  await assertFails(setDoc(doc(collection(alice, 'users/alice/lessonEvents')), { lessonId: 'A1-U1-L1', completedAt: serverTimestamp() }));
});

test('deleting accounts cannot recreate public activity or league entries', async () => {
  const alice = env.authenticatedContext('alice').firestore();
  await assertSucceeds(setDoc(doc(alice, 'users/alice'), profile('alice')));
  await assertSucceeds(setDoc(doc(alice, 'usernames/alice_tr'), { uid: 'alice' }));
  await env.withSecurityRulesDisabled(async (ctx) => {
    await updateDoc(doc(ctx.firestore(), 'users/alice'), { deletionRequested: true });
  });
  await assertFails(setDoc(doc(alice, 'leaderboard/alice'), { uid: 'alice', username: 'alice_tr', displayName: 'Alice', avatar: '' }));
  await assertFails(setDoc(doc(collection(alice, 'activity')), { uid: 'alice', username: 'alice_tr', avatar: '', text: 'x', createdAt: 1 }));
});
