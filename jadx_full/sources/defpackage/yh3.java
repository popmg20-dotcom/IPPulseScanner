package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yh3 extends yn1 {
    public static final yh3 y0;
    public static final wh3 z0;
    public volatile String X;
    public long Y;
    public byte Z;

    static {
        ao3.a(4, "Register");
        yh3 yh3Var = new yh3();
        yh3Var.X = "";
        yh3Var.Y = 0L;
        yh3Var.Z = (byte) -1;
        yh3Var.X = "";
        y0 = yh3Var;
        z0 = new wh3();
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
    public final xh3 u() {
        if (this == y0) {
            return new xh3();
        }
        xh3 xh3Var = new xh3();
        xh3Var.V(this);
        return xh3Var;
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
        long j = this.Y;
        if (j != 0) {
            q60Var.A(2, j);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yh3)) {
            return super.equals(obj);
        }
        yh3 yh3Var = (yh3) obj;
        return H().equals(yh3Var.H()) && this.Y == yh3Var.Y && this.z.equals(yh3Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iV = !yn1.C(this.X) ? yn1.v(1, this.X) : 0;
        long j = this.Y;
        if (j != 0) {
            iV += q60.k(2, j);
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
        int iHashCode = this.z.hashCode() + ((i12.b(this.Y) + ((((H().hashCode() + fw.q(bf4.S0, 779, 37, 1, 53)) * 37) + 2) * 53)) * 29);
        this.b = iHashCode;
        return iHashCode;
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
        xh3 xh3Var = new xh3(ue1Var);
        xh3Var.Y = "";
        return xh3Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.T0;
        vn1Var.a(yh3.class, xh3.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return y0;
    }
}
