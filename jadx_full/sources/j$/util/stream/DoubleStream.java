package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public interface DoubleStream extends BaseStream<Double, DoubleStream> {
    DoubleStream a(j$.util.p pVar);

    j$.util.a0 average();

    DoubleStream b();

    Stream boxed();

    DoubleStream c();

    Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    long count();

    DoubleStream d();

    DoubleStream distinct();

    DoubleStream e();

    j$.util.a0 findAny();

    j$.util.a0 findFirst();

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    @Override // j$.util.stream.BaseStream
    j$.util.g0 iterator();

    boolean j();

    DoubleStream limit(long j);

    Stream mapToObj(DoubleFunction doubleFunction);

    j$.util.a0 max();

    j$.util.a0 min();

    @Override // j$.util.stream.BaseStream
    DoubleStream parallel();

    DoubleStream peek(DoubleConsumer doubleConsumer);

    boolean q();

    LongStream r();

    double reduce(double d, DoubleBinaryOperator doubleBinaryOperator);

    j$.util.a0 reduce(DoubleBinaryOperator doubleBinaryOperator);

    @Override // j$.util.stream.BaseStream
    DoubleStream sequential();

    DoubleStream skip(long j);

    DoubleStream sorted();

    @Override // j$.util.stream.BaseStream
    j$.util.t0 spliterator();

    double sum();

    j$.util.w summaryStatistics();

    IntStream t();

    double[] toArray();

    boolean v();
}
