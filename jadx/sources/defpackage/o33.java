package defpackage;

import androidx.slidingpanelayout.widget.SlidingPaneLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o33 extends ru2 implements fy3 {
    public final p33 d;

    public o33(p33 p33Var) {
        super(true);
        this.d = p33Var;
        ((SlidingPaneLayout) p33Var.requireView()).H0.add(this);
    }

    @Override // defpackage.ru2
    public final void b() {
        ((SlidingPaneLayout) this.d.requireView()).a();
    }
}
