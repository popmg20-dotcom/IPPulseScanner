package io.sentry;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends z {
    public final f1 e;
    public final l1 f;
    public final ILogger g;

    public e0(f1 f1Var, l1 l1Var, ILogger iLogger, long j, int i) {
        super(f1Var, iLogger, j, i);
        this.e = f1Var;
        io.sentry.util.b.r(l1Var, "Serializer is required.");
        this.f = l1Var;
        io.sentry.util.b.r(iLogger, "Logger is required.");
        this.g = iLogger;
    }

    @Override // io.sentry.z
    public final boolean a(String str) {
        return str.endsWith(".envelope");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0116, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0118, code lost:
    
        c(r11, (io.sentry.hints.h) r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0141, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0161, code lost:
    
        if (r2 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0164, code lost:
    
        return;
     */
    @Override // io.sentry.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(File file, l0 l0Var) {
        Object objB;
        boolean zIsFile = file.isFile();
        ILogger iLogger = this.g;
        if (!zIsFile) {
            iLogger.h(p5.DEBUG, "'%s' is not a file.", file.getAbsolutePath());
            return;
        }
        if (!file.getName().endsWith(".envelope")) {
            iLogger.h(p5.DEBUG, "File '%s' doesn't match extension expected.", file.getAbsolutePath());
            return;
        }
        try {
            if (!file.getParentFile().canWrite()) {
                iLogger.h(p5.WARNING, "File '%s' cannot be deleted so it will not be processed.", file.getAbsolutePath());
                return;
            }
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        io.sentry.internal.debugmeta.c cVarC = this.f.c(bufferedInputStream);
                        if (cVarC == null) {
                            iLogger.h(p5.ERROR, "Failed to deserialize cached envelope %s", file.getAbsolutePath());
                        } else {
                            this.e.f(cVarC, l0Var);
                        }
                        Object objB2 = l0Var.b("sentry:typeCheckHint");
                        if (!io.sentry.hints.f.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB2 == null) {
                            io.sentry.util.b.n(io.sentry.hints.f.class, objB2, iLogger);
                        } else if (!((io.sentry.hints.f) objB2).d()) {
                            iLogger.h(p5.WARNING, "Timed out waiting for envelope submission.", new Object[0]);
                        }
                        bufferedInputStream.close();
                        Object objB3 = l0Var.b("sentry:typeCheckHint");
                        if (!io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB3 == null) {
                            io.sentry.util.b.n(io.sentry.hints.h.class, objB3, iLogger);
                        } else {
                            c(file, (io.sentry.hints.h) objB3);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    iLogger.b(p5.ERROR, e, "I/O on file '%s' failed.", file.getAbsolutePath());
                    objB = l0Var.b("sentry:typeCheckHint");
                    if (io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
                    }
                    io.sentry.util.b.n(io.sentry.hints.h.class, objB, iLogger);
                }
            } catch (FileNotFoundException e2) {
                iLogger.b(p5.ERROR, e2, "File '%s' cannot be found.", file.getAbsolutePath());
                objB = l0Var.b("sentry:typeCheckHint");
                if (io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
                }
                io.sentry.util.b.n(io.sentry.hints.h.class, objB, iLogger);
            } catch (Throwable th3) {
                iLogger.b(p5.ERROR, th3, "Failed to capture cached envelope %s", file.getAbsolutePath());
                Object objB4 = l0Var.b("sentry:typeCheckHint");
                if (!io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB4 == null) {
                    io.sentry.util.b.n(io.sentry.hints.h.class, objB4, iLogger);
                } else {
                    ((io.sentry.hints.h) objB4).c(false);
                    iLogger.b(p5.INFO, th3, "File '%s' won't retry.", file.getAbsolutePath());
                }
                objB = l0Var.b("sentry:typeCheckHint");
                if (io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
                }
                io.sentry.util.b.n(io.sentry.hints.h.class, objB, iLogger);
            }
        } catch (Throwable th4) {
            Object objB5 = l0Var.b("sentry:typeCheckHint");
            if (!io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB5 == null) {
                io.sentry.util.b.n(io.sentry.hints.h.class, objB5, iLogger);
            } else {
                c(file, (io.sentry.hints.h) objB5);
            }
            throw th4;
        }
    }

    public final void c(File file, io.sentry.hints.h hVar) {
        boolean zA = hVar.a();
        ILogger iLogger = this.g;
        if (zA) {
            iLogger.h(p5.INFO, "File not deleted since retry was marked. %s.", file.getAbsolutePath());
            return;
        }
        try {
            if (!file.delete()) {
                iLogger.h(p5.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), "after trying to capture it");
            }
        } catch (Throwable th) {
            iLogger.b(p5.ERROR, th, "Failed to delete '%s' %s", file.getAbsolutePath(), "after trying to capture it");
        }
        iLogger.h(p5.DEBUG, "Deleted file %s.", file.getAbsolutePath());
    }
}
