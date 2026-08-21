package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ip0 extends nn1 {
    public static final ip0 D0;
    public static final gp0 E0;
    public gq0 A0;
    public List B0;
    public byte C0;
    public int Y;
    public boolean Z;
    public boolean y0;
    public boolean z0;

    static {
        ao3.a(5, "EnumOptions");
        ip0 ip0Var = new ip0();
        ip0Var.Z = false;
        ip0Var.y0 = false;
        ip0Var.z0 = false;
        ip0Var.C0 = (byte) -1;
        ip0Var.B0 = Collections.EMPTY_LIST;
        D0 = ip0Var;
        E0 = new gp0();
    }

    public final gq0 K() {
        gq0 gq0Var = this.A0;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean L() {
        return (this.Y & 2) != 0;
    }

    public final boolean N() {
        return (this.Y & 4) != 0;
    }

    public final boolean O() {
        return (this.Y & 8) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final hp0 u() {
        if (this == D0) {
            return new hp0();
        }
        hp0 hp0Var = new hp0();
        hp0Var.a0(this);
        return hp0Var;
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
        if (O() && !K().c()) {
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
            q60Var.n(2, this.Z);
        }
        if ((this.Y & 2) != 0) {
            q60Var.n(3, this.y0);
        }
        if ((this.Y & 4) != 0) {
            q60Var.n(6, this.z0);
        }
        if ((this.Y & 8) != 0) {
            q60Var.u(7, K());
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
            if (!(obj instanceof ip0)) {
                return super.equals(obj);
            }
            ip0 ip0Var = (ip0) obj;
            int i = this.Y;
            if (((i & 1) != 0) != ((ip0Var.Y & 1) != 0) || (((i & 1) != 0 && this.Z != ip0Var.Z) || L() != ip0Var.L() || ((L() && this.y0 != ip0Var.y0) || N() != ip0Var.N() || ((N() && this.z0 != ip0Var.z0) || O() != ip0Var.O() || ((O() && !K().equals(ip0Var.K())) || !this.B0.equals(ip0Var.B0) || !this.z.equals(ip0Var.z) || !this.X.f().equals(ip0Var.X.f())))))) {
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
        int iB = (this.Y & 1) != 0 ? q60.b(2) : 0;
        if ((2 & this.Y) != 0) {
            iB += q60.b(3);
        }
        if ((this.Y & 4) != 0) {
            iB += q60.b(6);
        }
        if ((this.Y & 8) != 0) {
            iB += q60.f(7, K());
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
        int iHashCode = vs0.m1.hashCode() + 779;
        if ((this.Y & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + i12.a(this.Z);
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + i12.a(this.y0);
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + i12.a(this.z0);
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 7, 53) + K().hashCode();
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
        hp0 hp0Var = new hp0(ue1Var);
        hp0Var.C0 = Collections.EMPTY_LIST;
        return hp0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.n1;
        vn1Var.a(ip0.class, hp0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return D0;
    }
}
