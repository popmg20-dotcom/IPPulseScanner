package j$.time.temporal;

import j$.time.format.v;
import j$.time.format.w;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements q {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;
    public static final int[] a;
    public static final /* synthetic */ h[] b;

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.q
            public final boolean h(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.e(a.DAY_OF_YEAR) || !temporalAccessor.e(a.MONTH_OF_YEAR) || !temporalAccessor.e(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.a;
                return j$.time.a.J(temporalAccessor).equals(j$.time.chrono.s.c);
            }

            @Override // j$.time.temporal.q
            public final u i(TemporalAccessor temporalAccessor) {
                if (!h(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                long jS = temporalAccessor.s(h.QUARTER_OF_YEAR);
                if (jS != 1) {
                    return jS == 2 ? u.f(1L, 91L) : (jS == 3 || jS == 4) ? u.f(1L, 92L) : k();
                }
                long jS2 = temporalAccessor.s(a.YEAR);
                j$.time.chrono.s.c.getClass();
                return j$.time.chrono.s.O(jS2) ? u.f(1L, 91L) : u.f(1L, 90L);
            }

            @Override // j$.time.temporal.h, j$.time.temporal.q
            public final TemporalAccessor j(Map map, v vVar, w wVar) {
                j$.time.i iVarK;
                long jQ;
                a aVar = a.YEAR;
                HashMap map2 = (HashMap) map;
                Long l = (Long) map2.get(aVar);
                q qVar = h.QUARTER_OF_YEAR;
                Long l2 = (Long) map2.get(qVar);
                if (l != null && l2 != null) {
                    int iA = aVar.b.a(l.longValue(), aVar);
                    long jLongValue = ((Long) map2.get(h.DAY_OF_QUARTER)).longValue();
                    h hVar2 = j.a;
                    if (j$.time.a.J(vVar).equals(j$.time.chrono.s.c)) {
                        if (wVar == w.LENIENT) {
                            iVarK = j$.time.i.K(iA, 1, 1).P(j$.time.a.P(j$.time.a.Q(l2.longValue(), 1L), 3L));
                            jQ = j$.time.a.Q(jLongValue, 1L);
                        } else {
                            iVarK = j$.time.i.K(iA, ((qVar.k().a(l2.longValue(), qVar) - 1) * 3) + 1, 1);
                            if (jLongValue < 1 || jLongValue > 90) {
                                if (wVar == w.STRICT) {
                                    i(iVarK).b(jLongValue, this);
                                } else {
                                    k().b(jLongValue, this);
                                }
                            }
                            jQ = jLongValue - 1;
                        }
                        map2.remove(this);
                        map2.remove(aVar);
                        map2.remove(qVar);
                        return iVarK.O(jQ);
                    }
                    j$.time.h.j("Resolve requires IsoChronology");
                }
                return null;
            }

            @Override // j$.time.temporal.q
            public final u k() {
                return u.g(90L, 92L);
            }

            @Override // j$.time.temporal.q
            public final long m(TemporalAccessor temporalAccessor) {
                if (!h(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                int iH = temporalAccessor.h(a.DAY_OF_YEAR);
                int iH2 = temporalAccessor.h(a.MONTH_OF_YEAR);
                long jS = temporalAccessor.s(a.YEAR);
                int i = (iH2 - 1) / 3;
                j$.time.chrono.s.c.getClass();
                return iH - h.a[i + (j$.time.chrono.s.O(jS) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m p(m mVar, long j) {
                long jM = m(mVar);
                k().b(j, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.c((j - jM) + mVar.s(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.q
            public final boolean h(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.e(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.a;
                return j$.time.a.J(temporalAccessor).equals(j$.time.chrono.s.c);
            }

            @Override // j$.time.temporal.q
            public final u i(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return k();
                }
                throw new t("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.q
            public final u k() {
                return u.f(1L, 4L);
            }

            @Override // j$.time.temporal.q
            public final long m(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return (temporalAccessor.s(a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new t("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.q
            public final m p(m mVar, long j) {
                long jM = m(mVar);
                k().b(j, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.c(((j - jM) * 3) + mVar.s(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.q
            public final boolean h(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.e(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.a;
                return j$.time.a.J(temporalAccessor).equals(j$.time.chrono.s.c);
            }

            @Override // j$.time.temporal.q
            public final u i(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return u.f(1L, h.B(h.A(j$.time.i.C(temporalAccessor))));
                }
                throw new t("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.h, j$.time.temporal.q
            public final TemporalAccessor j(Map map, v vVar, w wVar) {
                j$.time.i iVarC;
                long j;
                q qVar = h.WEEK_BASED_YEAR;
                HashMap map2 = (HashMap) map;
                Long l = (Long) map2.get(qVar);
                a aVar = a.DAY_OF_WEEK;
                Long l2 = (Long) map2.get(aVar);
                if (l != null && l2 != null) {
                    int iA = qVar.k().a(l.longValue(), qVar);
                    long jLongValue = ((Long) map2.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                    h hVar4 = j.a;
                    if (j$.time.a.J(vVar).equals(j$.time.chrono.s.c)) {
                        j$.time.i iVarK = j$.time.i.K(iA, 1, 4);
                        if (wVar == w.LENIENT) {
                            long jLongValue2 = l2.longValue();
                            if (jLongValue2 > 7) {
                                long j2 = jLongValue2 - 1;
                                iVarK = iVarK.Q(j2 / 7);
                                j = j2 % 7;
                            } else {
                                if (jLongValue2 < 1) {
                                    iVarK = iVarK.Q(j$.time.a.Q(jLongValue2, 7L) / 7);
                                    j = (jLongValue2 + 6) % 7;
                                }
                                iVarC = iVarK.Q(j$.time.a.Q(jLongValue, 1L)).c(jLongValue2, aVar);
                            }
                            jLongValue2 = j + 1;
                            iVarC = iVarK.Q(j$.time.a.Q(jLongValue, 1L)).c(jLongValue2, aVar);
                        } else {
                            int iA2 = aVar.b.a(l2.longValue(), aVar);
                            if (jLongValue < 1 || jLongValue > 52) {
                                if (wVar == w.STRICT) {
                                    u.f(1L, h.B(h.A(iVarK))).b(jLongValue, this);
                                } else {
                                    k().b(jLongValue, this);
                                }
                            }
                            iVarC = iVarK.Q(jLongValue - 1).c(iA2, aVar);
                        }
                        map2.remove(this);
                        map2.remove(qVar);
                        map2.remove(aVar);
                        return iVarC;
                    }
                    j$.time.h.j("Resolve requires IsoChronology");
                }
                return null;
            }

            @Override // j$.time.temporal.q
            public final u k() {
                return u.g(52L, 53L);
            }

            @Override // j$.time.temporal.q
            public final long m(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return h.s(j$.time.i.C(temporalAccessor));
                }
                throw new t("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final m p(m mVar, long j) {
                k().b(j, this);
                return mVar.d(j$.time.a.Q(j, m(mVar)), b.WEEKS);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.q
            public final boolean h(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.e(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.a;
                return j$.time.a.J(temporalAccessor).equals(j$.time.chrono.s.c);
            }

            @Override // j$.time.temporal.q
            public final u i(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return a.YEAR.b;
                }
                throw new t("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final u k() {
                return a.YEAR.b;
            }

            @Override // j$.time.temporal.q
            public final long m(TemporalAccessor temporalAccessor) {
                if (h(temporalAccessor)) {
                    return h.A(j$.time.i.C(temporalAccessor));
                }
                throw new t("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final m p(m mVar, long j) {
                if (!h(mVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.b.a(j, h.WEEK_BASED_YEAR);
                j$.time.i iVarC = j$.time.i.C(mVar);
                int iH = iVarC.h(a.DAY_OF_WEEK);
                int iS = h.s(iVarC);
                if (iS == 53 && h.B(iA) == 52) {
                    iS = 52;
                }
                return mVar.o(j$.time.i.K(iA, 1, 4).O(((iS - 1) * 7) + (iH - r3.h(r6))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        b = new h[]{hVar, hVar2, hVar3, hVar4};
        a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static int A(j$.time.i iVar) {
        int i = iVar.a;
        int iF = iVar.F();
        if (iF <= 3) {
            return iF - iVar.E().ordinal() < -2 ? i - 1 : i;
        }
        if (iF >= 363) {
            return ((iF - 363) - (iVar.H() ? 1 : 0)) - iVar.E().ordinal() >= 0 ? i + 1 : i;
        }
        return i;
    }

    public static int B(int i) {
        j$.time.i iVarK = j$.time.i.K(i, 1, 1);
        if (iVarK.E() != j$.time.e.THURSDAY) {
            return (iVarK.E() == j$.time.e.WEDNESDAY && iVarK.H()) ? 53 : 52;
        }
        return 53;
    }

    public static int s(j$.time.i iVar) {
        int iOrdinal = iVar.E().ordinal();
        int iF = iVar.F() - 1;
        int i = (3 - iOrdinal) + iF;
        int i2 = i - ((i / 7) * 7);
        int i3 = i2 - 3;
        if (i3 < -3) {
            i3 = i2 + 4;
        }
        if (iF < i3) {
            if (iVar.F() != 180) {
                iVar = j$.time.i.M(iVar.a, 180);
            }
            return (int) u.f(1L, B(A(iVar.R(-1L)))).d;
        }
        int i4 = ((iF - i3) / 7) + 1;
        if (i4 != 53 || i3 == -3 || (i3 == -2 && iVar.H())) {
            return i4;
        }
        return 1;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) b.clone();
    }

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public TemporalAccessor j(Map map, v vVar, w wVar) {
        return null;
    }
}
