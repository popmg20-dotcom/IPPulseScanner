package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c20 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ c20(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 1:
                x41 x41Var = (x41) obj;
                AccessibilityManager accessibilityManager = x41Var.N0;
                if (x41Var.O0 != null && accessibilityManager != null && x41Var.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(x41Var.O0);
                    break;
                }
                break;
            case 2:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = wp4.a;
                view2.requestApplyInsets();
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        AccessibilityManager accessibilityManager3;
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                f20 f20Var = (f20) obj;
                ViewTreeObserver viewTreeObserver = f20Var.O0;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        f20Var.O0 = view.getViewTreeObserver();
                    }
                    f20Var.O0.removeGlobalOnLayoutListener(f20Var.z0);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                x41 x41Var = (x41) obj;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = x41Var.O0;
                if (touchExplorationStateChangeListener != null && (accessibilityManager = x41Var.N0) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
                    break;
                }
                break;
            case 2:
                break;
            case 3:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) obj;
                cs1 cs1Var = hideBottomViewOnScrollBehavior.y0;
                if (cs1Var != null && (accessibilityManager2 = hideBottomViewOnScrollBehavior.Z) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(cs1Var);
                    hideBottomViewOnScrollBehavior.y0 = null;
                    break;
                }
                break;
            case 4:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) obj;
                cs1 cs1Var2 = hideViewOnScrollBehavior.z;
                if (cs1Var2 != null && (accessibilityManager3 = hideViewOnScrollBehavior.f) != null) {
                    accessibilityManager3.removeTouchExplorationStateChangeListener(cs1Var2);
                    hideViewOnScrollBehavior.z = null;
                    break;
                }
                break;
            default:
                f24 f24Var = (f24) obj;
                ViewTreeObserver viewTreeObserver2 = f24Var.F0;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        f24Var.F0 = view.getViewTreeObserver();
                    }
                    f24Var.F0.removeGlobalOnLayoutListener(f24Var.z0);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    private final void c(View view) {
    }

    private final void d(View view) {
    }

    private final void e(View view) {
    }
}
