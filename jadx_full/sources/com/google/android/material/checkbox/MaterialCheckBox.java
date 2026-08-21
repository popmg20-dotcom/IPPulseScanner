package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import com.getsurfboard.R;
import defpackage.cl;
import defpackage.co4;
import defpackage.d3;
import defpackage.dw2;
import defpackage.e8;
import defpackage.ek0;
import defpackage.fa;
import defpackage.fx3;
import defpackage.hk3;
import defpackage.l72;
import defpackage.m8;
import defpackage.mi2;
import defpackage.n02;
import defpackage.n12;
import defpackage.n8;
import defpackage.o8;
import defpackage.rc3;
import defpackage.tj4;
import defpackage.v9;
import defpackage.vo;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialCheckBox extends fa {
    public static final int[] S0 = {R.attr.state_indeterminate};
    public static final int[] T0 = {R.attr.state_error};
    public static final int[][] U0 = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public static final int V0 = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public ColorStateList A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public CharSequence E0;
    public Drawable F0;
    public Drawable G0;
    public boolean H0;
    public ColorStateList I0;
    public ColorStateList J0;
    public PorterDuff.Mode K0;
    public int L0;
    public int[] M0;
    public boolean N0;
    public CharSequence O0;
    public CompoundButton.OnCheckedChangeListener P0;
    public final o8 Q0;
    public final cl R0;
    public final LinkedHashSet y0;
    public final LinkedHashSet z0;

    public MaterialCheckBox(Context context, AttributeSet attributeSet) throws Throwable {
        o8 o8Var;
        int next;
        super(co4.d0(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, R.attr.checkboxStyle);
        this.y0 = new LinkedHashSet();
        this.z0 = new LinkedHashSet();
        Context context2 = getContext();
        if (Build.VERSION.SDK_INT >= 24) {
            o8Var = new o8(context2, 0);
            Resources resources = context2.getResources();
            Resources.Theme theme = context2.getTheme();
            ThreadLocal threadLocal = hk3.a;
            Drawable drawable = resources.getDrawable(R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
            o8Var.b = drawable;
            drawable.setCallback(o8Var.Y);
            new n8(o8Var.b.getConstantState());
        } else {
            int i = o8.Z;
            try {
                XmlResourceParser xml = context2.getResources().getXml(R.drawable.mtrl_checkbox_button_checked_unchecked);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                Resources resources2 = context2.getResources();
                Resources.Theme theme2 = context2.getTheme();
                o8 o8Var2 = new o8(context2, 0);
                o8Var2.inflate(resources2, xml, attributeSetAsAttributeSet, theme2);
                o8Var = o8Var2;
            } catch (IOException e) {
                a1.e("AnimatedVDCompat", "parser error", e);
                o8Var = null;
            } catch (XmlPullParserException e2) {
                a1.e("AnimatedVDCompat", "parser error", e2);
                o8Var = null;
            }
        }
        this.Q0 = o8Var;
        this.R0 = new cl(this, 2);
        Context context3 = getContext();
        this.F0 = getButtonDrawable();
        this.I0 = getSuperButtonTintList();
        setSupportButtonTintList(null);
        n02 n02VarW = fx3.w(context3, attributeSet, rc3.w, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TypedArray typedArray = (TypedArray) n02VarW.z;
        this.G0 = n02VarW.o(2);
        if (this.F0 != null && ek0.B(context3, R.attr.isMaterial3Theme, false)) {
            int resourceId = typedArray.getResourceId(0, 0);
            int resourceId2 = typedArray.getResourceId(1, 0);
            if (resourceId == V0 && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.F0 = vo.r(context3, R.drawable.mtrl_checkbox_button);
                this.H0 = true;
                if (this.G0 == null) {
                    this.G0 = vo.r(context3, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.J0 = l72.q(context3, n02VarW, 3);
        this.K0 = tj4.V(typedArray.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.B0 = typedArray.getBoolean(10, false);
        this.C0 = typedArray.getBoolean(6, true);
        this.D0 = typedArray.getBoolean(9, false);
        this.E0 = typedArray.getText(8);
        if (typedArray.hasValue(7)) {
            setCheckedState(typedArray.getInt(7, 0));
        }
        n02VarW.K();
        a();
    }

    private String getButtonStateDescription() {
        int i = this.L0;
        return i == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        ColorStateList colorStateList = this.A0;
        if (colorStateList != null) {
            return colorStateList;
        }
        int iA = n12.A(this, R.attr.colorControlActivated);
        int iA2 = n12.A(this, R.attr.colorError);
        int iA3 = n12.A(this, R.attr.colorSurface);
        int iA4 = n12.A(this, R.attr.colorOnSurface);
        ColorStateList colorStateList2 = new ColorStateList(U0, new int[]{n12.I(iA3, 1.0f, iA2), n12.I(iA3, 1.0f, iA), n12.I(iA3, 0.54f, iA4), n12.I(iA3, 0.38f, iA4), n12.I(iA3, 0.38f, iA4)});
        this.A0 = colorStateList2;
        return colorStateList2;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.I0;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        d3 d3Var;
        this.F0 = v9.d(this.F0, this.I0, getButtonTintMode());
        this.G0 = v9.d(this.G0, this.J0, this.K0);
        if (this.H0) {
            o8 o8Var = this.Q0;
            if (o8Var != null) {
                m8 m8Var = o8Var.f;
                Drawable drawable = o8Var.b;
                cl clVar = this.R0;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    e8 e8Var = clVar.a;
                    if (e8Var == null) {
                        e8Var = new e8(clVar);
                        clVar.a = e8Var;
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(e8Var);
                }
                ArrayList arrayList = o8Var.X;
                if (arrayList != null && clVar != null) {
                    arrayList.remove(clVar);
                    if (o8Var.X.size() == 0 && (d3Var = o8Var.A) != null) {
                        m8Var.b.removeListener(d3Var);
                        o8Var.A = null;
                    }
                }
                Drawable drawable2 = o8Var.b;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    e8 e8Var2 = clVar.a;
                    if (e8Var2 == null) {
                        e8Var2 = new e8(clVar);
                        clVar.a = e8Var2;
                    }
                    animatedVectorDrawable2.registerAnimationCallback(e8Var2);
                } else if (clVar != null) {
                    ArrayList arrayList2 = o8Var.X;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        o8Var.X = arrayList2;
                    }
                    if (!arrayList2.contains(clVar)) {
                        o8Var.X.add(clVar);
                        d3 d3Var2 = o8Var.A;
                        if (d3Var2 == null) {
                            d3Var2 = new d3(2, o8Var);
                            o8Var.A = d3Var2;
                        }
                        m8Var.b.addListener(d3Var2);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable3 = this.F0;
                if ((drawable3 instanceof AnimatedStateListDrawable) && o8Var != null) {
                    ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, o8Var, false);
                    ((AnimatedStateListDrawable) this.F0).addTransition(R.id.indeterminate, R.id.unchecked, o8Var, false);
                }
            }
        }
        Drawable drawable4 = this.F0;
        if (drawable4 != null && (colorStateList2 = this.I0) != null) {
            drawable4.setTintList(colorStateList2);
        }
        Drawable drawable5 = this.G0;
        if (drawable5 != null && (colorStateList = this.J0) != null) {
            drawable5.setTintList(colorStateList);
        }
        super.setButtonDrawable(v9.b(this.F0, this.G0, -1, -1));
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.F0;
    }

    public Drawable getButtonIconDrawable() {
        return this.G0;
    }

    public ColorStateList getButtonIconTintList() {
        return this.J0;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.K0;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.I0;
    }

    public int getCheckedState() {
        return this.L0;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.E0;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.L0 == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.B0 && this.I0 == null && this.J0 == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, S0);
        }
        if (this.D0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, T0);
        }
        this.M0 = v9.f(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.C0 || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (getLayoutDirection() == 1 ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.D0) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.E0));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof mi2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        mi2 mi2Var = (mi2) parcelable;
        super.onRestoreInstanceState(mi2Var.getSuperState());
        setCheckedState(mi2Var.b);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        mi2 mi2Var = new mi2(super.onSaveInstanceState());
        mi2Var.b = getCheckedState();
        return mi2Var;
    }

    @Override // defpackage.fa, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(vo.r(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.G0 = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(vo.r(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.J0 == colorStateList) {
            return;
        }
        this.J0 = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.K0 == mode) {
            return;
        }
        this.K0 = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.I0 == colorStateList) {
            return;
        }
        this.I0 = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.C0 = z;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedState(z ? 1 : 0);
    }

    public void setCheckedState(int i) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.L0 != i) {
            this.L0 = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && this.O0 == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.N0) {
                return;
            }
            this.N0 = true;
            LinkedHashSet linkedHashSet = this.z0;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw dw2.z(it);
                }
            }
            if (this.L0 != 2 && (onCheckedChangeListener = this.P0) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i2 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.N0 = false;
        }
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.E0 = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z) {
        if (this.D0 == z) {
            return;
        }
        this.D0 = z;
        refreshDrawableState();
        Iterator it = this.y0.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.P0 = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.O0 = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.B0 = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // defpackage.fa, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.F0 = drawable;
        this.H0 = false;
        a();
    }

    public MaterialCheckBox(Context context) {
        this(context, null);
    }
}
