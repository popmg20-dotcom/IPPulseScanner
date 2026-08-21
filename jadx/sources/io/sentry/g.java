package io.sentry;

import defpackage.xe;
import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g implements k2, Comparable {
    public static final Map B0 = Collections.EMPTY_MAP;
    public String A;
    public ConcurrentHashMap A0;
    public String X;
    public volatile Map Y;
    public String Z;
    public final Long b;
    public Date f;
    public String y0;
    public final Long z;
    public p5 z0;

    public g(g gVar) {
        ConcurrentHashMap concurrentHashMapO;
        this.Y = B0;
        this.z = Long.valueOf(System.nanoTime());
        this.f = gVar.f;
        this.b = gVar.b;
        this.A = gVar.A;
        this.X = gVar.X;
        this.Z = gVar.Z;
        this.y0 = gVar.y0;
        if (!gVar.Y.isEmpty() && (concurrentHashMapO = io.sentry.util.b.o(gVar.Y)) != null) {
            this.Y = concurrentHashMapO;
        }
        this.A0 = io.sentry.util.b.o(gVar.A0);
        this.z0 = gVar.z0;
    }

    public static boolean a(g gVar, g gVar2) {
        return gVar.c().getTime() == gVar2.c().getTime() && io.sentry.util.b.i(gVar.A, gVar2.A) && io.sentry.util.b.i(gVar.X, gVar2.X) && io.sentry.util.b.i(gVar.Z, gVar2.Z) && io.sentry.util.b.i(gVar.y0, gVar2.y0) && gVar.z0 == gVar2.z0;
    }

    public final Map b() {
        Map concurrentHashMap;
        Map map = this.Y;
        Map map2 = B0;
        if (map != map2) {
            return map;
        }
        synchronized (this) {
            try {
                concurrentHashMap = this.Y;
                if (concurrentHashMap == map2) {
                    concurrentHashMap = new ConcurrentHashMap();
                    this.Y = concurrentHashMap;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return concurrentHashMap;
    }

    public final Date c() {
        Date date = this.f;
        if (date != null) {
            return date;
        }
        Long l = this.b;
        if (l == null) {
            xe.q("No timestamp set for breadcrumb");
            return null;
        }
        Date date2 = new Date(l.longValue());
        this.f = date2;
        return date2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.z.compareTo(((g) obj).z);
    }

    public final void d(Object obj, String str) {
        if (str == null) {
            return;
        }
        if (obj != null) {
            b().put(str, obj);
            return;
        }
        Map map = this.Y;
        if (map != B0) {
            map.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return "http".equals(this.X) ? a(this, gVar) && io.sentry.util.b.i(this.Y.get("status_code"), gVar.Y.get("status_code")) && io.sentry.util.b.i(this.Y.get(RtspHeaders.Values.URL), gVar.Y.get(RtspHeaders.Values.URL)) && io.sentry.util.b.i(this.Y.get("method"), gVar.Y.get("method")) && io.sentry.util.b.i(this.Y.get("http.fragment"), gVar.Y.get("http.fragment")) && io.sentry.util.b.i(this.Y.get("http.query"), gVar.Y.get("http.query")) : a(this, gVar);
    }

    public final int hashCode() {
        return "http".equals(this.X) ? Arrays.hashCode(new Object[]{Long.valueOf(c().getTime()), this.A, this.X, this.Z, this.y0, this.z0, this.Y.get("status_code"), this.Y.get(RtspHeaders.Values.URL), this.Y.get("method"), this.Y.get("http.fragment"), this.Y.get("http.query")}) : Arrays.hashCode(new Object[]{Long.valueOf(c().getTime()), this.A, this.X, this.Z, this.y0, this.z0});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("timestamp");
        Long l = this.b;
        cVar.y(l != null ? io.sentry.vendor.a.f(l.longValue()) : io.sentry.vendor.a.f(c().getTime()));
        if (this.A != null) {
            cVar.p("message");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("type");
            cVar.y(this.X);
        }
        cVar.p("data");
        cVar.v(iLogger, this.Y);
        if (this.Z != null) {
            cVar.p("category");
            cVar.y(this.Z);
        }
        if (this.y0 != null) {
            cVar.p("origin");
            cVar.y(this.y0);
        }
        if (this.z0 != null) {
            cVar.p("level");
            cVar.v(iLogger, this.z0);
        }
        ConcurrentHashMap concurrentHashMap = this.A0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.A0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }

    public g(long j) {
        this.Y = B0;
        this.z = Long.valueOf(System.nanoTime());
        this.b = Long.valueOf(j);
        this.f = null;
    }

    public g(Date date) {
        this.Y = B0;
        this.z = Long.valueOf(System.nanoTime());
        this.f = date;
        this.b = null;
    }

    public g() {
        this(System.currentTimeMillis());
    }
}
