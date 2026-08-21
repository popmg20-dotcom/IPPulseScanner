package defpackage;

import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class eh4 {
    public static final RectF a = new RectF();

    public static View a(View view, int i) {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        xe.k(ha0.x(resourceName, " is not a valid ancestor"));
        return null;
    }

    public static RectF b(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    public static float c(float f, float f2, float f3) {
        return ha0.h(f2, f, f3, f);
    }

    public static float d(float f, float f2, float f3, float f4, float f5, boolean z) {
        return (!z || (f5 >= 0.0f && f5 <= 1.0f)) ? f5 < f3 ? f : f5 > f4 ? f2 : c(f, f2, (f5 - f3) / (f4 - f3)) : c(f, f2, f5);
    }

    public static int e(float f, float f2, float f3, int i, int i2) {
        return f3 < f ? i : f3 > f2 ? i2 : (int) c(i, i2, (f3 - f) / (f2 - f));
    }
}
