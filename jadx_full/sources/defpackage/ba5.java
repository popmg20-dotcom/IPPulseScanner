package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import j$.util.Objects;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ba5 extends n25 {
    public final /* synthetic */ int e;
    public final /* synthetic */ ib5 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba5(ib5 ib5Var, m95 m95Var, int i) {
        super(m95Var);
        this.e = i;
        switch (i) {
            case 2:
                Objects.requireNonNull(ib5Var);
                this.f = ib5Var;
                super(m95Var);
                break;
            default:
                Objects.requireNonNull(ib5Var);
                this.f = ib5Var;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0289 A[Catch: IllegalArgumentException -> 0x0290, MalformedURLException -> 0x0292, TryCatch #5 {IllegalArgumentException -> 0x0290, MalformedURLException -> 0x0292, blocks: (B:80:0x0241, B:82:0x0289, B:87:0x0294, B:89:0x029a, B:91:0x02a2, B:92:0x02a8, B:93:0x02ac), top: B:116:0x0241 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029a A[Catch: IllegalArgumentException -> 0x0290, MalformedURLException -> 0x0292, TryCatch #5 {IllegalArgumentException -> 0x0290, MalformedURLException -> 0x0292, blocks: (B:80:0x0241, B:82:0x0289, B:87:0x0294, B:89:0x029a, B:91:0x02a2, B:92:0x02a8, B:93:0x02ac), top: B:116:0x0241 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e1  */
    @Override // defpackage.n25
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        Pair pair;
        NetworkInfo activeNetworkInfo;
        c25 c25VarP;
        Bundle bundle;
        String string;
        k85 k85Var;
        URL url;
        int i = this.e;
        ib5 ib5Var = this.f;
        switch (i) {
            case 0:
                ib5 ib5Var2 = ((k85) ib5Var.f).D0;
                k85.g(ib5Var2);
                new Thread(new z95(ib5Var2, i)).start();
                break;
            case 1:
                ib5Var.u1();
                break;
            case 2:
                ib5Var.b1();
                break;
            default:
                k85 k85Var2 = (k85) ib5Var.f;
                l75 l75Var = k85Var2.X;
                t65 t65Var = k85Var2.Y;
                f85 f85Var = k85Var2.Z;
                k85.h(f85Var);
                f85Var.V0();
                mb5 mb5Var = k85Var2.F0;
                k85.h(mb5Var);
                k85 k85Var3 = (k85) mb5Var.f;
                k85.h(mb5Var);
                String strB1 = k85Var2.l().b1();
                Boolean boolH1 = k85Var2.A.h1("google_analytics_adid_collection_enabled");
                if (boolH1 == null || boolH1.booleanValue()) {
                    k85.f(l75Var);
                    k85 k85Var4 = (k85) l75Var.f;
                    l75Var.V0();
                    if (l75Var.c1().i(r95.AD_STORAGE)) {
                        k85Var4.B0.getClass();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        String str = l75Var.B0;
                        if (str == null || jElapsedRealtime >= l75Var.D0) {
                            l75Var.D0 = k85Var4.A.c1(strB1, r55.b) + jElapsedRealtime;
                            try {
                                h6 h6VarA = i6.a(k85Var4.b);
                                l75Var.B0 = "";
                                String str2 = h6VarA.c;
                                if (str2 != null) {
                                    l75Var.B0 = str2;
                                }
                                l75Var.C0 = h6VarA.b;
                            } catch (Exception e) {
                                t65 t65Var2 = k85Var4.Y;
                                k85.h(t65Var2);
                                t65Var2.G0.b(e, "Unable to get advertising id");
                                l75Var.B0 = "";
                            }
                            pair = new Pair(l75Var.B0, Boolean.valueOf(l75Var.C0));
                        } else {
                            pair = new Pair(str, Boolean.valueOf(l75Var.C0));
                        }
                    } else {
                        pair = new Pair("", Boolean.FALSE);
                    }
                    if (((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
                        k85.h(t65Var);
                        t65Var.H0.a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
                    } else {
                        k85.h(mb5Var);
                        mb5Var.X0();
                        ConnectivityManager connectivityManager = (ConnectivityManager) k85Var3.b.getSystemService("connectivity");
                        if (connectivityManager != null) {
                            try {
                                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                            } catch (SecurityException unused) {
                                activeNetworkInfo = null;
                            }
                            if (activeNetworkInfo == null && activeNetworkInfo.isConnected()) {
                                StringBuilder sb = new StringBuilder();
                                dd5 dd5VarJ = k85Var2.j();
                                dd5VarJ.V0();
                                dd5VarJ.W0();
                                if (!dd5VarJ.c1()) {
                                    ib5 ib5Var3 = k85Var2.D0;
                                    k85.g(ib5Var3);
                                    k85 k85Var5 = (k85) ib5Var3.f;
                                    ib5Var3.V0();
                                    dd5 dd5VarJ2 = k85Var5.j();
                                    k85 k85Var6 = (k85) dd5VarJ2.f;
                                    dd5VarJ2.V0();
                                    dd5VarJ2.W0();
                                    v55 v55Var = dd5VarJ2.Z;
                                    if (v55Var == null) {
                                        dd5VarJ2.b1();
                                        t65 t65Var3 = k85Var6.Y;
                                        k85.h(t65Var3);
                                        t65Var3.G0.a("Failed to get consents; not connected to service yet.");
                                    } else {
                                        try {
                                            c25VarP = v55Var.p(dd5VarJ2.l1(false));
                                            dd5VarJ2.i1();
                                        } catch (RemoteException e2) {
                                            t65 t65Var4 = k85Var6.Y;
                                            k85.h(t65Var4);
                                            t65Var4.z0.b(e2, "Failed to get consents; remote exception");
                                            c25VarP = null;
                                        }
                                        bundle = c25VarP == null ? c25VarP.b : null;
                                        if (bundle != null) {
                                            int i2 = k85Var2.S0;
                                            k85Var2.S0 = i2 + 1;
                                            i = i2 < 10 ? 1 : 0;
                                            k85.h(t65Var);
                                            String str3 = i2 < 10 ? "Retrying." : "Skipping.";
                                            t65Var.G0.b(Integer.valueOf(k85Var2.S0), fw.z(new StringBuilder(str3.length() + 60), "Failed to retrieve DMA consent from the service, ", str3, " retryCount"));
                                        } else {
                                            t95 t95VarB = t95.b(100, bundle);
                                            sb.append("&gcs=");
                                            sb.append(t95VarB.f());
                                            o25 o25VarC = o25.c(100, bundle);
                                            String str4 = o25VarC.d;
                                            sb.append("&dma=");
                                            Boolean bool = o25VarC.c;
                                            Boolean bool2 = Boolean.FALSE;
                                            sb.append(!Objects.equals(bool, bool2) ? 1 : 0);
                                            if (!TextUtils.isEmpty(str4)) {
                                                sb.append("&dma_cps=");
                                                sb.append(str4);
                                            }
                                            int iOrdinal = t95.d(bundle.getString("ad_personalization")).ordinal();
                                            if (iOrdinal != 2) {
                                                bool2 = iOrdinal != 3 ? null : Boolean.TRUE;
                                            }
                                            int i3 = !Objects.equals(bool2, Boolean.TRUE) ? 1 : 0;
                                            sb.append("&npa=");
                                            sb.append(i3);
                                            k85.h(t65Var);
                                            t65Var.H0.b(sb, "Consent query parameters to Bow");
                                            qf5 qf5Var = k85Var2.z0;
                                            k85.f(qf5Var);
                                            ((k85) k85Var2.l().f).A.a1();
                                            String str5 = (String) pair.first;
                                            long jA = l75Var.O0.a() - 1;
                                            string = sb.toString();
                                            k85Var = (k85) qf5Var.f;
                                            try {
                                                tj4.f(str5);
                                                tj4.f(strB1);
                                                String strConcat = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=" + ("v133005." + qf5Var.D1()) + "&rdid=" + str5 + "&bundleid=" + strB1 + "&retry=" + jA;
                                                if (strB1.equals(k85Var.A.Z0("debug.deferred.deeplink"))) {
                                                    strConcat = strConcat.concat("&ddl_test=1");
                                                }
                                                if (!string.isEmpty()) {
                                                    if (string.charAt(0) != '&') {
                                                        strConcat = strConcat.concat("&");
                                                    }
                                                    strConcat = strConcat.concat(string);
                                                }
                                                url = new URL(strConcat);
                                            } catch (IllegalArgumentException e3) {
                                                e = e3;
                                                t65 t65Var5 = k85Var.Y;
                                                k85.h(t65Var5);
                                                t65Var5.z0.b(e.getMessage(), "Failed to create BOW URL for Deferred Deep Link. exception");
                                                url = null;
                                            } catch (MalformedURLException e4) {
                                                e = e4;
                                                t65 t65Var52 = k85Var.Y;
                                                k85.h(t65Var52);
                                                t65Var52.z0.b(e.getMessage(), "Failed to create BOW URL for Deferred Deep Link. exception");
                                                url = null;
                                            }
                                            if (url != null) {
                                                k85.h(mb5Var);
                                                i85 i85Var = new i85(k85Var2);
                                                mb5Var.X0();
                                                f85 f85Var2 = k85Var3.Z;
                                                k85.h(f85Var2);
                                                f85Var2.h1(new x65(mb5Var, strB1, url, (byte[]) null, (HashMap) null, i85Var));
                                            }
                                        }
                                    }
                                    c25VarP = null;
                                    if (c25VarP == null) {
                                    }
                                    if (bundle != null) {
                                    }
                                    break;
                                } else {
                                    qf5 qf5Var2 = ((k85) dd5VarJ.f).z0;
                                    k85.f(qf5Var2);
                                    if (qf5Var2.D1() < 234200) {
                                        qf5 qf5Var3 = k85Var2.z0;
                                        k85.f(qf5Var3);
                                        ((k85) k85Var2.l().f).A.a1();
                                        String str52 = (String) pair.first;
                                        long jA2 = l75Var.O0.a() - 1;
                                        string = sb.toString();
                                        k85Var = (k85) qf5Var3.f;
                                        tj4.f(str52);
                                        tj4.f(strB1);
                                        String strConcat2 = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=" + ("v133005." + qf5Var3.D1()) + "&rdid=" + str52 + "&bundleid=" + strB1 + "&retry=" + jA2;
                                        if (strB1.equals(k85Var.A.Z0("debug.deferred.deeplink"))) {
                                        }
                                        if (!string.isEmpty()) {
                                        }
                                        url = new URL(strConcat2);
                                        if (url != null) {
                                        }
                                    }
                                }
                            } else {
                                k85.h(t65Var);
                                t65Var.C0.a("Network is not available for Deferred Deep Link request. Skipping");
                            }
                            break;
                        } else {
                            activeNetworkInfo = null;
                            if (activeNetworkInfo == null) {
                                k85.h(t65Var);
                                t65Var.C0.a("Network is not available for Deferred Deep Link request. Skipping");
                            }
                        }
                    }
                } else {
                    k85.h(t65Var);
                    t65Var.H0.a("ADID collection is disabled from Manifest. Skipping");
                }
                if (i != 0) {
                    ib5Var.N0.b(2000L);
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ba5(ib5 ib5Var, m95 m95Var, int i, boolean z) {
        super(m95Var);
        this.e = i;
        this.f = ib5Var;
    }
}
