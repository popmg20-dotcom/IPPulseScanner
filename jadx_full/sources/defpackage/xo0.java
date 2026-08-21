package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xo0 extends yn1 {
    public static final vo0 A0;
    public static final xo0 z0;
    public int X;
    public int Y;
    public int Z;
    public byte y0;

    static {
        ao3.a(5, "ReservedRange");
        xo0 xo0Var = new xo0();
        xo0Var.Y = 0;
        xo0Var.Z = 0;
        xo0Var.y0 = (byte) -1;
        z0 = xo0Var;
        A0 = new vo0();
    }

    public final boolean H() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final wo0 u() {
        if (this == z0) {
            return new wo0();
        }
        wo0 wo0Var = new wo0();
        wo0Var.V(this);
        return wo0Var;
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
            if (!(obj instanceof xo0)) {
                return super.equals(obj);
            }
            xo0 xo0Var = (xo0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((xo0Var.X & 1) != 0) || (((i & 1) != 0 && this.Y != xo0Var.Y) || H() != xo0Var.H() || ((H() && this.Z != xo0Var.Z) || !this.z.equals(xo0Var.z)))) {
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
        int iHashCode = vs0.G0.hashCode() + 779;
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
        return new wo0(ue1Var);
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.H0;
        vn1Var.a(xo0.class, wo0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return z0;
    }
}
