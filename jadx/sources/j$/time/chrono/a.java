package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Comparable {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    static {
        new Locale("ja", "JP", "JP");
    }

    public static a E(String str) {
        Objects.requireNonNull(str, "id");
        while (true) {
            ConcurrentHashMap concurrentHashMap = a;
            a aVar = (a) concurrentHashMap.get(str);
            if (aVar == null) {
                aVar = (a) b.get(str);
            }
            if (aVar != null) {
                return aVar;
            }
            if (concurrentHashMap.get("ISO") != null) {
                for (a aVar2 : ServiceLoader.load(a.class)) {
                    if (str.equals(aVar2.C()) || str.equals(aVar2.B())) {
                        return aVar2;
                    }
                }
                j$.time.h.i(str, "Unknown chronology: ");
                return null;
            }
            o oVar = o.l;
            oVar.getClass();
            H(oVar, "Hijrah-umalqura");
            v vVar = v.c;
            vVar.getClass();
            H(vVar, "Japanese");
            a0 a0Var = a0.c;
            a0Var.getClass();
            H(a0Var, "Minguo");
            g0 g0Var = g0.c;
            g0Var.getClass();
            H(g0Var, "ThaiBuddhist");
            try {
                for (a aVar3 : Arrays.asList(new a[0])) {
                    if (!aVar3.C().equals("ISO")) {
                        H(aVar3, aVar3.C());
                    }
                }
                s sVar = s.c;
                sVar.getClass();
                H(sVar, "ISO");
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static a H(a aVar, String str) {
        String strB;
        a aVar2 = (a) a.putIfAbsent(str, aVar);
        if (aVar2 == null && (strB = aVar.B()) != null) {
            b.putIfAbsent(strB, aVar);
        }
        return aVar2;
    }

    public static b I(b bVar, long j, long j2, long j3) {
        long j4;
        b bVarD = bVar.d(j, (j$.time.temporal.s) j$.time.temporal.b.MONTHS);
        j$.time.temporal.b bVar2 = j$.time.temporal.b.WEEKS;
        b bVarD2 = bVarD.d(j2, (j$.time.temporal.s) bVar2);
        if (j3 <= 7) {
            if (j3 < 1) {
                bVarD2 = bVarD2.d(j$.time.a.Q(j3, 7L) / 7, (j$.time.temporal.s) bVar2);
                j4 = (j3 + 6) % 7;
            }
            return bVarD2.o(new j$.time.temporal.o(j$.time.e.A((int) j3).getValue(), 0));
        }
        long j5 = j3 - 1;
        bVarD2 = bVarD2.d(j5 / 7, (j$.time.temporal.s) bVar2);
        j4 = j5 % 7;
        j3 = j4 + 1;
        return bVarD2.o(new j$.time.temporal.o(j$.time.e.A((int) j3).getValue(), 0));
    }

    public static void h(Map map, j$.time.temporal.a aVar, long j) {
        Long l = (Long) map.get(aVar);
        if (l == null || l.longValue() == j) {
            map.put(aVar, Long.valueOf(j));
            return;
        }
        throw new j$.time.c("Conflict found: " + aVar + " " + l + " differs from " + aVar + " " + j);
    }

    public abstract List A();

    public abstract String B();

    public abstract String C();

    public e D(LocalDateTime localDateTime) {
        try {
            return j(localDateTime).u(j$.time.l.C(localDateTime));
        } catch (j$.time.c e) {
            throw new j$.time.c("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e);
        }
    }

    public abstract int F(m mVar, int i);

    public abstract j$.time.temporal.u G(j$.time.temporal.a aVar);

    public b J(Map map, j$.time.format.w wVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return k(((Long) map.remove(aVar)).longValue());
        }
        K(map, wVar);
        b bVarM = M(map, wVar);
        if (bVarM != null) {
            return bVarM;
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
        if (map.containsKey(aVar2)) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            int i = 0;
            if (map.containsKey(aVar3)) {
                if (map.containsKey(j$.time.temporal.a.DAY_OF_MONTH)) {
                    return L(map, wVar);
                }
                j$.time.temporal.a aVar4 = j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    j$.time.temporal.a aVar5 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                    if (map.containsKey(aVar5)) {
                        int iA = G(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (wVar == j$.time.format.w.LENIENT) {
                            long jQ = j$.time.a.Q(((Long) map.remove(aVar3)).longValue(), 1L);
                            return i(iA, 1, 1).d(jQ, (j$.time.temporal.s) j$.time.temporal.b.MONTHS).d(j$.time.a.Q(((Long) map.remove(aVar4)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.WEEKS).d(j$.time.a.Q(((Long) map.remove(aVar5)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                        }
                        int iA2 = G(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        int iA3 = G(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                        b bVarD = i(iA, iA2, 1).d((G(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((iA3 - 1) * 7), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                        if (wVar != j$.time.format.w.STRICT || bVarD.h(aVar3) == iA2) {
                            return bVarD;
                        }
                        j$.time.h.j("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                    j$.time.temporal.a aVar6 = j$.time.temporal.a.DAY_OF_WEEK;
                    if (map.containsKey(aVar6)) {
                        int iA4 = G(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (wVar == j$.time.format.w.LENIENT) {
                            return I(i(iA4, 1, 1), j$.time.a.Q(((Long) map.remove(aVar3)).longValue(), 1L), j$.time.a.Q(((Long) map.remove(aVar4)).longValue(), 1L), j$.time.a.Q(((Long) map.remove(aVar6)).longValue(), 1L));
                        }
                        int iA5 = G(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        b bVarO = i(iA4, iA5, 1).d((G(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (j$.time.temporal.s) j$.time.temporal.b.DAYS).o(new j$.time.temporal.o(j$.time.e.A(G(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).getValue(), i));
                        if (wVar != j$.time.format.w.STRICT || bVarO.h(aVar3) == iA5) {
                            return bVarO;
                        }
                        j$.time.h.j("Strict mode rejected resolved date as it is in a different month");
                        return null;
                    }
                }
            }
            j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar7)) {
                int iA6 = G(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                if (wVar != j$.time.format.w.LENIENT) {
                    return p(iA6, G(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
                }
                return p(iA6, 1).d(j$.time.a.Q(((Long) map.remove(aVar7)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
            }
            j$.time.temporal.a aVar8 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
            if (map.containsKey(aVar8)) {
                j$.time.temporal.a aVar9 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
                if (map.containsKey(aVar9)) {
                    int iA7 = G(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (wVar == j$.time.format.w.LENIENT) {
                        return p(iA7, 1).d(j$.time.a.Q(((Long) map.remove(aVar8)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.WEEKS).d(j$.time.a.Q(((Long) map.remove(aVar9)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                    }
                    int iA8 = G(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8);
                    b bVarD2 = p(iA7, 1).d((G(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((iA8 - 1) * 7), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                    if (wVar != j$.time.format.w.STRICT || bVarD2.h(aVar2) == iA7) {
                        return bVarD2;
                    }
                    j$.time.h.j("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
                j$.time.temporal.a aVar10 = j$.time.temporal.a.DAY_OF_WEEK;
                if (map.containsKey(aVar10)) {
                    int iA9 = G(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (wVar == j$.time.format.w.LENIENT) {
                        return I(p(iA9, 1), 0L, j$.time.a.Q(((Long) map.remove(aVar8)).longValue(), 1L), j$.time.a.Q(((Long) map.remove(aVar10)).longValue(), 1L));
                    }
                    b bVarO2 = p(iA9, 1).d((G(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (j$.time.temporal.s) j$.time.temporal.b.DAYS).o(new j$.time.temporal.o(j$.time.e.A(G(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).getValue(), i));
                    if (wVar != j$.time.format.w.STRICT || bVarO2.h(aVar2) == iA9) {
                        return bVarO2;
                    }
                    j$.time.h.j("Strict mode rejected resolved date as it is in a different year");
                    return null;
                }
            }
        }
        return null;
    }

    public void K(Map map, j$.time.format.w wVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (wVar != j$.time.format.w.LENIENT) {
                aVar.s(l.longValue());
            }
            b bVarC = m().c(1L, (j$.time.temporal.q) j$.time.temporal.a.DAY_OF_MONTH).c(l.longValue(), (j$.time.temporal.q) aVar);
            h(map, j$.time.temporal.a.MONTH_OF_YEAR, bVarC.h(r6));
            h(map, j$.time.temporal.a.YEAR, bVarC.h(r6));
        }
    }

    public b L(Map map, j$.time.format.w wVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = G(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (wVar == j$.time.format.w.LENIENT) {
            long jQ = j$.time.a.Q(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return i(iA, 1, 1).d(jQ, (j$.time.temporal.s) j$.time.temporal.b.MONTHS).d(j$.time.a.Q(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = G(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = G(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (wVar != j$.time.format.w.SMART) {
            return i(iA, iA2, iA3);
        }
        try {
            return i(iA, iA2, iA3);
        } catch (j$.time.c unused) {
            return this.i(iA, iA2, 1).o(new j$.time.z(2));
        }
    }

    public b M(Map map, j$.time.format.w wVar) {
        int iA;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l = (Long) map.remove(aVar);
        if (l == null) {
            j$.time.temporal.a aVar2 = j$.time.temporal.a.ERA;
            if (!map.containsKey(aVar2)) {
                return null;
            }
            G(aVar2).b(((Long) map.get(aVar2)).longValue(), aVar2);
            return null;
        }
        Long l2 = (Long) map.remove(j$.time.temporal.a.ERA);
        if (wVar != j$.time.format.w.LENIENT) {
            iA = G(aVar).a(l.longValue(), aVar);
        } else {
            long jLongValue = l.longValue();
            int i = (int) jLongValue;
            if (jLongValue != i) {
                throw new ArithmeticException();
            }
            iA = i;
        }
        if (l2 != null) {
            h(map, j$.time.temporal.a.YEAR, F(s(G(r2).a(l2.longValue(), r2)), iA));
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.YEAR;
        if (map.containsKey(aVar3)) {
            h(map, aVar3, F(p(G(aVar3).a(((Long) map.get(aVar3)).longValue(), aVar3), 1).v(), iA));
            return null;
        }
        if (wVar == j$.time.format.w.STRICT) {
            map.put(aVar, l);
            return null;
        }
        if (A().isEmpty()) {
            h(map, aVar3, iA);
            return null;
        }
        h(map, aVar3, F((m) r11.get(r11.size() - 1), iA));
        return null;
    }

    public abstract j N(Instant instant, ZoneId zoneId);

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return C().compareTo(((a) obj).C());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && C().compareTo(((a) obj).C()) == 0;
    }

    public final int hashCode() {
        return C().hashCode() ^ getClass().hashCode();
    }

    public abstract b i(int i, int i2, int i3);

    public abstract b j(TemporalAccessor temporalAccessor);

    public abstract b k(long j);

    public abstract /* synthetic */ b m();

    public abstract b p(int i, int i2);

    public abstract m s(int i);

    public final String toString() {
        return C();
    }
}
