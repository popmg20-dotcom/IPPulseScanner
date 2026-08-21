package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class r0 extends CountedCompleter {
    public Spliterator a;
    public final j5 b;
    public final a c;
    public long d;

    public r0(r0 r0Var, Spliterator spliterator) {
        super(r0Var);
        this.a = spliterator;
        this.b = r0Var.b;
        this.d = r0Var.d;
        this.c = r0Var.c;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.a;
        long jEstimateSize = spliterator.estimateSize();
        long jE = this.d;
        if (jE == 0) {
            jE = d.e(jEstimateSize);
            this.d = jE;
        }
        boolean zK = w6.SHORT_CIRCUIT.k(this.c.f);
        j5 j5Var = this.b;
        boolean z = false;
        while (true) {
            if (zK && j5Var.e()) {
                break;
            }
            if (jEstimateSize <= jE || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                break;
            }
            r0 r0Var = new r0(this, spliteratorTrySplit);
            this.addToPendingCount(1);
            if (z) {
                spliterator = spliteratorTrySplit;
            } else {
                r0Var = this;
                this = r0Var;
            }
            z = !z;
            this.fork();
            this = r0Var;
            jEstimateSize = spliterator.estimateSize();
        }
        this.c.w(spliterator, j5Var);
        this.a = null;
        this.propagateCompletion();
    }

    public r0(a aVar, Spliterator spliterator, j5 j5Var) {
        super(null);
        this.b = j5Var;
        this.c = aVar;
        this.a = spliterator;
        this.d = 0L;
    }
}
