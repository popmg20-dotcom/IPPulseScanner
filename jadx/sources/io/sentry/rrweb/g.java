package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g extends e implements k2 {
    public f A;
    public HashMap A0;
    public HashMap B0;
    public int X;
    public float Y;
    public float Z;
    public int y0;
    public int z0;

    public g() {
        super(d.MouseInteraction);
        this.y0 = 2;
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
        cVar.p("source");
        cVar.v(iLogger, this.z);
        cVar.p("type");
        cVar.v(iLogger, this.A);
        cVar.p("id");
        cVar.u(this.X);
        cVar.p("x");
        cVar.t(this.Y);
        cVar.p("y");
        cVar.t(this.Z);
        cVar.p("pointerType");
        cVar.u(this.y0);
        cVar.p("pointerId");
        cVar.u(this.z0);
        HashMap map = this.B0;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.B0, str, cVar, str, iLogger);
            }
        }
        cVar.m();
        HashMap map2 = this.A0;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                io.sentry.e.c(this.A0, str2, cVar, str2, iLogger);
            }
        }
        cVar.m();
    }
}
