package defpackage;

import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wo3 implements WindowManager {
    public final WindowManager b;

    public wo3(xo3 xo3Var, WindowManager windowManager) {
        this.b = windowManager;
    }

    @Override // android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        try {
            Log.d("WindowManagerWrapper", "WindowManager's addView(view, params) has been hooked.");
            this.b.addView(view, layoutParams);
        } catch (WindowManager.BadTokenException e) {
            Log.i("WindowManagerWrapper", e.getMessage());
            int i = xo3.a;
        } catch (Throwable th) {
            a1.e("WindowManagerWrapper", "[addView]", th);
        }
    }

    @Override // android.view.WindowManager
    public final Display getDefaultDisplay() {
        return this.b.getDefaultDisplay();
    }

    @Override // android.view.ViewManager
    public final void removeView(View view) {
        this.b.removeView(view);
    }

    @Override // android.view.WindowManager
    public final void removeViewImmediate(View view) {
        this.b.removeViewImmediate(view);
    }

    @Override // android.view.ViewManager
    public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        this.b.updateViewLayout(view, layoutParams);
    }
}
