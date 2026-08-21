package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g32 extends yn1 {
    public static final g32 C0;
    public static final c32 D0;
    public int A0;
    public byte B0;
    public int X;
    public boolean Y;
    public int Z;
    public boolean y0;
    public boolean z0;

    static {
        ao3.a(5, "JavaFeatures");
        g32 g32Var = new g32();
        g32Var.Y = false;
        g32Var.y0 = false;
        g32Var.z0 = false;
        g32Var.B0 = (byte) -1;
        g32Var.Z = 0;
        g32Var.A0 = 0;
        C0 = g32Var;
        D0 = new c32();
    }

    public final boolean H() {
        return (this.X & 4) != 0;
    }

    public final boolean J() {
        return (this.X & 16) != 0;
    }

    public final boolean K() {
        return (this.X & 8) != 0;
    }

    public final boolean L() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final d32 u() {
        if (this == C0) {
            return new d32();
        }
        d32 d32Var = new d32();
        d32Var.V(this);
        return d32Var;
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
        if ((this.X & 1) != 0) {
            q60Var.n(1, this.Y);
        }
        if ((this.X & 2) != 0) {
            q60Var.s(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            q60Var.n(3, this.y0);
        }
        if ((this.X & 8) != 0) {
            q60Var.n(4, this.z0);
        }
        if ((this.X & 16) != 0) {
            q60Var.s(5, this.A0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof g32)) {
                return super.equals(obj);
            }
            g32 g32Var = (g32) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((g32Var.X & 1) != 0) || (((i & 1) != 0 && this.Y != g32Var.Y) || L() != g32Var.L() || ((L() && this.Z != g32Var.Z) || H() != g32Var.H() || ((H() && this.y0 != g32Var.y0) || K() != g32Var.K() || ((K() && this.z0 != g32Var.z0) || J() != g32Var.J() || ((J() && this.A0 != g32Var.A0) || !this.z.equals(g32Var.z))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iB = (this.X & 1) != 0 ? q60.b(1) : 0;
        if ((this.X & 2) != 0) {
            iB += q60.d(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            iB += q60.b(3);
        }
        if ((this.X & 8) != 0) {
            iB += q60.b(4);
        }
        if ((this.X & 16) != 0) {
            iB += q60.d(5, this.A0);
        }
        int iH = this.z.h() + iB;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = h32.B0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + i12.a(this.Y);
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Z;
        }
        if (H()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + i12.a(this.y0);
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + i12.a(this.z0);
        }
        if (J()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + this.A0;
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
        d32 d32Var = new d32(ue1Var);
        d32Var.Z = 0;
        d32Var.A0 = 0;
        return d32Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = h32.C0;
        vn1Var.a(g32.class, d32.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return C0;
    }
}
