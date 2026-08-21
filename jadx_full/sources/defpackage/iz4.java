package defpackage;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class iz4 implements ThreadFactory {
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean f;

    public /* synthetic */ iz4(String str, boolean z) {
        this.b = str;
        this.f = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.b);
        thread.setDaemon(this.f);
        return thread;
    }
}
