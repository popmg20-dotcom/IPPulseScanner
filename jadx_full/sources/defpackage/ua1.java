package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ua1 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public boolean b;
    public final /* synthetic */ Object c;

    public ua1(cc1 cc1Var) {
        this.a = 1;
        this.c = cc1Var;
        this.b = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 1:
                this.b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                if (!this.b) {
                    ((View) obj).setVisibility(4);
                }
                break;
            case 1:
                cc1 cc1Var = (cc1) obj;
                if (this.b) {
                    this.b = false;
                } else if (((Float) cc1Var.z.getAnimatedValue()).floatValue() != 0.0f) {
                    cc1Var.A = 2;
                    cc1Var.s.invalidate();
                } else {
                    cc1Var.A = 0;
                    cc1Var.l(0);
                }
                break;
            default:
                yf1 yf1Var = (yf1) obj;
                yf1Var.r = 0;
                yf1Var.m = null;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                if (this.b) {
                    ((View) obj).setVisibility(0);
                }
                break;
            case 1:
            default:
                super.onAnimationStart(animator);
                break;
            case 2:
                yf1 yf1Var = (yf1) obj;
                yf1Var.s.a(0, this.b);
                yf1Var.r = 2;
                yf1Var.m = animator;
                break;
        }
    }

    public ua1(View view, boolean z) {
        this.a = 0;
        this.b = z;
        this.c = view;
    }

    public ua1(yf1 yf1Var, boolean z) {
        this.a = 2;
        this.c = yf1Var;
        this.b = z;
    }
}
