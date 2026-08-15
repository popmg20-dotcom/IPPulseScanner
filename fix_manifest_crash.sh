#!/usr/bin/env bash
set -e

MANIFEST="app/src/main/AndroidManifest.xml"

echo "Updating AndroidManifest.xml with proper foreground service type..."

if [ -f "$MANIFEST" ]; then
    # Clean up old service declarations if any
    python3 -c '
with open("app/src/main/AndroidManifest.xml", "r") as f:
    content = f.read()

# Ensure proper service attributes
if "android:foregroundServiceType" not in content:
    content = content.replace(
        "android:permission=\"android.permission.BIND_VPN_SERVICE\"",
        "android:permission=\"android.permission.BIND_VPN_SERVICE\" android:foregroundServiceType=\"specialUse\""
    )

with open("app/src/main/AndroidManifest.xml", "w") as f:
    f.write(content)
'
fi

git add .
git commit -m "Fix: Add foregroundServiceType to AndroidManifest to prevent crash" || true
git push origin main

echo "Manifest updated and pushed successfully! Please rebuild your app."
