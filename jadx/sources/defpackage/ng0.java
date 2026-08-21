package defpackage;

import android.database.DataSetObserver;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ng0 extends DataSetObserver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ng0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                p54 p54Var = (p54) obj;
                p54Var.b = true;
                p54Var.notifyDataSetChanged();
                break;
            default:
                hc2 hc2Var = (hc2) obj;
                if (hc2Var.Q0.isShowing()) {
                    hc2Var.g();
                }
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                p54 p54Var = (p54) obj;
                p54Var.b = false;
                p54Var.notifyDataSetInvalidated();
                break;
            default:
                ((hc2) obj).dismiss();
                break;
        }
    }
}
