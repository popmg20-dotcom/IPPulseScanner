package defpackage;

import android.os.Build;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ee1 implements y50 {
    public final File a;
    public final nx3 b;
    public final v10 c;
    public final AtomicBoolean d;
    public final yn2 e;

    public ee1(File file, nx3 nx3Var, v10 v10Var) {
        nx3Var.getClass();
        this.a = file;
        this.b = nx3Var;
        this.c = v10Var;
        this.d = new AtomicBoolean(false);
        this.e = new yn2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [xi0] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(xi0 xi0Var, ie0 ie0Var) throws Throwable {
        ce1 ce1Var;
        Throwable th;
        xd1 xd1Var;
        ee1 ee1Var;
        boolean z;
        ?? r8;
        if (ie0Var instanceof ce1) {
            ce1Var = (ce1) ie0Var;
            int i = ce1Var.z0;
            if ((i & Integer.MIN_VALUE) != 0) {
                ce1Var.z0 = i - Integer.MIN_VALUE;
            } else {
                ce1Var = new ce1(this, ie0Var);
            }
        }
        ?? r82 = ce1Var.Z;
        int i2 = ce1Var.z0;
        try {
            if (i2 == 0) {
                n12.S(r82);
                if (this.d.get()) {
                    xe.q("StorageConnection has already been disposed.");
                    return null;
                }
                boolean zD = this.e.d();
                xd1 xd1Var2 = new xd1(this.a);
                try {
                    Boolean boolValueOf = Boolean.valueOf(zD);
                    ce1Var.A = this;
                    ce1Var.X = xd1Var2;
                    ce1Var.Y = zD;
                    ce1Var.z0 = 1;
                    Object objE = xi0Var.e(xd1Var2, boolValueOf, ce1Var);
                    mf0 mf0Var = mf0.b;
                    if (objE == mf0Var) {
                        return mf0Var;
                    }
                    ee1Var = this;
                    z = zD ? 1 : 0;
                    r8 = objE;
                    xd1Var = xd1Var2;
                    xd1Var.close();
                    th = null;
                    if (th != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    xd1Var = xd1Var2;
                    r82 = zD;
                    xd1Var.close();
                    throw th;
                }
            } else {
                if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                z = ce1Var.Y;
                xd1Var = ce1Var.X;
                ee1Var = ce1Var.A;
                try {
                    n12.S(r82);
                    r8 = r82;
                    try {
                        xd1Var.close();
                        th = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    if (th != null) {
                        if (z) {
                            ee1Var.e.n(null);
                        }
                        return r8;
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        th = th4;
                        r82 = z;
                        this = ee1Var;
                    }
                } catch (Throwable th5) {
                    r82 = z ? 1 : 0;
                    this = ee1Var;
                    th = th5;
                    try {
                        xd1Var.close();
                        throw th;
                    } catch (Throwable th6) {
                        ek0.b(th, th6);
                        throw th;
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
        if (r82 != 0) {
            this.e.n(null);
        }
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca A[Catch: all -> 0x0105, IOException -> 0x0107, TRY_ENTER, TryCatch #1 {IOException -> 0x0107, blocks: (B:43:0x00ca, B:45:0x00d0, B:47:0x00d8, B:51:0x00e4, B:52:0x0104, B:48:0x00dd, B:59:0x0110, B:66:0x011d, B:65:0x011a), top: B:78:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0110 A[Catch: all -> 0x0105, IOException -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x0107, blocks: (B:43:0x00ca, B:45:0x00d0, B:47:0x00d8, B:51:0x00e4, B:52:0x0104, B:48:0x00dd, B:59:0x0110, B:66:0x011d, B:65:0x011a), top: B:78:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, wn2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(kj0 kj0Var, ie0 ie0Var) throws IOException {
        de1 de1Var;
        File file;
        wn2 wn2Var;
        Function2 function2;
        je1 je1Var;
        Throwable th;
        je1 je1Var2;
        ee1 ee1Var;
        File file2;
        if (ie0Var instanceof de1) {
            de1Var = (de1) ie0Var;
            int i = de1Var.A0;
            if ((i & Integer.MIN_VALUE) != 0) {
                de1Var.A0 = i - Integer.MIN_VALUE;
            } else {
                de1Var = new de1(this, ie0Var);
            }
        }
        Object obj = de1Var.y0;
        ?? r2 = de1Var.A0;
        mf0 mf0Var = mf0.b;
        try {
            try {
            } catch (IOException e) {
                e = e;
                file = kj0Var;
            }
            try {
                try {
                    if (r2 == 0) {
                        n12.S(obj);
                        if (this.d.get()) {
                            xe.q("StorageConnection has already been disposed.");
                            return null;
                        }
                        File file3 = this.a;
                        File parentFile = file3.getCanonicalFile().getParentFile();
                        if (parentFile != null) {
                            parentFile.mkdirs();
                            if (!parentFile.isDirectory()) {
                                st4.i(file3, "Unable to create parent directories of ");
                                return null;
                            }
                        }
                        de1Var.A = this;
                        de1Var.X = kj0Var;
                        yn2 yn2Var = this.e;
                        de1Var.Y = yn2Var;
                        de1Var.A0 = 1;
                        if (yn2Var.g(de1Var) != mf0Var) {
                            wn2Var = yn2Var;
                            function2 = kj0Var;
                        }
                        return mf0Var;
                    }
                    if (r2 != 1) {
                        if (r2 != 2) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        je1Var2 = de1Var.Z;
                        File file4 = (File) de1Var.Y;
                        wn2Var = (wn2) de1Var.X;
                        ee1Var = de1Var.A;
                        try {
                            n12.S(obj);
                            file2 = file4;
                            try {
                                je1Var2.close();
                                th = null;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            if (th == null) {
                                throw th;
                            }
                            if (file2.exists()) {
                                File file5 = ee1Var.a;
                                if (!(Build.VERSION.SDK_INT >= 26 ? v02.u(file2, file5) : file2.renameTo(file5))) {
                                    throw new IOException("Unable to rename " + file2 + " to " + ee1Var.a + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                                }
                            }
                            wn2Var.n(null);
                            return xl4.a;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                je1Var2.close();
                            } catch (Throwable th4) {
                                ek0.b(th, th4);
                            }
                            throw th;
                        }
                    }
                    wn2 wn2Var2 = (wn2) de1Var.Y;
                    Function2 function22 = (Function2) de1Var.X;
                    ee1 ee1Var2 = de1Var.A;
                    n12.S(obj);
                    wn2Var = wn2Var2;
                    this = ee1Var2;
                    function2 = function22;
                    de1Var.A = this;
                    de1Var.X = wn2Var;
                    de1Var.Y = file;
                    de1Var.Z = je1Var;
                    de1Var.A0 = 2;
                    if (function2.k(je1Var, de1Var) != mf0Var) {
                        ee1Var = this;
                        file2 = file;
                        je1Var2 = je1Var;
                        je1Var2.close();
                        th = null;
                        if (th == null) {
                        }
                    }
                    return mf0Var;
                } catch (Throwable th5) {
                    th = th5;
                    je1Var2 = je1Var;
                    je1Var2.close();
                    throw th;
                }
                je1Var = new je1(file);
            } catch (IOException e2) {
                e = e2;
                if (file.exists()) {
                    file.delete();
                }
                throw e;
            }
            file = new File(this.a.getAbsolutePath() + DiskFileUpload.postfix);
        } catch (Throwable th6) {
            r2.n(null);
            throw th6;
        }
    }

    @Override // defpackage.y50
    public final void close() {
        this.d.set(true);
        this.c.a();
    }
}
