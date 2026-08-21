package defpackage;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.getsurfboard.R;
import com.google.android.material.chip.Chip;
import io.netty.channel.internal.ChannelUtils;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n40 extends h2 {
    public static final Rect o = new Rect(ChannelUtils.WRITE_STATUS_SNDBUF_FULL, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final d7 p = new d7(17);
    public static final k01 q = new k01(17);
    public final AccessibilityManager h;
    public final Chip i;
    public m81 j;
    public final /* synthetic */ Chip n;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    public n40(Chip chip, Chip chip2) {
        this.n = chip;
        this.i = chip2;
        this.h = (AccessibilityManager) chip2.getContext().getSystemService("accessibility");
        chip2.setFocusable(true);
        if (chip2.getImportantForAccessibility() == 0) {
            chip2.setImportantForAccessibility(1);
        }
    }

    @Override // defpackage.h2
    public final cp1 b(View view) {
        m81 m81Var = this.j;
        if (m81Var != null) {
            return m81Var;
        }
        m81 m81Var2 = new m81(this);
        this.j = m81Var2;
        return m81Var2;
    }

    @Override // defpackage.h2
    public final void d(View view, p2 p2Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = p2Var.a;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = this.n;
        p40 p40Var = chip.y0;
        accessibilityNodeInfo.setCheckable(p40Var != null && p40Var.r1);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        p2Var.j(chip.getAccessibilityClassName());
        p2Var.r(chip.getText());
    }

    public final boolean j(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        o(i, false);
        q(i, 8);
        return true;
    }

    public final p2 k(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        p2 p2Var = new p2(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        p2Var.j("android.view.View");
        Rect rect = o;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        Chip chip = this.i;
        accessibilityNodeInfoObtain.setParent(chip);
        AccessibilityNodeInfo accessibilityNodeInfo = p2Var.a;
        if (i == 1) {
            Chip chip2 = this.n;
            CharSequence closeIconContentDescription = chip2.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = chip2.getText();
                accessibilityNodeInfo.setContentDescription(chip2.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            accessibilityNodeInfo.setBoundsInParent(chip2.getCloseIconTouchBoundsInt());
            p2Var.b(i2.e);
            accessibilityNodeInfo.setEnabled(chip2.isEnabled());
            p2Var.j(Button.class.getName());
        } else {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.R0);
        }
        if (p2Var.g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            zo2.w("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            return null;
        }
        Rect rect2 = this.e;
        accessibilityNodeInfoObtain.getBoundsInParent(rect2);
        Rect rect3 = this.d;
        p2Var.f(rect3);
        if (rect2.equals(rect) && rect3.equals(rect)) {
            zo2.w("Callbacks must set parent bounds or screen bounds in populateNodeForVirtualViewId()");
            return null;
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            zo2.w("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            return null;
        }
        if ((actions & 128) != 0) {
            zo2.w("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            return null;
        }
        accessibilityNodeInfoObtain.setPackageName(chip.getContext().getPackageName());
        p2Var.b = i;
        accessibilityNodeInfoObtain.setSource(chip, i);
        if (this.k == i) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            p2Var.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            p2Var.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            p2Var.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            p2Var.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.g;
        chip.getLocationOnScreen(iArr);
        if (rect3.equals(rect)) {
            accessibilityNodeInfoObtain.setBoundsInParent(rect2);
            Rect rect4 = new Rect();
            rect4.set(rect2);
            chip.getLocationOnScreen(iArr);
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            accessibilityNodeInfoObtain.setBoundsInScreen(rect4);
            p2Var.f(rect3);
        }
        Rect rect5 = this.f;
        if (chip.getLocalVisibleRect(rect5)) {
            rect5.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect5)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                break;
                            }
                            parent = view.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfo.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return p2Var;
    }

    public final void l(ArrayList arrayList) {
        p40 p40Var;
        arrayList.add(0);
        Rect rect = Chip.R0;
        Chip chip = this.n;
        if (!chip.c() || (p40Var = chip.y0) == null || !p40Var.l1 || chip.B0 == null) {
            return;
        }
        arrayList.add(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(int r21, android.graphics.Rect r22) {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n40.m(int, android.graphics.Rect):boolean");
    }

    public final p2 n(int i) {
        if (i != -1) {
            return k(i);
        }
        Chip chip = this.i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(chip);
        p2 p2Var = new p2(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = wp4.a;
        chip.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            zo2.w("Views cannot have both real and virtual children");
            return null;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            p2Var.a.addChild(chip, ((Integer) arrayList.get(i2)).intValue());
        }
        return p2Var;
    }

    public final void o(int i, boolean z) {
        Chip chip = this.n;
        if (i == 1) {
            chip.H0 = z;
        }
        p40 p40Var = chip.y0;
        boolean z2 = chip.H0;
        boolean zX = false;
        if (p40Var.m1 != null) {
            zX = p40Var.X(z2 ? new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled} : p40.g2);
        }
        if (zX) {
            chip.refreshDrawableState();
        }
    }

    public final boolean p(int i) {
        int i2;
        Chip chip = this.i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            j(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.l = i;
        o(i, true);
        q(i, 8);
        return true;
    }

    public final void q(int i, int i2) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = (view = this.i).getParent()) == null) {
            return;
        }
        if (i != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            p2 p2VarN = n(i);
            accessibilityEventObtain.getText().add(p2VarN.g());
            AccessibilityNodeInfo accessibilityNodeInfo = p2VarN.a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                zo2.w("Callbacks must add text or a content description in populateEventForVirtualViewId()");
                return;
            } else {
                accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
                accessibilityEventObtain.setSource(view, i);
                accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
            }
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }
}
