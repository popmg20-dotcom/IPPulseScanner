package io.sentry;

import defpackage.uj0;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final uj0 i = new uj0(7);
    public final ConcurrentHashMap a;
    public final io.sentry.util.a b;
    public Double c;
    public Double d;
    public final String e;
    public boolean f;
    public final boolean g;
    public final ILogger h;

    public c(ConcurrentHashMap concurrentHashMap, Double d, Double d2, String str, boolean z, ILogger iLogger) {
        this.b = new io.sentry.util.a();
        this.a = concurrentHashMap;
        this.c = d;
        this.d = d2;
        this.h = iLogger;
        this.e = str;
        this.f = true;
        this.g = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(ILogger iLogger, String str, boolean z) {
        Double d;
        Double dValueOf;
        boolean z2;
        Double dValueOf2;
        double d2;
        double d3;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ArrayList arrayList = new ArrayList();
        boolean z3 = false;
        int i2 = 0;
        if (str != null) {
            try {
                String[] strArrSplit = str.split(",", -1);
                int length = strArrSplit.length;
                int i3 = 0;
                z2 = false;
                dValueOf2 = null;
                dValueOf = null;
                while (i3 < length) {
                    try {
                        String str2 = strArrSplit[i3];
                        if (str2.trim().startsWith("sentry-")) {
                            try {
                                int iIndexOf = str2.indexOf("=");
                                String strTrim = str2.substring(i2, iIndexOf).trim();
                                String strDecode = URLDecoder.decode(strTrim, "UTF-8");
                                String strDecode2 = URLDecoder.decode(str2.substring(iIndexOf + 1).trim(), "UTF-8");
                                if ("sentry-sample_rate".equals(strDecode)) {
                                    if (strDecode2 != null) {
                                        try {
                                            d3 = Double.parseDouble(strDecode2);
                                        } catch (NumberFormatException unused) {
                                        }
                                        dValueOf2 = io.sentry.util.b.m(Double.valueOf(d3), false) ? Double.valueOf(d3) : null;
                                    }
                                } else if (!"sentry-sample_rand".equals(strDecode)) {
                                    concurrentHashMap.put(strDecode, strDecode2);
                                } else if (strDecode2 != null) {
                                    try {
                                        d2 = Double.parseDouble(strDecode2);
                                    } catch (NumberFormatException unused2) {
                                    }
                                    dValueOf = io.sentry.util.b.m(Double.valueOf(d2), false) ? Double.valueOf(d2) : null;
                                }
                                if (!"sentry-sample_rand".equalsIgnoreCase(strTrim)) {
                                    z2 = true;
                                }
                            } catch (Throwable th) {
                                iLogger.b(p5.ERROR, th, "Unable to decode baggage key value pair %s", str2);
                            }
                        } else if (z) {
                            arrayList.add(str2.trim());
                        }
                        i3++;
                        i2 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        iLogger.b(p5.ERROR, th, "Unable to decode baggage header %s", str);
                        z3 = z2;
                        d = dValueOf2;
                        return new c(concurrentHashMap, d, dValueOf, !arrayList.isEmpty() ? null : io.sentry.util.p.b(arrayList), z3, iLogger);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z2 = false;
                dValueOf2 = null;
                dValueOf = null;
            }
            z3 = z2;
            d = dValueOf2;
        } else {
            d = null;
            dValueOf = null;
        }
        return new c(concurrentHashMap, d, dValueOf, !arrayList.isEmpty() ? null : io.sentry.util.p.b(arrayList), z3, iLogger);
    }

    public static String c(Double d) {
        if (io.sentry.util.b.m(d, false)) {
            return ((DecimalFormat) i.get()).format(d);
        }
        return null;
    }

    public final String b(String str) {
        return (String) this.a.get(str);
    }

    public final void d(String str, String str2) {
        if (this.f) {
            ConcurrentHashMap concurrentHashMap = this.a;
            if (str2 == null) {
                concurrentHashMap.remove(str);
            } else {
                concurrentHashMap.put(str, str2);
            }
        }
    }

    public final void e(io.sentry.protocol.w wVar, io.sentry.protocol.w wVar2, p6 p6Var, x3 x3Var, String str, io.sentry.protocol.i0 i0Var) {
        d("sentry-trace_id", wVar.a());
        d("sentry-public_key", p6Var.retrieveParsedDsn().b);
        d("sentry-release", p6Var.getRelease());
        d("sentry-environment", p6Var.getEnvironment());
        if (i0Var == null || io.sentry.protocol.i0.URL.equals(i0Var)) {
            str = null;
        }
        d("sentry-transaction", str);
        if (wVar2 != null && !io.sentry.protocol.w.f.equals(wVar2)) {
            d("sentry-replay_id", wVar2.a());
        }
        d("sentry-org_id", p6Var.getEffectiveOrgId());
        Double d = x3Var == null ? null : (Double) x3Var.b;
        if (this.f) {
            this.c = d;
        }
        Boolean bool = x3Var == null ? null : (Boolean) x3Var.a;
        d("sentry-sampled", bool == null ? null : bool.toString());
        Double d2 = x3Var != null ? (Double) x3Var.c : null;
        if (this.f) {
            this.d = d2;
        }
    }

    public final h7 f() {
        String strB = b("sentry-trace_id");
        String strB2 = b("sentry-replay_id");
        String strB3 = b("sentry-public_key");
        if (strB == null || strB3 == null) {
            return null;
        }
        h7 h7Var = new h7(new io.sentry.protocol.w(strB), strB3, b("sentry-release"), b("sentry-environment"), b("sentry-user_id"), b("sentry-transaction"), c(this.c), b("sentry-sampled"), strB2 != null ? new io.sentry.protocol.w(strB2) : null, c(this.d));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            for (Map.Entry entry : this.a.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!b.a.contains(str) && str2 != null) {
                    concurrentHashMap.put(str.replaceFirst("sentry-", ""), str2);
                }
            }
            aVar.close();
            h7Var.B0 = concurrentHashMap;
            return h7Var;
        } finally {
        }
    }

    public c(ILogger iLogger) {
        this(new ConcurrentHashMap(), null, null, null, false, iLogger);
    }
}
