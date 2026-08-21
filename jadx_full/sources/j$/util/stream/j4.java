package j$.util.stream;

import java.util.function.IntBinaryOperator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class j4 extends t3 {
    public final /* synthetic */ IntBinaryOperator h;
    public final /* synthetic */ int i;

    public j4(x6 x6Var, IntBinaryOperator intBinaryOperator, int i) {
        this.h = intBinaryOperator;
        this.i = i;
    }

    @Override // j$.util.stream.t3
    public final o4 Y() {
        return new i4(this.i, this.h);
    }
}
