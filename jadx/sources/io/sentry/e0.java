package io.sentry;

import java.io.File;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.io.File r11, io.sentry.l0 r12) {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.e0.b(java.io.File, io.sentry.l0):void");
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
