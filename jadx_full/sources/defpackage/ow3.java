package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ow3 extends yn1 {
    public static final ow3 H0;
    public static final mw3 I0;
    public boolean A0;
    public int B0;
    public int C0;
    public boolean D0;
    public long E0;
    public xj2 F0;
    public byte G0;
    public int X;
    public int Y;
    public volatile String Z;
    public int y0;
    public volatile String z0;

    static {
        ao3.a(4, "Signal");
        ow3 ow3Var = new ow3();
        ow3Var.Y = 0;
        ow3Var.Z = "";
        ow3Var.y0 = 0;
        ow3Var.z0 = "";
        ow3Var.A0 = false;
        ow3Var.B0 = 0;
        ow3Var.C0 = 0;
        ow3Var.D0 = false;
        ow3Var.E0 = 0L;
        ow3Var.G0 = (byte) -1;
        ow3Var.Z = "";
        ow3Var.z0 = "";
        H0 = ow3Var;
        I0 = new mw3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.z0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.z0 = strI;
        return strI;
    }

    public final xj2 J() {
        xj2 xj2Var = this.F0;
        return xj2Var == null ? xj2.C0 : xj2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String K() {
        String str = this.Z;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.Z = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final nw3 u() {
        if (this == H0) {
            return new nw3();
        }
        nw3 nw3Var = new nw3();
        nw3Var.W(this);
        return nw3Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return H0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.G0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.G0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        int i = this.Y;
        if (i != 0) {
            q60Var.s(1, i);
        }
        if (!yn1.C(this.Z)) {
            yn1.G(q60Var, 2, this.Z);
        }
        int i2 = this.y0;
        if (i2 != 0) {
            q60Var.s(3, i2);
        }
        if (!yn1.C(this.z0)) {
            yn1.G(q60Var, 4, this.z0);
        }
        boolean z = this.A0;
        if (z) {
            q60Var.n(5, z);
        }
        int i3 = this.B0;
        if (i3 != 0) {
            q60Var.s(6, i3);
        }
        int i4 = this.C0;
        if (i4 != 0) {
            q60Var.s(7, i4);
        }
        boolean z2 = this.D0;
        if (z2) {
            q60Var.n(8, z2);
        }
        long j = this.E0;
        if (j != 0) {
            q60Var.A(9, j);
        }
        if ((this.X & 1) != 0) {
            q60Var.u(10, J());
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ow3)) {
                return super.equals(obj);
            }
            ow3 ow3Var = (ow3) obj;
            if (this.Y == ow3Var.Y && K().equals(ow3Var.K()) && this.y0 == ow3Var.y0 && H().equals(ow3Var.H()) && this.A0 == ow3Var.A0 && this.B0 == ow3Var.B0 && this.C0 == ow3Var.C0 && this.D0 == ow3Var.D0 && this.E0 == ow3Var.E0) {
                int i = this.X;
                if (((i & 1) != 0) == ((ow3Var.X & 1) != 0) && (((i & 1) == 0 || J().equals(ow3Var.J())) && this.z.equals(ow3Var.z))) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int i2 = this.Y;
        int iE = i2 != 0 ? q60.e(1, i2) : 0;
        if (!yn1.C(this.Z)) {
            iE += yn1.v(2, this.Z);
        }
        int i3 = this.y0;
        if (i3 != 0) {
            iE += q60.e(3, i3);
        }
        if (!yn1.C(this.z0)) {
            iE += yn1.v(4, this.z0);
        }
        if (this.A0) {
            iE += q60.b(5);
        }
        int i4 = this.B0;
        if (i4 != 0) {
            iE += q60.e(6, i4);
        }
        int i5 = this.C0;
        if (i5 != 0) {
            iE += q60.e(7, i5);
        }
        if (this.D0) {
            iE += q60.b(8);
        }
        long j = this.E0;
        if (j != 0) {
            iE += q60.k(9, j);
        }
        if ((1 & this.X) != 0) {
            iE += q60.f(10, J());
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
        int iB = i12.b(this.E0) + ((((i12.a(this.D0) + ha0.i(ha0.i((((i12.a(this.A0) + ((((H().hashCode() + ha0.i((((K().hashCode() + ha0.i(fw.q(bf4.K0, 779, 37, 1, 53), this.Y, 37, 2, 53)) * 37) + 3) * 53, this.y0, 37, 4, 53)) * 37) + 5) * 53)) * 37) + 6) * 53, this.B0, 37, 7, 53), this.C0, 37, 8, 53)) * 37) + 9) * 53);
        if ((this.X & 1) != 0) {
            iB = fw.p(iB, 37, 10, 53) + J().hashCode();
        }
        int iHashCode = this.z.hashCode() + (iB * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return H0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return I0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return H0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        nw3 nw3Var = new nw3(ue1Var);
        nw3Var.Z = "";
        nw3Var.z0 = "";
        return nw3Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.L0;
        vn1Var.a(ow3.class, nw3.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return H0;
    }
}
