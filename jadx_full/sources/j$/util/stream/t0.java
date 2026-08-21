package j$.util.stream;

import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class t0 extends z0 {
    public final /* synthetic */ int l;
    public final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(a1 a1Var, IntConsumer intConsumer) {
        super(a1Var, 0);
        this.l = 0;
        this.m = intConsumer;
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        switch (this.l) {
            case 0:
                return new s0(this, j5Var, 1);
            case 1:
                return new w0(this, j5Var);
            case 2:
                return new s0(this, j5Var, 2);
            case 3:
                return new l(this, j5Var, 4);
            default:
                return new w4(this, j5Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t0(a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.l = i2;
        this.m = obj;
    }
}
