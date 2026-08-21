package defpackage;

import j$.util.DesugarCollections;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ln1 extends kn1 {
    public jd1 X;

    @Override // defpackage.kn1, defpackage.a1
    public final a1 B(ft0 ft0Var) {
        return ft0Var.z.Q() ? new mz0(ft0Var.p()) : super.B(ft0Var);
    }

    @Override // defpackage.kn1, defpackage.a1
    public final a1 D(ft0 ft0Var, Object obj) {
        if (!ft0Var.z.Q()) {
            super.D(ft0Var, obj);
            return this;
        }
        Y(ft0Var);
        U();
        this.X.n(ft0Var, obj);
        S();
        return this;
    }

    @Override // defpackage.kn1
    /* JADX INFO: renamed from: H */
    public final kn1 o(ft0 ft0Var, Object obj) {
        if (!ft0Var.z.Q()) {
            super.o(ft0Var, obj);
            return this;
        }
        Y(ft0Var);
        U();
        this.X.a(ft0Var, obj);
        S();
        return this;
    }

    @Override // defpackage.kn1
    /* JADX INFO: renamed from: T */
    public final kn1 D(ft0 ft0Var, Object obj) {
        if (!ft0Var.z.Q()) {
            super.D(ft0Var, obj);
            return this;
        }
        Y(ft0Var);
        U();
        this.X.n(ft0Var, obj);
        S();
        return this;
    }

    public final void U() {
        if (this.X == null) {
            kd1 kd1Var = kd1.d;
            jy3 jy3VarG = jy3.g();
            jd1 jd1Var = new jd1();
            jd1Var.a = jy3VarG;
            jd1Var.c = true;
            this.X = jd1Var;
        }
    }

    public final boolean V() {
        jd1 jd1Var = this.X;
        return jd1Var == null || jd1Var.i();
    }

    public final void W(nn1 nn1Var) {
        if (nn1Var.X != null) {
            U();
            this.X.j(nn1Var.X);
            S();
        }
    }

    public final boolean X(m60 m60Var, o91 o91Var, int i) {
        U();
        m60Var.getClass();
        return vo.D(m60Var, u(), o91Var, f(), new wn1(6, this.X), i);
    }

    public final void Y(ft0 ft0Var) {
        if (ft0Var.B0 == f()) {
            return;
        }
        xe.k("FieldDescriptor does not match message type.");
    }

    @Override // defpackage.kn1, defpackage.ql2
    public final boolean b(ft0 ft0Var) {
        if (!ft0Var.z.Q()) {
            return super.b(ft0Var);
        }
        Y(ft0Var);
        jd1 jd1Var = this.X;
        return jd1Var != null && jd1Var.h(ft0Var);
    }

    @Override // defpackage.kn1, defpackage.ql2
    public final Map l() {
        TreeMap treeMapJ = J();
        jd1 jd1Var = this.X;
        if (jd1Var != null) {
            treeMapJ.putAll(jd1Var.e());
        }
        return DesugarCollections.unmodifiableMap(treeMapJ);
    }

    @Override // defpackage.kn1, defpackage.ql2
    public final Object n(ft0 ft0Var) {
        if (!ft0Var.z.Q()) {
            return super.n(ft0Var);
        }
        Y(ft0Var);
        jd1 jd1Var = this.X;
        Object objF = jd1Var == null ? null : jd1Var.f(ft0Var);
        return objF == null ? ft0Var.r().b == ct0.MESSAGE ? nz0.v(ft0Var.p()) : ft0Var.k() : objF;
    }

    @Override // defpackage.kn1, defpackage.a1
    public final a1 o(ft0 ft0Var, Object obj) {
        if (!ft0Var.z.Q()) {
            super.o(ft0Var, obj);
            return this;
        }
        Y(ft0Var);
        U();
        this.X.a(ft0Var, obj);
        S();
        return this;
    }

    @Override // defpackage.kn1, defpackage.a1
    public final a1 r(ft0 ft0Var) {
        if (!ft0Var.z.Q()) {
            return super.r(ft0Var);
        }
        Y(ft0Var);
        if (ft0Var.r().b != ct0.MESSAGE) {
            vp1.n("getFieldBuilder() called on a non-Message type.");
            return null;
        }
        U();
        Object objG = this.X.g(ft0Var);
        if (objG == null) {
            mz0 mz0Var = new mz0(ft0Var.p());
            this.X.n(ft0Var, mz0Var);
            S();
            return mz0Var;
        }
        if (objG instanceof a1) {
            return (a1) objG;
        }
        if (!(objG instanceof c1)) {
            vp1.n("getRepeatedFieldBuilder() called on a non-Message type.");
            return null;
        }
        a1 a1VarU = ((c1) objG).u();
        this.X.n(ft0Var, a1VarU);
        S();
        return a1VarU;
    }
}
