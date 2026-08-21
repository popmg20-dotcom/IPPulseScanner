package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.a0;
import androidx.fragment.app.e;
import androidx.fragment.app.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nm0 extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ a0 d;
    public final /* synthetic */ e e;

    public nm0(ViewGroup viewGroup, View view, boolean z, a0 a0Var, e eVar) {
        this.a = viewGroup;
        this.b = view;
        this.c = z;
        this.d = a0Var;
        this.e = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        animator.getClass();
        ViewGroup viewGroup = this.a;
        View view = this.b;
        viewGroup.endViewTransition(view);
        boolean z = this.c;
        a0 a0Var = this.d;
        if (z || a0Var.a == 3) {
            int i = a0Var.a;
            view.getClass();
            dw2.s(i, view, viewGroup);
        }
        e eVar = this.e;
        eVar.c.a.c(eVar);
        if (u.M(2)) {
            Log.v("FragmentManager", "Animator from operation " + a0Var + " has ended.");
        }
    }
}
