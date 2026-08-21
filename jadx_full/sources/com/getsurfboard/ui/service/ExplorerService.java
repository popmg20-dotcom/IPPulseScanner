package com.getsurfboard.ui.service;

import android.app.Dialog;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.R;
import com.tencent.mars.xlog.Xlog;
import defpackage.fj3;
import defpackage.fy4;
import defpackage.k5;
import defpackage.l72;
import defpackage.le2;
import defpackage.n12;
import defpackage.p95;
import defpackage.q81;
import defpackage.ts2;
import defpackage.us2;
import defpackage.v62;
import defpackage.v9;
import defpackage.w81;
import defpackage.wa;
import defpackage.xe;
import defpackage.zf2;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ExplorerService extends Service {
    public static final /* synthetic */ int y0 = 0;
    public zf2 A;
    public String X;
    public InetSocketAddress Y;
    public us2 b;
    public k5 f;
    public final w81 z = new w81(this);
    public final wa Z = new wa(3, this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        intent.getClass();
        String str = "onBind() called with: intent = " + intent;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ExplorerService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ExplorerService", str, null);
        }
        int i = Build.VERSION.SDK_INT;
        InetSocketAddress inetSocketAddress = i >= 33 ? (InetSocketAddress) intent.getSerializableExtra("address", InetSocketAddress.class) : (InetSocketAddress) intent.getSerializableExtra("address");
        if (inetSocketAddress == null) {
            xe.k("bindAddress not found");
            return null;
        }
        k5 k5Var = this.f;
        if (k5Var == null) {
            k5Var = new k5(this);
            this.f = k5Var;
        }
        if (k5Var.a == -1) {
            try {
                InetAddress address = inetSocketAddress.getAddress();
                address.getClass();
                k5Var.l(address, inetSocketAddress.getPort());
                zf2 zf2Var = this.A;
                if (zf2Var != null) {
                    zf2Var.p0(inetSocketAddress);
                }
                this.Y = inetSocketAddress;
                us2 us2Var = this.b;
                if (us2Var == null) {
                    n12.T("builder");
                    throw null;
                }
                us2Var.c(getString(R.string.explorer_running_template_short, inetSocketAddress.getAddress().getHostAddress(), Integer.valueOf(inetSocketAddress.getPort())));
                v62 v62Var = new v62(7, false);
                v62Var.z = us2.b(getString(R.string.explorer_running_template, inetSocketAddress.getAddress().getHostAddress(), Integer.valueOf(inetSocketAddress.getPort())));
                us2Var.d(v62Var);
                us2Var.b.add(new ts2(R.drawable.ic_round_content_copy_24, getString(R.string.copy_address), PendingIntent.getBroadcast(this, fj3.e, new Intent("com.getsurfboard.action.EXPLORER_COPY_URL").setPackage(getPackageName()), l72.a(134217728, false))));
                us2Var.b.add(new ts2(R.drawable.ic_round_stop_24, getString(R.string.stop), PendingIntent.getBroadcast(this, fj3.d, new Intent("com.getsurfboard.action.STOP_EXPLORER").setPackage(getPackageName()), l72.a(134217728, false))));
                us2 us2Var2 = this.b;
                if (i >= 34) {
                    if (us2Var2 == null) {
                        n12.T("builder");
                        throw null;
                    }
                    startForeground(R.id.explorer_notification, us2Var2.a(), 1);
                } else {
                    if (us2Var2 == null) {
                        n12.T("builder");
                        throw null;
                    }
                    startForeground(R.id.explorer_notification, us2Var2.a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                String message = e.getMessage();
                if (message == null) {
                    message = e.toString();
                }
                this.X = message;
                zf2 zf2Var2 = this.A;
                if (zf2Var2 != null) {
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.toString();
                    }
                    message2.getClass();
                    Dialog dialog = ((q81) zf2Var2.f).C0;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    p95.D(message2);
                }
            }
        }
        return this.z;
    }

    @Override // android.app.Service
    public final void onCreate() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ExplorerService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onCreate() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ExplorerService", "onCreate() called", null);
        }
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.getsurfboard.action.EXPLORER_COPY_URL");
        intentFilter.addAction("com.getsurfboard.action.STOP_EXPLORER");
        v9.r(this, this.Z, intentFilter, 4);
        us2 us2Var = new us2(this, "explorer");
        us2Var.s.icon = R.drawable.ic_stat_vpn;
        us2Var.e = us2.b(getString(R.string.explorer_service_title));
        us2Var.c(getString(R.string.starting));
        us2Var.n = "service";
        us2Var.m = true;
        us2Var.p = -1;
        us2Var.t = true;
        Intent intentS = p95.s(this, false);
        intentS.setFlags(intentS.getFlags() + 67108864);
        intentS.setFlags(intentS.getFlags() + 536870912);
        us2Var.g = l72.o(this, fj3.b, intentS, true);
        this.b = us2Var;
        if (Build.VERSION.SDK_INT >= 34) {
            startForeground(R.id.explorer_notification, us2Var.a(), 1);
        } else {
            startForeground(R.id.explorer_notification, us2Var.a());
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Dialog dialog;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ExplorerService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onDestroy() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ExplorerService", "onDestroy() called", null);
        }
        unregisterReceiver(this.Z);
        k5 k5Var = this.f;
        if (k5Var != null) {
            k5Var.c();
        }
        zf2 zf2Var = this.A;
        if (zf2Var != null && (dialog = ((q81) zf2Var.f).C0) != null) {
            dialog.dismiss();
        }
        this.A = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        String str = "onUnbind() called with: intent = " + intent;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ExplorerService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ExplorerService", str, null);
        }
        return super.onUnbind(intent);
    }
}
