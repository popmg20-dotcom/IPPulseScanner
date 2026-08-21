package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class us0 extends yn1 {
    public static final us0 E0;
    public static final ps0 F0;
    public double A0;
    public zt B0;
    public volatile Serializable C0;
    public byte D0;
    public int X;
    public List Y;
    public volatile Serializable Z;
    public long y0;
    public long z0;

    static {
        ao3.a(5, "UninterpretedOption");
        us0 us0Var = new us0();
        us0Var.Z = "";
        us0Var.y0 = 0L;
        us0Var.z0 = 0L;
        us0Var.A0 = 0.0d;
        zt ztVar = zt.z;
        us0Var.B0 = ztVar;
        us0Var.C0 = "";
        us0Var.D0 = (byte) -1;
        us0Var.Y = Collections.EMPTY_LIST;
        us0Var.Z = "";
        us0Var.B0 = ztVar;
        us0Var.C0 = "";
        E0 = us0Var;
        F0 = new ps0();
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

    public final boolean K() {
        return (this.X & 32) != 0;
    }

    public final boolean L() {
        return (this.X & 8) != 0;
    }

    public final boolean N() {
        return (this.X & 4) != 0;
    }

    public final boolean O() {
        return (this.X & 2) != 0;
    }

    public final boolean P() {
        return (this.X & 16) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final qs0 u() {
        if (this == E0) {
            return new qs0();
        }
        qs0 qs0Var = new qs0();
        qs0Var.V(this);
        return qs0Var;
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
        for (int i = 0; i < this.Y.size(); i++) {
            if (!((ts0) this.Y.get(i)).c()) {
                this.D0 = (byte) 0;
                return false;
            }
        }
        this.D0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        for (int i = 0; i < this.Y.size(); i++) {
            q60Var.u(2, (nl2) this.Y.get(i));
        }
        if ((this.X & 1) != 0) {
            yn1.G(q60Var, 3, this.Z);
        }
        if ((this.X & 2) != 0) {
            q60Var.A(4, this.y0);
        }
        if ((this.X & 4) != 0) {
            q60Var.A(5, this.z0);
        }
        if ((this.X & 8) != 0) {
            double d = this.A0;
            q60Var.getClass();
            long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
            q60Var.x(6, 1);
            q60Var.r(jDoubleToRawLongBits);
        }
        if ((this.X & 16) != 0) {
            q60Var.o(7, this.B0);
        }
        if ((this.X & 32) != 0) {
            yn1.G(q60Var, 8, this.C0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof us0)) {
                return super.equals(obj);
            }
            us0 us0Var = (us0) obj;
            if (this.Y.equals(us0Var.Y)) {
                int i = this.X;
                if (((i & 1) != 0) == ((us0Var.X & 1) != 0) && (((i & 1) == 0 || J().equals(us0Var.J())) && O() == us0Var.O() && ((!O() || this.y0 == us0Var.y0) && N() == us0Var.N() && ((!N() || this.z0 == us0Var.z0) && L() == us0Var.L() && ((!L() || Double.doubleToLongBits(this.A0) == Double.doubleToLongBits(us0Var.A0)) && P() == us0Var.P() && ((!P() || this.B0.equals(us0Var.B0)) && K() == us0Var.K() && ((!K() || H().equals(us0Var.H())) && this.z.equals(us0Var.z)))))))) {
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
        int iV = 0;
        for (int i2 = 0; i2 < this.Y.size(); i2++) {
            iV += q60.f(2, (nl2) this.Y.get(i2));
        }
        if ((this.X & 1) != 0) {
            iV += yn1.v(3, this.Z);
        }
        if ((this.X & 2) != 0) {
            iV += q60.k(4, this.y0);
        }
        if ((this.X & 4) != 0) {
            iV += q60.l(this.z0) + q60.h(5);
        }
        if ((this.X & 8) != 0) {
            iV += q60.h(6) + 8;
        }
        if ((this.X & 16) != 0) {
            iV += q60.c(7, this.B0);
        }
        if ((this.X & 32) != 0) {
            iV += yn1.v(8, this.C0);
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
        int iHashCode = vs0.u1.hashCode() + 779;
        if (this.Y.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Y.hashCode();
        }
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + J().hashCode();
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + i12.b(this.y0);
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + i12.b(this.z0);
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + i12.b(Double.doubleToLongBits(this.A0));
        }
        if (P()) {
            iHashCode = fw.p(iHashCode, 37, 7, 53) + this.B0.hashCode();
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 8, 53) + H().hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
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
        qs0 qs0Var = new qs0(ue1Var);
        qs0Var.Y = Collections.EMPTY_LIST;
        qs0Var.Z = "";
        qs0Var.B0 = zt.z;
        qs0Var.C0 = "";
        return qs0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.v1;
        vn1Var.a(us0.class, qs0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return E0;
    }
}
