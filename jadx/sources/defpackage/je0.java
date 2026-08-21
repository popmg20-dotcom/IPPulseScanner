package defpackage;

import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class je0 extends AtomicBoolean implements OutcomeReceiver {
    public final z00 b;

    public je0(z00 z00Var) {
        super(false);
        this.b = z00Var;
    }

    public final void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.b.d(n12.r(th));
        }
    }

    public final void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.b.d(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
