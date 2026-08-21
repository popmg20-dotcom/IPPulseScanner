package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i7 {
    public final p6 a;

    public i7(p6 p6Var) {
        this.a = p6Var;
    }

    public final x3 a(m mVar) {
        Double d = (Double) mVar.c;
        j7 j7Var = (j7) mVar.b;
        x3 x3Var = j7Var.A;
        if (x3Var != null) {
            return io.sentry.util.b.b(x3Var);
        }
        p6 p6Var = this.a;
        p6Var.getProfilesSampler();
        Double profilesSampleRate = p6Var.getProfilesSampleRate();
        Boolean boolValueOf = Boolean.valueOf(profilesSampleRate != null && profilesSampleRate.doubleValue() >= d.doubleValue());
        p6Var.getTracesSampler();
        x3 x3Var2 = j7Var.I0;
        if (x3Var2 != null) {
            return io.sentry.util.b.b(x3Var2);
        }
        Double tracesSampleRate = p6Var.getTracesSampleRate();
        Double dValueOf = tracesSampleRate == null ? null : Double.valueOf(tracesSampleRate.doubleValue() / Math.pow(2.0d, p6Var.getBackpressureMonitor().a()));
        if (dValueOf != null) {
            return new x3(Boolean.valueOf(dValueOf.doubleValue() >= d.doubleValue()), dValueOf, d, boolValueOf, profilesSampleRate);
        }
        Boolean bool = Boolean.FALSE;
        return new x3(bool, (Double) null, d, bool, (Double) null);
    }

    public final boolean b(double d) {
        Double profileSessionSampleRate = this.a.getProfileSessionSampleRate();
        return profileSessionSampleRate != null && profileSessionSampleRate.doubleValue() >= d;
    }
}
