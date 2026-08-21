package io.sentry.util;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static final boolean a;
    public static final boolean b;

    static {
        boolean zEquals;
        try {
            zEquals = "The Android Project".equals(System.getProperty("java.vendor"));
            a = zEquals;
        } catch (Throwable unused) {
            a = false;
            zEquals = false;
        }
        if (zEquals) {
            b = false;
            return;
        }
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                b = Double.parseDouble(property) >= 9.0d;
            } else {
                b = false;
            }
        } catch (Throwable unused2) {
            b = false;
        }
    }
}
