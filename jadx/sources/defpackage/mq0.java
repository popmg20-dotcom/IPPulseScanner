package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mq0 extends yn1 {
    public static final mq0 A0;
    public static final hq0 B0;
    public int X;
    public List Y;
    public int Z;
    public int y0;
    public byte z0;

    static {
        ao3.a(5, "FeatureSetDefaults");
        mq0 mq0Var = new mq0();
        mq0Var.Z = 0;
        mq0Var.y0 = 0;
        mq0Var.z0 = (byte) -1;
        mq0Var.Y = Collections.EMPTY_LIST;
        mq0Var.Z = 0;
        mq0Var.y0 = 0;
        A0 = mq0Var;
        B0 = new hq0();
    }

    public final boolean H() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final iq0 u() {
        if (this == A0) {
            return new iq0();
        }
        iq0 iq0Var = new iq0();
        iq0Var.V(this);
        return iq0Var;
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
        for (int i = 0; i < this.Y.size(); i++) {
            if (!((lq0) this.Y.get(i)).c()) {
                this.z0 = (byte) 0;
                return false;
            }
        }
        this.z0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        for (int i = 0; i < this.Y.size(); i++) {
            q60Var.u(1, (nl2) this.Y.get(i));
        }
        if ((this.X & 1) != 0) {
            q60Var.s(4, this.Z);
        }
        if ((this.X & 2) != 0) {
            q60Var.s(5, this.y0);
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof mq0)) {
                return super.equals(obj);
            }
            mq0 mq0Var = (mq0) obj;
            if (this.Y.equals(mq0Var.Y)) {
                int i = this.X;
                if (((i & 1) != 0) == ((mq0Var.X & 1) != 0) && (((i & 1) == 0 || this.Z == mq0Var.Z) && H() == mq0Var.H() && ((!H() || this.y0 == mq0Var.y0) && this.z.equals(mq0Var.z)))) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.nl2
    public final int h() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int iD = 0;
        for (int i2 = 0; i2 < this.Y.size(); i2++) {
            iD += q60.f(1, (nl2) this.Y.get(i2));
        }
        if ((this.X & 1) != 0) {
            iD += q60.d(4, this.Z);
        }
        if ((this.X & 2) != 0) {
            iD += q60.d(5, this.y0);
        }
        int iH = this.z.h() + iD;
        this.f = iH;
        return iH;
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = vs0.A1.hashCode() + 779;
        if (this.Y.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + this.Y.hashCode();
        }
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + this.Z;
        }
        if (H()) {
            iHashCode = fw.p(iHashCode, 37, 5, 53) + this.y0;
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
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
        iq0 iq0Var = new iq0(ue1Var);
        iq0Var.Y = Collections.EMPTY_LIST;
        iq0Var.Z = 0;
        iq0Var.y0 = 0;
        return iq0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.B1;
        vn1Var.a(mq0.class, iq0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return A0;
    }
}
