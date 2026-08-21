package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import defpackage.cp1;
import defpackage.iv1;
import defpackage.pl;
import defpackage.rl;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final cp1 z0;

    public BaseTransientBottomBar$Behavior() {
        cp1 cp1Var = new cp1(9, false);
        this.Y = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.Z = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.X = 0;
        this.z0 = cp1Var;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, defpackage.qe0
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        cp1 cp1Var = this.z0;
        cp1Var.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                iv1.q().A((pl) cp1Var.f);
            }
        } else if (coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            iv1.q().w((pl) cp1Var.f);
        }
        return super.k(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean w(View view) {
        this.z0.getClass();
        return view instanceof rl;
    }
}
