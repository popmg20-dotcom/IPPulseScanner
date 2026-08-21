package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s64 {
    public final ArrayList a;

    public s64(w64... w64VarArr) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        Collections.addAll(arrayList, w64VarArr);
    }

    public static void b(ArrayList arrayList, int i, int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            arrayList.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    iArr[i2] = i3;
                    b(arrayList, i, iArr, i2 + 1);
                    break;
                } else if (i3 == iArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    public final void a(w64 w64Var) {
        this.a.add(w64Var);
    }

    public final List c(List list) {
        d44 d44Var;
        d44 d44Var2;
        d44 d44Var3;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        int size = list.size();
        ArrayList arrayList = this.a;
        if (size != arrayList.size()) {
            return null;
        }
        int size2 = arrayList.size();
        ArrayList<int[]> arrayList2 = new ArrayList();
        b(arrayList2, size2, new int[size2], 0);
        w64[] w64VarArr = new w64[list.size()];
        for (int[] iArr : arrayList2) {
            boolean z = true;
            for (int i = 0; i < arrayList.size(); i++) {
                if (iArr[i] < list.size()) {
                    w64 w64Var = (w64) arrayList.get(i);
                    w64 w64Var2 = (w64) list.get(iArr[i]);
                    w64Var.getClass();
                    w64Var2.getClass();
                    z &= w64Var2.b.b <= w64Var.b.b && w64Var2.a == w64Var.a && ((d44Var = w64Var.c) == (d44Var2 = d44.DEFAULT) || (d44Var3 = w64Var2.c) == d44Var2 || d44Var3 == d44Var);
                    if (!z) {
                        break;
                    }
                    w64VarArr[iArr[i]] = (w64) arrayList.get(i);
                }
            }
            if (z) {
                return Arrays.asList(w64VarArr);
            }
        }
        return null;
    }

    public s64() {
        this.a = new ArrayList();
    }
}
