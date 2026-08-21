package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class e6 extends z4 {
    public final boolean l;
    public final Comparator m;

    public e6(b5 b5Var, Comparator comparator) {
        super(b5Var, w6.q | w6.p);
        this.l = false;
        this.m = (Comparator) Objects.requireNonNull(comparator);
    }

    @Override // j$.util.stream.a
    public final e2 G(a aVar, Spliterator spliterator, IntFunction intFunction) {
        if (w6.SORTED.k(aVar.f) && this.l) {
            return aVar.y(spliterator, false, intFunction);
        }
        Object[] objArrM = aVar.y(spliterator, true, intFunction).m(intFunction);
        Arrays.sort(objArrM, this.m);
        return new h2(objArrM);
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        Objects.requireNonNull(j5Var);
        if (w6.SORTED.k(i) && this.l) {
            return j5Var;
        }
        boolean zK = w6.SIZED.k(i);
        Comparator comparator = this.m;
        return zK ? new j6(j5Var, comparator) : new f6(j5Var, comparator);
    }

    public e6(b5 b5Var) {
        super(b5Var, w6.q | w6.o);
        this.l = true;
        this.m = j$.util.e.INSTANCE;
    }
}
