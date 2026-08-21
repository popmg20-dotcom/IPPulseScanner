package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rq0 extends yn1 {
    public static final rq0 I0;
    public static final nq0 J0;
    public volatile Serializable A0;
    public volatile Serializable B0;
    public volatile Serializable C0;
    public int D0;
    public volatile Serializable E0;
    public er0 F0;
    public boolean G0;
    public byte H0;
    public int X;
    public volatile Serializable Y;
    public int Z;
    public int y0;
    public int z0;

    static {
        ao3.a(5, "FieldDescriptorProto");
        rq0 rq0Var = new rq0();
        rq0Var.Y = "";
        rq0Var.Z = 0;
        rq0Var.y0 = 1;
        rq0Var.z0 = 1;
        rq0Var.A0 = "";
        rq0Var.B0 = "";
        rq0Var.C0 = "";
        rq0Var.D0 = 0;
        rq0Var.E0 = "";
        rq0Var.G0 = false;
        rq0Var.H0 = (byte) -1;
        rq0Var.Y = "";
        rq0Var.y0 = 1;
        rq0Var.z0 = 1;
        rq0Var.A0 = "";
        rq0Var.B0 = "";
        rq0Var.C0 = "";
        rq0Var.E0 = "";
        I0 = rq0Var;
        J0 = new nq0();
    }

    public final String H() {
        Serializable serializable = this.C0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.C0 = strI;
        }
        return strI;
    }

    public final String J() {
        Serializable serializable = this.B0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.B0 = strI;
        }
        return strI;
    }

    public final String K() {
        Serializable serializable = this.E0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.E0 = strI;
        }
        return strI;
    }

    public final String L() {
        Serializable serializable = this.Y;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.Y = strI;
        }
        return strI;
    }

    public final er0 N() {
        er0 er0Var = this.F0;
        return er0Var == null ? er0.M0 : er0Var;
    }

    public final String O() {
        Serializable serializable = this.A0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.A0 = strI;
        }
        return strI;
    }

    public final boolean P() {
        return (this.X & 64) != 0;
    }

    public final boolean Q() {
        return (this.X & 32) != 0;
    }

    public final boolean R() {
        return (this.X & 256) != 0;
    }

    public final boolean S() {
        return (this.X & 4) != 0;
    }

    public final boolean T() {
        return (this.X & 2) != 0;
    }

    public final boolean U() {
        return (this.X & 128) != 0;
    }

    public final boolean V() {
        return (this.X & 512) != 0;
    }

    public final boolean W() {
        return (this.X & 1024) != 0;
    }

    public final boolean X() {
        return (this.X & 8) != 0;
    }

    public final boolean Y() {
        return (this.X & 16) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final oq0 u() {
        if (this == I0) {
            return new oq0();
        }
        oq0 oq0Var = new oq0();
        oq0Var.V(this);
        return oq0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return I0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.H0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!V() || N().c()) {
            this.H0 = (byte) 1;
            return true;
        }
        this.H0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            yn1.G(q60Var, 1, this.Y);
        }
        if ((this.X & 32) != 0) {
            yn1.G(q60Var, 2, this.B0);
        }
        if ((this.X & 2) != 0) {
            q60Var.s(3, this.Z);
        }
        if ((this.X & 4) != 0) {
            q60Var.s(4, this.y0);
        }
        if ((this.X & 8) != 0) {
            q60Var.s(5, this.z0);
        }
        if ((this.X & 16) != 0) {
            yn1.G(q60Var, 6, this.A0);
        }
        if ((this.X & 64) != 0) {
            yn1.G(q60Var, 7, this.C0);
        }
        if ((this.X & 512) != 0) {
            q60Var.u(8, N());
        }
        if ((this.X & 128) != 0) {
            q60Var.s(9, this.D0);
        }
        if ((this.X & 256) != 0) {
            yn1.G(q60Var, 10, this.E0);
        }
        if ((this.X & 1024) != 0) {
            q60Var.n(17, this.G0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof rq0)) {
                return super.equals(obj);
            }
            rq0 rq0Var = (rq0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((rq0Var.X & 1) != 0) || (((i & 1) != 0 && !L().equals(rq0Var.L())) || T() != rq0Var.T() || ((T() && this.Z != rq0Var.Z) || S() != rq0Var.S() || ((S() && this.y0 != rq0Var.y0) || X() != rq0Var.X() || ((X() && this.z0 != rq0Var.z0) || Y() != rq0Var.Y() || ((Y() && !O().equals(rq0Var.O())) || Q() != rq0Var.Q() || ((Q() && !J().equals(rq0Var.J())) || P() != rq0Var.P() || ((P() && !H().equals(rq0Var.H())) || U() != rq0Var.U() || ((U() && this.D0 != rq0Var.D0) || R() != rq0Var.R() || ((R() && !K().equals(rq0Var.K())) || V() != rq0Var.V() || ((V() && !N().equals(rq0Var.N())) || W() != rq0Var.W() || ((W() && this.G0 != rq0Var.G0) || !this.z.equals(rq0Var.z))))))))))))) {
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
        int iV = (this.X & 1) != 0 ? yn1.v(1, this.Y) : 0;
        if ((this.X & 32) != 0) {
            iV += yn1.v(2, this.B0);
        }
        if ((this.X & 2) != 0) {
            iV += q60.e(3, this.Z);
        }
        if ((this.X & 4) != 0) {
            iV += q60.d(4, this.y0);
        }
        if ((this.X & 8) != 0) {
            iV += q60.d(5, this.z0);
        }
        if ((this.X & 16) != 0) {
            iV += yn1.v(6, this.A0);
        }
        if ((this.X & 64) != 0) {
            iV += yn1.v(7, this.C0);
        }
        if ((this.X & 512) != 0) {
            iV += q60.f(8, N());
        }
        if ((this.X & 128) != 0) {
            iV += q60.e(9, this.D0);
        }
        if ((this.X & 256) != 0) {
            iV += yn1.v(10, this.E0);
        }
        if ((this.X & 1024) != 0) {
            iV += q60.b(17);
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
        int iHashCode = vs0.M0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + L().hashCode();
        }
        if (T()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + this.Z;
        }
        if (S()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + this.y0;
        }
        if (X()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + this.z0;
        }
        if (Y()) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + O().hashCode();
        }
        if (Q()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + J().hashCode();
        }
        if (P()) {
            iHashCode = fw.p(iHashCode, 37, 7, 53) + H().hashCode();
        }
        if (U()) {
            iHashCode = fw.p(iHashCode, 37, 9, 53) + this.D0;
        }
        if (R()) {
            iHashCode = fw.p(iHashCode, 37, 10, 53) + K().hashCode();
        }
        if (V()) {
            iHashCode = fw.p(iHashCode, 37, 8, 53) + N().hashCode();
        }
        if (W()) {
            iHashCode = fw.p(iHashCode, 37, 17, 53) + i12.a(this.G0);
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return I0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return J0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return I0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        oq0 oq0Var = new oq0(ue1Var);
        oq0Var.Y = "";
        oq0Var.y0 = 1;
        oq0Var.z0 = 1;
        oq0Var.A0 = "";
        oq0Var.B0 = "";
        oq0Var.C0 = "";
        oq0Var.E0 = "";
        return oq0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.N0;
        vn1Var.a(rq0.class, oq0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return I0;
    }
}
