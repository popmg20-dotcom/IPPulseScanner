package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b00 {
    public static final b00 b;
    public static final b00 c;
    public final LinkedHashSet a;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new k92(0));
        b = new b00(linkedHashSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(new k92(1));
        c = new b00(linkedHashSet2);
    }

    public b00(LinkedHashSet linkedHashSet) {
        this.a = linkedHashSet;
    }

    public final ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList);
        for (k92 k92Var : this.a) {
            List<kz> listUnmodifiableList = DesugarCollections.unmodifiableList(arrayList2);
            k92Var.getClass();
            ArrayList arrayList3 = new ArrayList();
            for (kz kzVar : listUnmodifiableList) {
                r25.f(kzVar instanceof kz, "The camera info doesn't contain internal implementation.");
                if (kzVar.i() == k92Var.a) {
                    arrayList3.add(kzVar);
                }
            }
            arrayList2 = arrayList3;
        }
        arrayList2.retainAll(arrayList);
        return arrayList2;
    }

    public final Integer b() {
        Integer num = null;
        for (k92 k92Var : this.a) {
            if (k92Var instanceof k92) {
                Integer numValueOf = Integer.valueOf(k92Var.a);
                if (num == null) {
                    num = numValueOf;
                } else if (!num.equals(numValueOf)) {
                    xe.q("Multiple conflicting lens facing requirements exist.");
                    return null;
                }
            }
        }
        return num;
    }

    public final mz c(LinkedHashSet linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((mz) it.next()).b());
        }
        ArrayList arrayListA = a(arrayList);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            mz mzVar = (mz) it2.next();
            if (arrayListA.contains(mzVar.b())) {
                linkedHashSet2.add(mzVar);
            }
        }
        Iterator it3 = linkedHashSet2.iterator();
        if (it3.hasNext()) {
            return (mz) it3.next();
        }
        StringBuilder sb = new StringBuilder("Cams:");
        sb.append(linkedHashSet.size());
        Iterator it4 = linkedHashSet.iterator();
        while (it4.hasNext()) {
            kz kzVarR = ((mz) it4.next()).r();
            sb.append(" Id:" + kzVarR.d() + "  Lens:" + kzVarR.i());
        }
        String string = sb.toString();
        LinkedHashSet<k92> linkedHashSet3 = this.a;
        StringBuilder sb2 = new StringBuilder(dw2.A(linkedHashSet3.size(), "PhyId:null  Filters:"));
        for (k92 k92Var : linkedHashSet3) {
            sb2.append(" Id:");
            k92Var.getClass();
            sb2.append(k92.b);
            if (k92Var instanceof k92) {
                sb2.append(" LensFilter:");
                sb2.append(k92Var.a);
            }
        }
        xe.k(fw.u("No available camera can be found. ", string, " ", sb2.toString()));
        return null;
    }
}
