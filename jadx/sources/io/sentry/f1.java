package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface f1 {
    f1 A(String str);

    io.sentry.protocol.w B(f5 f5Var, l0 l0Var);

    void a(boolean z);

    void b(long j);

    void c(g gVar, l0 l0Var);

    y0 clone();

    io.sentry.android.core.internal.tombstone.c d();

    boolean e();

    io.sentry.protocol.w f(io.sentry.internal.debugmeta.c cVar, l0 l0Var);

    void g(g gVar);

    p6 getOptions();

    io.sentry.protocol.w h(s3 s3Var);

    p1 i();

    boolean isEnabled();

    io.sentry.protocol.w j(f5 f5Var);

    void k();

    void l();

    p1 m(j7 j7Var, k7 k7Var);

    io.sentry.protocol.w n(io.sentry.protocol.f0 f0Var, h7 h7Var, l0 l0Var);

    void o(h4 h4Var);

    boolean p();

    io.sentry.logger.a q();

    io.sentry.protocol.w r(r6 r6Var, l0 l0Var);

    d1 s();

    d1 t();

    x0 u();

    void v(String str);

    void w(h4 h4Var);

    io.sentry.protocol.w x(Throwable th);

    io.sentry.protocol.w y(Throwable th, l0 l0Var);

    io.sentry.protocol.w z(io.sentry.protocol.f0 f0Var, h7 h7Var, l0 l0Var, v3 v3Var);
}
