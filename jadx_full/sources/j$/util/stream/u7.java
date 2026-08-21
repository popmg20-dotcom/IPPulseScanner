package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class u7 extends v7 implements j$.util.z0, LongConsumer {
    public long e;

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.e = j;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.time.a.d(this, longConsumer);
    }

    @Override // j$.util.stream.y7
    public final Spliterator b(Spliterator spliterator) {
        return new u7((j$.util.z0) spliterator, this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.time.a.j(this, consumer);
    }

    @Override // j$.util.stream.v7
    public final void g(Object obj) {
        ((LongConsumer) obj).accept(this.e);
    }

    @Override // j$.util.stream.v7
    public final c7 j() {
        return new b7();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.time.a.z(this, consumer);
    }
}
