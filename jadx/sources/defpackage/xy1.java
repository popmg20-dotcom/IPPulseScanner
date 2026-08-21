package defpackage;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.p;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xy1 implements aa2 {
    public static final n84 f = new n84(new t4(9));
    public final p b;

    public xy1(p pVar) {
        this.b = pVar;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        if (p92Var != p92.ON_DESTROY) {
            return;
        }
        Object systemService = this.b.getSystemService("input_method");
        systemService.getClass();
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        uy1 uy1Var = (uy1) f.getValue();
        Object objB = uy1Var.b(inputMethodManager);
        if (objB == null) {
            return;
        }
        synchronized (objB) {
            View viewC = uy1Var.c(inputMethodManager);
            if (viewC == null) {
                return;
            }
            if (viewC.isAttachedToWindow()) {
                return;
            }
            boolean zA = uy1Var.a(inputMethodManager);
            if (zA) {
                inputMethodManager.isActive();
            }
        }
    }
}
