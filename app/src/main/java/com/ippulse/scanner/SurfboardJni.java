package com.ippulse.scanner;

public class SurfboardJni {
    static {
        System.loadLibrary("surfboard");
    }

    public static native void startVPN(int fd, int sdk, int mtu, boolean b1, boolean b2, boolean b3);
    public static native void stopVPN();
}
