package io.sentry.android.core;

import android.os.Handler;
import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.w2;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Closeable {
    public static final j0 X = new j0();
    public volatile i0 f;
    public final io.sentry.util.a b = new io.sentry.util.a();
    public final q0 z = new q0(4);
    public volatile Boolean A = null;

    public final void C() {
        if (this.f == null) {
            return;
        }
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            i0 i0Var = this.f;
            this.f.b.clear();
            this.f = null;
            aVar.close();
            if (io.sentry.android.core.internal.util.d.a.c()) {
                if (i0Var != null) {
                    ProcessLifecycleOwner.z0.Y.c(i0Var);
                }
            } else {
                q0 q0Var = this.z;
                ((Handler) q0Var.b).post(new g(2, this, i0Var));
            }
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        C();
    }

    public final void g(g0 g0Var) {
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            s(w2.b);
            if (this.f != null) {
                this.f.b.add(g0Var);
            }
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void n(ILogger iLogger) {
        i0 i0Var = this.f;
        if (i0Var != null) {
            try {
                ProcessLifecycleOwner.z0.Y.a(i0Var);
            } catch (Throwable th) {
                this.f = null;
                iLogger.d(p5.ERROR, "AppState failed to get Lifecycle and could not install lifecycle observer.", th);
            }
        }
    }

    public final void s(ILogger iLogger) {
        if (this.f != null) {
            return;
        }
        try {
            ProcessLifecycleOwner processLifecycleOwner = ProcessLifecycleOwner.z0;
            this.f = new i0(this);
            if (io.sentry.android.core.internal.util.d.a.c()) {
                n(iLogger);
                return;
            }
            q0 q0Var = this.z;
            ((Handler) q0Var.b).post(new z(1, this, iLogger));
        } catch (ClassNotFoundException unused) {
            iLogger.h(p5.WARNING, "androidx.lifecycle is not available, some features might not be properly working,e.g. Session Tracking, Network and System Events breadcrumbs, etc.", new Object[0]);
        } catch (Throwable th) {
            iLogger.d(p5.ERROR, "AppState could not register lifecycle observer", th);
        }
    }

    public final void x(g0 g0Var) {
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            if (this.f != null) {
                this.f.b.remove(g0Var);
            }
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
