package defpackage;

import j$.util.DesugarCollections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class kn1 extends a1 {
    public ol2 A = cm4.f;
    public b1 b;
    public oj1 f;
    public boolean z;

    public kn1(b1 b1Var) {
        this.b = b1Var;
    }

    @Override // defpackage.a1
    public a1 B(ft0 ft0Var) {
        return L().b(ft0Var).h();
    }

    @Override // defpackage.a1
    public final void E(yl4 yl4Var) {
        this.A = yl4Var;
        S();
    }

    @Override // defpackage.a1
    public final a1 G(cm4 cm4Var) {
        this.A = cm4Var;
        S();
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public kn1 o(ft0 ft0Var, Object obj) {
        L().b(ft0Var).l(this, obj);
        return this;
    }

    public final TreeMap J() {
        TreeMap treeMap = new TreeMap();
        List listM = L().a.m();
        int i = 0;
        while (i < listM.size()) {
            ft0 ft0VarD = (ft0) listM.get(i);
            kt0 kt0Var = ft0VarD.C0;
            if (kt0Var != null) {
                i += kt0Var.Y - 1;
                if (L().c(kt0Var).b(this)) {
                    ft0VarD = L().c(kt0Var).d(this);
                    treeMap.put(ft0VarD, n(ft0VarD));
                }
            } else if (ft0VarD.y()) {
                List list = (List) n(ft0VarD);
                if (!list.isEmpty()) {
                    treeMap.put(ft0VarD, list);
                }
            } else if (b(ft0VarD)) {
                treeMap.put(ft0VarD, n(ft0VarD));
            }
            i++;
        }
        return treeMap;
    }

    public final oj1 K() {
        oj1 oj1Var = this.f;
        if (oj1Var != null) {
            return oj1Var;
        }
        oj1 oj1Var2 = new oj1(4, this);
        this.f = oj1Var2;
        return oj1Var2;
    }

    public abstract vn1 L();

    public ye N(int i) {
        throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
    }

    public ye O(int i) {
        throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final void A(cm4 cm4Var) {
        cm4 cm4Var2 = cm4.f;
        if (cm4Var2.equals(cm4Var)) {
            return;
        }
        if (cm4Var2.equals(this.A)) {
            this.A = cm4Var;
            S();
        } else {
            u().w(cm4Var);
            S();
        }
    }

    public final void Q(int i, int i2) {
        u().x(i, i2);
    }

    public final void R() {
        if (this.b != null) {
            this.z = true;
        }
    }

    public final void S() {
        b1 b1Var;
        if (!this.z || (b1Var = this.b) == null) {
            return;
        }
        b1Var.d();
        this.z = false;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public kn1 D(ft0 ft0Var, Object obj) {
        L().b(ft0Var).j(this, obj);
        return this;
    }

    @Override // defpackage.ql2
    public boolean b(ft0 ft0Var) {
        return L().b(ft0Var).b(this);
    }

    public final Object clone() {
        return (kn1) ((kn1) a().r()).v(q());
    }

    @Override // defpackage.ql2
    public final cm4 i() {
        ol2 ol2Var = this.A;
        return ol2Var instanceof cm4 ? (cm4) ol2Var : ((yl4) ol2Var).p();
    }

    @Override // defpackage.ql2
    public Map l() {
        return DesugarCollections.unmodifiableMap(J());
    }

    @Override // defpackage.ql2
    public Object n(ft0 ft0Var) {
        Object objD = L().b(ft0Var).d(this);
        return ft0Var.y() ? DesugarCollections.unmodifiableList((List) objD) : objD;
    }

    @Override // defpackage.a1
    public a1 r(ft0 ft0Var) {
        return L().b(ft0Var).o(this);
    }

    @Override // defpackage.a1
    public final yl4 u() {
        ol2 ol2Var = this.A;
        if (ol2Var instanceof cm4) {
            yl4 yl4VarP = yl4.p();
            yl4VarP.w((cm4) ol2Var);
            this.A = yl4VarP;
        }
        S();
        return (yl4) this.A;
    }

    public kn1() {
    }
}
