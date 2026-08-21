package j$.util.stream;

import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x2 implements e2 {
    @Override // j$.util.stream.e2
    public e2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.e2
    public final long count() {
        return 0L;
    }

    @Override // j$.util.stream.e2
    public /* synthetic */ e2 j(long j, long j2, IntFunction intFunction) {
        return t3.w(this, j, j2, intFunction);
    }

    @Override // j$.util.stream.e2
    public final Object[] m(IntFunction intFunction) {
        return (Object[]) intFunction.apply(0);
    }

    @Override // j$.util.stream.e2
    public final int o() {
        return 0;
    }

    public final void g(Object obj) {
    }

    public final void f(int i, Object obj) {
    }
}
