package defpackage;

import io.github.rosemoe.oniguruma.OnigNative;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ap2 {
    public static boolean a() {
        try {
            OnigNative.releaseRegex(0L);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
