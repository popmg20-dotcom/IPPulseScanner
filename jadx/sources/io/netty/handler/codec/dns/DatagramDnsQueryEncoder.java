package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.net.InetSocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public class DatagramDnsQueryEncoder extends MessageToMessageEncoder<AddressedEnvelope<DnsQuery, InetSocketAddress>> {
    private final DnsQueryEncoder encoder;

    public DatagramDnsQueryEncoder(DnsRecordEncoder dnsRecordEncoder) {
        this.encoder = new DnsQueryEncoder(dnsRecordEncoder);
    }

    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsQuery, InetSocketAddress> addressedEnvelope) {
        return channelHandlerContext.alloc().ioBuffer(1024);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsQuery, InetSocketAddress> addressedEnvelope, List<Object> list) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) addressedEnvelope.recipient();
        DnsQuery dnsQueryContent = addressedEnvelope.content();
        ByteBuf byteBufAllocateBuffer = allocateBuffer(channelHandlerContext, addressedEnvelope);
        try {
            this.encoder.encode(dnsQueryContent, byteBufAllocateBuffer);
            list.add(new DatagramPacket(byteBufAllocateBuffer, inetSocketAddress, null));
        } catch (Throwable th) {
            byteBufAllocateBuffer.release();
            throw th;
        }
    }

    public DatagramDnsQueryEncoder() {
        this(DnsRecordEncoder.DEFAULT);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, AddressedEnvelope<DnsQuery, InetSocketAddress> addressedEnvelope, List list) {
        encode2(channelHandlerContext, addressedEnvelope, (List<Object>) list);
    }
}
