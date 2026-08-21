package io.sentry.android.core;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {
    public static String a;
    public static final Charset b = Charset.forName("UTF-8");
    public static final io.sentry.util.a c = new io.sentry.util.a();

    public static String a(Context context) {
        io.sentry.util.a aVar = c;
        aVar.g();
        try {
            String str = a;
            if (str == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    boolean zExists = file.exists();
                    Charset charset = b;
                    if (!zExists) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            String strF = io.sentry.config.a.f();
                            fileOutputStream.write(strF.getBytes(charset));
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            a = strF;
                            aVar.close();
                            return strF;
                        } finally {
                        }
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        byte[] bArr = new byte[(int) randomAccessFile.length()];
                        randomAccessFile.readFully(bArr);
                        String str2 = new String(bArr, charset);
                        randomAccessFile.close();
                        a = str2;
                        str = str2;
                    } finally {
                    }
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            aVar.close();
            return str;
        } catch (Throwable th2) {
            try {
                aVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
