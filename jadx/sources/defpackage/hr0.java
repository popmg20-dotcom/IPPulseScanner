package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hr0 extends yn1 {
    public static final hr0 L0;
    public static final fr0 M0;
    public x02 A0;
    public g92 B0;
    public List C0;
    public List D0;
    public List E0;
    public List F0;
    public lr0 G0;
    public ns0 H0;
    public volatile Serializable I0;
    public int J0;
    public byte K0;
    public int X;
    public volatile Serializable Y;
    public volatile Object Z;
    public g92 y0;
    public x02 z0;

    static {
        ao3.a(5, "FileDescriptorProto");
        hr0 hr0Var = new hr0();
        hr0Var.Y = "";
        hr0Var.Z = "";
        g92 g92Var = g92.z;
        hr0Var.y0 = g92Var;
        x02 x02Var = x02.X;
        hr0Var.z0 = x02Var;
        hr0Var.A0 = x02Var;
        hr0Var.B0 = g92Var;
        hr0Var.I0 = "";
        hr0Var.J0 = 0;
        hr0Var.K0 = (byte) -1;
        hr0Var.Y = "";
        hr0Var.Z = "";
        hr0Var.y0 = g92Var;
        hr0Var.z0 = x02Var;
        hr0Var.A0 = x02Var;
        hr0Var.B0 = g92Var;
        List list = Collections.EMPTY_LIST;
        hr0Var.C0 = list;
        hr0Var.D0 = list;
        hr0Var.E0 = list;
        hr0Var.F0 = list;
        hr0Var.I0 = "";
        hr0Var.J0 = 0;
        L0 = hr0Var;
        M0 = new fr0();
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

    public final lr0 J() {
        lr0 lr0Var = this.G0;
        return lr0Var == null ? lr0.T0 : lr0Var;
    }

    public final String K() {
        Object obj = this.Z;
        if (obj instanceof String) {
            return (String) obj;
        }
        zt ztVar = (zt) obj;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.Z = strI;
        }
        return strI;
    }

    public final ns0 L() {
        ns0 ns0Var = this.H0;
        return ns0Var == null ? ns0.y0 : ns0Var;
    }

    public final String N() {
        Serializable serializable = this.I0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.I0 = strI;
        }
        return strI;
    }

    public final boolean O() {
        return (this.X & 32) != 0;
    }

    public final boolean P() {
        return (this.X & 4) != 0;
    }

    public final boolean Q() {
        return (this.X & 2) != 0;
    }

    public final boolean R() {
        return (this.X & 8) != 0;
    }

    public final boolean S() {
        return (this.X & 16) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public final gr0 u() {
        if (this == L0) {
            return new gr0();
        }
        gr0 gr0Var = new gr0();
        gr0Var.Y(this);
        return gr0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return L0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.K0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.C0.size(); i++) {
            if (!((yo0) this.C0.get(i)).c()) {
                this.K0 = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < this.D0.size(); i2++) {
            if (!((fp0) this.D0.get(i2)).c()) {
                this.K0 = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.E0.size(); i3++) {
            if (!((es0) this.E0.get(i3)).c()) {
                this.K0 = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < this.F0.size(); i4++) {
            if (!((rq0) this.F0.get(i4)).c()) {
                this.K0 = (byte) 0;
                return false;
            }
        }
        if (P() && !J().c()) {
            this.K0 = (byte) 0;
            return false;
        }
        if (!R() || L().c()) {
            this.K0 = (byte) 1;
            return true;
        }
        this.K0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            yn1.G(q60Var, 1, this.Y);
        }
        if ((this.X & 2) != 0) {
            yn1.G(q60Var, 2, this.Z);
        }
        for (int i = 0; i < this.y0.f.size(); i++) {
            yn1.G(q60Var, 3, this.y0.f.get(i));
        }
        for (int i2 = 0; i2 < this.C0.size(); i2++) {
            q60Var.u(4, (nl2) this.C0.get(i2));
        }
        for (int i3 = 0; i3 < this.D0.size(); i3++) {
            q60Var.u(5, (nl2) this.D0.get(i3));
        }
        for (int i4 = 0; i4 < this.E0.size(); i4++) {
            q60Var.u(6, (nl2) this.E0.get(i4));
        }
        for (int i5 = 0; i5 < this.F0.size(); i5++) {
            q60Var.u(7, (nl2) this.F0.get(i5));
        }
        if ((this.X & 4) != 0) {
            q60Var.u(8, J());
        }
        if ((this.X & 8) != 0) {
            q60Var.u(9, L());
        }
        int i6 = 0;
        while (true) {
            x02 x02Var = this.z0;
            if (i6 >= x02Var.z) {
                break;
            }
            q60Var.s(10, x02Var.f(i6));
            i6++;
        }
        int i7 = 0;
        while (true) {
            x02 x02Var2 = this.A0;
            if (i7 >= x02Var2.z) {
                break;
            }
            q60Var.s(11, x02Var2.f(i7));
            i7++;
        }
        if ((this.X & 16) != 0) {
            yn1.G(q60Var, 12, this.I0);
        }
        if ((this.X & 32) != 0) {
            q60Var.s(14, this.J0);
        }
        for (int i8 = 0; i8 < this.B0.f.size(); i8++) {
            yn1.G(q60Var, 15, this.B0.f.get(i8));
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof hr0)) {
                return super.equals(obj);
            }
            hr0 hr0Var = (hr0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((hr0Var.X & 1) != 0) || (((i & 1) != 0 && !H().equals(hr0Var.H())) || Q() != hr0Var.Q() || ((Q() && !K().equals(hr0Var.K())) || !this.y0.equals(hr0Var.y0) || !this.z0.equals(hr0Var.z0) || !this.A0.equals(hr0Var.A0) || !this.B0.equals(hr0Var.B0) || !this.C0.equals(hr0Var.C0) || !this.D0.equals(hr0Var.D0) || !this.E0.equals(hr0Var.E0) || !this.F0.equals(hr0Var.F0) || P() != hr0Var.P() || ((P() && !J().equals(hr0Var.J())) || R() != hr0Var.R() || ((R() && !L().equals(hr0Var.L())) || S() != hr0Var.S() || ((S() && !N().equals(hr0Var.N())) || O() != hr0Var.O() || ((O() && this.J0 != hr0Var.J0) || !this.z.equals(hr0Var.z)))))))) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.nl2
    public final int h() {
        g92 g92Var;
        int i;
        int i2;
        int i3 = this.f;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        int iV = (this.X & 1) != 0 ? yn1.v(1, this.Y) : 0;
        if ((this.X & 2) != 0) {
            iV += yn1.v(2, this.Z);
        }
        int i5 = 0;
        int iW = 0;
        while (true) {
            int size = this.y0.f.size();
            g92Var = this.y0;
            if (i5 >= size) {
                break;
            }
            iW += yn1.w(g92Var.f.get(i5));
            i5++;
        }
        int size2 = g92Var.f.size() + iV + iW;
        for (int i6 = 0; i6 < this.C0.size(); i6++) {
            size2 += q60.f(4, (nl2) this.C0.get(i6));
        }
        for (int i7 = 0; i7 < this.D0.size(); i7++) {
            size2 += q60.f(5, (nl2) this.D0.get(i7));
        }
        for (int i8 = 0; i8 < this.E0.size(); i8++) {
            size2 += q60.f(6, (nl2) this.E0.get(i8));
        }
        for (int i9 = 0; i9 < this.F0.size(); i9++) {
            size2 += q60.f(7, (nl2) this.F0.get(i9));
        }
        if ((this.X & 4) != 0) {
            size2 += q60.f(8, J());
        }
        if ((this.X & 8) != 0) {
            size2 += q60.f(9, L());
        }
        int i10 = 0;
        int iL = 0;
        while (true) {
            i = this.z0.z;
            if (i10 >= i) {
                break;
            }
            iL += q60.l(r4.f(i10));
            i10++;
        }
        int i11 = size2 + iL + i;
        int i12 = 0;
        int iL2 = 0;
        while (true) {
            i2 = this.A0.z;
            if (i12 >= i2) {
                break;
            }
            iL2 += q60.l(r4.f(i12));
            i12++;
        }
        int iD = i11 + iL2 + i2;
        if ((this.X & 16) != 0) {
            iD += yn1.v(12, this.I0);
        }
        if ((this.X & 32) != 0) {
            iD += q60.d(14, this.J0);
        }
        int iW2 = 0;
        while (true) {
            int size3 = this.B0.f.size();
            g92 g92Var2 = this.B0;
            if (i4 >= size3) {
                int iH = this.z.h() + g92Var2.f.size() + iD + iW2;
                this.f = iH;
                return iH;
            }
            iW2 += yn1.w(g92Var2.f.get(i4));
            i4++;
        }
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = vs0.A0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + H().hashCode();
        }
        if (Q()) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + K().hashCode();
        }
        if (this.y0.f.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + this.y0.hashCode();
        }
        x02 x02Var = this.z0;
        if (x02Var.z > 0) {
            iHashCode = fw.p(iHashCode, 37, 10, 53) + x02Var.hashCode();
        }
        x02 x02Var2 = this.A0;
        if (x02Var2.z > 0) {
            iHashCode = fw.p(iHashCode, 37, 11, 53) + x02Var2.hashCode();
        }
        if (this.B0.f.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 15, 53) + this.B0.hashCode();
        }
        if (this.C0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + this.C0.hashCode();
        }
        if (this.D0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + this.D0.hashCode();
        }
        if (this.E0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + this.E0.hashCode();
        }
        if (this.F0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 7, 53) + this.F0.hashCode();
        }
        if (P()) {
            iHashCode = fw.p(iHashCode, 37, 8, 53) + J().hashCode();
        }
        if (R()) {
            iHashCode = fw.p(iHashCode, 37, 9, 53) + L().hashCode();
        }
        if (S()) {
            iHashCode = fw.p(iHashCode, 37, 12, 53) + N().hashCode();
        }
        if (O()) {
            iHashCode = fw.p(iHashCode, 37, 14, 53) + this.J0;
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return L0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return M0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return L0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        gr0 gr0Var = new gr0(ue1Var);
        gr0Var.Y = "";
        gr0Var.Z = "";
        g92 g92Var = g92.z;
        gr0Var.y0 = g92Var;
        x02 x02Var = x02.X;
        gr0Var.z0 = x02Var;
        gr0Var.A0 = x02Var;
        gr0Var.B0 = g92Var;
        List list = Collections.EMPTY_LIST;
        gr0Var.C0 = list;
        gr0Var.D0 = list;
        gr0Var.E0 = list;
        gr0Var.F0 = list;
        gr0Var.K0 = "";
        gr0Var.L0 = 0;
        return gr0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.B0;
        vn1Var.a(hr0.class, gr0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return L0;
    }
}
