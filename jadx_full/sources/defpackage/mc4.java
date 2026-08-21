package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mc4 implements sc4 {
    public tc4 a = new tc4();
    public float b = 0.0f;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ int d;
    public final /* synthetic */ hw4 e;
    public final /* synthetic */ uc4 f;

    public mc4(uc4 uc4Var, ArrayList arrayList, int i, hw4 hw4Var) {
        this.f = uc4Var;
        this.c = arrayList;
        this.d = i;
        this.e = hw4Var;
    }

    @Override // defpackage.sc4
    public final boolean a(ArrayList arrayList, boolean z, hm2 hm2Var) {
        int i;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jm3 jm3Var = (jm3) it.next();
            jm3Var.getClass();
            float[] fArrA = hb4.a(jm3Var.b - jm3Var.a);
            int i2 = jm3Var.a;
            int i3 = jm3Var.b;
            boolean z2 = jm3Var.c;
            uc4 uc4Var = this.f;
            char[] cArr = uc4Var.d.b;
            float f = uc4Var.j.a * uc4Var.k.a;
            int i4 = i2;
            int i5 = i4;
            float fA = 0.0f;
            while (i4 <= i3) {
                if (i4 == i3 || cArr[i4] == '\t') {
                    if (i4 > i5) {
                        int i6 = i4;
                        i = i6;
                        fA += uc4Var.k.a(cArr, i5, i6 - i5, i2, i3 - i2, z2, fArrA, i5 - i2);
                    } else {
                        i = i4;
                    }
                    if (i < i3) {
                        fA += f;
                        fArrA[i - i2] = f;
                    }
                    i5 = i + 1;
                } else {
                    i = i4;
                }
                i4 = i + 1;
            }
            float f2 = this.b;
            float f3 = f2 + fA;
            float f4 = this.d;
            if (f3 < f4) {
                tc4 tc4Var = this.a;
                boolean z3 = tc4Var.a;
                if (z3) {
                    int i7 = jm3Var.a;
                    int i8 = jm3Var.b;
                    tc4Var.a = false;
                    tc4Var.b = i7;
                    tc4Var.c = i8;
                } else {
                    int i9 = jm3Var.b;
                    if (z3) {
                        st4.g();
                        return false;
                    }
                    tc4Var.c = i9;
                }
                this.b = f2 + fA;
                hb4.b(fArrA);
            } else {
                int i10 = jm3Var.b - jm3Var.a;
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = (int) (f4 - this.b);
                    float f5 = 0.0f;
                    int i13 = i11;
                    while (i13 < i10) {
                        float f6 = fArrA[i13];
                        if (f6 != 0.0f) {
                            f5 += f6;
                            if (f5 > i12) {
                                break;
                            }
                        }
                        i13++;
                    }
                    if (i13 == i11) {
                        if (this.a.a) {
                            i13++;
                        } else {
                            b();
                        }
                    }
                    int i14 = jm3Var.a;
                    int iC = this.e.c(i14 + i11, i14 + i13) - jm3Var.a;
                    float f7 = 0.0f;
                    for (int i15 = i11; i15 < iC; i15++) {
                        f7 += fArrA[i15];
                    }
                    tc4 tc4Var2 = this.a;
                    boolean z4 = tc4Var2.a;
                    int i16 = jm3Var.a;
                    if (z4) {
                        tc4Var2.a = false;
                        tc4Var2.b = i11 + i16;
                        tc4Var2.c = i16 + iC;
                    } else {
                        int i17 = i16 + iC;
                        if (z4) {
                            st4.g();
                            return false;
                        }
                        tc4Var2.c = i17;
                    }
                    this.b += f7;
                    if (i13 != iC) {
                        b();
                    }
                    i11 = iC;
                }
                hb4.b(fArrA);
            }
        }
        return true;
    }

    public final void b() {
        tc4 tc4Var = this.a;
        tc4Var.d = this.b;
        this.c.add(tc4Var);
        this.b = 0.0f;
        this.a = new tc4();
    }
}
