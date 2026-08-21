package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ha3 {
    public final String a;
    public final int b;
    public final boolean c;

    public ha3(String str, int i, boolean z) {
        this.a = str;
        this.b = i;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ha3)) {
            return false;
        }
        ha3 ha3Var = (ha3) obj;
        return this.a.equals(ha3Var.a) && this.b == ha3Var.b && this.c == ha3Var.c;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + (this.c ? 1231 : 1237);
    }

    public final String toString() {
        return "ProxyConfig(tag=" + this.a + ", port=" + this.b + ", supportUDP=" + this.c + ")";
    }
}
