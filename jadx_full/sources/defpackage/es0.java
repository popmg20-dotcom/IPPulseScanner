package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class es0 extends yn1 {
    public static final es0 A0;
    public static final cs0 B0;
    public int X;
    public volatile Serializable Y;
    public List Z;
    public hs0 y0;
    public byte z0;

    static {
        ao3.a(5, "ServiceDescriptorProto");
        es0 es0Var = new es0();
        es0Var.Y = "";
        es0Var.z0 = (byte) -1;
        es0Var.Y = "";
        es0Var.Z = Collections.EMPTY_LIST;
        A0 = es0Var;
        B0 = new cs0();
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

    public final hs0 J() {
        hs0 hs0Var = this.y0;
        return hs0Var == null ? hs0.B0 : hs0Var;
    }

    public final boolean K() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final ds0 u() {
        if (this == A0) {
            return new ds0();
        }
        ds0 ds0Var = new ds0();
        ds0Var.V(this);
        return ds0Var;
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
        for (int i = 0; i < this.Z.size(); i++) {
            if (!((rr0) this.Z.get(i)).c()) {
                this.z0 = (byte) 0;
                return false;
            }
        }
        if (!K() || J().c()) {
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
        for (int i = 0; i < this.Z.size(); i++) {
            q60Var.u(2, (nl2) this.Z.get(i));
        }
        if ((this.X & 2) != 0) {
            q60Var.u(3, J());
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof es0)) {
                return super.equals(obj);
            }
            es0 es0Var = (es0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((es0Var.X & 1) != 0) || (((i & 1) != 0 && !H().equals(es0Var.H())) || !this.Z.equals(es0Var.Z) || K() != es0Var.K() || ((K() && !J().equals(es0Var.J())) || !this.z.equals(es0Var.z)))) {
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
        for (int i2 = 0; i2 < this.Z.size(); i2++) {
            iV += q60.f(2, (nl2) this.Z.get(i2));
        }
        if ((this.X & 2) != 0) {
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
        int iHashCode = vs0.W0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + H().hashCode();
        }
        if (this.Z.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Z.hashCode();
        }
        if (K()) {
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
        ds0 ds0Var = new ds0(ue1Var);
        ds0Var.Y = "";
        ds0Var.Z = Collections.EMPTY_LIST;
        return ds0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.X0;
        vn1Var.a(es0.class, ds0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
