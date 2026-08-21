package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j22 extends GestureDetector.SimpleOnGestureListener {
    public boolean a = true;
    public final /* synthetic */ k22 b;

    public j22(k22 k22Var) {
        this.b = k22Var;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        k22 k22Var;
        View viewN;
        rg3 rg3VarN;
        if (!this.a || (viewN = (k22Var = this.b).n(motionEvent)) == null || (rg3VarN = k22Var.r.N(viewN)) == null) {
            return;
        }
        i22 i22Var = k22Var.m;
        RecyclerView recyclerView = k22Var.r;
        if ((i22.b(i22Var.d(recyclerView, rg3VarN), recyclerView.getLayoutDirection()) & 16711680) != 0) {
            int pointerId = motionEvent.getPointerId(0);
            int i = k22Var.l;
            if (pointerId == i) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                k22Var.d = x;
                k22Var.e = y;
                k22Var.i = 0.0f;
                k22Var.h = 0.0f;
                k22Var.r(rg3VarN, 2);
            }
        }
    }
}
