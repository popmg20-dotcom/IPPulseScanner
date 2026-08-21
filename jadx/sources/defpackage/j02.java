package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j02 {
    public final h02 a;

    public j02(h02 h02Var) {
        this.a = h02Var;
    }

    public static j02 a(Object obj) {
        if (obj == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 31 ? new j02(new i02(obj)) : new j02(new h02(obj));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j02)) {
            return false;
        }
        return this.a.equals(((j02) obj).a);
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    public final String toString() {
        return this.a.a.toString();
    }
}
