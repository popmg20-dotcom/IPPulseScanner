package j$.util.stream;

import java.util.function.LongBinaryOperator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class u3 extends t3 {
    public final /* synthetic */ LongBinaryOperator h;
    public final /* synthetic */ long i;

    public u3(x6 x6Var, LongBinaryOperator longBinaryOperator, long j) {
        this.h = longBinaryOperator;
        this.i = j;
    }

    @Override // j$.util.stream.t3
    public final o4 Y() {
        return new m4(this.i, this.h);
    }
}
