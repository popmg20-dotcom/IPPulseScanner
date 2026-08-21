package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q93 extends yn1 {
    public static final q93 B0;
    public static final o93 C0;
    public byte A0;
    public int X;
    public int Y;
    public volatile String Z;
    public volatile String y0;
    public int z0;

    static {
        ao3.a(4, "ProxyStrategy");
        q93 q93Var = new q93();
        q93Var.X = 0;
        q93Var.Y = 0;
        q93Var.Z = "";
        q93Var.y0 = "";
        q93Var.z0 = 0;
        q93Var.A0 = (byte) -1;
        q93Var.Z = "";
        q93Var.y0 = "";
        B0 = q93Var;
        C0 = new o93();
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
        String str = this.y0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.y0 = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final p93 u() {
        if (this == B0) {
            return new p93();
        }
        p93 p93Var = new p93();
        p93Var.V(this);
        return p93Var;
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
        int i = this.X;
        if (i != 0) {
            q60Var.s(1, i);
        }
        int i2 = this.Y;
        if (i2 != 0) {
            q60Var.s(2, i2);
        }
        if (!yn1.C(this.Z)) {
            yn1.G(q60Var, 3, this.Z);
        }
        if (!yn1.C(this.y0)) {
            yn1.G(q60Var, 4, this.y0);
        }
        int i3 = this.z0;
        if (i3 != 0) {
            q60Var.s(5, i3);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q93)) {
            return super.equals(obj);
        }
        q93 q93Var = (q93) obj;
        return this.X == q93Var.X && this.Y == q93Var.Y && H().equals(q93Var.H()) && J().equals(q93Var.J()) && this.z0 == q93Var.z0 && this.z.equals(q93Var.z);
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
        if (!yn1.C(this.Z)) {
            iE += yn1.v(3, this.Z);
        }
        if (!yn1.C(this.y0)) {
            iE += yn1.v(4, this.y0);
        }
        int i4 = this.z0;
        if (i4 != 0) {
            iE += q60.e(5, i4);
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
        int iHashCode = this.z.hashCode() + ((((((J().hashCode() + ((((H().hashCode() + ha0.i(ha0.i(fw.q(u93.G0, 779, 37, 1, 53), this.X, 37, 2, 53), this.Y, 37, 3, 53)) * 37) + 4) * 53)) * 37) + 5) * 53) + this.z0) * 29);
        this.b = iHashCode;
        return iHashCode;
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
        p93 p93Var = new p93(ue1Var);
        p93Var.y0 = "";
        p93Var.z0 = "";
        return p93Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = u93.H0;
        vn1Var.a(q93.class, p93.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return B0;
    }
}
