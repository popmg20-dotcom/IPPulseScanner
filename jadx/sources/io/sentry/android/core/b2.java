package io.sentry.android.core;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b2 implements Comparable {
    public final long A;
    public final boolean X;
    public final boolean Y;
    public final long Z;
    public final long b;
    public final long f;
    public final long z;

    public b2(long j, long j2, long j3, long j4, boolean z, boolean z2, long j5) {
        this.b = j;
        this.f = j2;
        this.z = j3;
        this.A = j4;
        this.X = z;
        this.Y = z2;
        this.Z = j5;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f, ((b2) obj).f);
    }

    public b2(long j) {
        this(j, j, 0L, 0L, false, false, 0L);
    }
}
