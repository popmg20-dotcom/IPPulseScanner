package defpackage;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class rb2 extends rf3 {
    public final of d;

    public rb2(r25 r25Var) {
        ExecutorService executorServiceNewFixedThreadPool;
        qb2 qb2Var = new qb2(this);
        zf2 zf2Var = new zf2(2, this);
        synchronized (n12.a) {
            try {
                executorServiceNewFixedThreadPool = n12.b;
                if (executorServiceNewFixedThreadPool == null) {
                    executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
                    n12.b = executorServiceNewFixedThreadPool;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        of ofVar = new of(zf2Var, new lb(10, executorServiceNewFixedThreadPool, r25Var));
        this.d = ofVar;
        ofVar.d.add(qb2Var);
    }

    @Override // defpackage.rf3
    public final int b() {
        return this.d.f.size();
    }

    public final Object q(int i) {
        return this.d.f.get(i);
    }

    public void r(List list) {
        this.d.b(list, null);
    }

    public void s(List list, Runnable runnable) {
        this.d.b(list, runnable);
    }
}
