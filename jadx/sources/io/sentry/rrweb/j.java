package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j extends b implements k2 {
    public int A;
    public int X;
    public HashMap Y;
    public String z;

    public j() {
        super(c.Meta);
        this.z = "";
    }

    @Override // io.sentry.rrweb.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        j jVar = (j) obj;
        return this.A == jVar.A && this.X == jVar.X && io.sentry.util.b.i(this.z, jVar.z);
    }

    @Override // io.sentry.rrweb.b
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(super.hashCode()), this.z, Integer.valueOf(this.A), Integer.valueOf(this.X)});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("type");
        cVar.v(iLogger, this.b);
        cVar.p("timestamp");
        cVar.u(this.f);
        cVar.p("data");
        cVar.k();
        cVar.p("href");
        cVar.y(this.z);
        cVar.p("height");
        cVar.u(this.A);
        cVar.p("width");
        cVar.u(this.X);
        HashMap map = this.Y;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.Y, str, cVar, str, iLogger);
            }
        }
        cVar.m();
        cVar.m();
    }
}
