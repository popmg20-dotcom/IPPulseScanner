package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xi1 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ yi1 f;

    public /* synthetic */ xi1(yi1 yi1Var, int i) {
        this.b = i;
        this.f = yi1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        yi1 yi1Var = this.f;
        switch (i) {
            case 0:
                ViewParent parent = yi1Var.A.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                yi1Var.a();
                View view = yi1Var.A;
                if (view.isEnabled() && !view.isLongClickable() && yi1Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    yi1Var.Z = true;
                    break;
                }
                break;
        }
    }
}
