package defpackage;

import com.tencent.mars.xlog.Xlog;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class fw implements wv {
    public static final /* synthetic */ int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    public static final int[] f = {2, 1, 4, 3};

    public static StringBuilder A(int i, int i2, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder B(int i, String str) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        return sb;
    }

    public static StringBuilder C(String str, String str2, long j) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder D(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder E(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static /* synthetic */ String F(int i) {
        switch (i) {
            case 1:
                return "RELEASED";
            case 2:
                return "RELEASING";
            case 3:
                return "INITIALIZED";
            case 4:
                return "PENDING_OPEN";
            case 5:
                return "OPENING_WITH_ERROR";
            case 6:
                return "CLOSING";
            case 7:
                return "REOPENING_QUIRK";
            case 8:
                return "REOPENING";
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return "OPENING";
            case 10:
                return "OPENED";
            case 11:
                return "CONFIGURED";
            default:
                throw null;
        }
    }

    public static /* synthetic */ int G(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String H(int i) {
        switch (i) {
            case 1:
                return "RELEASED";
            case 2:
                return "RELEASING";
            case 3:
                return "INITIALIZED";
            case 4:
                return "PENDING_OPEN";
            case 5:
                return "OPENING_WITH_ERROR";
            case 6:
                return "CLOSING";
            case 7:
                return "REOPENING_QUIRK";
            case 8:
                return "REOPENING";
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return "OPENING";
            case 10:
                return "OPENED";
            case 11:
                return "CONFIGURED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String I(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "CLOSED" : "CLOSING" : "OPEN" : "OPENING" : "PENDING_OPEN";
    }

    public static /* synthetic */ String J(int i) {
        switch (i) {
            case 1:
                return "UNINITIALIZED";
            case 2:
                return "RELEASED";
            case 3:
                return "INITIALIZED";
            case 4:
                return "GET_SURFACE";
            case 5:
                return "RELEASING";
            case 6:
                return "CLOSED";
            case 7:
                return "OPENING";
            case 8:
                return "OPENED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String K(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "null" : "IN_LINE" : "BLOCK" : "BLANK_LINE";
    }

    public static /* synthetic */ int[] L(int i) {
        int[] iArr = new int[i];
        System.arraycopy(b, 0, iArr, 0, i);
        return iArr;
    }

    public static boolean a(kz kzVar, r90 r90Var, cp1 cp1Var) {
        for (eq1 eq1Var : (LinkedHashSet) cp1Var.f) {
            if (!eq1Var.b(kzVar, r90Var)) {
                ez4.o("CameraInfoInternal", eq1Var + " is not supported.");
                return false;
            }
        }
        try {
            r25.O(kzVar, r90Var, cp1Var);
            return true;
        } catch (h00 | IllegalArgumentException e) {
            ez4.p("CameraInfoInternal", "CameraInfoInternal.isResolvedFeatureGroupSupported failed", e);
            return false;
        }
    }

    public static void b(fg fgVar, go3 go3Var) {
        go3Var.getClass();
        if (go3Var instanceof c64) {
            fgVar.c(((c64) go3Var).b);
        }
    }

    public static int c(int i) throws qy4 {
        for (int i2 : L(3)) {
            if (h(i2) == i) {
                return i2;
            }
        }
        throw new qy4("Unknown compression method", 4);
    }

    public static /* synthetic */ void d(int i, String str) {
        if (i != 0) {
            return;
        }
        zo2.n(str);
    }

    public static /* synthetic */ boolean e(int i, int i2) {
        if (i != 0) {
            return i == i2;
        }
        throw null;
    }

    public static /* synthetic */ String f(int i) {
        if (i == 1) {
            return "MD5";
        }
        if (i == 2) {
            return "MD5-sess";
        }
        throw null;
    }

    public static /* synthetic */ int g(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 0;
        }
        if (i == 3) {
            return 3;
        }
        if (i == 4) {
            return 2;
        }
        throw null;
    }

    public static /* synthetic */ int h(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 8;
        }
        if (i == 3) {
            return 99;
        }
        throw null;
    }

    public static /* synthetic */ int i(int i) {
        if (i == 1) {
            return 16;
        }
        if (i == 2) {
            return 24;
        }
        if (i == 3) {
            return 32;
        }
        throw null;
    }

    public static /* synthetic */ int j(int i) {
        if (i == 1) {
            return 16;
        }
        if (i == 2) {
            return 24;
        }
        if (i == 3) {
            return 32;
        }
        throw null;
    }

    public static /* synthetic */ String k(int i) {
        if (i == 1) {
            return "auth";
        }
        if (i == 2) {
            return "auth-int";
        }
        throw null;
    }

    public static /* synthetic */ int l(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i == 3) {
                    return 3;
                }
                throw null;
            }
        }
        return i2;
    }

    public static /* synthetic */ int m(int i) {
        if (i == 1) {
            return 8;
        }
        if (i == 2) {
            return 12;
        }
        if (i == 3) {
            return 16;
        }
        throw null;
    }

    public static /* synthetic */ int o(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        throw null;
    }

    public static int p(int i, int i2, int i3, int i4) {
        return ((i * i2) + i3) * i4;
    }

    public static int q(ws0 ws0Var, int i, int i2, int i3, int i4) {
        return (((ws0Var.hashCode() + i) * i2) + i3) * i4;
    }

    public static Object r(ArrayList arrayList, int i) {
        return arrayList.get(arrayList.size() - i);
    }

    public static String s(int i, int i2, String str, String str2) {
        return str + i + str2 + i2;
    }

    public static String t(int i, String str, String str2, String str3, String str4) {
        return str + str2 + str3 + i + str4;
    }

    public static String u(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String v(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String w(String str, StringBuilder sb, int i) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String x(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static String y(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String z(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }
}
