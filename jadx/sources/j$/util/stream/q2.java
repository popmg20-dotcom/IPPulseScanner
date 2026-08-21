package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public class q2 implements y1 {
    public final double[] a;
    public int b;

    public q2(long j) {
        if (j >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            throw null;
        }
        this.a = new double[(int) j];
        this.b = 0;
    }

    @Override // j$.util.stream.d2, j$.util.stream.e2
    public final d2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.d2
    public final Object b() {
        double[] dArr = this.a;
        int length = dArr.length;
        int i = this.b;
        return length == i ? dArr : Arrays.copyOf(dArr, i);
    }

    @Override // j$.util.stream.e2
    public final long count() {
        return this.b;
    }

    @Override // j$.util.stream.d2
    public final void f(int i, Object obj) {
        int i2 = this.b;
        System.arraycopy(this.a, 0, (double[]) obj, i, i2);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ void forEach(Consumer consumer) {
        t3.q(this, consumer);
    }

    @Override // j$.util.stream.d2
    public final void g(Object obj) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i = 0; i < this.b; i++) {
            doubleConsumer.accept(this.a[i]);
        }
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ e2 j(long j, long j2, IntFunction intFunction) {
        return t3.t(this, j, j2);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ void k(Object[] objArr, int i) {
        t3.n(this, (Double[]) objArr, i);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ Object[] m(IntFunction intFunction) {
        return t3.m(this, intFunction);
    }

    @Override // j$.util.stream.e2
    public final int o() {
        return 0;
    }

    @Override // j$.util.stream.d2, j$.util.stream.e2
    public final j$.util.c1 spliterator() {
        int i = this.b;
        double[] dArr = this.a;
        Spliterators.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i);
        return new j$.util.j1(dArr, 0, i, 1040);
    }

    public String toString() {
        double[] dArr = this.a;
        return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(dArr.length - this.b), Arrays.toString(dArr));
    }

    @Override // j$.util.stream.e2
    public final e2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.e2
    public final Spliterator spliterator() {
        int i = this.b;
        double[] dArr = this.a;
        Spliterators.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i);
        return new j$.util.j1(dArr, 0, i, 1040);
    }

    public q2(double[] dArr) {
        this.a = dArr;
        this.b = dArr.length;
    }
}
