package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bi1 implements j31 {
    public final Context a;
    public final ai1 b;
    public final Object c = new Object();
    public Handler d;
    public ThreadPoolExecutor e;
    public ThreadPoolExecutor f;
    public fx3 g;

    public bi1(Context context, ai1 ai1Var) {
        r25.i(context, "Context cannot be null");
        this.a = context.getApplicationContext();
        this.b = ai1Var;
    }

    @Override // defpackage.j31
    public final void a(fx3 fx3Var) {
        synchronized (this.c) {
            this.g = fx3Var;
        }
        c();
    }

    public final void b() {
        synchronized (this.c) {
            try {
                this.g = null;
                Handler handler = this.d;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.d = null;
                ThreadPoolExecutor threadPoolExecutor = this.f;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.e = null;
                this.f = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.c) {
            try {
                if (this.g == null) {
                    return;
                }
                ThreadPoolExecutor threadPoolExecutor = this.e;
                if (threadPoolExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ca0("emojiCompat"));
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                    this.f = threadPoolExecutor2;
                    this.e = threadPoolExecutor2;
                    threadPoolExecutor = threadPoolExecutor2;
                }
                threadPoolExecutor.execute(new ga1(2, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ki1 d() {
        try {
            Context context = this.a;
            Object[] objArr = {this.b};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            t6 t6VarA = zh1.a(context, DesugarCollections.unmodifiableList(arrayList));
            int i = t6VarA.f;
            if (i != 0) {
                zo2.w(ha0.k("fetchFonts failed (", i, ")"));
                return null;
            }
            ki1[] ki1VarArr = (ki1[]) ((List) t6VarA.z).get(0);
            if (ki1VarArr != null && ki1VarArr.length != 0) {
                return ki1VarArr[0];
            }
            zo2.w("fetchFonts failed (empty result)");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zo2.o("provider not found", e);
            return null;
        }
    }
}
