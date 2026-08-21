package defpackage;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.getsurfboard.R;
import com.google.android.material.internal.NavigationMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eq2 extends rf3 {
    public final ArrayList d = new ArrayList();
    public sk2 e;
    public boolean f;
    public final /* synthetic */ mq2 g;

    public eq2(mq2 mq2Var) {
        this.g = mq2Var;
        q();
    }

    @Override // defpackage.rf3
    public final int b() {
        return this.d.size();
    }

    @Override // defpackage.rf3
    public final long c(int i) {
        return i;
    }

    @Override // defpackage.rf3
    public final int d(int i) {
        gq2 gq2Var = (gq2) this.d.get(i);
        if (gq2Var instanceof hq2) {
            return 2;
        }
        if (gq2Var instanceof fq2) {
            return 3;
        }
        if (gq2Var instanceof iq2) {
            return ((iq2) gq2Var).a.hasSubMenu() ? 1 : 0;
        }
        zo2.w("Unknown item type.");
        return 0;
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        View view = ((lq2) rg3Var).a;
        int iD = d(i);
        ArrayList arrayList = this.d;
        mq2 mq2Var = this.g;
        if (iD != 0) {
            if (iD != 1) {
                if (iD != 2) {
                    return;
                }
                hq2 hq2Var = (hq2) arrayList.get(i);
                view.setPaddingRelative(mq2Var.J0, hq2Var.a, mq2Var.K0, hq2Var.b);
                return;
            }
            TextView textView = (TextView) view;
            textView.setText(((iq2) arrayList.get(i)).a.e);
            textView.setTextAppearance(mq2Var.Z);
            textView.setPaddingRelative(mq2Var.L0, textView.getPaddingTop(), mq2Var.M0, textView.getPaddingBottom());
            ColorStateList colorStateList = mq2Var.y0;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
            wp4.n(textView, new dq2(this, i, true));
            return;
        }
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        navigationMenuItemView.setIconTintList(mq2Var.C0);
        navigationMenuItemView.setTextAppearance(mq2Var.z0);
        ColorStateList colorStateList2 = mq2Var.B0;
        if (colorStateList2 != null) {
            navigationMenuItemView.setTextColor(colorStateList2);
        }
        Drawable drawable = mq2Var.D0;
        navigationMenuItemView.setBackground(drawable != null ? drawable.getConstantState().newDrawable() : null);
        RippleDrawable rippleDrawable = mq2Var.E0;
        if (rippleDrawable != null) {
            navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
        }
        iq2 iq2Var = (iq2) arrayList.get(i);
        navigationMenuItemView.setNeedsEmptyIcon(iq2Var.b);
        int i2 = mq2Var.F0;
        int i3 = mq2Var.G0;
        navigationMenuItemView.setPadding(i2, i3, i2, i3);
        navigationMenuItemView.setIconPadding(mq2Var.H0);
        if (mq2Var.N0) {
            navigationMenuItemView.setIconSize(mq2Var.I0);
        }
        navigationMenuItemView.setMaxLines(mq2Var.P0);
        sk2 sk2Var = iq2Var.a;
        navigationMenuItemView.S0 = mq2Var.A0;
        navigationMenuItemView.c(sk2Var);
        wp4.n(navigationMenuItemView, new dq2(this, i, false));
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        mq2 mq2Var = this.g;
        if (i == 0) {
            LayoutInflater layoutInflater = mq2Var.Y;
            c3 c3Var = mq2Var.T0;
            View viewInflate = layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false);
            kq2 kq2Var = new kq2(viewInflate);
            viewInflate.setOnClickListener(c3Var);
            return kq2Var;
        }
        if (i == 1) {
            return new cq2(mq2Var.Y.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
        if (i == 2) {
            return new cq2(mq2Var.Y.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
        if (i != 3) {
            return null;
        }
        return new cq2(mq2Var.f);
    }

    @Override // defpackage.rf3
    public final void m(rg3 rg3Var) {
        lq2 lq2Var = (lq2) rg3Var;
        if (lq2Var instanceof kq2) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lq2Var.a;
            FrameLayout frameLayout = navigationMenuItemView.U0;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            navigationMenuItemView.T0.setCompoundDrawables(null, null, null, null);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void q() {
        if (this.f) {
            return;
        }
        this.f = true;
        ArrayList arrayList = this.d;
        arrayList.clear();
        arrayList.add(new fq2());
        mq2 mq2Var = this.g;
        int size = mq2Var.z.n().size();
        boolean z = false;
        int i = -1;
        int i2 = 0;
        boolean z2 = false;
        int size2 = 0;
        while (i2 < size) {
            sk2 sk2Var = (sk2) mq2Var.z.n().get(i2);
            if (sk2Var.isChecked()) {
                r(sk2Var);
            }
            if (sk2Var.isCheckable()) {
                sk2Var.g(z);
            }
            if (sk2Var.hasSubMenu()) {
                b54 b54Var = sk2Var.o;
                if (b54Var.hasVisibleItems()) {
                    if (i2 != 0) {
                        arrayList.add(new hq2(mq2Var.R0, z ? 1 : 0));
                    }
                    arrayList.add(new iq2(sk2Var));
                    int size3 = b54Var.f.size();
                    int i3 = z ? 1 : 0;
                    int i4 = i3;
                    while (i3 < size3) {
                        sk2 sk2Var2 = (sk2) b54Var.getItem(i3);
                        if (sk2Var2.isVisible()) {
                            if (i4 == 0 && sk2Var2.getIcon() != null) {
                                i4 = 1;
                            }
                            if (sk2Var2.isCheckable()) {
                                sk2Var2.g(z);
                            }
                            if (sk2Var2.isChecked()) {
                                r(sk2Var2);
                            }
                            arrayList.add(new iq2(sk2Var2));
                        }
                        i3++;
                        z = false;
                    }
                    if (i4 != 0) {
                        int size4 = arrayList.size();
                        for (int size5 = arrayList.size(); size5 < size4; size5++) {
                            ((iq2) arrayList.get(size5)).b = true;
                        }
                    }
                }
            } else {
                int i5 = sk2Var.b;
                if (i5 != i) {
                    size2 = arrayList.size();
                    z2 = sk2Var.getIcon() != null;
                    if (i2 != 0) {
                        size2++;
                        int i6 = mq2Var.R0;
                        arrayList.add(new hq2(i6, i6));
                    }
                } else if (!z2 && sk2Var.getIcon() != null) {
                    int size6 = arrayList.size();
                    for (int i7 = size2; i7 < size6; i7++) {
                        ((iq2) arrayList.get(i7)).b = true;
                    }
                    z2 = true;
                }
                iq2 iq2Var = new iq2(sk2Var);
                iq2Var.b = z2;
                arrayList.add(iq2Var);
                i = i5;
            }
            i2++;
            z = false;
        }
        this.f = z;
    }

    public final void r(sk2 sk2Var) {
        if (this.e == sk2Var || !sk2Var.isCheckable()) {
            return;
        }
        sk2 sk2Var2 = this.e;
        if (sk2Var2 != null) {
            sk2Var2.setChecked(false);
        }
        this.e = sk2Var;
        sk2Var.setChecked(true);
    }
}
