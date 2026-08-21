package io.sentry.android.core;

import android.os.Debug;
import io.sentry.p3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o implements io.sentry.b1 {
    @Override // io.sentry.b1
    public final void a(p3 p3Var) {
        long jFreeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long nativeHeapSize = Debug.getNativeHeapSize() - Debug.getNativeHeapFreeSize();
        p3Var.b = Long.valueOf(jFreeMemory);
        p3Var.c = Long.valueOf(nativeHeapSize);
    }

    @Override // io.sentry.b1
    public final void c() {
    }
}
