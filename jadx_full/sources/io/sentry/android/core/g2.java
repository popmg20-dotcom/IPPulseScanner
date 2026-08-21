package io.sentry.android.core;

import android.app.ApplicationExitInfo;
import android.content.Context;
import io.sentry.ILogger;
import io.sentry.d5;
import io.sentry.e5;
import io.sentry.f5;
import io.sentry.j2;
import io.sentry.o5;
import io.sentry.p5;
import j$.time.Instant;
import j$.time.format.DateTimeFormatter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g2 implements n0 {
    public final SentryAndroidOptions a;
    public final d1 b;
    public final Context c;

    public g2(Context context, SentryAndroidOptions sentryAndroidOptions) {
        this.a = sentryAndroidOptions;
        this.b = new d1(sentryAndroidOptions);
        this.c = context;
    }

    @Override // io.sentry.android.core.n0
    public final int a() {
        return 5;
    }

    @Override // io.sentry.android.core.n0
    public final Long b() {
        return io.sentry.android.core.cache.c.h(this.a, "last_tombstone_report", "Tombstone");
    }

    @Override // io.sentry.android.core.n0
    public final String c() {
        return "Tombstone";
    }

    @Override // io.sentry.android.core.n0
    public final boolean d() {
        return this.a.isReportHistoricalTombstones();
    }

    @Override // io.sentry.android.core.n0
    public final io.sentry.m e(ApplicationExitInfo applicationExitInfo, boolean z) {
        SentryAndroidOptions sentryAndroidOptions = this.a;
        try {
            boolean zIsAttachRawTombstone = sentryAndroidOptions.isAttachRawTombstone();
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            try {
                if (traceInputStream == null) {
                    sentryAndroidOptions.getLogger().h(p5.WARNING, "No tombstone InputStream available for ApplicationExitInfo from %s", DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochMilli(applicationExitInfo.getTimestamp())));
                    if (traceInputStream == null) {
                        return null;
                    }
                    traceInputStream.close();
                    return null;
                }
                byte[] bArrO = zIsAttachRawTombstone ? io.sentry.config.a.o(traceInputStream) : null;
                io.sentry.android.core.internal.tombstone.c cVar = new io.sentry.android.core.internal.tombstone.c(zIsAttachRawTombstone ? new ByteArrayInputStream(bArrO) : traceInputStream, sentryAndroidOptions.getInAppIncludes(), sentryAndroidOptions.getInAppExcludes(), this.c.getApplicationInfo().nativeLibraryDir);
                try {
                    f5 f5VarS = cVar.s();
                    cVar.close();
                    traceInputStream.close();
                    long timestamp = applicationExitInfo.getTimestamp();
                    f5VarS.G0 = new Date(timestamp);
                    f2 f2Var = new f2(sentryAndroidOptions.getFlushTimeoutMillis(), sentryAndroidOptions.getLogger(), timestamp, z);
                    io.sentry.l0 l0VarF = io.sentry.util.b.f(f2Var);
                    if (bArrO != null) {
                        l0VarF.g = new io.sentry.a("tombstone.pb", "application/x-protobuf", bArrO);
                    }
                    try {
                        f5 f5VarF = f(timestamp, f5VarS, l0VarF);
                        if (f5VarF != null) {
                            f5VarS = f5VarF;
                        }
                    } catch (Throwable th) {
                        sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to merge native event with tombstone, continuing without merge: %s", th.getMessage());
                    }
                    return new io.sentry.m(2, f5VarS, l0VarF, f2Var);
                } finally {
                }
            } finally {
            }
        } catch (Throwable th2) {
            sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to parse tombstone from %s: %s", DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochMilli(applicationExitInfo.getTimestamp())), th2.getMessage());
            return null;
        }
        sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to parse tombstone from %s: %s", DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochMilli(applicationExitInfo.getTimestamp())), th2.getMessage());
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
    
        r13.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x01bd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f5 f(long j, f5 f5Var, io.sentry.l0 l0Var) {
        int i;
        f5 f5Var2;
        int i2;
        File[] fileArr;
        String name;
        c1 c1Var;
        c1 c1VarA;
        int i3;
        String string;
        long j2;
        io.sentry.m mVar;
        e5 e5Var;
        String str;
        String str2;
        io.sentry.internal.debugmeta.c cVarA;
        d1 d1Var = this.b;
        ArrayList arrayList = (ArrayList) d1Var.c;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) d1Var.b;
        int i4 = 1;
        int i5 = 0;
        if (d1Var.a) {
            i = 0;
            f5Var2 = null;
        } else {
            d1Var.a = true;
            String outboxPath = sentryAndroidOptions.getOutboxPath();
            if (outboxPath == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Outbox path is null, skipping native event collection.", new Object[0]);
            } else {
                File[] fileArrListFiles = new File(outboxPath).listFiles();
                if (fileArrListFiles == null) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Outbox path is not a directory or an I/O error occurred: %s", outboxPath);
                } else if (fileArrListFiles.length == 0) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "No envelope files found in outbox.", new Object[0]);
                } else {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Scanning %d files in outbox for native events.", Integer.valueOf(fileArrListFiles.length));
                    int length = fileArrListFiles.length;
                    int i6 = 0;
                    while (i6 < length) {
                        File file = fileArrListFiles[i6];
                        if (!file.isFile() || (name = file.getName()) == null || name.startsWith("session") || name.startsWith("previous_session") || name.startsWith("startup_crash")) {
                            i2 = i5;
                            fileArr = fileArrListFiles;
                        } else {
                            try {
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                                int i7 = i5;
                                while (true) {
                                    try {
                                        int i8 = bufferedInputStream.read();
                                        c1Var = null;
                                        i3 = -1;
                                        if (i8 != -1) {
                                            i7++;
                                            if (i8 == 10) {
                                                break;
                                            }
                                        } else if (i7 <= 0) {
                                            i7 = -1;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        i2 = i5;
                                        fileArr = fileArrListFiles;
                                        c1Var = null;
                                    }
                                }
                                if (i7 < 0) {
                                    try {
                                        bufferedInputStream.close();
                                        i2 = i5;
                                        fileArr = fileArrListFiles;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        i2 = i5;
                                        fileArr = fileArrListFiles;
                                        ILogger logger = sentryAndroidOptions.getLogger();
                                        p5 p5Var = p5.DEBUG;
                                        Object[] objArr = new Object[1];
                                        objArr[i2] = file.getAbsolutePath();
                                        logger.b(p5Var, th, "Error extracting metadata from envelope file: %s", objArr);
                                    }
                                } else {
                                    int i9 = i5;
                                    fileArr = fileArrListFiles;
                                    long j3 = i7;
                                    while (true) {
                                        if (j3 >= 209715200) {
                                            i2 = i9;
                                            break;
                                        }
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            i2 = i9;
                                            while (true) {
                                                try {
                                                    int i10 = bufferedInputStream.read();
                                                    if (i10 == i3) {
                                                        string = sb.length() > 0 ? sb.toString() : null;
                                                    } else {
                                                        if (i10 == 10) {
                                                            string = sb.toString();
                                                            break;
                                                        }
                                                        sb.append((char) i10);
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    Throwable th4 = th;
                                                    try {
                                                        bufferedInputStream.close();
                                                    } catch (Throwable th5) {
                                                        th4.addSuppressed(th5);
                                                    }
                                                    throw th4;
                                                }
                                            }
                                            if (string == null || string.isEmpty()) {
                                                break;
                                            }
                                            long length2 = j3 + ((long) (string.length() + i4));
                                            j2 j2VarC = d1Var.c(string);
                                            if (j2VarC == null) {
                                                break;
                                            }
                                            int i11 = j2VarC.a;
                                            if ("event".equals((String) j2VarC.b)) {
                                                c1VarA = d1Var.a(bufferedInputStream, i11, file);
                                                if (c1VarA != null) {
                                                    try {
                                                        break;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        ILogger logger2 = sentryAndroidOptions.getLogger();
                                                        p5 p5Var2 = p5.DEBUG;
                                                        Object[] objArr2 = new Object[1];
                                                        objArr2[i2] = file.getAbsolutePath();
                                                        logger2.b(p5Var2, th, "Error extracting metadata from envelope file: %s", objArr2);
                                                        c1VarA = c1Var;
                                                        if (c1VarA == null) {
                                                        }
                                                        i6++;
                                                        fileArrListFiles = fileArr;
                                                        i5 = i2;
                                                        i4 = 1;
                                                    }
                                                } else {
                                                    j2 = length2;
                                                }
                                            } else {
                                                j2 = length2;
                                                d1.d(bufferedInputStream, i11);
                                            }
                                            long j4 = j2 + ((long) i11);
                                            int i12 = bufferedInputStream.read();
                                            if (i12 == -1) {
                                                break;
                                            }
                                            long j5 = j4 + 1;
                                            if (i12 != 10) {
                                                break;
                                            }
                                            j3 = j5;
                                            i9 = i2;
                                            i4 = 1;
                                            i3 = -1;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            i2 = i9;
                                        }
                                    }
                                    bufferedInputStream.close();
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                i2 = i5;
                                fileArr = fileArrListFiles;
                                c1Var = null;
                            }
                            c1VarA = c1Var;
                            if (c1VarA == null) {
                                arrayList.add(c1VarA);
                                ILogger logger3 = sentryAndroidOptions.getLogger();
                                p5 p5Var3 = p5.DEBUG;
                                String name2 = file.getName();
                                Long lValueOf = Long.valueOf(c1VarA.b);
                                Object[] objArr3 = new Object[2];
                                objArr3[i2] = name2;
                                objArr3[1] = lValueOf;
                                logger3.h(p5Var3, "Found native event in outbox: %s (timestamp: %d)", objArr3);
                            }
                        }
                        i6++;
                        fileArrListFiles = fileArr;
                        i5 = i2;
                        i4 = 1;
                    }
                    i = i5;
                    f5Var2 = null;
                    ILogger logger4 = sentryAndroidOptions.getLogger();
                    p5 p5Var4 = p5.DEBUG;
                    Object[] objArr4 = new Object[1];
                    objArr4[i] = Integer.valueOf(arrayList.size());
                    logger4.h(p5Var4, "Collected %d native events from outbox.", objArr4);
                }
            }
            i = 0;
            f5Var2 = null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c1 c1Var2 = (c1) it.next();
            long jAbs = Math.abs(j - c1Var2.b);
            if (jAbs <= 5000) {
                ILogger logger5 = sentryAndroidOptions.getLogger();
                p5 p5Var5 = p5.DEBUG;
                Object[] objArr5 = new Object[1];
                objArr5[i] = Long.valueOf(jAbs);
                logger5.h(p5Var5, "Matched native event by timestamp (diff: %d ms)", objArr5);
                arrayList.remove(c1Var2);
                File file2 = c1Var2.a;
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        cVarA = sentryAndroidOptions.getEnvelopeReader().a(bufferedInputStream2);
                    } finally {
                    }
                    if (cVarA != null) {
                        for (d5 d5Var : (Iterable) cVarA.z) {
                            if (o5.Event.equals(d5Var.a.X)) {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d5Var.g()), StandardCharsets.UTF_8));
                                try {
                                    f5 f5Var3 = (f5) sentryAndroidOptions.getSerializer().b(bufferedReader, f5.class);
                                    if (f5Var3 != null && "native".equals(f5Var3.y0)) {
                                        io.sentry.m mVar2 = new io.sentry.m(3, f5Var3, file2, cVarA);
                                        bufferedReader.close();
                                        bufferedInputStream2.close();
                                        mVar = mVar2;
                                        break;
                                    }
                                    bufferedReader.close();
                                } finally {
                                }
                            }
                        }
                    }
                    bufferedInputStream2.close();
                } catch (Throwable th9) {
                    ILogger logger6 = sentryAndroidOptions.getLogger();
                    p5 p5Var6 = p5.DEBUG;
                    Object[] objArr6 = new Object[1];
                    objArr6[i] = file2.getAbsolutePath();
                    logger6.b(p5Var6, th9, "Error loading envelope file: %s", objArr6);
                    mVar = f5Var2;
                    SentryAndroidOptions sentryAndroidOptions2 = this.a;
                    if (mVar == 0) {
                        sentryAndroidOptions2.getLogger().h(p5.DEBUG, "No matching native event found for tombstone.", new Object[i]);
                        return f5Var2;
                    }
                    File file3 = (File) mVar.c;
                    ILogger logger7 = sentryAndroidOptions2.getLogger();
                    p5 p5Var7 = p5.DEBUG;
                    Object[] objArr7 = new Object[1];
                    objArr7[i] = file3.getName();
                    logger7.h(p5Var7, "Found matching native event for tombstone, removing from outbox: %s", objArr7);
                    try {
                    } catch (Throwable th10) {
                        sentryAndroidOptions.getLogger().b(p5.ERROR, th10, "Error deleting native event file: %s", file3.getAbsolutePath());
                    }
                    if (!file3.delete()) {
                        sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to delete native event file: %s", file3.getAbsolutePath());
                        return f5Var2;
                    }
                    sentryAndroidOptions.getLogger().h(p5Var7, "Deleted native event file from outbox: %s", file3.getName());
                    f5 f5Var4 = (f5) mVar.b;
                    ArrayList arrayListD = f5Var.d();
                    io.sentry.protocol.f fVar = f5Var.E0;
                    ArrayList arrayListE = f5Var.e();
                    if (arrayListD != null && !arrayListD.isEmpty() && fVar != null && arrayListE != null) {
                        io.sentry.protocol.o oVar = ((io.sentry.protocol.v) arrayListD.get(0)).Y;
                        if (oVar != null) {
                            oVar.b = io.sentry.android.core.internal.tombstone.a.TOMBSTONE_MERGED.getValue();
                        }
                        io.sentry.protocol.p pVar = f5Var4.H0;
                        if (pVar == null || (str2 = pVar.f) == null || str2.isEmpty()) {
                            f5Var4.H0 = f5Var.H0;
                        }
                        f5Var4.h(arrayListD);
                        f5Var4.E0 = fVar;
                        f5Var4.J0 = new io.sentry.g2(arrayListE);
                    }
                    for (d5 d5Var2 : (Iterable) ((io.sentry.internal.debugmeta.c) mVar.d).z) {
                        try {
                            e5Var = d5Var2.a;
                            str = e5Var.z;
                        } catch (Throwable th11) {
                            th = th11;
                        }
                        if (e5Var.X == o5.Attachment && str != null) {
                            byte[] bArrG = d5Var2.g();
                            e5 e5Var2 = d5Var2.a;
                            try {
                                l0Var.b.add(new io.sentry.a(str, e5Var2.b, e5Var2.y0, bArrG));
                            } catch (Throwable th12) {
                                th = th12;
                                sentryAndroidOptions2.getLogger().h(p5.DEBUG, "Failed to process envelope item: %s", th.getMessage());
                            }
                        }
                    }
                    return f5Var4;
                }
            }
        }
    }
}
