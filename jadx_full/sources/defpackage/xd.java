package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xd extends yn1 {
    public static final xd Z;
    public static final vd y0;
    public zt X;
    public byte Y;

    static {
        ao3.a(4, "ArmMTEMetadata");
        xd xdVar = new xd();
        zt ztVar = zt.z;
        xdVar.Y = (byte) -1;
        xdVar.X = ztVar;
        Z = xdVar;
        y0 = new vd();
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final wd u() {
        if (this == Z) {
            return new wd();
        }
        wd wdVar = new wd();
        wdVar.V(this);
        return wdVar;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return Z;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.Y;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.Y = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if (!this.X.isEmpty()) {
            q60Var.o(1, this.X);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xd)) {
            return super.equals(obj);
        }
        xd xdVar = (xd) obj;
        return this.X.equals(xdVar.X) && this.z.equals(xdVar.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iH = this.z.h() + (!this.X.isEmpty() ? q60.c(1, this.X) : 0);
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.z.hashCode() + ((this.X.hashCode() + fw.q(bf4.Y0, 779, 37, 1, 53)) * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return Z.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return y0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return Z.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        wd wdVar = new wd(ue1Var);
        wdVar.Y = zt.z;
        return wdVar;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.Z0;
        vn1Var.a(xd.class, wd.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return Z;
    }
}
