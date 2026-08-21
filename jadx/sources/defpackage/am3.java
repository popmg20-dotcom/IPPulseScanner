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
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.hg0 b(float r15, float r16, long r17, long r19, long r21, long r23, long r25, float r27) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.am3.b(float, float, long, long, long, long, long, float):hg0");
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
