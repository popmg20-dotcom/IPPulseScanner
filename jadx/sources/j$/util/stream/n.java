package j$.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends c5 {
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(a aVar, j5 j5Var, int i) {
        super(j5Var);
        this.b = i;
        this.c = aVar;
    }

    @Override // j$.util.stream.g5, j$.util.stream.j5
    public final void accept(double d) {
        int i = this.b;
        j5 j5Var = this.a;
        a aVar = this.c;
        switch (i) {
            case 0:
                j5Var.accept(((DoubleFunction) ((q) aVar).m).apply(d));
                break;
            default:
                ((DoubleConsumer) ((w) aVar).m).accept(d);
                j5Var.accept(d);
                break;
        }
    }
}
