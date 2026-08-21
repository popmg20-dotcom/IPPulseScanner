package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vf1 extends AnimatorListenerAdapter {
    public boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ yf1 c;

    public vf1(yf1 yf1Var, boolean z) {
        this.c = yf1Var;
        this.b = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        yf1 yf1Var = this.c;
        yf1Var.r = 0;
        yf1Var.m = null;
        if (this.a) {
            return;
        }
        FloatingActionButton floatingActionButton = yf1Var.s;
        boolean z = this.b;
        floatingActionButton.a(z ? 8 : 4, z);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        yf1 yf1Var = this.c;
        yf1Var.s.a(0, this.b);
        yf1Var.r = 1;
        yf1Var.m = animator;
        this.a = false;
    }
}
