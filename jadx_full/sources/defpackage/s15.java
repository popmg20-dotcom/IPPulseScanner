package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class s15 implements d25, v15 {
    public final String b;
    public final HashMap f = new HashMap();

    public s15(String str) {
        this.b = str;
    }

    @Override // defpackage.v15
    public final d25 a(String str) {
        HashMap map = this.f;
        return map.containsKey(str) ? (d25) map.get(str) : d25.q0;
    }

    @Override // defpackage.v15
    public final void b(String str, d25 d25Var) {
        HashMap map = this.f;
        if (d25Var == null) {
            map.remove(str);
        } else {
            map.put(str, d25Var);
        }
    }

    @Override // defpackage.v15
    public final boolean c(String str) {
        return this.f.containsKey(str);
    }

    @Override // defpackage.d25
    public final Boolean d() {
        return Boolean.TRUE;
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return new t15(this.f.keySet().iterator());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s15)) {
            return false;
        }
        s15 s15Var = (s15) obj;
        String str = this.b;
        if (str != null) {
            return str.equals(s15Var.b);
        }
        return false;
    }

    @Override // defpackage.d25
    public final d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        return "toString".equals(str) ? new i25(this.b) : qe4.v(this, new i25(str), ih4Var, arrayList);
    }

    @Override // defpackage.d25
    public final Double g() {
        return Double.valueOf(Double.NaN);
    }

    @Override // defpackage.d25
    public final String h() {
        return this.b;
    }

    public final int hashCode() {
        String str = this.b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public abstract d25 j(ih4 ih4Var, List list);

    @Override // defpackage.d25
    public d25 i() {
        return this;
    }
}
