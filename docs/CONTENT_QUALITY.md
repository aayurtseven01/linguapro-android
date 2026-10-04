# A1–C2 English content revision

Every one of the 126 English units now includes an eight-activity contextual application lesson. Coverage is A1: 20 units; A2: 24; B1: 26; B2: 24; C1: 20; C2: 12. The second lesson in each unit is reconstructed; other lessons retain existing content and prior editorial improvements. Existing lesson identifiers remain stable for saved progress and server validation.

## Content delivered

- 126 original teaching passages and 252 new listening/reading comprehension questions with specific explanations and three distinct choices.
- 126 level-specific open writing tasks with the source passage visible. Models are examples, not the only acceptable response. Writing remains ungraded.
- Vocabulary, language, listening, reading and model-repeat practice reuse appropriate activities from each unit. This is not a claim that every activity is newly authored.
- All 126 English checkpoints contain five closed, scorable questions. Seven existing independently authored checkpoints retain their 35 unseen questions; the other 119 checkpoints each introduce a new transfer passage and question plus four unit-review questions.
- A1 identifies explicit people, places and times. A2 follows everyday events. B1 links cause and outcome. B2 weighs reasons and constraints. C1 separates evidence from interpretation. C2 examines implied meaning, register, irony and alternative readings.
- Writing tasks progress from two short sentences to structured summaries and interpretations of 100–140 words. Automated feedback does not certify grammar or a CEFR level.

All scenario passages, including reports, studies, notices and literary extracts, are fictional language-learning material. Their numbers and claims are not presented as actual research, news or legal advice.

## Validation and limits

Unit tests check complete unit coverage, stable identifiers, eight-activity delivery, distinct choices with one accepted answer, unseen transfer passages, five-question checkpoint contracts and increasing median passage length. Increasing length is a structural check, not CEFR calibration. Reports are generated under `app/build/reports/catalog/` and preserved in CI artifacts.

The other nine languages retain previously revised introductory lessons and existing editorial repairs; their entire curricula have not received this English scenario rewrite. Supplemental JSON lessons retain their own validated schema.

Independent language-editor review, learner trials, calibrated difficulty, professionally recorded audio and richer open speaking/writing assessment remain necessary before claiming parity with Duolingo. Audio currently uses device text-to-speech. No commercial success or flawless pedagogy is guaranteed by software tests.

## Production and word-lesson editorial revision

- All 126 writing tasks now have separately authored model responses that satisfy their stated sentence or word limits, rather than repeating the source passage. Each task has three self-review criteria. B1–C2 show a live word count and transparent length feedback; alternative answers remain ungraded.
- 65 existing vocabulary lessons now introduce words in English example sentences and add 195 controlled typed-recall activities. These examples also populate target-vocabulary records for review. Common British/American spelling variants are accepted where relevant.
- Nineteen volume grammar questions were clarified or corrected, including C2 inversion word order. Five supplemental grammar checks and additional conjunction/conditional prompts now specify the intended meaning or target structure. Completed sentences reinforce grammar explanations.
- Lexical repairs cover source citation, outlining a presentation, narrative plot, idioms, and context-sensitive advanced vocabulary. This is a targeted revision, not a claim that every retained exercise was individually rewritten.
- Writing checks no longer flag correct base forms such as “doesn't pass” and no longer equate unrelated non-Latin answers after stripping their characters. Unicode punctuation and canonical text normalization are supported.

The full delivered English lesson catalog is exported as `english-lesson-audit.json`, alongside `production-editorial.txt`. Regression tests check model coverage and limits, vocabulary recall, editorial idempotence, inversion, supplemental alignment and Unicode feedback. Device tests verify that writing displays the source and criteria, reveals the model after submission, and accepts an alternative without creating a false accuracy score.
