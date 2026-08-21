package defpackage;

import j$.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s24 implements Runnable {
    public static final Object y0 = new Object();
    public final AtomicReference A;
    public final Executor b;
    public final du2 f;
    public final AtomicBoolean z = new AtomicBoolean(true);
    public Object X = y0;
    public int Y = -1;
    public boolean Z = false;

    public s24(AtomicReference atomicReference, Executor executor, du2 du2Var) {
        this.A = atomicReference;
        this.b = executor;
        this.f = du2Var;
    }

    public final void a(int i) {
        synchronized (this) {
            try {
                if (this.z.get()) {
                    if (i <= this.Y) {
                        return;
                    }
                    this.Y = i;
                    if (this.Z) {
                        return;
                    }
                    this.Z = true;
                    try {
                        this.b.execute(this);
                    } catch (Throwable unused) {
                        synchronized (this) {
                            this.Z = false;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this) {
            try {
                if (!this.z.get()) {
                    this.Z = false;
                    return;
                }
                Object obj = this.A.get();
                int i = this.Y;
                while (true) {
                    if (!Objects.equals(this.X, obj)) {
                        this.X = obj;
                        boolean z = obj instanceof hh;
                        du2 du2Var = this.f;
                        if (z) {
                            du2Var.onError(null);
                        } else {
                            du2Var.a(obj);
                        }
                    }
                    synchronized (this) {
                        try {
                            if (i == this.Y || !this.z.get()) {
                                break;
                            }
                            obj = this.A.get();
                            i = this.Y;
                        } finally {
                        }
                    }
                }
                this.Z = false;
            } finally {
            }
        }
    }
}
