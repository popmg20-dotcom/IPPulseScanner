package net.typeblog.socks;

public class System {
    static {
        java.lang.System.loadLibrary("system");
    }

    public static native int sendfd(int fd, String path);
    public static native int jniclose(int fd);
}
