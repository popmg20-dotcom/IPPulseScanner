package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ut1 implements vx3 {
    public final bj1 b;
    public boolean f;
    public final /* synthetic */ wt1 z;

    public ut1(wt1 wt1Var) {
        this.z = wt1Var;
        this.b = new bj1(((ge3) wt1Var.c.A).b.i());
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) {
        if (this.f) {
            xe.q("closed");
        } else {
            hz4.a(hpVar.f, 0L, j);
            ((ge3) this.z.c.A).a0(hpVar, j);
        }
    }

    @Override // defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f) {
            return;
        }
        this.f = true;
        bj1 bj1Var = this.b;
        de4 de4Var = bj1Var.e;
        bj1Var.e = de4.d;
        de4Var.a();
        de4Var.b();
        this.z.d = 3;
    }

    @Override // defpackage.vx3, java.io.Flushable
    public final void flush() {
        if (this.f) {
            return;
        }
        ((ge3) this.z.c.A).flush();
    }

    @Override // defpackage.vx3
    public final de4 i() {
        return this.b;
    }
}
