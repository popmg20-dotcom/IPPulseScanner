package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zf extends pm {
    public final String I0;

    /* JADX WARN: Illegal instructions before constructor call */
    public zf(String str, yw3 yw3Var, o9 o9Var, nj4 nj4Var) {
        s52 s52Var;
        Object obj;
        t52 t52Var = yw3Var.X;
        c9 c9Var = yw3Var.f;
        s52 s52Var2 = s52.X;
        s52 s52Var3 = s52.b;
        boolean z = false;
        if (t52Var != null && (s52Var = t52Var.b) != s52Var3 && s52Var != s52Var2) {
            z = true;
        }
        boolean z2 = z;
        if (t52Var == null) {
            obj = Boolean.FALSE;
        } else {
            s52 s52Var4 = t52Var.b;
            obj = (s52Var4 == s52Var3 || s52Var4 == s52.f || s52Var4 == s52Var2) ? null : s52.z;
        }
        super(yw3Var, c9Var, o9Var, nj4Var, null, null, null, z2, obj, null);
        this.I0 = str;
    }

    @Override // defpackage.pm
    public final void j(Object obj, i52 i52Var, gt3 gt3Var) {
        Object objR = gt3Var.r(this.I0);
        if (objR == null) {
            b72 b72Var = this.B0;
            if (b72Var != null) {
                b72Var.e(null, i52Var, gt3Var);
                return;
            } else {
                i52Var.U();
                return;
            }
        }
        b72 b72VarC = this.A0;
        if (b72VarC == null) {
            Class<?> cls = objR.getClass();
            ke0 ke0Var = this.D0;
            b72 b72VarA = ke0Var.A(cls);
            b72VarC = b72VarA == null ? c(ke0Var, cls, gt3Var) : b72VarA;
        }
        Object obj2 = this.F0;
        if (obj2 != null) {
            if (s52.z == obj2) {
                if (b72VarC.c(gt3Var, objR)) {
                    l(i52Var, gt3Var);
                    return;
                }
            } else if (obj2.equals(objR)) {
                l(i52Var, gt3Var);
                return;
            }
        }
        if (objR == obj && e(i52Var, gt3Var, b72VarC)) {
            return;
        }
        zj4 zj4Var = this.C0;
        if (zj4Var == null) {
            b72VarC.e(objR, i52Var, gt3Var);
        } else {
            b72VarC.f(objR, i52Var, gt3Var, zj4Var);
        }
    }

    @Override // defpackage.pm
    public final void k(Object obj, i52 i52Var, gt3 gt3Var) {
        Object objR = gt3Var.r(this.I0);
        ft3 ft3Var = this.f;
        if (objR == null) {
            if (this.B0 != null) {
                i52Var.N(ft3Var);
                this.B0.e(null, i52Var, gt3Var);
                return;
            }
            return;
        }
        b72 b72VarC = this.A0;
        if (b72VarC == null) {
            Class<?> cls = objR.getClass();
            ke0 ke0Var = this.D0;
            b72 b72VarA = ke0Var.A(cls);
            b72VarC = b72VarA == null ? c(ke0Var, cls, gt3Var) : b72VarA;
        }
        Object obj2 = this.F0;
        if (obj2 != null) {
            if (s52.z == obj2) {
                if (b72VarC.c(gt3Var, objR)) {
                    return;
                }
            } else if (obj2.equals(objR)) {
                return;
            }
        }
        if (objR == obj && e(i52Var, gt3Var, b72VarC)) {
            return;
        }
        i52Var.N(ft3Var);
        zj4 zj4Var = this.C0;
        if (zj4Var == null) {
            b72VarC.e(objR, i52Var, gt3Var);
        } else {
            b72VarC.f(objR, i52Var, gt3Var, zj4Var);
        }
    }
}
