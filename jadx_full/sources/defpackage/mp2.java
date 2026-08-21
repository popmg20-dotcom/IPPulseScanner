package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class mp2 extends ViewGroup implements il2 {
    public static final int[] q1 = {R.attr.state_checked};
    public static final int[] r1 = {-16842910};
    public final SparseArray A;
    public lp2[] A0;
    public int B0;
    public int C0;
    public ColorStateList D0;
    public int E0;
    public ColorStateList F0;
    public final ColorStateList G0;
    public int H0;
    public int I0;
    public int J0;
    public int K0;
    public boolean L0;
    public Drawable M0;
    public ColorStateList N0;
    public int O0;
    public final SparseArray P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public boolean U0;
    public int V0;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;
    public int a1;
    public final ig b;
    public int b1;
    public ou3 c1;
    public boolean d1;
    public ColorStateList e1;
    public final c3 f;
    public op2 f1;
    public kp2 g1;
    public boolean h1;
    public boolean i1;
    public int j1;
    public int k1;
    public boolean l1;
    public MenuItem m1;
    public int n1;
    public boolean o1;
    public final Rect p1;
    public int y0;
    public d23 z;
    public int z0;

    public mp2(Context context) {
        super(context);
        this.A = new SparseArray();
        this.B0 = -1;
        this.C0 = -1;
        this.P0 = new SparseArray();
        this.Q0 = -1;
        this.R0 = -1;
        this.S0 = -1;
        this.T0 = -1;
        this.b1 = 49;
        this.d1 = false;
        this.j1 = 1;
        this.k1 = 0;
        this.m1 = null;
        this.n1 = 7;
        this.o1 = false;
        this.p1 = new Rect();
        this.G0 = c();
        if (isInEditMode()) {
            this.b = null;
        } else {
            ig igVar = new ig();
            this.b = igVar;
            igVar.Y(0);
            igVar.p();
            igVar.L(ek0.C(getContext(), com.getsurfboard.R.attr.motionDurationMedium4, getResources().getInteger(com.getsurfboard.R.integer.material_motion_duration_long_1)));
            igVar.O(l72.W(getContext(), com.getsurfboard.R.attr.motionEasingStandard, t8.b));
            igVar.U(new q82(1));
        }
        this.f = new c3(4, this);
        setImportantForAccessibility(1);
    }

    public static boolean g(int i, int i2) {
        return i == -1 ? i2 > 3 : i == 0;
    }

    private int getCollapsedVisibleItemCount() {
        return Math.min(this.n1, this.g1.e);
    }

    private ip2 getNewItem() {
        d23 d23Var = this.z;
        ip2 ip2Var = d23Var != null ? (ip2) d23Var.a() : null;
        return ip2Var == null ? f(getContext()) : ip2Var;
    }

    private void setBadgeIfNeeded(ip2 ip2Var) {
        pj pjVar;
        int id = ip2Var.getId();
        if (id == -1 || (pjVar = (pj) this.P0.get(id)) == null) {
            return;
        }
        ip2Var.setBadge(pjVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        View viewE;
        removeAllViews();
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null && this.z != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ip2 ip2Var = (ip2) lp2Var;
                    this.z.c(ip2Var);
                    ImageView imageView = ip2Var.N0;
                    if (ip2Var.r1 != null) {
                        if (imageView != null) {
                            ip2Var.setClipChildren(true);
                            ip2Var.setClipToPadding(true);
                            pj pjVar = ip2Var.r1;
                            if (pjVar != null) {
                                if (pjVar.e() != null) {
                                    pjVar.e().setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(pjVar);
                                }
                            }
                        }
                        ip2Var.r1 = null;
                    }
                    ip2Var.c1 = null;
                    ip2Var.i1 = 0.0f;
                    ip2Var.b = false;
                }
            }
        }
        this.f1.f = true;
        this.g1.b();
        this.f1.f = false;
        int i = this.g1.c;
        if (i == 0) {
            this.B0 = 0;
            this.C0 = 0;
            this.A0 = null;
            this.z = null;
            return;
        }
        if (this.z == null || this.k1 != i) {
            this.k1 = i;
            this.z = new d23(i);
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.g1.b.size(); i2++) {
            hashSet.add(Integer.valueOf(this.g1.a(i2).getItemId()));
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.P0;
            if (i3 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                sparseArray.delete(iKeyAt);
            }
            i3++;
        }
        int size = this.g1.b.size();
        this.A0 = new lp2[size];
        boolean zG = g(this.y0, getCurrentVisibleContentItemCount());
        int size2 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem menuItemA = this.g1.a(i5);
            boolean z = menuItemA instanceof mw0;
            if (z) {
                Context context = getContext();
                fp2 fp2Var = new fp2(context);
                LayoutInflater.from(context).inflate(com.getsurfboard.R.layout.m3_navigation_menu_divider, (ViewGroup) fp2Var, true);
                fp2Var.a();
                fp2Var.setOnlyShowWhenExpanded(true);
                fp2Var.setDividersEnabled(this.o1);
                viewE = fp2Var;
            } else if (menuItemA.hasSubMenu()) {
                if (size2 > 0) {
                    xe.k("Only one layer of submenu is supported; a submenu inside a submenu is not supported by the Navigation Bar.");
                    return;
                }
                qp2 qp2Var = new qp2(getContext());
                int i6 = this.K0;
                if (i6 == 0) {
                    i6 = this.I0;
                }
                qp2Var.setTextAppearance(i6);
                qp2Var.setTextColor(this.F0);
                qp2Var.setOnlyShowWhenExpanded(true);
                qp2Var.c((sk2) menuItemA);
                size2 = menuItemA.getSubMenu().size();
                viewE = qp2Var;
            } else if (size2 > 0) {
                size2--;
                viewE = e(i5, (sk2) menuItemA, zG, true);
            } else {
                sk2 sk2Var = (sk2) menuItemA;
                boolean z2 = i4 >= this.n1;
                i4++;
                viewE = e(i5, sk2Var, zG, z2);
            }
            if (!z && menuItemA.isCheckable() && this.C0 == -1) {
                this.C0 = i5;
            }
            this.A0[i5] = viewE;
            addView(viewE);
        }
        int iMin = Math.min(size - 1, this.C0);
        this.C0 = iMin;
        setCheckedItem(this.A0[iMin].getItemData());
    }

    @Override // defpackage.il2
    public final void b(nk2 nk2Var) {
        this.g1 = new kp2(nk2Var);
    }

    public final ColorStateList c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListG = v9.g(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(com.getsurfboard.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i = typedValue.data;
        int defaultColor = colorStateListG.getDefaultColor();
        int[] iArr = r1;
        return new ColorStateList(new int[][]{iArr, q1, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListG.getColorForState(iArr, defaultColor), i, defaultColor});
    }

    public final yi2 d() {
        if (this.c1 == null || this.e1 == null) {
            return null;
        }
        yi2 yi2Var = new yi2(this.c1);
        yi2Var.p(this.e1);
        return yi2Var;
    }

    public final ip2 e(int i, sk2 sk2Var, boolean z, boolean z2) {
        this.f1.f = true;
        sk2Var.setCheckable(true);
        this.f1.f = false;
        ip2 newItem = getNewItem();
        newItem.setShifting(z);
        newItem.setLabelMaxLines(this.j1);
        newItem.setIconTintList(this.D0);
        newItem.setIconSize(this.E0);
        newItem.setTextColor(this.G0);
        newItem.setTextAppearanceInactive(this.H0);
        newItem.setTextAppearanceActive(this.I0);
        newItem.setHorizontalTextAppearanceInactive(this.J0);
        newItem.setHorizontalTextAppearanceActive(this.K0);
        newItem.setTextAppearanceActiveBoldEnabled(this.L0);
        newItem.setTextColor(this.F0);
        int i2 = this.Q0;
        if (i2 != -1) {
            newItem.setItemPaddingTop(i2);
        }
        int i3 = this.R0;
        if (i3 != -1) {
            newItem.setItemPaddingBottom(i3);
        }
        newItem.setMeasureBottomPaddingFromLabelBaseline(this.h1);
        newItem.setLabelFontScalingEnabled(this.i1);
        int i4 = this.S0;
        if (i4 != -1) {
            newItem.setActiveIndicatorLabelPadding(i4);
        }
        int i5 = this.T0;
        if (i5 != -1) {
            newItem.setIconLabelHorizontalSpacing(i5);
        }
        newItem.setActiveIndicatorWidth(this.V0);
        newItem.setActiveIndicatorHeight(this.W0);
        newItem.setActiveIndicatorExpandedWidth(this.X0);
        newItem.setActiveIndicatorExpandedHeight(this.Y0);
        newItem.setActiveIndicatorMarginHorizontal(this.Z0);
        newItem.setItemGravity(this.b1);
        newItem.setActiveIndicatorExpandedPadding(this.p1);
        newItem.setActiveIndicatorExpandedMarginHorizontal(this.a1);
        newItem.setActiveIndicatorDrawable(d());
        newItem.setActiveIndicatorResizeable(this.d1);
        newItem.setActiveIndicatorEnabled(this.U0);
        Drawable drawable = this.M0;
        if (drawable != null) {
            newItem.setItemBackground(drawable);
        } else {
            newItem.setItemBackground(this.O0);
        }
        newItem.setItemRippleColor(this.N0);
        newItem.setLabelVisibilityMode(this.y0);
        newItem.setItemIconGravity(this.z0);
        newItem.setOnlyShowWhenExpanded(z2);
        newItem.setExpanded(this.l1);
        newItem.c(sk2Var);
        newItem.setItemPosition(i);
        int i6 = sk2Var.a;
        newItem.setOnTouchListener((View.OnTouchListener) this.A.get(i6));
        newItem.setOnClickListener(this.f);
        int i7 = this.B0;
        if (i7 != 0 && i6 == i7) {
            this.C0 = i;
        }
        setBadgeIfNeeded(newItem);
        return newItem;
    }

    public abstract ip2 f(Context context);

    public int getActiveIndicatorLabelPadding() {
        return this.S0;
    }

    public SparseArray<pj> getBadgeDrawables() {
        return this.P0;
    }

    public int getCurrentVisibleContentItemCount() {
        return this.l1 ? this.g1.d : getCollapsedVisibleItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.K0;
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.J0;
    }

    public int getIconLabelHorizontalSpacing() {
        return this.T0;
    }

    public ColorStateList getIconTintList() {
        return this.D0;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.e1;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.U0;
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.Y0;
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.a1;
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.X0;
    }

    public int getItemActiveIndicatorHeight() {
        return this.W0;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.Z0;
    }

    public ou3 getItemActiveIndicatorShapeAppearance() {
        return this.c1;
    }

    public int getItemActiveIndicatorWidth() {
        return this.V0;
    }

    public Drawable getItemBackground() {
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null && lp2VarArr.length > 0) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    return ((ip2) lp2Var).getBackground();
                }
            }
        }
        return this.M0;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.O0;
    }

    public int getItemGravity() {
        return this.b1;
    }

    public int getItemIconGravity() {
        return this.z0;
    }

    public int getItemIconSize() {
        return this.E0;
    }

    public int getItemPaddingBottom() {
        return this.R0;
    }

    public int getItemPaddingTop() {
        return this.Q0;
    }

    public ColorStateList getItemRippleColor() {
        return this.N0;
    }

    public int getItemTextAppearanceActive() {
        return this.I0;
    }

    public int getItemTextAppearanceInactive() {
        return this.H0;
    }

    public ColorStateList getItemTextColor() {
        return this.F0;
    }

    public int getLabelMaxLines() {
        return this.j1;
    }

    public int getLabelVisibilityMode() {
        return this.y0;
    }

    public kp2 getMenu() {
        return this.g1;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.i1;
    }

    public int getSelectedItemId() {
        return this.B0;
    }

    public int getSelectedItemPosition() {
        return this.C0;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getCurrentVisibleContentItemCount(), false, 1));
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.S0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorLabelPadding(i);
                }
            }
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        if (this.m1 == menuItem || !menuItem.isCheckable()) {
            return;
        }
        MenuItem menuItem2 = this.m1;
        if (menuItem2 != null && menuItem2.isChecked()) {
            this.m1.setChecked(false);
        }
        menuItem.setChecked(true);
        this.m1 = menuItem;
    }

    public void setCollapsedMaxItemCount(int i) {
        this.n1 = i;
    }

    public void setExpanded(boolean z) {
        this.l1 = z;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                lp2Var.setExpanded(z);
            }
        }
    }

    public void setHorizontalItemTextAppearanceActive(int i) {
        this.K0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setHorizontalTextAppearanceActive(i);
                }
            }
        }
    }

    public void setHorizontalItemTextAppearanceInactive(int i) {
        this.J0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setHorizontalTextAppearanceInactive(i);
                }
            }
        }
    }

    public void setIconLabelHorizontalSpacing(int i) {
        this.T0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setIconLabelHorizontalSpacing(i);
                }
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.D0 = colorStateList;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setIconTintList(colorStateList);
                }
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.e1 = colorStateList;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorDrawable(d());
                }
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.U0 = z;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorEnabled(z);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedHeight(int i) {
        this.Y0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorExpandedHeight(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i) {
        this.a1 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorExpandedMarginHorizontal(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedWidth(int i) {
        this.X0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorExpandedWidth(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.W0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorHeight(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.Z0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorMarginHorizontal(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z) {
        this.d1 = z;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorResizeable(z);
                }
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(ou3 ou3Var) {
        this.c1 = ou3Var;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorDrawable(d());
                }
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.V0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setActiveIndicatorWidth(i);
                }
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.M0 = drawable;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setItemBackground(drawable);
                }
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.O0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setItemBackground(i);
                }
            }
        }
    }

    public void setItemGravity(int i) {
        this.b1 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setItemGravity(i);
                }
            }
        }
    }

    public void setItemIconGravity(int i) {
        this.z0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setItemIconGravity(i);
                }
            }
        }
    }

    public void setItemIconSize(int i) {
        this.E0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setIconSize(i);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i) {
        this.R0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setItemPaddingBottom(this.R0);
                }
            }
        }
    }

    public void setItemPaddingTop(int i) {
        this.Q0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setItemPaddingTop(i);
                }
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.N0 = colorStateList;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setItemRippleColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        this.I0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setTextAppearanceActive(i);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.L0 = z;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setTextAppearanceActiveBoldEnabled(z);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        this.H0 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setTextAppearanceInactive(i);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.F0 = colorStateList;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setTextColor(colorStateList);
                }
            }
        }
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.i1 = z;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setLabelFontScalingEnabled(z);
                }
            }
        }
    }

    public void setLabelMaxLines(int i) {
        this.j1 = i;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setLabelMaxLines(i);
                }
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.y0 = i;
    }

    public void setMeasurePaddingFromLabelBaseline(boolean z) {
        this.h1 = z;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof ip2) {
                    ((ip2) lp2Var).setMeasureBottomPaddingFromLabelBaseline(z);
                }
            }
        }
    }

    public void setPresenter(op2 op2Var) {
        this.f1 = op2Var;
    }

    public void setSubmenuDividersEnabled(boolean z) {
        if (this.o1 == z) {
            return;
        }
        this.o1 = z;
        lp2[] lp2VarArr = this.A0;
        if (lp2VarArr != null) {
            for (lp2 lp2Var : lp2VarArr) {
                if (lp2Var instanceof fp2) {
                    ((fp2) lp2Var).setDividersEnabled(z);
                }
            }
        }
    }
}
