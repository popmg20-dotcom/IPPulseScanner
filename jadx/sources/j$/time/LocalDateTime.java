package j$.time;

import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.n, j$.time.chrono.e, Serializable {
    public static final LocalDateTime c = D(i.d, l.e);
    public static final LocalDateTime d = D(i.e, l.f);
    private static final long serialVersionUID = 6207766400415563566L;
    public final i a;
    public final l b;

    public LocalDateTime(i iVar, l lVar) {
        this.a = iVar;
        this.b = lVar;
    }

    public static LocalDateTime B(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).a;
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(i.C(temporalAccessor), l.C(temporalAccessor));
        } catch (c e) {
            throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    public static LocalDateTime D(i iVar, l lVar) {
        Objects.requireNonNull(iVar, "date");
        Objects.requireNonNull(lVar, RtspHeaders.Values.TIME);
        return new LocalDateTime(iVar, lVar);
    }

    public static LocalDateTime E(long j, int i, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j2 = i;
        j$.time.temporal.a.NANO_OF_SECOND.s(j2);
        long j3 = j + ((long) zoneOffset.b);
        return new LocalDateTime(i.L(a.O(j3, 86400L)), l.F((((long) ((int) a.N(j3, 86400L))) * 1000000000) + j2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 5, this);
    }

    public final int A(LocalDateTime localDateTime) {
        int iA = this.a.A(localDateTime.a);
        return iA == 0 ? this.b.compareTo(localDateTime.b) : iA;
    }

    public final boolean C(j$.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return A((LocalDateTime) eVar) < 0;
        }
        long jT = this.a.t();
        long jT2 = eVar.f().t();
        if (jT >= jT2) {
            return jT == jT2 && this.b.M() < eVar.b().M();
        }
        return true;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime d(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) sVar.h(this, j);
        }
        switch (j.a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return H(this.a, 0L, 0L, 0L, j);
            case 2:
                LocalDateTime localDateTimeJ = J(this.a.O(j / 86400000000L), this.b);
                return localDateTimeJ.H(localDateTimeJ.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimeJ2 = J(this.a.O(j / 86400000), this.b);
                return localDateTimeJ2.H(localDateTimeJ2.a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return G(j);
            case 5:
                return H(this.a, 0L, j, 0L, 0L);
            case 6:
                return H(this.a, j, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimeJ3 = J(this.a.O(j / 256), this.b);
                return localDateTimeJ3.H(localDateTimeJ3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return J(this.a.d(j, sVar), this.b);
        }
    }

    public final LocalDateTime G(long j) {
        return H(this.a, 0L, 0L, j, 0L);
    }

    public final LocalDateTime H(i iVar, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        l lVar = this.b;
        if (j5 == 0) {
            return J(iVar, lVar);
        }
        long j6 = j / 24;
        long jM = lVar.M();
        long j7 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L) + jM;
        long jO = a.O(j7, 86400000000000L) + j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long jN = a.N(j7, 86400000000000L);
        return J(iVar.O(jO), jN == jM ? this.b : l.F(jN));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (LocalDateTime) qVar.p(this, j);
        }
        boolean zA = ((j$.time.temporal.a) qVar).A();
        i iVar = this.a;
        return zA ? J(iVar, this.b.c(j, qVar)) : J(iVar.c(j, qVar), this.b);
    }

    public final LocalDateTime J(i iVar, l lVar) {
        return (this.a == iVar && this.b == lVar) ? this : new LocalDateTime(iVar, lVar);
    }

    @Override // j$.time.chrono.e
    public final j$.time.chrono.a a() {
        return ((i) f()).a();
    }

    @Override // j$.time.chrono.e
    public final l b() {
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
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.a.equals(localDateTime.a) && this.b.equals(localDateTime.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.e
    public final j$.time.chrono.b f() {
        return this.a;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).A() ? this.b.h(qVar) : this.a.h(qVar) : j$.time.temporal.r.a(this, qVar);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ this.a.hashCode();
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(i iVar) {
        return J(iVar, this.b);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.i(this);
        }
        if (!((j$.time.temporal.a) qVar).A()) {
            return this.a.j(qVar);
        }
        l lVar = this.b;
        lVar.getClass();
        return j$.time.temporal.r.d(lVar, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        return mVar.c(((i) f()).t(), j$.time.temporal.a.EPOCH_DAY).c(b().M(), j$.time.temporal.a.NANO_OF_DAY);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        return zVar == j$.time.temporal.r.f ? this.a : a.s(this, zVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m p(long j, j$.time.temporal.b bVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            this = d(Long.MAX_VALUE, bVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return this.d(j2, bVar);
    }

    @Override // j$.time.chrono.e
    public final j$.time.chrono.j q(ZoneId zoneId) {
        return ZonedDateTime.A(this, zoneId, null);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).A() ? this.b.s(qVar) : this.a.s(qVar) : qVar.m(this);
    }

    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.e eVar) {
        return eVar instanceof LocalDateTime ? A((LocalDateTime) eVar) : a.f(this, eVar);
    }
}
