package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class WebSocketServerExtensionHandler extends ChannelDuplexHandler {
    private final List<WebSocketServerExtensionHandshaker> extensionHandshakers;
    private List<WebSocketServerExtension> validExtensions;

    public WebSocketServerExtensionHandler(WebSocketServerExtensionHandshaker... webSocketServerExtensionHandshakerArr) {
        this.extensionHandshakers = Arrays.asList(ObjectUtil.checkNonEmpty(webSocketServerExtensionHandshakerArr, "extensionHandshakers"));
    }

    private void handlePotentialUpgrade(final ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise, HttpResponse httpResponse) {
        HttpHeaders httpHeadersHeaders = httpResponse.headers();
        if (WebSocketExtensionUtil.isWebsocketUpgrade(httpHeadersHeaders)) {
            if (this.validExtensions != null) {
                String asString = httpHeadersHeaders.getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                ArrayList arrayList = new ArrayList(this.extensionHandshakers.size());
                Iterator<WebSocketServerExtension> it = this.validExtensions.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().newReponseData());
                }
                String strComputeMergeExtensionsHeaderValue = WebSocketExtensionUtil.computeMergeExtensionsHeaderValue(asString, arrayList);
                channelPromise.addListener2((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandler.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (channelFuture.isSuccess()) {
                            for (WebSocketServerExtension webSocketServerExtension : WebSocketServerExtensionHandler.this.validExtensions) {
                                WebSocketExtensionDecoder webSocketExtensionDecoderNewExtensionDecoder = webSocketServerExtension.newExtensionDecoder();
                                WebSocketExtensionEncoder webSocketExtensionEncoderNewExtensionEncoder = webSocketServerExtension.newExtensionEncoder();
                                String strName = channelHandlerContext.name();
                                channelHandlerContext.pipeline().addAfter(strName, webSocketExtensionDecoderNewExtensionDecoder.getClass().getName(), webSocketExtensionDecoderNewExtensionDecoder).addAfter(strName, webSocketExtensionEncoderNewExtensionEncoder.getClass().getName(), webSocketExtensionEncoderNewExtensionEncoder);
                            }
                        }
                    }
                });
                if (strComputeMergeExtensionsHeaderValue != null) {
                    httpHeadersHeaders.set(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, strComputeMergeExtensionsHeaderValue);
                }
            }
            channelPromise.addListener2((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandler.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        channelHandlerContext.pipeline().remove(WebSocketServerExtensionHandler.this);
                    }
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        String asString;
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpRequest.headers()) && (asString = httpRequest.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS)) != null) {
                int iRsv = 0;
                for (WebSocketExtensionData webSocketExtensionData : WebSocketExtensionUtil.extractExtensions(asString)) {
                    Iterator<WebSocketServerExtensionHandshaker> it = this.extensionHandshakers.iterator();
                    WebSocketServerExtension webSocketServerExtensionHandshakeExtension = null;
                    while (webSocketServerExtensionHandshakeExtension == null && it.hasNext()) {
                        webSocketServerExtensionHandshakeExtension = it.next().handshakeExtension(webSocketExtensionData);
                    }
                    if (webSocketServerExtensionHandshakeExtension != null && (webSocketServerExtensionHandshakeExtension.rsv() & iRsv) == 0) {
                        if (this.validExtensions == null) {
                            this.validExtensions = new ArrayList(1);
                        }
                        iRsv |= webSocketServerExtensionHandshakeExtension.rsv();
                        this.validExtensions.add(webSocketServerExtensionHandshakeExtension);
                    }
                }
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (obj instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) obj;
            if (HttpResponseStatus.SWITCHING_PROTOCOLS.equals(httpResponse.status())) {
                handlePotentialUpgrade(channelHandlerContext, channelPromise, httpResponse);
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }
}
