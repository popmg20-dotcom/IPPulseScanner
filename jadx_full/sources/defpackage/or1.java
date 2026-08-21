package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class or1 extends yn1 {
    public static final or1 C0;
    public static final mr1 D0;
    public List A0;
    public byte B0;
    public long X;
    public long Y;
    public long Z;
    public List y0;
    public long z0;

    static {
        ao3.a(4, "HeapObject");
        or1 or1Var = new or1();
        or1Var.X = 0L;
        or1Var.Y = 0L;
        or1Var.Z = 0L;
        or1Var.z0 = 0L;
        or1Var.B0 = (byte) -1;
        List list = Collections.EMPTY_LIST;
        or1Var.y0 = list;
        or1Var.A0 = list;
        C0 = or1Var;
        D0 = new mr1();
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final nr1 u() {
        if (this == C0) {
            return new nr1();
        }
        nr1 nr1Var = new nr1();
        nr1Var.V(this);
        return nr1Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return C0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.B0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.B0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        long j = this.X;
        if (j != 0) {
            q60Var.A(1, j);
        }
        long j2 = this.Y;
        if (j2 != 0) {
            q60Var.A(2, j2);
        }
        long j3 = this.Z;
        if (j3 != 0) {
            q60Var.A(3, j3);
        }
        for (int i = 0; i < this.y0.size(); i++) {
            q60Var.u(4, (nl2) this.y0.get(i));
        }
        long j4 = this.z0;
        if (j4 != 0) {
            q60Var.A(5, j4);
        }
        for (int i2 = 0; i2 < this.A0.size(); i2++) {
            q60Var.u(6, (nl2) this.A0.get(i2));
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof or1)) {
            return super.equals(obj);
        }
        or1 or1Var = (or1) obj;
        return this.X == or1Var.X && this.Y == or1Var.Y && this.Z == or1Var.Z && this.y0.equals(or1Var.y0) && this.z0 == or1Var.z0 && this.A0.equals(or1Var.A0) && this.z.equals(or1Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        long j = this.X;
        int iK = j != 0 ? q60.k(1, j) : 0;
        long j2 = this.Y;
        if (j2 != 0) {
            iK += q60.k(2, j2);
        }
        long j3 = this.Z;
        if (j3 != 0) {
            iK += q60.k(3, j3);
        }
        for (int i2 = 0; i2 < this.y0.size(); i2++) {
            iK += q60.f(4, (nl2) this.y0.get(i2));
        }
        long j4 = this.z0;
        if (j4 != 0) {
            iK += q60.k(5, j4);
        }
        for (int i3 = 0; i3 < this.A0.size(); i3++) {
            iK += q60.f(6, (nl2) this.A0.get(i3));
        }
        int iH = this.z.h() + iK;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iB = i12.b(this.Z) + ((((i12.b(this.Y) + ((((i12.b(this.X) + fw.q(bf4.M0, 779, 37, 1, 53)) * 37) + 2) * 53)) * 37) + 3) * 53);
        if (this.y0.size() > 0) {
            iB = this.y0.hashCode() + fw.p(iB, 37, 4, 53);
        }
        int iB2 = i12.b(this.z0) + fw.p(iB, 37, 5, 53);
        if (this.A0.size() > 0) {
            iB2 = this.A0.hashCode() + fw.p(iB2, 37, 6, 53);
        }
        int iHashCode = this.z.hashCode() + (iB2 * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return C0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return D0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return C0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        nr1 nr1Var = new nr1(ue1Var);
        List list = Collections.EMPTY_LIST;
        nr1Var.z0 = list;
        nr1Var.B0 = list;
        return nr1Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.N0;
        vn1Var.a(or1.class, nr1.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return C0;
    }
}
