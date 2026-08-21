package j$.time.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements e {
    public final j$.time.temporal.q a;
    public final y b;
    public final a c;
    public volatile h d;

    public n(j$.time.temporal.q qVar, y yVar, a aVar) {
        this.a = qVar;
        this.b = yVar;
        this.c = aVar;
    }

    @Override // j$.time.format.e
    public final boolean h(r rVar, StringBuilder sb) {
        String strG;
        Long lA = rVar.a(this.a);
        DateTimeFormatter dateTimeFormatter = rVar.b;
        if (lA == null) {
            return false;
        }
        j$.time.chrono.a aVar = (j$.time.chrono.a) rVar.a.m(j$.time.temporal.r.b);
        if (aVar == null || aVar == j$.time.chrono.s.c) {
            a aVar2 = this.c;
            long jLongValue = lA.longValue();
            y yVar = this.b;
            Locale locale = dateTimeFormatter.b;
            strG = aVar2.a.g(jLongValue, yVar);
        } else {
            a aVar3 = this.c;
            long jLongValue2 = lA.longValue();
            y yVar2 = this.b;
            Locale locale2 = dateTimeFormatter.b;
            strG = aVar3.a.g(jLongValue2, yVar2);
        }
        if (strG != null) {
            sb.append(strG);
            return true;
        }
        if (this.d == null) {
            this.d = new h(this.a, 1, 19, x.NORMAL);
        }
        return this.d.h(rVar, sb);
    }

    @Override // j$.time.format.e
    public final int i(p pVar, CharSequence charSequence, int i) {
        a aVar = this.c;
        j$.time.temporal.q qVar = this.a;
        int length = charSequence.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        boolean z = pVar.c;
        DateTimeFormatter dateTimeFormatter = pVar.a;
        Iterator it = null;
        y yVar = z ? this.b : null;
        j$.time.chrono.a aVar2 = pVar.c().c;
        if (aVar2 == null && (aVar2 = pVar.a.e) == null) {
            aVar2 = j$.time.chrono.s.c;
        }
        if (aVar2 == null || aVar2 == j$.time.chrono.s.c) {
            Locale locale = dateTimeFormatter.b;
            List list = (List) ((HashMap) ((Map) aVar.a.c)).get(yVar);
            if (list != null) {
                it = list.iterator();
            }
        } else {
            List list2 = (List) ((HashMap) ((Map) aVar.a.c)).get(yVar);
            if (list2 != null) {
                it = list2.iterator();
            }
        }
        Iterator it2 = it;
        if (it2 != null) {
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                String str = (String) entry.getKey();
                if (pVar.g(str, 0, charSequence, i, str.length())) {
                    return pVar.f(this.a, ((Long) entry.getValue()).longValue(), i, str.length() + i);
                }
            }
            if (qVar == j$.time.temporal.a.ERA && !pVar.c) {
                Iterator it3 = aVar2.A().iterator();
                while (it3.hasNext()) {
                    String string = ((j$.time.chrono.m) it3.next()).toString();
                    if (pVar.g(string, 0, charSequence, i, string.length())) {
                        return pVar.f(this.a, r8.getValue(), i, string.length() + i);
                    }
                }
            }
            if (pVar.c) {
                return ~i;
            }
        }
        if (this.d == null) {
            this.d = new h(this.a, 1, 19, x.NORMAL);
        }
        return this.d.i(pVar, charSequence, i);
    }

    public final String toString() {
        y yVar = y.FULL;
        y yVar2 = this.b;
        j$.time.temporal.q qVar = this.a;
        if (yVar2 == yVar) {
            return "Text(" + qVar + ")";
        }
        return "Text(" + qVar + "," + yVar2 + ")";
    }
}
