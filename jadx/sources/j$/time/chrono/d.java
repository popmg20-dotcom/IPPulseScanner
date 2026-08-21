package j$.time.chrono;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements b, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public static b A(a aVar, j$.time.temporal.m mVar) {
        b bVar = (b) mVar;
        if (aVar.equals(bVar.a())) {
            return bVar;
        }
        j$.time.h.f("Chronology mismatch, expected: ", aVar.C(), bVar.a().C());
        return null;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public b p(long j, j$.time.temporal.s sVar) {
        return A(a(), j$.time.temporal.r.b(this, j, sVar));
    }

    public abstract b C(long j);

    public abstract b D(long j);

    public abstract b E(long j);

    @Override // j$.time.temporal.m
    public b c(long j, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        return A(a(), qVar.p(this, j));
    }

    @Override // j$.time.temporal.m
    public b d(long j, j$.time.temporal.s sVar) {
        boolean z = sVar instanceof j$.time.temporal.b;
        if (!z) {
            if (!z) {
                return A(a(), sVar.h(this, j));
            }
            j$.time.h.b(sVar, "Unsupported unit: ");
            return null;
        }
        switch (c.a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return C(j);
            case 2:
                return C(j$.time.a.P(j, 7L));
            case 3:
                return D(j);
            case 4:
                return E(j);
            case 5:
                return E(j$.time.a.P(j, 10L));
            case 6:
                return E(j$.time.a.P(j, 100L));
            case 7:
                return E(j$.time.a.P(j, 1000L));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(j$.time.a.K(s(aVar), j), (j$.time.temporal.q) aVar);
            default:
                j$.time.h.b(sVar, "Unsupported unit: ");
                return null;
        }
    }

    @Override // j$.time.chrono.b, j$.time.temporal.TemporalAccessor
    public /* synthetic */ boolean e(j$.time.temporal.q qVar) {
        return j$.time.a.p(this, qVar);
    }

    @Override // j$.time.chrono.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && j$.time.a.e(this, (b) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.chrono.b
    public int hashCode() {
        long jT = t();
        return a().hashCode() ^ ((int) (jT ^ (jT >>> 32)));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public /* synthetic */ j$.time.temporal.u j(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final /* synthetic */ j$.time.temporal.m k(j$.time.temporal.m mVar) {
        return j$.time.a.a(this, mVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object m(j$.time.z zVar) {
        return j$.time.a.r(this, zVar);
    }

    @Override // j$.time.temporal.m
    public b o(j$.time.temporal.n nVar) {
        return A(a(), nVar.k(this));
    }

    @Override // j$.time.chrono.b
    public long t() {
        return s(j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        long jS = s(j$.time.temporal.a.YEAR_OF_ERA);
        long jS2 = s(j$.time.temporal.a.MONTH_OF_YEAR);
        long jS3 = s(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(a().toString());
        sb.append(" ");
        sb.append(v());
        sb.append(" ");
        sb.append(jS);
        sb.append(jS2 < 10 ? "-0" : "-");
        sb.append(jS2);
        sb.append(jS3 < 10 ? "-0" : "-");
        sb.append(jS3);
        return sb.toString();
    }

    @Override // j$.time.chrono.b
    public e u(j$.time.l lVar) {
        return new g(this, lVar);
    }

    @Override // j$.time.chrono.b
    public m v() {
        return a().s(j$.time.temporal.r.a(this, j$.time.temporal.a.ERA));
    }

    @Override // j$.time.chrono.b
    public b x(j$.time.temporal.p pVar) {
        return A(a(), pVar.h(this));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: y */
    public final /* synthetic */ int compareTo(b bVar) {
        return j$.time.a.e(this, bVar);
    }
}
