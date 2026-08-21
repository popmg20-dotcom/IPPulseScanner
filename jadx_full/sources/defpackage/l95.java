package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l95 {
    public static final r90 a;

    static {
        r90 r90Var;
        Uri uri = n95.a;
        synchronized (p95.class) {
            try {
                if (p95.a == null) {
                    p95.H(new r90());
                }
                r90Var = p95.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        a = r90Var;
    }
}
