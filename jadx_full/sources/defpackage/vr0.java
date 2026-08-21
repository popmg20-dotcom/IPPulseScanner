package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vr0 extends nn1 {
    public static final vr0 C0;
    public static final sr0 D0;
    public List A0;
    public byte B0;
    public int Y;
    public boolean Z;
    public int y0;
    public gq0 z0;

    static {
        ao3.a(5, "MethodOptions");
        vr0 vr0Var = new vr0();
        vr0Var.Z = false;
        vr0Var.B0 = (byte) -1;
        vr0Var.y0 = 0;
        vr0Var.A0 = Collections.EMPTY_LIST;
        C0 = vr0Var;
        D0 = new sr0();
    }

    public final gq0 K() {
        gq0 gq0Var = this.z0;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean L() {
        return (this.Y & 4) != 0;
    }

    public final boolean N() {
        return (this.Y & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public final tr0 u() {
        if (this == C0) {
            return new tr0();
        }
        tr0 tr0Var = new tr0();
        tr0Var.a0(this);
        return tr0Var;
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
        if (L() && !K().c()) {
            this.B0 = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.A0.size(); i++) {
            if (!((us0) this.A0.get(i)).c()) {
                this.B0 = (byte) 0;
                return false;
            }
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
        if ((this.Y & 1) != 0) {
            q60Var.n(33, this.Z);
        }
        if ((this.Y & 2) != 0) {
            q60Var.s(34, this.y0);
        }
        if ((this.Y & 4) != 0) {
            q60Var.u(35, K());
        }
        for (int i = 0; i < this.A0.size(); i++) {
            q60Var.u(999, (nl2) this.A0.get(i));
        }
        mn1VarJ.k(536870912, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof vr0)) {
                return super.equals(obj);
            }
            vr0 vr0Var = (vr0) obj;
            int i = this.Y;
            if (((i & 1) != 0) != ((vr0Var.Y & 1) != 0) || (((i & 1) != 0 && this.Z != vr0Var.Z) || N() != vr0Var.N() || ((N() && this.y0 != vr0Var.y0) || L() != vr0Var.L() || ((L() && !K().equals(vr0Var.K())) || !this.A0.equals(vr0Var.A0) || !this.z.equals(vr0Var.z) || !this.X.f().equals(vr0Var.X.f()))))) {
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
        int iB = (this.Y & 1) != 0 ? q60.b(33) : 0;
        if ((this.Y & 2) != 0) {
            iB += q60.d(34, this.y0);
        }
        if ((this.Y & 4) != 0) {
            iB += q60.f(35, K());
        }
        for (int i2 = 0; i2 < this.A0.size(); i2++) {
            iB += q60.f(999, (nl2) this.A0.get(i2));
        }
        int iH = this.z.h() + this.X.h() + iB;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = vs0.s1.hashCode() + 779;
        if ((this.Y & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 33, 53) + i12.a(this.Z);
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 34, 53) + this.y0;
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 35, 53) + K().hashCode();
        }
        if (this.A0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 999, 53) + this.A0.hashCode();
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
        tr0 tr0Var = new tr0(ue1Var);
        tr0Var.y0 = 0;
        tr0Var.B0 = Collections.EMPTY_LIST;
        return tr0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.t1;
        vn1Var.a(vr0.class, tr0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return C0;
    }
}
