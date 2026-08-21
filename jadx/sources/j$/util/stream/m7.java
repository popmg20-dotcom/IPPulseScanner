package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class m7 extends p7 implements j$.util.t0 {
    @Override // j$.util.stream.r7
    public final Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
        return new m7((j$.util.t0) spliterator, j, j2, j3, j4);
    }

    @Override // j$.util.stream.p7
    public final Object b() {
        return new x1(1);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.time.a.h(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.time.a.x(this, consumer);
    }
}
