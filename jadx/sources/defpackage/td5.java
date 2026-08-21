package defpackage;

import android.content.Intent;
import android.os.SystemClock;
import io.sentry.android.core.internal.tombstone.b;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class td5 extends n25 {
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ td5(Object obj, m95 m95Var, int i) {
        super(m95Var);
        this.e = i;
        this.f = obj;
    }

    @Override // defpackage.n25
    public final void a() {
        int i = this.e;
        Object obj = this.f;
        switch (i) {
            case 0:
                b bVar = (b) obj;
                zd5 zd5Var = (zd5) bVar.d;
                zd5Var.V0();
                k85 k85Var = (k85) zd5Var.f;
                k85Var.B0.getClass();
                bVar.b(SystemClock.elapsedRealtime(), false, false);
                d45 d45Var = k85Var.E0;
                k85.e(d45Var);
                k85Var.B0.getClass();
                d45Var.Y0(SystemClock.elapsedRealtime());
                break;
            case 1:
                ge5 ge5Var = (ge5) obj;
                ge5Var.Z0();
                t65 t65Var = ((k85) ge5Var.f).Y;
                k85.h(t65Var);
                t65Var.H0.a("Starting upload from DelayedRunnable");
                ge5Var.X.l();
                break;
            default:
                ff5 ff5Var = (ff5) obj;
                ff5Var.C().V0();
                String str = (String) ff5Var.H0.pollFirst();
                if (str != null) {
                    ff5Var.z0().getClass();
                    ff5Var.Z0 = SystemClock.elapsedRealtime();
                    ff5Var.n().H0.b(str, "Sending trigger URI notification to app");
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                    intent.setPackage(str);
                    ff5.P(ff5Var.C0.b, intent);
                }
                ff5Var.E();
                break;
        }
    }
}
