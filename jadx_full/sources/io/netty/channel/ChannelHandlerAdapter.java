package io.netty.channel;

import defpackage.xe;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerMask;
import io.netty.util.internal.InternalThreadLocalMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChannelHandlerAdapter implements ChannelHandler {
    boolean added;

    public void ensureNotSharable() {
        if (isSharable()) {
            xe.l("ChannelHandler ", getClass().getName(), " is not allowed to be shared");
        }
    }

    @Override // io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    @Deprecated
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.fireExceptionCaught(th);
    }

    public boolean isSharable() {
        Class<?> cls = getClass();
        Map<Class<?>, Boolean> mapHandlerSharableCache = InternalThreadLocalMap.get().handlerSharableCache();
        Boolean boolValueOf = mapHandlerSharableCache.get(cls);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(cls.isAnnotationPresent(ChannelHandler.Sharable.class));
            mapHandlerSharableCache.put(cls, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
    }
}
