package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ac2 implements gl2, AdapterView.OnItemClickListener {
    public ExpandedMenuView A;
    public fl2 X;
    public zb2 Y;
    public Context b;
    public LayoutInflater f;
    public nk2 z;

    public ac2(ContextWrapper contextWrapper) {
        this.b = contextWrapper;
        this.f = LayoutInflater.from(contextWrapper);
    }

    @Override // defpackage.gl2
    public final void a(nk2 nk2Var, boolean z) {
        fl2 fl2Var = this.X;
        if (fl2Var != null) {
            fl2Var.a(nk2Var, z);
        }
    }

    @Override // defpackage.gl2
    public final void c(boolean z) {
        zb2 zb2Var = this.Y;
        if (zb2Var != null) {
            zb2Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.gl2
    public final boolean d(b54 b54Var) {
        boolean zHasVisibleItems = b54Var.hasVisibleItems();
        Context context = b54Var.a;
        if (!zHasVisibleItems) {
            return false;
        }
        ok2 ok2Var = new ok2();
        ok2Var.b = b54Var;
        t6 t6Var = new t6(context);
        p6 p6Var = (p6) t6Var.z;
        ac2 ac2Var = new ac2(p6Var.a);
        ok2Var.z = ac2Var;
        ac2Var.X = ok2Var;
        b54Var.b(ac2Var, context);
        ac2 ac2Var2 = ok2Var.z;
        zb2 zb2Var = ac2Var2.Y;
        if (zb2Var == null) {
            zb2Var = new zb2(ac2Var2);
            ac2Var2.Y = zb2Var;
        }
        p6Var.s = zb2Var;
        p6Var.t = ok2Var;
        View view = b54Var.o;
        if (view != null) {
            p6Var.f = view;
        } else {
            p6Var.d = b54Var.n;
            p6Var.e = b54Var.m;
        }
        p6Var.q = ok2Var;
        u6 u6VarH = t6Var.h();
        ok2Var.f = u6VarH;
        u6VarH.setOnDismissListener(ok2Var);
        WindowManager.LayoutParams attributes = ok2Var.f.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        ok2Var.f.show();
        fl2 fl2Var = this.X;
        if (fl2Var == null) {
            return true;
        }
        fl2Var.i0(b54Var);
        return true;
    }

    @Override // defpackage.gl2
    public final boolean e() {
        return false;
    }

    @Override // defpackage.gl2
    public final boolean f(sk2 sk2Var) {
        return false;
    }

    @Override // defpackage.gl2
    public final int getId() {
        return 0;
    }

    @Override // defpackage.gl2
    public final void h(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.A.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // defpackage.gl2
    public final void i(fl2 fl2Var) {
        throw null;
    }

    @Override // defpackage.gl2
    public final boolean j(sk2 sk2Var) {
        return false;
    }

    @Override // defpackage.gl2
    public final void l(Context context, nk2 nk2Var) {
        if (this.b != null) {
            this.b = context;
            if (this.f == null) {
                this.f = LayoutInflater.from(context);
            }
        }
        this.z = nk2Var;
        zb2 zb2Var = this.Y;
        if (zb2Var != null) {
            zb2Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.gl2
    public final Parcelable m() {
        if (this.A == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.A;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.z.s(this.Y.getItem(i), this, 0);
    }
}
