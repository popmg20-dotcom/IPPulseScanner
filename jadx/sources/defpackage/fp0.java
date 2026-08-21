package defpackage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fp0 extends yn1 {
    public static final fp0 D0;
    public static final ap0 E0;
    public g92 A0;
    public int B0;
    public byte C0;
    public int X;
    public volatile Serializable Y;
    public List Z;
    public ip0 y0;
    public List z0;

    static {
        ao3.a(5, "EnumDescriptorProto");
        fp0 fp0Var = new fp0();
        fp0Var.Y = "";
        g92 g92Var = g92.z;
        fp0Var.A0 = g92Var;
        fp0Var.B0 = 0;
        fp0Var.C0 = (byte) -1;
        fp0Var.Y = "";
        List list = Collections.EMPTY_LIST;
        fp0Var.Z = list;
        fp0Var.z0 = list;
        fp0Var.A0 = g92Var;
        fp0Var.B0 = 0;
        D0 = fp0Var;
        E0 = new ap0();
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

    public final ip0 J() {
        ip0 ip0Var = this.y0;
        return ip0Var == null ? ip0.D0 : ip0Var;
    }

    public final boolean K() {
        return (this.X & 2) != 0;
    }

    public final boolean L() {
        return (this.X & 4) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final bp0 u() {
        if (this == D0) {
            return new bp0();
        }
        bp0 bp0Var = new bp0();
        bp0Var.V(this);
        return bp0Var;
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
        for (int i = 0; i < this.Z.size(); i++) {
            if (!((lp0) this.Z.get(i)).c()) {
                this.C0 = (byte) 0;
                return false;
            }
        }
        if (!K() || J().c()) {
            this.C0 = (byte) 1;
            return true;
        }
        this.C0 = (byte) 0;
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
        if ((this.X & 2) != 0) {
            q60Var.u(3, J());
        }
        for (int i2 = 0; i2 < this.z0.size(); i2++) {
            q60Var.u(4, (nl2) this.z0.get(i2));
        }
        for (int i3 = 0; i3 < this.A0.f.size(); i3++) {
            yn1.G(q60Var, 5, this.A0.f.get(i3));
        }
        if ((this.X & 4) != 0) {
            q60Var.s(6, this.B0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof fp0)) {
                return super.equals(obj);
            }
            fp0 fp0Var = (fp0) obj;
            int i = this.X;
            if (((i & 1) != 0) != ((fp0Var.X & 1) != 0) || (((i & 1) != 0 && !H().equals(fp0Var.H())) || !this.Z.equals(fp0Var.Z) || K() != fp0Var.K() || ((K() && !J().equals(fp0Var.J())) || !this.z0.equals(fp0Var.z0) || !this.A0.equals(fp0Var.A0) || L() != fp0Var.L() || ((L() && this.B0 != fp0Var.B0) || !this.z.equals(fp0Var.z))))) {
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
        if ((this.X & 2) != 0) {
            iV += q60.f(3, J());
        }
        for (int i4 = 0; i4 < this.z0.size(); i4++) {
            iV += q60.f(4, (nl2) this.z0.get(i4));
        }
        int iW = 0;
        while (true) {
            int size = this.A0.f.size();
            g92Var = this.A0;
            if (i2 >= size) {
                break;
            }
            iW += yn1.w(g92Var.f.get(i2));
            i2++;
        }
        int size2 = g92Var.f.size() + iV + iW;
        if ((this.X & 4) != 0) {
            size2 += q60.d(6, this.B0);
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
        int iHashCode = vs0.Q0.hashCode() + 779;
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + H().hashCode();
        }
        if (this.Z.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + this.Z.hashCode();
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + J().hashCode();
        }
        if (this.z0.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + this.z0.hashCode();
        }
        if (this.A0.f.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + this.A0.hashCode();
        }
        if (L()) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + this.B0;
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
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
        bp0 bp0Var = new bp0(ue1Var);
        bp0Var.Y = "";
        List list = Collections.EMPTY_LIST;
        bp0Var.Z = list;
        bp0Var.A0 = list;
        bp0Var.B0 = g92.z;
        bp0Var.C0 = 0;
        return bp0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.R0;
        vn1Var.a(fp0.class, bp0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return D0;
    }
}
