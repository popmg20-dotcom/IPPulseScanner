package defpackage;

import j$.util.Objects;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ft3 implements Serializable {
    public static final d72 z = d72.b;
    public final String b;
    public volatile char[] f;

    public ft3(String str) {
        Objects.requireNonNull(str, "Null String illegal for SerializedString");
        this.b = str;
    }

    public final char[] a() {
        char[] cArr = this.f;
        if (cArr != null) {
            return cArr;
        }
        d72 d72Var = z;
        String str = this.b;
        d72Var.getClass();
        char[] cArrA = d72.a(str);
        this.f = cArrA;
        return cArrA;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ft3.class) {
            return false;
        }
        return this.b.equals(((ft3) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b;
    }
}
