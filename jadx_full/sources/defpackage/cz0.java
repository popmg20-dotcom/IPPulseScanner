package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class cz0 implements Comparable {
    public static final vd3 b = new vd3(15);
    public static final long f = ek0.f(4611686018427387903L);
    public static final long z = ek0.f(-4611686018427387903L);

    public static final long a(long j, long j2) {
        long j3 = j2 / 1000000;
        long jA = ek0.a(j, j3);
        if (-4611686018426L > jA || jA >= 4611686018427L) {
            return ek0.f(jA);
        }
        long j4 = ((jA * 1000000) + (j2 - (j3 * 1000000))) << 1;
        int i = dz0.a;
        return j4;
    }

    public static final long b(long j, ez0 ez0Var) {
        if (j == f) {
            return Long.MAX_VALUE;
        }
        if (j == z) {
            return Long.MIN_VALUE;
        }
        return ez0Var.b.convert(j >> 1, ((((int) j) & 1) == 0 ? ez0.NANOSECONDS : ez0.MILLISECONDS).b);
    }
}
