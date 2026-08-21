package io.netty.handler.codec.dns;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.net.InetSocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public class DatagramDnsResponseDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final DnsResponseDecoder<InetSocketAddress> responseDecoder;

    public DatagramDnsResponseDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.responseDecoder = new DnsResponseDecoder<InetSocketAddress>(dnsRecordDecoder) { // from class: io.netty.handler.codec.dns.DatagramDnsResponseDecoder.1
            @Override // io.netty.handler.codec.dns.DnsResponseDecoder
            public DnsResponse newResponse(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, int i, DnsOpCode dnsOpCode, DnsResponseCode dnsResponseCode) {
                return new DatagramDnsResponse(inetSocketAddress, inetSocketAddress2, i, dnsOpCode, dnsResponseCode);
            }
        };
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) {
        try {
            list.add(decodeResponse(channelHandlerContext, datagramPacket));
        } catch (IndexOutOfBoundsException e) {
            throw new CorruptedFrameException("Unable to decode response", e);
        }
    }

    public DnsResponse decodeResponse(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) {
        return this.responseDecoder.decode(datagramPacket.sender(), datagramPacket.recipient(), datagramPacket.content());
    }

    public DatagramDnsResponseDecoder() {
        this(DnsRecordDecoder.DEFAULT);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List list) {
        decode2(channelHandlerContext, datagramPacket, (List<Object>) list);
    }
}
