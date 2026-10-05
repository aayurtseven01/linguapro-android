# Release acceptance: learning integrity and modern design

This branch is a review candidate. Passing source/Node checks alone does not authorize a paid production release or establish Duolingo parity.

## Implemented in the candidate

- Preserve meaningful Unicode characters; reject altered CJK characters instead of accepting character similarity.
- Separate skill tallies by learner and course language; clear the new stores on account deletion.
- Use local calendar dates for daily words and quests; select daily words from the selected curriculum level.
- Validate declared writing length while leaving semantic/grammar assessment ungraded.
- Rotate personalized practice using recent session history; prioritize known mistakes.
- Distinguish listening answered through a visible transcript from listening evidence; record such answers as reading.
- Preserve offline study timestamps separately from server reward timestamps.
- Require the server account-deletion path instead of direct profile deletion.
- Reserve one current username per account and rate-limit fixed-template public activity.
- Integrate the midnight/mint visual design, shared typography, navigation and restyled learning/profile screens.
- Expand reading stories at A2–C2 across ten languages and add translations, evidence feedback and level filtering.

## Required executable checks

1. Android unit tests, debug and release builds, bundle and lint.
2. Compose/device regressions on API 24 and 36, including Unicode grading, language switching, writing correction, optional translations, font scaling and persistent navigation.
3. Firestore emulator tests against the exact rules shipped with this candidate.
4. Backend Node tests, callable handler tests and authored-content checks.
5. Screenshots and manual device review of home, course, lesson, story, profile, Pro and account deletion. Check TalkBack, reduced motion, large fonts and slow/offline transitions.

Local Node and source checks are distinct from Android compilation or Firestore emulator execution. GitHub Actions failures/cancellations without steps provide no evidence that those checks passed. Investigate the actual Actions error before changing runner settings or claiming a quota diagnosis.

## Owner configuration and production gates

- Firebase project, callable deployment, matching rules/indexes, App Check registration and operational monitoring.
- Play Console products/base plans, developer API service-account permissions and real-time notifications.
- Upload signing credentials outside Git and a signed internal-testing AAB.
- Real purchase, renewal, cancellation, refund, pending, account mismatch and restore tests.
- Public privacy/account-deletion pages and a real support contact; accurate store declarations.
- Coordinated update for older clients using direct social writes.

Do not invent these values, enable billing without verification, publish secrets or merge around failed required checks.

## Product/content work still open

- The nine world curricula still contain many brief C1–C2 exercises; the new stories are a targeted expansion, not a complete replacement.
- Independent multilingual grammar/translation and CEFR review; broader advanced themes and unseen assessment tasks.
- Calibrated placement and learning outcomes. Current short tests cannot certify C1/C2 proficiency.
- Meaning-aware open writing, pronunciation/fluency assessment and real conversational practice.
- Server-issued learning sessions and response validation if stronger ranked anti-cheat is required.
- Public user reporting/blocking and an operational moderation process.
- Recorded audio coverage and device accessibility/performance verification.
- Real learner pilots and retention/conversion evidence before claims about learning efficacy or commercial success.

These items require separate work and evidence. They must not be represented as complete simply because the app builds or contains A1–C2 labels.
