package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xa2 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ ya2 b;

    public /* synthetic */ xa2(ya2 ya2Var, int i) {
        this.a = i;
        this.b = ya2Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 1:
                super.onAnimationEnd(animator);
                ya2 ya2Var = this.b;
                ya2Var.e();
                cl clVar = ya2Var.j;
                if (clVar != null) {
                    clVar.a((rz1) ya2Var.a);
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        switch (this.a) {
            case 0:
                super.onAnimationRepeat(animator);
                ya2 ya2Var = this.b;
                ya2Var.g = (ya2Var.g + 1) % ya2Var.f.e.length;
                ya2Var.h = true;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }
}
