package defpackage;

import android.widget.AbsListView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fc2 implements AbsListView.OnScrollListener {
    public final /* synthetic */ hc2 a;

    public fc2(hc2 hc2Var) {
        this.a = hc2Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        hc2 hc2Var = this.a;
        ec2 ec2Var = hc2Var.I0;
        kb kbVar = hc2Var.Q0;
        if (i != 1 || kbVar.getInputMethodMode() == 2 || kbVar.getContentView() == null) {
            return;
        }
        hc2Var.M0.removeCallbacks(ec2Var);
        ec2Var.run();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
