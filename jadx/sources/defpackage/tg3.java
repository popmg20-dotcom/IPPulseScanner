package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class tg3 extends h2 {
    public final RecyclerView d;
    public final sg3 e;

    public tg3(RecyclerView recyclerView) {
        this.d = recyclerView;
        h2 h2VarJ = j();
        if (h2VarJ == null || !(h2VarJ instanceof sg3)) {
            this.e = new sg3(this);
        } else {
            this.e = (sg3) h2VarJ;
        }
    }

    @Override // defpackage.h2
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.d.R()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().Y(accessibilityEvent);
        }
    }

    @Override // defpackage.h2
    public void d(View view, p2 p2Var) {
        this.a.onInitializeAccessibilityNodeInfo(view, p2Var.a);
        RecyclerView recyclerView = this.d;
        if (recyclerView.R() || recyclerView.getLayoutManager() == null) {
            return;
        }
        ag3 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.b;
        layoutManager.Z(recyclerView2.z, recyclerView2.y1, p2Var);
    }

    @Override // defpackage.h2
    public final boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.d;
        if (recyclerView.R() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        return recyclerView.getLayoutManager().n0(i, bundle);
    }

    public h2 j() {
        return this.e;
    }
}
