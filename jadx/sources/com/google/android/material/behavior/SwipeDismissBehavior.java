package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.i2;
import defpackage.qe0;
import defpackage.w74;
import defpackage.wn1;
import defpackage.wp4;
import defpackage.zf2;
import defpackage.zp4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends qe0 {
    public boolean A;
    public zp4 b;
    public zf2 f;
    public boolean z;
    public int X = 2;
    public float Y = 0.0f;
    public float Z = 0.5f;
    public final w74 y0 = new w74(this);

    @Override // defpackage.qe0
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zO = this.z;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zO = coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.z = zO;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.z = false;
        }
        if (zO) {
            zp4 zp4Var = this.b;
            if (zp4Var == null) {
                zp4Var = new zp4(coordinatorLayout.getContext(), coordinatorLayout, this.y0);
                this.b = zp4Var;
            }
            if (!this.A && zp4Var.s(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.qe0
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            wp4.k(view, 1048576);
            wp4.i(view, 0);
            if (w(view)) {
                wp4.l(view, i2.i, null, new wn1(22, this));
            }
        }
        return false;
    }

    @Override // defpackage.qe0
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.b == null) {
            return false;
        }
        if (this.A && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.b.l(motionEvent);
        return true;
    }

    public boolean w(View view) {
        return true;
    }
}
