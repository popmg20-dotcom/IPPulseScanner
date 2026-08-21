package io.netty.handler.codec.http.websocketx;

import defpackage.fw;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class WebSocketServerProtocolHandshakeHandler extends ChannelInboundHandlerAdapter {
    private ChannelHandlerContext ctx;
    private ChannelPromise handshakePromise;
    private boolean isWebSocketPath;
    private final WebSocketServerProtocolConfig serverConfig;

    public WebSocketServerProtocolHandshakeHandler(WebSocketServerProtocolConfig webSocketServerProtocolConfig) {
        this.serverConfig = (WebSocketServerProtocolConfig) ObjectUtil.checkNotNull(webSocketServerProtocolConfig, "serverConfig");
    }

    private void applyHandshakeTimeout() {
        final ChannelPromise channelPromise = this.handshakePromise;
        long jHandshakeTimeoutMillis = this.serverConfig.handshakeTimeoutMillis();
        if (jHandshakeTimeoutMillis <= 0 || channelPromise.isDone()) {
            return;
        }
        final ScheduledFuture<?> scheduledFutureSchedule = this.ctx.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler.2
            @Override // java.lang.Runnable
            public void run() {
                if (channelPromise.isDone() || !channelPromise.tryFailure(new WebSocketServerHandshakeException("handshake timed out"))) {
                    return;
                }
                WebSocketServerProtocolHandshakeHandler.this.ctx.flush().fireUserEventTriggered((Object) WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_TIMEOUT).close();
            }
        }, jHandshakeTimeoutMillis, TimeUnit.MILLISECONDS);
        channelPromise.addListener2((GenericFutureListener<? extends Future<? super Void>>) new FutureListener<Void>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Void> future) {
                scheduledFutureSchedule.cancel(false);
            }
        });
    }

    private boolean checkNextUri(String str, String str2) {
        char cCharAt;
        int length = str2.length();
        return str.length() <= length || (cCharAt = str.charAt(length)) == '/' || cCharAt == '?';
    }

    private static String getWebSocketLocation(ChannelPipeline channelPipeline, HttpRequest httpRequest, String str) {
        return fw.u(channelPipeline.get(SslHandler.class) != null ? "wss" : "ws", "://", httpRequest.headers().get(HttpHeaderNames.HOST), str);
    }

    private boolean isWebSocketPath(HttpRequest httpRequest) {
        String strWebsocketPath = this.serverConfig.websocketPath();
        String strUri = httpRequest.uri();
        return this.serverConfig.checkStartsWith() ? strUri.startsWith(strWebsocketPath) && ("/".equals(strWebsocketPath) || checkNextUri(strUri, strWebsocketPath)) : strUri.equals(strWebsocketPath);
    }

    private static void sendHttpResponse(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        ChannelFuture channelFutureWriteAndFlush = channelHandlerContext.writeAndFlush(httpResponse);
        if (HttpUtil.isKeepAlive(httpRequest) && httpResponse.status().code() == 200) {
            return;
        }
        channelFutureWriteAndFlush.addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(final ChannelHandlerContext channelHandlerContext, Object obj) {
        HttpObject httpObject = (HttpObject) obj;
        if (!(httpObject instanceof HttpRequest)) {
            if (this.isWebSocketPath) {
                ReferenceCountUtil.release(obj);
                return;
            } else {
                channelHandlerContext.fireChannelRead(obj);
                return;
            }
        }
        final HttpRequest httpRequest = (HttpRequest) httpObject;
        boolean zIsWebSocketPath = isWebSocketPath(httpRequest);
        this.isWebSocketPath = zIsWebSocketPath;
        if (!zIsWebSocketPath) {
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        try {
            if (!HttpMethod.GET.equals(httpRequest.method())) {
                sendHttpResponse(channelHandlerContext, httpRequest, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN, channelHandlerContext.alloc().buffer(0)));
                ReferenceCountUtil.release(httpRequest);
                return;
            }
            final WebSocketServerHandshaker webSocketServerHandshakerNewHandshaker = new WebSocketServerHandshakerFactory(getWebSocketLocation(channelHandlerContext.pipeline(), httpRequest, this.serverConfig.websocketPath()), this.serverConfig.subprotocols(), this.serverConfig.decoderConfig()).newHandshaker(httpRequest);
            final ChannelPromise channelPromise = this.handshakePromise;
            if (webSocketServerHandshakerNewHandshaker == null) {
                WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(channelHandlerContext.channel());
            } else {
                WebSocketServerProtocolHandler.setHandshaker(channelHandlerContext.channel(), webSocketServerHandshakerNewHandshaker);
                channelHandlerContext.pipeline().remove(this);
                webSocketServerHandshakerNewHandshaker.handshake(channelHandlerContext.channel(), httpRequest).addListener2((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) {
                        boolean zIsSuccess = channelFuture.isSuccess();
                        ChannelPromise channelPromise2 = channelPromise;
                        if (!zIsSuccess) {
                            channelPromise2.tryFailure(channelFuture.cause());
                            channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                        } else {
                            channelPromise2.trySuccess();
                            channelHandlerContext.fireUserEventTriggered((Object) WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE);
                            channelHandlerContext.fireUserEventTriggered((Object) new WebSocketServerProtocolHandler.HandshakeComplete(httpRequest.uri(), httpRequest.headers(), webSocketServerHandshakerNewHandshaker.selectedSubprotocol()));
                        }
                    }
                });
                applyHandshakeTimeout();
            }
            ReferenceCountUtil.release(httpRequest);
        } catch (Throwable th) {
            ReferenceCountUtil.release(httpRequest);
            throw th;
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
        this.handshakePromise = channelHandlerContext.newPromise();
    }
}
