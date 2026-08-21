package io.netty.channel;

import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface ChannelOutboundHandler extends ChannelHandler {
    void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise);

    void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise);

    void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void flush(ChannelHandlerContext channelHandlerContext);

    void read(ChannelHandlerContext channelHandlerContext);

    void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise);
}
