package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class pm1 implements nc2 {
    public final nc2 b;
    public vv f;

    public pm1() {
        this.b = fx3.m(new oj1(3, this));
    }

    public static pm1 b(nc2 nc2Var) {
        return nc2Var instanceof pm1 ? (pm1) nc2Var : new pm1(nc2Var);
    }

    @Override // defpackage.nc2
    public final void a(Runnable runnable, Executor executor) {
        this.b.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.b.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.b.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.b.get(j, timeUnit);
    }

    public pm1(nc2 nc2Var) {
        nc2Var.getClass();
        this.b = nc2Var;
    }
}
