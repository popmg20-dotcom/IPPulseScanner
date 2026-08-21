package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.Objects;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x implements k2 {
    public final String b;
    public final String f;
    public HashMap z;

    public x(String str, String str2) {
        this.b = str;
        this.f = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.b.equals(xVar.b) && this.f.equals(xVar.f);
    }

    public final int hashCode() {
        return Objects.hash(this.b, this.f);
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("name");
        cVar.y(this.b);
        cVar.p("version");
        cVar.y(this.f);
        HashMap map = this.z;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.z, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
