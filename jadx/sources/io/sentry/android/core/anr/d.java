package io.sentry.android.core.anr;

import io.sentry.ILogger;
import io.sentry.cache.tape.i;
import io.sentry.hints.j;
import io.sentry.p5;
import io.sentry.p6;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d implements AutoCloseable {
    public final io.sentry.cache.tape.f b;

    public d(p6 p6Var, File file) {
        i iVar;
        ILogger logger = p6Var.getLogger();
        try {
            try {
                try {
                    iVar = new i(file, i.g(file), 120);
                } catch (Throwable th) {
                    throw th;
                }
            } catch (IOException e) {
                logger.d(p5.ERROR, "Failed to create stacktrace queue", e);
                iVar = null;
            }
        } catch (IOException unused) {
            if (!file.delete()) {
                throw new IOException("Could not delete file");
            }
            RandomAccessFile randomAccessFileG = i.g(file);
            try {
                iVar = new i(file, randomAccessFileG, 120);
            } finally {
                randomAccessFileG.close();
            }
        }
        if (iVar == null) {
            this.b = new io.sentry.cache.tape.b();
        } else {
            this.b = new io.sentry.cache.tape.d(iVar, new j());
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }
}
