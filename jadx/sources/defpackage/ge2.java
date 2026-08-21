package defpackage;

import com.getsurfboard.R;
import j$.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ge2 {
    public static final Pattern h = Pattern.compile("([0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}\\.[0-9]{3})\\s+(\\d+)\\s+(\\d+)\\s+([VDIWEF])\\s+([^:]+):\\s*(.*)");
    public static final SimpleDateFormat i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    public static final zy0 j;
    public static final fe2 k;
    public static final Pattern l;
    public final Date a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    static {
        zy0 zy0Var = new zy0();
        zy0Var.put("V", Integer.valueOf(R.color.logcat_verbose));
        zy0Var.put("D", Integer.valueOf(R.color.logcat_debug));
        zy0Var.put("I", Integer.valueOf(R.color.logcat_info));
        zy0Var.put("W", Integer.valueOf(R.color.logcat_warning));
        zy0Var.put("E", Integer.valueOf(R.color.logcat_error));
        zy0Var.put("F", Integer.valueOf(R.color.logcat_fatal));
        j = zy0Var;
        fe2 fe2Var = new fe2();
        fe2Var.add("V");
        fe2Var.add("D");
        fe2Var.add("I");
        fe2Var.add("W");
        fe2Var.add("E");
        fe2Var.add("F");
        k = fe2Var;
        l = Pattern.compile("--------- beginning of (.*)");
    }

    public ge2(String str) {
        Matcher matcher = h.matcher(str);
        if (!matcher.find()) {
            xe.q(ha0.n("logcat pattern not match: ", str));
            throw null;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strGroup3 = matcher.group(3);
        String strGroup4 = matcher.group(4);
        String strGroup5 = matcher.group(5);
        String strGroup6 = matcher.group(6);
        this.a = i.parse(strGroup);
        this.b = Integer.parseInt(strGroup2);
        this.c = Integer.parseInt(strGroup3);
        this.d = strGroup4;
        this.e = strGroup5;
        this.f = strGroup6;
        this.g = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ge2.class == obj.getClass()) {
            ge2 ge2Var = (ge2) obj;
            if (this.b == ge2Var.b && this.c == ge2Var.c && Objects.equals(this.a, ge2Var.a) && Objects.equals(this.d, ge2Var.d) && Objects.equals(this.e, ge2Var.e) && Objects.equals(this.f, ge2Var.f) && Objects.equals(this.g, ge2Var.g)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), this.d, this.e, this.f, this.g);
    }
}
