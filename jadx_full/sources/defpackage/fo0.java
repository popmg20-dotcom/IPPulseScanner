package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fo0 implements eo0, kv4 {
    public static final fo0 b = new fo0();
    public static final fo0 f = new fo0();

    @Override // defpackage.kv4
    public jv4 a(Activity activity, eo0 eo0Var) {
        ap.d.getClass();
        return new jv4(new yo(zo.a().h(activity)), eo0Var.d(activity));
    }

    @Override // defpackage.kv4
    public jv4 c(Context context, eo0 eo0Var) {
        WindowManager windowManager = context.isUiContext() ? (WindowManager) context.getSystemService(WindowManager.class) : (WindowManager) context.getApplicationContext().getSystemService(WindowManager.class);
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        bounds.getClass();
        return new jv4(bounds, windowManager.getCurrentWindowMetrics().getDensity());
    }

    @Override // defpackage.eo0
    public float d(Context context) {
        return ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getDensity();
    }
}
