package defpackage;

import android.os.Bundle;
import androidx.fragment.app.o;
import com.getsurfboard.backup.model.SettingValue;
import com.tencent.mars.xlog.Xlog;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Iterator;
import org.conscrypt.FileClientSessionCache;
import org.conscrypt.OpenSSLProvider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ha0 {
    public static /* synthetic */ String A(int i) {
        switch (i) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String B(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return SettingValue.TYPE_STRING;
            case 7:
                return "NUMBER";
            case 8:
                return SettingValue.TYPE_BOOLEAN;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static oz0 a(mn4 mn4Var) {
        oz0 oz0Var = (oz0) mn4Var.p(dy1.u, oz0.c);
        oz0Var.getClass();
        return oz0Var;
    }

    public static boolean b(int i, int i2, int i3) {
        switch (i) {
            case 1:
                if (((i2 + i3) & 1) == 0) {
                }
                break;
            case 2:
                if ((i2 & 1) == 0) {
                }
                break;
            case 3:
                if (i3 % 3 == 0) {
                }
                break;
            case 4:
                if ((i2 + i3) % 3 == 0) {
                }
                break;
            case 5:
                if ((((i3 / 3) + (i2 / 2)) & 1) == 0) {
                }
                break;
            case 6:
                if ((i2 * i3) % 6 == 0) {
                }
                break;
            case 7:
                if ((i2 * i3) % 6 < 3) {
                }
                break;
            default:
                if (((((i2 * i3) % 3) + i2 + i3) & 1) == 0) {
                }
                break;
        }
        return true;
    }

    public static final boolean c(int i, int i2) {
        return (d(i) & i2) != 0;
    }

    public static final int d(int i) {
        return 1 << fw.G(i);
    }

    public static String e(String str, char c) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String f(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = str.charAt(i);
            if (!Character.isLetter(cCharAt)) {
                i++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i) + upperCase + str.substring(i + 1);
            }
        }
        return str;
    }

    public static /* synthetic */ long g(int i) {
        switch (i) {
            case 1:
                return 67324752L;
            case 2:
                return 134695760L;
            case 3:
                return 33639248L;
            case 4:
                return 101010256L;
            case 5:
                return 808471376L;
            case 6:
                return 84233040L;
            case 7:
                return 134630224L;
            case 8:
                return 134695760L;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return 117853008L;
            case 10:
                return 101075792L;
            case 11:
                return 1L;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return 39169L;
            default:
                throw null;
        }
    }

    public static float h(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static int i(int i, int i2, int i3, int i4, int i5) {
        return (((i + i2) * i3) + i4) * i5;
    }

    public static String j(long j, String str) {
        return str + j;
    }

    public static String k(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String l(String str, o oVar, String str2) {
        return str + oVar + str2;
    }

    public static String m(String str, Object obj, char c) {
        return str + obj + c;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static StringBuilder q(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder r(OpenSSLProvider openSSLProvider, String str, String str2, String str3, String str4) {
        openSSLProvider.put(str, str2);
        openSSLProvider.put(str3, str4);
        return new StringBuilder();
    }

    public static /* synthetic */ void s() {
    }

    public static void t(int i, HashMap map, String str, int i2, String str2) {
        map.put(str, hd1.b(i));
        map.put(str2, hd1.b(i2));
    }

    public static void u(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        e7.a(bundle, str3);
    }

    public static void v(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static /* synthetic */ boolean w(Object obj) {
        return obj != null;
    }

    public static String x(String str, String str2) {
        return str + str2;
    }

    public static sw2 y(ka0 ka0Var, ka0 ka0Var2) {
        if (ka0Var == null && ka0Var2 == null) {
            return sw2.z;
        }
        qn2 qn2VarD = ka0Var2 != null ? qn2.d(ka0Var2) : qn2.c();
        if (ka0Var != null) {
            Iterator it = ka0Var.t().iterator();
            while (it.hasNext()) {
                z(qn2VarD, ka0Var2, ka0Var, (pg) it.next());
            }
        }
        return sw2.a(qn2VarD);
    }

    public static void z(qn2 qn2Var, ka0 ka0Var, ka0 ka0Var2, pg pgVar) {
        if (!Objects.equals(pgVar, hy1.F)) {
            qn2Var.f(pgVar, ka0Var2.S(pgVar), ka0Var2.u(pgVar));
            return;
        }
        sj3 sj3Var = (sj3) ka0Var2.p(pgVar, null);
        sj3 sj3Var2 = (sj3) ka0Var.p(pgVar, null);
        ia0 ia0VarS = ka0Var2.S(pgVar);
        if (sj3Var == null) {
            sj3Var = sj3Var2;
        } else if (sj3Var2 != null) {
            v62 v62Var = new v62(22, false);
            v62Var.f = sj3Var2.a;
            v62Var.z = sj3Var2.b;
            pr1 pr1Var = sj3Var.a;
            if (pr1Var != null) {
                v62Var.f = pr1Var;
            }
            tj3 tj3Var = sj3Var.b;
            if (tj3Var != null) {
                v62Var.z = tj3Var;
            }
            sj3Var = new sj3((pr1) v62Var.f, (tj3) v62Var.z, null);
        }
        qn2Var.f(pgVar, ia0VarS, sj3Var);
    }
}
