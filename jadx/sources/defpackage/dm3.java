package defpackage;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dm3 {
    public final List a;
    public final float b;
    public final float c;
    public final ub2 d;

    /* JADX WARN: Multi-variable type inference failed */
    public dm3(AbstractList abstractList, float f, float f2) {
        ArrayList arrayListL;
        ArrayList arrayListL2;
        char c;
        char c2;
        char c3;
        hg0 hg0Var;
        hg0 hg0Var2;
        List list;
        abstractList.getClass();
        this.a = abstractList;
        this.b = f;
        this.c = f2;
        ub2 ub2VarI = p95.i();
        char c4 = 3;
        char c5 = 2;
        char c6 = 1;
        if (abstractList.size() <= 0 || ((jc1) abstractList.get(0)).a.size() != 3) {
            arrayListL = null;
            arrayListL2 = null;
        } else {
            e03 e03VarD = ((hg0) ((jc1) abstractList.get(0)).a.get(1)).d(0.5f);
            hg0 hg0Var3 = (hg0) e03VarD.b;
            hg0 hg0Var4 = (hg0) e03VarD.f;
            arrayListL2 = e70.L(((jc1) abstractList.get(0)).a.get(0), hg0Var3);
            arrayListL = e70.L(hg0Var4, ((jc1) abstractList.get(0)).a.get(2));
        }
        int size = abstractList.size();
        if (size >= 0) {
            int i = 0;
            hg0Var = null;
            hg0Var2 = null;
            while (true) {
                if (i == 0 && arrayListL != null) {
                    list = arrayListL;
                } else if (i != this.a.size()) {
                    list = ((jc1) this.a.get(i)).a;
                } else {
                    if (arrayListL2 == null) {
                        c = c4;
                        c2 = c5;
                        c3 = c6;
                        break;
                    }
                    list = arrayListL2;
                }
                int size2 = list.size();
                c = c4;
                int i2 = 0;
                while (i2 < size2) {
                    char c7 = c5;
                    hg0 hg0Var5 = (hg0) list.get(i2);
                    char c8 = c6;
                    float[] fArr = hg0Var5.a;
                    if (((Math.abs(fArr[0] - hg0Var5.a()) >= 1.0E-4f || Math.abs(fArr[c8] - hg0Var5.b()) >= 1.0E-4f) ? (char) 0 : c8) == 0) {
                        if (hg0Var2 != null) {
                            ub2VarI.add(hg0Var2);
                        }
                        if (hg0Var == null) {
                            hg0Var = hg0Var5;
                            hg0Var2 = hg0Var;
                        } else {
                            hg0Var2 = hg0Var5;
                        }
                    } else if (hg0Var2 != null) {
                        float[] fArr2 = hg0Var2.a;
                        fArr2[6] = hg0Var5.a();
                        fArr2[7] = hg0Var5.b();
                    }
                    i2++;
                    c5 = c7;
                    c6 = c8;
                }
                c2 = c5;
                c3 = c6;
                if (i == size) {
                    break;
                }
                i++;
                c4 = c;
                c5 = c2;
                c6 = c3;
            }
        } else {
            c = 3;
            c2 = 2;
            c3 = 1;
            hg0Var = null;
            hg0Var2 = null;
        }
        if (hg0Var2 != null && hg0Var != null) {
            float[] fArr3 = hg0Var2.a;
            float f3 = fArr3[0];
            float f4 = fArr3[c3];
            float f5 = fArr3[c2];
            float f6 = fArr3[c];
            float f7 = fArr3[4];
            float f8 = fArr3[5];
            float[] fArr4 = hg0Var.a;
            ub2VarI.add(je.a(f3, f4, f5, f6, f7, f8, fArr4[0], fArr4[c3]));
        }
        ub2 ub2VarC = p95.c(ub2VarI);
        this.d = ub2VarC;
        Object obj = ub2VarC.get(ub2VarC.a() - 1);
        int iA = ub2VarC.a();
        int i3 = 0;
        while (i3 < iA) {
            hg0 hg0Var6 = (hg0) this.d.get(i3);
            hg0 hg0Var7 = (hg0) obj;
            if (Math.abs(hg0Var6.a[0] - hg0Var7.a()) > 1.0E-4f || Math.abs(hg0Var6.a[c3] - hg0Var7.b()) > 1.0E-4f) {
                xe.k("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
                throw null;
            }
            i3++;
            obj = hg0Var6;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dm3)) {
            return false;
        }
        return this.a.equals(((dm3) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "[RoundedPolygon. Cubics = " + d70.j0(this.d, null, null, null, null, 63) + " || Features = " + d70.j0(this.a, null, null, null, null, 63) + " || Center = (" + this.b + ", " + this.c + ")]";
    }
}
