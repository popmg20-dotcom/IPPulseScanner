package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class nz1 extends sn3 {
    public final boolean f;
    public final wn3[] g;
    public qh3 h;

    public nz1(wn3 wn3Var, String str, String str2, sn snVar) {
        super(wn3Var, str, str2);
        this.g = (wn3[]) snVar.f;
        this.f = snVar.b;
    }

    @Override // defpackage.sn3
    public final void a(xp1 xp1Var, qh3 qh3Var) {
        for (wn3 wn3Var : this.g) {
            xp1Var.d(wn3Var).a(xp1Var, qh3Var);
        }
    }

    @Override // defpackage.sn3
    public final n80 b(xp1 xp1Var, String str, boolean z, boolean z2) {
        qh3 qh3Var = this.h;
        if (qh3Var == null) {
            qh3Var = new qh3();
            a(xp1Var, qh3Var);
            this.h = qh3Var;
        }
        return qh3Var.b(z, z2);
    }
}
