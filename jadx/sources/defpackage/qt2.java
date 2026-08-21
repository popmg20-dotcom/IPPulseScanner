package defpackage;

import j$.util.List;
import j$.util.Map;
import j$.util.Optional;
import j$.util.function.BiFunction$CC;
import j$.util.function.Function$CC;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qt2 {
    public static final WeakHashMap a = new WeakHashMap();

    public static Object a(Object obj, final IdentityHashMap identityHashMap) {
        Object obj2 = identityHashMap.get(obj);
        if (obj2 != null) {
            return obj2;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            List list2 = (List) b(list, new ik(1, list));
            identityHashMap.put(list, list2);
            List.EL.replaceAll(list2, new UnaryOperator() { // from class: ot2
                public /* synthetic */ Function andThen(Function function) {
                    return Function$CC.$default$andThen(this, function);
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj3) {
                    if (obj3 == null) {
                        return null;
                    }
                    return qt2.a(obj3, identityHashMap);
                }

                public /* synthetic */ Function compose(Function function) {
                    return Function$CC.$default$compose(this, function);
                }
            });
            return list2;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            Set set2 = (Set) b(set, new v6(2));
            identityHashMap.put(set, set2);
            set2.clear();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                set2.add(next == null ? null : a(next, identityHashMap));
            }
            return set2;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Map map2 = (Map) b(map, new ik(2, map));
            identityHashMap.put(map, map2);
            Map.EL.replaceAll(map2, new BiFunction() { // from class: pt2
                public /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction$CC.$default$andThen(this, function);
                }

                @Override // java.util.function.BiFunction
                public final Object apply(Object obj3, Object obj4) {
                    if (obj4 == null) {
                        return null;
                    }
                    return qt2.a(obj4, identityHashMap);
                }
            });
            return map2;
        }
        if (!obj.getClass().isArray()) {
            identityHashMap.put(obj, b(obj, new ik(3, obj)));
            return obj;
        }
        int length = Array.getLength(obj);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), length);
        identityHashMap.put(obj, objNewInstance);
        for (int i = 0; i < length; i++) {
            Object obj3 = Array.get(obj, i);
            Array.set(objNewInstance, i, obj3 == null ? null : a(obj3, identityHashMap));
        }
        return objNewInstance;
    }

    public static Object b(Object obj, Supplier supplier) {
        if (obj instanceof Cloneable) {
            try {
                Optional optional = (Optional) Map.EL.computeIfAbsent(a, obj.getClass(), new hl(9));
                if (optional.isPresent()) {
                    return ((Method) optional.get()).invoke(obj, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return supplier.get();
    }
}
