package io.netty.util.concurrent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface Promise<V> extends Future<V> {
    Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Promise<V> await();

    Promise<V> awaitUninterruptibly();

    Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener);

    Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr);

    Promise<V> setFailure(Throwable th);

    Promise<V> setSuccess(V v);

    boolean setUncancellable();

    Promise<V> sync();

    Promise<V> syncUninterruptibly();

    boolean tryFailure(Throwable th);

    boolean trySuccess(V v);
}
