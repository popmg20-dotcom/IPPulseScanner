package io.sentry;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import org.conscrypt.BuildConfig;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h7 implements k2 {
    public final String A;
    public final io.sentry.protocol.w A0;
    public ConcurrentHashMap B0;
    public final String X;
    public final String Y;
    public final String Z;
    public final io.sentry.protocol.w b;
    public final String f;
    public final String y0;
    public final String z;
    public final String z0;

    public h7(io.sentry.protocol.w wVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, io.sentry.protocol.w wVar2, String str8) {
        this.b = wVar;
        this.f = str;
        this.z = str2;
        this.A = str3;
        this.X = str4;
        this.Y = str5;
        this.Z = str6;
        this.z0 = str7;
        this.A0 = wVar2;
        this.y0 = str8;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("trace_id");
        cVar.v(iLogger, this.b);
        cVar.p("public_key");
        cVar.y(this.f);
        String str = this.z;
        if (str != null) {
            cVar.p(BuildConfig.BUILD_TYPE);
            cVar.y(str);
        }
        String str2 = this.A;
        if (str2 != null) {
            cVar.p("environment");
            cVar.y(str2);
        }
        String str3 = this.X;
        if (str3 != null) {
            cVar.p("user_id");
            cVar.y(str3);
        }
        String str4 = this.Y;
        if (str4 != null) {
            cVar.p("transaction");
            cVar.y(str4);
        }
        String str5 = this.Z;
        if (str5 != null) {
            cVar.p("sample_rate");
            cVar.y(str5);
        }
        String str6 = this.y0;
        if (str6 != null) {
            cVar.p("sample_rand");
            cVar.y(str6);
        }
        String str7 = this.z0;
        if (str7 != null) {
            cVar.p("sampled");
            cVar.y(str7);
        }
        io.sentry.protocol.w wVar = this.A0;
        if (wVar != null) {
            cVar.p("replay_id");
            cVar.v(iLogger, wVar);
        }
        ConcurrentHashMap concurrentHashMap = this.B0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.B0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
