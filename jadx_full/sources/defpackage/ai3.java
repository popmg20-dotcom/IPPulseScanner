package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ai3 {
    public final iv1 a;

    static {
        ve2.a(ai3.class.getName());
    }

    public ai3() {
        new HashMap();
        this.a = new iv1(bd4.a(null, null));
    }

    public final nv1 a(String str, Integer num, Map map) {
        String str2;
        int iIntValue = num == null ? 0 : num.intValue();
        iv1 iv1Var = this.a;
        HashMap map2 = (HashMap) iv1Var.f;
        if (map2.containsKey(str)) {
            str2 = str;
        } else {
            od3 od3VarS = iv1Var.s(str);
            if (od3VarS == null) {
                return null;
            }
            str2 = str;
            map2.put(str2, new xp1(str2, od3VarS, iIntValue, map, iv1Var, iv1Var));
        }
        return (nv1) map2.get(str2);
    }

    public final nv1 b(pv1 pv1Var, Integer num, HashMap map) {
        try {
            od3 od3VarA = pd3.a(pv1Var);
            iv1 iv1Var = this.a;
            od3VarA.c();
            ((HashMap) iv1Var.z).put(od3VarA.c(), od3VarA);
            return a(od3VarA.c(), num, map);
        } catch (Exception e) {
            throw new r94("Loading grammar from [" + ((ov1) pv1Var).b + "] failed: " + e.getMessage(), e);
        }
    }

    public final void c(bd4 bd4Var) {
        try {
            this.a.X = bd4Var;
        } catch (Exception e) {
            throw new r94("Loading theme from '" + bd4Var.toString() + "' failed: " + e.getMessage(), e);
        }
    }
}
