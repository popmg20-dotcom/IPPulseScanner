package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p0 implements y0 {
    public final k4 a;

    public p0(k4 k4Var) {
        this.a = k4Var;
    }

    @Override // io.sentry.f1
    public final f1 A(String str) {
        return this.a.A("getCurrentScopes");
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w B(f5 f5Var, l0 l0Var) {
        return this.a.B(f5Var, l0Var);
    }

    @Override // io.sentry.f1
    public final void a(boolean z) {
        this.a.a(z);
    }

    @Override // io.sentry.f1
    public final void b(long j) {
        this.a.b(j);
    }

    @Override // io.sentry.f1
    public final void c(g gVar, l0 l0Var) {
        this.a.c(gVar, l0Var);
    }

    @Override // io.sentry.f1
    /* JADX INFO: renamed from: clone */
    public final y0 m7clone() {
        return this.a.m7clone();
    }

    @Override // io.sentry.f1
    public final io.sentry.android.core.internal.tombstone.c d() {
        return this.a.d();
    }

    @Override // io.sentry.f1
    public final boolean e() {
        return this.a.e();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w f(io.sentry.internal.debugmeta.c cVar, l0 l0Var) {
        return this.a.f(cVar, l0Var);
    }

    @Override // io.sentry.f1
    public final void g(g gVar) {
        this.a.g(gVar);
    }

    @Override // io.sentry.f1
    public final p6 getOptions() {
        return this.a.getOptions();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w h(s3 s3Var) {
        return this.a.h(s3Var);
    }

    @Override // io.sentry.f1
    public final p1 i() {
        return this.a.i();
    }

    @Override // io.sentry.f1
    public final boolean isEnabled() {
        return this.a.isEnabled();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w j(f5 f5Var) {
        return B(f5Var, new l0());
    }

    @Override // io.sentry.f1
    public final void k() {
        this.a.k();
    }

    @Override // io.sentry.f1
    public final void l() {
        this.a.l();
    }

    @Override // io.sentry.f1
    public final p1 m(j7 j7Var, k7 k7Var) {
        return this.a.m(j7Var, k7Var);
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w n(io.sentry.protocol.f0 f0Var, h7 h7Var, l0 l0Var) {
        return this.a.z(f0Var, h7Var, l0Var, null);
    }

    @Override // io.sentry.f1
    public final void o(h4 h4Var) {
        this.a.o(h4Var);
    }

    @Override // io.sentry.f1
    public final boolean p() {
        return false;
    }

    @Override // io.sentry.f1
    public final io.sentry.logger.a q() {
        return this.a.f;
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w r(r6 r6Var, l0 l0Var) {
        return this.a.r(r6Var, l0Var);
    }

    @Override // io.sentry.f1
    public final d1 s() {
        return p4.c;
    }

    @Override // io.sentry.f1
    public final d1 t() {
        return this.a.a;
    }

    @Override // io.sentry.f1
    public final x0 u() {
        return this.a.g;
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
        return this.a.y(th, l0Var);
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w z(io.sentry.protocol.f0 f0Var, h7 h7Var, l0 l0Var, v3 v3Var) {
        return this.a.z(f0Var, h7Var, l0Var, v3Var);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Object m10clone() {
        return this.a.m7clone();
    }
}
