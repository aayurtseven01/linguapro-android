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
