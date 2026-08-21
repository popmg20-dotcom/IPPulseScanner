package defpackage;

import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x65 implements Runnable {
    public final String A;
    public final Map X;
    public final Object Y;
    public final /* synthetic */ k70 Z;
    public final /* synthetic */ int b = 1;
    public final URL f;
    public final byte[] z;

    public x65(z65 z65Var, String str, URL url, byte[] bArr, Map map, v65 v65Var) {
        Objects.requireNonNull(z65Var);
        this.Z = z65Var;
        tj4.f(str);
        tj4.i(url);
        this.f = url;
        this.z = bArr;
        this.Y = v65Var;
        this.A = str;
        this.X = map;
    }

    public void a(int i, IOException iOException, byte[] bArr, Map map) {
        f85 f85Var = ((k85) ((mb5) this.Z).f).Z;
        k85.h(f85Var);
        f85Var.e1(new mf(this, i, iOException, bArr, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f5 A[Catch: all -> 0x00f9, LOOP:0: B:40:0x00ef->B:42:0x00f5, LOOP_END, TryCatch #11 {all -> 0x00f9, blocks: (B:39:0x00ed, B:40:0x00ef, B:42:0x00f5, B:45:0x00fb), top: B:184:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0178  */
    /* JADX WARN: Type inference failed for: r24v0, types: [x65] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.Map] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        Throwable th;
        int responseCode;
        HttpURLConnection httpURLConnection;
        Map map;
        IOException iOException;
        HttpURLConnection httpURLConnection2;
        Map map2;
        o65 o65Var;
        f85 f85Var;
        URLConnection uRLConnectionOpenConnection;
        Map<String, List<String>> headerFields;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        Throwable th2;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection3;
        ?? r6;
        IOException iOException2;
        OutputStream outputStream2;
        HttpURLConnection httpURLConnection4;
        ?? r5;
        URLConnection uRLConnectionOpenConnection2;
        String str;
        Object obj;
        int responseCode2;
        String str2;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr2;
        int i;
        int i2 = this.b;
        String str3 = "Content-Encoding";
        byte[] bArr3 = this.z;
        Map map3 = this.X;
        URL url = this.f;
        k70 k70Var = this.Z;
        int i3 = 0;
        String str4 = this.A;
        switch (i2) {
            case 0:
                OutputStream outputStream3 = null;
                v65 v65Var = (v65) this.Y;
                z65 z65Var = (z65) k70Var;
                k85 k85Var = (k85) z65Var.f;
                k85 k85Var2 = (k85) z65Var.f;
                f85 f85Var2 = k85Var.Z;
                k85.h(f85Var2);
                f85Var2.Z0();
                try {
                    uRLConnectionOpenConnection = url.openConnection();
                } catch (IOException e) {
                    iOException = e;
                    responseCode = 0;
                    httpURLConnection2 = null;
                    map2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    responseCode = 0;
                    httpURLConnection = null;
                    map = null;
                }
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new IOException("Failed to obtain HTTP connection");
                }
                httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
                httpURLConnection2.setDefaultUseCaches(false);
                x15 x15Var = k85Var2.A;
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.setReadTimeout(61000);
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setDoInput(true);
                if (map3 != null) {
                    try {
                        for (Map.Entry entry : map3.entrySet()) {
                            httpURLConnection2.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    } catch (IOException e2) {
                        iOException = e2;
                        responseCode = 0;
                        map2 = null;
                        if (outputStream3 != null) {
                        }
                        if (httpURLConnection2 != null) {
                        }
                        f85Var = k85Var2.Z;
                        k85.h(f85Var);
                        o65Var = new o65(this.A, v65Var, responseCode, iOException, (byte[]) null, map2);
                        f85Var.e1(o65Var);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection = httpURLConnection2;
                        responseCode = 0;
                        map = null;
                        th = th;
                        if (outputStream3 != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        f85 f85Var3 = k85Var2.Z;
                        k85.h(f85Var3);
                        f85Var3.e1(new o65(this.A, v65Var, responseCode, (IOException) null, (byte[]) null, map));
                        throw th;
                    }
                }
                if (bArr3 != null) {
                    z65 z65Var2 = z65Var.X.Z;
                    ff5.R(z65Var2);
                    byte[] bArrH1 = z65Var2.H1(bArr3);
                    t65 t65Var = k85Var2.Y;
                    k85.h(t65Var);
                    q65 q65Var = t65Var.H0;
                    int length = bArrH1.length;
                    q65Var.b(Integer.valueOf(length), "Uploading data. size");
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection2.setFixedLengthStreamingMode(length);
                    httpURLConnection2.connect();
                    OutputStream outputStream4 = httpURLConnection2.getOutputStream();
                    try {
                        outputStream4.write(bArrH1);
                        outputStream4.close();
                    } catch (IOException e3) {
                        iOException = e3;
                        responseCode = 0;
                        map2 = null;
                        outputStream3 = outputStream4;
                        if (outputStream3 != null) {
                        }
                        if (httpURLConnection2 != null) {
                        }
                        f85Var = k85Var2.Z;
                        k85.h(f85Var);
                        o65Var = new o65(this.A, v65Var, responseCode, iOException, (byte[]) null, map2);
                        f85Var.e1(o65Var);
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        responseCode = 0;
                        map = null;
                        outputStream3 = outputStream4;
                        httpURLConnection = httpURLConnection2;
                        th = th;
                        if (outputStream3 != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        f85 f85Var32 = k85Var2.Z;
                        k85.h(f85Var32);
                        f85Var32.e1(new o65(this.A, v65Var, responseCode, (IOException) null, (byte[]) null, map));
                        throw th;
                    }
                }
                responseCode = httpURLConnection2.getResponseCode();
                try {
                    try {
                        headerFields = httpURLConnection2.getHeaderFields();
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            inputStream = httpURLConnection2.getInputStream();
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream = null;
                        }
                        try {
                            bArr = new byte[1024];
                        } catch (Throwable th7) {
                            th = th7;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        iOException = e4;
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (IOException e5) {
                                t65 t65Var2 = k85Var2.Y;
                                k85.h(t65Var2);
                                t65Var2.z0.c("Error closing HTTP compressed POST connection output stream. appId", t65.Z0(str4), e5);
                            }
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        f85Var = k85Var2.Z;
                        k85.h(f85Var);
                        o65Var = new o65(this.A, v65Var, responseCode, iOException, (byte[]) null, map2);
                        break;
                    } catch (Throwable th8) {
                        th = th8;
                        httpURLConnection = httpURLConnection2;
                        th = th;
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (IOException e6) {
                                t65 t65Var3 = k85Var2.Y;
                                k85.h(t65Var3);
                                t65Var3.z0.c("Error closing HTTP compressed POST connection output stream. appId", t65.Z0(str4), e6);
                            }
                            break;
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        f85 f85Var322 = k85Var2.Z;
                        k85.h(f85Var322);
                        f85Var322.e1(new o65(this.A, v65Var, responseCode, (IOException) null, (byte[]) null, map));
                        throw th;
                    }
                } catch (IOException e7) {
                    iOException = e7;
                    map2 = null;
                    if (outputStream3 != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                    f85Var = k85Var2.Z;
                    k85.h(f85Var);
                    o65Var = new o65(this.A, v65Var, responseCode, iOException, (byte[]) null, map2);
                    f85Var.e1(o65Var);
                    return;
                } catch (Throwable th9) {
                    th = th9;
                    httpURLConnection = httpURLConnection2;
                    map = null;
                    th = th;
                    if (outputStream3 != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    f85 f85Var3222 = k85Var2.Z;
                    k85.h(f85Var3222);
                    f85Var3222.e1(new o65(this.A, v65Var, responseCode, (IOException) null, (byte[]) null, map));
                    throw th;
                }
                while (true) {
                    int i4 = inputStream.read(bArr);
                    if (i4 <= 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        inputStream.close();
                        httpURLConnection2.disconnect();
                        f85Var = k85Var2.Z;
                        k85.h(f85Var);
                        o65Var = new o65(this.A, v65Var, responseCode, (IOException) null, byteArray, headerFields);
                        f85Var.e1(o65Var);
                        return;
                    }
                    byteArrayOutputStream.write(bArr, 0, i4);
                }
                break;
                break;
            default:
                mb5 mb5Var = (mb5) k70Var;
                k85 k85Var3 = (k85) mb5Var.f;
                k85 k85Var4 = (k85) mb5Var.f;
                f85 f85Var4 = k85Var3.Z;
                k85.h(f85Var4);
                f85Var4.Z0();
                try {
                    uRLConnectionOpenConnection2 = url.openConnection();
                } catch (IOException e8) {
                    iOException2 = e8;
                    outputStream2 = null;
                    httpURLConnection4 = null;
                } catch (Throwable th10) {
                    th2 = th10;
                    outputStream = null;
                    httpURLConnection3 = null;
                    r6 = 0;
                }
                if (!(uRLConnectionOpenConnection2 instanceof HttpURLConnection)) {
                    throw new IOException("Failed to obtain HTTP connection");
                }
                HttpURLConnection httpURLConnection5 = (HttpURLConnection) uRLConnectionOpenConnection2;
                httpURLConnection5.setDefaultUseCaches(false);
                x15 x15Var2 = k85Var4.A;
                httpURLConnection5.setConnectTimeout(60000);
                httpURLConnection5.setReadTimeout(61000);
                httpURLConnection5.setInstanceFollowRedirects(false);
                httpURLConnection5.setDoInput(true);
                if (map3 != null) {
                    try {
                        try {
                            for (Map.Entry entry2 : map3.entrySet()) {
                                httpURLConnection5.addRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
                            }
                            if (bArr3 != null) {
                                try {
                                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream3);
                                    gZIPOutputStream.write(bArr3);
                                    gZIPOutputStream.close();
                                    byteArrayOutputStream3.close();
                                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                                    t65 t65Var4 = k85Var4.Y;
                                    k85.h(t65Var4);
                                    q65 q65Var2 = t65Var4.H0;
                                    int length2 = byteArray2.length;
                                    q65Var2.b(Integer.valueOf(length2), "Uploading data. size");
                                    httpURLConnection5.setDoOutput(true);
                                    httpURLConnection5.addRequestProperty("Content-Encoding", "gzip");
                                    httpURLConnection5.setFixedLengthStreamingMode(length2);
                                    httpURLConnection5.connect();
                                    outputStream = httpURLConnection5.getOutputStream();
                                    try {
                                        outputStream.write(byteArray2);
                                        outputStream.close();
                                    } catch (IOException e9) {
                                        iOException2 = e9;
                                        outputStream2 = outputStream;
                                        httpURLConnection4 = httpURLConnection5;
                                        r5 = 0;
                                        if (outputStream2 != null) {
                                        }
                                        if (httpURLConnection4 != null) {
                                        }
                                        a(i3, iOException2, null, r5);
                                        return;
                                    } catch (Throwable th11) {
                                        th = th11;
                                        httpURLConnection3 = httpURLConnection5;
                                        obj = null;
                                        th2 = th;
                                        r6 = obj;
                                        if (outputStream != null) {
                                        }
                                        if (httpURLConnection3 != null) {
                                        }
                                        a(i3, null, null, r6);
                                        throw th2;
                                    }
                                } catch (IOException e10) {
                                    t65 t65Var5 = k85Var4.Y;
                                    k85.h(t65Var5);
                                    t65Var5.z0.b(e10, "Failed to gzip post request content");
                                    throw e10;
                                }
                            }
                            responseCode2 = httpURLConnection5.getResponseCode();
                        } catch (IOException e11) {
                            e = e11;
                            httpURLConnection4 = httpURLConnection5;
                            str = null;
                            iOException2 = e;
                            outputStream2 = null;
                            r5 = str;
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e12) {
                                    t65 t65Var6 = k85Var4.Y;
                                    k85.h(t65Var6);
                                    t65Var6.z0.c("Error closing HTTP compressed POST connection output stream. appId", t65.Z0(str4), e12);
                                }
                                break;
                            }
                            if (httpURLConnection4 != null) {
                                httpURLConnection4.disconnect();
                            }
                            a(i3, iOException2, null, r5);
                            return;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        httpURLConnection3 = httpURLConnection5;
                        outputStream = null;
                        obj = null;
                        th2 = th;
                        r6 = obj;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection3 != null) {
                        }
                        a(i3, null, null, r6);
                        throw th2;
                    }
                    try {
                        try {
                            Map<String, List<String>> headerFields2 = httpURLConnection5.getHeaderFields();
                            try {
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                                inputStream2 = httpURLConnection5.getInputStream();
                                try {
                                    bArr2 = new byte[1024];
                                    while (true) {
                                        i = inputStream2.read(bArr2);
                                        if (i > 0) {
                                            byte[] byteArray3 = byteArrayOutputStream2.toByteArray();
                                            inputStream2.close();
                                            httpURLConnection5.disconnect();
                                            a(responseCode2, null, byteArray3, headerFields2);
                                            return;
                                        }
                                        byteArrayOutputStream2.write(bArr2, 0, i);
                                    }
                                } catch (Throwable th13) {
                                    th = th13;
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th14) {
                                th = th14;
                                inputStream2 = null;
                            }
                        } catch (IOException e13) {
                            e = e13;
                            i3 = responseCode2;
                            str2 = null;
                            httpURLConnection4 = httpURLConnection5;
                            str = str2;
                            iOException2 = e;
                            outputStream2 = null;
                            r5 = str;
                            if (outputStream2 != null) {
                            }
                            if (httpURLConnection4 != null) {
                            }
                            a(i3, iOException2, null, r5);
                            return;
                        } catch (Throwable th15) {
                            th = th15;
                            httpURLConnection3 = httpURLConnection5;
                            i3 = responseCode2;
                            outputStream = null;
                            obj = null;
                            th2 = th;
                            r6 = obj;
                            if (outputStream != null) {
                            }
                            if (httpURLConnection3 != null) {
                            }
                            a(i3, null, null, r6);
                            throw th2;
                        }
                    } catch (IOException e14) {
                        e = e14;
                        i3 = responseCode2;
                        str2 = str3;
                        httpURLConnection4 = httpURLConnection5;
                        str = str2;
                        iOException2 = e;
                        outputStream2 = null;
                        r5 = str;
                        if (outputStream2 != null) {
                        }
                        if (httpURLConnection4 != null) {
                        }
                        a(i3, iOException2, null, r5);
                        return;
                    } catch (Throwable th16) {
                        th = th16;
                        i3 = responseCode2;
                        obj = "Content-Encoding";
                        outputStream = null;
                        httpURLConnection3 = httpURLConnection5;
                        th2 = th;
                        r6 = obj;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection3 != null) {
                        }
                        a(i3, null, null, r6);
                        throw th2;
                    }
                    break;
                } else {
                    if (bArr3 != null) {
                    }
                    responseCode2 = httpURLConnection5.getResponseCode();
                    Map<String, List<String>> headerFields22 = httpURLConnection5.getHeaderFields();
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    inputStream2 = httpURLConnection5.getInputStream();
                    bArr2 = new byte[1024];
                    while (true) {
                        i = inputStream2.read(bArr2);
                        if (i > 0) {
                        }
                        byteArrayOutputStream2.write(bArr2, 0, i);
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e15) {
                        t65 t65Var7 = k85Var4.Y;
                        k85.h(t65Var7);
                        t65Var7.z0.c("Error closing HTTP compressed POST connection output stream. appId", t65.Z0(str4), e15);
                    }
                    break;
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                a(i3, null, null, r6);
                throw th2;
        }
    }

    public x65(mb5 mb5Var, String str, URL url, byte[] bArr, HashMap map, lb5 lb5Var) {
        Objects.requireNonNull(mb5Var);
        this.Z = mb5Var;
        tj4.f(str);
        this.f = url;
        this.z = bArr;
        this.Y = lb5Var;
        this.A = str;
        this.X = map;
    }
}
