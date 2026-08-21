package defpackage;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yv0 implements zv0 {
    public final ScheduledFuture b;

    public yv0(ScheduledFuture scheduledFuture) {
        this.b = scheduledFuture;
    }

    @Override // defpackage.zv0
    public final void c() {
        this.b.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.b + ']';
    }
}
