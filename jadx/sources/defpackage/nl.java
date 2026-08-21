package defpackage;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nl implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ sl f;

    public /* synthetic */ nl(sl slVar, int i) {
        this.b = i;
        this.f = slVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        sl slVar = this.f;
        int i2 = 2;
        int i3 = 1;
        switch (i) {
            case 0:
                rl rlVar = slVar.i;
                if (rlVar != null) {
                    int iHeight = ke0.i(slVar.h).height();
                    int[] iArr = new int[2];
                    rlVar.getLocationInWindow(iArr);
                    int height = (iHeight - (rlVar.getHeight() + iArr[1])) + ((int) rlVar.getTranslationY());
                    int i4 = slVar.p;
                    if (height < i4) {
                        ViewGroup.LayoutParams layoutParams = rlVar.getLayoutParams();
                        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                            a1.n(sl.A, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                        } else {
                            int i5 = slVar.p;
                            slVar.q = i5;
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.bottomMargin = (i5 - height) + marginLayoutParams.bottomMargin;
                            rlVar.requestLayout();
                        }
                    } else {
                        slVar.q = i4;
                    }
                }
                break;
            case 1:
                slVar.c();
                break;
            default:
                rl rlVar2 = slVar.i;
                if (rlVar2 != null) {
                    int i6 = 0;
                    if (rlVar2.getParent() != null) {
                        rlVar2.setVisibility(0);
                    }
                    if (rlVar2.getAnimationMode() != 1) {
                        int height2 = rlVar2.getHeight();
                        ViewGroup.LayoutParams layoutParams2 = rlVar2.getLayoutParams();
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            height2 += ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        }
                        rlVar2.setTranslationY(height2);
                        ValueAnimator valueAnimator = new ValueAnimator();
                        valueAnimator.setIntValues(height2, 0);
                        valueAnimator.setInterpolator(slVar.e);
                        valueAnimator.setDuration(slVar.c);
                        valueAnimator.addListener(new kl(slVar, i3));
                        valueAnimator.addUpdateListener(new ll(slVar, i2));
                        valueAnimator.start();
                    } else {
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                        valueAnimatorOfFloat.setInterpolator(slVar.d);
                        valueAnimatorOfFloat.addUpdateListener(new ll(slVar, i6));
                        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                        valueAnimatorOfFloat2.setInterpolator(slVar.f);
                        valueAnimatorOfFloat2.addUpdateListener(new ll(slVar, i3));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
                        animatorSet.setDuration(slVar.a);
                        animatorSet.addListener(new kl(slVar, 3));
                        animatorSet.start();
                    }
                    break;
                }
                break;
        }
    }
}
