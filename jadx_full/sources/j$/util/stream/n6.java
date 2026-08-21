package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class n6 extends r6 implements j$.util.w0 {
    public final /* synthetic */ o6 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n6(o6 o6Var, int i, int i2, int i3, int i4) {
        super(o6Var, i, i2, i3, i4);
        this.g = o6Var;
    }

    @Override // j$.util.stream.r6
    public final void a(int i, Object obj, Object obj2) {
        ((IntConsumer) obj2).accept(((int[]) obj)[i]);
    }

    @Override // j$.util.stream.r6
    public final j$.util.c1 b(Object obj, int i, int i2) {
        int[] iArr = (int[]) obj;
        int i3 = i2 + i;
        Spliterators.a(((int[]) Objects.requireNonNull(iArr)).length, i, i3);
        return new j$.util.o1(iArr, i, i3, 1040);
    }

    @Override // j$.util.stream.r6
    public final j$.util.c1 c(int i, int i2, int i3, int i4) {
        return new n6(this.g, i, i2, i3, i4);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.time.a.i(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.time.a.y(this, consumer);
    }
}
