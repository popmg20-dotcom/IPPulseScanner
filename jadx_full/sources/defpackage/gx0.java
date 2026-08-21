package defpackage;

import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gx0 {
    public final long a;
    public final String b;
    public final InetAddress c;

    public gx0(long j, String str, InetAddress inetAddress) {
        str.getClass();
        inetAddress.getClass();
        this.a = j;
        this.b = str;
        this.c = inetAddress;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!gx0.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        gx0 gx0Var = (gx0) obj;
        return n12.c(this.b, gx0Var.b) && n12.c(this.c, gx0Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "DomainRecord(validIn=" + this.a + ", domain=" + this.b + ", address=" + this.c + ")";
    }
}
