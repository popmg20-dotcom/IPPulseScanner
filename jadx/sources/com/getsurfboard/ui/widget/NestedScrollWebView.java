package com.getsurfboard.ui.widget;

import android.R;
import android.content.Context;
import android.os.Process;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.OverScroller;
import com.tencent.mars.xlog.Xlog;
import defpackage.fy4;
import defpackage.ha0;
import defpackage.le2;
import defpackage.wp4;
import defpackage.wq2;
import defpackage.xq2;
import io.netty.channel.internal.ChannelUtils;
import io.sentry.android.core.a1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollWebView extends WebView implements wq2 {
    public final xq2 A;
    public final int A0;
    public int B0;
    public int C0;
    public final OverScroller D0;
    public final int E0;
    public final int F0;
    public int G0;
    public final int[] b;
    public final int[] f;
    public boolean y0;
    public int z;
    public VelocityTracker z0;

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, (i & 2) != 0 ? null : attributeSet, R.attr.webViewStyle);
        this.b = new int[2];
        this.f = new int[2];
        this.A = new xq2(this);
        this.B0 = -1;
        this.D0 = new OverScroller(context);
        setOverScrollMode(2);
        setNestedScrollingEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.A0 = viewConfiguration.getScaledTouchSlop();
        this.E0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.F0 = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private final int getScrollRange() {
        return computeVerticalScrollRange();
    }

    public final void a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.B0) {
            int i = action == 0 ? 1 : 0;
            this.z = (int) motionEvent.getY(i);
            this.B0 = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.z0;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        /*
            r11 = this;
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            int r4 = r11.getOverScrollMode()
            int r5 = r11.computeHorizontalScrollRange()
            int r6 = r11.computeHorizontalScrollExtent()
            if (r5 <= r6) goto L1a
            r5 = r2
            goto L1b
        L1a:
            r5 = r0
        L1b:
            int r6 = r11.computeVerticalScrollRange()
            int r7 = r11.computeVerticalScrollExtent()
            if (r6 <= r7) goto L27
            r6 = r2
            goto L28
        L27:
            r6 = r0
        L28:
            r7 = 2
            java.lang.Integer[] r8 = new java.lang.Integer[r7]
            r8[r0] = r1
            r8[r2] = r3
            java.util.Set r8 = defpackage.qe.t0(r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L41
            if (r5 == 0) goto L41
            r5 = r2
            goto L42
        L41:
            r5 = r0
        L42:
            java.lang.Integer[] r7 = new java.lang.Integer[r7]
            r7[r0] = r1
            r7[r2] = r3
            java.util.Set r1 = defpackage.qe.t0(r7)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto L5a
            if (r6 == 0) goto L5a
            r1 = r2
            goto L5b
        L5a:
            r1 = r0
        L5b:
            int r14 = r14 + r12
            if (r5 != 0) goto L60
            r12 = r0
            goto L62
        L60:
            r12 = r18
        L62:
            int r15 = r15 + r13
            if (r1 != 0) goto L67
            r13 = r0
            goto L69
        L67:
            r13 = r19
        L69:
            int r1 = -r12
            int r12 = r12 + r16
            int r3 = -r13
            int r13 = r13 + r17
            if (r14 <= r12) goto L74
            r5 = r12
        L72:
            r12 = r2
            goto L7a
        L74:
            if (r14 >= r1) goto L78
            r5 = r1
            goto L72
        L78:
            r5 = r14
            r12 = r0
        L7a:
            if (r15 <= r13) goto L7f
            r6 = r13
            r13 = r2
            goto L86
        L7f:
            if (r15 >= r3) goto L84
            r13 = r2
            r6 = r3
            goto L86
        L84:
            r6 = r15
            r13 = r0
        L86:
            if (r13 == 0) goto L9c
            xq2 r14 = r11.A
            boolean r14 = r14.f(r2)
            if (r14 != 0) goto L9c
            r9 = 0
            int r10 = r11.getScrollRange()
            android.widget.OverScroller r4 = r11.D0
            r7 = 0
            r8 = 0
            r4.springBack(r5, r6, r7, r8, r9, r10)
        L9c:
            r11.onOverScrolled(r5, r6, r12, r13)
            if (r12 != 0) goto La5
            if (r13 == 0) goto La4
            goto La5
        La4:
            return r0
        La5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.ui.widget.NestedScrollWebView.b(int, int, int, int, int, int, int, int):boolean");
    }

    @Override // android.webkit.WebView, android.view.View
    public final void computeScroll() {
        int i;
        OverScroller overScroller = this.D0;
        if (overScroller.isFinished()) {
            return;
        }
        overScroller.computeScrollOffset();
        int currY = overScroller.getCurrY();
        int i2 = currY - this.G0;
        this.G0 = currY;
        int[] iArr = this.f;
        iArr[1] = 0;
        this.A.c(iArr, 0, null, i2, 1);
        int i3 = i2 - iArr[1];
        if (i3 != 0) {
            int scrollY = getScrollY();
            b(0, i3, getScrollX(), scrollY, 0, getScrollRange(), 0, 0);
            int scrollY2 = i3 - (getScrollY() - scrollY);
            iArr[1] = 0;
            i = 1;
            this.A.d(0, 0, 0, scrollY2, this.b, 1, iArr);
            i3 = scrollY2 - iArr[1];
        } else {
            i = 1;
        }
        if (i3 != 0) {
            overScroller.abortAnimation();
            this.A.h(i);
        }
        if (overScroller.isFinished()) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.A.a(f, f2, false);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return this.A.b(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.A.c(iArr, i, iArr2, i2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.A.d(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return 2;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.A.f(0);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.A.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b0  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.ui.widget.NestedScrollWebView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        motionEvent.getClass();
        if (this.z0 == null) {
            this.z0 = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C0 = 0;
        }
        motionEventObtain.offsetLocation(0.0f, this.C0);
        if (actionMasked == 0) {
            boolean zIsFinished = this.D0.isFinished();
            this.y0 = zIsFinished;
            if (!zIsFinished && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.D0.isFinished()) {
                this.D0.abortAnimation();
                this.A.h(1);
            }
            this.z = (int) motionEvent.getY();
            this.B0 = motionEvent.getPointerId(0);
            this.A.g(2, 0);
        } else if (actionMasked == 1) {
            VelocityTracker velocityTracker = this.z0;
            velocityTracker.getClass();
            velocityTracker.computeCurrentVelocity(1000, this.F0);
            int yVelocity = (int) velocityTracker.getYVelocity(this.B0);
            if (Math.abs(yVelocity) > this.E0) {
                float f = -yVelocity;
                if (!this.A.b(0.0f, f)) {
                    dispatchNestedFling(0.0f, f, true);
                    this.D0.fling(getScrollX(), getScrollY(), 0, -yVelocity, 0, 0, Integer.MIN_VALUE, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, 0, getHeight() / 2);
                    this.A.g(2, 1);
                    this.G0 = getScrollY();
                    postInvalidateOnAnimation();
                }
            } else if (this.D0.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            this.B0 = -1;
            this.y0 = false;
            VelocityTracker velocityTracker2 = this.z0;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.z0 = null;
            }
            this.A.h(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.B0);
            if (iFindPointerIndex == -1) {
                String strK = ha0.k("Invalid pointerId=", this.B0, " in onTouchEvent");
                if (fy4.b) {
                    Xlog.logWrite2(0L, 4, "NestedScrollWebView", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strK);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.e("NestedScrollWebView", strK, null);
                }
                VelocityTracker velocityTracker3 = this.z0;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEventObtain);
                }
                motionEventObtain.recycle();
                return super.onTouchEvent(motionEvent);
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int i = this.z - y;
            if (this.A.c(this.f, 0, this.b, i, 0)) {
                i -= this.f[1];
                this.C0 += this.b[1];
            }
            if (!this.y0 && Math.abs(i) > this.A0) {
                ViewParent parent2 = getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(true);
                }
                this.y0 = true;
                int i2 = this.A0;
                i = i > 0 ? i - i2 : i + i2;
            }
            int i3 = i;
            if (this.y0) {
                this.z = y - this.b[1];
                int scrollY = getScrollY();
                if (b(0, i3, 0, scrollY, 0, getScrollRange(), 0, 0) && !this.A.f(0)) {
                    VelocityTracker velocityTracker4 = this.z0;
                    velocityTracker4.getClass();
                    velocityTracker4.clear();
                }
                int scrollY2 = getScrollY() - scrollY;
                int[] iArr = this.f;
                iArr[1] = 0;
                this.A.d(0, scrollY2, 0, i3 - scrollY2, this.b, 0, iArr);
                int i4 = this.z;
                int i5 = this.b[1];
                this.z = i4 - i5;
                this.C0 += i5;
            }
        } else if (actionMasked == 3) {
            if (this.y0 && this.D0.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            this.B0 = -1;
            this.y0 = false;
            VelocityTracker velocityTracker5 = this.z0;
            if (velocityTracker5 != null) {
                velocityTracker5.recycle();
                this.z0 = null;
            }
            this.A.h(0);
        } else if (actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            this.z = (int) motionEvent.getY(actionIndex);
            this.B0 = motionEvent.getPointerId(actionIndex);
        } else if (actionMasked == 6) {
            a(motionEvent);
            this.z = (int) motionEvent.getY(motionEvent.findPointerIndex(this.B0));
        }
        VelocityTracker velocityTracker6 = this.z0;
        if (velocityTracker6 != null) {
            velocityTracker6.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (this.y0) {
            return true;
        }
        b(i, i2, i3, i4, i5, i6, i7, i8);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.z0) != null) {
            velocityTracker.recycle();
            this.z0 = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        xq2 xq2Var = this.A;
        if (xq2Var.d) {
            ViewGroup viewGroup = xq2Var.c;
            WeakHashMap weakHashMap = wp4.a;
            viewGroup.stopNestedScroll();
        }
        xq2Var.d = z;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return this.A.g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.A.h(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4);
        context.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollWebView(Context context) {
        this(context, null, 6);
        context.getClass();
    }
}
