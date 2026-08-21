package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yo4 {
    public final String a;
    public final CharSequence b;
    public final String c;

    public yo4(String str, CharSequence charSequence, String str2) {
        str.getClass();
        str2.getClass();
        this.a = str;
        this.b = charSequence;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yo4)) {
            return false;
        }
        yo4 yo4Var = (yo4) obj;
        return n12.c(this.a, yo4Var.a) && this.b.equals(yo4Var.b) && n12.c(this.c, yo4Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("VersionInfo(versionName=");
        sb.append(this.a);
        sb.append(", relativeReleasedTime=");
        sb.append((Object) this.b);
        sb.append(", url=");
        return fw.y(sb, this.c, ")");
    }
}
