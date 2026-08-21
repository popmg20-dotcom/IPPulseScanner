package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class b73 {
    public static final pr1 a = new pr1();

    public static void a(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x02eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0172 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x01d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0156  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v27, types: [int] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v55 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v57 */
    /* JADX WARN: Type inference failed for: r7v58 */
    /* JADX WARN: Type inference failed for: r7v59 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context, Executor executor, a73 a73Var, boolean z) {
        boolean z2;
        ?? C;
        yt0[] yt0VarArrQ;
        yt0[] yt0VarArr;
        yt0[] yt0VarArr2;
        byte[] bArr;
        ?? r7;
        boolean z3;
        Throwable th;
        Throwable th2;
        ?? r72;
        boolean z4;
        ?? byteArrayOutputStream;
        ?? r73;
        tx txVar;
        ?? r74;
        String str;
        FileInputStream fileInputStreamC;
        ?? r75;
        boolean z5;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j = dataInputStream.readLong();
                            dataInputStream.close();
                            z5 = j == packageInfo.lastUpdateTime;
                            if (z5) {
                                a73Var.k(2, null);
                            }
                        } finally {
                        }
                    } catch (IOException unused) {
                        z5 = false;
                    }
                    if (z5) {
                    }
                } else {
                    z5 = false;
                    if (z5) {
                        Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                        k73.c(context, false);
                        return;
                    }
                }
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            byte[] bArr2 = ji0.b;
            File file2 = new File(new File("/data/misc/profiles/cur/0", packageName), "primary.prof");
            tx txVar2 = new tx(assets, executor, a73Var, name, file2);
            byte[] bArr3 = (byte[]) txVar2.A;
            if (bArr3 != null) {
                if (file2.exists()) {
                    if (!file2.canWrite()) {
                        txVar2.d(4, null);
                    }
                    txVar2.f = true;
                    try {
                        C = txVar2.c(assets, "dexopt/baseline.prof");
                    } catch (FileNotFoundException e) {
                        a73Var.k(6, e);
                        C = 0;
                    } catch (IOException e2) {
                        a73Var.k(7, e2);
                        C = 0;
                    }
                    try {
                        if (C != 0) {
                            try {
                                try {
                                } catch (IOException e3) {
                                    a73Var.k(7, e3);
                                    try {
                                        C.close();
                                    } catch (IOException e4) {
                                        a73Var.k(7, e4);
                                    }
                                    yt0VarArrQ = null;
                                    txVar2.Z = yt0VarArrQ;
                                    yt0VarArr = (yt0[]) txVar2.Z;
                                    if (yt0VarArr != null) {
                                    }
                                    a73 a73Var2 = (a73) txVar2.z;
                                    yt0VarArr2 = (yt0[]) txVar2.Z;
                                    byte[] bArr4 = (byte[]) txVar2.A;
                                    ?? r76 = C;
                                    r76 = C;
                                    if (yt0VarArr2 != null) {
                                    }
                                    bArr = (byte[]) txVar2.y0;
                                    if (bArr != null) {
                                    }
                                    if (z3) {
                                    }
                                    z4 = z3;
                                    r75 = r72;
                                    k73.c(context, (z4 || !z) ? 0 : r75);
                                }
                            } catch (IllegalStateException e5) {
                                a73Var.k(8, e5);
                                C.close();
                                yt0VarArrQ = null;
                                txVar2.Z = yt0VarArrQ;
                                yt0VarArr = (yt0[]) txVar2.Z;
                                if (yt0VarArr != null) {
                                }
                                a73 a73Var22 = (a73) txVar2.z;
                                yt0VarArr2 = (yt0[]) txVar2.Z;
                                byte[] bArr42 = (byte[]) txVar2.A;
                                ?? r762 = C;
                                r762 = C;
                                if (yt0VarArr2 != null) {
                                }
                                bArr = (byte[]) txVar2.y0;
                                if (bArr != null) {
                                }
                                if (z3) {
                                }
                                z4 = z3;
                                r75 = r72;
                                k73.c(context, (z4 || !z) ? 0 : r75);
                            }
                            if (!Arrays.equals(bArr2, ez4.P(C, 4))) {
                                throw new IllegalStateException("Invalid magic");
                            }
                            yt0VarArrQ = ji0.Q(C, ez4.P(C, 4), (String) txVar2.Y);
                            try {
                                C.close();
                            } catch (IOException e6) {
                                a73Var.k(7, e6);
                            }
                            txVar2.Z = yt0VarArrQ;
                        }
                        yt0VarArr = (yt0[]) txVar2.Z;
                        if (yt0VarArr != null && (C = Build.VERSION.SDK_INT) >= 24 && (C >= 31 || C == 24 || C == 25)) {
                            try {
                                str = "dexopt/baseline.profm";
                                fileInputStreamC = txVar2.c(assets, "dexopt/baseline.profm");
                                r74 = str;
                            } catch (FileNotFoundException e7) {
                                a73Var.k(9, e7);
                                r74 = C;
                            } catch (IOException e8) {
                                a73Var.k(7, e8);
                                r74 = C;
                            } catch (IllegalStateException e9) {
                                txVar2.Z = null;
                                a73Var.k(8, e9);
                                r74 = C;
                            }
                            if (fileInputStreamC == null) {
                                try {
                                    if (!Arrays.equals(ji0.c, ez4.P(fileInputStreamC, 4))) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    byte[] bArrP = ez4.P(fileInputStreamC, 4);
                                    txVar2.Z = ji0.N(fileInputStreamC, bArrP, bArr3, yt0VarArr);
                                    fileInputStreamC.close();
                                    txVar = txVar2;
                                    C = bArrP;
                                    if (txVar != null) {
                                        txVar2 = txVar;
                                    }
                                } finally {
                                }
                            } else {
                                if (fileInputStreamC != null) {
                                    fileInputStreamC.close();
                                    r74 = str;
                                }
                                txVar = null;
                                C = r74;
                                if (txVar != null) {
                                }
                            }
                        }
                        a73 a73Var222 = (a73) txVar2.z;
                        yt0VarArr2 = (yt0[]) txVar2.Z;
                        byte[] bArr422 = (byte[]) txVar2.A;
                        ?? r7622 = C;
                        r7622 = C;
                        if (yt0VarArr2 != null && bArr422 != null) {
                            byteArrayOutputStream = txVar2.f;
                            if (byteArrayOutputStream != 0) {
                                xe.q("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                return;
                            }
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byteArrayOutputStream.write(bArr2);
                                    byteArrayOutputStream.write(bArr422);
                                } finally {
                                }
                            } catch (IOException e10) {
                                a73Var222.k(7, e10);
                                r73 = byteArrayOutputStream;
                            } catch (IllegalStateException e11) {
                                a73Var222.k(8, e11);
                                r73 = byteArrayOutputStream;
                            }
                            if (ji0.X(byteArrayOutputStream, bArr422, yt0VarArr2)) {
                                txVar2.y0 = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                r73 = byteArrayOutputStream;
                                txVar2.Z = null;
                                r7622 = r73;
                            } else {
                                a73Var222.k(5, null);
                                txVar2.Z = null;
                                byteArrayOutputStream.close();
                                r7622 = byteArrayOutputStream;
                            }
                        }
                        bArr = (byte[]) txVar2.y0;
                        if (bArr != null) {
                            z3 = false;
                            r72 = 1;
                        } else {
                            try {
                                if (!txVar2.f) {
                                    xe.q("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                    return;
                                }
                                try {
                                    try {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                        try {
                                            try {
                                                FileOutputStream fileOutputStream = new FileOutputStream((File) txVar2.X);
                                                try {
                                                    try {
                                                        FileChannel channel = fileOutputStream.getChannel();
                                                        try {
                                                            FileLock fileLockTryLock = channel.tryLock();
                                                            try {
                                                                try {
                                                                    if (fileLockTryLock != null) {
                                                                        try {
                                                                            if (fileLockTryLock.isValid()) {
                                                                                byte[] bArr5 = new byte[512];
                                                                                while (true) {
                                                                                    int i = byteArrayInputStream.read(bArr5);
                                                                                    if (i <= 0) {
                                                                                        break;
                                                                                    } else {
                                                                                        fileOutputStream.write(bArr5, 0, i);
                                                                                    }
                                                                                }
                                                                                r72 = 1;
                                                                                txVar2.d(1, null);
                                                                                fileLockTryLock.close();
                                                                                channel.close();
                                                                                fileOutputStream.close();
                                                                                byteArrayInputStream.close();
                                                                                txVar2.y0 = null;
                                                                                txVar2.Z = null;
                                                                                z3 = true;
                                                                            }
                                                                        } catch (Throwable th3) {
                                                                            th = th3;
                                                                            Throwable th4 = th;
                                                                            if (fileLockTryLock == null) {
                                                                                throw th4;
                                                                            }
                                                                            try {
                                                                                fileLockTryLock.close();
                                                                                throw th4;
                                                                            } catch (Throwable th5) {
                                                                                th4.addSuppressed(th5);
                                                                                throw th4;
                                                                            }
                                                                        }
                                                                    }
                                                                    throw new IOException("Unable to acquire a lock on the underlying file channel.");
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    Throwable th7 = th;
                                                                    if (channel == null) {
                                                                        throw th7;
                                                                    }
                                                                    try {
                                                                        channel.close();
                                                                        throw th7;
                                                                    } catch (Throwable th8) {
                                                                        th7.addSuppressed(th8);
                                                                        throw th7;
                                                                    }
                                                                }
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                            }
                                                        } catch (Throwable th10) {
                                                            th = th10;
                                                        }
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        th2 = th;
                                                        try {
                                                            fileOutputStream.close();
                                                            throw th2;
                                                        } catch (Throwable th12) {
                                                            th2.addSuppressed(th12);
                                                            throw th2;
                                                        }
                                                    }
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    th2 = th;
                                                    fileOutputStream.close();
                                                    throw th2;
                                                }
                                            } catch (Throwable th14) {
                                                th = th14;
                                                th = th;
                                                try {
                                                    byteArrayInputStream.close();
                                                    throw th;
                                                } catch (Throwable th15) {
                                                    th.addSuppressed(th15);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th16) {
                                            th = th16;
                                            th = th;
                                            byteArrayInputStream.close();
                                            throw th;
                                        }
                                    } catch (FileNotFoundException e12) {
                                        e = e12;
                                        txVar2.d(6, e);
                                        r7 = r7622;
                                        z3 = false;
                                        r72 = r7;
                                        if (z3) {
                                        }
                                        z4 = z3;
                                        r75 = r72;
                                        k73.c(context, (z4 || !z) ? 0 : r75);
                                    } catch (IOException e13) {
                                        e = e13;
                                        txVar2.d(7, e);
                                        r7 = r7622;
                                        z3 = false;
                                        r72 = r7;
                                        if (z3) {
                                        }
                                        z4 = z3;
                                        r75 = r72;
                                        k73.c(context, (z4 || !z) ? 0 : r75);
                                    }
                                } catch (FileNotFoundException e14) {
                                    e = e14;
                                    r7622 = 1;
                                    txVar2.d(6, e);
                                    r7 = r7622;
                                    z3 = false;
                                    r72 = r7;
                                    if (z3) {
                                    }
                                    z4 = z3;
                                    r75 = r72;
                                    k73.c(context, (z4 || !z) ? 0 : r75);
                                } catch (IOException e15) {
                                    e = e15;
                                    r7622 = 1;
                                    txVar2.d(7, e);
                                    r7 = r7622;
                                    z3 = false;
                                    r72 = r7;
                                    if (z3) {
                                    }
                                    z4 = z3;
                                    r75 = r72;
                                    k73.c(context, (z4 || !z) ? 0 : r75);
                                }
                            } finally {
                                txVar2.y0 = null;
                                txVar2.Z = null;
                            }
                        }
                        if (z3) {
                            a(packageInfo, filesDir);
                        }
                        z4 = z3;
                        r75 = r72;
                    } finally {
                    }
                } else {
                    try {
                        if (!file2.createNewFile()) {
                            txVar2.d(4, null);
                        }
                        txVar2.f = true;
                        C = txVar2.c(assets, "dexopt/baseline.prof");
                        if (C != 0) {
                        }
                        yt0VarArr = (yt0[]) txVar2.Z;
                        if (yt0VarArr != null) {
                            str = "dexopt/baseline.profm";
                            fileInputStreamC = txVar2.c(assets, "dexopt/baseline.profm");
                            r74 = str;
                            if (fileInputStreamC == null) {
                            }
                        }
                        a73 a73Var2222 = (a73) txVar2.z;
                        yt0VarArr2 = (yt0[]) txVar2.Z;
                        byte[] bArr4222 = (byte[]) txVar2.A;
                        ?? r76222 = C;
                        r76222 = C;
                        if (yt0VarArr2 != null) {
                            byteArrayOutputStream = txVar2.f;
                            if (byteArrayOutputStream != 0) {
                            }
                        }
                        bArr = (byte[]) txVar2.y0;
                        if (bArr != null) {
                        }
                        if (z3) {
                        }
                        z4 = z3;
                        r75 = r72;
                    } catch (IOException unused2) {
                        z2 = true;
                        txVar2.d(4, null);
                    }
                }
                k73.c(context, (z4 || !z) ? 0 : r75);
            }
            txVar2.d(3, Integer.valueOf(Build.VERSION.SDK_INT));
            z2 = true;
            z4 = false;
            r75 = z2;
            k73.c(context, (z4 || !z) ? 0 : r75);
        } catch (PackageManager.NameNotFoundException e16) {
            a73Var.k(7, e16);
            k73.c(context, false);
        }
    }
}
