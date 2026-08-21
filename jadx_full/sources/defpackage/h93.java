package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h93 {
    public final ArrayList a;
    public final w84 b;
    public int c;
    public boolean d;

    public h93(w84 w84Var, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.a = arrayList2;
        if (arrayList.size() > 0) {
            throw qe4.r(arrayList, 0);
        }
        if (arrayList.size() > 0) {
            throw qe4.r(arrayList, 0);
        }
        ArrayList arrayList3 = w84Var.b;
        if (!arrayList3.contains(this)) {
            arrayList3.add(this);
            int size = arrayList2.size() - 1;
            if (size >= 0) {
                throw qe4.r(arrayList2, size);
            }
            int size2 = arrayList2.size() - 1;
            if (size2 >= 0) {
                throw qe4.r(arrayList2, size2);
            }
        }
        this.b = w84Var;
    }
}
