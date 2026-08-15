#!/data/data/com.termux/files/usr/bin/bash
set -e

ROOT="/sdcard/IPPulseScanner_PocoX7Pro_final-1/IPPulseScannerApp"
APP="$ROOT/app"
PKG="$APP/src/main/java/com/ippulse/scanner"
LOCALVPN="$PKG/localvpn"

SERVICE="$PKG/GamingVpnService.java"
TCP="$LOCALVPN/TCPOutput.java"
UDP="$LOCALVPN/UDPOutput.java"

cd "$ROOT"

echo "=============================================="
echo " IPPulseScanner FINAL FIX"
echo "=============================================="

[ -d "$APP" ] || {
    echo "ERROR: app not found"
    exit 1
}

[ -d "$LOCALVPN" ] || {
    echo "ERROR: localvpn not found"
    exit 1
}

[ -f "$SERVICE" ] || {
    echo "ERROR: GamingVpnService.java not found"
    exit 1
}

echo "[1] Fixing LocalVPN adapters..."

# TCPOutput
if [ -f "$TCP" ]; then

    sed -i '/import .*LocalVPNService;/d' "$TCP"

    if ! grep -q 'import android.net.VpnService;' "$TCP"; then
        sed -i \
        '/^package com\.ippulse\.scanner\.localvpn;/a import android.net.VpnService;' \
        "$TCP"
    fi

    sed -i 's/\bLocalVPNService\b/VpnService/g' "$TCP"
fi

# UDPOutput
if [ -f "$UDP" ]; then

    sed -i '/import .*LocalVPNService;/d' "$UDP"

    if ! grep -q 'import android.net.VpnService;' "$UDP"; then
        sed -i \
        '/^package com\.ippulse\.scanner\.localvpn;/a import android.net.VpnService;' \
        "$UDP"
    fi

    sed -i 's/\bLocalVPNService\b/VpnService/g' "$UDP"
fi

echo "[OK] LocalVPN adapters fixed."

echo "[2] Fixing GamingVpnService running order..."

# The service must set running=true BEFORE workers start.
python - "$SERVICE" <<'PY'
import sys

path = sys.argv[1]

with open(path, "r", encoding="utf-8") as f:
    s = f.read()

old = """executorService =
                    Executors.newFixedThreadPool(6);

            /*
             * Network -> TUN
             */

"""

new = """/*
             * IMPORTANT:
             * Workers check running in their loops.
             * Set it BEFORE submitting workers.
             */
            running = true;

            executorService =
                    Executors.newFixedThreadPool(6);

            /*
             * Network -> TUN
             */

"""

if old in s:
    s = s.replace(old, new, 1)

# Remove a later duplicate running=true if present in startVpn().
old2 = """/*
             * IMPORTANT:
             * Start flag after all workers exist.
             */
            running = true;

"""

s = s.replace(old2, "", 1)

with open(path, "w", encoding="utf-8") as f:
    f.write(s)
PY

echo "[OK] running order fixed."

echo "[3] Validating VPN configuration..."

grep -q 'addRoute' "$SERVICE" || {
    echo "ERROR: addRoute missing"
    exit 1
}

grep -q '0.0.0.0' "$SERVICE" || {
    echo "ERROR: 0.0.0.0 route missing"
    exit 1
}

grep -q 'setMtu' "$SERVICE" || {
    echo "ERROR: setMtu missing"
    exit 1
}

grep -q 'addDnsServer' "$SERVICE" || {
    echo "ERROR: addDnsServer missing"
    exit 1
}

grep -q 'UDPInput' "$SERVICE" || {
    echo "ERROR: UDPInput missing"
    exit 1
}

grep -q 'UDPOutput' "$SERVICE" || {
    echo "ERROR: UDPOutput missing"
    exit 1
}

grep -q 'TCPInput' "$SERVICE" || {
    echo "ERROR: TCPInput missing"
    exit 1
}

grep -q 'TCPOutput' "$SERVICE" || {
    echo "ERROR: TCPOutput missing"
    exit 1
}

grep -q 'TunReader' "$SERVICE" || {
    echo "ERROR: TunReader missing"
    exit 1
}

grep -q 'TunWriter' "$SERVICE" || {
    echo "ERROR: TunWriter missing"
    exit 1
}

echo "[OK] Full Tunnel / MTU / DNS / TCP / UDP checks passed."

echo "[4] Checking LocalVPNService references..."

if grep -R -n \
    --include='*.java' \
    'LocalVPNService' \
    "$LOCALVPN" 2>/dev/null
then
    echo "ERROR: LocalVPNService reference remains."
    exit 1
fi

echo "[OK] No LocalVPNService references."

echo "[5] Gradle build..."

if [ -f "$ROOT/gradlew" ]; then

    bash "$ROOT/gradlew" \
        clean \
        assembleDebug \
        --no-daemon \
        --stacktrace

else

    gradle \
        clean \
        assembleDebug \
        --no-daemon \
        --stacktrace
fi

APK="$APP/build/outputs/apk/debug/app-debug.apk"

[ -f "$APK" ] || {
    echo "ERROR: APK not generated."
    exit 1
}

echo
echo "BUILD SUCCESS"
echo "APK: $APK"
echo

echo "[6] Git status..."

git status --short

echo "[7] Commit..."

git add -A

if git diff --cached --quiet; then

    echo "No new changes to commit."

else

    git commit \
        -m "Fix LocalVPN full tunnel TCP UDP DNS MTU"

fi

echo "[8] Push to GitHub..."

git push origin main

echo
echo "=============================================="
echo " DONE - PUSHED TO GITHUB"
echo "=============================================="
echo
echo "Remote:"
git remote get-url origin
echo
echo "APK:"
echo "$APK"
