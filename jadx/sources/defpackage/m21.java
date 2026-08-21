package defpackage;

import android.content.Context;
import android.view.WindowMetrics;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m21 implements am1 {
    public final /* synthetic */ v04 b;
    public final /* synthetic */ Context f;

    public /* synthetic */ m21(v04 v04Var, Context context) {
        this.b = v04Var;
        this.f = context;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        WindowMetrics windowMetrics = (WindowMetrics) obj;
        windowMetrics.getClass();
        return Boolean.valueOf(this.b.b(this.f, windowMetrics));
    }
}
