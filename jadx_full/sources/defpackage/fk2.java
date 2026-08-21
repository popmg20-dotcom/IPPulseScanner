package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fk2 extends yn1 {
    public static final fk2 F0;
    public static final dk2 G0;
    public boolean A0;
    public volatile String B0;
    public volatile String C0;
    public long D0;
    public byte E0;
    public long X;
    public long Y;
    public long Z;
    public boolean y0;
    public boolean z0;

    static {
        ao3.a(4, "MemoryMapping");
        fk2 fk2Var = new fk2();
        fk2Var.X = 0L;
        fk2Var.Y = 0L;
        fk2Var.Z = 0L;
        fk2Var.y0 = false;
        fk2Var.z0 = false;
        fk2Var.A0 = false;
        fk2Var.B0 = "";
        fk2Var.C0 = "";
        fk2Var.D0 = 0L;
        fk2Var.E0 = (byte) -1;
        fk2Var.B0 = "";
        fk2Var.C0 = "";
        F0 = fk2Var;
        G0 = new dk2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.C0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.C0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String J() {
        String str = this.B0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.B0 = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final ek2 u() {
        if (this == F0) {
            return new ek2();
        }
        ek2 ek2Var = new ek2();
        ek2Var.V(this);
        return ek2Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return F0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.E0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.E0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        long j = this.X;
        if (j != 0) {
            q60Var.A(1, j);
        }
        long j2 = this.Y;
        if (j2 != 0) {
            q60Var.A(2, j2);
        }
        long j3 = this.Z;
        if (j3 != 0) {
            q60Var.A(3, j3);
        }
        boolean z = this.y0;
        if (z) {
            q60Var.n(4, z);
        }
        boolean z2 = this.z0;
        if (z2) {
            q60Var.n(5, z2);
        }
        boolean z3 = this.A0;
        if (z3) {
            q60Var.n(6, z3);
        }
        if (!yn1.C(this.B0)) {
            yn1.G(q60Var, 7, this.B0);
        }
        if (!yn1.C(this.C0)) {
            yn1.G(q60Var, 8, this.C0);
        }
        long j4 = this.D0;
        if (j4 != 0) {
            q60Var.A(9, j4);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fk2)) {
            return super.equals(obj);
        }
        fk2 fk2Var = (fk2) obj;
        return this.X == fk2Var.X && this.Y == fk2Var.Y && this.Z == fk2Var.Z && this.y0 == fk2Var.y0 && this.z0 == fk2Var.z0 && this.A0 == fk2Var.A0 && J().equals(fk2Var.J()) && H().equals(fk2Var.H()) && this.D0 == fk2Var.D0 && this.z.equals(fk2Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        long j = this.X;
        int iK = j != 0 ? q60.k(1, j) : 0;
        long j2 = this.Y;
        if (j2 != 0) {
            iK += q60.k(2, j2);
        }
        long j3 = this.Z;
        if (j3 != 0) {
            iK += q60.k(3, j3);
        }
        if (this.y0) {
            iK += q60.b(4);
        }
        if (this.z0) {
            iK += q60.b(5);
        }
        if (this.A0) {
            iK += q60.b(6);
        }
        if (!yn1.C(this.B0)) {
            iK += yn1.v(7, this.B0);
        }
        if (!yn1.C(this.C0)) {
            iK += yn1.v(8, this.C0);
        }
        long j4 = this.D0;
        if (j4 != 0) {
            iK += q60.k(9, j4);
        }
        int iH = this.z.h() + iK;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.z.hashCode() + ((i12.b(this.D0) + ((((H().hashCode() + ((((J().hashCode() + ((((i12.a(this.A0) + ((((i12.a(this.z0) + ((((i12.a(this.y0) + ((((i12.b(this.Z) + ((((i12.b(this.Y) + ((((i12.b(this.X) + fw.q(bf4.c1, 779, 37, 1, 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 37) + 6) * 53)) * 37) + 7) * 53)) * 37) + 8) * 53)) * 37) + 9) * 53)) * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return F0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return G0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return F0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        ek2 ek2Var = new ek2(ue1Var);
        ek2Var.C0 = "";
        ek2Var.D0 = "";
        return ek2Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.d1;
        vn1Var.a(fk2.class, ek2.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return F0;
    }
}
