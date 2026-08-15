#!/usr/bin/env bash
set -e

TPROXY_FILE="app/src/main/java/com/ippulse/scanner/TProxyService.java"

if [ -f "$TPROXY_FILE" ]; then
    rm -f "$TPROXY_FILE"
    echo "Removed obsolete TProxyService.java"
fi

git add .
git commit -m "Fix: Remove obsolete TProxyService.java to resolve compilation errors"
git push origin main

echo "Pushed fix successfully!"
