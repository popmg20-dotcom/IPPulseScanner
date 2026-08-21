package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fv implements l83 {
    public static final k83 b = new k83("http://apple.com/ns/ical/", "calendar-color");
    public static final Pattern c;
    public final int a;

    static {
        Pattern patternCompile = Pattern.compile("#?(\\p{XDigit}{6})(\\p{XDigit}{2})?");
        patternCompile.getClass();
        c = patternCompile;
    }

    public fv(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof fv) && this.a == ((fv) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return ha0.p(new StringBuilder("CalendarColor(color="), this.a, ')');
    }
}
