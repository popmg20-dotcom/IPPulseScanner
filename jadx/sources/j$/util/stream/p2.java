package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class p2 extends g2 {
    @Override // j$.util.stream.e2
    public final void forEach(Consumer consumer) {
        this.a.forEach(consumer);
        this.b.forEach(consumer);
    }

    @Override // j$.util.stream.e2
    public final e2 j(long j, long j2, IntFunction intFunction) {
        if (j == 0 && j2 == this.c) {
            return this;
        }
        long jCount = this.a.count();
        if (j >= jCount) {
            return this.b.j(j - jCount, j2 - jCount, intFunction);
        }
        e2 e2Var = this.a;
        if (j2 <= jCount) {
            return e2Var.j(j, j2, intFunction);
        }
        return t3.E(x6.REFERENCE, e2Var.j(j, jCount, intFunction), this.b.j(0L, j2 - jCount, intFunction));
    }

    @Override // j$.util.stream.e2
    public final void k(Object[] objArr, int i) {
        Objects.requireNonNull(objArr);
        e2 e2Var = this.a;
        e2Var.k(objArr, i);
        this.b.k(objArr, i + ((int) e2Var.count()));
    }

    @Override // j$.util.stream.e2
    public final Object[] m(IntFunction intFunction) {
        long j = this.c;
        if (j >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) j);
        k(objArr, 0);
        return objArr;
    }

    @Override // j$.util.stream.e2
    public final Spliterator spliterator() {
        return new g3(this);
    }

    public final String toString() {
        long j = this.c;
        return j < 32 ? String.format("ConcNode[%s.%s]", this.a, this.b) : String.format("ConcNode[size=%d]", Long.valueOf(j));
    }
}
