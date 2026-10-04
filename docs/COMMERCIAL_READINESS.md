# Lingua Pro: commercial release setup

The product model is free core learning plus a monthly/yearly Pro subscription. Pro provides short sessions selected from authored exercises using the learner's mistakes and skill history. No AI pronunciation grading or CEFR certification is claimed. Billing is disabled by default until the owner completes the setup below.

## What the branch implements

- Google Play Billing 8.3: localized prices and ordinary base-plan conditions, account-bound checkout, pending-payment handling, restore and subscription-management links.
- Firebase callable purchase verification through the Google Play Developer API; purchase-token ownership, acknowledgement, expiry and account matching are checked on the server.
- Real-time developer notifications update cancellations, grace periods, holds, expiry and renewals. A replaced purchase cannot revoke its successor.
- App Check protects callable endpoints. Debug and release builds use different providers.
- Server-only ranked XP: a bounded reward once per lesson per UTC day. Local practice XP remains separate. This limits direct score tampering but does not prove that an offline learner actually answered each exercise; stronger anti-cheat would require server-issued sessions and answer verification.
- Reauthentication before account deletion, server cleanup of profile subcollections, public identity, purchase records and references in friends lists; account-scoped local cleanup follows.
- Room outbox for offline lesson attempts and atomic, idempotent Firestore uploads. Private review cards, skill summaries, streak and time goals remain local to the device.
- Daily study goals use foreground lesson time. Background and completion-screen time are excluded. Time from abandoned lessons is not added to completed-session totals.

## Owner configuration required before enabling payments

1. Create the Google Play Console application with package `com.linguapro.android`. Enroll in Play App Signing. Keep the upload keystore and passwords outside Git; configure a signed release build in the owner environment.
2. Create and activate subscription products `linguapro_pro_monthly` and `linguapro_pro_yearly`, with ordinary auto-renewing base plans. Prices, eligible countries, billing periods, renewal wording and any trials belong in Play Console. The app reads them from Play; it does not invent a price or trial.
3. Enable the Google Play Android Developer API. Grant the Cloud Functions runtime service account the least Play Console permissions needed to view and manage orders/subscriptions. Use application default credentials; never ship a service-account JSON in Android.
4. Register the production Android app with Firebase App Check / Play Integrity and its signing certificate. For debug testing, register the debug provider token in Firebase Console. Callable functions reject missing App Check tokens.
5. Provision the Pub/Sub topic `play-subscription-events`. Grant `google-play-developer-notifications@system.gserviceaccount.com` publisher access and configure the topic in Play Console real-time developer notifications. Send a test notification.
6. Copy `functions/.env.example` to the correct project environment file. Keep `PLAY_BILLING_ENABLED=false` initially. Deploy functions, security rules and indexes to the intended Firebase project:

   ```sh
   npm ci --prefix functions
   npm test --prefix functions
   firebase deploy --project YOUR_PROJECT_ID --only functions,firestore:rules,firestore:indexes
   ```

7. Use Play internal testing and license testers. Verify successful purchase, pending payment, canceled checkout, restore on another device with the same Lingua account, a different Lingua account, upgrade, renewal, grace period, hold, refund/revocation and expiry. Enable `PLAY_BILLING_ENABLED=true` only after these scenarios pass.
8. Provide a real support contact, production privacy policy and public account-deletion request URL. Complete Play Data safety using the actual configured Firebase/Google services and data retention policy. Obtain a curriculum review before advertising full CEFR coverage.

## Deploy and migration order

Deploy backend functions, indexes and matching rules before distributing this app version. Account deletion and verified social scoring now require the backend. Until configured, the free course works but Pro activation and account deletion must return a clear error.

Existing leaderboard values are not trusted or copied into `verifiedXp`. New server rewards establish the verified score; existing members are initialized when a new valid study event arrives. Existing cloud completion counters are retained for compatibility; historical duplicate counters require a separately reviewed data migration. New attempts cannot double-count the same lesson completion.

## Validation and release gates

CI runs unit tests, debug lint, debug APK, optimized release APK/AAB, Firestore security tests, backend domain tests and API 24/36 device tests. The unsigned release build checks packaging; it is not an upload-ready signed release. Passing these checks does not replace real Play purchase tests, device-specific speech tests, accessibility review, or education-content review.

Paid-access cache evidence expires after 24 hours without verification and never outlives the subscription expiry. On sign-in and foreground resume the app attempts to restore/verify current Play purchases. A full multi-device migration of local XP, streak, per-skill evidence and multilingual progress is still a separate product milestone.

## Next product milestones

1. Complete per-language progress, streak and mastery synchronization, with an explicit legacy-counter migration and account data export.
2. Record answer evidence and calibrate per-skill diagnostics; add reviewed adaptive placement across listening, speaking and writing.
3. Establish authored-content QA, native-speaker audio and speaking assessment with a clear accuracy/evaluation contract.
4. Measure onboarding completion, D1/D7 retention, lesson completion and paid conversion with consent-appropriate analytics. Do not add third-party tracking before choosing the real privacy/data policy.
5. Validate subscription value and pricing with real testers, then add advanced guided practice based on the measured need.

Official implementation references:
- https://developer.android.com/google/play/billing/integrate
- https://developer.android.com/google/play/billing/security
- https://developer.android.com/google/play/billing/lifecycle/subscriptions
- https://firebase.google.com/docs/app-check/android/play-integrity-provider
- https://firebase.google.com/docs/functions/callable
- https://developer.android.com/google/play/requirements/target-sdk
