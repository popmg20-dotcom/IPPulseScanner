package defpackage;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nv2 implements eg3, ScaleGestureDetector.OnScaleGestureListener {
    public final RecyclerView a;
    public final va3 b;
    public final ScaleGestureDetector c;
    public boolean d;
    public boolean e;
    public float f;

    public nv2(RecyclerView recyclerView, va3 va3Var) {
        this.a = recyclerView;
        this.b = va3Var;
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(recyclerView.getContext(), this);
        scaleGestureDetector.setQuickScaleEnabled(false);
        this.c = scaleGestureDetector;
        this.f = 1.0f;
    }

    @Override // defpackage.eg3
    public final void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        motionEvent.getClass();
        this.c.onTouchEvent(motionEvent);
    }

    @Override // defpackage.eg3
    public final boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        motionEvent.getClass();
        if (this.d) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1 && actionMasked != 3) {
                    return false;
                }
                this.d = false;
                return false;
            }
            this.d = false;
        }
        this.c.onTouchEvent(motionEvent);
        return this.e;
    }

    @Override // defpackage.eg3
    public final void e(boolean z) {
        this.d = z;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        scaleGestureDetector.getClass();
        this.f = scaleGestureDetector.getScaleFactor();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        boolean z;
        scaleGestureDetector.getClass();
        float focusX = scaleGestureDetector.getFocusX();
        float focusY = scaleGestureDetector.getFocusY();
        RecyclerView recyclerView = this.a;
        View viewE = recyclerView.E(focusX, focusY);
        if (viewE == null) {
            z = false;
        } else {
            rg3 rg3VarO = RecyclerView.O(viewE);
            if ((rg3VarO != null ? rg3VarO.d() : -1) != -1) {
                ViewParent parent = recyclerView.getParent();
                z = true;
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        this.e = z;
        return z;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        scaleGestureDetector.getClass();
        float f = this.f;
        va3 va3Var = this.b;
        if (f > 1.0f) {
            va3Var.g(Boolean.TRUE);
        } else if (f < 1.0f) {
            va3Var.g(Boolean.FALSE);
        }
        this.e = false;
    }
}
