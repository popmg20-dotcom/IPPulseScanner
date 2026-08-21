package io.sentry.profilemeasurements;

import io.sentry.ILogger;
import io.sentry.e;
import io.sentry.internal.debugmeta.c;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k2 {
    public ConcurrentHashMap b;
    public String f;
    public Collection z;

    public a(String str, AbstractCollection abstractCollection) {
        this.f = str;
        this.z = abstractCollection;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return io.sentry.util.b.i(this.b, aVar.b) && this.f.equals(aVar.f) && new ArrayList(this.z).equals(new ArrayList(aVar.z));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        c cVar = (c) n3Var;
        cVar.k();
        cVar.p("unit");
        cVar.v(iLogger, this.f);
        cVar.p("values");
        cVar.v(iLogger, this.z);
        ConcurrentHashMap concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.b, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
