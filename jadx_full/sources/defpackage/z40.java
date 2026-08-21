package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z40 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ a50 b;

    public /* synthetic */ z40(a50 a50Var, int i) {
        this.a = i;
        this.b = a50Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 1:
                super.onAnimationEnd(animator);
                a50 a50Var = this.b;
                a50Var.e();
                cl clVar = a50Var.j;
                if (clVar != null) {
                    clVar.a((rz1) a50Var.a);
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
                a50 a50Var = this.b;
                a50Var.g = (a50Var.g + 4) % a50Var.f.e.length;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }
}
