package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends CountedCompleter {
    public final a a;
    public Spliterator b;
    public final long c;
    public final ConcurrentHashMap d;
    public final p0 e;
    public final q0 f;
    public e2 g;

    public q0(a aVar, Spliterator spliterator, p0 p0Var) {
        super(null);
        this.a = aVar;
        this.b = spliterator;
        this.c = d.e(spliterator.estimateSize());
        this.d = new ConcurrentHashMap(Math.max(16, d.g << 1));
        this.e = p0Var;
        this.f = null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.b;
        long j = this.c;
        boolean z = false;
        while (spliterator.estimateSize() > j && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            q0 q0Var = new q0(this, spliteratorTrySplit, this.f);
            q0 q0Var2 = new q0(this, spliterator, q0Var);
            this.addToPendingCount(1);
            q0Var2.addToPendingCount(1);
            this.d.put(q0Var, q0Var2);
            if (this.f != null) {
                q0Var.addToPendingCount(1);
                if (this.d.replace(this.f, this, q0Var)) {
                    this.addToPendingCount(-1);
                } else {
                    q0Var.addToPendingCount(-1);
                }
            }
            if (z) {
                spliterator = spliteratorTrySplit;
                this = q0Var;
                q0Var = q0Var2;
            } else {
                this = q0Var2;
            }
            z = !z;
            q0Var.fork();
        }
        if (this.getPendingCount() > 0) {
            o oVar = new o(20);
            a aVar = this.a;
            w1 w1VarF = aVar.F(aVar.C(spliterator), oVar);
            this.a.N(spliterator, w1VarF);
            this.g = w1VarF.build();
            this.b = null;
        }
        this.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        e2 e2Var = this.g;
        if (e2Var != null) {
            e2Var.forEach(this.e);
            this.g = null;
        } else {
            Spliterator spliterator = this.b;
            if (spliterator != null) {
                this.a.N(spliterator, this.e);
                this.b = null;
            }
        }
        q0 q0Var = (q0) this.d.remove(this);
        if (q0Var != null) {
            q0Var.tryComplete();
        }
    }

    public q0(q0 q0Var, Spliterator spliterator, q0 q0Var2) {
        super(q0Var);
        this.a = q0Var.a;
        this.b = spliterator;
        this.c = q0Var.c;
        this.d = q0Var.d;
        this.e = q0Var.e;
        this.f = q0Var2;
    }
}
