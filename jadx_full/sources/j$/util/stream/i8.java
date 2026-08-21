package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class i8 extends y0 implements n8 {
    public final /* synthetic */ int l;
    public final /* synthetic */ IntPredicate m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i8(a1 a1Var, int i, IntPredicate intPredicate, int i2) {
        super(a1Var, i);
        this.l = i2;
        this.m = intPredicate;
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
        switch (this.l) {
            case 0:
                return w6.ORDERED.k(aVar.f) ? G(aVar, spliterator, new v0(28)).spliterator() : new s8((j$.util.w0) aVar.P(spliterator), this.m, 1);
            default:
                return w6.ORDERED.k(aVar.f) ? G(aVar, spliterator, new v0(29)).spliterator() : new s8((j$.util.w0) aVar.P(spliterator), this.m, 0);
        }
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        switch (this.l) {
            case 0:
                return new h8(this, j5Var);
            default:
                return new j8(this, j5Var, false);
        }
    }

    @Override // j$.util.stream.n8
    public o8 g(w1 w1Var, boolean z) {
        return new j8(this, w1Var, z);
    }
}
