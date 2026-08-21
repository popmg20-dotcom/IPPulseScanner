package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xj3 extends dx1 {
    public nj4 U0;

    @Override // defpackage.nj4
    public final qj4 X() {
        nj4 nj4Var = this.U0;
        return nj4Var != null ? nj4Var.X() : this.S0;
    }

    @Override // defpackage.nj4
    public final StringBuilder Z(StringBuilder sb) {
        nj4 nj4Var = this.U0;
        return nj4Var != null ? nj4Var.Z(sb) : sb;
    }

    @Override // defpackage.nj4
    public final StringBuilder a0(StringBuilder sb) {
        nj4 nj4Var = this.U0;
        if (nj4Var != null) {
            return nj4Var.Z(sb);
        }
        sb.append("?");
        return sb;
    }

    @Override // defpackage.nj4
    public final nj4 d0() {
        nj4 nj4Var = this.U0;
        return nj4Var != null ? nj4Var.d0() : this.Q0;
    }

    @Override // defpackage.nj4
    public final boolean h0() {
        return false;
    }

    @Override // defpackage.nj4
    public final nj4 l0(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr) {
        return null;
    }

    public final String toString() {
        StringBuilder sbB = fw.B(40, "[recursive type; ");
        nj4 nj4Var = this.U0;
        if (nj4Var == null) {
            sbB.append("UNRESOLVED");
        } else {
            sbB.append(nj4Var.L0.getName());
        }
        return sbB.toString();
    }

    @Override // defpackage.nj4
    public final nj4 q0() {
        return this;
    }

    @Override // defpackage.nj4
    public final nj4 n0(nj4 nj4Var) {
        return this;
    }

    @Override // defpackage.nj4
    public final nj4 o0(ak4 ak4Var) {
        return this;
    }

    @Override // defpackage.nj4
    public final nj4 r0(Object obj) {
        return this;
    }

    @Override // defpackage.nj4
    public final nj4 s0(Object obj) {
        return this;
    }
}
