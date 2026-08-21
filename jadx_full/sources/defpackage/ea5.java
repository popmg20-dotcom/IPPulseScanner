package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ea5 implements Runnable {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ ib5 f;

    public ea5(ib5 ib5Var, boolean z) {
        this.b = z;
        Objects.requireNonNull(ib5Var);
        this.f = ib5Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        ib5 ib5Var = this.f;
        k85 k85Var = (k85) ib5Var.f;
        boolean zA = k85Var.a();
        boolean z = false;
        boolean z2 = k85Var.P0 != null && k85Var.P0.booleanValue();
        boolean z3 = this.b;
        k85Var.P0 = Boolean.valueOf(z3);
        if (z2 == z3) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.H0.b(Boolean.valueOf(z3), "Default data collection state already set to");
        }
        if (k85Var.a() != zA) {
            boolean zA2 = k85Var.a();
            if (k85Var.P0 != null && k85Var.P0.booleanValue()) {
                z = true;
            }
            if (zA2 != z) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.E0.c("Default data collection is different than actual status", Boolean.valueOf(z3), Boolean.valueOf(zA));
            }
        }
        ib5Var.n1();
    }
}
