package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ux0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ vx0 b;

    public /* synthetic */ ux0(vx0 vx0Var, int i) {
        this.a = i;
        this.b = vx0Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.a) {
            case 1:
                super.onAnimationEnd(animator);
                vx0 vx0Var = this.b;
                super/*android.graphics.drawable.Drawable*/.setVisible(false, false);
                ArrayList arrayList = vx0Var.Z;
                if (arrayList != null && !vx0Var.y0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((cl) it.next()).a(vx0Var);
                    }
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.a) {
            case 0:
                super.onAnimationStart(animator);
                vx0 vx0Var = this.b;
                ArrayList arrayList = vx0Var.Z;
                if (arrayList != null && !vx0Var.y0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((cl) it.next()).b(vx0Var);
                    }
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
