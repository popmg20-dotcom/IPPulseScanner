package j$.time.chrono;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    a a();

    @Override // j$.time.temporal.m
    b c(long j, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    b d(long j, j$.time.temporal.s sVar);

    @Override // j$.time.temporal.TemporalAccessor
    boolean e(j$.time.temporal.q qVar);

    boolean equals(Object obj);

    int hashCode();

    b o(j$.time.temporal.n nVar);

    long t();

    String toString();

    e u(j$.time.l lVar);

    m v();

    b x(j$.time.temporal.p pVar);

    /* JADX INFO: renamed from: y */
    int compareTo(b bVar);
}
