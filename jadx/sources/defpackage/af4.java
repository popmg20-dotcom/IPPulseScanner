package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class af4 extends yn1 {
    public static final af4 U0;
    public static final we4 V0;
    public volatile String A0;
    public int B0;
    public int C0;
    public int D0;
    public volatile String E0;
    public g92 F0;
    public int G0;
    public ow3 H0;
    public volatile String I0;
    public List J0;
    public List K0;
    public og2 L0;
    public og2 M0;
    public List N0;
    public List O0;
    public List P0;
    public int Q0;
    public boolean R0;
    public p14 S0;
    public byte T0;
    public int X;
    public int Y;
    public int Z;
    public volatile String y0;
    public volatile String z0;

    static {
        ao3.a(4, "Tombstone");
        af4 af4Var = new af4();
        af4Var.Y = 0;
        af4Var.Z = 0;
        af4Var.y0 = "";
        af4Var.z0 = "";
        af4Var.A0 = "";
        af4Var.B0 = 0;
        af4Var.C0 = 0;
        af4Var.D0 = 0;
        af4Var.E0 = "";
        g92 g92Var = g92.z;
        af4Var.F0 = g92Var;
        af4Var.G0 = 0;
        af4Var.I0 = "";
        af4Var.Q0 = 0;
        af4Var.R0 = false;
        af4Var.T0 = (byte) -1;
        af4Var.Y = 0;
        af4Var.Z = 0;
        af4Var.y0 = "";
        af4Var.z0 = "";
        af4Var.A0 = "";
        af4Var.E0 = "";
        af4Var.F0 = g92Var;
        af4Var.I0 = "";
        List list = Collections.EMPTY_LIST;
        af4Var.J0 = list;
        af4Var.K0 = list;
        af4Var.N0 = list;
        af4Var.O0 = list;
        af4Var.P0 = list;
        U0 = af4Var;
        V0 = new we4();
    }

    @Override // defpackage.yn1
    public final ye A(int i) {
        if (i == 16) {
            return S();
        }
        if (i == 25) {
            return R();
        }
        zo2.w(dw2.A(i, "Invalid map field number: "));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.I0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.I0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String J() {
        String str = this.y0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.y0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String K() {
        String str = this.z0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.z0 = strI;
        return strI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String L() {
        String str = this.E0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.E0 = strI;
        return strI;
    }

    public final ow3 N() {
        ow3 ow3Var = this.H0;
        return ow3Var == null ? ow3.H0 : ow3Var;
    }

    public final p14 O() {
        p14 p14Var = this.S0;
        return p14Var == null ? p14.y0 : p14Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String P() {
        String str = this.A0;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.A0 = strI;
        return strI;
    }

    public final boolean Q() {
        return (this.X & 2) != 0;
    }

    public final og2 R() {
        og2 og2Var = this.M0;
        return og2Var == null ? new og2(ye4.a, Collections.EMPTY_MAP) : og2Var;
    }

    public final og2 S() {
        og2 og2Var = this.L0;
        return og2Var == null ? new og2(ze4.a, Collections.EMPTY_MAP) : og2Var;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public final xe4 u() {
        if (this == U0) {
            return new xe4();
        }
        xe4 xe4Var = new xe4();
        xe4Var.Z(this);
        return xe4Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return U0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.T0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.T0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if (this.Y != sd.ARM32.a()) {
            q60Var.s(1, this.Y);
        }
        if (!yn1.C(this.y0)) {
            yn1.G(q60Var, 2, this.y0);
        }
        if (!yn1.C(this.z0)) {
            yn1.G(q60Var, 3, this.z0);
        }
        if (!yn1.C(this.A0)) {
            yn1.G(q60Var, 4, this.A0);
        }
        int i = this.B0;
        if (i != 0) {
            q60Var.y(5, i);
        }
        int i2 = this.C0;
        if (i2 != 0) {
            q60Var.y(6, i2);
        }
        int i3 = this.D0;
        if (i3 != 0) {
            q60Var.y(7, i3);
        }
        if (!yn1.C(this.E0)) {
            yn1.G(q60Var, 8, this.E0);
        }
        for (int i4 = 0; i4 < this.F0.f.size(); i4++) {
            yn1.G(q60Var, 9, this.F0.f.get(i4));
        }
        if ((1 & this.X) != 0) {
            q60Var.u(10, N());
        }
        if (!yn1.C(this.I0)) {
            yn1.G(q60Var, 14, this.I0);
        }
        for (int i5 = 0; i5 < this.K0.size(); i5++) {
            q60Var.u(15, (nl2) this.K0.get(i5));
        }
        yn1.E(q60Var, S(), ze4.a, 16);
        for (int i6 = 0; i6 < this.N0.size(); i6++) {
            q60Var.u(17, (nl2) this.N0.get(i6));
        }
        for (int i7 = 0; i7 < this.O0.size(); i7++) {
            q60Var.u(18, (nl2) this.O0.get(i7));
        }
        for (int i8 = 0; i8 < this.P0.size(); i8++) {
            q60Var.u(19, (nl2) this.P0.get(i8));
        }
        int i9 = this.G0;
        if (i9 != 0) {
            q60Var.y(20, i9);
        }
        for (int i10 = 0; i10 < this.J0.size(); i10++) {
            q60Var.u(21, (nl2) this.J0.get(i10));
        }
        int i11 = this.Q0;
        if (i11 != 0) {
            q60Var.y(22, i11);
        }
        boolean z = this.R0;
        if (z) {
            q60Var.n(23, z);
        }
        if (this.Z != sd.ARM32.a()) {
            q60Var.s(24, this.Z);
        }
        yn1.E(q60Var, R(), ye4.a, 25);
        if ((this.X & 2) != 0) {
            q60Var.u(26, O());
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof af4)) {
                return super.equals(obj);
            }
            af4 af4Var = (af4) obj;
            if (this.Y == af4Var.Y && this.Z == af4Var.Z && J().equals(af4Var.J()) && K().equals(af4Var.K()) && P().equals(af4Var.P()) && this.B0 == af4Var.B0 && this.C0 == af4Var.C0 && this.D0 == af4Var.D0 && L().equals(af4Var.L()) && this.F0.equals(af4Var.F0) && this.G0 == af4Var.G0) {
                int i = this.X;
                if (((i & 1) != 0) == ((af4Var.X & 1) != 0) && (((i & 1) == 0 || N().equals(af4Var.N())) && H().equals(af4Var.H()) && this.J0.equals(af4Var.J0) && this.K0.equals(af4Var.K0) && S().equals(af4Var.S()) && R().equals(af4Var.R()) && this.N0.equals(af4Var.N0) && this.O0.equals(af4Var.O0) && this.P0.equals(af4Var.P0) && this.Q0 == af4Var.Q0 && this.R0 == af4Var.R0 && Q() == af4Var.Q() && ((!Q() || O().equals(af4Var.O())) && this.z.equals(af4Var.z)))) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.nl2
    public final int h() {
        g92 g92Var;
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iD = this.Y != sd.ARM32.a() ? q60.d(1, this.Y) : 0;
        if (!yn1.C(this.y0)) {
            iD += yn1.v(2, this.y0);
        }
        if (!yn1.C(this.z0)) {
            iD += yn1.v(3, this.z0);
        }
        if (!yn1.C(this.A0)) {
            iD += yn1.v(4, this.A0);
        }
        int i2 = this.B0;
        if (i2 != 0) {
            iD += q60.i(5, i2);
        }
        int i3 = this.C0;
        if (i3 != 0) {
            iD += q60.i(6, i3);
        }
        int i4 = this.D0;
        if (i4 != 0) {
            iD += q60.i(7, i4);
        }
        if (!yn1.C(this.E0)) {
            iD += yn1.v(8, this.E0);
        }
        int i5 = 0;
        int iW = 0;
        while (true) {
            int size = this.F0.f.size();
            g92Var = this.F0;
            if (i5 >= size) {
                break;
            }
            iW += yn1.w(g92Var.f.get(i5));
            i5++;
        }
        int size2 = g92Var.f.size() + iD + iW;
        if ((this.X & 1) != 0) {
            size2 += q60.f(10, N());
        }
        if (!yn1.C(this.I0)) {
            size2 += yn1.v(14, this.I0);
        }
        for (int i6 = 0; i6 < this.K0.size(); i6++) {
            size2 += q60.f(15, (nl2) this.K0.get(i6));
        }
        for (Map.Entry entry : S().a0().entrySet()) {
            gg2 gg2VarK = ze4.a.k();
            gg2VarK.f = (Integer) entry.getKey();
            gg2VarK.A = true;
            gg2VarK.z = (ld4) entry.getValue();
            gg2VarK.X = true;
            size2 += q60.f(16, gg2VarK.build());
        }
        for (int i7 = 0; i7 < this.N0.size(); i7++) {
            size2 += q60.f(17, (nl2) this.N0.get(i7));
        }
        for (int i8 = 0; i8 < this.O0.size(); i8++) {
            size2 += q60.f(18, (nl2) this.O0.get(i8));
        }
        for (int i9 = 0; i9 < this.P0.size(); i9++) {
            size2 += q60.f(19, (nl2) this.P0.get(i9));
        }
        int i10 = this.G0;
        if (i10 != 0) {
            size2 += q60.i(20, i10);
        }
        for (int i11 = 0; i11 < this.J0.size(); i11++) {
            size2 += q60.f(21, (nl2) this.J0.get(i11));
        }
        int i12 = this.Q0;
        if (i12 != 0) {
            size2 += q60.i(22, i12);
        }
        if (this.R0) {
            size2 += q60.b(23);
        }
        if (this.Z != sd.ARM32.a()) {
            size2 += q60.d(24, this.Z);
        }
        for (Map.Entry entry2 : R().a0().entrySet()) {
            gg2 gg2VarK2 = ye4.a.k();
            gg2VarK2.f = (Integer) entry2.getKey();
            gg2VarK2.A = true;
            gg2VarK2.z = (ld4) entry2.getValue();
            gg2VarK2.X = true;
            size2 += q60.f(25, gg2VarK2.build());
        }
        if ((this.X & 2) != 0) {
            size2 += q60.f(26, O());
        }
        int iH = this.z.h() + size2;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = L().hashCode() + ha0.i(ha0.i(ha0.i((((P().hashCode() + ((((K().hashCode() + ((((J().hashCode() + ha0.i(ha0.i(fw.q(bf4.G0, 779, 37, 1, 53), this.Y, 37, 24, 53), this.Z, 37, 2, 53)) * 37) + 3) * 53)) * 37) + 4) * 53)) * 37) + 5) * 53, this.B0, 37, 6, 53), this.C0, 37, 7, 53), this.D0, 37, 8, 53);
        if (this.F0.f.size() > 0) {
            iHashCode = this.F0.hashCode() + fw.p(iHashCode, 37, 9, 53);
        }
        int iP = fw.p(iHashCode, 37, 20, 53) + this.G0;
        if ((this.X & 1) != 0) {
            iP = fw.p(iP, 37, 10, 53) + N().hashCode();
        }
        int iHashCode2 = H().hashCode() + fw.p(iP, 37, 14, 53);
        if (this.J0.size() > 0) {
            iHashCode2 = this.J0.hashCode() + fw.p(iHashCode2, 37, 21, 53);
        }
        if (this.K0.size() > 0) {
            iHashCode2 = this.K0.hashCode() + fw.p(iHashCode2, 37, 15, 53);
        }
        if (!S().a0().isEmpty()) {
            iHashCode2 = S().hashCode() + fw.p(iHashCode2, 37, 16, 53);
        }
        if (!R().a0().isEmpty()) {
            iHashCode2 = R().hashCode() + fw.p(iHashCode2, 37, 25, 53);
        }
        if (this.N0.size() > 0) {
            iHashCode2 = this.N0.hashCode() + fw.p(iHashCode2, 37, 17, 53);
        }
        if (this.O0.size() > 0) {
            iHashCode2 = this.O0.hashCode() + fw.p(iHashCode2, 37, 18, 53);
        }
        if (this.P0.size() > 0) {
            iHashCode2 = this.P0.hashCode() + fw.p(iHashCode2, 37, 19, 53);
        }
        int iA = i12.a(this.R0) + ha0.i(fw.p(iHashCode2, 37, 22, 53), this.Q0, 37, 23, 53);
        if (Q()) {
            iA = O().hashCode() + fw.p(iA, 37, 26, 53);
        }
        int iHashCode3 = this.z.hashCode() + (iA * 29);
        this.b = iHashCode3;
        return iHashCode3;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return U0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return V0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return U0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        xe4 xe4Var = new xe4(ue1Var);
        xe4Var.Y = 0;
        xe4Var.Z = 0;
        xe4Var.y0 = "";
        xe4Var.z0 = "";
        xe4Var.A0 = "";
        xe4Var.E0 = "";
        xe4Var.F0 = g92.z;
        xe4Var.J0 = "";
        List list = Collections.EMPTY_LIST;
        xe4Var.K0 = list;
        xe4Var.L0 = list;
        xe4Var.O0 = list;
        xe4Var.P0 = list;
        xe4Var.Q0 = list;
        return xe4Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.H0;
        vn1Var.a(af4.class, xe4.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return U0;
    }
}
