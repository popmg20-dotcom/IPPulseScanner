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
import com.getsurfboard.vpn.Jni;
import com.getsurfboard.vpn.JniKt;
import com.getsurfboard.xray.XRay;
import com.tencent.mars.xlog.Xlog;
import defpackage.a04;
import defpackage.bh3;
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
import defpackage.ej;
import defpackage.ek0;
import defpackage.ez4;
import defpackage.f70;
import defpackage.f93;
import defpackage.fm3;
import defpackage.fn;
import defpackage.fw;
import defpackage.fw4;
import defpackage.fx3;
import defpackage.fy4;
import defpackage.g;
import defpackage.g41;
import defpackage.ga1;
import defpackage.ga5;
import defpackage.ge0;
import defpackage.gj;
import defpackage.gx0;
import defpackage.h14;
import defpackage.h41;
import defpackage.ha0;
import defpackage.ha1;
import defpackage.hd;
import defpackage.hn3;
import defpackage.i1;
import defpackage.i12;
import defpackage.i93;
import defpackage.i94;
import defpackage.ia3;
import defpackage.ii3;
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
import defpackage.lb3;
import defpackage.le2;
import defpackage.li3;
import defpackage.m32;
import defpackage.m93;
import defpackage.ma3;
import defpackage.mm3;
import defpackage.ms4;
import defpackage.mu3;
import defpackage.n12;
import defpackage.n32;
import defpackage.n84;
import defpackage.n93;
import defpackage.na3;
import defpackage.o32;
import defpackage.oj0;
import defpackage.on3;
import defpackage.p44;
import defpackage.p93;
import defpackage.p95;
import defpackage.pl1;
import defpackage.q93;
import defpackage.q94;
import defpackage.qe;
import defpackage.ql0;
import defpackage.qn3;
import defpackage.r93;
import defpackage.re2;
import defpackage.rl0;
import defpackage.rm3;
import defpackage.rn3;
import defpackage.rn4;
import defpackage.rs4;
import defpackage.s32;
import defpackage.sa3;
import defpackage.ss1;
import defpackage.t32;
import defpackage.t4;
import defpackage.t53;
import defpackage.t93;
import defpackage.tj4;
import defpackage.tm1;
import defpackage.tm3;
import defpackage.tn;
import defpackage.tn3;
import defpackage.ts1;
import defpackage.tu0;
import defpackage.ua3;
import defpackage.us1;
import defpackage.v62;
import defpackage.vs1;
import defpackage.vs4;
import defpackage.w44;
import defpackage.we2;
import defpackage.wm3;
import defpackage.ws1;
import defpackage.ws4;
import defpackage.x12;
import defpackage.xb5;
import defpackage.xd4;
import defpackage.xe;
import defpackage.xh4;
import defpackage.xj;
import defpackage.xs1;
import defpackage.xw0;
import defpackage.xw2;
import defpackage.ye;
import defpackage.yr2;
import defpackage.ys1;
import defpackage.yt3;
import defpackage.yw1;
import defpackage.zi3;
import defpackage.zn;
import defpackage.zo2;
import defpackage.zt;
import defpackage.zw1;
import io.netty.buffer.ByteBuf;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.DefaultDnsQuery;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.dns.DnsOpCode;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.CharsetUtil;
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
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
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
    */
    public Jni(yw1 yw1Var) {
        tm1 tm1Var;
        yw1Var.getClass();
        this.a = yw1Var;
        this.b = new ConcurrentHashMap();
        this.c = new iv1(15);
        this.d = new ConcurrentHashMap();
        this.e = new XRay();
        this.f = new f93(yw1Var);
        final int i = 0;
        this.g = new AtomicInteger(0);
        this.h = new AtomicInteger(0);
        this.i = new zn(2, this);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.j = linkedHashSet;
        this.k = new HashMap();
        this.l = new LinkedHashSet();
        this.p = new xw0(JniKt.getDNSTimeout());
        this.q = new v62(2);
        this.r = yw1Var.y0.F0 ? new ha1(new ji(14)) : null;
        this.s = new ConcurrentHashMap();
        this.t = new ArrayList();
        this.v = new n84(new pl1(this) { // from class: p32
            public final /* synthetic */ Jni f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i2 = i;
                Jni jni = this.f;
                switch (i2) {
                    case 0:
                        yw1 yw1Var2 = jni.a;
                        LinkedHashMap linkedHashMap = yw1Var2.j().F0;
                        LinkedHashMap linkedHashMap2 = yw1Var2.y0.J0;
                        linkedHashMap.getClass();
                        linkedHashMap2.getClass();
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMap);
                        linkedHashMap3.putAll(linkedHashMap2);
                        return linkedHashMap3;
                    default:
                        yw1 yw1Var3 = jni.a;
                        List list = yw1Var3.y0.C0;
                        return (list == null || list.isEmpty()) ? yw1Var3.j().Z : list;
                }
            }
        });
        final int i2 = 1;
        this.w = new n84(new pl1(this) { // from class: p32
            public final /* synthetic */ Jni f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i22 = i2;
                Jni jni = this.f;
                switch (i22) {
                    case 0:
                        yw1 yw1Var2 = jni.a;
                        LinkedHashMap linkedHashMap = yw1Var2.j().F0;
                        LinkedHashMap linkedHashMap2 = yw1Var2.y0.J0;
                        linkedHashMap.getClass();
                        linkedHashMap2.getClass();
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMap);
                        linkedHashMap3.putAll(linkedHashMap2);
                        return linkedHashMap3;
                    default:
                        yw1 yw1Var3 = jni.a;
                        List list = yw1Var3.y0.C0;
                        return (list == null || list.isEmpty()) ? yw1Var3.j().Z : list;
                }
            }
        });
        try {
            int defaultPort = new URL(yw1Var.j().y0).getDefaultPort();
            if (defaultPort > 0) {
                linkedHashSet.add(Integer.valueOf(defaultPort));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        synchronized (this.t) {
            ArrayList arrayList = this.t;
            Collection<na3> collectionValues = this.a.j().H0.values();
            collectionValues.getClass();
            ArrayList arrayList2 = new ArrayList();
            for (na3 na3Var : collectionValues) {
                int i3 = 8;
                if (na3Var instanceof ma3) {
                    if (((ma3) na3Var).Z != null) {
                        try {
                            int defaultPort2 = new URL(((ma3) na3Var).Z).getDefaultPort();
                            if (defaultPort2 > 0) {
                                this.j.add(Integer.valueOf(defaultPort2));
                            }
                        } catch (MalformedURLException e2) {
                            e2.printStackTrace();
                        }
                    }
                    tm1Var = new tm1(i3, this, na3Var);
                    if (tm1Var == null) {
                        arrayList2.add(tm1Var);
                    }
                } else {
                    if (na3Var instanceof ia3) {
                        if (((ia3) na3Var).Z != null) {
                            try {
                                int defaultPort3 = new URL(((ia3) na3Var).Z).getDefaultPort();
                                if (defaultPort3 > 0) {
                                    this.j.add(Integer.valueOf(defaultPort3));
                                }
                            } catch (MalformedURLException e3) {
                                e3.printStackTrace();
                            }
                        }
                        tm1Var = new tm1(i3, this, na3Var);
                    } else {
                        tm1Var = null;
                    }
                    if (tm1Var == null) {
                    }
                }
            }
            arrayList.addAll(arrayList2);
        }
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
    */
    private final byte[] onDnsQuery(byte[] bArr) {
        byte[] bArr2;
        Throwable th;
        DnsSection dnsSection;
        DefaultDnsQuery defaultDnsQuery;
        String str;
        byte[] bArrJ;
        Object next;
        String str2;
        String str3;
        String str4;
        byte[] bArr3;
        byte[] bArr4;
        String str5;
        String str6;
        boolean z;
        String str7;
        String str8;
        i93 i93Var = k93.E0;
        i93Var.getClass();
        DefaultDnsQuery defaultDnsQuery2 = null;
        k93 k93Var = (k93) i93Var.c(bArr, 0, bArr.length, i1.a);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(k93Var.J(), k93Var.z0);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress(k93Var.H(), k93Var.B0);
        int iG = k93Var.Z;
        if (iG == -1 && Build.VERSION.SDK_INT >= 29) {
            iG = g(inetSocketAddress, inetSocketAddress2, OsConstants.IPPROTO_UDP);
        }
        int i = iG;
        String strD = d(i);
        String str9 = k93Var.H() + ":" + k93Var.B0;
        t53 t53VarJ = this.a.j();
        zt ztVar = k93Var.Y;
        int size = ztVar.size();
        if (size == 0) {
            bArr2 = i12.c;
        } else {
            byte[] bArr5 = new byte[size];
            ztVar.d(size, bArr5);
            bArr2 = bArr5;
        }
        bArr2.getClass();
        DefaultDnsQuery defaultDnsQueryR = je.R(bArr2);
        try {
        } catch (Throwable th2) {
            th = th2;
            defaultDnsQuery2 = defaultDnsQueryR;
        }
        if (defaultDnsQueryR != null) {
            try {
                dnsSection = DnsSection.QUESTION;
                try {
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                defaultDnsQuery2 = defaultDnsQueryR;
            }
            if (defaultDnsQueryR.count(dnsSection) > 0) {
                DnsRecord dnsRecordRecordAt = defaultDnsQueryR.recordAt(dnsSection, 0);
                String strName = dnsRecordRecordAt.name();
                strName.getClass();
                String strG0 = p44.G0(".", strName);
                Iterator it = t53VarJ.D0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    InetSocketAddress inetSocketAddress3 = (InetSocketAddress) next;
                    if (inetSocketAddress3.getPort() == 53 || inetSocketAddress3.isUnresolved()) {
                        z = false;
                    } else {
                        z = false;
                        if (w44.j0(str9, inetSocketAddress3.getHostString() + ":", false)) {
                            break;
                        }
                    }
                }
                InetSocketAddress inetSocketAddress4 = (InetSocketAddress) next;
                if (inetSocketAddress4 != null) {
                    String str10 = "(" + JniKt.a(k93Var.X) + ") DNS [" + strD + "] " + defaultDnsQueryR.opCode() + " " + dnsRecordRecordAt.type().name() + " [" + ke0.J(strG0) + "] using " + tj4.g0(inetSocketAddress4);
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str10);
                        str5 = "Jni";
                        str6 = str10;
                    } else {
                        str5 = "Jni";
                        str6 = str10;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d(str5, str6, null);
                    }
                    m93 m93VarU = n93.C0.u();
                    m93VarU.Z(JniKt.dnsStrategyServer());
                    String hostString = inetSocketAddress4.getHostString();
                    hostString.getClass();
                    m93VarU.z0 = hostString;
                    m93VarU.X |= 8;
                    m93VarU.S();
                    m93VarU.Y(inetSocketAddress4.getPort());
                    m93VarU.a0(i);
                    bArrJ = m93VarU.p().j();
                } else {
                    ge0 ge0Var = null;
                    defaultDnsQuery = defaultDnsQueryR;
                    s32 s32VarB = b(t53VarJ, k93Var.X, strG0, dnsRecordRecordAt, defaultDnsQuery, strD, i);
                    if (s32VarB.a == JniKt.dnsStrategyAsyncDns()) {
                        if (s32VarB.d) {
                            v62 v62Var = this.q;
                            zt ztVar2 = k93Var.Y;
                            int size2 = ztVar2.size();
                            if (size2 == 0) {
                                bArr4 = i12.c;
                            } else {
                                byte[] bArr6 = new byte[size2];
                                ztVar2.d(size2, bArr6);
                                bArr4 = bArr6;
                            }
                            bArr4.getClass();
                            gj gjVar = new gj(7, this, k93Var);
                            v62Var.getClass();
                            ji0.B((ce0) v62Var.f, null, null, new ej(v62Var, bArr4, gjVar, ge0Var, 5), 3);
                        } else {
                            String str11 = s32VarB.c;
                            List listX = str11 != null ? p95.x(str11) : c();
                            xw0 xw0Var = this.p;
                            zt ztVar3 = k93Var.Y;
                            int size3 = ztVar3.size();
                            if (size3 == 0) {
                                bArr3 = i12.c;
                            } else {
                                byte[] bArr7 = new byte[size3];
                                ztVar3.d(size3, bArr7);
                                bArr3 = bArr7;
                            }
                            bArr3.getClass();
                            o32 o32Var = new o32(this, k93Var, strG0);
                            xw0Var.getClass();
                            listX.getClass();
                            ji0.B(xw0Var.b, null, null, new hd(bArr3, xw0Var, listX, o32Var, null, 5), 3);
                        }
                    } else if (s32VarB.a != JniKt.dnsStrategyServer() && s32VarB.a != JniKt.dnsStrategyIP()) {
                        if (k93Var.H().equals(JniKt.getDnsPlaceholder0()) || k93Var.H().equals(JniKt.getDnsPlaceholder1())) {
                            String str12 = "(" + JniKt.a(k93Var.X) + ") DNS [" + strD + "] " + defaultDnsQuery.opCode() + " " + dnsRecordRecordAt.type().name() + " [" + ke0.J(strG0) + "] using system dns";
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str12);
                                str2 = str12;
                            } else {
                                str2 = str12;
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("Jni", str2, null);
                            }
                        } else {
                            String str13 = "(" + JniKt.a(k93Var.X) + ") DNS [" + strD + "] " + defaultDnsQuery.opCode() + " " + dnsRecordRecordAt.type().name() + " [" + ke0.J(strG0) + "] using " + str9;
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str13);
                                str3 = "Jni";
                                str4 = str13;
                            } else {
                                str3 = "Jni";
                                str4 = str13;
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d(str3, str4, null);
                            }
                        }
                    }
                    bArrJ = s32VarB.b.j();
                }
                th = th;
                try {
                    throw th;
                } finally {
                }
            } else {
                defaultDnsQuery = defaultDnsQueryR;
                String str14 = "(" + JniKt.a(k93Var.X) + ") DNS [" + strD + "] parseDnsQuery get domain failed: " + defaultDnsQuery;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str14);
                    str = str14;
                } else {
                    str = str14;
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.e("Jni", str, null);
                }
                bArrJ = JniKt.a;
            }
            if (defaultDnsQuery != null) {
                defaultDnsQuery.release();
            }
            return bArrJ;
        }
        String str15 = "(" + JniKt.a(k93Var.X) + ") DNS [" + strD + "] parseDnsQuery return null: " + bArr;
        if (fy4.b) {
            Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str15);
            str7 = "Jni";
            str8 = str15;
        } else {
            str7 = "Jni";
            str8 = str15;
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            a1.e(str7, str8, null);
        }
        bArrJ = JniKt.a;
        defaultDnsQuery = defaultDnsQueryR;
        if (defaultDnsQuery != null) {
        }
        return bArrJ;
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
    */
    public final s32 b(t53 t53Var, int i, String str, DnsRecord dnsRecord, DefaultDnsQuery defaultDnsQuery, String str2, int i2) {
        int i3;
        ?? r15;
        String str3;
        Iterator it;
        on3 on3Var;
        String str4;
        String str5;
        List list;
        Iterator it2;
        Object obj;
        Object obj2;
        ea3 ea3VarE;
        InetAddress inetAddressZ;
        String strZ;
        Object objPutIfAbsent;
        Object objPutIfAbsent2;
        Jni jni = this;
        String str6 = str;
        DnsRecord dnsRecord2 = dnsRecord;
        DefaultDnsQuery defaultDnsQuery2 = defaultDnsQuery;
        String str7 = str2;
        int i4 = i2;
        for (Map.Entry entry : ((Map) jni.v.getValue()).entrySet()) {
            ss1 ss1Var = (ss1) entry.getKey();
            ys1 ys1Var = (ys1) entry.getValue();
            if (ss1Var.b(str6)) {
                if (ys1Var instanceof vs1) {
                    ArrayList arrayList = ((vs1) ys1Var).b;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : arrayList) {
                        InetAddress inetAddress = (InetAddress) obj3;
                        DnsRecordType dnsRecordTypeType = dnsRecord2.type();
                        if (n12.c(dnsRecordTypeType, DnsRecordType.A) ? inetAddress instanceof Inet4Address : n12.c(dnsRecordTypeType, DnsRecordType.AAAA) ? inetAddress instanceof Inet6Address : false) {
                            arrayList2.add(obj3);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        String strA = JniKt.a(i);
                        DnsOpCode dnsOpCodeOpCode = defaultDnsQuery2.opCode();
                        String strName = dnsRecord2.type().name();
                        String strJ = ke0.J(str6);
                        String strJ0 = d70.j0(arrayList2, null, null, null, new ji(13), 31);
                        StringBuilder sbE = fw.E("(", strA, ") DNS [", str7, "] ");
                        sbE.append(dnsOpCodeOpCode);
                        sbE.append(" ");
                        sbE.append(strName);
                        sbE.append(" [");
                        String strZ2 = fw.z(sbE, strJ, "] map to ", strJ0);
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strZ2);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("Jni", strZ2, null);
                        }
                        ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList2));
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            arrayList3.add(new e03((InetAddress) it3.next(), 600L));
                        }
                        e03[] e03VarArr = (e03[]) arrayList3.toArray(new e03[0]);
                        byte[] bArrM = je.m(defaultDnsQuery2, dnsRecord2, (e03[]) Arrays.copyOf(e03VarArr, e03VarArr.length));
                        long jElapsedRealtime = SystemClock.elapsedRealtime() + 600000;
                        ArrayList arrayList4 = new ArrayList(f70.Q(10, arrayList2));
                        Iterator it4 = arrayList2.iterator();
                        while (it4.hasNext()) {
                            arrayList4.add(new gx0(jElapsedRealtime, str6, (InetAddress) it4.next()));
                        }
                        synchronized (jni.b) {
                            try {
                                ConcurrentHashMap concurrentHashMap = jni.b;
                                Object linkedHashSet = concurrentHashMap.get(str6);
                                if (linkedHashSet == null && (objPutIfAbsent2 = concurrentHashMap.putIfAbsent(str6, (linkedHashSet = new LinkedHashSet()))) != null) {
                                    linkedHashSet = objPutIfAbsent2;
                                }
                                ((LinkedHashSet) linkedHashSet).addAll(arrayList4);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        int iDnsStrategyIP = JniKt.dnsStrategyIP();
                        m93 m93VarU = n93.C0.u();
                        m93VarU.Z(JniKt.dnsStrategyIP());
                        m93VarU.Z = zt.c(0, bArrM.length, bArrM);
                        m93VarU.X |= 2;
                        m93VarU.S();
                        m93VarU.Y(53);
                        m93VarU.a0(i4);
                        return new s32(iDnsStrategyIP, m93VarU.p(), null, 12);
                    }
                } else {
                    if (!(ys1Var instanceof ts1)) {
                        String str8 = str7;
                        int i5 = i4;
                        if (ys1Var instanceof ws1) {
                            String strA2 = JniKt.a(i);
                            DnsOpCode dnsOpCodeOpCode2 = defaultDnsQuery2.opCode();
                            String strName2 = dnsRecord2.type().name();
                            String strJ2 = ke0.J(str6);
                            ws1 ws1Var = (ws1) ys1Var;
                            InetAddress address = ws1Var.b.getAddress();
                            address.getClass();
                            String strF0 = tj4.f0(address);
                            int port = ws1Var.b.getPort();
                            StringBuilder sbE2 = fw.E("(", strA2, ") DNS [", str8, "] ");
                            sbE2.append(dnsOpCodeOpCode2);
                            sbE2.append(" ");
                            sbE2.append(strName2);
                            sbE2.append(" [");
                            ha0.v(sbE2, strJ2, "] using ", strF0, ":");
                            sbE2.append(port);
                            String string = sbE2.toString();
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("Jni", string, null);
                            }
                            int iDnsStrategyServer = JniKt.dnsStrategyServer();
                            m93 m93VarU2 = n93.C0.u();
                            m93VarU2.Z(JniKt.dnsStrategyServer());
                            String hostAddress = ws1Var.b.getAddress().getHostAddress();
                            if (hostAddress == null) {
                                hostAddress = "";
                            }
                            m93VarU2.z0 = hostAddress;
                            m93VarU2.X = 8 | m93VarU2.X;
                            m93VarU2.S();
                            m93VarU2.Y(ws1Var.b.getPort());
                            m93VarU2.a0(i5);
                            return new s32(iDnsStrategyServer, m93VarU2.p(), null, 12);
                        }
                        if (ys1Var instanceof us1) {
                            String strA3 = JniKt.a(i);
                            DnsOpCode dnsOpCodeOpCode3 = defaultDnsQuery2.opCode();
                            String strName3 = dnsRecord2.type().name();
                            String strJ3 = ke0.J(str6);
                            us1 us1Var = (us1) ys1Var;
                            String str9 = us1Var.b;
                            StringBuilder sbE3 = fw.E("(", strA3, ") DNS [", str8, "] ");
                            sbE3.append(dnsOpCodeOpCode3);
                            sbE3.append(" ");
                            sbE3.append(strName3);
                            sbE3.append(" [");
                            sbE3.append(strJ3);
                            sbE3.append("] using doh-server(");
                            sbE3.append(str9);
                            sbE3.append(")");
                            String string2 = sbE3.toString();
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string2);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("Jni", string2, null);
                            }
                            int iDnsStrategyAsyncDns = JniKt.dnsStrategyAsyncDns();
                            m93 m93VarU3 = n93.C0.u();
                            m93VarU3.Z(JniKt.dnsStrategyAsyncDns());
                            m93VarU3.a0(i5);
                            return new s32(iDnsStrategyAsyncDns, m93VarU3.p(), us1Var.b, 8);
                        }
                        if (!(ys1Var instanceof xs1)) {
                            g.d();
                            return null;
                        }
                        String strA4 = JniKt.a(i);
                        DnsOpCode dnsOpCodeOpCode4 = defaultDnsQuery2.opCode();
                        String strName4 = dnsRecord2.type().name();
                        String strJ4 = ke0.J(str6);
                        StringBuilder sbE4 = fw.E("(", strA4, ") DNS [", str8, "] ");
                        sbE4.append(dnsOpCodeOpCode4);
                        sbE4.append(" ");
                        sbE4.append(strName4);
                        sbE4.append(" [");
                        String strY = fw.y(sbE4, strJ4, "] using system dns");
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strY);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("Jni", strY, null);
                        }
                        int iDnsStrategyServer2 = JniKt.dnsStrategyServer();
                        m93 m93VarU4 = n93.C0.u();
                        m93VarU4.Z(JniKt.dnsStrategyServer());
                        String dnsPlaceholder0 = JniKt.getDnsPlaceholder0();
                        dnsPlaceholder0.getClass();
                        m93VarU4.z0 = dnsPlaceholder0;
                        m93VarU4.X = 8 | m93VarU4.X;
                        m93VarU4.S();
                        m93VarU4.Y(53);
                        m93VarU4.a0(i5);
                        return new s32(iDnsStrategyServer2, m93VarU4.p(), null, 12);
                    }
                    String strA5 = JniKt.a(i);
                    DnsOpCode dnsOpCodeOpCode5 = defaultDnsQuery2.opCode();
                    String strName5 = dnsRecord2.type().name();
                    String strJ5 = ke0.J(str6);
                    ts1 ts1Var = (ts1) ys1Var;
                    String str10 = ts1Var.b;
                    StringBuilder sbE5 = fw.E("(", strA5, ") DNS [", str7, "] ");
                    sbE5.append(dnsOpCodeOpCode5);
                    sbE5.append(" ");
                    sbE5.append(strName5);
                    sbE5.append(" [");
                    sbE5.append(strJ5);
                    sbE5.append("] alias to [");
                    sbE5.append(str10);
                    sbE5.append("]");
                    String string3 = sbE5.toString();
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string3);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Jni", string3, null);
                    }
                    String str11 = str7;
                    int i6 = i4;
                    s32 s32VarB = jni.b(t53Var, i, ts1Var.b, dnsRecord2, defaultDnsQuery2, str11, i6);
                    if (s32VarB.a != JniKt.dnsStrategyDirect()) {
                        return s32VarB;
                    }
                    String str12 = ts1Var.b;
                    str12.getClass();
                    DefaultDnsQuery defaultDnsQuery3 = new DefaultDnsQuery(defaultDnsQuery2.id(), defaultDnsQuery2.opCode());
                    try {
                        defaultDnsQuery3.setRecursionDesired(defaultDnsQuery2.isRecursionDesired());
                        defaultDnsQuery3.setZ(defaultDnsQuery2.z());
                        defaultDnsQuery3.addRecord(DnsSection.QUESTION, (DnsRecord) new DefaultDnsQuestion(str12, dnsRecord2.type(), dnsRecord2.dnsClass()));
                        int iCount = defaultDnsQuery2.count(DnsSection.ADDITIONAL);
                        for (int i7 = 0; i7 < iCount; i7++) {
                            DnsSection dnsSection = DnsSection.ADDITIONAL;
                            DnsRecord dnsRecordRecordAt = defaultDnsQuery2.recordAt(dnsSection, i7);
                            dnsRecordRecordAt.getClass();
                            defaultDnsQuery3.addRecord(dnsSection, (DnsRecord) je.r(dnsRecordRecordAt));
                        }
                        byte[] bArrD = je.D(defaultDnsQuery3);
                        defaultDnsQuery3.release();
                        jni.d.put(Integer.valueOf(defaultDnsQuery2.id()), str6);
                        int iDnsStrategyAlias = JniKt.dnsStrategyAlias();
                        m93 m93VarU5 = n93.C0.u();
                        m93VarU5.Z(JniKt.dnsStrategyAlias());
                        m93VarU5.y0 = zt.c(0, bArrD.length, bArrD);
                        m93VarU5.X |= 4;
                        m93VarU5.S();
                        m93VarU5.Y(53);
                        m93VarU5.a0(i6);
                        return new s32(iDnsStrategyAlias, m93VarU5.p(), null, 12);
                    } finally {
                    }
                }
            }
            str7 = str7;
            i4 = i4;
        }
        String str13 = str7;
        int i8 = i4;
        String str14 = str13;
        if (n12.c(dnsRecord2.type(), DnsRecordType.A) || n12.c(dnsRecord2.type(), DnsRecordType.AAAA)) {
            str6.getClass();
            if (w44.d0(p44.G0(".", str6), ".local", true)) {
                String strA6 = JniKt.a(i);
                DnsOpCode dnsOpCodeOpCode6 = defaultDnsQuery2.opCode();
                String strName6 = dnsRecord2.type().name();
                String strJ6 = ke0.J(str6);
                StringBuilder sbE6 = fw.E("(", strA6, ") DNS [", str14, "] ");
                sbE6.append(dnsOpCodeOpCode6);
                sbE6.append(" ");
                sbE6.append(strName6);
                sbE6.append(" [");
                String strY2 = fw.y(sbE6, strJ6, "] using mdns");
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strY2);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("Jni", strY2, null);
                }
                int iDnsStrategyAsyncDns2 = JniKt.dnsStrategyAsyncDns();
                m93 m93VarU6 = n93.C0.u();
                m93VarU6.Z(JniKt.dnsStrategyAsyncDns());
                m93VarU6.a0(i8);
                return new s32(iDnsStrategyAsyncDns2, m93VarU6.p(), null, 4);
            }
        }
        LinkedHashSet linkedHashSetN = t53.n(t53Var);
        if (!linkedHashSetN.isEmpty()) {
            Iterator it5 = linkedHashSetN.iterator();
            while (it5.hasNext()) {
                if (n12.c(lb3.a((ea3) it5.next()), str6)) {
                    if (jni.c().isEmpty()) {
                        int iDnsStrategyDirect = JniKt.dnsStrategyDirect();
                        m93 m93VarU7 = n93.C0.u();
                        m93VarU7.Z(JniKt.dnsStrategyDirect());
                        m93VarU7.a0(i8);
                        return new s32(iDnsStrategyDirect, m93VarU7.p(), null, 12);
                    }
                    String strA7 = JniKt.a(i);
                    DnsOpCode dnsOpCodeOpCode7 = defaultDnsQuery2.opCode();
                    String strName7 = dnsRecord2.type().name();
                    String strJ7 = ke0.J(str6);
                    String strJ02 = d70.j0(jni.c(), null, null, null, null, 63);
                    StringBuilder sbE7 = fw.E("(", strA7, ") DNS [", str14, "] ");
                    sbE7.append(dnsOpCodeOpCode7);
                    sbE7.append(" ");
                    sbE7.append(strName7);
                    sbE7.append(" [");
                    sbE7.append(strJ7);
                    sbE7.append("] using doh-server(");
                    sbE7.append(strJ02);
                    sbE7.append(")");
                    String string4 = sbE7.toString();
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string4);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Jni", string4, null);
                    }
                    int iDnsStrategyAsyncDns3 = JniKt.dnsStrategyAsyncDns();
                    m93 m93VarU8 = n93.C0.u();
                    m93VarU8.Z(JniKt.dnsStrategyAsyncDns());
                    m93VarU8.a0(i8);
                    return new s32(iDnsStrategyAsyncDns3, m93VarU8.p(), null, 12);
                }
            }
        }
        tm3 tm3Var = t53Var.K0;
        ea3 ea3VarE2 = tm3Var != null ? jni.e(tm3Var.b) : null;
        if (zw1.h.contains(str6) && str14.equals(jni.a.getPackageName()) && (ea3VarE2 instanceof tu0)) {
            if (jni.c().isEmpty()) {
                int iDnsStrategyDirect2 = JniKt.dnsStrategyDirect();
                m93 m93VarU9 = n93.C0.u();
                m93VarU9.Z(JniKt.dnsStrategyDirect());
                m93VarU9.a0(i8);
                return new s32(iDnsStrategyDirect2, m93VarU9.p(), null, 12);
            }
            String strA8 = JniKt.a(i);
            DnsOpCode dnsOpCodeOpCode8 = defaultDnsQuery2.opCode();
            String strName8 = dnsRecord2.type().name();
            String strJ8 = ke0.J(str6);
            String strJ03 = d70.j0(jni.c(), null, null, null, null, 63);
            StringBuilder sbE8 = fw.E("(", strA8, ") DNS [", str14, "] ");
            sbE8.append(dnsOpCodeOpCode8);
            sbE8.append(" ");
            sbE8.append(strName8);
            sbE8.append(" [");
            sbE8.append(strJ8);
            sbE8.append("] using doh-server(");
            sbE8.append(strJ03);
            sbE8.append(")");
            String string5 = sbE8.toString();
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string5);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("Jni", string5, null);
            }
            int iDnsStrategyAsyncDns4 = JniKt.dnsStrategyAsyncDns();
            m93 m93VarU10 = n93.C0.u();
            m93VarU10.Z(JniKt.dnsStrategyAsyncDns());
            m93VarU10.a0(i8);
            return new s32(iDnsStrategyAsyncDns4, m93VarU10.p(), null, 12);
        }
        xw2 xw2Var = jni.a.y0.b;
        if (xw2Var == xw2.f) {
            int iDnsStrategyDirect3 = JniKt.dnsStrategyDirect();
            m93 m93VarU11 = n93.C0.u();
            m93VarU11.Z(JniKt.dnsStrategyDirect());
            m93VarU11.a0(i8);
            return new s32(iDnsStrategyDirect3, m93VarU11.p(), null, 12);
        }
        if (xw2Var == xw2.z) {
            ArrayList arrayList5 = t53Var.E0;
            if (arrayList5 == null || !arrayList5.isEmpty()) {
                Iterator it6 = arrayList5.iterator();
                while (it6.hasNext()) {
                    if (ji0.a0((String) it6.next(), str6)) {
                        break;
                    }
                }
                ea3VarE = jni.e("Global Proxy");
                if (ea3VarE != null && !(ea3VarE instanceof tu0) && !(ea3VarE instanceof fw4) && (inetAddressZ = jni.c.z(str6)) != null) {
                    String strA9 = JniKt.a(i);
                    DnsOpCode dnsOpCodeOpCode9 = defaultDnsQuery2.opCode();
                    String strName9 = dnsRecord2.type().name();
                    String strJ9 = ke0.J(str6);
                    String strF02 = tj4.f0(inetAddressZ);
                    StringBuilder sbE9 = fw.E("(", strA9, ") DNS [", str14, "] ");
                    sbE9.append(dnsOpCodeOpCode9);
                    sbE9.append(" ");
                    sbE9.append(strName9);
                    sbE9.append(" [");
                    strZ = fw.z(sbE9, strJ9, "] map to FAKE IP ", strF02);
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strZ);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Jni", strZ, null);
                    }
                    byte[] bArrM2 = je.m(defaultDnsQuery2, dnsRecord2, new e03(inetAddressZ, 600L));
                    gx0 gx0Var = new gx0(SystemClock.elapsedRealtime() + 600000, str6, inetAddressZ);
                    synchronized (jni.b) {
                        try {
                            ConcurrentHashMap concurrentHashMap2 = jni.b;
                            Object linkedHashSet2 = concurrentHashMap2.get(str6);
                            if (linkedHashSet2 == null && (objPutIfAbsent = concurrentHashMap2.putIfAbsent(str6, (linkedHashSet2 = new LinkedHashSet()))) != null) {
                                linkedHashSet2 = objPutIfAbsent;
                            }
                            ((LinkedHashSet) linkedHashSet2).addAll(yr2.k0(gx0Var));
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    int iDnsStrategyIP2 = JniKt.dnsStrategyIP();
                    m93 m93VarU12 = n93.C0.u();
                    m93VarU12.Z(JniKt.dnsStrategyIP());
                    m93VarU12.Z = zt.c(0, bArrM2.length, bArrM2);
                    m93VarU12.X |= 2;
                    m93VarU12.S();
                    m93VarU12.Y(53);
                    m93VarU12.a0(i8);
                    return new s32(iDnsStrategyIP2, m93VarU12.p(), null, 12);
                }
            } else {
                ea3VarE = jni.e("Global Proxy");
                if (ea3VarE != null) {
                    String strA92 = JniKt.a(i);
                    DnsOpCode dnsOpCodeOpCode92 = defaultDnsQuery2.opCode();
                    String strName92 = dnsRecord2.type().name();
                    String strJ92 = ke0.J(str6);
                    String strF022 = tj4.f0(inetAddressZ);
                    StringBuilder sbE92 = fw.E("(", strA92, ") DNS [", str14, "] ");
                    sbE92.append(dnsOpCodeOpCode92);
                    sbE92.append(" ");
                    sbE92.append(strName92);
                    sbE92.append(" [");
                    strZ = fw.z(sbE92, strJ92, "] map to FAKE IP ", strF022);
                    if (fy4.b) {
                    }
                    if (((Boolean) le2.a.a()).booleanValue()) {
                        Log.d("Jni", strZ, null);
                    }
                    byte[] bArrM22 = je.m(defaultDnsQuery2, dnsRecord2, new e03(inetAddressZ, 600L));
                    gx0 gx0Var2 = new gx0(SystemClock.elapsedRealtime() + 600000, str6, inetAddressZ);
                    synchronized (jni.b) {
                    }
                }
            }
        }
        Object obj4 = null;
        obj4 = null;
        ArrayList arrayList6 = t53Var.E0;
        if (arrayList6 == null || !arrayList6.isEmpty()) {
            Iterator it7 = arrayList6.iterator();
            while (it7.hasNext()) {
                if (ji0.a0((String) it7.next(), str6)) {
                    break;
                }
            }
            yw1 yw1Var = jni.a;
            boolean z = yw1Var.y0.A0;
            String str15 = yw1Var.C0;
            String str16 = yw1Var.D0;
            List list2 = yw1Var.B0;
            on3 on3Var2 = yw1Var.A0;
            e03 e03VarS = on3Var2 != on3.z ? xb5.s() : new e03(0, 0);
            it = t53Var.J0.iterator();
            while (it.hasNext()) {
                tn3 tn3Var = (tn3) it.next();
                if (tn3Var instanceof qn3) {
                    on3Var = on3Var2;
                    str4 = str15;
                    str5 = str16;
                    list = list2;
                    if (((qn3) tn3Var).c(str4, str5, list, on3Var, e03VarS)) {
                        s32 s32VarQ = jni.q(tn3Var, z, str6, i, defaultDnsQuery2, dnsRecord2, str14, i8);
                        if (s32VarQ != null) {
                            return s32VarQ;
                        }
                    }
                    str3 = str2;
                    i3 = i2;
                    r15 = obj4;
                } else {
                    on3Var = on3Var2;
                    str4 = str15;
                    str5 = str16;
                    list = list2;
                }
                tn3 tn3Var2 = tn3Var;
                boolean z2 = z;
                String str17 = str6;
                if ((tn3Var2 instanceof rm3) && ((rm3) tn3Var2).b(str17)) {
                    str3 = str2;
                    s32 s32VarQ2 = q(tn3Var2, z2, str17, i, defaultDnsQuery, dnsRecord, str3, i2);
                    if (s32VarQ2 != null) {
                        return s32VarQ2;
                    }
                    i3 = i2;
                    r15 = obj4;
                } else if (Build.VERSION.SDK_INT >= 30 && (tn3Var2 instanceof in3) && ji0.a0(((in3) tn3Var2).b, str2)) {
                    s32 s32VarQ3 = q(tn3Var2, z2, str, i, defaultDnsQuery, dnsRecord, str2, i2);
                    if (s32VarQ3 != null) {
                        return s32VarQ3;
                    }
                    str3 = str2;
                    i3 = i2;
                    r15 = obj4;
                } else {
                    if (tn3Var2 instanceof bn3) {
                        it2 = it;
                        Object obj5 = obj4;
                        boolean zU = fx3.u(tn3Var2, str2, str, null, str4, str5, list, on3Var, e03VarS, null, null, null, null, null, 0);
                        tn3Var2 = tn3Var2;
                        obj = obj5;
                        if (zU) {
                            s32 s32VarQ4 = q(tn3Var2, z2, str, i, defaultDnsQuery, dnsRecord, str2, i2);
                            obj2 = obj5;
                            if (s32VarQ4 != null) {
                                return s32VarQ4;
                            }
                        }
                        str3 = str2;
                        i3 = i2;
                        r15 = obj2;
                    } else {
                        it2 = it;
                        obj = obj4;
                    }
                    if (tn3Var2 instanceof jn3) {
                        for (tn3 tn3Var3 : ((jn3) tn3Var2).z) {
                            if ((tn3Var3 instanceof qn3) && ((qn3) tn3Var3).c(str4, str5, list, on3Var, e03VarS)) {
                                s32 s32VarQ5 = q(tn3Var2, z2, str, i, defaultDnsQuery, dnsRecord, str2, i2);
                                obj2 = obj;
                                if (s32VarQ5 != null) {
                                    return s32VarQ5;
                                }
                                str3 = str2;
                                i3 = i2;
                                r15 = obj2;
                            } else {
                                tn3 tn3Var4 = tn3Var2;
                                if ((tn3Var3 instanceof rm3) && ((rm3) tn3Var3).b(str)) {
                                    str3 = str2;
                                    i3 = i2;
                                    s32 s32VarQ6 = q(tn3Var3, z2, str, i, defaultDnsQuery, dnsRecord, str3, i3);
                                    r15 = obj;
                                    if (s32VarQ6 != null) {
                                        return s32VarQ6;
                                    }
                                } else {
                                    tn3Var2 = tn3Var4;
                                }
                            }
                        }
                    }
                    jni = this;
                    dnsRecord2 = dnsRecord;
                    defaultDnsQuery2 = defaultDnsQuery;
                    z = z2;
                    str14 = str2;
                    i8 = i2;
                    obj4 = obj;
                    str15 = str4;
                    str16 = str5;
                    list2 = list;
                    on3Var2 = on3Var;
                    it = it2;
                    str6 = str;
                }
            }
            i3 = i8;
            r15 = obj4;
            str3 = str14;
        } else {
            yw1 yw1Var2 = jni.a;
            boolean z3 = yw1Var2.y0.A0;
            String str152 = yw1Var2.C0;
            String str162 = yw1Var2.D0;
            List list22 = yw1Var2.B0;
            on3 on3Var22 = yw1Var2.A0;
            if (on3Var22 != on3.z) {
            }
            it = t53Var.J0.iterator();
            while (it.hasNext()) {
            }
            i3 = i8;
            r15 = obj4;
            str3 = str14;
        }
        if (c().isEmpty()) {
            int iDnsStrategyDirect4 = JniKt.dnsStrategyDirect();
            m93 m93VarU13 = n93.C0.u();
            m93VarU13.Z(JniKt.dnsStrategyDirect());
            m93VarU13.a0(i3);
            return new s32(iDnsStrategyDirect4, m93VarU13.p(), r15, 12);
        }
        String strA10 = JniKt.a(i);
        DnsOpCode dnsOpCodeOpCode10 = defaultDnsQuery.opCode();
        String strName10 = dnsRecord.type().name();
        String strJ10 = ke0.J(str);
        String strJ04 = d70.j0(c(), null, null, null, null, 63);
        StringBuilder sbE10 = fw.E("(", strA10, ") DNS [", str3, "] ");
        sbE10.append(dnsOpCodeOpCode10);
        sbE10.append(" ");
        sbE10.append(strName10);
        sbE10.append(" [");
        sbE10.append(strJ10);
        sbE10.append("] using doh-server(");
        sbE10.append(strJ04);
        sbE10.append(")");
        String string6 = sbE10.toString();
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string6);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("Jni", string6, r15);
        }
        int iDnsStrategyAsyncDns5 = JniKt.dnsStrategyAsyncDns();
        m93 m93VarU14 = n93.C0.u();
        m93VarU14.Z(JniKt.dnsStrategyAsyncDns());
        m93VarU14.a0(i3);
        return new s32(iDnsStrategyAsyncDns5, m93VarU14.p(), r15, 12);
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
    */
    public final q93 f(final t93 t93Var) throws UnknownHostException {
        String str;
        cm2 cm2Var;
        q93 q93Var;
        String strD;
        ?? ValueOf;
        ?? r16;
        String str2;
        bh3 bh3Var;
        InetSocketAddress inetSocketAddress;
        String str3;
        InetSocketAddress inetSocketAddress2;
        char c;
        int i;
        int i2;
        xw2 xw2Var;
        ea3 ea3VarE;
        ?? r0;
        boolean z;
        List list;
        tm3 tm3Var;
        ?? r02;
        ?? r2;
        ea3 ea3VarE2;
        String name;
        String name2;
        String strG0;
        String strQ;
        char c2;
        ea3 ea3VarE3;
        InetSocketAddress inetSocketAddress3;
        String strN;
        t53 t53VarJ = this.a.j();
        String strA = t93Var.N().length() > 0 ? xj.a(0, t93Var.N()) : "";
        InetAddress byName = InetAddress.getByName(t93Var.H());
        String strJ = t93Var.J();
        if (p44.x0(strJ)) {
            synchronized (this.b) {
                ConcurrentHashMap concurrentHashMap = this.b;
                byName.getClass();
                strN = ye.n(concurrentHashMap, byName);
            }
            str = strN;
        } else {
            str = strJ;
        }
        bh3 bh3Var2 = new bh3();
        InetSocketAddress inetSocketAddress4 = new InetSocketAddress(t93Var.O(), t93Var.A0);
        bh3Var2.b = inetSocketAddress4;
        cm2 cm2Var2 = this.m;
        if (cm2Var2 == null || (inetSocketAddress3 = (InetSocketAddress) ((Map) cm2Var2.Z).get(inetSocketAddress4)) == null) {
            cm2 cm2Var3 = this.n;
            if (cm2Var3 != null) {
                SocketAddress socketAddress = (SocketAddress) bh3Var2.b;
                socketAddress.getClass();
                InetSocketAddress inetSocketAddress5 = (InetSocketAddress) ((Map) cm2Var3.Z).get(socketAddress);
                if (inetSocketAddress5 != null) {
                    bh3Var2.b = inetSocketAddress5;
                    cm2Var = this.n;
                } else {
                    cm2Var = null;
                }
            }
        } else {
            bh3Var2.b = inetSocketAddress3;
            cm2Var = this.m;
        }
        InetSocketAddress inetSocketAddress6 = new InetSocketAddress(InetAddress.getByAddress(str, byName.getAddress()), t93Var.C0);
        int iG = t93Var.Z;
        int i3 = t93Var.Y;
        boolean z2 = i3 == OsConstants.IPPROTO_UDP || i3 == OsConstants.IPPROTO_TCP;
        if (iG == -1) {
            q93Var = null;
            if (Build.VERSION.SDK_INT >= 29 && z2) {
                iG = g((InetSocketAddress) bh3Var2.b, inetSocketAddress6, i3);
            }
        } else {
            q93Var = null;
        }
        int i4 = iG;
        if (strA.length() > 0) {
            strD = "Speedometer";
        } else if (cm2Var == null) {
            strD = d(i4);
        } else if (cm2Var.equals(this.m)) {
            strD = ha0.k("HttpProxy(", ((InetSocketAddress) cm2Var.z).getPort(), ")");
        } else {
            if (!cm2Var.equals(this.n)) {
                zo2.m(cm2Var, "unknown localProxy: ");
                return q93Var;
            }
            strD = ha0.k("Socks5Proxy(", ((InetSocketAddress) cm2Var.z).getPort(), ")");
        }
        String type = "";
        String strS = "";
        boolean zEquals = strD.equals(this.a.getPackageName());
        if (cm2Var != null) {
            InetAddress address = ((InetSocketAddress) bh3Var2.b).getAddress();
            ValueOf = Integer.valueOf(((InetSocketAddress) cm2Var.z).getPort());
            r16 = address;
        } else {
            q93 q93Var2 = q93Var;
            ValueOf = q93Var2;
            r16 = q93Var2;
        }
        if (zEquals && t93Var.Y == OsConstants.IPPROTO_TCP && d70.W(str, zw1.h)) {
            int iOrdinal = this.a.y0.b.ordinal();
            if (iOrdinal == 0) {
                c2 = 2;
                tm3 tm3Var2 = t53VarJ.K0;
                if (tm3Var2 != null) {
                    type = "FINAL";
                    strS = tm3Var2.b;
                    ea3VarE3 = e(strS);
                } else {
                    ea3VarE3 = lb3.a;
                }
            } else if (iOrdinal != 1) {
                c2 = 2;
                if (iOrdinal != 2) {
                    g.d();
                    return q93Var;
                }
                type = "OutboundMode";
                ea3 ea3VarE4 = e("Global Proxy");
                ea3VarE3 = ea3VarE4;
                if (ea3VarE4 == null) {
                    ea3VarE3 = lb3.a;
                }
            } else {
                c2 = 2;
                ea3VarE3 = lb3.a;
            }
            str3 = strD;
            bh3Var = bh3Var2;
            c = c2;
            inetSocketAddress2 = inetSocketAddress6;
            r2 = ea3VarE3;
        } else if (zEquals) {
            LinkedHashSet<ea3> linkedHashSetN = t53.n(this.a.j());
            if (linkedHashSetN.isEmpty()) {
                str2 = strD;
                bh3Var = bh3Var2;
                inetSocketAddress = inetSocketAddress6;
                if (strA.length() <= 0) {
                    ea3VarE2 = e(strA);
                    str3 = str2;
                    inetSocketAddress2 = inetSocketAddress;
                    c = 2;
                    r2 = ea3VarE2;
                } else {
                    ArrayList arrayList = t53VarJ.C0;
                    if (arrayList == null || !arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            str3 = str2;
                            inetSocketAddress2 = inetSocketAddress;
                            c = 2;
                            if (i((tn3) it.next(), t93Var.Y, str, r16, ValueOf, inetSocketAddress2, str3, null, null, g41.b, null, new e03(0, 0), null)) {
                                type = "skip-proxy";
                                r2 = lb3.a;
                                break;
                            }
                            inetSocketAddress = inetSocketAddress2;
                            str2 = str3;
                        }
                        str3 = str2;
                        inetSocketAddress2 = inetSocketAddress;
                        c = 2;
                        i = t93Var.Y;
                        i2 = OsConstants.IPPROTO_UDP;
                        if (i != i2 && t93Var.C0 == 53) {
                            r2 = lb3.a;
                        } else if (i == i2 || !byName.isMulticastAddress()) {
                            yw1 yw1Var = this.a;
                            xw2Var = yw1Var.y0.b;
                            if (xw2Var != xw2.f) {
                                type = "OutboundMode";
                                r2 = lb3.a;
                            } else {
                                if (xw2Var == xw2.z) {
                                    type = "OutboundMode";
                                    ea3 ea3VarE5 = e("Global Proxy");
                                    r02 = ea3VarE5;
                                    r02 = ea3VarE5;
                                    if (t93Var.Y == i2 && ea3VarE5 != null) {
                                        rs4 rs4Var = this.a.y0;
                                        boolean zA = ea3VarE5.A(t53VarJ, rs4Var.f, rs4Var.z0);
                                        r02 = ea3VarE5;
                                        if (!zA) {
                                            r02 = t53VarJ.B0;
                                        }
                                    }
                                } else {
                                    byte[] bArr = JniKt.a;
                                    if (t93Var.Y == OsConstants.IPPROTO_TCP && t93Var.C0 == 853) {
                                        r2 = lb3.b;
                                    } else {
                                        String str4 = yw1Var.C0;
                                        String str5 = yw1Var.D0;
                                        List list2 = yw1Var.B0;
                                        on3 on3Var = yw1Var.A0;
                                        e03 e03VarS = on3Var == on3.z ? xb5.s() : new e03(0, 0);
                                        String strP = t93Var.P();
                                        ?? r25 = strP.length() > 0 ? strP : q93Var;
                                        Iterator it2 = t53VarJ.J0.iterator();
                                        Object objE = q93Var;
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            tn3 tn3Var = (tn3) it2.next();
                                            List list3 = list2;
                                            on3 on3Var2 = on3Var;
                                            String str6 = str4;
                                            String str7 = str5;
                                            if (i(tn3Var, t93Var.Y, str, r16, ValueOf, inetSocketAddress2, str3, str6, str7, list3, on3Var2, e03VarS, r25)) {
                                                strS = tn3Var.S();
                                                objE = e(tn3Var.S());
                                                if (objE != null) {
                                                    type = tn3Var.getType();
                                                    break;
                                                }
                                                String str8 = "can not find proxy for rule " + tn3Var;
                                                if (fy4.b) {
                                                    Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str8);
                                                }
                                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                    a1.e("Jni", str8, q93Var);
                                                }
                                            }
                                            str4 = str6;
                                            str5 = str7;
                                            list2 = list3;
                                            on3Var = on3Var2;
                                            q93Var = null;
                                        }
                                        if (objE != null || (tm3Var = t53VarJ.K0) == null) {
                                            ea3VarE = null;
                                        } else {
                                            type = "FINAL";
                                            strS = tm3Var.b;
                                            ea3VarE = e(strS);
                                            objE = ea3VarE;
                                        }
                                        ?? r03 = objE;
                                        int i5 = t93Var.Y;
                                        int i6 = OsConstants.IPPROTO_UDP;
                                        if (i5 == i6 && t93Var.C0 == 443) {
                                            tn tnVarX = r03 != 0 ? r03.X() : null;
                                            int i7 = tnVarX == null ? -1 : t32.a[tnVarX.ordinal()];
                                            if (i7 != -1) {
                                                if (i7 != 1) {
                                                    if (i7 != 2) {
                                                        if (i7 != 3) {
                                                            g.d();
                                                            return null;
                                                        }
                                                        rs4 rs4Var2 = this.a.y0;
                                                        if (!r03.A(t53VarJ, rs4Var2.f, rs4Var2.z0)) {
                                                        }
                                                        z = r0 instanceof ii3;
                                                        r02 = r0;
                                                        if (!z) {
                                                        }
                                                    }
                                                    q93Var = null;
                                                    r0 = r03;
                                                    z = r0 instanceof ii3;
                                                    r02 = r0;
                                                    if (!z) {
                                                    }
                                                }
                                                q93Var = null;
                                                type = "block-quic";
                                                r0 = lb3.b;
                                                z = r0 instanceof ii3;
                                                r02 = r0;
                                                if (!z) {
                                                }
                                            }
                                        } else {
                                            q93Var = null;
                                            r0 = r03;
                                            z = r0 instanceof ii3;
                                            r02 = r0;
                                            if (!z) {
                                                r02 = r0;
                                                r02 = r0;
                                                if (t93Var.Y == i6 && r0 != 0) {
                                                    rs4 rs4Var3 = this.a.y0;
                                                    boolean zA2 = r0.A(t53VarJ, rs4Var3.f, rs4Var3.z0);
                                                    r02 = r0;
                                                    if (!zA2) {
                                                        if (!r0.equals(ea3VarE) || ((list = fm3.z) != null && list.isEmpty())) {
                                                            r02 = t53VarJ.B0;
                                                        } else {
                                                            Iterator it3 = list.iterator();
                                                            while (it3.hasNext()) {
                                                                if (((fm3) it3.next()).m(byName)) {
                                                                    r02 = lb3.a;
                                                                    break;
                                                                }
                                                            }
                                                            r02 = t53VarJ.B0;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                r2 = r02;
                            }
                        } else {
                            type = RtspHeaders.Values.MULTICAST;
                            r2 = lb3.a;
                        }
                    } else {
                        str3 = str2;
                        inetSocketAddress2 = inetSocketAddress;
                        c = 2;
                        i = t93Var.Y;
                        i2 = OsConstants.IPPROTO_UDP;
                        if (i != i2) {
                            if (i == i2) {
                                yw1 yw1Var2 = this.a;
                                xw2Var = yw1Var2.y0.b;
                                if (xw2Var != xw2.f) {
                                }
                            }
                        }
                    }
                }
            } else {
                for (ea3 ea3Var : linkedHashSetN) {
                    String strA2 = lb3.a(ea3Var);
                    Integer numB = lb3.b(ea3Var);
                    str2 = strD;
                    bh3Var = bh3Var2;
                    inetSocketAddress = inetSocketAddress6;
                    if ((numB != null && numB.intValue() == inetSocketAddress.getPort()) ? (str == null || !qe.t0(new String[]{strA2, ea3Var instanceof q94 ? ((q94) ea3Var).V() : q93Var, ea3Var instanceof ms4 ? (String) ((ms4) ea3Var).y0.get("Host") : ea3Var instanceof xh4 ? (String) ((xh4) ea3Var).Z.get("Host") : q93Var}).contains(str)) ? n12.c(strA2, inetSocketAddress.getHostString()) : true : false) {
                        ea3VarE2 = lb3.a;
                        break;
                    }
                    strD = str2;
                    inetSocketAddress6 = inetSocketAddress;
                    bh3Var2 = bh3Var;
                }
                str2 = strD;
                bh3Var = bh3Var2;
                inetSocketAddress = inetSocketAddress6;
                if (strA.length() <= 0) {
                }
            }
        }
        boolean z3 = r2 instanceof ii3;
        ?? r22 = r2;
        r22 = r2;
        if (z3 && zEquals) {
            r22 = r2;
            if (t93Var.Y != OsConstants.IPPROTO_UDP) {
                type = "SELF";
                r22 = lb3.a;
            }
        }
        ?? r13 = r22;
        String str9 = type;
        if (r13 == 0 || (name = r13.getName()) == null) {
            name = "DIRECT";
        }
        String str10 = (strS.length() == 0 || strS.equals(name)) ? "" : "in [" + ((Object) strS) + "]";
        final String str11 = str10;
        final String strO = (r13 == 0 || (strQ = r13.q()) == null) ? "" : ha0.o(" via [", strQ, "]");
        final String str12 = p44.x0(str9) ? "" : " hit " + ((Object) str9);
        String strL = t93Var.L();
        int length = strL.length();
        Object objAnalyzeProtocol = strL;
        if (length <= 0) {
            objAnalyzeProtocol = q93Var;
        }
        if (objAnalyzeProtocol == null) {
            objAnalyzeProtocol = analyzeProtocol(t93Var.Y, inetSocketAddress2.getPort());
        }
        final String str13 = name;
        final ?? r4 = objAnalyzeProtocol;
        String str14 = str;
        final InetSocketAddress inetSocketAddress7 = inetSocketAddress2;
        final String str15 = str3;
        ?? r15 = q93Var;
        final bh3 bh3Var3 = bh3Var;
        pl1 pl1Var = new pl1() { // from class: r32
            @Override // defpackage.pl1
            public final Object a() {
                t93 t93Var2 = t93Var;
                int i8 = t93Var2.Y;
                int i9 = OsConstants.IPPROTO_TCP;
                String str16 = r4;
                String str17 = str15;
                bh3 bh3Var4 = bh3Var3;
                InetSocketAddress inetSocketAddress8 = inetSocketAddress7;
                String str18 = str12;
                String str19 = str13;
                String str20 = strO;
                String str21 = str11;
                if (i8 == i9) {
                    String strA3 = JniKt.a(t93Var2.X);
                    String strG02 = tj4.g0((SocketAddress) bh3Var4.b);
                    String strG03 = tj4.g0(inetSocketAddress8);
                    StringBuilder sbE = fw.E("(", strA3, ") ", str16, " [");
                    ha0.v(sbE, str17, "] from ", strG02, " to ");
                    ha0.v(sbE, strG03, str18, " through [", str19);
                    sbE.append("]");
                    sbE.append(str20);
                    sbE.append(" ");
                    sbE.append(str21);
                    return sbE.toString();
                }
                if (i8 == OsConstants.IPPROTO_UDP) {
                    String strA4 = JniKt.a(t93Var2.X);
                    String strG04 = tj4.g0((SocketAddress) bh3Var4.b);
                    String strG05 = tj4.g0(inetSocketAddress8);
                    int i10 = t93Var2.D0;
                    StringBuilder sbE2 = fw.E("(", strA4, ") ", str16, " [");
                    ha0.v(sbE2, str17, "] from ", strG04, " to ");
                    sbE2.append(strG05);
                    sbE2.append(" length ");
                    sbE2.append(i10);
                    sbE2.append(str18);
                    ha0.v(sbE2, " through [", str19, "]", str20);
                    return fw.y(sbE2, " ", str21);
                }
                if (i8 != OsConstants.IPPROTO_ICMP) {
                    return "";
                }
                String strA5 = JniKt.a(t93Var2.X);
                String strG06 = tj4.g0(inetSocketAddress8);
                int i11 = t93Var2.D0;
                StringBuilder sbE3 = fw.E("(", strA5, ") ", str16, " [");
                ha0.v(sbE3, str17, "] to ", strG06, " length ");
                sbE3.append(i11);
                sbE3.append(str18);
                sbE3.append(" through [");
                sbE3.append(str19);
                sbE3.append("]");
                sbE3.append(str20);
                sbE3.append(" ");
                sbE3.append(str21);
                return sbE3.toString();
            }
        };
        boolean z4 = r13 instanceof ii3;
        if (z4) {
            String str16 = (String) pl1Var.a();
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str16);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.o("Jni", str16, r15);
            }
        } else {
            String str17 = (String) pl1Var.a();
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str17);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("Jni", str17, r15);
            }
        }
        if (t93Var.Y == OsConstants.IPPROTO_TCP) {
            if (t93Var.K().length() > 0) {
                strG0 = (t93Var.C0 == 80 ? t93Var.H() : t93Var.H() + ":" + t93Var.C0).concat(t93Var.K());
            } else {
                strG0 = tj4.g0(inetSocketAddress2);
            }
            SurfboardVpn surfboardVpn = (SurfboardVpn) this.a;
            surfboardVpn.getClass();
            r4.getClass();
            if (!str15.equals(surfboardVpn.getPackageName()) && !str15.equals("Speedometer")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String lowerCase = r4.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
                zi3 zi3Var = new zi3(0, jCurrentTimeMillis, str15, str13, str9, lowerCase + "://" + strG0);
                try {
                    Handler handler = surfboardVpn.Y;
                    if (handler != null) {
                        handler.post(new ga1(22, zi3Var));
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        p93 p93VarU = q93.B0.u();
        ArrayList arrayList2 = t53VarJ.E0;
        if (arrayList2 == null || !arrayList2.isEmpty()) {
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                if (ji0.a0((String) it4.next(), str14 == null ? "" : str14)) {
                    p93VarU.y0 = "";
                    p93VarU.X |= 4;
                    p93VarU.S();
                    break;
                }
            }
            p93VarU.y0 = str14 != null ? "" : str14;
            p93VarU.X |= 4;
            p93VarU.S();
        } else {
            p93VarU.y0 = str14 != null ? "" : str14;
            p93VarU.X |= 4;
            p93VarU.S();
        }
        p93VarU.Z = i4;
        p93VarU.X |= 2;
        p93VarU.S();
        if (r13 == 0 || (name2 = r13.getName()) == null) {
            name2 = "DIRECT";
        }
        p93VarU.z0 = name2;
        p93VarU.X |= 8;
        p93VarU.S();
        if (z4) {
            p93VarU.Y(JniKt.proxyReject());
        } else if (r13 instanceof tu0) {
            p93VarU.Y(JniKt.proxyDirect());
        } else if (r13 instanceof li3) {
            p93VarU.Y(JniKt.proxyRejectDrop());
        } else if (r13 instanceof mu3) {
            p93VarU.Y(JniKt.proxySocks5());
            XRay xRay = this.e;
            String str18 = ((mu3) r13).b;
            xRay.getClass();
            str18.getClass();
            Integer num = (Integer) xRay.a.get(str18);
            if (num == null) {
                xe.q("Required value was null.");
                return r15;
            }
            p93VarU.X(num.intValue());
        } else if (r13 != 0) {
            p93VarU.Y(JniKt.proxySocks5());
            XRay xRay2 = this.e;
            String strC = r13.C();
            xRay2.getClass();
            strC.getClass();
            Integer num2 = (Integer) xRay2.a.get(strC);
            if (num2 == null) {
                xe.q("Required value was null.");
                return r15;
            }
            p93VarU.X(num2.intValue());
        } else {
            p93VarU.Y(JniKt.proxyDirect());
        }
        q93 q93VarQ = p93VarU.q();
        if (q93VarQ.c()) {
            return q93VarQ;
        }
        throw defpackage.a1.C(q93VarQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(DefaultDnsResponse defaultDnsResponse, String str) throws UnknownHostException {
        Object objPutIfAbsent;
        DefaultDnsResponse defaultDnsResponse2 = defaultDnsResponse;
        HashSet hashSet = new HashSet();
        int iCount = defaultDnsResponse2.count(DnsSection.ANSWER);
        int i = 0;
        while (i < iCount) {
            DnsRecord dnsRecordRecordAt = defaultDnsResponse2.recordAt(DnsSection.ANSWER, i);
            boolean z = dnsRecordRecordAt instanceof DnsRawRecord;
            if (z) {
                DnsRawRecord dnsRawRecord = (DnsRawRecord) dnsRecordRecordAt;
                if (n12.c(dnsRawRecord.type(), DnsRecordType.A) || n12.c(dnsRawRecord.type(), DnsRecordType.AAAA)) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() + (dnsRawRecord.timeToLive() * 1000);
                    ByteBuf byteBufContent = dnsRawRecord.content();
                    byte[] bArr = new byte[byteBufContent.readableBytes()];
                    byteBufContent.getBytes(byteBufContent.readerIndex(), bArr);
                    InetAddress byAddress = InetAddress.getByAddress(bArr);
                    DnsOpCode dnsOpCodeOpCode = defaultDnsResponse2.opCode();
                    DnsResponseCode dnsResponseCodeCode = defaultDnsResponse2.code();
                    byAddress.getClass();
                    String str2 = "DNS RESPONSE " + dnsOpCodeOpCode + " " + dnsResponseCodeCode + " " + dnsRecordRecordAt + " " + tj4.f0(byAddress);
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Jni", str2, null);
                    }
                    hashSet.add(new gx0(jElapsedRealtime, str, byAddress));
                } else {
                    String string = "";
                    if (z) {
                        DnsRawRecord dnsRawRecord2 = (DnsRawRecord) dnsRecordRecordAt;
                        if (n12.c(dnsRawRecord2.type(), DnsRecordType.CNAME)) {
                            ByteBuf byteBufContent2 = dnsRawRecord2.content();
                            byteBufContent2.getClass();
                            int iWriterIndex = byteBufContent2.writerIndex();
                            int i2 = byteBufContent2.readableBytes();
                            if (i2 == 0) {
                                string = ".";
                            } else {
                                StringBuilder sb = new StringBuilder(i2 << 1);
                                int i3 = -1;
                                int i4 = 0;
                                while (byteBufContent2.isReadable()) {
                                    short unsignedByte = byteBufContent2.readUnsignedByte();
                                    if ((unsignedByte & 192) != 192) {
                                        if (unsignedByte == 0) {
                                            break;
                                        }
                                        if (!byteBufContent2.isReadable(unsignedByte)) {
                                            throw new CorruptedFrameException("truncated label in a name");
                                        }
                                        sb.append(byteBufContent2.toString(byteBufContent2.readerIndex(), unsignedByte, CharsetUtil.UTF_8));
                                        sb.append('.');
                                        byteBufContent2.skipBytes(unsignedByte);
                                    } else {
                                        if (i3 == -1) {
                                            i3 = byteBufContent2.readerIndex() + 1;
                                        }
                                        if (!byteBufContent2.isReadable()) {
                                            throw new CorruptedFrameException("truncated pointer in a name");
                                        }
                                        int unsignedByte2 = ((unsignedByte & 63) << 8) | byteBufContent2.readUnsignedByte();
                                        if (unsignedByte2 >= iWriterIndex) {
                                            throw new CorruptedFrameException("name has an out-of-range pointer");
                                        }
                                        byteBufContent2.readerIndex(unsignedByte2);
                                        i4 += 2;
                                        if (i4 >= iWriterIndex) {
                                            throw new CorruptedFrameException("name contains a loop.");
                                        }
                                    }
                                }
                                if (i3 != -1) {
                                    byteBufContent2.readerIndex(i3);
                                }
                                if (sb.length() != 0) {
                                    if (sb.charAt(sb.length() - 1) != '.') {
                                        sb.append('.');
                                    }
                                    string = sb.toString();
                                }
                            }
                        }
                    }
                    String str3 = "DNS RESPONSE " + defaultDnsResponse.opCode() + " " + defaultDnsResponse.code() + " " + dnsRecordRecordAt + " " + ((Object) string);
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Jni", str3, null);
                    }
                }
            }
            i++;
            defaultDnsResponse2 = defaultDnsResponse;
        }
        synchronized (this.b) {
            try {
                ConcurrentHashMap concurrentHashMap = this.b;
                Object linkedHashSet = concurrentHashMap.get(str);
                if (linkedHashSet == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str, (linkedHashSet = new LinkedHashSet()))) != null) {
                    linkedHashSet = objPutIfAbsent;
                }
                ((LinkedHashSet) linkedHashSet).addAll(hashSet);
            } catch (Throwable th) {
                throw th;
            }
        }
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
    */
    public final s32 q(tn3 tn3Var, boolean z, String str, int i, DefaultDnsQuery defaultDnsQuery, DnsRecord dnsRecord, String str2, int i2) {
        boolean z2;
        InetAddress inetAddressZ;
        Object objPutIfAbsent;
        ea3 ea3VarE = e(tn3Var.S());
        if (!(ea3VarE instanceof tu0) && !(ea3VarE instanceof fw4)) {
            if (tn3Var instanceof rm3) {
                if (!z) {
                    rm3 rm3Var = (rm3) tn3Var;
                    if (!rm3Var.G() && !rm3Var.x()) {
                        z2 = false;
                    }
                }
                z2 = true;
            } else if (Build.VERSION.SDK_INT < 30 || !(tn3Var instanceof in3)) {
                z2 = z;
            } else {
                if (!z) {
                    in3 in3Var = (in3) tn3Var;
                    if (in3Var.A || in3Var.z) {
                    }
                }
                z2 = true;
            }
            if (z2 && (inetAddressZ = this.c.z(str)) != null) {
                String strA = JniKt.a(i);
                DnsOpCode dnsOpCodeOpCode = defaultDnsQuery.opCode();
                String strName = dnsRecord.type().name();
                String strJ = ke0.J(str);
                String strF0 = tj4.f0(inetAddressZ);
                StringBuilder sbE = fw.E("(", strA, ") DNS [", str2, "] ");
                sbE.append(dnsOpCodeOpCode);
                sbE.append(" ");
                sbE.append(strName);
                sbE.append(" [");
                String strZ = fw.z(sbE, strJ, "] map to FAKE IP ", strF0);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strZ);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("Jni", strZ, null);
                }
                byte[] bArrM = je.m(defaultDnsQuery, dnsRecord, new e03(inetAddressZ, 600L));
                gx0 gx0Var = new gx0(SystemClock.elapsedRealtime() + 600000, str, inetAddressZ);
                synchronized (this.b) {
                    try {
                        ConcurrentHashMap concurrentHashMap = this.b;
                        Object linkedHashSet = concurrentHashMap.get(str);
                        if (linkedHashSet == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str, (linkedHashSet = new LinkedHashSet()))) != null) {
                            linkedHashSet = objPutIfAbsent;
                        }
                        ((LinkedHashSet) linkedHashSet).addAll(yr2.k0(gx0Var));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                int iDnsStrategyIP = JniKt.dnsStrategyIP();
                m93 m93VarU = n93.C0.u();
                m93VarU.Z(JniKt.dnsStrategyIP());
                m93VarU.Z = zt.c(0, bArrM.length, bArrM);
                m93VarU.X |= 2;
                m93VarU.S();
                m93VarU.Y(53);
                m93VarU.a0(i2);
                return new s32(iDnsStrategyIP, m93VarU.p(), null, 12);
            }
        }
        return null;
    }

    public final native void resetAllTCPConnections();
}
