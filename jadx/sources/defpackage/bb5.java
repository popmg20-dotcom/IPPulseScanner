package defpackage;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bb5 extends y15 {
    public final n02 f;

    public bb5(n02 n02Var) {
        this.f = n02Var;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // defpackage.y15, defpackage.d25
    public final d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        int iHashCode = str.hashCode();
        n02 n02Var = this.f;
        switch (iHashCode) {
            case 21624207:
                if (str.equals("getEventName")) {
                    je.k0("getEventName", 0, arrayList);
                    return new i25(((y05) n02Var.z).a);
                }
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    je.k0("getTimestamp", 0, arrayList);
                    return new p15(Double.valueOf(((y05) n02Var.z).b));
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    je.k0("getParamValue", 1, arrayList);
                    String strH = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).h();
                    HashMap map = ((y05) n02Var.z).c;
                    return vo.Q(map.containsKey(strH) ? map.get(strH) : null);
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    je.k0("getParams", 0, arrayList);
                    HashMap map2 = ((y05) n02Var.z).c;
                    y15 y15Var = new y15();
                    for (String str2 : map2.keySet()) {
                        y15Var.b(str2, vo.Q(map2.get(str2)));
                    }
                    return y15Var;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    je.k0("setParamValue", 2, arrayList);
                    String strH2 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).h();
                    d25 d25VarK = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
                    y05 y05Var = (y05) n02Var.z;
                    Object objT0 = je.t0(d25VarK);
                    HashMap map3 = y05Var.c;
                    if (objT0 == null) {
                        map3.remove(strH2);
                        return d25VarK;
                    }
                    map3.put(strH2, y05.b(strH2, map3.get(strH2), objT0));
                    return d25VarK;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    je.k0("setEventName", 1, arrayList);
                    d25 d25VarK2 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                    if (d25.q0.equals(d25VarK2) || d25.r0.equals(d25VarK2)) {
                        xe.k("Illegal event name");
                        return null;
                    }
                    ((y05) n02Var.z).a = d25VarK2.h();
                    return new i25(d25VarK2.h());
                }
                break;
        }
        return super.f(str, ih4Var, arrayList);
    }
}
