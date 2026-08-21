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
    */
    public final void Z(View view, float f, float f2) {
        int i;
        zf2 zf2Var;
        this.h = -1;
        int width = view.getWidth();
        boolean z = false;
        SwipeDismissBehavior swipeDismissBehavior = this.i;
        if (f != 0.0f) {
            boolean z2 = view.getLayoutDirection() == 1;
            int i2 = swipeDismissBehavior.X;
            if (i2 != 2 && (i2 != 0 ? i2 != 1 || (!z2 ? f < 0.0f : f > 0.0f) : !z2 ? f > 0.0f : f < 0.0f)) {
                i = this.g;
            } else if (f >= 0.0f) {
                int left = view.getLeft();
                int i3 = this.g;
                i = left < i3 ? this.g - width : i3 + width;
                z = true;
            }
        } else {
            if (Math.abs(view.getLeft() - this.g) >= Math.round(view.getWidth() * 0.5f)) {
            }
        }
        if (swipeDismissBehavior.b.r(i, view.getTop())) {
            view.postOnAnimation(new cx(swipeDismissBehavior, view, z));
        } else {
            if (!z || (zf2Var = swipeDismissBehavior.f) == null) {
                return;
            }
            zf2Var.o0(view);
        }
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
