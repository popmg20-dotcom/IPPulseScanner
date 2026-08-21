package io.sentry.util;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static final ThreadLocal a = new ThreadLocal();
    public static final l b = new l();

    public static boolean a() {
        Integer num = (Integer) a.get();
        return num != null && num.intValue() > 0;
    }
}
