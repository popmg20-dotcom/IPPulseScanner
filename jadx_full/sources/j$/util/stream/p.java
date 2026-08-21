package j$.util.stream;

import j$.util.function.BiFunction$CC;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements BinaryOperator {
    public final /* synthetic */ int a;
    public final /* synthetic */ BiConsumer b;

    public /* synthetic */ p(BiConsumer biConsumer, int i) {
        this.a = i;
        this.b = biConsumer;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.a) {
        }
        return BiFunction$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i = this.a;
        BiConsumer biConsumer = this.b;
        switch (i) {
            case 0:
                biConsumer.accept(obj, obj2);
                break;
            case 1:
                biConsumer.accept(obj, obj2);
                break;
            default:
                biConsumer.accept(obj, obj2);
                break;
        }
        return obj;
    }
}
