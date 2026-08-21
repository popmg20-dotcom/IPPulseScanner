package defpackage;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rd2 {
    public static final rd2 b = a(new Locale[0]);
    public final td2 a;

    public rd2(td2 td2Var) {
        this.a = td2Var;
    }

    public static rd2 a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new rd2(new ud2(ga5.g(localeArr))) : new rd2(new sd2(localeArr));
    }

    public static rd2 b(String str) {
        if (str == null || str.isEmpty()) {
            return b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = Locale.forLanguageTag(strArrSplit[i]);
        }
        return a(localeArr);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof rd2) {
            return this.a.equals(((rd2) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }
}
