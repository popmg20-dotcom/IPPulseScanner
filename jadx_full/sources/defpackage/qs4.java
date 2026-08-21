package defpackage;

import android.util.Log;
import io.sentry.android.core.a1;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class qs4 {
    public static final boolean a = Log.isLoggable("Volley", 2);
    public static final String b = qs4.class.getName();

    public static String a(String str, Object... objArr) {
        String string;
        String str2 = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                string = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClassName().equals(b)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                StringBuilder sbQ = ha0.q(strSubstring.substring(strSubstring.lastIndexOf(36) + 1), ".");
                sbQ.append(stackTrace[i].getMethodName());
                string = sbQ.toString();
                break;
            }
            i++;
        }
        Locale locale = Locale.US;
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append("] ");
        sb.append(string);
        return fw.y(sb, ": ", str2);
    }

    public static void b(String str, Object... objArr) {
        Log.d("Volley", a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        a1.d("Volley", a(str, objArr));
    }

    public static void d(String str, Object... objArr) {
        if (a) {
            Log.v("Volley", a(str, objArr));
        }
    }
}
