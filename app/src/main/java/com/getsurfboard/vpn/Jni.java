package com.getsurfboard.vpn;

public class Jni {
    static {
        System.loadLibrary("conscrypt_jni");
        System.loadLibrary("xray");
        System.loadLibrary("surfboard");
    }

    // امضای دقیق از سورس Surfboard
    private final native void startVPN(int i, int i2, int i3, boolean z, boolean z2, boolean z3);
    private final native void stopVPN();

    public void start(int fd, int sdk, int mtu, boolean b1, boolean b2, boolean b3) {
        startVPN(fd, sdk, mtu, b1, b2, b3);
    }

    public void stop() {
        stopVPN();
    }
}
