package io.netty.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface ProgressivePromise<V> extends Promise<V>, ProgressiveFuture<V> {
    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> await();

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> awaitUninterruptibly();

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    @Override // io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    ProgressivePromise<V> setFailure(Throwable th);

    ProgressivePromise<V> setProgress(long j, long j2);

    ProgressivePromise<V> setSuccess(V v);

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> sync();

    @Override // io.netty.util.concurrent.Promise, io.netty.util.concurrent.Future
    ProgressivePromise<V> syncUninterruptibly();

    boolean tryProgress(long j, long j2);
}
