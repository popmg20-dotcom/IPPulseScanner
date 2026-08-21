package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.getsurfboard.R;
import com.google.android.material.internal.NavigationMenuView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mq2 implements gl2 {
    public int A;
    public ColorStateList B0;
    public ColorStateList C0;
    public Drawable D0;
    public RippleDrawable E0;
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public boolean N0;
    public int P0;
    public int Q0;
    public int R0;
    public eq2 X;
    public LayoutInflater Y;
    public NavigationMenuView b;
    public LinearLayout f;
    public ColorStateList y0;
    public nk2 z;
    public int Z = 0;
    public int z0 = 0;
    public boolean A0 = true;
    public boolean O0 = true;
    public int S0 = -1;
    public final c3 T0 = new c3(5, this);

    public final void b() {
        eq2 eq2Var = this.X;
        if (eq2Var != null) {
            ArrayList arrayList = eq2Var.d;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) instanceof hq2) {
                    eq2Var.e(i);
                }
            }
        }
    }

    @Override // defpackage.gl2
    public final void c(boolean z) {
        eq2 eq2Var = this.X;
        if (eq2Var != null) {
            sf3 sf3Var = eq2Var.a;
            ArrayList arrayList = eq2Var.d;
            int size = arrayList.size();
            eq2Var.q();
            sf3Var.b();
            if (size == arrayList.size()) {
                sf3Var.d(0, arrayList.size(), null);
            }
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
        return false;
    }

    public final void g() {
        eq2 eq2Var = this.X;
        if (eq2Var != null) {
            ArrayList arrayList = eq2Var.d;
            for (int i = 0; i < arrayList.size(); i++) {
                if ((arrayList.get(i) instanceof iq2) && eq2Var.d(i) == 1) {
                    eq2Var.e(i);
                }
            }
        }
    }

    @Override // defpackage.gl2
    public final int getId() {
        return this.A;
    }

    @Override // defpackage.gl2
    public final void h(Parcelable parcelable) {
        sk2 sk2Var;
        View actionView;
        j03 j03Var;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.b.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                eq2 eq2Var = this.X;
                ArrayList arrayList = eq2Var.d;
                int i = bundle2.getInt("android:menu:checked", 0);
                if (i != 0) {
                    eq2Var.f = true;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        gq2 gq2Var = (gq2) arrayList.get(i2);
                        if (gq2Var instanceof iq2) {
                            sk2 sk2Var2 = ((iq2) gq2Var).a;
                            if (sk2Var2.a == i) {
                                eq2Var.r(sk2Var2);
                                break;
                            }
                        }
                        i2++;
                    }
                    eq2Var.f = false;
                    eq2Var.q();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        gq2 gq2Var2 = (gq2) arrayList.get(i3);
                        if ((gq2Var2 instanceof iq2) && (actionView = (sk2Var = ((iq2) gq2Var2).a).getActionView()) != null && (j03Var = (j03) sparseParcelableArray2.get(sk2Var.a)) != null) {
                            actionView.restoreHierarchyState(j03Var);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // defpackage.gl2
    public final boolean j(sk2 sk2Var) {
        return false;
    }

    public final void k() {
        eq2 eq2Var = this.X;
        if (eq2Var != null) {
            ArrayList arrayList = eq2Var.d;
            for (int i = 0; i < arrayList.size(); i++) {
                if ((arrayList.get(i) instanceof iq2) && eq2Var.d(i) == 0) {
                    eq2Var.e(i);
                }
            }
        }
    }

    @Override // defpackage.gl2
    public final void l(Context context, nk2 nk2Var) {
        this.Y = LayoutInflater.from(context);
        this.z = nk2Var;
        this.R0 = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    @Override // defpackage.gl2
    public final Parcelable m() {
        sk2 sk2Var;
        View actionView;
        Bundle bundle = new Bundle();
        if (this.b != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.b.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        eq2 eq2Var = this.X;
        if (eq2Var != null) {
            ArrayList arrayList = eq2Var.d;
            Bundle bundle2 = new Bundle();
            sk2 sk2Var2 = eq2Var.e;
            if (sk2Var2 != null) {
                bundle2.putInt("android:menu:checked", sk2Var2.a);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                gq2 gq2Var = (gq2) arrayList.get(i);
                if ((gq2Var instanceof iq2) && (actionView = (sk2Var = ((iq2) gq2Var).a).getActionView()) != null) {
                    j03 j03Var = new j03();
                    actionView.saveHierarchyState(j03Var);
                    sparseArray2.put(sk2Var.a, j03Var);
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.f.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // defpackage.gl2
    public final void a(nk2 nk2Var, boolean z) {
    }
}
