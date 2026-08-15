#!/usr/bin/env bash
set -e

echo "[1/4] Restoring original JNI package for pre-compiled .so file..."
mkdir -p app/src/main/java/hev/socks5/tunnel
cat << 'JNI_EOF' > app/src/main/java/hev/socks5/tunnel/Tunnel.java
package hev.socks5.tunnel;

public class Tunnel {
    static {
        try {
            System.loadLibrary("hev-socks5-tunnel");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static native void HevSocks5TunnelStart(String config_path, int fd);
    public static native void HevSocks5TunnelStop();
    public static native boolean HevSocks5TunnelTProxy();
}
JNI_EOF

# Remove the broken custom package wrapper
rm -rf app/src/main/java/com/hev || true

echo "[2/4] Updating GamingVpnService to use the correct JNI class..."
FILE_VPN="app/src/main/java/com/ippulse/scanner/GamingVpnService.java"
if [ -f "$FILE_VPN" ]; then
    sed -i 's/import com.hev.socks5.HevSocks5Tunnel;/import hev.socks5.tunnel.Tunnel;/g' "$FILE_VPN"
    sed -i 's/HevSocks5Tunnel.HevSocks5TunnelStart/Tunnel.HevSocks5TunnelStart/g' "$FILE_VPN"
    sed -i 's/HevSocks5Tunnel.HevSocks5TunnelStop/Tunnel.HevSocks5TunnelStop/g' "$FILE_VPN"
fi

echo "[3/4] Checking and updating AndroidManifest.xml..."
MANIFEST="app/src/main/AndroidManifest.xml"
if [ -f "$MANIFEST" ]; then
    if grep -q "GamingVpnService" "$MANIFEST"; then
        echo "VPN Service already in Manifest."
    else
        echo "Injecting GamingVpnService to Manifest..."
        sed -i 's|</application>|    <service android:name=".GamingVpnService" android:permission="android.permission.BIND_VPN_SERVICE" android:exported="false">\n            <intent-filter>\n                <action android:name="android.net.VpnService" />\n            </intent-filter>\n        </service>\n    </application>|g' "$MANIFEST"
        
        # Add FOREGROUND_SERVICE permission if missing
        if ! grep -q "FOREGROUND_SERVICE" "$MANIFEST"; then
            sed -i 's|<application|\n    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" />\n    <uses-permission android:name="android.permission.FOREGROUND_SERVICE_SPECIAL_USE" />\n    <application|g' "$MANIFEST"
        fi
    fi
fi

echo "[4/4] Committing and pushing fixes..."
git add .
git commit -m "Fix: Restore hev.socks5.tunnel JNI package and update Manifest for VPN permissions" || true
git push origin main

echo "Runtime fixes applied and pushed successfully! Please trigger a new build."
