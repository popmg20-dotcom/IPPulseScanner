package io.sentry.android.core.performance;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Comparable {
    public final h b = new h();
    public final h f = new h();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        c cVar = (c) obj;
        int iCompare = Long.compare(this.b.z, cVar.b.z);
        return iCompare == 0 ? Long.compare(this.f.z, cVar.f.z) : iCompare;
    }
}
