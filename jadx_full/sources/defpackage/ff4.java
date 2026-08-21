package defpackage;

import android.content.Context;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ff4 implements gl2 {
    public nk2 b;
    public sk2 f;
    public final /* synthetic */ Toolbar z;

    public ff4(Toolbar toolbar) {
        this.z = toolbar;
    }

    @Override // defpackage.gl2
    public final void c(boolean z) {
        if (this.f != null) {
            nk2 nk2Var = this.b;
            if (nk2Var != null) {
                int size = nk2Var.f.size();
                for (int i = 0; i < size; i++) {
                    if (this.b.getItem(i) == this.f) {
                        return;
                    }
                }
            }
            f(this.f);
        }
    }

    @Override // defpackage.gl2
    public final boolean d(b54 b54Var) {
        return false;
    }

    @Override // defpackage.gl2
    public final boolean e() {
        return false;
    }

    @Override // defpackage.gl2
    public final boolean f(sk2 sk2Var) {
        Toolbar toolbar = this.z;
        KeyEvent.Callback callback = toolbar.C0;
        if (callback instanceof u60) {
            ((u60) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.C0);
        toolbar.removeView(toolbar.B0);
        toolbar.C0 = null;
        ArrayList arrayList = toolbar.Y0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f = null;
        toolbar.requestLayout();
        sk2Var.C = false;
        sk2Var.n.r(false);
        toolbar.y();
        return true;
    }

    @Override // defpackage.gl2
    public final int getId() {
        return 0;
    }

    @Override // defpackage.gl2
    public final boolean j(sk2 sk2Var) {
        Toolbar toolbar = this.z;
        toolbar.c();
        ViewParent parent = toolbar.B0.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.B0);
            }
            toolbar.addView(toolbar.B0);
        }
        View actionView = sk2Var.getActionView();
        toolbar.C0 = actionView;
        this.f = sk2Var;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.C0);
            }
            gf4 gf4VarH = Toolbar.h();
            gf4VarH.a = (toolbar.H0 & 112) | 8388611;
            gf4VarH.b = 2;
            toolbar.C0.setLayoutParams(gf4VarH);
            toolbar.addView(toolbar.C0);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((gf4) childAt.getLayoutParams()).b != 2 && childAt != toolbar.b) {
                toolbar.removeViewAt(childCount);
                toolbar.Y0.add(childAt);
            }
        }
        toolbar.requestLayout();
        sk2Var.C = true;
        sk2Var.n.r(false);
        KeyEvent.Callback callback = toolbar.C0;
        if (callback instanceof u60) {
            ((u60) callback).onActionViewExpanded();
        }
        toolbar.y();
        return true;
    }

    @Override // defpackage.gl2
    public final void l(Context context, nk2 nk2Var) {
        sk2 sk2Var;
        nk2 nk2Var2 = this.b;
        if (nk2Var2 != null && (sk2Var = this.f) != null) {
            nk2Var2.d(sk2Var);
        }
        this.b = nk2Var;
    }

    @Override // defpackage.gl2
    public final Parcelable m() {
        return null;
    }

    @Override // defpackage.gl2
    public final void h(Parcelable parcelable) {
    }

    @Override // defpackage.gl2
    public final void a(nk2 nk2Var, boolean z) {
    }
}
