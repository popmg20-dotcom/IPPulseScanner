package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ts0 extends yn1 {
    public static final rs0 A0;
    public static final ts0 z0;
    public int X;
    public volatile Serializable Y;
    public boolean Z;
    public byte y0;

    static {
        ao3.a(5, "NamePart");
        ts0 ts0Var = new ts0();
        ts0Var.Y = "";
        ts0Var.Z = false;
        ts0Var.y0 = (byte) -1;
        ts0Var.Y = "";
        z0 = ts0Var;
        A0 = new rs0();
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

    public final boolean J() {
        return (this.X & 2) != 0;
    }

    public final boolean K() {
        return (this.X & 1) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final ss0 u() {
        if (this == z0) {
            return new ss0();
        }
        ss0 ss0Var = new ss0();
        ss0Var.V(this);
        return ss0Var;
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
        if (!K()) {
            this.y0 = (byte) 0;
            return false;
        }
        if (J()) {
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
            q60Var.n(2, this.Z);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ts0)) {
            return super.equals(obj);
        }
        ts0 ts0Var = (ts0) obj;
        if (K() != ts0Var.K()) {
            return false;
        }
        if ((!K() || H().equals(ts0Var.H())) && J() == ts0Var.J()) {
            return (!J() || this.Z == ts0Var.Z) && this.z.equals(ts0Var.z);
        }
        return false;
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iV = (this.X & 1) != 0 ? yn1.v(1, this.Y) : 0;
        if ((this.X & 2) != 0) {
            iV += q60.b(2);
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
        int iHashCode = vs0.w1.hashCode() + 779;
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + H().hashCode();
        }
        if (J()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + i12.a(this.Z);
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
        ss0 ss0Var = new ss0(ue1Var);
        ss0Var.Y = "";
        return ss0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.x1;
        vn1Var.a(ts0.class, ss0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return z0;
    }
}
