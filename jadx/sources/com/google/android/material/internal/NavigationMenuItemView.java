package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import defpackage.hk3;
import defpackage.hl2;
import defpackage.oi1;
import defpackage.ol;
import defpackage.sk2;
import defpackage.wp4;
import defpackage.ye;
import defpackage.za2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends oi1 implements hl2 {
    public static final int[] a1 = {R.attr.state_checked};
    public int P0;
    public boolean Q0;
    public boolean R0;
    public boolean S0;
    public final CheckedTextView T0;
    public FrameLayout U0;
    public sk2 V0;
    public ColorStateList W0;
    public boolean X0;
    public Drawable Y0;
    public final ol Z0;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S0 = true;
        ol olVar = new ol(4, this);
        this.Z0 = olVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.getsurfboard.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.getsurfboard.R.id.design_menu_item_text);
        this.T0 = checkedTextView;
        wp4.n(checkedTextView, olVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.U0 == null) {
                this.U0 = (FrameLayout) ((ViewStub) findViewById(com.getsurfboard.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.U0.removeAllViews();
            this.U0.addView(view);
        }
    }

    @Override // defpackage.hl2
    public final void c(sk2 sk2Var) {
        StateListDrawable stateListDrawable;
        this.V0 = sk2Var;
        int i = sk2Var.a;
        if (i > 0) {
            setId(i);
        }
        setVisibility(sk2Var.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(com.getsurfboard.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(a1, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(sk2Var.isCheckable());
        setChecked(sk2Var.isChecked());
        setEnabled(sk2Var.isEnabled());
        setTitle(sk2Var.e);
        setIcon(sk2Var.getIcon());
        setActionView(sk2Var.getActionView());
        setContentDescription(sk2Var.q);
        ye.H(this, sk2Var.r);
        sk2 sk2Var2 = this.V0;
        CharSequence charSequence = sk2Var2.e;
        CheckedTextView checkedTextView = this.T0;
        if (charSequence == null && sk2Var2.getIcon() == null && this.V0.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.U0;
            if (frameLayout != null) {
                za2 za2Var = (za2) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) za2Var).width = -1;
                this.U0.setLayoutParams(za2Var);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.U0;
        if (frameLayout2 != null) {
            za2 za2Var2 = (za2) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) za2Var2).width = -2;
            this.U0.setLayoutParams(za2Var2);
        }
    }

    @Override // defpackage.hl2
    public sk2 getItemData() {
        return this.V0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        sk2 sk2Var = this.V0;
        if (sk2Var != null && sk2Var.isCheckable() && this.V0.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, a1);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.R0 != z) {
            this.R0 = z;
            this.Z0.h(this.T0, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.T0;
        checkedTextView.setChecked(z);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z && this.S0) ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.X0) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.W0);
            }
            int i = this.P0;
            drawable.setBounds(0, 0, i, i);
        } else if (this.Q0) {
            if (this.Y0 == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = hk3.a;
                Drawable drawable2 = resources.getDrawable(com.getsurfboard.R.drawable.navigation_empty_icon, theme);
                this.Y0 = drawable2;
                if (drawable2 != null) {
                    int i2 = this.P0;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.Y0;
        }
        this.T0.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.T0.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.P0 = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.W0 = colorStateList;
        this.X0 = colorStateList != null;
        sk2 sk2Var = this.V0;
        if (sk2Var != null) {
            setIcon(sk2Var.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.T0.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.Q0 = z;
    }

    public void setTextAppearance(int i) {
        this.T0.setTextAppearance(i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.T0.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.T0.setText(charSequence);
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }
}
