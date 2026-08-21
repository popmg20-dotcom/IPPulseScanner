package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kt0 extends it0 {
    public final String A;
    public final ws0 X;
    public int Y = 0;
    public ft0[] Z;
    public final int f;
    public final yr0 z;

    public kt0(yr0 yr0Var, ws0 ws0Var, int i) {
        this.z = yr0Var;
        this.A = mt0.b(null, ws0Var, yr0Var.H());
        this.f = i;
        this.X = ws0Var;
    }

    @Override // defpackage.it0
    public final gt0 c() {
        return this.X.X.c();
    }

    @Override // defpackage.it0
    public final String d() {
        return this.A;
    }

    @Override // defpackage.it0
    public final it0 e() {
        return this.X;
    }

    @Override // defpackage.it0
    public final String getName() {
        return this.z.H();
    }

    @Override // defpackage.it0
    public final c1 h() {
        return this.z;
    }
}
