package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDnsOptPseudoRrRecord extends AbstractDnsRecord implements DnsOptPseudoRecord {
    public AbstractDnsOptPseudoRrRecord(int i, int i2, int i3) {
        super("", DnsRecordType.OPT, i, packIntoLong(i2, i3));
    }

    private static long packIntoLong(int i, int i2) {
        return (((long) ((i2 & DnsRecord.CLASS_ANY) << 16)) | ((((long) i) & 255) << 24)) & 4294967295L;
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int extendedRcode() {
        return (short) ((((int) timeToLive()) >> 24) & DnsRecord.CLASS_ANY);
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int flags() {
        return (short) (((short) timeToLive()) & 255);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        return toStringBuilder().toString();
    }

    public final StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(OPT flags:");
        sb.append(flags());
        sb.append(" version:");
        sb.append(version());
        sb.append(" extendedRecode:");
        sb.append(extendedRcode());
        sb.append(" udp:");
        sb.append(dnsClass());
        sb.append(')');
        return sb;
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int version() {
        return (short) ((((int) timeToLive()) >> 16) & DnsRecord.CLASS_ANY);
    }

    public AbstractDnsOptPseudoRrRecord(int i) {
        super("", DnsRecordType.OPT, i, 0L);
    }
}
