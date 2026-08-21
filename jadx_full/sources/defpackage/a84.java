package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.internal.util.b;
import io.sentry.p5;
import io.sentry.r0;
import io.sentry.s0;
import io.sentry.util.a;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a84 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a84(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public void a() {
        ((b) this.b).B0.set(false);
        a aVar = ((b) this.b).Y;
        aVar.g();
        try {
            ((b) this.b).y0 = null;
            ((b) this.b).z0 = null;
            b bVar = (b) this.b;
            bVar.A.getClass();
            bVar.A0 = SystemClock.uptimeMillis();
            ((b) this.b).f.getLogger().h(p5.DEBUG, "Cache cleared - network lost/unavailable", new Object[0]);
            Iterator it = ((b) this.b).X.iterator();
            while (it.hasNext()) {
                ((s0) it.next()).s(r0.DISCONNECTED);
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

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.a) {
            case 0:
                network.getClass();
                String str = "startFetchSwitchMedia: onAvailable() called with: network = " + network;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "SwitchMediaImportDialogFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("SwitchMediaImportDialogFragment", str, null);
                }
                ji0.B(uf2.t((b84) this.b), null, null, new z74((b84) this.b, network, null), 3);
                super.onAvailable(network);
                return;
            default:
                ((b) this.b).z0 = network;
                if (((b) this.b).B0.getAndSet(true)) {
                    return;
                }
                a aVar = b.E0;
                aVar.g();
                try {
                    Iterator it = b.F0.iterator();
                    while (it.hasNext()) {
                        ((ConnectivityManager.NetworkCallback) it.next()).onAvailable(network);
                        break;
                    }
                    aVar.close();
                    return;
                } finally {
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0082 A[Catch: all -> 0x008c, LOOP:3: B:35:0x007c->B:37:0x0082, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x008c, blocks: (B:34:0x0072, B:35:0x007c, B:37:0x0082), top: B:69:0x0072 }] */
    @Override // android.net.ConnectivityManager.NetworkCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        a aVar;
        Iterator it;
        switch (this.a) {
            case 1:
                if (network.equals(((b) this.b).z0)) {
                    NetworkCapabilities networkCapabilities2 = ((b) this.b).y0;
                    if ((networkCapabilities2 == null) != (networkCapabilities == null)) {
                        ((b) this.b).X(networkCapabilities);
                        r0 r0VarC = ((b) this.b).C();
                        aVar = ((b) this.b).Y;
                        aVar.g();
                        it = ((b) this.b).X.iterator();
                        while (it.hasNext()) {
                            break;
                        }
                        aVar.close();
                    } else if (networkCapabilities2 != null || networkCapabilities != null) {
                        int[] iArr = b.H0;
                        int length = iArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                for (int i2 : b.G0) {
                                    if (networkCapabilities2.hasTransport(i2) == networkCapabilities.hasTransport(i2)) {
                                    }
                                }
                            } else {
                                int i3 = iArr[i];
                                if (i3 == 0 || networkCapabilities2.hasCapability(i3) == networkCapabilities.hasCapability(i3)) {
                                    i++;
                                }
                            }
                        }
                        ((b) this.b).X(networkCapabilities);
                        r0 r0VarC2 = ((b) this.b).C();
                        aVar = ((b) this.b).Y;
                        aVar.g();
                        try {
                            it = ((b) this.b).X.iterator();
                            while (it.hasNext()) {
                                ((s0) it.next()).s(r0VarC2);
                                break;
                            }
                            aVar.close();
                        } catch (Throwable th) {
                            try {
                                aVar.close();
                                break;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    a aVar2 = b.E0;
                    aVar2.g();
                    try {
                        Iterator it2 = b.F0.iterator();
                        while (it2.hasNext()) {
                            ((ConnectivityManager.NetworkCallback) it2.next()).onCapabilitiesChanged(network, networkCapabilities);
                            break;
                        }
                        aVar2.close();
                        return;
                    } catch (Throwable th3) {
                        try {
                            aVar2.close();
                            break;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
                return;
            default:
                super.onCapabilitiesChanged(network, networkCapabilities);
                return;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        switch (this.a) {
            case 1:
                if (network.equals(((b) this.b).z0)) {
                    a();
                    a aVar = b.E0;
                    aVar.g();
                    try {
                        Iterator it = b.F0.iterator();
                        while (it.hasNext()) {
                            ((ConnectivityManager.NetworkCallback) it.next()).onLost(network);
                            break;
                        }
                        aVar.close();
                        return;
                    } catch (Throwable th) {
                        try {
                            aVar.close();
                            break;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                return;
            default:
                super.onLost(network);
                return;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        switch (this.a) {
            case 0:
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "SwitchMediaImportDialogFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "startFetchSwitchMedia: onUnavailable() called");
                }
                ge0 ge0Var = null;
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("SwitchMediaImportDialogFragment", "startFetchSwitchMedia: onUnavailable() called", null);
                }
                super.onUnavailable();
                ji0.B(uf2.t((b84) this.b), null, null, new mt((b84) this.b, ge0Var, 19), 3);
                return;
            default:
                a();
                a aVar = b.E0;
                aVar.g();
                try {
                    Iterator it = b.F0.iterator();
                    while (it.hasNext()) {
                        ((ConnectivityManager.NetworkCallback) it.next()).onUnavailable();
                        break;
                    }
                    aVar.close();
                    return;
                } finally {
                }
        }
    }
}
