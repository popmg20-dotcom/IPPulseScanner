package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class aa1 {
    public final String a;
    public final String b;
    public long c;
    public int d;
    public final ea1 e;

    public aa1(String str, String str2, long j, ea1 ea1Var) {
        str.getClass();
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = 1;
        this.e = ea1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aa1)) {
            return false;
        }
        aa1 aa1Var = (aa1) obj;
        return n12.c(this.a, aa1Var.a) && this.b.equals(aa1Var.b) && this.c == aa1Var.c && this.d == aa1Var.d && this.e.equals(aa1Var.e);
    }

    public final int hashCode() {
        int iW = dw2.w(this.a.hashCode() * 31, 31, this.b);
        long j = this.c;
        return this.e.hashCode() + ((((iW + ((int) (j ^ (j >>> 32)))) * 31) + this.d) * 31);
    }

    public final String toString() {
        long j = this.c;
        int i = this.d;
        StringBuilder sbE = fw.E("ExternalResource(url=", this.a, ", displayUrl=", this.b, ", updateTime=");
        sbE.append(j);
        sbE.append(", referenceCount=");
        sbE.append(i);
        sbE.append(", origin=");
        sbE.append(this.e);
        sbE.append(")");
        return sbE.toString();
    }
}
