package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import defpackage.eg0;
import defpackage.lj1;
import defpackage.mm0;
import defpackage.vz3;
import defpackage.xe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c extends vz3 {
    public final d c;

    public c(d dVar) {
        this.c = dVar;
    }

    @Override // defpackage.vz3
    public final void b(ViewGroup viewGroup) {
        viewGroup.getClass();
        a0 a0Var = this.c.a;
        View view = a0Var.c.mView;
        view.clearAnimation();
        viewGroup.endViewTransition(view);
        a0Var.c(this);
        if (u.M(2)) {
            Log.v("FragmentManager", "Animation from operation " + a0Var + " has been cancelled.");
        }
    }

    @Override // defpackage.vz3
    public final void c(ViewGroup viewGroup) {
        viewGroup.getClass();
        d dVar = this.c;
        a0 a0Var = dVar.a;
        if (dVar.a()) {
            a0Var.c(this);
            return;
        }
        Context context = viewGroup.getContext();
        View view = a0Var.c.mView;
        context.getClass();
        eg0 eg0VarB = dVar.b(context);
        if (eg0VarB == null) {
            xe.q("Required value was null.");
            return;
        }
        Animation animation = (Animation) eg0VarB.f;
        if (animation == null) {
            xe.q("Required value was null.");
            return;
        }
        if (a0Var.a != 1) {
            view.startAnimation(animation);
            a0Var.c(this);
            return;
        }
        viewGroup.startViewTransition(view);
        lj1 lj1Var = new lj1(animation, viewGroup, view);
        lj1Var.setAnimationListener(new mm0(a0Var, viewGroup, view, this));
        view.startAnimation(lj1Var);
        if (u.M(2)) {
            Log.v("FragmentManager", "Animation from operation " + a0Var + " has started.");
        }
    }
}
