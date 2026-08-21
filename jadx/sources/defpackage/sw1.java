package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sw1 extends ov2 {
    public static final int[] b = {6, 8, 10, 12, 14};
    public static final int[] c = {1, 1, 1, 1};
    public static final int[][] d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final int[][] e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    public int a;

    public static int f(int[] iArr) throws qs2 {
        float f = 0.38f;
        int i = 0;
        int i2 = -1;
        while (i < 20) {
            float fC = ov2.c(iArr, e[i], i <= 9 ? 0.5f : 0.75f);
            if (fC < f) {
                i2 = i;
                f = fC;
            } else if (fC == f) {
                i2 = -1;
            }
            i++;
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw qs2.a();
    }

    public static int[] g(int i, bn bnVar, int[] iArr) throws qs2 {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i2 = bnVar.f;
        int i3 = i;
        boolean z = false;
        int i4 = 0;
        while (i < i2) {
            if (bnVar.d(i) != z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (ov2.c(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i3, i};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i++;
        }
        throw qs2.a();
    }

    @Override // defpackage.ov2
    public final vk3 b(int i, bn bnVar, Map map) throws qs2, qi1 {
        int[] iArrG;
        boolean z;
        int i2 = bnVar.f;
        int iE = bnVar.e(0);
        if (iE == i2) {
            throw qs2.a();
        }
        int[] iArrG2 = g(iE, bnVar, c);
        int i3 = iArrG2[1];
        int i4 = iArrG2[0];
        this.a = (i3 - i4) / 4;
        h(bnVar, i4);
        int[][] iArr = d;
        bnVar.i();
        try {
            int i5 = bnVar.f;
            int iE2 = bnVar.e(0);
            if (iE2 == i5) {
                throw qs2.a();
            }
            try {
                iArrG = g(iE2, bnVar, iArr[0]);
            } catch (qs2 unused) {
                iArrG = g(iE2, bnVar, iArr[1]);
            }
            h(bnVar, iArrG[0]);
            int i6 = iArrG[0];
            int i7 = bnVar.f;
            iArrG[0] = i7 - iArrG[1];
            iArrG[1] = i7 - i6;
            bnVar.i();
            StringBuilder sb = new StringBuilder(20);
            int i8 = iArrG2[1];
            int i9 = iArrG[0];
            int[] iArr2 = new int[10];
            int[] iArr3 = new int[5];
            int[] iArr4 = new int[5];
            while (i8 < i9) {
                ov2.d(i8, bnVar, iArr2);
                for (int i10 = 0; i10 < 5; i10++) {
                    int i11 = i10 * 2;
                    iArr3[i10] = iArr2[i11];
                    iArr4[i10] = iArr2[i11 + 1];
                }
                sb.append((char) (f(iArr3) + 48));
                sb.append((char) (f(iArr4) + 48));
                for (int i12 = 0; i12 < 10; i12++) {
                    i8 += iArr2[i12];
                }
            }
            String string = sb.toString();
            int[] iArr5 = map != null ? (int[]) map.get(fk0.f) : null;
            if (iArr5 == null) {
                iArr5 = b;
            }
            int length = string.length();
            int length2 = iArr5.length;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (i13 >= length2) {
                    z = false;
                    break;
                }
                int i15 = iArr5[i13];
                if (length == i15) {
                    z = true;
                    break;
                }
                if (i15 > i14) {
                    i14 = i15;
                }
                i13++;
            }
            if (!z && length > i14) {
                z = true;
            }
            if (!z) {
                throw qi1.a();
            }
            float f = i;
            vk3 vk3Var = new vk3(string, null, new xk3[]{new xk3(iArrG2[1], f), new xk3(iArrG[0], f)}, sj.z0);
            vk3Var.b(wk3.D0, "]I0");
            return vk3Var;
        } catch (Throwable th) {
            bnVar.i();
            throw th;
        }
    }

    public final void h(bn bnVar, int i) throws qs2 {
        int iMin = Math.min(this.a * 10, i);
        for (int i2 = i - 1; iMin > 0 && i2 >= 0 && !bnVar.d(i2); i2--) {
            iMin--;
        }
        if (iMin != 0) {
            throw qs2.a();
        }
    }
}
