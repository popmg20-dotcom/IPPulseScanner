package defpackage;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ao0 extends x1 implements ScheduledFuture {
    public final ScheduledFuture y0;

    public ao0(zn0 zn0Var) {
        this.y0 = zn0Var.a(new cp1(22, this));
    }

    @Override // defpackage.x1
    public final void c() {
        ScheduledFuture scheduledFuture = this.y0;
        Object obj = this.b;
        scheduledFuture.cancel((obj instanceof p1) && ((p1) obj).a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.y0.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.y0.getDelay(timeUnit);
    }
}
