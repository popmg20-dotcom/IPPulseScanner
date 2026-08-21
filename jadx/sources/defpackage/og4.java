package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class og4 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public og4(fu4 fu4Var, View view) {
        this.b = fu4Var;
        this.c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((ie) obj2).remove(animator);
                ((vg4) obj).G0.remove(animator);
                break;
            default:
                fu4 fu4Var = (fu4) obj2;
                fu4Var.a.e(1.0f);
                bu4.f(fu4Var, (View) obj);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                ((vg4) this.c).G0.add(animator);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public og4(vg4 vg4Var, ie ieVar) {
        this.c = vg4Var;
        this.b = ieVar;
    }
}
