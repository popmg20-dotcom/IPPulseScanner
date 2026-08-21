package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sa3 {
    public final String a;
    public final String b;
    public final String c;

    public sa3(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sa3)) {
            return false;
        }
        sa3 sa3Var = (sa3) obj;
        return n12.c(this.a, sa3Var.a) && n12.c(this.b, sa3Var.b) && n12.c(this.c, sa3Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + dw2.w(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return fw.y(fw.E("ProxyGroupSelection(profileName=", this.a, ", groupName=", this.b, ", selection="), this.c, ")");
    }
}
