package defpackage;

import android.os.Process;
import android.util.Log;
import com.getsurfboard.ui.service.ExplorerService;
import com.tencent.mars.xlog.Xlog;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.CharsetUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u81 extends SimpleChannelInboundHandler {
    public final ExplorerService b;
    public final iq1 f = new iq1();
    public final ConcurrentHashMap A = new ConcurrentHashMap();

    public u81(ExplorerService explorerService) {
        this.b = explorerService;
    }

    public static void C(ChannelHandlerContext channelHandlerContext, File file) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(le1.T(file)));
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"");
        channelHandlerContext.writeAndFlush(defaultFullHttpResponse);
    }

    public static void F(ChannelHandlerContext channelHandlerContext, String str) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/json; charset=UTF-8");
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
        channelHandlerContext.writeAndFlush(defaultFullHttpResponse);
    }

    public static void I(ChannelHandlerContext channelHandlerContext, HttpResponseStatus httpResponseStatus, String str) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, httpResponseStatus, Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/json; charset=UTF-8");
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
        channelHandlerContext.writeAndFlush(defaultFullHttpResponse);
    }

    public static void M(ChannelHandlerContext channelHandlerContext, String str) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
        channelHandlerContext.writeAndFlush(defaultFullHttpResponse);
    }

    public static Serializable N(String str, String str2) {
        byte[] bytes = str2.getBytes(y30.a);
        bytes.getClass();
        return c63.j(str, new ByteArrayInputStream(bytes), k01.A, t60.Y, vd3.A, null);
    }

    @Override // io.netty.channel.SimpleChannelInboundHandler
    public final void channelRead0(ChannelHandlerContext channelHandlerContext, Object obj) {
        int iV0;
        FullHttpRequest fullHttpRequest = (FullHttpRequest) obj;
        channelHandlerContext.getClass();
        fullHttpRequest.getClass();
        if (!fullHttpRequest.decoderResult().isSuccess()) {
            HttpResponseStatus httpResponseStatus = HttpResponseStatus.BAD_REQUEST;
            httpResponseStatus.getClass();
            s(channelHandlerContext, httpResponseStatus, null);
            return;
        }
        String strUri = fullHttpRequest.uri();
        strUri.getClass();
        if (w44.j0(strUri, "/api/v1/", false)) {
            String strPath = new QueryStringDecoder(fullHttpRequest.uri()).path();
            HttpMethod httpMethodMethod = fullHttpRequest.method();
            uh3 uh3Var = new uh3("/api/v1/files");
            uh3 uh3Var2 = new uh3("/api/v1/files/([^/]+)");
            uh3 uh3Var3 = new uh3("/api/v1/files/([^/]+)/content");
            uh3 uh3Var4 = new uh3("/api/v1/files/([^/]+)/rename");
            uh3 uh3Var5 = new uh3("/api/v1/files/([^/]+)/copy");
            uh3 uh3Var6 = new uh3("/api/v1/files/([^/]+)/download");
            uh3 uh3Var7 = new uh3("/api/v1/upload");
            uh3 uh3Var8 = new uh3("/api/v1/import-url");
            uh3 uh3Var9 = new uh3("/api/v1/import-url/([^/]+)");
            FullHttpRequest fullHttpRequestRetainedDuplicate = fullHttpRequest.retainedDuplicate();
            gm0 gm0Var = qv0.a;
            ji0.B(p95.a(pl0.z), null, null, new s81(uh3Var, strPath, httpMethodMethod, this, channelHandlerContext, uh3Var3, fullHttpRequestRetainedDuplicate, uh3Var7, uh3Var4, uh3Var5, uh3Var2, uh3Var6, uh3Var8, uh3Var9, null), 3);
            return;
        }
        if (!n12.c(fullHttpRequest.method(), HttpMethod.GET)) {
            HttpResponseStatus httpResponseStatus2 = HttpResponseStatus.METHOD_NOT_ALLOWED;
            httpResponseStatus2.getClass();
            s(channelHandlerContext, httpResponseStatus2, null);
            return;
        }
        if (p44.o0(strUri, "?", false) && (iV0 = p44.v0(strUri, "?", 0, false, 6)) != -1) {
            strUri = strUri.substring(0, iV0);
        }
        if (strUri.equals("/")) {
            strUri = "/index.html";
        }
        if (p44.o0(strUri, "..", false) || p44.o0(strUri, "//", false)) {
            HttpResponseStatus httpResponseStatus3 = HttpResponseStatus.FORBIDDEN;
            httpResponseStatus3.getClass();
            s(channelHandlerContext, httpResponseStatus3, null);
            return;
        }
        String strConcat = "explorer".concat(strUri);
        try {
            InputStream inputStreamOpen = this.b.getAssets().open(strConcat);
            inputStreamOpen.getClass();
            byte[] bArrS = l72.S(inputStreamOpen);
            inputStreamOpen.close();
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(bArrS));
            defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
            String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(strConcat);
            if (strGuessContentTypeFromName == null) {
                strGuessContentTypeFromName = HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE;
            }
            if (w44.d0(strConcat, ".html", false)) {
                strGuessContentTypeFromName = "text/html";
            } else if (w44.d0(strConcat, ".js", false)) {
                strGuessContentTypeFromName = "application/javascript";
            } else if (w44.d0(strConcat, ".css", false)) {
                strGuessContentTypeFromName = "text/css";
            } else if (w44.d0(strConcat, ".json", false)) {
                strGuessContentTypeFromName = HttpHeaders.Values.APPLICATION_JSON;
            } else if (w44.d0(strConcat, ".svg", false)) {
                strGuessContentTypeFromName = "image/svg+xml";
            }
            defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, strGuessContentTypeFromName);
            defaultFullHttpResponse.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            channelHandlerContext.writeAndFlush(defaultFullHttpResponse);
        } catch (FileNotFoundException e) {
            String strN = ha0.n("File not found: ", e.getMessage());
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("ExplorerServer", strN, null);
            }
            HttpResponseStatus httpResponseStatus4 = HttpResponseStatus.NOT_FOUND;
            httpResponseStatus4.getClass();
            s(channelHandlerContext, httpResponseStatus4, e.getMessage());
        } catch (Exception e2) {
            e2.printStackTrace();
            String strN2 = ha0.n("Error serving file: ", e2.getMessage());
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "ExplorerServer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN2);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("ExplorerServer", strN2, null);
            }
            HttpResponseStatus httpResponseStatus5 = HttpResponseStatus.INTERNAL_SERVER_ERROR;
            httpResponseStatus5.getClass();
            s(channelHandlerContext, httpResponseStatus5, e2.getMessage());
        }
    }

    public final void g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Set setEntrySet = this.A.entrySet();
        setEntrySet.getClass();
        d70.a0(setEntrySet, new r81(jCurrentTimeMillis, 0), true);
    }

    public final void n(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        HttpPostRequestDecoder httpPostRequestDecoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE), fullHttpRequest);
        ArrayList arrayList = new ArrayList();
        gm0 gm0Var = qv0.a;
        ji0.B(p95.a(pl0.z), null, null, new t81(httpPostRequestDecoder, this, channelHandlerContext, arrayList, null), 3);
    }

    public final void s(ChannelHandlerContext channelHandlerContext, HttpResponseStatus httpResponseStatus, String str) {
        String string = null;
        if (str != null) {
            hb2 hb2Var = new hb2(str);
            String str2 = (String) (!hb2Var.hasNext() ? null : hb2Var.next());
            if (str2 != null) {
                string = p44.U0(str2).toString();
            }
        }
        g62 g62Var = new g62();
        g62Var.f("success", Boolean.FALSE);
        if (string == null) {
            string = "Failure: " + httpResponseStatus;
        }
        g62Var.g("message", string);
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, httpResponseStatus, Unpooled.copiedBuffer(this.f.g(g62Var), CharsetUtil.UTF_8));
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/json; charset=UTF-8");
        defaultFullHttpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(defaultFullHttpResponse.content().readableBytes()));
        channelHandlerContext.writeAndFlush(defaultFullHttpResponse).addListener2(ChannelFutureListener.CLOSE);
    }
}
