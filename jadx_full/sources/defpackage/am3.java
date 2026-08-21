package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class am3 {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final float f;
    public final float g;
    public final float h;
    public long i;

    public am3(long j, long j2, long j3, xe0 xe0Var) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        long jD = yr2.D(yr2.T(j, j2));
        this.d = jD;
        long jD2 = yr2.D(yr2.T(j3, j2));
        this.e = jD2;
        float f = xe0Var.a;
        this.f = f;
        this.g = xe0Var.b;
        float fW = yr2.w(jD, jD2);
        float f2 = eo4.b;
        float fSqrt = (float) Math.sqrt(1.0f - (fW * fW));
        this.h = ((double) fSqrt) > 0.001d ? ((fW + 1.0f) * f) / fSqrt : 0.0f;
        this.i = qf1.a(0.0f, 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static hg0 b(float f, float f2, long j, long j2, long j3, long j4, long j5, float f3) {
        qf1 qf1Var;
        long jD = yr2.D(yr2.T(j2, j));
        long jC0 = yr2.c0(j, yr2.n0(yr2.n0(jD, f), 1.0f + f2));
        long jT = yr2.t(yr2.c0(j3, j4), 2.0f);
        long jA = qf1.a(eo4.c(yr2.H(j3), yr2.H(jT), f2), eo4.c(yr2.I(j3), yr2.I(jT), f2));
        long jC02 = yr2.c0(j5, yr2.n0(eo4.b(yr2.H(jA) - yr2.H(j5), yr2.I(jA) - yr2.I(j5)), f3));
        long jT2 = yr2.T(jC02, j5);
        long jA2 = qf1.a(-yr2.I(jT2), yr2.H(jT2));
        long jA3 = qf1.a(-yr2.I(jA2), yr2.H(jA2));
        float fW = yr2.w(jD, jA3);
        if (Math.abs(fW) < 1.0E-4f) {
            qf1Var = null;
        } else {
            float fW2 = yr2.w(yr2.T(jC02, j2), jA3);
            if (Math.abs(fW) >= Math.abs(fW2) * 1.0E-4f) {
                qf1Var = new qf1(yr2.c0(j2, yr2.n0(jD, fW2 / fW)));
            }
        }
        long j6 = qf1Var != null ? qf1Var.a : j3;
        long jT3 = yr2.t(yr2.c0(jC0, yr2.n0(j6, 2.0f)), 3.0f);
        return new hg0(new float[]{yr2.H(jC0), yr2.I(jC0), yr2.H(jT3), yr2.I(jT3), yr2.H(j6), yr2.I(j6), yr2.H(jC02), yr2.I(jC02)});
    }

    public final float a(float f) {
        float fC = c();
        float f2 = this.g;
        if (f > fC) {
            return f2;
        }
        float f3 = this.h;
        if (f > f3) {
            return ((f - f3) * f2) / (c() - f3);
        }
        return 0.0f;
    }

    public final float c() {
        return (1.0f + this.g) * this.h;
    }
}
