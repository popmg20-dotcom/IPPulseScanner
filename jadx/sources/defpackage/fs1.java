package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fs1 implements Executor {
    public static volatile fs1 z;
    public final /* synthetic */ int b;
    public final Object f;

    public fs1(int i) {
        this.b = i;
        switch (i) {
            case 2:
                s05 s05Var = new s05(Looper.getMainLooper());
                Looper.getMainLooper();
                this.f = s05Var;
                break;
            default:
                this.f = Executors.newSingleThreadExecutor(new es1(0));
                break;
        }
    }

    public static Executor a() {
        if (z != null) {
            return z;
        }
        synchronized (fs1.class) {
            try {
                if (z == null) {
                    z = new fs1(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                ((ExecutorService) obj).execute(runnable);
                break;
            case 1:
                ((Handler) ((ih4) obj).c).post(runnable);
                break;
            default:
                ((s05) obj).post(runnable);
                break;
        }
    }

    public fs1(ih4 ih4Var) {
        this.b = 1;
        this.f = ih4Var;
    }
}
