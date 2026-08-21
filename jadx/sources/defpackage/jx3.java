package defpackage;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class jx3 extends nj4 {
    public jx3(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr, Object obj, Object obj2, boolean z) {
        super(cls, qj4Var, nj4Var, nj4VarArr, (qj4Var == null ? qj4.Z : qj4Var).A, obj, obj2, z);
    }

    public static jx3 t0(Class cls) {
        return new jx3(cls, null, null, null, null, null, false);
    }

    @Override // defpackage.nj4
    public String V() {
        StringBuilder sb = new StringBuilder(this.L0.getName());
        qj4 qj4Var = this.S0;
        int length = qj4Var.f.length;
        if (length > 0 && U(length)) {
            sb.append('<');
            for (int i = 0; i < length; i++) {
                nj4 nj4VarD = qj4Var.d(i);
                if (i > 0) {
                    sb.append(StringUtil.COMMA);
                }
                sb.append(nj4VarD.m0());
            }
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // defpackage.nj4
    public StringBuilder Z(StringBuilder sb) {
        nj4.T(this.L0, sb, true);
        return sb;
    }

    @Override // defpackage.nj4
    public StringBuilder a0(StringBuilder sb) {
        nj4.T(this.L0, sb, false);
        qj4 qj4Var = this.S0;
        int length = qj4Var.f.length;
        if (length > 0) {
            sb.append('<');
            for (int i = 0; i < length; i++) {
                sb = qj4Var.d(i).a0(sb);
            }
            sb.append('>');
        }
        sb.append(';');
        return sb;
    }

    @Override // defpackage.nj4
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        jx3 jx3Var = (jx3) obj;
        if (jx3Var.L0 != this.L0) {
            return false;
        }
        return this.S0.equals(jx3Var.S0);
    }

    @Override // defpackage.nj4
    public final boolean h0() {
        return false;
    }

    @Override // defpackage.nj4
    public nj4 l0(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr) {
        return null;
    }

    @Override // defpackage.nj4
    public nj4 n0(nj4 nj4Var) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override // defpackage.nj4
    public nj4 o0(ak4 ak4Var) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    public String toString() {
        StringBuilder sbB = fw.B(40, "[simple type, class ");
        sbB.append(V());
        sbB.append(']');
        return sbB.toString();
    }

    @Override // defpackage.nj4
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public jx3 q0() {
        if (this.P0) {
            return this;
        }
        return new jx3(this.L0, this.S0, this.Q0, this.R0, this.N0, this.O0, true);
    }

    @Override // defpackage.nj4
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public jx3 r0(Object obj) {
        if (this.O0 == obj) {
            return this;
        }
        return new jx3(this.L0, this.S0, this.Q0, this.R0, this.N0, obj, this.P0);
    }

    @Override // defpackage.nj4
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public jx3 s0(Object obj) {
        if (obj == this.N0) {
            return this;
        }
        return new jx3(this.L0, this.S0, this.Q0, this.R0, obj, this.O0, this.P0);
    }

    public jx3(Class cls) {
        this(cls, qj4.Z, null, null);
    }

    public jx3(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr) {
        this(cls, qj4Var, nj4Var, nj4VarArr, null, null, false);
    }
}
