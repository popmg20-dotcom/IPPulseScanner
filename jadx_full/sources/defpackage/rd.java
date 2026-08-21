package defpackage;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rd extends je {
    public static volatile rd A0;
    public static final qd B0 = new qd(0);
    public final ym0 z0 = new ym0();

    public static rd w0() {
        if (A0 != null) {
            return A0;
        }
        synchronized (rd.class) {
            try {
                if (A0 == null) {
                    A0 = new rd();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return A0;
    }

    public final void x0(Runnable runnable) {
        ym0 ym0Var = this.z0;
        if (ym0Var.B0 == null) {
            synchronized (ym0Var.z0) {
                try {
                    if (ym0Var.B0 == null) {
                        ym0Var.B0 = ym0.w0(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        ym0Var.B0.post(runnable);
    }
}
