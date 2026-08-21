package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x5 extends w4 {
    public final long b;
    public final long f;

    public x5() {
        this(System.currentTimeMillis(), System.nanoTime());
    }

    @Override // io.sentry.w4, java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public final int compareTo(w4 w4Var) {
        if (!(w4Var instanceof x5)) {
            return super.compareTo(w4Var);
        }
        x5 x5Var = (x5) w4Var;
        long j = x5Var.b;
        long j2 = this.b;
        return j2 == j ? Long.compare(this.f, x5Var.f) : Long.compare(j2, j);
    }

    @Override // io.sentry.w4
    public final long b(w4 w4Var) {
        return w4Var instanceof x5 ? this.f - ((x5) w4Var).f : super.b(w4Var);
    }

    @Override // io.sentry.w4
    public final long c(w4 w4Var) {
        if (!(w4Var instanceof x5)) {
            return super.c(w4Var);
        }
        x5 x5Var = (x5) w4Var;
        long j = x5Var.f;
        int iCompareTo = compareTo(w4Var);
        long j2 = this.f;
        if (iCompareTo < 0) {
            return d() + (j - j2);
        }
        return x5Var.d() + (j2 - j);
    }

    @Override // io.sentry.w4
    public final long d() {
        return this.b * 1000000;
    }

    public x5(long j, long j2) {
        this.b = j;
        this.f = j2;
    }
}
