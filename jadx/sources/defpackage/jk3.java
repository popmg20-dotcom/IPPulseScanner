package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class jk3 {
    public cm2 a;
    public ba3 b;
    public String d;
    public zq1 e;
    public wy3 h;
    public kk3 i;
    public kk3 j;
    public kk3 k;
    public long l;
    public long m;
    public ue1 n;
    public int c = -1;
    public ok3 g = ok3.f;
    public fg4 o = fg4.W;
    public m20 f = new m20(1);

    public static void b(kk3 kk3Var, String str) {
        if (kk3Var != null) {
            if (kk3Var.z0 != null) {
                e04.f(str.concat(".networkResponse != null"));
            } else if (kk3Var.A0 != null) {
                e04.f(str.concat(".cacheResponse != null"));
            } else {
                if (kk3Var.B0 == null) {
                    return;
                }
                e04.f(str.concat(".priorResponse != null"));
            }
        }
    }

    public final kk3 a() {
        int i = this.c;
        if (i < 0) {
            s53.r(this.c, "code < 0: ");
            return null;
        }
        cm2 cm2Var = this.a;
        if (cm2Var == null) {
            xe.q("request == null");
            return null;
        }
        ba3 ba3Var = this.b;
        if (ba3Var == null) {
            xe.q("protocol == null");
            return null;
        }
        String str = this.d;
        if (str == null) {
            xe.q("message == null");
            return null;
        }
        zq1 zq1Var = this.e;
        m20 m20Var = this.f;
        m20Var.getClass();
        return new kk3(cm2Var, ba3Var, str, i, zq1Var, gb4.y(m20Var), this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }
}
