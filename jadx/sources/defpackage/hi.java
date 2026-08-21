package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hi extends yn1 {
    public static final hi E0;
    public static final fi F0;
    public volatile String A0;
    public long B0;
    public volatile String C0;
    public byte D0;
    public long X;
    public long Y;
    public long Z;
    public volatile String y0;
    public long z0;

    static {
        ao3.a(4, "BacktraceFrame");
        hi hiVar = new hi();
        hiVar.X = 0L;
        hiVar.Y = 0L;
        hiVar.Z = 0L;
        hiVar.y0 = "";
        hiVar.z0 = 0L;
        hiVar.A0 = "";
        hiVar.B0 = 0L;
        hiVar.C0 = "";
        hiVar.D0 = (byte) -1;
        hiVar.y0 = "";
        hiVar.A0 = "";
        hiVar.C0 = "";
        E0 = hiVar;
        F0 = new fi();
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
        String str = this.A0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.A0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String K() {
        String str = this.y0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.y0 = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final gi u() {
        if (this == E0) {
            return new gi();
        }
        gi giVar = new gi();
        giVar.V(this);
        return giVar;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return E0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.D0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.D0 = (byte) 1;
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
        if (!yn1.C(this.y0)) {
            yn1.G(q60Var, 4, this.y0);
        }
        long j4 = this.z0;
        if (j4 != 0) {
            q60Var.A(5, j4);
        }
        if (!yn1.C(this.A0)) {
            yn1.G(q60Var, 6, this.A0);
        }
        long j5 = this.B0;
        if (j5 != 0) {
            q60Var.A(7, j5);
        }
        if (!yn1.C(this.C0)) {
            yn1.G(q60Var, 8, this.C0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof hi)) {
            return super.equals(obj);
        }
        hi hiVar = (hi) obj;
        return this.X == hiVar.X && this.Y == hiVar.Y && this.Z == hiVar.Z && K().equals(hiVar.K()) && this.z0 == hiVar.z0 && J().equals(hiVar.J()) && this.B0 == hiVar.B0 && H().equals(hiVar.H()) && this.z.equals(hiVar.z);
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
        if (!yn1.C(this.y0)) {
            iK += yn1.v(4, this.y0);
        }
        long j4 = this.z0;
        if (j4 != 0) {
            iK += q60.k(5, j4);
        }
        if (!yn1.C(this.A0)) {
            iK += yn1.v(6, this.A0);
        }
        long j5 = this.B0;
        if (j5 != 0) {
            iK += q60.k(7, j5);
        }
        if (!yn1.C(this.C0)) {
            iK += yn1.v(8, this.C0);
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
        int iHashCode = this.z.hashCode() + ((H().hashCode() + ((((i12.b(this.B0) + ((((J().hashCode() + ((((i12.b(this.z0) + ((((K().hashCode() + ((((i12.b(this.Z) + ((((i12.b(this.Y) + ((((i12.b(this.X) + fw.q(bf4.W0, 779, 37, 1, 53)) * 37) + 2) * 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53)) * 37) + 6) * 53)) * 37) + 7) * 53)) * 37) + 8) * 53)) * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return E0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return F0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return E0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        gi giVar = new gi(ue1Var);
        giVar.z0 = "";
        giVar.B0 = "";
        giVar.D0 = "";
        return giVar;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.X0;
        vn1Var.a(hi.class, gi.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return E0;
    }
}
