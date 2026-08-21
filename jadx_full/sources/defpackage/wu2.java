package defpackage;

import android.window.OnBackInvokedDispatcher;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wu2 {
    public final Runnable a;
    public final n84 b = new n84(new fn(12, this));

    public wu2(Runnable runnable) {
        this.a = runnable;
    }

    public final void a(da2 da2Var, ru2 ru2Var) {
        da2Var.getClass();
        ru2Var.getClass();
        final r92 lifecycle = da2Var.getLifecycle();
        if (lifecycle.b() == q92.b) {
            return;
        }
        qu2 qu2Var = new qu2(ru2Var, new su2(da2Var, ru2Var));
        ru2Var.a.add(qu2Var);
        qu2Var.c(false);
        iv1.b(c().c, qu2Var);
        final bm0 bm0Var = new bm0(qu2Var, this, lifecycle);
        lifecycle.a(bm0Var);
        ru2Var.c.add(new AutoCloseable() { // from class: tu2
            @Override // java.lang.AutoCloseable
            public final void close() {
                lifecycle.c(bm0Var);
            }
        });
    }

    public final void b(ru2 ru2Var) {
        ru2Var.getClass();
        qu2 qu2Var = new qu2(ru2Var, new su2(null, ru2Var));
        ru2Var.a.add(qu2Var);
        iv1.b(c().c, qu2Var);
    }

    public final uu2 c() {
        return (uu2) this.b.getValue();
    }

    public final void d() {
        c().a();
    }

    public final void e(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        c().c.d(new nu2(onBackInvokedDispatcher, 0), 1);
        c().c.d(new nu2(onBackInvokedDispatcher, 1000000), 0);
    }
}
