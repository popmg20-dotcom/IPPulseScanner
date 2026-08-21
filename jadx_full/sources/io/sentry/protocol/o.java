package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o implements k2 {
    public Boolean A;
    public Boolean A0;
    public HashMap B0;
    public AbstractMap X;
    public ConcurrentHashMap Y;
    public Boolean Z;
    public String b;
    public String f;
    public Integer y0;
    public String z;
    public Integer z0;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("type");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("description");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("help_link");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("handled");
            cVar.w(this.A);
        }
        if (this.X != null) {
            cVar.p("meta");
            cVar.v(iLogger, this.X);
        }
        if (this.Y != null) {
            cVar.p("data");
            cVar.v(iLogger, this.Y);
        }
        if (this.Z != null) {
            cVar.p("synthetic");
            cVar.w(this.Z);
        }
        if (this.y0 != null) {
            cVar.p("exception_id");
            cVar.v(iLogger, this.y0);
        }
        if (this.z0 != null) {
            cVar.p("parent_id");
            cVar.v(iLogger, this.z0);
        }
        if (this.A0 != null) {
            cVar.p("is_exception_group");
            cVar.w(this.A0);
        }
        HashMap map = this.B0;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.B0, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
