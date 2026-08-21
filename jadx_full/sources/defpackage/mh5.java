package defpackage;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mh5 {
    public final String a;
    public final boolean b;
    public final t85 c;
    public final BitSet d;
    public final BitSet e;
    public final ie f;
    public final ie g;
    public final /* synthetic */ e15 h;

    public mh5(e15 e15Var, String str, t85 t85Var, BitSet bitSet, BitSet bitSet2, ie ieVar, ie ieVar2) {
        this.h = e15Var;
        this.a = str;
        this.d = bitSet;
        this.e = bitSet2;
        this.f = ieVar;
        this.g = new ie(0);
        for (Integer num : (fe) ieVar2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) ieVar2.get(num));
            this.g.put(num, arrayList);
        }
        this.b = false;
        this.c = t85Var;
    }

    public final void a(z05 z05Var) {
        int iO;
        switch (z05Var.g) {
            case 0:
                iO = ((f55) z05Var.i).o();
                break;
            default:
                iO = ((m55) z05Var.i).o();
                break;
        }
        boolean z = true;
        if (z05Var.c != null) {
            this.e.set(iO, true);
        }
        Boolean bool = z05Var.d;
        if (bool != null) {
            this.d.set(iO, bool.booleanValue());
        }
        if (z05Var.e != null) {
            Integer numValueOf = Integer.valueOf(iO);
            ie ieVar = this.f;
            Long l = (Long) ieVar.get(numValueOf);
            long jLongValue = z05Var.e.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                ieVar.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (z05Var.f != null) {
            Integer numValueOf2 = Integer.valueOf(iO);
            ie ieVar2 = this.g;
            List arrayList = (List) ieVar2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                ieVar2.put(numValueOf2, arrayList);
            }
            boolean zT = false;
            switch (z05Var.g) {
                case 0:
                    z = false;
                    break;
            }
            if (z) {
                arrayList.clear();
            }
            uf5.a();
            k85 k85Var = (k85) this.h.f;
            x15 x15Var = k85Var.A;
            q55 q55Var = r55.G0;
            String str = this.a;
            if (x15Var.f1(str, q55Var)) {
                switch (z05Var.g) {
                    case 0:
                        zT = ((f55) z05Var.i).t();
                        break;
                }
                if (zT) {
                    arrayList.clear();
                }
            }
            uf5.a();
            boolean zF1 = k85Var.A.f1(str, q55Var);
            Long l2 = z05Var.f;
            if (!zF1) {
                arrayList.add(Long.valueOf(l2.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(l2.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public final k75 b(int i) {
        List list;
        j75 j75VarU = k75.u();
        j75VarU.c();
        ((k75) j75VarU.f).v(i);
        j75VarU.c();
        ((k75) j75VarU.f).y(this.b);
        t85 t85Var = this.c;
        if (t85Var != null) {
            j75VarU.c();
            ((k75) j75VarU.f).x(t85Var);
        }
        s85 s85VarV = t85.v();
        ArrayList arrayListD1 = z65.D1(this.d);
        s85VarV.c();
        ((t85) s85VarV.f).z(arrayListD1);
        ArrayList arrayListD12 = z65.D1(this.e);
        s85VarV.c();
        ((t85) s85VarV.f).x(arrayListD12);
        ie ieVar = this.f;
        ArrayList arrayList = new ArrayList(ieVar.z);
        for (Integer num : (fe) ieVar.keySet()) {
            int iIntValue = num.intValue();
            Long l = (Long) ieVar.get(num);
            if (l != null) {
                t75 t75VarR = u75.r();
                t75VarR.c();
                ((u75) t75VarR.f).s(iIntValue);
                long jLongValue = l.longValue();
                t75VarR.c();
                ((u75) t75VarR.f).t(jLongValue);
                arrayList.add((u75) t75VarR.e());
            }
        }
        s85VarV.c();
        ((t85) s85VarV.f).B(arrayList);
        ie ieVar2 = this.g;
        if (ieVar2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList2 = new ArrayList(ieVar2.z);
            for (Integer num2 : (fe) ieVar2.keySet()) {
                v85 v85VarS = w85.s();
                int iIntValue2 = num2.intValue();
                v85VarS.c();
                ((w85) v85VarS.f).t(iIntValue2);
                List list2 = (List) ieVar2.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    v85VarS.c();
                    ((w85) v85VarS.f).u(list2);
                }
                arrayList2.add((w85) v85VarS.e());
            }
            list = arrayList2;
        }
        s85VarV.c();
        ((t85) s85VarV.f).D(list);
        j75VarU.c();
        ((k75) j75VarU.f).w((t85) s85VarV.e());
        return (k75) j75VarU.e();
    }

    public mh5(e15 e15Var, String str) {
        this.h = e15Var;
        this.a = str;
        this.b = true;
        this.d = new BitSet();
        this.e = new BitSet();
        this.f = new ie(0);
        this.g = new ie(0);
    }
}
