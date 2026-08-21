package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lq0 extends yn1 {
    public static final lq0 A0;
    public static final jq0 B0;
    public int X;
    public int Y;
    public gq0 Z;
    public gq0 y0;
    public byte z0;

    static {
        ao3.a(5, "FeatureSetEditionDefault");
        lq0 lq0Var = new lq0();
        lq0Var.z0 = (byte) -1;
        lq0Var.Y = 0;
        A0 = lq0Var;
        B0 = new jq0();
    }

    public final gq0 H() {
        gq0 gq0Var = this.y0;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final gq0 J() {
        gq0 gq0Var = this.Z;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean K() {
        return (this.X & 4) != 0;
    }

    public final boolean L() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final kq0 u() {
        if (this == A0) {
            return new kq0();
        }
        kq0 kq0Var = new kq0();
        kq0Var.V(this);
        return kq0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return A0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.z0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (L() && !J().c()) {
            this.z0 = (byte) 0;
            return false;
        }
        if (!K() || H().c()) {
            this.z0 = (byte) 1;
            return true;
        }
        this.z0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            q60Var.s(3, this.Y);
        }
        if ((this.X & 2) != 0) {
            q60Var.u(4, J());
        }
        if ((this.X & 4) != 0) {
            q60Var.u(5, H());
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof lq0)) {
                return super.equals(obj);
            }
            lq0 lq0Var = (lq0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((lq0Var.X & 1) != 0) || (((i & 1) != 0 && this.Y != lq0Var.Y) || L() != lq0Var.L() || ((L() && !J().equals(lq0Var.J())) || K() != lq0Var.K() || ((K() && !H().equals(lq0Var.H())) || !this.z.equals(lq0Var.z))))) {
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
        int iD = (this.X & 1) != 0 ? q60.d(3, this.Y) : 0;
        if ((this.X & 2) != 0) {
            iD += q60.f(4, J());
        }
        if ((this.X & 4) != 0) {
            iD += q60.f(5, H());
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
        int iHashCode = vs0.C1.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + this.Y;
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + J().hashCode();
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + H().hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return A0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return B0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return A0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        kq0 kq0Var = new kq0(ue1Var);
        kq0Var.Y = 0;
        return kq0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.D1;
        vn1Var.a(lq0.class, kq0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
