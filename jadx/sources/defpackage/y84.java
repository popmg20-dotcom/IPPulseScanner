package defpackage;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y84 implements zu2, w61 {
    public static final String A0 = ue2.i("SystemFgDispatcher");
    public vw4 A;
    public final LinkedHashMap X;
    public final HashMap Y;
    public final HashMap Z;
    public final xw4 b;
    public final ih4 f;
    public final m20 y0;
    public final Object z = new Object();
    public SystemForegroundService z0;

    public y84(Context context) {
        xw4 xw4VarC = xw4.c(context);
        this.b = xw4VarC;
        this.f = xw4VarC.d;
        this.A = null;
        this.X = new LinkedHashMap();
        this.Z = new HashMap();
        this.Y = new HashMap();
        this.y0 = new m20(xw4VarC.j);
        xw4VarC.f.a(this);
    }

    public static Intent c(Context context, vw4 vw4Var, ni1 ni1Var) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", vw4Var.a);
        intent.putExtra("KEY_GENERATION", vw4Var.b);
        intent.putExtra("KEY_NOTIFICATION_ID", ni1Var.a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", ni1Var.b);
        intent.putExtra("KEY_NOTIFICATION", ni1Var.c);
        return intent;
    }

    @Override // defpackage.zu2
    public final void a(gx4 gx4Var, qc0 qc0Var) {
        if (qc0Var instanceof pc0) {
            String str = gx4Var.a;
            ue2.g().a(A0, "Constraints unmet for WorkSpec " + str);
            vw4 vw4VarM = l72.m(gx4Var);
            int i = ((pc0) qc0Var).a;
            xw4 xw4Var = this.b;
            ((la) xw4Var.d.a).execute(new o34(xw4Var.f, new h24(vw4VarM), true, i));
        }
    }

    @Override // defpackage.w61
    public final void b(vw4 vw4Var, boolean z) {
        Map.Entry entry;
        synchronized (this.z) {
            try {
                v32 v32Var = ((gx4) this.Y.remove(vw4Var)) != null ? (v32) this.Z.remove(vw4Var) : null;
                if (v32Var != null) {
                    v32Var.g(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ni1 ni1Var = (ni1) this.X.remove(vw4Var);
        if (vw4Var.equals(this.A)) {
            if (this.X.size() > 0) {
                Iterator it = this.X.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.A = (vw4) entry.getKey();
                if (this.z0 != null) {
                    ni1 ni1Var2 = (ni1) entry.getValue();
                    SystemForegroundService systemForegroundService = this.z0;
                    int i = ni1Var2.a;
                    int i2 = ni1Var2.b;
                    Notification notification = ni1Var2.c;
                    systemForegroundService.getClass();
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 31) {
                        v9.y(systemForegroundService, i, notification, i2);
                    } else if (i3 >= 29) {
                        v9.x(systemForegroundService, i, notification, i2);
                    } else {
                        systemForegroundService.startForeground(i, notification);
                    }
                    this.z0.A.cancel(ni1Var2.a);
                }
            } else {
                this.A = null;
            }
        }
        SystemForegroundService systemForegroundService2 = this.z0;
        if (ni1Var == null || systemForegroundService2 == null) {
            return;
        }
        ue2.g().a(A0, "Removing Notification (id: " + ni1Var.a + ", workSpecId: " + vw4Var + ", notificationType: " + ni1Var.b);
        systemForegroundService2.A.cancel(ni1Var.a);
    }

    public final void d(Intent intent) {
        if (this.z0 == null) {
            xe.q("handleNotify was called on the destroyed dispatcher");
            return;
        }
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        vw4 vw4Var = new vw4(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        ue2.g().a(A0, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification == null) {
            xe.k("Notification passed in the intent was null.");
            return;
        }
        ni1 ni1Var = new ni1(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.X;
        linkedHashMap.put(vw4Var, ni1Var);
        ni1 ni1Var2 = (ni1) linkedHashMap.get(this.A);
        if (ni1Var2 == null) {
            this.A = vw4Var;
        } else {
            this.z0.A.notify(intExtra, notification);
            if (Build.VERSION.SDK_INT >= 29) {
                Iterator it = linkedHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    i |= ((ni1) ((Map.Entry) it.next()).getValue()).b;
                }
                ni1Var = new ni1(ni1Var2.a, ni1Var2.c, i);
            } else {
                ni1Var = ni1Var2;
            }
        }
        SystemForegroundService systemForegroundService = this.z0;
        int i2 = ni1Var.a;
        int i3 = ni1Var.b;
        Notification notification2 = ni1Var.c;
        systemForegroundService.getClass();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            v9.y(systemForegroundService, i2, notification2, i3);
        } else if (i4 >= 29) {
            v9.x(systemForegroundService, i2, notification2, i3);
        } else {
            systemForegroundService.startForeground(i2, notification2);
        }
    }

    public final void e() {
        this.z0 = null;
        synchronized (this.z) {
            try {
                Iterator it = this.Z.values().iterator();
                while (it.hasNext()) {
                    ((v32) it.next()).g(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b.f.g(this);
    }

    public final void f(int i, int i2) {
        ue2.g().h(A0, "Foreground service timed out, FGS type: " + i2);
        for (Map.Entry entry : this.X.entrySet()) {
            if (((ni1) entry.getValue()).b == i2) {
                vw4 vw4Var = (vw4) entry.getKey();
                xw4 xw4Var = this.b;
                ((la) xw4Var.d.a).execute(new o34(xw4Var.f, new h24(vw4Var), true, -128));
            }
        }
        SystemForegroundService systemForegroundService = this.z0;
        if (systemForegroundService != null) {
            systemForegroundService.f = true;
            ue2.g().a(SystemForegroundService.X, "Shutting down.");
            if (Build.VERSION.SDK_INT >= 26) {
                systemForegroundService.stopForeground(true);
            }
            systemForegroundService.stopSelf(i);
        }
    }
}
