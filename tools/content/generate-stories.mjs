import fs from 'node:fs';
import path from 'node:path';
import { fileURLToPath } from 'node:url';
const root = path.resolve(path.dirname(fileURLToPath(import.meta.url)), '../..');
const stories = JSON.parse(fs.readFileSync(path.join(root, 'content/story-expansion.json'), 'utf8'));
const q = (value) => JSON.stringify(value).replaceAll('$', '\\$');
const content = `package com.linguapro.android\n\n/** Authored parallel reading stories; level labels require independent editorial validation. */\ninternal object StoryExpansion {\n    val stories: List<Story> = listOf(\n${stories.map((story) => `        Story(${q(story.id)}, ${q(story.lang)}, ${q(story.level)}, ${q(story.title)}, listOf(\n${story.lines.map((line) => `            StoryLine(${line.speaker}, ${q(line.text)}, ${q(line.tr)})`).join(',\n')}\n        ), listOf(\n${story.questions.map((item) => `            StoryQuestion(${q(item.prompt)}, listOf(${item.options.map(q).join(', ')}), ${item.correct}, ${q(item.explanationTr)})`).join(',\n')}\n        ))`).join(',\n')}\n    )\n}\n`;
const target = path.join(root, 'app/src/main/java/com/linguapro/android/StoryExpansion.kt');
if (process.argv.includes('--check')) {
  if (!fs.existsSync(target) || fs.readFileSync(target, 'utf8') !== content) throw new Error('StoryExpansion.kt is out of sync with its authored content source');
} else fs.writeFileSync(target, content);
