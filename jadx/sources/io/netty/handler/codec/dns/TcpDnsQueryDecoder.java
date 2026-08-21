package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.dns.DnsMessageUtil;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class TcpDnsQueryDecoder extends LengthFieldBasedFrameDecoder {
    private final DnsRecordDecoder decoder;

    public TcpDnsQueryDecoder(DnsRecordDecoder dnsRecordDecoder, int i) {
        super(i, 0, 2, 0, 2);
        this.decoder = (DnsRecordDecoder) ObjectUtil.checkNotNull(dnsRecordDecoder, "decoder");
    }

    @Override // io.netty.handler.codec.LengthFieldBasedFrameDecoder
    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        ByteBuf byteBuf2 = (ByteBuf) super.decode(channelHandlerContext, byteBuf);
        if (byteBuf2 == null) {
            return null;
        }
        return DnsMessageUtil.decodeDnsQuery(this.decoder, byteBuf2.slice(), new DnsMessageUtil.DnsQueryFactory() { // from class: io.netty.handler.codec.dns.TcpDnsQueryDecoder.1
            @Override // io.netty.handler.codec.dns.DnsMessageUtil.DnsQueryFactory
            public DnsQuery newQuery(int i, DnsOpCode dnsOpCode) {
                return new DefaultDnsQuery(i, dnsOpCode);
            }
        });
    }

    public TcpDnsQueryDecoder() {
        this(DnsRecordDecoder.DEFAULT, 65535);
    }
}
