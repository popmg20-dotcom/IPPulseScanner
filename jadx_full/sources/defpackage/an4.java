package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class an4 extends rm {
    public final po2 B0;

    public an4(rm rmVar, po2 po2Var) {
        super(rmVar, rm.s(rmVar.A, po2Var), rm.s(rmVar.X, po2Var));
        this.B0 = po2Var;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        i52Var.s(obj);
        if (this.y0 != null) {
            p(obj, i52Var, gt3Var, false);
        } else if (this.Y == null) {
            u(obj, i52Var, gt3Var);
        } else {
            v(obj, i52Var, gt3Var);
            throw null;
        }
    }

    @Override // defpackage.rm, defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        if (gt3Var.b.h(dt3.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            gt3Var.z(this.b, "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
            throw null;
        }
        i52Var.s(obj);
        if (this.y0 != null) {
            o(obj, i52Var, gt3Var, zj4Var);
        } else if (this.Y == null) {
            u(obj, i52Var, gt3Var);
        } else {
            v(obj, i52Var, gt3Var);
            throw null;
        }
    }

    @Override // defpackage.b72
    public final b72 g(po2 po2Var) {
        return new an4(this, po2Var);
    }

    public final String toString() {
        return "UnwrappingBeanSerializer for ".concat(this.b.getName());
    }

    @Override // defpackage.rm
    public final rm w(Set set, Set set2) {
        return new an4(this, set, set2);
    }

    @Override // defpackage.rm
    public final rm x(Object obj) {
        return new an4(this, this.y0, obj);
    }

    @Override // defpackage.rm
    public final rm y(wt2 wt2Var) {
        return new an4(this, wt2Var);
    }

    @Override // defpackage.rm
    public final rm z(pm[] pmVarArr, pm[] pmVarArr2) {
        return new an4(this, pmVarArr, pmVarArr2);
    }

    public an4(an4 an4Var, Set set, Set set2) {
        super(an4Var, set, set2);
        this.B0 = an4Var.B0;
    }

    @Override // defpackage.rm
    public final rm r() {
        return this;
    }

    public an4(an4 an4Var, pm[] pmVarArr, pm[] pmVarArr2) {
        super(an4Var, pmVarArr, pmVarArr2);
        this.B0 = an4Var.B0;
    }

    public an4(an4 an4Var, wt2 wt2Var) {
        super(an4Var, wt2Var, an4Var.Y);
        this.B0 = an4Var.B0;
    }

    public an4(an4 an4Var, wt2 wt2Var, Object obj) {
        super(an4Var, wt2Var, obj);
        this.B0 = an4Var.B0;
    }
}
