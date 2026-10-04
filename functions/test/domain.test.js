'use strict';
const { test } = require('node:test');
const assert = require('node:assert/strict');
const { hash, weekKey, studyAward, levelFor, subscriptionEntitlement } = require('../src/domain');
const now = Date.parse('2026-10-04T09:00:00Z');
const purchase = (state = 'SUBSCRIPTION_STATE_ACTIVE', extra = {}) => ({
  subscriptionState: state,
  externalAccountIdentifiers: { obfuscatedExternalAccountId: hash('alice') },
  lineItems: [{ productId: 'linguapro_pro_monthly', expiryTime: '2026-11-04T09:00:00Z' }], ...extra,
});

test('subscription identity and product must match the authenticated account', () => {
  assert.throws(() => subscriptionEntitlement(purchase(), { uid: 'bob', now }), /ACCOUNT_MISMATCH/);
  assert.throws(() => subscriptionEntitlement(purchase(undefined, { lineItems: [{ productId: 'fake', expiryTime: '2027-01-01' }] }), { uid: 'alice', now }), /UNKNOWN_PRODUCT/);
});
test('active and grace-period subscriptions retain access; canceled access lasts only until expiry', () => {
  for (const state of ['SUBSCRIPTION_STATE_ACTIVE', 'SUBSCRIPTION_STATE_IN_GRACE_PERIOD', 'SUBSCRIPTION_STATE_CANCELED']) {
    assert.equal(subscriptionEntitlement(purchase(state), { uid: 'alice', now }).active, true);
  }
  assert.equal(subscriptionEntitlement(purchase(), { uid: 'alice', now: Date.parse('2027-01-01') }).active, false);
});
test('pending, paused, held and expired subscriptions do not unlock Pro', () => {
  for (const state of ['SUBSCRIPTION_STATE_PENDING', 'SUBSCRIPTION_STATE_PAUSED', 'SUBSCRIPTION_STATE_ON_HOLD', 'SUBSCRIPTION_STATE_EXPIRED']) {
    assert.equal(subscriptionEntitlement(purchase(state), { uid: 'alice', now }).active, false);
  }
});
test('invalid expiry never grants paid access', () => {
  assert.equal(subscriptionEntitlement(purchase(undefined, { lineItems: [{ productId: 'linguapro_pro_monthly', expiryTime: 'bad' }] }), { uid: 'alice', now }).active, false);
});
test('XP awards are bounded and repeat attempts share the same daily reward key', () => {
  assert.equal(studyAward('A1-U1-L1', 100, now).xp, 20);
  assert.equal(studyAward('A1-U1-L1', null, now).xp, 10);
  assert.equal(studyAward('A1-U1-L1', 60, now).id, studyAward('A1-U1-L1', 90, now + 1000).id);
  assert.notEqual(studyAward('A1-U1-L1', 90, now).id, studyAward('A1-U1-L1', 90, now + 86400000).id);
  assert.equal(studyAward('fake', 100, now), null);
  assert.equal(studyAward('A1-U999-L1', 100, now), null);
  assert.equal(studyAward('A1-JSON-U1-L1', 90, now).xp, 19);
  assert.equal(studyAward('A1-U1-L1', 999999, now), null);
  assert.equal(studyAward('A1-U1-L1', 20.5, now), null);
});
test('server levels use the same progression boundaries as the app', () => {
  assert.equal(levelFor(0), 1); assert.equal(levelFor(99), 1);
  assert.equal(levelFor(100), 2); assert.equal(levelFor(225), 3);
  assert.equal(levelFor(99999999), 200);
});

test('all clients share a Monday UTC weekly league boundary', () => {
  assert.equal(weekKey(Date.parse('2026-10-04T23:59:59Z')), '2026-09-28');
  assert.equal(weekKey(Date.parse('2026-10-05T00:00:00Z')), '2026-10-05');
  assert.equal(weekKey(Date.parse('2026-01-01T00:00:00Z')), '2025-12-29');
});
