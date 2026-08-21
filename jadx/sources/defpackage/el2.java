package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class el2 extends hc2 implements rk2 {
    public static final Method V0;
    public cp1 U0;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                V0 = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // defpackage.rk2
    public final void G(nk2 nk2Var, sk2 sk2Var) {
        cp1 cp1Var = this.U0;
        if (cp1Var != null) {
            cp1Var.G(nk2Var, sk2Var);
        }
    }

    @Override // defpackage.hc2
    public final jy0 a(Context context, boolean z) {
        dl2 dl2Var = new dl2(context, z);
        dl2Var.setHoverListener(this);
        return dl2Var;
    }

    @Override // defpackage.rk2
    public final void d(nk2 nk2Var, MenuItem menuItem) {
        cp1 cp1Var = this.U0;
        if (cp1Var != null) {
            cp1Var.d(nk2Var, menuItem);
        }
    }
}
