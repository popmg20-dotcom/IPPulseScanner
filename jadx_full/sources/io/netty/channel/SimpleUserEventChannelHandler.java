package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleUserEventChannelHandler<I> extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    public SimpleUserEventChannelHandler(boolean z) {
        this.matcher = TypeParameterMatcher.find(this, SimpleUserEventChannelHandler.class, "I");
        this.autoRelease = z;
    }

    public boolean acceptEvent(Object obj) {
        return this.matcher.match(obj);
    }

    public abstract void eventReceived(ChannelHandlerContext channelHandlerContext, I i);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        boolean z = true;
        try {
            if (acceptEvent(obj)) {
                eventReceived(channelHandlerContext, obj);
            } else {
                z = false;
                channelHandlerContext.fireUserEventTriggered(obj);
            }
            if (this.autoRelease && z) {
                ReferenceCountUtil.release(obj);
            }
        } catch (Throwable th) {
            if (this.autoRelease && 1 != 0) {
                ReferenceCountUtil.release(obj);
            }
            throw th;
        }
    }

    public SimpleUserEventChannelHandler() {
        this(true);
    }

    public SimpleUserEventChannelHandler(Class<? extends I> cls) {
        this(cls, true);
    }

    public SimpleUserEventChannelHandler(Class<? extends I> cls, boolean z) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.autoRelease = z;
    }
}
