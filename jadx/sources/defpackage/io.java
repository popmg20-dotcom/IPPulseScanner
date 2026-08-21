package defpackage;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class io implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ io(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                yi2 yi2Var = ((BottomSheetBehavior) obj).A0;
                if (yi2Var != null) {
                    yi2Var.q(fFloatValue);
                }
                break;
            case 1:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                cc1 cc1Var = (cc1) obj;
                cc1Var.c.setAlpha(iFloatValue);
                cc1Var.d.setAlpha(iFloatValue);
                cc1Var.s.invalidate();
                break;
            case 2:
                ((g22) obj).m = valueAnimator.getAnimatedFraction();
                break;
            case 3:
                ri2 ri2Var = (ri2) obj;
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i2 = ri2.L;
                if (ri2Var.D != animatedFraction) {
                    ri2Var.d(animatedFraction);
                }
                break;
            case 4:
                ri2 ri2Var2 = (ri2) obj;
                float animatedFraction2 = valueAnimator.getAnimatedFraction();
                int i3 = ri2.L;
                if (ri2Var2.D != animatedFraction2) {
                    ri2Var2.d(animatedFraction2);
                }
                break;
            case 5:
                ((TabLayout) obj).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
            case 6:
                ((TextInputLayout) obj).N1.m(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) obj;
                textView.setScaleX(fFloatValue2);
                textView.setScaleY(fFloatValue2);
                break;
        }
    }
}
