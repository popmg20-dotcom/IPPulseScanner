package j$.util.stream;

import j$.util.Objects;
import j$.util.Optional;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b5 extends a implements Stream {
    @Override // j$.util.stream.a
    public final e2 B(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return t3.A(aVar, spliterator, z, intFunction);
    }

    @Override // j$.util.stream.a
    public final boolean D(Spliterator spliterator, j5 j5Var) {
        boolean zE;
        do {
            zE = j5Var.e();
            if (zE) {
                break;
            }
        } while (spliterator.tryAdvance(j5Var));
        return zE;
    }

    @Override // j$.util.stream.a
    public final x6 E() {
        return x6.REFERENCE;
    }

    @Override // j$.util.stream.a
    public final w1 F(long j, IntFunction intFunction) {
        return t3.x(j, intFunction);
    }

    @Override // j$.util.stream.a
    public final Spliterator M(a aVar, Supplier supplier, boolean z) {
        return new a8(aVar, supplier, z);
    }

    @Override // j$.util.stream.Stream
    public final Stream a(j$.util.p pVar) {
        Objects.requireNonNull(pVar);
        return new q(this, w6.p | w6.n | w6.t, pVar, 6);
    }

    @Override // j$.util.stream.Stream
    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) z(t3.W(r1.ALL, predicate))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) z(t3.W(r1.ANY, predicate))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final Object collect(Collector collector) {
        Collector collector2;
        Object objZ;
        if (this.a.k && collector.characteristics().contains(g.CONCURRENT) && (!w6.ORDERED.k(this.f) || collector.characteristics().contains(g.UNORDERED))) {
            objZ = collector.supplier().get();
            forEach(new j$.time.format.t(9, collector.accumulator(), objZ));
            collector2 = collector;
        } else {
            Supplier supplier = ((Collector) Objects.requireNonNull(collector)).supplier();
            collector2 = collector;
            objZ = z(new f4(x6.REFERENCE, collector.combiner(), collector.accumulator(), supplier, collector2));
        }
        return collector2.characteristics().contains(g.IDENTITY_FINISH) ? objZ : collector2.finisher().apply(objZ);
    }

    @Override // j$.util.stream.Stream
    public final long count() {
        return ((Long) z(new a4(2))).longValue();
    }

    @Override // j$.util.stream.Stream
    public final Stream distinct() {
        return new m(this, w6.m | w6.t);
    }

    @Override // j$.util.stream.Stream
    public final Stream dropWhile(Predicate predicate) {
        int i = w8.a;
        Objects.requireNonNull(predicate);
        return new f8(this, w8.b, predicate, 1);
    }

    @Override // j$.util.stream.Stream
    public final Stream filter(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new q(this, w6.t, predicate, 4);
    }

    @Override // j$.util.stream.Stream
    public final Optional findAny() {
        return (Optional) z(h0.d);
    }

    @Override // j$.util.stream.Stream
    public final Optional findFirst() {
        return (Optional) z(h0.c);
    }

    @Override // j$.util.stream.Stream
    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        z(new o0(consumer, false));
    }

    @Override // j$.util.stream.Stream
    public void forEachOrdered(Consumer consumer) {
        Objects.requireNonNull(consumer);
        z(new o0(consumer, true));
    }

    @Override // j$.util.stream.BaseStream
    public final Iterator iterator() {
        Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.e1(spliterator);
    }

    @Override // j$.util.stream.Stream
    public final LongStream k(j$.util.p pVar) {
        Objects.requireNonNull(pVar);
        return new e1(this, w6.p | w6.n | w6.t, pVar, 2);
    }

    @Override // j$.util.stream.Stream
    public final Stream limit(long j) {
        if (j >= 0) {
            return t3.X(this, 0L, j);
        }
        j$.time.h.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.Stream
    public final Stream map(Function function) {
        Objects.requireNonNull(function);
        return new q(this, w6.p | w6.n, function, 5);
    }

    @Override // j$.util.stream.Stream
    public final DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new w(this, w6.p | w6.n, toDoubleFunction, 2);
    }

    @Override // j$.util.stream.Stream
    public final IntStream mapToInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new t0(this, w6.p | w6.n, toIntFunction, 3);
    }

    @Override // j$.util.stream.Stream
    public final LongStream mapToLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new e1(this, w6.p | w6.n, toLongFunction, 3);
    }

    @Override // j$.util.stream.Stream
    public final Optional max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new j$.util.function.a(comparator, 0));
    }

    @Override // j$.util.stream.Stream
    public final Optional min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new j$.util.function.a(comparator, 1));
    }

    @Override // j$.util.stream.Stream
    public final DoubleStream n(j$.util.p pVar) {
        Objects.requireNonNull(pVar);
        return new w(this, w6.p | w6.n | w6.t, pVar, 3);
    }

    @Override // j$.util.stream.Stream
    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) z(t3.W(r1.NONE, predicate))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final IntStream p(j$.util.p pVar) {
        Objects.requireNonNull(pVar);
        return new t0(this, w6.p | w6.n | w6.t, pVar, 4);
    }

    @Override // j$.util.stream.Stream
    public final Stream peek(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new q(this, consumer);
    }

    @Override // j$.util.stream.Stream
    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(binaryOperator);
        return z(new y3(x6.REFERENCE, binaryOperator, biFunction, obj, 2));
    }

    @Override // j$.util.stream.Stream
    public final Stream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : t3.X(this, j, -1L);
        }
        j$.time.h.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted() {
        return new e6(this);
    }

    @Override // j$.util.stream.Stream
    public final Stream takeWhile(Predicate predicate) {
        int i = w8.a;
        Objects.requireNonNull(predicate);
        return new f8(this, w8.a, predicate, 0);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray(IntFunction intFunction) {
        return t3.I(A(intFunction), intFunction).m(intFunction);
    }

    @Override // j$.util.stream.Stream
    public final List toList() {
        return Collections.unmodifiableList(new ArrayList(Arrays.asList(toArray())));
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return new e6(this, comparator);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray() {
        return toArray(new v0(22));
    }

    @Override // j$.util.stream.Stream
    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        Objects.requireNonNull(binaryOperator);
        return z(new y3(x6.REFERENCE, binaryOperator, binaryOperator, obj, 2));
    }

    @Override // j$.util.stream.Stream
    public final Optional reduce(BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (Optional) z(new w3(x6.REFERENCE, binaryOperator, 2));
    }

    @Override // j$.util.stream.Stream
    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return z(new y3(x6.REFERENCE, biConsumer2, biConsumer, supplier, 3));
    }
}
