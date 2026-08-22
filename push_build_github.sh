#!/data/data/com.termux/files/usr/bin/bash
set -e

cd "$HOME/IPPulseScanner"

mkdir -p .github/workflows

cat > .github/workflows/android-build.yml <<'YAML'
name: Android Build

on:
  push:
    branches:
      - main
      - master
  workflow_dispatch:

permissions:
  contents: read

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout
        uses: actions/checkout@v4

      - name: Setup Java
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: '17'

      - name: Setup Gradle
        uses: gradle/actions/setup-gradle@v4
        with:
          gradle-version: '8.6'

      - name: Build APK
        run: gradle :app:assembleDebug --no-daemon --stacktrace

      - name: Show APK
        run: find app/build/outputs -type f -name "*.apk" -print

      - name: Upload APK
        uses: actions/upload-artifact@v4
        with:
          name: IPPulseScanner-debug
          path: app/build/outputs/apk/debug/*.apk
          if-no-files-found: error
YAML

echo "[1] Git status"
git status --short

echo "[2] Commit"
git add .

if git diff --cached --quiet; then
    echo "No new changes to commit."
else
    git commit -m "Network Lab build configuration"
fi

BRANCH="$(git branch --show-current)"

if [ -z "$BRANCH" ]; then
    echo "ERROR: current git branch is empty."
    exit 1
fi

echo "[3] Push: origin/$BRANCH"
git push origin "$BRANCH"

echo
echo "DONE"
echo "GitHub Actions should now build the APK."
echo "Open GitHub -> Actions -> Android Build."
