package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yf0 extends yn1 {
    public static final yf0 y0;
    public static final wf0 z0;
    public zt X;
    public zt Y;
    public byte Z;

    static {
        ao3.a(4, "CrashDetail");
        yf0 yf0Var = new yf0();
        zt ztVar = zt.z;
        yf0Var.Z = (byte) -1;
        yf0Var.X = ztVar;
        yf0Var.Y = ztVar;
        y0 = yf0Var;
        z0 = new wf0();
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final xf0 u() {
        if (this == y0) {
            return new xf0();
        }
        xf0 xf0Var = new xf0();
        xf0Var.V(this);
        return xf0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return y0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.Z;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.Z = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if (!this.X.isEmpty()) {
            q60Var.o(1, this.X);
        }
        if (!this.Y.isEmpty()) {
            q60Var.o(2, this.Y);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yf0)) {
            return super.equals(obj);
        }
        yf0 yf0Var = (yf0) obj;
        return this.X.equals(yf0Var.X) && this.Y.equals(yf0Var.Y) && this.z.equals(yf0Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iC = !this.X.isEmpty() ? q60.c(1, this.X) : 0;
        if (!this.Y.isEmpty()) {
            iC += q60.c(2, this.Y);
        }
        int iH = this.z.h() + iC;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.z.hashCode() + ((this.Y.hashCode() + ((((this.X.hashCode() + fw.q(bf4.A0, 779, 37, 1, 53)) * 37) + 2) * 53)) * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return y0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return z0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return y0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        xf0 xf0Var = new xf0(ue1Var);
        zt ztVar = zt.z;
        xf0Var.Y = ztVar;
        xf0Var.Z = ztVar;
        return xf0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.B0;
        vn1Var.a(yf0.class, xf0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return y0;
    }
}
