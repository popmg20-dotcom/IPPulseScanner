package defpackage;

import android.os.RemoteException;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g33 implements Runnable {
    public Object A;
    public final /* synthetic */ int b;
    public Object f;
    public Object z;

    public g33(dd5 dd5Var, AtomicReference atomicReference, tg5 tg5Var) {
        this.b = 10;
        this.f = atomicReference;
        this.z = tg5Var;
        Objects.requireNonNull(dd5Var);
        this.A = dd5Var;
    }

    private final void a() {
        AtomicReference atomicReference;
        dd5 dd5Var;
        k85 k85Var;
        l75 l75Var;
        AtomicReference atomicReference2 = (AtomicReference) this.f;
        synchronized (atomicReference2) {
            try {
                try {
                    dd5Var = (dd5) this.A;
                    k85Var = (k85) dd5Var.f;
                    l75Var = k85Var.X;
                    k85.f(l75Var);
                } catch (RemoteException e) {
                    t65 t65Var = ((k85) ((dd5) this.A).f).Y;
                    k85.h(t65Var);
                    t65Var.z0.b(e, "Failed to get app instance id");
                    atomicReference = (AtomicReference) this.f;
                }
                if (l75Var.c1().i(r95.ANALYTICS_STORAGE)) {
                    v55 v55Var = dd5Var.Z;
                    if (v55Var != null) {
                        atomicReference2.set(v55Var.C((tg5) this.z));
                        String str = (String) atomicReference2.get();
                        if (str != null) {
                            ib5 ib5Var = ((k85) dd5Var.f).D0;
                            k85.g(ib5Var);
                            ib5Var.A0.set(str);
                            l75 l75Var2 = k85Var.X;
                            k85.f(l75Var2);
                            l75Var2.A0.C(str);
                        }
                        dd5Var.i1();
                        atomicReference = (AtomicReference) this.f;
                        atomicReference.notify();
                        return;
                    }
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.a("Failed to get app instance id");
                } else {
                    t65 t65Var3 = k85Var.Y;
                    k85.h(t65Var3);
                    t65Var3.E0.a("Analytics storage consent denied; will not get app instance id");
                    ib5 ib5Var2 = ((k85) dd5Var.f).D0;
                    k85.g(ib5Var2);
                    ib5Var2.A0.set(null);
                    l75 l75Var3 = k85Var.X;
                    k85.f(l75Var3);
                    l75Var3.A0.C(null);
                    atomicReference2.set(null);
                }
                atomicReference2.notify();
            } catch (Throwable th) {
                ((AtomicReference) this.f).notify();
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x023d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g33.run():void");
    }

    public /* synthetic */ g33(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.A = obj;
        this.f = obj2;
        this.z = obj3;
    }

    public /* synthetic */ g33(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    public /* synthetic */ g33() {
        this.b = 4;
    }
}
