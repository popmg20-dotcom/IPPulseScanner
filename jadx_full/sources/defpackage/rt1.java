package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rt1 implements vx3 {
    public final bj1 b;
    public boolean f;
    public final /* synthetic */ wt1 z;

    public rt1(wt1 wt1Var) {
        this.z = wt1Var;
        this.b = new bj1(((ge3) wt1Var.c.A).b.i());
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) {
        if (this.f) {
            xe.q("closed");
            return;
        }
        if (j == 0) {
            return;
        }
        ge3 ge3Var = (ge3) this.z.c.A;
        if (ge3Var.z) {
            xe.q("closed");
            return;
        }
        ge3Var.f.L0(j);
        ge3Var.g();
        ge3Var.S("\r\n");
        ge3Var.a0(hpVar, j);
        ge3Var.S("\r\n");
    }

    @Override // defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f) {
            return;
        }
        this.f = true;
        ((ge3) this.z.c.A).S("0\r\n\r\n");
        bj1 bj1Var = this.b;
        de4 de4Var = bj1Var.e;
        bj1Var.e = de4.d;
        de4Var.a();
        de4Var.b();
        this.z.d = 3;
    }

    @Override // defpackage.vx3, java.io.Flushable
    public final synchronized void flush() {
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
