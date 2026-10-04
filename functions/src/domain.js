'use strict';

const { createHash } = require('node:crypto');
const DEFAULT_PRODUCTS = ['linguapro_pro_monthly', 'linguapro_pro_yearly'];
const COURSE_IDS = new Set(require('./course-ids.json'));
const hash = (value) => createHash('sha256').update(value).digest('hex');

function weekKey(now) {
  const date = new Date(now);
  date.setUTCDate(date.getUTCDate() - (date.getUTCDay() + 6) % 7);
  return date.toISOString().slice(0, 10);
}

function levelFor(xp) {
  let level = 1, required = 0, step = 100;
  while (level < 200 && xp >= required + step) { required += step; step += 25; level++; }
  return level;
}

function studyAward(lessonId, score, completedAt) {
  if (typeof lessonId !== 'string' || lessonId.length > 100) return null;
  const language = '(?:EN|DE|FR|ES|PT|IT|RU|ZH|JA|KO)';
  const level = '(?:A[12]|B[12]|C[12])';
  const practice = new RegExp(`^${language}-(?:WORDS|${level}-(?:REFRESH|PRO))$`);
  if (!COURSE_IDS.has(lessonId) && !practice.test(lessonId)) return null;
  if (score != null && (!Number.isInteger(score) || score < 0 || score > 100)) return null;
  if (!Number.isFinite(completedAt)) return null;
  const day = new Date(completedAt).toISOString().slice(0, 10);
  return { id: hash(`${lessonId}:${day}`), xp: score == null ? 10 : 10 + Math.floor(score / 10) };
}

function subscriptionEntitlement(purchase, { uid, allowedProducts = DEFAULT_PRODUCTS, now = Date.now() }) {
  if (purchase?.externalAccountIdentifiers?.obfuscatedExternalAccountId !== hash(uid)) {
    throw new Error('ACCOUNT_MISMATCH');
  }
  const states = ['SUBSCRIPTION_STATE_ACTIVE', 'SUBSCRIPTION_STATE_IN_GRACE_PERIOD', 'SUBSCRIPTION_STATE_CANCELED'];
  const matching = (purchase.lineItems || []).filter((item) => allowedProducts.includes(item.productId));
  if (matching.length === 0) throw new Error('UNKNOWN_PRODUCT');
  const expiryMillis = Math.max(...matching.map((item) => Date.parse(item.expiryTime) || 0));
  return {
    active: states.includes(purchase.subscriptionState) && expiryMillis > now,
    expiresAtMillis: expiryMillis,
    productId: matching.find((item) => Date.parse(item.expiryTime) === expiryMillis)?.productId || matching[0].productId,
    state: purchase.subscriptionState,
  };
}

module.exports = { DEFAULT_PRODUCTS, hash, weekKey, levelFor, studyAward, subscriptionEntitlement };
