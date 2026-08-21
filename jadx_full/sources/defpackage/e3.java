package defpackage;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e3 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ActionBarOverlayLayout f;

    public /* synthetic */ e3(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.b = i;
        this.f = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f;
        switch (i) {
            case 0:
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.Q0 = actionBarOverlayLayout.A.animate().translationY(0.0f).setListener(actionBarOverlayLayout.R0);
                break;
            default:
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.Q0 = actionBarOverlayLayout.A.animate().translationY(-actionBarOverlayLayout.A.getHeight()).setListener(actionBarOverlayLayout.R0);
                break;
        }
    }
}
