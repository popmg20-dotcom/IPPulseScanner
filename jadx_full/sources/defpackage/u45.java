package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u45 extends v45 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ int X = 1;
    public final /* synthetic */ String Y;
    public final /* synthetic */ String Z;
    public final /* synthetic */ boolean y0;
    public final /* synthetic */ b55 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u45(b55 b55Var, String str, String str2, boolean z, q35 q35Var) {
        super(b55Var, true);
        this.Y = str;
        this.Z = str2;
        this.y0 = z;
        this.A0 = q35Var;
        this.z0 = b55Var;
    }

    @Override // defpackage.v45
    public final void a() {
        switch (this.X) {
            case 0:
                t35 t35Var = this.z0.e;
                tj4.i(t35Var);
                t35Var.getUserProperties(this.Y, this.Z, this.y0, (q35) this.A0);
                break;
            default:
                long j = this.b;
                t35 t35Var2 = this.z0.e;
                tj4.i(t35Var2);
                t35Var2.logEvent(this.Y, this.Z, (Bundle) this.A0, this.y0, true, j);
                break;
        }
    }

    @Override // defpackage.v45
    public void b() {
        switch (this.X) {
            case 0:
                ((q35) this.A0).t(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u45(b55 b55Var, String str, String str2, Bundle bundle, boolean z) {
        super(b55Var, true);
        this.Y = str;
        this.Z = str2;
        this.A0 = bundle;
        this.y0 = z;
        this.z0 = b55Var;
    }
}
