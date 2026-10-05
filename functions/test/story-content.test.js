'use strict';
const { test } = require('node:test');
const assert = require('node:assert/strict');
const fs = require('node:fs');
const path = require('node:path');
const { spawnSync } = require('node:child_process');
const root = path.resolve(__dirname, '../..');
const stories = JSON.parse(fs.readFileSync(path.join(root, 'content/story-expansion.json'), 'utf8'));

test('reading expansion covers ten languages and five levels with unique stable ids', () => {
  assert.equal(stories.length, 50);
  assert.equal(new Set(stories.map((story) => story.id)).size, stories.length);
  for (const language of ['EN', 'DE', 'FR', 'ES', 'PT', 'IT', 'RU', 'ZH', 'JA', 'KO']) {
    for (const level of ['A2', 'B1', 'B2', 'C1', 'C2']) {
      assert.equal(stories.filter((story) => story.lang === language && story.level === level).length, 1);
    }
  }
});
test('every story has readable turns, Turkish translations and distinct supported answer keys', () => {
  for (const story of stories) {
    assert.equal(story.lines.length, 8);
    for (const line of story.lines) {
      assert.ok(line.text.trim() && line.tr.trim());
      assert.ok(line.text.length < 4000, 'turn must fit Android TTS input limit');
      assert.ok(line.speaker === 0 || line.speaker === 1);
    }
    assert.equal(story.questions.length, 4);
    for (const item of story.questions) {
      assert.equal(new Set(item.options).size, 3);
      assert.ok(Number.isInteger(item.correct) && item.correct >= 0 && item.correct < 3);
      assert.ok(item.explanationTr.length > 20);
    }
  }
});
test('advanced reading is extended text rather than isolated phrases; length does not certify CEFR', () => {
  for (const story of stories) {
    const text = story.lines.map((line) => line.text).join(' ');
    if (['ZH', 'JA'].includes(story.lang)) {
      if (story.level === 'C1') assert.ok(text.length >= 400);
      if (story.level === 'C2') assert.ok(text.length >= 600);
    } else {
      const words = text.split(/\s+/).length;
      if (story.level === 'C1') assert.ok(words >= 175);
      if (story.level === 'C2') assert.ok(words >= 250);
    }
  }
});
test('the shipped Kotlin bank exactly matches the authored source', () => {
  const result = spawnSync(process.execPath, [path.join(root, 'tools/content/generate-stories.mjs'), '--check'], { encoding: 'utf8' });
  assert.equal(result.status, 0, result.stderr);
});
