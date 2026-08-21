package io.netty.handler.ipfilter;

import defpackage.zo2;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractRemoteAddressFilter<T extends SocketAddress> extends ChannelInboundHandlerAdapter {
    private boolean handleNewChannel(ChannelHandlerContext channelHandlerContext) {
        SocketAddress socketAddressRemoteAddress = channelHandlerContext.channel().remoteAddress();
        if (socketAddressRemoteAddress == null) {
            return false;
        }
        channelHandlerContext.pipeline().remove(this);
        if (accept(channelHandlerContext, socketAddressRemoteAddress)) {
            channelAccepted(channelHandlerContext, socketAddressRemoteAddress);
            return true;
        }
        ChannelFuture channelFutureChannelRejected = channelRejected(channelHandlerContext, socketAddressRemoteAddress);
        if (channelFutureChannelRejected != null) {
            channelFutureChannelRejected.addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            return true;
        }
        channelHandlerContext.close();
        return true;
    }

    public abstract boolean accept(ChannelHandlerContext channelHandlerContext, T t);

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        if (handleNewChannel(channelHandlerContext)) {
            channelHandlerContext.fireChannelActive();
        } else {
            zo2.v(channelHandlerContext.channel(), "cannot determine to accept or reject a channel: ");
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        handleNewChannel(channelHandlerContext);
        channelHandlerContext.fireChannelRegistered();
    }

    public ChannelFuture channelRejected(ChannelHandlerContext channelHandlerContext, T t) {
        return null;
    }

    public void channelAccepted(ChannelHandlerContext channelHandlerContext, T t) {
    }
}
