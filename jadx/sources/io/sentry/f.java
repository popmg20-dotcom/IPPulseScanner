package io.sentry;

import com.tencent.mars.xlog.Xlog;
import defpackage.bx1;
import defpackage.ha0;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.conscrypt.BuildConfig;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f implements x1 {
    public final /* synthetic */ int a;

    public /* synthetic */ f(int i) {
        this.a = i;
    }

    public static b7 b(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        io.sentry.protocol.w wVar = null;
        d7 d7Var = null;
        String strQ = null;
        ConcurrentHashMap concurrentHashMap = null;
        d7 d7Var2 = null;
        String strQ2 = null;
        f7 f7Var = null;
        String strQ3 = null;
        ConcurrentHashMap concurrentHashMapO = null;
        Map map = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            strR = m3Var.R();
            strR.getClass();
            switch (strR) {
                case "span_id":
                    d7Var = new d7(m3Var.q());
                    break;
                case "parent_span_id":
                    d7Var2 = (d7) m3Var.m0(iLogger, new f(23));
                    break;
                case "description":
                    strQ2 = m3Var.q();
                    break;
                case "origin":
                    strQ3 = m3Var.q();
                    break;
                case "status":
                    f7Var = (f7) m3Var.m0(iLogger, new f(24));
                    break;
                case "op":
                    strQ = m3Var.q();
                    break;
                case "data":
                    map = (Map) m3Var.o0();
                    break;
                case "tags":
                    concurrentHashMapO = io.sentry.util.b.o((Map) m3Var.o0());
                    break;
                case "trace_id":
                    wVar = new io.sentry.protocol.w(m3Var.q());
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    m3Var.w(iLogger, concurrentHashMap, strR);
                    break;
            }
        }
        if (wVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
            iLogger.d(p5.ERROR, "Missing required field \"trace_id\"", illegalStateException);
            throw illegalStateException;
        }
        if (d7Var == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
            iLogger.d(p5.ERROR, "Missing required field \"span_id\"", illegalStateException2);
            throw illegalStateException2;
        }
        if (strQ == null) {
            strQ = "";
        }
        b7 b7Var = new b7(wVar, d7Var, strQ, d7Var2);
        b7Var.Y = strQ2;
        b7Var.Z = f7Var;
        b7Var.z0 = strQ3;
        if (concurrentHashMapO != null) {
            b7Var.y0 = concurrentHashMapO;
        }
        if (map != null) {
            b7Var.A0 = map;
        }
        b7Var.B0 = concurrentHashMap;
        m3Var.V();
        return b7Var;
    }

    private final Object c(m3 m3Var, ILogger iLogger) {
        return f7.valueOf(m3Var.q().toUpperCase(Locale.ROOT));
    }

    private final Object d(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        ConcurrentHashMap concurrentHashMap = null;
        io.sentry.protocol.w wVar = null;
        String strQ = null;
        String strG = null;
        String strG2 = null;
        String strG3 = null;
        String strG4 = null;
        String strG5 = null;
        String strG6 = null;
        io.sentry.protocol.w wVar2 = null;
        String strG7 = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            strR = m3Var.R();
            strR.getClass();
            switch (strR) {
                case "replay_id":
                    wVar2 = new io.sentry.protocol.w(m3Var.q());
                    break;
                case "user_id":
                    strG3 = m3Var.G();
                    break;
                case "environment":
                    strG2 = m3Var.G();
                    break;
                case "sample_rand":
                    strG7 = m3Var.G();
                    break;
                case "sample_rate":
                    strG5 = m3Var.G();
                    break;
                case "release":
                    strG = m3Var.G();
                    break;
                case "trace_id":
                    wVar = new io.sentry.protocol.w(m3Var.q());
                    break;
                case "sampled":
                    strG6 = m3Var.G();
                    break;
                case "public_key":
                    strQ = m3Var.q();
                    break;
                case "transaction":
                    strG4 = m3Var.G();
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    m3Var.w(iLogger, concurrentHashMap, strR);
                    break;
            }
        }
        if (wVar == null) {
            throw f("trace_id", iLogger);
        }
        if (strQ == null) {
            throw f("public_key", iLogger);
        }
        h7 h7Var = new h7(wVar, strQ, strG, strG2, strG3, strG4, strG5, strG6, wVar2, strG7);
        h7Var.B0 = concurrentHashMap;
        m3Var.V();
        return h7Var;
    }

    public static IllegalStateException e(String str, ILogger iLogger) {
        String strO = ha0.o("Missing required field \"", str, "\"");
        IllegalStateException illegalStateException = new IllegalStateException(strO);
        iLogger.d(p5.ERROR, strO, illegalStateException);
        return illegalStateException;
    }

    public static IllegalStateException f(String str, ILogger iLogger) {
        String strO = ha0.o("Missing required field \"", str, "\"");
        IllegalStateException illegalStateException = new IllegalStateException(strO);
        iLogger.d(p5.ERROR, strO, illegalStateException);
        return illegalStateException;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r49v0, types: [io.sentry.ILogger] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // io.sentry.x1
    public final Object a(m3 m3Var, ILogger iLogger) {
        ?? r8;
        byte b;
        byte b2;
        String strR;
        ArrayList arrayList;
        String strR2;
        String strR3;
        String strR4;
        int i;
        String strR5;
        String strR6;
        String strR7;
        String strR8;
        String strR9;
        y6 y6VarValueOf;
        Date date;
        String strG;
        String strR10;
        m3 m3Var2 = m3Var;
        int i2 = 17;
        int i3 = 11;
        switch (this.a) {
            case 0:
                boolean z = true;
                String strG2 = null;
                char c = 3;
                m3Var2.p0();
                Date date2 = new Date();
                String strG3 = null;
                ConcurrentHashMap concurrentHashMap = null;
                String strG4 = null;
                ConcurrentHashMap concurrentHashMap2 = null;
                String strG5 = null;
                p5 p5VarValueOf = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR11 = m3Var2.R();
                    strR11.getClass();
                    switch (strR11.hashCode()) {
                        case -1008619738:
                            r8 = strR11.equals("origin") ? 0 : -1;
                            break;
                        case 3076010:
                            r8 = strR11.equals("data") ? z : -1;
                            break;
                        case 3575610:
                            r8 = strR11.equals("type") ? 2 : -1;
                            break;
                        case 50511102:
                            r8 = strR11.equals("category") ? c : -1;
                            break;
                        case 55126294:
                            r8 = strR11.equals("timestamp") ? 4 : -1;
                            break;
                        case 102865796:
                            r8 = strR11.equals("level") ? 5 : -1;
                            break;
                        case 954925063:
                            r8 = strR11.equals("message") ? 6 : -1;
                            break;
                        default:
                            r8 = -1;
                            break;
                    }
                    switch (r8) {
                        case 0:
                            strG5 = m3Var.G();
                            continue;
                            m3Var2 = m3Var;
                            z = true;
                            c = 3;
                            break;
                        case 1:
                            ConcurrentHashMap concurrentHashMapO = io.sentry.util.b.o((Map) m3Var.o0());
                            if (concurrentHashMapO == null) {
                                continue;
                            } else if (!concurrentHashMapO.isEmpty()) {
                                concurrentHashMap = concurrentHashMapO;
                            }
                            m3Var2 = m3Var;
                            z = true;
                            c = 3;
                            break;
                        case 2:
                            strG3 = m3Var.G();
                            continue;
                            m3Var2 = m3Var;
                            z = true;
                            c = 3;
                            break;
                        case 3:
                            strG4 = m3Var.G();
                            continue;
                            m3Var2 = m3Var;
                            z = true;
                            c = 3;
                            break;
                        case 4:
                            Date dateY = m3Var.Y(iLogger);
                            if (dateY != null) {
                                date2 = dateY;
                            } else {
                                continue;
                            }
                            m3Var2 = m3Var;
                            z = true;
                            c = 3;
                            break;
                        case 5:
                            try {
                                p5VarValueOf = p5.valueOf(m3Var2.q().toUpperCase(Locale.ROOT));
                            } catch (Exception e) {
                                iLogger.b(p5.ERROR, e, "Error when deserializing SentryLevel", new Object[0]);
                            }
                            break;
                        case 6:
                            strG2 = m3Var2.G();
                            break;
                        default:
                            if (concurrentHashMap2 == null) {
                                concurrentHashMap2 = new ConcurrentHashMap();
                            }
                            m3Var2.w(iLogger, concurrentHashMap2, strR11);
                            break;
                    }
                    m3Var2 = m3Var;
                    z = true;
                    c = 3;
                }
                g gVar = new g(date2);
                gVar.A = strG2;
                gVar.X = strG3;
                if (concurrentHashMap != null) {
                    gVar.Y = concurrentHashMap;
                }
                gVar.Z = strG4;
                gVar.y0 = strG5;
                gVar.z0 = p5VarValueOf;
                gVar.A0 = concurrentHashMap2;
                m3Var.V();
                return gVar;
            case 1:
                char c2 = '\n';
                char c3 = 4;
                ConcurrentHashMap concurrentHashMap3 = null;
                m3Var2.p0();
                io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
                s3 s3Var = new s3(wVar, wVar, null, new HashMap(), Double.valueOf(0.0d), p6.empty());
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR12 = m3Var2.R();
                    strR12.getClass();
                    switch (strR12.hashCode()) {
                        case -1840434063:
                            b = strR12.equals("debug_meta") ? (byte) 0 : (byte) -1;
                            break;
                        case -362243017:
                            b = strR12.equals("measurements") ? (byte) 1 : (byte) -1;
                            break;
                        case -309425751:
                            b = strR12.equals("profile") ? (byte) 2 : (byte) -1;
                            break;
                        case -85904877:
                            b = strR12.equals("environment") ? (byte) 3 : (byte) -1;
                            break;
                        case 55126294:
                            b = strR12.equals("timestamp") ? c3 : (byte) -1;
                            break;
                        case 178573617:
                            b = strR12.equals("profiler_id") ? (byte) 5 : (byte) -1;
                            break;
                        case 351608024:
                            b = strR12.equals("version") ? (byte) 6 : (byte) -1;
                            break;
                        case 831846208:
                            b = strR12.equals("content_type") ? (byte) 7 : (byte) -1;
                            break;
                        case 1090594823:
                            b = strR12.equals(BuildConfig.BUILD_TYPE) ? (byte) 8 : (byte) -1;
                            break;
                        case 1102774726:
                            b = strR12.equals("client_sdk") ? (byte) 9 : (byte) -1;
                            break;
                        case 1874684019:
                            b = strR12.equals("platform") ? c2 : (byte) -1;
                            break;
                        case 1953158756:
                            b = strR12.equals("sampled_profile") ? (byte) 11 : (byte) -1;
                            break;
                        case 2005113901:
                            b = strR12.equals("chunk_id") ? (byte) 12 : (byte) -1;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        case 0:
                            io.sentry.protocol.f fVar = (io.sentry.protocol.f) m3Var2.m0(iLogger, new io.sentry.clientreport.a(8));
                            if (fVar != null) {
                                s3Var.b = fVar;
                            }
                            break;
                        case 1:
                            HashMap mapJ = m3Var2.J(iLogger, new io.sentry.clientreport.a(2));
                            if (mapJ != null) {
                                s3Var.X.putAll(mapJ);
                            }
                            break;
                        case 2:
                            io.sentry.protocol.profiling.a aVar = (io.sentry.protocol.profiling.a) m3Var2.m0(iLogger, new io.sentry.protocol.d0(5));
                            if (aVar != null) {
                                s3Var.E0 = aVar;
                            }
                            break;
                        case 3:
                            String strG6 = m3Var2.G();
                            if (strG6 != null) {
                                s3Var.y0 = strG6;
                            }
                            break;
                        case 4:
                            Double dO = m3Var2.O();
                            if (dO != null) {
                                s3Var.A0 = dO.doubleValue();
                            }
                            break;
                        case 5:
                            io.sentry.protocol.w wVar2 = (io.sentry.protocol.w) m3Var2.m0(iLogger, new io.sentry.clientreport.a(23));
                            if (wVar2 != null) {
                                s3Var.f = wVar2;
                            }
                            break;
                        case 6:
                            String strG7 = m3Var2.G();
                            if (strG7 != null) {
                                s3Var.z0 = strG7;
                            }
                            break;
                        case 7:
                            String strG8 = m3Var2.G();
                            if (strG8 != null) {
                                s3Var.B0 = strG8;
                            }
                            break;
                        case 8:
                            String strG9 = m3Var2.G();
                            if (strG9 != null) {
                                s3Var.Z = strG9;
                            }
                            break;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                            io.sentry.protocol.u uVar = (io.sentry.protocol.u) m3Var2.m0(iLogger, new io.sentry.clientreport.a(21));
                            if (uVar != null) {
                                s3Var.A = uVar;
                            }
                            break;
                        case 10:
                            String strG10 = m3Var2.G();
                            if (strG10 != null) {
                                s3Var.Y = strG10;
                            }
                            break;
                        case 11:
                            String strG11 = m3Var2.G();
                            if (strG11 != null) {
                                s3Var.D0 = strG11;
                            }
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            io.sentry.protocol.w wVar3 = (io.sentry.protocol.w) m3Var2.m0(iLogger, new io.sentry.clientreport.a(23));
                            if (wVar3 != null) {
                                s3Var.z = wVar3;
                            }
                            break;
                        default:
                            if (concurrentHashMap3 == null) {
                                concurrentHashMap3 = new ConcurrentHashMap();
                            }
                            m3Var2.w(iLogger, concurrentHashMap3, strR12);
                            break;
                    }
                    c2 = '\n';
                    c3 = 4;
                }
                s3Var.F0 = concurrentHashMap3;
                m3Var2.V();
                return s3Var;
            case 2:
                ConcurrentHashMap concurrentHashMap4 = null;
                m3Var2.p0();
                t3 t3Var = new t3(io.sentry.protocol.w.f);
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR13 = m3Var2.R();
                    strR13.getClass();
                    if (strR13.equals("profiler_id")) {
                        io.sentry.protocol.w wVar4 = (io.sentry.protocol.w) m3Var2.m0(iLogger, new io.sentry.clientreport.a(23));
                        if (wVar4 != null) {
                            t3Var.b = wVar4;
                        }
                    } else {
                        if (concurrentHashMap4 == null) {
                            concurrentHashMap4 = new ConcurrentHashMap();
                        }
                        m3Var2.w(iLogger, concurrentHashMap4, strR13);
                    }
                }
                t3Var.f = concurrentHashMap4;
                m3Var2.V();
                return t3Var;
            case 3:
                m3Var2.p0();
                File file = new File("dummy");
                Date date3 = new Date();
                ArrayList arrayList2 = new ArrayList();
                io.sentry.protocol.w wVar5 = io.sentry.protocol.w.f;
                ConcurrentHashMap concurrentHashMap5 = null;
                v3 v3Var = new v3(file, date3, arrayList2, "", wVar5.a(), new b7(wVar5, d7.f, "op", null).b.a(), "0", 0, "", new m0(3), null, null, null, null, null, null, null, null, "normal", new HashMap());
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR14 = m3Var2.R();
                    strR14.getClass();
                    switch (strR14.hashCode()) {
                        case -2133529830:
                            b2 = strR14.equals("device_manufacturer") ? (byte) 0 : (byte) -1;
                            break;
                        case -1981468849:
                            b2 = strR14.equals("android_api_level") ? (byte) 1 : (byte) -1;
                            break;
                        case -1430655860:
                            b2 = strR14.equals("build_id") ? (byte) 2 : (byte) -1;
                            break;
                        case -1172160413:
                            b2 = strR14.equals("device_locale") ? (byte) 3 : (byte) -1;
                            break;
                        case -1102636175:
                            b2 = strR14.equals("profile_id") ? (byte) 4 : (byte) -1;
                            break;
                        case -716656436:
                            b2 = strR14.equals("device_os_build_number") ? (byte) 5 : (byte) -1;
                            break;
                        case -591076352:
                            b2 = strR14.equals("device_model") ? (byte) 6 : (byte) -1;
                            break;
                        case -512511455:
                            b2 = strR14.equals("device_is_emulator") ? (byte) 7 : (byte) -1;
                            break;
                        case -478065584:
                            b2 = strR14.equals("duration_ns") ? (byte) 8 : (byte) -1;
                            break;
                        case -362243017:
                            b2 = strR14.equals("measurements") ? (byte) 9 : (byte) -1;
                            break;
                        case -332426004:
                            b2 = strR14.equals("device_physical_memory_bytes") ? (byte) 10 : (byte) -1;
                            break;
                        case -212264198:
                            b2 = strR14.equals("device_cpu_frequencies") ? (byte) 11 : (byte) -1;
                            break;
                        case -102985484:
                            b2 = strR14.equals("version_code") ? (byte) 12 : (byte) -1;
                            break;
                        case -102670958:
                            b2 = strR14.equals("version_name") ? HttpConstants.CR : (byte) -1;
                            break;
                        case -85904877:
                            b2 = strR14.equals("environment") ? (byte) 14 : (byte) -1;
                            break;
                        case 55126294:
                            b2 = strR14.equals("timestamp") ? (byte) 15 : (byte) -1;
                            break;
                        case 508853068:
                            b2 = strR14.equals("transaction_name") ? (byte) 16 : (byte) -1;
                            break;
                        case 796476189:
                            b2 = strR14.equals("device_os_name") ? (byte) 17 : (byte) -1;
                            break;
                        case 839674195:
                            b2 = strR14.equals("architecture") ? (byte) 18 : (byte) -1;
                            break;
                        case 1010584092:
                            b2 = strR14.equals("transaction_id") ? (byte) 19 : (byte) -1;
                            break;
                        case 1052553990:
                            b2 = strR14.equals("device_os_version") ? (byte) 20 : (byte) -1;
                            break;
                        case 1163928186:
                            b2 = strR14.equals("truncation_reason") ? (byte) 21 : (byte) -1;
                            break;
                        case 1270300245:
                            b2 = strR14.equals("trace_id") ? (byte) 22 : (byte) -1;
                            break;
                        case 1874684019:
                            b2 = strR14.equals("platform") ? (byte) 23 : (byte) -1;
                            break;
                        case 1953158756:
                            b2 = strR14.equals("sampled_profile") ? (byte) 24 : (byte) -1;
                            break;
                        case 1954122069:
                            b2 = strR14.equals("transactions") ? (byte) 25 : (byte) -1;
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    switch (b2) {
                        case 0:
                            String strG12 = m3Var2.G();
                            if (strG12 != null) {
                                v3Var.X = strG12;
                            }
                            break;
                        case 1:
                            Integer numU = m3Var2.u();
                            if (numU != null) {
                                v3Var.z = numU.intValue();
                            }
                            break;
                        case 2:
                            String strG13 = m3Var2.G();
                            if (strG13 != null) {
                                v3Var.F0 = strG13;
                            }
                            break;
                        case 3:
                            String strG14 = m3Var2.G();
                            if (strG14 != null) {
                                v3Var.A = strG14;
                            }
                            break;
                        case 4:
                            String strG15 = m3Var2.G();
                            if (strG15 != null) {
                                v3Var.N0 = strG15;
                            }
                            break;
                        case 5:
                            String strG16 = m3Var2.G();
                            if (strG16 != null) {
                                v3Var.Z = strG16;
                            }
                            break;
                        case 6:
                            String strG17 = m3Var2.G();
                            if (strG17 != null) {
                                v3Var.Y = strG17;
                            }
                            break;
                        case 7:
                            Boolean boolB0 = m3Var2.b0();
                            if (boolB0 != null) {
                                v3Var.A0 = boolB0.booleanValue();
                            }
                            break;
                        case 8:
                            String strG18 = m3Var2.G();
                            if (strG18 != null) {
                                v3Var.I0 = strG18;
                            }
                            break;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                            HashMap mapJ2 = m3Var2.J(iLogger, new io.sentry.clientreport.a(2));
                            if (mapJ2 != null) {
                                v3Var.R0.putAll(mapJ2);
                            }
                            break;
                        case 10:
                            String strG19 = m3Var2.G();
                            if (strG19 != null) {
                                v3Var.D0 = strG19;
                            }
                            break;
                        case 11:
                            List list = (List) m3Var2.o0();
                            if (list != null) {
                                v3Var.C0 = list;
                            }
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            String strG20 = m3Var2.G();
                            if (strG20 != null) {
                                v3Var.J0 = strG20;
                            }
                            break;
                        case 13:
                            String strG21 = m3Var2.G();
                            if (strG21 != null) {
                                v3Var.K0 = strG21;
                            }
                            break;
                        case 14:
                            String strG22 = m3Var2.G();
                            if (strG22 != null) {
                                v3Var.O0 = strG22;
                            }
                            break;
                        case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                            Date dateY2 = m3Var.Y(iLogger);
                            if (dateY2 != null) {
                                v3Var.Q0 = dateY2;
                            }
                            break;
                        case 16:
                            String strG23 = m3Var2.G();
                            if (strG23 != null) {
                                v3Var.H0 = strG23;
                            }
                            break;
                        case 17:
                            String strG24 = m3Var2.G();
                            if (strG24 != null) {
                                v3Var.y0 = strG24;
                            }
                            break;
                        case 18:
                            String strG25 = m3Var2.G();
                            if (strG25 != null) {
                                v3Var.B0 = strG25;
                            }
                            break;
                        case 19:
                            String strG26 = m3Var2.G();
                            if (strG26 != null) {
                                v3Var.L0 = strG26;
                            }
                            break;
                        case 20:
                            String strG27 = m3Var2.G();
                            if (strG27 != null) {
                                v3Var.z0 = strG27;
                            }
                            break;
                        case 21:
                            String strG28 = m3Var2.G();
                            if (strG28 != null) {
                                v3Var.P0 = strG28;
                            }
                            break;
                        case 22:
                            String strG29 = m3Var2.G();
                            if (strG29 != null) {
                                v3Var.M0 = strG29;
                            }
                            break;
                        case 23:
                            String strG30 = m3Var2.G();
                            if (strG30 != null) {
                                v3Var.E0 = strG30;
                            }
                            break;
                        case 24:
                            String strG31 = m3Var2.G();
                            if (strG31 != null) {
                                v3Var.S0 = strG31;
                            }
                            break;
                        case 25:
                            ArrayList arrayListY0 = m3Var2.y0(iLogger, new f(4));
                            if (arrayListY0 != null) {
                                v3Var.G0.addAll(arrayListY0);
                            }
                            break;
                        default:
                            if (concurrentHashMap5 == null) {
                                concurrentHashMap5 = new ConcurrentHashMap();
                            }
                            m3Var2.w(iLogger, concurrentHashMap5, strR14);
                            break;
                    }
                }
                v3Var.T0 = concurrentHashMap5;
                m3Var2.V();
                return v3Var;
            case 4:
                m3Var2.p0();
                w3 w3Var = new w3(j3.a, 0L, 0L);
                ConcurrentHashMap concurrentHashMap6 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR = m3Var2.R();
                    strR.getClass();
                    switch (strR) {
                        case "relative_start_ns":
                            Long lY = m3Var2.y();
                            if (lY == null) {
                                break;
                            } else {
                                w3Var.A = lY;
                                break;
                            }
                            break;
                        case "relative_end_ns":
                            Long lY2 = m3Var2.y();
                            if (lY2 == null) {
                                break;
                            } else {
                                w3Var.X = lY2;
                                break;
                            }
                            break;
                        case "id":
                            String strG32 = m3Var2.G();
                            if (strG32 == null) {
                                break;
                            } else {
                                w3Var.b = strG32;
                                break;
                            }
                            break;
                        case "name":
                            String strG33 = m3Var2.G();
                            if (strG33 == null) {
                                break;
                            } else {
                                w3Var.z = strG33;
                                break;
                            }
                            break;
                        case "trace_id":
                            String strG34 = m3Var2.G();
                            if (strG34 == null) {
                                break;
                            } else {
                                w3Var.f = strG34;
                                break;
                            }
                            break;
                        case "relative_cpu_end_ms":
                            Long lY3 = m3Var2.y();
                            if (lY3 == null) {
                                break;
                            } else {
                                w3Var.Z = lY3;
                                break;
                            }
                            break;
                        case "relative_cpu_start_ms":
                            Long lY4 = m3Var2.y();
                            if (lY4 == null) {
                                break;
                            } else {
                                w3Var.Y = lY4;
                                break;
                            }
                            break;
                        default:
                            if (concurrentHashMap6 == null) {
                                concurrentHashMap6 = new ConcurrentHashMap();
                            }
                            m3Var2.w(iLogger, concurrentHashMap6, strR);
                            break;
                    }
                }
                w3Var.y0 = concurrentHashMap6;
                m3Var2.V();
                return w3Var;
            case 5:
                b4 b4Var = new b4();
                m3Var2.p0();
                Integer numU2 = null;
                HashMap map = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR15 = m3Var2.R();
                    strR15.getClass();
                    if (strR15.equals("segment_id")) {
                        numU2 = m3Var2.u();
                    } else {
                        if (map == null) {
                            map = new HashMap();
                        }
                        m3Var2.w(iLogger, map, strR15);
                    }
                }
                m3Var2.V();
                m3Var2.H(true);
                List list2 = (List) m3Var2.o0();
                m3Var2.H(false);
                if (list2 != null) {
                    arrayList = new ArrayList(list2.size());
                    for (Object obj : list2) {
                        if (obj instanceof Map) {
                            Map map2 = (Map) obj;
                            io.sentry.util.h hVar = new io.sentry.util.h(map2);
                            for (Map.Entry entry : map2.entrySet()) {
                                String str = (String) entry.getKey();
                                Object value = entry.getValue();
                                if (str.equals("type")) {
                                    io.sentry.rrweb.c cVar = io.sentry.rrweb.c.values()[((Integer) value).intValue()];
                                    int i4 = a4.b[cVar.ordinal()];
                                    if (i4 == 1) {
                                        Map map3 = (Map) map2.get("data");
                                        if (map3 == null) {
                                            map3 = Collections.EMPTY_MAP;
                                        }
                                        Integer num = (Integer) map3.get("source");
                                        if (num != null) {
                                            io.sentry.rrweb.d dVar = io.sentry.rrweb.d.values()[num.intValue()];
                                            int i5 = a4.a[dVar.ordinal()];
                                            if (i5 == 1) {
                                                arrayList.add(io.sentry.protocol.d0.c(hVar, iLogger));
                                            } else if (i5 != 2) {
                                                iLogger.h(p5.DEBUG, "Unsupported rrweb incremental snapshot type %s", dVar);
                                            } else {
                                                arrayList.add(io.sentry.protocol.d0.d(hVar, iLogger));
                                            }
                                        }
                                    } else if (i4 == 2) {
                                        arrayList.add(io.sentry.protocol.d0.e(hVar, iLogger));
                                    } else if (i4 == 3) {
                                        Map map4 = (Map) map2.get("data");
                                        if (map4 == null) {
                                            map4 = Collections.EMPTY_MAP;
                                        }
                                        String str2 = (String) map4.get("tag");
                                        if (str2 != null) {
                                            switch (str2) {
                                                case "performanceSpan":
                                                    arrayList.add(io.sentry.protocol.d0.f(hVar, iLogger));
                                                    break;
                                                case "video":
                                                    arrayList.add(io.sentry.protocol.d0.g(hVar, iLogger));
                                                    break;
                                                case "breadcrumb":
                                                    arrayList.add(io.sentry.protocol.d0.b(hVar, iLogger));
                                                    break;
                                                default:
                                                    iLogger.h(p5.DEBUG, "Unsupported rrweb event type %s", cVar);
                                                    break;
                                            }
                                        }
                                    } else {
                                        iLogger.h(p5.DEBUG, "Unsupported rrweb event type %s", cVar);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    arrayList = null;
                }
                b4Var.b = numU2;
                b4Var.f = arrayList;
                b4Var.z = map;
                return b4Var;
            case 6:
                m3Var2.p0();
                q4 q4Var = new q4();
                q4Var.z = false;
                q4Var.A = null;
                q4Var.b = false;
                q4Var.f = null;
                q4Var.z0 = false;
                q4Var.X = null;
                q4Var.Y = false;
                q4Var.Z = false;
                q4Var.D0 = u3.MANUAL;
                q4Var.y0 = 0;
                q4Var.A0 = true;
                q4Var.B0 = false;
                q4Var.C0 = true;
                ConcurrentHashMap concurrentHashMap7 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR2 = m3Var2.R();
                    strR2.getClass();
                    switch (strR2) {
                        case "is_enable_app_start_profiling":
                            Boolean boolB02 = m3Var2.b0();
                            if (boolB02 == null) {
                                break;
                            } else {
                                q4Var.A0 = boolB02.booleanValue();
                                break;
                            }
                            break;
                        case "trace_sampled":
                            Boolean boolB03 = m3Var2.b0();
                            if (boolB03 == null) {
                                break;
                            } else {
                                q4Var.z = boolB03.booleanValue();
                                break;
                            }
                            break;
                        case "profiling_traces_dir_path":
                            String strG35 = m3Var2.G();
                            if (strG35 == null) {
                                break;
                            } else {
                                q4Var.X = strG35;
                                break;
                            }
                            break;
                        case "is_continuous_profiling_enabled":
                            Boolean boolB04 = m3Var2.b0();
                            if (boolB04 == null) {
                                break;
                            } else {
                                q4Var.Z = boolB04.booleanValue();
                                break;
                            }
                            break;
                        case "is_profiling_enabled":
                            Boolean boolB05 = m3Var2.b0();
                            if (boolB05 == null) {
                                break;
                            } else {
                                q4Var.Y = boolB05.booleanValue();
                                break;
                            }
                            break;
                        case "is_start_profiler_on_app_start":
                            Boolean boolB06 = m3Var2.b0();
                            if (boolB06 == null) {
                                break;
                            } else {
                                q4Var.B0 = boolB06.booleanValue();
                                break;
                            }
                            break;
                        case "profile_sampled":
                            Boolean boolB07 = m3Var2.b0();
                            if (boolB07 == null) {
                                break;
                            } else {
                                q4Var.b = boolB07.booleanValue();
                                break;
                            }
                            break;
                        case "profile_lifecycle":
                            String strG36 = m3Var2.G();
                            if (strG36 == null) {
                                break;
                            } else {
                                try {
                                    q4Var.D0 = u3.valueOf(strG36);
                                } catch (IllegalArgumentException unused) {
                                    iLogger.h(p5.ERROR, "Error when deserializing ProfileLifecycle: ".concat(strG36), new Object[0]);
                                }
                                break;
                            }
                            break;
                        case "continuous_profile_sampled":
                            Boolean boolB08 = m3Var2.b0();
                            if (boolB08 == null) {
                                break;
                            } else {
                                q4Var.z0 = boolB08.booleanValue();
                                break;
                            }
                            break;
                        case "profiling_traces_hz":
                            Integer numU3 = m3Var2.u();
                            if (numU3 == null) {
                                break;
                            } else {
                                q4Var.y0 = numU3.intValue();
                                break;
                            }
                            break;
                        case "trace_sample_rate":
                            Double dO2 = m3Var2.O();
                            if (dO2 == null) {
                                break;
                            } else {
                                q4Var.A = dO2;
                                break;
                            }
                            break;
                        case "enable_legacy_profiling":
                            Boolean boolB09 = m3Var2.b0();
                            if (boolB09 == null) {
                                break;
                            } else {
                                q4Var.C0 = boolB09.booleanValue();
                                break;
                            }
                            break;
                        case "profile_sample_rate":
                            Double dO3 = m3Var2.O();
                            if (dO3 == null) {
                                break;
                            } else {
                                q4Var.f = dO3;
                                break;
                            }
                            break;
                        default:
                            if (concurrentHashMap7 == null) {
                                concurrentHashMap7 = new ConcurrentHashMap();
                            }
                            m3Var2.w(iLogger, concurrentHashMap7, strR2);
                            break;
                    }
                }
                q4Var.E0 = concurrentHashMap7;
                m3Var2.V();
                return q4Var;
            case 7:
                m3Var2.p0();
                io.sentry.protocol.u uVar2 = null;
                h7 h7Var = null;
                Date dateY3 = null;
                HashMap map5 = null;
                io.sentry.protocol.w wVar6 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR3 = m3Var2.R();
                    strR3.getClass();
                    switch (strR3) {
                        case "sdk":
                            uVar2 = (io.sentry.protocol.u) m3Var2.m0(iLogger, new io.sentry.clientreport.a(21));
                            break;
                        case "trace":
                            h7Var = (h7) m3Var2.m0(iLogger, new f(25));
                            break;
                        case "event_id":
                            wVar6 = (io.sentry.protocol.w) m3Var2.m0(iLogger, new io.sentry.clientreport.a(23));
                            break;
                        case "sent_at":
                            dateY3 = m3Var.Y(iLogger);
                            break;
                        default:
                            if (map5 == null) {
                                map5 = new HashMap();
                            }
                            m3Var2.w(iLogger, map5, strR3);
                            break;
                    }
                }
                y4 y4Var = new y4(wVar6, uVar2, h7Var);
                y4Var.A = dateY3;
                y4Var.X = map5;
                m3Var2.V();
                return y4Var;
            case 8:
                m3Var2.p0();
                Integer numU4 = null;
                HashMap map6 = null;
                o5 o5Var = null;
                int iNextInt = 0;
                String strG37 = null;
                String strG38 = null;
                String strG39 = null;
                String strG40 = null;
                Integer numU5 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR4 = m3Var2.R();
                    strR4.getClass();
                    switch (strR4) {
                        case "item_count":
                            numU5 = m3Var2.u();
                            continue;
                            break;
                        case "meta_length":
                            numU4 = m3Var2.u();
                            continue;
                            break;
                        case "length":
                            iNextInt = m3Var2.nextInt();
                            continue;
                            break;
                        case "filename":
                            strG38 = m3Var2.G();
                            continue;
                            break;
                        case "attachment_type":
                            strG39 = m3Var2.G();
                            continue;
                            break;
                        case "type":
                            o5Var = (o5) m3Var2.m0(iLogger, new f(10));
                            continue;
                            break;
                        case "content_type":
                            strG37 = m3Var2.G();
                            break;
                        case "platform":
                            strG40 = m3Var2.G();
                            break;
                        default:
                            if (map6 == null) {
                                map6 = new HashMap();
                            }
                            m3Var2.w(iLogger, map6, strR4);
                            break;
                    }
                }
                if (o5Var == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"type\"");
                    iLogger.d(p5.ERROR, "Missing required field \"type\"", illegalStateException);
                    throw illegalStateException;
                }
                e5 e5Var = new e5(o5Var, iNextInt, null, strG37, strG38, strG39, strG40, numU5, numU4 != null ? new bx1(3, numU4) : null);
                e5Var.A0 = map6;
                m3Var2.V();
                return e5Var;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                int i6 = 0;
                m3Var2.p0();
                f5 f5Var = new f5();
                ConcurrentHashMap concurrentHashMap8 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR16 = m3Var2.R();
                    strR16.getClass();
                    switch (strR16.hashCode()) {
                        case -1375934236:
                            i = strR16.equals("fingerprint") ? i6 : -1;
                            break;
                        case -1337936983:
                            i = strR16.equals("threads") ? 1 : -1;
                            break;
                        case -1097337456:
                            i = strR16.equals("logger") ? 2 : -1;
                            break;
                        case 55126294:
                            i = strR16.equals("timestamp") ? 3 : -1;
                            break;
                        case 102865796:
                            i = strR16.equals("level") ? 4 : -1;
                            break;
                        case 954925063:
                            i = strR16.equals("message") ? 5 : -1;
                            break;
                        case 1227433863:
                            i = strR16.equals("modules") ? 6 : -1;
                            break;
                        case 1481625679:
                            i = strR16.equals("exception") ? 7 : -1;
                            break;
                        case 2141246174:
                            i = strR16.equals("transaction") ? 8 : -1;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    switch (i) {
                        case 0:
                            List list3 = (List) m3Var2.o0();
                            if (list3 != null) {
                                f5Var.N0 = list3;
                            }
                            break;
                        case 1:
                            m3Var2.p0();
                            m3Var2.R();
                            f5Var.J0 = new g2(m3Var2.y0(iLogger, new io.sentry.protocol.d0(i6)));
                            m3Var2.V();
                            break;
                        case 2:
                            f5Var.I0 = m3Var2.G();
                            break;
                        case 3:
                            Date dateY4 = m3Var.Y(iLogger);
                            if (dateY4 != null) {
                                f5Var.G0 = dateY4;
                            }
                            break;
                        case 4:
                            f5Var.L0 = (p5) m3Var2.m0(iLogger, new f(i3));
                            break;
                        case 5:
                            f5Var.H0 = (io.sentry.protocol.p) m3Var2.m0(iLogger, new io.sentry.clientreport.a(i2));
                            break;
                        case 6:
                            f5Var.P0 = io.sentry.util.b.o((Map) m3Var2.o0());
                            break;
                        case 7:
                            m3Var2.p0();
                            m3Var2.R();
                            f5Var.K0 = new g2(m3Var2.y0(iLogger, new io.sentry.clientreport.a(22)));
                            m3Var2.V();
                            break;
                        case 8:
                            f5Var.M0 = m3Var2.G();
                            break;
                        default:
                            if (!io.sentry.config.a.b(f5Var, strR16, m3Var2, iLogger)) {
                                if (concurrentHashMap8 == null) {
                                    concurrentHashMap8 = new ConcurrentHashMap();
                                }
                                m3Var2.w(iLogger, concurrentHashMap8, strR16);
                            }
                            break;
                    }
                    i6 = 0;
                }
                f5Var.O0 = concurrentHashMap8;
                m3Var2.V();
                return f5Var;
            case 10:
                return o5.valueOfLabel(m3Var2.q().toLowerCase(Locale.ROOT));
            case 11:
                return p5.valueOf(m3Var2.q().toUpperCase(Locale.ROOT));
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                q5 q5Var = new q5();
                m3Var2.p0();
                ConcurrentHashMap concurrentHashMap9 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR5 = m3Var2.R();
                    strR5.getClass();
                    switch (strR5) {
                        case "package_name":
                            q5Var.z = m3Var2.G();
                            break;
                        case "thread_id":
                            q5Var.X = m3Var2.y();
                            break;
                        case "address":
                            q5Var.f = m3Var2.G();
                            break;
                        case "class_name":
                            q5Var.A = m3Var2.G();
                            break;
                        case "type":
                            q5Var.b = m3Var2.nextInt();
                            break;
                        default:
                            if (concurrentHashMap9 == null) {
                                concurrentHashMap9 = new ConcurrentHashMap();
                            }
                            m3Var2.w(iLogger, concurrentHashMap9, strR5);
                            break;
                    }
                }
                q5Var.Y = concurrentHashMap9;
                m3Var2.V();
                return q5Var;
            case 13:
                m3Var2.p0();
                Double dO4 = null;
                String strG41 = null;
                HashMap map7 = null;
                t5 t5Var = null;
                HashMap mapJ3 = null;
                Integer numU6 = null;
                d7 d7Var = null;
                io.sentry.protocol.w wVar7 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR6 = m3Var2.R();
                    strR6.getClass();
                    switch (strR6) {
                        case "span_id":
                            d7Var = (d7) m3Var2.m0(iLogger, new f(23));
                            break;
                        case "severity_number":
                            numU6 = m3Var2.u();
                            break;
                        case "body":
                            strG41 = m3Var2.G();
                            break;
                        case "timestamp":
                            dO4 = m3Var2.O();
                            break;
                        case "level":
                            t5Var = (t5) m3Var2.m0(iLogger, new f(16));
                            break;
                        case "attributes":
                            mapJ3 = m3Var2.J(iLogger, new f(14));
                            break;
                        case "trace_id":
                            wVar7 = (io.sentry.protocol.w) m3Var2.m0(iLogger, new io.sentry.clientreport.a(23));
                            break;
                        default:
                            if (map7 == null) {
                                map7 = new HashMap();
                            }
                            m3Var2.w(iLogger, map7, strR6);
                            break;
                    }
                }
                m3Var2.V();
                if (wVar7 == null) {
                    IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"trace_id\"");
                    iLogger.d(p5.ERROR, "Missing required field \"trace_id\"", illegalStateException2);
                    throw illegalStateException2;
                }
                if (dO4 == null) {
                    IllegalStateException illegalStateException3 = new IllegalStateException("Missing required field \"timestamp\"");
                    iLogger.d(p5.ERROR, "Missing required field \"timestamp\"", illegalStateException3);
                    throw illegalStateException3;
                }
                if (strG41 == null) {
                    IllegalStateException illegalStateException4 = new IllegalStateException("Missing required field \"body\"");
                    iLogger.d(p5.ERROR, "Missing required field \"body\"", illegalStateException4);
                    throw illegalStateException4;
                }
                if (t5Var == null) {
                    IllegalStateException illegalStateException5 = new IllegalStateException("Missing required field \"level\"");
                    iLogger.d(p5.ERROR, "Missing required field \"level\"", illegalStateException5);
                    throw illegalStateException5;
                }
                r5 r5Var = new r5(wVar7, dO4, strG41, t5Var);
                r5Var.Z = mapJ3;
                r5Var.Y = numU6;
                r5Var.f = d7Var;
                r5Var.y0 = map7;
                return r5Var;
            case 14:
                m3Var2.p0();
                Object objO0 = null;
                HashMap map8 = null;
                String strG42 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR17 = m3Var2.R();
                    strR17.getClass();
                    if (strR17.equals("type")) {
                        strG42 = m3Var2.G();
                    } else if (strR17.equals("value")) {
                        objO0 = m3Var2.o0();
                    } else {
                        if (map8 == null) {
                            map8 = new HashMap();
                        }
                        m3Var2.w(iLogger, map8, strR17);
                    }
                }
                m3Var2.V();
                if (strG42 != null) {
                    io.sentry.protocol.n nVar = new io.sentry.protocol.n(strG42, objO0);
                    nVar.A = map8;
                    return nVar;
                }
                IllegalStateException illegalStateException6 = new IllegalStateException("Missing required field \"type\"");
                iLogger.d(p5.ERROR, "Missing required field \"type\"", illegalStateException6);
                throw illegalStateException6;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                m3Var2.p0();
                HashMap map9 = null;
                ArrayList arrayListY02 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR18 = m3Var2.R();
                    strR18.getClass();
                    if (strR18.equals("items")) {
                        arrayListY02 = m3Var2.y0(iLogger, new f(13));
                    } else {
                        if (map9 == null) {
                            map9 = new HashMap();
                        }
                        m3Var2.w(iLogger, map9, strR18);
                    }
                }
                m3Var2.V();
                if (arrayListY02 != null) {
                    s5 s5Var = new s5(arrayListY02);
                    s5Var.f = map9;
                    return s5Var;
                }
                IllegalStateException illegalStateException7 = new IllegalStateException("Missing required field \"items\"");
                iLogger.d(p5.ERROR, "Missing required field \"items\"", illegalStateException7);
                throw illegalStateException7;
            case 16:
                return t5.valueOf(m3Var2.q().toUpperCase(Locale.ROOT));
            case 17:
                m3Var2.p0();
                Double dO5 = null;
                String strG43 = null;
                HashMap map10 = null;
                String strG44 = null;
                Double dO6 = null;
                HashMap mapJ4 = null;
                d7 d7Var2 = null;
                String strG45 = null;
                io.sentry.protocol.w wVar8 = null;
                while (true) {
                    HashMap map11 = map10;
                    if (m3Var2.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                        m3Var2.V();
                        if (wVar8 == null) {
                            IllegalStateException illegalStateException8 = new IllegalStateException("Missing required field \"trace_id\"");
                            iLogger.d(p5.ERROR, "Missing required field \"trace_id\"", illegalStateException8);
                            throw illegalStateException8;
                        }
                        if (dO5 == null) {
                            IllegalStateException illegalStateException9 = new IllegalStateException("Missing required field \"timestamp\"");
                            iLogger.d(p5.ERROR, "Missing required field \"timestamp\"", illegalStateException9);
                            throw illegalStateException9;
                        }
                        if (strG43 == null) {
                            IllegalStateException illegalStateException10 = new IllegalStateException("Missing required field \"type\"");
                            iLogger.d(p5.ERROR, "Missing required field \"type\"", illegalStateException10);
                            throw illegalStateException10;
                        }
                        if (strG44 == null) {
                            IllegalStateException illegalStateException11 = new IllegalStateException("Missing required field \"name\"");
                            iLogger.d(p5.ERROR, "Missing required field \"name\"", illegalStateException11);
                            throw illegalStateException11;
                        }
                        if (dO6 == null) {
                            IllegalStateException illegalStateException12 = new IllegalStateException("Missing required field \"value\"");
                            iLogger.d(p5.ERROR, "Missing required field \"value\"", illegalStateException12);
                            throw illegalStateException12;
                        }
                        v5 v5Var = new v5();
                        v5Var.b = wVar8;
                        v5Var.z = dO5;
                        v5Var.A = strG44;
                        v5Var.Y = strG43;
                        v5Var.Z = dO6;
                        v5Var.y0 = mapJ4;
                        v5Var.f = d7Var2;
                        v5Var.X = strG45;
                        v5Var.z0 = map11;
                        return v5Var;
                    }
                    strR7 = m3Var2.R();
                    strR7.getClass();
                    switch (strR7) {
                        case "span_id":
                            d7Var2 = (d7) m3Var2.m0(iLogger, new f(23));
                            break;
                        case "name":
                            strG44 = m3Var2.G();
                            break;
                        case "type":
                            strG43 = m3Var2.G();
                            break;
                        case "unit":
                            strG45 = m3Var2.G();
                            break;
                        case "timestamp":
                            dO5 = m3Var2.O();
                            break;
                        case "value":
                            dO6 = m3Var2.O();
                            break;
                        case "attributes":
                            mapJ4 = m3Var2.J(iLogger, new f(14));
                            break;
                        case "trace_id":
                            wVar8 = (io.sentry.protocol.w) m3Var2.m0(iLogger, new io.sentry.clientreport.a(23));
                            break;
                        default:
                            HashMap map12 = map11 == null ? new HashMap() : map11;
                            m3Var2.w(iLogger, map12, strR7);
                            map10 = map12;
                            continue;
                            break;
                    }
                    map10 = map11;
                }
                break;
            case 18:
                m3Var2.p0();
                HashMap map13 = null;
                ArrayList arrayListY03 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR19 = m3Var2.R();
                    strR19.getClass();
                    if (strR19.equals("items")) {
                        arrayListY03 = m3Var2.y0(iLogger, new f(i2));
                    } else {
                        if (map13 == null) {
                            map13 = new HashMap();
                        }
                        m3Var2.w(iLogger, map13, strR19);
                    }
                }
                m3Var2.V();
                if (arrayListY03 != null) {
                    w5 w5Var = new w5(arrayListY03);
                    w5Var.f = map13;
                    return w5Var;
                }
                IllegalStateException illegalStateException13 = new IllegalStateException("Missing required field \"items\"");
                iLogger.d(p5.ERROR, "Missing required field \"items\"", illegalStateException13);
                throw illegalStateException13;
            case 19:
                r6 r6Var = new r6();
                m3Var2.p0();
                q6 q6Var = null;
                Date dateY5 = null;
                HashMap map14 = null;
                io.sentry.protocol.w wVar9 = null;
                Date dateY6 = null;
                List list4 = null;
                List list5 = null;
                List list6 = null;
                String strG46 = null;
                List list7 = null;
                Integer numU7 = null;
                while (true) {
                    HashMap map15 = map14;
                    if (m3Var2.peek() != io.sentry.vendor.gson.stream.b.NAME) {
                        m3Var2.V();
                        if (strG46 != null) {
                            r6Var.H0 = strG46;
                        }
                        if (q6Var != null) {
                            r6Var.I0 = q6Var;
                        }
                        if (numU7 != null) {
                            r6Var.K0 = numU7.intValue();
                        }
                        if (dateY5 != null) {
                            r6Var.L0 = dateY5;
                        }
                        r6Var.J0 = wVar9;
                        r6Var.M0 = dateY6;
                        r6Var.N0 = list4;
                        r6Var.O0 = list5;
                        r6Var.P0 = list6;
                        r6Var.Q0 = list7;
                        r6Var.R0 = map15;
                        return r6Var;
                    }
                    strR8 = m3Var2.R();
                    strR8.getClass();
                    switch (strR8) {
                        case "segment_names":
                            list7 = (List) m3Var2.o0();
                            map14 = map15;
                            break;
                        case "replay_id":
                            wVar9 = (io.sentry.protocol.w) m3Var2.m0(iLogger, new io.sentry.clientreport.a(23));
                            map14 = map15;
                            break;
                        case "replay_start_timestamp":
                            dateY6 = m3Var.Y(iLogger);
                            map14 = map15;
                            break;
                        case "type":
                            strG46 = m3Var2.G();
                            map14 = map15;
                            break;
                        case "urls":
                            list4 = (List) m3Var2.o0();
                            map14 = map15;
                            break;
                        case "timestamp":
                            dateY5 = m3Var.Y(iLogger);
                            map14 = map15;
                            break;
                        case "error_ids":
                            list5 = (List) m3Var2.o0();
                            map14 = map15;
                            break;
                        case "trace_ids":
                            list6 = (List) m3Var2.o0();
                            map14 = map15;
                            break;
                        case "replay_type":
                            q6Var = (q6) m3Var2.m0(iLogger, new f(20));
                            map14 = map15;
                            break;
                        case "segment_id":
                            numU7 = m3Var2.u();
                            map14 = map15;
                            break;
                        default:
                            if (!io.sentry.config.a.b(r6Var, strR8, m3Var2, iLogger)) {
                                HashMap map16 = map15 == null ? new HashMap() : map15;
                                m3Var2.w(iLogger, map16, strR8);
                                map14 = map16;
                                break;
                            } else {
                                map14 = map15;
                                break;
                            }
                            break;
                    }
                }
                break;
            case 20:
                return q6.valueOf(m3Var2.q().toUpperCase(Locale.ROOT));
            case 21:
                m3Var2.p0();
                String str3 = null;
                ConcurrentHashMap concurrentHashMap10 = null;
                y6 y6Var = null;
                Date dateY7 = null;
                Date dateY8 = null;
                String str4 = null;
                Long lY5 = null;
                Boolean boolB010 = null;
                Double dO7 = null;
                String strG47 = null;
                String strG48 = null;
                Integer numU8 = null;
                String strG49 = null;
                String strG50 = null;
                String strG51 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR9 = m3Var2.R();
                    strR9.getClass();
                    switch (strR9) {
                        case "duration":
                            y6VarValueOf = y6Var;
                            dO7 = m3Var2.O();
                            strG = str3;
                            break;
                        case "started":
                            y6VarValueOf = y6Var;
                            dateY7 = m3Var.Y(iLogger);
                            strG = str3;
                            break;
                        case "errors":
                            y6VarValueOf = y6Var;
                            numU8 = m3Var2.u();
                            strG = str3;
                            break;
                        case "status":
                            y6VarValueOf = y6Var;
                            date = dateY7;
                            String strA = io.sentry.util.p.a(m3Var2.G());
                            if (strA != null) {
                                y6VarValueOf = y6.valueOf(strA);
                                dateY7 = date;
                                strG = str3;
                                break;
                            }
                            strG = str3;
                            dateY7 = date;
                            break;
                        case "did":
                            y6VarValueOf = y6Var;
                            strG = m3Var2.G();
                            break;
                        case "seq":
                            y6VarValueOf = y6Var;
                            lY5 = m3Var2.y();
                            strG = str3;
                            break;
                        case "sid":
                            String strG52 = m3Var2.G();
                            if (strG52 != null) {
                                y6VarValueOf = y6Var;
                                if (strG52.length() == 36 || strG52.length() == 32) {
                                    strG = str3;
                                    str4 = strG52;
                                }
                                break;
                            } else {
                                y6VarValueOf = y6Var;
                            }
                            date = dateY7;
                            iLogger.h(p5.ERROR, "%s sid is not valid.", strG52);
                            strG = str3;
                            dateY7 = date;
                            break;
                        case "init":
                            y6VarValueOf = y6Var;
                            boolB010 = m3Var2.b0();
                            strG = str3;
                            break;
                        case "timestamp":
                            dateY8 = m3Var.Y(iLogger);
                            y6VarValueOf = y6Var;
                            strG = str3;
                            break;
                        case "attrs":
                            m3Var2.p0();
                            while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                                String strR20 = m3Var2.R();
                                strR20.getClass();
                                switch (strR20) {
                                    case "environment":
                                        strG51 = m3Var2.G();
                                        break;
                                    case "release":
                                        strG47 = m3Var2.G();
                                        break;
                                    case "ip_address":
                                        strG49 = m3Var2.G();
                                        break;
                                    case "user_agent":
                                        strG50 = m3Var2.G();
                                        break;
                                    default:
                                        m3Var2.t();
                                        break;
                                }
                            }
                            m3Var2.V();
                            y6VarValueOf = y6Var;
                            strG = str3;
                            break;
                        case "abnormal_mechanism":
                            y6VarValueOf = y6Var;
                            strG48 = m3Var2.G();
                            strG = str3;
                            break;
                        default:
                            if (concurrentHashMap10 == null) {
                                concurrentHashMap10 = new ConcurrentHashMap();
                            }
                            m3Var2.w(iLogger, concurrentHashMap10, strR9);
                            y6VarValueOf = y6Var;
                            strG = str3;
                            break;
                    }
                    str3 = strG;
                    y6Var = y6VarValueOf;
                }
                y6 y6Var2 = y6Var;
                Date date4 = dateY7;
                if (y6Var2 == null) {
                    throw e("status", iLogger);
                }
                if (date4 == null) {
                    throw e("started", iLogger);
                }
                if (numU8 == null) {
                    throw e("errors", iLogger);
                }
                if (strG47 == null) {
                    throw e(BuildConfig.BUILD_TYPE, iLogger);
                }
                z6 z6Var = new z6(y6Var2, date4, dateY8, numU8.intValue(), str3, str4, boolB010, lY5, dO7, strG49, strG50, strG51, strG47, strG48);
                z6Var.G0 = concurrentHashMap10;
                m3Var2.V();
                return z6Var;
            case 22:
                return b(m3Var, iLogger);
            case 23:
                return new d7(m3Var2.q());
            case 24:
                return c(m3Var, iLogger);
            case 25:
                return d(m3Var, iLogger);
            default:
                m3Var2.p0();
                io.sentry.protocol.w wVar10 = null;
                String strG53 = null;
                String strG54 = null;
                String strG55 = null;
                HashMap map17 = null;
                while (m3Var2.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR10 = m3Var2.R();
                    strR10.getClass();
                    switch (strR10) {
                        case "comments":
                            strG55 = m3Var2.G();
                            break;
                        case "name":
                            strG53 = m3Var2.G();
                            break;
                        case "email":
                            strG54 = m3Var2.G();
                            break;
                        case "event_id":
                            wVar10 = new io.sentry.protocol.w(m3Var2.q());
                            break;
                        default:
                            if (map17 == null) {
                                map17 = new HashMap();
                            }
                            m3Var2.w(iLogger, map17, strR10);
                            break;
                    }
                }
                m3Var2.V();
                if (wVar10 != null) {
                    m7 m7Var = new m7(wVar10, strG53, strG54, strG55);
                    m7Var.X = map17;
                    return m7Var;
                }
                IllegalStateException illegalStateException14 = new IllegalStateException("Missing required field \"event_id\"");
                iLogger.d(p5.ERROR, "Missing required field \"event_id\"", illegalStateException14);
                throw illegalStateException14;
        }
    }
}
