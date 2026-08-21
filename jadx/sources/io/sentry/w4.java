package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class w4 implements Comparable {
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(w4 w4Var) {
        return Long.compare(d(), w4Var.d());
    }

    public long b(w4 w4Var) {
        return d() - w4Var.d();
    }

    public long c(w4 w4Var) {
        return (w4Var == null || compareTo(w4Var) >= 0) ? d() : w4Var.d();
    }

    public abstract long d();
}
