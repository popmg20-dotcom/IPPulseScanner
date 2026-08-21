package androidx.core.app;

import android.os.Build;
import defpackage.dl1;
import defpackage.k01;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class FrameMetricsAggregator {
    public final k01 a;

    public FrameMetricsAggregator(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.a = new dl1(i);
        } else {
            this.a = new k01(20);
        }
    }

    public FrameMetricsAggregator() {
        this(1);
    }
}
