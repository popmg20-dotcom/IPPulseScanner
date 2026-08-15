package com.ippulse.scanner;

public class Tun2Socks {
    static {
        System.loadLibrary("tun2socks");
    }

    public static native void start(int fd);
    public static native void stop();
}
