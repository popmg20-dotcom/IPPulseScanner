package com.getsurfboard.vpn;

import defpackage.qe;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class JniKt {
    public static final byte[] a = new byte[0];
    public static final Set b = qe.t0(new InetAddress[]{InetAddress.getByName("127.0.0.1"), InetAddress.getByName("0.0.0.0")});
    public static final Method c;
    public static final Method d;

    static {
        Method declaredMethod = FileDescriptor.class.getDeclaredMethod("setInt$", Integer.TYPE);
        declaredMethod.getClass();
        c = declaredMethod;
        Method declaredMethod2 = FileDescriptor.class.getDeclaredMethod("getInt$", null);
        declaredMethod2.getClass();
        d = declaredMethod2;
    }

    public static final String a(int i) {
        return "0x".concat(String.format("%08X", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1)));
    }

    public static final native int dnsStrategyAlias();

    public static final native int dnsStrategyAsyncDns();

    public static final native int dnsStrategyDirect();

    public static final native int dnsStrategyIP();

    public static final native int dnsStrategyServer();

    public static final native int getDNSTimeout();

    public static final native String getDnsPlaceholder0();

    public static final native String getDnsPlaceholder1();

    public static final native String getFakeIpMapperEnd();

    public static final native String getFakeIpMapperStart();

    public static final native byte[] getPcapHeaderBytes();

    public static final native String getTun6Address();

    public static final native String getTunAddress();

    public static final native String getXRayAddress();

    public static final native int proxyDirect();

    public static final native int proxyReject();

    public static final native int proxyRejectDrop();

    public static final native int proxySocks5();
}
