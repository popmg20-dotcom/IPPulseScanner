package j$.time.temporal;

import j$.time.format.v;
import j$.time.format.w;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;
    public final transient String a;
    public final transient u b;
    public final transient long c;

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j) {
        this.a = str;
        this.b = u.f((-365243219162L) + j, 365241780471L + j);
        this.c = j;
    }

    @Override // j$.time.temporal.q
    public final boolean h(TemporalAccessor temporalAccessor) {
        return temporalAccessor.e(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u i(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.e(a.EPOCH_DAY)) {
            return this.b;
        }
        j$.time.h.i(this, "Unsupported field: ");
        return null;
    }

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    @Override // j$.time.temporal.q
    public final TemporalAccessor j(Map map, v vVar, w wVar) {
        long jLongValue = ((Long) ((HashMap) map).remove(this)).longValue();
        j$.time.chrono.a aVarJ = j$.time.a.J(vVar);
        w wVar2 = w.LENIENT;
        long j = this.c;
        if (wVar == wVar2) {
            return aVarJ.k(j$.time.a.Q(jLongValue, j));
        }
        this.b.b(jLongValue, this);
        return aVarJ.k(jLongValue - j);
    }

    @Override // j$.time.temporal.q
    public final u k() {
        return this.b;
    }

    @Override // j$.time.temporal.q
    public final long m(TemporalAccessor temporalAccessor) {
        return temporalAccessor.s(a.EPOCH_DAY) + this.c;
    }

    @Override // j$.time.temporal.q
    public final m p(m mVar, long j) {
        if (this.b.e(j)) {
            return mVar.c(j$.time.a.Q(j, this.c), a.EPOCH_DAY);
        }
        throw new j$.time.c("Invalid value: " + this.a + " " + j);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }
}
