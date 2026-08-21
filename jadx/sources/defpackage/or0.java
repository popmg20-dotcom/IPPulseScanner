package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class or0 extends nn1 {
    public static final or0 F0;
    public static final mr0 G0;
    public boolean A0;
    public boolean B0;
    public gq0 C0;
    public List D0;
    public byte E0;
    public int Y;
    public boolean Z;
    public boolean y0;
    public boolean z0;

    static {
        ao3.a(5, "MessageOptions");
        or0 or0Var = new or0();
        or0Var.Z = false;
        or0Var.y0 = false;
        or0Var.z0 = false;
        or0Var.A0 = false;
        or0Var.B0 = false;
        or0Var.E0 = (byte) -1;
        or0Var.D0 = Collections.EMPTY_LIST;
        F0 = or0Var;
        G0 = new mr0();
    }

    public final gq0 K() {
        gq0 gq0Var = this.C0;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean L() {
        return (this.Y & 4) != 0;
    }

    public final boolean N() {
        return (this.Y & 16) != 0;
    }

    public final boolean O() {
        return (this.Y & 32) != 0;
    }

    public final boolean P() {
        return (this.Y & 8) != 0;
    }

    public final boolean Q() {
        return (this.Y & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public final nr0 u() {
        if (this == F0) {
            return new nr0();
        }
        nr0 nr0Var = new nr0();
        nr0Var.a0(this);
        return nr0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return F0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.E0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (O() && !K().c()) {
            this.E0 = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.D0.size(); i++) {
            if (!((us0) this.D0.get(i)).c()) {
                this.E0 = (byte) 0;
                return false;
            }
        }
        if (this.X.j()) {
            this.E0 = (byte) 1;
            return true;
        }
        this.E0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        mn1 mn1VarJ = J();
        if ((this.Y & 1) != 0) {
            q60Var.n(1, this.Z);
        }
        if ((this.Y & 2) != 0) {
            q60Var.n(2, this.y0);
        }
        if ((this.Y & 4) != 0) {
            q60Var.n(3, this.z0);
        }
        if ((this.Y & 8) != 0) {
            q60Var.n(7, this.A0);
        }
        if ((this.Y & 16) != 0) {
            q60Var.n(11, this.B0);
        }
        if ((this.Y & 32) != 0) {
            q60Var.u(12, K());
        }
        for (int i = 0; i < this.D0.size(); i++) {
            q60Var.u(999, (nl2) this.D0.get(i));
        }
        mn1VarJ.k(536870912, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof or0)) {
                return super.equals(obj);
            }
            or0 or0Var = (or0) obj;
            int i = this.Y;
            if (((i & 1) != 0) != ((or0Var.Y & 1) != 0) || (((i & 1) != 0 && this.Z != or0Var.Z) || Q() != or0Var.Q() || ((Q() && this.y0 != or0Var.y0) || L() != or0Var.L() || ((L() && this.z0 != or0Var.z0) || P() != or0Var.P() || ((P() && this.A0 != or0Var.A0) || N() != or0Var.N() || ((N() && this.B0 != or0Var.B0) || O() != or0Var.O() || ((O() && !K().equals(or0Var.K())) || !this.D0.equals(or0Var.D0) || !this.z.equals(or0Var.z) || !this.X.f().equals(or0Var.X.f())))))))) {
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
            iB += q60.b(2);
        }
        if ((this.Y & 4) != 0) {
            iB += q60.b(3);
        }
        if ((this.Y & 8) != 0) {
            iB += q60.b(7);
        }
        if ((this.Y & 16) != 0) {
            iB += q60.b(11);
        }
        if ((this.Y & 32) != 0) {
            iB += q60.f(12, K());
        }
        for (int i2 = 0; i2 < this.D0.size(); i2++) {
            iB += q60.f(999, (nl2) this.D0.get(i2));
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
        int iHashCode = vs0.c1.hashCode() + 779;
        if ((this.Y & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + i12.a(this.Z);
        }
        if (Q()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + i12.a(this.y0);
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + i12.a(this.z0);
        }
        if (P()) {
            iHashCode = fw.p(iHashCode, 37, 7, 53) + i12.a(this.A0);
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 11, 53) + i12.a(this.B0);
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 12, 53) + K().hashCode();
        }
        if (this.D0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 999, 53) + this.D0.hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (c1.q(iHashCode, this.X.f()) * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return F0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return G0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return F0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        nr0 nr0Var = new nr0(ue1Var);
        nr0Var.E0 = Collections.EMPTY_LIST;
        return nr0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.d1;
        vn1Var.a(or0.class, nr0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return F0;
    }
}
