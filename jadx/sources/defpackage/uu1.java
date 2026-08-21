package defpackage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class uu1 implements GenericFutureListener {
    public final /* synthetic */ wu1 A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Channel f;
    public final /* synthetic */ Object z;

    public /* synthetic */ uu1(HttpObject httpObject, Channel channel, wu1 wu1Var) {
        this.b = 2;
        this.z = httpObject;
        this.f = channel;
        this.A = wu1Var;
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future) throws Throwable {
        int i = this.b;
        wu1 wu1Var = this.A;
        Channel channel = this.f;
        Object obj = this.z;
        int i2 = 0;
        switch (i) {
            case 0:
                Channel channel2 = (Channel) obj;
                cm2 cm2Var = wu1Var.b;
                if (!future.isSuccess()) {
                    channel2.writeAndFlush(xu1.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                    ((Map) cm2Var.Z).values().remove(channel2.remoteAddress());
                } else {
                    ChannelPipeline channelPipelinePipeline = channel.pipeline();
                    channelPipelinePipeline.addLast(new IdleStateHandler(0, 0, 60));
                    vu1 vu1Var = wu1.f;
                    channelPipelinePipeline.addLast(vu1Var);
                    SocketAddress socketAddressLocalAddress = channel.localAddress();
                    socketAddressLocalAddress.getClass();
                    channel2.getClass();
                    channelPipelinePipeline.addLast(new ob3(cm2Var, socketAddressLocalAddress, channel2));
                    ChannelPipeline channelPipelinePipeline2 = channel2.pipeline();
                    channelPipelinePipeline2.remove(wu1Var);
                    channelPipelinePipeline2.addLast(new IdleStateHandler(0, 0, 60));
                    channelPipelinePipeline2.addLast(vu1Var);
                    SocketAddress socketAddressLocalAddress2 = channel.localAddress();
                    socketAddressLocalAddress2.getClass();
                    channelPipelinePipeline2.addLast(new ob3(cm2Var, socketAddressLocalAddress2, channel));
                    channelPipelinePipeline2.remove(HttpServerCodec.class);
                }
                break;
            case 1:
                Channel channel3 = (Channel) obj;
                cm2 cm2Var2 = wu1Var.b;
                if (!future.isSuccess()) {
                    channel.close();
                } else {
                    ChannelPipeline channelPipelinePipeline3 = channel.pipeline();
                    channelPipelinePipeline3.addLast(new IdleStateHandler(0, 0, 60));
                    vu1 vu1Var2 = wu1.f;
                    channelPipelinePipeline3.addLast(vu1Var2);
                    SocketAddress socketAddressLocalAddress3 = channel.localAddress();
                    socketAddressLocalAddress3.getClass();
                    channel3.getClass();
                    channelPipelinePipeline3.addLast(new ob3(cm2Var2, socketAddressLocalAddress3, channel3));
                    ChannelPipeline channelPipelinePipeline4 = channel3.pipeline();
                    channelPipelinePipeline4.remove(wu1Var);
                    channelPipelinePipeline4.addLast(new IdleStateHandler(0, 0, 60));
                    channelPipelinePipeline4.addLast(vu1Var2);
                    SocketAddress socketAddressLocalAddress4 = channel.localAddress();
                    socketAddressLocalAddress4.getClass();
                    channelPipelinePipeline4.addLast(new ob3(cm2Var2, socketAddressLocalAddress4, channel));
                    channelPipelinePipeline4.remove(HttpServerCodec.class);
                }
                break;
            default:
                HttpObject httpObject = (HttpObject) obj;
                if (!future.isSuccess()) {
                    channel.writeAndFlush(xu1.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                    ((Map) wu1Var.b.Z).values().remove(channel.remoteAddress());
                } else {
                    HttpRequest httpRequest = (HttpRequest) httpObject;
                    URI uriCreate = URI.create(httpRequest.uri());
                    StringBuilder sb = new StringBuilder();
                    if (uriCreate.getRawPath() != null) {
                        sb.append(uriCreate.getRawPath());
                    } else {
                        sb.append('/');
                    }
                    if (uriCreate.getRawQuery() != null) {
                        sb.append('?');
                        sb.append(uriCreate.getRawQuery());
                    }
                    if (uriCreate.getRawFragment() != null) {
                        sb.append('#');
                        sb.append(uriCreate.getRawFragment());
                    }
                    httpRequest.setUri(sb.toString());
                    httpRequest.headers().remove(HttpHeaderNames.PROXY_CONNECTION).remove(HttpHeaderNames.CONNECTION);
                    Object now = future.getNow();
                    now.getClass();
                    Channel channel4 = (Channel) now;
                    EmbeddedChannel embeddedChannel = new EmbeddedChannel(new HttpRequestEncoder());
                    embeddedChannel.writeOutbound(httpObject);
                    channel4.writeAndFlush((ByteBuf) embeddedChannel.readOutbound()).addListener2((GenericFutureListener<? extends Future<? super Void>>) new uu1(channel4, channel, wu1Var, i2));
                }
                break;
        }
    }

    public /* synthetic */ uu1(Channel channel, Channel channel2, wu1 wu1Var, int i) {
        this.b = i;
        this.f = channel;
        this.z = channel2;
        this.A = wu1Var;
    }
}
