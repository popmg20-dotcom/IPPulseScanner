package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDnsPtrRecord extends AbstractDnsRecord implements DnsPtrRecord {
    private final String hostname;

    public DefaultDnsPtrRecord(String str, int i, long j, String str2) {
        super(str, DnsRecordType.PTR, i, j);
        this.hostname = (String) ObjectUtil.checkNotNull(str2, "hostname");
    }

    @Override // io.netty.handler.codec.dns.DnsPtrRecord
    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        DnsRecordType dnsRecordTypeType = type();
        sb.append(name().isEmpty() ? "<root>" : name());
        sb.append(' ');
        sb.append(timeToLive());
        sb.append(' ');
        StringBuilder sbAppendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        sbAppendRecordClass.append(' ');
        sbAppendRecordClass.append(dnsRecordTypeType.name());
        sb.append(' ');
        sb.append(this.hostname);
        return sb.toString();
    }
}
