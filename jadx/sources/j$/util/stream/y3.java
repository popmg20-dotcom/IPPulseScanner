package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class y3 extends t3 {
    public final /* synthetic */ int h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;

    public /* synthetic */ y3(x6 x6Var, Object obj, Object obj2, Object obj3, int i) {
        this.h = i;
        this.j = obj;
        this.k = obj2;
        this.i = obj3;
    }

    @Override // j$.util.stream.t3
    public final o4 Y() {
        int i = this.h;
        Object obj = this.j;
        Object obj2 = this.k;
        Object obj3 = this.i;
        switch (i) {
            case 0:
                return new v3((Supplier) obj3, (ObjLongConsumer) obj2, (p) obj);
            case 1:
                return new b4((Supplier) obj3, (ObjDoubleConsumer) obj2, (p) obj);
            case 2:
                return new d4(obj3, (BiFunction) obj2, (BinaryOperator) obj);
            case 3:
                return new h4((Supplier) obj3, (BiConsumer) obj2, (BiConsumer) obj);
            default:
                return new l4((Supplier) obj3, (ObjIntConsumer) obj2, (p) obj);
        }
    }
}
