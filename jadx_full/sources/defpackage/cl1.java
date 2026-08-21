package defpackage;

import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window$OnFrameMetricsAvailableListener;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cl1 implements Window$OnFrameMetricsAvailableListener {
    public final /* synthetic */ dl1 a;

    public cl1(dl1 dl1Var) {
        this.a = dl1Var;
    }

    public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        dl1 dl1Var = this.a;
        if ((dl1Var.B0 & 1) != 0) {
            dl1.y(dl1Var.C0[0], frameMetrics.getMetric(8));
        }
        if ((dl1Var.B0 & 2) != 0) {
            dl1.y(dl1Var.C0[1], frameMetrics.getMetric(1));
        }
        if ((dl1Var.B0 & 4) != 0) {
            dl1.y(dl1Var.C0[2], frameMetrics.getMetric(3));
        }
        if ((dl1Var.B0 & 8) != 0) {
            dl1.y(dl1Var.C0[3], frameMetrics.getMetric(4));
        }
        if ((dl1Var.B0 & 16) != 0) {
            dl1.y(dl1Var.C0[4], frameMetrics.getMetric(5));
        }
        if ((dl1Var.B0 & 64) != 0) {
            dl1.y(dl1Var.C0[6], frameMetrics.getMetric(7));
        }
        if ((dl1Var.B0 & 32) != 0) {
            dl1.y(dl1Var.C0[5], frameMetrics.getMetric(6));
        }
        if ((dl1Var.B0 & 128) != 0) {
            dl1.y(dl1Var.C0[7], frameMetrics.getMetric(0));
        }
        if ((dl1Var.B0 & 256) != 0) {
            dl1.y(dl1Var.C0[8], frameMetrics.getMetric(2));
        }
    }
}
