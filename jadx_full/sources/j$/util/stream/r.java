package j$.util.stream;

import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends c5 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(a aVar, j5 j5Var, int i) {
        super(j5Var);
        this.b = i;
    }

    @Override // j$.util.stream.g5, j$.util.stream.j5
    public final void accept(double d) {
        switch (this.b) {
            case 0:
                DoubleUnaryOperator doubleUnaryOperator = null;
                doubleUnaryOperator.applyAsDouble(d);
                throw null;
            case 1:
                DoubleToIntFunction doubleToIntFunction = null;
                doubleToIntFunction.applyAsInt(d);
                throw null;
            case 2:
                DoubleToLongFunction doubleToLongFunction = null;
                doubleToLongFunction.applyAsLong(d);
                throw null;
            case 3:
                DoublePredicate doublePredicate = null;
                doublePredicate.test(d);
                throw null;
            default:
                DoublePredicate doublePredicate2 = null;
                doublePredicate2.test(d);
                throw null;
        }
    }

    @Override // j$.util.stream.c5, j$.util.stream.j5
    public void c(long j) {
        switch (this.b) {
            case 3:
                this.a.c(-1L);
                break;
            case 4:
                this.a.c(-1L);
                break;
            default:
                super.c(j);
                break;
        }
    }

    @Override // j$.util.stream.c5, j$.util.stream.j5
    public boolean e() {
        switch (this.b) {
            case 4:
                return this.a.e();
            default:
                return super.e();
        }
    }
}
