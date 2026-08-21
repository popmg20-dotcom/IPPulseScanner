package io.sentry;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b4 implements k2 {
    public Integer b;
    public List f;
    public HashMap z;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b4.class == obj.getClass()) {
            b4 b4Var = (b4) obj;
            if (io.sentry.util.b.i(this.b, b4Var.b) && io.sentry.util.b.i(this.f, b4Var.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        io.sentry.vendor.gson.stream.c cVar2 = (io.sentry.vendor.gson.stream.c) cVar.f;
        if (this.b != null) {
            cVar.p("segment_id");
            cVar.x(this.b);
        }
        HashMap map = this.z;
        if (map != null) {
            for (String str : map.keySet()) {
                e.c(this.z, str, cVar, str, iLogger);
            }
        }
        cVar.m();
        cVar2.Y = true;
        if (this.b != null) {
            cVar2.I();
            cVar2.g();
            cVar2.b.append((CharSequence) "\n");
        }
        List list = this.f;
        if (list != null) {
            cVar.v(iLogger, list);
        }
        cVar2.Y = false;
    }
}
