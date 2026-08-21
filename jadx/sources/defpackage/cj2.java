package defpackage;

import android.content.res.Resources;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cj2 extends fk {
    public final float h;
    public final float i;
    public final float j;

    public cj2(View view) {
        super(view);
        Resources resources = view.getResources();
        this.h = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.i = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.j = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public final void a(float f, boolean z, int i) {
        View view = (View) this.f;
        float interpolation = ((PathInterpolator) this.e).getInterpolation(f);
        boolean z2 = (Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3;
        boolean z3 = z == z2;
        int width = view.getWidth();
        int height = view.getHeight();
        float f2 = width;
        if (f2 > 0.0f) {
            float f3 = height;
            if (f3 <= 0.0f) {
                return;
            }
            float f4 = this.h / f2;
            float f5 = this.i / f2;
            float f6 = this.j / f3;
            if (z2) {
                f2 = 0.0f;
            }
            view.setPivotX(f2);
            if (!z3) {
                f5 = -f4;
            }
            float fA = t8.a(0.0f, f5, interpolation);
            float f7 = fA + 1.0f;
            float fA2 = 1.0f - t8.a(0.0f, f6, interpolation);
            if (Float.isNaN(f7) || Float.isNaN(fA2)) {
                return;
            }
            view.setScaleX(f7);
            view.setScaleY(fA2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    childAt.setPivotX(z2 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f8 = z3 ? 1.0f - fA : 1.0f;
                    float f9 = fA2 != 0.0f ? (f7 / fA2) * f8 : 1.0f;
                    if (!Float.isNaN(f8) && !Float.isNaN(f9)) {
                        childAt.setScaleX(f8);
                        childAt.setScaleY(f9);
                    }
                }
            }
        }
    }
}
