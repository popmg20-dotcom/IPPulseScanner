package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends a0 {
    @Override // j$.util.stream.a
    public final boolean I() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.a0, j$.util.stream.DoubleStream
    public final void forEach(DoubleConsumer doubleConsumer) {
        if (this.a.k) {
            super.forEach(doubleConsumer);
        } else {
            a0.Q(L()).forEachRemaining(doubleConsumer);
        }
    }

    @Override // j$.util.stream.a0, j$.util.stream.DoubleStream
    public final void forEachOrdered(DoubleConsumer doubleConsumer) {
        if (this.a.k) {
            super.forEachOrdered(doubleConsumer);
        } else {
            a0.Q(L()).forEachRemaining(doubleConsumer);
        }
    }

    @Override // j$.util.stream.a, j$.util.stream.BaseStream
    public final DoubleStream parallel() {
        this.a.k = true;
        return this;
    }

    @Override // j$.util.stream.a, j$.util.stream.BaseStream
    public final DoubleStream sequential() {
        this.a.k = false;
        return this;
    }

    @Override // j$.util.stream.a, j$.util.stream.BaseStream
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // j$.util.stream.BaseStream
    public final BaseStream unordered() {
        return !w6.ORDERED.k(this.f) ? this : new s(this, w6.r, 1);
    }
}
