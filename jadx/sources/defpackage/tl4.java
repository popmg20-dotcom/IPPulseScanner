package defpackage;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tl4 extends um2 {
    public static final short[] C0 = {16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16908, 16905, 16904, 16904, 16904, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 17028, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 30896, 30896, 30896, 30896, 30896, 30896, 30896, 30896, 30896, 30896, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 31906, 31906, 31906, 31906, 31906, 31906, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 16800, 16800, 16800, 16800, 20896, 16800, 30946, 30946, 30946, 30946, 30946, 30946, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 16800, 16800, 16800, 16800, 16392, 8, 8, 8, 8, 8, 648, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 644, 416, 160, 160, 160, 160, 160, 160, 160, 160, 12514, 416, 160, 168, 160, 160, 160, 160, 4256, 4256, 160, 12514, 160, 416, 160, 4256, 12514, 416, 4256, 4256, 4256, 416, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 160, 13474, 13474, 13474, 13474, 13474, 13474, 13474, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 160, 12514, 12514, 12514, 12514, 12514, 12514, 12514, 12514};
    public final /* synthetic */ int B0 = 0;

    public tl4(String str, int i, int i2, int[] iArr, int[][] iArr2) {
        super(str, i, i2, iArr, iArr2, C0);
        this.A = true;
    }

    public static int[] N(int i) {
        ml4[] ml4VarArr = ml4.Dh;
        if (i < ml4VarArr.length) {
            return ml4VarArr[i].b();
        }
        throw new InternalError("undefined type (bug)");
    }

    public static Object[] P(int i, String str) {
        try {
            DataInputStream dataInputStreamQ = je.Q(str);
            int i2 = dataInputStreamQ.readInt();
            int[][] iArr = new int[i2][];
            sl4[] sl4VarArr = new sl4[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = new int[i];
                for (int i4 = 0; i4 < i; i4++) {
                    iArr[i3][i4] = dataInputStreamQ.readInt();
                }
                sl4VarArr[i3] = new sl4(dataInputStreamQ);
            }
            dataInputStreamQ.close();
            return new Object[]{iArr, sl4VarArr};
        } catch (IOException e) {
            vp1.p(e);
            return null;
        }
    }

    public abstract boolean O(int i);

    @Override // defpackage.k0
    public void a(int i, v92 v92Var) {
        switch (this.B0) {
            case 0:
                int[] iArr = {0};
                int i2 = 0;
                while (true) {
                    int[] iArr2 = pl4.a;
                    if (i2 >= iArr2.length) {
                        int i3 = 0;
                        while (true) {
                            int[] iArr3 = pl4.c;
                            if (i3 < iArr3.length) {
                                int i4 = iArr3[i3];
                                sl4 sl4Var = pl4.d[i3];
                                int i5 = 0;
                                while (true) {
                                    int[] iArr4 = sl4Var.a;
                                    if (i5 < iArr4.length) {
                                        iArr[0] = i4;
                                        k01.j(iArr4[i5], iArr, 1, v92Var);
                                        iArr[0] = iArr4[i5];
                                        k01.j(i4, iArr, 1, v92Var);
                                        for (int i6 = 0; i6 < i5; i6++) {
                                            iArr[0] = iArr4[i6];
                                            k01.j(iArr4[i5], iArr, 1, v92Var);
                                            iArr[0] = iArr4[i5];
                                            k01.j(iArr4[i6], iArr, 1, v92Var);
                                        }
                                        i5++;
                                    }
                                }
                                i3++;
                            } else if ((i & Pow2.MAX_POW2) != 0) {
                                int i7 = 0;
                                while (true) {
                                    int[][] iArr5 = ql4.a;
                                    if (i7 >= iArr5.length) {
                                        int i8 = 0;
                                        while (true) {
                                            int[][] iArr6 = ql4.c;
                                            if (i8 >= iArr6.length) {
                                                int i9 = 0;
                                                while (true) {
                                                    int[][] iArr7 = rl4.a;
                                                    if (i9 < iArr7.length) {
                                                        int[] iArr8 = iArr7[i9];
                                                        sl4 sl4Var2 = rl4.b[i9];
                                                        int i10 = 0;
                                                        while (true) {
                                                            int[] iArr9 = sl4Var2.a;
                                                            if (i10 < iArr9.length) {
                                                                k01.j(iArr9[i10], iArr8, 3, v92Var);
                                                                int i11 = 0;
                                                                while (true) {
                                                                    int[] iArr10 = sl4Var2.a;
                                                                    if (i11 < iArr10.length) {
                                                                        if (i11 != i10) {
                                                                            iArr[0] = iArr10[i11];
                                                                            k01.j(iArr10[i10], iArr, 1, v92Var);
                                                                        }
                                                                        i11++;
                                                                    }
                                                                }
                                                                i10++;
                                                            }
                                                        }
                                                        i9++;
                                                    }
                                                }
                                            } else {
                                                int[] iArr11 = iArr6[i8];
                                                sl4 sl4Var3 = ql4.d[i8];
                                                int i12 = 0;
                                                while (true) {
                                                    int[] iArr12 = sl4Var3.a;
                                                    if (i12 < iArr12.length) {
                                                        k01.j(iArr12[i12], iArr11, 2, v92Var);
                                                        int i13 = 0;
                                                        while (true) {
                                                            int[] iArr13 = sl4Var3.a;
                                                            if (i13 < iArr13.length) {
                                                                if (i13 != i12) {
                                                                    iArr[0] = iArr13[i13];
                                                                    k01.j(iArr13[i12], iArr, 1, v92Var);
                                                                }
                                                                i13++;
                                                            }
                                                        }
                                                        i12++;
                                                    }
                                                }
                                                i8++;
                                            }
                                        }
                                    } else {
                                        int[] iArr14 = iArr5[i7];
                                        sl4 sl4Var4 = ql4.b[i7];
                                        int i14 = 0;
                                        while (true) {
                                            int[] iArr15 = sl4Var4.a;
                                            if (i14 < iArr15.length) {
                                                k01.j(iArr15[i14], iArr14, 2, v92Var);
                                                int i15 = 0;
                                                while (true) {
                                                    int[] iArr16 = sl4Var4.a;
                                                    if (i15 < iArr16.length) {
                                                        if (i15 != i14) {
                                                            iArr[0] = iArr16[i15];
                                                            k01.j(iArr16[i14], iArr, 1, v92Var);
                                                        }
                                                        i15++;
                                                    }
                                                }
                                                i14++;
                                            }
                                        }
                                        i7++;
                                    }
                                }
                            }
                        }
                    } else {
                        int i16 = iArr2[i2];
                        sl4 sl4Var5 = pl4.b[i2];
                        int i17 = 0;
                        while (true) {
                            int[] iArr17 = sl4Var5.a;
                            if (i17 < iArr17.length) {
                                iArr[0] = i16;
                                k01.j(iArr17[i17], iArr, 1, v92Var);
                                iArr[0] = iArr17[i17];
                                k01.j(i16, iArr, 1, v92Var);
                                for (int i18 = 0; i18 < i17; i18++) {
                                    iArr[0] = iArr17[i18];
                                    k01.j(iArr17[i17], iArr, 1, v92Var);
                                    iArr[0] = iArr17[i17];
                                    k01.j(iArr17[i18], iArr, 1, v92Var);
                                }
                                i17++;
                            }
                        }
                        i2++;
                    }
                    break;
                }
                break;
            default:
                super.a(i, v92Var);
                break;
        }
    }

    @Override // defpackage.k0
    public g20[] e(int i, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        g20[] g20VarArr;
        int i7;
        int i8;
        int i9;
        switch (this.B0) {
            case 0:
                int iU = u(i2, i3, bArr);
                int iR = r(i2, i3, bArr);
                sl4 sl4Var = (sl4) ol4.a.get(iU);
                int i10 = 1;
                int i11 = 0;
                if (sl4Var != null) {
                    int[] iArr = sl4Var.a;
                    g20VarArr = new g20[13];
                    if (iArr.length == 1) {
                        g20VarArr[0] = g20.g(iR, iArr[0]);
                        int i12 = iArr[0];
                        sl4 sl4Var2 = (sl4) pl4.e.get(i12);
                        if (sl4Var2 != null) {
                            i7 = 1;
                            int i13 = 0;
                            while (true) {
                                int[] iArr2 = sl4Var2.a;
                                i6 = Pow2.MAX_POW2;
                                if (i13 < iArr2.length) {
                                    int i14 = iArr2[i13];
                                    if (i14 != iU) {
                                        g20VarArr[i7] = g20.g(iR, i14);
                                        i7++;
                                    }
                                    i13++;
                                }
                            }
                        } else {
                            i6 = Pow2.MAX_POW2;
                            i7 = 1;
                        }
                        i8 = i;
                        iU = i12;
                        i4 = 1;
                        i5 = 0;
                    } else {
                        i6 = Pow2.MAX_POW2;
                        if ((i & Pow2.MAX_POW2) != 0) {
                            char c = 2;
                            int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 3, 4);
                            int[] iArr4 = new int[3];
                            int i15 = 0;
                            while (i15 < iArr.length) {
                                int[] iArr5 = iArr3[i15];
                                int i16 = i11;
                                int i17 = iArr[i15];
                                iArr5[i16] = i17;
                                sl4 sl4Var3 = (sl4) pl4.e.get(i17);
                                if (sl4Var3 != null) {
                                    i9 = i10;
                                    int i18 = i16;
                                    while (true) {
                                        int[] iArr6 = sl4Var3.a;
                                        if (i18 < iArr6.length) {
                                            int i19 = i18 + 1;
                                            iArr3[i15][i19] = iArr6[i18];
                                            i18 = i19;
                                        } else {
                                            iArr4[i15] = iArr6.length + 1;
                                        }
                                    }
                                } else {
                                    i9 = i10;
                                    iArr4[i15] = i9;
                                }
                                i15++;
                                i11 = i16;
                                i10 = i9;
                            }
                            i4 = i10;
                            i5 = i11;
                            if (i15 == 2) {
                                int i20 = i5;
                                int i21 = i20;
                                while (i20 < iArr4[i5]) {
                                    for (int i22 = i5; i22 < iArr4[i4]; i22++) {
                                        g20VarArr[i21] = g20.h(iR, iArr3[i5][i20], iArr3[i4][i22]);
                                        i21++;
                                    }
                                    i20++;
                                }
                                sl4 sl4Var4 = (sl4) ql4.e.c(iArr);
                                if (sl4Var4 != null) {
                                    int i23 = i5;
                                    while (true) {
                                        int[] iArr7 = sl4Var4.a;
                                        if (i23 < iArr7.length) {
                                            int i24 = iArr7[i23];
                                            if (i24 != iU) {
                                                g20VarArr[i21] = g20.g(iR, i24);
                                                i21++;
                                            }
                                            i23++;
                                        }
                                    }
                                }
                                i7 = i21;
                            } else {
                                int i25 = i5;
                                int i26 = i25;
                                while (i25 < iArr4[i5]) {
                                    for (int i27 = i5; i27 < iArr4[i4]; i27++) {
                                        int i28 = i5;
                                        while (i28 < iArr4[c]) {
                                            char c2 = c;
                                            g20VarArr[i26] = new g20(new int[]{iArr3[i5][i25], iArr3[i4][i27], iArr3[c2][i28]}, iR);
                                            i26++;
                                            i28++;
                                            c = c2;
                                            i25 = i25;
                                        }
                                    }
                                    i25++;
                                }
                                sl4 sl4Var5 = (sl4) rl4.c.c(iArr);
                                if (sl4Var5 != null) {
                                    int i29 = i5;
                                    while (true) {
                                        int[] iArr8 = sl4Var5.a;
                                        if (i29 < iArr8.length) {
                                            int i30 = iArr8[i29];
                                            if (i30 != iU) {
                                                g20VarArr[i26] = g20.g(iR, i30);
                                                i26++;
                                            }
                                            i29++;
                                        }
                                    }
                                }
                                i7 = i26;
                            }
                            i8 = i5;
                        } else {
                            i4 = 1;
                            i5 = 0;
                            i8 = i;
                            i7 = i5;
                        }
                    }
                } else {
                    i4 = 1;
                    i5 = 0;
                    i6 = Pow2.MAX_POW2;
                    sl4 sl4Var6 = (sl4) pl4.e.get(iU);
                    if (sl4Var6 != null) {
                        g20VarArr = new g20[13];
                        int i31 = 0;
                        i7 = 0;
                        while (true) {
                            int[] iArr9 = sl4Var6.a;
                            if (i31 < iArr9.length) {
                                g20VarArr[i7] = g20.g(iR, iArr9[i31]);
                                i7++;
                                i31++;
                            } else {
                                i8 = i;
                            }
                        }
                    } else {
                        g20VarArr = null;
                        i8 = i;
                        i7 = i5;
                    }
                }
                if ((i8 & i6) != 0) {
                    if (g20VarArr == null) {
                        g20VarArr = new g20[13];
                    }
                    int i32 = i2 + iR;
                    if (i32 < i3) {
                        int iU2 = u(i32, i3, bArr);
                        sl4 sl4Var7 = (sl4) ol4.a.get(iU2);
                        if (sl4Var7 != null) {
                            int[] iArr10 = sl4Var7.a;
                            if (iArr10.length == i4) {
                                iU2 = iArr10[i5];
                            }
                        }
                        int iR2 = r(i32, i3, bArr);
                        int i33 = iR + iR2;
                        sl4 sl4Var8 = (sl4) ql4.e.c(iU, iU2);
                        if (sl4Var8 != null) {
                            int i34 = i5;
                            while (true) {
                                int[] iArr11 = sl4Var8.a;
                                if (i34 < iArr11.length) {
                                    g20VarArr[i7] = g20.g(i33, iArr11[i34]);
                                    i7++;
                                    i34++;
                                }
                            }
                        }
                        int i35 = i32 + iR2;
                        if (i35 < i3) {
                            int iU3 = u(i35, i3, bArr);
                            sl4 sl4Var9 = (sl4) ol4.a.get(iU3);
                            if (sl4Var9 != null) {
                                int[] iArr12 = sl4Var9.a;
                                if (iArr12.length == 1) {
                                    iU3 = iArr12[i5];
                                }
                            }
                            int iR3 = r(i35, i3, bArr) + i33;
                            sl4 sl4Var10 = (sl4) rl4.c.c(iU, iU2, iU3);
                            if (sl4Var10 != null) {
                                int i36 = i5;
                                while (true) {
                                    int[] iArr13 = sl4Var10.a;
                                    if (i36 < iArr13.length) {
                                        g20VarArr[i7] = g20.g(iR3, iArr13[i36]);
                                        i7++;
                                        i36++;
                                    }
                                }
                            }
                        }
                    }
                }
                if (g20VarArr == null || i7 == 0) {
                    return g20.A;
                }
                if (i7 >= g20VarArr.length) {
                    return g20VarArr;
                }
                g20[] g20VarArr2 = new g20[i7];
                int i37 = i5;
                System.arraycopy(g20VarArr, i37, g20VarArr2, i37, i7);
                return g20VarArr2;
            default:
                return super.e(i, bArr, i2, i3);
        }
    }

    @Override // defpackage.um2, defpackage.k0
    public boolean j(int i, int i2) {
        switch (this.B0) {
            case 0:
                if (i2 <= 14 && i < 256) {
                    return k(i, i2);
                }
                ml4[] ml4VarArr = ml4.Dh;
                if (i2 <= ml4VarArr.length) {
                    return r25.I(0, i, ml4VarArr[i2].b());
                }
                throw new InternalError("undefined type (bug)");
            default:
                return super.j(i, i2);
        }
    }

    @Override // defpackage.k0
    public int q(int i, int i2, int i3, byte[] bArr) {
        if (i2 <= i) {
            return i2;
        }
        int i4 = i2;
        while (!O(bArr[i4] & 255) && i4 > i) {
            i4--;
        }
        int iR = r(i4, i3, bArr) + i4;
        return iR > i2 ? i4 : iR + ((i2 - iR) & (-2));
    }

    @Override // defpackage.k0
    public int t(int i, byte[] bArr, ue2 ue2Var, int i2, byte[] bArr2) {
        switch (this.B0) {
            case 0:
                int i3 = ue2Var.b;
                int iU = u(i3, i2, bArr);
                int iR = r(i3, i2, bArr);
                ue2Var.b += iR;
                sl4 sl4Var = (sl4) ol4.a.get(iU);
                int i4 = 0;
                if (sl4Var == null) {
                    int i5 = 0;
                    while (i4 < iR) {
                        bArr2[i5] = bArr[i3];
                        i4++;
                        i5++;
                        i3++;
                    }
                    return iR;
                }
                int[] iArr = sl4Var.a;
                if (iArr.length == 1) {
                    return f(iArr[0], 0, bArr2);
                }
                int i6 = 0;
                int i7 = 0;
                while (i4 < iArr.length) {
                    int iF = f(iArr[i4], i6, bArr2);
                    i6 += iF;
                    i7 += iF;
                    i4++;
                }
                return i7;
            default:
                return super.t(i, bArr, ue2Var, i2, bArr2);
        }
    }

    @Override // defpackage.k0
    public int w(byte[] bArr, int i, int i2) {
        switch (this.B0) {
            case 0:
                byte[] bArr2 = new byte[46];
                int iR = i;
                int i3 = 0;
                while (iR < i2) {
                    int iU = u(iR, i2, bArr);
                    if (iU != 32 && iU != 45 && iU != 95) {
                        if (iU >= 128) {
                            du duVar = q41.f;
                            throw new w30(i, i2, bArr);
                        }
                        int i4 = i3 + 1;
                        bArr2[i3] = (byte) iU;
                        if (i4 >= 46) {
                            du duVar2 = q41.f;
                            throw new w30(i, i2, bArr);
                        }
                        i3 = i4;
                    }
                    iR += r(iR, i2, bArr);
                }
                Integer num = (Integer) nl4.a.b(0, i3, bArr2);
                if (num != null) {
                    return num.intValue();
                }
                du duVar3 = q41.f;
                throw new w30(i, i2, bArr);
            default:
                return super.w(bArr, i, i2);
        }
    }

    public /* synthetic */ tl4(String str, int i, int i2, int[] iArr, int[][] iArr2, short[] sArr) {
        super(str, i, i2, iArr, iArr2, sArr);
    }
}
