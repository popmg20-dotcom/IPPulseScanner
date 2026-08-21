package defpackage;

import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ao3 {
    public static final String a = b(5);

    static {
        Logger.getLogger(ao3.class.getName());
    }

    public static void a(int i, String str) {
        String str2 = System.getenv("TEMPORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        if (str2 == null || !str2.equals("true")) {
            if (i < 0) {
                throw new t80("Invalid gencode version: ".concat(b(i)));
            }
            if (i != 5 && 5 < i) {
                String strB = b(i);
                Locale locale = Locale.US;
                throw new t80(fw.y(fw.E("Detected incompatible Protobuf Gencode/Runtime versions when loading ", str, ": gencode ", strB, ", runtime "), a, ". Runtime version cannot be older than the linked gencode version."));
            }
        }
    }

    public static String b(int i) {
        Locale locale = Locale.US;
        return ha0.k("4.33.", i, "");
    }
}
