package io.netty.channel;

import defpackage.l0;
import io.netty.util.concurrent.AbstractEventExecutor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractEventLoop extends AbstractEventExecutor implements EventLoop, AutoCloseable {
    public AbstractEventLoop() {
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        l0.f(this);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup) super.parent();
    }

    public AbstractEventLoop(EventLoopGroup eventLoopGroup) {
        super(eventLoopGroup);
    }
}
