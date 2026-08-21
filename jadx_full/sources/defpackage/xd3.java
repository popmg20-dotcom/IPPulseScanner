package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xd3 {
    public final wt2[] a;
    public final int b;

    public xd3(o82 o82Var) {
        i53 i53Var = (i53) o82Var.b;
        int size = i53Var.b.size();
        int i = 8;
        while (i < (size <= 64 ? size + size : size + (size >> 2))) {
            i += i;
        }
        this.b = i - 1;
        wt2[] wt2VarArr = new wt2[i];
        for (Map.Entry entry : (d53) i53Var.entrySet()) {
            uj4 uj4Var = (uj4) entry.getKey();
            b72 b72Var = (b72) entry.getValue();
            int i2 = uj4Var.a & this.b;
            wt2VarArr[i2] = new wt2(wt2VarArr[i2], uj4Var, b72Var);
        }
        this.a = wt2VarArr;
    }

    public final b72 a(nj4 nj4Var) {
        wt2 wt2Var = this.a[(nj4Var.hashCode() - 1) & this.b];
        if (wt2Var == null) {
            return null;
        }
        if (!wt2Var.c && nj4Var.equals((nj4) wt2Var.b)) {
            return (b72) wt2Var.a;
        }
        while (true) {
            wt2Var = (wt2) wt2Var.d;
            if (wt2Var == null) {
                return null;
            }
            if (!wt2Var.c && nj4Var.equals((nj4) wt2Var.b)) {
                return (b72) wt2Var.a;
            }
        }
    }

    public final b72 b(Class cls) {
        wt2 wt2Var = this.a[cls.getName().hashCode() & this.b];
        if (wt2Var == null) {
            return null;
        }
        if (((Class) wt2Var.e) == cls && !wt2Var.c) {
            return (b72) wt2Var.a;
        }
        while (true) {
            wt2Var = (wt2) wt2Var.d;
            if (wt2Var == null) {
                return null;
            }
            if (((Class) wt2Var.e) == cls && !wt2Var.c) {
                return (b72) wt2Var.a;
            }
        }
    }
}
