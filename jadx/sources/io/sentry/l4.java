package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l4 implements f1 {
    public static final l4 a = new l4();

    @Override // io.sentry.f1
    public final f1 A(String str) {
        return p4.c().A("getCurrentScopes");
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w B(f5 f5Var, l0 l0Var) {
        return p4.c().B(f5Var, l0Var);
    }

    @Override // io.sentry.f1
    public final void a(boolean z) {
        p4.a();
    }

    @Override // io.sentry.f1
    public final void b(long j) {
        p4.b(j);
    }

    @Override // io.sentry.f1
    public final void c(g gVar, l0 l0Var) {
        p4.c().c(gVar, l0Var);
    }

    @Override // io.sentry.f1
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final y0 m7clone() {
        return p4.c().m6clone();
    }

    @Override // io.sentry.f1
    public final io.sentry.android.core.internal.tombstone.c d() {
        return p4.c().d();
    }

    @Override // io.sentry.f1
    public final boolean e() {
        return p4.c().e();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w f(io.sentry.internal.debugmeta.c cVar, l0 l0Var) {
        return p4.c().f(cVar, l0Var);
    }

    @Override // io.sentry.f1
    public final void g(g gVar) {
        c(gVar, new l0());
    }

    @Override // io.sentry.f1
    public final p6 getOptions() {
        return p4.c().getOptions();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w h(s3 s3Var) {
        return p4.c().h(s3Var);
    }

    @Override // io.sentry.f1
    public final p1 i() {
        return p4.c().i();
    }

    @Override // io.sentry.f1
    public final boolean isEnabled() {
        return p4.g();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w j(f5 f5Var) {
        return B(f5Var, new l0());
    }

    @Override // io.sentry.f1
    public final void k() {
        p4.c().k();
    }

    @Override // io.sentry.f1
    public final void l() {
        p4.c().l();
    }

    @Override // io.sentry.f1
    public final p1 m(j7 j7Var, k7 k7Var) {
        return p4.c().m(j7Var, k7Var);
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w n(io.sentry.protocol.f0 f0Var, h7 h7Var, l0 l0Var) {
        return z(f0Var, h7Var, l0Var, null);
    }

    @Override // io.sentry.f1
    public final void o(h4 h4Var) {
        p4.c().o(h4Var);
    }

    @Override // io.sentry.f1
    public final boolean p() {
        return false;
    }

    @Override // io.sentry.f1
    public final io.sentry.logger.a q() {
        return p4.c().q();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w r(r6 r6Var, l0 l0Var) {
        return p4.c().r(r6Var, l0Var);
    }

    @Override // io.sentry.f1
    public final d1 s() {
        return p4.c;
    }

    @Override // io.sentry.f1
    public final d1 t() {
        return p4.c().t();
    }

    @Override // io.sentry.f1
    public final x0 u() {
        return p4.c().u();
    }

    @Override // io.sentry.f1
    public final /* synthetic */ void v(String str) {
        e.a(this, str);
    }

    @Override // io.sentry.f1
    public final void w(h4 h4Var) {
        o(h4Var);
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w x(Throwable th) {
        return y(th, new l0());
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w y(Throwable th, l0 l0Var) {
        return p4.c().y(th, l0Var);
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w z(io.sentry.protocol.f0 f0Var, h7 h7Var, l0 l0Var, v3 v3Var) {
        return p4.c().z(f0Var, h7Var, l0Var, v3Var);
    }
}
