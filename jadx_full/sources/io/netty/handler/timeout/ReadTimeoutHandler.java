package io.netty.handler.timeout;

import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ReadTimeoutHandler extends IdleStateHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean closed;

    public ReadTimeoutHandler(long j, TimeUnit timeUnit) {
        super(j, 0L, 0L, timeUnit);
    }

    @Override // io.netty.handler.timeout.IdleStateHandler
    public final void channelIdle(ChannelHandlerContext channelHandlerContext, IdleStateEvent idleStateEvent) {
        readTimedOut(channelHandlerContext);
    }

    public void readTimedOut(ChannelHandlerContext channelHandlerContext) {
        if (this.closed) {
            return;
        }
        channelHandlerContext.fireExceptionCaught((Throwable) ReadTimeoutException.INSTANCE);
        channelHandlerContext.close();
        this.closed = true;
    }

    public ReadTimeoutHandler(int i) {
        this(i, TimeUnit.SECONDS);
    }
}
