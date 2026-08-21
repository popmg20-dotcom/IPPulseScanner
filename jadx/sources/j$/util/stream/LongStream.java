package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public interface LongStream extends BaseStream<Long, LongStream> {
    LongStream a(j$.util.p pVar);

    DoubleStream asDoubleStream();

    j$.util.a0 average();

    LongStream b();

    Stream boxed();

    LongStream c();

    Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    long count();

    LongStream d();

    LongStream distinct();

    LongStream e();

    j$.util.c0 findAny();

    j$.util.c0 findFirst();

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    DoubleStream h();

    @Override // j$.util.stream.BaseStream
    j$.util.o0 iterator();

    boolean l();

    LongStream limit(long j);

    Stream mapToObj(LongFunction longFunction);

    j$.util.c0 max();

    j$.util.c0 min();

    boolean o();

    @Override // j$.util.stream.BaseStream
    LongStream parallel();

    LongStream peek(LongConsumer longConsumer);

    long reduce(long j, LongBinaryOperator longBinaryOperator);

    j$.util.c0 reduce(LongBinaryOperator longBinaryOperator);

    boolean s();

    @Override // j$.util.stream.BaseStream
    LongStream sequential();

    LongStream skip(long j);

    LongStream sorted();

    @Override // j$.util.stream.BaseStream
    j$.util.z0 spliterator();

    long sum();

    j$.util.z summaryStatistics();

    long[] toArray();

    IntStream u();
}
