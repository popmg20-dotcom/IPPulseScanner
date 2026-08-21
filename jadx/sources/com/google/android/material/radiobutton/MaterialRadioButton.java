package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import defpackage.co4;
import defpackage.fx3;
import defpackage.l72;
import defpackage.mb;
import defpackage.n12;
import defpackage.rc3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialRadioButton extends mb {
    public static final int[][] A0 = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList y0;
    public boolean z0;

    public MaterialRadioButton(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, com.getsurfboard.R.attr.radioButtonStyle, com.getsurfboard.R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayV = fx3.v(context2, attributeSet, rc3.y, com.getsurfboard.R.attr.radioButtonStyle, com.getsurfboard.R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayV.hasValue(0)) {
            setButtonTintList(l72.r(context2, typedArrayV, 0));
        }
        this.z0 = typedArrayV.getBoolean(1, false);
        typedArrayV.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        ColorStateList colorStateList = this.y0;
        if (colorStateList != null) {
            return colorStateList;
        }
        int iA = n12.A(this, com.getsurfboard.R.attr.colorControlActivated);
        int iA2 = n12.A(this, com.getsurfboard.R.attr.colorOnSurface);
        int iA3 = n12.A(this, com.getsurfboard.R.attr.colorSurface);
        ColorStateList colorStateList2 = new ColorStateList(A0, new int[]{n12.I(iA3, 1.0f, iA), n12.I(iA3, 0.54f, iA2), n12.I(iA3, 0.38f, iA2), n12.I(iA3, 0.38f, iA2)});
        this.y0 = colorStateList2;
        return colorStateList2;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.z0 && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.z0 = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    public MaterialRadioButton(Context context) {
        this(context, null);
    }
}
