package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {
    public static final /* synthetic */ int b = 0;
    private static final long serialVersionUID = -23038383694477807L;
    public final int a;

    static {
        j$.time.format.o oVar = new j$.time.format.o();
        oVar.h(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.x.EXCEEDS_PAD);
        oVar.l(Locale.getDefault(), j$.time.format.w.SMART, null);
    }

    public v(int i) {
        this.a = i;
    }

    public static v A(int i) {
        j$.time.temporal.a.YEAR.s(i);
        return new v(i);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 11, this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public final v d(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (v) sVar.h(this, j);
        }
        int i = u.b[((j$.time.temporal.b) sVar).ordinal()];
        if (i == 1) {
            return C(j);
        }
        if (i == 2) {
            return C(a.P(j, 10L));
        }
        if (i == 3) {
            return C(a.P(j, 100L));
        }
        if (i == 4) {
            return C(a.P(j, 1000L));
        }
        if (i == 5) {
            j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
            return c(a.K(s(aVar), j), aVar);
        }
        h.b(sVar, "Unsupported unit: ");
        return null;
    }

    public final v C(long j) {
        if (j == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return A(aVar.b.a(((long) this.a) + j, aVar));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final v c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (v) qVar.p(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.s(j);
        int i = u.a[aVar.ordinal()];
        if (i == 1) {
            if (this.a < 1) {
                j = 1 - j;
            }
            return A((int) j);
        }
        if (i == 2) {
            return A((int) j);
        }
        if (i == 3) {
            return s(j$.time.temporal.a.ERA) == j ? this : A(1 - this.a);
        }
        throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.a - ((v) obj).a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.YEAR || qVar == j$.time.temporal.a.YEAR_OF_ERA || qVar == j$.time.temporal.a.ERA : qVar != null && qVar.h(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && this.a == ((v) obj).a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        return j(qVar).a(s(qVar), qVar);
    }

    public final int hashCode() {
        return this.a;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i */
    public final j$.time.temporal.m o(i iVar) {
        return (v) a.a(iVar, this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.u.f(1L, this.a <= 0 ? 1000000000L : 999999999L);
        }
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        if (a.J(mVar).equals(j$.time.chrono.s.c)) {
            return mVar.c(this.a, j$.time.temporal.a.YEAR);
        }
        h.j("Adjustment only supported on ISO date-time");
        return null;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        return zVar == j$.time.temporal.r.b ? j$.time.chrono.s.c : zVar == j$.time.temporal.r.c ? j$.time.temporal.b.YEARS : j$.time.temporal.r.c(this, zVar);
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
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.m(this);
        }
        int i = u.a[((j$.time.temporal.a) qVar).ordinal()];
        if (i == 1) {
            int i2 = this.a;
            if (i2 < 1) {
                i2 = 1 - i2;
            }
            return i2;
        }
        if (i == 2) {
            return this.a;
        }
        if (i == 3) {
            return this.a < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
    }

    public final String toString() {
        return Integer.toString(this.a);
    }
}
