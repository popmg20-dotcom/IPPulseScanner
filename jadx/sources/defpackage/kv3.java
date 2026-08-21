package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kv3 extends ConnectivityManager.NetworkCallback {
    public static final kv3 a = new kv3();
    public static final Object b = new Object();
    public static final LinkedHashMap c = new LinkedHashMap();
    public static NetworkCapabilities d;
    public static boolean e;
    public static boolean f;

    public static qi a(ConnectivityManager connectivityManager, NetworkRequest networkRequest, gj gjVar) {
        NetworkCapabilities networkCapabilities;
        synchronized (b) {
            try {
                LinkedHashMap linkedHashMap = c;
                boolean zIsEmpty = linkedHashMap.isEmpty();
                linkedHashMap.put(gjVar, networkRequest);
                if (zIsEmpty) {
                    ue2.g().a(mw4.a, "NetworkRequestConstraintController register shared callback");
                    connectivityManager.registerDefaultNetworkCallback(a);
                }
                ue2.g().a(mw4.a, "NetworkRequestConstraintController send initial capabilities");
                a.getClass();
                boolean z = true;
                if (e) {
                    networkCapabilities = d;
                } else {
                    networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    d = networkCapabilities;
                    e = true;
                }
                if (f || !networkRequest.canBeSatisfiedBy(networkCapabilities)) {
                    z = false;
                }
                gjVar.g(z ? oc0.a : new pc0(7));
            } catch (Throwable th) {
                throw th;
            }
        }
        return new qi(9, gjVar, connectivityManager);
    }

    public static void b() {
        ArrayList<e03> arrayList = new ArrayList();
        synchronized (b) {
            try {
                for (Map.Entry entry : c.entrySet()) {
                    am1 am1Var = (am1) entry.getKey();
                    NetworkRequest networkRequest = (NetworkRequest) entry.getValue();
                    kv3 kv3Var = a;
                    NetworkCapabilities networkCapabilities = d;
                    kv3Var.getClass();
                    arrayList.add(new e03(am1Var, !f && networkRequest.canBeSatisfiedBy(networkCapabilities) ? oc0.a : new pc0(7)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (e03 e03Var : arrayList) {
            ((am1) e03Var.b).g((qc0) e03Var.f);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onBlockedStatusChanged(Network network, boolean z) {
        network.getClass();
        ue2.g().a(mw4.a, "NetworkRequestConstraintController onBlockedStatusChanged callback");
        synchronized (b) {
            if (f == z) {
                return;
            }
            f = z;
            b();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        network.getClass();
        networkCapabilities.getClass();
        ue2.g().a(mw4.a, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        synchronized (b) {
            d = networkCapabilities;
        }
        b();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        network.getClass();
        ue2.g().a(mw4.a, "NetworkRequestConstraintController onLost callback");
        synchronized (b) {
            d = null;
            Iterator it = c.keySet().iterator();
            while (it.hasNext()) {
                ((am1) it.next()).g(new pc0(7));
            }
        }
    }
}
