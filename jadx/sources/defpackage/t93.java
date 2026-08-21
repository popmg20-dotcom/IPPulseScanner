package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t93 extends yn1 {
    public static final t93 J0;
    public static final r93 K0;
    public int A0;
    public volatile String B0;
    public int C0;
    public int D0;
    public volatile String E0;
    public volatile String F0;
    public volatile String G0;
    public volatile String H0;
    public byte I0;
    public int X;
    public int Y;
    public int Z;
    public volatile String y0;
    public volatile String z0;

    static {
        ao3.a(4, "TrafficInfo");
        t93 t93Var = new t93();
        t93Var.X = 0;
        t93Var.Y = 0;
        t93Var.Z = 0;
        t93Var.y0 = "";
        t93Var.z0 = "";
        t93Var.A0 = 0;
        t93Var.B0 = "";
        t93Var.C0 = 0;
        t93Var.D0 = 0;
        t93Var.E0 = "";
        t93Var.F0 = "";
        t93Var.G0 = "";
        t93Var.H0 = "";
        t93Var.I0 = (byte) -1;
        t93Var.y0 = "";
        t93Var.z0 = "";
        t93Var.B0 = "";
        t93Var.E0 = "";
        t93Var.F0 = "";
        t93Var.G0 = "";
        t93Var.H0 = "";
        J0 = t93Var;
        K0 = new r93();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.B0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.B0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String J() {
        String str = this.y0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.y0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String K() {
        String str = this.G0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.G0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String L() {
        String str = this.F0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.F0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String N() {
        String str = this.E0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.E0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String O() {
        String str = this.z0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.z0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String P() {
        String str = this.H0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.H0 = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final s93 u() {
        if (this == J0) {
            return new s93();
        }
        s93 s93Var = new s93();
        s93Var.V(this);
        return s93Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return J0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.I0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.I0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        int i = this.X;
        if (i != 0) {
            q60Var.s(1, i);
        }
        int i2 = this.Y;
        if (i2 != 0) {
            q60Var.s(2, i2);
        }
        int i3 = this.Z;
        if (i3 != 0) {
            q60Var.s(3, i3);
        }
        if (!yn1.C(this.y0)) {
            yn1.G(q60Var, 4, this.y0);
        }
        if (!yn1.C(this.z0)) {
            yn1.G(q60Var, 5, this.z0);
        }
        int i4 = this.A0;
        if (i4 != 0) {
            q60Var.s(6, i4);
        }
        if (!yn1.C(this.B0)) {
            yn1.G(q60Var, 7, this.B0);
        }
        int i5 = this.C0;
        if (i5 != 0) {
            q60Var.s(8, i5);
        }
        int i6 = this.D0;
        if (i6 != 0) {
            q60Var.s(9, i6);
        }
        if (!yn1.C(this.E0)) {
            yn1.G(q60Var, 10, this.E0);
        }
        if (!yn1.C(this.F0)) {
            yn1.G(q60Var, 11, this.F0);
        }
        if (!yn1.C(this.G0)) {
            yn1.G(q60Var, 12, this.G0);
        }
        if (!yn1.C(this.H0)) {
            yn1.G(q60Var, 13, this.H0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t93)) {
            return super.equals(obj);
        }
        t93 t93Var = (t93) obj;
        return this.X == t93Var.X && this.Y == t93Var.Y && this.Z == t93Var.Z && J().equals(t93Var.J()) && O().equals(t93Var.O()) && this.A0 == t93Var.A0 && H().equals(t93Var.H()) && this.C0 == t93Var.C0 && this.D0 == t93Var.D0 && N().equals(t93Var.N()) && L().equals(t93Var.L()) && K().equals(t93Var.K()) && P().equals(t93Var.P()) && this.z.equals(t93Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int i2 = this.X;
        int iE = i2 != 0 ? q60.e(1, i2) : 0;
        int i3 = this.Y;
        if (i3 != 0) {
            iE += q60.e(2, i3);
        }
        int i4 = this.Z;
        if (i4 != 0) {
            iE += q60.e(3, i4);
        }
        if (!yn1.C(this.y0)) {
            iE += yn1.v(4, this.y0);
        }
        if (!yn1.C(this.z0)) {
            iE += yn1.v(5, this.z0);
        }
        int i5 = this.A0;
        if (i5 != 0) {
            iE += q60.e(6, i5);
        }
        if (!yn1.C(this.B0)) {
            iE += yn1.v(7, this.B0);
        }
        int i6 = this.C0;
        if (i6 != 0) {
            iE += q60.e(8, i6);
        }
        int i7 = this.D0;
        if (i7 != 0) {
            iE += q60.e(9, i7);
        }
        if (!yn1.C(this.E0)) {
            iE += yn1.v(10, this.E0);
        }
        if (!yn1.C(this.F0)) {
            iE += yn1.v(11, this.F0);
        }
        if (!yn1.C(this.G0)) {
            iE += yn1.v(12, this.G0);
        }
        if (!yn1.C(this.H0)) {
            iE += yn1.v(13, this.H0);
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
        int iHashCode = this.z.hashCode() + ((P().hashCode() + ((((K().hashCode() + ((((L().hashCode() + ((((N().hashCode() + ha0.i(ha0.i((((H().hashCode() + ha0.i((((O().hashCode() + ((((J().hashCode() + ha0.i(ha0.i(ha0.i(fw.q(u93.E0, 779, 37, 1, 53), this.X, 37, 2, 53), this.Y, 37, 3, 53), this.Z, 37, 4, 53)) * 37) + 5) * 53)) * 37) + 6) * 53, this.A0, 37, 7, 53)) * 37) + 8) * 53, this.C0, 37, 9, 53), this.D0, 37, 10, 53)) * 37) + 11) * 53)) * 37) + 12) * 53)) * 37) + 13) * 53)) * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return J0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return K0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return J0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        s93 s93Var = new s93(ue1Var);
        s93Var.z0 = "";
        s93Var.A0 = "";
        s93Var.C0 = "";
        s93Var.F0 = "";
        s93Var.G0 = "";
        s93Var.H0 = "";
        s93Var.I0 = "";
        return s93Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = u93.F0;
        vn1Var.a(t93.class, s93.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return J0;
    }
}
