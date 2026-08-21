package defpackage;

import io.netty.handler.codec.dns.DnsRecordType;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uw0 {
    public final String a;
    public final DnsRecordType b;

    public uw0(String str, DnsRecordType dnsRecordType) {
        this.a = str;
        this.b = dnsRecordType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uw0)) {
            return false;
        }
        uw0 uw0Var = (uw0) obj;
        return this.a.equals(uw0Var.a) && this.b.equals(uw0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "CacheKey(domain=" + this.a + ", type=" + this.b + ")";
    }
}
