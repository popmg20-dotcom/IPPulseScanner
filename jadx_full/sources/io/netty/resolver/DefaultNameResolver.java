package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.SocketUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultNameResolver extends InetNameResolver {
    public DefaultNameResolver(EventExecutor eventExecutor) {
        super(eventExecutor);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    public void doResolve(String str, Promise<InetAddress> promise) {
        try {
            promise.setSuccess(SocketUtils.addressByName(str));
        } catch (UnknownHostException e) {
            promise.setFailure(e);
        }
    }

    @Override // io.netty.resolver.SimpleNameResolver
    public void doResolveAll(String str, Promise<List<InetAddress>> promise) {
        try {
            promise.setSuccess(Arrays.asList(SocketUtils.allAddressesByName(str)));
        } catch (UnknownHostException e) {
            promise.setFailure(e);
        }
    }
}
