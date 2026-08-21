package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xw1 extends HandlerThread {
    public final /* synthetic */ yw1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xw1(yw1 yw1Var) {
        super("IVpnService_handlerThread");
        this.b = yw1Var;
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        this.b.Y = new Handler(getLooper());
    }
}
