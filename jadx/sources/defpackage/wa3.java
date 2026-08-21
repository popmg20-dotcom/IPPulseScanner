package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wa3 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ya3 f;

    public /* synthetic */ wa3(ya3 ya3Var, int i) {
        this.b = i;
        this.f = ya3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ya3 ya3Var = this.f;
        switch (i) {
            case 0:
                ed4 ed4Var = ya3Var.b;
                ed4Var.getClass();
                ((RecyclerView) ed4Var.A).l0(0);
                break;
            default:
                ed4 ed4Var2 = ya3Var.b;
                if (ed4Var2 != null) {
                    ((RecyclerView) ed4Var2.A).l0(0);
                }
                break;
        }
    }
}
