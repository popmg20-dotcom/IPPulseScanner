package io.sentry.clientreport;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e implements k2 {
    public HashMap A;
    public final String b;
    public final String f;
    public final Long z;

    public e(String str, String str2, Long l) {
        this.b = str;
        this.f = str2;
        this.z = l;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("reason");
        cVar.y(this.b);
        cVar.p("category");
        cVar.y(this.f);
        cVar.p("quantity");
        cVar.x(this.z);
        HashMap map = this.A;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.A, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }

    public final String toString() {
        return "DiscardedEvent{reason='" + this.b + "', category='" + this.f + "', quantity=" + this.z + '}';
    }
}
