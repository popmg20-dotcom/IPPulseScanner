package com.hev.socks5;

public class HevSocks5Tunnel {
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
