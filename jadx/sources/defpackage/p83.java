package defpackage;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p83 implements Serializable {
    public static final p83 A = new p83("", null);
    public static final p83 X = new p83(new String(""), null);
    public final String b;
    public final String f;
    public ft3 z;

    public p83(String str, String str2) {
        Annotation[] annotationArr = n50.a;
        this.b = str == null ? "" : str;
        this.f = str2;
    }

    public static p83 a(String str) {
        return (str == null || str.isEmpty()) ? A : new p83(f12.f.a(str), null);
    }

    public static p83 b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        return (str2 == null && str.isEmpty()) ? A : new p83(f12.f.a(str), str2);
    }

    public final boolean c() {
        return this.f == null && this.b.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != p83.class) {
            return false;
        }
        p83 p83Var = (p83) obj;
        String str = p83Var.b;
        String str2 = this.b;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        String str3 = p83Var.f;
        String str4 = this.f;
        return str4 == null ? str3 == null : str4.equals(str3);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f) + (Objects.hashCode(this.b) * 31);
    }

    public final String toString() {
        String str = this.b;
        String str2 = this.f;
        if (str2 == null) {
            return str;
        }
        return "{" + str2 + "}" + str;
    }
}
