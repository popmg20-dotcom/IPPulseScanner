package j$.util.stream;

import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends i0 implements i5 {
    public static final d0 c;
    public static final d0 d;

    static {
        x6 x6Var = x6.LONG_VALUE;
        o oVar = new o(16);
        o oVar2 = new o(17);
        j$.util.c0 c0Var = j$.util.c0.c;
        c = new d0(true, x6Var, c0Var, oVar, oVar2);
        d = new d0(false, x6Var, c0Var, new o(16), new o(17));
    }

    @Override // j$.util.stream.i0, j$.util.stream.j5
    public final void accept(long j) {
        n(Long.valueOf(j));
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.time.a.d(this, longConsumer);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.a) {
            return new j$.util.c0(((Long) this.b).longValue());
        }
        return null;
    }
}
