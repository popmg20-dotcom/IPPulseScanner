package androidx.fragment.app;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import defpackage.eg0;
import defpackage.nm0;
import defpackage.om0;
import defpackage.pm0;
import defpackage.vz3;
import defpackage.yh;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e extends vz3 {
    public final d c;
    public AnimatorSet d;

    public e(d dVar) {
        this.c = dVar;
    }

    @Override // defpackage.vz3
    public final void b(ViewGroup viewGroup) {
        viewGroup.getClass();
        AnimatorSet animatorSet = this.d;
        a0 a0Var = this.c.a;
        if (animatorSet == null) {
            a0Var.c(this);
            return;
        }
        if (!a0Var.g) {
            animatorSet.end();
        } else if (Build.VERSION.SDK_INT >= 26) {
            pm0.a.a(animatorSet);
        }
        if (u.M(2)) {
            StringBuilder sb = new StringBuilder("Animator from operation ");
            sb.append(a0Var);
            sb.append(" has been canceled");
            sb.append(a0Var.g ? " with seeking." : ".");
            sb.append(' ');
            Log.v("FragmentManager", sb.toString());
        }
    }

    @Override // defpackage.vz3
    public final void c(ViewGroup viewGroup) {
        viewGroup.getClass();
        a0 a0Var = this.c.a;
        AnimatorSet animatorSet = this.d;
        if (animatorSet == null) {
            a0Var.c(this);
            return;
        }
        animatorSet.start();
        if (u.M(2)) {
            Log.v("FragmentManager", "Animator from operation " + a0Var + " has started.");
        }
    }

    @Override // defpackage.vz3
    public final void d(yh yhVar, ViewGroup viewGroup) {
        viewGroup.getClass();
        a0 a0Var = this.c.a;
        AnimatorSet animatorSet = this.d;
        if (animatorSet == null) {
            a0Var.c(this);
            return;
        }
        if (Build.VERSION.SDK_INT < 34 || !a0Var.c.mTransitioning) {
            return;
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + a0Var);
        }
        long jA = om0.a.a(animatorSet);
        long j = (long) (yhVar.c * jA);
        if (j == 0) {
            j = 1;
        }
        if (j == jA) {
            j = jA - 1;
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "Setting currentPlayTime to " + j + " for Animator " + animatorSet + " on operation " + a0Var);
        }
        pm0.a.b(animatorSet, j);
    }

    @Override // defpackage.vz3
    public final void e(ViewGroup viewGroup) {
        e eVar;
        viewGroup.getClass();
        d dVar = this.c;
        if (dVar.a()) {
            return;
        }
        Context context = viewGroup.getContext();
        context.getClass();
        eg0 eg0VarB = dVar.b(context);
        this.d = eg0VarB != null ? (AnimatorSet) eg0VarB.z : null;
        a0 a0Var = dVar.a;
        o oVar = a0Var.c;
        boolean z = a0Var.a == 3;
        View view = oVar.mView;
        viewGroup.startViewTransition(view);
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            eVar = this;
            animatorSet.addListener(new nm0(viewGroup, view, z, a0Var, eVar));
        } else {
            eVar = this;
        }
        AnimatorSet animatorSet2 = eVar.d;
        if (animatorSet2 != null) {
            animatorSet2.setTarget(view);
        }
    }
}
