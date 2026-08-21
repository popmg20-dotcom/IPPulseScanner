package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class n25 {
    public static volatile s05 d;
    public final m95 a;
    public final tm1 b;
    public volatile long c;

    public n25(m95 m95Var) {
        tj4.i(m95Var);
        this.a = m95Var;
        this.b = new tm1(16, this, m95Var, false);
    }

    public abstract void a();

    public final void b(long j) {
        c();
        if (j >= 0) {
            m95 m95Var = this.a;
            m95Var.z0().getClass();
            this.c = System.currentTimeMillis();
            if (d().postDelayed(this.b, j)) {
                return;
            }
            m95Var.n().z0.b(Long.valueOf(j), "Failed to schedule delayed post. time");
        }
    }

    public final void c() {
        this.c = 0L;
        d().removeCallbacks(this.b);
    }

    public final Handler d() {
        s05 s05Var;
        if (d != null) {
            return d;
        }
        synchronized (n25.class) {
            try {
                if (d == null) {
                    d = new s05(this.a.r0().getMainLooper(), 2);
                }
                s05Var = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return s05Var;
    }
}
