package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bs0 extends nn1 {
    public static final bs0 A0;
    public static final zr0 B0;
    public int Y;
    public gq0 Z;
    public List y0;
    public byte z0;

    static {
        ao3.a(5, "OneofOptions");
        bs0 bs0Var = new bs0();
        bs0Var.z0 = (byte) -1;
        bs0Var.y0 = Collections.EMPTY_LIST;
        A0 = bs0Var;
        B0 = new zr0();
    }

    public final gq0 K() {
        gq0 gq0Var = this.Z;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean L() {
        return (this.Y & 1) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final as0 u() {
        if (this == A0) {
            return new as0();
        }
        as0 as0Var = new as0();
        as0Var.a0(this);
        return as0Var;
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
        if (L() && !K().c()) {
            this.z0 = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.y0.size(); i++) {
            if (!((us0) this.y0.get(i)).c()) {
                this.z0 = (byte) 0;
                return false;
            }
        }
        if (this.X.j()) {
            this.z0 = (byte) 1;
            return true;
        }
        this.z0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        mn1 mn1VarJ = J();
        if ((this.Y & 1) != 0) {
            q60Var.u(1, K());
        }
        for (int i = 0; i < this.y0.size(); i++) {
            q60Var.u(999, (nl2) this.y0.get(i));
        }
        mn1VarJ.k(536870912, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bs0)) {
            return super.equals(obj);
        }
        bs0 bs0Var = (bs0) obj;
        if (L() != bs0Var.L()) {
            return false;
        }
        return (!L() || K().equals(bs0Var.K())) && this.y0.equals(bs0Var.y0) && this.z.equals(bs0Var.z) && this.X.f().equals(bs0Var.X.f());
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iF = (this.Y & 1) != 0 ? q60.f(1, K()) : 0;
        for (int i2 = 0; i2 < this.y0.size(); i2++) {
            iF += q60.f(999, (nl2) this.y0.get(i2));
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
        int iHashCode = vs0.k1.hashCode() + 779;
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + K().hashCode();
        }
        if (this.y0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 999, 53) + this.y0.hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (c1.q(iHashCode, this.X.f()) * 29);
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
        as0 as0Var = new as0(ue1Var);
        as0Var.z0 = Collections.EMPTY_LIST;
        return as0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.l1;
        vn1Var.a(bs0.class, as0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
