package j$.util.stream;

import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class s4 extends u4 implements i5 {
    @Override // j$.util.stream.u4, j$.util.stream.j5
    public final void accept(long j) {
        this.b++;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.time.a.d(this, longConsumer);
    }

    @Override // j$.util.stream.p4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.b);
    }

    @Override // j$.util.stream.o4
    public final void i(o4 o4Var) {
        this.b += ((u4) o4Var).b;
    }

    @Override // j$.util.stream.i5
    public final /* synthetic */ void l(Long l) {
        t3.i(this, l);
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final /* bridge */ /* synthetic */ void n(Object obj) {
        l((Long) obj);
    }
}
