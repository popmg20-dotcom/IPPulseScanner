package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mt4 {
    public static int f;
    public ArrayList a;
    public int b;
    public int c;
    public ArrayList d;
    public int e;

    public final void a(ArrayList arrayList) {
        int size = this.a.size();
        if (this.e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                mt4 mt4Var = (mt4) arrayList.get(i);
                if (this.e == mt4Var.b) {
                    c(this.c, mt4Var);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(gb2 gb2Var, int i) {
        int iN;
        int iN2;
        ArrayList arrayList = this.a;
        if (arrayList.size() == 0) {
            return 0;
        }
        kc0 kc0Var = ((jc0) arrayList.get(0)).S;
        gb2Var.t();
        kc0Var.b(gb2Var, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((jc0) arrayList.get(i2)).b(gb2Var, false);
        }
        if (i == 0 && kc0Var.y0 > 0) {
            n12.b(kc0Var, gb2Var, arrayList, 0);
        }
        if (i == 1 && kc0Var.z0 > 0) {
            n12.b(kc0Var, gb2Var, arrayList, 1);
        }
        try {
            gb2Var.p();
        } catch (Exception e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.d = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jc0 jc0Var = (jc0) arrayList.get(i3);
            d84 d84Var = new d84(4);
            new WeakReference(jc0Var);
            gb2.n(jc0Var.H);
            gb2.n(jc0Var.I);
            gb2.n(jc0Var.J);
            gb2.n(jc0Var.K);
            gb2.n(jc0Var.L);
            this.d.add(d84Var);
        }
        if (i == 0) {
            iN = gb2.n(kc0Var.H);
            iN2 = gb2.n(kc0Var.J);
            gb2Var.t();
        } else {
            iN = gb2.n(kc0Var.I);
            iN2 = gb2.n(kc0Var.K);
            gb2Var.t();
        }
        return iN2 - iN;
    }

    public final void c(int i, mt4 mt4Var) {
        int i2 = mt4Var.b;
        for (jc0 jc0Var : this.a) {
            ArrayList arrayList = mt4Var.a;
            if (!arrayList.contains(jc0Var)) {
                arrayList.add(jc0Var);
            }
            if (i == 0) {
                jc0Var.m0 = i2;
            } else {
                jc0Var.n0 = i2;
            }
        }
        this.e = i2;
    }

    public final String toString() {
        int i = this.c;
        StringBuilder sb = new StringBuilder(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String strW = fw.w("] <", sb, this.b);
        for (jc0 jc0Var : this.a) {
            StringBuilder sbQ = ha0.q(strW, " ");
            sbQ.append(jc0Var.g0);
            strW = sbQ.toString();
        }
        return strW.concat(" >");
    }
}
