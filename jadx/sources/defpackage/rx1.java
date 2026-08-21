package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rx1 extends wi1 {
    public final /* synthetic */ int A = 1;
    public final Object X;

    public rx1(my1 my1Var, sx1 sx1Var) {
        super(my1Var);
        this.X = new WeakReference(sx1Var);
        g(new qx1(0, this));
    }

    @Override // defpackage.wi1, java.lang.AutoCloseable
    public void close() throws Exception {
        switch (this.A) {
            case 1:
                if (!((AtomicBoolean) this.X).getAndSet(true)) {
                    super.close();
                }
                break;
            default:
                super.close();
                break;
        }
    }

    public rx1(my1 my1Var) {
        super(my1Var);
        this.X = new AtomicBoolean(false);
    }
}
