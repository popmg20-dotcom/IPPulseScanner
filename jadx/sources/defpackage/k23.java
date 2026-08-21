package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k23 {
    public static final p83[] f = new p83[0];
    public final i9 a;
    public final boolean b;
    public final u42 c;
    public p83[] d;
    public p83[] e;

    public k23(i9 i9Var, u42 u42Var) {
        this.a = i9Var;
        this.b = u42Var != null;
        this.c = u42Var == null ? u42.b : u42Var;
    }

    public final boolean a(bt3 bt3Var) {
        cu2 cu2VarD = bt3Var.d();
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            if (this.e[i] == null && this.d[i] == null && cu2VarD.i(this.a.U(i)) == null) {
                return false;
            }
        }
        return true;
    }

    public final void b(yg2 yg2Var) {
        if (this.d != null) {
            return;
        }
        i9 i9Var = this.a;
        int iV = i9Var.V();
        if (iV == 0) {
            p83[] p83VarArr = f;
            this.e = p83VarArr;
            this.d = p83VarArr;
            return;
        }
        this.e = new p83[iV];
        this.d = new p83[iV];
        cu2 cu2VarD = yg2Var.d();
        for (int i = 0; i < iV; i++) {
            p83 p83VarL = cu2VarD.l(i9Var.U(i));
            if (p83VarL != null && !p83VarL.c()) {
                this.e[i] = p83VarL;
            }
        }
    }

    public final String toString() {
        return "(mode=" + this.c + ")" + this.a;
    }
}
