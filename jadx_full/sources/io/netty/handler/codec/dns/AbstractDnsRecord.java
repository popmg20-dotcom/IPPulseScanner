package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.IDN;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDnsRecord implements DnsRecord {
    private final short dnsClass;
    private int hashCode;
    private final String name;
    private final long timeToLive;
    private final DnsRecordType type;

    public AbstractDnsRecord(String str, DnsRecordType dnsRecordType, int i, long j) {
        ObjectUtil.checkPositiveOrZero(j, "timeToLive");
        this.name = appendTrailingDot(IDNtoASCII(str));
        this.type = (DnsRecordType) ObjectUtil.checkNotNull(dnsRecordType, "type");
        this.dnsClass = (short) i;
        this.timeToLive = j;
    }

    private static String IDNtoASCII(String str) {
        ObjectUtil.checkNotNull(str, "name");
        return (PlatformDependent.isAndroid() && ".".equals(str)) ? str : IDN.toASCII(str);
    }

    private static String appendTrailingDot(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + (-1)) == '.') ? str : str.concat(".");
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public int dnsClass() {
        return this.dnsClass & 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DnsRecord)) {
            return false;
        }
        DnsRecord dnsRecord = (DnsRecord) obj;
        int i = this.hashCode;
        return (i == 0 || i == dnsRecord.hashCode()) && type().intValue() == dnsRecord.type().intValue() && dnsClass() == dnsRecord.dnsClass() && name().equals(dnsRecord.name());
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iDnsClass = dnsClass() + (type().intValue() * 31) + (this.name.hashCode() * 31);
        this.hashCode = iDnsClass;
        return iDnsClass;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public String name() {
        return this.name;
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public long timeToLive() {
        return this.timeToLive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append(name());
        sb.append(' ');
        sb.append(timeToLive());
        sb.append(' ');
        StringBuilder sbAppendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        sbAppendRecordClass.append(' ');
        sbAppendRecordClass.append(type().name());
        sbAppendRecordClass.append(')');
        return sb.toString();
    }

    @Override // io.netty.handler.codec.dns.DnsRecord
    public DnsRecordType type() {
        return this.type;
    }

    public AbstractDnsRecord(String str, DnsRecordType dnsRecordType, long j) {
        this(str, dnsRecordType, 1, j);
    }
}
