package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nr2 {
    public static final String a = ue2.i("NetworkStateTracker");

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final lr2 a(ConnectivityManager connectivityManager, boolean z) {
        boolean z2;
        SecurityException securityException;
        boolean z3;
        NetworkCapabilities networkCapabilities;
        String str = a;
        connectivityManager.getClass();
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z4 = true;
            if (activeNetworkInfo != null) {
                try {
                    if (activeNetworkInfo.isConnected()) {
                        z3 = true;
                    } else {
                        z3 = true;
                        z4 = false;
                    }
                    try {
                        networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    } catch (SecurityException e) {
                        ue2.g().f(str, "Unable to validate active network", e);
                    }
                    boolean zHasCapability = networkCapabilities != null ? networkCapabilities.hasCapability(16) : false;
                    boolean zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
                    if (activeNetworkInfo != null) {
                        boolean z5 = !activeNetworkInfo.isRoaming() ? z3 : false;
                        z2 = z;
                        try {
                            return new lr2(z4, zHasCapability, zIsActiveNetworkMetered, z5, z2);
                        } catch (SecurityException e2) {
                            e = e2;
                            securityException = e;
                            ue2.g().f(str, "Unable to get active network state", securityException);
                            return new lr2(false, false, false, true, z2);
                        }
                    }
                } catch (SecurityException e3) {
                    securityException = e3;
                    z2 = z;
                }
            }
        } catch (SecurityException e4) {
            e = e4;
            z2 = z;
        }
        ue2.g().f(str, "Unable to get active network state", securityException);
        return new lr2(false, false, false, true, z2);
    }

    public static final lr2 b(NetworkCapabilities networkCapabilities, boolean z) {
        return new lr2(networkCapabilities.hasCapability(12), networkCapabilities.hasCapability(16), !networkCapabilities.hasCapability(11), networkCapabilities.hasCapability(18), z);
    }
}
