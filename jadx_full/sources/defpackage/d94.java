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
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d94 implements GenericFutureListener {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int X;
    public final /* synthetic */ boolean Y;
    public final /* synthetic */ hz3 Z;
    public final /* synthetic */ int b;
    public final /* synthetic */ i94 f;
    public final /* synthetic */ Channel z;

    public /* synthetic */ d94(HttpObject httpObject, Channel channel, i94 i94Var, int i, boolean z, hz3 hz3Var) {
        this.b = 2;
        this.A = httpObject;
        this.z = channel;
        this.f = i94Var;
        this.X = i;
        this.Y = z;
        this.Z = hz3Var;
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future) throws Throwable {
        int i = this.b;
        hz3 hz3Var = this.Z;
        Object obj = this.A;
        switch (i) {
            case 0:
                Channel channel = (Channel) obj;
                boolean zIsSuccess = future.isSuccess();
                Channel channel2 = this.z;
                if (!zIsSuccess) {
                    channel2.close();
                } else {
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    e94 e94Var = new e94();
                    ChannelPipeline channelPipelinePipeline = channel2.pipeline();
                    channelPipelinePipeline.addLast(new IdleStateHandler(0, 0, 60));
                    channelPipelinePipeline.addLast(e94Var);
                    SocketAddress socketAddressLocalAddress = channel2.localAddress();
                    socketAddressLocalAddress.getClass();
                    i94 i94Var = this.f;
                    int i2 = this.X;
                    boolean z = this.Y;
                    channelPipelinePipeline.addLast(new g94(i94Var, socketAddressLocalAddress, channel, i2, false, atomicBoolean, z));
                    ChannelPipeline channelPipelinePipeline2 = channel.pipeline();
                    channelPipelinePipeline2.remove(hz3Var);
                    channelPipelinePipeline2.addLast(new IdleStateHandler(0, 0, 60));
                    channelPipelinePipeline2.addLast(e94Var);
                    SocketAddress socketAddressLocalAddress2 = channel2.localAddress();
                    socketAddressLocalAddress2.getClass();
                    channelPipelinePipeline2.addLast(new g94(i94Var, socketAddressLocalAddress2, channel2, i2, true, atomicBoolean, z));
                    channelPipelinePipeline2.remove(HttpServerCodec.class);
                    i94Var.h.g(Integer.valueOf(i94Var.m.incrementAndGet()));
                }
                break;
            case 1:
                Channel channel3 = (Channel) obj;
                if (!future.isSuccess()) {
                    channel3.writeAndFlush(j94.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                } else {
                    AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                    e94 e94Var2 = new e94();
                    Channel channel4 = this.z;
                    ChannelPipeline channelPipelinePipeline3 = channel4.pipeline();
                    channelPipelinePipeline3.addLast(new IdleStateHandler(0, 0, 60));
                    channelPipelinePipeline3.addLast(e94Var2);
                    SocketAddress socketAddressLocalAddress3 = channel4.localAddress();
                    socketAddressLocalAddress3.getClass();
                    i94 i94Var2 = this.f;
                    int i3 = this.X;
                    boolean z2 = this.Y;
                    channelPipelinePipeline3.addLast(new g94(i94Var2, socketAddressLocalAddress3, channel3, i3, false, atomicBoolean2, z2));
                    ChannelPipeline channelPipelinePipeline4 = channel3.pipeline();
                    channelPipelinePipeline4.remove(hz3Var);
                    channelPipelinePipeline4.addLast(new IdleStateHandler(0, 0, 60));
                    channelPipelinePipeline4.addLast(e94Var2);
                    SocketAddress socketAddressLocalAddress4 = channel4.localAddress();
                    socketAddressLocalAddress4.getClass();
                    channelPipelinePipeline4.addLast(new g94(i94Var2, socketAddressLocalAddress4, channel4, i3, true, atomicBoolean2, z2));
                    channelPipelinePipeline4.remove(HttpServerCodec.class);
                    i94Var2.h.g(Integer.valueOf(i94Var2.m.incrementAndGet()));
                }
                break;
            default:
                HttpObject httpObject = (HttpObject) obj;
                boolean zIsSuccess2 = future.isSuccess();
                Channel channel5 = this.z;
                if (!zIsSuccess2) {
                    channel5.writeAndFlush(j94.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
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
                    Channel channel6 = (Channel) now;
                    EmbeddedChannel embeddedChannel = new EmbeddedChannel(new HttpRequestEncoder());
                    embeddedChannel.writeOutbound(httpObject);
                    channel6.writeAndFlush((ByteBuf) embeddedChannel.readOutbound()).addListener2((GenericFutureListener<? extends Future<? super Void>>) new d94(this.f, channel6, channel5, this.X, this.Y, this.Z, 1));
                }
                break;
        }
    }

    public /* synthetic */ d94(i94 i94Var, Channel channel, Channel channel2, int i, boolean z, hz3 hz3Var, int i2) {
        this.b = i2;
        this.f = i94Var;
        this.z = channel;
        this.A = channel2;
        this.X = i;
        this.Y = z;
        this.Z = hz3Var;
    }
}
