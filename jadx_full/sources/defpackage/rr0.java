package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rr0 extends yn1 {
    public static final rr0 D0;
    public static final pr0 E0;
    public boolean A0;
    public boolean B0;
    public byte C0;
    public int X;
    public volatile Serializable Y;
    public volatile Serializable Z;
    public volatile Serializable y0;
    public vr0 z0;

    static {
        ao3.a(5, "MethodDescriptorProto");
        rr0 rr0Var = new rr0();
        rr0Var.Y = "";
        rr0Var.Z = "";
        rr0Var.y0 = "";
        rr0Var.A0 = false;
        rr0Var.B0 = false;
        rr0Var.C0 = (byte) -1;
        rr0Var.Y = "";
        rr0Var.Z = "";
        rr0Var.y0 = "";
        D0 = rr0Var;
        E0 = new pr0();
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

    public final vr0 K() {
        vr0 vr0Var = this.z0;
        return vr0Var == null ? vr0.C0 : vr0Var;
    }

    public final String L() {
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

    public final boolean N() {
        return (this.X & 16) != 0;
    }

    public final boolean O() {
        return (this.X & 2) != 0;
    }

    public final boolean P() {
        return (this.X & 8) != 0;
    }

    public final boolean Q() {
        return (this.X & 4) != 0;
    }

    public final boolean R() {
        return (this.X & 32) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final qr0 u() {
        if (this == D0) {
            return new qr0();
        }
        qr0 qr0Var = new qr0();
        qr0Var.V(this);
        return qr0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return D0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.C0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!P() || K().c()) {
            this.C0 = (byte) 1;
            return true;
        }
        this.C0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            yn1.G(q60Var, 1, this.Y);
        }
        if ((this.X & 2) != 0) {
            yn1.G(q60Var, 2, this.Z);
        }
        if ((this.X & 4) != 0) {
            yn1.G(q60Var, 3, this.y0);
        }
        if ((this.X & 8) != 0) {
            q60Var.u(4, K());
        }
        if ((this.X & 16) != 0) {
            q60Var.n(5, this.A0);
        }
        if ((this.X & 32) != 0) {
            q60Var.n(6, this.B0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof rr0)) {
                return super.equals(obj);
            }
            rr0 rr0Var = (rr0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((rr0Var.X & 1) != 0) || (((i & 1) != 0 && !J().equals(rr0Var.J())) || O() != rr0Var.O() || ((O() && !H().equals(rr0Var.H())) || Q() != rr0Var.Q() || ((Q() && !L().equals(rr0Var.L())) || P() != rr0Var.P() || ((P() && !K().equals(rr0Var.K())) || N() != rr0Var.N() || ((N() && this.A0 != rr0Var.A0) || R() != rr0Var.R() || ((R() && this.B0 != rr0Var.B0) || !this.z.equals(rr0Var.z)))))))) {
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
        if ((this.X & 2) != 0) {
            iV += yn1.v(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            iV += yn1.v(3, this.y0);
        }
        if ((this.X & 8) != 0) {
            iV += q60.f(4, K());
        }
        if ((this.X & 16) != 0) {
            iV += q60.b(5);
        }
        if ((this.X & 32) != 0) {
            iV += q60.b(6);
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
        int iHashCode = vs0.Y0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + J().hashCode();
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + H().hashCode();
        }
        if (Q()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + L().hashCode();
        }
        if (P()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + K().hashCode();
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + i12.a(this.A0);
        }
        if (R()) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + i12.a(this.B0);
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return D0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return E0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return D0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        qr0 qr0Var = new qr0(ue1Var);
        qr0Var.Y = "";
        qr0Var.Z = "";
        qr0Var.y0 = "";
        return qr0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.Z0;
        vn1Var.a(rr0.class, qr0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return D0;
    }
}
