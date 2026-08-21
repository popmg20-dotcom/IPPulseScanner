package j$.time;

import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeParseException;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.m, j$.time.chrono.j, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;
    public final LocalDateTime a;
    public final ZoneOffset b;
    public final ZoneId c;

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.a = localDateTime;
        this.b = zoneOffset;
        this.c = zoneId;
    }

    public static ZonedDateTime A(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f fVarC = zoneId.C();
        List listF = fVarC.f(localDateTime);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() == 0) {
            Object objE = fVarC.e(localDateTime);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            localDateTime = localDateTime.G(Duration.ofSeconds(bVar.d.b - bVar.c.b).a);
            zoneOffset = bVar.d;
        } else if (zoneOffset == null || !listF.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) Objects.requireNonNull((ZoneOffset) listF.get(0), "offset");
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime k(long j, int i, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.C().d(Instant.B(j, i));
        return new ZonedDateTime(LocalDateTime.E(j, i, zoneOffsetD), zoneId, zoneOffsetD);
    }

    public static ZonedDateTime parse(CharSequence charSequence) {
        String string;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.f;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        z zVar = new z(0);
        dateTimeFormatter.getClass();
        Objects.requireNonNull(charSequence, "text");
        Objects.requireNonNull(zVar, "query");
        try {
            return (ZonedDateTime) dateTimeFormatter.a(charSequence).m(zVar);
        } catch (DateTimeParseException e) {
            throw e;
        } catch (RuntimeException e2) {
            if (charSequence.length() > 64) {
                string = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                string = charSequence.toString();
            }
            DateTimeParseException dateTimeParseException = new DateTimeParseException("Text '" + string + "' could not be parsed: " + e2.getMessage(), e2);
            charSequence.toString();
            throw dateTimeParseException;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 6, this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime d(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (ZonedDateTime) sVar.h(this, j);
        }
        j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
        if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0 && bVar != j$.time.temporal.b.FOREVER) {
            return A(this.a.d(j, sVar), this.c, this.b);
        }
        LocalDateTime localDateTimeF = this.a.d(j, sVar);
        ZoneOffset zoneOffset = this.b;
        ZoneId zoneId = this.c;
        Objects.requireNonNull(localDateTimeF, "localDateTime");
        Objects.requireNonNull(zoneOffset, "offset");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId.C().f(localDateTimeF).contains(zoneOffset)) {
            return new ZonedDateTime(localDateTimeF, zoneId, zoneOffset);
        }
        localDateTimeF.getClass();
        return k(a.v(localDateTimeF, zoneOffset), localDateTimeF.b.d, zoneId);
    }

    @Override // j$.time.chrono.j
    public final j$.time.chrono.a a() {
        return ((i) f()).a();
    }

    @Override // j$.time.chrono.j
    public final l b() {
        return this.a.b;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (ZonedDateTime) qVar.p(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i = a0.a[aVar.ordinal()];
        if (i == 1) {
            return k(j, this.a.b.d, this.c);
        }
        if (i != 2) {
            return A(this.a.c(j, qVar), this.c, this.b);
        }
        ZoneOffset zoneOffsetJ = ZoneOffset.J(aVar.b.a(j, aVar));
        return (zoneOffsetJ.equals(this.b) || !this.c.C().f(this.a).contains(zoneOffsetJ)) ? this : new ZonedDateTime(this.a, this.c, zoneOffsetJ);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return a.g(this, (j$.time.chrono.j) obj);
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
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.a.equals(zonedDateTime.a) && this.b.equals(zonedDateTime.b) && this.c.equals(zonedDateTime.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.j
    public final j$.time.chrono.b f() {
        return this.a.a;
    }

    @Override // j$.time.chrono.j
    public final ZoneOffset g() {
        return this.b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return a.k(this, qVar);
        }
        int i = a0.a[((j$.time.temporal.a) qVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.h(qVar) : this.b.b;
        }
        throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.c.hashCode(), 3) ^ (this.a.hashCode() ^ this.b.b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(i iVar) {
        return A(LocalDateTime.D(iVar, this.a.b), this.c, this.b);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) ? ((j$.time.temporal.a) qVar).b : this.a.j(qVar) : qVar.i(this);
    }

    @Override // j$.time.chrono.j
    public final j$.time.chrono.e l() {
        return this.a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        return zVar == j$.time.temporal.r.f ? this.a.a : a.t(this, zVar);
    }

    @Override // j$.time.chrono.j
    public final j$.time.chrono.j n(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.c.equals(zoneId) ? this : A(this.a, zoneId, this.b);
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

    @Override // j$.time.chrono.j
    public final ZoneId r() {
        return this.c;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.m(this);
        }
        int i = a0.a[((j$.time.temporal.a) qVar).ordinal()];
        return i != 1 ? i != 2 ? this.a.s(qVar) : this.b.b : a.w(this);
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
        return a.w(this);
    }
}
