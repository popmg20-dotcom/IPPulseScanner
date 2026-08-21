package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oj3 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public oj3(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static oj3 a(oj3 oj3Var, String str, String str2, String str3, String str4, int i) {
        if ((i & 1) != 0) {
            str = oj3Var.a;
        }
        if ((i & 2) != 0) {
            str2 = oj3Var.b;
        }
        if ((i & 4) != 0) {
            str3 = oj3Var.c;
        }
        if ((i & 8) != 0) {
            str4 = oj3Var.d;
        }
        oj3Var.getClass();
        str.getClass();
        return new oj3(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oj3)) {
            return false;
        }
        oj3 oj3Var = (oj3) obj;
        return n12.c(this.a, oj3Var.a) && n12.c(this.b, oj3Var.b) && n12.c(this.c, oj3Var.c) && n12.c(this.d, oj3Var.d);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Query(keyword=", this.a, ", packageName=", this.b, ", proxy=");
        sbE.append(this.c);
        sbE.append(", rule=");
        sbE.append(this.d);
        sbE.append(")");
        return sbE.toString();
    }
}
