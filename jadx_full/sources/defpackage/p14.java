package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p14 extends yn1 {
    public static final p14 y0;
    public static final n14 z0;
    public long X;
    public List Y;
    public byte Z;

    static {
        ao3.a(4, "StackHistoryBuffer");
        p14 p14Var = new p14();
        p14Var.X = 0L;
        p14Var.Z = (byte) -1;
        p14Var.Y = Collections.EMPTY_LIST;
        y0 = p14Var;
        z0 = new n14();
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final o14 u() {
        if (this == y0) {
            return new o14();
        }
        o14 o14Var = new o14();
        o14Var.V(this);
        return o14Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return y0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.Z;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.Z = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        long j = this.X;
        if (j != 0) {
            q60Var.A(1, j);
        }
        for (int i = 0; i < this.Y.size(); i++) {
            q60Var.u(2, (nl2) this.Y.get(i));
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p14)) {
            return super.equals(obj);
        }
        p14 p14Var = (p14) obj;
        return this.X == p14Var.X && this.Y.equals(p14Var.Y) && this.z.equals(p14Var.z);
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        long j = this.X;
        int iK = j != 0 ? q60.k(1, j) : 0;
        for (int i2 = 0; i2 < this.Y.size(); i2++) {
            iK += q60.f(2, (nl2) this.Y.get(i2));
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
        int iB = i12.b(this.X) + fw.q(bf4.E0, 779, 37, 1, 53);
        if (this.Y.size() > 0) {
            iB = this.Y.hashCode() + fw.p(iB, 37, 2, 53);
        }
        int iHashCode = this.z.hashCode() + (iB * 29);
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return y0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return z0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return y0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        o14 o14Var = new o14(ue1Var);
        o14Var.Z = Collections.EMPTY_LIST;
        return o14Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = bf4.F0;
        vn1Var.a(p14.class, o14.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return y0;
    }
}
