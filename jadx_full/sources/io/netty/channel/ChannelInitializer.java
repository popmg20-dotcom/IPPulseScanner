package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public abstract class ChannelInitializer<C extends Channel> extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelInitializer.class);
    private final Set<ChannelHandlerContext> initMap = Collections.newSetFromMap(new ConcurrentHashMap());

    private boolean initChannel(ChannelHandlerContext channelHandlerContext) {
        boolean zIsRemoved;
        if (!this.initMap.add(channelHandlerContext)) {
            return false;
        }
        try {
            initChannel(channelHandlerContext.channel());
            if (zIsRemoved) {
                return true;
            }
        } catch (Throwable th) {
            try {
                exceptionCaught(channelHandlerContext, th);
                if (channelHandlerContext.isRemoved()) {
                    return true;
                }
            } finally {
                if (!channelHandlerContext.isRemoved()) {
                    channelHandlerContext.pipeline().remove(this);
                }
            }
        }
        return true;
    }

    private void removeState(final ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.isRemoved()) {
            this.initMap.remove(channelHandlerContext);
        } else {
            channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.channel.ChannelInitializer.1
                @Override // java.lang.Runnable
                public void run() {
                    ChannelInitializer.this.initMap.remove(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        if (!initChannel(channelHandlerContext)) {
            channelHandlerContext.fireChannelRegistered();
        } else {
            channelHandlerContext.pipeline().fireChannelRegistered();
            removeState(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        InternalLogger internalLogger = logger;
        if (internalLogger.isWarnEnabled()) {
            internalLogger.warn("Failed to initialize a channel. Closing: " + channelHandlerContext.channel(), th);
        }
        channelHandlerContext.close();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.channel().isRegistered() && initChannel(channelHandlerContext)) {
            removeState(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        this.initMap.remove(channelHandlerContext);
    }

    public abstract void initChannel(C c);
}
