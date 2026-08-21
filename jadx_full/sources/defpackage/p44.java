package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p44 extends w44 {
    public static int A0(CharSequence charSequence, String str, int i) {
        int length = (i & 2) != 0 ? charSequence.length() - 1 : 0;
        str.getClass();
        return !(charSequence instanceof String) ? t0(charSequence, str, length, 0, false, true) : ((String) charSequence).lastIndexOf(str, length);
    }

    public static List B0(CharSequence charSequence) {
        charSequence.getClass();
        hb2 hb2Var = new hb2(charSequence);
        if (!hb2Var.hasNext()) {
            return g41.b;
        }
        Object next = hb2Var.next();
        if (!hb2Var.hasNext()) {
            return p95.x(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (hb2Var.hasNext()) {
            arrayList.add(hb2Var.next());
        }
        return arrayList;
    }

    public static String C0(String str) {
        CharSequence charSequenceSubSequence;
        if (15 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(15);
            sb.append((CharSequence) str);
            int length = 15 - str.length();
            int i = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(' ');
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static String D0(String str, int i, char c) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        if (i < 0) {
            xe.k(ha0.k("Desired length ", i, " is less than zero."));
            return null;
        }
        if (i <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - str.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean E0(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!yr2.z(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String F0(String str, String str2) {
        str.getClass();
        return w44.j0(str, str2, false) ? str.substring(str2.length()) : str;
    }

    public static String G0(CharSequence charSequence, String str) {
        str.getClass();
        return q0(charSequence, str) ? str.substring(0, str.length() - charSequence.length()) : str;
    }

    public static String H0(String str, String str2) {
        str.getClass();
        return (str.length() >= str2.length() + str2.length() && w44.j0(str, str2, false) && q0(str2, str)) ? str.substring(str2.length(), str.length() - str2.length()) : str;
    }

    public static final void I0(int i) {
        if (i >= 0) {
            return;
        }
        e04.f(dw2.A(i, "Limit must be non-negative, but was "));
    }

    public static final List J0(CharSequence charSequence, String str, int i) {
        I0(i);
        int iS0 = s0(charSequence, str, 0, false);
        if (iS0 == -1 || i == 1) {
            return p95.x(charSequence.toString());
        }
        boolean z = i > 0;
        int i2 = 10;
        if (z && i <= 10) {
            i2 = i;
        }
        ArrayList arrayList = new ArrayList(i2);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iS0).toString());
            length = str.length() + iS0;
            if (z && arrayList.size() == i - 1) {
                break;
            }
            iS0 = s0(charSequence, str, length, false);
        } while (iS0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List K0(CharSequence charSequence, char[] cArr, int i) {
        int i2 = (i & 4) != 0 ? 0 : 2;
        charSequence.getClass();
        if (cArr.length == 1) {
            return J0(charSequence, String.valueOf(cArr[0]), i2);
        }
        I0(i2);
        we0 we0Var = new we0(new do0(charSequence, i2, new cd(8, cArr)));
        ArrayList arrayList = new ArrayList(f70.Q(10, we0Var));
        Iterator it = we0Var.iterator();
        while (true) {
            co0 co0Var = (co0) it;
            if (!co0Var.hasNext()) {
                return arrayList;
            }
            b12 b12Var = (b12) co0Var.next();
            b12Var.getClass();
            arrayList.add(charSequence.subSequence(b12Var.b, b12Var.f + 1).toString());
        }
    }

    public static List L0(CharSequence charSequence, String[] strArr, int i) {
        int i2 = (i & 4) != 0 ? 0 : 2;
        charSequence.getClass();
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return J0(charSequence, str, i2);
            }
        }
        I0(i2);
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        we0 we0Var = new we0(new do0(charSequence, i2, new cd(7, listAsList)));
        ArrayList arrayList = new ArrayList(f70.Q(10, we0Var));
        Iterator it = we0Var.iterator();
        while (true) {
            co0 co0Var = (co0) it;
            if (!co0Var.hasNext()) {
                return arrayList;
            }
            b12 b12Var = (b12) co0Var.next();
            b12Var.getClass();
            arrayList.add(charSequence.subSequence(b12Var.b, b12Var.f + 1).toString());
        }
    }

    public static boolean M0(String str, char c) {
        str.getClass();
        return str.length() > 0 && yr2.z(str.charAt(0), c, false);
    }

    public static String N0(String str, char c) {
        int iU0 = u0(str, c, 0, 6);
        return iU0 == -1 ? str : str.substring(iU0 + 1, str.length());
    }

    public static String O0(String str, String str2) {
        int iV0 = v0(str, str2, 0, false, 6);
        return iV0 == -1 ? str : str.substring(str2.length() + iV0, str.length());
    }

    public static String P0(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int iZ0 = z0(str, c, 0, 6);
        return iZ0 == -1 ? str2 : str.substring(iZ0 + 1, str.length());
    }

    public static String Q0(String str, char c) {
        str.getClass();
        str.getClass();
        int iU0 = u0(str, c, 0, 6);
        return iU0 == -1 ? str : str.substring(0, iU0);
    }

    public static String R0(String str, char c) {
        str.getClass();
        str.getClass();
        int iZ0 = z0(str, c, 0, 6);
        return iZ0 == -1 ? str : str.substring(0, iZ0);
    }

    public static String S0(String str, String str2) {
        str.getClass();
        str.getClass();
        int iA0 = A0(str, str2, 6);
        return iA0 == -1 ? str : str.substring(0, iA0);
    }

    public static String T0(int i, String str) {
        str.getClass();
        if (i < 0) {
            e04.f(ha0.k("Requested character count ", i, " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(0, i);
    }

    public static CharSequence U0(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zO = yr2.O(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zO) {
                    break;
                }
                length--;
            } else if (zO) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static boolean o0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        if (charSequence2 instanceof String) {
            if (v0(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                return true;
            }
        } else if (t0(charSequence, charSequence2, 0, charSequence.length(), z, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean p0(CharSequence charSequence, char c) {
        charSequence.getClass();
        return u0(charSequence, c, 0, 2) >= 0;
    }

    public static boolean q0(CharSequence charSequence, String str) {
        return charSequence instanceof String ? w44.d0(str, (String) charSequence, false) : E0(str, false, str.length() - charSequence.length(), charSequence, 0, charSequence.length());
    }

    public static boolean r0(String str, char c) {
        return str.length() > 0 && yr2.z(str.charAt(str.length() - 1), c, false);
    }

    public static final int s0(CharSequence charSequence, String str, int i, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? t0(charSequence, str, i, charSequence.length(), z, false) : ((String) charSequence).indexOf(str, i);
    }

    public static final int t0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        z02 z02Var;
        if (z2) {
            charSequence.getClass();
            int length = charSequence.length() - 1;
            if (i > length) {
                i = length;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            z02Var = new z02(i, i2, -1);
        } else {
            if (i < 0) {
                i = 0;
            }
            int length2 = charSequence.length();
            if (i2 > length2) {
                i2 = length2;
            }
            z02Var = new b12(i, i2, 1);
        }
        boolean z3 = charSequence instanceof String;
        int i3 = z02Var.z;
        int i4 = z02Var.f;
        int i5 = z02Var.b;
        if (z3 && (charSequence2 instanceof String)) {
            if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
                int i6 = i5;
                while (true) {
                    String str = (String) charSequence2;
                    boolean z4 = z;
                    if (!w44.g0(0, i6, str.length(), str, (String) charSequence, z4)) {
                        if (i6 == i4) {
                            break;
                        }
                        i6 += i3;
                        z = z4;
                    } else {
                        return i6;
                    }
                }
            }
        } else if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
            int i7 = i5;
            while (true) {
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                if (!E0(charSequence4, z, 0, charSequence3, i7, charSequence2.length())) {
                    if (i7 == i4) {
                        break;
                    }
                    i7 += i3;
                    charSequence2 = charSequence4;
                    charSequence = charSequence3;
                } else {
                    return i7;
                }
            }
        }
        return -1;
    }

    public static int u0(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        charSequence.getClass();
        return !(charSequence instanceof String) ? w0(charSequence, new char[]{c}, i, false) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int v0(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return s0(charSequence, str, i, z);
    }

    public static final int w0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(qe.p0(cArr), i);
        }
        if (i < 0) {
            i = 0;
        }
        int length = charSequence.length() - 1;
        if (i > length) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (yr2.z(c, cCharAt, z)) {
                    return i;
                }
            }
            if (i == length) {
                return -1;
            }
            i++;
        }
    }

    public static boolean x0(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            if (!yr2.O(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static char y0(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            return charSequence.charAt(charSequence.length() - 1);
        }
        e04.h("Char sequence is empty.");
        return (char) 0;
    }

    public static int z0(CharSequence charSequence, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            charSequence.getClass();
            i = charSequence.length() - 1;
        }
        charSequence.getClass();
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        char[] cArr = {c};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(qe.p0(cArr), i);
        }
        int length = charSequence.length() - 1;
        if (i > length) {
            i = length;
        }
        while (-1 < i) {
            if (yr2.z(cArr[0], charSequence.charAt(i), false)) {
                return i;
            }
            i--;
        }
        return -1;
    }
}
