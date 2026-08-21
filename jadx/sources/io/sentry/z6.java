package io.sentry;

import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.conscrypt.BuildConfig;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z6 implements k2 {
    public final String A;
    public final String A0;
    public String B0;
    public final String C0;
    public final String D0;
    public String E0;
    public final io.sentry.util.a F0 = new io.sentry.util.a();
    public ConcurrentHashMap G0;
    public final String X;
    public Boolean Y;
    public y6 Z;
    public final Date b;
    public Date f;
    public Long y0;
    public final AtomicInteger z;
    public Double z0;

    public z6(y6 y6Var, Date date, Date date2, int i, String str, String str2, Boolean bool, Long l, Double d, String str3, String str4, String str5, String str6, String str7) {
        this.Z = y6Var;
        this.b = date;
        this.f = date2;
        this.z = new AtomicInteger(i);
        this.A = str;
        this.X = str2;
        this.Y = bool;
        this.y0 = l;
        this.z0 = d;
        this.A0 = str3;
        this.B0 = str4;
        this.C0 = str5;
        this.D0 = str6;
        this.E0 = str7;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final z6 clone() {
        return new z6(this.Z, this.b, this.f, this.z.get(), this.A, this.X, this.Y, this.y0, this.z0, this.A0, this.B0, this.C0, this.D0, this.E0);
    }

    public final void b(Date date) {
        io.sentry.util.a aVar = this.F0;
        aVar.g();
        try {
            this.Y = null;
            if (this.Z == y6.Ok) {
                this.Z = y6.Exited;
            }
            if (date != null) {
                this.f = date;
            } else {
                date = new Date();
                this.f = date;
            }
            this.z0 = Double.valueOf(Math.abs(date.getTime() - this.b.getTime()) / 1000.0d);
            long time = this.f.getTime();
            if (time < 0) {
                time = Math.abs(time);
            }
            this.y0 = Long.valueOf(time);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean c(y6 y6Var, String str, boolean z, String str2) {
        boolean z2;
        io.sentry.util.a aVar = this.F0;
        aVar.g();
        boolean z3 = true;
        if (y6Var != null) {
            try {
                this.Z = y6Var;
                z2 = true;
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } else {
            z2 = false;
        }
        if (str != null) {
            this.B0 = str;
            z2 = true;
        }
        if (z) {
            this.z.addAndGet(1);
            z2 = true;
        }
        if (str2 != null) {
            this.E0 = str2;
        } else {
            z3 = z2;
        }
        if (z3) {
            this.Y = null;
            Date date = new Date();
            this.f = date;
            long time = date.getTime();
            if (time < 0) {
                time = Math.abs(time);
            }
            this.y0 = Long.valueOf(time);
        }
        aVar.close();
        return z3;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        String str = this.X;
        if (str != null) {
            cVar.p("sid");
            cVar.y(str);
        }
        String str2 = this.A;
        if (str2 != null) {
            cVar.p("did");
            cVar.y(str2);
        }
        if (this.Y != null) {
            cVar.p("init");
            cVar.w(this.Y);
        }
        cVar.p("started");
        cVar.v(iLogger, this.b);
        cVar.p("status");
        cVar.v(iLogger, this.Z.name().toLowerCase(Locale.ROOT));
        if (this.y0 != null) {
            cVar.p(RtspHeaders.Values.SEQ);
            cVar.x(this.y0);
        }
        cVar.p("errors");
        cVar.u(this.z.intValue());
        if (this.z0 != null) {
            cVar.p("duration");
            cVar.x(this.z0);
        }
        if (this.f != null) {
            cVar.p("timestamp");
            cVar.v(iLogger, this.f);
        }
        if (this.E0 != null) {
            cVar.p("abnormal_mechanism");
            cVar.v(iLogger, this.E0);
        }
        cVar.p("attrs");
        cVar.k();
        cVar.p(BuildConfig.BUILD_TYPE);
        cVar.v(iLogger, this.D0);
        String str3 = this.C0;
        if (str3 != null) {
            cVar.p("environment");
            cVar.v(iLogger, str3);
        }
        String str4 = this.A0;
        if (str4 != null) {
            cVar.p("ip_address");
            cVar.v(iLogger, str4);
        }
        if (this.B0 != null) {
            cVar.p("user_agent");
            cVar.v(iLogger, this.B0);
        }
        cVar.m();
        ConcurrentHashMap concurrentHashMap = this.G0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.G0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
