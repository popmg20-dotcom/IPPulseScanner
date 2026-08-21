package defpackage;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ms0 extends yn1 {
    public static final ms0 E0;
    public static final ks0 F0;
    public volatile Serializable A0;
    public volatile Serializable B0;
    public g92 C0;
    public byte D0;
    public int X;
    public x02 Y;
    public int Z;
    public x02 y0;
    public int z0;

    static {
        ao3.a(5, HttpHeaders.Names.LOCATION);
        ms0 ms0Var = new ms0();
        x02 x02Var = x02.X;
        ms0Var.Y = x02Var;
        ms0Var.Z = -1;
        ms0Var.y0 = x02Var;
        ms0Var.z0 = -1;
        ms0Var.A0 = "";
        ms0Var.B0 = "";
        g92 g92Var = g92.z;
        ms0Var.C0 = g92Var;
        ms0Var.D0 = (byte) -1;
        ms0Var.Y = x02Var;
        ms0Var.y0 = x02Var;
        ms0Var.A0 = "";
        ms0Var.B0 = "";
        ms0Var.C0 = g92Var;
        E0 = ms0Var;
        F0 = new ks0();
    }

    public final String H() {
        Serializable serializable = this.A0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.A0 = strI;
        }
        return strI;
    }

    public final String J() {
        Serializable serializable = this.B0;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        zt ztVar = (zt) serializable;
        String strI = ztVar.i();
        if (ztVar.g()) {
            this.B0 = strI;
        }
        return strI;
    }

    public final boolean K() {
        return (this.X & 2) != 0;
    }

    @Override // defpackage.c1
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final ls0 u() {
        if (this == E0) {
            return new ls0();
        }
        ls0 ls0Var = new ls0();
        ls0Var.X(this);
        return ls0Var;
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return E0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        byte b = this.D0;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.D0 = (byte) 1;
        return true;
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        h();
        if (this.Y.z > 0) {
            q60Var.z(10);
            q60Var.z(this.Z);
        }
        int i = 0;
        while (true) {
            x02 x02Var = this.Y;
            if (i >= x02Var.z) {
                break;
            }
            q60Var.t(x02Var.f(i));
            i++;
        }
        if (this.y0.z > 0) {
            q60Var.z(18);
            q60Var.z(this.z0);
        }
        int i2 = 0;
        while (true) {
            x02 x02Var2 = this.y0;
            if (i2 >= x02Var2.z) {
                break;
            }
            q60Var.t(x02Var2.f(i2));
            i2++;
        }
        if ((this.X & 1) != 0) {
            yn1.G(q60Var, 3, this.A0);
        }
        if ((this.X & 2) != 0) {
            yn1.G(q60Var, 4, this.B0);
        }
        for (int i3 = 0; i3 < this.C0.f.size(); i3++) {
            yn1.G(q60Var, 6, this.C0.f.get(i3));
        }
        this.z.d(q60Var);
    }

    @Override // defpackage.c1
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ms0)) {
                return super.equals(obj);
            }
            ms0 ms0Var = (ms0) obj;
            if (this.Y.equals(ms0Var.Y) && this.y0.equals(ms0Var.y0)) {
                int i = this.X;
                if (((i & 1) != 0) == ((ms0Var.X & 1) != 0) && (((i & 1) == 0 || H().equals(ms0Var.H())) && K() == ms0Var.K() && ((!K() || J().equals(ms0Var.J())) && this.C0.equals(ms0Var.C0) && this.z.equals(ms0Var.z)))) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.nl2
    public final int h() {
        x02 x02Var;
        int iL;
        x02 x02Var2;
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = 0;
        int iL2 = 0;
        while (true) {
            x02Var = this.Y;
            if (i3 >= x02Var.z) {
                break;
            }
            iL2 += q60.l(x02Var.f(i3));
            i3++;
        }
        if (x02Var.isEmpty()) {
            iL = iL2;
        } else {
            iL = q60.l(iL2) + iL2 + 1;
        }
        this.Z = iL2;
        int i4 = 0;
        int iL3 = 0;
        while (true) {
            x02Var2 = this.y0;
            if (i4 >= x02Var2.z) {
                break;
            }
            iL3 += q60.l(x02Var2.f(i4));
            i4++;
        }
        int iV = iL + iL3;
        if (!x02Var2.isEmpty()) {
            iV = iV + 1 + q60.l(iL3);
        }
        this.z0 = iL3;
        if ((this.X & 1) != 0) {
            iV += yn1.v(3, this.A0);
        }
        if ((this.X & 2) != 0) {
            iV += yn1.v(4, this.B0);
        }
        int iW = 0;
        while (true) {
            int size = this.C0.f.size();
            g92 g92Var = this.C0;
            if (i2 >= size) {
                int iH = this.z.h() + g92Var.f.size() + iV + iW;
                this.f = iH;
                return iH;
            }
            iW += yn1.w(g92Var.f.get(i2));
            i2++;
        }
    }

    @Override // defpackage.c1
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = vs0.G1.hashCode() + 779;
        x02 x02Var = this.Y;
        if (x02Var.z > 0) {
            iHashCode = fw.p(iHashCode, 37, 1, 53) + x02Var.hashCode();
        }
        x02 x02Var2 = this.y0;
        if (x02Var2.z > 0) {
            iHashCode = fw.p(iHashCode, 37, 2, 53) + x02Var2.hashCode();
        }
        if ((this.X & 1) != 0) {
            iHashCode = fw.p(iHashCode, 37, 3, 53) + H().hashCode();
        }
        if (K()) {
            iHashCode = fw.p(iHashCode, 37, 4, 53) + J().hashCode();
        }
        if (this.C0.f.size() > 0) {
            iHashCode = fw.p(iHashCode, 37, 6, 53) + this.C0.hashCode();
        }
        int iHashCode2 = this.z.hashCode() + (iHashCode * 29);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return E0.u();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return F0;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return E0.u();
    }

    @Override // defpackage.c1
    public final a1 t(ue1 ue1Var) {
        ls0 ls0Var = new ls0(ue1Var);
        x02 x02Var = x02.X;
        ls0Var.Y = x02Var;
        ls0Var.Z = x02Var;
        ls0Var.y0 = "";
        ls0Var.z0 = "";
        ls0Var.A0 = g92.z;
        return ls0Var;
    }

    @Override // defpackage.yn1
    public final vn1 z() {
        vn1 vn1Var = vs0.H1;
        vn1Var.a(ms0.class, ls0.class);
        return vn1Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return E0;
    }
}
