package defpackage;

import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class df4 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Toolbar f;

    public /* synthetic */ df4(Toolbar toolbar, int i) {
        this.b = i;
        this.f = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Toolbar toolbar = this.f;
        switch (i) {
            case 0:
                ff4 ff4Var = toolbar.g1;
                sk2 sk2Var = ff4Var == null ? null : ff4Var.f;
                if (sk2Var != null) {
                    sk2Var.collapseActionView();
                }
                break;
            default:
                toolbar.p();
                break;
        }
    }
}
