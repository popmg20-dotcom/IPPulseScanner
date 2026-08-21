package j$.util.stream;

import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends i0 implements g5 {
    public static final d0 c;
    public static final d0 d;

    static {
        x6 x6Var = x6.DOUBLE_VALUE;
        o oVar = new o(12);
        o oVar2 = new o(13);
        j$.util.a0 a0Var = j$.util.a0.c;
        c = new d0(true, x6Var, a0Var, oVar, oVar2);
        d = new d0(false, x6Var, a0Var, new o(12), new o(13));
    }

    @Override // j$.util.stream.i0, j$.util.stream.j5
    public final void accept(double d2) {
        n(Double.valueOf(d2));
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.time.a.b(this, doubleConsumer);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.a) {
            return new j$.util.a0(((Double) this.b).doubleValue());
        }
        return null;
    }
}
