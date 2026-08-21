package defpackage;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w45 extends v45 {
    public final /* synthetic */ int X;
    public final /* synthetic */ Activity Y;
    public final /* synthetic */ a55 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w45(a55 a55Var, Activity activity, int i) {
        super((b55) a55Var.f, true);
        this.X = i;
        switch (i) {
            case 1:
                this.Y = activity;
                this.Z = a55Var;
                super((b55) a55Var.f, true);
                break;
            case 2:
                this.Y = activity;
                this.Z = a55Var;
                super((b55) a55Var.f, true);
                break;
            case 3:
                this.Y = activity;
                this.Z = a55Var;
                super((b55) a55Var.f, true);
                break;
            case 4:
                this.Y = activity;
                this.Z = a55Var;
                super((b55) a55Var.f, true);
                break;
            default:
                this.Y = activity;
                this.Z = a55Var;
                break;
        }
    }

    @Override // defpackage.v45
    public final void a() {
        switch (this.X) {
            case 0:
                t35 t35Var = ((b55) this.Z.f).e;
                tj4.i(t35Var);
                t35Var.onActivityStartedByScionActivityInfo(k45.a(this.Y), this.f);
                break;
            case 1:
                t35 t35Var2 = ((b55) this.Z.f).e;
                tj4.i(t35Var2);
                t35Var2.onActivityResumedByScionActivityInfo(k45.a(this.Y), this.f);
                break;
            case 2:
                t35 t35Var3 = ((b55) this.Z.f).e;
                tj4.i(t35Var3);
                t35Var3.onActivityPausedByScionActivityInfo(k45.a(this.Y), this.f);
                break;
            case 3:
                t35 t35Var4 = ((b55) this.Z.f).e;
                tj4.i(t35Var4);
                t35Var4.onActivityStoppedByScionActivityInfo(k45.a(this.Y), this.f);
                break;
            default:
                t35 t35Var5 = ((b55) this.Z.f).e;
                tj4.i(t35Var5);
                t35Var5.onActivityDestroyedByScionActivityInfo(k45.a(this.Y), this.f);
                break;
        }
    }
}
