package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nf implements Executor {
    public final /* synthetic */ int b;
    public final Handler f;

    public nf() {
        this.b = 0;
        this.f = new Handler(Looper.getMainLooper());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i = this.b;
        Handler handler = this.f;
        switch (i) {
            case 0:
                handler.post(runnable);
                break;
            default:
                handler.post(runnable);
                break;
        }
    }

    public nf(Handler handler) {
        this.b = 1;
        this.f = handler;
    }
}
