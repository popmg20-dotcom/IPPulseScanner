package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sg3 extends h2 {
    public final tg3 d;
    public final WeakHashMap e = new WeakHashMap();

    public sg3(tg3 tg3Var) {
        this.d = tg3Var;
    }

    @Override // defpackage.h2
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        h2 h2Var = (h2) this.e.get(view);
        return h2Var != null ? h2Var.a(view, accessibilityEvent) : this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // defpackage.h2
    public final cp1 b(View view) {
        h2 h2Var = (h2) this.e.get(view);
        return h2Var != null ? h2Var.b(view) : super.b(view);
    }

    @Override // defpackage.h2
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        h2 h2Var = (h2) this.e.get(view);
        if (h2Var != null) {
            h2Var.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // defpackage.h2
    public final void d(View view, p2 p2Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = p2Var.a;
        tg3 tg3Var = this.d;
        RecyclerView recyclerView = tg3Var.d;
        RecyclerView recyclerView2 = tg3Var.d;
        boolean zR = recyclerView.R();
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        if (zR || recyclerView2.getLayoutManager() == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        recyclerView2.getLayoutManager().b0(view, p2Var);
        h2 h2Var = (h2) this.e.get(view);
        if (h2Var != null) {
            h2Var.d(view, p2Var);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // defpackage.h2
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        h2 h2Var = (h2) this.e.get(view);
        if (h2Var != null) {
            h2Var.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // defpackage.h2
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        h2 h2Var = (h2) this.e.get(viewGroup);
        return h2Var != null ? h2Var.f(viewGroup, view, accessibilityEvent) : this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // defpackage.h2
    public final boolean g(View view, int i, Bundle bundle) {
        tg3 tg3Var = this.d;
        RecyclerView recyclerView = tg3Var.d;
        RecyclerView recyclerView2 = tg3Var.d;
        if (recyclerView.R() || recyclerView2.getLayoutManager() == null) {
            return super.g(view, i, bundle);
        }
        h2 h2Var = (h2) this.e.get(view);
        if (h2Var != null) {
            if (h2Var.g(view, i, bundle)) {
                return true;
            }
        } else if (super.g(view, i, bundle)) {
            return true;
        }
        ig3 ig3Var = recyclerView2.getLayoutManager().b.z;
        return false;
    }

    @Override // defpackage.h2
    public final void h(View view, int i) {
        h2 h2Var = (h2) this.e.get(view);
        if (h2Var != null) {
            h2Var.h(view, i);
        } else {
            super.h(view, i);
        }
    }

    @Override // defpackage.h2
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        h2 h2Var = (h2) this.e.get(view);
        if (h2Var != null) {
            h2Var.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
