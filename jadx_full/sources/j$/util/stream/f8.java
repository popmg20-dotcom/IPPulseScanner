package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class f8 extends z4 implements n8 {
    public final /* synthetic */ int l;
    public final /* synthetic */ Predicate m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f8(b5 b5Var, int i, Predicate predicate, int i2) {
        super(b5Var, i);
        this.l = i2;
        this.m = predicate;
    }

    @Override // j$.util.stream.a
    public final e2 G(a aVar, Spliterator spliterator, IntFunction intFunction) {
        switch (this.l) {
            case 0:
                return (e2) new q8(this, aVar, spliterator, intFunction).invoke();
            default:
                return (e2) new p8(this, aVar, spliterator, intFunction).invoke();
        }
    }

    @Override // j$.util.stream.a
    public final Spliterator H(a aVar, Spliterator spliterator) {
        int i = 14;
        switch (this.l) {
            case 0:
                return w6.ORDERED.k(aVar.f) ? G(aVar, spliterator, new v0(i)).spliterator() : new u8(aVar.P(spliterator), this.m, 1);
            default:
                return w6.ORDERED.k(aVar.f) ? G(aVar, spliterator, new v0(i)).spliterator() : new u8(aVar.P(spliterator), this.m, 0);
        }
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        switch (this.l) {
            case 0:
                return new k(this, j5Var);
            default:
                return new g8(this, j5Var, false);
        }
    }

    @Override // j$.util.stream.n8
    public o8 g(w1 w1Var, boolean z) {
        return new g8(this, w1Var, z);
    }
}
