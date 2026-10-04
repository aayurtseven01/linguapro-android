'use strict';

const { initializeApp } = require('firebase-admin/app');
const { getAuth } = require('firebase-admin/auth');
const { getFirestore, Timestamp, FieldValue } = require('firebase-admin/firestore');
const { onCall, HttpsError } = require('firebase-functions/v2/https');
const { onDocumentCreated } = require('firebase-functions/v2/firestore');
const { onMessagePublished } = require('firebase-functions/v2/pubsub');
const { setGlobalOptions } = require('firebase-functions/v2');
const { GoogleAuth } = require('google-auth-library');
const { DEFAULT_PRODUCTS, hash, weekKey, levelFor, studyAward, subscriptionEntitlement } = require('./domain');

initializeApp();
setGlobalOptions({ region: 'us-central1', maxInstances: 10 });
const db = getFirestore();
const packageName = 'com.linguapro.android';
const publisher = new GoogleAuth({ scopes: ['https://www.googleapis.com/auth/androidpublisher'] });
const allowedProducts = (process.env.PLAY_SUBSCRIPTION_PRODUCTS || DEFAULT_PRODUCTS.join(',')).split(',').map((s) => s.trim()).filter(Boolean);
const billingEnabled = process.env.PLAY_BILLING_ENABLED === 'true';

exports.getCommerceStatus = onCall({ enforceAppCheck: true }, async (request) => {
  if (!request.auth) throw new HttpsError('unauthenticated', 'Önce giriş yap.');
  return { ready: billingEnabled, products: billingEnabled ? allowedProducts : [] };
});

async function fetchSubscription(token) {
  const client = await publisher.getClient();
  const { data } = await client.request({ url: `https://androidpublisher.googleapis.com/androidpublisher/v3/applications/${packageName}/purchases/subscriptionsv2/tokens/${encodeURIComponent(token)}` });
  return data;
}

async function verifyAndSave(uid, token, purchase) {
  const entitlement = subscriptionEntitlement(purchase, { uid, allowedProducts });
  const tokenRef = db.collection('billingPurchaseTokens').doc(hash(token));
  const profile = db.collection('users').doc(uid);
  const entitlementRef = profile.collection('private').doc('entitlement');
  const parent = purchase.linkedPurchaseToken ? db.collection('billingPurchaseTokens').doc(hash(purchase.linkedPurchaseToken)) : null;
  await db.runTransaction(async (tx) => {
    const owner = await tx.get(tokenRef);
    const user = await tx.get(profile);
    const linked = parent ? await tx.get(parent) : null;
    const current = await tx.get(entitlementRef);
    if (!user.exists || user.get('deletionRequested')) throw new HttpsError('failed-precondition', 'Profil bulunamadı veya siliniyor.');
    if ((owner.exists && owner.get('uid') !== uid) || (linked?.exists && linked.get('uid') !== uid)) {
      throw new HttpsError('permission-denied', 'Abonelik başka bir hesaba bağlı.');
    }
    tx.set(tokenRef, { uid, token, productId: entitlement.productId, updatedAt: FieldValue.serverTimestamp() }, { merge: true });
    if (parent) tx.set(parent, { uid, supersededBy: tokenRef.id }, { merge: true });
    // Delayed notifications for a replaced purchase must not revoke its successor.
    const stale = owner.get('supersededBy') ||
      (current.exists && current.get('purchaseTokenHash') !== tokenRef.id &&
       current.get('expiresAtMillis') > entitlement.expiresAtMillis && parent?.id !== current.get('purchaseTokenHash'));
    if (!stale) tx.set(entitlementRef, {
      ...entitlement, purchaseTokenHash: tokenRef.id,
      expiresAt: Timestamp.fromMillis(entitlement.expiresAtMillis), verifiedAt: FieldValue.serverTimestamp(),
    });
  });
  if (entitlement.active && purchase.acknowledgementState !== 'ACKNOWLEDGEMENT_STATE_ACKNOWLEDGED') {
    const client = await publisher.getClient();
    await client.request({ method: 'POST', url: `https://androidpublisher.googleapis.com/androidpublisher/v3/applications/${packageName}/purchases/subscriptions/${encodeURIComponent(entitlement.productId)}/tokens/${encodeURIComponent(token)}:acknowledge`, data: {} });
  }
  return entitlement;
}

exports.verifyPlaySubscription = onCall({ enforceAppCheck: true }, async (request) => {
  if (!request.auth) throw new HttpsError('unauthenticated', 'Önce giriş yap.');
  if (!billingEnabled) throw new HttpsError('unavailable', 'Abonelikler henüz açılmadı.');
  const token = request.data?.purchaseToken;
  if (typeof token !== 'string' || token.length < 10 || token.length > 4096) throw new HttpsError('invalid-argument', 'Satın alma kaydı geçersiz.');
  try {
    return await verifyAndSave(request.auth.uid, token, await fetchSubscription(token));
  } catch (error) {
    // Never include Google's request URL or the purchase token in a client error/log.
    if (error instanceof HttpsError) throw error;
    if (['ACCOUNT_MISMATCH', 'UNKNOWN_PRODUCT'].includes(error.message)) throw new HttpsError('permission-denied', 'Abonelik bu hesaba veya ürüne ait değil.');
    throw new HttpsError('unavailable', 'Abonelik doğrulanamadı. Satın alımları geri yükleyerek tekrar dene.');
  }
});

exports.subscriptionNotifications = onMessagePublished({ topic: 'play-subscription-events', retry: true }, async (event) => {
  const message = event.data.message.json;
  if (message?.packageName !== packageName || !message.subscriptionNotification) return;
  const token = message.subscriptionNotification.purchaseToken;
  if (typeof token !== 'string') return;
  const owner = await db.collection('billingPurchaseTokens').doc(hash(token)).get();
  if (!owner.exists) return; // Initial activation goes through the authenticated callable.
  if (!(await db.collection('users').doc(owner.get('uid')).get()).exists) return;
  await verifyAndSave(owner.get('uid'), token, await fetchSubscription(token));
});

exports.initializeBoardScore = onDocumentCreated('leaderboard/{uid}', async (event) => {
  const uid = event.params.uid;
  await db.runTransaction(async (tx) => {
    const user = await tx.get(db.collection('users').doc(uid));
    const board = await tx.get(event.data.ref);
    if (!board.exists || !user.exists) return;
    const xp = user.get('verifiedXp') || 0;
    const week = weekKey(Date.now());
    tx.update(event.data.ref, { verifiedXp: xp, level: levelFor(xp), weekKey: week,
      verifiedWeekXp: user.get('verifiedWeekKey') === week ? user.get('verifiedWeekXp') || 0 : 0 });
  });
});

exports.awardStudyXp = onDocumentCreated('users/{uid}/lessonEvents/{eventId}', async (event) => {
  const data = event.data.data();
  const award = studyAward(data.lessonId, data.score, data.completedAt?.toMillis());
  if (!award) return;
  const uid = event.params.uid;
  const profile = db.collection('users').doc(uid);
  const awardRef = profile.collection('xpAwards').doc(award.id);
  const boardRef = db.collection('leaderboard').doc(uid);
  await db.runTransaction(async (tx) => {
    const prior = await tx.get(awardRef);
    const user = await tx.get(profile);
    const board = await tx.get(boardRef);
    if (prior.exists || !user.exists || user.get('deletionRequested')) return;
    const xp = (user.get('verifiedXp') || 0) + award.xp;
    const week = weekKey(Date.now());
    const weeklyXp = (user.get('verifiedWeekKey') === week ? user.get('verifiedWeekXp') || 0 : 0) +
      (weekKey(data.completedAt.toMillis()) === week ? award.xp : 0);
    tx.create(awardRef, { lessonId: data.lessonId, xp: award.xp, awardedAt: FieldValue.serverTimestamp() });
    tx.update(profile, { verifiedXp: xp, verifiedWeekXp: weeklyXp, verifiedWeekKey: week });
    if (board.exists) tx.update(boardRef, { verifiedXp: xp, level: levelFor(xp), verifiedWeekXp: weeklyXp, weekKey: week });
  });
});

exports.deleteAccount = onCall({ enforceAppCheck: true }, async (request) => {
  if (!request.auth) throw new HttpsError('unauthenticated', 'Önce giriş yap.');
  if (!Number.isFinite(request.auth.token.auth_time) || Date.now() / 1000 - request.auth.token.auth_time > 300) {
    throw new HttpsError('failed-precondition', 'Güvenlik için şifreni yeniden doğrula.');
  }
  const uid = request.auth.uid;
  const deleting = await db.collection('users').doc(uid).get();
  if (deleting.exists) await deleting.ref.update({ deletionRequested: true });
  // RTDN and XP triggers check profile existence; remove the profile tree before releasing identity.
  await db.recursiveDelete(db.collection('users').doc(uid));
  async function deleteQuery(query) {
    while (true) {
      const docs = await query.limit(200).get();
      if (docs.empty) return;
      const batch = db.batch();
      for (const doc of docs.docs) batch.delete(doc.ref);
      await batch.commit();
    }
  }
  for (const name of ['leaderboard', 'activity', 'usernames', 'billingPurchaseTokens']) {
    await deleteQuery(db.collection(name).where('uid', '==', uid));
  }
  await deleteQuery(db.collectionGroup('friends').where('uid', '==', uid));
  try { await getAuth().deleteUser(uid); } catch (error) {
    if (error.code !== 'auth/user-not-found') throw new HttpsError('unavailable', 'Hesap silme tamamlanamadı. Yeniden dene.');
  }
  return { deleted: true };
});
