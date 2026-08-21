package io.netty.handler.codec.dns;

import defpackage.dw2;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDnsRecordEncoder implements DnsRecordEncoder {
    private static final int PREFIX_MASK = 7;

    public static int calculateEcsAddressLength(int i, int i2) {
        return (i >>> 3) + (i2 != 0 ? 1 : 0);
    }

    private void encodeOptEcsRecord(DnsOptEcsRecord dnsOptEcsRecord, ByteBuf byteBuf) {
        encodeRecord0(dnsOptEcsRecord, byteBuf);
        int iSourcePrefixLength = dnsOptEcsRecord.sourcePrefixLength();
        int iScopePrefixLength = dnsOptEcsRecord.scopePrefixLength();
        int i = iSourcePrefixLength & 7;
        byte[] bArrAddress = dnsOptEcsRecord.address();
        int length = bArrAddress.length << 3;
        if (length < iSourcePrefixLength || iSourcePrefixLength < 0) {
            throw new IllegalArgumentException(iSourcePrefixLength + ": " + iSourcePrefixLength + " (expected: 0 >= " + length + ')');
        }
        short sAddressNumber = (short) (bArrAddress.length == 4 ? InternetProtocolFamily.IPv4 : InternetProtocolFamily.IPv6).addressNumber();
        int iCalculateEcsAddressLength = calculateEcsAddressLength(iSourcePrefixLength, i);
        byteBuf.writeShort(iCalculateEcsAddressLength + 8);
        byteBuf.writeShort(8);
        byteBuf.writeShort(iCalculateEcsAddressLength + 4);
        byteBuf.writeShort(sAddressNumber);
        byteBuf.writeByte(iSourcePrefixLength);
        byteBuf.writeByte(iScopePrefixLength);
        if (i <= 0) {
            byteBuf.writeBytes(bArrAddress, 0, iCalculateEcsAddressLength);
            return;
        }
        int i2 = iCalculateEcsAddressLength - 1;
        byteBuf.writeBytes(bArrAddress, 0, i2);
        byteBuf.writeByte(padWithZeros(bArrAddress[i2], i));
    }

    private void encodeOptPseudoRecord(DnsOptPseudoRecord dnsOptPseudoRecord, ByteBuf byteBuf) {
        encodeRecord0(dnsOptPseudoRecord, byteBuf);
        byteBuf.writeShort(0);
    }

    private void encodePtrRecord(DnsPtrRecord dnsPtrRecord, ByteBuf byteBuf) {
        encodeRecord0(dnsPtrRecord, byteBuf);
        encodeName(dnsPtrRecord.hostname(), byteBuf);
    }

    private void encodeRawRecord(DnsRawRecord dnsRawRecord, ByteBuf byteBuf) {
        encodeRecord0(dnsRawRecord, byteBuf);
        ByteBuf byteBufContent = dnsRawRecord.content();
        int i = byteBufContent.readableBytes();
        byteBuf.writeShort(i);
        byteBuf.writeBytes(byteBufContent, byteBufContent.readerIndex(), i);
    }

    private void encodeRecord0(DnsRecord dnsRecord, ByteBuf byteBuf) {
        encodeName(dnsRecord.name(), byteBuf);
        byteBuf.writeShort(dnsRecord.type().intValue());
        byteBuf.writeShort(dnsRecord.dnsClass());
        byteBuf.writeInt((int) dnsRecord.timeToLive());
    }

    private static byte padWithZeros(byte b, int i) {
        switch (i) {
            case 0:
                return (byte) 0;
            case 1:
                return (byte) (b & 128);
            case 2:
                return (byte) (b & 192);
            case 3:
                return (byte) (b & 224);
            case 4:
                return (byte) (b & 240);
            case 5:
                return (byte) (b & 248);
            case 6:
                return (byte) (b & 252);
            case 7:
                return (byte) (b & 254);
            case 8:
                return b;
            default:
                xe.k(dw2.A(i, "lowOrderBitsToPreserve: "));
                return (byte) 0;
        }
    }

    public void encodeName(String str, ByteBuf byteBuf) {
        DnsCodecUtil.encodeDomainName(str, byteBuf);
    }

    @Override // io.netty.handler.codec.dns.DnsRecordEncoder
    public final void encodeQuestion(DnsQuestion dnsQuestion, ByteBuf byteBuf) {
        encodeName(dnsQuestion.name(), byteBuf);
        byteBuf.writeShort(dnsQuestion.type().intValue());
        byteBuf.writeShort(dnsQuestion.dnsClass());
    }

    @Override // io.netty.handler.codec.dns.DnsRecordEncoder
    public void encodeRecord(DnsRecord dnsRecord, ByteBuf byteBuf) {
        if (dnsRecord instanceof DnsQuestion) {
            encodeQuestion((DnsQuestion) dnsRecord, byteBuf);
            return;
        }
        if (dnsRecord instanceof DnsPtrRecord) {
            encodePtrRecord((DnsPtrRecord) dnsRecord, byteBuf);
            return;
        }
        if (dnsRecord instanceof DnsOptEcsRecord) {
            encodeOptEcsRecord((DnsOptEcsRecord) dnsRecord, byteBuf);
        } else if (dnsRecord instanceof DnsOptPseudoRecord) {
            encodeOptPseudoRecord((DnsOptPseudoRecord) dnsRecord, byteBuf);
        } else {
            if (!(dnsRecord instanceof DnsRawRecord)) {
                throw new UnsupportedMessageTypeException(StringUtil.simpleClassName(dnsRecord));
            }
            encodeRawRecord((DnsRawRecord) dnsRecord, byteBuf);
        }
    }
}
