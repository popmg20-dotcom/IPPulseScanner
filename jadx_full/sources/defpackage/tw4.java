package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tw4 implements pl1 {
    public final /* synthetic */ Context A;
    public final /* synthetic */ uw4 b;
    public final /* synthetic */ UUID f;
    public final /* synthetic */ ni1 z;

    public /* synthetic */ tw4(uw4 uw4Var, UUID uuid, ni1 ni1Var, Context context) {
        this.b = uw4Var;
        this.f = uuid;
        this.z = ni1Var;
        this.A = context;
    }

    @Override // defpackage.pl1
    public final Object a() {
        uw4 uw4Var = this.b;
        UUID uuid = this.f;
        ni1 ni1Var = this.z;
        Context context = this.A;
        String string = uuid.toString();
        gx4 gx4VarC = uw4Var.c.c(string);
        if (gx4VarC == null || gx4VarC.b.a()) {
            xe.q("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            return null;
        }
        n53 n53Var = uw4Var.b;
        synchronized (n53Var.k) {
            try {
                ue2.g().h(n53.l, "Moving WorkSpec (" + string + ") to the foreground");
                yx4 yx4Var = (yx4) n53Var.g.remove(string);
                if (yx4Var != null) {
                    if (n53Var.a == null) {
                        PowerManager.WakeLock wakeLockA = zs4.a(n53Var.b);
                        n53Var.a = wakeLockA;
                        wakeLockA.acquire();
                    }
                    n53Var.f.put(string, yx4Var);
                    v9.z(n53Var.b, y84.c(n53Var.b, l72.m(yx4Var.a), ni1Var));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        vw4 vw4VarM = l72.m(gx4VarC);
        String str = y84.A0;
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", ni1Var.a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", ni1Var.b);
        intent.putExtra("KEY_NOTIFICATION", ni1Var.c);
        intent.putExtra("KEY_WORKSPEC_ID", vw4VarM.a);
        intent.putExtra("KEY_GENERATION", vw4VarM.b);
        context.startService(intent);
        return null;
    }
}
