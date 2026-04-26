#!/usr/bin/env bash
set -e

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
REPO_ROOT="$(cd "$PROJECT_DIR/.." && pwd)"
ASSETS_DIR="$PROJECT_DIR/app/src/main/assets"
IMAGE_NAME="spark-android-builder"
APK_OUT="$PROJECT_DIR/app/build/outputs/apk/release/app-release.apk"
SOURCE_HTML="$REPO_ROOT/S5-Residency-Countdown.html"
SOURCE_FONTS_DIR="$REPO_ROOT/fonts"

echo "=== Spark Lab S5 Countdown — APK Builder ==="
echo ""

echo "[0/4] Syncing latest web assets from repo root..."
if [ ! -f "$SOURCE_HTML" ]; then
    echo "ERROR: Missing source HTML at $SOURCE_HTML" >&2
    exit 1
fi
if [ ! -d "$SOURCE_FONTS_DIR" ]; then
    echo "ERROR: Missing source fonts directory at $SOURCE_FONTS_DIR" >&2
    exit 1
fi
mkdir -p "$ASSETS_DIR"
cp "$SOURCE_HTML" "$ASSETS_DIR/S5-Residency-Countdown.html"
rm -rf "$ASSETS_DIR/fonts"
cp -R "$SOURCE_FONTS_DIR" "$ASSETS_DIR/fonts"

# Build or reuse Docker image
if ! docker image inspect "$IMAGE_NAME" &>/dev/null; then
    echo "[1/4] Building Android SDK Docker image (first time: ~5-10 min, downloads ~700MB)..."
    docker build --platform linux/amd64 -t "$IMAGE_NAME" "$PROJECT_DIR"
else
    echo "[1/4] Docker image '$IMAGE_NAME' already exists — skipping build."
fi

echo "[2/4] Gradle wrapper present."

echo "[3/4] Building APK (release)..."
docker run --rm --platform linux/amd64 \
    -v "$PROJECT_DIR:/project" \
    -v "spark-gradle-cache:/root/.gradle" \
    -v "spark-android-home:/root/.android" \
    -w /project \
    -e ANDROID_HOME=/opt/android-sdk \
    "$IMAGE_NAME" \
    bash -c "chmod +x gradlew && ./gradlew assembleRelease --no-daemon --quiet"

if [ -f "$APK_OUT" ]; then
    SIZE=$(du -h "$APK_OUT" | cut -f1)
    DEST="$HOME/Desktop/SparkCountdown-S5.apk"
    cp "$APK_OUT" "$DEST"
    echo ""
    echo "[4/4] APK ready: $DEST ($SIZE)"
    echo ""
    echo "Install on Redmi TV:"
    echo "  1. Copy APK to USB drive → plug into TV"
    echo "  2. TV Settings → Device Preferences → Security → Unknown Sources: ON"
    echo "  3. Open file manager → install APK"
    echo "  4. Launch 'S5 Countdown' from apps"
else
    echo "ERROR: APK not found at expected path." >&2
    exit 1
fi
