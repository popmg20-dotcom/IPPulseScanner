package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class md3 {
    public final String a;
    public final String b;
    public final String c;

    public md3(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof md3)) {
            return false;
        }
        md3 md3Var = (md3) obj;
        return n12.c(this.a, md3Var.a) && n12.c(this.b, md3Var.b) && n12.c(this.c, md3Var.c);
    }

    public final int hashCode() {
        int iW = dw2.w(this.a.hashCode() * 31, 31, this.b);
        String str = this.c;
        return iW + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return fw.y(fw.E("RawFetchedContent(profileName=", this.a, ", content=", this.b, ", remoteName="), this.c, ")");
    }
}
