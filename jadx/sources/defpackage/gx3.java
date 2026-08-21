package defpackage;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gx3 implements ea1 {
    public final String a;
    public final Uri b;
    public final long c;

    public gx3(String str, Uri uri, long j) {
        str.getClass();
        this.a = str;
        this.b = uri;
        this.c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gx3)) {
            return false;
        }
        gx3 gx3Var = (gx3) obj;
        return n12.c(this.a, gx3Var.a) && this.b.equals(gx3Var.b) && this.c == gx3Var.c;
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        long j = this.c;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SimplePolicyPath(url=");
        sb.append(this.a);
        sb.append(", uri=");
        sb.append(this.b);
        sb.append(", updateTime=");
        return dw2.C(sb, ")", this.c);
    }
}
