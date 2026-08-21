package defpackage;

import j$.util.DesugarCollections;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gg2 extends a1 {
    public boolean A;
    public boolean X;
    public final cm2 b;
    public Object f;
    public Object z;

    public gg2(cm2 cm2Var, Object obj, Object obj2, boolean z, boolean z2) {
        this.b = cm2Var;
        this.f = obj;
        this.z = obj2;
        this.A = z;
        this.X = z2;
    }

    @Override // defpackage.a1
    public final a1 B(ft0 ft0Var) {
        J(ft0Var);
        if (ft0Var.z.Z == 2 && ft0Var.r().b == ct0.MESSAGE) {
            return ((c1) this.z).r();
        }
        zo2.w(fw.y(new StringBuilder("\""), ft0Var.X, "\" is not a message value field."));
        return null;
    }

    @Override // defpackage.a1
    public final a1 D(ft0 ft0Var, Object obj) {
        J(ft0Var);
        if (obj == null) {
            zo2.n(fw.y(new StringBuilder(), ft0Var.X, " is null"));
            return null;
        }
        if (ft0Var.z.Z == 1) {
            this.f = obj;
            this.A = true;
            return this;
        }
        if (ft0Var.r() == et0.Y) {
            obj = Integer.valueOf(((bt0) obj).z.Z);
        } else if (ft0Var.r() == et0.A) {
            cm2 cm2Var = this.b;
            if (!cm2Var.X.getClass().isInstance(obj)) {
                obj = ((c1) cm2Var.X).u().x((c1) obj).p();
            }
        }
        this.z = obj;
        this.X = true;
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final ig2 p() {
        ig2 ig2Var = new ig2(this.b, this.f, this.z);
        if (ig2Var.c()) {
            return ig2Var;
        }
        throw a1.C(ig2Var);
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: I */
    public final nl2 q() {
        return new ig2(this.b, this.f, this.z);
    }

    public final void J(ft0 ft0Var) {
        ws0 ws0Var = ft0Var.B0;
        cm2 cm2Var = this.b;
        if (ws0Var == ((ws0) cm2Var.Y)) {
            return;
        }
        throw new RuntimeException("Wrong FieldDescriptor \"" + ft0Var.X + "\" used in message \"" + ((ws0) cm2Var.Y).A);
    }

    @Override // defpackage.ql2
    public final boolean b(ft0 ft0Var) {
        J(ft0Var);
        return ft0Var.z.Z == 1 ? this.A : this.X;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        Object obj = this.z;
        if (((aw4) this.b.A).b == cw4.MESSAGE) {
            return ((nl2) obj).c();
        }
        return true;
    }

    public final Object clone() {
        return new gg2(this.b, this.f, this.z, this.A, this.X);
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return (ws0) this.b.Y;
    }

    @Override // defpackage.ql2
    public final cm4 i() {
        return cm4.f;
    }

    @Override // defpackage.ql2
    public final Map l() {
        TreeMap treeMap = new TreeMap();
        for (ft0 ft0Var : ((ws0) this.b.Y).m()) {
            if (b(ft0Var)) {
                treeMap.put(ft0Var, n(ft0Var));
            }
        }
        return DesugarCollections.unmodifiableMap(treeMap);
    }

    @Override // defpackage.ql2
    public final Object n(ft0 ft0Var) {
        J(ft0Var);
        Object obj = ft0Var.z.Z == 1 ? this.f : this.z;
        return ft0Var.r() == et0.Y ? ft0Var.l().j(((Integer) obj).intValue()) : obj;
    }

    @Override // defpackage.a1
    public final a1 o(ft0 ft0Var, Object obj) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // defpackage.a1
    public final c1 q() {
        return new ig2(this.b, this.f, this.z);
    }

    @Override // defpackage.a1
    public final a1 G(cm4 cm4Var) {
        return this;
    }
}
