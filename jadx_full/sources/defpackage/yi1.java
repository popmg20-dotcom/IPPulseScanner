package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
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
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        jy0 jy0VarK;
        boolean z2 = this.Z;
        View view2 = this.A;
        if (z2) {
            wv3 wv3VarB = b();
            if (wv3VarB == null || !wv3VarB.b() || (jy0VarK = wv3VarB.k()) == null || !jy0VarK.isShown()) {
                z = !d();
            } else {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.z0;
                view2.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                jy0VarK.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean zB = jy0VarK.b(motionEventObtainNoHistory, this.y0);
                motionEventObtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z3 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (!zB || !z3) {
                }
            }
        } else if (view2.isEnabled()) {
            int actionMasked2 = motionEvent.getActionMasked();
            if (actionMasked2 == 0) {
                this.y0 = motionEvent.getPointerId(0);
                xi1 xi1Var = this.X;
                if (xi1Var == null) {
                    xi1Var = new xi1(this, 0);
                    this.X = xi1Var;
                }
                view2.postDelayed(xi1Var, this.f);
                xi1 xi1Var2 = this.Y;
                if (xi1Var2 == null) {
                    xi1Var2 = new xi1(this, 1);
                    this.Y = xi1Var2;
                }
                view2.postDelayed(xi1Var2, this.z);
            } else if (actionMasked2 == 1) {
                a();
            } else if (actionMasked2 == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.y0);
                if (iFindPointerIndex >= 0) {
                    float x = motionEvent.getX(iFindPointerIndex);
                    float y = motionEvent.getY(iFindPointerIndex);
                    float f = this.b;
                    float f2 = -f;
                    if (x < f2 || y < f2 || x >= (view2.getRight() - view2.getLeft()) + f || y >= (view2.getBottom() - view2.getTop()) + f) {
                        a();
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                        if (c()) {
                            z = true;
                        }
                        if (z) {
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                            view2.onTouchEvent(motionEventObtain);
                            motionEventObtain.recycle();
                        }
                    }
                }
            } else if (actionMasked2 == 3) {
            }
            z = false;
            if (z) {
            }
        } else {
            z = false;
            if (z) {
            }
        }
        this.Z = z;
        return z || z2;
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
