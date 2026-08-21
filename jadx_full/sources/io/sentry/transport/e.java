package io.sentry.transport;

import defpackage.ha0;
import io.netty.handler.codec.http.HttpHeaders;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.m6;
import io.sentry.p5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
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
    */
    public e(SentryAndroidOptions sentryAndroidOptions, io.sentry.internal.debugmeta.c cVar, io.sentry.android.core.internal.tombstone.c cVar2) {
        Proxy proxy;
        this.b = cVar;
        this.c = sentryAndroidOptions;
        this.d = cVar2;
        m6 proxy2 = sentryAndroidOptions.getProxy();
        if (proxy2 != null) {
            String str = proxy2.b;
            String str2 = proxy2.a;
            if (str != null) {
                try {
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str2, Integer.parseInt(str)));
                } catch (NumberFormatException e2) {
                    this.c.getLogger().b(p5.ERROR, e2, ha0.o("Failed to parse Sentry Proxy port: ", str, ". Proxy is ignored"), new Object[0]);
                    proxy = null;
                }
            } else {
                proxy = null;
            }
        }
        this.a = proxy;
        if (proxy == null || sentryAndroidOptions.getProxy() == null) {
            return;
        }
        String str3 = sentryAndroidOptions.getProxy().c;
        String str4 = sentryAndroidOptions.getProxy().d;
        String str5 = sentryAndroidOptions.getProxy().a;
        if (str3 == null || str4 == null) {
            return;
        }
        Authenticator.setDefault(new l(str3, str4, str5));
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
    */
    public static String b(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        StringBuilder sb;
        boolean z;
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(errorStream, e));
                try {
                    sb = new StringBuilder();
                    z = true;
                } finally {
                }
            } finally {
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (!z) {
                    sb.append("\n");
                }
                sb.append(line);
                z = false;
            }
            String string = sb.toString();
            bufferedReader.close();
            if (errorStream != null) {
                errorStream.close();
            }
            return string;
        } catch (IOException unused) {
            return "Failed to obtain error message while analyzing send failure.";
        }
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
    */
    public final void e(HttpURLConnection httpURLConnection, int i) {
        long j;
        String[] strArr;
        double d;
        int i2;
        long j2;
        int i3;
        String[] strArr2;
        io.sentry.o oVar;
        String string;
        String headerField = httpURLConnection.getHeaderField("Retry-After");
        String headerField2 = httpURLConnection.getHeaderField("X-Sentry-Rate-Limits");
        io.sentry.android.core.internal.tombstone.c cVar = this.d;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) cVar.f;
        double d2 = 1000.0d;
        if (headerField2 == null) {
            if (i == 429) {
                if (headerField != null) {
                    try {
                        j = (long) (Double.parseDouble(headerField) * 1000.0d);
                    } catch (NumberFormatException unused) {
                        j = 60000;
                    }
                } else {
                    j = 60000;
                }
                cVar.g(io.sentry.o.All, new Date(System.currentTimeMillis() + j), j);
                return;
            }
            return;
        }
        int i4 = -1;
        String[] strArrSplit = headerField2.split(",", -1);
        int length = strArrSplit.length;
        int i5 = 0;
        int i6 = 0;
        while (i6 < length) {
            String[] strArrSplit2 = strArrSplit[i6].replace(" ", "").split(":", i4);
            if (strArrSplit2.length <= 0) {
                strArr = strArrSplit;
                d = d2;
                i2 = i5;
            } else {
                String str = strArrSplit2[i5];
                if (str != null) {
                    try {
                        j2 = (long) (Double.parseDouble(str) * d2);
                    } catch (NumberFormatException unused2) {
                        j2 = 60000;
                    }
                    if (strArrSplit2.length <= 1) {
                        String str2 = strArrSplit2[1];
                        d = d2;
                        Date date = new Date(System.currentTimeMillis() + j2);
                        if (str2 == null || str2.isEmpty()) {
                            strArr = strArrSplit;
                            i2 = i5;
                            cVar.g(io.sentry.o.All, date, j2);
                        } else {
                            String[] strArrSplit3 = str2.split(";", i4);
                            int length2 = strArrSplit3.length;
                            int i7 = i5;
                            while (i7 < length2) {
                                String str3 = strArrSplit3[i7];
                                io.sentry.o oVarValueOf = io.sentry.o.Unknown;
                                try {
                                    Charset charset = io.sentry.util.p.a;
                                    if (str3 == null || str3.isEmpty()) {
                                        i3 = i5;
                                        string = str3;
                                    } else {
                                        String[] strArrSplit4 = io.sentry.util.p.b.split(str3, i4);
                                        StringBuilder sb = new StringBuilder();
                                        i3 = i5;
                                        try {
                                            int length3 = strArrSplit4.length;
                                            int i8 = i3;
                                            while (i8 < length3) {
                                                sb.append(io.sentry.util.p.a(strArrSplit4[i8]));
                                                i8++;
                                                strArrSplit4 = strArrSplit4;
                                            }
                                            string = sb.toString();
                                        } catch (IllegalArgumentException e2) {
                                            e = e2;
                                            strArr2 = strArrSplit;
                                            ILogger logger = sentryAndroidOptions.getLogger();
                                            p5 p5Var = p5.INFO;
                                            Object[] objArr = new Object[1];
                                            objArr[i3] = str3;
                                            logger.b(p5Var, e, "Unknown category: %s", objArr);
                                            oVar = oVarValueOf;
                                            if (io.sentry.o.Unknown.equals(oVar)) {
                                            }
                                            i7++;
                                            i5 = i3;
                                            strArrSplit = strArr2;
                                            i4 = -1;
                                        }
                                    }
                                    if (string != null) {
                                        oVarValueOf = io.sentry.o.valueOf(string);
                                        strArr2 = strArrSplit;
                                    } else {
                                        ILogger logger2 = sentryAndroidOptions.getLogger();
                                        p5 p5Var2 = p5.ERROR;
                                        strArr2 = strArrSplit;
                                        try {
                                            Object[] objArr2 = new Object[1];
                                            objArr2[i3] = str3;
                                            logger2.h(p5Var2, "Couldn't capitalize: %s", objArr2);
                                        } catch (IllegalArgumentException e3) {
                                            e = e3;
                                            ILogger logger3 = sentryAndroidOptions.getLogger();
                                            p5 p5Var3 = p5.INFO;
                                            Object[] objArr3 = new Object[1];
                                            objArr3[i3] = str3;
                                            logger3.b(p5Var3, e, "Unknown category: %s", objArr3);
                                        }
                                    }
                                } catch (IllegalArgumentException e4) {
                                    e = e4;
                                    i3 = i5;
                                }
                                oVar = oVarValueOf;
                                if (io.sentry.o.Unknown.equals(oVar)) {
                                    cVar.g(oVar, date, j2);
                                }
                                i7++;
                                i5 = i3;
                                strArrSplit = strArr2;
                                i4 = -1;
                            }
                            strArr = strArrSplit;
                        }
                    }
                    i2 = i5;
                } else {
                    j2 = 60000;
                    if (strArrSplit2.length <= 1) {
                    }
                    i2 = i5;
                }
            }
            i6++;
            d2 = d;
            i5 = i2;
            strArrSplit = strArr;
            i4 = -1;
        }
    }
}
