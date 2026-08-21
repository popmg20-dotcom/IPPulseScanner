package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w64 {
    public static final d44 e = d44.DEFAULT;
    public static final t64[] f = {t64.S720P_16_9, t64.S1080P_4_3, t64.S1080P_16_9, t64.S1440P_16_9, t64.UHD, t64.X_VGA};
    public static final Map g;
    public static final LinkedHashMap h;
    public final v64 a;
    public final t64 b;
    public final d44 c;
    public final int d;

    static {
        Map mapV = fh2.V(new e03(v64.f, 35), new e03(v64.z, 256), new e03(v64.A, 4101), new e03(v64.X, 32), new e03(v64.b, 34));
        g = mapV;
        Set<Map.Entry> setEntrySet = mapV.entrySet();
        int iU = fh2.U(f70.Q(10, setEntrySet));
        if (iU < 16) {
            iU = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iU);
        for (Map.Entry entry : setEntrySet) {
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (v64) entry.getKey());
        }
        h = linkedHashMap;
    }

    public w64(v64 v64Var, t64 t64Var, d44 d44Var) {
        t64Var.getClass();
        d44Var.getClass();
        this.a = v64Var;
        this.b = t64Var;
        this.c = d44Var;
        Integer num = (Integer) g.get(v64Var);
        this.d = num != null ? num.intValue() : 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w64)) {
            return false;
        }
        w64 w64Var = (w64) obj;
        return this.a == w64Var.a && this.b == w64Var.b && this.c == w64Var.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SurfaceConfig(configType=" + this.a + ", configSize=" + this.b + ", streamUseCase=" + this.c + ')';
    }
}
