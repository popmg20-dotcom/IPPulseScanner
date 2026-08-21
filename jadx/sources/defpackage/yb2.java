package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yb2 implements nc2 {
    public final AtomicInteger A;
    public final yv X = fx3.m(new oj1(10, this));
    public vv Y;
    public ArrayList b;
    public ArrayList f;
    public final boolean z;

    public yb2(ArrayList arrayList, boolean z, yu0 yu0Var) {
        this.b = arrayList;
        this.f = new ArrayList(arrayList.size());
        this.z = z;
        this.A = new AtomicInteger(arrayList.size());
        a(new f33(16, this), yu0.a());
        if (this.b.isEmpty()) {
            this.Y.b(new ArrayList(this.f));
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            this.f.add(null);
        }
        ArrayList arrayList2 = this.b;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            nc2 nc2Var = (nc2) arrayList2.get(i2);
            nc2Var.a(new ec(this, i2, nc2Var), yu0Var);
        }
    }

    @Override // defpackage.nc2
    public final void a(Runnable runnable, Executor executor) {
        this.X.f.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        ArrayList arrayList = this.b;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((nc2) it.next()).cancel(z);
            }
        }
        return this.X.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        ArrayList<nc2> arrayList = this.b;
        if (arrayList != null && !isDone()) {
            loop0: for (nc2 nc2Var : arrayList) {
                while (!nc2Var.isDone()) {
                    try {
                        nc2Var.get();
                    } catch (Error e) {
                        throw e;
                    } catch (InterruptedException e2) {
                        throw e2;
                    } catch (Throwable unused) {
                        if (this.z) {
                            return (List) this.X.f.get();
                        }
                    }
                }
            }
        }
        return (List) this.X.f.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.X.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.X.f.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return (List) this.X.f.get(j, timeUnit);
    }
}
