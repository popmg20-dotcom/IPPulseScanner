package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ir1 {
    public final String a;
    public final String b;

    public ir1(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ir1.class == obj.getClass()) {
            ir1 ir1Var = (ir1) obj;
            if (TextUtils.equals(this.a, ir1Var.a) && TextUtils.equals(this.b, ir1Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Header[name=");
        sb.append(this.a);
        sb.append(",value=");
        return fw.y(sb, this.b, "]");
    }
}
