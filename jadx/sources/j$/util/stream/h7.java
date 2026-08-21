package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class h7 extends y6 implements j$.util.t0 {
    @Override // j$.util.stream.y6
    public final void d() {
        m6 m6Var = new m6();
        this.h = m6Var;
        Objects.requireNonNull(m6Var);
        this.e = this.b.O(new g7(m6Var, 1));
        this.f = new j$.util.p(12, this);
    }

    @Override // j$.util.stream.y6
    public final y6 e(Spliterator spliterator) {
        return new h7(this.b, spliterator, this.a);
    }

    @Override // j$.util.c1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(doubleConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(doubleConsumer);
        c();
        Objects.requireNonNull(doubleConsumer);
        g7 g7Var = new g7(doubleConsumer, 0);
        this.b.N(this.d, g7Var);
        this.i = true;
    }

    @Override // j$.util.c1
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        boolean zA = a();
        if (zA) {
            m6 m6Var = (m6) this.h;
            long j = this.g;
            int iR = m6Var.r(j);
            doubleConsumer.accept((m6Var.c == 0 && iR == 0) ? ((double[]) m6Var.e)[(int) j] : ((double[][]) m6Var.f)[iR][(int) (j - m6Var.d[iR])]);
        }
        return zA;
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final j$.util.t0 trySplit() {
        return (j$.util.t0) super.trySplit();
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final j$.util.c1 trySplit() {
        return (j$.util.t0) super.trySplit();
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.t0) super.trySplit();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.time.a.h(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.time.a.x(this, consumer);
    }
}
