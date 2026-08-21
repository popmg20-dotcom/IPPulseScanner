package j$.util.stream;

import java.util.function.DoublePredicate;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class m8 extends c5 implements o8 {
    public m8(b6 b6Var, j5 j5Var, boolean z) {
        super(j5Var);
    }

    @Override // j$.util.stream.g5, j$.util.stream.j5
    public final void accept(double d) {
        DoublePredicate doublePredicate = null;
        doublePredicate.test(d);
        throw null;
    }

    @Override // j$.util.stream.o8
    public final long h() {
        return 0L;
    }
}
