package defpackage;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fu4 {
    public eu4 a;

    public fu4(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new du4(i7.b(i, interpolator, j));
        } else {
            this.a = new bu4(i, interpolator, j);
        }
    }

    public static void a(View view, k70 k70Var) {
        if (Build.VERSION.SDK_INT >= 30) {
            du4.h(view, k70Var);
            return;
        }
        PathInterpolator pathInterpolator = bu4.e;
        View.OnApplyWindowInsetsListener au4Var = new au4(view, k70Var);
        view.setTag(R.id.tag_window_insets_animation_callback, au4Var);
        if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
            view.setOnApplyWindowInsetsListener(au4Var);
        }
    }
}
