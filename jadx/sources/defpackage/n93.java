package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n93 extends yn1 {
    public static final n93 C0;
    public static final l93 D0;
    public int A0;
    public byte B0;
    public int X;
    public zt Y;
    public zt Z;
    public volatile String y0;
    public int z0;

    static {
        ao3.a(4, "DnsQueryStrategy");
        n93 n93Var = new n93();
        n93Var.X = 0;
        zt ztVar = zt.z;
        n93Var.Y = ztVar;
        n93Var.Z = ztVar;
        n93Var.y0 = "";
        n93Var.z0 = 0;
        n93Var.A0 = 0;
        n93Var.B0 = (byte) -1;
        n93Var.Y = ztVar;
        n93Var.Z = ztVar;
        n93Var.y0 = "";
        C0 = n93Var;
        D0 = new l93();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.y0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.y0 = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final m93 u() {
        if (this == C0) {
            return new m93();
        }
        m93 m93Var = new m93();
        m93Var.W(this);
        return m93Var;
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
        int i = this.X;
        if (i != 0) {
            q60Var.s(1, i);
        }
        if (!this.Y.isEmpty()) {
            q60Var.o(2, this.Y);
        }
        if (!this.Z.isEmpty()) {
            q60Var.o(3, this.Z);
        }
        if (!yn1.C(this.y0)) {
            yn1.G(q60Var, 4, this.y0);
        }
        int i2 = this.z0;
        if (i2 != 0) {
            q60Var.s(5, i2);
        }
        int i3 = this.A0;
        if (i3 != 0) {
            q60Var.s(6, i3);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n93)) {
            return super.equals(obj);
        }
        n93 n93Var = (n93) obj;
        return this.X == n93Var.X && this.Y.equals(n93Var.Y) && this.Z.equals(n93Var.Z) && H().equals(n93Var.H()) && this.z0 == n93Var.z0 && this.A0 == n93Var.A0 && this.z.equals(n93Var.z);
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
        if (!this.Z.isEmpty()) {
            iE += q60.c(3, this.Z);
        }
        if (!yn1.C(this.y0)) {
            iE += yn1.v(4, this.y0);
        }
        int i3 = this.z0;
        if (i3 != 0) {
            iE += q60.e(5, i3);
        }
        int i4 = this.A0;
        if (i4 != 0) {
            iE += q60.e(6, i4);
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
        int iHashCode = this.z.hashCode() + ((ha0.i((((H().hashCode() + ((((this.Z.hashCode() + ((((this.Y.hashCode() + ha0.i(fw.q(u93.C0, 779, 37, 1, 53), this.X, 37, 2, 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53, this.z0, 37, 6, 53) + this.A0) * 29);
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
        m93 m93Var = new m93(ue1Var);
        zt ztVar = zt.z;
        m93Var.Z = ztVar;
        m93Var.y0 = ztVar;
        m93Var.z0 = "";
        return m93Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = u93.D0;
        vn1Var.a(n93.class, m93.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return C0;
    }
}
