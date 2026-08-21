package defpackage;

import android.os.Bundle;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m45 extends v45 {
    public final /* synthetic */ int X;
    public final /* synthetic */ String Y;
    public final /* synthetic */ String Z;
    public final /* synthetic */ b55 y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m45(b55 b55Var, k45 k45Var, String str, String str2) {
        super(b55Var, true);
        this.X = 2;
        this.z0 = k45Var;
        this.Y = str;
        this.Z = str2;
        Objects.requireNonNull(b55Var);
        this.y0 = b55Var;
    }

    @Override // defpackage.v45
    public final void a() {
        switch (this.X) {
            case 0:
                t35 t35Var = this.y0.e;
                tj4.i(t35Var);
                t35Var.clearConditionalUserProperty(this.Y, this.Z, (Bundle) this.z0);
                break;
            case 1:
                t35 t35Var2 = this.y0.e;
                tj4.i(t35Var2);
                t35Var2.getConditionalUserProperties(this.Y, this.Z, (q35) this.z0);
                break;
            default:
                t35 t35Var3 = this.y0.e;
                tj4.i(t35Var3);
                t35Var3.setCurrentScreenByScionActivityInfo((k45) this.z0, this.Y, this.Z, this.b);
                break;
        }
    }

    @Override // defpackage.v45
    public void b() {
        switch (this.X) {
            case 1:
                ((q35) this.z0).t(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m45(b55 b55Var, String str, String str2, Object obj, int i) {
        super(b55Var, true);
        this.X = i;
        this.Y = str;
        this.Z = str2;
        this.z0 = obj;
        this.y0 = b55Var;
    }
}
