package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class oa0 implements ThreadFactory {
    public final AtomicInteger b = new AtomicInteger(0);
    public final /* synthetic */ boolean f;

    public oa0(boolean z) {
        this.f = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        runnable.getClass();
        return new Thread(runnable, (this.f ? "WM.task-" : "androidx.work-") + this.b.incrementAndGet());
    }
}
