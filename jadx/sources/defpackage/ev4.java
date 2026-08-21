package defpackage;

import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ev4 implements WindowInsetsAnimationControlListener {
    public hu4 a = null;
    public final /* synthetic */ wn1 b;

    public ev4(wn1 wn1Var) {
        this.b = wn1Var;
    }

    public final void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
        ((bh3) this.b.f).b = null;
    }

    public final void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.a.getClass();
        ((bh3) this.b.f).b = null;
    }

    public final void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i) {
        hu4 hu4Var = new hu4(windowInsetsAnimationController);
        this.a = hu4Var;
        ((bh3) this.b.f).b = hu4Var;
    }
}
