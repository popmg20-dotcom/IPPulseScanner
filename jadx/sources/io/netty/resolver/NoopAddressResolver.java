package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class NoopAddressResolver extends AbstractAddressResolver<SocketAddress> {
    public NoopAddressResolver(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public boolean doIsResolved(SocketAddress socketAddress) {
        return true;
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public void doResolve(SocketAddress socketAddress, Promise<SocketAddress> promise) {
        promise.setSuccess(socketAddress);
    }

    @Override // io.netty.resolver.AbstractAddressResolver
    public void doResolveAll(SocketAddress socketAddress, Promise<List<SocketAddress>> promise) {
        promise.setSuccess(Collections.singletonList(socketAddress));
    }
}
