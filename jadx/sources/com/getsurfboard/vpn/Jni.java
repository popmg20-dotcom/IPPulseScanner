package com.getsurfboard.vpn;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.LocalServerSocket;
import android.net.Network;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.getsurfboard.xray.XRay;
import com.tencent.mars.xlog.Xlog;
import defpackage.a04;
import defpackage.bn3;
import defpackage.cd;
import defpackage.ce0;
import defpackage.cm2;
import defpackage.d70;
import defpackage.dg4;
import defpackage.dt;
import defpackage.dw2;
import defpackage.e03;
import defpackage.e7;
import defpackage.ea3;
import defpackage.eb1;
import defpackage.ek0;
import defpackage.ez4;
import defpackage.f93;
import defpackage.fn;
import defpackage.fw;
import defpackage.fx3;
import defpackage.fy4;
import defpackage.ga5;
import defpackage.gj;
import defpackage.h14;
import defpackage.h41;
import defpackage.ha0;
import defpackage.ha1;
import defpackage.hn3;
import defpackage.i1;
import defpackage.i94;
import defpackage.in3;
import defpackage.it3;
import defpackage.iv1;
import defpackage.je;
import defpackage.ji;
import defpackage.ji0;
import defpackage.jn3;
import defpackage.jt3;
import defpackage.k14;
import defpackage.k93;
import defpackage.ke0;
import defpackage.la3;
import defpackage.le2;
import defpackage.m32;
import defpackage.mm3;
import defpackage.n12;
import defpackage.n32;
import defpackage.n84;
import defpackage.oj0;
import defpackage.on3;
import defpackage.p44;
import defpackage.p95;
import defpackage.pl1;
import defpackage.ql0;
import defpackage.qn3;
import defpackage.r93;
import defpackage.re2;
import defpackage.rl0;
import defpackage.rm3;
import defpackage.rn3;
import defpackage.rn4;
import defpackage.rs4;
import defpackage.sa3;
import defpackage.t4;
import defpackage.t53;
import defpackage.t93;
import defpackage.tj4;
import defpackage.tm3;
import defpackage.tn3;
import defpackage.ua3;
import defpackage.v62;
import defpackage.vs4;
import defpackage.we2;
import defpackage.wm3;
import defpackage.ws4;
import defpackage.x12;
import defpackage.xb5;
import defpackage.xd4;
import defpackage.xe;
import defpackage.xw0;
import defpackage.xw2;
import defpackage.yt3;
import defpackage.yw1;
import defpackage.zn;
import defpackage.zw1;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.dns.DnsSection;
import io.sentry.android.core.a1;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.BindException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Jni {
    public final yw1 a;
    public final ConcurrentHashMap b;
    public final iv1 c;
    public final ConcurrentHashMap d;
    public final XRay e;
    public final f93 f;
    public final AtomicInteger g;
    public final AtomicInteger h;
    public final zn i;
    public final LinkedHashSet j;
    public final HashMap k;
    public final LinkedHashSet l;
    public cm2 m;
    public cm2 n;
    public i94 o;
    public final xw0 p;
    public final v62 q;
    public final ha1 r;
    public final ConcurrentHashMap s;
    public final ArrayList t;
    public Network u;
    public final n84 v;
    public final n84 w;

    /* JADX WARN: Removed duplicated region for block: B:59:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Jni(defpackage.yw1 r9) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.vpn.Jni.<init>(yw1):void");
    }

    public static int g(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                return ContextUtilsKt.b().getConnectionOwnerUid(i, inetSocketAddress, inetSocketAddress2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    private final byte[] getProxyStrategy(byte[] bArr) {
        try {
            r93 r93Var = t93.K0;
            r93Var.getClass();
            t93 t93Var = (t93) r93Var.c(bArr, 0, bArr.length, i1.a);
            t93Var.getClass();
            return f(t93Var).j();
        } catch (Throwable th) {
            String string = th.toString();
            ((SurfboardVpn) this.a).getClass();
            string.getClass();
            xb5.c(string);
            throw th;
        }
    }

    private final String getSystemDns(String str) throws NoSuchMethodException, UnknownHostException {
        LinkProperties linkProperties;
        List<InetAddress> dnsServers;
        InetAddress byName = InetAddress.getByName(str);
        ConnectivityManager connectivityManagerB = ContextUtilsKt.b();
        Network network = this.u;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        if (Build.VERSION.SDK_INT < 26) {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            for (int i2 = 1; i2 < 5; i2++) {
                String str2 = (String) method.invoke(null, dw2.A(i2, "net.dns"));
                if (str2 != null && str2.length() != 0) {
                    InetAddress byName2 = InetAddress.getByName(str2);
                    if (byName2 instanceof Inet4Address) {
                        arrayList.add(byName2);
                    } else if (byName2 instanceof Inet6Address) {
                        Inet6Address inet6Address = (Inet6Address) byName2;
                        if (inet6Address.isIPv4CompatibleAddress()) {
                            InetAddress byAddress = InetAddress.getByAddress(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
                            byAddress.getClass();
                            arrayList.add((Inet4Address) byAddress);
                        } else {
                            arrayList2.add(byName2);
                        }
                    }
                }
            }
        } else if (network != null && (linkProperties = connectivityManagerB.getLinkProperties(network)) != null && (dnsServers = linkProperties.getDnsServers()) != null) {
            for (InetAddress inetAddress : dnsServers) {
                if (inetAddress instanceof Inet4Address) {
                    arrayList.add(inetAddress);
                } else if (inetAddress instanceof Inet6Address) {
                    Inet6Address inet6Address2 = (Inet6Address) inetAddress;
                    if (inet6Address2.isIPv4CompatibleAddress()) {
                        InetAddress byAddress2 = InetAddress.getByAddress(Arrays.copyOfRange(inet6Address2.getAddress(), 12, 16));
                        byAddress2.getClass();
                        arrayList.add((Inet4Address) byAddress2);
                    } else {
                        arrayList2.add(inetAddress);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            String hostAddress = byName.getHostAddress();
            if (!n12.c(hostAddress, JniKt.getDnsPlaceholder0())) {
                if (n12.c(hostAddress, JniKt.getDnsPlaceholder1())) {
                    i = 1;
                } else {
                    String strConcat = "getSystemDns: mismatch system dns placeholder ".concat(tj4.f0(byName));
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        a1.e("Jni", strConcat, null);
                    }
                }
            }
            return ((InetAddress) arrayList.get(Math.min(i, arrayList.size() - 1))).getHostAddress();
        }
        if (fy4.b) {
            Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "getSystemDns: getDnsServers return empty list");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            a1.e("Jni", "getSystemDns: getDnsServers return empty list", null);
            return null;
        }
        return null;
    }

    public static boolean i(tn3 tn3Var, int i, String str, InetAddress inetAddress, Integer num, InetSocketAddress inetSocketAddress, String str2, String str3, String str4, List list, on3 on3Var, e03 e03Var, String str5) {
        String str6;
        String str7;
        if (tn3Var instanceof jn3) {
            Iterator it = ((jn3) tn3Var).z.iterator();
            while (it.hasNext()) {
                if (i((tn3) it.next(), i, str, inetAddress, num, inetSocketAddress, str2, str3, str4, list, on3Var, e03Var, str5)) {
                    return true;
                }
            }
        }
        if (tn3Var instanceof bn3) {
            str6 = str;
            str7 = str5;
            if (fx3.u(tn3Var, str2, str6, inetSocketAddress.getAddress(), str3, str4, list, on3Var, e03Var, inetAddress != null ? tj4.f0(inetAddress) : null, num, Integer.valueOf(inetSocketAddress.getPort()), Integer.valueOf(i), str7, 0)) {
                return true;
            }
        } else {
            str6 = str;
            str7 = str5;
        }
        if ((tn3Var instanceof rm3) && str6 != null && ((rm3) tn3Var).b(str6)) {
            return true;
        }
        InetAddress address = inetSocketAddress.getAddress();
        address.getClass();
        int iI0 = tj4.i0(address);
        int i2 = eb1.a;
        if ((iI0 > eb1.b || i2 > iI0) && (tn3Var instanceof wm3)) {
            InetAddress address2 = inetSocketAddress.getAddress();
            address2.getClass();
            if (((wm3) tn3Var).m(address2)) {
                return true;
            }
        }
        if ((tn3Var instanceof in3) && ji0.a0(((in3) tn3Var).b, str2)) {
            return true;
        }
        if ((tn3Var instanceof qn3) && ((qn3) tn3Var).c(str3, str4, list, on3Var, e03Var)) {
            return true;
        }
        if (tn3Var instanceof hn3) {
            if (((hn3) tn3Var).B(inetAddress != null ? tj4.f0(inetAddress) : null, num, inetSocketAddress.getPort(), i)) {
                return true;
            }
        }
        return (tn3Var instanceof rn3) && str7 != null && ji0.a0(((rn3) tn3Var).b, str7);
    }

    public static final void j(Jni jni, k93 k93Var, byte[] bArr) {
        bArr.getClass();
        jni.returnAsyncDnsResult(k93Var.X, bArr);
    }

    public static final void k(Jni jni, k93 k93Var, String str, DefaultDnsResponse defaultDnsResponse, byte[] bArr) {
        defaultDnsResponse.getClass();
        bArr.getClass();
        try {
            jni.h(defaultDnsResponse, str);
            defaultDnsResponse.release();
            jni.returnAsyncDnsResult(k93Var.X, bArr);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    defaultDnsResponse.release();
                } catch (Throwable th3) {
                    ek0.b(th, th3);
                }
                throw th2;
            }
        }
    }

    private final void logTraffic(int i, boolean z, long j, boolean z2) {
        dg4 dg4Var = dg4.a;
        if (!z) {
            j = -j;
        }
        dg4Var.a(j, i, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x042d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final byte[] onDnsQuery(byte[] r33) {
        /*
            Method dump skipped, instruction units count: 1087
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.vpn.Jni.onDnsQuery(byte[]):byte[]");
    }

    private final byte[] onDnsResponse(byte[] bArr) {
        String str;
        byte[] bArrD;
        tm3 tm3Var;
        String str2;
        String str3;
        String str4;
        String str5;
        DefaultDnsResponse defaultDnsResponseS = je.S(bArr);
        try {
            if (defaultDnsResponseS == null) {
                String str6 = "parseDnsResponse return null: " + bArr;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str6);
                    str5 = str6;
                } else {
                    str5 = str6;
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.e("Jni", str5, null);
                }
                bArrD = new byte[0];
            } else {
                DnsSection dnsSection = DnsSection.QUESTION;
                if (defaultDnsResponseS.count(dnsSection) > 0) {
                    String strName = defaultDnsResponseS.recordAt(dnsSection).name();
                    strName.getClass();
                    String strG0 = p44.G0(".", strName);
                    ArrayList arrayListE = je.E(defaultDnsResponseS);
                    String str7 = (String) this.d.get(Integer.valueOf(defaultDnsResponseS.id()));
                    if (str7 != null) {
                        String str8 = "DNS RESPONSE restore [" + str7 + "] to [" + ke0.J(strG0) + "]";
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str8);
                            str4 = str8;
                        } else {
                            str4 = str8;
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("Jni", str4, null);
                        }
                        DefaultDnsResponse defaultDnsResponseC0 = je.c0(defaultDnsResponseS, strG0, str7);
                        try {
                            h(defaultDnsResponseC0, strG0);
                            bArrD = je.D(defaultDnsResponseC0);
                            defaultDnsResponseC0.release();
                        } finally {
                        }
                    } else {
                        rs4 rs4Var = this.a.y0;
                        if (rs4Var.b == xw2.f || !rs4Var.Y || arrayListE.isEmpty()) {
                            h(defaultDnsResponseS, strG0);
                            bArrD = new byte[0];
                        } else {
                            Iterator it = arrayListE.iterator();
                            while (it.hasNext()) {
                                if (JniKt.b.contains((InetAddress) it.next())) {
                                    yw1 yw1Var = this.a;
                                    xw2 xw2Var = yw1Var.y0.b;
                                    ea3 ea3VarE = xw2Var == xw2.z ? e("Global Proxy") : (xw2Var != xw2.b || (tm3Var = yw1Var.j().K0) == null) ? null : e(tm3Var.b);
                                    if (ea3VarE != null) {
                                        InetAddress inetAddressZ = this.c.z(strG0);
                                        if (inetAddressZ != null) {
                                            this.l.add(new mm3(strG0, ea3VarE.getName(), false, false));
                                            String str9 = "DNS RESPONSE poison " + ke0.J(strG0) + "(" + d70.j0(arrayListE, null, null, null, new ji(16), 31) + ") return fake ip: " + tj4.f0(inetAddressZ);
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 3, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str9);
                                                str3 = str9;
                                            } else {
                                                str3 = str9;
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                a1.o("Jni", str3, null);
                                            }
                                            DefaultDnsResponse defaultDnsResponseB0 = je.b0(defaultDnsResponseS, strG0, inetAddressZ);
                                            try {
                                                h(defaultDnsResponseB0, strG0);
                                                bArrD = je.D(defaultDnsResponseB0);
                                                defaultDnsResponseB0.release();
                                            } finally {
                                            }
                                        } else {
                                            String str10 = "fakeIpMapper put failed: " + ke0.J(strG0);
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str10);
                                                str2 = str10;
                                            } else {
                                                str2 = str10;
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                a1.e("Jni", str2, null);
                                            }
                                            bArrD = new byte[0];
                                        }
                                    } else {
                                        h(defaultDnsResponseS, strG0);
                                        bArrD = new byte[0];
                                    }
                                }
                            }
                            h(defaultDnsResponseS, strG0);
                            bArrD = new byte[0];
                        }
                    }
                } else {
                    String str11 = "parseDnsQuery get domain failed: " + defaultDnsResponseS;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str11);
                        str = str11;
                    } else {
                        str = str11;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Jni", str, null);
                    }
                    bArrD = new byte[0];
                }
            }
            if (defaultDnsResponseS != null) {
                defaultDnsResponseS.release();
            }
            return bArrD;
        } finally {
        }
    }

    private final void onVpnStarted() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onVpnStarted() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("Jni", "onVpnStarted() called", null);
        }
        ((SurfboardVpn) this.a).getClass();
        e7.a(null, "vpn_start");
        ws4.b.i(Boolean.FALSE);
        final int i = 1;
        ws4.c.i(new vs4(this.a.j().b, true));
        final HashMap map = new HashMap();
        yw1 yw1Var = this.a;
        List list = yw1Var.y0.B0;
        final int i2 = 0;
        InetSocketAddress inetSocketAddress = list != null ? (InetSocketAddress) list.get(0) : yw1Var.j().X;
        if (inetSocketAddress != null) {
            Proxy.Type type = Proxy.Type.HTTP;
            final cm2 cm2Var = new cm2(type, inetSocketAddress);
            map.put(new Proxy(type, inetSocketAddress), null);
            ez4.X("localHttpProxy", new pl1() { // from class: q32
                @Override // defpackage.pl1
                public final Object a() {
                    int i3 = i2;
                    xl4 xl4Var = xl4.a;
                    HashMap map2 = map;
                    cm2 cm2Var2 = cm2Var;
                    switch (i3) {
                        case 0:
                            try {
                                cm2Var2.B();
                            } catch (BindException e) {
                                e.printStackTrace();
                                on2 on2Var = ws4.a;
                                on2 on2Var2 = ws4.f;
                                HashMap map3 = new HashMap(map2);
                                map3.put(new Proxy((Proxy.Type) cm2Var2.f, (InetSocketAddress) cm2Var2.z), e);
                                on2Var2.i(map3);
                            }
                            break;
                        default:
                            try {
                                cm2Var2.B();
                            } catch (BindException e2) {
                                e2.printStackTrace();
                                on2 on2Var3 = ws4.a;
                                on2 on2Var4 = ws4.f;
                                HashMap map4 = new HashMap(map2);
                                map4.put(new Proxy((Proxy.Type) cm2Var2.f, (InetSocketAddress) cm2Var2.z), e2);
                                on2Var4.i(map4);
                            }
                            break;
                    }
                    return xl4Var;
                    return xl4Var;
                }
            });
            this.m = cm2Var;
        }
        yw1 yw1Var2 = this.a;
        List list2 = yw1Var2.y0.B0;
        InetSocketAddress inetSocketAddress2 = list2 != null ? (InetSocketAddress) list2.get(1) : yw1Var2.j().Y;
        if (inetSocketAddress2 != null) {
            Proxy.Type type2 = Proxy.Type.SOCKS;
            final cm2 cm2Var2 = new cm2(type2, inetSocketAddress2);
            map.put(new Proxy(type2, inetSocketAddress2), null);
            ez4.X("localSocks5Proxy", new pl1() { // from class: q32
                @Override // defpackage.pl1
                public final Object a() {
                    int i3 = i;
                    xl4 xl4Var = xl4.a;
                    HashMap map2 = map;
                    cm2 cm2Var22 = cm2Var2;
                    switch (i3) {
                        case 0:
                            try {
                                cm2Var22.B();
                            } catch (BindException e) {
                                e.printStackTrace();
                                on2 on2Var = ws4.a;
                                on2 on2Var2 = ws4.f;
                                HashMap map3 = new HashMap(map2);
                                map3.put(new Proxy((Proxy.Type) cm2Var22.f, (InetSocketAddress) cm2Var22.z), e);
                                on2Var2.i(map3);
                            }
                            break;
                        default:
                            try {
                                cm2Var22.B();
                            } catch (BindException e2) {
                                e2.printStackTrace();
                                on2 on2Var3 = ws4.a;
                                on2 on2Var4 = ws4.f;
                                HashMap map4 = new HashMap(map2);
                                map4.put(new Proxy((Proxy.Type) cm2Var22.f, (InetSocketAddress) cm2Var22.z), e2);
                                on2Var4.i(map4);
                            }
                            break;
                    }
                    return xl4Var;
                    return xl4Var;
                }
            });
            this.n = cm2Var2;
        }
        ws4.f.i(map);
    }

    private final void onVpnStopped() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onVpnStopped() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("Jni", "onVpnStopped() called", null);
        }
        if (zw1.g != 0) {
            yw1 yw1Var = this.a;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - zw1.g;
            ((SurfboardVpn) yw1Var).getClass();
            Bundle bundle = new Bundle();
            bundle.putLong("duration", jElapsedRealtime);
            e7.a(bundle, "vpn_stop");
            zw1.g = 0L;
        }
        cm2 cm2Var = this.m;
        if (cm2Var != null) {
            ((NioEventLoopGroup) cm2Var.X).shutdownGracefully();
            ((NioEventLoopGroup) cm2Var.Y).shutdownGracefully();
        }
        cm2 cm2Var2 = this.n;
        if (cm2Var2 != null) {
            ((NioEventLoopGroup) cm2Var2.X).shutdownGracefully();
            ((NioEventLoopGroup) cm2Var2.Y).shutdownGracefully();
        }
        i94 i94Var = this.o;
        if (i94Var != null) {
            i94Var.j.shutdownGracefully();
            i94Var.k.shutdownGracefully();
        }
        ws4.f.i(h41.b);
        iv1 iv1Var = this.c;
        ((HashMap) iv1Var.f).clear();
        ((HashMap) iv1Var.z).clear();
        ((ConcurrentHashMap) iv1Var.A).clear();
        p95.e((ce0) iv1Var.X);
        this.b.clear();
        this.d.clear();
        this.j.clear();
        this.k.clear();
        this.l.clear();
        this.s.clear();
        synchronized (this.t) {
            d70.o0(this.t, new m32(this, 3));
        }
        ArrayList arrayList = a04.a;
        synchronized (arrayList) {
            d70.o0(arrayList, new ji(15));
        }
        this.e.b();
        ws4.d.i(Boolean.FALSE);
        this.a.stopSelf();
        ws4.c.i(new vs4());
    }

    private final boolean protect(int i) throws IllegalAccessException, InvocationTargetException {
        boolean zProtect;
        if (this.u != null) {
            try {
                FileDescriptor fileDescriptor = new FileDescriptor();
                zProtect = true;
                JniKt.c.invoke(fileDescriptor, Integer.valueOf(i));
                Network network = this.u;
                if (network != null) {
                    network.bindSocket(fileDescriptor);
                }
            } catch (IOException e) {
                e.printStackTrace();
                zProtect = this.a.protect(i);
            }
        } else {
            zProtect = this.a.protect(i);
        }
        if (!zProtect) {
            String strA = dw2.A(i, "protect failed: ");
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strA);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("Jni", strA, null);
            }
        }
        return zProtect;
    }

    private final native void returnAsyncDnsResult(int i, byte[] bArr);

    private final boolean shouldDecodeProxy(int i) {
        return this.j.contains(Integer.valueOf(i));
    }

    private final native void startVPN(int i, int i2, int i3, boolean z, boolean z2, boolean z3);

    private final native void stopVPN();

    private final void updateActiveConnectionCount(int i) {
        AtomicInteger atomicInteger = this.h;
        atomicInteger.set(i);
        ws4.e.i(Integer.valueOf(this.g.get() + atomicInteger.get()));
    }

    private final void writePcapRecord(byte[] bArr) {
        ha1 ha1Var = this.r;
        if (ha1Var == null || !((h14) ha1Var.f).W0.get()) {
            return;
        }
        bArr.getClass();
    }

    public final void a() {
        yw1 yw1Var;
        t53 t53Var;
        Object next;
        String str;
        vs4 vs4Var = (vs4) ws4.c.d();
        if (vs4Var == null || !vs4Var.b || (t53Var = (yw1Var = this.a).z) == null) {
            return;
        }
        e03 e03VarS = yw1Var.A0 == on3.z ? xb5.s() : new e03(0, 0);
        Collection collectionValues = t53Var.H0.values();
        collectionValues.getClass();
        ArrayList<la3> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (obj instanceof la3) {
                arrayList.add(obj);
            }
        }
        for (la3 la3Var : arrayList) {
            Set setEntrySet = la3Var.A.entrySet();
            setEntrySet.getClass();
            Iterator it = setEntrySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Map.Entry entry = (Map.Entry) next;
                entry.getClass();
                Object key = entry.getKey();
                key.getClass();
                yw1 yw1Var2 = this.a;
                if (((qn3) key).c(yw1Var2.C0, yw1Var2.D0, yw1Var2.B0, yw1Var2.A0, e03VarS)) {
                    break;
                }
            }
            Map.Entry entry2 = (Map.Entry) next;
            if (entry2 == null || (str = (String) entry2.getValue()) == null) {
                str = la3Var.z;
            }
            String str2 = (String) this.a.y0.f.get(la3Var.b);
            if (!n12.c(str, str2)) {
                StringBuilder sbE = fw.E("subnet group ", la3Var.b, " selection changed: ", str2, " -> ");
                sbE.append(str);
                String string = sbE.toString();
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("Jni", string, null);
                }
                yw1 yw1Var3 = this.a;
                String str3 = t53Var.b;
                String str4 = la3Var.b;
                ((SurfboardVpn) yw1Var3).getClass();
                str3.getClass();
                str4.getClass();
                str.getClass();
                ua3 ua3VarT = oj0.a.t();
                ke0.r(ua3VarT.a, false, true, new gj(16, ua3VarT, new sa3[]{new sa3(str3, str4, str)}));
                yw1 yw1Var4 = this.a;
                zw1.a(yw1Var4, yw1Var4.getClass(), t53Var.b, la3Var.b, str, false);
            }
        }
    }

    public final native String analyzeProtocol(int i, int i2);

    /* JADX WARN: Removed duplicated region for block: B:218:0x08c3  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x09a8  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x09af  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x09c2  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0915 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.s32 b(defpackage.t53 r42, int r43, java.lang.String r44, io.netty.handler.codec.dns.DnsRecord r45, io.netty.handler.codec.dns.DefaultDnsQuery r46, java.lang.String r47, int r48) {
        /*
            Method dump skipped, instruction units count: 3068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.vpn.Jni.b(t53, int, java.lang.String, io.netty.handler.codec.dns.DnsRecord, io.netty.handler.codec.dns.DefaultDnsQuery, java.lang.String, int):s32");
    }

    public final List c() {
        return (List) this.w.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10, types: [int] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.String] */
    public final String d(int i) {
        yw1 yw1Var = this.a;
        Integer numValueOf = Integer.valueOf((int) i);
        ConcurrentHashMap concurrentHashMap = this.s;
        Object obj = concurrentHashMap.get(numValueOf);
        ?? r4 = obj;
        if (obj == null) {
            if (i == -1) {
                i = "UNKNOWN(-1)";
            } else if (i == 0) {
                i = "ROOT";
            } else if (i == 1013) {
                i = "MEDIA_SERVER";
            } else if (i == 2000) {
                i = "SHELL";
            } else if (i == 1020) {
                i = "MDNSR";
            } else if (i == 1021) {
                i = "GPS";
            } else if (i == 1051) {
                i = "NETD";
            } else if (i != 1052) {
                switch (i) {
                    case 1000:
                        i = "SYSTEM";
                        break;
                    case 1001:
                        i = "PHONE";
                        break;
                    case 1002:
                        i = "BLUETOOTH";
                        break;
                    default:
                        try {
                            String[] packagesForUid = yw1Var.getPackageManager().getPackagesForUid(i);
                            if (packagesForUid == null || packagesForUid.length == 0) {
                                String nameForUid = yw1Var.getPackageManager().getNameForUid(i);
                                i = nameForUid == null ? "UNKNOWN(" + ((int) i) + ")" : nameForUid;
                            } else {
                                i = packagesForUid[0];
                            }
                        } catch (SecurityException e) {
                            e.printStackTrace();
                            i = "UNKNOWN(" + i + ")";
                        }
                        break;
                }
            } else {
                i = "DNS_TETHER";
            }
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(numValueOf, i);
            r4 = objPutIfAbsent == null ? i : objPutIfAbsent;
        }
        r4.getClass();
        return (String) r4;
    }

    public final ea3 e(String str) {
        yw1 yw1Var = this.a;
        return yw1Var.j().l(str, yw1Var.y0.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0230 A[PHI: r0 r6 r8
      0x0230: PHI (r0v18 java.lang.String) = (r0v17 java.lang.String), (r0v17 java.lang.String), (r0v48 java.lang.String) binds: [B:83:0x018d, B:85:0x019d, B:368:0x0230] A[DONT_GENERATE, DONT_INLINE]
      0x0230: PHI (r6v2 bh3) = (r6v1 bh3), (r6v1 bh3), (r6v8 bh3) binds: [B:83:0x018d, B:85:0x019d, B:368:0x0230] A[DONT_GENERATE, DONT_INLINE]
      0x0230: PHI (r8v5 java.net.InetSocketAddress) = (r8v4 java.net.InetSocketAddress), (r8v4 java.net.InetSocketAddress), (r8v23 java.net.InetSocketAddress) binds: [B:83:0x018d, B:85:0x019d, B:368:0x0230] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0657  */
    /* JADX WARN: Type inference failed for: r0v26, types: [ea3] */
    /* JADX WARN: Type inference failed for: r0v27, types: [ea3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r0v83 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v88 */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARN: Type inference failed for: r13v21, types: [ea3] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.Throwable, q93] */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.net.InetAddress] */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r2v113 */
    /* JADX WARN: Type inference failed for: r2v114 */
    /* JADX WARN: Type inference failed for: r2v115 */
    /* JADX WARN: Type inference failed for: r2v116 */
    /* JADX WARN: Type inference failed for: r2v117 */
    /* JADX WARN: Type inference failed for: r2v118 */
    /* JADX WARN: Type inference failed for: r2v119 */
    /* JADX WARN: Type inference failed for: r2v120 */
    /* JADX WARN: Type inference failed for: r2v121 */
    /* JADX WARN: Type inference failed for: r2v122 */
    /* JADX WARN: Type inference failed for: r2v123 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.q93 f(final defpackage.t93 r45) throws java.net.UnknownHostException {
        /*
            Method dump skipped, instruction units count: 1818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.vpn.Jni.f(t93):q93");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(io.netty.handler.codec.dns.DefaultDnsResponse r42, java.lang.String r43) throws java.net.UnknownHostException {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.vpn.Jni.h(io.netty.handler.codec.dns.DefaultDnsResponse, java.lang.String):void");
    }

    public final void l(Network network) {
        Handler handler;
        String str = "onNetworkConnected: " + network;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("Jni", str, null);
        }
        this.p.c = network;
        this.q.z = network;
        this.u = network;
        if (network == null || (handler = this.a.Y) == null) {
            return;
        }
        synchronized (this.t) {
            for (Runnable runnable : this.t) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000L);
            }
        }
    }

    public final boolean m(FileDescriptor fileDescriptor) throws IllegalAccessException, InvocationTargetException {
        boolean zProtect;
        Network network = this.u;
        if (network != null) {
            try {
                network.bindSocket(fileDescriptor);
                zProtect = true;
            } catch (IOException e) {
                e.printStackTrace();
                yw1 yw1Var = this.a;
                Object objInvoke = JniKt.d.invoke(fileDescriptor, null);
                objInvoke.getClass();
                zProtect = yw1Var.protect(((Integer) objInvoke).intValue());
            }
        } else {
            yw1 yw1Var2 = this.a;
            Object objInvoke2 = JniKt.d.invoke(fileDescriptor, null);
            objInvoke2.getClass();
            zProtect = yw1Var2.protect(((Integer) objInvoke2).intValue());
        }
        if (!zProtect) {
            String str = "protect failed: " + fileDescriptor;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("Jni", str, null);
            }
        }
        return zProtect;
    }

    public final void n(int i, int i2, boolean z, boolean z2) {
        int i3;
        ws4.h.i(Boolean.FALSE);
        this.f.start();
        XRay xRay = this.e;
        xRay.c = new t4(12);
        String xRayAddress = JniKt.getXRayAddress();
        LinkedHashSet linkedHashSetN = t53.n(this.a.j());
        yw1 yw1Var = this.a;
        rs4 rs4Var = yw1Var.y0;
        String strA = xRay.a(xRayAddress, linkedHashSetN, rs4Var.y0, rs4Var.z0, rs4Var.G0, rs4Var.H0, yw1Var.j(), this.a.y0.f);
        if (strA == null) {
            ws4.d.i(Boolean.TRUE);
        } else {
            String strConcat = "failed to start xray: ".concat(strA);
            if (fy4.b) {
                Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e("Jni", strConcat, null);
            }
        }
        ha1 ha1Var = this.r;
        if (ha1Var != null) {
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "SSHDumpServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "start");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("SSHDumpServer", "start", null);
            }
            h14 h14Var = (h14) ha1Var.f;
            try {
                i3 = 15000;
                new ServerSocket(15000, 1, InetAddress.getByName("0.0.0.0")).close();
            } catch (Exception e) {
                String strX = ha0.x(e.getLocalizedMessage(), " 15000");
                if (fy4.b) {
                    Xlog.logWrite2(0L, 3, "SocketUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strX);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.o("SocketUtils", strX, null);
                }
                i3 = 0;
            }
            h14Var.P0 = i3;
            h14 h14Var2 = (h14) ha1Var.f;
            if (h14Var2.isClosed()) {
                xe.q("Can not start the server again");
                return;
            }
            if (!h14Var2.W0.get()) {
                rn4 rn4Var = jt3.S;
                List list = h14Var2.y0;
                List list2 = Collections.EMPTY_LIST;
                if (ga5.u(list)) {
                    list = list2;
                }
                n12.h(list, "KeyExchangeFactories not set", new Object[0]);
                if (h14Var2.F0 == null) {
                    String strConcat2 = h14Var2.toString().concat("-timer");
                    ThreadLocal threadLocal = xd4.a;
                    h14Var2.F0 = new ScheduledThreadPoolExecutor(1, new k14(strConcat2));
                    h14Var2.G0 = true;
                }
                List list3 = h14Var2.z0;
                List list4 = Collections.EMPTY_LIST;
                if (ga5.u(list3)) {
                    list3 = list4;
                }
                n12.h(list3, "CipherFactories not set", new Object[0]);
                List list5 = h14Var2.A0;
                List list6 = Collections.EMPTY_LIST;
                if (ga5.u(list5)) {
                    list5 = list6;
                }
                n12.h(list5, "CompressionFactories not set", new Object[0]);
                List list7 = h14Var2.B0;
                List list8 = Collections.EMPTY_LIST;
                if (ga5.u(list7)) {
                    list7 = list8;
                }
                n12.h(list7, "MacFactories not set", new Object[0]);
                Objects.requireNonNull(h14Var2.D0, "RandomFactory not set");
                if (h14Var2.C0 == null) {
                    we2 we2Var = rl0.Y;
                    h14Var2.C0 = ql0.a;
                }
                int i4 = h14Var2.P0;
                n12.k(i4 >= 0, "Bad port number: %d", Integer.valueOf(i4));
                int i5 = it3.a;
                List list9 = h14Var2.R0;
                int iE = ga5.E(list9);
                List list10 = list9;
                if (iE <= 0) {
                    ArrayList arrayList = new ArrayList();
                    if (h14Var2.T0 != null) {
                        arrayList.add(jt3.R);
                        arrayList.add(rn4Var);
                    } else if (h14Var2.V0 != null) {
                        arrayList.add(rn4Var);
                    }
                    list10 = arrayList;
                    if (h14Var2.U0 != null) {
                        arrayList.add(jt3.Q);
                        list10 = arrayList;
                    }
                }
                n12.h(list10, "UserAuthFactories not set", new Object[0]);
                h14Var2.R0 = list10;
                n12.h(h14Var2.E0, "ChannelFactories not set", new Object[0]);
                Objects.requireNonNull(h14Var2.S0, "HostKeyProvider not set");
                Objects.requireNonNull(h14Var2.H0, "FileSystemFactory not set");
                if (ga5.u(h14Var2.I0)) {
                    h14Var2.I0 = h14.Y0;
                }
                if (h14Var2.Q0 == null) {
                    h14Var2.Q0 = new yt3();
                }
                synchronized (h14Var2.C0) {
                    h14Var2.C0.W0(h14Var2);
                }
                throw null;
            }
            ws4.g.i(Integer.valueOf(((h14) ha1Var.f).P0));
        }
        dg4 dg4Var = dg4.a;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "TrafficManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "start() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("TrafficManager", "start() called", null);
        }
        dg4.o = ez4.X("TrafficManager", new t4(27));
        new Handler(Looper.getMainLooper()).post(new n32(this, 0));
        rs4 rs4Var2 = this.a.y0;
        startVPN(i, rs4Var2.I0, i2, z, rs4Var2.F0, z2);
        if (strA != null) {
            p95.D(strA);
            p();
        }
    }

    public final i94 o() {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 0);
        dt dtVar = new dt(this);
        x12 x12Var = new x12(1, this, Jni.class, "getNameForUid", "getNameForUid(I)Ljava/lang/String;", 0, 1);
        m32 m32Var = new m32(this, 0);
        boolean z = false;
        cd cdVar = new cd(3, this);
        if (this.r != null) {
            z = true;
        }
        i94 i94Var = new i94(inetSocketAddress, dtVar, x12Var, m32Var, cdVar, z, new m32(this, 1), new m32(this, 2));
        this.o = i94Var;
        ez4.X("systemHttpProxy", new fn(9, i94Var));
        return i94Var;
    }

    public final void p() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "stop() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("Jni", "stop() called", null);
        }
        new Handler(Looper.getMainLooper()).post(new n32(this, 1));
        dg4 dg4Var = dg4.a;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "TrafficManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "stop() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("TrafficManager", "stop() called", null);
        }
        dg4.n = false;
        re2 re2Var = dg4.o;
        if (re2Var != null) {
            re2Var.interrupt();
        }
        dg4.o = null;
        f93 f93Var = this.f;
        f93Var.getClass();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProtectThread", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "stopThread() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProtectThread", "stopThread() called", null);
        }
        f93Var.z = false;
        LocalServerSocket localServerSocket = f93Var.f;
        if (localServerSocket != null) {
            try {
                Os.shutdown(localServerSocket.getFileDescriptor(), OsConstants.SHUT_RDWR);
            } catch (ErrnoException e) {
                e.printStackTrace();
            }
            f93Var.f = null;
        }
        ha1 ha1Var = this.r;
        if (ha1Var != null && !((h14) ha1Var.f).isClosed() && !((h14) ha1Var.f).X0()) {
            ez4.X("stop_sshdump", new fn(10, ha1Var));
        }
        ws4.g.i(null);
        tj4.n();
        xw0 xw0Var = this.p;
        p95.e(xw0Var.b);
        synchronized (xw0Var.d) {
            xw0Var.d.clear();
        }
        p95.e((ce0) this.q.f);
        stopVPN();
    }

    public final native void printAllTCPConnectionsInfo();

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.s32 q(defpackage.tn3 r21, boolean r22, java.lang.String r23, int r24, io.netty.handler.codec.dns.DefaultDnsQuery r25, io.netty.handler.codec.dns.DnsRecord r26, java.lang.String r27, int r28) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.vpn.Jni.q(tn3, boolean, java.lang.String, int, io.netty.handler.codec.dns.DefaultDnsQuery, io.netty.handler.codec.dns.DnsRecord, java.lang.String, int):s32");
    }

    public final native void resetAllTCPConnections();
}
