package defpackage;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l1 extends SimpleChannelInboundHandler {
    public static void g(Channel channel, String str, int i, ChannelFutureListener channelFutureListener, Promise promise) {
        str.getClass();
        Bootstrap bootstrapChannelFactory = new Bootstrap().group(channel.eventLoop()).channelFactory((ChannelFactory) new g(4));
        ChannelOption<Boolean> channelOption = ChannelOption.TCP_NODELAY;
        Boolean bool = Boolean.TRUE;
        bootstrapChannelFactory.option(channelOption, bool).option(ChannelOption.SO_KEEPALIVE, bool).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 4000).handler(new vu0(promise)).connect(str, i).addListener2((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
    }
}
