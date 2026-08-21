package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qm extends rm {
    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        if (this.y0 != null) {
            i52Var.s(obj);
            p(obj, i52Var, gt3Var, true);
            return;
        }
        i52Var.z0(obj);
        if (this.Y != null) {
            v(obj, i52Var, gt3Var);
            throw null;
        }
        u(obj, i52Var, gt3Var);
        i52Var.M();
    }

    @Override // defpackage.b72
    public final b72 g(po2 po2Var) {
        return new an4(this, po2Var);
    }

    @Override // defpackage.b72
    public final b72 i(Set set) {
        return new qm(this, set, null);
    }

    @Override // defpackage.rm
    public final rm r() {
        return (this.y0 == null && this.Y == null) ? new mm(this) : this;
    }

    public final String toString() {
        return "BeanSerializer for ".concat(this.b.getName());
    }

    @Override // defpackage.rm
    public final rm w(Set set, Set set2) {
        return new qm(this, set, set2);
    }

    @Override // defpackage.rm
    public final rm x(Object obj) {
        return new qm(this, this.y0, obj);
    }

    @Override // defpackage.rm
    public final rm y(wt2 wt2Var) {
        return new qm(this, wt2Var, this.Y);
    }

    @Override // defpackage.rm
    public final rm z(pm[] pmVarArr, pm[] pmVarArr2) {
        return new qm(this, pmVarArr, pmVarArr2);
    }
}
