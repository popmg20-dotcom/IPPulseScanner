package io.sentry.android.core.internal.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.a84;
import io.sentry.ILogger;
import io.sentry.android.core.g0;
import io.sentry.android.core.j0;
import io.sentry.android.core.p0;
import io.sentry.android.core.q0;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.r0;
import io.sentry.s0;
import io.sentry.t0;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t0, g0 {
    public static volatile ConnectivityManager D0;
    public final c A;
    public volatile long A0;
    public final AtomicBoolean B0;
    public final ArrayList X;
    public final io.sentry.util.a Y;
    public volatile a84 Z;
    public final Context b;
    public final p6 f;
    public volatile NetworkCapabilities y0;
    public final q0 z;
    public volatile Network z0;
    public static final io.sentry.util.a C0 = new io.sentry.util.a();
    public static final io.sentry.util.a E0 = new io.sentry.util.a();
    public static final ArrayList F0 = new ArrayList();
    public static final int[] G0 = {1, 0, 3, 2};
    public static final int[] H0 = new int[2];

    public b(SurfboardApp surfboardApp, p6 p6Var, q0 q0Var) {
        c cVar = c.b;
        this.Y = new io.sentry.util.a();
        this.A0 = 0L;
        this.B0 = new AtomicBoolean(false);
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
        this.f = p6Var;
        this.z = q0Var;
        this.A = cVar;
        this.X = new ArrayList();
        int[] iArr = H0;
        iArr[0] = 12;
        iArr[1] = 16;
        Q(new a(this, 1));
        j0.X.g(this);
    }

    public static String F(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(0)) {
            return "cellular";
        }
        return null;
    }

    public static ConnectivityManager M(Context context, ILogger iLogger) {
        if (D0 != null) {
            return D0;
        }
        io.sentry.util.a aVar = C0;
        aVar.g();
        try {
            if (D0 != null) {
                ConnectivityManager connectivityManager = D0;
                aVar.close();
                return connectivityManager;
            }
            D0 = (ConnectivityManager) context.getSystemService("connectivity");
            if (D0 == null) {
                iLogger.h(p5.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
            }
            ConnectivityManager connectivityManager2 = D0;
            aVar.close();
            return connectivityManager2;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean N(Context context, ILogger iLogger, q0 q0Var, a84 a84Var) {
        q0Var.getClass();
        if (Build.VERSION.SDK_INT < 24) {
            iLogger.h(p5.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        ConnectivityManager connectivityManagerM = M(context, iLogger);
        if (connectivityManagerM == null) {
            return false;
        }
        if (!io.sentry.config.a.m(context)) {
            iLogger.h(p5.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        try {
            connectivityManagerM.registerDefaultNetworkCallback(a84Var);
            return true;
        } catch (Throwable th) {
            iLogger.d(p5.WARNING, "registerDefaultNetworkCallback failed", th);
            return false;
        }
    }

    public static boolean s(Context context, ILogger iLogger, q0 q0Var, ConnectivityManager.NetworkCallback networkCallback) {
        if (Build.VERSION.SDK_INT < 24) {
            iLogger.h(p5.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        if (!io.sentry.config.a.m(context)) {
            iLogger.h(p5.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        io.sentry.util.a aVar = E0;
        aVar.g();
        try {
            F0.add(networkCallback);
            aVar.close();
            return true;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final r0 C() {
        if (this.y0 != null) {
            NetworkCapabilities networkCapabilities = this.y0;
            if (networkCapabilities != null) {
                boolean zHasCapability = networkCapabilities.hasCapability(12);
                this.z.getClass();
                if (zHasCapability && networkCapabilities.hasCapability(16)) {
                    for (int i : G0) {
                        if (networkCapabilities.hasTransport(i)) {
                            return r0.CONNECTED;
                        }
                    }
                }
            }
            return r0.DISCONNECTED;
        }
        ConnectivityManager connectivityManagerM = M(this.b, this.f.getLogger());
        if (connectivityManagerM == null) {
            return r0.UNKNOWN;
        }
        Context context = this.b;
        ILogger logger = this.f.getLogger();
        if (!io.sentry.config.a.m(context)) {
            logger.h(p5.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return r0.NO_PERMISSION;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManagerM.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected() ? r0.CONNECTED : r0.DISCONNECTED;
            }
            logger.h(p5.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
            return r0.DISCONNECTED;
        } catch (Throwable th) {
            logger.d(p5.WARNING, "Could not retrieve Connection Status", th);
            return r0.UNKNOWN;
        }
    }

    public final String I() {
        NetworkCapabilities networkCapabilities = this.y0;
        if (networkCapabilities != null) {
            return F(networkCapabilities);
        }
        Context context = this.b;
        ILogger logger = this.f.getLogger();
        q0 q0Var = this.z;
        ConnectivityManager connectivityManagerM = M(context, logger);
        if (connectivityManagerM != null) {
            if (!io.sentry.config.a.m(context)) {
                logger.h(p5.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
                return null;
            }
            try {
                q0Var.getClass();
                Network activeNetwork = connectivityManagerM.getActiveNetwork();
                if (activeNetwork == null) {
                    logger.h(p5.INFO, "Network is null and cannot check network status", new Object[0]);
                    return null;
                }
                NetworkCapabilities networkCapabilities2 = connectivityManagerM.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities2 == null) {
                    logger.h(p5.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                    return null;
                }
                boolean zHasTransport = networkCapabilities2.hasTransport(3);
                boolean zHasTransport2 = networkCapabilities2.hasTransport(1);
                boolean zHasTransport3 = networkCapabilities2.hasTransport(0);
                if (zHasTransport) {
                    return "ethernet";
                }
                if (zHasTransport2) {
                    return "wifi";
                }
                if (zHasTransport3) {
                    return "cellular";
                }
            } catch (Throwable th) {
                logger.d(p5.ERROR, "Failed to retrieve network info", th);
                return null;
            }
        }
        return null;
    }

    public final void Q(Runnable runnable) {
        p6 p6Var = this.f;
        try {
            p6Var.getExecutorService().submit(runnable);
        } catch (Throwable th) {
            p6Var.getLogger().d(p5.ERROR, "AndroidConnectionStatusProvider submit failed", th);
        }
    }

    public final void U(boolean z) {
        io.sentry.util.a aVar = this.Y;
        aVar.g();
        if (z) {
            try {
                this.X.clear();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        a84 a84Var = this.Z;
        this.Z = null;
        if (a84Var != null) {
            Context context = this.b;
            ILogger logger = this.f.getLogger();
            ConnectivityManager connectivityManagerM = M(context, logger);
            if (connectivityManagerM != null) {
                try {
                    connectivityManagerM.unregisterNetworkCallback(a84Var);
                } catch (Throwable th3) {
                    logger.d(p5.WARNING, "unregisterNetworkCallback failed", th3);
                }
            }
        }
        this.y0 = null;
        this.z0 = null;
        this.A0 = 0L;
        aVar.close();
        this.f.getLogger().h(p5.DEBUG, "Network callback unregistered", new Object[0]);
    }

    public final void X(NetworkCapabilities networkCapabilities) {
        io.sentry.util.a aVar = this.Y;
        aVar.g();
        try {
            if (networkCapabilities != null) {
                this.y0 = networkCapabilities;
            } else {
                if (!io.sentry.config.a.m(this.b)) {
                    this.f.getLogger().h(p5.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
                    this.y0 = null;
                    this.A.getClass();
                    this.A0 = SystemClock.uptimeMillis();
                    aVar.close();
                    return;
                }
                this.z.getClass();
                ConnectivityManager connectivityManagerM = M(this.b, this.f.getLogger());
                if (connectivityManagerM != null) {
                    Network activeNetwork = connectivityManagerM.getActiveNetwork();
                    this.y0 = activeNetwork != null ? connectivityManagerM.getNetworkCapabilities(activeNetwork) : null;
                } else {
                    this.y0 = null;
                }
            }
            this.A.getClass();
            this.A0 = SystemClock.uptimeMillis();
            this.f.getLogger().h(p5.DEBUG, "Cache updated - Status: " + C() + ", Type: " + I(), new Object[0]);
        } catch (Throwable th) {
            try {
                this.f.getLogger().d(p5.WARNING, "Failed to update connection status cache", th);
                this.y0 = null;
                this.A.getClass();
                this.A0 = SystemClock.uptimeMillis();
            } catch (Throwable th2) {
                try {
                    aVar.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        aVar.close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Q(new a(this, 0));
    }

    @Override // io.sentry.t0
    public final r0 d0() {
        this.A.getClass();
        if (SystemClock.uptimeMillis() - this.A0 >= 120000) {
            X(null);
        }
        return C();
    }

    @Override // io.sentry.android.core.g0
    public final void g() {
        if (this.Z != null) {
            return;
        }
        Q(new a(this, 3));
    }

    @Override // io.sentry.t0
    public final boolean h0(s0 s0Var) {
        io.sentry.util.a aVar = this.Y;
        aVar.g();
        try {
            this.X.add(s0Var);
            aVar.close();
            x();
            return this.Z != null;
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
    public final void n() {
        if (this.Z == null) {
            return;
        }
        Q(new a(this, 2));
    }

    @Override // io.sentry.t0
    public final void s0(s0 s0Var) {
        io.sentry.util.a aVar = this.Y;
        aVar.g();
        try {
            this.X.remove(s0Var);
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

    @Override // io.sentry.t0
    public final String v() {
        this.A.getClass();
        if (SystemClock.uptimeMillis() - this.A0 >= 120000) {
            X(null);
        }
        return I();
    }

    public final void x() {
        if (p0.f() && this.Z == null) {
            io.sentry.util.a aVar = this.Y;
            aVar.g();
            try {
                if (this.Z != null) {
                    aVar.close();
                    return;
                }
                a84 a84Var = new a84(1, this);
                if (N(this.b, this.f.getLogger(), this.z, a84Var)) {
                    this.Z = a84Var;
                    this.f.getLogger().h(p5.DEBUG, "Network callback registered successfully", new Object[0]);
                } else {
                    this.f.getLogger().h(p5.WARNING, "Failed to register network callback", new Object[0]);
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
    }
}
