package defpackage;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hz implements ThreadFactory {
    public final /* synthetic */ int b;
    public final Object f;

    public hz(int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.f = new AtomicInteger(0);
                break;
            case 2:
                this.f = new AtomicInteger(0);
                break;
            default:
                this.f = new AtomicInteger(0);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                Thread thread = new Thread(new d4(5, runnable));
                thread.setPriority(7);
                Locale locale = Locale.US;
                thread.setName("CameraX-core_camera_" + ((AtomicInteger) obj).getAndIncrement());
                return thread;
            case 1:
                Thread thread2 = new Thread(runnable);
                thread2.setName("arch_disk_io_" + ((AtomicInteger) obj).getAndIncrement());
                return thread2;
            case 2:
                Thread thread3 = new Thread(runnable);
                Locale locale2 = Locale.US;
                thread3.setName("CameraX-camerax_io_" + ((AtomicInteger) obj).getAndIncrement());
                return thread3;
            default:
                Thread threadNewThread = ((ThreadFactory) obj).newThread(runnable);
                threadNewThread.setName("ScionFrontendApi");
                return threadNewThread;
        }
    }

    public hz(b55 b55Var) {
        this.b = 3;
        this.f = Executors.defaultThreadFactory();
    }
}
