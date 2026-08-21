package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b0 implements DoubleStream {
    public final /* synthetic */ java.util.stream.DoubleStream a;

    public /* synthetic */ b0(java.util.stream.DoubleStream doubleStream) {
        this.a = doubleStream;
    }

    public static /* synthetic */ DoubleStream g(java.util.stream.DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof c0 ? ((c0) doubleStream).a : new b0(doubleStream);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream a(j$.util.p pVar) {
        java.util.stream.DoubleStream doubleStream = this.a;
        j$.util.p pVar2 = new j$.util.p(6);
        pVar2.b = pVar;
        return g(doubleStream.flatMap(pVar2));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ j$.util.a0 average() {
        return j$.time.a.B(this.a.average());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream b() {
        return g(this.a.map(null));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ Stream boxed() {
        return u6.g(this.a.boxed());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream c() {
        return g(this.a.takeWhile(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.a.close();
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ long count() {
        return this.a.count();
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream d() {
        return g(this.a.filter(null));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream distinct() {
        return g(this.a.distinct());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream e() {
        return g(this.a.dropWhile(null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.DoubleStream doubleStream = this.a;
        if (obj instanceof b0) {
            obj = ((b0) obj).a;
        }
        return doubleStream.equals(obj);
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ j$.util.a0 findAny() {
        return j$.time.a.B(this.a.findAny());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ j$.util.a0 findFirst() {
        return j$.time.a.B(this.a.findFirst());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.a.forEach(doubleConsumer);
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.PrimitiveIterator$OfDouble] */
    @Override // j$.util.stream.DoubleStream, j$.util.stream.BaseStream
    public final /* synthetic */ j$.util.g0 iterator() {
        ?? it = this.a.iterator();
        if (it == 0) {
            return null;
        }
        return it instanceof j$.util.f0 ? ((j$.util.f0) it).a : new j$.util.e0(it);
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ boolean j() {
        return this.a.anyMatch(null);
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream limit(long j) {
        return g(this.a.limit(j));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return u6.g(this.a.mapToObj(doubleFunction));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ j$.util.a0 max() {
        return j$.time.a.B(this.a.max());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ j$.util.a0 min() {
        return j$.time.a.B(this.a.min());
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return e.g(this.a.onClose(runnable));
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return e.g(this.a.parallel());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
        return g(this.a.peek(doubleConsumer));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ boolean q() {
        return this.a.allMatch(null);
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ LongStream r() {
        return j1.g(this.a.mapToLong(null));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ j$.util.a0 reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return j$.time.a.B(this.a.reduce(doubleBinaryOperator));
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return e.g(this.a.sequential());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream skip(long j) {
        return g(this.a.skip(j));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ DoubleStream sorted() {
        return g(this.a.sorted());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Spliterator$OfDouble] */
    @Override // j$.util.stream.DoubleStream, j$.util.stream.BaseStream
    public final /* synthetic */ j$.util.t0 spliterator() {
        return j$.util.r0.a(this.a.spliterator());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ double sum() {
        return this.a.sum();
    }

    @Override // j$.util.stream.DoubleStream
    public final j$.util.w summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ IntStream t() {
        return IntStream.VivifiedWrapper.convert(this.a.mapToInt(null));
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ double[] toArray() {
        return this.a.toArray();
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return e.g(this.a.unordered());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ boolean v() {
        return this.a.noneMatch(null);
    }

    @Override // j$.util.stream.DoubleStream, j$.util.stream.BaseStream
    public final /* synthetic */ DoubleStream parallel() {
        return g(this.a.parallel());
    }

    @Override // j$.util.stream.DoubleStream
    public final /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        return this.a.reduce(d, doubleBinaryOperator);
    }

    @Override // j$.util.stream.DoubleStream, j$.util.stream.BaseStream
    public final /* synthetic */ DoubleStream sequential() {
        return g(this.a.sequential());
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.d1.a(this.a.spliterator());
    }

    @Override // j$.util.stream.BaseStream
    public final /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }
}
