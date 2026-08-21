package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nk4 extends ov2 {
    public static final int[] d = {1, 1, 1};
    public static final int[] e = {1, 1, 1, 1, 1};
    public static final int[][] f;
    public static final int[][] g;
    public final StringBuilder a = new StringBuilder(20);
    public final lb b = new lb(2);
    public final eg0 c = new eg0(8);

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f = iArr;
        int[][] iArr2 = new int[20][];
        g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = f[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            g[i] = iArr4;
        }
    }

    public static int g(bn bnVar, int[] iArr, int i, int[][] iArr2) {
        ov2.d(i, bnVar, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fC = ov2.c(iArr, iArr2[i3], 0.7f);
            if (fC < f2) {
                i2 = i3;
                f2 = fC;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw qs2.a();
    }

    public static int[] k(bn bnVar, int i, boolean z, int[] iArr, int[] iArr2) {
        int i2 = bnVar.f;
        int iF = z ? bnVar.f(i) : bnVar.e(i);
        int length = iArr.length;
        boolean z2 = z;
        int i3 = 0;
        int i4 = iF;
        while (iF < i2) {
            if (bnVar.d(iF) != z2) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (ov2.c(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i4, iF};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z2 = !z2;
            }
            iF++;
        }
        throw qs2.a();
    }

    public static int[] l(bn bnVar) {
        int[] iArr = new int[3];
        int[] iArrK = null;
        boolean zH = false;
        int i = 0;
        while (!zH) {
            Arrays.fill(iArr, 0, 3, 0);
            iArrK = k(bnVar, i, false, d, iArr);
            int i2 = iArrK[0];
            int i3 = iArrK[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zH = bnVar.h(i4, i2);
            }
            i = i3;
        }
        return iArrK;
    }

    @Override // defpackage.ov2
    public vk3 b(int i, bn bnVar, Map map) {
        return j(i, bnVar, l(bnVar), map);
    }

    public boolean f(String str) throws qi1 {
        int length = str.length();
        if (length != 0) {
            int i = length - 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            CharSequence charSequenceSubSequence = str.subSequence(0, i);
            int length2 = charSequenceSubSequence.length();
            int i2 = 0;
            for (int i3 = length2 - 1; i3 >= 0; i3 -= 2) {
                int iCharAt = charSequenceSubSequence.charAt(i3) - '0';
                if (iCharAt < 0 || iCharAt > 9) {
                    throw qi1.a();
                }
                i2 += iCharAt;
            }
            int i4 = i2 * 3;
            for (int i5 = length2 - 2; i5 >= 0; i5 -= 2) {
                int iCharAt2 = charSequenceSubSequence.charAt(i5) - '0';
                if (iCharAt2 < 0 || iCharAt2 > 9) {
                    throw qi1.a();
                }
                i4 += iCharAt2;
            }
            if ((1000 - i4) % 10 == iDigit) {
                return true;
            }
        }
        return false;
    }

    public int[] h(bn bnVar, int i) {
        return k(bnVar, i, false, d, new int[3]);
    }

    public abstract int i(bn bnVar, int[] iArr, StringBuilder sb);

    public vk3 j(int i, bn bnVar, int[] iArr, Map map) throws qs2, d40, qi1 {
        int length;
        String str = null;
        if (map != null && map.get(fk0.X) != null) {
            st4.n();
            return null;
        }
        StringBuilder sb = this.a;
        sb.setLength(0);
        int[] iArrH = h(bnVar, i(bnVar, iArr, sb));
        int i2 = iArrH[1];
        int i3 = (i2 - iArrH[0]) + i2;
        if (i3 >= bnVar.f || !bnVar.h(i2, i3)) {
            throw qs2.a();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw qi1.a();
        }
        if (!f(string)) {
            throw d40.a();
        }
        sj sjVarM = m();
        float f2 = i;
        vk3 vk3Var = new vk3(string, null, new xk3[]{new xk3((iArr[1] + iArr[0]) / 2.0f, f2), new xk3((iArrH[1] + iArrH[0]) / 2.0f, f2)}, sjVarM);
        try {
            vk3 vk3VarS = this.b.s(i, iArrH[1], bnVar);
            vk3Var.b(wk3.z0, vk3VarS.a);
            vk3Var.a(vk3VarS.e);
            xk3[] xk3VarArr = vk3VarS.c;
            xk3[] xk3VarArr2 = vk3Var.c;
            if (xk3VarArr2 == null) {
                vk3Var.c = xk3VarArr;
            } else if (xk3VarArr != null && xk3VarArr.length > 0) {
                xk3[] xk3VarArr3 = new xk3[xk3VarArr2.length + xk3VarArr.length];
                System.arraycopy(xk3VarArr2, 0, xk3VarArr3, 0, xk3VarArr2.length);
                System.arraycopy(xk3VarArr, 0, xk3VarArr3, xk3VarArr2.length, xk3VarArr.length);
                vk3Var.c = xk3VarArr3;
            }
            length = vk3VarS.a.length();
        } catch (de3 unused) {
            length = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(fk0.Y);
        if (iArr2 != null) {
            for (int i4 : iArr2) {
                if (length != i4) {
                }
            }
            throw qs2.a();
        }
        if (sjVarM == sj.y0 || sjVarM == sj.F0) {
            eg0 eg0Var = this.c;
            synchronized (eg0Var) {
                if (((ArrayList) eg0Var.f).isEmpty()) {
                    eg0Var.t(new int[]{0, 19}, "US/CA");
                    eg0Var.t(new int[]{30, 39}, "US");
                    eg0Var.t(new int[]{60, 139}, "US/CA");
                    eg0Var.t(new int[]{300, 379}, "FR");
                    eg0Var.t(new int[]{380}, "BG");
                    eg0Var.t(new int[]{383}, "SI");
                    eg0Var.t(new int[]{385}, "HR");
                    eg0Var.t(new int[]{387}, "BA");
                    eg0Var.t(new int[]{400, 440}, "DE");
                    eg0Var.t(new int[]{450, 459}, "JP");
                    eg0Var.t(new int[]{460, 469}, "RU");
                    eg0Var.t(new int[]{471}, "TW");
                    eg0Var.t(new int[]{474}, "EE");
                    eg0Var.t(new int[]{475}, "LV");
                    eg0Var.t(new int[]{476}, "AZ");
                    eg0Var.t(new int[]{477}, "LT");
                    eg0Var.t(new int[]{478}, "UZ");
                    eg0Var.t(new int[]{479}, "LK");
                    eg0Var.t(new int[]{480}, "PH");
                    eg0Var.t(new int[]{481}, "BY");
                    eg0Var.t(new int[]{482}, "UA");
                    eg0Var.t(new int[]{484}, "MD");
                    eg0Var.t(new int[]{485}, "AM");
                    eg0Var.t(new int[]{486}, "GE");
                    eg0Var.t(new int[]{487}, "KZ");
                    eg0Var.t(new int[]{489}, "HK");
                    eg0Var.t(new int[]{490, 499}, "JP");
                    eg0Var.t(new int[]{500, 509}, "GB");
                    eg0Var.t(new int[]{520}, "GR");
                    eg0Var.t(new int[]{528}, "LB");
                    eg0Var.t(new int[]{529}, "CY");
                    eg0Var.t(new int[]{531}, "MK");
                    eg0Var.t(new int[]{535}, "MT");
                    eg0Var.t(new int[]{539}, "IE");
                    eg0Var.t(new int[]{540, 549}, "BE/LU");
                    eg0Var.t(new int[]{560}, "PT");
                    eg0Var.t(new int[]{569}, "IS");
                    eg0Var.t(new int[]{570, 579}, "DK");
                    eg0Var.t(new int[]{590}, "PL");
                    eg0Var.t(new int[]{594}, "RO");
                    eg0Var.t(new int[]{599}, "HU");
                    eg0Var.t(new int[]{600, 601}, "ZA");
                    eg0Var.t(new int[]{603}, "GH");
                    eg0Var.t(new int[]{608}, "BH");
                    eg0Var.t(new int[]{609}, "MU");
                    eg0Var.t(new int[]{611}, "MA");
                    eg0Var.t(new int[]{613}, "DZ");
                    eg0Var.t(new int[]{616}, "KE");
                    eg0Var.t(new int[]{618}, "CI");
                    eg0Var.t(new int[]{619}, "TN");
                    eg0Var.t(new int[]{621}, "SY");
                    eg0Var.t(new int[]{622}, "EG");
                    eg0Var.t(new int[]{624}, "LY");
                    eg0Var.t(new int[]{625}, "JO");
                    eg0Var.t(new int[]{626}, "IR");
                    eg0Var.t(new int[]{627}, "KW");
                    eg0Var.t(new int[]{628}, "SA");
                    eg0Var.t(new int[]{629}, "AE");
                    eg0Var.t(new int[]{640, 649}, "FI");
                    eg0Var.t(new int[]{690, 695}, "CN");
                    eg0Var.t(new int[]{700, 709}, "NO");
                    eg0Var.t(new int[]{729}, "IL");
                    eg0Var.t(new int[]{730, 739}, "SE");
                    eg0Var.t(new int[]{740}, "GT");
                    eg0Var.t(new int[]{741}, "SV");
                    eg0Var.t(new int[]{742}, "HN");
                    eg0Var.t(new int[]{743}, "NI");
                    eg0Var.t(new int[]{744}, "CR");
                    eg0Var.t(new int[]{745}, "PA");
                    eg0Var.t(new int[]{746}, "DO");
                    eg0Var.t(new int[]{750}, "MX");
                    eg0Var.t(new int[]{754, 755}, "CA");
                    eg0Var.t(new int[]{759}, "VE");
                    eg0Var.t(new int[]{760, 769}, "CH");
                    eg0Var.t(new int[]{770}, "CO");
                    eg0Var.t(new int[]{773}, "UY");
                    eg0Var.t(new int[]{775}, "PE");
                    eg0Var.t(new int[]{777}, "BO");
                    eg0Var.t(new int[]{779}, "AR");
                    eg0Var.t(new int[]{780}, "CL");
                    eg0Var.t(new int[]{784}, "PY");
                    eg0Var.t(new int[]{785}, "PE");
                    eg0Var.t(new int[]{786}, "EC");
                    eg0Var.t(new int[]{789, 790}, "BR");
                    eg0Var.t(new int[]{800, 839}, "IT");
                    eg0Var.t(new int[]{840, 849}, "ES");
                    eg0Var.t(new int[]{850}, "CU");
                    eg0Var.t(new int[]{858}, "SK");
                    eg0Var.t(new int[]{859}, "CZ");
                    eg0Var.t(new int[]{860}, "YU");
                    eg0Var.t(new int[]{865}, "MN");
                    eg0Var.t(new int[]{867}, "KP");
                    eg0Var.t(new int[]{868, 869}, "TR");
                    eg0Var.t(new int[]{870, 879}, "NL");
                    eg0Var.t(new int[]{880}, "KR");
                    eg0Var.t(new int[]{885}, "TH");
                    eg0Var.t(new int[]{888}, "SG");
                    eg0Var.t(new int[]{890}, "IN");
                    eg0Var.t(new int[]{893}, "VN");
                    eg0Var.t(new int[]{896}, "PK");
                    eg0Var.t(new int[]{899}, "ID");
                    eg0Var.t(new int[]{900, 919}, "AT");
                    eg0Var.t(new int[]{930, 939}, "AU");
                    eg0Var.t(new int[]{940, 949}, "AZ");
                    eg0Var.t(new int[]{955}, "MY");
                    eg0Var.t(new int[]{958}, "MO");
                }
            }
            int i5 = Integer.parseInt(string.substring(0, 3));
            int size = ((ArrayList) eg0Var.f).size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    break;
                }
                int[] iArr3 = (int[]) ((ArrayList) eg0Var.f).get(i6);
                int i7 = iArr3[0];
                if (i5 < i7) {
                    break;
                }
                if (iArr3.length != 1) {
                    i7 = iArr3[1];
                }
                if (i5 <= i7) {
                    str = (String) ((ArrayList) eg0Var.z).get(i6);
                    break;
                }
                i6++;
            }
            if (str != null) {
                vk3Var.b(wk3.y0, str);
            }
        }
        vk3Var.b(wk3.D0, "]E" + (sjVarM == sj.Z ? 4 : 0));
        return vk3Var;
    }

    public abstract sj m();
}
