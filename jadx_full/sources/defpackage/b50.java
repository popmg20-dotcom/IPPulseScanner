package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b50 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ c50 b;

    public /* synthetic */ b50(c50 c50Var, int i) {
        this.a = i;
        this.b = c50Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 1:
                super.onAnimationEnd(animator);
                c50 c50Var = this.b;
                c50Var.e();
                cl clVar = c50Var.j;
                if (clVar != null) {
                    clVar.a((rz1) c50Var.a);
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
                c50 c50Var = this.b;
                c50Var.g = (c50Var.g + c50.l.length) % c50Var.f.e.length;
                break;
            default:
                super.onAnimationRepeat(animator);
                break;
        }
    }
}
