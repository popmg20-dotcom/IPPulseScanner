package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zi3 {
    public final int a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public zi3(int i, long j, String str, String str2, String str3, String str4) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.a = i;
        this.b = j;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zi3)) {
            return false;
        }
        zi3 zi3Var = (zi3) obj;
        return this.a == zi3Var.a && this.b == zi3Var.b && n12.c(this.c, zi3Var.c) && n12.c(this.d, zi3Var.d) && n12.c(this.e, zi3Var.e) && n12.c(this.f, zi3Var.f);
    }

    public final int hashCode() {
        int i = this.a * 31;
        long j = this.b;
        return this.f.hashCode() + dw2.w(dw2.w(dw2.w((i + ((int) (j ^ (j >>> 32)))) * 31, 31, this.c), 31, this.d), 31, this.e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request(id=");
        sb.append(this.a);
        sb.append(", time=");
        sb.append(this.b);
        ha0.v(sb, ", packageName=", this.c, ", proxy=", this.d);
        ha0.v(sb, ", rule=", this.e, ", server=", this.f);
        sb.append(")");
        return sb.toString();
    }
}
