package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class y15 implements d25, v15 {
    public final HashMap b = new HashMap();

    @Override // defpackage.v15
    public final d25 a(String str) {
        HashMap map = this.b;
        return map.containsKey(str) ? (d25) map.get(str) : d25.q0;
    }

    @Override // defpackage.v15
    public final void b(String str, d25 d25Var) {
        HashMap map = this.b;
        if (d25Var == null) {
            map.remove(str);
        } else {
            map.put(str, d25Var);
        }
    }

    @Override // defpackage.v15
    public final boolean c(String str) {
        return this.b.containsKey(str);
    }

    @Override // defpackage.d25
    public final Boolean d() {
        return Boolean.TRUE;
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return new t15(this.b.keySet().iterator());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y15) {
            return this.b.equals(((y15) obj).b);
        }
        return false;
    }

    @Override // defpackage.d25
    public d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        return "toString".equals(str) ? new i25(toString()) : qe4.v(this, new i25(str), ih4Var, arrayList);
    }

    @Override // defpackage.d25
    public final Double g() {
        return Double.valueOf(Double.NaN);
    }

    @Override // defpackage.d25
    public final String h() {
        return "[object Object]";
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // defpackage.d25
    public final d25 i() {
        y15 y15Var = new y15();
        for (Map.Entry entry : this.b.entrySet()) {
            boolean z = entry.getValue() instanceof v15;
            HashMap map = y15Var.b;
            if (z) {
                map.put((String) entry.getKey(), (d25) entry.getValue());
            } else {
                map.put((String) entry.getKey(), ((d25) entry.getValue()).i());
            }
        }
        return y15Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        HashMap map = this.b;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(String.format("%s: %s,", str, map.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
