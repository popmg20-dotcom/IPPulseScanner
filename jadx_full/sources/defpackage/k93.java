package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k93 extends yn1 {
    public static final k93 D0;
    public static final i93 E0;
    public volatile String A0;
    public int B0;
    public byte C0;
    public int X;
    public zt Y;
    public int Z;
    public volatile String y0;
    public int z0;

    static {
        ao3.a(4, "DnsQueryInfo");
        k93 k93Var = new k93();
        k93Var.X = 0;
        zt ztVar = zt.z;
        k93Var.Y = ztVar;
        k93Var.Z = 0;
        k93Var.y0 = "";
        k93Var.z0 = 0;
        k93Var.A0 = "";
        k93Var.B0 = 0;
        k93Var.C0 = (byte) -1;
        k93Var.Y = ztVar;
        k93Var.y0 = "";
        k93Var.A0 = "";
        D0 = k93Var;
        E0 = new i93();
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
    public final j93 u() {
        if (this == D0) {
            return new j93();
        }
        j93 j93Var = new j93();
        j93Var.V(this);
        return j93Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return D0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.C0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.C0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        int i = this.X;
        if (i != 0) {
            q60Var.s(1, i);
        }
        if (!this.Y.isEmpty()) {
            q60Var.o(2, this.Y);
        }
        int i2 = this.Z;
        if (i2 != 0) {
            q60Var.s(3, i2);
        }
        if (!yn1.C(this.y0)) {
            yn1.G(q60Var, 4, this.y0);
        }
        int i3 = this.z0;
        if (i3 != 0) {
            q60Var.s(5, i3);
        }
        if (!yn1.C(this.A0)) {
            yn1.G(q60Var, 6, this.A0);
        }
        int i4 = this.B0;
        if (i4 != 0) {
            q60Var.s(7, i4);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k93)) {
            return super.equals(obj);
        }
        k93 k93Var = (k93) obj;
        return this.X == k93Var.X && this.Y.equals(k93Var.Y) && this.Z == k93Var.Z && J().equals(k93Var.J()) && this.z0 == k93Var.z0 && H().equals(k93Var.H()) && this.B0 == k93Var.B0 && this.z.equals(k93Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int i2 = this.X;
        int iE = i2 != 0 ? q60.e(1, i2) : 0;
        if (!this.Y.isEmpty()) {
            iE += q60.c(2, this.Y);
        }
        int i3 = this.Z;
        if (i3 != 0) {
            iE += q60.e(3, i3);
        }
        if (!yn1.C(this.y0)) {
            iE += yn1.v(4, this.y0);
        }
        int i4 = this.z0;
        if (i4 != 0) {
            iE += q60.e(5, i4);
        }
        if (!yn1.C(this.A0)) {
            iE += yn1.v(6, this.A0);
        }
        int i5 = this.B0;
        if (i5 != 0) {
            iE += q60.e(7, i5);
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
        int iHashCode = this.z.hashCode() + ((((((H().hashCode() + ha0.i((((J().hashCode() + ha0.i((((this.Y.hashCode() + ha0.i(fw.q(u93.A0, 779, 37, 1, 53), this.X, 37, 2, 53)) * 37) + 3) * 53, this.Z, 37, 4, 53)) * 37) + 5) * 53, this.z0, 37, 6, 53)) * 37) + 7) * 53) + this.B0) * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return D0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return E0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return D0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        j93 j93Var = new j93(ue1Var);
        j93Var.Z = zt.z;
        j93Var.z0 = "";
        j93Var.B0 = "";
        return j93Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = u93.B0;
        vn1Var.a(k93.class, j93.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return D0;
    }
}
