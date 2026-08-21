package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ck2 extends yn1 {
    public static final ck2 A0;
    public static final yj2 B0;
    public int X;
    public Object Y;
    public int Z;
    public int y0;
    public byte z0;

    static {
        ao3.a(4, "MemoryError");
        ck2 ck2Var = new ck2();
        ck2Var.X = 0;
        ck2Var.z0 = (byte) -1;
        ck2Var.Z = 0;
        ck2Var.y0 = 0;
        A0 = ck2Var;
        B0 = new yj2();
    }

    public final or1 H() {
        return this.X == 3 ? (or1) this.Y : or1.C0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final zj2 u() {
        if (this == A0) {
            return new zj2();
        }
        zj2 zj2Var = new zj2();
        zj2Var.W(this);
        return zj2Var;
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
        this.z0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if (this.Z != ak2.GWP_ASAN.a()) {
            q60Var.s(1, this.Z);
        }
        if (this.y0 != bk2.UNKNOWN.a()) {
            q60Var.s(2, this.y0);
        }
        if (this.X == 3) {
            q60Var.u(3, (or1) this.Y);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ck2)) {
                return super.equals(obj);
            }
            ck2 ck2Var = (ck2) obj;
            if (this.Z == ck2Var.Z && this.y0 == ck2Var.y0) {
                int i = this.X;
                int i2 = i != 0 ? i != 3 ? 0 : 1 : 2;
                int i3 = ck2Var.X;
                if (fw.e(i2, i3 != 0 ? i3 != 3 ? 0 : 1 : 2) && ((this.X != 3 || H().equals(ck2Var.H())) && this.z.equals(ck2Var.z))) {
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
        int iD = this.Z != ak2.GWP_ASAN.a() ? q60.d(1, this.Z) : 0;
        if (this.y0 != bk2.UNKNOWN.a()) {
            iD += q60.d(2, this.y0);
        }
        if (this.X == 3) {
            iD += q60.f(3, (or1) this.Y);
        }
        int iH = this.z.h() + iD;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int i2 = ha0.i(fw.q(bf4.O0, 779, 37, 1, 53), this.Z, 37, 2, 53) + this.y0;
        if (this.X == 3) {
            i2 = fw.p(i2, 37, 3, 53) + H().hashCode();
        }
        int iHashCode = this.z.hashCode() + (i2 * 29);
        this.b = iHashCode;
        return iHashCode;
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
        zj2 zj2Var = new zj2(ue1Var);
        zj2Var.X = 0;
        zj2Var.y0 = 0;
        zj2Var.z0 = 0;
        return zj2Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.P0;
        vn1Var.a(ck2.class, zj2.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
