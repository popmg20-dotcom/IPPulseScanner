package io.netty.channel;

import defpackage.l0;
import io.netty.util.concurrent.AbstractEventExecutorGroup;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractEventLoopGroup extends AbstractEventExecutorGroup implements EventLoopGroup, AutoCloseable {
    @Override // io.netty.util.concurrent.AbstractEventExecutorGroup, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        l0.g(this);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public abstract EventLoop next();
}
