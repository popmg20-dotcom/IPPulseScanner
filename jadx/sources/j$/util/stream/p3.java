package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p3 extends CountedCompleter implements j5 {
    public final Spliterator a;
    public final a b;
    public final long c;
    public final long d;
    public final long e;
    public int f;
    public int g;

    public p3(p3 p3Var, Spliterator spliterator, long j, long j2, int i) {
        super(p3Var);
        this.a = spliterator;
        this.b = p3Var.b;
        this.c = p3Var.c;
        this.d = j;
        this.e = j2;
        if (j < 0 || j2 < 0 || (j + j2) - 1 >= i) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)));
        }
    }

    public abstract p3 a(Spliterator spliterator, long j, long j2);

    public /* synthetic */ void accept(double d) {
        t3.c();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.j5
    public final void c(long j) {
        long j2 = this.e;
        if (j > j2) {
            throw new IllegalStateException("size passed to Sink.begin exceeds array length");
        }
        int i = (int) this.d;
        this.f = i;
        this.g = i + ((int) j2);
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.a;
        p3 p3VarA = this;
        while (spliterator.estimateSize() > p3VarA.c && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            p3VarA.setPendingCount(1);
            long jEstimateSize = spliteratorTrySplit.estimateSize();
            p3VarA.a(spliteratorTrySplit, p3VarA.d, jEstimateSize).fork();
            p3VarA = p3VarA.a(spliterator, p3VarA.d + jEstimateSize, p3VarA.e - jEstimateSize);
        }
        p3VarA.b.N(spliterator, p3VarA);
        p3VarA.propagateCompletion();
    }

    @Override // j$.util.stream.j5
    public final boolean e() {
        return false;
    }

    public /* synthetic */ void accept(int i) {
        t3.k();
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        t3.l();
        throw null;
    }

    public p3(Spliterator spliterator, a aVar, int i) {
        this.a = spliterator;
        this.b = aVar;
        this.c = d.e(spliterator.estimateSize());
        this.d = 0L;
        this.e = i;
    }

    @Override // j$.util.stream.j5
    public final void end() {
    }
}
