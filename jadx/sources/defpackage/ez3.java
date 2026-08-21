package defpackage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ez3 extends ChannelInboundHandlerAdapter {
    @Override // io.netty.channel.ChannelHandlerAdapter
    public final boolean isSharable() {
        return true;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.getClass();
        obj.getClass();
        if (obj instanceof IdleStateEvent) {
            channelHandlerContext.close();
        }
    }
}
