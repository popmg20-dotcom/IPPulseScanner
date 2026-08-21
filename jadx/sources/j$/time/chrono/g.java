package j$.time.chrono;

import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.time.ZoneId;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements e, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;
    public final transient b a;
    public final transient j$.time.l b;

    public g(b bVar, j$.time.l lVar) {
        Objects.requireNonNull(bVar, "date");
        Objects.requireNonNull(lVar, RtspHeaders.Values.TIME);
        this.a = bVar;
        this.b = lVar;
    }

    public static g A(a aVar, j$.time.temporal.m mVar) {
        g gVar = (g) mVar;
        if (aVar.equals(gVar.a.a())) {
            return gVar;
        }
        j$.time.h.f("Chronology mismatch, required: ", aVar.C(), gVar.a.a().C());
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 2, this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public final g d(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return A(this.a.a(), sVar.h(this, j));
        }
        switch (f.a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return C(this.a, 0L, 0L, 0L, j);
            case 2:
                g gVarE = E(this.a.d(j / 86400000000L, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.b);
                return gVarE.C(gVarE.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                g gVarE2 = E(this.a.d(j / 86400000, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.b);
                return gVarE2.C(gVarE2.a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return C(this.a, 0L, 0L, j, 0L);
            case 5:
                return C(this.a, 0L, j, 0L, 0L);
            case 6:
                return C(this.a, j, 0L, 0L, 0L);
            case 7:
                g gVarE3 = E(this.a.d(j / 256, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.b);
                return gVarE3.C(gVarE3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return E(this.a.d(j, sVar), this.b);
        }
    }

    public final g C(b bVar, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        j$.time.l lVar = this.b;
        if (j5 == 0) {
            return E(bVar, lVar);
        }
        long j6 = j / 24;
        long jM = lVar.M();
        long j7 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L) + jM;
        long jO = j$.time.a.O(j7, 86400000000000L) + j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long jN = j$.time.a.N(j7, 86400000000000L);
        return E(bVar.d(jO, (j$.time.temporal.s) j$.time.temporal.b.DAYS), jN == jM ? this.b : j$.time.l.F(jN));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final g c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return A(this.a.a(), qVar.p(this, j));
        }
        boolean zA = ((j$.time.temporal.a) qVar).A();
        b bVar = this.a;
        return zA ? E(bVar, this.b.c(j, qVar)) : E(bVar.c(j, qVar), this.b);
    }

    public final g E(j$.time.temporal.m mVar, j$.time.l lVar) {
        b bVar = this.a;
        return (bVar == mVar && this.b == lVar) ? this : new g(d.A(bVar.a(), mVar), lVar);
    }

    @Override // j$.time.chrono.e
    public final a a() {
        return this.a.a();
    }

    @Override // j$.time.chrono.e
    public final j$.time.l b() {
        return this.b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.h(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.A();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && j$.time.a.f(this, (e) obj) == 0;
    }

    @Override // j$.time.chrono.e
    public final b f() {
        return this.a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).A() ? this.b.h(qVar) : this.a.h(qVar) : j(qVar).a(s(qVar), qVar);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(j$.time.i iVar) {
        return E(iVar, this.b);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.i(this);
        }
        if (!((j$.time.temporal.a) qVar).A()) {
            return this.a.j(qVar);
        }
        j$.time.l lVar = this.b;
        lVar.getClass();
        return j$.time.temporal.r.d(lVar, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        return mVar.c(f().t(), j$.time.temporal.a.EPOCH_DAY).c(b().M(), j$.time.temporal.a.NANO_OF_DAY);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object m(j$.time.z zVar) {
        return j$.time.a.s(this, zVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m p(long j, j$.time.temporal.b bVar) {
        return A(this.a.a(), j$.time.temporal.r.b(this, j, bVar));
    }

    @Override // j$.time.chrono.e
    public final j q(ZoneId zoneId) {
        return l.A(zoneId, null, this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).A() ? this.b.s(qVar) : this.a.s(qVar) : qVar.m(this);
    }

    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: w */
    public final /* synthetic */ int compareTo(e eVar) {
        return j$.time.a.f(this, eVar);
    }
}
