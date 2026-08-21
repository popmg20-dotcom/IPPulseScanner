package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vp0 extends nn1 {
    public static final vp0 C0;
    public static final pp0 D0;
    public int A0;
    public byte B0;
    public int Y;
    public List Z;
    public List y0;
    public gq0 z0;

    static {
        ao3.a(5, "ExtensionRangeOptions");
        vp0 vp0Var = new vp0();
        vp0Var.A0 = 1;
        vp0Var.B0 = (byte) -1;
        List list = Collections.EMPTY_LIST;
        vp0Var.Z = list;
        vp0Var.y0 = list;
        vp0Var.A0 = 1;
        C0 = vp0Var;
        D0 = new pp0();
    }

    public final gq0 K() {
        gq0 gq0Var = this.z0;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean L() {
        return (this.Y & 1) != 0;
    }

    public final boolean N() {
        return (this.Y & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public final qp0 u() {
        if (this == C0) {
            return new qp0();
        }
        qp0 qp0Var = new qp0();
        qp0Var.a0(this);
        return qp0Var;
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
        for (int i = 0; i < this.Z.size(); i++) {
            if (!((us0) this.Z.get(i)).c()) {
                this.B0 = (byte) 0;
                return false;
            }
        }
        if (L() && !K().c()) {
            this.B0 = (byte) 0;
            return false;
        }
        if (this.X.j()) {
            this.B0 = (byte) 1;
            return true;
        }
        this.B0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        mn1 mn1VarJ = J();
        for (int i = 0; i < this.y0.size(); i++) {
            q60Var.u(2, (nl2) this.y0.get(i));
        }
        if ((this.Y & 2) != 0) {
            q60Var.s(3, this.A0);
        }
        if ((this.Y & 1) != 0) {
            q60Var.u(50, K());
        }
        for (int i2 = 0; i2 < this.Z.size(); i2++) {
            q60Var.u(999, (nl2) this.Z.get(i2));
        }
        mn1VarJ.k(536870912, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vp0)) {
            return super.equals(obj);
        }
        vp0 vp0Var = (vp0) obj;
        if (!this.Z.equals(vp0Var.Z) || !this.y0.equals(vp0Var.y0) || L() != vp0Var.L()) {
            return false;
        }
        if ((!L() || K().equals(vp0Var.K())) && N() == vp0Var.N()) {
            return (!N() || this.A0 == vp0Var.A0) && this.z.equals(vp0Var.z) && this.X.f().equals(vp0Var.X.f());
        }
        return false;
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iF = 0;
        for (int i2 = 0; i2 < this.y0.size(); i2++) {
            iF += q60.f(2, (nl2) this.y0.get(i2));
        }
        if ((this.Y & 2) != 0) {
            iF += q60.d(3, this.A0);
        }
        if ((this.Y & 1) != 0) {
            iF += q60.f(50, K());
        }
        for (int i3 = 0; i3 < this.Z.size(); i3++) {
            iF += q60.f(999, (nl2) this.Z.get(i3));
        }
        int iH = this.z.h() + this.X.h() + iF;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = vs0.I0.hashCode() + 779;
        if (this.Z.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 999, 53) + this.Z.hashCode();
        }
        if (this.y0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.y0.hashCode();
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 50, 53) + K().hashCode();
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + this.A0;
        }
        int iHashCode2 = this.z.hashCode() + (c1.q(iHashCode, this.X.f()) * 29);
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
        qp0 qp0Var = new qp0(ue1Var);
        List list = Collections.EMPTY_LIST;
        qp0Var.Z = list;
        qp0Var.y0 = list;
        qp0Var.B0 = 1;
        return qp0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.J0;
        vn1Var.a(vp0.class, qp0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return C0;
    }
}
