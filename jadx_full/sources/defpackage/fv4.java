package defpackage;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class fv4 extends vo {
    public final WindowInsetsController L0;
    public final Window M0;

    public fv4(Window window) {
        this.L0 = window.getInsetsController();
        this.M0 = window;
    }

    @Override // defpackage.vo
    public void J(boolean z) {
        T(16, 16, z);
    }

    @Override // defpackage.vo
    public void K(boolean z) {
        T(8192, 8, z);
    }

    public final void T(int i, int i2, boolean z) {
        Window window = this.M0;
        if (window == null) {
            WindowInsetsController windowInsetsController = this.L0;
            if (z) {
                windowInsetsController.setSystemBarsAppearance(i2, i2);
                return;
            } else {
                windowInsetsController.setSystemBarsAppearance(0, i2);
                return;
            }
        }
        if (z) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        } else {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility((~i) & decorView2.getSystemUiVisibility());
        }
    }

    @Override // defpackage.vo
    public final void i(wn1 wn1Var) {
        this.L0.controlWindowInsetsAnimation(8, -1L, null, null, new ev4(wn1Var));
    }

    @Override // defpackage.vo
    public boolean y() {
        Window window = this.M0;
        if (window == null) {
            this.L0.setSystemBarsAppearance(0, 0);
            if ((this.L0.getSystemBarsAppearance() & 8) != 0) {
                return true;
            }
        } else if ((window.getDecorView().getSystemUiVisibility() & 8192) != 0) {
            return true;
        }
        return false;
    }
}
