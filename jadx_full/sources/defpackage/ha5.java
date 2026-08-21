package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ha5 extends s15 {
    public final Object A;
    public final /* synthetic */ int z = 4;

    public ha5(rz4 rz4Var) {
        super("internal.logger");
        this.A = rz4Var;
        this.f.put("log", new ih5(this, false, true));
        this.f.put("silent", new uc5("silent", 1));
        ((s15) this.f.get("silent")).b("log", new ih5(this, true, true));
        this.f.put("unmonitored", new uc5("unmonitored", 2));
        ((s15) this.f.get("unmonitored")).b("log", new ih5(this, false, false));
    }

    @Override // defpackage.s15
    public final d25 j(ih4 ih4Var, List list) {
        TreeMap treeMap;
        int i = this.z;
        String str = this.b;
        j25 j25Var = d25.q0;
        Object obj = this.A;
        String str2 = null;
        switch (i) {
            case 0:
                je.k0(str, 3, list);
                String strH = ((e24) ih4Var.b).K(ih4Var, (d25) list.get(0)).h();
                d25 d25Var = (d25) list.get(1);
                e24 e24Var = (e24) ih4Var.b;
                long jS0 = (long) je.s0(e24Var.K(ih4Var, d25Var).g().doubleValue());
                d25 d25VarK = e24Var.K(ih4Var, (d25) list.get(2));
                HashMap mapU0 = d25VarK instanceof y15 ? je.u0((y15) d25VarK) : new HashMap();
                n02 n02Var = (n02) obj;
                n02Var.getClass();
                HashMap map = new HashMap();
                for (String str3 : mapU0.keySet()) {
                    HashMap map2 = ((y05) n02Var.f).c;
                    map.put(str3, y05.b(str3, map2.containsKey(str3) ? map2.get(str3) : null, mapU0.get(str3)));
                }
                ((ArrayList) n02Var.A).add(new y05(strH, jS0, map));
                return j25Var;
            case 1:
                je.k0("getValue", 2, list);
                d25 d25VarK2 = ((e24) ih4Var.b).K(ih4Var, (d25) list.get(0));
                d25 d25VarK3 = ((e24) ih4Var.b).K(ih4Var, (d25) list.get(1));
                String strH2 = d25VarK2.h();
                e24 e24Var2 = (e24) obj;
                Map map3 = (Map) ((x75) e24Var2.z).Z.get((String) e24Var2.f);
                if (map3 != null && map3.containsKey(strH2)) {
                    str2 = (String) map3.get(strH2);
                }
                return str2 != null ? new i25(str2) : d25VarK3;
            case 2:
                return j25Var;
            case 3:
                try {
                    return vo.Q(((s75) obj).call());
                } catch (Exception unused) {
                    return j25Var;
                }
            default:
                je.k0(str, 3, list);
                ((e24) ih4Var.b).K(ih4Var, (d25) list.get(0)).h();
                d25 d25Var2 = (d25) list.get(1);
                e24 e24Var3 = (e24) ih4Var.b;
                d25 d25VarK4 = e24Var3.K(ih4Var, d25Var2);
                if (d25VarK4 instanceof b25) {
                    d25 d25VarK5 = e24Var3.K(ih4Var, (d25) list.get(2));
                    if (d25VarK5 instanceof y15) {
                        y15 y15Var = (y15) d25VarK5;
                        HashMap map4 = y15Var.b;
                        if (map4.containsKey("type")) {
                            String strH3 = y15Var.a("type").h();
                            int iR0 = map4.containsKey("priority") ? je.r0(y15Var.a("priority").g().doubleValue()) : 1000;
                            ca5 ca5Var = (ca5) obj;
                            b25 b25Var = (b25) d25VarK4;
                            ca5Var.getClass();
                            if ("create".equals(strH3)) {
                                treeMap = (TreeMap) ca5Var.b;
                            } else if ("edit".equals(strH3)) {
                                treeMap = (TreeMap) ca5Var.a;
                            } else {
                                xe.q("Unknown callback type: ".concat(String.valueOf(strH3)));
                            }
                            if (treeMap.containsKey(Integer.valueOf(iR0))) {
                                iR0 = ((Integer) treeMap.lastKey()).intValue() + 1;
                            }
                            treeMap.put(Integer.valueOf(iR0), b25Var);
                            return j25Var;
                        }
                        xe.k("Undefined rule type");
                    } else {
                        xe.k("Invalid callback params");
                    }
                } else {
                    xe.k("Invalid callback type");
                }
                return null;
        }
    }

    public ha5(n02 n02Var) {
        super("internal.eventLogger");
        this.A = n02Var;
    }

    public ha5(s75 s75Var) {
        super("internal.appMetadata");
        this.A = s75Var;
    }

    public ha5(ca5 ca5Var) {
        super("internal.registerCallback");
        this.A = ca5Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha5(uc5 uc5Var, e24 e24Var) {
        super("getValue");
        this.A = e24Var;
    }
}
