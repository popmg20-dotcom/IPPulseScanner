package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public final class TcpDnsResponseEncoder extends MessageToMessageEncoder<DnsResponse> {
    private final DnsRecordEncoder encoder;

    public TcpDnsResponseEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.encoder = (DnsRecordEncoder) ObjectUtil.checkNotNull(dnsRecordEncoder, "encoder");
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, DnsResponse dnsResponse, List<Object> list) {
        ByteBuf byteBufIoBuffer = channelHandlerContext.alloc().ioBuffer(1024);
        byteBufIoBuffer.writerIndex(byteBufIoBuffer.writerIndex() + 2);
        DnsMessageUtil.encodeDnsResponse(this.encoder, dnsResponse, byteBufIoBuffer);
        byteBufIoBuffer.setShort(0, byteBufIoBuffer.readableBytes() - 2);
        list.add(byteBufIoBuffer);
    }

    public TcpDnsResponseEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, DnsResponse dnsResponse, List list) {
        encode2(channelHandlerContext, dnsResponse, (List<Object>) list);
    }
}
