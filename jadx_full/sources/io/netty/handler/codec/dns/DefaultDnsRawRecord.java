package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDnsRawRecord extends AbstractDnsRecord implements DnsRawRecord {
    private final ByteBuf content;

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, int i, long j, ByteBuf byteBuf) {
        super(str, dnsRecordType, i, j);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return content().refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return content().release();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord replace(ByteBuf byteBuf) {
        return new DefaultDnsRawRecord(name(), type(), dnsClass(), timeToLive(), byteBuf);
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord retain() {
        content().retain();
        return this;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        DnsRecordType dnsRecordTypeType = type();
        if (dnsRecordTypeType != DnsRecordType.OPT) {
            sb.append(name().isEmpty() ? "<root>" : name());
            sb.append(' ');
            sb.append(timeToLive());
            sb.append(' ');
            StringBuilder sbAppendRecordClass = DnsMessageUtil.appendRecordClass(sb, dnsClass());
            sbAppendRecordClass.append(' ');
            sbAppendRecordClass.append(dnsRecordTypeType.name());
        } else {
            sb.append("OPT flags:");
            sb.append(timeToLive());
            sb.append(" udp:");
            sb.append(dnsClass());
        }
        sb.append(' ');
        sb.append(content().readableBytes());
        sb.append("B)");
        return sb.toString();
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord touch() {
        content().touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return content().release(i);
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord retain(int i) {
        content().retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord touch(Object obj) {
        content().touch(obj);
        return this;
    }

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, long j, ByteBuf byteBuf) {
        this(str, dnsRecordType, 1, j, byteBuf);
    }
}
