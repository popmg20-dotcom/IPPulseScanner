package defpackage;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bl implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ dl f;

    public /* synthetic */ bl(dl dlVar, int i) {
        this.b = i;
        this.f = dlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        dl dlVar = this.f;
        switch (i) {
            case 0:
                if (dlVar.y0 > 0) {
                    dlVar.z0 = SystemClock.uptimeMillis();
                }
                dlVar.setVisibility(0);
                break;
            default:
                ((vx0) dlVar.getCurrentDrawable()).d(false, false, true);
                if ((dlVar.getProgressDrawable() == null || !dlVar.getProgressDrawable().isVisible()) && (dlVar.getIndeterminateDrawable() == null || !dlVar.getIndeterminateDrawable().isVisible())) {
                    dlVar.setVisibility(4);
                }
                dlVar.z0 = -1L;
                break;
        }
    }
}
