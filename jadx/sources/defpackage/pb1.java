package defpackage;

import j$.util.DesugarTimeZone;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pb1 extends lb1 {
    public final Locale b;
    public final HashMap c = new HashMap();

    public pb1(Locale locale) {
        this.b = locale;
        StringBuilder sb = new StringBuilder();
        sb.append("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
        TreeSet<String> treeSet = new TreeSet(qb1.y0);
        for (String[] strArr : DateFormatSymbols.getInstance(locale).getZoneStrings()) {
            String str = strArr[0];
            if (!str.equalsIgnoreCase("GMT")) {
                TimeZone timeZone = DesugarTimeZone.getTimeZone(str);
                ob1 ob1Var = new ob1(timeZone, false);
                ob1 ob1Var2 = ob1Var;
                for (int i = 1; i < strArr.length; i++) {
                    if (i == 3) {
                        ob1Var2 = new ob1(timeZone, true);
                    } else if (i == 5) {
                        ob1Var2 = ob1Var;
                    }
                    String str2 = strArr[i];
                    if (str2 != null) {
                        String lowerCase = str2.toLowerCase(locale);
                        if (treeSet.add(lowerCase)) {
                            this.c.put(lowerCase, ob1Var2);
                        }
                    }
                }
            }
        }
        for (String str3 : treeSet) {
            sb.append('|');
            qb1.c(sb, str3);
        }
        sb.append(")");
        this.a = Pattern.compile(sb.toString());
    }

    @Override // defpackage.lb1
    public final void c(Calendar calendar, String str) {
        ip1 ip1VarA = dc1.a(str);
        if (ip1VarA != null) {
            calendar.setTimeZone(ip1VarA);
            return;
        }
        String lowerCase = str.toLowerCase(this.b);
        HashMap map = this.c;
        ob1 ob1Var = (ob1) map.get(lowerCase);
        if (ob1Var == null) {
            ob1Var = (ob1) map.get(lowerCase + '.');
        }
        calendar.set(16, ob1Var.b);
        calendar.set(15, ob1Var.a.getRawOffset());
    }
}
