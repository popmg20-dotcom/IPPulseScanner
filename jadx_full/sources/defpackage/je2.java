package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class je2 extends yn1 {
    public static final je2 C0;
    public static final he2 D0;
    public volatile String A0;
    public byte B0;
    public volatile String X;
    public int Y;
    public int Z;
    public int y0;
    public volatile String z0;

    static {
        ao3.a(4, "LogMessage");
        je2 je2Var = new je2();
        je2Var.X = "";
        je2Var.Y = 0;
        je2Var.Z = 0;
        je2Var.y0 = 0;
        je2Var.z0 = "";
        je2Var.A0 = "";
        je2Var.B0 = (byte) -1;
        je2Var.X = "";
        je2Var.z0 = "";
        je2Var.A0 = "";
        C0 = je2Var;
        D0 = new he2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.A0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.A0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String J() {
        String str = this.z0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.z0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String K() {
        String str = this.X;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.X = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final ie2 u() {
        if (this == C0) {
            return new ie2();
        }
        ie2 ie2Var = new ie2();
        ie2Var.V(this);
        return ie2Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return C0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.B0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.B0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if (!yn1.C(this.X)) {
            yn1.G(q60Var, 1, this.X);
        }
        int i = this.Y;
        if (i != 0) {
            q60Var.y(2, i);
        }
        int i2 = this.Z;
        if (i2 != 0) {
            q60Var.y(3, i2);
        }
        int i3 = this.y0;
        if (i3 != 0) {
            q60Var.y(4, i3);
        }
        if (!yn1.C(this.z0)) {
            yn1.G(q60Var, 5, this.z0);
        }
        if (!yn1.C(this.A0)) {
            yn1.G(q60Var, 6, this.A0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof je2)) {
            return super.equals(obj);
        }
        je2 je2Var = (je2) obj;
        return K().equals(je2Var.K()) && this.Y == je2Var.Y && this.Z == je2Var.Z && this.y0 == je2Var.y0 && J().equals(je2Var.J()) && H().equals(je2Var.H()) && this.z.equals(je2Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iV = !yn1.C(this.X) ? yn1.v(1, this.X) : 0;
        int i2 = this.Y;
        if (i2 != 0) {
            iV += q60.i(2, i2);
        }
        int i3 = this.Z;
        if (i3 != 0) {
            iV += q60.i(3, i3);
        }
        int i4 = this.y0;
        if (i4 != 0) {
            iV += q60.i(4, i4);
        }
        if (!yn1.C(this.z0)) {
            iV += yn1.v(5, this.z0);
        }
        if (!yn1.C(this.A0)) {
            iV += yn1.v(6, this.A0);
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
        int iHashCode = this.z.hashCode() + ((H().hashCode() + ((((J().hashCode() + ha0.i(ha0.i(ha0.i((((K().hashCode() + fw.q(bf4.i1, 779, 37, 1, 53)) * 37) + 2) * 53, this.Y, 37, 3, 53), this.Z, 37, 4, 53), this.y0, 37, 5, 53)) * 37) + 6) * 53)) * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return C0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return D0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return C0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        ie2 ie2Var = new ie2(ue1Var);
        ie2Var.Y = "";
        ie2Var.A0 = "";
        ie2Var.B0 = "";
        return ie2Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.j1;
        vn1Var.a(je2.class, ie2.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return C0;
    }
}
