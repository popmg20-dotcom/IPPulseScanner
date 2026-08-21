package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ee2 extends yn1 {
    public static final ee2 y0;
    public static final ce2 z0;
    public volatile String X;
    public List Y;
    public byte Z;

    static {
        ao3.a(4, "LogBuffer");
        ee2 ee2Var = new ee2();
        ee2Var.X = "";
        ee2Var.Z = (byte) -1;
        ee2Var.X = "";
        ee2Var.Y = Collections.EMPTY_LIST;
        y0 = ee2Var;
        z0 = new ce2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.X;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.X = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final de2 u() {
        if (this == y0) {
            return new de2();
        }
        de2 de2Var = new de2();
        de2Var.V(this);
        return de2Var;
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
        this.Z = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if (!yn1.C(this.X)) {
            yn1.G(q60Var, 1, this.X);
        }
        for (int i = 0; i < this.Y.size(); i++) {
            q60Var.u(2, (nl2) this.Y.get(i));
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ee2)) {
            return super.equals(obj);
        }
        ee2 ee2Var = (ee2) obj;
        return H().equals(ee2Var.H()) && this.Y.equals(ee2Var.Y) && this.z.equals(ee2Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iV = !yn1.C(this.X) ? yn1.v(1, this.X) : 0;
        for (int i2 = 0; i2 < this.Y.size(); i2++) {
            iV += q60.f(2, (nl2) this.Y.get(i2));
        }
        int iH = this.z.h() + iV;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = H().hashCode() + fw.q(bf4.g1, 779, 37, 1, 53);
        if (this.Y.size() > 0) {
            iHashCode = this.Y.hashCode() + fw.p(iHashCode, 37, 2, 53);
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
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
        de2 de2Var = new de2(ue1Var);
        de2Var.Y = "";
        de2Var.Z = Collections.EMPTY_LIST;
        return de2Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.h1;
        vn1Var.a(ee2.class, de2.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return y0;
    }
}
