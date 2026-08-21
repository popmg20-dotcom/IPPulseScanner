package defpackage;

import android.os.RemoteException;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d20 implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public d20(ib5 ib5Var, AtomicReference atomicReference, String str, String str2) {
        this.b = 5;
        this.f = atomicReference;
        this.z = str;
        this.A = str2;
        Objects.requireNonNull(ib5Var);
        this.X = ib5Var;
    }

    private final void a() {
        v55 v55Var;
        dd5 dd5Var = (dd5) this.f;
        AtomicReference atomicReference = (AtomicReference) this.z;
        tg5 tg5Var = (tg5) this.A;
        le5 le5Var = (le5) this.X;
        synchronized (atomicReference) {
            try {
                v55Var = dd5Var.Z;
            } catch (RemoteException e) {
                t65 t65Var = ((k85) dd5Var.f).Y;
                k85.h(t65Var);
                t65Var.z0.b(e, "[sgtm] Failed to get upload batches; remote exception");
                atomicReference.notifyAll();
            }
            if (v55Var != null) {
                v55Var.u(tg5Var, le5Var, new cc5(dd5Var, atomicReference));
                dd5Var.i1();
            } else {
                t65 t65Var2 = ((k85) dd5Var.f).Y;
                k85.h(t65Var2);
                t65Var2.z0.a("[sgtm] Failed to get upload batches; not connected to service");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0368  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d20.run():void");
    }

    public /* synthetic */ d20(Object obj, Object obj2, Object obj3, Object obj4, int i, boolean z) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
        this.X = obj4;
    }

    public /* synthetic */ d20(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.b = i;
        this.X = obj;
        this.f = obj2;
        this.z = obj3;
        this.A = obj4;
    }
}
