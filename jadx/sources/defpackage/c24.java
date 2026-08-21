package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class c24 implements rc0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ cm2 b;

    public /* synthetic */ c24(cm2 cm2Var, int i) {
        this.a = i;
        this.b = cm2Var;
    }

    @Override // defpackage.rc0
    public final void a(ds2 ds2Var, Object obj) {
        int i = this.a;
        cm2 cm2Var = this.b;
        switch (i) {
            case 0:
                if (!ds2Var.c) {
                    zo2.t(ds2Var, "Unexpected recursive mapping structure. Node: ");
                } else {
                    cm2Var.f((dh2) ds2Var, (Map) obj);
                }
                break;
            case 1:
                if (!ds2Var.c) {
                    zo2.t(ds2Var, "Unexpected recursive sequence structure. Node: ");
                } else {
                    List list = (List) obj;
                    Iterator it = ((us3) ds2Var).e.iterator();
                    while (it.hasNext()) {
                        list.add(cm2Var.h((ds2) it.next()));
                    }
                }
                break;
            default:
                if (!ds2Var.c) {
                    zo2.t(ds2Var, "Unexpected recursive set structure. Node: ");
                } else {
                    cm2Var.i((dh2) ds2Var, (Set) obj);
                }
                break;
        }
    }

    @Override // defpackage.rc0
    public final Object b(ds2 ds2Var) {
        int i = this.a;
        cm2 cm2Var = this.b;
        switch (i) {
            case 0:
                dh2 dh2Var = (dh2) ds2Var;
                boolean z = ds2Var.c;
                uf4 uf4Var = (uf4) cm2Var.Z;
                if (z) {
                    Object obj = uf4Var.d;
                    return new HashMap(dh2Var.e.size());
                }
                Object obj2 = uf4Var.d;
                HashMap map = new HashMap(dh2Var.e.size());
                cm2Var.f(dh2Var, map);
                return map;
            case 1:
                us3 us3Var = (us3) ds2Var;
                boolean z2 = ds2Var.c;
                uf4 uf4Var2 = (uf4) cm2Var.Z;
                if (z2) {
                    Object obj3 = uf4Var2.a;
                    return new ArrayList(us3Var.e.size());
                }
                Object obj4 = uf4Var2.a;
                ArrayList arrayList = new ArrayList(us3Var.e.size());
                Iterator it = us3Var.e.iterator();
                while (it.hasNext()) {
                    arrayList.add(cm2Var.h((ds2) it.next()));
                }
                return arrayList;
            default:
                boolean z3 = ds2Var.c;
                uf4 uf4Var3 = (uf4) cm2Var.Z;
                HashMap map2 = (HashMap) cm2Var.z;
                if (z3) {
                    if (map2.containsKey(ds2Var)) {
                        return map2.get(ds2Var);
                    }
                    Object obj5 = uf4Var3.c;
                    return new HashSet(((dh2) ds2Var).e.size());
                }
                dh2 dh2Var2 = (dh2) ds2Var;
                Object obj6 = uf4Var3.c;
                HashSet hashSet = new HashSet(dh2Var2.e.size());
                cm2Var.i(dh2Var2, hashSet);
                return hashSet;
        }
    }
}
