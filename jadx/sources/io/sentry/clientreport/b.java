package io.sentry.clientreport;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements k2 {
    public final Date b;
    public final ArrayList f;
    public HashMap z;

    public b(Date date, ArrayList arrayList) {
        this.b = date;
        this.f = arrayList;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("timestamp");
        cVar.y(io.sentry.vendor.a.f(this.b.getTime()));
        cVar.p("discarded_events");
        cVar.v(iLogger, this.f);
        HashMap map = this.z;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.z, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
