package defpackage;

import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ig2 extends c1 {
    public final Object A;
    public final cm2 X;
    public volatile int Y;
    public final Object z;

    public ig2(m60 m60Var, o91 o91Var, cm2 cm2Var) throws s12 {
        this.Y = -1;
        try {
            this.X = cm2Var;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntryT = je.T(m60Var, o91Var, cm2Var);
            this.z = simpleImmutableEntryT.getKey();
            this.A = simpleImmutableEntryT.getValue();
        } catch (s12 e) {
            throw e;
        } catch (IOException e2) {
            throw new s12(e2.getMessage(), e2);
        }
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        cm2 cm2Var = this.X;
        return new ig2(cm2Var, cm2Var.z, cm2Var.X);
    }

    @Override // defpackage.ql2
    public final boolean b(ft0 ft0Var) {
        v(ft0Var);
        return true;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        if (((aw4) this.X.A).b == cw4.MESSAGE) {
            return ((nl2) this.A).c();
        }
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) {
        cm2 cm2Var = this.X;
        kd1.p(q60Var, (aw4) cm2Var.f, 1, this.z);
        kd1.p(q60Var, (aw4) cm2Var.A, 2, this.A);
    }

    @Override // defpackage.ql2
    public final ws0 f() {
        return (ws0) this.X.Y;
    }

    @Override // defpackage.nl2
    public final int h() {
        if (this.Y != -1) {
            return this.Y;
        }
        cm2 cm2Var = this.X;
        Object obj = this.z;
        Object obj2 = this.A;
        int iC = kd1.c((aw4) cm2Var.A, 2, obj2) + kd1.c((aw4) cm2Var.f, 1, obj);
        this.Y = iC;
        return iC;
    }

    @Override // defpackage.ql2
    public final cm4 i() {
        return cm4.f;
    }

    @Override // defpackage.ql2
    public final Map l() {
        TreeMap treeMap = new TreeMap();
        for (ft0 ft0Var : ((ws0) this.X.Y).m()) {
            v(ft0Var);
            treeMap.put(ft0Var, n(ft0Var));
        }
        return DesugarCollections.unmodifiableMap(treeMap);
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return (hg2) this.X.Z;
    }

    @Override // defpackage.ql2
    public final Object n(ft0 ft0Var) {
        v(ft0Var);
        Object obj = ft0Var.z.Z == 1 ? this.z : this.A;
        return ft0Var.r() == et0.Y ? ft0Var.l().j(((Integer) obj).intValue()) : obj;
    }

    public final void v(ft0 ft0Var) {
        ws0 ws0Var = ft0Var.B0;
        cm2 cm2Var = this.X;
        if (ws0Var == ((ws0) cm2Var.Y)) {
            return;
        }
        throw new RuntimeException("Wrong FieldDescriptor \"" + ft0Var.X + "\" used in message \"" + ((ws0) cm2Var.Y).A);
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final gg2 r() {
        cm2 cm2Var = this.X;
        return new gg2(cm2Var, cm2Var.z, cm2Var.X, false, false);
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final gg2 u() {
        return new gg2(this.X, this.z, this.A, true, true);
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        cm2 cm2Var = this.X;
        return new ig2(cm2Var, cm2Var.z, cm2Var.X);
    }

    public ig2(cm2 cm2Var, Object obj, Object obj2) {
        this.Y = -1;
        this.z = obj;
        this.A = obj2;
        this.X = cm2Var;
    }

    public ig2(ws0 ws0Var, aw4 aw4Var, aw4 aw4Var2, Object obj) {
        this.Y = -1;
        this.z = 0;
        this.A = obj;
        this.X = new cm2(ws0Var, this, aw4Var, aw4Var2);
    }
}
