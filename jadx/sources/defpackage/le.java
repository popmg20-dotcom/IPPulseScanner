package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class le extends hd0 implements ee0 {
    public final Boolean A;
    public final nm z;

    public le(le leVar, nm nmVar, Boolean bool) {
        super(leVar.b, 0);
        this.z = nmVar;
        this.A = bool;
    }

    public b72 a(gt3 gt3Var, nm nmVar) {
        e52 e52VarK;
        if (nmVar == null || (e52VarK = l34.k(gt3Var, nmVar, this.b)) == null) {
            return this;
        }
        Boolean boolB = e52VarK.b(b52.b);
        return !Objects.equals(boolB, this.A) ? q(nmVar, boolB) : this;
    }

    @Override // defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(obj, g72.X));
        i52Var.s(obj);
        r(obj, i52Var, gt3Var);
        zj4Var.f(i52Var, e10VarE);
    }

    public final boolean p(gt3 gt3Var) {
        Boolean bool = this.A;
        if (bool != null) {
            return bool.booleanValue();
        }
        return gt3Var.b.h(dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
    }

    public abstract b72 q(nm nmVar, Boolean bool);

    public abstract void r(Object obj, i52 i52Var, gt3 gt3Var);

    public le(Class cls) {
        super(cls);
        this.z = null;
        this.A = null;
    }
}
