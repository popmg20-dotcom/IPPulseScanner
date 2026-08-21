package j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class s0 extends d5 {
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(a aVar, j5 j5Var, int i) {
        super(j5Var);
        this.b = i;
        this.c = aVar;
    }

    @Override // j$.util.stream.h5, java.util.function.IntConsumer
    public final void accept(int i) {
        int i2 = this.b;
        j5 j5Var = this.a;
        a aVar = this.c;
        switch (i2) {
            case 0:
                j5Var.accept(((IntFunction) ((q) aVar).m).apply(i));
                break;
            case 1:
                ((IntConsumer) ((t0) aVar).m).accept(i);
                j5Var.accept(i);
                break;
            default:
                if (((IntPredicate) ((t0) aVar).m).test(i)) {
                    j5Var.accept(i);
                }
                break;
        }
    }

    @Override // j$.util.stream.d5, j$.util.stream.j5
    public void c(long j) {
        switch (this.b) {
            case 2:
                this.a.c(-1L);
                break;
            default:
                super.c(j);
                break;
        }
    }
}
