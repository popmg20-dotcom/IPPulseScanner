package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m34 extends vf2 implements Serializable {
    public static void I(w8 w8Var, uo2 uo2Var, yg2 yg2Var, cu2 cu2Var, HashMap map) {
        String strK;
        if (uo2Var.z == null && (strK = cu2Var.K(w8Var)) != null) {
            uo2Var = new uo2(uo2Var.b, strK);
        }
        uo2 uo2Var2 = new uo2(uo2Var.b, null);
        if (map.containsKey(uo2Var2)) {
            if (uo2Var.z == null || ((uo2) map.get(uo2Var2)).z != null) {
                return;
            }
            map.put(uo2Var2, uo2Var);
            return;
        }
        map.put(uo2Var2, uo2Var);
        List listJ = cu2Var.J(w8Var);
        if (listJ != null) {
            ArrayList<uo2> arrayList = (ArrayList) listJ;
            if (arrayList.isEmpty()) {
                return;
            }
            for (uo2 uo2Var3 : arrayList) {
                I(x8.H(yg2Var, uo2Var3.b, yg2Var), uo2Var3, yg2Var, cu2Var, map);
            }
        }
    }

    public final ArrayList J(yg2 yg2Var, c9 c9Var, nj4 nj4Var) {
        Class clsU;
        List listJ;
        cu2 cu2VarD = yg2Var.d();
        if (nj4Var != null) {
            clsU = nj4Var.L0;
        } else {
            if (c9Var == null) {
                xe.k("Both property and base type are nulls");
                return null;
            }
            clsU = c9Var.u();
        }
        HashMap map = new HashMap();
        if (c9Var != null && (listJ = cu2VarD.J(c9Var)) != null) {
            for (uo2 uo2Var : (ArrayList) listJ) {
                I(x8.H(yg2Var, uo2Var.b, yg2Var), uo2Var, yg2Var, cu2VarD, map);
            }
        }
        I(x8.H(yg2Var, clsU, yg2Var), new uo2(clsU, null), yg2Var, cu2VarD, map);
        return new ArrayList(map.values());
    }
}
