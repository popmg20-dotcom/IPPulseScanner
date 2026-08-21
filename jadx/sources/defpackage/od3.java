package defpackage;

import io.netty.util.internal.StringUtil;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class od3 extends d93 {
    /* JADX WARN: Multi-variable type inference failed */
    public final rd3 b() {
        rd3 rd3Var = (rd3) get("repository");
        if (rd3Var != null) {
            return rd3Var;
        }
        rd3 rd3Var2 = new rd3();
        super.put("repository", rd3Var2);
        return rd3Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String c() {
        V v = get("scopeName");
        if (v != 0) {
            return (String) v;
        }
        e04.h(fw.x(new StringBuilder("Key 'scopeName' does not exit for grammar '"), (String) get("name"), StringUtil.DOUBLE_QUOTE));
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        String str = (String) obj;
        "fileTypes".equals(str);
        return super.put(str, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        if (map != null) {
            map.containsKey("fileTypes");
        }
        super.putAll(map);
    }
}
