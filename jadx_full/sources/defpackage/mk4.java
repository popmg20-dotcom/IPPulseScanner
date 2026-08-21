package defpackage;

import java.util.EnumMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mk4 {
    public static final int[] c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    public final int[] a;
    public final StringBuilder b;

    public mk4(int i) {
        switch (i) {
            case 1:
                this.a = new int[4];
                this.b = new StringBuilder();
                break;
            default:
                this.a = new int[4];
                this.b = new StringBuilder();
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public vk3 a(int i, bn bnVar, int[] iArr) throws qs2 {
        String str;
        String str2;
        EnumMap enumMap;
        StringBuilder sb = this.b;
        sb.setLength(0);
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = bnVar.f;
        int iF = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 5 && iF < i2; i4++) {
            int iG = nk4.g(bnVar, iArr2, iF, nk4.g);
            sb.append((char) ((iG % 10) + 48));
            for (int i5 : iArr2) {
                iF += i5;
            }
            if (iG >= 10) {
                i3 |= 1 << (4 - i4);
            }
            if (i4 != 4) {
                iF = bnVar.f(bnVar.e(iF));
            }
        }
        if (sb.length() != 5) {
            throw qs2.a();
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (i3 == c[i6]) {
                String string = sb.toString();
                int length = string.length();
                int iCharAt = 0;
                for (int i7 = length - 2; i7 >= 0; i7 -= 2) {
                    iCharAt += string.charAt(i7) - '0';
                }
                int iCharAt2 = iCharAt * 3;
                for (int i8 = length - 1; i8 >= 0; i8 -= 2) {
                    iCharAt2 += string.charAt(i8) - '0';
                }
                if ((iCharAt2 * 3) % 10 != i6) {
                    throw qs2.a();
                }
                String string2 = sb.toString();
                if (string2.length() == 5) {
                    char cCharAt = string2.charAt(0);
                    if (cCharAt == '0') {
                        str = "£";
                    } else if (cCharAt != '5') {
                        str = "";
                        if (cCharAt == '9') {
                            switch (string2) {
                                case "90000":
                                    str2 = null;
                                    break;
                                case "99990":
                                    str2 = "Used";
                                    break;
                                case "99991":
                                    str2 = "0.00";
                                    break;
                            }
                            if (str2 != null) {
                                enumMap = null;
                            } else {
                                enumMap = new EnumMap(wk3.class);
                                enumMap.put(wk3.Z, str2);
                            }
                        }
                    } else {
                        str = "$";
                    }
                    int i9 = Integer.parseInt(string2.substring(1));
                    String strValueOf = String.valueOf(i9 / 100);
                    int i10 = i9 % 100;
                    str2 = str + strValueOf + '.' + (i10 < 10 ? dw2.A(i10, "0") : String.valueOf(i10));
                    if (str2 != null) {
                    }
                }
                float f = i;
                vk3 vk3Var = new vk3(string2, null, new xk3[]{new xk3((iArr[0] + iArr[1]) / 2.0f, f), new xk3(iF, f)}, sj.H0);
                if (enumMap != null) {
                    vk3Var.a(enumMap);
                }
                return vk3Var;
            }
        }
        throw qs2.a();
    }
}
