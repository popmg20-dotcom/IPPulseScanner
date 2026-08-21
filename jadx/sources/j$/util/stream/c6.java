package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class c6 extends y0 {
    @Override // j$.util.stream.a
    public final e2 G(a aVar, Spliterator spliterator, IntFunction intFunction) {
        if (w6.SORTED.k(aVar.f)) {
            return aVar.y(spliterator, false, intFunction);
        }
        int[] iArr = (int[]) ((a2) aVar.y(spliterator, true, intFunction)).b();
        Arrays.sort(iArr);
        return new z2(iArr);
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        Objects.requireNonNull(j5Var);
        return w6.SORTED.k(i) ? j5Var : w6.SIZED.k(i) ? new h6(j5Var) : new z5(j5Var);
    }
}
