package com.getsurfboard.vpn;

import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ippulse.scanner.GamingVpnService;

public final class Jni {

    private static final String TAG = "SurfboardJni";

    private static final String TUN_ADDRESS = "";
    private static final String TUN6_ADDRESS = " ";
    private static final String DNS_ADDRESS = "";

    private static volatile WeakReference<GamingVpnService> serviceRef =
            new WeakReference<>(null);

    private static final ConcurrentHashMap<Integer, String> DNS_RESTORE =
            new ConcurrentHashMap<>();

    static {
        System.loadLibrary("surfboard");
    }

    public Jni() {
    }

    public Jni(GamingVpnService service) {
        attachService(service);
    }

    public static void attachService(GamingVpnService service) {
        serviceRef = new WeakReference<>(service);
    }

    public static void detachService(GamingVpnService service) {
        GamingVpnService s = serviceRef.get();
        if (s == service) {
            serviceRef = new WeakReference<>(null);
        }
    }

    private static GamingVpnService service() {
        return serviceRef.get();
    }

    public static String getTunAddress() {
        return TUN_ADDRESS;
    }

    public static String getTun6Address() {
        return TUN6_ADDRESS;
    }

    public static String getDnsAddress() {
        return DNS_ADDRESS;
    }

    /*
     * Exact native entry point:
     *
     * startVPN(int tunFd,
     *          int sdkInt,
     *          int logMode,
     *          boolean logEnabled,
     *          boolean sshDump,
     *          boolean ipv6)
     */
    public native void startVPN(
            int tunFd,
            int sdkInt,
            int logMode,
            boolean logEnabled,
            boolean sshDump,
            boolean ipv6
    );

    public native void stopVPN();

    public native void returnAsyncDnsResult(int id, byte[] data);

    public native void resetAllTCPConnections();

    public native void printAllTCPConnectionsInfo();

    public boolean protect(int fd) {
        GamingVpnService s = service();
        if (s == null) return false;

        try {
            return s.protect(fd);
        } catch (Throwable t) {
            Log.e(TAG, "protect(" + fd + ") failed", t);
            return false;
        }
    }

    public boolean shouldDecodeProxy(int uid) {
        return false;
    }

    public void updateActiveConnectionCount(int count) {
        GamingVpnService s = service();
        if (s != null) {
            s.onNativeConnectionCount(count);
        }
    }

    public void writePcapRecord(byte[] data) {
        /*
         * SSHDump/PCAP is intentionally disabled for this build.
         * Native engine still has the callback available.
         */
    }

    public void logTraffic(int uid, boolean upload, long bytes, boolean metered) {
        GamingVpnService s = service();
        if (s != null) {
            s.onNativeTraffic(uid, upload, bytes, metered);
        }
    }

    public void onVpnStarted() {
        GamingVpnService s = service();
        if (s != null) {
            s.onNativeVpnStarted();
        }
    }

    public void onVpnStopped() {
        GamingVpnService s = service();
        if (s != null) {
            s.onNativeVpnStopped();
        }
    }

    public String getSystemDns(String ignored) {
        GamingVpnService s = service();
        if (s != null) {
            String d = s.getConfiguredDns();
            if (d != null && !d.trim().isEmpty()) {
                return d.trim();
            }
        }
        return "8.8.8.8";
    }

    public byte[] getProxyStrategy(byte[] data) {
        /*
         * Empty strategy means native engine uses its normal/direct path.
         */
        return new byte[0];
    }

    public byte[] onDnsQuery(byte[] query) {
        GamingVpnService s = service();
        if (s == null || query == null || query.length < 12) {
            return new byte[0];
        }

        try {
            return s.handleNativeDnsQuery(query);
        } catch (Throwable t) {
            Log.e(TAG, "onDnsQuery failed", t);
            return new byte[0];
        }
    }

    public byte[] onDnsResponse(byte[] response) {
        return response == null ? new byte[0] : response;
    }
}
