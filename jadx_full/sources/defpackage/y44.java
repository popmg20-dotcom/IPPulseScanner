package defpackage;

import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y44 {
    public final InetSocketAddress a;
    public final InetSocketAddress b;
    public final Integer c;
    public final String d;

    public y44(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, Integer num, String str) {
        this.a = inetSocketAddress;
        this.b = inetSocketAddress2;
        this.c = num;
        this.d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y44)) {
            return false;
        }
        y44 y44Var = (y44) obj;
        return n12.c(this.a, y44Var.a) && n12.c(this.b, y44Var.b) && n12.c(this.c, y44Var.c) && n12.c(this.d, y44Var.d);
    }

    public final int hashCode() {
        InetSocketAddress inetSocketAddress = this.a;
        int iHashCode = (inetSocketAddress == null ? 0 : inetSocketAddress.hashCode()) * 31;
        InetSocketAddress inetSocketAddress2 = this.b;
        int iHashCode2 = (iHashCode + (inetSocketAddress2 == null ? 0 : inetSocketAddress2.hashCode())) * 31;
        Integer num = this.c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.d;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "StunResponse(mappedAddress=" + this.a + ", otherAddress=" + this.b + ", errorCode=" + this.c + ", errorReason=" + this.d + ")";
    }
}
