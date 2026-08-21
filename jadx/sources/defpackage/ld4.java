package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ld4 extends yn1 implements sd4 {
    public static final ld4 F0;
    public static final jd4 G0;
    public List A0;
    public List B0;
    public long C0;
    public long D0;
    public byte E0;
    public int X;
    public volatile String Y;
    public List Z;
    public g92 y0;
    public g92 z0;

    static {
        ao3.a(4, "Thread");
        ld4 ld4Var = new ld4();
        ld4Var.X = 0;
        ld4Var.Y = "";
        g92 g92Var = g92.z;
        ld4Var.y0 = g92Var;
        ld4Var.z0 = g92Var;
        ld4Var.C0 = 0L;
        ld4Var.D0 = 0L;
        ld4Var.E0 = (byte) -1;
        ld4Var.Y = "";
        List list = Collections.EMPTY_LIST;
        ld4Var.Z = list;
        ld4Var.y0 = g92Var;
        ld4Var.z0 = g92Var;
        ld4Var.A0 = list;
        ld4Var.B0 = list;
        F0 = ld4Var;
        G0 = new jd4();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String H() {
        String str = this.Y;
        if (ha0.w(str)) {
            return str;
        }
        String strI = ((zt) str).i();
        this.Y = strI;
        return strI;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final kd4 u() {
        if (this == F0) {
            return new kd4();
        }
        kd4 kd4Var = new kd4();
        kd4Var.W(this);
        return kd4Var;
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
        this.E0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        int i = this.X;
        if (i != 0) {
            q60Var.s(1, i);
        }
        if (!yn1.C(this.Y)) {
            yn1.G(q60Var, 2, this.Y);
        }
        for (int i2 = 0; i2 < this.Z.size(); i2++) {
            q60Var.u(3, (nl2) this.Z.get(i2));
        }
        for (int i3 = 0; i3 < this.A0.size(); i3++) {
            q60Var.u(4, (nl2) this.A0.get(i3));
        }
        for (int i4 = 0; i4 < this.B0.size(); i4++) {
            q60Var.u(5, (nl2) this.B0.get(i4));
        }
        long j = this.C0;
        if (j != 0) {
            q60Var.A(6, j);
        }
        for (int i5 = 0; i5 < this.y0.f.size(); i5++) {
            yn1.G(q60Var, 7, this.y0.f.get(i5));
        }
        long j2 = this.D0;
        if (j2 != 0) {
            q60Var.A(8, j2);
        }
        for (int i6 = 0; i6 < this.z0.f.size(); i6++) {
            yn1.G(q60Var, 9, this.z0.f.get(i6));
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ld4)) {
            return super.equals(obj);
        }
        ld4 ld4Var = (ld4) obj;
        return this.X == ld4Var.X && H().equals(ld4Var.H()) && this.Z.equals(ld4Var.Z) && this.y0.equals(ld4Var.y0) && this.z0.equals(ld4Var.z0) && this.A0.equals(ld4Var.A0) && this.B0.equals(ld4Var.B0) && this.C0 == ld4Var.C0 && this.D0 == ld4Var.D0 && this.z.equals(ld4Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        g92 g92Var;
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int i2 = this.X;
        int i3 = 0;
        int iE = i2 != 0 ? q60.e(1, i2) : 0;
        if (!yn1.C(this.Y)) {
            iE += yn1.v(2, this.Y);
        }
        for (int i4 = 0; i4 < this.Z.size(); i4++) {
            iE += q60.f(3, (nl2) this.Z.get(i4));
        }
        for (int i5 = 0; i5 < this.A0.size(); i5++) {
            iE += q60.f(4, (nl2) this.A0.get(i5));
        }
        for (int i6 = 0; i6 < this.B0.size(); i6++) {
            iE += q60.f(5, (nl2) this.B0.get(i6));
        }
        long j = this.C0;
        if (j != 0) {
            iE += q60.l(j) + q60.h(6);
        }
        int i7 = 0;
        int iW = 0;
        while (true) {
            int size = this.y0.f.size();
            g92Var = this.y0;
            if (i7 >= size) {
                break;
            }
            iW += yn1.w(g92Var.f.get(i7));
            i7++;
        }
        int size2 = g92Var.f.size() + iE + iW;
        long j2 = this.D0;
        if (j2 != 0) {
            size2 += q60.l(j2) + q60.h(8);
        }
        int iW2 = 0;
        while (true) {
            int size3 = this.z0.f.size();
            g92 g92Var2 = this.z0;
            if (i3 >= size3) {
                int iH = this.z.h() + g92Var2.f.size() + size2 + iW2;
                this.f = iH;
                return iH;
            }
            iW2 += yn1.w(g92Var2.f.get(i3));
            i3++;
        }
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = H().hashCode() + ha0.i(fw.q(bf4.U0, 779, 37, 1, 53), this.X, 37, 2, 53);
        if (this.Z.size() > 0) {
            iHashCode = this.Z.hashCode() + fw.p(iHashCode, 37, 3, 53);
        }
        if (this.y0.f.size() > 0) {
            iHashCode = this.y0.hashCode() + fw.p(iHashCode, 37, 7, 53);
        }
        if (this.z0.f.size() > 0) {
            iHashCode = this.z0.hashCode() + fw.p(iHashCode, 37, 9, 53);
        }
        if (this.A0.size() > 0) {
            iHashCode = this.A0.hashCode() + fw.p(iHashCode, 37, 4, 53);
        }
        if (this.B0.size() > 0) {
            iHashCode = this.B0.hashCode() + fw.p(iHashCode, 37, 5, 53);
        }
        int iHashCode2 = this.z.hashCode() + ((i12.b(this.D0) + ((((i12.b(this.C0) + fw.p(iHashCode, 37, 6, 53)) * 37) + 8) * 53)) * 29);
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
        kd4 kd4Var = new kd4(ue1Var);
        kd4Var.Z = "";
        List list = Collections.EMPTY_LIST;
        kd4Var.y0 = list;
        g92 g92Var = g92.z;
        kd4Var.z0 = g92Var;
        kd4Var.A0 = g92Var;
        kd4Var.B0 = list;
        kd4Var.C0 = list;
        return kd4Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.V0;
        vn1Var.a(ld4.class, kd4.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return F0;
    }
}
