package defpackage;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b55 {
    public static volatile b55 f;
    public final ExecutorService a;
    public final k01 b;
    public int c;
    public boolean d;
    public volatile t35 e;

    public b55(Context context, Bundle bundle) {
        hz hzVar = new hz(this);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), hzVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.a = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.b = new k01(9);
        new ArrayList();
        int i = 0;
        try {
            if (n12.Y(context, ye.T(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, b55.class.getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.d = true;
                    a1.n("FA", "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        a(new n45(this, context, bundle, i));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            a1.n("FA", "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new a55(i, this));
        }
    }

    public static b55 c(Context context, Bundle bundle) {
        tj4.i(context);
        if (f == null) {
            synchronized (b55.class) {
                try {
                    if (f == null) {
                        f = new b55(context, bundle);
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public final void a(v45 v45Var) {
        this.a.execute(v45Var);
    }

    public final void b(Exception exc, boolean z, boolean z2) {
        this.d |= z;
        if (z) {
            a1.o("FA", "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            a(new l45(this, exc));
        }
        a1.o("FA", "Error with data collection. Data lost.", exc);
    }
}
