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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.view.View r5, android.view.View r6) {
        /*
            r4 = this;
            boolean r0 = r4.z
            if (r0 != 0) goto L5
            return
        L5:
            r0 = 0
            r4.z = r0
            android.view.View r4 = r4.b
            int r1 = r4.getLayoutDirection()
            r2 = 1
            if (r1 != r2) goto L12
            r0 = r2
        L12:
            int r1 = r5.getWidth()
            int r2 = r6.getWidth()
            int r1 = java.lang.Math.max(r1, r2)
            r2 = 0
            if (r0 == 0) goto L2c
            int r4 = r5.getLeft()
            if (r4 != 0) goto L2a
            int r4 = -r1
            float r4 = (float) r4
            goto L37
        L2a:
            r4 = r2
            goto L37
        L2c:
            int r0 = r5.getRight()
            int r4 = r4.getWidth()
            if (r0 != r4) goto L2a
            float r4 = (float) r1
        L37:
            android.view.ViewPropertyAnimator r5 = r5.animate()
            android.view.ViewPropertyAnimator r5 = r5.alpha(r2)
            android.view.ViewPropertyAnimator r5 = r5.translationX(r4)
            r0 = 200(0xc8, double:9.9E-322)
            android.view.ViewPropertyAnimator r5 = r5.setDuration(r0)
            tb1 r3 = defpackage.uk0.Y
            android.view.ViewPropertyAnimator r5 = r5.setInterpolator(r3)
            r5.start()
            android.view.ViewPropertyAnimator r5 = r6.animate()
            android.view.ViewPropertyAnimator r5 = r5.alpha(r2)
            android.view.ViewPropertyAnimator r4 = r5.translationX(r4)
            android.view.ViewPropertyAnimator r4 = r4.setDuration(r0)
            android.view.ViewPropertyAnimator r4 = r4.setInterpolator(r3)
            r4.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uk0.b(android.view.View, android.view.View):void");
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
