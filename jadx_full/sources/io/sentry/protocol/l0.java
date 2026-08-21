package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements k2 {
    public String A;
    public Double A0;
    public List B0;
    public HashMap C0;
    public Double X;
    public Double Y;
    public Double Z;
    public String b;
    public String f;
    public Double y0;
    public String z;
    public String z0;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("rendering_system");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("type");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("identifier");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("tag");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("width");
            cVar.x(this.X);
        }
        if (this.Y != null) {
            cVar.p("height");
            cVar.x(this.Y);
        }
        if (this.Z != null) {
            cVar.p("x");
            cVar.x(this.Z);
        }
        if (this.y0 != null) {
            cVar.p("y");
            cVar.x(this.y0);
        }
        if (this.z0 != null) {
            cVar.p("visibility");
            cVar.y(this.z0);
        }
        if (this.A0 != null) {
            cVar.p("alpha");
            cVar.x(this.A0);
        }
        List list = this.B0;
        if (list != null && !list.isEmpty()) {
            cVar.p("children");
            cVar.v(iLogger, this.B0);
        }
        HashMap map = this.C0;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.C0, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
