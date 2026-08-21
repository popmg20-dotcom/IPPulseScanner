package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q82 extends vg4 {
    public final /* synthetic */ int X0;

    public /* synthetic */ q82(int i) {
        this.X0 = i;
    }

    @Override // defpackage.vg4
    public final void e(hh4 hh4Var) {
        switch (this.X0) {
            case 0:
                hh4Var.a.put("NavigationRailLabelVisibility", Integer.valueOf(hh4Var.b.getVisibility()));
                break;
            default:
                View view = hh4Var.b;
                if (view instanceof TextView) {
                    hh4Var.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
                }
                break;
        }
    }

    @Override // defpackage.vg4
    public final void h(hh4 hh4Var) {
        switch (this.X0) {
            case 0:
                hh4Var.a.put("NavigationRailLabelVisibility", Integer.valueOf(hh4Var.b.getVisibility()));
                break;
            default:
                View view = hh4Var.b;
                if (view instanceof TextView) {
                    hh4Var.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
                }
                break;
        }
    }

    @Override // defpackage.vg4
    public final Animator l(ViewGroup viewGroup, hh4 hh4Var, hh4 hh4Var2) {
        switch (this.X0) {
            case 0:
                if (hh4Var == null) {
                    return null;
                }
                HashMap map = hh4Var.a;
                if (hh4Var2 == null) {
                    return null;
                }
                HashMap map2 = hh4Var2.a;
                if (map.get("NavigationRailLabelVisibility") == null || map2.get("NavigationRailLabelVisibility") == null || ((Integer) map.get("NavigationRailLabelVisibility")).intValue() != 8 || ((Integer) map2.get("NavigationRailLabelVisibility")).intValue() != 0) {
                    return null;
                }
                View view = hh4Var2.b;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new p82(view, 0));
                return valueAnimatorOfFloat;
            default:
                if (hh4Var == null || hh4Var2 == null || !(hh4Var.b instanceof TextView)) {
                    return null;
                }
                View view2 = hh4Var2.b;
                if (!(view2 instanceof TextView)) {
                    return null;
                }
                TextView textView = (TextView) view2;
                HashMap map3 = hh4Var.a;
                HashMap map4 = hh4Var2.a;
                float fFloatValue = map3.get("android:textscale:scale") != null ? ((Float) map3.get("android:textscale:scale")).floatValue() : 1.0f;
                float fFloatValue2 = map4.get("android:textscale:scale") != null ? ((Float) map4.get("android:textscale:scale")).floatValue() : 1.0f;
                if (fFloatValue == fFloatValue2) {
                    return null;
                }
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
                valueAnimatorOfFloat2.addUpdateListener(new io(7, textView));
                return valueAnimatorOfFloat2;
        }
    }
}
