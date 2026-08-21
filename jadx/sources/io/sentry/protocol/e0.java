package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements k2 {
    public String A;
    public Map A0;
    public ConcurrentHashMap B0;
    public Boolean X;
    public Boolean Y;
    public Boolean Z;
    public Long b;
    public Integer f;
    public Boolean y0;
    public String z;
    public c0 z0;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("id");
            cVar.x(this.b);
        }
        if (this.f != null) {
            cVar.p("priority");
            cVar.x(this.f);
        }
        if (this.z != null) {
            cVar.p("name");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("state");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("crashed");
            cVar.w(this.X);
        }
        if (this.Y != null) {
            cVar.p("current");
            cVar.w(this.Y);
        }
        if (this.Z != null) {
            cVar.p("daemon");
            cVar.w(this.Z);
        }
        if (this.y0 != null) {
            cVar.p("main");
            cVar.w(this.y0);
        }
        if (this.z0 != null) {
            cVar.p("stacktrace");
            cVar.v(iLogger, this.z0);
        }
        if (this.A0 != null) {
            cVar.p("held_locks");
            cVar.v(iLogger, this.A0);
        }
        ConcurrentHashMap concurrentHashMap = this.B0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.B0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
