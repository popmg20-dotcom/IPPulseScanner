package io.sentry;

import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n5 {
    public static volatile n5 c;
    public static final io.sentry.util.a d = new io.sentry.util.a();
    public static volatile Boolean e = null;
    public static final io.sentry.util.a f = new io.sentry.util.a();
    public final CopyOnWriteArraySet a = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet b = new CopyOnWriteArraySet();

    public static n5 d() {
        if (c == null) {
            io.sentry.util.a aVar = d;
            aVar.g();
            try {
                if (c == null) {
                    c = new n5();
                }
                aVar.close();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return c;
    }

    public final void a(String str) {
        io.sentry.util.b.r(str, "integration is required.");
        this.a.add(str);
    }

    public final void b(String str, String str2) {
        this.b.add(new io.sentry.protocol.x(str, str2));
        io.sentry.util.a aVar = f;
        aVar.g();
        try {
            e = null;
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean c(ILogger iLogger) {
        Boolean bool = e;
        if (bool != null) {
            return bool.booleanValue();
        }
        io.sentry.util.a aVar = f;
        aVar.g();
        try {
            boolean z = false;
            for (io.sentry.protocol.x xVar : this.b) {
                if (xVar.b.startsWith("maven:io.sentry:") && !"8.51.0".equalsIgnoreCase(xVar.f)) {
                    iLogger.h(p5.ERROR, "The Sentry SDK has been configured with mixed versions. Expected %s to match core SDK version %s but was %s", xVar.b, "8.51.0", xVar.f);
                    z = true;
                }
            }
            if (z) {
                p5 p5Var = p5.ERROR;
                iLogger.h(p5Var, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                iLogger.h(p5Var, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                iLogger.h(p5Var, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                iLogger.h(p5Var, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
            }
            e = Boolean.valueOf(z);
            aVar.close();
            return z;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
