package io.sentry.cache;

import defpackage.c73;
import defpackage.o73;
import io.sentry.d5;
import io.sentry.l1;
import io.sentry.n2;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.util.f;
import io.sentry.z6;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class b implements c {
    public static final Charset z0 = Charset.forName("UTF-8");
    public final int A;
    public final p6 b;
    public final n2 z;
    public final f f = new f(new o73(27, this));
    public final WeakHashMap Y = new WeakHashMap();
    public final io.sentry.util.a Z = new io.sentry.util.a();
    public final io.sentry.util.a y0 = new io.sentry.util.a();
    public final CountDownLatch X = new CountDownLatch(1);

    public b(p6 p6Var, String str, int i) {
        this.b = p6Var;
        this.z = new n2(str);
        this.A = i;
    }

    @Override // io.sentry.cache.c
    public final void Q(io.sentry.internal.debugmeta.c cVar) {
        io.sentry.util.b.r(cVar, "Envelope is required.");
        File fileB = b(cVar);
        boolean zDelete = fileB.delete();
        p6 p6Var = this.b;
        if (zDelete) {
            p6Var.getLogger().h(p5.DEBUG, "Discarding envelope from cache: %s", fileB.getAbsolutePath());
        } else {
            p6Var.getLogger().h(p5.DEBUG, "Envelope was not cached or could not be deleted: %s", fileB.getAbsolutePath());
        }
    }

    public final File[] a() {
        n2 n2Var = this.z;
        File file = (File) n2Var.f;
        if (file.isDirectory() && file.canWrite() && file.canRead()) {
            File[] fileArrListFiles = ((File) n2Var.f).listFiles(new c73(5));
            if (fileArrListFiles != null) {
                return fileArrListFiles;
            }
        } else {
            this.b.getLogger().h(p5.ERROR, "The directory for caching files is inaccessible.: %s", file.getAbsolutePath());
        }
        return new File[0];
    }

    public final File b(io.sentry.internal.debugmeta.c cVar) {
        String str;
        WeakHashMap weakHashMap = this.Y;
        io.sentry.util.a aVar = this.Z;
        aVar.g();
        try {
            if (weakHashMap.containsKey(cVar)) {
                str = (String) weakHashMap.get(cVar);
            } else {
                String strConcat = io.sentry.config.a.f().concat(".envelope");
                weakHashMap.put(cVar, strConcat);
                str = strConcat;
            }
            File file = new File((File) this.z.f, str);
            aVar.close();
            return file;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void c(File file, File file2) {
        io.sentry.util.a aVar = this.y0;
        aVar.g();
        try {
            if (!file.exists()) {
                aVar.close();
                return;
            }
            boolean zExists = file2.exists();
            p6 p6Var = this.b;
            if (zExists) {
                p6Var.getLogger().h(p5.DEBUG, "Previous session file already exists, deleting it.", new Object[0]);
                if (!file2.delete()) {
                    p6Var.getLogger().h(p5.WARNING, "Unable to delete previous session file: %s", file2);
                }
            }
            p6Var.getLogger().h(p5.INFO, "Moving current session to previous session.", new Object[0]);
            try {
                if (!file.renameTo(file2)) {
                    p6Var.getLogger().h(p5.WARNING, "Unable to move current session to previous session.", new Object[0]);
                }
            } catch (Throwable th) {
                p6Var.getLogger().d(p5.ERROR, "Error moving current session to previous session.", th);
            }
            aVar.close();
        } catch (Throwable th2) {
            try {
                aVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final io.sentry.internal.debugmeta.c d(File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                io.sentry.internal.debugmeta.c cVarC = ((l1) this.f.a()).c(bufferedInputStream);
                bufferedInputStream.close();
                return cVarC;
            } finally {
            }
        } catch (IOException e) {
            this.b.getLogger().d(p5.ERROR, "Failed to deserialize the envelope.", e);
            return null;
        }
    }

    public final z6 e(d5 d5Var) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d5Var.g()), z0));
            try {
                z6 z6Var = (z6) ((l1) this.f.a()).b(bufferedReader, z6.class);
                bufferedReader.close();
                return z6Var;
            } finally {
            }
        } catch (Throwable th) {
            this.b.getLogger().d(p5.ERROR, "Failed to deserialize the session.", th);
            return null;
        }
    }

    public final boolean f() {
        p6 p6Var = this.b;
        try {
            return this.X.await(p6Var.getSessionFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            p6Var.getLogger().h(p5.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }

    public final void g(File file, z6 z6Var) {
        String str = z6Var.X;
        p6 p6Var = this.b;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, z0));
                try {
                    p6Var.getLogger().h(p5.DEBUG, "Overwriting session to offline storage: %s", str);
                    ((l1) this.f.a()).a(z6Var, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            p6Var.getLogger().b(p5.ERROR, th, "Error writing Session to offline storage: %s", str);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        p6 p6Var = this.b;
        File[] fileArrA = a();
        ArrayList arrayList = new ArrayList(fileArrA.length);
        for (File file : fileArrA) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    arrayList.add(((l1) this.f.a()).c(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused) {
                p6Var.getLogger().h(p5.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e) {
                p6Var.getLogger().d(p5.ERROR, "Error while reading cached envelope from file " + file.getAbsolutePath(), e);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x024f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r9v44, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v45 */
    /* JADX WARN: Type inference failed for: r9v46 */
    /* JADX WARN: Type inference failed for: r9v47 */
    @Override // io.sentry.cache.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean n(io.sentry.internal.debugmeta.c r28, io.sentry.l0 r29) {
        /*
            Method dump skipped, instruction units count: 1411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.b.n(io.sentry.internal.debugmeta.c, io.sentry.l0):boolean");
    }
}
