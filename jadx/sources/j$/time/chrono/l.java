package j$.time.chrono;

import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements j, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    public final transient g a;
    public final transient ZoneOffset b;
    public final transient ZoneId c;

    public l(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        this.a = (g) Objects.requireNonNull(gVar, "dateTime");
        this.b = (ZoneOffset) Objects.requireNonNull(zoneOffset, "offset");
        this.c = (ZoneId) Objects.requireNonNull(zoneId, "zone");
    }

    public static l A(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        Objects.requireNonNull(gVar, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new l(zoneId, (ZoneOffset) zoneId, gVar);
        }
        j$.time.zone.f fVarC = zoneId.C();
        LocalDateTime localDateTimeB = LocalDateTime.B(gVar);
        List listF = fVarC.f(localDateTimeB);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() == 0) {
            Object objE = fVarC.e(localDateTimeB);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            gVar = gVar.C(gVar.a, 0L, 0L, Duration.ofSeconds(bVar.d.b - bVar.c.b).a, 0L);
            zoneOffset = bVar.d;
        } else {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
            }
            gVar = gVar;
        }
        Objects.requireNonNull(zoneOffset, "offset");
        return new l(zoneId, zoneOffset, gVar);
    }

    public static l B(a aVar, Instant instant, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.C().d(instant);
        Objects.requireNonNull(zoneOffsetD, "offset");
        return new l(zoneId, zoneOffsetD, (g) aVar.D(LocalDateTime.E(instant.getEpochSecond(), instant.getNano(), zoneOffsetD)));
    }

    public static l k(a aVar, j$.time.temporal.m mVar) {
        l lVar = (l) mVar;
        if (aVar.equals(lVar.a())) {
            return lVar;
        }
        j$.time.h.f("Chronology mismatch, required: ", aVar.C(), lVar.a().C());
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 3, this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final l d(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return k(a(), sVar.h(this, j));
        }
        return k(a(), this.a.d(j, sVar).k(this));
    }

    @Override // j$.time.chrono.j
    public final a a() {
        return this.a.a.a();
    }

    @Override // j$.time.chrono.j
    public final j$.time.l b() {
        return ((g) l()).b();
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return k(a(), qVar.p(this, j));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i = k.a[aVar.ordinal()];
        if (i == 1) {
            return d(j - j$.time.a.w(this), j$.time.temporal.b.SECONDS);
        }
        if (i != 2) {
            return A(this.c, this.b, this.a.c(j, qVar));
        }
        ZoneOffset zoneOffsetJ = ZoneOffset.J(aVar.b.a(j, aVar));
        g gVar = this.a;
        gVar.getClass();
        return B(a(), Instant.B(j$.time.a.v(gVar, zoneOffsetJ), gVar.b.d), this.c);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return j$.time.a.g(this, (j) obj);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && j$.time.a.g(this, (j) obj) == 0;
    }

    @Override // j$.time.chrono.j
    public final b f() {
        return this.a.a;
    }

    @Override // j$.time.chrono.j
    public final ZoneOffset g() {
        return this.b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ int h(j$.time.temporal.q qVar) {
        return j$.time.a.k(this, qVar);
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.c.hashCode(), 3) ^ (this.a.hashCode() ^ this.b.b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(j$.time.i iVar) {
        return k(a(), iVar.k(this));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) ? ((j$.time.temporal.a) qVar).b : this.a.j(qVar) : qVar.i(this);
    }

    @Override // j$.time.chrono.j
    public final e l() {
        return this.a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final /* synthetic */ Object m(j$.time.z zVar) {
        return j$.time.a.t(this, zVar);
    }

    @Override // j$.time.chrono.j
    public final j n(ZoneId zoneId) {
        return A(zoneId, this.b, this.a);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m p(long j, j$.time.temporal.b bVar) {
        return k(a(), j$.time.temporal.r.b(this, j, bVar));
    }

    @Override // j$.time.chrono.j
    public final ZoneId r() {
        return this.c;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.m(this);
        }
        int i = i.a[((j$.time.temporal.a) qVar).ordinal()];
        return i != 1 ? i != 2 ? ((g) l()).s(qVar) : g().b : z();
    }

    public final String toString() {
        String str = this.a.toString() + this.b.c;
        ZoneOffset zoneOffset = this.b;
        ZoneId zoneId = this.c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    @Override // j$.time.chrono.j
    public final /* synthetic */ long z() {
        return j$.time.a.w(this);
    }
}
