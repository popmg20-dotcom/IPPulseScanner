package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w20 extends vg4 {
    public static final String[] X0 = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final xk Y0;
    public static final xk Z0;
    public static final xk a1;
    public static final xk b1;
    public static final xk c1;

    static {
        Class<PointF> cls = PointF.class;
        String str = "topLeft";
        Y0 = new xk(1, cls, str);
        String str2 = "bottomRight";
        Z0 = new xk(2, cls, str2);
        a1 = new xk(3, cls, str2);
        b1 = new xk(4, cls, str);
        c1 = new xk(5, cls, "position");
    }

    public static void U(hh4 hh4Var) {
        View view = hh4Var.b;
        HashMap map = hh4Var.a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", hh4Var.b.getParent());
    }

    @Override // defpackage.vg4
    public final void e(hh4 hh4Var) {
        U(hh4Var);
    }

    @Override // defpackage.vg4
    public final void h(hh4 hh4Var) {
        U(hh4Var);
    }

    @Override // defpackage.vg4
    public final Animator l(ViewGroup viewGroup, hh4 hh4Var, hh4 hh4Var2) {
        int i;
        w20 w20Var;
        Animator animatorA;
        if (hh4Var == null) {
            return null;
        }
        HashMap map = hh4Var.a;
        if (hh4Var2 == null) {
            return null;
        }
        HashMap map2 = hh4Var2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = hh4Var2.b;
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i2 = rect.left;
        int i3 = rect2.left;
        int i4 = rect.top;
        int i5 = rect2.top;
        int i6 = rect.right;
        int i7 = rect2.right;
        int i8 = rect.bottom;
        int i9 = rect2.bottom;
        int i10 = i6 - i2;
        int i11 = i8 - i4;
        int i12 = i7 - i3;
        int i13 = i9 - i5;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0)) {
            i = 0;
        } else {
            i = (i2 == i3 && i4 == i5) ? 0 : 1;
            if (i6 != i7 || i8 != i9) {
                i++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i++;
        }
        int i14 = i;
        if (i14 <= 0) {
            return null;
        }
        or4.a(view, i2, i4, i6, i8);
        if (i14 != 2) {
            w20Var = this;
            animatorA = (i2 == i3 && i4 == i5) ? mt2.a(view, a1, w20Var.P0.p(i6, i8, i7, i9)) : mt2.a(view, b1, w20Var.P0.p(i2, i4, i3, i5));
        } else if (i10 == i12 && i11 == i13) {
            w20Var = this;
            animatorA = mt2.a(view, c1, w20Var.P0.p(i2, i4, i3, i5));
        } else {
            w20Var = this;
            v20 v20Var = new v20(view);
            ObjectAnimator objectAnimatorA = mt2.a(v20Var, Y0, w20Var.P0.p(i2, i4, i3, i5));
            ObjectAnimator objectAnimatorA2 = mt2.a(v20Var, Z0, w20Var.P0.p(i6, i8, i7, i9));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
            animatorSet.addListener(new t20(v20Var));
            animatorA = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            fx3.L(viewGroup4, true);
            w20Var.r().a(new u20(viewGroup4));
        }
        return animatorA;
    }

    @Override // defpackage.vg4
    public final String[] u() {
        return X0;
    }
}
