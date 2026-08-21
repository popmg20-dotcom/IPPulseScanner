package defpackage;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hb1 extends lb1 {
    public final int b;
    public final Locale c;
    public final HashMap d;

    public hb1(int i, Calendar calendar, Locale locale) {
        this.b = i;
        this.c = locale;
        StringBuilder sb = new StringBuilder();
        sb.append("((?iu)");
        HashMap map = new HashMap();
        Map<String, Integer> displayNames = calendar.getDisplayNames(i, 0, locale);
        TreeSet treeSet = new TreeSet(qb1.y0);
        for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
            String lowerCase = entry.getKey().toLowerCase(locale);
            if (treeSet.add(lowerCase)) {
                map.put(lowerCase, entry.getValue());
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            qb1.c(sb, (String) it.next());
            sb.append('|');
        }
        this.d = map;
        sb.setLength(sb.length() - 1);
        sb.append(")");
        this.a = Pattern.compile(sb.toString());
    }

    @Override // defpackage.lb1
    public final void c(Calendar calendar, String str) {
        String lowerCase = str.toLowerCase(this.c);
        HashMap map = this.d;
        Integer num = (Integer) map.get(lowerCase);
        if (num == null) {
            num = (Integer) map.get(lowerCase + '.');
        }
        calendar.set(this.b, num.intValue());
    }
}
