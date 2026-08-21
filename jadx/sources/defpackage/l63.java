package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l63 extends AnimatorListenerAdapter {
    public final /* synthetic */ bh3 a;
    public final /* synthetic */ hu4 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public l63(bh3 bh3Var, hu4 hu4Var, int i, int i2) {
        this.a = bh3Var;
        this.b = hu4Var;
        this.c = i;
        this.d = i2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        animator.getClass();
        Object obj = this.a.b;
        hu4 hu4Var = this.b;
        if (n12.c(obj, hu4Var)) {
            hu4Var.a.w0(this.c == this.d);
        }
    }
}
