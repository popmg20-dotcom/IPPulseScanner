package j$.time;

import j$.time.format.DateTimeFormatter;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {
    public static final Instant c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;
    public final long a;
    public final int b;

    static {
        B(-31557014167219200L, 0L);
        B(31556889864403199L, 999999999L);
    }

    public Instant(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public static Instant A(long j, int i) {
        if ((((long) i) | j) == 0) {
            return c;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new Instant(j, i);
        }
        h.j("Instant exceeds minimum or maximum instant");
        return null;
    }

    public static Instant B(long j, long j2) {
        return A(a.K(j, a.O(j2, 1000000000L)), (int) a.N(j2, 1000000000L));
    }

    public static Instant now() {
        b.b.getClass();
        return ofEpochMilli(System.currentTimeMillis());
    }

    public static Instant ofEpochMilli(long j) {
        return A(a.O(j, 1000L), ((int) a.N(j, 1000L)) * 1000000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 2, this);
    }

    public final Instant C(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return B(a.K(a.K(this.a, j), j2 / 1000000000), ((long) this.b) + (j2 % 1000000000));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final Instant d(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (Instant) sVar.h(this, j);
        }
        switch (f.b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return C(0L, j);
            case 2:
                return C(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return C(j / 1000, (j % 1000) * 1000000);
            case 4:
                return C(j, 0L);
            case 5:
                return C(a.P(j, 60L), 0L);
            case 6:
                return C(a.P(j, 3600L), 0L);
            case 7:
                return C(a.P(j, 43200L), 0L);
            case 8:
                return C(a.P(j, 86400L), 0L);
            default:
                h.b(sVar, "Unsupported unit: ");
                return null;
        }
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.A(this, zoneOffset);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (Instant) qVar.p(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.s(j);
        int i = f.a[aVar.ordinal()];
        if (i == 1) {
            return j != ((long) this.b) ? A(this.a, (int) j) : this;
        }
        if (i == 2) {
            int i2 = ((int) j) * 1000;
            return i2 != this.b ? A(this.a, i2) : this;
        }
        if (i == 3) {
            int i3 = ((int) j) * 1000000;
            return i3 != this.b ? A(this.a, i3) : this;
        }
        if (i == 4) {
            return j != this.a ? A(j, this.b) : this;
        }
        throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.a, instant2.a);
        return iCompare != 0 ? iCompare : this.b - instant2.b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND : qVar != null && qVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.a == instant.a && this.b == instant.b) {
                return true;
            }
        }
        return false;
    }

    public long getEpochSecond() {
        return this.a;
    }

    public int getNano() {
        return this.b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.r.d(this, qVar).a(qVar.m(this), qVar);
        }
        int i = f.a[((j$.time.temporal.a) qVar).ordinal()];
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return this.b / 1000;
        }
        if (i == 3) {
            return this.b / 1000000;
        }
        if (i == 4) {
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            aVar.b.a(this.a, aVar);
        }
        throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
    }

    public final int hashCode() {
        long j = this.a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(i iVar) {
        return (Instant) a.a(iVar, this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        return mVar.c(this.a, j$.time.temporal.a.INSTANT_SECONDS).c(this.b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        if (zVar == j$.time.temporal.r.c) {
            return j$.time.temporal.b.NANOS;
        }
        if (zVar == j$.time.temporal.r.b || zVar == j$.time.temporal.r.a || zVar == j$.time.temporal.r.e || zVar == j$.time.temporal.r.d || zVar == j$.time.temporal.r.f || zVar == j$.time.temporal.r.g) {
            return null;
        }
        return zVar.g(this);
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

    @Override // j$.time.temporal.TemporalAccessor
    public final long s(j$.time.temporal.q qVar) {
        int i;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.m(this);
        }
        int i2 = f.a[((j$.time.temporal.a) qVar).ordinal()];
        if (i2 == 1) {
            i = this.b;
        } else if (i2 == 2) {
            i = this.b / 1000;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    return this.a;
                }
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
            }
            i = this.b / 1000000;
        }
        return i;
    }

    public final String toString() {
        return DateTimeFormatter.ISO_INSTANT.format(this);
    }
}
