package j$.time.format;

import j$.time.z;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final z f = new z(1);
    public o a;
    public final o b;
    public final List c;
    public final boolean d;
    public int e;

    static {
        HashMap map = new HashMap();
        map.put('G', j$.time.temporal.a.ERA);
        map.put('y', j$.time.temporal.a.YEAR_OF_ERA);
        map.put('u', j$.time.temporal.a.YEAR);
        j$.time.temporal.h hVar = j$.time.temporal.j.a;
        map.put('Q', hVar);
        map.put('q', hVar);
        j$.time.temporal.a aVar = j$.time.temporal.a.MONTH_OF_YEAR;
        map.put('M', aVar);
        map.put('L', aVar);
        map.put('D', j$.time.temporal.a.DAY_OF_YEAR);
        map.put('d', j$.time.temporal.a.DAY_OF_MONTH);
        map.put('F', j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.DAY_OF_WEEK;
        map.put('E', aVar2);
        map.put('c', aVar2);
        map.put('e', aVar2);
        map.put('a', j$.time.temporal.a.AMPM_OF_DAY);
        map.put('H', j$.time.temporal.a.HOUR_OF_DAY);
        map.put('k', j$.time.temporal.a.CLOCK_HOUR_OF_DAY);
        map.put('K', j$.time.temporal.a.HOUR_OF_AMPM);
        map.put('h', j$.time.temporal.a.CLOCK_HOUR_OF_AMPM);
        map.put('m', j$.time.temporal.a.MINUTE_OF_HOUR);
        map.put('s', j$.time.temporal.a.SECOND_OF_MINUTE);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.NANO_OF_SECOND;
        map.put('S', aVar3);
        map.put('A', j$.time.temporal.a.MILLI_OF_DAY);
        map.put('n', aVar3);
        map.put('N', j$.time.temporal.a.NANO_OF_DAY);
        map.put('g', j$.time.temporal.l.a);
    }

    public o() {
        this.a = this;
        this.c = new ArrayList();
        this.e = -1;
        this.b = null;
        this.d = false;
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        d dVar = dateTimeFormatter.a;
        if (dVar.b) {
            dVar = new d(dVar.a, false);
        }
        b(dVar);
    }

    public final int b(e eVar) {
        Objects.requireNonNull(eVar, "pp");
        o oVar = this.a;
        oVar.getClass();
        ((ArrayList) oVar.c).add(eVar);
        this.a.e = -1;
        return ((ArrayList) r1.c).size() - 1;
    }

    public final void c(char c) {
        b(new c(c));
    }

    public final void d(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            b(new c(str.charAt(0)));
        } else {
            b(new m(str));
        }
    }

    public final void e(j$.time.temporal.a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        Objects.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        y yVar = y.FULL;
        b(new n(aVar, yVar, new a(new t(Collections.singletonMap(yVar, linkedHashMap)))));
    }

    public final void f(h hVar) {
        h hVarB;
        o oVar = this.a;
        int i = oVar.e;
        if (i < 0) {
            oVar.e = b(hVar);
            return;
        }
        h hVar2 = (h) ((ArrayList) oVar.c).get(i);
        int i2 = hVar.b;
        int i3 = hVar.c;
        if (i2 == i3 && hVar.d == x.NOT_NEGATIVE) {
            hVarB = hVar2.c(i3);
            b(hVar.b());
            this.a.e = i;
        } else {
            hVarB = hVar2.b();
            this.a.e = b(hVar);
        }
        ((ArrayList) this.a.c).set(i, hVarB);
    }

    public final void g(j$.time.temporal.q qVar, int i) {
        Objects.requireNonNull(qVar, "field");
        if (i < 1 || i > 19) {
            j$.time.h.k("The width must be from 1 to 19 inclusive but was ", i);
        } else {
            f(new h(qVar, i, i, x.NOT_NEGATIVE));
        }
    }

    public final void h(j$.time.temporal.q qVar, int i, int i2, x xVar) {
        if (i == i2 && xVar == x.NOT_NEGATIVE) {
            g(qVar, i2);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(xVar, "signStyle");
        if (i < 1 || i > 19) {
            j$.time.h.k("The minimum width must be from 1 to 19 inclusive but was ", i);
            return;
        }
        if (i2 < 1 || i2 > 19) {
            j$.time.h.k("The maximum width must be from 1 to 19 inclusive but was ", i2);
            return;
        }
        if (i2 >= i) {
            f(new h(qVar, i, i2, xVar));
            return;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
    }

    public final void i() {
        o oVar = this.a;
        if (oVar.b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        int size = ((ArrayList) oVar.c).size();
        o oVar2 = this.a;
        if (size <= 0) {
            this.a = oVar2.b;
            return;
        }
        d dVar = new d(oVar2.c, oVar2.d);
        this.a = this.a.b;
        b(dVar);
    }

    public final void j() {
        o oVar = this.a;
        oVar.e = -1;
        this.a = new o(oVar);
    }

    public final DateTimeFormatter k(w wVar, j$.time.chrono.a aVar) {
        return l(Locale.getDefault(), wVar, aVar);
    }

    public final DateTimeFormatter l(Locale locale, w wVar, j$.time.chrono.a aVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.a.b != null) {
            i();
        }
        d dVar = new d(this.c, false);
        u uVar = u.a;
        return new DateTimeFormatter(dVar, locale, wVar, aVar);
    }

    public o(o oVar) {
        this.a = this;
        this.c = new ArrayList();
        this.e = -1;
        this.b = oVar;
        this.d = true;
    }
}
