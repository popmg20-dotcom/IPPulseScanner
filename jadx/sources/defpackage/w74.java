package defpackage;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w74 extends yr2 {
    public int g;
    public int h = -1;
    public final /* synthetic */ SwipeDismissBehavior i;

    public w74(SwipeDismissBehavior swipeDismissBehavior) {
        this.i = swipeDismissBehavior;
    }

    @Override // defpackage.yr2
    public final int F(View view) {
        return view.getWidth();
    }

    @Override // defpackage.yr2
    public final void W(View view, int i) {
        this.h = i;
        this.g = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.i;
            swipeDismissBehavior.A = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.A = false;
        }
    }

    @Override // defpackage.yr2
    public final void X(int i) {
        zf2 zf2Var = this.i.f;
        if (zf2Var != null) {
            pl plVar = ((sl) zf2Var.f).u;
            if (i == 0) {
                iv1.q().A(plVar);
            } else if (i == 1 || i == 2) {
                iv1.q().w(plVar);
            }
        }
    }

    @Override // defpackage.yr2
    public final void Y(View view, int i, int i2) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.i;
        float f = width * swipeDismissBehavior.Y;
        float width2 = view.getWidth() * swipeDismissBehavior.Z;
        float fAbs = Math.abs(i - this.g);
        if (fAbs <= f) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f) / (width2 - f))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    @Override // defpackage.yr2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.h = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.i
            r4 = 1
            if (r1 == 0) goto L37
            int r5 = r9.getLayoutDirection()
            if (r5 != r4) goto L18
            r5 = r4
            goto L19
        L18:
            r5 = r2
        L19:
            int r6 = r3.X
            r7 = 2
            if (r6 != r7) goto L1f
            goto L50
        L1f:
            if (r6 != 0) goto L2b
            if (r5 == 0) goto L28
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L28:
            if (r1 <= 0) goto L65
            goto L50
        L2b:
            if (r6 != r4) goto L65
            if (r5 == 0) goto L32
            if (r1 <= 0) goto L65
            goto L50
        L32:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L65
            goto L50
        L37:
            int r1 = r9.getLeft()
            int r5 = r8.g
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L65
        L50:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L5f
            int r10 = r9.getLeft()
            int r0 = r8.g
            if (r10 >= r0) goto L5d
            goto L5f
        L5d:
            int r0 = r0 + r11
            goto L63
        L5f:
            int r8 = r8.g
            int r0 = r8 - r11
        L63:
            r2 = r4
            goto L67
        L65:
            int r0 = r8.g
        L67:
            zp4 r8 = r3.b
            int r10 = r9.getTop()
            boolean r8 = r8.r(r0, r10)
            if (r8 == 0) goto L7c
            cx r8 = new cx
            r8.<init>(r3, r9, r2)
            r9.postOnAnimation(r8)
            return
        L7c:
            if (r2 == 0) goto L85
            zf2 r8 = r3.f
            if (r8 == 0) goto L85
            r8.o0(r9)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w74.Z(android.view.View, float, float):void");
    }

    @Override // defpackage.yr2
    public final int h(View view, int i) {
        int width;
        int width2;
        boolean z = view.getLayoutDirection() == 1;
        int i2 = this.i.X;
        if (i2 == 0) {
            width = this.g;
            if (z) {
                width -= view.getWidth();
                width2 = this.g;
            } else {
                width2 = view.getWidth() + width;
            }
        } else {
            int i3 = this.g;
            if (i2 != 1) {
                width = i3 - view.getWidth();
                width2 = this.g + view.getWidth();
            } else if (z) {
                width2 = view.getWidth() + i3;
                width = i3;
            } else {
                width = i3 - view.getWidth();
                width2 = this.g;
            }
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // defpackage.yr2
    public final int i(View view, int i) {
        return view.getTop();
    }

    @Override // defpackage.yr2
    public final boolean p0(View view, int i) {
        int i2 = this.h;
        return (i2 == -1 || i2 == i) && this.i.w(view);
    }
}
