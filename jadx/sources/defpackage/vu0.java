package defpackage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Promise;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vu0 extends ChannelInboundHandlerAdapter {
    public final Promise b;

    public vu0(Promise promise) {
        this.b = promise;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelActive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.getClass();
        channelHandlerContext.pipeline().remove(this);
        this.b.setSuccess(channelHandlerContext.channel());
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.getClass();
        th.getClass();
        this.b.setFailure(th);
    }
}
