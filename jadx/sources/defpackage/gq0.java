package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gq0 extends nn1 {
    public static final gq0 G0;
    public static final wp0 H0;
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public byte F0;
    public int Y;
    public int Z;
    public int y0;
    public int z0;

    static {
        ao3.a(5, "FeatureSet");
        gq0 gq0Var = new gq0();
        gq0Var.F0 = (byte) -1;
        gq0Var.Z = 0;
        gq0Var.y0 = 0;
        gq0Var.z0 = 0;
        gq0Var.A0 = 0;
        gq0Var.B0 = 0;
        gq0Var.C0 = 0;
        gq0Var.D0 = 0;
        gq0Var.E0 = 0;
        G0 = gq0Var;
        H0 = new wp0();
    }

    public final boolean K() {
        return (this.Y & 128) != 0;
    }

    public final boolean L() {
        return (this.Y & 64) != 0;
    }

    public final boolean N() {
        return (this.Y & 2) != 0;
    }

    public final boolean O() {
        return (this.Y & 32) != 0;
    }

    public final boolean P() {
        return (this.Y & 16) != 0;
    }

    public final boolean Q() {
        return (this.Y & 4) != 0;
    }

    public final boolean R() {
        return (this.Y & 8) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final xp0 u() {
        if (this == G0) {
            return new xp0();
        }
        xp0 xp0Var = new xp0();
        xp0Var.b0(this);
        return xp0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return G0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.F0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (this.X.j()) {
            this.F0 = (byte) 1;
            return true;
        }
        this.F0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        mn1 mn1VarJ = J();
        if ((this.Y & 1) != 0) {
            q60Var.s(1, this.Z);
        }
        if ((this.Y & 2) != 0) {
            q60Var.s(2, this.y0);
        }
        if ((this.Y & 4) != 0) {
            q60Var.s(3, this.z0);
        }
        if ((this.Y & 8) != 0) {
            q60Var.s(4, this.A0);
        }
        if ((this.Y & 16) != 0) {
            q60Var.s(5, this.B0);
        }
        if ((this.Y & 32) != 0) {
            q60Var.s(6, this.C0);
        }
        if ((this.Y & 64) != 0) {
            q60Var.s(7, this.D0);
        }
        if ((this.Y & 128) != 0) {
            q60Var.s(8, this.E0);
        }
        mn1VarJ.k(10001, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof gq0)) {
                return super.equals(obj);
            }
            gq0 gq0Var = (gq0) obj;
            int i = this.Y;
            if (((i & 1) != 0) != ((gq0Var.Y & 1) != 0) || (((i & 1) != 0 && this.Z != gq0Var.Z) || N() != gq0Var.N() || ((N() && this.y0 != gq0Var.y0) || Q() != gq0Var.Q() || ((Q() && this.z0 != gq0Var.z0) || R() != gq0Var.R() || ((R() && this.A0 != gq0Var.A0) || P() != gq0Var.P() || ((P() && this.B0 != gq0Var.B0) || O() != gq0Var.O() || ((O() && this.C0 != gq0Var.C0) || L() != gq0Var.L() || ((L() && this.D0 != gq0Var.D0) || K() != gq0Var.K() || ((K() && this.E0 != gq0Var.E0) || !this.z.equals(gq0Var.z) || !this.X.f().equals(gq0Var.X.f())))))))))) {
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
        int iD = (this.Y & 1) != 0 ? q60.d(1, this.Z) : 0;
        if ((this.Y & 2) != 0) {
            iD += q60.d(2, this.y0);
        }
        if ((this.Y & 4) != 0) {
            iD += q60.d(3, this.z0);
        }
        if ((this.Y & 8) != 0) {
            iD += q60.d(4, this.A0);
        }
        if ((this.Y & 16) != 0) {
            iD += q60.d(5, this.B0);
        }
        if ((this.Y & 32) != 0) {
            iD += q60.d(6, this.C0);
        }
        if ((this.Y & 64) != 0) {
            iD += q60.d(7, this.D0);
        }
        if ((this.Y & 128) != 0) {
            iD += q60.d(8, this.E0);
        }
        int iH = this.z.h() + this.X.h() + iD;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = vs0.y1.hashCode() + 779;
        if ((this.Y & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + this.Z;
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.y0;
        }
        if (Q()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + this.z0;
        }
        if (R()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + this.A0;
        }
        if (P()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + this.B0;
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + this.C0;
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 7, 53) + this.D0;
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 8, 53) + this.E0;
        }
        int iHashCode2 = this.z.hashCode() + (c1.q(iHashCode, this.X.f()) * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return G0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return H0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return G0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        xp0 xp0Var = new xp0(ue1Var);
        xp0Var.Z = 0;
        xp0Var.y0 = 0;
        xp0Var.z0 = 0;
        xp0Var.A0 = 0;
        xp0Var.B0 = 0;
        xp0Var.C0 = 0;
        xp0Var.D0 = 0;
        xp0Var.E0 = 0;
        return xp0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.z1;
        vn1Var.a(gq0.class, xp0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return G0;
    }
}
