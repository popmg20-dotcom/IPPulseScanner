package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wa1 extends AnimatorListenerAdapter implements tg4 {
    public final View a;
    public boolean b = false;

    public wa1(View view) {
        this.a = view;
    }

    @Override // defpackage.tg4
    public final void a(vg4 vg4Var) {
        throw null;
    }

    @Override // defpackage.tg4
    public final void b(vg4 vg4Var) {
        this.a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // defpackage.tg4
    public final void c(vg4 vg4Var) {
        throw null;
    }

    @Override // defpackage.tg4
    public final void f(vg4 vg4Var) {
        View view = this.a;
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? or4.a.B(view) : 0.0f));
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        or4.a.V(this.a, 1.0f);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        boolean z2 = this.b;
        View view = this.a;
        if (z2) {
            view.setLayerType(0, null);
        }
        if (z) {
            return;
        }
        ur4 ur4Var = or4.a;
        ur4Var.V(view, 1.0f);
        ur4Var.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // defpackage.tg4
    public final void d(vg4 vg4Var) {
    }

    @Override // defpackage.tg4
    public final void e(vg4 vg4Var) {
    }

    @Override // defpackage.tg4
    public final void g(vg4 vg4Var) {
    }
}
