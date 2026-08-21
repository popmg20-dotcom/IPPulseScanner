package defpackage;

import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class cv4 extends vo {
    public final Window L0;

    public cv4(Window window) {
        this.L0 = window;
    }

    @Override // defpackage.vo
    public final void K(boolean z) {
        Window window = this.L0;
        if (!z) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }

    @Override // defpackage.vo
    public final boolean y() {
        return (this.L0.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    @Override // defpackage.vo
    public final void i(wn1 wn1Var) {
    }
}
