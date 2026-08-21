package defpackage;

import android.transition.Transition;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pi2 extends wg4 {
    public final /* synthetic */ View a;
    public final /* synthetic */ ri2 b;
    public final /* synthetic */ View c;
    public final /* synthetic */ View d;
    public final /* synthetic */ si2 e;

    public pi2(si2 si2Var, View view, ri2 ri2Var, View view2, View view3) {
        this.e = si2Var;
        this.a = view;
        this.b = ri2Var;
        this.c = view2;
        this.d = view3;
    }

    @Override // defpackage.wg4, android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        si2 si2Var = this.e;
        si2Var.removeListener(this);
        if (si2Var.b) {
            return;
        }
        this.c.setAlpha(1.0f);
        this.d.setAlpha(1.0f);
        this.a.getOverlay().remove(this.b);
    }

    @Override // defpackage.wg4, android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        this.a.getOverlay().add(this.b);
        this.c.setAlpha(0.0f);
        this.d.setAlpha(0.0f);
    }
}
