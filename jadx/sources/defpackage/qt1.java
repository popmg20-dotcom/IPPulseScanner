package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qt1 implements lz3 {
    public final /* synthetic */ wt1 A;
    public final ev1 b;
    public final bj1 f;
    public boolean z;

    public qt1(wt1 wt1Var, ev1 ev1Var) {
        ev1Var.getClass();
        this.A = wt1Var;
        this.b = ev1Var;
        this.f = new bj1(((he3) wt1Var.c.z).b.i());
    }

    public final void g(lr1 lr1Var) {
        lu2 lu2Var;
        ne0 ne0Var;
        lr1Var.getClass();
        wt1 wt1Var = this.A;
        int i = wt1Var.d;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            xe.d(wt1Var.d, "state: ");
            return;
        }
        bj1 bj1Var = this.f;
        de4 de4Var = bj1Var.e;
        bj1Var.e = de4.d;
        de4Var.a();
        de4Var.b();
        wt1Var.d = 6;
        if (lr1Var.size() <= 0 || (lu2Var = wt1Var.a) == null || (ne0Var = lu2Var.j) == null) {
            return;
        }
        ru1.d(ne0Var, this.b, lr1Var);
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.f;
    }

    @Override // defpackage.lz3
    public long t0(hp hpVar, long j) {
        wt1 wt1Var = this.A;
        hpVar.getClass();
        try {
            return ((he3) wt1Var.c.z).t0(hpVar, j);
        } catch (IOException e) {
            wt1Var.b.d();
            this.g(wt1.f);
            throw e;
        }
    }
}
