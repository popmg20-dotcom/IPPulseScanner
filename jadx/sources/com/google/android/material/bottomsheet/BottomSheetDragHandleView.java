package com.google.android.material.bottomsheet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.getsurfboard.R;
import defpackage.co4;
import defpackage.i2;
import defpackage.ib;
import defpackage.jd;
import defpackage.no;
import defpackage.ol;
import defpackage.qe0;
import defpackage.ro;
import defpackage.te0;
import defpackage.wp4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDragHandleView extends ib implements AccessibilityManager.AccessibilityStateChangeListener {
    public static final /* synthetic */ int H0 = 0;
    public final AccessibilityManager A;
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public final String D0;
    public final String E0;
    public final String F0;
    public final no G0;
    public BottomSheetBehavior y0;
    public final GestureDetector z0;

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, R.attr.bottomSheetDragHandleStyle, R.style.Widget_Material3_BottomSheet_DragHandle), attributeSet, R.attr.bottomSheetDragHandleStyle);
        this.B0 = false;
        this.C0 = false;
        this.D0 = getResources().getString(R.string.bottomsheet_action_expand_description);
        this.E0 = getResources().getString(R.string.bottomsheet_action_half_expand_description);
        this.F0 = getResources().getString(R.string.bottomsheet_action_collapse_description);
        this.G0 = new no(this, 1);
        ro roVar = new ro(0, this);
        Context context2 = getContext();
        this.z0 = new GestureDetector(context2, roVar, new Handler(Looper.getMainLooper()));
        this.A = (AccessibilityManager) context2.getSystemService("accessibility");
        wp4.n(this, new ol(2, this));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getNextState() {
        /*
            r6 = this;
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r6.y0
            r1 = -1
            if (r0 == 0) goto L20
            boolean r2 = r0.f
            int r0 = r0.f1
            r3 = 6
            r4 = 4
            r5 = 3
            if (r0 == r5) goto L1c
            if (r0 == r4) goto L18
            if (r0 == r3) goto L13
            return r1
        L13:
            boolean r6 = r6.A0
            if (r6 == 0) goto L1f
            goto L1b
        L18:
            if (r2 != 0) goto L1b
            goto L1e
        L1b:
            return r5
        L1c:
            if (r2 != 0) goto L1f
        L1e:
            return r3
        L1f:
            return r4
        L20:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetDragHandleView.getNextState():int");
    }

    private void setBottomSheetBehavior(BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior bottomSheetBehavior2 = this.y0;
        no noVar = this.G0;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.s1.remove(noVar);
            this.y0.K(null);
            this.y0.q1 = null;
        }
        this.y0 = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.K(this);
            BottomSheetBehavior bottomSheetBehavior3 = this.y0;
            bottomSheetBehavior3.getClass();
            bottomSheetBehavior3.q1 = new WeakReference(this);
            d(this.y0.f1);
            ArrayList arrayList = this.y0.s1;
            if (!arrayList.contains(noVar)) {
                arrayList.add(noVar);
            }
        }
        setClickable(this.y0 != null);
    }

    public final boolean c() {
        if (this.y0 == null) {
            return false;
        }
        int nextState = getNextState();
        if (nextState == -1) {
            return true;
        }
        this.y0.N(nextState);
        return true;
    }

    public final void d(int i) {
        if (i == 4) {
            this.A0 = true;
        } else if (i == 3) {
            this.A0 = false;
        }
        int nextState = getNextState();
        wp4.l(this, i2.e, nextState != 3 ? nextState != 4 ? nextState != 6 ? null : this.E0 : this.F0 : this.D0, new jd(2, this));
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        BottomSheetBehavior<?> bottomSheetBehavior;
        super.onAttachedToWindow();
        View view = this;
        while (true) {
            Object parent = view.getParent();
            bottomSheetBehavior = null;
            view = parent instanceof View ? (View) parent : null;
            if (view == null) {
                break;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof te0) {
                qe0 qe0Var = ((te0) layoutParams).a;
                if (qe0Var instanceof BottomSheetBehavior) {
                    bottomSheetBehavior = (BottomSheetBehavior) qe0Var;
                    break;
                }
            }
        }
        setBottomSheetBehavior(bottomSheetBehavior);
        AccessibilityManager accessibilityManager = this.A;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            accessibilityManager.isEnabled();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.A;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        return !isEnabled() ? super.onKeyDown(i, keyEvent) : (i == 23 || i == 66) ? this.C0 ? performClick() : c() : super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.C0 || this.B0) ? super.onTouchEvent(motionEvent) : this.z0.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.C0 = onClickListener != null;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.B0 = onTouchListener != null;
        super.setOnTouchListener(onTouchListener);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z) {
    }

    public BottomSheetDragHandleView(Context context) {
        this(context, null);
    }
}
