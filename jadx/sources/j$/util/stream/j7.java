package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class j7 extends y6 implements j$.util.w0 {
    @Override // j$.util.stream.y6
    public final void d() {
        o6 o6Var = new o6();
        this.h = o6Var;
        Objects.requireNonNull(o6Var);
        this.e = this.b.O(new i7(o6Var, 1));
        this.f = new j$.util.p(13, this);
    }

    @Override // j$.util.stream.y6
    public final y6 e(Spliterator spliterator) {
        return new j7(this.b, spliterator, this.a);
    }

    @Override // j$.util.c1
    public final void forEachRemaining(IntConsumer intConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(intConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(intConsumer);
        c();
        Objects.requireNonNull(intConsumer);
        i7 i7Var = new i7(intConsumer, 0);
        this.b.N(this.d, i7Var);
        this.i = true;
    }

    @Override // j$.util.c1
    public final boolean tryAdvance(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        boolean zA = a();
        if (zA) {
            o6 o6Var = (o6) this.h;
            long j = this.g;
            int iR = o6Var.r(j);
            intConsumer.accept((o6Var.c == 0 && iR == 0) ? ((int[]) o6Var.e)[(int) j] : ((int[][]) o6Var.f)[iR][(int) (j - o6Var.d[iR])]);
        }
        return zA;
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final j$.util.w0 trySplit() {
        return (j$.util.w0) super.trySplit();
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final j$.util.c1 trySplit() {
        return (j$.util.w0) super.trySplit();
    }

    @Override // j$.util.stream.y6, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.w0) super.trySplit();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.time.a.i(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.time.a.y(this, consumer);
    }
}
