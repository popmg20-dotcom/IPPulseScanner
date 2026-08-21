package defpackage;

import android.os.Bundle;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k65 {
    public static final AtomicReference b = new AtomicReference();
    public static final AtomicReference c = new AtomicReference();
    public static final AtomicReference d = new AtomicReference();
    public final i85 a;

    public k65(i85 i85Var) {
        this.a = i85Var;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        tj4.i(atomicReference);
        tj4.d(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (Objects.equals(str, strArr[i])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i];
                        if (str2 == null) {
                            str2 = strArr2[i] + "(" + strArr[i] + ")";
                            strArr3[i] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !this.a.b() ? str : g(str, xb5.z0, xb5.Z, b);
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.a.b() ? str : g(str, je.Y, je.X, c);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        return !this.a.b() ? str : str.startsWith("_exp_") ? ha0.o("experiment_id(", str, ")") : g(str, ye.e, ye.d, d);
    }

    public final String d(z25 z25Var) {
        i85 i85Var = this.a;
        if (!i85Var.b()) {
            return z25Var.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(z25Var.z);
        sb.append(",name=");
        sb.append(a(z25Var.b));
        sb.append(",params=");
        y25 y25Var = z25Var.f;
        sb.append(y25Var == null ? null : !i85Var.b() ? y25Var.b.toString() : e(y25Var.l()));
        return sb.toString();
    }

    public final String e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.a.b()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(b(str));
            sb.append("=");
            Object obj = bundle.get(str);
            sb.append(obj instanceof Bundle ? f(new Object[]{obj}) : obj instanceof Object[] ? f((Object[]) obj) : obj instanceof ArrayList ? f(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb.append("}]");
        return sb.toString();
    }

    public final String f(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            String strE = obj instanceof Bundle ? e((Bundle) obj) : String.valueOf(obj);
            if (strE != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(strE);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
