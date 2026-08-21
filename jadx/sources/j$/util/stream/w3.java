package j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class w3 extends t3 {
    public final /* synthetic */ int h;
    public final /* synthetic */ Object i;

    public /* synthetic */ w3(x6 x6Var, Object obj, int i) {
        this.h = i;
        this.i = obj;
    }

    @Override // j$.util.stream.t3
    public final o4 Y() {
        switch (this.h) {
            case 0:
                return new n4((LongBinaryOperator) this.i);
            case 1:
                return new z3((DoubleBinaryOperator) this.i);
            case 2:
                return new e4((BinaryOperator) this.i);
            default:
                return new k4((IntBinaryOperator) this.i);
        }
    }
}
