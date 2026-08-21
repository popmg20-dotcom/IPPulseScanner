package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i1 extends a implements LongStream {
    public static j$.util.z0 Q(Spliterator spliterator) {
        if (spliterator instanceof j$.util.z0) {
            return (j$.util.z0) spliterator;
        }
        if (!e8.a) {
            throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
        }
        e8.a(a.class, "using LongStream.adapt(Spliterator<Long> s)");
        throw null;
    }

    @Override // j$.util.stream.a
    public final e2 B(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return t3.D(aVar, spliterator, z);
    }

    @Override // j$.util.stream.a
    public final boolean D(Spliterator spliterator, j5 j5Var) {
        LongConsumer l0Var;
        boolean zE;
        j$.util.z0 z0VarQ = Q(spliterator);
        if (j5Var instanceof LongConsumer) {
            l0Var = (LongConsumer) j5Var;
        } else {
            if (e8.a) {
                e8.a(a.class, "using LongStream.adapt(Sink<Long> s)");
                throw null;
            }
            Objects.requireNonNull(j5Var);
            l0Var = new j$.util.l0(j5Var, 1);
        }
        do {
            zE = j5Var.e();
            if (zE) {
                break;
            }
        } while (z0VarQ.tryAdvance(l0Var));
        return zE;
    }

    @Override // j$.util.stream.a
    public final x6 E() {
        return x6.LONG_VALUE;
    }

    @Override // j$.util.stream.a
    public final w1 F(long j, IntFunction intFunction) {
        return t3.P(j);
    }

    @Override // j$.util.stream.a
    public final Spliterator M(a aVar, Supplier supplier, boolean z) {
        return new l7(aVar, supplier, z);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream a(j$.util.p pVar) {
        Objects.requireNonNull(pVar);
        return new e1(this, w6.p | w6.n | w6.t, pVar, 0);
    }

    @Override // j$.util.stream.LongStream
    public final DoubleStream asDoubleStream() {
        return new s(this, w6.n, 5);
    }

    @Override // j$.util.stream.LongStream
    public final j$.util.a0 average() {
        long j = ((long[]) collect(new v0(6), new v0(7), new v0(8)))[0];
        return j > 0 ? new j$.util.a0(r4[1] / j) : j$.util.a0.c;
    }

    @Override // j$.util.stream.LongStream
    public final LongStream b() {
        Objects.requireNonNull(null);
        return new u(this, w6.p | w6.n, 3);
    }

    @Override // j$.util.stream.LongStream
    public final Stream boxed() {
        return new q(this, 0, new v0(5), 2);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream c() {
        int i = w8.a;
        Objects.requireNonNull(null);
        return new d6(this, w8.a, 1);
    }

    @Override // j$.util.stream.LongStream
    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 2);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objLongConsumer);
        Objects.requireNonNull(pVar);
        return z(new y3(x6.LONG_VALUE, pVar, objLongConsumer, supplier, 0));
    }

    @Override // j$.util.stream.LongStream
    public final long count() {
        return ((Long) z(new a4(0))).longValue();
    }

    @Override // j$.util.stream.LongStream
    public final LongStream d() {
        Objects.requireNonNull(null);
        return new u(this, w6.t, 5);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream distinct() {
        return ((b5) boxed()).distinct().mapToLong(new v0(12));
    }

    @Override // j$.util.stream.LongStream
    public final LongStream e() {
        int i = w8.a;
        Objects.requireNonNull(null);
        return new d6(this, w8.b, 2);
    }

    @Override // j$.util.stream.LongStream
    public final j$.util.c0 findAny() {
        return (j$.util.c0) z(g0.d);
    }

    @Override // j$.util.stream.LongStream
    public final j$.util.c0 findFirst() {
        return (j$.util.c0) z(g0.c);
    }

    public void forEach(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        z(new n0(longConsumer, false));
    }

    public void forEachOrdered(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        z(new n0(longConsumer, true));
    }

    @Override // j$.util.stream.LongStream
    public final DoubleStream h() {
        Objects.requireNonNull(null);
        return new s(this, w6.p | w6.n, 6);
    }

    @Override // j$.util.stream.BaseStream
    public final j$.util.o0 iterator() {
        j$.util.z0 z0VarSpliterator = spliterator();
        Objects.requireNonNull(z0VarSpliterator);
        return new j$.util.g1(z0VarSpliterator);
    }

    @Override // j$.util.stream.LongStream
    public final boolean l() {
        return ((Boolean) z(t3.U(r1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.LongStream
    public final LongStream limit(long j) {
        if (j >= 0) {
            return t3.V(this, 0L, j);
        }
        j$.time.h.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.LongStream
    public final Stream mapToObj(LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new q(this, w6.p | w6.n, longFunction, 2);
    }

    @Override // j$.util.stream.LongStream
    public final j$.util.c0 max() {
        return reduce(new v0(9));
    }

    @Override // j$.util.stream.LongStream
    public final j$.util.c0 min() {
        return reduce(new v0(11));
    }

    @Override // j$.util.stream.LongStream
    public final boolean o() {
        return ((Boolean) z(t3.U(r1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.LongStream
    public final LongStream peek(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new e1(this, longConsumer);
    }

    @Override // j$.util.stream.LongStream
    public final long reduce(long j, LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return ((Long) z(new u3(x6.LONG_VALUE, longBinaryOperator, j))).longValue();
    }

    @Override // j$.util.stream.LongStream
    public final boolean s() {
        return ((Boolean) z(t3.U(r1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.LongStream
    public final LongStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : t3.V(this, j, -1L);
        }
        j$.time.h.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.LongStream
    public final LongStream sorted() {
        return new d6(this, w6.q | w6.o, 0);
    }

    @Override // j$.util.stream.a, j$.util.stream.BaseStream
    public final j$.util.z0 spliterator() {
        return Q(super.spliterator());
    }

    @Override // j$.util.stream.LongStream
    public final long sum() {
        return reduce(0L, new v0(10));
    }

    @Override // j$.util.stream.LongStream
    public final j$.util.z summaryStatistics() {
        return (j$.util.z) collect(new j$.time.z(19), new v0(2), new v0(3));
    }

    @Override // j$.util.stream.LongStream
    public final long[] toArray() {
        return (long[]) t3.L((c2) A(new v0(4))).b();
    }

    @Override // j$.util.stream.LongStream
    public final IntStream u() {
        Objects.requireNonNull(null);
        return new t(this, w6.p | w6.n, 3);
    }

    @Override // j$.util.stream.LongStream
    public final j$.util.c0 reduce(LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return (j$.util.c0) z(new w3(x6.LONG_VALUE, longBinaryOperator, 0));
    }
}
