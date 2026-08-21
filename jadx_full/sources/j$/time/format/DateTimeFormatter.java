package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_INSTANT;
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public static final DateTimeFormatter f;
    public final d a;
    public final Locale b;
    public final u c;
    public final w d;
    public final j$.time.chrono.a e;

    static {
        o oVar = new o();
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        x xVar = x.EXCEEDS_PAD;
        oVar.h(aVar, 4, 10, xVar);
        oVar.c('-');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        oVar.g(aVar2, 2);
        oVar.c('-');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        oVar.g(aVar3, 2);
        w wVar = w.STRICT;
        j$.time.chrono.s sVar = j$.time.chrono.s.c;
        DateTimeFormatter dateTimeFormatterK = oVar.k(wVar, sVar);
        ISO_LOCAL_DATE = dateTimeFormatterK;
        o oVar2 = new o();
        l lVar = l.INSENSITIVE;
        oVar2.b(lVar);
        oVar2.a(dateTimeFormatterK);
        i iVar = i.e;
        oVar2.b(iVar);
        oVar2.k(wVar, sVar);
        o oVar3 = new o();
        oVar3.b(lVar);
        oVar3.a(dateTimeFormatterK);
        oVar3.j();
        oVar3.b(iVar);
        oVar3.k(wVar, sVar);
        o oVar4 = new o();
        j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
        oVar4.g(aVar4, 2);
        oVar4.c(':');
        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
        oVar4.g(aVar5, 2);
        oVar4.j();
        oVar4.c(':');
        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
        oVar4.g(aVar6, 2);
        oVar4.j();
        oVar4.b(new f(j$.time.temporal.a.NANO_OF_SECOND));
        DateTimeFormatter dateTimeFormatterK2 = oVar4.k(wVar, null);
        o oVar5 = new o();
        oVar5.b(lVar);
        oVar5.a(dateTimeFormatterK2);
        oVar5.b(iVar);
        oVar5.k(wVar, null);
        o oVar6 = new o();
        oVar6.b(lVar);
        oVar6.a(dateTimeFormatterK2);
        oVar6.j();
        oVar6.b(iVar);
        oVar6.k(wVar, null);
        o oVar7 = new o();
        oVar7.b(lVar);
        oVar7.a(dateTimeFormatterK);
        oVar7.c('T');
        oVar7.a(dateTimeFormatterK2);
        DateTimeFormatter dateTimeFormatterK3 = oVar7.k(wVar, sVar);
        o oVar8 = new o();
        oVar8.b(lVar);
        oVar8.a(dateTimeFormatterK3);
        l lVar2 = l.LENIENT;
        oVar8.b(lVar2);
        oVar8.b(iVar);
        l lVar3 = l.STRICT;
        oVar8.b(lVar3);
        DateTimeFormatter dateTimeFormatterK4 = oVar8.k(wVar, sVar);
        o oVar9 = new o();
        oVar9.a(dateTimeFormatterK4);
        oVar9.j();
        oVar9.c('[');
        l lVar4 = l.SENSITIVE;
        oVar9.b(lVar4);
        int i = 1;
        oVar9.b(new g(i));
        oVar9.c(']');
        f = oVar9.k(wVar, sVar);
        o oVar10 = new o();
        oVar10.a(dateTimeFormatterK3);
        oVar10.j();
        oVar10.b(iVar);
        oVar10.j();
        oVar10.c('[');
        oVar10.b(lVar4);
        oVar10.b(new g(i));
        oVar10.c(']');
        oVar10.k(wVar, sVar);
        o oVar11 = new o();
        oVar11.b(lVar);
        oVar11.h(aVar, 4, 10, xVar);
        oVar11.c('-');
        oVar11.g(j$.time.temporal.a.DAY_OF_YEAR, 3);
        oVar11.j();
        oVar11.b(iVar);
        oVar11.k(wVar, sVar);
        o oVar12 = new o();
        oVar12.b(lVar);
        oVar12.h(j$.time.temporal.j.c, 4, 10, xVar);
        oVar12.d("-W");
        oVar12.g(j$.time.temporal.j.b, 2);
        oVar12.c('-');
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_WEEK;
        oVar12.g(aVar7, 1);
        oVar12.j();
        oVar12.b(iVar);
        oVar12.k(wVar, sVar);
        o oVar13 = new o();
        oVar13.b(lVar);
        oVar13.b(new g(0));
        ISO_INSTANT = oVar13.k(wVar, null);
        o oVar14 = new o();
        oVar14.b(lVar);
        oVar14.g(aVar, 4);
        oVar14.g(aVar2, 2);
        oVar14.g(aVar3, 2);
        oVar14.j();
        oVar14.b(lVar2);
        oVar14.b(new i("+HHMMss", "Z"));
        oVar14.b(lVar3);
        oVar14.k(wVar, sVar);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        o oVar15 = new o();
        oVar15.b(lVar);
        oVar15.b(lVar2);
        oVar15.j();
        oVar15.e(aVar7, map);
        oVar15.d(", ");
        oVar15.i();
        oVar15.h(aVar3, 1, 2, x.NOT_NEGATIVE);
        oVar15.c(' ');
        oVar15.e(aVar2, map2);
        oVar15.c(' ');
        oVar15.g(aVar, 4);
        oVar15.c(' ');
        oVar15.g(aVar4, 2);
        oVar15.c(':');
        oVar15.g(aVar5, 2);
        oVar15.j();
        oVar15.c(':');
        oVar15.g(aVar6, 2);
        oVar15.i();
        oVar15.c(' ');
        oVar15.b(new i("+HHMM", "GMT"));
        oVar15.k(w.SMART, sVar);
    }

    public DateTimeFormatter(d dVar, Locale locale, w wVar, j$.time.chrono.a aVar) {
        u uVar = u.a;
        this.a = (d) Objects.requireNonNull(dVar, "printerParser");
        this.b = (Locale) Objects.requireNonNull(locale, "locale");
        this.c = (u) Objects.requireNonNull(uVar, "decimalStyle");
        this.d = (w) Objects.requireNonNull(wVar, "resolverStyle");
        this.e = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0262  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final v a(CharSequence charSequence) {
        long j;
        j$.time.s sVar;
        j$.time.s sVar2;
        int i = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        Objects.requireNonNull(charSequence, "text");
        Objects.requireNonNull(parsePosition, "position");
        p pVar = new p(this);
        int i2 = this.a.i(pVar, charSequence, parsePosition.getIndex());
        if (i2 < 0) {
            parsePosition.setErrorIndex(~i2);
            pVar = null;
        } else {
            parsePosition.setIndex(i2);
        }
        if (pVar == null || parsePosition.getErrorIndex() >= 0 || parsePosition.getIndex() < charSequence.length()) {
            String string = charSequence.length() > 64 ? charSequence.subSequence(0, 64).toString() + "..." : charSequence.toString();
            if (parsePosition.getErrorIndex() >= 0) {
                String str = "Text '" + string + "' could not be parsed at index " + parsePosition.getErrorIndex();
                parsePosition.getErrorIndex();
                throw new DateTimeParseException(str, charSequence);
            }
            String str2 = "Text '" + string + "' could not be parsed, unparsed text found at index " + parsePosition.getIndex();
            parsePosition.getIndex();
            throw new DateTimeParseException(str2, charSequence);
        }
        v vVarC = pVar.c();
        j$.time.chrono.a aVar = pVar.c().c;
        if (aVar == null && (aVar = pVar.a.e) == null) {
            aVar = j$.time.chrono.s.c;
        }
        vVarC.c = aVar;
        ZoneId zoneId = vVarC.b;
        if (zoneId == null) {
            zoneId = null;
        }
        vVarC.b = zoneId;
        vVarC.e = this.d;
        vVarC.A();
        vVarC.F(vVarC.c.J(vVarC.a, vVarC.e));
        vVarC.D();
        if (((HashMap) vVarC.a).size() > 0) {
            loop0: while (i < 50) {
                Iterator it = ((HashMap) vVarC.a).entrySet().iterator();
                while (it.hasNext()) {
                    j$.time.temporal.q qVar = (j$.time.temporal.q) ((Map.Entry) it.next()).getKey();
                    TemporalAccessor temporalAccessorJ = qVar.j(vVarC.a, vVarC, vVarC.e);
                    if (temporalAccessorJ == null) {
                        if (!((HashMap) vVarC.a).containsKey(qVar)) {
                            break;
                        }
                    } else {
                        if (temporalAccessorJ instanceof j$.time.chrono.j) {
                            j$.time.chrono.j jVar = (j$.time.chrono.j) temporalAccessorJ;
                            ZoneId zoneId2 = vVarC.b;
                            if (zoneId2 == null) {
                                vVarC.b = jVar.r();
                            } else if (!zoneId2.equals(jVar.r())) {
                                throw new j$.time.c("ChronoZonedDateTime must use the effective parsed zone: " + vVarC.b);
                            }
                            temporalAccessorJ = jVar.l();
                        }
                        if (temporalAccessorJ instanceof j$.time.chrono.e) {
                            j$.time.chrono.e eVar = (j$.time.chrono.e) temporalAccessorJ;
                            vVarC.E(eVar.b(), j$.time.s.d);
                            vVarC.F(eVar.f());
                        } else if (temporalAccessorJ instanceof j$.time.chrono.b) {
                            vVarC.F((j$.time.chrono.b) temporalAccessorJ);
                        } else {
                            if (!(temporalAccessorJ instanceof j$.time.l)) {
                                j$.time.h.j("Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime");
                                return null;
                            }
                            vVarC.E((j$.time.l) temporalAccessorJ, j$.time.s.d);
                        }
                    }
                    i++;
                }
            }
            if (i == 50) {
                j$.time.h.j("One of the parsed fields has an incorrectly implemented resolve method");
                return null;
            }
            if (i > 0) {
                vVarC.A();
                vVarC.F(vVarC.c.J(vVarC.a, vVarC.e));
                vVarC.D();
            }
        }
        if (vVarC.g == null) {
            Map map = vVarC.a;
            j$.time.temporal.a aVar2 = j$.time.temporal.a.MILLI_OF_SECOND;
            boolean zContainsKey = ((HashMap) map).containsKey(aVar2);
            Map map2 = vVarC.a;
            if (zContainsKey) {
                long jLongValue = ((Long) ((HashMap) map2).remove(aVar2)).longValue();
                Map map3 = vVarC.a;
                j$.time.temporal.a aVar3 = j$.time.temporal.a.MICRO_OF_SECOND;
                boolean zContainsKey2 = ((HashMap) map3).containsKey(aVar3);
                Map map4 = vVarC.a;
                if (zContainsKey2) {
                    long jLongValue2 = (((Long) ((HashMap) map4).get(aVar3)).longValue() % 1000) + (jLongValue * 1000);
                    vVarC.G(aVar2, aVar3, Long.valueOf(jLongValue2));
                    ((HashMap) vVarC.a).remove(aVar3);
                    ((HashMap) vVarC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue2 * 1000));
                } else {
                    ((HashMap) map4).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue * 1000000));
                }
            } else {
                j$.time.temporal.a aVar4 = j$.time.temporal.a.MICRO_OF_SECOND;
                if (((HashMap) map2).containsKey(aVar4)) {
                    ((HashMap) vVarC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(((Long) ((HashMap) vVarC.a).remove(aVar4)).longValue() * 1000));
                }
            }
            Map map5 = vVarC.a;
            j$.time.temporal.a aVar5 = j$.time.temporal.a.HOUR_OF_DAY;
            Long l = (Long) ((HashMap) map5).get(aVar5);
            if (l != null) {
                Map map6 = vVarC.a;
                j$.time.temporal.a aVar6 = j$.time.temporal.a.MINUTE_OF_HOUR;
                Long l2 = (Long) ((HashMap) map6).get(aVar6);
                Map map7 = vVarC.a;
                j$.time.temporal.a aVar7 = j$.time.temporal.a.SECOND_OF_MINUTE;
                Long l3 = (Long) ((HashMap) map7).get(aVar7);
                Map map8 = vVarC.a;
                j$.time.temporal.a aVar8 = j$.time.temporal.a.NANO_OF_SECOND;
                Long l4 = (Long) ((HashMap) map8).get(aVar8);
                if ((l2 != null || (l3 == null && l4 == null)) && (l2 == null || l3 != null || l4 == null)) {
                    j = 1000000;
                    vVarC.C(l.longValue(), l2 != null ? l2.longValue() : 0L, l3 != null ? l3.longValue() : 0L, l4 != null ? l4.longValue() : 0L);
                    ((HashMap) vVarC.a).remove(aVar5);
                    ((HashMap) vVarC.a).remove(aVar6);
                    ((HashMap) vVarC.a).remove(aVar7);
                    ((HashMap) vVarC.a).remove(aVar8);
                } else {
                    j = 1000000;
                }
            } else {
                j = 1000000;
            }
            if (vVarC.e != w.LENIENT && ((HashMap) vVarC.a).size() > 0) {
                for (Map.Entry entry : ((HashMap) vVarC.a).entrySet()) {
                    j$.time.temporal.q qVar2 = (j$.time.temporal.q) entry.getKey();
                    if (qVar2 instanceof j$.time.temporal.a) {
                        j$.time.temporal.a aVar9 = (j$.time.temporal.a) qVar2;
                        if (aVar9.A()) {
                            aVar9.s(((Long) entry.getValue()).longValue());
                        }
                    }
                }
            }
        }
        j$.time.chrono.b bVar = vVarC.f;
        if (bVar != null) {
            vVarC.k(bVar);
        }
        j$.time.l lVar = vVarC.g;
        if (lVar != null) {
            vVarC.k(lVar);
            if (vVarC.f != null && ((HashMap) vVarC.a).size() > 0) {
                vVarC.k(vVarC.f.u(vVarC.g));
            }
        }
        j$.time.chrono.b bVar2 = vVarC.f;
        if (bVar2 != null && vVarC.g != null && (sVar = vVarC.h) != (sVar2 = j$.time.s.d)) {
            vVarC.f = bVar2.x(sVar);
            vVarC.h = sVar2;
        }
        if (vVarC.g == null) {
            if (!((HashMap) vVarC.a).containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
                if (!((HashMap) vVarC.a).containsKey(j$.time.temporal.a.SECOND_OF_DAY)) {
                    if (((HashMap) vVarC.a).containsKey(j$.time.temporal.a.SECOND_OF_MINUTE)) {
                        Map map9 = vVarC.a;
                        j$.time.temporal.a aVar10 = j$.time.temporal.a.NANO_OF_SECOND;
                        boolean zContainsKey3 = ((HashMap) map9).containsKey(aVar10);
                        Map map10 = vVarC.a;
                        if (zContainsKey3) {
                            long jLongValue3 = ((Long) ((HashMap) map10).get(aVar10)).longValue();
                            ((HashMap) vVarC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue3 / 1000));
                            ((HashMap) vVarC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue3 / j));
                        } else {
                            ((HashMap) map10).put(aVar10, 0L);
                            ((HashMap) vVarC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, 0L);
                            ((HashMap) vVarC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, 0L);
                        }
                    }
                }
            }
        }
        if (vVarC.f != null && vVarC.g != null) {
            Long l5 = (Long) ((HashMap) vVarC.a).get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l5 != null) {
                ((HashMap) vVarC.a).put(j$.time.temporal.a.INSTANT_SECONDS, Long.valueOf(vVarC.f.u(vVarC.g).q(ZoneOffset.J(l5.intValue())).z()));
                return vVarC;
            }
            if (vVarC.b != null) {
                ((HashMap) vVarC.a).put(j$.time.temporal.a.INSTANT_SECONDS, Long.valueOf(vVarC.f.u(vVarC.g).q(vVarC.b).z()));
            }
        }
        return vVarC;
    }

    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        d dVar = this.a;
        Objects.requireNonNull(temporalAccessor, "temporal");
        Objects.requireNonNull(sb, "appendable");
        try {
            dVar.h(new r(temporalAccessor, this), sb);
            return sb.toString();
        } catch (IOException e) {
            throw new j$.time.c(e.getMessage(), e);
        }
    }

    public final String toString() {
        String string = this.a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }
}
