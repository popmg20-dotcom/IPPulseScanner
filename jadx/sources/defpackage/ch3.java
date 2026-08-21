package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ch3 extends jx3 {
    public final nj4 U0;
    public final nj4 V0;

    public ch3(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr, nj4 nj4Var2, nj4 nj4Var3, Object obj, Object obj2, boolean z) {
        super(cls, qj4Var, nj4Var, nj4VarArr, Objects.hashCode(nj4Var2), obj, obj2, z);
        this.U0 = nj4Var2;
        this.V0 = nj4Var3 == null ? this : nj4Var3;
    }

    @Override // defpackage.vo
    public final boolean B() {
        return true;
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final String V() {
        StringBuilder sb = new StringBuilder(this.L0.getName());
        nj4 nj4Var = this.U0;
        if (nj4Var != null && U(1)) {
            sb.append('<');
            sb.append(nj4Var.m0());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // defpackage.nj4
    public final nj4 Y() {
        return this.U0;
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final StringBuilder Z(StringBuilder sb) {
        nj4.T(this.L0, sb, true);
        return sb;
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final StringBuilder a0(StringBuilder sb) {
        nj4.T(this.L0, sb, false);
        sb.append('<');
        StringBuilder sbA0 = this.U0.a0(sb);
        sbA0.append(">;");
        return sbA0;
    }

    @Override // defpackage.nj4
    /* JADX INFO: renamed from: c0 */
    public final nj4 u() {
        return this.U0;
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ch3.class) {
            return false;
        }
        ch3 ch3Var = (ch3) obj;
        if (ch3Var.L0 != this.L0) {
            return false;
        }
        return this.U0.equals(ch3Var.U0);
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final nj4 l0(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr) {
        return new ch3(cls, this.S0, nj4Var, nj4VarArr, this.U0, this.V0, this.N0, this.O0, this.P0);
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final nj4 n0(nj4 nj4Var) {
        if (this.U0 == nj4Var) {
            return this;
        }
        return new ch3(this.L0, this.S0, this.Q0, this.R0, nj4Var, this.V0, this.N0, this.O0, this.P0);
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final nj4 o0(ak4 ak4Var) {
        nj4 nj4Var = this.U0;
        if (ak4Var == nj4Var.O0) {
            return this;
        }
        return new ch3(this.L0, this.S0, this.Q0, this.R0, nj4Var.r0(ak4Var), this.V0, this.N0, this.O0, this.P0);
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final nj4 r0(Object obj) {
        if (obj == this.O0) {
            return this;
        }
        return new ch3(this.L0, this.S0, this.Q0, this.R0, this.U0, this.V0, this.N0, obj, this.P0);
    }

    @Override // defpackage.jx3, defpackage.nj4
    public final nj4 s0(Object obj) {
        if (obj == this.N0) {
            return this;
        }
        return new ch3(this.L0, this.S0, this.Q0, this.R0, this.U0, this.V0, obj, this.O0, this.P0);
    }

    @Override // defpackage.jx3
    public final String toString() {
        StringBuilder sbB = fw.B(40, "[reference type, class ");
        sbB.append(V());
        sbB.append('<');
        sbB.append(this.U0);
        sbB.append(">]");
        return sbB.toString();
    }

    @Override // defpackage.nj4, defpackage.vo
    public final nj4 u() {
        return this.U0;
    }

    @Override // defpackage.jx3
    /* JADX INFO: renamed from: v0 */
    public final jx3 r0(Object obj) {
        if (obj == this.O0) {
            return this;
        }
        return new ch3(this.L0, this.S0, this.Q0, this.R0, this.U0, this.V0, this.N0, obj, this.P0);
    }

    @Override // defpackage.jx3
    /* JADX INFO: renamed from: w0 */
    public final jx3 s0(Object obj) {
        if (obj == this.N0) {
            return this;
        }
        return new ch3(this.L0, this.S0, this.Q0, this.R0, this.U0, this.V0, obj, this.O0, this.P0);
    }

    @Override // defpackage.jx3
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final ch3 q0() {
        if (this.P0) {
            return this;
        }
        return new ch3(this.L0, this.S0, this.Q0, this.R0, this.U0.q0(), this.V0, this.N0, this.O0, true);
    }
}
