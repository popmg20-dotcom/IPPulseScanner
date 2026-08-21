package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bp implements ap, kv4 {
    public static final bp b = new bp();
    public static final bp f = new bp();

    @Override // defpackage.kv4
    public jv4 a(Activity activity, eo0 eo0Var) {
        ap.d.getClass();
        return new jv4(new yo(zo.a().h(activity)), eo0Var.d(activity));
    }

    @Override // defpackage.kv4
    public jv4 c(Context context, eo0 eo0Var) {
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        float f2 = context.getResources().getDisplayMetrics().density;
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        bounds.getClass();
        return new jv4(bounds, f2);
    }

    @Override // defpackage.ap
    public Rect h(Activity activity) {
        Rect bounds = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        bounds.getClass();
        return bounds;
    }
}
