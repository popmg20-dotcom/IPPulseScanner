package io.netty.handler.codec.dns;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.dns.DnsMessageUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public class DatagramDnsQueryDecoder extends MessageToMessageDecoder<DatagramPacket> {
    private final DnsRecordDecoder recordDecoder;

    public DatagramDnsQueryDecoder(DnsRecordDecoder dnsRecordDecoder) {
        this.recordDecoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "recordDecoder");
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(ChannelHandlerContext channelHandlerContext, final DatagramPacket datagramPacket, List<Object> list) {
        list.add(DnsMessageUtil.decodeDnsQuery(this.recordDecoder, datagramPacket.content(), new DnsMessageUtil.DnsQueryFactory() { // from class: io.netty.handler.codec.dns.DatagramDnsQueryDecoder.1
            @Override // io.netty.handler.codec.dns.DnsMessageUtil.DnsQueryFactory
            public DnsQuery newQuery(int i, DnsOpCode dnsOpCode) {
                return new DatagramDnsQuery(datagramPacket.sender(), datagramPacket.recipient(), i, dnsOpCode);
            }
        }));
    }

    public DatagramDnsQueryDecoder() {
        this(DnsRecordDecoder.DEFAULT);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List list) {
        decode2(channelHandlerContext, datagramPacket, (List<Object>) list);
    }
}
