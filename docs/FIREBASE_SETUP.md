# Firebase connection checklist

Firebase SDK dependencies, the Google Services Gradle plugin, and the owner-provided `app/google-services.json` are present. The config matches package `com.linguapro.android`, is tracked with the private repository for reproducible sync/CI builds, and contains Firebase client configuration (not an Admin SDK/service-account secret). Firebase-provisioned API keys identify the project; enforce Firebase API restrictions, Security Rules and App Check. The app deliberately shows a labelled demo path when Firebase is not configured; that path creates no account.

## One-time project-owner setup

1. In Firebase Console, create/select the production project and add an Android app with package **`com.linguapro.android`**.
2. Turn on **Authentication → Email/Password**. Configure authorized domains and email verification policy appropriate to launch.
3. Create the production Firestore database in the intended region.
4. The supplied Android client's `google-services.json` is installed at **`app/google-services.json`** and its package is `com.linguapro.android`. It is Firebase client configuration, not a service-account key. Firebase documents Firebase-provisioned API keys as public-by-design identifiers; keep them restricted to Firebase APIs and rely on Security Rules/App Check for authorization. Never put a service-account JSON, private key, or Admin SDK credential in the Android app/repository. Do not add non-Firebase/Gemini API keys to this file.
5. Deploy `firestore.rules` with Firebase CLI after reviewing the rules against the final data model. Use the Firebase Emulator Suite to test owner-only reads/writes and rejection of cross-user or entitlement writes.
6. Sync Gradle and run the app. Signup writes a user profile; placement and completed-lesson events are stored beneath that authenticated user's UID. Check Firebase Console/Authentication and Firestore to confirm.

## Data and security boundary

`users/{uid}` contains user profile, CEFR estimate, completion count, and skill-mastery summary. `users/{uid}/lessonEvents/{eventId}` stores lesson ID, score, and server timestamp. Firestore rules make user documents owner-readable and restrict update fields. A user-owned progress number is not proof of paid access. **No premium entitlement field may be client-writable**; subscription state must come from trusted backend verification of Google Play purchase tokens.

## Current implementation status

Auth repository supports email/password registration, sign-in, password-reset email, initial profile write, placement save, profile load and lesson event persistence. The supplied Android client config is present and the Firestore rules pass the Firebase Emulator Suite tests in CI. A live Firebase smoke test is still blocked until the project owner confirms/enables Email/Password Auth and Firestore and deploys these rules to the correct project. Offline queue/sync conflict handling, email verification flow, account deletion/export, App Check and live-project verification remain pre-release tasks. Do not launch with permissive test-mode Firestore rules.
