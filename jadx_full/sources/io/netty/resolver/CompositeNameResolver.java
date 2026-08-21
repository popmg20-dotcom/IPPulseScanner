package io.netty.resolver;

import defpackage.xe;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class CompositeNameResolver<T> extends SimpleNameResolver<T> {
    private final NameResolver<T>[] resolvers;

    public CompositeNameResolver(EventExecutor eventExecutor, NameResolver<T>... nameResolverArr) {
        super(eventExecutor);
        ObjectUtil.checkNotNull(nameResolverArr, "resolvers");
        for (int i = 0; i < nameResolverArr.length; i++) {
            ObjectUtil.checkNotNull(nameResolverArr[i], "resolvers[" + i + ']');
        }
        if (nameResolverArr.length < 2) {
            xe.r("resolvers: ", Arrays.asList(nameResolverArr), " (expected: at least 2 resolvers)");
            throw null;
        }
        this.resolvers = (NameResolver[]) nameResolverArr.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveAllRec(final String str, final Promise<List<T>> promise, final int i, Throwable th) {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i].resolveAll(str).addListener2(new FutureListener<List<T>>() { // from class: io.netty.resolver.CompositeNameResolver.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<List<T>> future) {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveAllRec(str, promise, i + 1, future.cause());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveRec(final String str, final Promise<T> promise, final int i, Throwable th) {
        NameResolver<T>[] nameResolverArr = this.resolvers;
        if (i >= nameResolverArr.length) {
            promise.setFailure(th);
        } else {
            nameResolverArr[i].resolve(str).addListener2(new FutureListener<T>() { // from class: io.netty.resolver.CompositeNameResolver.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<T> future) {
                    if (future.isSuccess()) {
                        promise.setSuccess(future.getNow());
                    } else {
                        CompositeNameResolver.this.doResolveRec(str, promise, i + 1, future.cause());
                    }
                }
            });
        }
    }

    @Override // io.netty.resolver.SimpleNameResolver
    public void doResolve(String str, Promise<T> promise) {
        doResolveRec(str, promise, 0, null);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    public void doResolveAll(String str, Promise<List<T>> promise) {
        doResolveAllRec(str, promise, 0, null);
    }
}
