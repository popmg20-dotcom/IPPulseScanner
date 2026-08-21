package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tl0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ rg3 b;
    public final /* synthetic */ View c;
    public final /* synthetic */ ViewPropertyAnimator d;
    public final /* synthetic */ yl0 e;

    public tl0(yl0 yl0Var, rg3 rg3Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.e = yl0Var;
        this.b = rg3Var;
        this.d = viewPropertyAnimator;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 1:
                this.c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        rg3 rg3Var = this.b;
        yl0 yl0Var = this.e;
        ViewPropertyAnimator viewPropertyAnimator = this.d;
        switch (i) {
            case 0:
                viewPropertyAnimator.setListener(null);
                this.c.setAlpha(1.0f);
                yl0Var.c(rg3Var);
                yl0Var.p.remove(rg3Var);
                yl0Var.i();
                break;
            default:
                viewPropertyAnimator.setListener(null);
                yl0Var.c(rg3Var);
                yl0Var.n.remove(rg3Var);
                yl0Var.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                this.e.getClass();
                break;
            default:
                this.e.getClass();
                break;
        }
    }

    public tl0(yl0 yl0Var, rg3 rg3Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.e = yl0Var;
        this.b = rg3Var;
        this.c = view;
        this.d = viewPropertyAnimator;
    }
}
