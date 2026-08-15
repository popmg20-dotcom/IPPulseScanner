package com.ippulse.scanner;

public class NativeHelper {
    static {
        System.loadLibrary("system");
    }

    public static native int sendfd(int fd, String path);
    public static native int jniclose(int fd);
}
