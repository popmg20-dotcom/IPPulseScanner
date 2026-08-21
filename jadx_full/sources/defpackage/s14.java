package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s14 extends yn1 {
    public static final s14 A0;
    public static final q14 B0;
    public int X;
    public hi Y;
    public long Z;
    public long y0;
    public byte z0;

    static {
        ao3.a(4, "StackHistoryBufferEntry");
        s14 s14Var = new s14();
        s14Var.Z = 0L;
        s14Var.y0 = 0L;
        s14Var.z0 = (byte) -1;
        A0 = s14Var;
        B0 = new q14();
    }

    public final hi H() {
        hi hiVar = this.Y;
        return hiVar == null ? hi.E0 : hiVar;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final r14 u() {
        if (this == A0) {
            return new r14();
        }
        r14 r14Var = new r14();
        r14Var.W(this);
        return r14Var;
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
        if ((this.X & 1) != 0) {
            q60Var.u(1, H());
        }
        long j = this.Z;
        if (j != 0) {
            q60Var.A(2, j);
        }
        long j2 = this.y0;
        if (j2 != 0) {
            q60Var.A(3, j2);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof s14)) {
                return super.equals(obj);
            }
            s14 s14Var = (s14) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((s14Var.X & 1) != 0) || (((i & 1) != 0 && !H().equals(s14Var.H())) || this.Z != s14Var.Z || this.y0 != s14Var.y0 || !this.z.equals(s14Var.z))) {
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
        int iF = (this.X & 1) != 0 ? q60.f(1, H()) : 0;
        long j = this.Z;
        if (j != 0) {
            iF += q60.k(2, j);
        }
        long j2 = this.y0;
        if (j2 != 0) {
            iF += q60.k(3, j2);
        }
        int iH = this.z.h() + iF;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = bf4.C0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + H().hashCode();
        }
        int iHashCode2 = this.z.hashCode() + ((i12.b(this.y0) + ((((i12.b(this.Z) + fw.p(iHashCode, 37, 2, 53)) * 37) + 3) * 53)) * 29);
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
        return new r14(ue1Var);
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.D0;
        vn1Var.a(s14.class, r14.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
