package defpackage;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h85 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ v35 f;
    public final /* synthetic */ AppMeasurementDynamiteService z;

    public /* synthetic */ h85(AppMeasurementDynamiteService appMeasurementDynamiteService, v35 v35Var, int i) {
        this.b = i;
        this.f = v35Var;
        this.z = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        switch (this.b) {
            case 0:
                dd5 dd5VarJ = this.z.c.j();
                v35 v35Var = this.f;
                dd5VarJ.V0();
                dd5VarJ.W0();
                dd5VarJ.j1(new g33(11, dd5VarJ, dd5VarJ.l1(false), v35Var));
                break;
            default:
                AppMeasurementDynamiteService appMeasurementDynamiteService = this.z;
                qf5 qf5Var = appMeasurementDynamiteService.c.z0;
                k85.f(qf5Var);
                k85 k85Var = appMeasurementDynamiteService.c;
                if (k85Var.P0 != null && k85Var.P0.booleanValue()) {
                    z = true;
                }
                qf5Var.J1(this.f, z);
                break;
        }
    }
}
