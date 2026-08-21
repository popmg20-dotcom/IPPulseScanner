package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDnsQuestion extends AbstractDnsRecord implements DnsQuestion {
    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType, int i) {
        super(str, dnsRecordType, i, 0L);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append(name());
        sb.append(' ');
        StringBuilder sbAppendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
        sbAppendRecordClass.append(' ');
        sbAppendRecordClass.append(type().name());
        sbAppendRecordClass.append(')');
        return sb.toString();
    }

    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType) {
        super(str, dnsRecordType, 0L);
    }
}
