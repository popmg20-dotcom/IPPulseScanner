package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zm4 extends pm {
    public final po2 I0;

    public zm4(pm pmVar, po2 po2Var) {
        super(pmVar, pmVar.f);
        this.I0 = po2Var;
    }

    @Override // defpackage.pm
    public final b72 c(ke0 ke0Var, Class cls, gt3 gt3Var) {
        nj4 nj4Var = this.Y;
        b72 b72VarP = nj4Var != null ? gt3Var.p(gt3Var.e(nj4Var, cls), this) : gt3Var.q(cls, this);
        boolean zD = b72VarP.d();
        po2 no2Var = this.I0;
        if (zD && (b72VarP instanceof an4)) {
            no2Var = new no2(no2Var, ((an4) b72VarP).B0);
        }
        b72 b72VarG = b72VarP.g(no2Var);
        this.D0 = this.D0.n(cls, b72VarG);
        return b72VarG;
    }

    @Override // defpackage.pm
    public final void g(b72 b72Var) {
        if (b72Var != null) {
            boolean zD = b72Var.d();
            po2 no2Var = this.I0;
            if (zD && (b72Var instanceof an4)) {
                no2Var = new no2(no2Var, ((an4) b72Var).B0);
            }
            b72Var = b72Var.g(no2Var);
        }
        super.g(b72Var);
    }

    @Override // defpackage.pm
    public final pm i(po2 po2Var) {
        return new zm4(this, new no2(po2Var, this.I0), new ft3(po2Var.a(this.f.b)));
    }

    @Override // defpackage.pm
    public final void k(Object obj, i52 i52Var, gt3 gt3Var) {
        Method method = this.y0;
        Object objInvoke = method == null ? this.z0.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            return;
        }
        b72 b72VarC = this.A0;
        if (b72VarC == null) {
            Class<?> cls = objInvoke.getClass();
            ke0 ke0Var = this.D0;
            b72 b72VarA = ke0Var.A(cls);
            b72VarC = b72VarA == null ? c(ke0Var, cls, gt3Var) : b72VarA;
        }
        Object obj2 = this.F0;
        if (obj2 != null) {
            if (s52.z == obj2) {
                if (b72VarC.c(gt3Var, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && e(i52Var, gt3Var, b72VarC)) {
            return;
        }
        if (!b72VarC.d()) {
            i52Var.N(this.f);
        }
        zj4 zj4Var = this.C0;
        if (zj4Var == null) {
            b72VarC.e(objInvoke, i52Var, gt3Var);
        } else {
            b72VarC.f(objInvoke, i52Var, gt3Var, zj4Var);
        }
    }

    public zm4(zm4 zm4Var, no2 no2Var, ft3 ft3Var) {
        super(zm4Var, ft3Var);
        this.I0 = no2Var;
    }
}
