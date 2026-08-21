package defpackage;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ViewFlipper;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bq4 extends ViewFlipper {
    public final void a(View view, wr1 wr1Var, wr1 wr1Var2) {
        View displayedChildView = getDisplayedChildView();
        super.setDisplayedChild(indexOfChild(view));
        if (displayedChildView != null) {
            ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) wr1Var.g(view);
            viewPropertyAnimator.setListener(new pf2(1, w10.A, new aq4(view, 0)));
            viewPropertyAnimator.start();
            ViewPropertyAnimator viewPropertyAnimator2 = (ViewPropertyAnimator) wr1Var2.g(displayedChildView);
            viewPropertyAnimator2.setListener(new pf2(1, new aq4(displayedChildView, 1), new aq4(displayedChildView, 2)));
            viewPropertyAnimator2.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getClass();
        View displayedChildView = getDisplayedChildView();
        displayedChildView.getClass();
        motionEvent.offsetLocation(displayedChildView.getTranslationX(), 0.0f);
        return super.dispatchTouchEvent(motionEvent);
    }

    public final View getDisplayedChildView() {
        return getChildAt(getDisplayedChild());
    }
}
