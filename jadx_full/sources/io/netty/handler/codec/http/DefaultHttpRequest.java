package io.netty.handler.codec.http;

import defpackage.dw2;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultHttpRequest extends DefaultHttpMessage implements HttpRequest {
    private static final int HASH_CODE_PRIME = 31;
    private HttpMethod method;
    private String uri;

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, boolean z) {
        super(httpVersion, z, false);
        this.method = (HttpMethod) ObjectUtil.checkNotNull(httpMethod, "method");
        this.uri = (String) ObjectUtil.checkNotNull(str, "uri");
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttpRequest)) {
            return false;
        }
        DefaultHttpRequest defaultHttpRequest = (DefaultHttpRequest) obj;
        return method().equals(defaultHttpRequest.method()) && uri().equalsIgnoreCase(defaultHttpRequest.uri()) && super.equals(obj);
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    @Deprecated
    public HttpMethod getMethod() {
        return method();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    @Deprecated
    public String getUri() {
        return uri();
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return dw2.w((this.method.hashCode() + HASH_CODE_PRIME) * HASH_CODE_PRIME, HASH_CODE_PRIME, this.uri) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    public HttpMethod method() {
        return this.method;
    }

    public HttpRequest setMethod(HttpMethod httpMethod) {
        this.method = (HttpMethod) ObjectUtil.checkNotNull(httpMethod, "method");
        return this;
    }

    public HttpRequest setUri(String str) {
        this.uri = (String) ObjectUtil.checkNotNull(str, "uri");
        return this;
    }

    public String toString() {
        return HttpMessageUtil.appendRequest(new StringBuilder(256), this).toString();
    }

    @Override // io.netty.handler.codec.http.HttpRequest
    public String uri() {
        return this.uri;
    }

    @Override // io.netty.handler.codec.http.DefaultHttpMessage, io.netty.handler.codec.http.HttpMessage, io.netty.handler.codec.http.HttpRequest, io.netty.handler.codec.http.FullHttpRequest
    public HttpRequest setProtocolVersion(HttpVersion httpVersion) {
        super.setProtocolVersion(httpVersion);
        return this;
    }

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str) {
        this(httpVersion, httpMethod, str, true);
    }

    public DefaultHttpRequest(HttpVersion httpVersion, HttpMethod httpMethod, String str, HttpHeaders httpHeaders) {
        super(httpVersion, httpHeaders);
        this.method = (HttpMethod) ObjectUtil.checkNotNull(httpMethod, "method");
        this.uri = (String) ObjectUtil.checkNotNull(str, "uri");
    }
}
