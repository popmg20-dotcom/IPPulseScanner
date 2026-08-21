package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class l2 extends o2 implements y1 {
    @Override // j$.util.stream.e2
    public final /* synthetic */ void forEach(Consumer consumer) {
        t3.q(this, consumer);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ e2 j(long j, long j2, IntFunction intFunction) {
        return t3.t(this, j, j2);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ void k(Object[] objArr, int i) {
        t3.n(this, (Double[]) objArr, i);
    }

    @Override // j$.util.stream.d2
    public final Object newArray(int i) {
        return new double[i];
    }

    @Override // j$.util.stream.e2
    public final j$.util.c1 spliterator() {
        return new c3(this);
    }

    @Override // j$.util.stream.e2
    public final Spliterator spliterator() {
        return new c3(this);
    }
}
