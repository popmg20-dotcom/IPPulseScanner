package defpackage;

import androidx.lifecycle.DefaultLifecycleObserver;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ep1 extends r92 {
    public static final ep1 b = new ep1();
    public static final dp1 c = new dp1();

    @Override // defpackage.r92
    public final void a(ca2 ca2Var) {
        if (!(ca2Var instanceof DefaultLifecycleObserver)) {
            throw new IllegalArgumentException((ca2Var + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) ca2Var;
        dp1 dp1Var = c;
        defaultLifecycleObserver.onCreate(dp1Var);
        defaultLifecycleObserver.onStart(dp1Var);
        defaultLifecycleObserver.onResume(dp1Var);
    }

    @Override // defpackage.r92
    public final q92 b() {
        return q92.X;
    }

    public final String toString() {
        return "coil.request.GlobalLifecycle";
    }

    @Override // defpackage.r92
    public final void c(ca2 ca2Var) {
    }
}
