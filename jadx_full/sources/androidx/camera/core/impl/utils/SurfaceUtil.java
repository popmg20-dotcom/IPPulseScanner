package androidx.camera.core.impl.utils;

import android.view.Surface;
import defpackage.l74;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SurfaceUtil {
    static {
        System.loadLibrary("surface_util_jni");
    }

    public static l74 a(Surface surface) {
        int[] iArrNativeGetSurfaceInfo = nativeGetSurfaceInfo(surface);
        l74 l74Var = new l74(0);
        int i = iArrNativeGetSurfaceInfo[0];
        int i2 = iArrNativeGetSurfaceInfo[1];
        int i3 = iArrNativeGetSurfaceInfo[2];
        return l74Var;
    }

    private static native int[] nativeGetSurfaceInfo(Surface surface);
}
