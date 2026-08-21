package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class HttpResponseEncoder extends HttpObjectEncoder<HttpResponse> {
    @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) {
        return super.acceptOutboundMessage(obj) && !(obj instanceof HttpRequest);
    }

    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void encodeInitialLine(ByteBuf byteBuf, HttpResponse httpResponse) {
        httpResponse.protocolVersion().encode(byteBuf);
        byteBuf.writeByte(32);
        httpResponse.status().encode(byteBuf);
        ByteBufUtil.writeShortBE(byteBuf, 3338);
    }

    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
        HttpResponseStatus httpResponseStatusStatus = httpResponse.status();
        if (httpResponseStatusStatus.codeClass() != HttpStatusClass.INFORMATIONAL) {
            return httpResponseStatusStatus.code() == HttpResponseStatus.NO_CONTENT.code() || httpResponseStatusStatus.code() == HttpResponseStatus.NOT_MODIFIED.code() || httpResponseStatusStatus.code() == HttpResponseStatus.RESET_CONTENT.code();
        }
        if (httpResponseStatusStatus.code() == HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_VERSION);
        }
        return true;
    }

    @Override // io.netty.handler.codec.http.HttpObjectEncoder
    public void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z) {
        if (z) {
            HttpResponseStatus httpResponseStatusStatus = httpResponse.status();
            if (httpResponseStatusStatus.codeClass() == HttpStatusClass.INFORMATIONAL || httpResponseStatusStatus.code() == HttpResponseStatus.NO_CONTENT.code()) {
                httpResponse.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            } else if (httpResponseStatusStatus.code() == HttpResponseStatus.RESET_CONTENT.code()) {
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
                httpResponse.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, 0);
            }
        }
    }
}
