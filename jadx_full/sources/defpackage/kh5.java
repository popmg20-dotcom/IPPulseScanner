package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kh5 extends s15 {
    public final HashMap A;
    public final jf4 z;

    public kh5(jf4 jf4Var) {
        super("require");
        this.A = new HashMap();
        this.z = jf4Var;
    }

    @Override // defpackage.s15
    public final d25 j(ih4 ih4Var, List list) {
        d25 d25Var;
        je.k0("require", 1, list);
        String strH = ((e24) ih4Var.b).K(ih4Var, (d25) list.get(0)).h();
        HashMap map = this.A;
        if (map.containsKey(strH)) {
            return (d25) map.get(strH);
        }
        HashMap map2 = (HashMap) this.z.f;
        if (map2.containsKey(strH)) {
            try {
                d25Var = (d25) ((Callable) map2.get(strH)).call();
            } catch (Exception unused) {
                xe.q("Failed to create API implementation: ".concat(String.valueOf(strH)));
                return null;
            }
        } else {
            d25Var = d25.q0;
        }
        if (d25Var instanceof s15) {
            map.put(strH, (s15) d25Var);
        }
        return d25Var;
    }
}
