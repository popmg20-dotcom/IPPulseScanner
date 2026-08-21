package defpackage;

import j$.util.Collection;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.stream.Collectors;
import java.util.AbstractMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class t84 implements Map {
    public static final v83 b;
    public static final t84 f;
    public static final u83 z;

    static {
        v83 w83Var;
        Properties properties = System.getProperties();
        NavigableSet navigableSet = x83.a;
        if ((properties == null ? 0 : properties.size()) <= 0) {
            w83Var = v83.O;
        } else {
            Set<String> setStringPropertyNames = properties.stringPropertyNames();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(ga5.E(setStringPropertyNames));
            for (String str : setStringPropertyNames) {
                String property = properties.getProperty(str);
                if (property != null) {
                    concurrentHashMap.put(str, property);
                }
            }
            w83Var = new w83(concurrentHashMap);
        }
        b = w83Var;
        f = new t84();
        z = new u83(1);
    }

    public static boolean a(String str) {
        return (str == null ? 0 : str.length()) > 23 && str.startsWith("org.apache.sshd.config") && str.charAt(22) == '.';
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("sysprops#clear() N/A");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        Properties properties = System.getProperties();
        for (String str : properties.stringPropertyNames()) {
            if (a(str) && Objects.equals(properties.getProperty(str), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        String property;
        Properties properties = System.getProperties();
        TreeSet treeSet = new TreeSet(tj4.c);
        for (String str : properties.stringPropertyNames()) {
            if (a(str) && (property = properties.getProperty(str)) != null) {
                String string = Objects.toString(str);
                if (a(string)) {
                    string = string.substring(23);
                }
                treeSet.add(new AbstractMap.SimpleImmutableEntry(string, property));
            }
        }
        return treeSet;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        String str = "org.apache.sshd.config." + obj;
        if (obj instanceof String) {
            return System.getProperty(str);
        }
        return null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ga5.u(keySet());
    }

    @Override // java.util.Map
    public final Set keySet() {
        int i = 17;
        return (Set) Collection.EL.stream(System.getProperties().stringPropertyNames()).filter(new sm(i)).map(new hl(i)).collect(Collectors.toSet());
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("sysprops#put(" + ((String) obj) + ")[" + obj2 + "] N/A");
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException("sysprops#putAll(" + map + ") N/A");
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("sysprops#remove(" + obj + ") N/A");
    }

    @Override // java.util.Map
    public final int size() {
        return ga5.E(keySet());
    }

    public final String toString() {
        return Objects.toString(entrySet(), null);
    }

    @Override // java.util.Map
    public final java.util.Collection values() {
        Properties properties = System.getProperties();
        return (java.util.Collection) Collection.EL.stream(properties.stringPropertyNames()).filter(new sm(17)).map(new um0(2, properties)).collect(Collectors.toList());
    }
}
