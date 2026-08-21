package defpackage;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tt4 extends gb4 {
    public final /* synthetic */ int g;
    public final /* synthetic */ vt4 h;

    public /* synthetic */ tt4(vt4 vt4Var, int i) {
        this.g = i;
        this.h = vt4Var;
    }

    @Override // defpackage.er4
    public final void c() {
        View view;
        int i = this.g;
        vt4 vt4Var = this.h;
        switch (i) {
            case 0:
                if (vt4Var.z && (view = vt4Var.r) != null) {
                    view.setTranslationY(0.0f);
                    vt4Var.o.setTranslationY(0.0f);
                }
                vt4Var.o.setVisibility(8);
                vt4Var.o.setTransitioning(false);
                vt4Var.D = null;
                lb lbVar = vt4Var.v;
                if (lbVar != null) {
                    lbVar.C(vt4Var.u);
                    vt4Var.u = null;
                    vt4Var.v = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = vt4Var.n;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = wp4.a;
                    actionBarOverlayLayout.requestApplyInsets();
                }
                break;
            default:
                vt4Var.D = null;
                vt4Var.o.requestLayout();
                break;
        }
    }
}
