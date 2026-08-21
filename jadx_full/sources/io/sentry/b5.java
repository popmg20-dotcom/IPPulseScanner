package io.sentry;

import defpackage.ft4;
import defpackage.ha0;
import defpackage.xe;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b5 implements Callable {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ long b;
    public final /* synthetic */ l1 c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b5(a aVar, long j, l1 l1Var, ILogger iLogger) {
        this.d = aVar;
        this.b = j;
        this.c = l1Var;
        this.e = iLogger;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws io.sentry.exception.c {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        int i = this.a;
        byte[] bArr2 = null;
        Object obj = this.e;
        l1 l1Var = this.c;
        long j = this.b;
        Object obj2 = this.d;
        switch (i) {
            case 0:
                File file = (File) obj2;
                v3 v3Var = (v3) obj;
                if (!file.exists()) {
                    throw new io.sentry.exception.c(ha0.o("Dropping profiling trace data, because the file '", file.getName(), "' doesn't exists"));
                }
                try {
                    String str = new String(io.sentry.vendor.a.b(io.sentry.util.b.p(j, file.getPath())), "US-ASCII");
                    if (str.isEmpty()) {
                        throw new io.sentry.exception.c("Profiling trace file is empty");
                    }
                    v3Var.S0 = str;
                    try {
                        v3Var.C0 = (List) v3Var.f.call();
                        break;
                    } catch (Throwable unused) {
                    }
                    try {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream2, d5.d), 512);
                                try {
                                    l1Var.a(v3Var, bufferedWriter);
                                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                    bufferedWriter.close();
                                    byteArrayOutputStream2.close();
                                    return byteArray;
                                } finally {
                                    try {
                                        break;
                                    } catch (Throwable th) {
                                    }
                                }
                            } catch (Throwable th2) {
                                try {
                                    byteArrayOutputStream2.close();
                                    break;
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        } catch (IOException e) {
                            throw new io.sentry.exception.c("Failed to serialize profiling trace data\n" + e.getMessage());
                        }
                    } finally {
                        file.delete();
                    }
                } catch (UnsupportedEncodingException e2) {
                    xe.i(e2);
                    return null;
                }
            default:
                a aVar = (a) obj2;
                ILogger iLogger = (ILogger) obj;
                byte[] bArr3 = aVar.a;
                String str2 = aVar.e;
                if (bArr3 != null) {
                    d5.a(str2, bArr3.length, j);
                    return bArr3;
                }
                io.sentry.protocol.k0 k0Var = aVar.b;
                if (k0Var != null) {
                    Charset charset = io.sentry.util.d.a;
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th4) {
                        iLogger.d(p5.ERROR, "Could not serialize serializable", th4);
                    }
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, io.sentry.util.d.a));
                        try {
                            l1Var.a(k0Var, bufferedWriter2);
                            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                            bufferedWriter2.close();
                            byteArrayOutputStream.close();
                            bArr2 = byteArray2;
                            if (bArr2 != null) {
                                d5.a(str2, bArr2.length, j);
                                return bArr2;
                            }
                        } finally {
                            try {
                                break;
                            } catch (Throwable th5) {
                            }
                        }
                    } finally {
                        try {
                            break;
                        } catch (Throwable th6) {
                        }
                    }
                } else {
                    String str3 = aVar.d;
                    if (str3 != null) {
                        return io.sentry.util.b.p(j, str3);
                    }
                    ft4 ft4Var = aVar.c;
                    if (ft4Var != null && (bArr = (byte[]) ft4Var.call()) != null) {
                        d5.a(str2, bArr.length, j);
                        return bArr;
                    }
                }
                throw new io.sentry.exception.c(ha0.o("Couldn't attach the attachment ", str2, ".\nPlease check that either bytes, serializable, path or provider is set."));
        }
    }

    public /* synthetic */ b5(File file, long j, v3 v3Var, l1 l1Var) {
        this.d = file;
        this.b = j;
        this.e = v3Var;
        this.c = l1Var;
    }
}
