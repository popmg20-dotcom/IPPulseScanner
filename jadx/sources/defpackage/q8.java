package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q8 {
    public p8 a;
    public final /* synthetic */ s8 b;

    public q8(s8 s8Var) {
        this.b = s8Var;
    }

    public final boolean a() {
        boolean zUnregisterDurationScaleChangeListener = ValueAnimator.unregisterDurationScaleChangeListener(this.a);
        this.a = null;
        return zUnregisterDurationScaleChangeListener;
    }
}
