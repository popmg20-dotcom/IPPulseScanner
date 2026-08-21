package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l20 extends yn1 {
    public static final j20 A0;
    public static final l20 z0;
    public int X;
    public Object Y;
    public volatile String Z;
    public byte y0;

    static {
        ao3.a(4, "Cause");
        l20 l20Var = new l20();
        l20Var.X = 0;
        l20Var.Z = "";
        l20Var.y0 = (byte) -1;
        l20Var.Z = "";
        z0 = l20Var;
        A0 = new j20();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.Z;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.Z = strI;
        return strI;
    }

    public final ck2 J() {
        return this.X == 2 ? (ck2) this.Y : ck2.A0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final k20 u() {
        if (this == z0) {
            return new k20();
        }
        k20 k20Var = new k20();
        k20Var.W(this);
        return k20Var;
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
        if (!yn1.C(this.Z)) {
            yn1.G(q60Var, 1, this.Z);
        }
        if (this.X == 2) {
            q60Var.u(2, (ck2) this.Y);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof l20)) {
                return super.equals(obj);
            }
            l20 l20Var = (l20) obj;
            if (H().equals(l20Var.H())) {
                int i = this.X;
                int i2 = i != 0 ? i != 2 ? 0 : 1 : 2;
                int i3 = l20Var.X;
                if (fw.e(i2, i3 != 0 ? i3 != 2 ? 0 : 1 : 2) && ((this.X != 2 || J().equals(l20Var.J())) && this.z.equals(l20Var.z))) {
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
        if (this.X == 2) {
            iV += q60.f(2, (ck2) this.Y);
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
        int iHashCode = H().hashCode() + fw.q(bf4.Q0, 779, 37, 1, 53);
        if (this.X == 2) {
            iHashCode = J().hashCode() + fw.p(iHashCode, 37, 2, 53);
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
        k20 k20Var = new k20(ue1Var);
        k20Var.X = 0;
        k20Var.y0 = "";
        return k20Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.R0;
        vn1Var.a(l20.class, k20.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return z0;
    }
}
