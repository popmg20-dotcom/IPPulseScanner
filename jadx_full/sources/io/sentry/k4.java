package io.sentry;

import defpackage.xe;
import defpackage.xy0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k4 implements f1 {
    public final d1 a;
    public final d1 b;
    public final d1 c;
    public final n d;
    public final m e;
    public final i0 f;
    public final i0 g;

    public k4(d1 d1Var, d1 d1Var2, d1 d1Var3) {
        this.e = new m(0, d1Var3, d1Var2, d1Var);
        this.a = d1Var;
        this.b = d1Var2;
        this.c = d1Var3;
        p6 options = getOptions();
        io.sentry.util.b.r(options, "SentryOptions is required.");
        if (options.getDsn() == null || options.getDsn().isEmpty()) {
            xe.k("Scopes requires a DSN to be instantiated. Considering using the NoOpScopes if no DSN is available.");
            throw null;
        }
        this.d = options.getCompositePerformanceCollector();
        this.f = new i0(this);
        this.g = new i0(this);
    }

    @Override // io.sentry.f1
    public final f1 A(String str) {
        return new k4(this.a.clone(), this.b.clone(), this.c);
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w B(f5 f5Var, l0 l0Var) {
        d1 d1Var = this.e;
        io.sentry.protocol.w wVarL = io.sentry.protocol.w.f;
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return wVarL;
        }
        try {
            d1Var.z(f5Var);
            wVarL = d1Var.v().l(f5Var, d1Var, l0Var);
            d1Var.E(wVarL);
            return wVarL;
        } catch (Throwable th) {
            getOptions().getLogger().d(p5.ERROR, "Error while capturing event with id: " + f5Var.b, th);
            return wVarL;
        }
    }

    @Override // io.sentry.f1
    public final void a(boolean z) {
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (v1 v1Var : getOptions().getIntegrations()) {
                if (v1Var instanceof Closeable) {
                    try {
                        ((Closeable) v1Var).close();
                    } catch (Throwable th) {
                        getOptions().getLogger().h(p5.WARNING, "Failed to close the integration {}.", v1Var, th);
                    }
                }
            }
            for (f0 f0Var : getOptions().getEventProcessors()) {
                if (f0Var instanceof Closeable) {
                    try {
                        ((Closeable) f0Var).close();
                    } catch (Throwable th2) {
                        getOptions().getLogger().h(p5.WARNING, "Failed to close the event processor {}.", f0Var, th2);
                    }
                }
            }
            boolean zIsEnabled = isEnabled();
            m mVar = this.e;
            if (zIsEnabled) {
                try {
                    mVar.b(null).clear();
                } catch (Throwable th3) {
                    getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th3);
                }
            } else {
                getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            }
            j4 j4Var = j4.ISOLATION;
            if (isEnabled()) {
                try {
                    mVar.b(j4Var).clear();
                } catch (Throwable th4) {
                    getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th4);
                }
            } else {
                getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            }
            getOptions().getBackpressureMonitor().close();
            getOptions().getTransactionProfiler().close();
            getOptions().getContinuousProfiler().a(true);
            getOptions().getCompositePerformanceCollector().close();
            getOptions().getConnectionStatusProvider().close();
            if (!z) {
                getOptions().getTimerExecutorService().a(getOptions().getShutdownTimeoutMillis());
            }
            j1 executorService = getOptions().getExecutorService();
            if (z) {
                try {
                    executorService.submit(new xy0(27, this, executorService));
                } catch (RejectedExecutionException e) {
                    getOptions().getLogger().d(p5.WARNING, "Failed to submit executor service shutdown task during restart. Shutting down synchronously.", e);
                    executorService.a(getOptions().getShutdownTimeoutMillis());
                }
            } else {
                executorService.a(getOptions().getShutdownTimeoutMillis());
            }
            j4 j4Var2 = j4.CURRENT;
            if (isEnabled()) {
                try {
                    mVar.b(j4Var2).v().a(z);
                } catch (Throwable th5) {
                    getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th5);
                }
            } else {
                getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            }
            j4 j4Var3 = j4.ISOLATION;
            if (isEnabled()) {
                try {
                    mVar.b(j4Var3).v().a(z);
                } catch (Throwable th6) {
                    getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th6);
                }
            } else {
                getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            }
            j4 j4Var4 = j4.GLOBAL;
            if (!isEnabled()) {
                getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
                return;
            }
            try {
                mVar.b(j4Var4).v().a(z);
            } catch (Throwable th7) {
                getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th7);
            }
        } catch (Throwable th8) {
            getOptions().getLogger().d(p5.ERROR, "Error while closing the Scopes.", th8);
        }
    }

    @Override // io.sentry.f1
    public final void b(long j) {
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.e.v().b(j);
        } catch (Throwable th) {
            getOptions().getLogger().d(p5.ERROR, "Error in the 'client.flush'.", th);
        }
    }

    @Override // io.sentry.f1
    public final void c(g gVar, l0 l0Var) {
        if (isEnabled()) {
            this.e.c(gVar, l0Var);
        } else {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        }
    }

    @Override // io.sentry.f1
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final y0 m6clone() {
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Disabled Scopes cloned.", new Object[0]);
        }
        return new p0((k4) A("scopes clone"));
    }

    @Override // io.sentry.f1
    public final io.sentry.android.core.internal.tombstone.c d() {
        return this.e.v().d();
    }

    @Override // io.sentry.f1
    public final boolean e() {
        return this.e.v().e();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w f(io.sentry.internal.debugmeta.c cVar, l0 l0Var) {
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            return wVar;
        }
        try {
            io.sentry.protocol.w wVarF = this.e.v().f(cVar, l0Var);
            return wVarF != null ? wVarF : wVar;
        } catch (Throwable th) {
            this.getOptions().getLogger().d(p5.ERROR, "Error while capturing envelope.", th);
            return wVar;
        }
    }

    @Override // io.sentry.f1
    public final void g(g gVar) {
        c(gVar, new l0());
    }

    @Override // io.sentry.f1
    public final p6 getOptions() {
        return ((d1) this.e.b).getOptions();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w h(s3 s3Var) {
        io.sentry.util.b.r(s3Var, "profilingContinuousData is required");
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return wVar;
        }
        try {
            return this.e.v().h(s3Var);
        } catch (Throwable th) {
            this.getOptions().getLogger().d(p5.ERROR, "Error while capturing profile chunk with id: " + s3Var.z, th);
            return wVar;
        }
    }

    @Override // io.sentry.f1
    public final p1 i() {
        if (isEnabled()) {
            return this.e.i();
        }
        getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'getTransaction' call is a no-op.", new Object[0]);
        return null;
    }

    @Override // io.sentry.f1
    public final boolean isEnabled() {
        return this.e.v().isEnabled();
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w j(f5 f5Var) {
        return B(f5Var, new l0());
    }

    @Override // io.sentry.f1
    public final void k() {
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        m mVar = this.e;
        z6 z6VarK = mVar.k();
        if (z6VarK != null) {
            mVar.v().c(z6VarK, io.sentry.util.b.f(new io.sentry.hints.j()));
        }
    }

    @Override // io.sentry.f1
    public final void l() {
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        m mVar = this.e;
        io.sentry.internal.debugmeta.c cVarL = mVar.l();
        if (cVarL == null) {
            getOptions().getLogger().h(p5.WARNING, "Session could not be started.", new Object[0]);
            return;
        }
        z6 z6Var = (z6) cVarL.f;
        if (z6Var != null) {
            mVar.v().c(z6Var, io.sentry.util.b.f(new io.sentry.hints.j()));
        }
        mVar.v().c((z6) cVarL.z, io.sentry.util.b.f(new io.sentry.hints.j()));
    }

    @Override // io.sentry.f1
    public final p1 m(j7 j7Var, k7 k7Var) {
        Double dValueOf;
        j7Var.z0 = k7Var.d;
        boolean zIsEnabled = isEnabled();
        p1 p1VarA = j3.a;
        if (!zIsEnabled) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
        } else if (io.sentry.util.o.a(j7Var.z0, getOptions().getIgnoredSpanOrigins())) {
            getOptions().getLogger().h(p5.DEBUG, "Returning no-op for span origin %s as the SDK has been configured to ignore it", j7Var.z0);
        } else if (!getOptions().getInstrumenter().equals(j7Var.C0)) {
            getOptions().getLogger().h(p5.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", j7Var.C0, getOptions().getInstrumenter());
        } else if (getOptions().isTracingEnabled()) {
            c cVar = j7Var.D0;
            if (cVar == null || (dValueOf = cVar.d) == null) {
                Double d = ((c) this.e.s().e).d;
                dValueOf = Double.valueOf(d == null ? 0.0d : d.doubleValue());
            }
            x3 x3VarA = getOptions().getInternalTracesSampler().a(new m(j7Var, dValueOf));
            Boolean bool = (Boolean) x3VarA.a;
            j7Var.a(x3VarA);
            o1 spanFactory = getOptions().getSpanFactory();
            if (bool.booleanValue() && getOptions().isContinuousProfilingEnabled()) {
                u3 profileLifecycle = getOptions().getProfileLifecycle();
                u3 u3Var = u3.TRACE;
                if (profileLifecycle == u3Var && j7Var.F0.equals(io.sentry.protocol.w.f)) {
                    getOptions().getContinuousProfiler().c(u3Var, getOptions().getInternalTracesSampler());
                }
            }
            p1VarA = spanFactory.a(j7Var, this, k7Var, this.d);
            if (bool.booleanValue() && ((Boolean) x3VarA.d).booleanValue()) {
                q1 transactionProfiler = getOptions().getTransactionProfiler();
                if (!transactionProfiler.isRunning()) {
                    transactionProfiler.start();
                    transactionProfiler.c(p1VarA);
                } else if (k7Var.e) {
                    transactionProfiler.c(p1VarA);
                }
            }
        } else {
            getOptions().getLogger().h(p5.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
        }
        if (g4.ON == k7Var.b) {
            p1VarA.j();
        }
        return p1VarA;
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w n(io.sentry.protocol.f0 f0Var, h7 h7Var, l0 l0Var) {
        return z(f0Var, h7Var, l0Var, null);
    }

    @Override // io.sentry.f1
    public final void o(h4 h4Var) {
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            h4Var.m(this.e.b(null));
        } catch (Throwable th) {
            getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    @Override // io.sentry.f1
    public final boolean p() {
        return false;
    }

    @Override // io.sentry.f1
    public final io.sentry.logger.a q() {
        return this.f;
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w r(r6 r6Var, l0 l0Var) {
        d1 d1Var = this.e;
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'captureReplay' call is a no-op.", new Object[0]);
            return wVar;
        }
        try {
            return d1Var.v().g(r6Var, d1Var, l0Var);
        } catch (Throwable th) {
            this.getOptions().getLogger().d(p5.ERROR, "Error while capturing replay", th);
            return wVar;
        }
    }

    @Override // io.sentry.f1
    public final d1 s() {
        return this.c;
    }

    @Override // io.sentry.f1
    public final d1 t() {
        return this.a;
    }

    @Override // io.sentry.f1
    public final x0 u() {
        return this.g;
    }

    @Override // io.sentry.f1
    public final /* synthetic */ void v(String str) {
        e.a(this, str);
    }

    @Override // io.sentry.f1
    public final void w(h4 h4Var) {
        o(h4Var);
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w x(Throwable th) {
        return y(th, new l0());
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w y(Throwable th, l0 l0Var) {
        io.sentry.protocol.w wVarL = io.sentry.protocol.w.f;
        boolean zIsEnabled = isEnabled();
        d1 d1Var = this.e;
        if (zIsEnabled) {
            try {
                f5 f5Var = new f5(th);
                d1Var.z(f5Var);
                wVarL = d1Var.v().l(f5Var, d1Var, l0Var);
            } catch (Throwable th2) {
                getOptions().getLogger().d(p5.ERROR, "Error while capturing exception: " + th.getMessage(), th2);
            }
        } else {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
        }
        d1Var.E(wVarL);
        return wVarL;
    }

    @Override // io.sentry.f1
    public final io.sentry.protocol.w z(io.sentry.protocol.f0 f0Var, h7 h7Var, l0 l0Var, v3 v3Var) {
        io.sentry.protocol.f0 f0Var2;
        d1 d1Var = this.e;
        ArrayList arrayList = f0Var.J0;
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        if (!isEnabled()) {
            getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return wVar;
        }
        if (f0Var.I0 == null) {
            getOptions().getLogger().h(p5.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", f0Var.b);
            return wVar;
        }
        Boolean bool = Boolean.TRUE;
        b7 b7VarI = f0Var.f.i();
        x3 x3Var = b7VarI == null ? null : b7VarI.A;
        if (bool.equals(Boolean.valueOf(x3Var == null ? false : ((Boolean) x3Var.a).booleanValue()))) {
            try {
                f0Var2 = f0Var;
            } catch (Throwable th) {
                th = th;
                f0Var2 = f0Var;
            }
            try {
                return d1Var.v().j(f0Var2, h7Var, d1Var, l0Var, v3Var);
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                this.getOptions().getLogger().d(p5.ERROR, "Error while capturing transaction with id: " + f0Var2.b, th3);
                return wVar;
            }
        }
        getOptions().getLogger().h(p5.DEBUG, "Transaction %s was dropped due to sampling decision.", f0Var.b);
        if (getOptions().getBackpressureMonitor().a() > 0) {
            io.sentry.clientreport.f clientReportRecorder = getOptions().getClientReportRecorder();
            io.sentry.clientreport.d dVar = io.sentry.clientreport.d.BACKPRESSURE;
            clientReportRecorder.a(dVar, o.Transaction);
            getOptions().getClientReportRecorder().e(dVar, o.Span, arrayList.size() + 1);
            return wVar;
        }
        io.sentry.clientreport.f clientReportRecorder2 = getOptions().getClientReportRecorder();
        io.sentry.clientreport.d dVar2 = io.sentry.clientreport.d.SAMPLE_RATE;
        clientReportRecorder2.a(dVar2, o.Transaction);
        getOptions().getClientReportRecorder().e(dVar2, o.Span, arrayList.size() + 1);
        return wVar;
    }
}
