package defpackage;

import android.view.WindowInsetsAnimationController;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gu4 extends je {
    public final WindowInsetsAnimationController z0;

    public gu4(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.z0 = windowInsetsAnimationController;
    }

    public final void A0(t02 t02Var, float f) {
        this.z0.setInsetsAndAlpha(t02Var.e(), 1.0f, f);
    }

    public final void w0(boolean z) {
        this.z0.finish(z);
    }

    public final t02 x0() {
        return t02.d(this.z0.getCurrentInsets());
    }

    public final t02 y0() {
        return t02.d(this.z0.getHiddenStateInsets());
    }

    public final t02 z0() {
        return t02.d(this.z0.getShownStateInsets());
    }
}
