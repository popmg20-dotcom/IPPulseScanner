package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class b10 {
    public boolean a;
    public boolean b;
    public Object c;

    public b10(bt3 bt3Var, String str) {
        this.a = bt3Var.f(ah2.USE_STD_BEAN_NAMING);
        this.b = bt3Var.f(ah2.ALLOW_IS_GETTERS_FOR_NON_BOOLEAN);
        this.c = str;
    }

    public static String e(int i, String str) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb.append((CharSequence) str, i, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    public static String f(int i, String str) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        int i2 = i + 1;
        if (i2 < length && Character.isUpperCase(str.charAt(i2))) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        sb.append((CharSequence) str, i2, length);
        return sb.toString();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.a) {
                    return;
                }
                this.a = true;
                this.b = true;
                m10 m10Var = (m10) this.c;
                if (m10Var != null) {
                    try {
                        Runnable runnable = (Runnable) m10Var.f;
                        vg4 vg4Var = (vg4) m10Var.z;
                        Runnable runnable2 = (Runnable) m10Var.A;
                        if (runnable == null) {
                            vg4Var.d();
                            runnable2.run();
                        } else {
                            runnable.run();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.b = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (this) {
                    this.b = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public String b(d9 d9Var, String str) {
        if (!this.b) {
            nj4 nj4VarX = d9Var.x();
            if (nj4VarX.B()) {
                nj4VarX = nj4VarX.u();
            }
            if (!nj4VarX.g0(Boolean.TYPE) && !nj4VarX.g0(Boolean.class) && !nj4VarX.g0(AtomicBoolean.class)) {
                return null;
            }
        }
        if (str.startsWith("is")) {
            return this.a ? f(2, str) : e(2, str);
        }
        return null;
    }

    public String c(String str) {
        String str2 = (String) this.c;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.a ? f(str2.length(), str) : e(str2.length(), str);
    }

    public String d(d9 d9Var, String str) {
        Method method = d9Var.E0;
        if (!str.startsWith("get")) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            Class<?> returnType = method.getReturnType();
            if (returnType.isArray()) {
                String name = returnType.getComponentType().getName();
                if (name.contains(".cglib") && (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib"))) {
                    return null;
                }
            }
        } else if ("getMetaClass".equals(str) && method.getReturnType().getName().startsWith("groovy.lang")) {
            return null;
        }
        return this.a ? f(3, str) : e(3, str);
    }
}
