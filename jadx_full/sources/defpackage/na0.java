package defpackage;

import android.os.Build;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class na0 {
    public final ExecutorService a = n12.q(false);
    public final gm0 b = qv0.a;
    public final ExecutorService c = n12.q(true);
    public final d84 d = new d84(1);
    public final w7 e = new w7(22);
    public final int f;
    public final t60 g;

    public na0(wl3 wl3Var) {
        this.f = Build.VERSION.SDK_INT == 23 ? 10 : 20;
        this.g = new t60();
    }
}
