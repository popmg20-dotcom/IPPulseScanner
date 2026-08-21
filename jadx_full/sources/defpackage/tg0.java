package defpackage;

import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tg0 implements ThreadFactory {
    public static final ThreadFactory X = Executors.defaultThreadFactory();
    public final StrictMode.ThreadPolicy A;
    public final AtomicLong b = new AtomicLong();
    public final String f;
    public final int z;

    public tg0(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        this.f = str;
        this.z = i;
        this.A = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = X.newThread(new s7(22, this, runnable));
        Locale locale = Locale.ROOT;
        threadNewThread.setName(this.f + " Thread #" + this.b.getAndIncrement());
        return threadNewThread;
    }
}
