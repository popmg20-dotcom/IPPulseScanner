package defpackage;

import android.os.SystemClock;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class v45 implements Runnable {
    public final /* synthetic */ b55 A;
    public final long b;
    public final long f;
    public final boolean z;

    public v45(b55 b55Var, boolean z) {
        Objects.requireNonNull(b55Var);
        this.A = b55Var;
        this.b = System.currentTimeMillis();
        this.f = SystemClock.elapsedRealtime();
        this.z = z;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        b55 b55Var = this.A;
        if (b55Var.d) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e) {
            b55Var.b(e, false, this.z);
            b();
        }
    }

    public void b() {
    }
}
