package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sj2 {
    public static final Class[] c = new Class[0];
    public final String a;
    public final Class[] b;

    public sj2(Method method) {
        this(method.getName(), method.getParameterTypes().length > 0 ? method.getParameterTypes() : c);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != sj2.class) {
            return false;
        }
        sj2 sj2Var = (sj2) obj;
        if (!this.a.equals(sj2Var.a)) {
            return false;
        }
        Class[] clsArr = sj2Var.b;
        Class[] clsArr2 = this.b;
        int length = clsArr2.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (clsArr[i] != clsArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode() + this.b.length;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("(");
        return fw.w("-args)", sb, this.b.length);
    }

    public sj2(Constructor constructor) {
        this("", constructor.getParameterCount() > 0 ? constructor.getParameterTypes() : c);
    }

    public sj2(String str, Class[] clsArr) {
        this.a = str;
        this.b = clsArr == null ? c : clsArr;
    }
}
