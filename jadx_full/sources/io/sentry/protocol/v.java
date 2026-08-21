package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v implements k2 {
    public Long A;
    public c0 X;
    public o Y;
    public HashMap Z;
    public String b;
    public String f;
    public String z;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("type");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("value");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("module");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("thread_id");
            cVar.x(this.A);
        }
        if (this.X != null) {
            cVar.p("stacktrace");
            cVar.v(iLogger, this.X);
        }
        if (this.Y != null) {
            cVar.p("mechanism");
            cVar.v(iLogger, this.Y);
        }
        HashMap map = this.Z;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.Z, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
