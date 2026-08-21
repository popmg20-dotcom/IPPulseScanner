package io.sentry.cache;

import defpackage.c73;
import defpackage.i60;
import defpackage.o73;
import io.sentry.ILogger;
import io.sentry.android.core.f2;
import io.sentry.d5;
import io.sentry.hints.g;
import io.sentry.hints.i;
import io.sentry.hints.j;
import io.sentry.l0;
import io.sentry.l1;
import io.sentry.l7;
import io.sentry.n2;
import io.sentry.o5;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.util.f;
import io.sentry.v4;
import io.sentry.y4;
import io.sentry.y6;
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
import java.util.Arrays;
import java.util.Date;
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
    */
    public boolean n(io.sentry.internal.debugmeta.c cVar, l0 l0Var) {
        Date date;
        io.sentry.hints.a aVar;
        boolean z;
        BufferedReader bufferedReader;
        File[] fileArr;
        int i;
        f fVar;
        int i2;
        p6 p6Var;
        File[] fileArr2;
        z6 z6VarE;
        Boolean bool;
        String str;
        int i3;
        int i4;
        d5 d5VarE;
        FileOutputStream fileOutputStream;
        ?? Equals;
        z6 z6VarE2;
        io.sentry.util.b.r(cVar, "Envelope is required.");
        n2 n2Var = this.z;
        File file = (File) n2Var.f;
        io.sentry.util.b.e(file);
        String absolutePath = file.getAbsolutePath();
        File[] fileArrA = a();
        int length = fileArrA.length;
        f fVar2 = this.f;
        int i5 = 0;
        p6 p6Var2 = this.b;
        int i6 = this.A;
        if (length >= i6) {
            p6Var2.getLogger().h(p5.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i7 = (length - i6) + 1;
            if (fileArrA.length > 1) {
                Arrays.sort(fileArrA, new i60(16));
            }
            File[] fileArr3 = (File[]) Arrays.copyOfRange(fileArrA, i7, length);
            int i8 = 0;
            while (i8 < i7) {
                File file2 = fileArrA[i8];
                io.sentry.internal.debugmeta.c cVarD = d(file2);
                if (cVarD != null) {
                    i2 = i5;
                    Iterable iterable = (Iterable) cVarD.z;
                    if (iterable.iterator().hasNext()) {
                        fileArr = fileArrA;
                        p6Var2.getClientReportRecorder().c(io.sentry.clientreport.d.CACHE_OVERFLOW, cVarD);
                        Iterator it = iterable.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z6VarE = null;
                                break;
                            }
                            d5 d5Var = (d5) it.next();
                            if ((d5Var == null ? i2 : d5Var.a.X.equals(o5.Session)) != 0) {
                                z6VarE = e(d5Var);
                                break;
                            }
                        }
                        if (z6VarE != null) {
                            String str2 = z6VarE.X;
                            if (z6VarE.Z.equals(y6.Ok) && str2 != null && (bool = z6VarE.Y) != null && bool.booleanValue()) {
                                int length2 = fileArr3.length;
                                int i9 = i2;
                                while (i9 < length2) {
                                    i = i7;
                                    File file3 = fileArr3[i9];
                                    fVar = fVar2;
                                    io.sentry.internal.debugmeta.c cVarD2 = d(file3);
                                    if (cVarD2 != null) {
                                        Iterable iterable2 = (Iterable) cVarD2.z;
                                        if (iterable2.iterator().hasNext()) {
                                            Iterator it2 = iterable2.iterator();
                                            while (true) {
                                                if (!it2.hasNext()) {
                                                    str = str2;
                                                    i3 = length2;
                                                    p6Var = p6Var2;
                                                    i4 = i9;
                                                    d5VarE = null;
                                                    break;
                                                }
                                                Iterator it3 = it2;
                                                d5 d5Var2 = (d5) it2.next();
                                                if (d5Var2 == null) {
                                                    i3 = length2;
                                                    p6Var = p6Var2;
                                                    Equals = i2;
                                                } else {
                                                    i3 = length2;
                                                    p6Var = p6Var2;
                                                    Equals = d5Var2.a.X.equals(o5.Session);
                                                }
                                                if (Equals == 0 || (z6VarE2 = e(d5Var2)) == null) {
                                                    length2 = i3;
                                                    it2 = it3;
                                                    p6Var2 = p6Var;
                                                } else {
                                                    String str3 = z6VarE2.X;
                                                    i4 = i9;
                                                    if (z6VarE2.Z.equals(y6.Ok) && str3 != null) {
                                                        Boolean bool2 = z6VarE2.Y;
                                                        if (bool2 != null && bool2.booleanValue()) {
                                                            ILogger logger = p6Var.getLogger();
                                                            p5 p5Var = p5.ERROR;
                                                            Object[] objArr = new Object[1];
                                                            objArr[i2] = str2;
                                                            logger.h(p5Var, "Session %s has 2 times the init flag.", objArr);
                                                            break;
                                                        }
                                                        if (str2 != null && str2.equals(str3)) {
                                                            z6VarE2.Y = Boolean.TRUE;
                                                            try {
                                                                d5VarE = d5.e((l1) fVar.a(), z6VarE2);
                                                            } catch (IOException e) {
                                                                e = e;
                                                                d5VarE = null;
                                                            }
                                                            try {
                                                                it3.remove();
                                                                str = str2;
                                                                break;
                                                            } catch (IOException e2) {
                                                                e = e2;
                                                                ILogger logger2 = p6Var.getLogger();
                                                                p5 p5Var2 = p5.ERROR;
                                                                str = str2;
                                                                d5 d5Var3 = d5VarE;
                                                                Object[] objArr2 = new Object[1];
                                                                objArr2[i2] = str;
                                                                logger2.b(p5Var2, e, "Failed to create new envelope item for the session %s", objArr2);
                                                                d5VarE = d5Var3;
                                                                if (d5VarE != null) {
                                                                    ArrayList arrayList = new ArrayList();
                                                                    Iterator it4 = iterable2.iterator();
                                                                    while (it4.hasNext()) {
                                                                        arrayList.add((d5) it4.next());
                                                                    }
                                                                    arrayList.add(d5VarE);
                                                                    io.sentry.internal.debugmeta.c cVar2 = new io.sentry.internal.debugmeta.c((y4) cVarD2.f, arrayList);
                                                                    long jLastModified = file3.lastModified();
                                                                    if (file3.delete()) {
                                                                        fileArr2 = fileArr3;
                                                                    } else {
                                                                        ILogger logger3 = p6Var.getLogger();
                                                                        p5 p5Var3 = p5.WARNING;
                                                                        fileArr2 = fileArr3;
                                                                        Object[] objArr3 = new Object[1];
                                                                        objArr3[i2] = file3.getAbsolutePath();
                                                                        logger3.h(p5Var3, "File can't be deleted: %s", objArr3);
                                                                    }
                                                                    try {
                                                                        fileOutputStream = new FileOutputStream(file3);
                                                                    } catch (Throwable th) {
                                                                        p6Var.getLogger().d(p5.ERROR, "Failed to serialize the new envelope to the disk.", th);
                                                                    }
                                                                    try {
                                                                        ((l1) fVar.a()).e(cVar2, fileOutputStream);
                                                                        file3.setLastModified(jLastModified);
                                                                        fileOutputStream.close();
                                                                        if (file2.delete()) {
                                                                        }
                                                                        i8++;
                                                                        i5 = i2;
                                                                        fileArrA = fileArr;
                                                                        i7 = i;
                                                                        fVar2 = fVar;
                                                                        fileArr3 = fileArr2;
                                                                        p6Var2 = p6Var;
                                                                    } finally {
                                                                    }
                                                                }
                                                                i9 = i4 + 1;
                                                                i7 = i;
                                                                fVar2 = fVar;
                                                                length2 = i3;
                                                                fileArr3 = fileArr3;
                                                                p6Var2 = p6Var;
                                                                str2 = str;
                                                            }
                                                        }
                                                    }
                                                    length2 = i3;
                                                    it2 = it3;
                                                    p6Var2 = p6Var;
                                                    i9 = i4;
                                                    str2 = str2;
                                                }
                                            }
                                        } else {
                                            str = str2;
                                            i3 = length2;
                                            p6Var = p6Var2;
                                            i4 = i9;
                                        }
                                    }
                                    i9 = i4 + 1;
                                    i7 = i;
                                    fVar2 = fVar;
                                    length2 = i3;
                                    fileArr3 = fileArr3;
                                    p6Var2 = p6Var;
                                    str2 = str;
                                }
                            }
                        }
                    } else {
                        fileArr = fileArrA;
                    }
                    i = i7;
                    fVar = fVar2;
                } else {
                    fileArr = fileArrA;
                    i = i7;
                    fVar = fVar2;
                    i2 = i5;
                }
                p6Var = p6Var2;
                fileArr2 = fileArr3;
                if (file2.delete()) {
                    ILogger logger4 = p6Var.getLogger();
                    p5 p5Var4 = p5.WARNING;
                    Object[] objArr4 = new Object[1];
                    objArr4[i2] = file2.getAbsolutePath();
                    logger4.h(p5Var4, "File can't be deleted: %s", objArr4);
                }
                i8++;
                i5 = i2;
                fileArrA = fileArr;
                i7 = i;
                fVar2 = fVar;
                fileArr3 = fileArr2;
                p6Var2 = p6Var;
            }
        }
        f fVar3 = fVar2;
        int i10 = i5;
        p6 p6Var3 = p6Var2;
        File file4 = new File(absolutePath, "session.json");
        File file5 = new File(absolutePath, "previous_session.json");
        if (io.sentry.util.b.j(l0Var, i.class) && !file4.delete()) {
            p6Var3.getLogger().h(p5.WARNING, "Current envelope doesn't exist.", new Object[i10]);
        }
        boolean zIsInstance = io.sentry.hints.a.class.isInstance(l0Var.b("sentry:typeCheckHint"));
        Charset charset = z0;
        if (zIsInstance || g.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
            Object objB = l0Var.b("sentry:typeCheckHint");
            File file6 = new File(((File) n2Var.f).getAbsolutePath(), "previous_session.json");
            if (file6.exists()) {
                ILogger logger5 = p6Var3.getLogger();
                p5 p5Var5 = p5.WARNING;
                logger5.h(p5Var5, "Previous session is not ended, we'd need to end it.", new Object[0]);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file6), charset));
                    try {
                        z6 z6Var = (z6) ((l1) fVar3.a()).b(bufferedReader2, z6.class);
                        if (z6Var != null) {
                            Date date2 = z6Var.b;
                            if (objB instanceof io.sentry.hints.a) {
                                io.sentry.hints.a aVar2 = (io.sentry.hints.a) objB;
                                Long lB = aVar2.b();
                                if (lB != null) {
                                    aVar = aVar2;
                                    date = new Date(lB.longValue());
                                    if (date.before(date2)) {
                                        p6Var3.getLogger().h(p5Var5, "Abnormal exit happened before previous session start, not ending the session.", new Object[0]);
                                    }
                                } else {
                                    aVar = aVar2;
                                    date = null;
                                }
                                z6Var.c(y6.Abnormal, null, true, aVar.e());
                                z6Var.b(date);
                                g(file6, z6Var);
                            } else {
                                if (objB instanceof g) {
                                    date = new Date(((f2) ((g) objB)).A);
                                    if (date.before(date2)) {
                                        p6Var3.getLogger().h(p5Var5, "Native crash exit happened before previous session start, not ending the session.", new Object[0]);
                                    } else {
                                        z6Var.c(y6.Crashed, null, true, null);
                                    }
                                } else {
                                    date = null;
                                }
                                z6Var.b(date);
                                g(file6, z6Var);
                            }
                        }
                        bufferedReader2.close();
                    } finally {
                        try {
                            bufferedReader2.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                } catch (Throwable th3) {
                    p6Var3.getLogger().d(p5.ERROR, "Error processing previous session.", th3);
                }
            } else {
                p6Var3.getLogger().h(p5.DEBUG, "No previous session file to end.", new Object[0]);
            }
        }
        if (j.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
            c(file4, file5);
            Iterable iterable3 = (Iterable) cVar.z;
            if (iterable3.iterator().hasNext()) {
                d5 d5Var4 = (d5) iterable3.iterator().next();
                o5 o5Var = o5.Session;
                o5 o5Var2 = d5Var4.a.X;
                if (o5Var.equals(o5Var2)) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d5Var4.g()), charset));
                    } catch (Throwable th4) {
                        p6Var3.getLogger().d(p5.ERROR, "Item failed to process.", th4);
                    }
                    try {
                        z6 z6Var2 = (z6) ((l1) fVar3.a()).b(bufferedReader, z6.class);
                        if (z6Var2 == null) {
                            p6Var3.getLogger().h(p5.ERROR, "Item of type %s returned null by the parser.", o5Var2);
                        } else {
                            g(file4, z6Var2);
                        }
                        bufferedReader.close();
                    } finally {
                    }
                } else {
                    p6Var3.getLogger().h(p5.INFO, "Current envelope has a different envelope type %s", o5Var2);
                }
            } else {
                p6Var3.getLogger().h(p5.INFO, "Current envelope %s is empty", file4.getAbsolutePath());
            }
            if (!new File(p6Var3.getCacheDirPath(), ".sentry-native/last_crash").exists()) {
                File file7 = new File(p6Var3.getCacheDirPath(), "last_crash");
                if (file7.exists()) {
                    p6Var3.getLogger().h(p5.INFO, "Crash marker file exists, crashedLastRun will return true.", new Object[0]);
                    if (!file7.delete()) {
                        p6Var3.getLogger().h(p5.ERROR, "Failed to delete the crash marker file. %s.", file7.getAbsolutePath());
                    }
                }
            }
            v4.c.a();
            this.X.countDown();
        }
        File fileB = b(cVar);
        if (fileB.exists()) {
            p6Var3.getLogger().h(p5.WARNING, "Not adding Envelope to offline storage because it already exists: %s", fileB.getAbsolutePath());
            return true;
        }
        ILogger logger6 = p6Var3.getLogger();
        p5 p5Var6 = p5.DEBUG;
        logger6.h(p5Var6, "Adding Envelope to offline storage: %s", fileB.getAbsolutePath());
        if (fileB.exists()) {
            p6Var3.getLogger().h(p5Var6, "Overwriting envelope to offline storage: %s", fileB.getAbsolutePath());
            if (!fileB.delete()) {
                p6Var3.getLogger().h(p5.ERROR, "Failed to delete: %s", fileB.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileB);
            try {
                ((l1) fVar3.a()).e(cVar, fileOutputStream2);
                fileOutputStream2.close();
                z = true;
            } finally {
                try {
                    fileOutputStream2.close();
                    throw th;
                } catch (Throwable th5) {
                    th.addSuppressed(th5);
                }
            }
        } catch (Throwable th6) {
            p6Var3.getLogger().b(p5.ERROR, th6, "Error writing Envelope %s to offline storage", fileB.getAbsolutePath());
            z = false;
        }
        if (l7.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(new File(p6Var3.getCacheDirPath(), "last_crash"));
                try {
                    fileOutputStream3.write(io.sentry.vendor.a.f(new Date().getTime()).getBytes(charset));
                    fileOutputStream3.flush();
                    fileOutputStream3.close();
                } finally {
                }
            } catch (Throwable th7) {
                p6Var3.getLogger().d(p5.ERROR, "Error writing the crash marker file to the disk", th7);
            }
        }
        return z;
    }
}
