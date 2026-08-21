package defpackage;

import android.os.StrictMode;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p90 implements da3 {
    public final /* synthetic */ int a;

    @Override // defpackage.da3
    public final Object get() {
        switch (this.a) {
            case 0:
                return Collections.EMPTY_SET;
            case 1:
                return ExecutorsRegistrar.a();
            case 2:
                a92 a92Var = ExecutorsRegistrar.a;
                return new yn0(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new tg0("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.d.get());
            case 3:
                a92 a92Var2 = ExecutorsRegistrar.a;
                return new yn0(Executors.newCachedThreadPool(new tg0("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.d.get());
            case 4:
                a92 a92Var3 = ExecutorsRegistrar.a;
                return Executors.newSingleThreadScheduledExecutor(new tg0("Firebase Scheduler", 0, null));
            default:
                return null;
        }
    }
}
