package defpackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class dc1 {
    public static final Pattern a = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");
    public static final ip1 b = new ip1(false, 0, 0);

    public static ip1 a(String str) {
        if (!"Z".equals(str) && !"UTC".equals(str)) {
            Matcher matcher = a.matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String strGroup = matcher.group(2);
            boolean z = false;
            int i = strGroup != null ? Integer.parseInt(strGroup) : 0;
            String strGroup2 = matcher.group(4);
            int i2 = strGroup2 != null ? Integer.parseInt(strGroup2) : 0;
            if (i != 0 || i2 != 0) {
                String strGroup3 = matcher.group(1);
                if (strGroup3 != null && strGroup3.charAt(0) == '-') {
                    z = true;
                }
                return new ip1(z, i, i2);
            }
        }
        return b;
    }
}
