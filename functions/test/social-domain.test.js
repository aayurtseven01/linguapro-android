'use strict';
const { test } = require('node:test');
const assert = require('node:assert/strict');
const { validUsername, activityAllowance, activityText } = require('../src/social-domain');

test('usernames have a bounded canonical format', () => {
  assert.equal(validUsername('ahmet_01'), true);
  for (const value of ['ab', 'AName', '../user', '<script>', 'a'.repeat(21), null]) assert.equal(validUsername(value), false);
});
test('activity limit applies per UTC day and resets on a new day', () => {
  assert.equal(activityAllowance('2026-10-05', '2026-10-05', 4).allowed, true);
  assert.equal(activityAllowance('2026-10-05', '2026-10-05', 5).allowed, false);
  assert.equal(activityAllowance('2026-10-06', '2026-10-05', 5).nextCount, 1);
});
test('activity captions are server templates rather than user text', () => {
  assert.equal(activityText('arbitrary caption', 10), null);
  assert.equal(activityText('level', 900).includes('200'), true);
  assert.equal(activityText('story').includes('hikâye'), true);
});
