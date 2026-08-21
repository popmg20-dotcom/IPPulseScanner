package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wr4 {
    public static final wr4 k;
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;
    public final double[] g;
    public final double h;
    public final double i;
    public final double j;

    static {
        double[] dArr = tj4.b;
        double dN0 = (tj4.n0(50.0d) * 63.66197723675813d) / 100.0d;
        double dMax = Math.max(0.1d, 50.0d);
        double[][] dArr2 = vf2.z;
        double d = dArr[0];
        double[] dArr3 = dArr2[0];
        double d2 = dArr3[0] * d;
        double d3 = dArr[1];
        double d4 = (dArr3[1] * d3) + d2;
        double d5 = dArr[2];
        double d6 = (dArr3[2] * d5) + d4;
        double[] dArr4 = dArr2[1];
        double d7 = (dArr4[2] * d5) + (dArr4[1] * d3) + (dArr4[0] * d);
        double[] dArr5 = dArr2[2];
        double d8 = (d5 * dArr5[2]) + (d3 * dArr5[1]) + (d * dArr5[0]);
        double dExp = (1.0d - (Math.exp(((-dN0) - 42.0d) / 92.0d) * 0.2777777777777778d)) * 1.0d;
        if (dExp < 0.0d) {
            dExp = 0.0d;
        } else if (dExp > 1.0d) {
            dExp = 1.0d;
        }
        double[] dArr6 = {(((100.0d / d6) * dExp) + 1.0d) - dExp, (((100.0d / d7) * dExp) + 1.0d) - dExp, (((100.0d / d8) * dExp) + 1.0d) - dExp};
        double d9 = 5.0d * dN0;
        double d10 = 1.0d / (d9 + 1.0d);
        double d11 = d10 * d10 * d10 * d10;
        double d12 = 1.0d - d11;
        double dCbrt = (Math.cbrt(d9) * 0.1d * d12 * d12) + (d11 * dN0);
        double dN02 = tj4.n0(dMax) / dArr[1];
        double dSqrt = Math.sqrt(dN02) + 1.48d;
        double dPow = 0.725d / Math.pow(dN02, 0.2d);
        double[] dArr7 = {Math.pow(((dArr6[0] * dCbrt) * d6) / 100.0d, 0.42d), Math.pow(((dArr6[1] * dCbrt) * d7) / 100.0d, 0.42d), Math.pow(((dArr6[2] * dCbrt) * d8) / 100.0d, 0.42d)};
        double d13 = dArr7[0];
        double d14 = (d13 * 400.0d) / (d13 + 27.13d);
        double d15 = dArr7[1];
        double d16 = (d15 * 400.0d) / (d15 + 27.13d);
        double d17 = dArr7[2];
        double[] dArr8 = {d14, d16, (400.0d * d17) / (d17 + 27.13d)};
        k = new wr4(dN02, ((dArr8[2] * 0.05d) + (dArr8[0] * 2.0d) + dArr8[1]) * dPow, dPow, dPow, 0.69d, 1.0d, dArr6, dCbrt, Math.pow(dCbrt, 0.25d), dSqrt);
    }

    public wr4(double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, double d7, double d8, double d9) {
        this.f = d;
        this.a = d2;
        this.b = d3;
        this.c = d4;
        this.d = d5;
        this.e = d6;
        this.g = dArr;
        this.h = d7;
        this.i = d8;
        this.j = d9;
    }
}
