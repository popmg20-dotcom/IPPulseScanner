package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xq0 extends yn1 {
    public static final vq0 A0;
    public static final xq0 z0;
    public int X;
    public int Y;
    public volatile Serializable Z;
    public byte y0;

    static {
        ao3.a(5, "EditionDefault");
        xq0 xq0Var = new xq0();
        xq0Var.Y = 0;
        xq0Var.Z = "";
        xq0Var.y0 = (byte) -1;
        xq0Var.Y = 0;
        xq0Var.Z = "";
        z0 = xq0Var;
        A0 = new vq0();
    }

    public final String H() {
        Serializable serializable = this.Z;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.Z = strI;
        }
        return strI;
    }

    public final boolean J() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final wq0 u() {
        if (this == z0) {
            return new wq0();
        }
        wq0 wq0Var = new wq0();
        wq0Var.V(this);
        return wq0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return z0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.y0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.y0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 2) != 0) {
            yn1.G(q60Var, 2, this.Z);
        }
        if ((this.X & 1) != 0) {
            q60Var.s(3, this.Y);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof xq0)) {
                return super.equals(obj);
            }
            xq0 xq0Var = (xq0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((xq0Var.X & 1) != 0) || (((i & 1) != 0 && this.Y != xq0Var.Y) || J() != xq0Var.J() || ((J() && !H().equals(xq0Var.H())) || !this.z.equals(xq0Var.z)))) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iV = (this.X & 2) != 0 ? yn1.v(2, this.Z) : 0;
        if ((this.X & 1) != 0) {
            iV += q60.d(3, this.Y);
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
        int iHashCode = vs0.g1.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + this.Y;
        }
        if (J()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + H().hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return z0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return A0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return z0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        wq0 wq0Var = new wq0(ue1Var);
        wq0Var.Y = 0;
        wq0Var.Z = "";
        return wq0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.h1;
        vn1Var.a(xq0.class, wq0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return z0;
    }
}
