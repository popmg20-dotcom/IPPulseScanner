package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.getsurfboard.R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class st0 extends co4 {
    public final /* synthetic */ int k;

    public /* synthetic */ st0(int i) {
        this.k = i;
    }

    @Override // defpackage.co4
    public final float C(Object obj) {
        switch (this.k) {
            case 0:
                return ((tt0) obj).G0.b * 10000.0f;
            case 1:
                return ((ld2) obj).c;
            default:
                return ((MaterialButton) obj).getDisplayedWidthIncrease();
        }
    }

    @Override // defpackage.co4
    public final void W(Object obj, float f) {
        switch (this.k) {
            case 0:
                tt0 tt0Var = (tt0) obj;
                tt0Var.G0.b = f / 10000.0f;
                tt0Var.invalidateSelf();
                int i = (int) f;
                el elVar = tt0Var.f;
                if (elVar.b(true)) {
                    Context context = tt0Var.b;
                    if (tt0Var.K0 == null) {
                        LinearInterpolator linearInterpolator = t8.a;
                        tt0Var.M0 = l72.W(context, R.attr.motionEasingStandardInterpolator, linearInterpolator);
                        tt0Var.N0 = l72.W(context, R.attr.motionEasingEmphasizedAccelerateInterpolator, linearInterpolator);
                        ValueAnimator valueAnimator = new ValueAnimator();
                        tt0Var.K0 = valueAnimator;
                        valueAnimator.setDuration(500L);
                        tt0Var.K0.setFloatValues(0.0f, 1.0f);
                        tt0Var.K0.setInterpolator(null);
                        tt0Var.K0.addUpdateListener(new rt0(0, tt0Var));
                    }
                    float f2 = i;
                    float f3 = (f2 < elVar.o * 10000.0f || f2 > elVar.p * 10000.0f) ? 0.0f : 1.0f;
                    float f4 = tt0Var.H0;
                    ValueAnimator valueAnimator2 = tt0Var.K0;
                    if (f3 != f4) {
                        if (valueAnimator2.isRunning()) {
                            tt0Var.K0.cancel();
                        }
                        tt0Var.H0 = f3;
                        if (f3 != 1.0f) {
                            tt0Var.L0 = tt0Var.N0;
                            tt0Var.K0.reverse();
                        } else {
                            tt0Var.L0 = tt0Var.M0;
                            tt0Var.K0.start();
                        }
                    } else if (!valueAnimator2.isRunning()) {
                        tt0Var.G0.e = f3;
                        tt0Var.invalidateSelf();
                    }
                    break;
                }
                break;
            case 1:
                ((ld2) obj).a(f);
                break;
            default:
                ((MaterialButton) obj).setDisplayedWidthIncrease(f);
                break;
        }
    }
}
