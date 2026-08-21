package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l45 extends v45 {
    public final /* synthetic */ int X;
    public final /* synthetic */ b55 Y;
    public final /* synthetic */ Object Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l45(b55 b55Var, Exception exc) {
        super(b55Var, false);
        this.X = 2;
        this.Z = exc;
        this.Y = b55Var;
    }

    @Override // defpackage.v45
    public final void a() {
        switch (this.X) {
            case 0:
                t35 t35Var = this.Y.e;
                tj4.i(t35Var);
                t35Var.setConditionalUserProperty((Bundle) this.Z, this.b);
                break;
            case 1:
                t35 t35Var2 = this.Y.e;
                tj4.i(t35Var2);
                t35Var2.retrieveAndUploadBatches(new p45(this, (tm1) this.Z));
                break;
            default:
                t35 t35Var3 = this.Y.e;
                tj4.i(t35Var3);
                t35Var3.logHealthData(5, "Error with data collection. Data lost.", new bu2((Exception) this.Z), new bu2(null), new bu2(null));
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l45(b55 b55Var, Object obj, int i) {
        super(b55Var, true);
        this.X = i;
        this.Z = obj;
        this.Y = b55Var;
    }
}
