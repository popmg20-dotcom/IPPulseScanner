package j$.util.stream;

import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class e1 extends h1 {
    public final /* synthetic */ int l;
    public final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(i1 i1Var, LongConsumer longConsumer) {
        super(i1Var, 0);
        this.l = 1;
        this.m = longConsumer;
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        switch (this.l) {
            case 0:
                return new d1(this, j5Var);
            case 1:
                return new b1(this, j5Var, 1);
            case 2:
                return new w4(this, j5Var);
            default:
                return new l(this, j5Var, 5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.l = i2;
        this.m = obj;
    }
}
