package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class op0 extends nn1 {
    public static final op0 D0;
    public static final mp0 E0;
    public ar0 A0;
    public List B0;
    public byte C0;
    public int Y;
    public boolean Z;
    public gq0 y0;
    public boolean z0;

    static {
        ao3.a(5, "EnumValueOptions");
        op0 op0Var = new op0();
        op0Var.Z = false;
        op0Var.z0 = false;
        op0Var.C0 = (byte) -1;
        op0Var.B0 = Collections.EMPTY_LIST;
        D0 = op0Var;
        E0 = new mp0();
    }

    public final ar0 K() {
        ar0 ar0Var = this.A0;
        return ar0Var == null ? ar0.B0 : ar0Var;
    }

    public final gq0 L() {
        gq0 gq0Var = this.y0;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean N() {
        return (this.Y & 4) != 0;
    }

    public final boolean O() {
        return (this.Y & 8) != 0;
    }

    public final boolean P() {
        return (this.Y & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final np0 u() {
        if (this == D0) {
            return new np0();
        }
        np0 np0Var = new np0();
        np0Var.b0(this);
        return np0Var;
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
        if (P() && !L().c()) {
            this.C0 = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.B0.size(); i++) {
            if (!((us0) this.B0.get(i)).c()) {
                this.C0 = (byte) 0;
                return false;
            }
        }
        if (this.X.j()) {
            this.C0 = (byte) 1;
            return true;
        }
        this.C0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        mn1 mn1VarJ = J();
        if ((this.Y & 1) != 0) {
            q60Var.n(1, this.Z);
        }
        if ((this.Y & 2) != 0) {
            q60Var.u(2, L());
        }
        if ((this.Y & 4) != 0) {
            q60Var.n(3, this.z0);
        }
        if ((this.Y & 8) != 0) {
            q60Var.u(4, K());
        }
        for (int i = 0; i < this.B0.size(); i++) {
            q60Var.u(999, (nl2) this.B0.get(i));
        }
        mn1VarJ.k(536870912, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof op0)) {
                return super.equals(obj);
            }
            op0 op0Var = (op0) obj;
            int i = this.Y;
            if (((i & 1) != 0) != ((op0Var.Y & 1) != 0) || (((i & 1) != 0 && this.Z != op0Var.Z) || P() != op0Var.P() || ((P() && !L().equals(op0Var.L())) || N() != op0Var.N() || ((N() && this.z0 != op0Var.z0) || O() != op0Var.O() || ((O() && !K().equals(op0Var.K())) || !this.B0.equals(op0Var.B0) || !this.z.equals(op0Var.z) || !this.X.f().equals(op0Var.X.f())))))) {
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
        int iB = (this.Y & 1) != 0 ? q60.b(1) : 0;
        if ((this.Y & 2) != 0) {
            iB += q60.f(2, L());
        }
        if ((this.Y & 4) != 0) {
            iB += q60.b(3);
        }
        if ((this.Y & 8) != 0) {
            iB += q60.f(4, K());
        }
        for (int i2 = 0; i2 < this.B0.size(); i2++) {
            iB += q60.f(999, (nl2) this.B0.get(i2));
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
        int iHashCode = vs0.o1.hashCode() + 779;
        if ((this.Y & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + i12.a(this.Z);
        }
        if (P()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + L().hashCode();
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + i12.a(this.z0);
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + K().hashCode();
        }
        if (this.B0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 999, 53) + this.B0.hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (c1.q(iHashCode, this.X.f()) * 29);
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
        np0 np0Var = new np0(ue1Var);
        np0Var.D0 = Collections.EMPTY_LIST;
        return np0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.p1;
        vn1Var.a(op0.class, np0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return D0;
    }
}
