package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zl2 {
    public final SparseArray a;
    public kk4 b;

    public zl2(int i) {
        this.a = new SparseArray(i);
    }

    public final void a(kk4 kk4Var, int i, int i2) {
        int iA = kk4Var.a(i);
        SparseArray sparseArray = this.a;
        zl2 zl2Var = (zl2) sparseArray.get(iA);
        if (zl2Var == null) {
            zl2Var = new zl2(1);
            sparseArray.put(kk4Var.a(i), zl2Var);
        }
        if (i2 > i) {
            zl2Var.a(kk4Var, i + 1, i2);
        } else {
            zl2Var.b = kk4Var;
        }
    }
}
