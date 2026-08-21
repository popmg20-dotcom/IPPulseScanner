package io.sentry;

import defpackage.l84;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n4 {
    public final /* synthetic */ int a;
    public final io.sentry.android.core.q b;

    public /* synthetic */ n4(io.sentry.android.core.q qVar, int i) {
        this.a = i;
        this.b = qVar;
    }

    public final l84 a(f1 f1Var, p6 p6Var) {
        int i = this.a;
        io.sentry.android.core.q qVar = this.b;
        switch (i) {
            case 0:
                io.sentry.util.b.r(f1Var, "Scopes are required");
                io.sentry.util.b.r(p6Var, "SentryOptions is required");
                String cacheDirPath = qVar.f.getCacheDirPath();
                if (cacheDirPath == null || !e.b(cacheDirPath, p6Var.getLogger())) {
                    p6Var.getLogger().h(p5.ERROR, "No cache dir path is defined in options.", new Object[0]);
                }
                break;
            default:
                io.sentry.util.b.r(f1Var, "Scopes are required");
                io.sentry.util.b.r(p6Var, "SentryOptions is required");
                String outboxPath = qVar.f.getOutboxPath();
                if (outboxPath == null || !e.b(outboxPath, p6Var.getLogger())) {
                    p6Var.getLogger().h(p5.ERROR, "No outbox dir path is defined in options.", new Object[0]);
                }
                break;
        }
        return null;
    }
}
