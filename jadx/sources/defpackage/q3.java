package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.getsurfboard.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q3 implements gl2 {
    public final LayoutInflater A;
    public n3 A0;
    public Drawable B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public int F0;
    public int G0;
    public int H0;
    public boolean I0;
    public l3 K0;
    public l3 L0;
    public tm1 M0;
    public m3 N0;
    public int P0;
    public fl2 X;
    public final Context b;
    public Context f;
    public il2 y0;
    public nk2 z;
    public int z0;
    public final int Y = R.layout.abc_action_menu_layout;
    public final int Z = R.layout.abc_action_menu_item_layout;
    public final SparseBooleanArray J0 = new SparseBooleanArray();
    public final w7 O0 = new w7(3, this);

    public q3(Context context) {
        this.b = context;
        this.A = LayoutInflater.from(context);
    }

    @Override // defpackage.gl2
    public final void a(nk2 nk2Var, boolean z) {
        g();
        l3 l3Var = this.L0;
        if (l3Var != null && l3Var.b()) {
            l3Var.i.dismiss();
        }
        fl2 fl2Var = this.X;
        if (fl2Var != null) {
            fl2Var.a(nk2Var, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b(sk2 sk2Var, View view, ViewGroup viewGroup) {
        View actionView = sk2Var.getActionView();
        if (actionView == null || sk2Var.e()) {
            hl2 hl2Var = view instanceof hl2 ? (hl2) view : (hl2) this.A.inflate(this.Z, viewGroup, false);
            hl2Var.c(sk2Var);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) hl2Var;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.y0);
            m3 m3Var = this.N0;
            if (m3Var == null) {
                m3Var = new m3(this);
                this.N0 = m3Var;
            }
            actionMenuItemView.setPopupCallback(m3Var);
            actionView = (View) hl2Var;
        }
        actionView.setVisibility(sk2Var.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof s3)) {
            actionView.setLayoutParams(ActionMenuView.k(layoutParams));
        }
        return actionView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.gl2
    public final void c(boolean z) {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.y0;
        ArrayList arrayList = null;
        boolean z2 = false;
        if (viewGroup != null) {
            nk2 nk2Var = this.z;
            if (nk2Var != null) {
                nk2Var.k();
                ArrayList arrayListN = this.z.n();
                int size = arrayListN.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    sk2 sk2Var = (sk2) arrayListN.get(i2);
                    if ((sk2Var.x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        sk2 itemData = childAt instanceof hl2 ? ((hl2) childAt).getItemData() : null;
                        View viewB = b(sk2Var, childAt, viewGroup);
                        if (sk2Var != itemData) {
                            viewB.setPressed(false);
                            viewB.jumpDrawablesToCurrentState();
                        }
                        if (viewB != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewB.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewB);
                            }
                            ((ViewGroup) this.y0).addView(viewB, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.A0) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.y0).requestLayout();
        nk2 nk2Var2 = this.z;
        if (nk2Var2 != null) {
            nk2Var2.k();
            ArrayList arrayList2 = nk2Var2.i;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                uk2 uk2Var = ((sk2) arrayList2.get(i3)).A;
            }
        }
        nk2 nk2Var3 = this.z;
        if (nk2Var3 != null) {
            nk2Var3.k();
            arrayList = nk2Var3.j;
        }
        if (this.D0 && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z2 = !((sk2) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z2 = true;
            }
        }
        n3 n3Var = this.A0;
        if (z2) {
            if (n3Var == null) {
                n3Var = new n3(this, this.b);
                this.A0 = n3Var;
            }
            ViewGroup viewGroup3 = (ViewGroup) n3Var.getParent();
            if (viewGroup3 != this.y0) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.A0);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.y0;
                n3 n3Var2 = this.A0;
                actionMenuView.getClass();
                s3 s3VarJ = ActionMenuView.j();
                s3VarJ.a = true;
                actionMenuView.addView(n3Var2, s3VarJ);
            }
        } else if (n3Var != null) {
            Object parent = n3Var.getParent();
            Object obj = this.y0;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.A0);
            }
        }
        ((ActionMenuView) this.y0).setOverflowReserved(this.D0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.gl2
    public final boolean d(b54 b54Var) {
        boolean z;
        if (b54Var.hasVisibleItems()) {
            b54 b54Var2 = b54Var;
            while (true) {
                nk2 nk2Var = b54Var2.A;
                if (nk2Var == this.z) {
                    break;
                }
                b54Var2 = (b54) nk2Var;
            }
            sk2 sk2Var = b54Var2.B;
            ViewGroup viewGroup = (ViewGroup) this.y0;
            View view = null;
            view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof hl2) && ((hl2) childAt).getItemData() == sk2Var) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                this.P0 = b54Var.B.a;
                int size = b54Var.f.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = b54Var.getItem(i2);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                l3 l3Var = new l3(this, this.f, b54Var, view);
                this.L0 = l3Var;
                l3Var.g = z;
                yk2 yk2Var = l3Var.i;
                if (yk2Var != null) {
                    yk2Var.q(z);
                }
                l3 l3Var2 = this.L0;
                if (!l3Var2.b()) {
                    if (l3Var2.e == null) {
                        xe.q("MenuPopupHelper cannot be used without an anchor");
                        return false;
                    }
                    l3Var2.d(0, 0, false, false);
                }
                fl2 fl2Var = this.X;
                if (fl2Var != null) {
                    fl2Var.i0(b54Var);
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.gl2
    public final boolean e() {
        int size;
        ArrayList arrayListN;
        int i;
        boolean z;
        q3 q3Var = this;
        nk2 nk2Var = q3Var.z;
        if (nk2Var != null) {
            arrayListN = nk2Var.n();
            size = arrayListN.size();
        } else {
            size = 0;
            arrayListN = null;
        }
        int i2 = q3Var.H0;
        int i3 = q3Var.G0;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) q3Var.y0;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            z = true;
            if (i4 >= size) {
                break;
            }
            sk2 sk2Var = (sk2) arrayListN.get(i4);
            int i7 = sk2Var.y;
            if ((i7 & 2) == 2) {
                i5++;
            } else if ((i7 & 1) == 1) {
                i6++;
            } else {
                z2 = true;
            }
            if (q3Var.I0 && sk2Var.C) {
                i2 = 0;
            }
            i4++;
        }
        if (q3Var.D0 && (z2 || i6 + i5 > i2)) {
            i2--;
        }
        int i8 = i2 - i5;
        SparseBooleanArray sparseBooleanArray = q3Var.J0;
        sparseBooleanArray.clear();
        int i9 = 0;
        int i10 = 0;
        while (i9 < size) {
            sk2 sk2Var2 = (sk2) arrayListN.get(i9);
            int i11 = sk2Var2.y;
            boolean z3 = (i11 & 2) == i ? z : false;
            int i12 = sk2Var2.b;
            if (z3) {
                View viewB = q3Var.b(sk2Var2, null, viewGroup);
                viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewB.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                if (i12 != 0) {
                    sparseBooleanArray.put(i12, z);
                }
                sk2Var2.h(z);
            } else if ((i11 & 1) == z) {
                boolean z4 = sparseBooleanArray.get(i12);
                boolean z5 = ((i8 > 0 || z4) && i3 > 0) ? z : false;
                if (z5) {
                    View viewB2 = q3Var.b(sk2Var2, null, viewGroup);
                    viewB2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewB2.getMeasuredWidth();
                    i3 -= measuredWidth2;
                    if (i10 == 0) {
                        i10 = measuredWidth2;
                    }
                    z5 &= i3 + i10 > 0;
                }
                if (z5 && i12 != 0) {
                    sparseBooleanArray.put(i12, true);
                } else if (z4) {
                    sparseBooleanArray.put(i12, false);
                    for (int i13 = 0; i13 < i9; i13++) {
                        sk2 sk2Var3 = (sk2) arrayListN.get(i13);
                        if (sk2Var3.b == i12) {
                            if ((sk2Var3.x & 32) == 32) {
                                i8++;
                            }
                            sk2Var3.h(false);
                        }
                    }
                }
                if (z5) {
                    i8--;
                }
                sk2Var2.h(z5);
            } else {
                sk2Var2.h(false);
                i9++;
                i = 2;
                q3Var = this;
                z = true;
            }
            i9++;
            i = 2;
            q3Var = this;
            z = true;
        }
        return z;
    }

    @Override // defpackage.gl2
    public final boolean f(sk2 sk2Var) {
        return false;
    }

    public final boolean g() {
        Object obj;
        tm1 tm1Var = this.M0;
        if (tm1Var != null && (obj = this.y0) != null) {
            ((View) obj).removeCallbacks(tm1Var);
            this.M0 = null;
            return true;
        }
        l3 l3Var = this.K0;
        if (l3Var == null) {
            return false;
        }
        if (l3Var.b()) {
            l3Var.i.dismiss();
        }
        return true;
    }

    @Override // defpackage.gl2
    public final int getId() {
        return this.z0;
    }

    @Override // defpackage.gl2
    public final void h(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof p3) && (i = ((p3) parcelable).b) > 0 && (menuItemFindItem = this.z.findItem(i)) != null) {
            d((b54) menuItemFindItem.getSubMenu());
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

    public final boolean k() {
        l3 l3Var = this.K0;
        return l3Var != null && l3Var.b();
    }

    @Override // defpackage.gl2
    public final void l(Context context, nk2 nk2Var) {
        this.f = context;
        LayoutInflater.from(context);
        this.z = nk2Var;
        Resources resources = context.getResources();
        if (!this.E0) {
            this.D0 = true;
        }
        int i = 2;
        this.F0 = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.H0 = i;
        int measuredWidth = this.F0;
        if (this.D0) {
            if (this.A0 == null) {
                n3 n3Var = new n3(this, this.b);
                this.A0 = n3Var;
                if (this.C0) {
                    n3Var.setImageDrawable(this.B0);
                    this.B0 = null;
                    this.C0 = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.A0.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.A0.getMeasuredWidth();
        } else {
            this.A0 = null;
        }
        this.G0 = measuredWidth;
        float f = resources.getDisplayMetrics().density;
    }

    @Override // defpackage.gl2
    public final Parcelable m() {
        p3 p3Var = new p3();
        p3Var.b = this.P0;
        return p3Var;
    }

    public final boolean n() {
        nk2 nk2Var;
        boolean z = false;
        if (this.D0 && !k() && (nk2Var = this.z) != null && this.y0 != null && this.M0 == null) {
            nk2Var.k();
            if (!nk2Var.j.isEmpty()) {
                tm1 tm1Var = new tm1(1, this, new l3(this, this.f, this.z, this.A0), z);
                this.M0 = tm1Var;
                ((View) this.y0).post(tm1Var);
                return true;
            }
        }
        return false;
    }
}
