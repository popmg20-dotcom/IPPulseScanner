package io.netty.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractFuture<V> implements Future<V> {
    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (!await(j, timeUnit)) {
            throw new TimeoutException();
        }
        Throwable thCause = cause();
        if (thCause == null) {
            return getNow();
        }
        if (thCause instanceof CancellationException) {
            throw ((CancellationException) thCause);
        }
        throw new ExecutionException(thCause);
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException {
        await();
        Throwable thCause = cause();
        if (thCause == null) {
            return getNow();
        }
        if (thCause instanceof CancellationException) {
            throw ((CancellationException) thCause);
        }
        throw new ExecutionException(thCause);
    }
}
