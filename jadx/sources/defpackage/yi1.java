package defpackage;

import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yi1 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final View A;
    public xi1 X;
    public xi1 Y;
    public boolean Z;
    public final float b;
    public final int f;
    public int y0;
    public final int z;
    public final int[] z0 = new int[2];

    public yi1(View view) {
        this.A = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f = tapTimeout;
        this.z = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        xi1 xi1Var = this.Y;
        View view = this.A;
        if (xi1Var != null) {
            view.removeCallbacks(xi1Var);
        }
        xi1 xi1Var2 = this.X;
        if (xi1Var2 != null) {
            view.removeCallbacks(xi1Var2);
        }
    }

    public abstract wv3 b();

    public abstract boolean c();

    public boolean d() {
        wv3 wv3VarB = b();
        if (wv3VarB == null || !wv3VarB.b()) {
            return true;
        }
        wv3VarB.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yi1.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.Z = false;
        this.y0 = -1;
        xi1 xi1Var = this.X;
        if (xi1Var != null) {
            this.A.removeCallbacks(xi1Var);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
