package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 extends a implements DoubleStream {
    public static j$.util.t0 Q(Spliterator spliterator) {
        if (spliterator instanceof j$.util.t0) {
            return (j$.util.t0) spliterator;
        }
        if (!e8.a) {
            throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
        }
        e8.a(a.class, "using DoubleStream.adapt(Spliterator<Double> s)");
        throw null;
    }

    @Override // j$.util.stream.a
    public final e2 B(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return t3.B(aVar, spliterator, z);
    }

    @Override // j$.util.stream.a
    public final boolean D(Spliterator spliterator, j5 j5Var) {
        DoubleConsumer d0Var;
        boolean zE;
        j$.util.t0 t0VarQ = Q(spliterator);
        if (j5Var instanceof DoubleConsumer) {
            d0Var = (DoubleConsumer) j5Var;
        } else {
            if (e8.a) {
                e8.a(a.class, "using DoubleStream.adapt(Sink<Double> s)");
                throw null;
            }
            Objects.requireNonNull(j5Var);
            d0Var = new j$.util.d0(j5Var, 1);
        }
        do {
            zE = j5Var.e();
            if (zE) {
                break;
            }
        } while (t0VarQ.tryAdvance(d0Var));
        return zE;
    }

    @Override // j$.util.stream.a
    public final x6 E() {
        return x6.DOUBLE_VALUE;
    }

    @Override // j$.util.stream.a
    public final w1 F(long j, IntFunction intFunction) {
        return t3.F(j);
    }

    @Override // j$.util.stream.a
    public final Spliterator M(a aVar, Supplier supplier, boolean z) {
        return new h7(aVar, supplier, z);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream a(j$.util.p pVar) {
        Objects.requireNonNull(pVar);
        return new w(this, w6.p | w6.n | w6.t, pVar, 0);
    }

    @Override // j$.util.stream.DoubleStream
    public final j$.util.a0 average() {
        double[] dArr = (double[]) collect(new o(8), new o(9), new o(10));
        if (dArr[2] <= 0.0d) {
            return j$.util.a0.c;
        }
        Set set = Collectors.a;
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        if (Double.isNaN(d) && Double.isInfinite(d2)) {
            d = d2;
        }
        return new j$.util.a0(d / dArr[2]);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream b() {
        Objects.requireNonNull(null);
        return new s(this, w6.p | w6.n, 0);
    }

    @Override // j$.util.stream.DoubleStream
    public final Stream boxed() {
        return new q(this, 0, new o(0), 0);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream c() {
        int i = w8.a;
        Objects.requireNonNull(null);
        return new b6(this, w8.a, 1);
    }

    @Override // j$.util.stream.DoubleStream
    public final Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 0);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objDoubleConsumer);
        Objects.requireNonNull(pVar);
        return z(new y3(x6.DOUBLE_VALUE, pVar, objDoubleConsumer, supplier, 1));
    }

    @Override // j$.util.stream.DoubleStream
    public final long count() {
        return ((Long) z(new a4(1))).longValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream d() {
        Objects.requireNonNull(null);
        return new s(this, w6.t, 2);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream distinct() {
        return ((b5) boxed()).distinct().mapToDouble(new o(1));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream e() {
        int i = w8.a;
        Objects.requireNonNull(null);
        return new b6(this, w8.b, 2);
    }

    @Override // j$.util.stream.DoubleStream
    public final j$.util.a0 findAny() {
        return (j$.util.a0) z(e0.d);
    }

    @Override // j$.util.stream.DoubleStream
    public final j$.util.a0 findFirst() {
        return (j$.util.a0) z(e0.c);
    }

    @Override // j$.util.stream.DoubleStream
    public void forEach(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        z(new l0(doubleConsumer, false));
    }

    @Override // j$.util.stream.DoubleStream
    public void forEachOrdered(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        z(new l0(doubleConsumer, true));
    }

    @Override // j$.util.stream.BaseStream
    public final j$.util.g0 iterator() {
        j$.util.t0 t0VarSpliterator = spliterator();
        Objects.requireNonNull(t0VarSpliterator);
        return new j$.util.h1(t0VarSpliterator);
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean j() {
        return ((Boolean) z(t3.Q(r1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream limit(long j) {
        if (j >= 0) {
            return t3.R(this, 0L, j);
        }
        j$.time.h.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.DoubleStream
    public final Stream mapToObj(DoubleFunction doubleFunction) {
        Objects.requireNonNull(doubleFunction);
        return new q(this, w6.p | w6.n, doubleFunction, 0);
    }

    @Override // j$.util.stream.DoubleStream
    public final j$.util.a0 max() {
        return reduce(new o(3));
    }

    @Override // j$.util.stream.DoubleStream
    public final j$.util.a0 min() {
        return reduce(new o(7));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream peek(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new w(this, doubleConsumer);
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean q() {
        return ((Boolean) z(t3.Q(r1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final LongStream r() {
        Objects.requireNonNull(null);
        return new u(this, w6.p | w6.n, 0);
    }

    @Override // j$.util.stream.DoubleStream
    public final double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return ((Double) z(new c4(x6.DOUBLE_VALUE, doubleBinaryOperator, d))).doubleValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : t3.R(this, j, -1L);
        }
        j$.time.h.c(Long.toString(j));
        return null;
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream sorted() {
        return new b6(this, w6.q | w6.o, 0);
    }

    @Override // j$.util.stream.a, j$.util.stream.BaseStream
    public final j$.util.t0 spliterator() {
        return Q(super.spliterator());
    }

    @Override // j$.util.stream.DoubleStream
    public final double sum() {
        double[] dArr = (double[]) collect(new o(4), new o(5), new o(6));
        Set set = Collectors.a;
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (Double.isNaN(d) && Double.isInfinite(d2)) ? d2 : d;
    }

    @Override // j$.util.stream.DoubleStream
    public final j$.util.w summaryStatistics() {
        return (j$.util.w) collect(new j$.time.z(11), new o(11), new j$.time.z(29));
    }

    @Override // j$.util.stream.DoubleStream
    public final IntStream t() {
        Objects.requireNonNull(null);
        return new t(this, w6.p | w6.n, 0);
    }

    @Override // j$.util.stream.DoubleStream
    public final double[] toArray() {
        return (double[]) t3.J((y1) A(new o(2))).b();
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean v() {
        return ((Boolean) z(t3.Q(r1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final j$.util.a0 reduce(DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return (j$.util.a0) z(new w3(x6.DOUBLE_VALUE, doubleBinaryOperator, 1));
    }
}
