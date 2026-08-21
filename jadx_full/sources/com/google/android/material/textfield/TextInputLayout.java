package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.internal.CheckableImageButton;
import defpackage.a0;
import defpackage.ah4;
import defpackage.cm3;
import defpackage.co4;
import defpackage.cp1;
import defpackage.db;
import defpackage.e04;
import defpackage.ek0;
import defpackage.f33;
import defpackage.fw;
import defpackage.fx3;
import defpackage.g24;
import defpackage.ga1;
import defpackage.io;
import defpackage.k01;
import defpackage.kb4;
import defpackage.l72;
import defpackage.mb4;
import defpackage.n02;
import defpackage.n12;
import defpackage.o73;
import defpackage.ou3;
import defpackage.po0;
import defpackage.qy1;
import defpackage.rc3;
import defpackage.sn;
import defpackage.sq2;
import defpackage.st4;
import defpackage.t8;
import defpackage.tx0;
import defpackage.u24;
import defpackage.u70;
import defpackage.uf2;
import defpackage.uy0;
import defpackage.v02;
import defpackage.v41;
import defpackage.v60;
import defpackage.v9;
import defpackage.vg0;
import defpackage.vo;
import defpackage.vz1;
import defpackage.wb4;
import defpackage.wg0;
import defpackage.wi2;
import defpackage.wp4;
import defpackage.x00;
import defpackage.x41;
import defpackage.xa1;
import defpackage.xb4;
import defpackage.xe;
import defpackage.xg0;
import defpackage.xm;
import defpackage.yb4;
import defpackage.ye0;
import defpackage.yi2;
import defpackage.zb4;
import defpackage.zo2;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] U1 = {new int[]{R.attr.state_pressed}, new int[0]};
    public final int A;
    public int A0;
    public ColorStateList A1;
    public int B0;
    public ColorStateList B1;
    public int C0;
    public int C1;
    public int D0;
    public int D1;
    public final vz1 E0;
    public int E1;
    public boolean F0;
    public ColorStateList F1;
    public int G0;
    public int G1;
    public boolean H0;
    public int H1;
    public yb4 I0;
    public int I1;
    public AppCompatTextView J0;
    public int J1;
    public int K0;
    public int K1;
    public int L0;
    public int L1;
    public CharSequence M0;
    public boolean M1;
    public boolean N0;
    public final v60 N1;
    public AppCompatTextView O0;
    public boolean O1;
    public ColorStateList P0;
    public boolean P1;
    public int Q0;
    public ValueAnimator Q1;
    public xa1 R0;
    public boolean R1;
    public xa1 S0;
    public boolean S1;
    public ColorStateList T0;
    public boolean T1;
    public ColorStateList U0;
    public ColorStateList V0;
    public ColorStateList W0;
    public boolean X0;
    public CharSequence Y0;
    public boolean Z0;
    public yi2 a1;
    public final FrameLayout b;
    public yi2 b1;
    public StateListDrawable c1;
    public boolean d1;
    public yi2 e1;
    public final g24 f;
    public yi2 f1;
    public ou3 g1;
    public boolean h1;
    public final int i1;
    public int j1;
    public int k1;
    public int l1;
    public int m1;
    public int n1;
    public int o1;
    public int p1;
    public final Rect q1;
    public final Rect r1;
    public final RectF s1;
    public Typeface t1;
    public ColorDrawable u1;
    public int v1;
    public final LinkedHashSet w1;
    public ColorDrawable x1;
    public EditText y0;
    public int y1;
    public final x41 z;
    public CharSequence z0;
    public Drawable z1;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, com.getsurfboard.R.attr.textInputStyle, com.getsurfboard.R.style.Widget_Design_TextInputLayout), attributeSet, com.getsurfboard.R.attr.textInputStyle);
        this.A0 = -1;
        this.B0 = -1;
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = new vz1(this);
        this.I0 = new e04(10);
        this.q1 = new Rect();
        this.r1 = new Rect();
        this.s1 = new RectF();
        this.w1 = new LinkedHashSet();
        v60 v60Var = new v60(this);
        this.N1 = v60Var;
        this.T1 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = t8.a;
        v60Var.R = linearInterpolator;
        v60Var.j(false);
        v60Var.Q = linearInterpolator;
        v60Var.j(false);
        if (v60Var.g != 8388659) {
            v60Var.g = 8388659;
            v60Var.j(false);
        }
        n02 n02VarW = fx3.w(context2, attributeSet, rc3.Q, com.getsurfboard.R.attr.textInputStyle, com.getsurfboard.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        g24 g24Var = new g24(this, n02VarW);
        this.f = g24Var;
        TypedArray typedArray = (TypedArray) n02VarW.z;
        this.X0 = typedArray.getBoolean(48, true);
        setHint(typedArray.getText(4));
        this.P1 = typedArray.getBoolean(47, true);
        this.O1 = typedArray.getBoolean(42, true);
        if (typedArray.hasValue(6)) {
            setMinEms(typedArray.getInt(6, -1));
        } else if (typedArray.hasValue(3)) {
            setMinWidth(typedArray.getDimensionPixelSize(3, -1));
        }
        if (typedArray.hasValue(5)) {
            setMaxEms(typedArray.getInt(5, -1));
        } else if (typedArray.hasValue(2)) {
            setMaxWidth(typedArray.getDimensionPixelSize(2, -1));
        }
        this.g1 = ou3.h(context2, attributeSet, com.getsurfboard.R.attr.textInputStyle, com.getsurfboard.R.style.Widget_Design_TextInputLayout).b();
        this.i1 = context2.getResources().getDimensionPixelOffset(com.getsurfboard.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.k1 = typedArray.getDimensionPixelOffset(9, 0);
        this.A = getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.m1 = typedArray.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.n1 = typedArray.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.l1 = this.m1;
        float dimension = typedArray.getDimension(13, -1.0f);
        float dimension2 = typedArray.getDimension(12, -1.0f);
        float dimension3 = typedArray.getDimension(10, -1.0f);
        float dimension4 = typedArray.getDimension(11, -1.0f);
        qy1 qy1VarL = this.g1.l();
        if (dimension >= 0.0f) {
            qy1VarL.e = new a0(dimension);
        }
        if (dimension2 >= 0.0f) {
            qy1VarL.f = new a0(dimension2);
        }
        if (dimension3 >= 0.0f) {
            qy1VarL.g = new a0(dimension3);
        }
        if (dimension4 >= 0.0f) {
            qy1VarL.h = new a0(dimension4);
        }
        this.g1 = qy1VarL.b();
        ColorStateList colorStateListQ = l72.q(context2, n02VarW, 7);
        if (colorStateListQ != null) {
            int defaultColor = colorStateListQ.getDefaultColor();
            this.G1 = defaultColor;
            this.p1 = defaultColor;
            if (colorStateListQ.isStateful()) {
                this.H1 = colorStateListQ.getColorForState(new int[]{-16842910}, -1);
                this.I1 = colorStateListQ.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.J1 = colorStateListQ.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.I1 = this.G1;
                ColorStateList colorStateListG = v9.g(context2, com.getsurfboard.R.color.mtrl_filled_background_color);
                this.H1 = colorStateListG.getColorForState(new int[]{-16842910}, -1);
                this.J1 = colorStateListG.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.p1 = 0;
            this.G1 = 0;
            this.H1 = 0;
            this.I1 = 0;
            this.J1 = 0;
        }
        if (typedArray.hasValue(1)) {
            ColorStateList colorStateListN = n02VarW.n(1);
            this.B1 = colorStateListN;
            this.A1 = colorStateListN;
        }
        ColorStateList colorStateListQ2 = l72.q(context2, n02VarW, 14);
        this.E1 = typedArray.getColor(14, 0);
        this.C1 = context2.getColor(com.getsurfboard.R.color.mtrl_textinput_default_box_stroke_color);
        this.K1 = context2.getColor(com.getsurfboard.R.color.mtrl_textinput_disabled_color);
        this.D1 = context2.getColor(com.getsurfboard.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListQ2 != null) {
            setBoxStrokeColorStateList(colorStateListQ2);
        }
        if (typedArray.hasValue(15)) {
            setBoxStrokeErrorColor(l72.q(context2, n02VarW, 15));
        }
        if (typedArray.getResourceId(50, -1) != -1) {
            setHintTextAppearance(typedArray.getResourceId(50, 0));
        }
        this.V0 = n02VarW.n(24);
        this.W0 = n02VarW.n(25);
        int resourceId = typedArray.getResourceId(40, 0);
        CharSequence text = typedArray.getText(35);
        int i = typedArray.getInt(34, 1);
        boolean z = typedArray.getBoolean(36, false);
        int resourceId2 = typedArray.getResourceId(45, 0);
        boolean z2 = typedArray.getBoolean(44, false);
        CharSequence text2 = typedArray.getText(43);
        int resourceId3 = typedArray.getResourceId(58, 0);
        CharSequence text3 = typedArray.getText(57);
        boolean z3 = typedArray.getBoolean(18, false);
        setCounterMaxLength(typedArray.getInt(19, -1));
        this.L0 = typedArray.getResourceId(22, 0);
        this.K0 = typedArray.getResourceId(20, 0);
        setBoxBackgroundMode(typedArray.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i);
        setCounterOverflowTextAppearance(this.K0);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.L0);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArray.hasValue(41)) {
            setErrorTextColor(n02VarW.n(41));
        }
        if (typedArray.hasValue(46)) {
            setHelperTextColor(n02VarW.n(46));
        }
        if (typedArray.hasValue(51)) {
            setHintTextColor(n02VarW.n(51));
        }
        if (typedArray.hasValue(23)) {
            setCounterTextColor(n02VarW.n(23));
        }
        if (typedArray.hasValue(21)) {
            setCounterOverflowTextColor(n02VarW.n(21));
        }
        if (typedArray.hasValue(59)) {
            setPlaceholderTextColor(n02VarW.n(59));
        }
        x41 x41Var = new x41(this, n02VarW);
        this.z = x41Var;
        boolean z4 = typedArray.getBoolean(0, true);
        setHintMaxLines(typedArray.getInt(49, 1));
        n02VarW.K();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(g24Var);
        frameLayout.addView(x41Var);
        addView(frameLayout);
        setEnabled(z4);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.y0;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.a1;
        }
        int iA = n12.A(this.y0, com.getsurfboard.R.attr.colorControlHighlight);
        int i = this.j1;
        int[][] iArr = U1;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            yi2 yi2Var = this.a1;
            int i2 = this.p1;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{n12.I(iA, 0.1f, i2), i2}), yi2Var, yi2Var);
        }
        Context context = getContext();
        yi2 yi2Var2 = this.a1;
        TypedValue typedValueA = ek0.A(context, com.getsurfboard.R.attr.colorSurface);
        if (typedValueA == null) {
            zo2.p("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{"TextInputLayout", context.getResources().getResourceName(com.getsurfboard.R.attr.colorSurface)});
            return null;
        }
        int i3 = typedValueA.resourceId;
        int color = i3 != 0 ? context.getColor(i3) : typedValueA.data;
        yi2 yi2Var3 = new yi2(yi2Var2.getShapeAppearanceModel());
        int I = n12.I(iA, 0.1f, color);
        yi2Var3.p(new ColorStateList(iArr, new int[]{I, 0}));
        yi2Var3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{I, color});
        yi2 yi2Var4 = new yi2(yi2Var2.getShapeAppearanceModel());
        yi2Var4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, yi2Var3, yi2Var4), yi2Var2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.c1 == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.c1 = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.c1.addState(new int[0], h(false));
        }
        return this.c1;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        yi2 yi2Var = this.b1;
        if (yi2Var != null) {
            return yi2Var;
        }
        yi2 yi2VarH = h(true);
        this.b1 = yi2VarH;
        return yi2VarH;
    }

    public static void m(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.y0 != null) {
            xe.k("We already have an EditText, can only have one");
            return;
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.y0 = editText;
        int i = this.A0;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.C0);
        }
        int i2 = this.B0;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.D0);
        }
        this.d1 = false;
        k();
        setTextInputAccessibilityDelegate(new xb4(this));
        Typeface typeface = this.y0.getTypeface();
        v60 v60Var = this.N1;
        v60Var.n(typeface);
        float textSize = this.y0.getTextSize();
        if (v60Var.h != textSize) {
            v60Var.h = textSize;
            v60Var.j(false);
        }
        float letterSpacing = this.y0.getLetterSpacing();
        if (v60Var.X != letterSpacing) {
            v60Var.X = letterSpacing;
            v60Var.j(false);
        }
        int gravity = this.y0.getGravity();
        int i3 = (gravity & (-113)) | 48;
        if (v60Var.g != i3) {
            v60Var.g = i3;
            v60Var.j(false);
        }
        if (v60Var.f != gravity) {
            v60Var.f = gravity;
            v60Var.j(false);
        }
        this.L1 = editText.getMinimumHeight();
        this.y0.addTextChangedListener(new wb4(this, editText));
        if (this.A1 == null) {
            this.A1 = this.y0.getHintTextColors();
        }
        if (this.X0) {
            if (TextUtils.isEmpty(this.Y0)) {
                CharSequence hint = this.y0.getHint();
                this.z0 = hint;
                setHint(hint);
                this.y0.setHint((CharSequence) null);
            }
            this.Z0 = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        if (this.J0 != null) {
            p(this.y0.getText());
        }
        t();
        this.E0.b();
        this.f.bringToFront();
        x41 x41Var = this.z;
        x41Var.bringToFront();
        Iterator it = this.w1.iterator();
        while (it.hasNext()) {
            ((v41) it.next()).a(this);
        }
        x41Var.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.Y0)) {
            return;
        }
        this.Y0 = charSequence;
        v60 v60Var = this.N1;
        if (charSequence == null || !TextUtils.equals(v60Var.B, charSequence)) {
            v60Var.B = charSequence;
            v60Var.C = null;
            v60Var.j(false);
        }
        if (this.M1) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.N0 == z) {
            return;
        }
        AppCompatTextView appCompatTextView = this.O0;
        if (!z) {
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(8);
            }
            this.O0 = null;
        } else if (appCompatTextView != null) {
            this.b.addView(appCompatTextView);
            this.O0.setVisibility(0);
        }
        this.N0 = z;
    }

    public final void a() {
        if (this.y0 == null || this.j1 != 1) {
            return;
        }
        if (getHintMaxLines() != 1) {
            EditText editText = this.y0;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.N1.f() + this.A), this.y0.getPaddingEnd(), getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
            EditText editText2 = this.y0;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.material_filled_edittext_font_2_0_padding_top), this.y0.getPaddingEnd(), getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (l72.K(getContext())) {
            EditText editText3 = this.y0;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.material_filled_edittext_font_1_3_padding_top), this.y0.getPaddingEnd(), getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.b;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f) {
        v60 v60Var = this.N1;
        if (v60Var.b == f) {
            return;
        }
        if (this.Q1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.Q1 = valueAnimator;
            valueAnimator.setInterpolator(l72.W(getContext(), com.getsurfboard.R.attr.motionEasingEmphasizedInterpolator, t8.b));
            this.Q1.setDuration(ek0.C(getContext(), com.getsurfboard.R.attr.motionDurationMedium4, 167));
            this.Q1.addUpdateListener(new io(6, this));
        }
        this.Q1.setFloatValues(v60Var.b, f);
        this.Q1.start();
    }

    public final void c() {
        int i;
        int i2;
        yi2 yi2Var = this.a1;
        if (yi2Var == null) {
            return;
        }
        ou3 shapeAppearanceModel = yi2Var.getShapeAppearanceModel();
        ou3 ou3Var = this.g1;
        if (shapeAppearanceModel != ou3Var) {
            this.a1.setShapeAppearanceModel(ou3Var);
        }
        if (this.j1 == 2 && (i = this.l1) > -1 && (i2 = this.o1) != 0) {
            yi2 yi2Var2 = this.a1;
            yi2Var2.f.j = i;
            yi2Var2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i2);
            wi2 wi2Var = yi2Var2.f;
            if (wi2Var.d != colorStateListValueOf) {
                wi2Var.d = colorStateListValueOf;
                yi2Var2.onStateChange(yi2Var2.getState());
            }
        }
        int iC = this.p1;
        if (this.j1 == 1) {
            iC = u70.c(this.p1, n12.z(getContext(), com.getsurfboard.R.attr.colorSurface, 0));
        }
        this.p1 = iC;
        this.a1.p(ColorStateList.valueOf(iC));
        yi2 yi2Var3 = this.e1;
        if (yi2Var3 != null && this.f1 != null) {
            if (this.l1 > -1 && this.o1 != 0) {
                yi2Var3.p(this.y0.isFocused() ? ColorStateList.valueOf(this.C1) : ColorStateList.valueOf(this.o1));
                this.f1.p(ColorStateList.valueOf(this.o1));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.y0 == null) {
            st4.g();
            return null;
        }
        boolean z = getLayoutDirection() == 1;
        int i = rect.bottom;
        Rect rect2 = this.r1;
        rect2.bottom = i;
        int i2 = this.j1;
        if (i2 == 1) {
            rect2.left = i(rect.left, z);
            rect2.top = rect.top + this.k1;
            rect2.right = j(rect.right, z);
            return rect2;
        }
        int i3 = rect.left;
        if (i2 != 2) {
            rect2.left = i(i3, z);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z);
            return rect2;
        }
        rect2.left = this.y0.getPaddingLeft() + i3;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.y0.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.y0;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.z0 != null) {
            boolean z = this.Z0;
            this.Z0 = false;
            CharSequence hint = editText.getHint();
            this.y0.setHint(this.z0);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.y0.setHint(hint);
                this.Z0 = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.b;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
            View childAt = frameLayout.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.y0) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.S1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.S1 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        yi2 yi2Var;
        super.draw(canvas);
        boolean z = this.X0;
        v60 v60Var = this.N1;
        if (z) {
            TextPaint textPaint = v60Var.O;
            RectF rectF = v60Var.e;
            int iSave = canvas.save();
            if (v60Var.C != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(v60Var.G);
                float f = v60Var.q;
                float f2 = v60Var.r;
                float f3 = v60Var.F;
                if (f3 != 1.0f) {
                    canvas.scale(f3, f3, f, f2);
                }
                if ((v60Var.e0 > 1 || v60Var.f0 > 1) && !v60Var.D && v60Var.o()) {
                    float lineStart = v60Var.q - v60Var.Z.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas.translate(lineStart, f2);
                    float f4 = alpha;
                    textPaint.setAlpha((int) (v60Var.c0 * f4));
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 31) {
                        textPaint.setShadowLayer(v60Var.H, v60Var.I, v60Var.J, n12.n(v60Var.K, textPaint.getAlpha()));
                    }
                    v60Var.Z.draw(canvas);
                    textPaint.setAlpha((int) (v60Var.b0 * f4));
                    if (i >= 31) {
                        textPaint.setShadowLayer(v60Var.H, v60Var.I, v60Var.J, n12.n(v60Var.K, textPaint.getAlpha()));
                    }
                    int lineBaseline = v60Var.Z.getLineBaseline(0);
                    CharSequence charSequence = v60Var.d0;
                    float f5 = lineBaseline;
                    canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, textPaint);
                    if (i >= 31) {
                        textPaint.setShadowLayer(v60Var.H, v60Var.I, v60Var.J, v60Var.K);
                    }
                    String strTrim = v60Var.d0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas.drawText(str, 0, Math.min(v60Var.Z.getLineEnd(0), str.length()), 0.0f, f5, (Paint) textPaint);
                    canvas = canvas;
                } else {
                    canvas.translate(f, f2);
                    v60Var.Z.draw(canvas);
                }
                canvas.restoreToCount(iSave);
            }
        }
        if (this.f1 == null || (yi2Var = this.e1) == null) {
            return;
        }
        yi2Var.draw(canvas);
        if (this.y0.isFocused()) {
            Rect bounds = this.f1.getBounds();
            Rect bounds2 = this.e1.getBounds();
            float f6 = v60Var.b;
            int iCenterX = bounds2.centerX();
            bounds.left = t8.c(iCenterX, f6, bounds2.left);
            bounds.right = t8.c(iCenterX, f6, bounds2.right);
            this.f1.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void drawableStateChanged() {
        boolean z;
        ColorStateList colorStateList;
        if (this.R1) {
            return;
        }
        this.R1 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        v60 v60Var = this.N1;
        if (v60Var != null) {
            v60Var.M = drawableState;
            ColorStateList colorStateList2 = v60Var.k;
            if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = v60Var.j) == null || !colorStateList.isStateful())) {
                z = false;
            } else {
                v60Var.j(false);
                z = true;
            }
        }
        if (this.y0 != null) {
            w(isLaidOut() && isEnabled(), false);
        }
        t();
        z();
        if (z) {
            invalidate();
        }
        this.R1 = false;
    }

    public final int e() {
        if (this.X0) {
            int i = this.j1;
            v60 v60Var = this.N1;
            if (i == 0) {
                return (int) v60Var.f();
            }
            if (i == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (v60Var.f() / 2.0f);
                }
                float f = v60Var.f();
                TextPaint textPaint = v60Var.P;
                textPaint.setTextSize(v60Var.i);
                textPaint.setTypeface(v60Var.s);
                textPaint.setLetterSpacing(v60Var.W);
                return Math.max(0, (int) (f - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final xa1 f() {
        xa1 xa1Var = new xa1();
        xa1Var.z = ek0.C(getContext(), com.getsurfboard.R.attr.motionDurationShort2, 87);
        xa1Var.A = l72.W(getContext(), com.getsurfboard.R.attr.motionEasingLinearInterpolator, t8.a);
        return xa1Var;
    }

    public final boolean g() {
        return this.X0 && !TextUtils.isEmpty(this.Y0) && (this.a1 instanceof xg0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.y0;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    public yi2 getBoxBackground() {
        int i = this.j1;
        if (i == 1 || i == 2) {
            return this.a1;
        }
        st4.g();
        return null;
    }

    public int getBoxBackgroundColor() {
        return this.p1;
    }

    public int getBoxBackgroundMode() {
        return this.j1;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.k1;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        ou3 ou3Var = this.g1;
        RectF rectF = this.s1;
        return layoutDirection == 1 ? ou3Var.h.a(rectF) : ou3Var.g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        ou3 ou3Var = this.g1;
        RectF rectF = this.s1;
        return layoutDirection == 1 ? ou3Var.g.a(rectF) : ou3Var.h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        ou3 ou3Var = this.g1;
        RectF rectF = this.s1;
        return layoutDirection == 1 ? ou3Var.e.a(rectF) : ou3Var.f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        ou3 ou3Var = this.g1;
        RectF rectF = this.s1;
        return layoutDirection == 1 ? ou3Var.f.a(rectF) : ou3Var.e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.E1;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.F1;
    }

    public int getBoxStrokeWidth() {
        return this.m1;
    }

    public int getBoxStrokeWidthFocused() {
        return this.n1;
    }

    public int getCounterMaxLength() {
        return this.G0;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.F0 && this.H0 && (appCompatTextView = this.J0) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.U0;
    }

    public ColorStateList getCounterTextColor() {
        return this.T0;
    }

    public ColorStateList getCursorColor() {
        return this.V0;
    }

    public ColorStateList getCursorErrorColor() {
        return this.W0;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.A1;
    }

    public EditText getEditText() {
        return this.y0;
    }

    public CharSequence getEndIconContentDescription() {
        return this.z.A0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.z.A0.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.z.G0;
    }

    public int getEndIconMode() {
        return this.z.C0;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.z.H0;
    }

    public CheckableImageButton getEndIconView() {
        return this.z.A0;
    }

    public CharSequence getError() {
        vz1 vz1Var = this.E0;
        if (vz1Var.q) {
            return vz1Var.p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.E0.t;
    }

    public CharSequence getErrorContentDescription() {
        return this.E0.s;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.E0.r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.z.z.getDrawable();
    }

    public CharSequence getHelperText() {
        vz1 vz1Var = this.E0;
        if (vz1Var.x) {
            return vz1Var.w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.E0.y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.X0) {
            return this.Y0;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.N1.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        v60 v60Var = this.N1;
        return v60Var.g(v60Var.k);
    }

    public int getHintMaxLines() {
        return this.N1.e0;
    }

    public ColorStateList getHintTextColor() {
        return this.B1;
    }

    public yb4 getLengthCounter() {
        return this.I0;
    }

    public int getMaxEms() {
        return this.B0;
    }

    public int getMaxWidth() {
        return this.D0;
    }

    public int getMinEms() {
        return this.A0;
    }

    public int getMinWidth() {
        return this.C0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.z.A0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.z.A0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.N0) {
            return this.M0;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.Q0;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.P0;
    }

    public CharSequence getPrefixText() {
        return this.f.z;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f.f.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f.f;
    }

    public ou3 getShapeAppearanceModel() {
        return this.g1;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f.A.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f.A.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f.A0;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f.B0;
    }

    public CharSequence getSuffixText() {
        return this.z.J0;
    }

    public ColorStateList getSuffixTextColor() {
        return this.z.K0.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.z.K0;
    }

    public Typeface getTypeface() {
        return this.t1;
    }

    public final yi2 h(boolean z) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(com.getsurfboard.R.dimen.mtrl_shape_corner_size_small_component);
        float f = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.y0;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : getResources().getDimensionPixelOffset(com.getsurfboard.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.getsurfboard.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        cm3 cm3Var = new cm3();
        cm3 cm3Var2 = new cm3();
        cm3 cm3Var3 = new cm3();
        cm3 cm3Var4 = new cm3();
        int i = 0;
        k01 k01Var = new k01(i);
        k01 k01Var2 = new k01(i);
        k01 k01Var3 = new k01(i);
        k01 k01Var4 = new k01(i);
        a0 a0Var = new a0(f);
        a0 a0Var2 = new a0(f);
        a0 a0Var3 = new a0(dimensionPixelOffset);
        a0 a0Var4 = new a0(dimensionPixelOffset);
        ou3 ou3Var = new ou3();
        ou3Var.a = cm3Var;
        ou3Var.b = cm3Var2;
        ou3Var.c = cm3Var3;
        ou3Var.d = cm3Var4;
        ou3Var.e = a0Var;
        ou3Var.f = a0Var2;
        ou3Var.g = a0Var4;
        ou3Var.h = a0Var3;
        ou3Var.i = k01Var;
        ou3Var.j = k01Var2;
        ou3Var.k = k01Var3;
        ou3Var.l = k01Var4;
        EditText editText2 = this.y0;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = yi2.W0;
            String simpleName = yi2.class.getSimpleName();
            TypedValue typedValueA = ek0.A(context, com.getsurfboard.R.attr.colorSurface);
            if (typedValueA == null) {
                zo2.p("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{simpleName, context.getResources().getResourceName(com.getsurfboard.R.attr.colorSurface)});
                return null;
            }
            int i2 = typedValueA.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i2 != 0 ? context.getColor(i2) : typedValueA.data);
        }
        yi2 yi2Var = new yi2();
        yi2Var.l(context);
        yi2Var.p(dropDownBackgroundTintList);
        yi2Var.o(popupElevation);
        yi2Var.setShapeAppearanceModel(ou3Var);
        wi2 wi2Var = yi2Var.f;
        if (wi2Var.g == null) {
            wi2Var.g = new Rect();
        }
        yi2Var.f.g.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        yi2Var.invalidateSelf();
        return yi2Var;
    }

    public final int i(int i, boolean z) {
        return ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.y0.getCompoundPaddingLeft() : this.z.b() : this.f.a()) + i;
    }

    public final int j(int i, boolean z) {
        return i - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.y0.getCompoundPaddingRight() : this.f.a() : this.z.b());
    }

    public final void k() {
        int i = this.j1;
        if (i == 0) {
            this.a1 = null;
            this.e1 = null;
            this.f1 = null;
        } else if (i == 1) {
            this.a1 = new yi2(this.g1);
            this.e1 = new yi2();
            this.f1 = new yi2();
        } else {
            if (i != 2) {
                xe.k(fw.w(" is illegal; only @BoxBackgroundMode constants are supported.", new StringBuilder(), this.j1));
                return;
            }
            if (!this.X0 || (this.a1 instanceof xg0)) {
                this.a1 = new yi2(this.g1);
            } else {
                ou3 ou3Var = this.g1;
                int i2 = xg0.Z0;
                if (ou3Var == null) {
                    ou3Var = new ou3();
                }
                vg0 vg0Var = new vg0(ou3Var, new RectF());
                wg0 wg0Var = new wg0(vg0Var);
                wg0Var.Y0 = vg0Var;
                this.a1 = wg0Var;
            }
            this.e1 = null;
            this.f1 = null;
        }
        u();
        z();
        if (this.j1 == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.k1 = getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (l72.K(getContext())) {
                this.k1 = getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.j1 != 0) {
            v();
        }
        EditText editText = this.y0;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i3 = this.j1;
                if (i3 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i3 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l() {
        float f;
        float f2;
        float f3;
        RectF rectF;
        float f4;
        int i;
        float f5;
        int i2;
        if (g()) {
            int width = this.y0.getWidth();
            int gravity = this.y0.getGravity();
            v60 v60Var = this.N1;
            boolean zC = v60Var.c(v60Var.B);
            v60Var.D = zC;
            Rect rect = v60Var.d;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (zC) {
                        i2 = rect.left;
                        f3 = i2;
                    } else {
                        f = rect.right;
                        f2 = v60Var.a0;
                    }
                } else if (zC) {
                    f = rect.right;
                    f2 = v60Var.a0;
                } else {
                    i2 = rect.left;
                    f3 = i2;
                }
                float fMax = Math.max(f3, rect.left);
                rectF = this.s1;
                rectF.left = fMax;
                rectF.top = rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f4 = (width / 2.0f) + (v60Var.a0 / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (v60Var.D) {
                        f5 = v60Var.a0;
                        f4 = f5 + fMax;
                    } else {
                        i = rect.right;
                        f4 = i;
                    }
                } else if (v60Var.D) {
                    i = rect.right;
                    f4 = i;
                } else {
                    f5 = v60Var.a0;
                    f4 = f5 + fMax;
                }
                rectF.right = Math.min(f4, rect.right);
                rectF.bottom = v60Var.f() + rect.top;
                if (v60Var.Z != null && !v60Var.o()) {
                    StaticLayout staticLayout = v60Var.Z;
                    float lineWidth = (v60Var.i / v60Var.h) * staticLayout.getLineWidth(staticLayout.getLineCount() - 1);
                    if (v60Var.D) {
                        rectF.right = rectF.left + lineWidth;
                    } else {
                        rectF.left = rectF.right - lineWidth;
                    }
                }
                if (rectF.width() > 0.0f || rectF.height() <= 0.0f) {
                }
                float f6 = rectF.left;
                float f7 = this.i1;
                rectF.left = f6 - f7;
                rectF.right += f7;
                rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.l1);
                rectF.top = 0.0f;
                xg0 xg0Var = (xg0) this.a1;
                xg0Var.getClass();
                xg0Var.z(rectF.left, rectF.top, rectF.right, rectF.bottom);
                return;
            }
            f = width / 2.0f;
            f2 = v60Var.a0 / 2.0f;
            f3 = f - f2;
            float fMax2 = Math.max(f3, rect.left);
            rectF = this.s1;
            rectF.left = fMax2;
            rectF.top = rect.top;
            if (gravity != 17) {
                f4 = (width / 2.0f) + (v60Var.a0 / 2.0f);
            }
            rectF.right = Math.min(f4, rect.right);
            rectF.bottom = v60Var.f() + rect.top;
            if (v60Var.Z != null) {
                StaticLayout staticLayout2 = v60Var.Z;
                float lineWidth2 = (v60Var.i / v60Var.h) * staticLayout2.getLineWidth(staticLayout2.getLineCount() - 1);
                if (v60Var.D) {
                }
            }
            if (rectF.width() > 0.0f) {
            }
        }
    }

    public final void n(AppCompatTextView appCompatTextView, int i) {
        try {
            appCompatTextView.setTextAppearance(i);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        appCompatTextView.setTextAppearance(com.getsurfboard.R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(getContext().getColor(com.getsurfboard.R.color.design_error));
    }

    public final boolean o() {
        vz1 vz1Var = this.E0;
        return (vz1Var.o != 1 || vz1Var.r == null || TextUtils.isEmpty(vz1Var.p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.N1.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        x41 x41Var = this.z;
        x41Var.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.T1 = false;
        if (this.y0 != null && this.y0.getMeasuredHeight() < (iMax = Math.max(x41Var.getMeasuredHeight(), this.f.getMeasuredHeight()))) {
            this.y0.setMinimumHeight(iMax);
            z = true;
        }
        boolean zS = s();
        if (z || zS) {
            this.y0.post(new ga1(25, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float fDescent;
        int i5;
        int compoundPaddingTop;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.y0;
        if (editText != null) {
            Rect rect = this.q1;
            po0.a(this, editText, rect);
            yi2 yi2Var = this.e1;
            if (yi2Var != null) {
                int i6 = rect.bottom;
                yi2Var.setBounds(rect.left, i6 - this.m1, rect.right, i6);
            }
            yi2 yi2Var2 = this.f1;
            if (yi2Var2 != null) {
                int i7 = rect.bottom;
                yi2Var2.setBounds(rect.left, i7 - this.n1, rect.right, i7);
            }
            if (this.X0) {
                float textSize = this.y0.getTextSize();
                v60 v60Var = this.N1;
                float f = v60Var.h;
                TextPaint textPaint = v60Var.P;
                if (f != textSize) {
                    v60Var.h = textSize;
                    v60Var.j(false);
                }
                int gravity = this.y0.getGravity();
                int i8 = (gravity & (-113)) | 48;
                if (v60Var.g != i8) {
                    v60Var.g = i8;
                    v60Var.j(false);
                }
                if (v60Var.f != gravity) {
                    v60Var.f = gravity;
                    v60Var.j(false);
                }
                Rect rectD = d(rect);
                int i9 = rectD.left;
                int i10 = rectD.top;
                int i11 = rectD.right;
                int i12 = rectD.bottom;
                Rect rect2 = v60Var.d;
                if (rect2.left != i9 || rect2.top != i10 || rect2.right != i11 || rect2.bottom != i12) {
                    rect2.set(i9, i10, i11, i12);
                    v60Var.N = true;
                }
                if (this.y0 == null) {
                    st4.g();
                    return;
                }
                if (getHintMaxLines() == 1) {
                    textPaint.setTextSize(v60Var.h);
                    textPaint.setTypeface(v60Var.v);
                    textPaint.setLetterSpacing(v60Var.X);
                    fDescent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(v60Var.h);
                    textPaint.setTypeface(v60Var.v);
                    textPaint.setLetterSpacing(v60Var.X);
                    fDescent = v60Var.l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.y0.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.r1;
                rect3.left = compoundPaddingLeft;
                if (this.j1 != 1 || this.y0.getMinLines() > 1) {
                    if (this.j1 != 0 || getHintMaxLines() == 1) {
                        i5 = 0;
                    } else {
                        textPaint.setTextSize(v60Var.h);
                        textPaint.setTypeface(v60Var.v);
                        textPaint.setLetterSpacing(v60Var.X);
                        i5 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.y0.getCompoundPaddingTop() + rect.top) - i5;
                } else {
                    compoundPaddingTop = (int) (rect.centerY() - (fDescent / 2.0f));
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.y0.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.j1 != 1 || this.y0.getMinLines() > 1) ? rect.bottom - this.y0.getCompoundPaddingBottom() : (int) (rect3.top + fDescent);
                rect3.bottom = compoundPaddingBottom;
                int i13 = rect3.left;
                int i14 = rect3.top;
                int i15 = rect3.right;
                Rect rect4 = v60Var.c;
                if (rect4.left != i13 || rect4.top != i14 || rect4.right != i15 || rect4.bottom != compoundPaddingBottom || true != v60Var.k0) {
                    rect4.set(i13, i14, i15, compoundPaddingBottom);
                    v60Var.N = true;
                    v60Var.k0 = true;
                }
                v60Var.j(false);
                if (!g() || this.M1) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        float f;
        EditText editText;
        super.onMeasure(i, i2);
        boolean z = this.T1;
        x41 x41Var = this.z;
        if (!z) {
            x41Var.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.T1 = true;
        }
        if (this.O0 != null && (editText = this.y0) != null) {
            this.O0.setGravity(editText.getGravity());
            this.O0.setPadding(this.y0.getCompoundPaddingLeft(), this.y0.getCompoundPaddingTop(), this.y0.getCompoundPaddingRight(), this.y0.getCompoundPaddingBottom());
        }
        x41Var.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.y0.getMeasuredWidth() - this.y0.getCompoundPaddingLeft()) - this.y0.getCompoundPaddingRight();
        v60 v60Var = this.N1;
        TextPaint textPaint = v60Var.P;
        textPaint.setTextSize(v60Var.i);
        textPaint.setTypeface(v60Var.s);
        textPaint.setLetterSpacing(v60Var.W);
        float f2 = measuredWidth;
        v60Var.i0 = v60Var.e(v60Var.f0, textPaint, v60Var.B, (v60Var.i / v60Var.h) * f2, v60Var.D).getHeight();
        textPaint.setTextSize(v60Var.h);
        textPaint.setTypeface(v60Var.v);
        textPaint.setLetterSpacing(v60Var.X);
        v60Var.j0 = v60Var.e(v60Var.e0, textPaint, v60Var.B, f2, v60Var.D).getHeight();
        EditText editText2 = this.y0;
        Rect rect = this.q1;
        po0.a(this, editText2, rect);
        Rect rectD = d(rect);
        int i3 = rectD.left;
        int i4 = rectD.top;
        int i5 = rectD.right;
        int i6 = rectD.bottom;
        Rect rect2 = v60Var.d;
        if (rect2.left != i3 || rect2.top != i4 || rect2.right != i5 || rect2.bottom != i6) {
            rect2.set(i3, i4, i5, i6);
            v60Var.N = true;
        }
        v();
        a();
        if (this.y0 == null) {
            return;
        }
        int i7 = v60Var.j0;
        if (i7 != -1) {
            f = i7;
        } else {
            TextPaint textPaint2 = v60Var.P;
            textPaint2.setTextSize(v60Var.h);
            textPaint2.setTypeface(v60Var.v);
            textPaint2.setLetterSpacing(v60Var.X);
            f = -textPaint2.ascent();
        }
        if (this.M0 != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.O0.getPaint());
            textPaint3.setTextSize(this.O0.getTextSize());
            textPaint3.setTypeface(this.O0.getTypeface());
            textPaint3.setLetterSpacing(this.O0.getLetterSpacing());
            u24 u24Var = new u24(this.M0, textPaint3, measuredWidth);
            u24Var.k = getLayoutDirection() == 1;
            u24Var.j = true;
            float lineSpacingExtra = this.O0.getLineSpacingExtra();
            float lineSpacingMultiplier = this.O0.getLineSpacingMultiplier();
            u24Var.g = lineSpacingExtra;
            u24Var.h = lineSpacingMultiplier;
            u24Var.m = new o73(11, this);
            f = (this.j1 == 1 ? v60Var.f() + this.k1 + this.A : 0.0f) + u24Var.a().getHeight();
        }
        float fMax = Math.max(f, f);
        if (this.y0.getMeasuredHeight() < fMax) {
            this.y0.setMinimumHeight(Math.round(fMax));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof zb4)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        zb4 zb4Var = (zb4) parcelable;
        super.onRestoreInstanceState(zb4Var.b);
        setError(zb4Var.z);
        if (zb4Var.A) {
            post(new f33(25, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 1;
        if (z != this.h1) {
            ye0 ye0Var = this.g1.e;
            RectF rectF = this.s1;
            float fA = ye0Var.a(rectF);
            float fA2 = this.g1.f.a(rectF);
            float fA3 = this.g1.h.a(rectF);
            float fA4 = this.g1.g.a(rectF);
            ou3 ou3Var = this.g1;
            fx3 fx3Var = ou3Var.a;
            fx3 fx3Var2 = ou3Var.b;
            fx3 fx3Var3 = ou3Var.d;
            fx3 fx3Var4 = ou3Var.c;
            k01 k01Var = new k01(0);
            k01 k01Var2 = new k01(0);
            k01 k01Var3 = new k01(0);
            k01 k01Var4 = new k01(0);
            a0 a0Var = new a0(fA2);
            a0 a0Var2 = new a0(fA);
            a0 a0Var3 = new a0(fA4);
            a0 a0Var4 = new a0(fA3);
            ou3 ou3Var2 = new ou3();
            ou3Var2.a = fx3Var2;
            ou3Var2.b = fx3Var;
            ou3Var2.c = fx3Var3;
            ou3Var2.d = fx3Var4;
            ou3Var2.e = a0Var;
            ou3Var2.f = a0Var2;
            ou3Var2.g = a0Var4;
            ou3Var2.h = a0Var3;
            ou3Var2.i = k01Var;
            ou3Var2.j = k01Var2;
            ou3Var2.k = k01Var3;
            ou3Var2.l = k01Var4;
            this.h1 = z;
            setShapeAppearanceModel(ou3Var2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        zb4 zb4Var = new zb4(super.onSaveInstanceState());
        if (o()) {
            zb4Var.z = getError();
        }
        x41 x41Var = this.z;
        zb4Var.A = x41Var.C0 != 0 && x41Var.A0.A;
        return zb4Var;
    }

    public final void p(Editable editable) {
        ((e04) this.I0).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z = this.H0;
        int i = this.G0;
        if (i == -1) {
            this.J0.setText(String.valueOf(length));
            this.J0.setContentDescription(null);
            this.H0 = false;
        } else {
            this.H0 = length > i;
            Context context = getContext();
            this.J0.setContentDescription(context.getString(this.H0 ? com.getsurfboard.R.string.character_counter_overflowed_content_description : com.getsurfboard.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.G0)));
            if (z != this.H0) {
                q();
            }
            String str = xm.b;
            xm xmVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? xm.e : xm.d;
            AppCompatTextView appCompatTextView = this.J0;
            String string = getContext().getString(com.getsurfboard.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.G0));
            xmVar.getClass();
            sn snVar = mb4.a;
            appCompatTextView.setText(string != null ? xmVar.c(string).toString() : null);
        }
        if (this.y0 == null || z == this.H0) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.J0;
        if (appCompatTextView != null) {
            n(appCompatTextView, this.H0 ? this.K0 : this.L0);
            if (!this.H0 && (colorStateList2 = this.T0) != null) {
                this.J0.setTextColor(colorStateList2);
            }
            if (!this.H0 || (colorStateList = this.U0) == null) {
                return;
            }
            this.J0.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r() {
        ColorStateList colorStateList;
        ColorStateList colorStateListValueOf = this.V0;
        if (colorStateListValueOf == null) {
            Context context = getContext();
            TypedValue typedValueA = ek0.A(context, com.getsurfboard.R.attr.colorControlActivated);
            if (typedValueA != null) {
                int i = typedValueA.resourceId;
                if (i != 0) {
                    colorStateListValueOf = v9.g(context, i);
                } else {
                    int i2 = typedValueA.data;
                    colorStateListValueOf = i2 != 0 ? ColorStateList.valueOf(i2) : null;
                }
            }
        }
        EditText editText = this.y0;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = this.y0.getTextCursorDrawable().mutate();
        if ((o() || (this.J0 != null && this.H0)) && (colorStateList = this.W0) != null) {
            colorStateListValueOf = colorStateList;
        }
        drawableMutate.setTintList(colorStateListValueOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s() {
        boolean z;
        if (this.y0 == null) {
            return false;
        }
        CheckableImageButton checkableImageButton = null;
        boolean z2 = true;
        if (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) {
            g24 g24Var = this.f;
            if (g24Var.getMeasuredWidth() > 0) {
                int iMax = Math.max(0, g24Var.getMeasuredWidth() - this.y0.getPaddingLeft());
                if (this.u1 == null || this.v1 != iMax) {
                    ColorDrawable colorDrawable = new ColorDrawable();
                    this.u1 = colorDrawable;
                    this.v1 = iMax;
                    colorDrawable.setBounds(0, 0, iMax, 1);
                }
                Drawable[] compoundDrawablesRelative = this.y0.getCompoundDrawablesRelative();
                Drawable drawable = compoundDrawablesRelative[0];
                ColorDrawable colorDrawable2 = this.u1;
                if (drawable != colorDrawable2) {
                    this.y0.setCompoundDrawablesRelative(colorDrawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                    z = true;
                }
                z = false;
            } else {
                if (this.u1 != null) {
                    Drawable[] compoundDrawablesRelative2 = this.y0.getCompoundDrawablesRelative();
                    this.y0.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                    this.u1 = null;
                    z = true;
                }
                z = false;
            }
        }
        x41 x41Var = this.z;
        if ((x41Var.d() || ((x41Var.C0 != 0 && x41Var.c()) || x41Var.J0 != null)) && x41Var.getMeasuredWidth() > 0) {
            int measuredWidth = x41Var.K0.getMeasuredWidth() - this.y0.getPaddingRight();
            if (x41Var.d()) {
                checkableImageButton = x41Var.z;
            } else if (x41Var.C0 != 0 && x41Var.c()) {
                checkableImageButton = x41Var.A0;
            }
            if (checkableImageButton != null) {
                measuredWidth = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth() + measuredWidth;
            }
            int iMax2 = Math.max(0, measuredWidth);
            Drawable[] compoundDrawablesRelative3 = this.y0.getCompoundDrawablesRelative();
            ColorDrawable colorDrawable3 = this.x1;
            if (colorDrawable3 != null && this.y1 != iMax2) {
                this.y1 = iMax2;
                colorDrawable3.setBounds(0, 0, iMax2, 1);
                this.y0.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.x1, compoundDrawablesRelative3[3]);
                return true;
            }
            if (colorDrawable3 == null) {
                ColorDrawable colorDrawable4 = new ColorDrawable();
                this.x1 = colorDrawable4;
                this.y1 = iMax2;
                colorDrawable4.setBounds(0, 0, iMax2, 1);
            }
            Drawable drawable2 = compoundDrawablesRelative3[2];
            ColorDrawable colorDrawable5 = this.x1;
            if (drawable2 != colorDrawable5) {
                this.z1 = drawable2;
                this.y0.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], colorDrawable5, compoundDrawablesRelative3[3]);
                return true;
            }
        } else if (this.x1 != null) {
            Drawable[] compoundDrawablesRelative4 = this.y0.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative4[2] == this.x1) {
                this.y0.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.z1, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.x1 = null;
            return z2;
        }
        return z;
    }

    public void setBoxBackgroundColor(int i) {
        if (this.p1 != i) {
            this.p1 = i;
            this.G1 = i;
            this.I1 = i;
            this.J1 = i;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(getContext().getColor(i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.G1 = defaultColor;
        this.p1 = defaultColor;
        this.H1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.I1 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.J1 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.j1) {
            return;
        }
        this.j1 = i;
        if (this.y0 != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.k1 = i;
    }

    public void setBoxCornerFamily(int i) {
        qy1 qy1VarL = this.g1.l();
        ye0 ye0Var = this.g1.e;
        qy1VarL.a = uf2.k(i);
        qy1VarL.e = ye0Var;
        ye0 ye0Var2 = this.g1.f;
        qy1VarL.b = uf2.k(i);
        qy1VarL.f = ye0Var2;
        ye0 ye0Var3 = this.g1.h;
        qy1VarL.d = uf2.k(i);
        qy1VarL.h = ye0Var3;
        ye0 ye0Var4 = this.g1.g;
        qy1VarL.c = uf2.k(i);
        qy1VarL.g = ye0Var4;
        this.g1 = qy1VarL.b();
        c();
    }

    public void setBoxStrokeColor(int i) {
        if (this.E1 != i) {
            this.E1 = i;
            z();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.C1 = colorStateList.getDefaultColor();
            this.K1 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.D1 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.E1 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.E1 != colorStateList.getDefaultColor()) {
            this.E1 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.F1 != colorStateList) {
            this.F1 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.m1 = i;
        z();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.n1 = i;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.F0 != z) {
            vz1 vz1Var = this.E0;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.J0 = appCompatTextView;
                appCompatTextView.setId(com.getsurfboard.R.id.textinput_counter);
                Typeface typeface = this.t1;
                if (typeface != null) {
                    this.J0.setTypeface(typeface);
                }
                this.J0.setMaxLines(1);
                vz1Var.a(this.J0, 2);
                ((ViewGroup.MarginLayoutParams) this.J0.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(com.getsurfboard.R.dimen.mtrl_textinput_counter_margin_start));
                q();
                if (this.J0 != null) {
                    EditText editText = this.y0;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                vz1Var.g(this.J0, 2);
                this.J0 = null;
            }
            this.F0 = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.G0 != i) {
            if (i > 0) {
                this.G0 = i;
            } else {
                this.G0 = -1;
            }
            if (!this.F0 || this.J0 == null) {
                return;
            }
            EditText editText = this.y0;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.K0 != i) {
            this.K0 = i;
            q();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.U0 != colorStateList) {
            this.U0 = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.L0 != i) {
            this.L0 = i;
            q();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.T0 != colorStateList) {
            this.T0 = colorStateList;
            q();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.V0 != colorStateList) {
            this.V0 = colorStateList;
            r();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.W0 != colorStateList) {
            this.W0 = colorStateList;
            if (o() || (this.J0 != null && this.H0)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.A1 = colorStateList;
        this.B1 = colorStateList;
        if (this.y0 != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.z.A0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.z.A0.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        x41 x41Var = this.z;
        x41Var.f(i != 0 ? x41Var.getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        x41 x41Var = this.z;
        Drawable drawableR = i != 0 ? vo.r(x41Var.getContext(), i) : null;
        TextInputLayout textInputLayout = x41Var.b;
        CheckableImageButton checkableImageButton = x41Var.A0;
        checkableImageButton.setImageDrawable(drawableR);
        if (drawableR != null) {
            v02.a(textInputLayout, checkableImageButton, x41Var.E0, x41Var.F0);
            v02.x(textInputLayout, checkableImageButton, x41Var.E0);
        }
    }

    public void setEndIconMinSize(int i) {
        x41 x41Var = this.z;
        if (i < 0) {
            x41Var.getClass();
            xe.k("endIconSize cannot be less than 0");
        } else if (i != x41Var.G0) {
            x41Var.G0 = i;
            CheckableImageButton checkableImageButton = x41Var.A0;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = x41Var.z;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.z.g(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        x41 x41Var = this.z;
        CheckableImageButton checkableImageButton = x41Var.A0;
        View.OnLongClickListener onLongClickListener = x41Var.I0;
        checkableImageButton.setOnClickListener(onClickListener);
        v02.G(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        x41 x41Var = this.z;
        x41Var.I0 = onLongClickListener;
        CheckableImageButton checkableImageButton = x41Var.A0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        v02.G(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        x41 x41Var = this.z;
        x41Var.H0 = scaleType;
        x41Var.A0.setScaleType(scaleType);
        x41Var.z.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        x41 x41Var = this.z;
        if (x41Var.E0 != colorStateList) {
            x41Var.E0 = colorStateList;
            v02.a(x41Var.b, x41Var.A0, colorStateList, x41Var.F0);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        x41 x41Var = this.z;
        if (x41Var.F0 != mode) {
            x41Var.F0 = mode;
            v02.a(x41Var.b, x41Var.A0, x41Var.E0, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.z.h(z);
    }

    public void setError(CharSequence charSequence) {
        vz1 vz1Var = this.E0;
        if (!vz1Var.q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            vz1Var.f();
            return;
        }
        vz1Var.c();
        vz1Var.p = charSequence;
        vz1Var.r.setText(charSequence);
        int i = vz1Var.n;
        if (i != 1) {
            vz1Var.o = 1;
        }
        vz1Var.i(i, vz1Var.o, vz1Var.h(vz1Var.r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        vz1 vz1Var = this.E0;
        vz1Var.t = i;
        AppCompatTextView appCompatTextView = vz1Var.r;
        if (appCompatTextView != null) {
            appCompatTextView.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        vz1 vz1Var = this.E0;
        vz1Var.s = charSequence;
        AppCompatTextView appCompatTextView = vz1Var.r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        vz1 vz1Var = this.E0;
        TextInputLayout textInputLayout = vz1Var.h;
        if (vz1Var.q == z) {
            return;
        }
        vz1Var.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(vz1Var.g);
            vz1Var.r = appCompatTextView;
            appCompatTextView.setId(com.getsurfboard.R.id.textinput_error);
            vz1Var.r.setTextAlignment(5);
            Typeface typeface = vz1Var.B;
            if (typeface != null) {
                vz1Var.r.setTypeface(typeface);
            }
            int i = vz1Var.u;
            vz1Var.u = i;
            AppCompatTextView appCompatTextView2 = vz1Var.r;
            if (appCompatTextView2 != null) {
                vz1Var.h.n(appCompatTextView2, i);
            }
            ColorStateList colorStateList = vz1Var.v;
            vz1Var.v = colorStateList;
            AppCompatTextView appCompatTextView3 = vz1Var.r;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = vz1Var.s;
            vz1Var.s = charSequence;
            AppCompatTextView appCompatTextView4 = vz1Var.r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i2 = vz1Var.t;
            vz1Var.t = i2;
            AppCompatTextView appCompatTextView5 = vz1Var.r;
            if (appCompatTextView5 != null) {
                appCompatTextView5.setAccessibilityLiveRegion(i2);
            }
            vz1Var.r.setVisibility(4);
            vz1Var.a(vz1Var.r, 0);
        } else {
            vz1Var.f();
            vz1Var.g(vz1Var.r, 0);
            vz1Var.r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        vz1Var.q = z;
    }

    public void setErrorIconDrawable(int i) {
        x41 x41Var = this.z;
        x41Var.i(i != 0 ? vo.r(x41Var.getContext(), i) : null);
        v02.x(x41Var.b, x41Var.z, x41Var.A);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        x41 x41Var = this.z;
        CheckableImageButton checkableImageButton = x41Var.z;
        View.OnLongClickListener onLongClickListener = x41Var.z0;
        checkableImageButton.setOnClickListener(onClickListener);
        v02.G(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        x41 x41Var = this.z;
        x41Var.z0 = onLongClickListener;
        CheckableImageButton checkableImageButton = x41Var.z;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        v02.G(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        x41 x41Var = this.z;
        if (x41Var.A != colorStateList) {
            x41Var.A = colorStateList;
            v02.a(x41Var.b, x41Var.z, colorStateList, x41Var.y0);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        x41 x41Var = this.z;
        if (x41Var.y0 != mode) {
            x41Var.y0 = mode;
            v02.a(x41Var.b, x41Var.z, x41Var.A, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        vz1 vz1Var = this.E0;
        vz1Var.u = i;
        AppCompatTextView appCompatTextView = vz1Var.r;
        if (appCompatTextView != null) {
            vz1Var.h.n(appCompatTextView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        vz1 vz1Var = this.E0;
        vz1Var.v = colorStateList;
        AppCompatTextView appCompatTextView = vz1Var.r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.O1 != z) {
            this.O1 = z;
            w(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        vz1 vz1Var = this.E0;
        if (zIsEmpty) {
            if (vz1Var.x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!vz1Var.x) {
            setHelperTextEnabled(true);
        }
        vz1Var.c();
        vz1Var.w = charSequence;
        vz1Var.y.setText(charSequence);
        int i = vz1Var.n;
        if (i != 2) {
            vz1Var.o = 2;
        }
        vz1Var.i(i, vz1Var.o, vz1Var.h(vz1Var.y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        vz1 vz1Var = this.E0;
        vz1Var.A = colorStateList;
        AppCompatTextView appCompatTextView = vz1Var.y;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        vz1 vz1Var = this.E0;
        TextInputLayout textInputLayout = vz1Var.h;
        if (vz1Var.x == z) {
            return;
        }
        vz1Var.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(vz1Var.g);
            vz1Var.y = appCompatTextView;
            appCompatTextView.setId(com.getsurfboard.R.id.textinput_helper_text);
            vz1Var.y.setTextAlignment(5);
            Typeface typeface = vz1Var.B;
            if (typeface != null) {
                vz1Var.y.setTypeface(typeface);
            }
            vz1Var.y.setVisibility(4);
            vz1Var.y.setImportantForAccessibility(2);
            int i = vz1Var.z;
            vz1Var.z = i;
            AppCompatTextView appCompatTextView2 = vz1Var.y;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setTextAppearance(i);
            }
            ColorStateList colorStateList = vz1Var.A;
            vz1Var.A = colorStateList;
            AppCompatTextView appCompatTextView3 = vz1Var.y;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            vz1Var.a(vz1Var.y, 1);
        } else {
            vz1Var.c();
            int i2 = vz1Var.n;
            if (i2 == 2) {
                vz1Var.o = 0;
            }
            vz1Var.i(i2, vz1Var.o, vz1Var.h(vz1Var.y, ""));
            vz1Var.g(vz1Var.y, 1);
            vz1Var.y = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        vz1Var.x = z;
    }

    public void setHelperTextTextAppearance(int i) {
        vz1 vz1Var = this.E0;
        vz1Var.z = i;
        AppCompatTextView appCompatTextView = vz1Var.y;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setHintAnimationEnabled(boolean z) {
        this.P1 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.X0) {
            this.X0 = z;
            if (z) {
                CharSequence hint = this.y0.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.Y0)) {
                        setHint(hint);
                    }
                    this.y0.setHint((CharSequence) null);
                }
                this.Z0 = true;
            } else {
                this.Z0 = false;
                if (!TextUtils.isEmpty(this.Y0) && TextUtils.isEmpty(this.y0.getHint())) {
                    this.y0.setHint(this.Y0);
                }
                setHintInternal(null);
            }
            if (this.y0 != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i) {
        v60 v60Var = this.N1;
        if (i != v60Var.f0) {
            v60Var.f0 = i;
            v60Var.j(false);
        }
        if (i != v60Var.e0) {
            v60Var.e0 = i;
            v60Var.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(int i) {
        v60 v60Var = this.N1;
        TextInputLayout textInputLayout = v60Var.a;
        kb4 kb4Var = new kb4(textInputLayout.getContext(), i);
        ColorStateList colorStateList = kb4Var.k;
        if (colorStateList != null) {
            v60Var.k = colorStateList;
        }
        float f = kb4Var.l;
        if (f != 0.0f) {
            v60Var.i = f;
        }
        ColorStateList colorStateList2 = kb4Var.a;
        if (colorStateList2 != null) {
            v60Var.V = colorStateList2;
        }
        v60Var.T = kb4Var.f;
        v60Var.U = kb4Var.g;
        v60Var.S = kb4Var.h;
        v60Var.W = kb4Var.j;
        x00 x00Var = v60Var.z;
        if (x00Var != null) {
            x00Var.g = true;
        }
        cp1 cp1Var = new cp1(17, v60Var);
        kb4Var.a();
        v60Var.z = new x00(cp1Var, kb4Var.p);
        kb4Var.b(textInputLayout.getContext(), v60Var.z);
        v60Var.j(false);
        this.B1 = v60Var.k;
        if (this.y0 != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.B1 != colorStateList) {
            if (this.A1 == null) {
                v60 v60Var = this.N1;
                if (v60Var.k != colorStateList) {
                    v60Var.k = colorStateList;
                    v60Var.j(false);
                }
            }
            this.B1 = colorStateList;
            if (this.y0 != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(yb4 yb4Var) {
        this.I0 = yb4Var;
    }

    public void setMaxEms(int i) {
        this.B0 = i;
        EditText editText = this.y0;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.D0 = i;
        EditText editText = this.y0;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.A0 = i;
        EditText editText = this.y0;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.C0 = i;
        EditText editText = this.y0;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        x41 x41Var = this.z;
        x41Var.A0.setContentDescription(i != 0 ? x41Var.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        x41 x41Var = this.z;
        x41Var.A0.setImageDrawable(i != 0 ? vo.r(x41Var.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        x41 x41Var = this.z;
        if (z && x41Var.C0 != 1) {
            x41Var.g(1);
        } else if (z) {
            x41Var.getClass();
        } else {
            x41Var.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        x41 x41Var = this.z;
        x41Var.E0 = colorStateList;
        v02.a(x41Var.b, x41Var.A0, colorStateList, x41Var.F0);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        x41 x41Var = this.z;
        x41Var.F0 = mode;
        v02.a(x41Var.b, x41Var.A0, x41Var.E0, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        int i = 1;
        if (this.O0 == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.O0 = appCompatTextView;
            appCompatTextView.setId(com.getsurfboard.R.id.textinput_placeholder);
            this.O0.setImportantForAccessibility(1);
            this.O0.setAccessibilityLiveRegion(1);
            xa1 xa1VarF = f();
            this.R0 = xa1VarF;
            xa1VarF.f = 67L;
            this.S0 = f();
            setPlaceholderTextAppearance(this.Q0);
            setPlaceholderTextColor(this.P0);
            wp4.n(this.O0, new sq2(i));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.N0) {
                setPlaceholderTextEnabled(true);
            }
            this.M0 = charSequence;
        }
        EditText editText = this.y0;
        x(editText == null ? null : editText.getText());
    }

    public void setPlaceholderTextAppearance(int i) {
        this.Q0 = i;
        AppCompatTextView appCompatTextView = this.O0;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.P0 != colorStateList) {
            this.P0 = colorStateList;
            AppCompatTextView appCompatTextView = this.O0;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        g24 g24Var = this.f;
        g24Var.getClass();
        g24Var.z = TextUtils.isEmpty(charSequence) ? null : charSequence;
        g24Var.f.setText(charSequence);
        g24Var.f();
    }

    public void setPrefixTextAppearance(int i) {
        this.f.f.setTextAppearance(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f.f.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(ou3 ou3Var) {
        yi2 yi2Var = this.a1;
        if (yi2Var == null || yi2Var.getShapeAppearanceModel() == ou3Var) {
            return;
        }
        this.g1 = ou3Var;
        c();
    }

    public void setStartIconCheckable(boolean z) {
        this.f.A.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? vo.r(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        g24 g24Var = this.f;
        if (i < 0) {
            g24Var.getClass();
            xe.k("startIconSize cannot be less than 0");
        } else if (i != g24Var.A0) {
            g24Var.A0 = i;
            CheckableImageButton checkableImageButton = g24Var.A;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        g24 g24Var = this.f;
        CheckableImageButton checkableImageButton = g24Var.A;
        View.OnLongClickListener onLongClickListener = g24Var.C0;
        checkableImageButton.setOnClickListener(onClickListener);
        v02.G(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        g24 g24Var = this.f;
        g24Var.C0 = onLongClickListener;
        CheckableImageButton checkableImageButton = g24Var.A;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        v02.G(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        g24 g24Var = this.f;
        g24Var.B0 = scaleType;
        g24Var.A.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        g24 g24Var = this.f;
        if (g24Var.y0 != colorStateList) {
            g24Var.y0 = colorStateList;
            v02.a(g24Var.b, g24Var.A, colorStateList, g24Var.z0);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        g24 g24Var = this.f;
        if (g24Var.z0 != mode) {
            g24Var.z0 = mode;
            v02.a(g24Var.b, g24Var.A, g24Var.y0, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.f.d(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        x41 x41Var = this.z;
        x41Var.getClass();
        x41Var.J0 = TextUtils.isEmpty(charSequence) ? null : charSequence;
        x41Var.K0.setText(charSequence);
        x41Var.n();
    }

    public void setSuffixTextAppearance(int i) {
        this.z.K0.setTextAppearance(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.z.K0.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(xb4 xb4Var) {
        EditText editText = this.y0;
        if (editText != null) {
            wp4.n(editText, xb4Var);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.t1) {
            this.t1 = typeface;
            this.N1.n(typeface);
            vz1 vz1Var = this.E0;
            if (typeface != vz1Var.B) {
                vz1Var.B = typeface;
                AppCompatTextView appCompatTextView = vz1Var.r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = vz1Var.y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.J0;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.y0;
        if (editText == null || this.j1 != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = tx0.a;
        Drawable drawableMutate = background.mutate();
        if (o()) {
            drawableMutate.setColorFilter(db.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.H0 && (appCompatTextView = this.J0) != null) {
            drawableMutate.setColorFilter(db.c(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.y0.refreshDrawableState();
        }
    }

    public final void u() {
        EditText editText = this.y0;
        if (editText == null || this.a1 == null) {
            return;
        }
        if ((this.d1 || editText.getBackground() == null) && this.j1 != 0) {
            this.y0.setBackground(getEditTextBoxBackground());
            this.d1 = true;
        }
    }

    public final void v() {
        if (this.j1 != 1) {
            FrameLayout frameLayout = this.b;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iE = e();
            if (iE != layoutParams.topMargin) {
                layoutParams.topMargin = iE;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z, boolean z2) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.y0;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.y0;
        boolean z4 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.A1;
        v60 v60Var = this.N1;
        if (colorStateList2 != null) {
            v60Var.k(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.A1;
            int colorForState = this.K1;
            if (colorStateList3 != null) {
                colorForState = colorStateList3.getColorForState(new int[]{-16842910}, colorForState);
            }
            v60Var.k(ColorStateList.valueOf(colorForState));
        } else if (o()) {
            AppCompatTextView appCompatTextView2 = this.E0.r;
            v60Var.k(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.H0 && (appCompatTextView = this.J0) != null) {
            v60Var.k(appCompatTextView.getTextColors());
        } else if (z4 && (colorStateList = this.B1) != null && v60Var.k != colorStateList) {
            v60Var.k = colorStateList;
            v60Var.j(false);
        }
        x41 x41Var = this.z;
        g24 g24Var = this.f;
        if (z3 || !this.O1 || (isEnabled() && z4)) {
            if (z2 || this.M1) {
                ValueAnimator valueAnimator = this.Q1;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.Q1.cancel();
                }
                if (z && this.P1) {
                    b(1.0f);
                } else {
                    v60Var.m(1.0f);
                }
                this.M1 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.y0;
                x(editText3 != null ? editText3.getText() : null);
                g24Var.D0 = false;
                g24Var.f();
                x41Var.L0 = false;
                x41Var.n();
                return;
            }
            return;
        }
        if (z2 || !this.M1) {
            ValueAnimator valueAnimator2 = this.Q1;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.Q1.cancel();
            }
            if (z && this.P1) {
                b(0.0f);
            } else {
                v60Var.m(0.0f);
            }
            if (g() && !((xg0) this.a1).Y0.r.isEmpty() && g()) {
                ((xg0) this.a1).z(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.M1 = true;
            AppCompatTextView appCompatTextView3 = this.O0;
            if (appCompatTextView3 != null && this.N0) {
                appCompatTextView3.setText((CharSequence) null);
                ah4.a(this.b, this.S0);
                this.O0.setVisibility(4);
            }
            g24Var.D0 = true;
            g24Var.f();
            x41Var.L0 = true;
            x41Var.n();
        }
    }

    public final void x(Editable editable) {
        ((e04) this.I0).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.b;
        if (length != 0 || this.M1) {
            AppCompatTextView appCompatTextView = this.O0;
            if (appCompatTextView == null || !this.N0) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            ah4.a(frameLayout, this.S0);
            this.O0.setVisibility(4);
            return;
        }
        if (this.O0 == null || !this.N0 || TextUtils.isEmpty(this.M0)) {
            return;
        }
        this.O0.setText(this.M0);
        ah4.a(frameLayout, this.R0);
        this.O0.setVisibility(0);
        this.O0.bringToFront();
    }

    public final void y(boolean z, boolean z2) {
        int defaultColor = this.F1.getDefaultColor();
        int colorForState = this.F1.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.F1.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.o1 = colorForState2;
        } else if (z2) {
            this.o1 = colorForState;
        } else {
            this.o1 = defaultColor;
        }
    }

    public final void z() {
        AppCompatTextView appCompatTextView;
        int i;
        EditText editText;
        EditText editText2;
        if (this.a1 == null || this.j1 == 0) {
            return;
        }
        boolean z = isFocused() || ((editText2 = this.y0) != null && editText2.hasFocus());
        boolean z2 = isHovered() || ((editText = this.y0) != null && editText.isHovered());
        if (!isEnabled()) {
            this.o1 = this.K1;
        } else if (o()) {
            if (this.F1 != null) {
                y(z, z2);
            } else {
                this.o1 = getErrorCurrentTextColors();
            }
        } else if (!this.H0 || (appCompatTextView = this.J0) == null) {
            if (z) {
                this.o1 = this.E1;
            } else if (z2) {
                this.o1 = this.D1;
            } else {
                this.o1 = this.C1;
            }
        } else if (this.F1 != null) {
            y(z, z2);
        } else {
            this.o1 = appCompatTextView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r();
        }
        x41 x41Var = this.z;
        TextInputLayout textInputLayout = x41Var.b;
        CheckableImageButton checkableImageButton = x41Var.A0;
        TextInputLayout textInputLayout2 = x41Var.b;
        x41Var.l();
        v02.x(textInputLayout2, x41Var.z, x41Var.A);
        v02.x(textInputLayout2, checkableImageButton, x41Var.E0);
        if (x41Var.a() instanceof uy0) {
            if (!textInputLayout.o() || checkableImageButton.getDrawable() == null) {
                v02.a(textInputLayout, checkableImageButton, x41Var.E0, x41Var.F0);
            } else {
                Drawable drawableMutate = checkableImageButton.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        g24 g24Var = this.f;
        v02.x(g24Var.b, g24Var.A, g24Var.y0);
        if (this.j1 == 2) {
            int i2 = this.l1;
            if (z && isEnabled()) {
                i = this.n1;
                this.l1 = i;
            } else {
                i = this.m1;
                this.l1 = i;
            }
            if (i != i2 && g() && !this.M1) {
                if (g()) {
                    ((xg0) this.a1).z(0.0f, 0.0f, 0.0f, 0.0f);
                }
                l();
            }
        }
        if (this.j1 == 1) {
            if (!isEnabled()) {
                this.p1 = this.H1;
            } else if (z2 && !z) {
                this.p1 = this.J1;
            } else if (z) {
                this.p1 = this.I1;
            } else {
                this.p1 = this.G1;
            }
        }
        c();
        if (getEndIconMode() == 3) {
            EditText editText3 = this.y0;
            if ((editText3 instanceof AutoCompleteTextView) && editText3.getInputType() == 0) {
                getEndIconView().setFocusable(false);
                getEndIconView().setClickable(false);
            } else {
                getEndIconView().setFocusable(true);
                getEndIconView().setClickable(true);
            }
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.X0) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f.b(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f.c(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.z.f(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.z.A0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.z.A0.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.z.i(drawable);
    }

    public void setEndIconDrawable(Drawable drawable) {
        x41 x41Var = this.z;
        TextInputLayout textInputLayout = x41Var.b;
        CheckableImageButton checkableImageButton = x41Var.A0;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            v02.a(textInputLayout, checkableImageButton, x41Var.E0, x41Var.F0);
            v02.x(textInputLayout, checkableImageButton, x41Var.E0);
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }
}
