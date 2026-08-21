package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b25 extends s15 {
    public final ArrayList A;
    public final ih4 X;
    public final ArrayList z;

    public b25(String str, ArrayList arrayList, List list, ih4 ih4Var) {
        super(str);
        this.z = new ArrayList();
        this.X = ih4Var;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.z.add(((d25) it.next()).h());
            }
        }
        this.A = new ArrayList(list);
    }

    @Override // defpackage.s15, defpackage.d25
    public final d25 i() {
        return new b25(this);
    }

    @Override // defpackage.s15
    public final d25 j(ih4 ih4Var, List list) {
        j25 j25Var;
        ih4 ih4VarK = this.X.k();
        e24 e24Var = (e24) ih4VarK.b;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.z;
            int size = arrayList.size();
            j25Var = d25.q0;
            if (i >= size) {
                break;
            }
            if (i < list.size()) {
                ih4VarK.n((String) arrayList.get(i), ((e24) ih4Var.b).K(ih4Var, (d25) list.get(i)));
            } else {
                ih4VarK.n((String) arrayList.get(i), j25Var);
            }
            i++;
        }
        for (d25 d25Var : this.A) {
            d25 d25VarK = e24Var.K(ih4VarK, d25Var);
            if (d25VarK instanceof e25) {
                d25VarK = e24Var.K(ih4VarK, d25Var);
            }
            if (d25VarK instanceof n15) {
                return ((n15) d25VarK).b;
            }
        }
        return j25Var;
    }

    public b25(b25 b25Var) {
        super(b25Var.b);
        ArrayList arrayList = new ArrayList(b25Var.z.size());
        this.z = arrayList;
        arrayList.addAll(b25Var.z);
        ArrayList arrayList2 = new ArrayList(b25Var.A.size());
        this.A = arrayList2;
        arrayList2.addAll(b25Var.A);
        this.X = b25Var.X;
    }
}
