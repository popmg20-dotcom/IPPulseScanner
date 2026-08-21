package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ro extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ro(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        switch (this.a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = ((BottomSheetDragHandleView) this.b).y0;
                if (bottomSheetBehavior == null || !bottomSheetBehavior.a1) {
                    return super.onDoubleTap(motionEvent);
                }
                bottomSheetBehavior.N(5);
                return true;
            default:
                motionEvent.getClass();
                motionEvent.getX();
                motionEvent.getY();
                return true;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        switch (this.a) {
            case 0:
                return ((BottomSheetDragHandleView) this.b).isClickable();
            default:
                return super.onDown(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        switch (this.a) {
            case 0:
                BottomSheetDragHandleView bottomSheetDragHandleView = (BottomSheetDragHandleView) this.b;
                int i = BottomSheetDragHandleView.H0;
                return bottomSheetDragHandleView.c();
            default:
                return super.onSingleTapConfirmed(motionEvent);
        }
    }
}
