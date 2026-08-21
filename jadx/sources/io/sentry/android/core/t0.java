package io.sentry.android.core;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class t0 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[io.sentry.r0.values().length];
        a = iArr;
        try {
            iArr[io.sentry.r0.DISCONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[io.sentry.r0.CONNECTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
