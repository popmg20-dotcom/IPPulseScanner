package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import defpackage.nw4;
import defpackage.o71;
import defpackage.p95;
import defpackage.qv2;
import defpackage.rv2;
import defpackage.ue2;
import defpackage.xw4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String a = ue2.i("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        ue2 ue2VarG = ue2.g();
        String str = a;
        ue2VarG.a(str, "Requesting diagnostics");
        try {
            context.getClass();
            xw4 xw4VarC = xw4.c(context);
            List listX = p95.x((rv2) new qv2(DiagnosticsWorker.class, 0).a());
            if (listX.isEmpty()) {
                throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
            }
            new nw4(xw4VarC, null, o71.f, listX, 0).a();
        } catch (IllegalStateException e) {
            ue2.g().f(str, "WorkManager is not initialized", e);
        }
    }
}
