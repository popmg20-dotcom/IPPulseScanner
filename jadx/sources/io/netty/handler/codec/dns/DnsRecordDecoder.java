package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface DnsRecordDecoder {
    public static final DnsRecordDecoder DEFAULT = new DefaultDnsRecordDecoder();

    DnsQuestion decodeQuestion(ByteBuf byteBuf);

    <T extends DnsRecord> T decodeRecord(ByteBuf byteBuf);
}
