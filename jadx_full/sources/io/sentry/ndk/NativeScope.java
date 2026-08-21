package io.sentry.ndk;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NativeScope {
    public static native void nativeAddBreadcrumb(String str, String str2, String str3, String str4, String str5, String str6);

    public static native void nativeClearAttachments();

    public static native void nativeRemoveTag(String str);

    public static native void nativeSetTag(String str, String str2);

    public static native void nativeSetTrace(String str, String str2);
}
