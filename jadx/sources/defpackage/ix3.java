package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ix3 implements ea1 {
    public final String a;
    public final Uri b;
    public final long c;

    public ix3(String str, Uri uri, long j) {
        str.getClass();
        this.a = str;
        this.b = uri;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ix3)) {
            return false;
        }
        ix3 ix3Var = (ix3) obj;
        return n12.c(this.a, ix3Var.a) && this.b.equals(ix3Var.b) && this.c == ix3Var.c;
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        long j = this.c;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SimpleRuleSet(url=");
        sb.append(this.a);
        sb.append(", uri=");
        sb.append(this.b);
        sb.append(", updateTime=");
        return dw2.C(sb, ")", this.c);
    }
}
