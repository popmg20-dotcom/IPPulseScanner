package defpackage;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wg2 extends nj4 {
    public final nj4 U0;
    public final nj4 V0;

    public wg2(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr, nj4 nj4Var2, nj4 nj4Var3, Object obj, Object obj2, boolean z) {
        super(cls, qj4Var, nj4Var, nj4VarArr, nj4Var3.hashCode() + (nj4Var2.hashCode() * 31), obj, obj2, z);
        this.U0 = nj4Var2;
        this.V0 = nj4Var3;
    }

    @Override // defpackage.nj4
    public final String V() {
        StringBuilder sb = new StringBuilder(this.L0.getName());
        nj4 nj4Var = this.U0;
        if (nj4Var != null && U(2)) {
            sb.append('<');
            sb.append(nj4Var.m0());
            sb.append(StringUtil.COMMA);
            sb.append(this.V0.m0());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // defpackage.nj4
    public final nj4 Y() {
        return this.V0;
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
        this.V0.a0(sb);
        sb.append(">;");
        return sb;
    }

    @Override // defpackage.nj4
    public final nj4 b0() {
        return this.U0;
    }

    @Override // defpackage.nj4
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != wg2.class) {
            return false;
        }
        wg2 wg2Var = (wg2) obj;
        return this.L0 == wg2Var.L0 && this.U0.equals(wg2Var.U0) && this.V0.equals(wg2Var.V0);
    }

    @Override // defpackage.nj4
    public final boolean f0() {
        return super.f0() || this.V0.f0() || this.U0.f0();
    }

    @Override // defpackage.nj4
    public final boolean h0() {
        return true;
    }

    @Override // defpackage.nj4
    public final nj4 l0(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr) {
        return new wg2(cls, qj4Var, nj4Var, nj4VarArr, this.U0, this.V0, this.N0, this.O0, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 n0(nj4 nj4Var) {
        if (this.V0 == nj4Var) {
            return this;
        }
        return new wg2(this.L0, this.S0, this.Q0, this.R0, this.U0, nj4Var, this.N0, this.O0, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 o0(ak4 ak4Var) {
        return new wg2(this.L0, this.S0, this.Q0, this.R0, this.U0, this.V0.r0(ak4Var), this.N0, this.O0, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 p0(nj4 nj4Var) {
        nj4 nj4Var2;
        nj4 nj4VarP0;
        nj4 nj4VarP02 = super.p0(nj4Var);
        nj4 nj4VarB0 = nj4Var.b0();
        boolean z = nj4VarP02 instanceof wg2;
        nj4 wg2Var = nj4VarP02;
        wg2Var = nj4VarP02;
        if (z && nj4VarB0 != null) {
            nj4 nj4Var3 = this.U0;
            nj4 nj4VarP03 = nj4Var3.p0(nj4VarB0);
            wg2Var = nj4VarP02;
            if (nj4VarP03 != nj4Var3) {
                wg2 wg2Var2 = (wg2) nj4VarP02;
                nj4 nj4Var4 = wg2Var2.U0;
                wg2Var = wg2Var2;
                if (nj4VarP03 != nj4Var4) {
                    wg2Var = new wg2(wg2Var2.L0, wg2Var2.S0, wg2Var2.Q0, wg2Var2.R0, nj4VarP03, wg2Var2.V0, wg2Var2.N0, wg2Var2.O0, wg2Var2.P0);
                }
            }
        }
        nj4 nj4VarY = nj4Var.Y();
        return (nj4VarY == null || (nj4VarP0 = (nj4Var2 = this.V0).p0(nj4VarY)) == nj4Var2) ? wg2Var : wg2Var.n0(nj4VarP0);
    }

    @Override // defpackage.nj4
    public final nj4 q0() {
        if (this.P0) {
            return this;
        }
        return new wg2(this.L0, this.S0, this.Q0, this.R0, this.U0.q0(), this.V0.q0(), this.N0, this.O0, true);
    }

    @Override // defpackage.nj4
    public final nj4 r0(Object obj) {
        return new wg2(this.L0, this.S0, this.Q0, this.R0, this.U0, this.V0, this.N0, obj, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 s0(Object obj) {
        return new wg2(this.L0, this.S0, this.Q0, this.R0, this.U0, this.V0, obj, this.O0, this.P0);
    }

    public final String toString() {
        return "[map type; class " + this.L0.getName() + ", " + this.U0 + " -> " + this.V0 + "]";
    }
}
