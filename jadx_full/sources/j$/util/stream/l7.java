package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class l7 extends y6 implements j$.util.z0 {
    @Override // j$.util.stream.y6
    public final void d() {
        q6 q6Var = new q6();
        this.h = q6Var;
        Objects.requireNonNull(q6Var);
        this.e = this.b.O(new k7(q6Var, 1));
        this.f = new j$.util.p(14, this);
    }

    @Override // j$.util.stream.y6
    public final y6 e(Spliterator spliterator) {
        return new l7(this.b, spliterator, this.a);
    }

    @Override // j$.util.c1
    public final void forEachRemaining(LongConsumer longConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(longConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(longConsumer);
        c();
        Objects.requireNonNull(longConsumer);
        k7 k7Var = new k7(longConsumer, 0);
        this.b.N(this.d, k7Var);
        this.i = true;
    }

    @Override // j$.util.c1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        boolean zA = a();
        if (zA) {
            q6 q6Var = (q6) this.h;
            long j = this.g;
            int iR = q6Var.r(j);
            longConsumer.accept((q6Var.c == 0 && iR == 0) ? ((long[]) q6Var.e)[(int) j] : ((long[][]) q6Var.f)[iR][(int) (j - q6Var.d[iR])]);
        }
        return zA;
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final j$.util.z0 trySplit() {
        return (j$.util.z0) super.trySplit();
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final j$.util.c1 trySplit() {
        return (j$.util.z0) super.trySplit();
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.z0) super.trySplit();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.time.a.j(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.time.a.z(this, consumer);
    }
}
