package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDnsRecordDecoder implements DnsRecordDecoder {
    static final String ROOT = ".";

    public static String decodeName(ByteBuf byteBuf) {
        return DnsCodecUtil.decodeDomainName(byteBuf);
    }

    public String decodeName0(ByteBuf byteBuf) {
        return decodeName(byteBuf);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordDecoder
    public final DnsQuestion decodeQuestion(ByteBuf byteBuf) {
        return new DefaultDnsQuestion(decodeName(byteBuf), DnsRecordType.valueOf(byteBuf.readUnsignedShort()), byteBuf.readUnsignedShort());
    }

    public DnsRecord decodeRecord(String str, DnsRecordType dnsRecordType, int i, long j, ByteBuf byteBuf, int i2, int i3) {
        return dnsRecordType == DnsRecordType.PTR ? new DefaultDnsPtrRecord(str, i, j, decodeName0(byteBuf.duplicate().setIndex(i2, i3 + i2))) : (dnsRecordType == DnsRecordType.CNAME || dnsRecordType == DnsRecordType.NS) ? new DefaultDnsRawRecord(str, dnsRecordType, i, j, DnsCodecUtil.decompressDomainName(byteBuf.duplicate().setIndex(i2, i3 + i2))) : new DefaultDnsRawRecord(str, dnsRecordType, i, j, byteBuf.retainedDuplicate().setIndex(i2, i3 + i2));
    }

    @Override // io.netty.handler.codec.dns.DnsRecordDecoder
    public final <T extends DnsRecord> T decodeRecord(ByteBuf byteBuf) {
        int i = byteBuf.readerIndex();
        String strDecodeName = decodeName(byteBuf);
        int iWriterIndex = byteBuf.writerIndex();
        if (iWriterIndex - byteBuf.readerIndex() < 10) {
            byteBuf.readerIndex(i);
            return null;
        }
        DnsRecordType dnsRecordTypeValueOf = DnsRecordType.valueOf(byteBuf.readUnsignedShort());
        int unsignedShort = byteBuf.readUnsignedShort();
        long unsignedInt = byteBuf.readUnsignedInt();
        int unsignedShort2 = byteBuf.readUnsignedShort();
        int i2 = byteBuf.readerIndex();
        if (iWriterIndex - i2 < unsignedShort2) {
            byteBuf.readerIndex(i);
            return null;
        }
        T t = (T) decodeRecord(strDecodeName, dnsRecordTypeValueOf, unsignedShort, unsignedInt, byteBuf, i2, unsignedShort2);
        byteBuf.readerIndex(i2 + unsignedShort2);
        return t;
    }
}
