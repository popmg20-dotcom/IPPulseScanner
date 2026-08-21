package io.sentry;

import defpackage.bx1;
import defpackage.ft4;
import defpackage.ha0;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d5 {
    public static final Charset d = Charset.forName("UTF-8");
    public final e5 a;
    public final Callable b;
    public byte[] c;

    public d5(e5 e5Var, byte[] bArr) {
        this.a = e5Var;
        this.c = bArr;
        this.b = null;
    }

    public static void a(String str, long j, long j2) throws io.sentry.exception.c {
        if (j > j2) {
            throw new io.sentry.exception.c(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static d5 b(l1 l1Var, io.sentry.clientreport.b bVar) {
        io.sentry.util.b.r(l1Var, "ISerializer is required.");
        io.sentry.internal.debugmeta.c cVar = new io.sentry.internal.debugmeta.c(new ft4(5, l1Var, bVar));
        return new d5(new e5(o5.resolve(bVar), new z4(cVar, 11), HttpHeaders.Values.APPLICATION_JSON, null, null), new z4(cVar, 12));
    }

    public static d5 c(s3 s3Var, l1 l1Var) throws io.sentry.exception.c {
        File file = s3Var.C0;
        if (file == null || !file.exists()) {
            throw new io.sentry.exception.c(ha0.o("Dropping perfetto profile chunk, because the trace file '", file != null ? file.getName() : "null", "' doesn't exist"));
        }
        AtomicReference atomicReference = new AtomicReference(null);
        io.sentry.internal.debugmeta.c cVar = new io.sentry.internal.debugmeta.c(new a5(l1Var, s3Var, atomicReference, file));
        return new d5(new e5(o5.ProfileChunk, -1, new z4(cVar, 4), s3Var.B0, file.getName(), null, s3Var.Y, null, new bx1(2, atomicReference)), new z4(cVar, 5));
    }

    public static d5 d(s3 s3Var, l1 l1Var, c1 c1Var) {
        File file = s3Var.C0;
        io.sentry.internal.debugmeta.c cVar = new io.sentry.internal.debugmeta.c(new a5(file, s3Var, c1Var, l1Var));
        return new d5(new e5(o5.ProfileChunk, new z4(cVar, 2), "application-json", file != null ? file.getName() : null, null, s3Var.Y, null), new z4(cVar, 3));
    }

    public static d5 e(l1 l1Var, z6 z6Var) {
        io.sentry.util.b.r(l1Var, "ISerializer is required.");
        io.sentry.util.b.r(z6Var, "Session is required.");
        io.sentry.internal.debugmeta.c cVar = new io.sentry.internal.debugmeta.c(new ft4(6, l1Var, z6Var));
        return new d5(new e5(o5.Session, new z4(cVar, 16), HttpHeaders.Values.APPLICATION_JSON, null, null), new z4(cVar, 17));
    }

    public static byte[] k(LinkedHashMap linkedHashMap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write((byte) (linkedHashMap.size() | 128));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                byte[] bytes = ((String) entry.getKey()).getBytes(d);
                int length = bytes.length;
                byteArrayOutputStream.write(-39);
                byteArrayOutputStream.write((byte) length);
                byteArrayOutputStream.write(bytes);
                byte[] bArr = (byte[]) entry.getValue();
                int length2 = bArr.length;
                byteArrayOutputStream.write(-58);
                byteArrayOutputStream.write(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(length2).array());
                byteArrayOutputStream.write(bArr);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final io.sentry.clientreport.b f(l1 l1Var) throws IOException {
        if (this.a.X != o5.ClientReport) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(g()), d));
        try {
            io.sentry.clientreport.b bVar = (io.sentry.clientreport.b) l1Var.b(bufferedReader, io.sentry.clientreport.b.class);
            bufferedReader.close();
            return bVar;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final byte[] g() {
        Callable callable;
        byte[] bArr = this.c;
        if (bArr != null || (callable = this.b) == null) {
            return bArr;
        }
        byte[] bArr2 = (byte[]) callable.call();
        this.c = bArr2;
        return bArr2;
    }

    public final s5 h(l1 l1Var) throws IOException {
        if (this.a.X != o5.Log) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(g()), d));
        try {
            s5 s5Var = (s5) l1Var.b(bufferedReader, s5.class);
            bufferedReader.close();
            return s5Var;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final w5 i(l1 l1Var) throws IOException {
        if (this.a.X != o5.TraceMetric) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(g()), d));
        try {
            w5 w5Var = (w5) l1Var.b(bufferedReader, w5.class);
            bufferedReader.close();
            return w5Var;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final io.sentry.protocol.f0 j(l1 l1Var) throws IOException {
        if (this.a.X != o5.Transaction) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(g()), d));
        try {
            io.sentry.protocol.f0 f0Var = (io.sentry.protocol.f0) l1Var.b(bufferedReader, io.sentry.protocol.f0.class);
            bufferedReader.close();
            return f0Var;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public d5(e5 e5Var, Callable callable) {
        this.a = e5Var;
        this.b = callable;
        this.c = null;
    }
}
