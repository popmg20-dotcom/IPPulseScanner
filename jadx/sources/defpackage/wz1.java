package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wz1 extends ConnectivityManager.NetworkCallback {
    public static final /* synthetic */ int c = 0;
    public final /* synthetic */ int a;
    public final Object b;

    public wz1(gj gjVar) {
        this.a = 0;
        this.b = gjVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        switch (this.a) {
            case 2:
                ((n02) this.b).z(network, true);
                break;
            default:
                super.onAvailable(network);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onBlockedStatusChanged(Network network, boolean z) {
        switch (this.a) {
            case 1:
                network.getClass();
                if (network.equals(((mr2) this.b).f.getActiveNetwork())) {
                    ue2.g().a(nr2.a, "Network blocked status changed: " + z);
                    mr2 mr2Var = (mr2) this.b;
                    Object objA = mr2Var.e;
                    if (objA == null) {
                        objA = mr2Var.a();
                    }
                    lr2 lr2Var = (lr2) objA;
                    mr2 mr2Var2 = (mr2) this.b;
                    synchronized (mr2Var2.g) {
                        if (mr2Var2.h == z) {
                            return;
                        }
                        mr2Var2.h = z;
                        ((mr2) this.b).b(new lr2(lr2Var.a, lr2Var.b, lr2Var.c, lr2Var.d, z));
                        return;
                    }
                }
                return;
            default:
                super.onBlockedStatusChanged(network, z);
                return;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) throws Exception {
        switch (this.a) {
            case 0:
                network.getClass();
                networkCapabilities.getClass();
                ue2.g().a(mw4.a, "NetworkRequestConstraintController onCapabilitiesChanged callback");
                ((gj) this.b).g(oc0.a);
                break;
            case 1:
                network.getClass();
                networkCapabilities.getClass();
                ue2.g().a(nr2.a, "Network capabilities changed: " + networkCapabilities);
                mr2 mr2Var = (mr2) this.b;
                mr2Var.b(Build.VERSION.SDK_INT >= 28 ? nr2.b(networkCapabilities, mr2Var.h) : nr2.a(mr2Var.f, mr2Var.h));
                break;
            default:
                super.onCapabilitiesChanged(network, networkCapabilities);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) throws Exception {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                network.getClass();
                ue2.g().a(mw4.a, "NetworkRequestConstraintController onLost callback");
                ((gj) obj).g(new pc0(7));
                break;
            case 1:
                network.getClass();
                ue2.g().a(nr2.a, "Network connection lost");
                ((mr2) obj).b(new lr2(false, false, false, false, false));
                break;
            default:
                ((n02) obj).z(network, false);
                break;
        }
    }

    public /* synthetic */ wz1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
