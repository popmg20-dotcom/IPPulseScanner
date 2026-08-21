package defpackage;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class cu0 {
    public static final String a = ue2.i("DiagnosticsWrkr");

    public static final String a(ax4 ax4Var, lx4 lx4Var, m94 m94Var, List list) {
        StringBuilder sb = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            gx4 gx4Var = (gx4) it.next();
            vw4 vw4VarM = l72.m(gx4Var);
            String str = gx4Var.a;
            m94Var.getClass();
            String str2 = vw4VarM.a;
            int i = vw4VarM.b;
            str2.getClass();
            k94 k94Var = (k94) ke0.r(m94Var.a, true, false, new l94(str2, i, 0));
            Integer numValueOf = k94Var != null ? Integer.valueOf(k94Var.c) : null;
            ax4Var.getClass();
            str.getClass();
            String strJ0 = d70.j0((List) ke0.r(ax4Var.a, true, false, new ko0(str, 12)), ",", null, null, null, 62);
            lx4Var.getClass();
            String strJ02 = d70.j0((List) ke0.r(lx4Var.a, true, false, new ko0(str, 24)), ",", null, null, null, 62);
            StringBuilder sbD = fw.D("\n", str, "\t ");
            sbD.append(gx4Var.c);
            sbD.append("\t ");
            sbD.append(numValueOf);
            sbD.append("\t ");
            sbD.append(gx4Var.b.name());
            sbD.append("\t ");
            sbD.append(strJ0);
            sbD.append("\t ");
            sbD.append(strJ02);
            sbD.append('\t');
            sb.append(sbD.toString());
        }
        return sb.toString();
    }
}
