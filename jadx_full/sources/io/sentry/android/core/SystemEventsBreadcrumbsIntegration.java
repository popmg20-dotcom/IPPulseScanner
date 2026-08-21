package io.sentry.android.core;

import android.content.Context;
import android.content.IntentFilter;
import android.os.HandlerThread;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.l4;
import io.sentry.p5;
import java.io.Closeable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SystemEventsBreadcrumbsIntegration implements io.sentry.v1, Closeable, g0 {
    public io.sentry.f1 A;
    public d2 C0;
    public final String[] X;
    public final Context b;
    public volatile e2 f;
    public SentryAndroidOptions z;
    public volatile boolean Y = false;
    public volatile boolean Z = false;
    public volatile IntentFilter y0 = null;
    public volatile HandlerThread z0 = null;
    public final AtomicBoolean A0 = new AtomicBoolean(false);
    public final io.sentry.util.a B0 = new io.sentry.util.a();

    public SystemEventsBreadcrumbsIntegration(SurfboardApp surfboardApp) {
        String[] strArr = {"android.intent.action.ACTION_SHUTDOWN", "android.intent.action.AIRPLANE_MODE", "android.intent.action.BATTERY_CHANGED", "android.intent.action.CAMERA_BUTTON", "android.intent.action.CONFIGURATION_CHANGED", "android.intent.action.DATE_CHANGED", "android.intent.action.DEVICE_STORAGE_LOW", "android.intent.action.DEVICE_STORAGE_OK", "android.intent.action.DOCK_EVENT", "android.intent.action.DREAMING_STARTED", "android.intent.action.DREAMING_STOPPED", "android.intent.action.INPUT_METHOD_CHANGED", "android.intent.action.LOCALE_CHANGED", "android.intent.action.SCREEN_OFF", "android.intent.action.SCREEN_ON", "android.intent.action.TIMEZONE_CHANGED", "android.intent.action.TIME_SET", "android.os.action.DEVICE_IDLE_MODE_CHANGED", "android.os.action.POWER_SAVE_MODE_CHANGED"};
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext == null ? surfboardApp : applicationContext;
        this.X = strArr;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.z = sentryAndroidOptions;
        this.A = l4.a;
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "SystemEventsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.z.isEnableSystemEventBreadcrumbs()));
        if (this.z.isEnableSystemEventBreadcrumbs()) {
            j0.X.g(this);
            if (p0.f()) {
                s(this.A, this.z);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.sentry.util.a aVar = this.B0;
        aVar.g();
        try {
            this.Y = true;
            this.y0 = null;
            if (this.z0 != null) {
                this.z0.quit();
            }
            this.z0 = null;
            aVar.close();
            j0.X.x(this);
            SentryAndroidOptions sentryAndroidOptions = this.z;
            if (sentryAndroidOptions != null) {
                try {
                    sentryAndroidOptions.getExecutorService().submit(new g(7, this));
                } catch (RejectedExecutionException unused) {
                    x(this.z);
                }
            }
            SentryAndroidOptions sentryAndroidOptions2 = this.z;
            if (sentryAndroidOptions2 != null) {
                sentryAndroidOptions2.getLogger().h(p5.DEBUG, "SystemEventsBreadcrumbsIntegration removed.", new Object[0]);
            }
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.android.core.g0
    public final void g() {
        if (this.A == null || this.z == null) {
            return;
        }
        this.Z = false;
        s(this.A, this.z);
    }

    @Override // io.sentry.android.core.g0
    public final void n() {
        SentryAndroidOptions sentryAndroidOptions = this.z;
        if (sentryAndroidOptions == null) {
            return;
        }
        try {
            sentryAndroidOptions.getExecutorService().submit(new g(7, this));
        } catch (RejectedExecutionException unused) {
            x(this.z);
        }
    }

    public final void s(io.sentry.f1 f1Var, SentryAndroidOptions sentryAndroidOptions) {
        if (sentryAndroidOptions.isEnableSystemEventBreadcrumbs() && !this.Y && !this.Z && this.f == null) {
            try {
                sentryAndroidOptions.getExecutorService().submit(new p1(this, f1Var, sentryAndroidOptions));
            } catch (Throwable unused) {
                sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to start SystemEventsBreadcrumbsIntegration on executor thread.", new Object[0]);
            }
        }
    }

    public final void x(SentryAndroidOptions sentryAndroidOptions) {
        io.sentry.util.a aVar = this.B0;
        aVar.g();
        try {
            this.Z = true;
            e2 e2Var = this.f;
            this.f = null;
            aVar.close();
            if (e2Var != null) {
                try {
                    this.b.unregisterReceiver(e2Var);
                } catch (Throwable th) {
                    sentryAndroidOptions.getLogger().b(p5.ERROR, th, "Failed to unregister SystemEventsBroadcastReceiver", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                aVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
