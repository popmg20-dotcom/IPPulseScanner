package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultEventLoop extends SingleThreadEventLoop {
    public DefaultEventLoop(EventLoopGroup eventLoopGroup) {
        this(eventLoopGroup, new DefaultThreadFactory((Class<?>) DefaultEventLoop.class));
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void run() {
        do {
            Runnable runnableTakeTask = takeTask();
            if (runnableTakeTask != null) {
                AbstractEventExecutor.runTask(runnableTakeTask);
                updateLastExecutionTime();
            }
        } while (!confirmShutdown());
    }

    public DefaultEventLoop(ThreadFactory threadFactory) {
        this((EventLoopGroup) null, threadFactory);
    }

    public DefaultEventLoop(Executor executor) {
        this((EventLoopGroup) null, executor);
    }

    public DefaultEventLoop() {
        this((EventLoopGroup) null);
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup, ThreadFactory threadFactory) {
        super(eventLoopGroup, threadFactory, true);
    }

    public DefaultEventLoop(EventLoopGroup eventLoopGroup, Executor executor) {
        super(eventLoopGroup, executor, true);
    }
}
