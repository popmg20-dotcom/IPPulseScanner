package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ar0 extends yn1 {
    public static final ar0 B0;
    public static final yq0 C0;
    public byte A0;
    public int X;
    public int Y;
    public int Z;
    public volatile Serializable y0;
    public int z0;

    static {
        ao3.a(5, "FeatureSupport");
        ar0 ar0Var = new ar0();
        ar0Var.Y = 0;
        ar0Var.Z = 0;
        ar0Var.y0 = "";
        ar0Var.z0 = 0;
        ar0Var.A0 = (byte) -1;
        ar0Var.Y = 0;
        ar0Var.Z = 0;
        ar0Var.y0 = "";
        ar0Var.z0 = 0;
        B0 = ar0Var;
        C0 = new yq0();
    }

    public final String H() {
        Serializable serializable = this.y0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.y0 = strI;
        }
        return strI;
    }

    public final boolean J() {
        return (this.X & 4) != 0;
    }

    public final boolean K() {
        return (this.X & 2) != 0;
    }

    public final boolean L() {
        return (this.X & 8) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final zq0 u() {
        if (this == B0) {
            return new zq0();
        }
        zq0 zq0Var = new zq0();
        zq0Var.V(this);
        return zq0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return B0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.A0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.A0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            q60Var.s(1, this.Y);
        }
        if ((this.X & 2) != 0) {
            q60Var.s(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            yn1.G(q60Var, 3, this.y0);
        }
        if ((this.X & 8) != 0) {
            q60Var.s(4, this.z0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ar0)) {
                return super.equals(obj);
            }
            ar0 ar0Var = (ar0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((ar0Var.X & 1) != 0) || (((i & 1) != 0 && this.Y != ar0Var.Y) || K() != ar0Var.K() || ((K() && this.Z != ar0Var.Z) || J() != ar0Var.J() || ((J() && !H().equals(ar0Var.H())) || L() != ar0Var.L() || ((L() && this.z0 != ar0Var.z0) || !this.z.equals(ar0Var.z)))))) {
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
        int iD = (this.X & 1) != 0 ? q60.d(1, this.Y) : 0;
        if ((this.X & 2) != 0) {
            iD += q60.d(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            iD += yn1.v(3, this.y0);
        }
        if ((this.X & 8) != 0) {
            iD += q60.d(4, this.z0);
        }
        int iH = this.z.h() + iD;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = vs0.i1.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + this.Y;
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Z;
        }
        if (J()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + H().hashCode();
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + this.z0;
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return B0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return C0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return B0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        zq0 zq0Var = new zq0(ue1Var);
        zq0Var.Y = 0;
        zq0Var.Z = 0;
        zq0Var.y0 = "";
        zq0Var.z0 = 0;
        return zq0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.j1;
        vn1Var.a(ar0.class, zq0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return B0;
    }
}
