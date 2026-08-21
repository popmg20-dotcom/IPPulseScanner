package defpackage;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class j94 {
    public static final DefaultHttpResponse a;
    public static final DefaultHttpResponse b;

    static {
        HttpVersion httpVersion = HttpVersion.HTTP_1_1;
        a = new DefaultHttpResponse(httpVersion, new HttpResponseStatus(200, "Connection established"));
        DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(httpVersion, HttpResponseStatus.SERVICE_UNAVAILABLE);
        defaultHttpResponse.headers().set("X-Surfboard-Error", (Object) "1");
        b = defaultHttpResponse;
    }
}
