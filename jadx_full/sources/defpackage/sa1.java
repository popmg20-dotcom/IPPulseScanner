package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sa1 extends yn1 {
    public static final sa1 A0;
    public static final qa1 B0;
    public int X;
    public volatile String Y;
    public volatile String Z;
    public long y0;
    public byte z0;

    static {
        ao3.a(4, "FD");
        sa1 sa1Var = new sa1();
        sa1Var.X = 0;
        sa1Var.Y = "";
        sa1Var.Z = "";
        sa1Var.y0 = 0L;
        sa1Var.z0 = (byte) -1;
        sa1Var.Y = "";
        sa1Var.Z = "";
        A0 = sa1Var;
        B0 = new qa1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.Z;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.Z = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String J() {
        String str = this.Y;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.Y = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final ra1 u() {
        if (this == A0) {
            return new ra1();
        }
        ra1 ra1Var = new ra1();
        ra1Var.V(this);
        return ra1Var;
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
        this.z0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        int i = this.X;
        if (i != 0) {
            q60Var.s(1, i);
        }
        if (!yn1.C(this.Y)) {
            yn1.G(q60Var, 2, this.Y);
        }
        if (!yn1.C(this.Z)) {
            yn1.G(q60Var, 3, this.Z);
        }
        long j = this.y0;
        if (j != 0) {
            q60Var.A(4, j);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sa1)) {
            return super.equals(obj);
        }
        sa1 sa1Var = (sa1) obj;
        return this.X == sa1Var.X && J().equals(sa1Var.J()) && H().equals(sa1Var.H()) && this.y0 == sa1Var.y0 && this.z.equals(sa1Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int i2 = this.X;
        int iE = i2 != 0 ? q60.e(1, i2) : 0;
        if (!yn1.C(this.Y)) {
            iE += yn1.v(2, this.Y);
        }
        if (!yn1.C(this.Z)) {
            iE += yn1.v(3, this.Z);
        }
        long j = this.y0;
        if (j != 0) {
            iE += q60.k(4, j);
        }
        int iH = this.z.h() + iE;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.z.hashCode() + ((i12.b(this.y0) + ((((H().hashCode() + ((((J().hashCode() + ha0.i(fw.q(bf4.e1, 779, 37, 1, 53), this.X, 37, 2, 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 29);
        this.b = iHashCode;
        return iHashCode;
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
        ra1 ra1Var = new ra1(ue1Var);
        ra1Var.Z = "";
        ra1Var.y0 = "";
        return ra1Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.f1;
        vn1Var.a(sa1.class, ra1.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
