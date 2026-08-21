package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e60 extends ov2 {
    public static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '$', ':', '/', '.', '+', 'A', 'B', 'C', 'D'};
    public static final int[] e = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    public static final char[] f = {'A', 'B', 'C', 'D'};
    public final StringBuilder a = new StringBuilder(20);
    public int[] b = new int[80];
    public int c = 0;

    public static boolean f(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ov2
    public final vk3 b(int i, bn bnVar, Map map) throws qs2 {
        int i2;
        int[] iArr;
        int i3 = 0;
        Arrays.fill(this.b, 0);
        this.c = 0;
        int iF = bnVar.f(0);
        int i4 = bnVar.f;
        if (iF >= i4) {
            throw qs2.a();
        }
        int i5 = 1;
        int i6 = 0;
        boolean z = true;
        while (iF < i4) {
            if (bnVar.d(iF) != z) {
                i6++;
            } else {
                int[] iArr2 = this.b;
                int i7 = this.c;
                iArr2[i7] = i6;
                int i8 = i7 + 1;
                this.c = i8;
                if (i8 >= iArr2.length) {
                    int[] iArr3 = new int[i8 * 2];
                    System.arraycopy(iArr2, 0, iArr3, 0, i8);
                    this.b = iArr3;
                }
                z = !z;
                i6 = 1;
            }
            iF++;
        }
        int[] iArr4 = this.b;
        int i9 = this.c;
        iArr4[i9] = i6;
        int i10 = i9 + 1;
        this.c = i10;
        if (i10 >= iArr4.length) {
            int[] iArr5 = new int[i10 * 2];
            System.arraycopy(iArr4, 0, iArr5, 0, i10);
            this.b = iArr5;
        }
        int i11 = 1;
        while (i11 < this.c) {
            int iG = g(i11);
            if (iG != -1) {
                char[] cArr = d;
                char c = cArr[iG];
                char[] cArr2 = f;
                if (f(cArr2, c)) {
                    int i12 = i3;
                    for (int i13 = i11; i13 < i11 + 7; i13++) {
                        i12 += this.b[i13];
                    }
                    if (i11 == i5 || this.b[i11 - 1] >= i12 / 2) {
                        StringBuilder sb = this.a;
                        sb.setLength(i3);
                        int i14 = i11;
                        while (true) {
                            int iG2 = g(i14);
                            if (iG2 == -1) {
                                throw qs2.a();
                            }
                            sb.append((char) iG2);
                            i2 = i14 + 8;
                            if ((sb.length() > i5 && f(cArr2, cArr[iG2])) || i2 >= this.c) {
                                break;
                            }
                            i14 = i2;
                            i5 = i5;
                        }
                        int i15 = i14 + 7;
                        int i16 = this.b[i15];
                        int i17 = i3;
                        for (int i18 = -8; i18 < -1; i18++) {
                            i17 += this.b[i2 + i18];
                        }
                        int i19 = 2;
                        if (i2 < this.c && i16 < i17 / 2) {
                            throw qs2.a();
                        }
                        int[] iArr6 = new int[4];
                        iArr6[i3] = i3;
                        iArr6[i5] = i3;
                        iArr6[2] = i3;
                        iArr6[3] = i3;
                        int[] iArr7 = new int[4];
                        iArr7[i3] = i3;
                        iArr7[i5] = i3;
                        iArr7[2] = i3;
                        iArr7[3] = i3;
                        int length = sb.length() - i5;
                        int i20 = i11;
                        int i21 = i3;
                        while (true) {
                            int i22 = 6;
                            iArr = e;
                            if (i21 > length) {
                                break;
                            }
                            int i23 = iArr[sb.charAt(i21)];
                            while (i22 >= 0) {
                                int i24 = ((i23 & 1) * 2) + (i22 & 1);
                                iArr6[i24] = iArr6[i24] + this.b[i20 + i22];
                                iArr7[i24] = iArr7[i24] + 1;
                                i23 >>= 1;
                                i22--;
                                i5 = i5;
                            }
                            i20 += 8;
                            i21++;
                        }
                        int i25 = i5;
                        float[] fArr = new float[4];
                        float[] fArr2 = new float[4];
                        int i26 = i3;
                        while (i26 < i19) {
                            fArr2[i26] = 0.0f;
                            int i27 = i26 + 2;
                            int i28 = i19;
                            float f2 = iArr6[i27];
                            float f3 = iArr7[i27];
                            float f4 = ((f2 / f3) + (iArr6[i26] / iArr7[i26])) / 2.0f;
                            fArr2[i27] = f4;
                            fArr[i26] = f4;
                            fArr[i27] = ((f2 * 2.0f) + 1.5f) / f3;
                            i26++;
                            i19 = i28;
                        }
                        int i29 = i19;
                        int i30 = i11;
                        for (int i31 = 0; i31 <= length; i31++) {
                            int i32 = iArr[sb.charAt(i31)];
                            for (int i33 = 6; i33 >= 0; i33--) {
                                int i34 = ((i32 & 1) * 2) + (i33 & 1);
                                float f5 = this.b[i30 + i33];
                                if (f5 < fArr2[i34] || f5 > fArr[i34]) {
                                    throw qs2.a();
                                }
                                i32 >>= 1;
                            }
                            i30 += 8;
                        }
                        for (int i35 = 0; i35 < sb.length(); i35++) {
                            sb.setCharAt(i35, cArr[sb.charAt(i35)]);
                        }
                        if (!f(cArr2, sb.charAt(0))) {
                            throw qs2.a();
                        }
                        if (!f(cArr2, sb.charAt(sb.length() - 1))) {
                            throw qs2.a();
                        }
                        if (sb.length() <= 3) {
                            throw qs2.a();
                        }
                        if (map == null || !map.containsKey(fk0.A)) {
                            sb.deleteCharAt(sb.length() - 1);
                            sb.deleteCharAt(0);
                        }
                        int i36 = 0;
                        for (int i37 = 0; i37 < i11; i37++) {
                            i36 += this.b[i37];
                        }
                        float f6 = i36;
                        while (i11 < i15) {
                            i36 += this.b[i11];
                            i11++;
                        }
                        float f7 = i36;
                        String string = sb.toString();
                        float f8 = i;
                        xk3 xk3Var = new xk3(f6, f8);
                        xk3 xk3Var2 = new xk3(f7, f8);
                        xk3[] xk3VarArr = new xk3[i29];
                        xk3VarArr[0] = xk3Var;
                        xk3VarArr[i25] = xk3Var2;
                        vk3 vk3Var = new vk3(string, null, xk3VarArr, sj.f);
                        vk3Var.b(wk3.D0, "]F0");
                        return vk3Var;
                    }
                }
            }
            i11 += 2;
            i3 = i3;
            i5 = i5;
        }
        throw qs2.a();
    }

    public final int g(int i) {
        int i2 = i + 7;
        if (i2 >= this.c) {
            return -1;
        }
        int[] iArr = this.b;
        int i3 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int i6 = i; i6 < i2; i6 += 2) {
            int i7 = iArr[i6];
            if (i7 < i4) {
                i4 = i7;
            }
            if (i7 > i5) {
                i5 = i7;
            }
        }
        int i8 = (i4 + i5) / 2;
        int i9 = 0;
        for (int i10 = i + 1; i10 < i2; i10 += 2) {
            int i11 = iArr[i10];
            if (i11 < i3) {
                i3 = i11;
            }
            if (i11 > i9) {
                i9 = i11;
            }
        }
        int i12 = (i3 + i9) / 2;
        int i13 = 128;
        int i14 = 0;
        for (int i15 = 0; i15 < 7; i15++) {
            i13 >>= 1;
            if (iArr[i + i15] > ((i15 & 1) == 0 ? i8 : i12)) {
                i14 |= i13;
            }
        }
        for (int i16 = 0; i16 < 20; i16++) {
            if (e[i16] == i14) {
                return i16;
            }
        }
        return -1;
    }
}
