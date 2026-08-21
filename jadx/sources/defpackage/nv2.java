package defpackage;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onScaleBegin(android.view.ScaleGestureDetector r3) {
        /*
            r2 = this;
            r3.getClass()
            float r0 = r3.getFocusX()
            float r3 = r3.getFocusY()
            androidx.recyclerview.widget.RecyclerView r1 = r2.a
            android.view.View r3 = r1.E(r0, r3)
            if (r3 == 0) goto L2e
            rg3 r3 = androidx.recyclerview.widget.RecyclerView.O(r3)
            r0 = -1
            if (r3 == 0) goto L1f
            int r3 = r3.d()
            goto L20
        L1f:
            r3 = r0
        L20:
            if (r3 != r0) goto L23
            goto L2e
        L23:
            android.view.ViewParent r3 = r1.getParent()
            r0 = 1
            if (r3 == 0) goto L2f
            r3.requestDisallowInterceptTouchEvent(r0)
            goto L2f
        L2e:
            r0 = 0
        L2f:
            r2.e = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nv2.onScaleBegin(android.view.ScaleGestureDetector):boolean");
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
