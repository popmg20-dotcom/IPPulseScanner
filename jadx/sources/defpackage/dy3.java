package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dy3 extends h2 {
    public final Rect d = new Rect();
    public final /* synthetic */ SlidingPaneLayout e;

    public dy3(SlidingPaneLayout slidingPaneLayout) {
        this.e = slidingPaneLayout;
    }

    @Override // defpackage.h2
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
    }

    @Override // defpackage.h2
    public final void d(View view, p2 p2Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = p2Var.a;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoObtain);
        Rect rect = this.d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect);
        accessibilityNodeInfo.setBoundsInScreen(rect);
        accessibilityNodeInfo.setVisibleToUser(accessibilityNodeInfoObtain.isVisibleToUser());
        accessibilityNodeInfo.setPackageName(accessibilityNodeInfoObtain.getPackageName());
        p2Var.j(accessibilityNodeInfoObtain.getClassName());
        accessibilityNodeInfo.setContentDescription(accessibilityNodeInfoObtain.getContentDescription());
        accessibilityNodeInfo.setEnabled(accessibilityNodeInfoObtain.isEnabled());
        accessibilityNodeInfo.setClickable(accessibilityNodeInfoObtain.isClickable());
        accessibilityNodeInfo.setFocusable(accessibilityNodeInfoObtain.isFocusable());
        accessibilityNodeInfo.setFocused(accessibilityNodeInfoObtain.isFocused());
        accessibilityNodeInfo.setAccessibilityFocused(accessibilityNodeInfoObtain.isAccessibilityFocused());
        accessibilityNodeInfo.setSelected(accessibilityNodeInfoObtain.isSelected());
        accessibilityNodeInfo.setLongClickable(accessibilityNodeInfoObtain.isLongClickable());
        p2Var.a(accessibilityNodeInfoObtain.getActions());
        accessibilityNodeInfo.setMovementGranularities(accessibilityNodeInfoObtain.getMovementGranularities());
        p2Var.j("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        p2Var.b = -1;
        accessibilityNodeInfo.setSource(view);
        WeakHashMap weakHashMap = wp4.a;
        Object parentForAccessibility = view.getParentForAccessibility();
        if (parentForAccessibility instanceof View) {
            accessibilityNodeInfo.setParent((View) parentForAccessibility);
        }
        SlidingPaneLayout slidingPaneLayout = this.e;
        int childCount = slidingPaneLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = slidingPaneLayout.getChildAt(i);
            if (!slidingPaneLayout.b(childAt) && childAt.getVisibility() == 0) {
                childAt.setImportantForAccessibility(1);
                accessibilityNodeInfo.addChild(childAt);
            }
        }
    }

    @Override // defpackage.h2
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (this.e.b(view)) {
            return false;
        }
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}
