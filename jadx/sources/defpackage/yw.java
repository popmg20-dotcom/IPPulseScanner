package defpackage;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yw implements om1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ o10 f;
    public final /* synthetic */ ex z;

    public /* synthetic */ yw(ex exVar, o10 o10Var, int i) {
        this.b = i;
        this.z = exVar;
        this.f = o10Var;
    }

    @Override // defpackage.om1
    public final void m(Object obj) {
        switch (this.b) {
            case 0:
                this.z.G0.remove(this.f);
                int iG = fw.G(this.z.c1);
                if (iG != 1 && iG != 5) {
                    if (iG == 6 || (iG == 7 && this.z.B0 != 0)) {
                        this.z.w("Camera reopen required. Checking if the current camera can be closed safely.", null);
                    }
                }
                if (this.z.G0.isEmpty()) {
                    ex exVar = this.z;
                    if (exVar.A0 != null) {
                        exVar.w("closing camera", null);
                        this.z.A0.close();
                        this.z.A0 = null;
                    }
                }
                break;
            default:
                if (this.z.J0.b() == 2 && this.z.c1 == 10) {
                    this.z.G(11);
                    break;
                }
                break;
        }
    }

    @Override // defpackage.om1
    public final void q(Throwable th) {
        switch (this.b) {
            case 0:
                break;
            default:
                boolean z = th instanceof cn0;
                ex exVar = this.z;
                tt3 tt3Var = null;
                if (z) {
                    dn0 dn0Var = ((cn0) th).b;
                    Iterator it = exVar.b.s().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            tt3 tt3Var2 = (tt3) it.next();
                            if (tt3Var2.b().contains(dn0Var)) {
                                tt3Var = tt3Var2;
                            }
                        }
                    }
                    if (tt3Var != null) {
                        ex exVar2 = this.z;
                        ScheduledExecutorService scheduledExecutorServiceQ = vf2.q();
                        rt3 rt3Var = tt3Var.f;
                        if (rt3Var != null) {
                            exVar2.w("Posting surface closed", new Throwable());
                            ((xq1) scheduledExecutorServiceQ).execute(new s7(7, rt3Var, tt3Var));
                        }
                    }
                } else if (!(th instanceof CancellationException)) {
                    if (exVar.c1 == 10) {
                        this.z.H(10, new mg(th, 4), true);
                    }
                    ez4.r("Camera2CameraImpl", "Unable to configure camera " + this.z, th);
                    ex exVar3 = this.z;
                    if (exVar3.C0 == this.f) {
                        exVar3.F();
                    }
                } else {
                    exVar.w("Unable to configure camera cancelled", null);
                }
                break;
        }
    }

    private final void a(Throwable th) {
    }
}
