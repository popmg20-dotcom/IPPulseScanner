package io.sentry.android.core;

import io.sentry.i2;
import io.sentry.j2;
import io.sentry.p5;
import io.sentry.q2;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
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
    */
    public c1 a(BufferedInputStream bufferedInputStream, int i, File file) {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.b;
        c1 c1Var = null;
        try {
            b1 b1Var = new b1(bufferedInputStream, i);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(b1Var, StandardCharsets.UTF_8);
                try {
                    i2 i2Var = new i2(inputStreamReader);
                    io.sentry.vendor.gson.stream.a aVar = i2Var.b;
                    i2Var.p0();
                    String strG = null;
                    Date dateY = null;
                    while (aVar.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                        String strR = aVar.R();
                        int iHashCode = strR.hashCode();
                        if (iHashCode != 55126294) {
                            if (iHashCode == 1874684019 && strR.equals("platform")) {
                                strG = i2Var.G();
                            } else {
                                i2Var.t();
                            }
                            if (strG == null && dateY != null) {
                                break;
                            }
                        } else {
                            if (strR.equals("timestamp")) {
                                dateY = i2Var.Y(sentryAndroidOptions.getLogger());
                            }
                            if (strG == null) {
                            }
                        }
                    }
                    if ("native".equals(strG) && dateY != null) {
                        c1Var = new c1(file, dateY.getTime());
                    }
                    inputStreamReader.close();
                    b1Var.close();
                    return c1Var;
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(p5.DEBUG, th, "Error parsing event JSON from: %s", file.getName());
            return null;
        }
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
    */
    public j2 c(String str) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(str.getBytes(charset)), charset);
            try {
                i2 i2Var = new i2(inputStreamReader);
                io.sentry.vendor.gson.stream.a aVar = i2Var.b;
                i2Var.p0();
                int iNextInt = -1;
                String strG = null;
                while (aVar.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                    String strR = aVar.R();
                    int iHashCode = strR.hashCode();
                    if (iHashCode != -1106363674) {
                        if (iHashCode == 3575610 && strR.equals("type")) {
                            strG = i2Var.G();
                        } else {
                            i2Var.t();
                        }
                        if (strG == null && iNextInt >= 0) {
                            break;
                        }
                    } else {
                        if (strR.equals("length")) {
                            iNextInt = i2Var.nextInt();
                        }
                        if (strG == null) {
                        }
                    }
                }
                if (iNextInt < 0) {
                    inputStreamReader.close();
                    return null;
                }
                j2 j2Var = new j2(strG, iNextInt);
                inputStreamReader.close();
                return j2Var;
            } finally {
            }
        } catch (Throwable th) {
            ((SentryAndroidOptions) this.b).getLogger().b(p5.DEBUG, th, "Error parsing item header", new Object[0]);
            return null;
        }
        ((SentryAndroidOptions) this.b).getLogger().b(p5.DEBUG, th, "Error parsing item header", new Object[0]);
        return null;
    }

    public d1(String str, q2 q2Var, boolean z) {
        this.b = str;
        this.c = q2Var;
        this.a = z;
    }
}
