package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class DnsQueryEncoder {
    private final DnsRecordEncoder recordEncoder;

    public DnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.recordEncoder = (DnsRecordEncoder) ObjectUtil.checkNotNull(dnsRecordEncoder, "recordEncoder");
    }

    private static void encodeHeader(DnsQuery dnsQuery, ByteBuf byteBuf) {
        byteBuf.writeShort(dnsQuery.id());
        int iByteValue = (dnsQuery.opCode().byteValue() & 255) << 14;
        if (dnsQuery.isRecursionDesired()) {
            iByteValue |= 256;
        }
        byteBuf.writeShort(iByteValue);
        byteBuf.writeShort(dnsQuery.count(DnsSection.QUESTION));
        byteBuf.writeShort(0);
        byteBuf.writeShort(0);
        byteBuf.writeShort(dnsQuery.count(DnsSection.ADDITIONAL));
    }

    private void encodeQuestions(DnsQuery dnsQuery, ByteBuf byteBuf) {
        int iCount = dnsQuery.count(DnsSection.QUESTION);
        for (int i = 0; i < iCount; i++) {
            this.recordEncoder.encodeQuestion((DnsQuestion) dnsQuery.recordAt(DnsSection.QUESTION, i), byteBuf);
        }
    }

    private void encodeRecords(DnsQuery dnsQuery, DnsSection dnsSection, ByteBuf byteBuf) {
        int iCount = dnsQuery.count(dnsSection);
        for (int i = 0; i < iCount; i++) {
            this.recordEncoder.encodeRecord(dnsQuery.recordAt(dnsSection, i), byteBuf);
        }
    }

    public void encode(DnsQuery dnsQuery, ByteBuf byteBuf) {
        encodeHeader(dnsQuery, byteBuf);
        encodeQuestions(dnsQuery, byteBuf);
        encodeRecords(dnsQuery, DnsSection.ADDITIONAL, byteBuf);
    }
}
