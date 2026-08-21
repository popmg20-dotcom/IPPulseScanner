package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
abstract class DnsResponseDecoder<A extends SocketAddress> {
    private final DnsRecordDecoder recordDecoder;

    public DnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.recordDecoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "recordDecoder");
    }

    private void decodeQuestions(DnsResponse dnsResponse, ByteBuf byteBuf, int i) {
        while (i > 0) {
            dnsResponse.addRecord(DnsSection.QUESTION, (DnsRecord) this.recordDecoder.decodeQuestion(byteBuf));
            i--;
        }
    }

    private boolean decodeRecords(DnsResponse dnsResponse, DnsSection dnsSection, ByteBuf byteBuf, int i) {
        while (i > 0) {
            DnsRecord dnsRecordDecodeRecord = this.recordDecoder.decodeRecord(byteBuf);
            if (dnsRecordDecodeRecord == null) {
                return false;
            }
            dnsResponse.addRecord(dnsSection, dnsRecordDecodeRecord);
            i--;
        }
        return true;
    }

    public final DnsResponse decode(A a, A a2, ByteBuf byteBuf) {
        int unsignedShort = byteBuf.readUnsignedShort();
        int unsignedShort2 = byteBuf.readUnsignedShort();
        if ((unsignedShort2 >> 15) == 0) {
            throw new CorruptedFrameException("not a response");
        }
        DnsResponse dnsResponseNewResponse = newResponse(a, a2, unsignedShort, DnsOpCode.valueOf((byte) ((unsignedShort2 >> 11) & 15)), DnsResponseCode.valueOf((byte) (unsignedShort2 & 15)));
        dnsResponseNewResponse.setRecursionDesired(((unsignedShort2 >> 8) & 1) == 1);
        dnsResponseNewResponse.setAuthoritativeAnswer(((unsignedShort2 >> 10) & 1) == 1);
        dnsResponseNewResponse.setTruncated(((unsignedShort2 >> 9) & 1) == 1);
        dnsResponseNewResponse.setRecursionAvailable(((unsignedShort2 >> 7) & 1) == 1);
        dnsResponseNewResponse.setZ((unsignedShort2 >> 4) & 7);
        try {
            int unsignedShort3 = byteBuf.readUnsignedShort();
            int unsignedShort4 = byteBuf.readUnsignedShort();
            int unsignedShort5 = byteBuf.readUnsignedShort();
            int unsignedShort6 = byteBuf.readUnsignedShort();
            decodeQuestions(dnsResponseNewResponse, byteBuf, unsignedShort3);
            if (!decodeRecords(dnsResponseNewResponse, DnsSection.ANSWER, byteBuf, unsignedShort4) || !decodeRecords(dnsResponseNewResponse, DnsSection.AUTHORITY, byteBuf, unsignedShort5)) {
                return dnsResponseNewResponse;
            }
            decodeRecords(dnsResponseNewResponse, DnsSection.ADDITIONAL, byteBuf, unsignedShort6);
            return dnsResponseNewResponse;
        } catch (Throwable th) {
            dnsResponseNewResponse.release();
            throw th;
        }
    }

    public abstract DnsResponse newResponse(A a, A a2, int i, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode);
}
