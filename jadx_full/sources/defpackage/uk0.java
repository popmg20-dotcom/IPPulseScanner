package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uk0 implements ac1 {
    public static final tb1 X = new tb1(1);
    public static final tb1 Y = new tb1(0);
    public boolean A;
    public final View b;
    public boolean f = true;
    public boolean z = true;

    public uk0(View view) {
        this.b = view;
    }

    @Override // defpackage.ac1
    public final void a(View view) {
        if (this.A) {
            return;
        }
        this.A = true;
        view.animate().alpha(1.0f).setDuration(150L).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    @Override // defpackage.ac1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(View view, View view2) {
        float f;
        if (this.z) {
            this.z = false;
            View view3 = this.b;
            boolean z = view3.getLayoutDirection() == 1;
            int iMax = Math.max(view.getWidth(), view2.getWidth());
            if (z) {
                f = view.getLeft() == 0 ? -iMax : 0.0f;
            } else if (view.getRight() == view3.getWidth()) {
                f = iMax;
            }
            ViewPropertyAnimator duration = view.animate().alpha(0.0f).translationX(f).setDuration(200L);
            tb1 tb1Var = Y;
            duration.setInterpolator(tb1Var).start();
            view2.animate().alpha(0.0f).translationX(f).setDuration(200L).setInterpolator(tb1Var).start();
        }
    }

    @Override // defpackage.ac1
    public final boolean c() {
        return this.f;
    }

    @Override // defpackage.ac1
    public final void f(View view) {
        if (this.A) {
            this.A = false;
            view.animate().alpha(0.0f).setDuration(200L).start();
        }
    }

    @Override // defpackage.ac1
    public final void l(View view, View view2) {
        if (this.z) {
            return;
        }
        this.z = true;
        ViewPropertyAnimator duration = view.animate().alpha(1.0f).translationX(0.0f).setDuration(150L);
        tb1 tb1Var = X;
        duration.setInterpolator(tb1Var).start();
        view2.animate().alpha(1.0f).translationX(0.0f).setDuration(150L).setInterpolator(tb1Var).start();
    }

    @Override // defpackage.ac1
    public final void g() {
    }
}
