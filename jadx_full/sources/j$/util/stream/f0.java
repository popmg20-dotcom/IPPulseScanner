package j$.util.stream;

import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends i0 implements h5 {
    public static final d0 c;
    public static final d0 d;

    static {
        x6 x6Var = x6.INT_VALUE;
        o oVar = new o(14);
        o oVar2 = new o(15);
        j$.util.b0 b0Var = j$.util.b0.c;
        c = new d0(true, x6Var, b0Var, oVar, oVar2);
        d = new d0(false, x6Var, b0Var, new o(14), new o(15));
    }

    @Override // j$.util.stream.i0, j$.util.stream.j5, j$.util.stream.h5, java.util.function.IntConsumer
    public final void accept(int i) {
        n(Integer.valueOf(i));
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.time.a.c(this, intConsumer);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.a) {
            return new j$.util.b0(((Integer) this.b).intValue());
        }
        return null;
    }
}
