package defpackage;

import io.sentry.g;
import j$.util.Map;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vw0 extends LinkedHashMap implements Map {
    public final /* synthetic */ int b;

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        int i = this.b;
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        int i = this.b;
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        int i = this.b;
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof uw0) {
                    return super.containsKey((uw0) obj);
                }
                return false;
            case 1:
                if (obj instanceof String) {
                    return super.containsKey((String) obj);
                }
                return false;
            default:
                if (obj instanceof g) {
                    return super.containsKey((g) obj);
                }
                return false;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof tw0) {
                    return super.containsValue((tw0) obj);
                }
                return false;
            case 1:
                if (obj instanceof Boolean) {
                    return super.containsValue((Boolean) obj);
                }
                return false;
            default:
                return false;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        int i = this.b;
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof uw0) {
                    return (tw0) super.get((uw0) obj);
                }
                return null;
            case 1:
                if (obj instanceof String) {
                    return (Boolean) super.get((String) obj);
                }
                return null;
            default:
                if ((obj instanceof g) && super.get((g) obj) != null) {
                    st4.n();
                }
                return null;
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        switch (this.b) {
            case 0:
                return !(obj instanceof uw0) ? obj2 : (tw0) Map.CC.$default$getOrDefault(this, (uw0) obj, (tw0) obj2);
            case 1:
                return !(obj instanceof String) ? obj2 : (Boolean) Map.CC.$default$getOrDefault(this, (String) obj, (Boolean) obj2);
            default:
                if (!(obj instanceof g)) {
                    return obj2;
                }
                g gVar = (g) obj;
                if (obj2 != null || Map.CC.$default$getOrDefault(this, gVar, null) != null) {
                    st4.n();
                }
                return null;
        }
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i = this.b;
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        int i = this.b;
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof uw0) {
                    return (tw0) super.remove((uw0) obj);
                }
                return null;
            case 1:
                if (obj instanceof String) {
                    return (Boolean) super.remove((String) obj);
                }
                return null;
            default:
                if ((obj instanceof g) && super.remove((g) obj) != null) {
                    st4.n();
                }
                return null;
        }
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        switch (this.b) {
            case 0:
                if (super.size() > 1000) {
                }
                break;
            case 1:
                if (super.size() > 512) {
                }
                break;
            default:
                if (super.size() > 32) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        int i = this.b;
        return Map.CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        int i = this.b;
        Map.CC.$default$replaceAll(this, biFunction);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vw0(int i, float f, boolean z, int i2) {
        super(i, f, z);
        this.b = i2;
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        int i = this.b;
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // java.util.HashMap, java.util.Map, j$.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        switch (this.b) {
            case 0:
                if ((obj instanceof uw0) && (obj2 instanceof tw0)) {
                    return Map.CC.$default$remove(this, (uw0) obj, (tw0) obj2);
                }
                return false;
            case 1:
                if ((obj instanceof String) && (obj2 instanceof Boolean)) {
                    return Map.CC.$default$remove(this, (String) obj, (Boolean) obj2);
                }
                return false;
            default:
                return false;
        }
    }
}
