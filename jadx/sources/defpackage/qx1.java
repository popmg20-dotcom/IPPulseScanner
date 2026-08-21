package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qx1 implements vi1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ qx1(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.vi1
    public final void a(wi1 wi1Var) {
        sa4 sa4Var;
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                sx1 sx1Var = (sx1) ((WeakReference) ((rx1) obj).X).get();
                if (sx1Var != null) {
                    sx1Var.M0.execute(new ga1(8, sx1Var));
                    return;
                }
                return;
            default:
                e10 e10Var = (e10) obj;
                synchronized (e10Var.z) {
                    try {
                        int i2 = e10Var.b - 1;
                        e10Var.b = i2;
                        if (e10Var.f && i2 == 0) {
                            e10Var.close();
                        }
                        sa4Var = (sa4) e10Var.Y;
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (sa4Var != null) {
                    sa4Var.a(wi1Var);
                    return;
                }
                return;
        }
    }
}
