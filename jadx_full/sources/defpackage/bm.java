package defpackage;

import j$.util.function.Function$CC;
import j$.util.stream.Collectors;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class bm implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ bm(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        z1 z1Var;
        switch (this.a) {
            case 0:
                em emVar = (em) this.b;
                String str = (String) this.c;
                return new am(emVar.a(str), em.b(str));
            default:
                Class cls = (Class) this.b;
                Predicate predicate = (Predicate) this.c;
                nr3.h();
                LinkedHashMap linkedHashMap = nr3.d;
                synchronized (linkedHashMap) {
                    List list = (List) ga5.G(linkedHashMap.values()).filter(new ro2(1, predicate)).collect(Collectors.toList());
                    z1Var = (z1) (ga5.u(list) ? null : list.get(0));
                    break;
                }
                try {
                    return dw2.L(cls, z1Var, nr3.a());
                } catch (ReflectiveOperationException e) {
                    Throwable thA = n61.a(e);
                    if (thA instanceof RuntimeException) {
                        throw ((RuntimeException) thA);
                    }
                    if (thA instanceof Error) {
                        throw ((Error) thA);
                    }
                    throw new IllegalArgumentException(thA);
                }
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
