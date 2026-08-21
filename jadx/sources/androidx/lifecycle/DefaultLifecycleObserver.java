package androidx.lifecycle;

import defpackage.ca2;
import defpackage.da2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface DefaultLifecycleObserver extends ca2 {
    void onCreate(da2 da2Var);

    void onDestroy(da2 da2Var);

    void onPause(da2 da2Var);

    void onResume(da2 da2Var);

    void onStart(da2 da2Var);

    void onStop(da2 da2Var);
}
