package io.netty.handler.proxy;

import defpackage.fw;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest;
import io.netty.handler.codec.socksx.v4.Socks4ClientDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ClientEncoder;
import io.netty.handler.codec.socksx.v4.Socks4CommandResponse;
import io.netty.handler.codec.socksx.v4.Socks4CommandStatus;
import io.netty.handler.codec.socksx.v4.Socks4CommandType;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Socks4ProxyHandler extends ProxyHandler {
    private static final String AUTH_USERNAME = "username";
    private static final String PROTOCOL = "socks4";
    private String decoderName;
    private String encoderName;
    private final String username;

    public Socks4ProxyHandler(SocketAddress socketAddress, String str) {
        super(socketAddress);
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.username = str;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void addCodec(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
        String strName = channelHandlerContext.name();
        Socks4ClientDecoder socks4ClientDecoder = new Socks4ClientDecoder();
        channelPipelinePipeline.addBefore(strName, null, socks4ClientDecoder);
        this.decoderName = channelPipelinePipeline.context(socks4ClientDecoder).name();
        String strY = fw.y(new StringBuilder(), this.decoderName, ".encoder");
        this.encoderName = strY;
        channelPipelinePipeline.addBefore(strName, strY, Socks4ClientEncoder.INSTANCE);
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public String authScheme() {
        return this.username != null ? AUTH_USERNAME : "none";
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public boolean handleResponse(ChannelHandlerContext channelHandlerContext, Object obj) throws ProxyConnectException {
        Socks4CommandStatus socks4CommandStatusStatus = ((Socks4CommandResponse) obj).status();
        if (socks4CommandStatusStatus == Socks4CommandStatus.SUCCESS) {
            return true;
        }
        throw new ProxyConnectException(exceptionMessage("status: " + socks4CommandStatusStatus));
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public Object newInitialMessage(ChannelHandlerContext channelHandlerContext) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) destinationAddress();
        String hostString = inetSocketAddress.isUnresolved() ? inetSocketAddress.getHostString() : inetSocketAddress.getAddress().getHostAddress();
        Socks4CommandType socks4CommandType = Socks4CommandType.CONNECT;
        int port = inetSocketAddress.getPort();
        String str = this.username;
        if (str == null) {
            str = "";
        }
        return new DefaultSocks4CommandRequest(socks4CommandType, hostString, port, str);
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public String protocol() {
        return PROTOCOL;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void removeDecoder(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this.decoderName);
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public void removeEncoder(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this.encoderName);
    }

    public String username() {
        return this.username;
    }

    public Socks4ProxyHandler(SocketAddress socketAddress) {
        this(socketAddress, null);
    }
}
