package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.d5;
import io.sentry.p5;
import io.sentry.p6;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g implements io.sentry.clientreport.f {
    public static boolean b(p6 p6Var, String str) {
        return d(str, p6Var != null ? p6Var.getLogger() : null);
    }

    public static boolean d(String str, ILogger iLogger) {
        return f(iLogger, str, false) != null;
    }

    public static Class f(ILogger iLogger, String str, boolean z) {
        try {
            return Class.forName(str, z, g.class.getClassLoader());
        } catch (ClassNotFoundException unused) {
            if (iLogger == null) {
                return null;
            }
            iLogger.h(p5.INFO, "Class not available: ".concat(str), new Object[0]);
            return null;
        } catch (UnsatisfiedLinkError e) {
            if (iLogger == null) {
                return null;
            }
            iLogger.d(p5.ERROR, "Failed to load (UnsatisfiedLinkError) ".concat(str), e);
            return null;
        } catch (Throwable th) {
            if (iLogger == null) {
                return null;
            }
            iLogger.d(p5.ERROR, "Failed to initialize ".concat(str), th);
            return null;
        }
    }

    @Override // io.sentry.clientreport.f
    public io.sentry.internal.debugmeta.c j(io.sentry.internal.debugmeta.c cVar) {
        return cVar;
    }

    @Override // io.sentry.clientreport.f
    public void a(io.sentry.clientreport.d dVar, io.sentry.o oVar) {
    }

    @Override // io.sentry.clientreport.f
    public void c(io.sentry.clientreport.d dVar, io.sentry.internal.debugmeta.c cVar) {
    }

    @Override // io.sentry.clientreport.f
    public void g(io.sentry.clientreport.d dVar, d5 d5Var) {
    }

    @Override // io.sentry.clientreport.f
    public void e(io.sentry.clientreport.d dVar, io.sentry.o oVar, long j) {
    }
}
