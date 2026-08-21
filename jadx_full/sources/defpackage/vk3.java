package defpackage;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vk3 {
    public final String a;
    public final byte[] b;
    public xk3[] c;
    public final sj d;
    public Map e;

    public vk3(String str, byte[] bArr, xk3[] xk3VarArr, sj sjVar, int i) {
        this.a = str;
        this.b = bArr;
        this.c = xk3VarArr;
        this.d = sjVar;
        this.e = null;
    }

    public final void a(Map map) {
        if (map != null) {
            Map map2 = this.e;
            if (map2 == null) {
                this.e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public final void b(wk3 wk3Var, Object obj) {
        Map enumMap = this.e;
        if (enumMap == null) {
            enumMap = new EnumMap(wk3.class);
            this.e = enumMap;
        }
        enumMap.put(wk3Var, obj);
    }

    public final String toString() {
        return this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public vk3(String str, byte[] bArr, xk3[] xk3VarArr, sj sjVar) {
        this(str, bArr, xk3VarArr, sjVar, 0);
        System.currentTimeMillis();
    }
}
