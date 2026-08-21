package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class d6 extends g1 implements n8 {
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d6(a aVar, int i, int i2) {
        super(aVar, i);
        this.l = i2;
    }

    @Override // j$.util.stream.a
    public final e2 G(a aVar, Spliterator spliterator, IntFunction intFunction) {
        switch (this.l) {
            case 0:
                if (w6.SORTED.k(aVar.f)) {
                    return aVar.y(spliterator, false, intFunction);
                }
                long[] jArr = (long[]) ((c2) aVar.y(spliterator, true, intFunction)).b();
                Arrays.sort(jArr);
                return new i3(jArr);
            case 1:
                return (e2) new q8(this, aVar, spliterator, intFunction).invoke();
            default:
                return (e2) new p8(this, aVar, spliterator, intFunction).invoke();
        }
    }

    @Override // j$.util.stream.a
    public Spliterator H(a aVar, Spliterator spliterator) {
        int i = 0;
        int i2 = 1;
        switch (this.l) {
            case 1:
                return w6.ORDERED.k(aVar.f) ? G(aVar, spliterator, new k8(0)).spliterator() : new t8((j$.util.z0) aVar.P(spliterator), i2);
            case 2:
                return w6.ORDERED.k(aVar.f) ? G(aVar, spliterator, new k8(1)).spliterator() : new t8((j$.util.z0) aVar.P(spliterator), i);
            default:
                return super.H(aVar, spliterator);
        }
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        switch (this.l) {
            case 0:
                Objects.requireNonNull(j5Var);
                if (w6.SORTED.k(i)) {
                    return j5Var;
                }
                return w6.SIZED.k(i) ? new i6(j5Var) : new a6(j5Var);
            case 1:
                return new c1(this, j5Var, 5);
            default:
                return new l8(this, j5Var, false);
        }
    }

    @Override // j$.util.stream.n8
    public o8 g(w1 w1Var, boolean z) {
        return new l8(this, w1Var, z);
    }
}
