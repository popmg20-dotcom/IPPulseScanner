package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lz1 {
    public final String a;
    public volatile kz1 b;
    public volatile e03 c;
    public volatile String d;
    public final long e;

    public lz1(String str) {
        kz1 kz1Var = kz1.b;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.a = str;
        this.b = kz1Var;
        this.c = null;
        this.d = null;
        this.e = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lz1)) {
            return false;
        }
        lz1 lz1Var = (lz1) obj;
        return this.a.equals(lz1Var.a) && this.b == lz1Var.b && n12.c(this.c, lz1Var.c) && n12.c(this.d, lz1Var.d) && this.e == lz1Var.e;
    }

    public final int hashCode() {
        int iHashCode = (((((this.b.hashCode() + (this.a.hashCode() * 31)) * 31) + (this.c == null ? 0 : this.c.hashCode())) * 31) + (this.d != null ? this.d.hashCode() : 0)) * 31;
        long j = this.e;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str = this.a;
        kz1 kz1Var = this.b;
        e03 e03Var = this.c;
        String str2 = this.d;
        long j = this.e;
        StringBuilder sb = new StringBuilder("ImportTask(taskId=");
        sb.append(str);
        sb.append(", status=");
        sb.append(kz1Var);
        sb.append(", result=");
        sb.append(e03Var);
        sb.append(", error=");
        sb.append(str2);
        sb.append(", createdAt=");
        return dw2.C(sb, ")", j);
    }
}
