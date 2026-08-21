package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ep0 extends yn1 {
    public static final cp0 A0;
    public static final ep0 z0;
    public int X;
    public int Y;
    public int Z;
    public byte y0;

    static {
        ao3.a(5, "EnumReservedRange");
        ep0 ep0Var = new ep0();
        ep0Var.Y = 0;
        ep0Var.Z = 0;
        ep0Var.y0 = (byte) -1;
        z0 = ep0Var;
        A0 = new cp0();
    }

    public final boolean H() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final dp0 u() {
        if (this == z0) {
            return new dp0();
        }
        dp0 dp0Var = new dp0();
        dp0Var.V(this);
        return dp0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return z0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.y0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.y0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            q60Var.s(1, this.Y);
        }
        if ((this.X & 2) != 0) {
            q60Var.s(2, this.Z);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ep0)) {
                return super.equals(obj);
            }
            ep0 ep0Var = (ep0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((ep0Var.X & 1) != 0) || (((i & 1) != 0 && this.Y != ep0Var.Y) || H() != ep0Var.H() || ((H() && this.Z != ep0Var.Z) || !this.z.equals(ep0Var.z)))) {
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
        int iE = (this.X & 1) != 0 ? q60.e(1, this.Y) : 0;
        if ((this.X & 2) != 0) {
            iE += q60.e(2, this.Z);
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
        int iHashCode = vs0.S0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + this.Y;
        }
        if (H()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Z;
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return z0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return A0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return z0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        return new dp0(ue1Var);
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.T0;
        vn1Var.a(ep0.class, dp0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return z0;
    }
}
