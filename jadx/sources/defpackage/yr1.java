package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yr1 extends r82 implements pl1 {
    public final /* synthetic */ View A;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ zr1 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yr1(boolean z, zr1 zr1Var, View view) {
        super(0);
        this.f = z;
        this.z = zr1Var;
        this.A = view;
    }

    @Override // defpackage.pl1
    public final Object a() {
        zr1 zr1Var = this.z;
        boolean z = this.f;
        int childCount = z ? zr1Var.getChildCount() : 0;
        View view = this.A;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = zr1Var.generateDefaultLayoutParams();
        }
        super/*android.widget.ViewFlipper*/.addView(view, childCount, layoutParams);
        if (zr1Var.getChildCount() != 1) {
            View displayedChildView = zr1Var.getDisplayedChildView();
            displayedChildView.getClass();
            zr1Var.a(view, new wr1(z, zr1Var, 0), new wr1(z, zr1Var, 1));
            WeakHashMap weakHashMap = wp4.a;
            if (!zr1Var.isLaidOut() || zr1Var.isLayoutRequested()) {
                zr1Var.addOnLayoutChangeListener(new xr1(zr1Var, displayedChildView, view));
            } else {
                zr1Var.c(zr1Var.getPaddingBottom() + zr1Var.getPaddingTop() + displayedChildView.getHeight(), zr1Var.getPaddingBottom() + zr1Var.getPaddingTop() + view.getHeight(), new ig0(4, zr1Var, displayedChildView));
            }
        }
        return xl4.a;
    }
}
