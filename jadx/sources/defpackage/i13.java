package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i13 extends ez4 {
    public final /* synthetic */ ez2 k;
    public final /* synthetic */ ez2 l;
    public final /* synthetic */ int m;
    public final /* synthetic */ int n;

    public i13(ez2 ez2Var, ez2 ez2Var2, int i, int i2) {
        this.k = ez2Var;
        this.l = ez2Var2;
        this.m = i;
        this.n = i2;
    }

    @Override // defpackage.ez4
    public final int A() {
        return this.m;
    }

    @Override // defpackage.ez4
    public final boolean b(int i, int i2) {
        Object objC = this.k.c(i);
        Object objC2 = this.l.c(i2);
        if (objC == objC2) {
            return true;
        }
        zi3 zi3Var = (zi3) objC;
        zi3 zi3Var2 = (zi3) objC2;
        zi3Var.getClass();
        zi3Var2.getClass();
        return zi3Var.equals(zi3Var2);
    }

    @Override // defpackage.ez4
    public final boolean c(int i, int i2) {
        Object objC = this.k.c(i);
        Object objC2 = this.l.c(i2);
        if (objC == objC2) {
            return true;
        }
        zi3 zi3Var = (zi3) objC;
        zi3 zi3Var2 = (zi3) objC2;
        zi3Var.getClass();
        zi3Var2.getClass();
        return zi3Var.a == zi3Var2.a;
    }

    @Override // defpackage.ez4
    public final Object w(int i, int i2) {
        if (this.k.c(i) == this.l.c(i2)) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // defpackage.ez4
    public final int z() {
        return this.n;
    }
}
