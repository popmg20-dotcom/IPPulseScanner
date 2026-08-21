package defpackage;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class s00 implements t00 {
    public final /* synthetic */ int b;
    public final Object f;

    public /* synthetic */ s00(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.t00
    public final void b(Throwable th) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                ((ScheduledFuture) obj).cancel(false);
                break;
            case 1:
                ((am1) obj).g(th);
                break;
            default:
                ((zv0) obj).c();
                break;
        }
    }

    public final String toString() {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) obj) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((am1) obj).getClass().getSimpleName() + '@' + ek0.l(this) + ']';
            default:
                return "DisposeOnCancel[" + ((zv0) obj) + ']';
        }
    }
}
