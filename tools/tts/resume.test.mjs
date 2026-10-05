import test from 'node:test';
import assert from 'node:assert/strict';
import { mkdtempSync, writeFileSync, rmSync } from 'node:fs';
import { tmpdir } from 'node:os';
import { join } from 'node:path';
import { mergeCatalog, cachedAudio, uploadedTo, recordUpload } from './resume.mjs';

const catalog = (voices, bucket = 'first') => ({ version: 1, baseUrl: `https://storage.googleapis.com/${bucket}/audio/v1`, voices });
test('a selected language update preserves other published languages', () => {
  const result = mergeCatalog(catalog({ 'en-US': { f: 'old-f', m: 'old-m' }, 'de-DE': { f: 'a', m: 'b' } }),
    catalog({ 'de-DE': { f: 'new-f', m: 'new-m' } }));
  assert.deepEqual(result.voices['en-US'], { f: 'old-f', m: 'old-m' });
  assert.equal(result.voices['de-DE'].f, 'new-f');
});
test('first publication creates the complete selected catalog', () => {
  const current = catalog({ 'de-DE': { f: 'a', m: 'b' } });
  assert.deepEqual(mergeCatalog(null, current), current);
});
test('an incompatible catalog is refused rather than overwritten', () => {
  assert.throws(() => mergeCatalog(catalog({}, 'old-bucket'), catalog({}, 'new-bucket')));
  assert.throws(() => mergeCatalog({ ...catalog({}), version: 2 }, catalog({})));
});
test('malformed voice maps are refused', () => {
  assert.throws(() => mergeCatalog(catalog([]), catalog({})));
});
function fixture(run) {
  const dir = mkdtempSync(join(tmpdir(), 'linguapro-audio-'));
  const path = join(dir, 'audio.mp3');
  const bytes = Buffer.from('sample audio');
  try { writeFileSync(path, bytes); run(path, bytes); }
  finally { rmSync(dir, { recursive: true, force: true }); }
}
test('local audio without an upload receipt must be uploaded', () => fixture((path, bytes) => {
  assert.deepEqual(cachedAudio(path), bytes);
  assert.equal(uploadedTo(path, 'first', 'audio/v1/de-DE/key.mp3'), false);
}));
test('a successful upload can be resumed in the same bucket', () => fixture((path, bytes) => {
  recordUpload(path, 'first', 'audio/v1/de-DE/key.mp3', bytes);
  assert.equal(uploadedTo(path, 'first', 'audio/v1/de-DE/key.mp3'), true);
}));
test('changing bucket or object path requires uploading the cached audio again', () => fixture((path, bytes) => {
  recordUpload(path, 'first', 'audio/v1/de-DE/key.mp3', bytes);
  assert.equal(uploadedTo(path, 'second', 'audio/v1/de-DE/key.mp3'), false);
  assert.equal(uploadedTo(path, 'first', 'audio/v1/fr-FR/key.mp3'), false);
}));
test('changed, empty or corrupt local state cannot count as uploaded', () => fixture((path, bytes) => {
  recordUpload(path, 'first', 'audio/v1/de-DE/key.mp3', bytes);
  writeFileSync(path, 'changed');
  assert.equal(uploadedTo(path, 'first', 'audio/v1/de-DE/key.mp3'), false);
  writeFileSync(path, '');
  assert.equal(cachedAudio(path), null);
  writeFileSync(`${path}.uploaded.json`, 'invalid');
  assert.equal(uploadedTo(path, 'first', 'audio/v1/de-DE/key.mp3'), false);
}));
