package defpackage;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.p;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b90 implements aa2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ b90(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        Window window;
        View viewPeekDecorView;
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                p pVar = (p) obj;
                if (p92Var == p92.ON_STOP && (window = pVar.getWindow()) != null && (viewPeekDecorView = window.peekDecorView()) != null) {
                    viewPeekDecorView.cancelPendingInputEvents();
                    break;
                }
                break;
            case 1:
                p pVar2 = (p) obj;
                if (p92Var == p92.ON_DESTROY) {
                    pVar2.f.a = null;
                    if (!pVar2.isChangingConfigurations()) {
                        pVar2.getViewModelStore().a();
                    }
                    f90 f90Var = pVar2.Y;
                    p pVar3 = f90Var.A;
                    pVar3.getWindow().getDecorView().removeCallbacks(f90Var);
                    pVar3.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(f90Var);
                }
                break;
            default:
                jp3 jp3Var = (jp3) obj;
                if (p92Var == p92.ON_START) {
                    jp3Var.h = true;
                } else if (p92Var == p92.ON_STOP) {
                    jp3Var.h = false;
                }
                break;
        }
    }
}
