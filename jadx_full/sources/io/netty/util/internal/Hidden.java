package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import j$.util.function.Function$CC;
import j$.util.function.Predicate$CC;
import java.util.function.Function;
import java.util.function.Predicate;
import reactor.blockhound.BlockHound;
import reactor.blockhound.integration.BlockHoundIntegration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class Hidden {

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class NettyBlockHoundIntegration implements BlockHoundIntegration {
        public void applyTo(BlockHound.Builder builder) {
            builder.allowBlockingCallsInside("io.netty.channel.nio.NioEventLoop", "handleLoopException");
            builder.allowBlockingCallsInside("io.netty.channel.kqueue.KQueueEventLoop", "handleLoopException");
            builder.allowBlockingCallsInside("io.netty.channel.epoll.EpollEventLoop", "handleLoopException");
            builder.allowBlockingCallsInside("io.netty.util.HashedWheelTimer", "start");
            builder.allowBlockingCallsInside("io.netty.util.HashedWheelTimer", "stop");
            builder.allowBlockingCallsInside("io.netty.util.HashedWheelTimer$Worker", "waitForNextTick");
            builder.allowBlockingCallsInside("io.netty.util.concurrent.SingleThreadEventExecutor", "confirmShutdown");
            builder.allowBlockingCallsInside("io.netty.buffer.PoolArena", "lock");
            builder.allowBlockingCallsInside("io.netty.buffer.PoolSubpage", "lock");
            builder.allowBlockingCallsInside("io.netty.buffer.PoolChunk", "allocateRun");
            builder.allowBlockingCallsInside("io.netty.buffer.PoolChunk", "free");
            builder.allowBlockingCallsInside("io.netty.handler.ssl.SslHandler", "handshake");
            builder.allowBlockingCallsInside("io.netty.handler.ssl.SslHandler", "runAllDelegatedTasks");
            builder.allowBlockingCallsInside("io.netty.handler.ssl.SslHandler", "runDelegatedTasks");
            builder.allowBlockingCallsInside("io.netty.util.concurrent.GlobalEventExecutor", "takeTask");
            builder.allowBlockingCallsInside("io.netty.util.concurrent.GlobalEventExecutor", "addTask");
            builder.allowBlockingCallsInside("io.netty.util.concurrent.SingleThreadEventExecutor", "takeTask");
            builder.allowBlockingCallsInside("io.netty.util.concurrent.SingleThreadEventExecutor", "addTask");
            builder.allowBlockingCallsInside("io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$ExtendedTrustManagerVerifyCallback", "verify");
            builder.allowBlockingCallsInside("io.netty.handler.ssl.JdkSslContext$Defaults", "init");
            builder.allowBlockingCallsInside("sun.security.ssl.SSLEngineImpl", "unwrap");
            builder.allowBlockingCallsInside("sun.security.ssl.SSLEngineImpl", "wrap");
            builder.allowBlockingCallsInside("io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider", "parse");
            builder.allowBlockingCallsInside("io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider", "parseEtcResolverSearchDomains");
            builder.allowBlockingCallsInside("io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider", "parseEtcResolverOptions");
            builder.allowBlockingCallsInside("io.netty.resolver.HostsFileEntriesProvider$ParserImpl", "parse");
            builder.allowBlockingCallsInside("io.netty.util.NetUtil$SoMaxConnAction", "run");
            builder.allowBlockingCallsInside("io.netty.util.internal.PlatformDependent", "createTempFile");
            builder.nonBlockingThreadPredicate(new Function<Predicate<Thread>, Predicate<Thread>>() { // from class: io.netty.util.internal.Hidden.NettyBlockHoundIntegration.1
                public /* synthetic */ Function andThen(Function function) {
                    return Function$CC.$default$andThen(this, function);
                }

                public /* synthetic */ Function compose(Function function) {
                    return Function$CC.$default$compose(this, function);
                }

                @Override // java.util.function.Function
                public Predicate<Thread> apply(final Predicate<Thread> predicate) {
                    return new Predicate<Thread>() { // from class: io.netty.util.internal.Hidden.NettyBlockHoundIntegration.1.1
                        public /* synthetic */ Predicate and(Predicate predicate2) {
                            return Predicate$CC.$default$and(this, predicate2);
                        }

                        public /* synthetic */ Predicate negate() {
                            return Predicate$CC.$default$negate(this);
                        }

                        public /* synthetic */ Predicate or(Predicate predicate2) {
                            return Predicate$CC.$default$or(this, predicate2);
                        }

                        @Override // java.util.function.Predicate
                        public boolean test(Thread thread) {
                            if (predicate.test(thread)) {
                                return true;
                            }
                            return (thread instanceof FastThreadLocalThread) && !((FastThreadLocalThread) thread).permitBlockingCalls();
                        }
                    };
                }
            });
        }

        public int compareTo(BlockHoundIntegration blockHoundIntegration) {
            return 0;
        }
    }
}
