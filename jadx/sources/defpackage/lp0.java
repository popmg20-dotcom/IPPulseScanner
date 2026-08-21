package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lp0 extends yn1 {
    public static final lp0 A0;
    public static final jp0 B0;
    public int X;
    public volatile Serializable Y;
    public int Z;
    public op0 y0;
    public byte z0;

    static {
        ao3.a(5, "EnumValueDescriptorProto");
        lp0 lp0Var = new lp0();
        lp0Var.Y = "";
        lp0Var.Z = 0;
        lp0Var.z0 = (byte) -1;
        lp0Var.Y = "";
        A0 = lp0Var;
        B0 = new jp0();
    }

    public final String H() {
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

    public final op0 J() {
        op0 op0Var = this.y0;
        return op0Var == null ? op0.D0 : op0Var;
    }

    public final boolean K() {
        return (this.X & 2) != 0;
    }

    public final boolean L() {
        return (this.X & 4) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final kp0 u() {
        if (this == A0) {
            return new kp0();
        }
        kp0 kp0Var = new kp0();
        kp0Var.V(this);
        return kp0Var;
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
        if (!L() || J().c()) {
            this.z0 = (byte) 1;
            return true;
        }
        this.z0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            yn1.G(q60Var, 1, this.Y);
        }
        if ((this.X & 2) != 0) {
            q60Var.s(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            q60Var.u(3, J());
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof lp0)) {
                return super.equals(obj);
            }
            lp0 lp0Var = (lp0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((lp0Var.X & 1) != 0) || (((i & 1) != 0 && !H().equals(lp0Var.H())) || K() != lp0Var.K() || ((K() && this.Z != lp0Var.Z) || L() != lp0Var.L() || ((L() && !J().equals(lp0Var.J())) || !this.z.equals(lp0Var.z))))) {
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
            iV += q60.e(2, this.Z);
        }
        if ((this.X & 4) != 0) {
            iV += q60.f(3, J());
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
        int iHashCode = vs0.U0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + H().hashCode();
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Z;
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + J().hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
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
        kp0 kp0Var = new kp0(ue1Var);
        kp0Var.Y = "";
        return kp0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.V0;
        vn1Var.a(lp0.class, kp0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
