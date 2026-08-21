package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uo0 extends yn1 {
    public static final uo0 A0;
    public static final so0 B0;
    public int X;
    public int Y;
    public int Z;
    public vp0 y0;
    public byte z0;

    static {
        ao3.a(5, "ExtensionRange");
        uo0 uo0Var = new uo0();
        uo0Var.Y = 0;
        uo0Var.Z = 0;
        uo0Var.z0 = (byte) -1;
        A0 = uo0Var;
        B0 = new so0();
    }

    public final vp0 H() {
        vp0 vp0Var = this.y0;
        return vp0Var == null ? vp0.C0 : vp0Var;
    }

    public final boolean J() {
        return (this.X & 2) != 0;
    }

    public final boolean K() {
        return (this.X & 4) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final to0 u() {
        if (this == A0) {
            return new to0();
        }
        to0 to0Var = new to0();
        to0Var.V(this);
        return to0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return A0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.z0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!K() || H().c()) {
            this.z0 = (byte) 1;
            return true;
        }
        this.z0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            q60Var.s(1, this.Y);
        }
        if ((this.X & 2) != 0) {
            q60Var.s(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            q60Var.u(3, H());
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof uo0)) {
                return super.equals(obj);
            }
            uo0 uo0Var = (uo0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((uo0Var.X & 1) != 0) || (((i & 1) != 0 && this.Y != uo0Var.Y) || J() != uo0Var.J() || ((J() && this.Z != uo0Var.Z) || K() != uo0Var.K() || ((K() && !H().equals(uo0Var.H())) || !this.z.equals(uo0Var.z))))) {
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
        if ((this.X & 4) != 0) {
            iE += q60.f(3, H());
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
        int iHashCode = vs0.E0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + this.Y;
        }
        if (J()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Z;
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + H().hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return A0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return B0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return A0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        return new to0(ue1Var);
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.F0;
        vn1Var.a(uo0.class, to0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
