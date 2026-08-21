package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j7 extends b7 {
    public static final io.sentry.protocol.i0 J0 = io.sentry.protocol.i0.CUSTOM;
    public String G0;
    public io.sentry.protocol.i0 H0;
    public final x3 I0;

    public j7(String str, io.sentry.protocol.i0 i0Var, String str2, x3 x3Var) {
        super(new io.sentry.protocol.w(), new d7(), str2, null);
        this.G0 = str;
        this.H0 = i0Var;
        a(x3Var);
        this.D0 = io.sentry.util.b.h(null, x3Var == null ? null : (Boolean) x3Var.a, x3Var == null ? null : (Double) x3Var.b, x3Var == null ? null : (Double) x3Var.c);
    }

    public static j7 b(x3 x3Var) {
        x3 x3Var2;
        Boolean bool = (Boolean) x3Var.a;
        c cVar = (c) x3Var.e;
        Double d = cVar.c;
        if (bool == null) {
            x3Var2 = null;
        } else {
            Double d2 = cVar.d;
            x3Var2 = new x3(bool, d, Double.valueOf(d2 == null ? 0.0d : d2.doubleValue()));
        }
        return new j7((io.sentry.protocol.w) x3Var.b, (d7) x3Var.c, (d7) x3Var.d, x3Var2, cVar);
    }

    public j7(io.sentry.protocol.w wVar, d7 d7Var, d7 d7Var2, x3 x3Var, c cVar) {
        super(wVar, d7Var, "default", d7Var2);
        this.G0 = "<unlabeled transaction>";
        this.I0 = x3Var;
        this.H0 = J0;
        this.D0 = io.sentry.util.b.h(cVar, x3Var == null ? null : (Boolean) x3Var.a, x3Var == null ? null : (Double) x3Var.b, x3Var != null ? (Double) x3Var.c : null);
    }
}
