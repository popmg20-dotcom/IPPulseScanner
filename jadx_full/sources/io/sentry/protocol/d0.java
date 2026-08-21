package io.sentry.protocol;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.ILogger;
import io.sentry.m3;
import io.sentry.p5;
import io.sentry.x1;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements x1 {
    public final /* synthetic */ int a;

    public /* synthetic */ d0(int i) {
        this.a = i;
    }

    public static io.sentry.rrweb.a b(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        io.sentry.rrweb.a aVar = new io.sentry.rrweb.a();
        HashMap map = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            String strR2 = m3Var.R();
            strR2.getClass();
            if (strR2.equals("data")) {
                m3Var.p0();
                ConcurrentHashMap concurrentHashMap = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR3 = m3Var.R();
                    strR3.getClass();
                    if (strR3.equals("payload")) {
                        m3Var.p0();
                        ConcurrentHashMap concurrentHashMap2 = null;
                        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                            strR = m3Var.R();
                            strR.getClass();
                            switch (strR) {
                                case "data":
                                    ConcurrentHashMap concurrentHashMapO = io.sentry.util.b.o((Map) m3Var.o0());
                                    if (concurrentHashMapO == null) {
                                        break;
                                    } else {
                                        aVar.z0 = concurrentHashMapO;
                                        break;
                                    }
                                    break;
                                case "type":
                                    aVar.X = m3Var.G();
                                    break;
                                case "category":
                                    aVar.Y = m3Var.G();
                                    break;
                                case "timestamp":
                                    aVar.A = m3Var.nextDouble();
                                    break;
                                case "level":
                                    try {
                                        aVar.y0 = p5.valueOf(m3Var.q().toUpperCase(Locale.ROOT));
                                        break;
                                    } catch (Exception e) {
                                        iLogger.b(p5.DEBUG, e, "Error when deserializing SentryLevel", new Object[0]);
                                        break;
                                    }
                                    break;
                                case "message":
                                    aVar.Z = m3Var.G();
                                    break;
                                default:
                                    if (concurrentHashMap2 == null) {
                                        concurrentHashMap2 = new ConcurrentHashMap();
                                    }
                                    m3Var.w(iLogger, concurrentHashMap2, strR);
                                    break;
                            }
                        }
                        aVar.B0 = concurrentHashMap2;
                        m3Var.V();
                    } else if (strR3.equals("tag")) {
                        String strG = m3Var.G();
                        if (strG == null) {
                            strG = "";
                        }
                        aVar.z = strG;
                    } else {
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        m3Var.w(iLogger, concurrentHashMap, strR3);
                    }
                }
                aVar.C0 = concurrentHashMap;
                m3Var.V();
            } else if (strR2.equals("type")) {
                io.sentry.rrweb.c cVar = (io.sentry.rrweb.c) m3Var.m0(iLogger, new d0(10));
                io.sentry.util.b.r(cVar, "");
                aVar.b = cVar;
            } else if (strR2.equals("timestamp")) {
                aVar.f = m3Var.nextLong();
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                m3Var.w(iLogger, map, strR2);
            }
        }
        aVar.A0 = map;
        m3Var.V();
        return aVar;
    }

    public static io.sentry.rrweb.g c(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        io.sentry.rrweb.g gVar = new io.sentry.rrweb.g();
        HashMap map = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            String strR2 = m3Var.R();
            strR2.getClass();
            if (strR2.equals("data")) {
                m3Var.p0();
                HashMap map2 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR = m3Var.R();
                    strR.getClass();
                    switch (strR) {
                        case "x":
                            gVar.Y = m3Var.nextFloat();
                            break;
                        case "y":
                            gVar.Z = m3Var.nextFloat();
                            break;
                        case "id":
                            gVar.X = m3Var.nextInt();
                            break;
                        case "type":
                            gVar.A = (io.sentry.rrweb.f) m3Var.m0(iLogger, new d0(13));
                            break;
                        case "pointerType":
                            gVar.y0 = m3Var.nextInt();
                            break;
                        case "pointerId":
                            gVar.z0 = m3Var.nextInt();
                            break;
                        default:
                            if (!strR.equals("source")) {
                                if (map2 == null) {
                                    map2 = new HashMap();
                                }
                                m3Var.w(iLogger, map2, strR);
                                break;
                            } else {
                                io.sentry.rrweb.d dVar = (io.sentry.rrweb.d) m3Var.m0(iLogger, new d0(11));
                                io.sentry.util.b.r(dVar, "");
                                gVar.z = dVar;
                                break;
                            }
                            break;
                    }
                }
                gVar.B0 = map2;
                m3Var.V();
            } else if (strR2.equals("type")) {
                io.sentry.rrweb.c cVar = (io.sentry.rrweb.c) m3Var.m0(iLogger, new d0(10));
                io.sentry.util.b.r(cVar, "");
                gVar.b = cVar;
            } else if (strR2.equals("timestamp")) {
                gVar.f = m3Var.nextLong();
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                m3Var.w(iLogger, map, strR2);
            }
        }
        gVar.A0 = map;
        m3Var.V();
        return gVar;
    }

    public static io.sentry.rrweb.i d(m3 m3Var, ILogger iLogger) {
        m3Var.p0();
        io.sentry.rrweb.i iVar = new io.sentry.rrweb.i();
        HashMap map = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            String strR = m3Var.R();
            strR.getClass();
            if (strR.equals("data")) {
                m3Var.p0();
                HashMap map2 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR2 = m3Var.R();
                    strR2.getClass();
                    if (strR2.equals("pointerId")) {
                        iVar.A = m3Var.nextInt();
                    } else if (strR2.equals("positions")) {
                        iVar.X = m3Var.y0(iLogger, new d0(15));
                    } else if (strR2.equals("source")) {
                        io.sentry.rrweb.d dVar = (io.sentry.rrweb.d) m3Var.m0(iLogger, new d0(11));
                        io.sentry.util.b.r(dVar, "");
                        iVar.z = dVar;
                    } else {
                        if (map2 == null) {
                            map2 = new HashMap();
                        }
                        m3Var.w(iLogger, map2, strR2);
                    }
                }
                iVar.Z = map2;
                m3Var.V();
            } else if (strR.equals("type")) {
                io.sentry.rrweb.c cVar = (io.sentry.rrweb.c) m3Var.m0(iLogger, new d0(10));
                io.sentry.util.b.r(cVar, "");
                iVar.b = cVar;
            } else if (strR.equals("timestamp")) {
                iVar.f = m3Var.nextLong();
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                m3Var.w(iLogger, map, strR);
            }
        }
        iVar.Y = map;
        m3Var.V();
        return iVar;
    }

    public static io.sentry.rrweb.j e(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        io.sentry.rrweb.j jVar = new io.sentry.rrweb.j();
        HashMap map = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            String strR2 = m3Var.R();
            strR2.getClass();
            if (strR2.equals("data")) {
                m3Var.p0();
                AbstractMap concurrentHashMap = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR = m3Var.R();
                    strR.getClass();
                    switch (strR) {
                        case "height":
                            Integer numU = m3Var.u();
                            jVar.A = numU != null ? numU.intValue() : 0;
                            break;
                        case "href":
                            String strG = m3Var.G();
                            if (strG == null) {
                                strG = "";
                            }
                            jVar.z = strG;
                            break;
                        case "width":
                            Integer numU2 = m3Var.u();
                            jVar.X = numU2 != null ? numU2.intValue() : 0;
                            break;
                        default:
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            m3Var.w(iLogger, concurrentHashMap, strR);
                            break;
                    }
                }
                m3Var.V();
            } else if (strR2.equals("type")) {
                io.sentry.rrweb.c cVar = (io.sentry.rrweb.c) m3Var.m0(iLogger, new d0(10));
                io.sentry.util.b.r(cVar, "");
                jVar.b = cVar;
            } else if (strR2.equals("timestamp")) {
                jVar.f = m3Var.nextLong();
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                m3Var.w(iLogger, map, strR2);
            }
        }
        jVar.Y = map;
        m3Var.V();
        return jVar;
    }

    public static io.sentry.rrweb.l f(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        io.sentry.rrweb.l lVar = new io.sentry.rrweb.l();
        HashMap map = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            String strR2 = m3Var.R();
            strR2.getClass();
            if (strR2.equals("data")) {
                m3Var.p0();
                ConcurrentHashMap concurrentHashMap = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR3 = m3Var.R();
                    strR3.getClass();
                    if (strR3.equals("payload")) {
                        m3Var.p0();
                        ConcurrentHashMap concurrentHashMap2 = null;
                        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                            strR = m3Var.R();
                            strR.getClass();
                            switch (strR) {
                                case "description":
                                    lVar.X = m3Var.G();
                                    break;
                                case "endTimestamp":
                                    lVar.Z = m3Var.nextDouble();
                                    break;
                                case "startTimestamp":
                                    lVar.Y = m3Var.nextDouble();
                                    break;
                                case "op":
                                    lVar.A = m3Var.G();
                                    break;
                                case "data":
                                    ConcurrentHashMap concurrentHashMapO = io.sentry.util.b.o((Map) m3Var.o0());
                                    if (concurrentHashMapO == null) {
                                        break;
                                    } else {
                                        lVar.y0 = concurrentHashMapO;
                                        break;
                                    }
                                    break;
                                default:
                                    if (concurrentHashMap2 == null) {
                                        concurrentHashMap2 = new ConcurrentHashMap();
                                    }
                                    m3Var.w(iLogger, concurrentHashMap2, strR);
                                    break;
                            }
                        }
                        lVar.A0 = concurrentHashMap2;
                        m3Var.V();
                    } else if (strR3.equals("tag")) {
                        String strG = m3Var.G();
                        if (strG == null) {
                            strG = "";
                        }
                        lVar.z = strG;
                    } else {
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        m3Var.w(iLogger, concurrentHashMap, strR3);
                    }
                }
                lVar.B0 = concurrentHashMap;
                m3Var.V();
            } else if (strR2.equals("type")) {
                io.sentry.rrweb.c cVar = (io.sentry.rrweb.c) m3Var.m0(iLogger, new d0(10));
                io.sentry.util.b.r(cVar, "");
                lVar.b = cVar;
            } else if (strR2.equals("timestamp")) {
                lVar.f = m3Var.nextLong();
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                m3Var.w(iLogger, map, strR2);
            }
        }
        lVar.z0 = map;
        m3Var.V();
        return lVar;
    }

    public static io.sentry.rrweb.m g(m3 m3Var, ILogger iLogger) {
        String strR;
        m3Var.p0();
        io.sentry.rrweb.m mVar = new io.sentry.rrweb.m();
        HashMap map = null;
        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
            String strR2 = m3Var.R();
            strR2.getClass();
            int i = 10;
            if (strR2.equals("data")) {
                m3Var.p0();
                ConcurrentHashMap concurrentHashMap = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR3 = m3Var.R();
                    strR3.getClass();
                    if (strR3.equals("payload")) {
                        m3Var.p0();
                        ConcurrentHashMap concurrentHashMap2 = null;
                        while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                            strR = m3Var.R();
                            strR.getClass();
                            switch (strR) {
                                case "duration":
                                    mVar.Y = m3Var.nextLong();
                                    break;
                                case "segmentId":
                                    mVar.A = m3Var.nextInt();
                                    break;
                                case "height":
                                    Integer numU = m3Var.u();
                                    mVar.z0 = numU != null ? numU.intValue() : 0;
                                    break;
                                case "container":
                                    String strG = m3Var.G();
                                    if (strG == null) {
                                        strG = "";
                                    }
                                    mVar.y0 = strG;
                                    break;
                                case "frameCount":
                                    Integer numU2 = m3Var.u();
                                    mVar.B0 = numU2 != null ? numU2.intValue() : 0;
                                    break;
                                case "top":
                                    Integer numU3 = m3Var.u();
                                    mVar.F0 = numU3 != null ? numU3.intValue() : 0;
                                    break;
                                case "left":
                                    Integer numU4 = m3Var.u();
                                    mVar.E0 = numU4 != null ? numU4.intValue() : 0;
                                    break;
                                case "size":
                                    Long lY = m3Var.y();
                                    mVar.X = lY == null ? 0L : lY.longValue();
                                    break;
                                case "width":
                                    Integer numU5 = m3Var.u();
                                    mVar.A0 = numU5 != null ? numU5.intValue() : 0;
                                    break;
                                case "frameRate":
                                    Integer numU6 = m3Var.u();
                                    mVar.D0 = numU6 != null ? numU6.intValue() : 0;
                                    break;
                                case "encoding":
                                    String strG2 = m3Var.G();
                                    if (strG2 == null) {
                                        strG2 = "";
                                    }
                                    mVar.Z = strG2;
                                    break;
                                case "frameRateType":
                                    String strG3 = m3Var.G();
                                    if (strG3 == null) {
                                        strG3 = "";
                                    }
                                    mVar.C0 = strG3;
                                    break;
                                default:
                                    if (concurrentHashMap2 == null) {
                                        concurrentHashMap2 = new ConcurrentHashMap();
                                    }
                                    m3Var.w(iLogger, concurrentHashMap2, strR);
                                    break;
                            }
                        }
                        mVar.H0 = concurrentHashMap2;
                        m3Var.V();
                    } else if (strR3.equals("tag")) {
                        String strG4 = m3Var.G();
                        if (strG4 == null) {
                            strG4 = "";
                        }
                        mVar.z = strG4;
                    } else {
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        m3Var.w(iLogger, concurrentHashMap, strR3);
                    }
                }
                mVar.I0 = concurrentHashMap;
                m3Var.V();
            } else if (strR2.equals("type")) {
                io.sentry.rrweb.c cVar = (io.sentry.rrweb.c) m3Var.m0(iLogger, new d0(i));
                io.sentry.util.b.r(cVar, "");
                mVar.b = cVar;
            } else if (strR2.equals("timestamp")) {
                mVar.f = m3Var.nextLong();
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                m3Var.w(iLogger, map, strR2);
            }
        }
        mVar.G0 = map;
        m3Var.V();
        return mVar;
    }

    @Override // io.sentry.x1
    public final Object a(m3 m3Var, ILogger iLogger) {
        String strR;
        String strR2;
        String strR3;
        String strR4;
        String strR5;
        String strR6;
        String strR7;
        String strR8;
        int i = 7;
        int i2 = 8;
        int i3 = 4;
        int i4 = 6;
        switch (this.a) {
            case 0:
                e0 e0Var = new e0();
                m3Var.p0();
                ConcurrentHashMap concurrentHashMap = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR = m3Var.R();
                    strR.getClass();
                    switch (strR) {
                        case "daemon":
                            e0Var.Z = m3Var.b0();
                            break;
                        case "priority":
                            e0Var.f = m3Var.u();
                            break;
                        case "held_locks":
                            HashMap mapJ = m3Var.J(iLogger, new io.sentry.f(12));
                            if (mapJ != null) {
                                e0Var.A0 = new HashMap(mapJ);
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "id":
                            e0Var.b = m3Var.y();
                            break;
                        case "main":
                            e0Var.y0 = m3Var.b0();
                            break;
                        case "name":
                            e0Var.z = m3Var.G();
                            break;
                        case "state":
                            e0Var.A = m3Var.G();
                            break;
                        case "crashed":
                            e0Var.X = m3Var.b0();
                            break;
                        case "current":
                            e0Var.Y = m3Var.b0();
                            break;
                        case "stacktrace":
                            e0Var.z0 = (c0) m3Var.m0(iLogger, new io.sentry.clientreport.a(28));
                            break;
                        default:
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            m3Var.w(iLogger, concurrentHashMap, strR);
                            break;
                    }
                }
                e0Var.B0 = concurrentHashMap;
                m3Var.V();
                return e0Var;
            case 1:
                m3Var.p0();
                f0 f0Var = new f0(new ArrayList(), new HashMap(), new h0(i0.CUSTOM.apiName()));
                ConcurrentHashMap concurrentHashMap2 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR2 = m3Var.R();
                    strR2.getClass();
                    switch (strR2) {
                        case "start_timestamp":
                            try {
                                Double dO = m3Var.O();
                                if (dO != null) {
                                    f0Var.H0 = dO;
                                }
                                break;
                            } catch (NumberFormatException unused) {
                                if (m3Var.Y(iLogger) != null) {
                                    f0Var.H0 = Double.valueOf(r6.getTime() / 1000.0d);
                                }
                                break;
                            }
                            break;
                        case "measurements":
                            HashMap mapJ2 = m3Var.J(iLogger, new io.sentry.clientreport.a(15));
                            if (mapJ2 != null) {
                                f0Var.K0.putAll(mapJ2);
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "type":
                            m3Var.q();
                            break;
                        case "timestamp":
                            try {
                                Double dO2 = m3Var.O();
                                if (dO2 != null) {
                                    f0Var.I0 = dO2;
                                }
                                break;
                            } catch (NumberFormatException unused2) {
                                if (m3Var.Y(iLogger) != null) {
                                    f0Var.I0 = Double.valueOf(r6.getTime() / 1000.0d);
                                }
                                break;
                            }
                            break;
                        case "spans":
                            ArrayList arrayListY0 = m3Var.y0(iLogger, new io.sentry.clientreport.a(26));
                            if (arrayListY0 != null) {
                                f0Var.J0.addAll(arrayListY0);
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "transaction_info":
                            m3Var.p0();
                            String strG = null;
                            ConcurrentHashMap concurrentHashMap3 = null;
                            while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                                String strR9 = m3Var.R();
                                strR9.getClass();
                                if (strR9.equals("source")) {
                                    strG = m3Var.G();
                                } else {
                                    if (concurrentHashMap3 == null) {
                                        concurrentHashMap3 = new ConcurrentHashMap();
                                    }
                                    m3Var.w(iLogger, concurrentHashMap3, strR9);
                                }
                            }
                            h0 h0Var = new h0(strG);
                            h0Var.f = concurrentHashMap3;
                            m3Var.V();
                            f0Var.L0 = h0Var;
                            break;
                        case "transaction":
                            f0Var.G0 = m3Var.G();
                            break;
                        default:
                            if (io.sentry.config.a.b(f0Var, strR2, m3Var, iLogger)) {
                                break;
                            } else {
                                if (concurrentHashMap2 == null) {
                                    concurrentHashMap2 = new ConcurrentHashMap();
                                }
                                m3Var.w(iLogger, concurrentHashMap2, strR2);
                                break;
                            }
                            break;
                    }
                }
                f0Var.M0 = concurrentHashMap2;
                m3Var.V();
                return f0Var;
            case 2:
                m3Var.p0();
                j0 j0Var = new j0();
                ConcurrentHashMap concurrentHashMap4 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR3 = m3Var.R();
                    strR3.getClass();
                    switch (strR3) {
                        case "username":
                            j0Var.z = m3Var.G();
                            break;
                        case "id":
                            j0Var.f = m3Var.G();
                            break;
                        case "geo":
                            m3Var.p0();
                            l lVar = new l();
                            ConcurrentHashMap concurrentHashMap5 = null;
                            while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                                strR4 = m3Var.R();
                                strR4.getClass();
                                switch (strR4) {
                                    case "region":
                                        lVar.z = m3Var.G();
                                        break;
                                    case "city":
                                        lVar.b = m3Var.G();
                                        break;
                                    case "country_code":
                                        lVar.f = m3Var.G();
                                        break;
                                    default:
                                        if (concurrentHashMap5 == null) {
                                            concurrentHashMap5 = new ConcurrentHashMap();
                                        }
                                        m3Var.w(iLogger, concurrentHashMap5, strR4);
                                        break;
                                }
                            }
                            lVar.A = concurrentHashMap5;
                            m3Var.V();
                            j0Var.Y = lVar;
                            break;
                        case "data":
                            j0Var.Z = io.sentry.util.b.o((Map) m3Var.o0());
                            break;
                        case "name":
                            j0Var.X = m3Var.G();
                            break;
                        case "email":
                            j0Var.b = m3Var.G();
                            break;
                        case "ip_address":
                            j0Var.A = m3Var.G();
                            break;
                        default:
                            if (concurrentHashMap4 == null) {
                                concurrentHashMap4 = new ConcurrentHashMap();
                            }
                            m3Var.w(iLogger, concurrentHashMap4, strR3);
                            break;
                    }
                }
                j0Var.y0 = concurrentHashMap4;
                m3Var.V();
                return j0Var;
            case 3:
                m3Var.p0();
                String strG2 = null;
                ArrayList arrayListY02 = null;
                HashMap map = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR10 = m3Var.R();
                    strR10.getClass();
                    if (strR10.equals("rendering_system")) {
                        strG2 = m3Var.G();
                    } else if (strR10.equals("windows")) {
                        arrayListY02 = m3Var.y0(iLogger, new d0(i3));
                    } else {
                        if (map == null) {
                            map = new HashMap();
                        }
                        m3Var.w(iLogger, map, strR10);
                    }
                }
                m3Var.V();
                k0 k0Var = new k0(strG2, arrayListY02);
                k0Var.z = map;
                return k0Var;
            case 4:
                l0 l0Var = new l0();
                m3Var.p0();
                HashMap map2 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR5 = m3Var.R();
                    strR5.getClass();
                    switch (strR5) {
                        case "rendering_system":
                            l0Var.b = m3Var.G();
                            break;
                        case "identifier":
                            l0Var.z = m3Var.G();
                            break;
                        case "height":
                            l0Var.Y = m3Var.O();
                            break;
                        case "x":
                            l0Var.Z = m3Var.O();
                            break;
                        case "y":
                            l0Var.y0 = m3Var.O();
                            break;
                        case "tag":
                            l0Var.A = m3Var.G();
                            break;
                        case "type":
                            l0Var.f = m3Var.G();
                            break;
                        case "alpha":
                            l0Var.A0 = m3Var.O();
                            break;
                        case "width":
                            l0Var.X = m3Var.O();
                            break;
                        case "children":
                            l0Var.B0 = m3Var.y0(iLogger, this);
                            break;
                        case "visibility":
                            l0Var.z0 = m3Var.G();
                            break;
                        default:
                            if (map2 == null) {
                                map2 = new HashMap();
                            }
                            m3Var.w(iLogger, map2, strR5);
                            break;
                    }
                }
                m3Var.V();
                l0Var.C0 = map2;
                return l0Var;
            case 5:
                m3Var.p0();
                io.sentry.protocol.profiling.a aVar = new io.sentry.protocol.profiling.a();
                ConcurrentHashMap concurrentHashMap6 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR6 = m3Var.R();
                    strR6.getClass();
                    switch (strR6) {
                        case "frames":
                            ArrayList arrayListY03 = m3Var.y0(iLogger, new io.sentry.clientreport.a(27));
                            if (arrayListY03 != null) {
                                aVar.z = arrayListY03;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "stacks":
                            List list = (List) m3Var.m0(iLogger, new d0(i4));
                            if (list != null) {
                                aVar.f = list;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "samples":
                            ArrayList arrayListY04 = m3Var.y0(iLogger, new d0(i));
                            if (arrayListY04 != null) {
                                aVar.b = arrayListY04;
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "thread_metadata":
                            HashMap mapJ3 = m3Var.J(iLogger, new d0(i2));
                            if (mapJ3 != null) {
                                aVar.A = mapJ3;
                                break;
                            } else {
                                break;
                            }
                            break;
                        default:
                            if (concurrentHashMap6 == null) {
                                concurrentHashMap6 = new ConcurrentHashMap();
                            }
                            m3Var.w(iLogger, concurrentHashMap6, strR6);
                            break;
                    }
                }
                aVar.X = concurrentHashMap6;
                m3Var.V();
                return aVar;
            case 6:
                ArrayList arrayList = new ArrayList();
                m3Var.B0();
                while (m3Var.hasNext()) {
                    ArrayList arrayList2 = new ArrayList();
                    m3Var.B0();
                    while (m3Var.hasNext()) {
                        arrayList2.add(Integer.valueOf(m3Var.nextInt()));
                    }
                    m3Var.w0();
                    arrayList.add(arrayList2);
                }
                m3Var.w0();
                return arrayList;
            case 7:
                m3Var.p0();
                io.sentry.protocol.profiling.b bVar = new io.sentry.protocol.profiling.b();
                HashMap map3 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR7 = m3Var.R();
                    strR7.getClass();
                    switch (strR7) {
                        case "thread_id":
                            bVar.z = m3Var.G();
                            break;
                        case "timestamp":
                            bVar.b = m3Var.nextDouble();
                            break;
                        case "stack_id":
                            bVar.f = m3Var.nextInt();
                            break;
                        default:
                            if (map3 == null) {
                                map3 = new HashMap();
                            }
                            m3Var.w(iLogger, map3, strR7);
                            break;
                    }
                }
                bVar.A = map3;
                m3Var.V();
                return bVar;
            case 8:
                m3Var.p0();
                io.sentry.protocol.profiling.c cVar = new io.sentry.protocol.profiling.c();
                HashMap map4 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR11 = m3Var.R();
                    strR11.getClass();
                    if (strR11.equals("priority")) {
                        cVar.f = m3Var.nextInt();
                    } else if (strR11.equals("name")) {
                        cVar.b = m3Var.G();
                    } else {
                        if (map4 == null) {
                            map4 = new HashMap();
                        }
                        m3Var.w(iLogger, map4, strR11);
                    }
                }
                cVar.z = map4;
                m3Var.V();
                return cVar;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return b(m3Var, iLogger);
            case 10:
                return io.sentry.rrweb.c.values()[m3Var.nextInt()];
            case 11:
                return io.sentry.rrweb.d.values()[m3Var.nextInt()];
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return c(m3Var, iLogger);
            case 13:
                return io.sentry.rrweb.f.values()[m3Var.nextInt()];
            case 14:
                return d(m3Var, iLogger);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                m3Var.p0();
                io.sentry.rrweb.h hVar = new io.sentry.rrweb.h();
                HashMap map5 = null;
                while (m3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    strR8 = m3Var.R();
                    strR8.getClass();
                    switch (strR8) {
                        case "x":
                            hVar.f = m3Var.nextFloat();
                            break;
                        case "y":
                            hVar.z = m3Var.nextFloat();
                            break;
                        case "id":
                            hVar.b = m3Var.nextInt();
                            break;
                        case "timeOffset":
                            hVar.A = m3Var.nextLong();
                            break;
                        default:
                            if (map5 == null) {
                                map5 = new HashMap();
                            }
                            m3Var.w(iLogger, map5, strR8);
                            break;
                    }
                }
                hVar.X = map5;
                m3Var.V();
                return hVar;
            case 16:
                return e(m3Var, iLogger);
            case 17:
                return f(m3Var, iLogger);
            default:
                return g(m3Var, iLogger);
        }
    }
}
