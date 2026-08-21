package j$.util.stream;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class b1 extends e5 {
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b1(a aVar, j5 j5Var, int i) {
        super(j5Var);
        this.b = i;
        this.c = aVar;
    }

    @Override // j$.util.stream.i5, j$.util.stream.j5
    public final void accept(long j) {
        int i = this.b;
        j5 j5Var = this.a;
        a aVar = this.c;
        switch (i) {
            case 0:
                j5Var.accept(((LongFunction) ((q) aVar).m).apply(j));
                break;
            default:
                ((LongConsumer) ((e1) aVar).m).accept(j);
                j5Var.accept(j);
                break;
        }
    }
}
