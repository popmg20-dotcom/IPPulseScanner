package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nt0 extends zg2 {
    public static final int C0 = yg2.b(ot0.class);
    public final int B0;

    public nt0(jl jlVar, m34 m34Var, dx3 dx3Var, o82 o82Var, ma0 ma0Var, s60 s60Var, tj0 tj0Var) {
        super(jlVar, m34Var, dx3Var, o82Var, ma0Var, tj0Var);
        this.B0 = C0;
    }

    @Override // defpackage.yg2
    public final boolean e(rj0 rj0Var) {
        tj0 tj0Var = this.y0;
        tj0Var.getClass();
        int iB = rj0Var.b();
        if (iB == 0) {
            return rj0Var.a(tj0Var.b);
        }
        if (iB == 1) {
            return rj0Var.a(tj0Var.f);
        }
        int i = zo4.a;
        zo2.w("Internal error: this code path should never get executed");
        return false;
    }

    public nt0(nt0 nt0Var, long j, int i) {
        super(nt0Var, j);
        this.B0 = i;
    }
}
