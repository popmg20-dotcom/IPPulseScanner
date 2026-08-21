package io.sentry.android.core;

import io.sentry.p5;
import io.sentry.q2;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d1 {
    public boolean a;
    public final Object b;
    public final Object c;

    public d1(SentryAndroidOptions sentryAndroidOptions) {
        this.c = new ArrayList();
        this.a = false;
        this.b = sentryAndroidOptions;
    }

    public static void d(BufferedInputStream bufferedInputStream, long j) {
        while (j > 0) {
            long jSkip = bufferedInputStream.skip(j);
            if (jSkip != 0) {
                j -= jSkip;
            } else {
                if (bufferedInputStream.read() == -1) {
                    throw new EOFException("Unexpected end of stream while skipping bytes");
                }
                j--;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[Catch: all -> 0x0045, TryCatch #1 {all -> 0x0045, blocks: (B:5:0x0011, B:6:0x001d, B:8:0x0025, B:21:0x0058, B:13:0x0038, B:15:0x0040, B:18:0x0047, B:20:0x004f, B:24:0x005f, B:27:0x0069), top: B:50:0x0011, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.android.core.c1 a(java.io.BufferedInputStream r9, int r10, java.io.File r11) {
        /*
            r8 = this;
            java.lang.Object r8 = r8.b
            io.sentry.android.core.SentryAndroidOptions r8 = (io.sentry.android.core.SentryAndroidOptions) r8
            r0 = 0
            io.sentry.android.core.b1 r1 = new io.sentry.android.core.b1     // Catch: java.lang.Throwable -> L7a
            r1.<init>(r9, r10)     // Catch: java.lang.Throwable -> L7a
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L7c
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L7c
            r9.<init>(r1, r10)     // Catch: java.lang.Throwable -> L7c
            io.sentry.i2 r10 = new io.sentry.i2     // Catch: java.lang.Throwable -> L45
            r10.<init>(r9)     // Catch: java.lang.Throwable -> L45
            io.sentry.vendor.gson.stream.a r2 = r10.b     // Catch: java.lang.Throwable -> L45
            r10.p0()     // Catch: java.lang.Throwable -> L45
            r3 = r0
            r4 = r3
        L1d:
            io.sentry.vendor.gson.stream.b r5 = r2.peek()     // Catch: java.lang.Throwable -> L45
            io.sentry.vendor.gson.stream.b r6 = io.sentry.vendor.gson.stream.b.NAME     // Catch: java.lang.Throwable -> L45
            if (r5 != r6) goto L5f
            java.lang.String r5 = r2.R()     // Catch: java.lang.Throwable -> L45
            int r6 = r5.hashCode()     // Catch: java.lang.Throwable -> L45
            r7 = 55126294(0x3492916, float:5.9115755E-37)
            if (r6 == r7) goto L47
            r7 = 1874684019(0x6fbd6873, float:1.1723788E29)
            if (r6 == r7) goto L38
            goto L58
        L38:
            java.lang.String r6 = "platform"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L45
            if (r5 == 0) goto L58
            java.lang.String r3 = r10.G()     // Catch: java.lang.Throwable -> L45
            goto L5b
        L45:
            r10 = move-exception
            goto L7e
        L47:
            java.lang.String r6 = "timestamp"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L45
            if (r5 == 0) goto L58
            io.sentry.ILogger r4 = r8.getLogger()     // Catch: java.lang.Throwable -> L45
            java.util.Date r4 = r10.Y(r4)     // Catch: java.lang.Throwable -> L45
            goto L5b
        L58:
            r10.t()     // Catch: java.lang.Throwable -> L45
        L5b:
            if (r3 == 0) goto L1d
            if (r4 == 0) goto L1d
        L5f:
            java.lang.String r10 = "native"
            boolean r10 = r10.equals(r3)     // Catch: java.lang.Throwable -> L45
            if (r10 == 0) goto L73
            if (r4 == 0) goto L73
            io.sentry.android.core.c1 r10 = new io.sentry.android.core.c1     // Catch: java.lang.Throwable -> L45
            long r2 = r4.getTime()     // Catch: java.lang.Throwable -> L45
            r10.<init>(r11, r2)     // Catch: java.lang.Throwable -> L45
            r0 = r10
        L73:
            r9.close()     // Catch: java.lang.Throwable -> L7c
            r1.close()     // Catch: java.lang.Throwable -> L7a
            return r0
        L7a:
            r9 = move-exception
            goto L90
        L7c:
            r9 = move-exception
            goto L87
        L7e:
            r9.close()     // Catch: java.lang.Throwable -> L82
            goto L86
        L82:
            r9 = move-exception
            r10.addSuppressed(r9)     // Catch: java.lang.Throwable -> L7c
        L86:
            throw r10     // Catch: java.lang.Throwable -> L7c
        L87:
            r1.close()     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L8b:
            r10 = move-exception
            r9.addSuppressed(r10)     // Catch: java.lang.Throwable -> L7a
        L8f:
            throw r9     // Catch: java.lang.Throwable -> L7a
        L90:
            io.sentry.ILogger r8 = r8.getLogger()
            io.sentry.p5 r10 = io.sentry.p5.DEBUG
            java.lang.String r11 = r11.getName()
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r11
            java.lang.String r11 = "Error parsing event JSON from: %s"
            r8.b(r10, r9, r11, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.d1.a(java.io.BufferedInputStream, int, java.io.File):io.sentry.android.core.c1");
    }

    public Properties b() {
        q2 q2Var = (q2) this.c;
        String str = (String) this.b;
        try {
            File file = new File(str.trim());
            if (file.isFile() && file.canRead()) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    return properties;
                } finally {
                }
            }
            if (file.isFile()) {
                if (!file.canRead()) {
                    q2Var.h(p5.ERROR, "Failed to load Sentry configuration since it is not readable: %s", str);
                }
            } else if (this.a) {
                q2Var.h(p5.ERROR, "Failed to load Sentry configuration since it is not a file or does not exist: %s", str);
                return null;
            }
            return null;
        } catch (Throwable th) {
            q2Var.b(p5.ERROR, th, "Failed to load Sentry configuration from file: %s", str);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[Catch: all -> 0x0045, TryCatch #1 {all -> 0x0045, blocks: (B:4:0x0011, B:5:0x001d, B:7:0x0025, B:20:0x0054, B:12:0x0038, B:14:0x0040, B:17:0x0047, B:19:0x004f, B:24:0x005d), top: B:40:0x0011, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.j2 c(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L66
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L66
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L66
            byte[] r9 = r9.getBytes(r3)     // Catch: java.lang.Throwable -> L66
            r2.<init>(r9)     // Catch: java.lang.Throwable -> L66
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L66
            io.sentry.i2 r9 = new io.sentry.i2     // Catch: java.lang.Throwable -> L45
            r9.<init>(r1)     // Catch: java.lang.Throwable -> L45
            io.sentry.vendor.gson.stream.a r2 = r9.b     // Catch: java.lang.Throwable -> L45
            r9.p0()     // Catch: java.lang.Throwable -> L45
            r3 = -1
            r4 = r0
        L1d:
            io.sentry.vendor.gson.stream.b r5 = r2.peek()     // Catch: java.lang.Throwable -> L45
            io.sentry.vendor.gson.stream.b r6 = io.sentry.vendor.gson.stream.b.NAME     // Catch: java.lang.Throwable -> L45
            if (r5 != r6) goto L5b
            java.lang.String r5 = r2.R()     // Catch: java.lang.Throwable -> L45
            int r6 = r5.hashCode()     // Catch: java.lang.Throwable -> L45
            r7 = -1106363674(0xffffffffbe0e3ae6, float:-0.13889655)
            if (r6 == r7) goto L47
            r7 = 3575610(0x368f3a, float:5.010497E-39)
            if (r6 == r7) goto L38
            goto L54
        L38:
            java.lang.String r6 = "type"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L45
            if (r5 == 0) goto L54
            java.lang.String r4 = r9.G()     // Catch: java.lang.Throwable -> L45
            goto L57
        L45:
            r9 = move-exception
            goto L6c
        L47:
            java.lang.String r6 = "length"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L45
            if (r5 == 0) goto L54
            int r3 = r9.nextInt()     // Catch: java.lang.Throwable -> L45
            goto L57
        L54:
            r9.t()     // Catch: java.lang.Throwable -> L45
        L57:
            if (r4 == 0) goto L1d
            if (r3 < 0) goto L1d
        L5b:
            if (r3 < 0) goto L68
            io.sentry.j2 r9 = new io.sentry.j2     // Catch: java.lang.Throwable -> L45
            r9.<init>(r4, r3)     // Catch: java.lang.Throwable -> L45
            r1.close()     // Catch: java.lang.Throwable -> L66
            return r9
        L66:
            r9 = move-exception
            goto L75
        L68:
            r1.close()     // Catch: java.lang.Throwable -> L66
            return r0
        L6c:
            r1.close()     // Catch: java.lang.Throwable -> L70
            goto L74
        L70:
            r1 = move-exception
            r9.addSuppressed(r1)     // Catch: java.lang.Throwable -> L66
        L74:
            throw r9     // Catch: java.lang.Throwable -> L66
        L75:
            java.lang.Object r8 = r8.b
            io.sentry.android.core.SentryAndroidOptions r8 = (io.sentry.android.core.SentryAndroidOptions) r8
            io.sentry.ILogger r8 = r8.getLogger()
            io.sentry.p5 r1 = io.sentry.p5.DEBUG
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "Error parsing item header"
            r8.b(r1, r9, r3, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.d1.c(java.lang.String):io.sentry.j2");
    }

    public d1(String str, q2 q2Var, boolean z) {
        this.b = str;
        this.c = q2Var;
        this.a = z;
    }
}
