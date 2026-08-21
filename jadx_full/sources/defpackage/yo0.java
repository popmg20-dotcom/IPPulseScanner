package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yo0 extends yn1 {
    public static final yo0 I0;
    public static final qo0 J0;
    public List A0;
    public List B0;
    public List C0;
    public or0 D0;
    public List E0;
    public g92 F0;
    public int G0;
    public byte H0;
    public int X;
    public volatile Serializable Y;
    public List Z;
    public List y0;
    public List z0;

    static {
        ao3.a(5, "DescriptorProto");
        yo0 yo0Var = new yo0();
        yo0Var.Y = "";
        g92 g92Var = g92.z;
        yo0Var.F0 = g92Var;
        yo0Var.G0 = 0;
        yo0Var.H0 = (byte) -1;
        yo0Var.Y = "";
        List list = Collections.EMPTY_LIST;
        yo0Var.Z = list;
        yo0Var.y0 = list;
        yo0Var.z0 = list;
        yo0Var.A0 = list;
        yo0Var.B0 = list;
        yo0Var.C0 = list;
        yo0Var.E0 = list;
        yo0Var.F0 = g92Var;
        yo0Var.G0 = 0;
        I0 = yo0Var;
        J0 = new qo0();
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

    public final or0 J() {
        or0 or0Var = this.D0;
        return or0Var == null ? or0.F0 : or0Var;
    }

    public final boolean K() {
        return (this.X & 2) != 0;
    }

    public final boolean L() {
        return (this.X & 4) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final ro0 u() {
        if (this == I0) {
            return new ro0();
        }
        ro0 ro0Var = new ro0();
        ro0Var.W(this);
        return ro0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return I0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.H0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.Z.size(); i++) {
            if (!((rq0) this.Z.get(i)).c()) {
                this.H0 = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < this.y0.size(); i2++) {
            if (!((rq0) this.y0.get(i2)).c()) {
                this.H0 = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.z0.size(); i3++) {
            if (!((yo0) this.z0.get(i3)).c()) {
                this.H0 = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < this.A0.size(); i4++) {
            if (!((fp0) this.A0.get(i4)).c()) {
                this.H0 = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < this.B0.size(); i5++) {
            if (!((uo0) this.B0.get(i5)).c()) {
                this.H0 = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.C0.size(); i6++) {
            if (!((yr0) this.C0.get(i6)).c()) {
                this.H0 = (byte) 0;
                return false;
            }
        }
        if (!K() || J().c()) {
            this.H0 = (byte) 1;
            return true;
        }
        this.H0 = (byte) 0;
        return false;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        if ((this.X & 1) != 0) {
            yn1.G(q60Var, 1, this.Y);
        }
        for (int i = 0; i < this.Z.size(); i++) {
            q60Var.u(2, (nl2) this.Z.get(i));
        }
        for (int i2 = 0; i2 < this.z0.size(); i2++) {
            q60Var.u(3, (nl2) this.z0.get(i2));
        }
        for (int i3 = 0; i3 < this.A0.size(); i3++) {
            q60Var.u(4, (nl2) this.A0.get(i3));
        }
        for (int i4 = 0; i4 < this.B0.size(); i4++) {
            q60Var.u(5, (nl2) this.B0.get(i4));
        }
        for (int i5 = 0; i5 < this.y0.size(); i5++) {
            q60Var.u(6, (nl2) this.y0.get(i5));
        }
        if ((this.X & 2) != 0) {
            q60Var.u(7, J());
        }
        for (int i6 = 0; i6 < this.C0.size(); i6++) {
            q60Var.u(8, (nl2) this.C0.get(i6));
        }
        for (int i7 = 0; i7 < this.E0.size(); i7++) {
            q60Var.u(9, (nl2) this.E0.get(i7));
        }
        for (int i8 = 0; i8 < this.F0.f.size(); i8++) {
            yn1.G(q60Var, 10, this.F0.f.get(i8));
        }
        if ((this.X & 4) != 0) {
            q60Var.s(11, this.G0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof yo0)) {
                return super.equals(obj);
            }
            yo0 yo0Var = (yo0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((yo0Var.X & 1) != 0) || (((i & 1) != 0 && !H().equals(yo0Var.H())) || !this.Z.equals(yo0Var.Z) || !this.y0.equals(yo0Var.y0) || !this.z0.equals(yo0Var.z0) || !this.A0.equals(yo0Var.A0) || !this.B0.equals(yo0Var.B0) || !this.C0.equals(yo0Var.C0) || K() != yo0Var.K() || ((K() && !J().equals(yo0Var.J())) || !this.E0.equals(yo0Var.E0) || !this.F0.equals(yo0Var.F0) || L() != yo0Var.L() || ((L() && this.G0 != yo0Var.G0) || !this.z.equals(yo0Var.z))))) {
                return false;
            }
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
        int i2 = 0;
        int iV = (this.X & 1) != 0 ? yn1.v(1, this.Y) : 0;
        for (int i3 = 0; i3 < this.Z.size(); i3++) {
            iV += q60.f(2, (nl2) this.Z.get(i3));
        }
        for (int i4 = 0; i4 < this.z0.size(); i4++) {
            iV += q60.f(3, (nl2) this.z0.get(i4));
        }
        for (int i5 = 0; i5 < this.A0.size(); i5++) {
            iV += q60.f(4, (nl2) this.A0.get(i5));
        }
        for (int i6 = 0; i6 < this.B0.size(); i6++) {
            iV += q60.f(5, (nl2) this.B0.get(i6));
        }
        for (int i7 = 0; i7 < this.y0.size(); i7++) {
            iV += q60.f(6, (nl2) this.y0.get(i7));
        }
        if ((this.X & 2) != 0) {
            iV += q60.f(7, J());
        }
        for (int i8 = 0; i8 < this.C0.size(); i8++) {
            iV += q60.f(8, (nl2) this.C0.get(i8));
        }
        for (int i9 = 0; i9 < this.E0.size(); i9++) {
            iV += q60.f(9, (nl2) this.E0.get(i9));
        }
        int iW = 0;
        while (true) {
            int size = this.F0.f.size();
            g92Var = this.F0;
            if (i2 >= size) {
                break;
            }
            iW += yn1.w(g92Var.f.get(i2));
            i2++;
        }
        int size2 = g92Var.f.size() + iV + iW;
        if ((this.X & 4) != 0) {
            size2 += q60.d(11, this.G0);
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
        int iHashCode = vs0.C0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + H().hashCode();
        }
        if (this.Z.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Z.hashCode();
        }
        if (this.y0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + this.y0.hashCode();
        }
        if (this.z0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + this.z0.hashCode();
        }
        if (this.A0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + this.A0.hashCode();
        }
        if (this.B0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + this.B0.hashCode();
        }
        if (this.C0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 8, 53) + this.C0.hashCode();
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 7, 53) + J().hashCode();
        }
        if (this.E0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 9, 53) + this.E0.hashCode();
        }
        if (this.F0.f.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 10, 53) + this.F0.hashCode();
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 11, 53) + this.G0;
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return I0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return J0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return I0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        ro0 ro0Var = new ro0(ue1Var);
        ro0Var.Y = "";
        List list = Collections.EMPTY_LIST;
        ro0Var.Z = list;
        ro0Var.y0 = list;
        ro0Var.z0 = list;
        ro0Var.A0 = list;
        ro0Var.B0 = list;
        ro0Var.C0 = list;
        ro0Var.F0 = list;
        ro0Var.G0 = g92.z;
        ro0Var.H0 = 0;
        return ro0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.D0;
        vn1Var.a(yo0.class, ro0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return I0;
    }
}
