package io.sentry.android.core.internal.util;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Comparable {
    public final long b;
    public final long f;

    public o(long j, long j2) {
        this.b = j;
        this.f = j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        o oVar = (o) obj;
        int iCompare = Long.compare(this.f, oVar.f);
        return iCompare != 0 ? iCompare : Long.compare(this.b, oVar.b);
    }
}
