package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ne extends nj4 {
    public static final /* synthetic */ int W0 = 0;
    public final nj4 U0;
    public final Object V0;

    public ne(nj4 nj4Var, qj4 qj4Var, Object obj, Object obj2, Object obj3, boolean z) {
        super(obj.getClass(), qj4Var, null, null, nj4Var.hashCode(), obj2, obj3, z);
        this.U0 = nj4Var;
        this.V0 = obj;
    }

    @Override // defpackage.nj4
    public final nj4 Y() {
        return this.U0;
    }

    @Override // defpackage.nj4
    public final StringBuilder Z(StringBuilder sb) {
        sb.append('[');
        return this.U0.Z(sb);
    }

    @Override // defpackage.nj4
    public final StringBuilder a0(StringBuilder sb) {
        sb.append('[');
        return this.U0.a0(sb);
    }

    @Override // defpackage.nj4
    public final boolean e0() {
        return this.U0.e0();
    }

    @Override // defpackage.nj4
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == ne.class) {
            return this.U0.equals(((ne) obj).U0);
        }
        return false;
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
        return null;
    }

    @Override // defpackage.nj4
    public final nj4 n0(nj4 nj4Var) {
        return new ne(nj4Var, this.S0, Array.newInstance((Class<?>) nj4Var.L0, 0), this.N0, this.O0, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 o0(ak4 ak4Var) {
        nj4 nj4Var = this.U0;
        if (ak4Var == nj4Var.O0) {
            return this;
        }
        return new ne(nj4Var.r0(ak4Var), this.S0, this.V0, this.N0, this.O0, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 q0() {
        if (this.P0) {
            return this;
        }
        return new ne(this.U0.q0(), this.S0, this.V0, this.N0, this.O0, true);
    }

    @Override // defpackage.nj4
    public final nj4 r0(Object obj) {
        if (obj == this.O0) {
            return this;
        }
        return new ne(this.U0, this.S0, this.V0, this.N0, obj, this.P0);
    }

    @Override // defpackage.nj4
    public final nj4 s0(Object obj) {
        if (obj == this.N0) {
            return this;
        }
        return new ne(this.U0, this.S0, this.V0, obj, this.O0, this.P0);
    }

    public final String toString() {
        return "[array type, component type: " + this.U0 + "]";
    }
}
