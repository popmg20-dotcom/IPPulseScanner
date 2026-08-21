package io.sentry.android.core;

import android.net.TrafficStats;
import android.util.Log;
import defpackage.x8;
import io.sentry.ILogger;
import io.sentry.p5;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w implements io.sentry.m1, x0, ILogger, io.sentry.logger.c, io.sentry.metrics.b {
    public static final w f = new w(0);
    public static final w z = new w(1);
    public final /* synthetic */ int b;

    public /* synthetic */ w(int i) {
        this.b = i;
    }

    @Override // io.sentry.m1
    public void a() {
        TrafficStats.clearThreadStatsTag();
    }

    @Override // io.sentry.ILogger
    public void b(p5 p5Var, Throwable th, String str, Object... objArr) {
        switch (this.b) {
            case 2:
                if (objArr.length != 0) {
                    d(p5Var, String.format(str, objArr), th);
                } else {
                    d(p5Var, str, th);
                }
                break;
            default:
                if (objArr.length != 0) {
                    d(p5Var, String.format(str, objArr), th);
                } else {
                    d(p5Var, str, th);
                }
                break;
        }
    }

    @Override // io.sentry.logger.c
    public io.sentry.logger.b c(SentryAndroidOptions sentryAndroidOptions, x8 x8Var) {
        n nVar = new n(sentryAndroidOptions, x8Var);
        j0.X.g(nVar);
        return nVar;
    }

    @Override // io.sentry.ILogger
    public void d(p5 p5Var, String str, Throwable th) {
        switch (this.b) {
            case 2:
                Log.wtf("Sentry", str, th);
                break;
            default:
                int i = l.a[p5Var.ordinal()];
                if (i == 1) {
                    Log.i("Sentry", str, th);
                } else if (i == 2) {
                    Log.w("Sentry", str, th);
                } else if (i == 3) {
                    Log.e("Sentry", str, th);
                } else if (i == 4) {
                    Log.wtf("Sentry", str, th);
                } else {
                    Log.d("Sentry", str, th);
                }
                break;
        }
    }

    @Override // io.sentry.m1
    public void e() {
        TrafficStats.setThreadStatsTag(61441);
    }

    @Override // io.sentry.ILogger
    public void h(p5 p5Var, String str, Object... objArr) {
        int i = 7;
        switch (this.b) {
            case 2:
                if (objArr.length != 0) {
                    Log.println(7, "Sentry", String.format(str, objArr));
                } else {
                    Log.println(7, "Sentry", str);
                }
                break;
            default:
                if (objArr.length != 0) {
                    int i2 = l.a[p5Var.ordinal()];
                    if (i2 == 1) {
                        i = 4;
                    } else if (i2 == 2) {
                        i = 5;
                    } else if (i2 != 4) {
                        i = 3;
                    }
                    Log.println(i, "Sentry", String.format(str, objArr));
                } else {
                    int i3 = l.a[p5Var.ordinal()];
                    if (i3 == 1) {
                        i = 4;
                    } else if (i3 == 2) {
                        i = 5;
                    } else if (i3 != 4) {
                        i = 3;
                    }
                    Log.println(i, "Sentry", str);
                }
                break;
        }
    }

    @Override // io.sentry.ILogger
    public boolean i(p5 p5Var) {
        switch (this.b) {
        }
        return true;
    }

    @Override // io.sentry.metrics.b
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public io.sentry.metrics.a mo2c(SentryAndroidOptions sentryAndroidOptions, x8 x8Var) {
        p pVar = new p(sentryAndroidOptions, x8Var);
        j0.X.g(pVar);
        return pVar;
    }
}
