package io.netty.handler.codec.http;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class HttpRequestDecoder extends HttpObjectDecoder {
    public HttpRequestDecoder(int i, int i2, int i3, boolean z, int i4, boolean z2, boolean z3) {
        super(i, i2, i3, true, z, i4, z2, z3);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createInvalidMessage() {
        return new DefaultFullHttpRequest(HttpVersion.HTTP_1_0, HttpMethod.GET, "/bad-request", this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public HttpMessage createMessage(String[] strArr) {
        return new DefaultHttpRequest(HttpVersion.valueOf(strArr[2]), HttpMethod.valueOf(strArr[0]), strArr[1], this.validateHeaders);
    }

    @Override // io.netty.handler.codec.http.HttpObjectDecoder
    public boolean isDecodingRequest() {
        return true;
    }

    public HttpRequestDecoder(int i, int i2, int i3) {
        super(i, i2, i3, true);
    }

    public HttpRequestDecoder(int i, int i2, int i3, boolean z) {
        super(i, i2, i3, true, z);
    }

    public HttpRequestDecoder(int i, int i2, int i3, boolean z, int i4) {
        super(i, i2, i3, true, z, i4);
    }

    public HttpRequestDecoder(int i, int i2, int i3, boolean z, int i4, boolean z2) {
        super(i, i2, i3, true, z, i4, z2);
    }

    public HttpRequestDecoder() {
    }
}
