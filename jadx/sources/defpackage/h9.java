package defpackage;

import java.lang.reflect.Member;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h9 extends c9 {
    public final i9 D0;
    public final nj4 E0;
    public final int F0;

    public h9(i9 i9Var, nj4 nj4Var, yj4 yj4Var, cp1 cp1Var, int i) {
        super(yj4Var, cp1Var);
        this.D0 = i9Var;
        this.E0 = nj4Var;
        this.F0 = i;
    }

    @Override // defpackage.c9
    public final Class O() {
        return this.D0.O();
    }

    @Override // defpackage.c9
    public final Member Q() {
        return this.D0.Q();
    }

    @Override // defpackage.c9
    public final Object R(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of ".concat(this.D0.O().getName()));
    }

    @Override // defpackage.c9
    public final xb5 T(cp1 cp1Var) {
        if (cp1Var == this.C0) {
            return this;
        }
        i9 i9Var = this.D0;
        cp1[] cp1VarArr = i9Var.D0;
        int i = this.F0;
        cp1VarArr[i] = cp1Var;
        return i9Var.U(i);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!n50.n(obj, h9.class)) {
            return false;
        }
        h9 h9Var = (h9) obj;
        return h9Var.D0.equals(this.D0) && h9Var.F0 == this.F0;
    }

    public final int hashCode() {
        return this.D0.hashCode() + this.F0;
    }

    @Override // defpackage.xb5
    public final int p() {
        return this.D0.p();
    }

    @Override // defpackage.xb5
    public final String q() {
        return "";
    }

    public final String toString() {
        return "[parameter #" + this.F0 + ", annotations: " + this.C0 + "]";
    }

    @Override // defpackage.xb5
    public final Class u() {
        return this.E0.L0;
    }

    @Override // defpackage.xb5
    public final nj4 x() {
        return this.E0;
    }
}
