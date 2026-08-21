package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ns0 extends nn1 {
    public static final ns0 y0;
    public static final is0 z0;
    public List Y;
    public byte Z;

    static {
        ao3.a(5, "SourceCodeInfo");
        ns0 ns0Var = new ns0();
        ns0Var.Z = (byte) -1;
        ns0Var.Y = Collections.EMPTY_LIST;
        y0 = ns0Var;
        z0 = new is0();
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final js0 u() {
        if (this == y0) {
            return new js0();
        }
        js0 js0Var = new js0();
        js0Var.a0(this);
        return js0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return y0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.Z;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (this.X.j()) {
            this.Z = (byte) 1;
            return true;
        }
        this.Z = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        mn1 mn1VarJ = J();
        for (int i = 0; i < this.Y.size(); i++) {
            q60Var.u(1, (nl2) this.Y.get(i));
        }
        mn1VarJ.k(536000001, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ns0)) {
            return super.equals(obj);
        }
        ns0 ns0Var = (ns0) obj;
        return this.Y.equals(ns0Var.Y) && this.z.equals(ns0Var.z) && this.X.f().equals(ns0Var.X.f());
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iF = 0;
        for (int i2 = 0; i2 < this.Y.size(); i2++) {
            iF += q60.f(1, (nl2) this.Y.get(i2));
        }
        int iH = this.z.h() + this.X.h() + iF;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = vs0.E1.hashCode() + 779;
        if (this.Y.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + this.Y.hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (c1.q(iHashCode, this.X.f()) * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return y0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return z0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return y0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        js0 js0Var = new js0(ue1Var);
        js0Var.Z = Collections.EMPTY_LIST;
        return js0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.F1;
        vn1Var.a(ns0.class, js0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return y0;
    }
}
