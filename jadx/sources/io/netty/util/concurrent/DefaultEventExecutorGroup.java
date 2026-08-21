package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultEventExecutorGroup extends MultithreadEventExecutorGroup {
    public DefaultEventExecutorGroup(int i, ThreadFactory threadFactory, int i2, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, threadFactory, Integer.valueOf(i2), rejectedExecutionHandler);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventExecutor newChild(Executor executor, Object... objArr) {
        return new DefaultEventExecutor(this, executor, ((Integer) objArr[0]).intValue(), (RejectedExecutionHandler) objArr[1]);
    }

    public DefaultEventExecutorGroup(int i, ThreadFactory threadFactory) {
        this(i, threadFactory, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    public DefaultEventExecutorGroup(int i) {
        this(i, null);
    }
}
