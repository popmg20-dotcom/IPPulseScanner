package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yv implements nc2 {
    public final WeakReference b;
    public final xv f = new xv(this);

    public yv(vv vvVar) {
        this.b = new WeakReference(vvVar);
    }

    @Override // defpackage.nc2
    public final void a(Runnable runnable, Executor executor) {
        this.f.a(runnable, executor);
    }

    public final boolean b(Throwable th) {
        return this.f.k(th);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        vv vvVar = (vv) this.b.get();
        boolean zCancel = this.f.cancel(z);
        if (zCancel && vvVar != null) {
            vvVar.a = null;
            vvVar.b = null;
            vvVar.c.j(null);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f.b instanceof p1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f.isDone();
    }

    public final String toString() {
        return this.f.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.f.get(j, timeUnit);
    }
}
