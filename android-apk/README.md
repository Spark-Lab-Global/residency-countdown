# Android APK Wrapper

This directory vendors the Android TV `WebView` wrapper from the `android-apk` branch into the main repository without replacing the root single-file web app.

> Current status: this directory has been integrated and cleaned up, but the **APK itself has not yet been rebuilt in a Docker / Android SDK environment after the latest HTML and time-compatibility changes**.  
> In practice, the APK currently installed on TV should still be treated as the **previous packaged version** until a new build is produced and validated on-device.

## Intent

- Keep the repository root as the source of truth for the countdown experience.
- Package the current [S5-Residency-Countdown.html](../S5-Residency-Countdown.html) into an Android APK for TV sideloading.
- Avoid maintaining a second, drifting HTML implementation inside the Android project.

## Source Of Truth

- Main page: [../S5-Residency-Countdown.html](../S5-Residency-Countdown.html)
- Font assets: [../fonts](../fonts)

The build script syncs those files into `app/src/main/assets/` before running Gradle, so APK builds stay aligned with the latest root web version.

## Build

From the repository root:

```bash
./android-apk/build.sh
```

This script:

1. Copies the latest root HTML and `fonts/` into Android assets.
2. Reuses or builds a Dockerized Android SDK environment.
3. Builds a release APK with Gradle.
4. Copies the APK to the Desktop.

## Alternative Build Paths

Docker is the default path in this repository because it avoids changing the host machine too much, but it is **not** the only option.

### 1. Android Studio

If a machine already has Android Studio installed with an initialized SDK:

1. Open the `android-apk/` directory as a project.
2. Let Android Studio sync Gradle.
3. Build the app from the IDE.

Android Studio ultimately calls the same Gradle build underneath, but it manages the SDK location and licenses for you.

### 2. Local Android Command-Line Tools

If you do not want Docker, you can also build with a local SDK installation:

1. Install Android SDK Command-Line Tools.
2. Use `sdkmanager` to install at least:
   - `platforms;android-34`
   - `build-tools;34.0.0`
   - `platform-tools`
3. Point Gradle at that SDK via `ANDROID_HOME` or a `local.properties` file.
4. Run:

```bash
cd android-apk
./gradlew assembleRelease
```

This path changes the host machine more than Docker, but it avoids running a local VM.

### 3. Build On Another Machine Or CI

If this Mac is your main working machine and you want the lowest risk:

- keep editing on this machine,
- build the APK on another Mac / build box / CI runner with Docker or a local Android SDK,
- then bring back the generated APK.

## Notes

- The imported `origin/android-apk` branch originally carried its own `assets/index.html` fork. The active launcher now opens `S5-Residency-Countdown.html` directly from assets instead.
- The build also persists `/root/.android` in a Docker volume so repeated local builds reuse the same debug signing key and remain upgradeable on the target TV.
- The web page now prefers a tiny native `AndroidTime` bridge inside the APK for current time, then falls back to browser `Date` when that bridge is unavailable. This keeps the root HTML portable while giving Android TV a steadier clock source.
- TV-side time issues around **Ship it Monday** and the **main countdown** should be considered unresolved until a fresh APK is rebuilt and tested on a real device.
