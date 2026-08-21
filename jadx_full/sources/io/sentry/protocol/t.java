package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t implements k2 {
    public Integer A;
    public HashMap X;
    public String b;
    public Integer f;
    public Integer z;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("sdk_name");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("version_major");
            cVar.x(this.f);
        }
        if (this.z != null) {
            cVar.p("version_minor");
            cVar.x(this.z);
        }
        if (this.A != null) {
            cVar.p("version_patchlevel");
            cVar.x(this.A);
        }
        HashMap map = this.X;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.X, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
