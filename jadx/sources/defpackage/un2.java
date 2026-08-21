package defpackage;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class un2 implements eu2 {
    public final AtomicReference f;
    public final Object b = new Object();
    public int z = 0;
    public boolean A = false;
    public final HashMap X = new HashMap();
    public final CopyOnWriteArraySet Y = new CopyOnWriteArraySet();

    public un2(Object obj) {
        this.f = new AtomicReference(obj);
    }

    @Override // defpackage.eu2
    public final void a(Executor executor, du2 du2Var) {
        s24 s24Var;
        synchronized (this.b) {
            s24 s24Var2 = (s24) this.X.remove(du2Var);
            if (s24Var2 != null) {
                s24Var2.z.set(false);
                this.Y.remove(s24Var2);
            }
            s24Var = new s24(this.f, executor, du2Var);
            this.X.put(du2Var, s24Var);
            this.Y.add(s24Var);
        }
        s24Var.a(0);
    }

    @Override // defpackage.eu2
    public final void f(du2 du2Var) {
        synchronized (this.b) {
            s24 s24Var = (s24) this.X.remove(du2Var);
            if (s24Var != null) {
                s24Var.z.set(false);
                this.Y.remove(s24Var);
            }
        }
    }
}
