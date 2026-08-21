package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q45 extends v45 {
    public final /* synthetic */ int X;
    public final /* synthetic */ q35 Y;
    public final /* synthetic */ b55 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q45(b55 b55Var, q35 q35Var, int i) {
        super(b55Var, true);
        this.X = i;
        this.Y = q35Var;
        this.Z = b55Var;
    }

    @Override // defpackage.v45
    public final void a() {
        switch (this.X) {
            case 0:
                t35 t35Var = this.Z.e;
                tj4.i(t35Var);
                t35Var.getGmpAppId(this.Y);
                break;
            case 1:
                t35 t35Var2 = this.Z.e;
                tj4.i(t35Var2);
                t35Var2.getCachedAppInstanceId(this.Y);
                break;
            case 2:
                t35 t35Var3 = this.Z.e;
                tj4.i(t35Var3);
                t35Var3.generateEventId(this.Y);
                break;
            case 3:
                t35 t35Var4 = this.Z.e;
                tj4.i(t35Var4);
                t35Var4.getCurrentScreenName(this.Y);
                break;
            default:
                t35 t35Var5 = this.Z.e;
                tj4.i(t35Var5);
                t35Var5.getCurrentScreenClass(this.Y);
                break;
        }
    }

    @Override // defpackage.v45
    public final void b() {
        int i = this.X;
        q35 q35Var = this.Y;
        switch (i) {
            case 0:
                q35Var.t(null);
                break;
            case 1:
                q35Var.t(null);
                break;
            case 2:
                q35Var.t(null);
                break;
            case 3:
                q35Var.t(null);
                break;
            default:
                q35Var.t(null);
                break;
        }
    }
}
