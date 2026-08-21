package j$.util.stream;

import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends a5 {
    public final /* synthetic */ int l;
    public final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(b5 b5Var, Consumer consumer) {
        super(b5Var, 0);
        this.l = 3;
        this.m = consumer;
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        switch (this.l) {
            case 0:
                return new n(this, j5Var, 0);
            case 1:
                return new s0(this, j5Var, 0);
            case 2:
                return new b1(this, j5Var, 0);
            case 3:
                return new l(this, j5Var, 1);
            case 4:
                return new l(this, j5Var, 2);
            case 5:
                return new l(this, j5Var, 3);
            default:
                return new k(this, j5Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.l = i2;
        this.m = obj;
    }
}
