package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kq3 implements vx1 {
    public ValueAnimator a;
    public final /* synthetic */ lq3 b;

    public kq3(lq3 lq3Var) {
        this.b = lq3Var;
    }

    @Override // defpackage.vx1
    public final void clear() {
        ez4.o("ScreenFlashView", "ScreenFlash#clear");
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.a = null;
        }
        lq3 lq3Var = this.b;
        lq3Var.setAlpha(0.0f);
        lq3Var.setBrightness(0.0f);
    }
}
