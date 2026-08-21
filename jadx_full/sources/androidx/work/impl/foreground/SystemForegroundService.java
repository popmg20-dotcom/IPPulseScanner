package androidx.work.impl.foreground;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import defpackage.da2;
import defpackage.fa2;
import defpackage.la;
import defpackage.n02;
import defpackage.p92;
import defpackage.p95;
import defpackage.qi;
import defpackage.r92;
import defpackage.t60;
import defpackage.tm1;
import defpackage.ue2;
import defpackage.xw4;
import defpackage.y84;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService extends Service implements da2 {
    public static final String X = ue2.i("SystemFgService");
    public NotificationManager A;
    public final n02 b = new n02(this);
    public boolean f;
    public y84 z;

    public final void a() {
        this.A = (NotificationManager) getApplicationContext().getSystemService("notification");
        y84 y84Var = new y84(getApplicationContext());
        this.z = y84Var;
        if (y84Var.z0 != null) {
            ue2.g().e(y84.A0, "A callback already exists.");
        } else {
            y84Var.z0 = this;
        }
    }

    public final void c() {
        n02 n02Var = this.b;
        n02Var.getClass();
        n02Var.D(p92.ON_CREATE);
        super.onCreate();
    }

    public final void d() {
        n02 n02Var = this.b;
        n02Var.getClass();
        n02Var.D(p92.ON_STOP);
        n02Var.D(p92.ON_DESTROY);
        super.onDestroy();
    }

    @Override // defpackage.da2
    public final r92 getLifecycle() {
        return (fa2) this.b.f;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        intent.getClass();
        n02 n02Var = this.b;
        n02Var.getClass();
        n02Var.D(p92.ON_START);
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        c();
        a();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        d();
        this.z.e();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        n02 n02Var = this.b;
        n02Var.getClass();
        n02Var.D(p92.ON_START);
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        boolean z = this.f;
        boolean z2 = false;
        String str = X;
        if (z) {
            ue2.g().h(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.z.e();
            a();
            this.f = false;
        }
        if (intent == null) {
            return 3;
        }
        y84 y84Var = this.z;
        y84Var.getClass();
        String str2 = y84.A0;
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            ue2.g().h(str2, "Started foreground service " + intent);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            ((la) y84Var.f.a).execute(new tm1(12, y84Var, stringExtra, z2));
            y84Var.d(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            y84Var.d(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            ue2.g().h(str2, "Stopping foreground service");
            SystemForegroundService systemForegroundService = y84Var.z0;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.f = true;
            ue2.g().a(str, "Shutting down.");
            if (Build.VERSION.SDK_INT >= 26) {
                systemForegroundService.stopForeground(true);
            }
            systemForegroundService.stopSelf(i2);
            return 3;
        }
        ue2.g().h(str2, "Stopping foreground work for " + intent);
        String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
            return 3;
        }
        xw4 xw4Var = y84Var.b;
        UUID uuidFromString = UUID.fromString(stringExtra2);
        xw4Var.getClass();
        uuidFromString.getClass();
        t60 t60Var = xw4Var.b.g;
        la laVar = (la) xw4Var.d.a;
        laVar.getClass();
        p95.w(t60Var, "CancelWorkById", laVar, new qi(2, xw4Var, uuidFromString));
        return 3;
    }

    @Override // android.app.Service
    public final void onTimeout(int i) {
        if (Build.VERSION.SDK_INT >= 35) {
            return;
        }
        this.z.f(i, 2048);
    }

    public final void onTimeout(int i, int i2) {
        this.z.f(i, i2);
    }
}
