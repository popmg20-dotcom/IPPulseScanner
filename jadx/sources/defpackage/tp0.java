package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tp0 extends yn1 {
    public static final tp0 C0;
    public static final rp0 D0;
    public boolean A0;
    public byte B0;
    public int X;
    public int Y;
    public volatile Serializable Z;
    public volatile Serializable y0;
    public boolean z0;

    static {
        ao3.a(5, "Declaration");
        tp0 tp0Var = new tp0();
        tp0Var.Y = 0;
        tp0Var.Z = "";
        tp0Var.y0 = "";
        tp0Var.z0 = false;
        tp0Var.A0 = false;
        tp0Var.B0 = (byte) -1;
        tp0Var.Z = "";
        tp0Var.y0 = "";
        C0 = tp0Var;
        D0 = new rp0();
    }

    public final String H() {
        Serializable serializable = this.Z;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.Z = strI;
        }
        return strI;
    }

    public final String J() {
        Serializable serializable = this.y0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.y0 = strI;
        }
        return strI;
    }

    public final boolean K() {
        return (this.X & 2) != 0;
    }

    public final boolean L() {
        return (this.X & 16) != 0;
    }

    public final boolean N() {
        return (this.X & 8) != 0;
    }

    public final boolean O() {
        return (this.X & 4) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final sp0 u() {
        if (this == C0) {
            return new sp0();
        }
        sp0 sp0Var = new sp0();
        sp0Var.V(this);
        return sp0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return C0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.B0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.B0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            q60Var.s(1, this.Y);
        }
        if ((this.X & 2) != 0) {
            yn1.G(q60Var, 2, this.Z);
        }
        if ((this.X & 4) != 0) {
            yn1.G(q60Var, 3, this.y0);
        }
        if ((this.X & 8) != 0) {
            q60Var.n(5, this.z0);
        }
        if ((this.X & 16) != 0) {
            q60Var.n(6, this.A0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof tp0)) {
                return super.equals(obj);
            }
            tp0 tp0Var = (tp0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((tp0Var.X & 1) != 0) || (((i & 1) != 0 && this.Y != tp0Var.Y) || K() != tp0Var.K() || ((K() && !H().equals(tp0Var.H())) || O() != tp0Var.O() || ((O() && !J().equals(tp0Var.J())) || N() != tp0Var.N() || ((N() && this.z0 != tp0Var.z0) || L() != tp0Var.L() || ((L() && this.A0 != tp0Var.A0) || !this.z.equals(tp0Var.z))))))) {
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
            iE += yn1.v(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            iE += yn1.v(3, this.y0);
        }
        if ((this.X & 8) != 0) {
            iE += q60.b(5);
        }
        if ((this.X & 16) != 0) {
            iE += q60.b(6);
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
        int iHashCode = vs0.K0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + this.Y;
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + H().hashCode();
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + J().hashCode();
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + i12.a(this.z0);
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + i12.a(this.A0);
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return C0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return D0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return C0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        sp0 sp0Var = new sp0(ue1Var);
        sp0Var.Z = "";
        sp0Var.y0 = "";
        return sp0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.L0;
        vn1Var.a(tp0.class, sp0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return C0;
    }
}
