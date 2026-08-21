package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class DnsMessageUtil {

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public interface DnsQueryFactory {
        DnsQuery newQuery(int i, DnsOpCode dnsOpCode);
    }

    private DnsMessageUtil() {
    }

    private static StringBuilder appendAddresses(StringBuilder sb, DnsMessage dnsMessage) {
        if (dnsMessage instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) dnsMessage;
            SocketAddress socketAddressSender = addressedEnvelope.sender();
            if (socketAddressSender != null) {
                sb.append("from: ");
                sb.append(socketAddressSender);
                sb.append(", ");
            }
            SocketAddress socketAddressRecipient = addressedEnvelope.recipient();
            if (socketAddressRecipient != null) {
                sb.append("to: ");
                sb.append(socketAddressRecipient);
                sb.append(", ");
            }
        }
        return sb;
    }

    private static void appendAllRecords(StringBuilder sb, DnsMessage dnsMessage) {
        appendRecords(sb, dnsMessage, DnsSection.QUESTION);
        appendRecords(sb, dnsMessage, DnsSection.ANSWER);
        appendRecords(sb, dnsMessage, DnsSection.AUTHORITY);
        appendRecords(sb, dnsMessage, DnsSection.ADDITIONAL);
    }

    public static StringBuilder appendQuery(StringBuilder sb, DnsQuery dnsQuery) {
        appendQueryHeader(sb, dnsQuery);
        appendAllRecords(sb, dnsQuery);
        return sb;
    }

    private static void appendQueryHeader(StringBuilder sb, DnsQuery dnsQuery) {
        sb.append(StringUtil.simpleClassName(dnsQuery));
        sb.append('(');
        StringBuilder sbAppendAddresses = appendAddresses(sb, dnsQuery);
        sbAppendAddresses.append(dnsQuery.id());
        sbAppendAddresses.append(", ");
        sbAppendAddresses.append(dnsQuery.opCode());
        if (dnsQuery.isRecursionDesired()) {
            sb.append(", RD");
        }
        if (dnsQuery.z() != 0) {
            sb.append(", Z: ");
            sb.append(dnsQuery.z());
        }
        sb.append(')');
    }

    public static StringBuilder appendRecordClass(StringBuilder sb, int i) {
        int i2 = i & 65535;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 254 ? i2 != 255 ? null : "ANY" : "NONE" : "HESIOD" : "CHAOS" : "CSNET" : "IN";
        if (str != null) {
            sb.append(str);
            return sb;
        }
        sb.append("UNKNOWN(");
        sb.append(i2);
        sb.append(')');
        return sb;
    }

    private static void appendRecords(StringBuilder sb, DnsMessage dnsMessage, DnsSection dnsSection) {
        int iCount = dnsMessage.count(dnsSection);
        for (int i = 0; i < iCount; i++) {
            sb.append(StringUtil.NEWLINE);
            sb.append('\t');
            sb.append(dnsMessage.recordAt(dnsSection, i));
        }
    }

    public static StringBuilder appendResponse(StringBuilder sb, DnsResponse dnsResponse) {
        appendResponseHeader(sb, dnsResponse);
        appendAllRecords(sb, dnsResponse);
        return sb;
    }

    private static void appendResponseHeader(StringBuilder sb, DnsResponse dnsResponse) {
        boolean z;
        sb.append(StringUtil.simpleClassName(dnsResponse));
        sb.append('(');
        StringBuilder sbAppendAddresses = appendAddresses(sb, dnsResponse);
        sbAppendAddresses.append(dnsResponse.id());
        sbAppendAddresses.append(", ");
        sbAppendAddresses.append(dnsResponse.opCode());
        sbAppendAddresses.append(", ");
        sbAppendAddresses.append(dnsResponse.code());
        sbAppendAddresses.append(StringUtil.COMMA);
        boolean z2 = false;
        if (dnsResponse.isRecursionDesired()) {
            sb.append(" RD");
            z = false;
        } else {
            z = true;
        }
        if (dnsResponse.isAuthoritativeAnswer()) {
            sb.append(" AA");
            z = false;
        }
        if (dnsResponse.isTruncated()) {
            sb.append(" TC");
            z = false;
        }
        if (dnsResponse.isRecursionAvailable()) {
            sb.append(" RA");
        } else {
            z2 = z;
        }
        if (dnsResponse.z() != 0) {
            if (!z2) {
                sb.append(StringUtil.COMMA);
            }
            sb.append(" Z: ");
            sb.append(dnsResponse.z());
        }
        if (z2) {
            sb.setCharAt(sb.length() - 1, ')');
        } else {
            sb.append(')');
        }
    }

    public static DnsQuery decodeDnsQuery(DnsRecordDecoder dnsRecordDecoder, ByteBuf byteBuf, DnsQueryFactory dnsQueryFactory) {
        DnsQuery dnsQueryNewQuery = newQuery(byteBuf, dnsQueryFactory);
        try {
            int unsignedShort = byteBuf.readUnsignedShort();
            int unsignedShort2 = byteBuf.readUnsignedShort();
            int unsignedShort3 = byteBuf.readUnsignedShort();
            int unsignedShort4 = byteBuf.readUnsignedShort();
            decodeQuestions(dnsRecordDecoder, dnsQueryNewQuery, byteBuf, unsignedShort);
            decodeRecords(dnsRecordDecoder, dnsQueryNewQuery, DnsSection.ANSWER, byteBuf, unsignedShort2);
            decodeRecords(dnsRecordDecoder, dnsQueryNewQuery, DnsSection.AUTHORITY, byteBuf, unsignedShort3);
            decodeRecords(dnsRecordDecoder, dnsQueryNewQuery, DnsSection.ADDITIONAL, byteBuf, unsignedShort4);
            return dnsQueryNewQuery;
        } catch (Throwable th) {
            dnsQueryNewQuery.release();
            throw th;
        }
    }

    private static void decodeQuestions(DnsRecordDecoder dnsRecordDecoder, DnsQuery dnsQuery, ByteBuf byteBuf, int i) {
        while (i > 0) {
            dnsQuery.addRecord(DnsSection.QUESTION, (DnsRecord) dnsRecordDecoder.decodeQuestion(byteBuf));
            i--;
        }
    }

    private static void decodeRecords(DnsRecordDecoder dnsRecordDecoder, DnsQuery dnsQuery, DnsSection dnsSection, ByteBuf byteBuf, int i) {
        while (i > 0) {
            DnsRecord dnsRecordDecodeRecord = dnsRecordDecoder.decodeRecord(byteBuf);
            if (dnsRecordDecodeRecord == null) {
                return;
            }
            dnsQuery.addRecord(dnsSection, dnsRecordDecodeRecord);
            i--;
        }
    }

    public static void encodeDnsResponse(DnsRecordEncoder dnsRecordEncoder, DnsResponse dnsResponse, ByteBuf byteBuf) {
        try {
            encodeHeader(dnsResponse, byteBuf);
            encodeQuestions(dnsRecordEncoder, dnsResponse, byteBuf);
            encodeRecords(dnsRecordEncoder, dnsResponse, DnsSection.ANSWER, byteBuf);
            encodeRecords(dnsRecordEncoder, dnsResponse, DnsSection.AUTHORITY, byteBuf);
            encodeRecords(dnsRecordEncoder, dnsResponse, DnsSection.ADDITIONAL, byteBuf);
        } catch (Throwable th) {
            byteBuf.release();
            throw th;
        }
    }

    private static void encodeHeader(DnsResponse dnsResponse, ByteBuf byteBuf) {
        byteBuf.writeShort(dnsResponse.id());
        int iByteValue = (dnsResponse.opCode().byteValue() & 255) << 11;
        int i = 32768 | iByteValue;
        if (dnsResponse.isAuthoritativeAnswer()) {
            i = 33792 | iByteValue;
        }
        if (dnsResponse.isTruncated()) {
            i |= 512;
        }
        if (dnsResponse.isRecursionDesired()) {
            i |= 256;
        }
        if (dnsResponse.isRecursionAvailable()) {
            i |= 128;
        }
        byteBuf.writeShort((dnsResponse.z() << 4) | i | dnsResponse.code().intValue());
        byteBuf.writeShort(dnsResponse.count(DnsSection.QUESTION));
        byteBuf.writeShort(dnsResponse.count(DnsSection.ANSWER));
        byteBuf.writeShort(dnsResponse.count(DnsSection.AUTHORITY));
        byteBuf.writeShort(dnsResponse.count(DnsSection.ADDITIONAL));
    }

    private static void encodeQuestions(DnsRecordEncoder dnsRecordEncoder, DnsResponse dnsResponse, ByteBuf byteBuf) {
        int iCount = dnsResponse.count(DnsSection.QUESTION);
        for (int i = 0; i < iCount; i++) {
            dnsRecordEncoder.encodeQuestion((DnsQuestion) dnsResponse.recordAt(DnsSection.QUESTION, i), byteBuf);
        }
    }

    private static void encodeRecords(DnsRecordEncoder dnsRecordEncoder, DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf) {
        int iCount = dnsResponse.count(dnsSection);
        for (int i = 0; i < iCount; i++) {
            dnsRecordEncoder.encodeRecord(dnsResponse.recordAt(dnsSection, i), byteBuf);
        }
    }

    private static DnsQuery newQuery(ByteBuf byteBuf, DnsQueryFactory dnsQueryFactory) {
        int unsignedShort = byteBuf.readUnsignedShort();
        int unsignedShort2 = byteBuf.readUnsignedShort();
        if ((unsignedShort2 >> 15) == 1) {
            throw new CorruptedFrameException("not a query");
        }
        DnsQuery dnsQueryNewQuery = dnsQueryFactory.newQuery(unsignedShort, DnsOpCode.valueOf((byte) ((unsignedShort2 >> 11) & 15)));
        dnsQueryNewQuery.setRecursionDesired(((unsignedShort2 >> 8) & 1) == 1);
        dnsQueryNewQuery.setZ((unsignedShort2 >> 4) & 7);
        return dnsQueryNewQuery;
    }
}
