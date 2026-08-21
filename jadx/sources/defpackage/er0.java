package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class er0 extends nn1 {
    public static final er0 M0;
    public static final sq0 N0;
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public int F0;
    public x02 G0;
    public List H0;
    public gq0 I0;
    public ar0 J0;
    public List K0;
    public byte L0;
    public int Y;
    public int Z;
    public boolean y0;
    public int z0;

    static {
        ao3.a(5, "FieldOptions");
        er0 er0Var = new er0();
        er0Var.Z = 0;
        er0Var.y0 = false;
        er0Var.z0 = 0;
        er0Var.A0 = false;
        er0Var.B0 = false;
        er0Var.C0 = false;
        er0Var.D0 = false;
        er0Var.E0 = false;
        er0Var.F0 = 0;
        x02 x02Var = x02.X;
        er0Var.L0 = (byte) -1;
        er0Var.Z = 0;
        er0Var.z0 = 0;
        er0Var.F0 = 0;
        er0Var.G0 = x02Var;
        List list = Collections.EMPTY_LIST;
        er0Var.H0 = list;
        er0Var.K0 = list;
        M0 = er0Var;
        N0 = new sq0();
    }

    public final ar0 K() {
        ar0 ar0Var = this.J0;
        return ar0Var == null ? ar0.B0 : ar0Var;
    }

    public final gq0 L() {
        gq0 gq0Var = this.I0;
        return gq0Var == null ? gq0.G0 : gq0Var;
    }

    public final boolean N() {
        return (this.Y & 128) != 0;
    }

    public final boolean O() {
        return (this.Y & 32) != 0;
    }

    public final boolean P() {
        return (this.Y & 1024) != 0;
    }

    public final boolean Q() {
        return (this.Y & 512) != 0;
    }

    public final boolean R() {
        return (this.Y & 4) != 0;
    }

    public final boolean S() {
        return (this.Y & 8) != 0;
    }

    public final boolean T() {
        return (this.Y & 2) != 0;
    }

    public final boolean U() {
        return (this.Y & 256) != 0;
    }

    public final boolean V() {
        return (this.Y & 16) != 0;
    }

    public final boolean W() {
        return (this.Y & 64) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final tq0 u() {
        if (this == M0) {
            return new tq0();
        }
        tq0 tq0Var = new tq0();
        tq0Var.c0(this);
        return tq0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return M0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.L0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (Q() && !L().c()) {
            this.L0 = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.K0.size(); i++) {
            if (!((us0) this.K0.get(i)).c()) {
                this.L0 = (byte) 0;
                return false;
            }
        }
        if (this.X.j()) {
            this.L0 = (byte) 1;
            return true;
        }
        this.L0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        mn1 mn1VarJ = J();
        if ((this.Y & 1) != 0) {
            q60Var.s(1, this.Z);
        }
        if ((this.Y & 2) != 0) {
            q60Var.n(2, this.y0);
        }
        if ((this.Y & 32) != 0) {
            q60Var.n(3, this.C0);
        }
        if ((this.Y & 8) != 0) {
            q60Var.n(5, this.A0);
        }
        if ((this.Y & 4) != 0) {
            q60Var.s(6, this.z0);
        }
        if ((this.Y & 64) != 0) {
            q60Var.n(10, this.D0);
        }
        if ((this.Y & 16) != 0) {
            q60Var.n(15, this.B0);
        }
        if ((this.Y & 128) != 0) {
            q60Var.n(16, this.E0);
        }
        if ((this.Y & 256) != 0) {
            q60Var.s(17, this.F0);
        }
        int i = 0;
        while (true) {
            x02 x02Var = this.G0;
            if (i >= x02Var.z) {
                break;
            }
            q60Var.s(19, x02Var.f(i));
            i++;
        }
        for (int i2 = 0; i2 < this.H0.size(); i2++) {
            q60Var.u(20, (nl2) this.H0.get(i2));
        }
        if ((this.Y & 512) != 0) {
            q60Var.u(21, L());
        }
        if ((this.Y & 1024) != 0) {
            q60Var.u(22, K());
        }
        for (int i3 = 0; i3 < this.K0.size(); i3++) {
            q60Var.u(999, (nl2) this.K0.get(i3));
        }
        mn1VarJ.k(536870912, q60Var);
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof er0)) {
                return super.equals(obj);
            }
            er0 er0Var = (er0) obj;
            int i = this.Y;
            if (((i & 1) != 0) != ((er0Var.Y & 1) != 0) || (((i & 1) != 0 && this.Z != er0Var.Z) || T() != er0Var.T() || ((T() && this.y0 != er0Var.y0) || R() != er0Var.R() || ((R() && this.z0 != er0Var.z0) || S() != er0Var.S() || ((S() && this.A0 != er0Var.A0) || V() != er0Var.V() || ((V() && this.B0 != er0Var.B0) || O() != er0Var.O() || ((O() && this.C0 != er0Var.C0) || W() != er0Var.W() || ((W() && this.D0 != er0Var.D0) || N() != er0Var.N() || ((N() && this.E0 != er0Var.E0) || U() != er0Var.U() || ((U() && this.F0 != er0Var.F0) || !this.G0.equals(er0Var.G0) || !this.H0.equals(er0Var.H0) || Q() != er0Var.Q() || ((Q() && !L().equals(er0Var.L())) || P() != er0Var.P() || ((P() && !K().equals(er0Var.K())) || !this.K0.equals(er0Var.K0) || !this.z.equals(er0Var.z) || !this.X.f().equals(er0Var.X.f()))))))))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.nl2
    public final int h() {
        int i;
        int i2 = this.f;
        if (i2 != -1) {
            return i2;
        }
        int iD = (this.Y & 1) != 0 ? q60.d(1, this.Z) : 0;
        if ((this.Y & 2) != 0) {
            iD += q60.b(2);
        }
        if ((this.Y & 32) != 0) {
            iD += q60.b(3);
        }
        if ((this.Y & 8) != 0) {
            iD += q60.b(5);
        }
        if ((this.Y & 4) != 0) {
            iD += q60.d(6, this.z0);
        }
        if ((this.Y & 64) != 0) {
            iD += q60.b(10);
        }
        if ((this.Y & 16) != 0) {
            iD += q60.b(15);
        }
        if ((this.Y & 128) != 0) {
            iD += q60.b(16);
        }
        if ((this.Y & 256) != 0) {
            iD += q60.d(17, this.F0);
        }
        int i3 = 0;
        int iL = 0;
        while (true) {
            i = this.G0.z;
            if (i3 >= i) {
                break;
            }
            iL += q60.l(r5.f(i3));
            i3++;
        }
        int iF = (i * 2) + iD + iL;
        for (int i4 = 0; i4 < this.H0.size(); i4++) {
            iF += q60.f(20, (nl2) this.H0.get(i4));
        }
        if ((this.Y & 512) != 0) {
            iF += q60.f(21, L());
        }
        if ((this.Y & 1024) != 0) {
            iF += q60.f(22, K());
        }
        for (int i5 = 0; i5 < this.K0.size(); i5++) {
            iF += q60.f(999, (nl2) this.K0.get(i5));
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
        int iHashCode = vs0.e1.hashCode() + 779;
        if ((this.Y & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + this.Z;
        }
        if (T()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + i12.a(this.y0);
        }
        if (R()) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + this.z0;
        }
        if (S()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + i12.a(this.A0);
        }
        if (V()) {
            iHashCode = fw.p(iHashCode, 37, 15, 53) + i12.a(this.B0);
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + i12.a(this.C0);
        }
        if (W()) {
            iHashCode = fw.p(iHashCode, 37, 10, 53) + i12.a(this.D0);
        }
        if (N()) {
            iHashCode = fw.p(iHashCode, 37, 16, 53) + i12.a(this.E0);
        }
        if (U()) {
            iHashCode = fw.p(iHashCode, 37, 17, 53) + this.F0;
        }
        x02 x02Var = this.G0;
        if (x02Var.z > 0) {
            iHashCode = fw.p(iHashCode, 37, 19, 53) + x02Var.hashCode();
        }
        if (this.H0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 20, 53) + this.H0.hashCode();
        }
        if (Q()) {
            iHashCode = fw.p(iHashCode, 37, 21, 53) + L().hashCode();
        }
        if (P()) {
            iHashCode = fw.p(iHashCode, 37, 22, 53) + K().hashCode();
        }
        if (this.K0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 999, 53) + this.K0.hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (c1.q(iHashCode, this.X.f()) * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return M0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return N0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return M0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        tq0 tq0Var = new tq0(ue1Var);
        tq0Var.Z = 0;
        tq0Var.z0 = 0;
        tq0Var.F0 = 0;
        tq0Var.G0 = x02.X;
        List list = Collections.EMPTY_LIST;
        tq0Var.H0 = list;
        tq0Var.M0 = list;
        return tq0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.f1;
        vn1Var.a(er0.class, tq0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return M0;
    }
}
