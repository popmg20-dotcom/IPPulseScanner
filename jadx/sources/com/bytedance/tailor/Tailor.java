package com.bytedance.tailor;

import android.os.Debug;
import defpackage.ha0;
import defpackage.vp1;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class Tailor {
    static {
        System.loadLibrary("tailor");
    }

    public static void cropHprofData(String str, String str2, boolean z) throws IOException {
        if (isHprofValid(str)) {
            nCropHprof(str, str2, z);
        } else {
            vp1.i(ha0.n("Bad hprof file ", str));
        }
    }

    public static synchronized void dumpHprofData(String str, boolean z) {
        nOpenProxy(str, z);
        Debug.dumpHprofData(str);
        nCloseProxy();
    }

    public static boolean isHprofValid(String str) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                randomAccessFile2.seek(randomAccessFile2.length() - 9);
                boolean z = randomAccessFile2.readByte() == 44;
                try {
                    randomAccessFile2.close();
                    return z;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return z;
                }
            } catch (IOException unused) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static native void nCloseProxy();

    public static native void nCropHprof(String str, String str2, boolean z);

    public static native void nOpenProxy(String str, boolean z);
}
