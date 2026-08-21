package defpackage;

import j$.util.function.Function$CC;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class bd2 implements UnaryOperator {
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        uz3 uz3Var = (uz3) obj;
        if (uz3Var.b == 1) {
            return uz3Var;
        }
        throw new e31(uz3Var.toString());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
