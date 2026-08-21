package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yr0 extends yn1 {
    public static final wr0 A0;
    public static final yr0 z0;
    public int X;
    public volatile Serializable Y;
    public bs0 Z;
    public byte y0;

    static {
        ao3.a(5, "OneofDescriptorProto");
        yr0 yr0Var = new yr0();
        yr0Var.Y = "";
        yr0Var.y0 = (byte) -1;
        yr0Var.Y = "";
        z0 = yr0Var;
        A0 = new wr0();
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

    public final bs0 J() {
        bs0 bs0Var = this.Z;
        return bs0Var == null ? bs0.A0 : bs0Var;
    }

    public final boolean K() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final xr0 u() {
        if (this == z0) {
            return new xr0();
        }
        xr0 xr0Var = new xr0();
        xr0Var.V(this);
        return xr0Var;
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
        if (!K() || J().c()) {
            this.y0 = (byte) 1;
            return true;
        }
        this.y0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            yn1.G(q60Var, 1, this.Y);
        }
        if ((this.X & 2) != 0) {
            q60Var.u(2, J());
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof yr0)) {
                return super.equals(obj);
            }
            yr0 yr0Var = (yr0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((yr0Var.X & 1) != 0) || (((i & 1) != 0 && !H().equals(yr0Var.H())) || K() != yr0Var.K() || ((K() && !J().equals(yr0Var.J())) || !this.z.equals(yr0Var.z)))) {
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
            iV += q60.f(2, J());
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
        int iHashCode = vs0.O0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + H().hashCode();
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + J().hashCode();
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
        xr0 xr0Var = new xr0(ue1Var);
        xr0Var.Y = "";
        return xr0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.P0;
        vn1Var.a(yr0.class, xr0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return z0;
    }
}
