package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.co4;
import defpackage.ek0;
import defpackage.l72;
import defpackage.rc3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, R.attr.textViewStyle, 0), attributeSet, R.attr.textViewStyle);
        Context context2 = getContext();
        if (ek0.B(context2, com.getsurfboard.R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = rc3.D;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
            int[] iArr2 = {1, 2};
            int iS = -1;
            for (int i = 0; i < 2 && iS < 0; i++) {
                iS = l72.s(context2, typedArrayObtainStyledAttributes, iArr2[i], -1);
            }
            typedArrayObtainStyledAttributes.recycle();
            if (iS != -1) {
                return;
            }
            TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
            int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
            typedArrayObtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, rc3.C);
                Context context3 = getContext();
                int[] iArr3 = {2, 4};
                int iS2 = -1;
                for (int i2 = 0; i2 < 2 && iS2 < 0; i2++) {
                    iS2 = l72.s(context3, typedArrayObtainStyledAttributes3, iArr3[i2], -1);
                }
                typedArrayObtainStyledAttributes3.recycle();
                if (iS2 >= 0) {
                    setLineHeight(iS2);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (ek0.B(context, com.getsurfboard.R.attr.textAppearanceLineHeightEnabled, true)) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, rc3.C);
            Context context2 = getContext();
            int[] iArr = {2, 4};
            int iS = -1;
            for (int i2 = 0; i2 < 2 && iS < 0; i2++) {
                iS = l72.s(context2, typedArrayObtainStyledAttributes, iArr[i2], -1);
            }
            typedArrayObtainStyledAttributes.recycle();
            if (iS >= 0) {
                setLineHeight(iS);
            }
        }
    }

    public MaterialTextView(Context context) {
        this(context, null);
    }
}
