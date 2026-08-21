package defpackage;

import j$.util.Objects;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class um1 implements Runnable {
    public final /* synthetic */ int b;
    public Object f;
    public final Object z;

    public um1(vf vfVar) {
        this.b = 3;
        this.z = vfVar;
        this.f = new AtomicReference(null);
    }

    private final void a() {
        try {
            ((Runnable) this.z).run();
            synchronized (((la) this.f).A) {
                ((la) this.f).c();
            }
        } catch (Throwable th) {
            synchronized (((la) this.f).A) {
                ((la) this.f).c();
                throw th;
            }
        }
    }

    private final void b() {
        f95 f95Var = (f95) this.z;
        synchronized (f95Var.c) {
            e24 e24Var = (e24) f95Var.d;
            ((Map) ((e24) e24Var.z).z).remove((wa4) e24Var.f);
        }
    }

    private final void c() {
        f95 f95Var = (f95) this.z;
        synchronized (f95Var.c) {
            dv2 dv2Var = (dv2) f95Var.d;
            tj4.i(((wt2) this.f).c());
            dv2Var.c();
        }
    }

    private final void d() {
        f95 f95Var = (f95) this.z;
        synchronized (f95Var.c) {
            jf4 jf4Var = (jf4) f95Var.d;
            ((wt2) this.f).d();
            ((CountDownLatch) jf4Var.f).countDown();
        }
    }

    private final void e() {
        yc5 yc5Var = (yc5) this.z;
        synchronized (yc5Var) {
            try {
                yc5Var.b = false;
                dd5 dd5Var = yc5Var.z;
                if (!dd5Var.m1()) {
                    t65 t65Var = ((k85) dd5Var.f).Y;
                    k85.h(t65Var);
                    t65Var.G0.a("Connected to remote service");
                    v55 v55Var = (v55) this.f;
                    dd5Var.V0();
                    dd5Var.Z = v55Var;
                    dd5Var.i1();
                    dd5Var.k1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        dd5 dd5Var2 = ((yc5) this.z).z;
        ScheduledExecutorService scheduledExecutorService = dd5Var2.A0;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            dd5Var2.A0 = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:263:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e0  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.um1.run():void");
    }

    public String toString() {
        switch (this.b) {
            case 0:
                return um1.class.getSimpleName() + "," + ((om1) this.z);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ um1(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj2;
        this.z = obj3;
    }

    public /* synthetic */ um1(int i, Object obj, Object obj2, boolean z) {
        this.b = i;
        this.z = obj;
        this.f = obj2;
    }

    public um1(n75 n75Var, g35 g35Var, n75 n75Var2) {
        this.b = 14;
        this.f = g35Var;
        this.z = n75Var;
    }

    public um1(ib5 ib5Var, v35 v35Var) {
        this.b = 19;
        this.f = v35Var;
        Objects.requireNonNull(ib5Var);
        this.z = ib5Var;
    }

    public um1(dd5 dd5Var, rb5 rb5Var) {
        this.b = 23;
        this.f = rb5Var;
        Objects.requireNonNull(dd5Var);
        this.z = dd5Var;
    }

    public /* synthetic */ um1(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public um1(k22 k22Var, g22 g22Var, int i) {
        this.b = 5;
        this.z = k22Var;
        this.f = g22Var;
    }
}
