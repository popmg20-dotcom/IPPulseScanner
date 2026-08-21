package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.i81;
import defpackage.j81;
import defpackage.qe0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends qe0 {
    public int b = 0;

    public ExpandableBehavior() {
    }

    @Override // defpackage.qe0
    public abstract boolean f(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.qe0
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Object obj = (j81) view2;
        boolean z = ((FloatingActionButton) obj).I0.a;
        int i = this.b;
        if (z) {
            if (i != 0 && i != 2) {
                return false;
            }
        } else if (i != 1) {
            return false;
        }
        boolean z2 = ((FloatingActionButton) obj).I0.a;
        this.b = z2 ? 1 : 2;
        w((View) obj, view, z2, true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.qe0
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        j81 j81Var;
        if (!view.isLaidOut()) {
            ArrayList arrayListK = coordinatorLayout.k(view);
            int size = arrayListK.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    j81Var = null;
                    break;
                }
                View view2 = (View) arrayListK.get(i2);
                if (f(view, view2)) {
                    j81Var = (j81) view2;
                    break;
                }
                i2++;
            }
            if (j81Var != null) {
                boolean z = ((FloatingActionButton) j81Var).I0.a;
                int i3 = this.b;
                if (!z ? i3 == 1 : !(i3 != 0 && i3 != 2)) {
                    int i4 = z ? 1 : 2;
                    this.b = i4;
                    view.getViewTreeObserver().addOnPreDrawListener(new i81(this, view, i4, j81Var));
                }
            }
        }
        return false;
    }

    public abstract void w(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
