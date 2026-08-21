package io.sentry.transport;

import defpackage.e04;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.l0;
import io.sentry.p5;
import io.sentry.w4;
import io.sentry.y4;
import java.io.IOException;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {
    public final q A = new q(-1);
    public final /* synthetic */ c X;
    public final io.sentry.internal.debugmeta.c b;
    public final l0 f;
    public final io.sentry.cache.c z;

    public b(c cVar, io.sentry.internal.debugmeta.c cVar2, l0 l0Var, io.sentry.cache.c cVar3) {
        this.X = cVar;
        io.sentry.util.b.r(cVar2, "Envelope is required.");
        this.b = cVar2;
        this.f = l0Var;
        io.sentry.util.b.r(cVar3, "EnvelopeCache is required.");
        this.z = cVar3;
    }

    public final io.sentry.config.a a() {
        Class cls;
        w4 w4VarA;
        io.sentry.internal.debugmeta.c cVar = this.b;
        ((y4) cVar.f).A = null;
        io.sentry.cache.c cVar2 = this.z;
        l0 l0Var = this.f;
        boolean zN = cVar2.n(cVar, l0Var);
        Object objB = l0Var.b("sentry:typeCheckHint");
        boolean zIsInstance = io.sentry.hints.c.class.isInstance(l0Var.b("sentry:typeCheckHint"));
        c cVar3 = this.X;
        if (zIsInstance && objB != null) {
            io.sentry.hints.c cVar4 = (io.sentry.hints.c) objB;
            SentryAndroidOptions sentryAndroidOptions = cVar3.z;
            if (cVar4.f(((y4) cVar.f).b)) {
                cVar4.b.countDown();
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Disk flush envelope fired", new Object[0]);
            } else {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Not firing envelope flush as there's an ongoing transaction", new Object[0]);
            }
        }
        SentryAndroidOptions sentryAndroidOptions2 = cVar3.z;
        if (!cVar3.X.isConnected()) {
            Object objB2 = l0Var.b("sentry:typeCheckHint");
            boolean zIsInstance2 = io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint"));
            q qVar = this.A;
            if (zIsInstance2 && objB2 != null) {
                ((io.sentry.hints.h) objB2).c(true);
                return qVar;
            }
            if (!zN) {
                io.sentry.util.b.n(io.sentry.hints.h.class, objB2, sentryAndroidOptions2.getLogger());
                sentryAndroidOptions2.getClientReportRecorder().c(io.sentry.clientreport.d.NETWORK_ERROR, cVar);
            }
            return qVar;
        }
        io.sentry.internal.debugmeta.c cVarJ = sentryAndroidOptions2.getClientReportRecorder().j(cVar);
        try {
            w4VarA = sentryAndroidOptions2.getDateProvider().a();
            cls = io.sentry.hints.h.class;
        } catch (IOException e) {
            e = e;
            cls = io.sentry.hints.h.class;
        }
        try {
            ((y4) cVarJ.f).A = new Date((long) (w4VarA.d() / 1000000.0d));
            io.sentry.config.a aVarD = cVar3.Y.d(cVarJ);
            if (aVarD.n()) {
                cVar2.Q(cVar);
                return aVarD;
            }
            String str = "The transport failed to send the envelope with response code " + aVarD.l();
            sentryAndroidOptions2.getLogger().h(p5.ERROR, str, new Object[0]);
            if (aVarD.l() >= 400) {
                cVar2.Q(cVar);
                if (aVarD.l() != 429) {
                    sentryAndroidOptions2.getClientReportRecorder().c(io.sentry.clientreport.d.SEND_ERROR, cVarJ);
                }
            }
            throw new IllegalStateException(str);
        } catch (IOException e2) {
            e = e2;
            Object objB3 = l0Var.b("sentry:typeCheckHint");
            Class cls2 = cls;
            if (cls2.isInstance(l0Var.b("sentry:typeCheckHint")) && objB3 != null) {
                ((io.sentry.hints.h) objB3).c(true);
            } else if (!zN) {
                io.sentry.util.b.n(cls2, objB3, sentryAndroidOptions2.getLogger());
                sentryAndroidOptions2.getClientReportRecorder().c(io.sentry.clientreport.d.NETWORK_ERROR, cVarJ);
            }
            e04.l("Sending the event failed.", e);
            return null;
        }
    }

    public final /* synthetic */ void b(io.sentry.config.a aVar, io.sentry.hints.k kVar) {
        this.X.z.getLogger().h(p5.DEBUG, "Marking envelope submission result: %s", Boolean.valueOf(aVar.n()));
        kVar.b(aVar.n());
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.X.Z = this;
        io.sentry.config.a aVarA = this.A;
        try {
            aVarA = a();
            this.X.z.getLogger().h(p5.DEBUG, "Envelope flushed", new Object[0]);
        } catch (Throwable th) {
            try {
                this.X.z.getLogger().b(p5.ERROR, th, "Envelope submission failed", new Object[0]);
                throw th;
            } finally {
                l0 l0Var = this.f;
                Object objB = l0Var.b("sentry:typeCheckHint");
                if (io.sentry.hints.k.class.isInstance(l0Var.b("sentry:typeCheckHint")) && objB != null) {
                    b(aVarA, (io.sentry.hints.k) objB);
                }
                this.X.Z = null;
            }
        }
    }
}
