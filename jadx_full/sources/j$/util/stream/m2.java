package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class m2 extends o2 implements a2 {
    @Override // j$.util.stream.e2
    public final /* synthetic */ void forEach(Consumer consumer) {
        t3.r(this, consumer);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ e2 j(long j, long j2, IntFunction intFunction) {
        return t3.u(this, j, j2);
    }

    @Override // j$.util.stream.e2
    public final /* synthetic */ void k(Object[] objArr, int i) {
        t3.o(this, (Integer[]) objArr, i);
    }

    @Override // j$.util.stream.d2
    public final Object newArray(int i) {
        return new int[i];
    }

    @Override // j$.util.stream.e2
    public final j$.util.c1 spliterator() {
        return new d3(this);
    }

    @Override // j$.util.stream.e2
    public final Spliterator spliterator() {
        return new d3(this);
    }
}
