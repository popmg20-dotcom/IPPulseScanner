package com.getsurfboard.vpn;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.VpnService;
import android.os.Build;
import android.util.Log;

import java.net.InetAddress;
import java.util.List;

public final class Jni {

    private static volatile VpnService vpnService;
    private static volatile Network activeNetwork;

    public Jni() {
    }

    public static void attach(VpnService service, Network network) {
        vpnService = service;
        activeNetwork = network;
    }

    public static void detach() {
        vpnService = null;
        activeNetwork = null;
    }

    /*
     * Native -> Java callbacks expected by libsurfboard.so.
     */

    private byte[] getProxyStrategy(byte[] data) {
        /*
         * Keep the original payload intact.
         * Native side owns the actual proxy/TCP/UDP machinery.
         */
        return data;
    }

    private String getSystemDns(String ignored) {
        try {
            Network n = activeNetwork;
            if (n != null && vpnService != null) {
                ConnectivityManager cm =
                        (ConnectivityManager)
                                vpnService.getSystemService(VpnService.CONNECTIVITY_SERVICE);

                if (cm != null) {
                    LinkProperties lp = cm.getLinkProperties(n);
                    if (lp != null) {
                        List<InetAddress> dns = lp.getDnsServers();
                        if (dns != null && !dns.isEmpty()) {
                            return dns.get(0).getHostAddress();
                        }
                    }
                }
            }
        } catch (Throwable t) {
            Log.w("SurfboardJni", "getSystemDns failed", t);
        }

        return "8.8.8.8";
    }

    private byte[] onDnsQuery(byte[] data) {
        return data;
    }

    private byte[] onDnsResponse(byte[] data) {
        return data;
    }

    private void onVpnStarted() {
        Log.i("SurfboardJni", "onVpnStarted");
    }

    private void onVpnStopped() {
        Log.i("SurfboardJni", "onVpnStopped");
    }

    private boolean protect(int fd) {
        try {
            VpnService service = vpnService;
            if (service == null) {
                return false;
            }

            /*
             * Prefer the exact physical Network when available.
             * Otherwise use normal VpnService.protect().
             */
            Network network = activeNetwork;

            if (network != null) {
                try {
                    java.io.FileDescriptor fdObject =
                            new java.io.FileDescriptor();

                    return service.protect(fd);
                } catch (Throwable ignored) {
                }
            }

            return service.protect(fd);

        } catch (Throwable t) {
            Log.e("SurfboardJni", "protect(" + fd + ") failed", t);
            return false;
        }
    }

    private void updateActiveConnectionCount(int count) {
        Log.d("SurfboardJni",
                "active connections=" + count);
    }

    private void writePcapRecord(byte[] data) {
        // PCAP export is optional in this build.
    }

    private void logTraffic(int uid, boolean upload, long bytes,
                            boolean encrypted) {
        Log.d(
                "SurfboardJni",
                "uid=" + uid
                        + " upload=" + upload
                        + " bytes=" + bytes
                        + " encrypted=" + encrypted
        );
    }

    private boolean shouldDecodeProxy(int uid) {
        return false;
    }

    private native void returnAsyncDnsResult(int id, byte[] data);

    private static native void startVPN(
            int tunFd,
            int sdkInt,
            int logEnabled,
            boolean sshdump,
            boolean ipv6,
            boolean reserved
    );

    private static native void stopVPN();

    public static native void resetAllTCPConnections();

    public static native void printAllTCPConnectionsInfo();

    public static void start(
            VpnService service,
            Network network,
            int tunFd,
            boolean logEnabled
    ) {
        attach(service, network);

        startVPN(
                tunFd,
                Build.VERSION.SDK_INT,
                logEnabled ? 1 : 0,
                false,
                false,
                false
        );
    }

    public static void stop() {
        try {
            stopVPN();
        } catch (Throwable t) {
            Log.w("SurfboardJni", "stopVPN failed", t);
        } finally {
            detach();
        }
    }

    static {
        System.loadLibrary("surfboard");
    }
}
