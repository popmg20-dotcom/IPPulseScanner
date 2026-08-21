package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xr1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ zr1 a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public xr1(zr1 zr1Var, View view, View view2) {
        this.a = zr1Var;
        this.b = view;
        this.c = view2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        view.removeOnLayoutChangeListener(this);
        View view2 = this.b;
        int height = view2.getHeight();
        zr1 zr1Var = this.a;
        int paddingBottom = zr1Var.getPaddingBottom() + zr1Var.getPaddingTop() + height;
        int paddingBottom2 = zr1Var.getPaddingBottom() + zr1Var.getPaddingTop() + this.c.getHeight();
        ig0 ig0Var = new ig0(4, zr1Var, view2);
        int i9 = zr1.y0;
        zr1Var.c(paddingBottom, paddingBottom2, ig0Var);
    }
}
