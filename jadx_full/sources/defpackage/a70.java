package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a70 extends nj4 {
    public final nj4 U0;

    public a70(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr, nj4 nj4Var2, Object obj, Object obj2, boolean z) {
        super(cls, qj4Var, nj4Var, nj4VarArr, nj4Var2.hashCode(), obj, obj2, z);
        this.U0 = nj4Var2;
    }

    @Override // defpackage.nj4
    public final String V() {
        StringBuilder sb = new StringBuilder(this.L0.getName());
        nj4 nj4Var = this.U0;
        if (nj4Var != null && U(1)) {
            sb.append('<');
            sb.append(nj4Var.V());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // defpackage.nj4
    public final nj4 Y() {
        return this.U0;
    }

    @Override // defpackage.nj4
    public final StringBuilder Z(StringBuilder sb) {
        nj4.T(this.L0, sb, true);
        return sb;
    }

    @Override // defpackage.nj4
    public final StringBuilder a0(StringBuilder sb) {
        nj4.T(this.L0, sb, false);
        sb.append('<');
        this.U0.a0(sb);
        sb.append(">;");
        return sb;
    }

    @Override // defpackage.nj4
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != a70.class) {
            return false;
        }
        a70 a70Var = (a70) obj;
        return this.L0 == a70Var.L0 && this.U0.equals(a70Var.U0);
    }

    @Override // defpackage.nj4
    public final boolean f0() {
        return super.f0() || this.U0.f0();
    }

    @Override // defpackage.nj4
    public final boolean h0() {
        return true;
    }

    @Override // defpackage.nj4
    public final nj4 l0(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr) {
        return new a70(cls, qj4Var, nj4Var, nj4VarArr, this.U0, this.N0, this.O0, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 n0(nj4 nj4Var) {
        if (this.U0 == nj4Var) {
            return this;
        }
        return new a70(this.L0, this.S0, this.Q0, this.R0, nj4Var, this.N0, this.O0, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 o0(ak4 ak4Var) {
        return new a70(this.L0, this.S0, this.Q0, this.R0, this.U0.r0(ak4Var), this.N0, this.O0, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 p0(nj4 nj4Var) {
        nj4 nj4Var2;
        nj4 nj4VarP0;
        nj4 nj4VarP02 = super.p0(nj4Var);
        nj4 nj4VarY = nj4Var.Y();
        return (nj4VarY == null || (nj4VarP0 = (nj4Var2 = this.U0).p0(nj4VarY)) == nj4Var2) ? nj4VarP02 : nj4VarP02.n0(nj4VarP0);
    }

    @Override // defpackage.nj4
    public final nj4 q0() {
        if (this.P0) {
            return this;
        }
        return new a70(this.L0, this.S0, this.Q0, this.R0, this.U0.q0(), this.N0, this.O0, true);
    }

    @Override // defpackage.nj4
    public final nj4 r0(Object obj) {
        return new a70(this.L0, this.S0, this.Q0, this.R0, this.U0, this.N0, obj, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 s0(Object obj) {
        return new a70(this.L0, this.S0, this.Q0, this.R0, this.U0, obj, this.O0, this.P0);
    }

    public final String toString() {
        return "[collection type; class " + this.L0.getName() + ", contains " + this.U0 + "]";
    }
}
