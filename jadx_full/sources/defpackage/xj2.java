package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xj2 extends yn1 {
    public static final xj2 C0;
    public static final vj2 D0;
    public zt A0;
    public byte B0;
    public int X;
    public Object Y;
    public volatile String Z;
    public volatile String y0;
    public long z0;

    static {
        ao3.a(4, "MemoryDump");
        xj2 xj2Var = new xj2();
        xj2Var.X = 0;
        xj2Var.Z = "";
        xj2Var.y0 = "";
        xj2Var.z0 = 0L;
        zt ztVar = zt.z;
        xj2Var.A0 = ztVar;
        xj2Var.B0 = (byte) -1;
        xj2Var.Z = "";
        xj2Var.y0 = "";
        xj2Var.A0 = ztVar;
        C0 = xj2Var;
        D0 = new vj2();
    }

    public final xd H() {
        return this.X == 6 ? (xd) this.Y : xd.Z;
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
    public final wj2 u() {
        if (this == C0) {
            return new wj2();
        }
        wj2 wj2Var = new wj2();
        wj2Var.W(this);
        return wj2Var;
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
        if (!yn1.C(this.Z)) {
            yn1.G(q60Var, 1, this.Z);
        }
        if (!yn1.C(this.y0)) {
            yn1.G(q60Var, 2, this.y0);
        }
        long j = this.z0;
        if (j != 0) {
            q60Var.A(3, j);
        }
        if (!this.A0.isEmpty()) {
            q60Var.o(4, this.A0);
        }
        if (this.X == 6) {
            q60Var.u(6, (xd) this.Y);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof xj2)) {
                return super.equals(obj);
            }
            xj2 xj2Var = (xj2) obj;
            if (K().equals(xj2Var.K()) && J().equals(xj2Var.J()) && this.z0 == xj2Var.z0 && this.A0.equals(xj2Var.A0)) {
                int i = this.X;
                int i2 = i != 0 ? i != 6 ? 0 : 1 : 2;
                int i3 = xj2Var.X;
                if (fw.e(i2, i3 != 0 ? i3 != 6 ? 0 : 1 : 2) && ((this.X != 6 || H().equals(xj2Var.H())) && this.z.equals(xj2Var.z))) {
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
        int iV = !yn1.C(this.Z) ? yn1.v(1, this.Z) : 0;
        if (!yn1.C(this.y0)) {
            iV += yn1.v(2, this.y0);
        }
        long j = this.z0;
        if (j != 0) {
            iV += q60.k(3, j);
        }
        if (!this.A0.isEmpty()) {
            iV += q60.c(4, this.A0);
        }
        if (this.X == 6) {
            iV += q60.f(6, (xd) this.Y);
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
        int iHashCode = this.A0.hashCode() + ((((i12.b(this.z0) + ((((J().hashCode() + ((((K().hashCode() + fw.q(bf4.a1, 779, 37, 1, 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53);
        if (this.X == 6) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + H().hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
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
        wj2 wj2Var = new wj2(ue1Var);
        wj2Var.X = 0;
        wj2Var.y0 = "";
        wj2Var.z0 = "";
        wj2Var.B0 = zt.z;
        return wj2Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.b1;
        vn1Var.a(xj2.class, wj2.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return C0;
    }
}
