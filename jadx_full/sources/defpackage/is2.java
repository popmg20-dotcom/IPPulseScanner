package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class is2 extends j0 implements v32 {
    public static final is2 f = new is2(pr1.X);

    @Override // defpackage.v32
    public final g40 C(e42 e42Var) {
        return js2.b;
    }

    @Override // defpackage.v32
    public final CancellationException F() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // defpackage.v32
    public final zv0 M(am1 am1Var) {
        return js2.b;
    }

    @Override // defpackage.v32
    public final Object i0(ie0 ie0Var) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // defpackage.v32
    public final boolean isActive() {
        return true;
    }

    @Override // defpackage.v32
    public final boolean isCancelled() {
        return false;
    }

    @Override // defpackage.v32
    public final ss3 s() {
        return j41.a;
    }

    @Override // defpackage.v32
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    @Override // defpackage.v32
    public final zv0 x(boolean z, boolean z2, x12 x12Var) {
        return js2.b;
    }

    @Override // defpackage.v32
    public final void g(CancellationException cancellationException) {
    }
}
