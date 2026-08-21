package j$.time;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements j$.time.temporal.m, j$.time.temporal.n, j$.time.chrono.b, Serializable {
    public static final i d = K(-999999999, 1, 1);
    public static final i e = K(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;
    public final int a;
    public final short b;
    public final short c;

    static {
        K(1970, 1, 1);
    }

    public i(int i, int i2, int i3) {
        this.a = i;
        this.b = (short) i2;
        this.c = (short) i3;
    }

    public static i B(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.c.getClass();
                if (j$.time.chrono.s.O(i)) {
                    i4 = 29;
                }
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    h.e("Invalid date 'February 29' as '", i, "' is not a leap year");
                    return null;
                }
                throw new c("Invalid date '" + n.D(i2).name() + " " + i3 + "'");
            }
        }
        return new i(i, i2, i3);
    }

    public static i C(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        i iVar = (i) temporalAccessor.m(j$.time.temporal.r.f);
        if (iVar != null) {
            return iVar;
        }
        h.g("Unable to obtain LocalDate from TemporalAccessor: ", temporalAccessor, " of type ", temporalAccessor.getClass().getName());
        return null;
    }

    public static i J(b bVar) {
        Objects.requireNonNull(bVar, RtspHeaders.Values.CLOCK);
        Instant instantOfEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zoneId = bVar.a;
        Objects.requireNonNull(instantOfEpochMilli, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return L(a.O(instantOfEpochMilli.getEpochSecond() + ((long) zoneId.C().d(instantOfEpochMilli).b), 86400L));
    }

    public static i K(int i, int i2, int i3) {
        j$.time.temporal.a.YEAR.s(i);
        j$.time.temporal.a.MONTH_OF_YEAR.s(i2);
        j$.time.temporal.a.DAY_OF_MONTH.s(i3);
        return B(i, i2, i3);
    }

    public static i L(long j) {
        long j2;
        j$.time.temporal.a.EPOCH_DAY.s(j);
        long j3 = 719468 + j;
        if (j3 < 0) {
            long j4 = ((j + 719469) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        int i3 = ((i2 + 2) % 12) + 1;
        int i4 = (i - (((i2 * 306) + 5) / 10)) + 1;
        long j7 = j5 + j2 + ((long) (i2 / 10));
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new i(aVar.b.a(j7, aVar), i3, i4);
    }

    public static i M(int i, int i2) {
        long j = i;
        j$.time.temporal.a.YEAR.s(j);
        j$.time.temporal.a.DAY_OF_YEAR.s(i2);
        j$.time.chrono.s.c.getClass();
        boolean zO = j$.time.chrono.s.O(j);
        if (i2 == 366 && !zO) {
            h.e("Invalid date 'DayOfYear 366' as '", i, "' is not a leap year");
            return null;
        }
        n nVarD = n.D(((i2 - 1) / 31) + 1);
        if (i2 > (nVarD.B(zO) + nVarD.A(zO)) - 1) {
            nVarD = n.a[(nVarD.ordinal() + 13) % 12];
        }
        return new i(i, nVarD.getValue(), (i2 - nVarD.A(zO)) + 1);
    }

    public static i S(int i, int i2, int i3) {
        if (i2 == 2) {
            j$.time.chrono.s.c.getClass();
            i3 = Math.min(i3, j$.time.chrono.s.O((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return new i(i, i2, i3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 3, this);
    }

    public final int A(i iVar) {
        int i = this.a - iVar.a;
        return (i == 0 && (i = this.b - iVar.b) == 0) ? this.c - iVar.c : i;
    }

    public final int D(j$.time.temporal.q qVar) {
        switch (g.a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.c;
            case 2:
                return F();
            case 3:
                return ((this.c - 1) / 7) + 1;
            case 4:
                int i = this.a;
                return i >= 1 ? i : 1 - i;
            case 5:
                return E().getValue();
            case 6:
                return ((this.c - 1) % 7) + 1;
            case 7:
                return ((F() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.t("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((F() - 1) / 7) + 1;
            case 10:
                return this.b;
            case 11:
                throw new j$.time.temporal.t("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return this.a;
            case 13:
                return this.a >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    public final e E() {
        return e.A(((int) a.N(t() + 3, 7L)) + 1);
    }

    public final int F() {
        return (n.D(this.b).A(H()) + this.c) - 1;
    }

    public final boolean G(j$.time.chrono.b bVar) {
        return bVar instanceof i ? A((i) bVar) < 0 : t() < bVar.t();
    }

    public final boolean H() {
        j$.time.chrono.s sVar = j$.time.chrono.s.c;
        long j = this.a;
        sVar.getClass();
        return j$.time.chrono.s.O(j);
    }

    public final int I() {
        short s = this.b;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : H() ? 29 : 28;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final i d(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (i) sVar.h(this, j);
        }
        switch (g.b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return O(j);
            case 2:
                return Q(j);
            case 3:
                return P(j);
            case 4:
                return R(j);
            case 5:
                return R(a.P(j, 10L));
            case 6:
                return R(a.P(j, 100L));
            case 7:
                return R(a.P(j, 1000L));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return c(a.K(s(aVar), j), aVar);
            default:
                h.b(sVar, "Unsupported unit: ");
                return null;
        }
    }

    public final i O(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = ((long) this.c) + j;
        if (j2 > 0) {
            if (j2 <= 28) {
                return new i(this.a, this.b, (int) j2);
            }
            if (j2 <= 59) {
                long jI = I();
                if (j2 <= jI) {
                    return new i(this.a, this.b, (int) j2);
                }
                short s = this.b;
                if (s < 12) {
                    return new i(this.a, s + 1, (int) (j2 - jI));
                }
                j$.time.temporal.a.YEAR.s(this.a + 1);
                return new i(this.a + 1, 1, (int) (j2 - jI));
            }
        }
        return L(a.K(t(), j));
    }

    public final i P(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.a) * 12) + ((long) (this.b - 1)) + j;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return S(aVar.b.a(a.O(j2, 12L), aVar), ((int) a.N(j2, 12L)) + 1, this.c);
    }

    public final i Q(long j) {
        return O(a.P(j, 7L));
    }

    public final i R(long j) {
        if (j == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return S(aVar.b.a(((long) this.a) + j, aVar), this.b, this.c);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public final i c(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (i) qVar.p(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.s(j);
        switch (g.a[aVar.ordinal()]) {
            case 1:
                int i = (int) j;
                if (this.c != i) {
                    return K(this.a, this.b, i);
                }
                return this;
            case 2:
                int i2 = (int) j;
                if (F() != i2) {
                    return M(this.a, i2);
                }
                return this;
            case 3:
                return Q(j - s(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.a < 1) {
                    j = 1 - j;
                }
                return V((int) j);
            case 5:
                return O(j - ((long) E().getValue()));
            case 6:
                return O(j - s(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return O(j - s(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return L(j);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return Q(j - s(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i3 = (int) j;
                if (this.b != i3) {
                    j$.time.temporal.a.MONTH_OF_YEAR.s(i3);
                    return S(this.a, i3, this.c);
                }
                return this;
            case 11:
                return P(j - (((((long) this.a) * 12) + ((long) this.b)) - 1));
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return V((int) j);
            case 13:
                if (s(j$.time.temporal.a.ERA) != j) {
                    return V(1 - this.a);
                }
                return this;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.b
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final i o(j$.time.temporal.n nVar) {
        return nVar instanceof i ? (i) nVar : (i) nVar.k(this);
    }

    public final i V(int i) {
        if (this.a == i) {
            return this;
        }
        j$.time.temporal.a.YEAR.s(i);
        return S(i, this.b, this.c);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.a a() {
        return j$.time.chrono.s.c;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean e(j$.time.temporal.q qVar) {
        return a.p(this, qVar);
    }

    @Override // j$.time.chrono.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && A((i) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int h(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? D(qVar) : j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.chrono.b
    public final int hashCode() {
        int i = this.a;
        return (i & (-2048)) ^ (((i << 11) + (this.b << 6)) + this.c);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u j(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.i(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        if (!aVar.isDateBased()) {
            throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
        int i = g.a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.u.f(1L, I());
        }
        if (i == 2) {
            return j$.time.temporal.u.f(1L, H() ? 366 : 365);
        }
        if (i != 3) {
            return i != 4 ? aVar.b : this.a <= 0 ? j$.time.temporal.u.f(1L, 1000000000L) : j$.time.temporal.u.f(1L, 999999999L);
        }
        return j$.time.temporal.u.f(1L, (n.D(this.b) != n.FEBRUARY || H()) ? 5L : 4L);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m k(j$.time.temporal.m mVar) {
        return a.a(this, mVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object m(z zVar) {
        return zVar == j$.time.temporal.r.f ? this : a.r(this, zVar);
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
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.EPOCH_DAY ? t() : qVar == j$.time.temporal.a.PROLEPTIC_MONTH ? ((((long) this.a) * 12) + ((long) this.b)) - 1 : D(qVar) : qVar.m(this);
    }

    @Override // j$.time.chrono.b
    public final long t() {
        long j = this.a;
        long j2 = this.b;
        long j3 = 365 * j;
        long j4 = (((367 * j2) - 362) / 12) + (j >= 0 ? ((j + 399) / 400) + (((3 + j) / 4) - ((99 + j) / 100)) + j3 : j3 - ((j / (-400)) + ((j / (-4)) - (j / (-100))))) + ((long) (this.c - 1));
        if (j2 > 2) {
            j4 = !H() ? j4 - 2 : j4 - 1;
        }
        return j4 - 719528;
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        int i = this.a;
        short s = this.b;
        short s2 = this.c;
        int iAbs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + 10000);
            sb.deleteCharAt(0);
        }
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        return sb.toString();
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.e u(l lVar) {
        return LocalDateTime.D(this, lVar);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.m v() {
        return this.a >= 1 ? j$.time.chrono.t.CE : j$.time.chrono.t.BCE;
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.b x(j$.time.temporal.p pVar) {
        s sVar = (s) pVar;
        return P((((long) sVar.a) * 12) + ((long) sVar.b)).O(sVar.c);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.b bVar) {
        return bVar instanceof i ? A((i) bVar) : a.e(this, bVar);
    }
}
