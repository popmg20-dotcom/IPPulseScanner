package defpackage;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vo2 {
    public final wo2 a;
    public final Inet4Address b;
    public final String c;
    public final InetSocketAddress d;
    public final int e;
    public final String f;

    public vo2(wo2 wo2Var, Inet4Address inet4Address, String str, InetSocketAddress inetSocketAddress, int i, String str2) {
        this.a = wo2Var;
        this.b = inet4Address;
        this.c = str;
        this.d = inetSocketAddress;
        this.e = i;
        this.f = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vo2)) {
            return false;
        }
        vo2 vo2Var = (vo2) obj;
        return this.a == vo2Var.a && n12.c(this.b, vo2Var.b) && n12.c(this.c, vo2Var.c) && n12.c(this.d, vo2Var.d) && this.e == vo2Var.e && n12.c(this.f, vo2Var.f);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Inet4Address inet4Address = this.b;
        int iHashCode2 = (iHashCode + (inet4Address == null ? 0 : inet4Address.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        InetSocketAddress inetSocketAddress = this.d;
        int iHashCode4 = (((iHashCode3 + (inetSocketAddress == null ? 0 : inetSocketAddress.hashCode())) * 31) + this.e) * 31;
        String str2 = this.f;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String hostAddress;
        InetAddress address;
        String hostAddress2;
        String str = "unknown";
        String str2 = this.c;
        if (str2 == null) {
            str2 = "unknown";
        }
        StringBuilder sb = new StringBuilder(ha0.o("Network interface: ", str2, "\n"));
        Inet4Address inet4Address = this.b;
        if (inet4Address == null || (hostAddress = inet4Address.getHostAddress()) == null) {
            hostAddress = "unknown";
        }
        sb.append("Local IP address: " + hostAddress + "\n");
        String str3 = this.f;
        if (str3 != null) {
            sb.append(str3 + " - Responsecode: " + this.e + "\n");
            return sb.toString();
        }
        switch (this.a.ordinal()) {
            case 0:
                sb.append("Firewall blocks UDP.\n");
                break;
            case 1:
                sb.append("Open access to the Internet.\n");
                break;
            case 2:
                sb.append("Full Cone NAT handles connections.\n");
                break;
            case 3:
                sb.append("Restricted Cone NAT handles connections.\n");
                break;
            case 4:
                sb.append("Port restricted Cone NAT handles connections.\n");
                break;
            case 5:
                sb.append("Symmetric Cone NAT handles connections.\n");
                break;
            case 6:
                sb.append("Symmetric UDP Firewall handles connections.\n");
                break;
            case 7:
                sb.append("Endpoint-Independent NAT (filtering type could not be determined).\n");
                break;
            default:
                g.d();
                return null;
        }
        InetSocketAddress inetSocketAddress = this.d;
        if (inetSocketAddress != null && (address = inetSocketAddress.getAddress()) != null && (hostAddress2 = address.getHostAddress()) != null) {
            str = hostAddress2;
        }
        sb.append("Public IP address: " + str + "\n");
        return sb.toString();
    }
}
