package defpackage;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rt0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ rt0(jf4 jf4Var, View view) {
        this.a = 3;
        this.b = jf4Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                tt0 tt0Var = (tt0) obj;
                tt0Var.G0.e = tt0Var.L0.getInterpolation(tt0Var.K0.getAnimatedFraction());
                break;
            case 1:
                ((uy0) obj).d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 2:
                li2 li2Var = (li2) obj;
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                li2Var.k.setAlpha((int) (255.0f * fFloatValue));
                li2Var.y = fFloatValue;
                break;
            default:
                ((View) ((vt4) ((jf4) obj).f).o.getParent()).invalidate();
                break;
        }
    }

    public /* synthetic */ rt0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
