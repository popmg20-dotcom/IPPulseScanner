package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yu0 implements Executor {
    public static volatile yu0 f;
    public static final /* synthetic */ yu0 z = new yu0(2);
    public final /* synthetic */ int b;

    public /* synthetic */ yu0(int i) {
        this.b = i;
    }

    public static yu0 a() {
        if (f != null) {
            return f;
        }
        synchronized (yu0.class) {
            try {
                if (f == null) {
                    f = new yu0(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.b) {
            case 0:
                runnable.run();
                break;
            case 1:
                new Thread(runnable).start();
                break;
            case 2:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
