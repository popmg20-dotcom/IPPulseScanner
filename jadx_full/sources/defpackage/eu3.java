package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eu3 {
    public final String a;
    public final fu3 b;
    public final String c;

    public eu3(String str, fu3 fu3Var, String str2) {
        str.getClass();
        this.a = str;
        this.b = fu3Var;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eu3)) {
            return false;
        }
        eu3 eu3Var = (eu3) obj;
        return n12.c(this.a, eu3Var.a) && this.b == eu3Var.b && n12.c(this.c, eu3Var.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        String str = this.c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SettingSpec(key=");
        sb.append(this.a);
        sb.append(", type=");
        sb.append(this.b);
        sb.append(", enumName=");
        return fw.y(sb, this.c, ")");
    }
}
