package io.sentry.transport;

import io.netty.handler.codec.http.HttpHeaders;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.p5;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final Charset e = Charset.forName("UTF-8");
    public final Proxy a;
    public final io.sentry.internal.debugmeta.c b;
    public final SentryAndroidOptions c;
    public final io.sentry.android.core.internal.tombstone.c d;

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(io.sentry.android.core.SentryAndroidOptions r5, io.sentry.internal.debugmeta.c r6, io.sentry.android.core.internal.tombstone.c r7) {
        /*
            r4 = this;
            r4.<init>()
            r4.b = r6
            r4.c = r5
            r4.d = r7
            io.sentry.m6 r6 = r5.getProxy()
            if (r6 == 0) goto L3d
            java.lang.String r7 = r6.b
            java.lang.String r6 = r6.a
            if (r7 == 0) goto L3d
            java.net.Proxy$Type r0 = java.net.Proxy.Type.HTTP     // Catch: java.lang.NumberFormatException -> L26
            java.net.InetSocketAddress r1 = new java.net.InetSocketAddress     // Catch: java.lang.NumberFormatException -> L26
            int r2 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.NumberFormatException -> L26
            r1.<init>(r6, r2)     // Catch: java.lang.NumberFormatException -> L26
            java.net.Proxy r6 = new java.net.Proxy     // Catch: java.lang.NumberFormatException -> L26
            r6.<init>(r0, r1)     // Catch: java.lang.NumberFormatException -> L26
            goto L3e
        L26:
            r6 = move-exception
            io.sentry.android.core.SentryAndroidOptions r0 = r4.c
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.p5 r1 = io.sentry.p5.ERROR
            java.lang.String r2 = "Failed to parse Sentry Proxy port: "
            java.lang.String r3 = ". Proxy is ignored"
            java.lang.String r7 = defpackage.ha0.o(r2, r7, r3)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.b(r1, r6, r7, r2)
        L3d:
            r6 = 0
        L3e:
            r4.a = r6
            if (r6 == 0) goto L66
            io.sentry.m6 r4 = r5.getProxy()
            if (r4 == 0) goto L66
            io.sentry.m6 r4 = r5.getProxy()
            java.lang.String r4 = r4.c
            io.sentry.m6 r6 = r5.getProxy()
            java.lang.String r6 = r6.d
            io.sentry.m6 r5 = r5.getProxy()
            java.lang.String r5 = r5.a
            if (r4 == 0) goto L66
            if (r6 == 0) goto L66
            io.sentry.transport.l r7 = new io.sentry.transport.l
            r7.<init>(r4, r6, r5)
            java.net.Authenticator.setDefault(r7)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.e.<init>(io.sentry.android.core.SentryAndroidOptions, io.sentry.internal.debugmeta.c, io.sentry.android.core.internal.tombstone.c):void");
    }

    public static void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } finally {
            httpURLConnection.disconnect();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.net.HttpURLConnection r4) {
        /*
            java.io.InputStream r4 = r4.getErrorStream()     // Catch: java.io.IOException -> L4e
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L38
            java.nio.charset.Charset r2 = io.sentry.transport.e.e     // Catch: java.lang.Throwable -> L38
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L38
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r1.<init>()     // Catch: java.lang.Throwable -> L24
            r2 = 1
        L16:
            java.lang.String r3 = r0.readLine()     // Catch: java.lang.Throwable -> L24
            if (r3 == 0) goto L2b
            if (r2 != 0) goto L26
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch: java.lang.Throwable -> L24
            goto L26
        L24:
            r1 = move-exception
            goto L3a
        L26:
            r1.append(r3)     // Catch: java.lang.Throwable -> L24
            r2 = 0
            goto L16
        L2b:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L24
            r0.close()     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L37
            r4.close()     // Catch: java.io.IOException -> L4e
        L37:
            return r1
        L38:
            r0 = move-exception
            goto L43
        L3a:
            r0.close()     // Catch: java.lang.Throwable -> L3e
            goto L42
        L3e:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch: java.lang.Throwable -> L38
        L42:
            throw r1     // Catch: java.lang.Throwable -> L38
        L43:
            if (r4 == 0) goto L4d
            r4.close()     // Catch: java.lang.Throwable -> L49
            goto L4d
        L49:
            r4 = move-exception
            r0.addSuppressed(r4)     // Catch: java.io.IOException -> L4e
        L4d:
            throw r0     // Catch: java.io.IOException -> L4e
        L4e:
            java.lang.String r4 = "Failed to obtain error message while analyzing send failure."
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.e.b(java.net.HttpURLConnection):java.lang.String");
    }

    public final io.sentry.config.a c(HttpURLConnection httpURLConnection) {
        p5 p5Var;
        SentryAndroidOptions sentryAndroidOptions = this.c;
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                e(httpURLConnection, responseCode);
                if (responseCode == 200) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Envelope sent successfully.", new Object[0]);
                    return r.a;
                }
                if (responseCode == 413) {
                    ILogger logger = sentryAndroidOptions.getLogger();
                    p5Var = p5.ERROR;
                    logger.h(p5Var, "Envelope was discarded by the server because it was too large. Consider reducing the size of events, breadcrumbs, or attachments. You can use the `SentryOptions.onOversizedEvent` callback to customize how oversized events are handled.", new Object[0]);
                } else {
                    ILogger logger2 = sentryAndroidOptions.getLogger();
                    p5Var = p5.ERROR;
                    logger2.h(p5Var, "Request failed, API returned %s", Integer.valueOf(responseCode));
                }
                if (sentryAndroidOptions.isDebug()) {
                    sentryAndroidOptions.getLogger().h(p5Var, "%s", b(httpURLConnection));
                }
                return new q(responseCode);
            } catch (IOException e2) {
                sentryAndroidOptions.getLogger().b(p5.ERROR, e2, "Error reading and logging the response stream", new Object[0]);
                a(httpURLConnection);
                return new q(-1);
            }
        } finally {
            a(httpURLConnection);
        }
    }

    public final io.sentry.config.a d(io.sentry.internal.debugmeta.c cVar) {
        SentryAndroidOptions sentryAndroidOptions = this.c;
        sentryAndroidOptions.getSocketTagger().e();
        io.sentry.internal.debugmeta.c cVar2 = this.b;
        URL url = (URL) cVar2.f;
        Proxy proxy = this.a;
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
        for (Map.Entry entry : ((HashMap) cVar2.z).entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-sentry-envelope");
        httpURLConnection.setRequestProperty("Accept", HttpHeaders.Values.APPLICATION_JSON);
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setConnectTimeout(sentryAndroidOptions.getConnectionTimeoutMillis());
        httpURLConnection.setReadTimeout(sentryAndroidOptions.getReadTimeoutMillis());
        SSLSocketFactory sslSocketFactory = sentryAndroidOptions.getSslSocketFactory();
        if ((httpURLConnection instanceof HttpsURLConnection) && sslSocketFactory != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sslSocketFactory);
        }
        httpURLConnection.connect();
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    sentryAndroidOptions.getSerializer().e(cVar, gZIPOutputStream);
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } finally {
                }
            } finally {
            }
        } finally {
            try {
            } finally {
            }
        }
        return c(httpURLConnection);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.net.HttpURLConnection r23, int r24) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.e.e(java.net.HttpURLConnection, int):void");
    }
}
