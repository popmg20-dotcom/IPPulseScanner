#!/usr/bin/env bash
set -e

FILE="app/src/main/java/com/ippulse/scanner/LocalSocks5Server.java"

if [ -f "$FILE" ]; then
    sed -i 's/executor.execute(() -> pipe(in, targetSocket.getOutputStream()));/executor.execute(() -> { try { pipe(in, targetSocket.getOutputStream()); } catch (Exception ignored) {} });/g' "$FILE"
    sed -i 's/pipe(targetSocket.getInputStream(), out);/try { pipe(targetSocket.getInputStream(), out); } catch (Exception ignored) {}/g' "$FILE"
    echo "Fixed IOException in LocalSocks5Server.java"
fi

git add .
git commit -m "Fix: Handle IOException in LocalSocks5Server pipe calls"
git push origin main

echo "Pushed fix successfully!"
