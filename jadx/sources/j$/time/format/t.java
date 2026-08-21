package j$.time.format;

import com.tencent.mars.xlog.Xlog;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer$CC;
import j$.util.function.BiFunction$CC;
import j$.util.function.Consumer$CC;
import j$.util.stream.c8;
import j$.util.stream.f7;
import j$.util.stream.m1;
import j$.util.stream.n1;
import j$.util.stream.q1;
import j$.util.stream.r1;
import j$.util.stream.s1;
import j$.util.stream.w6;
import j$.util.stream.x6;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements BiConsumer, BiFunction, Consumer, Supplier, c8 {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public t(Map map) {
        this.a = 0;
        this.b = map;
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            HashMap map3 = new HashMap();
            for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                String str = (String) entry2.getValue();
                String str2 = (String) entry2.getValue();
                Long l = (Long) entry2.getKey();
                s sVar = a.b;
                map3.put(str, new AbstractMap.SimpleImmutableEntry(str2, l));
            }
            ArrayList arrayList2 = new ArrayList(map3.values());
            Collections.sort(arrayList2, a.b);
            map2.put((y) entry.getKey(), arrayList2);
            arrayList.addAll(arrayList2);
            map2.put(null, arrayList);
        }
        Collections.sort(arrayList, a.b);
        this.c = map2;
    }

    @Override // j$.util.stream.c8
    public Object a(j$.util.stream.a aVar, Spliterator spliterator) {
        q1 q1Var = (q1) ((Supplier) this.c).get();
        aVar.N(spliterator, q1Var);
        return Boolean.valueOf(q1Var.b);
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public void n(Object obj) {
        int i = this.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case 4:
                ((Consumer) obj3).n(obj);
                ((Consumer) obj2).n(obj);
                break;
            case 5:
                AtomicBoolean atomicBoolean = (AtomicBoolean) obj3;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) obj2;
                if (obj != null) {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                } else {
                    atomicBoolean.set(true);
                }
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((BiConsumer) obj3).accept(obj2, obj);
                break;
            default:
                Consumer consumer = (Consumer) obj2;
                if (((f7) obj3).b.putIfAbsent(obj != null ? obj : f7.d, Boolean.TRUE) == null) {
                    consumer.n(obj);
                }
                break;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
            case 4:
                break;
            case 5:
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                break;
        }
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        return ((Function) this.c).apply(((BiFunction) this.b).apply(obj, obj2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.stream.c8
    public Object b(j$.util.stream.a aVar, Spliterator spliterator) {
        return (Boolean) new s1(this, aVar, spliterator).invoke();
    }

    @Override // j$.util.stream.c8
    public int f() {
        return w6.u | w6.r;
    }

    public String g(long j, y yVar) {
        Map map = (Map) ((Map) this.b).get(yVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j));
        }
        return null;
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.a) {
            case 6:
                return new n1((r1) this.b, (IntPredicate) this.c);
            default:
                return new m1((r1) this.b, (Predicate) this.c);
        }
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction$CC.$default$andThen(this, function);
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.a) {
        }
        return BiConsumer$CC.$default$andThen(this, biConsumer);
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        int i = this.a;
        Object obj3 = this.c;
        Object obj4 = this.b;
        switch (i) {
            case 1:
                ConcurrentMap concurrentMap = (ConcurrentMap) obj4;
                BiFunction biFunction = (BiFunction) obj3;
                while (!concurrentMap.replace(obj, obj2, biFunction.apply(obj, obj2)) && (obj2 = concurrentMap.get(obj)) != null) {
                }
                break;
            default:
                ((BiConsumer) obj4).accept(obj, obj2);
                ((BiConsumer) obj3).accept(obj, obj2);
                break;
        }
    }

    public t(x6 x6Var, r1 r1Var, Supplier supplier) {
        this.a = 8;
        this.b = r1Var;
        this.c = supplier;
    }

    public /* synthetic */ t(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }
}
