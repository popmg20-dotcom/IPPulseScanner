package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public final class TcpDnsQueryEncoder extends MessageToByteEncoder<DnsQuery> {
    private final DnsQueryEncoder encoder;

    public TcpDnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.encoder = new DnsQueryEncoder(dnsRecordEncoder);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, DnsQuery dnsQuery, boolean z) {
        return z ? channelHandlerContext.alloc().ioBuffer(1024) : channelHandlerContext.alloc().heapBuffer(1024);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, DnsQuery dnsQuery, ByteBuf byteBuf) {
        byteBuf.writerIndex(byteBuf.writerIndex() + 2);
        this.encoder.encode(dnsQuery, byteBuf);
        byteBuf.setShort(0, byteBuf.readableBytes() - 2);
    }

    public TcpDnsQueryEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }
}
