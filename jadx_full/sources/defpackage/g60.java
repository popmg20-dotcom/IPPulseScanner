package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g60 extends ov2 {
    public static final int[] d = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};
    public final boolean a;
    public final StringBuilder b = new StringBuilder(20);
    public final int[] c = new int[9];

    public g60(boolean z) {
        this.a = z;
    }

    public static int f(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if (i10 * 2 >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    @Override // defpackage.ov2
    public final vk3 b(int i, bn bnVar, Map map) throws qs2, d40 {
        int i2;
        char c;
        char cCharAt;
        int[] iArr = this.c;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.b;
        sb.setLength(0);
        int i3 = bnVar.f;
        int iE = bnVar.e(0);
        int length = iArr.length;
        boolean z = false;
        int i4 = 0;
        int i5 = iE;
        while (iE < i3) {
            char c2 = 1;
            if (bnVar.d(iE) != z) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 == length - 1) {
                    int i6 = 148;
                    if (f(iArr) == 148 && bnVar.h(Math.max(0, i5 - ((iE - i5) / 2)), i5)) {
                        int iE2 = bnVar.e(new int[]{i5, iE}[1]);
                        int i7 = bnVar.f;
                        while (true) {
                            ov2.d(iE2, bnVar, iArr);
                            int iF = f(iArr);
                            if (iF < 0) {
                                throw qs2.a();
                            }
                            int i8 = 0;
                            while (true) {
                                if (i8 < 43) {
                                    c = c2;
                                    if (d[i8] == iF) {
                                        cCharAt = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i8);
                                        break;
                                    }
                                    i8++;
                                    c2 = c;
                                } else {
                                    c = c2;
                                    if (iF != i6) {
                                        throw qs2.a();
                                    }
                                    cCharAt = '*';
                                }
                            }
                            sb.append(cCharAt);
                            int i9 = iE2;
                            for (int i10 : iArr) {
                                i9 += i10;
                            }
                            int iE3 = bnVar.e(i9);
                            if (cCharAt == '*') {
                                sb.setLength(sb.length() - 1);
                                int i11 = 0;
                                for (int i12 : iArr) {
                                    i11 += i12;
                                }
                                int i13 = (iE3 - iE2) - i11;
                                if (iE3 != i7 && i13 * 2 < i11) {
                                    throw qs2.a();
                                }
                                if (this.a) {
                                    int length2 = sb.length() - 1;
                                    int iIndexOf = 0;
                                    for (int i14 = 0; i14 < length2; i14++) {
                                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(sb.charAt(i14));
                                    }
                                    if (sb.charAt(length2) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                                        throw d40.a();
                                    }
                                    sb.setLength(length2);
                                }
                                if (sb.length() == 0) {
                                    throw qs2.a();
                                }
                                String string = sb.toString();
                                float f = (r5[c] + r5[0]) / 2.0f;
                                float f2 = (i11 / 2.0f) + iE2;
                                float f3 = i;
                                xk3 xk3Var = new xk3(f, f3);
                                xk3 xk3Var2 = new xk3(f2, f3);
                                xk3[] xk3VarArr = new xk3[2];
                                xk3VarArr[0] = xk3Var;
                                xk3VarArr[c] = xk3Var2;
                                vk3 vk3Var = new vk3(string, null, xk3VarArr, sj.z);
                                vk3Var.b(wk3.D0, "]A0");
                                return vk3Var;
                            }
                            c2 = c;
                            iE2 = iE3;
                            i6 = 148;
                        }
                    } else {
                        i2 = 1;
                        i5 += iArr[0] + iArr[1];
                        int i15 = i4 - 1;
                        System.arraycopy(iArr, 2, iArr, 0, i15);
                        iArr[i15] = 0;
                        iArr[i4] = 0;
                        i4--;
                    }
                } else {
                    i2 = 1;
                    i4++;
                }
                iArr[i4] = i2;
                z = !z;
            }
            iE++;
        }
        throw qs2.a();
    }
}
