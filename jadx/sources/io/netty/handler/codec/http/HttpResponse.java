package io.netty.handler.codec.http;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface HttpResponse extends HttpMessage {
    @Deprecated
    HttpResponseStatus getStatus();

    @Override // io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    HttpResponse setProtocolVersion(HttpVersion httpVersion);

    HttpResponse setStatus(HttpResponseStatus httpResponseStatus);

    HttpResponseStatus status();
}
