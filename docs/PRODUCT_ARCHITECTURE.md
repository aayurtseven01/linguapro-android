# LinguaPro — product, learning and technical plan

## Product goal
A Turkish-first English-learning Android app that guides a learner from a diagnostic profile into a CEFR-aligned, skill-balanced study path. The goal is measurable communicative ability—not a list of grammar rules or an English-only streak counter.

## Learning design basis
Use the Council of Europe CEFR Companion Volume (2020) as the proficiency and activity reference. The course map must cover reception (listening/reading), production (speaking/writing), interaction and mediation, not treat the four skills as isolated grammar drills. Learner-facing units are organized around real tasks and situations, with grammar/vocabulary introduced as support for completing those tasks. Source: https://rm.coe.int/cefr-companion-volume-with-new-descriptors-2020/16809ea0d4

A1 learning targets start with familiar everyday expressions, simple personal information, short concrete exchanges, very short familiar texts, and carefully paced speech. Higher levels increase range, complexity, independence, register awareness and ability to handle abstract/unfamiliar topics. Level assignment from a short quiz is an initial estimate only; it must be refined by skill-specific performance and learner history.

## Product sequence
1. **Account & consent:** Firebase Authentication (email/password first; provider sign-in later), privacy notice, age/consent policy, Turkish onboarding.
2. **Diagnostic:** short adaptive placement across vocabulary/grammar, listening, reading, writing and speaking. Store per-skill confidence; label the result as an estimate. Offer a short calibration lesson and an option to retake.
3. **Personal plan:** target, available minutes, weekly cadence, interests (daily life/work/travel), baseline level, skills to strengthen. Generate a stable plan, not a random level assignment.
4. **Learning loop:** retrieve prior knowledge → model/example → guided practice → communicative task → feedback → spaced review. A lesson mixes modalities; accessibility alternatives always exist for audio/speech tasks.
5. **Progress & mastery:** record item attempts, skill evidence, lesson completion, streak, review schedule and explanation. Do not unlock a level only from one correct answer; use mastery thresholds and a level check.
6. **Subscription:** Google Play Billing with server-side entitlement verification. Trial and renewal disclosures must match Play Console products. A client-only boolean must never grant paid access.
7. **Content operations:** versioned content IDs, authored review, answer-key tests, localization and release checks. Content is data, not UI code.

## Proposed Android architecture
- Kotlin + Jetpack Compose; single-activity, navigation destinations by feature.
- MVVM / unidirectional state flow; UI state in ViewModels; repositories abstract storage and auth.
- `core/model`, `core/design`, `core/data`, and feature packages: `auth`, `onboarding`, `placement`, `learning`, `progress`, `paywall`, `profile`.
- Firebase Auth for identity; Firestore for user profile, placement snapshot, plan, activity events and entitlement mirror. Security Rules: every user-owned document scoped to `request.auth.uid`; content is read-only for app clients; entitlement writes restricted to trusted server/Cloud Functions.
- Offline-first: local Room cache / DataStore for preferences and queued progress; sync idempotently. Never put service-account credentials in the Android app or repository.
- Audio: Android TextToSpeech for model audio; SpeechRecognizer/recording only with explicit permission and clear data notice. For durable, pedagogically useful pronunciation scoring, use an explicitly selected speech assessment service; raw microphone audio is not silently uploaded.
- Billing: Google Play Billing Library; verify purchase tokens on trusted backend/Cloud Functions before enabling premium content.

Firebase Android setup is external: create a Firebase project, register package `com.linguapro.android`, enable Auth providers, create Firestore, download `google-services.json` into `app/`, and configure restrictive rules. Do not commit secrets or service-account JSON. Client Firebase config is not a substitute for security rules. Official Firebase Android guidance: https://firebase.google.com/docs/android/learn-more

## Quality gates for each iteration
1. Gradle `assembleDebug` and unit tests in CI.
2. Unit tests for placement boundaries, answer keys, progress/mastery transitions and serialization IDs.
3. UI tests for onboarding, quiz retry/back navigation, lesson completion, auth error states and locked entitlement.
4. Manual device check on at least one small and one large screen; accessibility labels, font scaling, contrast and keyboard flow.
5. Security review of Firestore rules and entitlement handling before any real user/payment launch.

## Phased delivery (do not claim production-ready prematurely)
- **P0 foundation:** product specification, architecture, visual shell, CI.
- **P1 learning vertical slice:** authored A1 starter course with listening/reading/grammar/writing/speaking tasks, feedback and local progress; content/placement tests.
- **P2 backend:** Firebase project connection, Auth, Firestore, rules, offline sync and account lifecycle.
- **P3 course breadth:** content review and complete A1–C1 scope, spaced repetition and skill-level diagnostics.
- **P4 commercial readiness:** Play Billing, server verification, privacy/consent, analytics minimization, crash reporting and release testing.

## Known external inputs
The repository owner must create/configure the Firebase project and provide the app's `google-services.json` through a secure channel (not a committed public file). Play Console products and pricing/trial configuration must be owned by the product account. Curriculum should receive a qualified English-teaching review before representing it as a complete CEFR course.
