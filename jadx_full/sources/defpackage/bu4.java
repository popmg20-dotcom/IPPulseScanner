package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import com.getsurfboard.R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bu4 extends eu4 {
    public static final PathInterpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final tb1 f = new tb1(0);
    public static final DecelerateInterpolator g = new DecelerateInterpolator(1.5f);
    public static final AccelerateInterpolator h = new AccelerateInterpolator(1.5f);

    public static void f(fu4 fu4Var, View view) {
        k70 k70VarJ = j(view);
        if (k70VarJ != null) {
            k70VarJ.P0(fu4Var);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(fu4Var, viewGroup.getChildAt(i));
            }
        }
    }

    public static void g(View view, fu4 fu4Var, bv4 bv4Var, boolean z) {
        k70 k70VarJ = j(view);
        if (k70VarJ != null) {
            k70VarJ.f = bv4Var;
            if (!z) {
                k70VarJ.Q0(fu4Var);
                z = true;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), fu4Var, bv4Var, z);
            }
        }
    }

    public static void h(View view, bv4 bv4Var, List list) {
        k70 k70VarJ = j(view);
        if (k70VarJ != null) {
            k70VarJ.R0(bv4Var, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                h(viewGroup.getChildAt(i), bv4Var, list);
            }
        }
    }

    public static void i(View view, fu4 fu4Var, e24 e24Var) {
        k70 k70VarJ = j(view);
        if (k70VarJ != null) {
            k70VarJ.S0(fu4Var, e24Var);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                i(viewGroup.getChildAt(i), fu4Var, e24Var);
            }
        }
    }

    public static k70 j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof au4) {
            return ((au4) tag).a;
        }
        return null;
    }
}
