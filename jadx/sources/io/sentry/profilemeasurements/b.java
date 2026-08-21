package io.sentry.profilemeasurements;

import io.sentry.ILogger;
import io.sentry.e;
import io.sentry.internal.debugmeta.c;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements k2 {
    public double A;
    public ConcurrentHashMap b;
    public double f;
    public String z;

    public b(Long l, Number number, long j) {
        this.z = l.toString();
        this.A = number.doubleValue();
        this.f = j / 1.0E9d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return io.sentry.util.b.i(this.b, bVar.b) && this.z.equals(bVar.z) && this.A == bVar.A && this.f == bVar.f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.z, Double.valueOf(this.A)});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        c cVar = (c) n3Var;
        cVar.k();
        cVar.p("value");
        cVar.v(iLogger, Double.valueOf(this.A));
        cVar.p("elapsed_since_start_ns");
        cVar.v(iLogger, this.z);
        cVar.p("timestamp");
        cVar.v(iLogger, io.sentry.config.a.c(this.f));
        ConcurrentHashMap concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.b, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
