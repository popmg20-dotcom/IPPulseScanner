package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sc5 {
    public final String a;
    public final boolean b;

    public sc5(String str, boolean z) {
        tj4.f(str);
        this.a = str;
        tj4.f("com.google.android.gms");
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sc5)) {
            return false;
        }
        sc5 sc5Var = (sc5) obj;
        return gb4.I(this.a, sc5Var.a) && gb4.I("com.google.android.gms", "com.google.android.gms") && gb4.I(null, null) && this.b == sc5Var.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, "com.google.android.gms", null, 4225, Boolean.valueOf(this.b)});
    }

    public final String toString() {
        String str = this.a;
        if (str != null) {
            return str;
        }
        tj4.i(null);
        throw null;
    }
}
