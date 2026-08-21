package defpackage;

import java.util.Locale;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 fe1, still in use, count: 1, list:
  (r8v0 fe1) from 0x00ae: MOVE (r0v4 fe1) = (r8v0 fe1) (LINE:175)
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fe1 {
    /* JADX INFO: Fake field, exist only in values array */
    GENERIC(false, new int[]{0}, new String[0], '/'),
    /* JADX INFO: Fake field, exist only in values array */
    LINUX(true, new int[]{0, 47}, new String[0], '/'),
    /* JADX INFO: Fake field, exist only in values array */
    MAC_OSX(true, new int[]{0, 47, 58}, new String[0], '/'),
    /* JADX INFO: Fake field, exist only in values array */
    WINDOWS(false, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 34, 42, 47, 58, 60, 62, 63, 92, 124}, new String[]{"AUX", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "COM²", "COM³", "COM¹", "CON", "CONIN$", "CONOUT$", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9", "LPT²", "LPT³", "LPT¹", "NUL", "PRN"}, '\\');

    public static final fe1 f;
    public final boolean b;

    static {
        fe1 fe1Var;
        boolean zA = a("Linux");
        boolean zA2 = a("Mac");
        boolean zA3 = a("Windows");
        if (zA) {
            fe1Var = fe1Var;
        } else if (zA2) {
            fe1Var = fe1Var;
        } else if (zA3) {
            fe1Var = fe1Var;
        }
        f = fe1Var;
    }

    public fe1(boolean z2, int[] iArr, String[] strArr, char c) {
        this.b = z2;
        if (c == '/' || c == '\\') {
            return;
        }
        xe.k(String.valueOf(c));
        throw null;
    }

    public static boolean a(String str) {
        String property;
        try {
            property = System.getProperty("os.name");
        } catch (SecurityException unused) {
            System.err.println("Caught a SecurityException reading the system property 'os.name'; the SystemUtils property value will default to null.");
            property = null;
        }
        if (property == null) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return property.toUpperCase(locale).startsWith(str.toUpperCase(locale));
    }

    public static fe1 valueOf(String str) {
        return (fe1) Enum.valueOf(fe1.class, str);
    }

    public static fe1[] values() {
        return (fe1[]) z.clone();
    }
}
