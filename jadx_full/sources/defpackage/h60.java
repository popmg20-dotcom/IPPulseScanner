package defpackage;

import io.netty.channel.unix.Socket;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h60 extends ov2 {
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '.', ' ', '$', '/', '+', '%', 'a', 'b', 'c', 'd', '*'};
    public static final int[] d;
    public static final int e;
    public final StringBuilder a = new StringBuilder(20);
    public final int[] b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        d = iArr;
        e = iArr[47];
    }

    public static void f(int i, int i2, CharSequence charSequence) throws d40 {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != c[iIndexOf % 47]) {
            throw d40.a();
        }
    }

    public static int g(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = Math.round((iArr[i4] * 9.0f) / i);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    @Override // defpackage.ov2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final vk3 b(int i, bn bnVar, Map map) throws qs2, d40, qi1 {
        int i2;
        char c2;
        int i3 = bnVar.f;
        int iE = bnVar.e(0);
        int[] iArr = this.b;
        Arrays.fill(iArr, 0);
        int length = iArr.length;
        boolean z = false;
        int i4 = 0;
        int i5 = iE;
        while (iE < i3) {
            if (bnVar.d(iE) != z) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (g(iArr) == e) {
                        int iE2 = bnVar.e(new int[]{i5, iE}[1]);
                        int i6 = bnVar.f;
                        Arrays.fill(iArr, 0);
                        StringBuilder sb = this.a;
                        sb.setLength(0);
                        while (true) {
                            ov2.d(iE2, bnVar, iArr);
                            int iG = g(iArr);
                            if (iG < 0) {
                                throw qs2.a();
                            }
                            for (int i7 = 0; i7 < 48; i7++) {
                                if (d[i7] == iG) {
                                    char c3 = c[i7];
                                    sb.append(c3);
                                    int i8 = iE2;
                                    for (int i9 : iArr) {
                                        i8 += i9;
                                    }
                                    int iE3 = bnVar.e(i8);
                                    if (c3 == '*') {
                                        sb.deleteCharAt(sb.length() - 1);
                                        int i10 = 0;
                                        for (int i11 : iArr) {
                                            i10 += i11;
                                        }
                                        if (iE3 == i6 || !bnVar.d(iE3)) {
                                            throw qs2.a();
                                        }
                                        if (sb.length() < 2) {
                                            throw qs2.a();
                                        }
                                        int length2 = sb.length();
                                        f(length2 - 2, 20, sb);
                                        f(length2 - 1, 15, sb);
                                        sb.setLength(sb.length() - 2);
                                        int length3 = sb.length();
                                        StringBuilder sb2 = new StringBuilder(length3);
                                        int i12 = 0;
                                        while (i12 < length3) {
                                            char cCharAt = sb.charAt(i12);
                                            if (cCharAt >= 'a' && cCharAt <= 'd') {
                                                if (i12 >= length3 - 1) {
                                                    throw qi1.a();
                                                }
                                                i12++;
                                                char cCharAt2 = sb.charAt(i12);
                                                switch (cCharAt) {
                                                    case 'a':
                                                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                                            throw qi1.a();
                                                        }
                                                        i2 = cCharAt2 - '@';
                                                        c2 = (char) i2;
                                                        sb2.append(c2);
                                                        break;
                                                        break;
                                                    case 'b':
                                                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                                                            i2 = cCharAt2 - '&';
                                                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                                                            i2 = cCharAt2 - 11;
                                                        } else if (cCharAt2 >= 'K' && cCharAt2 <= 'O') {
                                                            i2 = cCharAt2 + 16;
                                                        } else if (cCharAt2 < 'P' || cCharAt2 > 'T') {
                                                            if (cCharAt2 == 'U') {
                                                                c2 = 0;
                                                            } else if (cCharAt2 == 'V') {
                                                                c2 = '@';
                                                            } else if (cCharAt2 == 'W') {
                                                                c2 = '`';
                                                            } else {
                                                                if (cCharAt2 < 'X' || cCharAt2 > 'Z') {
                                                                    throw qi1.a();
                                                                }
                                                                c2 = 127;
                                                            }
                                                            sb2.append(c2);
                                                        } else {
                                                            i2 = cCharAt2 + '+';
                                                        }
                                                        c2 = (char) i2;
                                                        sb2.append(c2);
                                                        break;
                                                    case 'c':
                                                        if (cCharAt2 < 'A' || cCharAt2 > 'O') {
                                                            if (cCharAt2 != 'Z') {
                                                                throw qi1.a();
                                                            }
                                                            c2 = ':';
                                                            sb2.append(c2);
                                                        } else {
                                                            i2 = cCharAt2 - ' ';
                                                            c2 = (char) i2;
                                                            sb2.append(c2);
                                                        }
                                                        break;
                                                    case Socket.UDS_SUN_PATH_SIZE /* 100 */:
                                                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                                            throw qi1.a();
                                                        }
                                                        i2 = cCharAt2 + ' ';
                                                        c2 = (char) i2;
                                                        sb2.append(c2);
                                                        break;
                                                        break;
                                                }
                                            } else {
                                                sb2.append(cCharAt);
                                            }
                                            i12++;
                                        }
                                        float f = i;
                                        vk3 vk3Var = new vk3(sb2.toString(), null, new xk3[]{new xk3((r15[1] + r15[0]) / 2.0f, f), new xk3((i10 / 2.0f) + iE2, f)}, sj.A);
                                        vk3Var.b(wk3.D0, "]G0");
                                        return vk3Var;
                                    }
                                    iE2 = iE3;
                                }
                            }
                            throw qs2.a();
                        }
                    }
                    i5 += iArr[0] + iArr[1];
                    int i13 = i4 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i4] = 0;
                    i4--;
                }
                iArr[i4] = 1;
                z = !z;
            }
            iE++;
        }
        throw qs2.a();
    }
}
