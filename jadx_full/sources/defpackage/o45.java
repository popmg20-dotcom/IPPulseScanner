package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o45 extends v45 {
    public final /* synthetic */ int X;
    public final /* synthetic */ String Y;
    public final /* synthetic */ b55 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o45(b55 b55Var, String str, int i) {
        super(b55Var, true);
        this.X = i;
        this.Y = str;
        this.Z = b55Var;
    }

    @Override // defpackage.v45
    public final void a() {
        switch (this.X) {
            case 0:
                t35 t35Var = this.Z.e;
                tj4.i(t35Var);
                t35Var.beginAdUnitExposure(this.Y, this.f);
                break;
            default:
                t35 t35Var2 = this.Z.e;
                tj4.i(t35Var2);
                t35Var2.endAdUnitExposure(this.Y, this.f);
                break;
        }
    }
}
