package com.getsurfboard.ui.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;
import android.view.WindowManager;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.DeeplinkActivity;
import com.getsurfboard.ui.service.SurfboardTile;
import com.tencent.mars.xlog.Xlog;
import defpackage.ai0;
import defpackage.d73;
import defpackage.de0;
import defpackage.dw2;
import defpackage.e7;
import defpackage.fj3;
import defpackage.fy4;
import defpackage.hu2;
import defpackage.ja1;
import defpackage.ka1;
import defpackage.l72;
import defpackage.le2;
import defpackage.li;
import defpackage.n12;
import defpackage.p6;
import defpackage.p95;
import defpackage.ph0;
import defpackage.t23;
import defpackage.t53;
import defpackage.u6;
import defpackage.u74;
import defpackage.vs4;
import defpackage.wh2;
import defpackage.ws4;
import defpackage.xb5;
import defpackage.xe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SurfboardTile extends TileService {
    public static final /* synthetic */ int X = 0;
    public int A;
    public final u74 b;
    public final u74 f;
    public final u74 z;

    /* JADX WARN: Type inference failed for: r0v0, types: [u74] */
    /* JADX WARN: Type inference failed for: r0v1, types: [u74] */
    /* JADX WARN: Type inference failed for: r0v2, types: [u74] */
    public SurfboardTile() {
        final int i = 0;
        this.b = new hu2(this) { // from class: u74
            public final /* synthetic */ SurfboardTile f;

            {
                this.f = this;
            }

            @Override // defpackage.hu2
            public final void b(Object obj) {
                int i2 = i;
                SurfboardTile surfboardTile = this.f;
                switch (i2) {
                    case 0:
                        int i3 = SurfboardTile.X;
                        ((vs4) obj).getClass();
                        surfboardTile.b();
                        break;
                    case 1:
                        ((Boolean) obj).getClass();
                        int i4 = SurfboardTile.X;
                        surfboardTile.b();
                        break;
                    default:
                        int i5 = SurfboardTile.X;
                        surfboardTile.b();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.f = new hu2(this) { // from class: u74
            public final /* synthetic */ SurfboardTile f;

            {
                this.f = this;
            }

            @Override // defpackage.hu2
            public final void b(Object obj) {
                int i22 = i2;
                SurfboardTile surfboardTile = this.f;
                switch (i22) {
                    case 0:
                        int i3 = SurfboardTile.X;
                        ((vs4) obj).getClass();
                        surfboardTile.b();
                        break;
                    case 1:
                        ((Boolean) obj).getClass();
                        int i4 = SurfboardTile.X;
                        surfboardTile.b();
                        break;
                    default:
                        int i5 = SurfboardTile.X;
                        surfboardTile.b();
                        break;
                }
            }
        };
        final int i3 = 2;
        this.z = new hu2(this) { // from class: u74
            public final /* synthetic */ SurfboardTile f;

            {
                this.f = this;
            }

            @Override // defpackage.hu2
            public final void b(Object obj) {
                int i22 = i3;
                SurfboardTile surfboardTile = this.f;
                switch (i22) {
                    case 0:
                        int i32 = SurfboardTile.X;
                        ((vs4) obj).getClass();
                        surfboardTile.b();
                        break;
                    case 1:
                        ((Boolean) obj).getClass();
                        int i4 = SurfboardTile.X;
                        surfboardTile.b();
                        break;
                    default:
                        int i5 = SurfboardTile.X;
                        surfboardTile.b();
                        break;
                }
            }
        };
    }

    public final void a(Context context, boolean z) {
        Intent intentS = p95.s(context, z);
        intentS.setFlags(intentS.getFlags() + 67108864);
        intentS.setFlags(intentS.getFlags() + 536870912);
        intentS.setFlags(intentS.getFlags() + 268435456);
        try {
            if (Build.VERSION.SDK_INT < 34) {
                startActivityAndCollapse(intentS);
                return;
            }
            PendingIntent pendingIntentO = l72.o(context, fj3.b, intentS, true);
            pendingIntentO.getClass();
            startActivityAndCollapse(pendingIntentO);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        if (n12.c(ws4.b.d(), Boolean.TRUE) || d73.c.d() == null) {
            c(0);
            return;
        }
        vs4 vs4Var = (vs4) ws4.c.d();
        if (vs4Var == null || !vs4Var.b) {
            c(1);
        } else {
            c(2);
        }
    }

    public final void c(int i) {
        String str;
        String string;
        if (i == 0) {
            str = "UNAVAILABLE";
        } else if (i == 1) {
            str = "INACTIVE";
        } else {
            if (i != 2) {
                xe.k(dw2.A(i, "unknown tile state value: "));
                return;
            }
            str = "ACTIVE";
        }
        String strConcat = "setState: ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "SurfboardTile", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("SurfboardTile", strConcat, null);
        }
        this.A = i;
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setState(i);
            if (Build.VERSION.SDK_INT >= 29) {
                t53 t53Var = (t53) d73.c.d();
                if (t53Var == null || (string = t53Var.b) == null) {
                    string = getString(R.string.no_selected_profile);
                    string.getClass();
                }
                qsTile.setSubtitle(string);
            }
            try {
                qsTile.updateTile();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void d(de0 de0Var, Intent intent) {
        boolean zC;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                String[] strArr = t23.a;
                zC = true;
            } else {
                zC = t23.c(R.string.setting_auto_collapse_notification_bar_key, true);
            }
            if (!zC) {
                startActivity(intent);
            } else {
                if (i < 34) {
                    startActivityAndCollapse(intent);
                    return;
                }
                PendingIntent pendingIntentO = l72.o(de0Var, fj3.b, intent, true);
                pendingIntentO.getClass();
                startActivityAndCollapse(pendingIntentO);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        try {
            IBinder iBinderOnBind = super.onBind(intent);
            c(this.A);
            return iBinderOnBind;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void onClick() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "SurfboardTile", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onClick() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("SurfboardTile", "onClick() called", null);
        }
        vs4 vs4Var = (vs4) ws4.c.d();
        boolean z = vs4Var != null && vs4Var.b;
        Bundle bundle = new Bundle();
        bundle.putString("action", z ? "close" : "open");
        e7.a(bundle, "tile_clicked");
        de0 de0Var = new de0(this, R.style.Theme_Surfboard);
        if (((t53) d73.c.d()) == null) {
            xb5.c("SurfboardTile: profile == null");
            wh2 wh2Var = new wh2(de0Var);
            wh2Var.x(R.string.app_name);
            wh2Var.t(R.string.no_valid_profiles_existed);
            wh2Var.w(R.string.go_and_check, new li(10, this, de0Var));
            wh2Var.u(R.string.cancel, new ph0(7));
            ja1 ja1Var = new ja1(4);
            p6 p6Var = (p6) wh2Var.z;
            p6Var.p = ja1Var;
            p6Var.o = new ka1(4);
            u6 u6VarH = wh2Var.h();
            u6VarH.setOnShowListener(new ai0(5));
            try {
                showDialog(u6VarH);
                return;
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
                return;
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (z) {
            xb5.c("SurfboardTile: stopVpnService");
            c(0);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("surfboard:///stop"));
            intent.setClass(de0Var, DeeplinkActivity.class);
            intent.addFlags(268435456);
            d(de0Var, intent);
            e7.a(null, "tile_stop_vpn");
            return;
        }
        try {
            if (VpnService.prepare(de0Var) != null) {
                xb5.c("SurfboardTile: VpnService.prepare(context) != null");
                e7.a(null, "tile_jump_for_vpn_permission_grant");
                a(de0Var, true);
                return;
            }
            xb5.c("SurfboardTile: startSurfboardVpn");
            c(1);
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("surfboard:///start"));
            intent2.setClass(de0Var, DeeplinkActivity.class);
            intent2.addFlags(268435456);
            d(de0Var, intent2);
            e7.a(null, "tile_start_vpn");
        } catch (IllegalStateException e3) {
            e3.printStackTrace();
            String message = e3.getMessage();
            if (message == null) {
                message = getString(R.string.unknown_error);
                message.getClass();
            }
            p95.D(message);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        ws4.c.j(this.b);
        ws4.b.j(this.f);
        d73.c.j(this.z);
    }

    public final void onStartListening() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "SurfboardTile", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onStartListening() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("SurfboardTile", "onStartListening() called", null);
        }
        b();
        ws4.c.f(this.b);
        ws4.b.f(this.f);
        d73.c.f(this.z);
    }

    public final void onStopListening() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "SurfboardTile", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onStopListening() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("SurfboardTile", "onStopListening() called", null);
        }
        ws4.c.j(this.b);
        ws4.b.j(this.f);
        d73.c.j(this.z);
    }

    public final void onTileAdded() {
        t23.C(true);
        e7.a(null, "tile_added");
    }

    public final void onTileRemoved() {
        t23.C(false);
        e7.a(null, "tile_removed");
    }
}
