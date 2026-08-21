package j$.time.format;

import j$.time.temporal.TemporalAccessor;
import j$.util.Objects;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.format.v a(java.lang.CharSequence r24) {
        /*
            Method dump skipped, instruction units count: 1078
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatter.a(java.lang.CharSequence):j$.time.format.v");
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
