package defpackage;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class qq4 extends qe0 {
    public r02 b;
    public int f = 0;

    public qq4() {
    }

    @Override // defpackage.qe0
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        x(coordinatorLayout, view, i);
        r02 r02Var = this.b;
        if (r02Var == null) {
            r02Var = new r02();
            r02Var.d = view;
            this.b = r02Var;
        }
        View view2 = (View) r02Var.d;
        r02Var.a = view2.getTop();
        r02Var.b = view2.getLeft();
        this.b.c();
        int i2 = this.f;
        if (i2 == 0) {
            return true;
        }
        r02 r02Var2 = this.b;
        if (r02Var2.c != i2) {
            r02Var2.c = i2;
            r02Var2.c();
        }
        this.f = 0;
        return true;
    }

    public final int w() {
        r02 r02Var = this.b;
        if (r02Var != null) {
            return r02Var.c;
        }
        return 0;
    }

    public void x(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.q(view, i);
    }

    public qq4(int i) {
    }
}
