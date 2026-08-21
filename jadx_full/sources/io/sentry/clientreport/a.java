package io.sentry.clientreport;

import com.tencent.mars.xlog.Xlog;
import defpackage.ha0;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.ILogger;
import io.sentry.m3;
import io.sentry.p5;
import io.sentry.protocol.g;
import io.sentry.protocol.g0;
import io.sentry.protocol.h;
import io.sentry.protocol.j;
import io.sentry.protocol.k;
import io.sentry.protocol.m;
import io.sentry.protocol.q;
import io.sentry.protocol.s;
import io.sentry.protocol.w;
import io.sentry.protocol.y;
import io.sentry.t3;
import io.sentry.x1;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements x1 {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
        this.a = i;
    }

    public static io.sentry.protocol.a b(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        io.sentry.protocol.a aVar = new io.sentry.protocol.a();
        ConcurrentHashMap concurrentHashMap = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            strR = m3Var.R();
            strR.getClass();
            switch (strR) {
                case "split_names":
                    List list = (List) m3Var.o0();
                    if (list == null) {
                        break;
                    } else {
                        aVar.D0 = list;
                        break;
                    }
                    break;
                case "device_app_hash":
                    aVar.z = m3Var.G();
                    break;
                case "start_type":
                    aVar.A0 = m3Var.G();
                    break;
                case "view_names":
                    List list2 = (List) m3Var.o0();
                    if (list2 == null) {
                        break;
                    } else {
                        aVar.z0 = list2;
                        break;
                    }
                    break;
                case "app_version":
                    aVar.Y = m3Var.G();
                    break;
                case "in_foreground":
                    aVar.B0 = m3Var.b0();
                    break;
                case "build_type":
                    aVar.A = m3Var.G();
                    break;
                case "app_identifier":
                    aVar.b = m3Var.G();
                    break;
                case "app_start_time":
                    aVar.f = m3Var.Y(iLogger);
                    break;
                case "permissions":
                    aVar.y0 = io.sentry.util.b.o((Map) m3Var.o0());
                    break;
                case "app_name":
                    aVar.X = m3Var.G();
                    break;
                case "app_build":
                    aVar.Z = m3Var.G();
                    break;
                case "is_split_apks":
                    aVar.C0 = m3Var.b0();
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    m3Var.w(iLogger, concurrentHashMap, strR);
                    break;
            }
        }
        aVar.E0 = concurrentHashMap;
        m3Var.V();
        return aVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static io.sentry.protocol.e c(m3 m3Var, ILogger iLogger) {
        byte b;
        String strR;
        String strR2;
        String strR3;
        io.sentry.protocol.e eVar = new io.sentry.protocol.e();
        m3Var.p0();
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            String strR4 = m3Var.R();
            strR4.getClass();
            int i = 11;
            switch (strR4.hashCode()) {
                case -1335157162:
                    b = !strR4.equals("device") ? (byte) -1 : (byte) 0;
                    break;
                case -895679987:
                    b = !strR4.equals("spring") ? (byte) -1 : (byte) 1;
                    break;
                case -340323263:
                    b = !strR4.equals("response") ? (byte) -1 : (byte) 2;
                    break;
                case -309425751:
                    b = !strR4.equals("profile") ? (byte) -1 : (byte) 3;
                    break;
                case -191501435:
                    b = !strR4.equals("feedback") ? (byte) -1 : (byte) 4;
                    break;
                case 3556:
                    b = !strR4.equals("os") ? (byte) -1 : (byte) 5;
                    break;
                case 96801:
                    b = !strR4.equals("app") ? (byte) -1 : (byte) 6;
                    break;
                case 96867:
                    b = !strR4.equals("art") ? (byte) -1 : (byte) 7;
                    break;
                case 102572:
                    b = !strR4.equals("gpu") ? (byte) -1 : (byte) 8;
                    break;
                case 97513095:
                    b = !strR4.equals("flags") ? (byte) -1 : (byte) 9;
                    break;
                case 110620997:
                    b = !strR4.equals("trace") ? (byte) -1 : (byte) 10;
                    break;
                case 150940456:
                    b = !strR4.equals("browser") ? (byte) -1 : (byte) 11;
                    break;
                case 1550962648:
                    b = !strR4.equals("runtime") ? (byte) -1 : (byte) 12;
                    break;
                default:
                    b = -1;
                    break;
            }
            ArrayList arrayList = null;
            switch (b) {
                case 0:
                    eVar.o(d(m3Var, iLogger));
                    break;
                case 1:
                    m3Var.p0();
                    g0 g0Var = new g0();
                    ConcurrentHashMap concurrentHashMap = null;
                    while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                        String strR5 = m3Var.R();
                        strR5.getClass();
                        if (strR5.equals("active_profiles")) {
                            List list = (List) m3Var.o0();
                            if (list != null) {
                                String[] strArr = new String[list.size()];
                                list.toArray(strArr);
                                g0Var.b = strArr;
                            }
                        } else {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            m3Var.w(iLogger, concurrentHashMap, strR5);
                        }
                    }
                    g0Var.f = concurrentHashMap;
                    m3Var.V();
                    eVar.u(g0Var);
                    break;
                case 2:
                    m3Var.p0();
                    s sVar = new s();
                    ConcurrentHashMap concurrentHashMap2 = null;
                    while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                        strR = m3Var.R();
                        strR.getClass();
                        switch (strR) {
                            case "status_code":
                                sVar.z = m3Var.u();
                                break;
                            case "data":
                                sVar.X = m3Var.o0();
                                break;
                            case "headers":
                                Map map = (Map) m3Var.o0();
                                if (map != null) {
                                    sVar.f = io.sentry.util.b.o(map);
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "cookies":
                                sVar.b = m3Var.G();
                                break;
                            case "body_size":
                                sVar.A = m3Var.y();
                                break;
                            default:
                                if (concurrentHashMap2 == null) {
                                    concurrentHashMap2 = new ConcurrentHashMap();
                                }
                                m3Var.w(iLogger, concurrentHashMap2, strR);
                                break;
                        }
                    }
                    sVar.Y = concurrentHashMap2;
                    m3Var.V();
                    eVar.s(sVar);
                    break;
                case 3:
                    m3Var.p0();
                    t3 t3Var = new t3(w.f);
                    ConcurrentHashMap concurrentHashMap3 = null;
                    while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                        String strR6 = m3Var.R();
                        strR6.getClass();
                        if (strR6.equals("profiler_id")) {
                            w wVar = (w) m3Var.m0(iLogger, new a(23));
                            if (wVar != null) {
                                t3Var.b = wVar;
                            }
                        } else {
                            if (concurrentHashMap3 == null) {
                                concurrentHashMap3 = new ConcurrentHashMap();
                            }
                            m3Var.w(iLogger, concurrentHashMap3, strR6);
                        }
                    }
                    t3Var.f = concurrentHashMap3;
                    m3Var.V();
                    eVar.k(t3Var, "profile");
                    break;
                case 4:
                    eVar.k(e(m3Var, iLogger), "feedback");
                    break;
                case 5:
                    eVar.r(g(m3Var, iLogger));
                    break;
                case 6:
                    eVar.m(b(m3Var, iLogger));
                    break;
                case 7:
                    m3Var.p0();
                    io.sentry.protocol.c cVar = new io.sentry.protocol.c();
                    ConcurrentHashMap concurrentHashMap4 = null;
                    while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                        strR2 = m3Var.R();
                        strR2.getClass();
                        switch (strR2) {
                            case "gc.total_time":
                                cVar.f = m3Var.O();
                                break;
                            case "memory.free_until_gc":
                                cVar.y0 = m3Var.y();
                                break;
                            case "gc.blocking_time":
                                cVar.A = m3Var.O();
                                break;
                            case "gc.waiting_time":
                                cVar.Y = m3Var.O();
                                break;
                            case "memory.free_until_oome":
                                cVar.z0 = m3Var.y();
                                break;
                            case "memory.total":
                                cVar.A0 = m3Var.y();
                                break;
                            case "gc.pre_oome_count":
                                cVar.X = m3Var.y();
                                break;
                            case "memory.free":
                                cVar.Z = m3Var.y();
                                break;
                            case "gc.blocking_count":
                                cVar.z = m3Var.y();
                                break;
                            case "gc.total_count":
                                cVar.b = m3Var.y();
                                break;
                            case "memory.max":
                                cVar.B0 = m3Var.y();
                                break;
                            default:
                                if (concurrentHashMap4 == null) {
                                    concurrentHashMap4 = new ConcurrentHashMap();
                                }
                                m3Var.w(iLogger, concurrentHashMap4, strR2);
                                break;
                        }
                    }
                    cVar.C0 = concurrentHashMap4;
                    m3Var.V();
                    eVar.k(cVar, "art");
                    break;
                case 8:
                    eVar.q(f(m3Var, iLogger));
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    m3Var.p0();
                    ConcurrentHashMap concurrentHashMap5 = null;
                    while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                        String strR7 = m3Var.R();
                        strR7.getClass();
                        if (strR7.equals("values")) {
                            arrayList = m3Var.y0(iLogger, new a(i));
                        } else {
                            if (concurrentHashMap5 == null) {
                                concurrentHashMap5 = new ConcurrentHashMap();
                            }
                            m3Var.w(iLogger, concurrentHashMap5, strR7);
                        }
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    j jVar = new j(arrayList);
                    jVar.f = concurrentHashMap5;
                    m3Var.V();
                    eVar.p(jVar);
                    break;
                case 10:
                    eVar.v(io.sentry.f.b(m3Var, iLogger));
                    break;
                case 11:
                    m3Var.p0();
                    io.sentry.protocol.d dVar = new io.sentry.protocol.d();
                    ConcurrentHashMap concurrentHashMap6 = null;
                    while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                        String strR8 = m3Var.R();
                        strR8.getClass();
                        if (strR8.equals("name")) {
                            dVar.b = m3Var.G();
                        } else if (strR8.equals("version")) {
                            dVar.f = m3Var.G();
                        } else {
                            if (concurrentHashMap6 == null) {
                                concurrentHashMap6 = new ConcurrentHashMap();
                            }
                            m3Var.w(iLogger, concurrentHashMap6, strR8);
                        }
                    }
                    dVar.z = concurrentHashMap6;
                    m3Var.V();
                    eVar.n(dVar);
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    m3Var.p0();
                    y yVar = new y();
                    ConcurrentHashMap concurrentHashMap7 = null;
                    while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                        strR3 = m3Var.R();
                        strR3.getClass();
                        switch (strR3) {
                            case "raw_description":
                                yVar.z = m3Var.G();
                                break;
                            case "name":
                                yVar.b = m3Var.G();
                                break;
                            case "version":
                                yVar.f = m3Var.G();
                                break;
                            default:
                                if (concurrentHashMap7 == null) {
                                    concurrentHashMap7 = new ConcurrentHashMap();
                                }
                                m3Var.w(iLogger, concurrentHashMap7, strR3);
                                break;
                        }
                    }
                    yVar.A = concurrentHashMap7;
                    m3Var.V();
                    eVar.t(yVar);
                    break;
                default:
                    Object objO0 = m3Var.o0();
                    if (objO0 != null) {
                        eVar.k(objO0, strR4);
                    }
                    break;
            }
        }
        m3Var.V();
        return eVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static h d(m3 m3Var, ILogger iLogger) {
        m3Var.p0();
        h hVar = new h();
        ConcurrentHashMap concurrentHashMap = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            String strR = m3Var.R();
            strR.getClass();
            int i = 10;
            byte b = -1;
            switch (strR.hashCode()) {
                case -2076227591:
                    if (strR.equals("timezone")) {
                        b = 0;
                    }
                    break;
                case -2012489734:
                    if (strR.equals("boot_time")) {
                        b = 1;
                    }
                    break;
                case -1981332476:
                    if (strR.equals("simulator")) {
                        b = 2;
                    }
                    break;
                case -1969347631:
                    if (strR.equals("manufacturer")) {
                        b = 3;
                    }
                    break;
                case -1608004830:
                    if (strR.equals("processor_count")) {
                        b = 4;
                    }
                    break;
                case -1439500848:
                    if (strR.equals("orientation")) {
                        b = 5;
                    }
                    break;
                case -1410521534:
                    if (strR.equals("battery_temperature")) {
                        b = 6;
                    }
                    break;
                case -1281860764:
                    if (strR.equals("family")) {
                        b = 7;
                    }
                    break;
                case -1097462182:
                    if (strR.equals("locale")) {
                        b = 8;
                    }
                    break;
                case -1012222381:
                    if (strR.equals("online")) {
                        b = 9;
                    }
                    break;
                case -877252910:
                    if (strR.equals("battery_level")) {
                        b = 10;
                    }
                    break;
                case -619038223:
                    if (strR.equals("model_id")) {
                        b = 11;
                    }
                    break;
                case -568274923:
                    if (strR.equals("screen_density")) {
                        b = 12;
                    }
                    break;
                case -417046774:
                    if (strR.equals("screen_dpi")) {
                        b = HttpConstants.CR;
                    }
                    break;
                case -136523212:
                    if (strR.equals("free_memory")) {
                        b = 14;
                    }
                    break;
                case 3355:
                    if (strR.equals("id")) {
                        b = 15;
                    }
                    break;
                case 3373707:
                    if (strR.equals("name")) {
                        b = 16;
                    }
                    break;
                case 59142220:
                    if (strR.equals("low_memory")) {
                        b = 17;
                    }
                    break;
                case 93076189:
                    if (strR.equals("archs")) {
                        b = 18;
                    }
                    break;
                case 93997959:
                    if (strR.equals("brand")) {
                        b = 19;
                    }
                    break;
                case 104069929:
                    if (strR.equals("model")) {
                        b = 20;
                    }
                    break;
                case 115746789:
                    if (strR.equals("cpu_description")) {
                        b = 21;
                    }
                    break;
                case 244497903:
                    if (strR.equals("processor_frequency")) {
                        b = 22;
                    }
                    break;
                case 731866107:
                    if (strR.equals("connection_type")) {
                        b = 23;
                    }
                    break;
                case 746402966:
                    if (strR.equals("chipset")) {
                        b = 24;
                    }
                    break;
                case 817830969:
                    if (strR.equals("screen_width_pixels")) {
                        b = 25;
                    }
                    break;
                case 823882553:
                    if (strR.equals("external_storage_size")) {
                        b = 26;
                    }
                    break;
                case 897428293:
                    if (strR.equals("storage_size")) {
                        b = 27;
                    }
                    break;
                case 1331465768:
                    if (strR.equals("usable_memory")) {
                        b = 28;
                    }
                    break;
                case 1418777727:
                    if (strR.equals("memory_size")) {
                        b = 29;
                    }
                    break;
                case 1436115569:
                    if (strR.equals("charging")) {
                        b = 30;
                    }
                    break;
                case 1450613660:
                    if (strR.equals("external_free_storage")) {
                        b = 31;
                    }
                    break;
                case 1524159400:
                    if (strR.equals("free_storage")) {
                        b = HttpConstants.SP;
                    }
                    break;
                case 1556284978:
                    if (strR.equals("screen_height_pixels")) {
                        b = 33;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    hVar.Q0 = m3Var.E(iLogger);
                    break;
                case 1:
                    if (m3Var.peek() == io.sentry.vendor.gson.stream.b.STRING) {
                        hVar.P0 = m3Var.Y(iLogger);
                    }
                    break;
                case 2:
                    hVar.C0 = m3Var.b0();
                    break;
                case 3:
                    hVar.f = m3Var.G();
                    break;
                case 4:
                    hVar.V0 = m3Var.u();
                    break;
                case 5:
                    hVar.B0 = (g) m3Var.m0(iLogger, new a(i));
                    break;
                case 6:
                    hVar.U0 = m3Var.l0();
                    break;
                case 7:
                    hVar.A = m3Var.G();
                    break;
                case 8:
                    hVar.S0 = m3Var.G();
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    hVar.A0 = m3Var.b0();
                    break;
                case 10:
                    hVar.y0 = m3Var.l0();
                    break;
                case 11:
                    hVar.Y = m3Var.G();
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    hVar.N0 = m3Var.l0();
                    break;
                case 13:
                    hVar.O0 = m3Var.u();
                    break;
                case 14:
                    hVar.E0 = m3Var.y();
                    break;
                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                    hVar.R0 = m3Var.G();
                    break;
                case 16:
                    hVar.b = m3Var.G();
                    break;
                case 17:
                    hVar.G0 = m3Var.b0();
                    break;
                case 18:
                    List list = (List) m3Var.o0();
                    if (list != null) {
                        String[] strArr = new String[list.size()];
                        list.toArray(strArr);
                        hVar.Z = strArr;
                    }
                    break;
                case 19:
                    hVar.z = m3Var.G();
                    break;
                case 20:
                    hVar.X = m3Var.G();
                    break;
                case 21:
                    hVar.X0 = m3Var.G();
                    break;
                case 22:
                    hVar.W0 = m3Var.O();
                    break;
                case 23:
                    hVar.T0 = m3Var.G();
                    break;
                case 24:
                    hVar.Y0 = m3Var.G();
                    break;
                case 25:
                    hVar.L0 = m3Var.u();
                    break;
                case 26:
                    hVar.J0 = m3Var.y();
                    break;
                case 27:
                    hVar.H0 = m3Var.y();
                    break;
                case 28:
                    hVar.F0 = m3Var.y();
                    break;
                case 29:
                    hVar.D0 = m3Var.y();
                    break;
                case 30:
                    hVar.z0 = m3Var.b0();
                    break;
                case 31:
                    hVar.K0 = m3Var.y();
                    break;
                case 32:
                    hVar.I0 = m3Var.y();
                    break;
                case 33:
                    hVar.M0 = m3Var.u();
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    m3Var.w(iLogger, concurrentHashMap, strR);
                    break;
            }
        }
        hVar.Z0 = concurrentHashMap;
        m3Var.V();
        return hVar;
    }

    public static k e(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        w wVar = null;
        w wVar2 = null;
        String strG4 = null;
        HashMap map = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            strR = m3Var.R();
            strR.getClass();
            switch (strR) {
                case "associated_event_id":
                    wVar = new w(m3Var.q());
                    break;
                case "replay_id":
                    wVar2 = new w(m3Var.q());
                    break;
                case "url":
                    strG4 = m3Var.G();
                    break;
                case "name":
                    strG3 = m3Var.G();
                    break;
                case "contact_email":
                    strG2 = m3Var.G();
                    break;
                case "message":
                    strG = m3Var.G();
                    break;
                default:
                    if (map == null) {
                        map = new HashMap();
                    }
                    m3Var.w(iLogger, map, strR);
                    break;
            }
        }
        m3Var.V();
        if (strG == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"message\"");
            iLogger.d(p5.ERROR, "Missing required field \"message\"", illegalStateException);
            throw illegalStateException;
        }
        k kVar = new k(strG);
        kVar.f = strG2;
        kVar.z = strG3;
        kVar.A = wVar;
        kVar.X = wVar2;
        kVar.Y = strG4;
        kVar.Z = map;
        return kVar;
    }

    public static m f(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        m mVar = new m();
        ConcurrentHashMap concurrentHashMap = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            strR = m3Var.R();
            strR.getClass();
            switch (strR) {
                case "npot_support":
                    mVar.z0 = m3Var.G();
                    break;
                case "vendor_id":
                    mVar.z = m3Var.G();
                    break;
                case "multi_threaded_rendering":
                    mVar.Z = m3Var.b0();
                    break;
                case "id":
                    mVar.f = m3Var.u();
                    break;
                case "name":
                    mVar.b = m3Var.G();
                    break;
                case "vendor_name":
                    mVar.A = m3Var.G();
                    break;
                case "version":
                    mVar.y0 = m3Var.G();
                    break;
                case "api_type":
                    mVar.Y = m3Var.G();
                    break;
                case "memory_size":
                    mVar.X = m3Var.u();
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    m3Var.w(iLogger, concurrentHashMap, strR);
                    break;
            }
        }
        mVar.A0 = concurrentHashMap;
        m3Var.V();
        return mVar;
    }

    public static q g(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        q qVar = new q();
        ConcurrentHashMap concurrentHashMap = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            strR = m3Var.R();
            strR.getClass();
            switch (strR) {
                case "rooted":
                    qVar.Y = m3Var.b0();
                    break;
                case "raw_description":
                    qVar.z = m3Var.G();
                    break;
                case "name":
                    qVar.b = m3Var.G();
                    break;
                case "build":
                    qVar.A = m3Var.G();
                    break;
                case "version":
                    qVar.f = m3Var.G();
                    break;
                case "kernel_version":
                    qVar.X = m3Var.G();
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    m3Var.w(iLogger, concurrentHashMap, strR);
                    break;
            }
        }
        qVar.Z = concurrentHashMap;
        m3Var.V();
        return qVar;
    }

    public static IllegalStateException h(String str, ILogger iLogger) {
        String strO = ha0.o("Missing required field \"", str, "\"");
        IllegalStateException illegalStateException = new IllegalStateException(strO);
        iLogger.d(p5.ERROR, strO, illegalStateException);
        return illegalStateException;
    }

    public static IllegalStateException i(String str, ILogger iLogger) {
        String strO = ha0.o("Missing required field \"", str, "\"");
        IllegalStateException illegalStateException = new IllegalStateException(strO);
        iLogger.d(p5.ERROR, strO, illegalStateException);
        return illegalStateException;
    }

    public static IllegalStateException j(String str, ILogger iLogger) {
        String strO = ha0.o("Missing required field \"", str, "\"");
        IllegalStateException illegalStateException = new IllegalStateException(strO);
        iLogger.d(p5.ERROR, strO, illegalStateException);
        return illegalStateException;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*  JADX ERROR: NullPointerException in pass: SwitchBreakVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    @Override // io.sentry.x1
    public final java.lang.Object a(io.sentry.m3 r35, io.sentry.ILogger r36) {
        /*
            Method dump skipped, instruction units count: 4490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.clientreport.a.a(io.sentry.m3, io.sentry.ILogger):java.lang.Object");
    }
}
