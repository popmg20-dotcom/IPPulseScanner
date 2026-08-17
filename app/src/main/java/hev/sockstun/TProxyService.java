package hev.sockstun;

public final class TProxyService {

    private TProxyService() {}

    static {
        System.loadLibrary("hev-socks5-tunnel");
    }

    private static native boolean TProxyStartService(
            String configPath,
            int tunFd
    );

    private static native boolean TProxyStopService();

    private static native boolean TProxyIsRunning();

    private static native long[] TProxyGetStats();

    public static boolean start(
            String configPath,
            int tunFd
    ) {
        return TProxyStartService(
                configPath,
                tunFd
        );
    }

    public static boolean stop() {
        return TProxyStopService();
    }

    public static boolean isRunning() {
        return TProxyIsRunning();
    }

    public static long[] getStats() {
        return TProxyGetStats();
    }
}
