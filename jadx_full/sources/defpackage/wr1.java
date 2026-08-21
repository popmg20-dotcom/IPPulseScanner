package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wr1 extends r82 implements am1 {
    public final /* synthetic */ zr1 A;
    public final /* synthetic */ int f;
    public final /* synthetic */ boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wr1(boolean z, zr1 zr1Var, int i) {
        super(1);
        this.f = i;
        this.z = z;
        this.A = zr1Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.f;
        zr1 zr1Var = this.A;
        boolean z = this.z;
        switch (i) {
            case 0:
                View view = (View) obj;
                view.getClass();
                view.setTranslationX(z ? zr1Var.getWidth() : -(zr1Var.getWidth() * 0.25f));
                ViewPropertyAnimator interpolator = view.animate().translationX(0.0f).setDuration(zr1Var.getAnimationDuration()).setInterpolator(zr1Var.getAnimationInterpolator());
                interpolator.getClass();
                return interpolator;
            default:
                View view2 = (View) obj;
                view2.getClass();
                view2.setTranslationX(0.0f);
                ViewPropertyAnimator interpolator2 = view2.animate().translationX(!z ? zr1Var.getWidth() : -(zr1Var.getWidth() * 0.25f)).setDuration(zr1Var.getAnimationDuration()).setInterpolator(zr1Var.getAnimationInterpolator());
                interpolator2.getClass();
                return interpolator2;
        }
    }
}
