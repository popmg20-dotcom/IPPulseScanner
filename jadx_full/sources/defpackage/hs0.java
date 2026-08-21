package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hs0 extends nn1 {
    public static final hs0 B0;
    public static final fs0 C0;
    public byte A0;
    public int Y;
    public gq0 Z;
    public boolean y0;
    public List z0;

    static {
        ao3.a(5, "ServiceOptions");
        hs0 hs0Var = new hs0();
        hs0Var.y0 = false;
        hs0Var.A0 = (byte) -1;
        hs0Var.z0 = Collections.EMPTY_LIST;
        B0 = hs0Var;
        C0 = new fs0();
    }

    public final gq0 K() {
        gq0 gq0Var = this.Z;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean L() {
        return (this.Y & 2) != 0;
    }

    public final boolean N() {
        return (this.Y & 1) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public final gs0 u() {
        if (this == B0) {
            return new gs0();
        }
        gs0 gs0Var = new gs0();
        gs0Var.a0(this);
        return gs0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return B0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.A0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (N() && !K().c()) {
            this.A0 = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.z0.size(); i++) {
            if (!((us0) this.z0.get(i)).c()) {
                this.A0 = (byte) 0;
                return false;
            }
        }
        if (this.X.j()) {
            this.A0 = (byte) 1;
            return true;
        }
        this.A0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        mn1 mn1VarJ = J();
        if ((this.Y & 2) != 0) {
            q60Var.n(33, this.y0);
        }
        if ((this.Y & 1) != 0) {
            q60Var.u(34, K());
        }
        for (int i = 0; i < this.z0.size(); i++) {
            q60Var.u(999, (nl2) this.z0.get(i));
        }
        mn1VarJ.k(536870912, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof hs0)) {
            return super.equals(obj);
        }
        hs0 hs0Var = (hs0) obj;
        if (N() != hs0Var.N()) {
            return false;
        }
        if ((!N() || K().equals(hs0Var.K())) && L() == hs0Var.L()) {
            return (!L() || this.y0 == hs0Var.y0) && this.z0.equals(hs0Var.z0) && this.z.equals(hs0Var.z) && this.X.f().equals(hs0Var.X.f());
        }
        return false;
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iB = (this.Y & 2) != 0 ? q60.b(33) : 0;
        if ((this.Y & 1) != 0) {
            iB += q60.f(34, K());
        }
        for (int i2 = 0; i2 < this.z0.size(); i2++) {
            iB += q60.f(999, (nl2) this.z0.get(i2));
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
        int iHashCode = vs0.q1.hashCode() + 779;
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 34, 53) + K().hashCode();
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 33, 53) + i12.a(this.y0);
        }
        if (this.z0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 999, 53) + this.z0.hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (c1.q(iHashCode, this.X.f()) * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return B0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return C0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return B0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        gs0 gs0Var = new gs0(ue1Var);
        gs0Var.A0 = Collections.EMPTY_LIST;
        return gs0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.r1;
        vn1Var.a(hs0.class, gs0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return B0;
    }
}
