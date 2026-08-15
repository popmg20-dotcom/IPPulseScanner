#!/usr/bin/env bash
set -e

echo "Removing hev-socks5-tunnel dependency from build.gradle..."

if [ -f "app/build.gradle" ]; then
    sed -i '/hev-socks5-tunnel/d' app/build.gradle
fi

if [ -f "app/build.gradle.kts" ]; then
    sed -i '/hev-socks5-tunnel/d' app/build.gradle.kts
fi

git add .
git commit -m "Fix: Remove non-existent gradle dependency for hev-socks5-tunnel"
git push origin main

echo "Dependency removed and pushed successfully!"
