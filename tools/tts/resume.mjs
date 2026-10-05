import { createHash } from 'node:crypto';
import { readFileSync, writeFileSync } from 'node:fs';

export function mergeCatalog(previous, current) {
  if (previous && (previous.version !== 1 || previous.baseUrl !== current.baseUrl ||
      !previous.voices || typeof previous.voices !== 'object' || Array.isArray(previous.voices))) {
    throw new Error('Mevcut ses kataloğu uyumsuz; üzerine yazılmadı.');
  }
  return { ...current, voices: { ...(previous?.voices ?? {}), ...current.voices } };
}

export function cachedAudio(path) {
  try { const bytes = readFileSync(path); return bytes.length ? bytes : null; }
  catch { return null; }
}

const digest = (bytes) => createHash('sha256').update(bytes).digest('hex');

/** A local MP3 alone never proves that this bucket contains the file. */
export function uploadedTo(path, bucket, objectPath) {
  try {
    const receipt = JSON.parse(readFileSync(`${path}.uploaded.json`, 'utf8'));
    const bytes = cachedAudio(path);
    return !!bytes && receipt.bucket === bucket && receipt.objectPath === objectPath &&
      receipt.sha256 === digest(bytes);
  } catch { return false; }
}

export function recordUpload(path, bucket, objectPath, bytes) {
  writeFileSync(`${path}.uploaded.json`, JSON.stringify({ bucket, objectPath, sha256: digest(bytes) }));
}
