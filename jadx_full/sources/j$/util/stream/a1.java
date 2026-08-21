package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a1 extends a implements IntStream {
    public static j$.util.w0 Q(Spliterator spliterator) {
        if (spliterator instanceof j$.util.w0) {
            return (j$.util.w0) spliterator;
        }
        if (!e8.a) {
            throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
        }
        e8.a(a.class, "using IntStream.adapt(Spliterator<Integer> s)");
        throw null;
    }

    @Override // j$.util.stream.a
    public final e2 B(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return t3.C(aVar, spliterator, z);
    }

    @Override // j$.util.stream.a
    public final boolean D(Spliterator spliterator, j5 j5Var) {
        IntConsumer h0Var;
        boolean zE;
        j$.util.w0 w0VarQ = Q(spliterator);
        if (j5Var instanceof IntConsumer) {
            h0Var = (IntConsumer) j5Var;
        } else {
            if (e8.a) {
                e8.a(a.class, "using IntStream.adapt(Sink<Integer> s)");
                throw null;
            }
            Objects.requireNonNull(j5Var);
            h0Var = new j$.util.h0(j5Var, 1);
        }
        do {
            zE = j5Var.e();
            if (zE) {
                break;
            }
        } while (w0VarQ.tryAdvance(h0Var));
        return zE;
    }

    @Override // j$.util.stream.a
    public final x6 E() {
        return x6.INT_VALUE;
    }

    @Override // j$.util.stream.a
    public final w1 F(long j, IntFunction intFunction) {
        return t3.O(j);
    }

    @Override // j$.util.stream.a
    public final Spliterator M(a aVar, Supplier supplier, boolean z) {
        return new j7(aVar, supplier, z);
    }

    @Override // j$.util.stream.IntStream
    public final boolean allMatch(IntPredicate intPredicate) {
        return ((Boolean) z(t3.S(r1.ALL, intPredicate))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final boolean anyMatch(IntPredicate intPredicate) {
        return ((Boolean) z(t3.S(r1.ANY, intPredicate))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final DoubleStream asDoubleStream() {
        return new s(this, 0, 3);
    }

    @Override // j$.util.stream.IntStream
    public final LongStream asLongStream() {
        return new u(this, 0, 1);
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.a0 average() {
        long j = ((long[]) collect(new o(27), new o(28), new o(29)))[0];
        return j > 0 ? new j$.util.a0(r4[1] / j) : j$.util.a0.c;
    }

    @Override // j$.util.stream.IntStream
    public final IntStream b() {
        Objects.requireNonNull(null);
        return new t(this, w6.p | w6.n, 1);
    }

    @Override // j$.util.stream.IntStream
    public final Stream boxed() {
        return new q(this, 0, new v0(1), 1);
    }

    @Override // j$.util.stream.IntStream
    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 1);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objIntConsumer);
        Objects.requireNonNull(pVar);
        return z(new y3(x6.INT_VALUE, pVar, objIntConsumer, supplier, 4));
    }

    @Override // j$.util.stream.IntStream
    public final long count() {
        return ((Long) z(new a4(3))).longValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream distinct() {
        return ((b5) boxed()).distinct().mapToInt(new v0(0));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream dropWhile(IntPredicate intPredicate) {
        int i = w8.a;
        Objects.requireNonNull(intPredicate);
        return new i8(this, w8.b, intPredicate, 1);
    }

    @Override // j$.util.stream.IntStream
    public final DoubleStream f() {
        Objects.requireNonNull(null);
        return new s(this, w6.p | w6.n, 4);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream filter(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        return new t0(this, w6.t, intPredicate, 2);
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.b0 findAny() {
        return (j$.util.b0) z(f0.d);
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.b0 findFirst() {
        return (j$.util.b0) z(f0.c);
    }

    @Override // j$.util.stream.IntStream
    public void forEach(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        z(new m0(intConsumer, false));
    }

    @Override // j$.util.stream.IntStream
    public void forEachOrdered(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        z(new m0(intConsumer, true));
    }

    @Override // j$.util.stream.IntStream
    public final LongStream i() {
        Objects.requireNonNull(null);
        return new u(this, w6.p | w6.n, 2);
    }

    @Override // j$.util.stream.BaseStream
    public final j$.util.k0 iterator() {
        j$.util.w0 w0VarSpliterator = spliterator();
        Objects.requireNonNull(w0VarSpliterator);
        return new j$.util.f1(w0VarSpliterator);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream limit(long j) {
        if (j >= 0) {
            return t3.T(this, 0L, j);
        }
        j$.time.h.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.IntStream
    public final IntStream m(k0 k0Var) {
        Objects.requireNonNull(k0Var);
        return new t0(this, w6.p | w6.n | w6.t, k0Var, 1);
    }

    @Override // j$.util.stream.IntStream
    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new q(this, w6.p | w6.n, intFunction, 1);
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.b0 max() {
        return reduce(new o(26));
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.b0 min() {
        return reduce(new o(22));
    }

    @Override // j$.util.stream.IntStream
    public final boolean noneMatch(IntPredicate intPredicate) {
        return ((Boolean) z(t3.S(r1.NONE, intPredicate))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream peek(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new t0(this, intConsumer);
    }

    @Override // j$.util.stream.IntStream
    public final int reduce(int i, IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return ((Integer) z(new j4(x6.INT_VALUE, intBinaryOperator, i))).intValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : t3.T(this, j, -1L);
        }
        j$.time.h.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.IntStream
    public final IntStream sorted() {
        return new c6(this, w6.q | w6.o);
    }

    @Override // j$.util.stream.a, j$.util.stream.BaseStream
    public final j$.util.w0 spliterator() {
        return Q(super.spliterator());
    }

    @Override // j$.util.stream.IntStream
    public final int sum() {
        return reduce(0, new o(25));
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.x summaryStatistics() {
        return (j$.util.x) collect(new j$.time.z(16), new o(23), new o(24));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream takeWhile(IntPredicate intPredicate) {
        int i = w8.a;
        Objects.requireNonNull(intPredicate);
        return new i8(this, w8.a, intPredicate, 0);
    }

    @Override // j$.util.stream.IntStream
    public final int[] toArray() {
        return (int[]) t3.K((a2) A(new o(21))).b();
    }

    @Override // j$.util.stream.IntStream
    public final j$.util.b0 reduce(IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return (j$.util.b0) z(new w3(x6.INT_VALUE, intBinaryOperator, 3));
    }
}
