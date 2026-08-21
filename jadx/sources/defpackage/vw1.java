package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vw1 extends BroadcastReceiver {
    public final /* synthetic */ int a;

    public /* synthetic */ vw1(int i) {
        this.a = i;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        int i = this.a;
        context.getClass();
        switch (i) {
            case 0:
                String strConcat = "device idle mode changed: ".concat(ContextUtilsKt.j());
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("IVpnService", strConcat, null);
                    break;
                }
                break;
            default:
                on2 on2Var = cr2.a;
                String str3 = "onReceive() called with: intent = " + intent;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "NetworkDetector", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("NetworkDetector", str3, null);
                }
                if (intent != null) {
                    ConnectivityManager connectivityManagerB = ContextUtilsKt.b();
                    try {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        NetworkInfo networkInfo2 = networkInfo != null ? connectivityManagerB.getNetworkInfo(networkInfo.getType()) : null;
                        String str4 = "info: " + networkInfo2;
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "NetworkDetector", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str4);
                            str = str4;
                        } else {
                            str = str4;
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("NetworkDetector", str, null);
                        }
                        if (!intent.getBooleanExtra("noConnectivity", false)) {
                            cr2.a(networkInfo2);
                        } else {
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "NetworkDetector", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "EXTRA_NO_CONNECTIVITY");
                                str2 = "EXTRA_NO_CONNECTIVITY";
                            } else {
                                str2 = "EXTRA_NO_CONNECTIVITY";
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("NetworkDetector", str2, null);
                            }
                            on2 on2Var2 = cr2.a;
                            i24 i24Var = i24.f;
                            cr2.f(on2Var2, new ei0(i24Var, null));
                            cr2.f(cr2.b, new ei0(i24Var, null));
                            cr2.f(cr2.c, new ei0(i24Var, null));
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
