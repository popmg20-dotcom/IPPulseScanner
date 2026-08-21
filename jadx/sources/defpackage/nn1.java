package defpackage;

import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nn1 extends yn1 {
    public final kd1 X;

    public nn1(ln1 ln1Var) {
        super(ln1Var);
        jd1 jd1Var = ln1Var.X;
        this.X = jd1Var == null ? kd1.d : jd1Var.b(true);
    }

    public final Object H(xn1 xn1Var) {
        xn1Var.getClass();
        ft0 ft0VarB = xn1Var.b();
        if (ft0VarB.B0 != z().a) {
            StringBuilder sb = new StringBuilder("Extension is for type \"");
            sb.append(ft0VarB.B0.A);
            sb.append("\" which does not match message type \"");
            xe.k(fw.y(sb, z().a.A, "\"."));
            return null;
        }
        Object objB = this.X.a.get(ft0VarB);
        if (objB instanceof d92) {
            objB = ((d92) objB).b();
        }
        Object objA = objB == null ? ft0VarB.y() ? w93.X : ft0VarB.r().b == ct0.MESSAGE ? xn1Var.b : xn1Var.a(ft0VarB.k()) : xn1Var.a(objB);
        Object obj = this.X.a.get(ft0VarB);
        if ((obj instanceof d92) && ((d92) obj).e) {
            this.f = -1;
        }
        return objA;
    }

    public final mn1 J() {
        return this.X.a.isEmpty() ? k01.X : new eg0(this);
    }

    @Override // defpackage.yn1, defpackage.ql2
    public final boolean b(ft0 ft0Var) {
        if (!ft0Var.z.Q()) {
            return super.b(ft0Var);
        }
        if (ft0Var.B0 == z().a) {
            return this.X.i(ft0Var);
        }
        xe.k("FieldDescriptor does not match message type.");
        return false;
    }

    @Override // defpackage.yn1, defpackage.ql2
    public final Map l() {
        TreeMap treeMapX = x();
        treeMapX.putAll(this.X.f());
        return DesugarCollections.unmodifiableMap(treeMapX);
    }

    @Override // defpackage.yn1, defpackage.ql2
    public final Object n(ft0 ft0Var) {
        if (!ft0Var.z.Q()) {
            return super.n(ft0Var);
        }
        if (ft0Var.B0 != z().a) {
            xe.k("FieldDescriptor does not match message type.");
            return null;
        }
        Object objB = this.X.a.get(ft0Var);
        if (objB instanceof d92) {
            objB = ((d92) objB).b();
        }
        return objB == null ? ft0Var.y() ? Collections.EMPTY_LIST : ft0Var.r().b == ct0.MESSAGE ? nz0.v(ft0Var.p()) : ft0Var.k() : objB;
    }

    public nn1() {
        this.X = new kd1();
    }
}
