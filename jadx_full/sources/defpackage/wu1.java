package defpackage;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wu1 extends l1 {
    public static final vu1 f = new vu1();
    public final cm2 b;

    public wu1(cm2 cm2Var) {
        cm2Var.getClass();
        this.b = cm2Var;
    }

    @Override // io.netty.channel.SimpleChannelInboundHandler
    public final void channelRead0(ChannelHandlerContext channelHandlerContext, Object obj) {
        HttpObject httpObject = (HttpObject) obj;
        channelHandlerContext.getClass();
        httpObject.getClass();
        if (httpObject instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) httpObject;
            String strUri = httpRequest.headers().get(HttpHeaderNames.HOST);
            if (strUri == null || !p44.o0(strUri, ":", false)) {
                strUri = httpRequest.uri();
                strUri.getClass();
                if (w44.j0(strUri, "http://", false)) {
                    strUri = p44.F0(strUri, "http://");
                    if (p44.o0(strUri, "/", false)) {
                        strUri = (String) p44.L0(strUri, new String[]{"/"}, 6).get(0);
                    }
                    if (!p44.o0(strUri, ":", false)) {
                        strUri = strUri.concat(":80");
                    }
                }
            }
            List listL0 = p44.L0(strUri, new String[]{":"}, 6);
            Promise promiseNewPromise = channelHandlerContext.executor().newPromise();
            final Channel channel = channelHandlerContext.channel();
            if (n12.c(httpRequest.method(), HttpMethod.CONNECT)) {
                promiseNewPromise.addListener2(new GenericFutureListener(this) { // from class: su1
                    public final /* synthetic */ wu1 f;

                    {
                        this.f = this;
                    }

                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public final void operationComplete(Future future) {
                        boolean zIsSuccess = future.isSuccess();
                        Channel channel2 = channel;
                        wu1 wu1Var = this.f;
                        if (!zIsSuccess) {
                            channel2.writeAndFlush(xu1.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                            ((Map) wu1Var.b.Z).values().remove(channel2.remoteAddress());
                        } else {
                            Object now = future.getNow();
                            now.getClass();
                            channel2.writeAndFlush(xu1.a).addListener2((GenericFutureListener<? extends Future<? super Void>>) new uu1((Channel) now, channel2, wu1Var, 1));
                        }
                    }
                });
            } else {
                promiseNewPromise.addListener2((GenericFutureListener) new uu1(httpObject, channel, this));
            }
            ChannelFutureListener channelFutureListener = new ChannelFutureListener() { // from class: tu1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public final void operationComplete(Future future) {
                    ChannelFuture channelFuture = (ChannelFuture) future;
                    boolean zIsSuccess = channelFuture.isSuccess();
                    Channel channel2 = channel;
                    if (!zIsSuccess) {
                        channel2.writeAndFlush(xu1.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                        return;
                    }
                    Map map = (Map) this.b.b.Z;
                    map.getClass();
                    map.put(channelFuture.channel().localAddress(), channel2.remoteAddress());
                }
            };
            String str = (String) listL0.get(0);
            int i = Integer.parseInt((String) listL0.get(1));
            channel.getClass();
            promiseNewPromise.getClass();
            l1.g(channel, str, i, channelFutureListener, promiseNewPromise);
        }
    }
}
