package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import defpackage.a7;
import defpackage.cd3;
import defpackage.fx3;
import defpackage.gb;
import defpackage.id4;
import defpackage.ip4;
import defpackage.jc;
import defpackage.k31;
import defpackage.n02;
import defpackage.pr4;
import defpackage.tj4;
import defpackage.tx0;
import defpackage.v9;
import defpackage.vo;
import defpackage.wp4;
import defpackage.x31;
import defpackage.xk;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    public static final xk l1 = new xk(18, Float.class, "thumbPos");
    public static final int[] m1 = {R.attr.state_checked};
    public boolean A;
    public ColorStateList A0;
    public PorterDuff.Mode B0;
    public boolean C0;
    public boolean D0;
    public int E0;
    public int F0;
    public int G0;
    public boolean H0;
    public CharSequence I0;
    public CharSequence J0;
    public CharSequence K0;
    public CharSequence L0;
    public boolean M0;
    public int N0;
    public final int O0;
    public float P0;
    public float Q0;
    public final VelocityTracker R0;
    public final int S0;
    public float T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;
    public int a1;
    public Drawable b;
    public boolean b1;
    public final TextPaint c1;
    public final ColorStateList d1;
    public StaticLayout e1;
    public ColorStateList f;
    public StaticLayout f1;
    public final a7 g1;
    public ObjectAnimator h1;
    public gb i1;
    public x31 j1;
    public final Rect k1;
    public boolean y0;
    public PorterDuff.Mode z;
    public Drawable z0;

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        int resourceId;
        super(context, attributeSet, i);
        this.f = null;
        this.z = null;
        this.A = false;
        this.y0 = false;
        this.A0 = null;
        this.B0 = null;
        this.C0 = false;
        this.D0 = false;
        this.R0 = VelocityTracker.obtain();
        this.b1 = true;
        this.k1 = new Rect();
        id4.a(getContext(), this);
        TextPaint textPaint = new TextPaint(1);
        this.c1 = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = cd3.w;
        n02 n02VarY = n02.y(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        wp4.m(this, context, iArr, attributeSet, typedArray, i);
        Drawable drawableO = n02VarY.o(2);
        this.b = drawableO;
        if (drawableO != null) {
            drawableO.setCallback(this);
        }
        Drawable drawableO2 = n02VarY.o(11);
        this.z0 = drawableO2;
        if (drawableO2 != null) {
            drawableO2.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.M0 = typedArray.getBoolean(3, true);
        this.E0 = typedArray.getDimensionPixelSize(8, 0);
        this.F0 = typedArray.getDimensionPixelSize(5, 0);
        this.G0 = typedArray.getDimensionPixelSize(6, 0);
        this.H0 = typedArray.getBoolean(4, false);
        ColorStateList colorStateListN = n02VarY.n(9);
        if (colorStateListN != null) {
            this.f = colorStateListN;
            this.A = true;
        }
        PorterDuff.Mode modeC = tx0.c(typedArray.getInt(10, -1), null);
        if (this.z != modeC) {
            this.z = modeC;
            this.y0 = true;
        }
        if (this.A || this.y0) {
            a();
        }
        ColorStateList colorStateListN2 = n02VarY.n(12);
        if (colorStateListN2 != null) {
            this.A0 = colorStateListN2;
            this.C0 = true;
        }
        PorterDuff.Mode modeC2 = tx0.c(typedArray.getInt(13, -1), null);
        if (this.B0 != modeC2) {
            this.B0 = modeC2;
            this.D0 = true;
        }
        if (this.C0 || this.D0) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId2, cd3.x);
            ColorStateList colorStateList = (!typedArrayObtainStyledAttributes.hasValue(3) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = v9.g(context, resourceId)) == null) ? typedArrayObtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.d1 = colorStateList;
            } else {
                this.d1 = getTextColors();
            }
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f = dimensionPixelSize;
                if (f != textPaint.getTextSize()) {
                    textPaint.setTextSize(f);
                    requestLayout();
                }
            }
            int i2 = typedArrayObtainStyledAttributes.getInt(1, -1);
            int i3 = typedArrayObtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i3 > 0) {
                Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
                setSwitchTypeface(typefaceDefaultFromStyle);
                int i4 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i3;
                textPaint.setFakeBoldText((i4 & 1) != 0);
                textPaint.setTextSkewX((2 & i4) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                a7 a7Var = new a7();
                a7Var.b = context2.getResources().getConfiguration().locale;
                this.g1 = a7Var;
            } else {
                this.g1 = null;
            }
            setTextOnInternal(this.I0);
            setTextOffInternal(this.K0);
            typedArrayObtainStyledAttributes.recycle();
        }
        new jc(this).f(attributeSet, i);
        n02VarY.K();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.O0 = viewConfiguration.getScaledTouchSlop();
        this.S0 = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, i);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private gb getEmojiTextViewHelper() {
        gb gbVar = this.i1;
        if (gbVar != null) {
            return gbVar;
        }
        gb gbVar2 = new gb(this);
        this.i1 = gbVar2;
        return gbVar2;
    }

    private boolean getTargetCheckedState() {
        return this.T0 > 0.5f;
    }

    private int getThumbOffset() {
        boolean z = pr4.a;
        int layoutDirection = getLayoutDirection();
        float f = this.T0;
        if (layoutDirection == 1) {
            f = 1.0f - f;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.z0;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.k1;
        drawable.getPadding(rect);
        Drawable drawable2 = this.b;
        Rect rectB = drawable2 != null ? tx0.b(drawable2) : tx0.c;
        return ((((this.U0 - this.W0) - rect.left) - rect.right) - rectB.left) - rectB.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.K0 = charSequence;
        TransformationMethod transformationMethodM0 = ((tj4) getEmojiTextViewHelper().b.f).m0(this.g1);
        if (transformationMethodM0 != null) {
            charSequence = transformationMethodM0.getTransformation(charSequence, this);
        }
        this.L0 = charSequence;
        this.f1 = null;
        if (this.M0) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.I0 = charSequence;
        TransformationMethod transformationMethodM0 = ((tj4) getEmojiTextViewHelper().b.f).m0(this.g1);
        if (transformationMethodM0 != null) {
            charSequence = transformationMethodM0.getTransformation(charSequence, this);
        }
        this.J0 = charSequence;
        this.e1 = null;
        if (this.M0) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.b;
        if (drawable != null) {
            if (this.A || this.y0) {
                Drawable drawableMutate = drawable.mutate();
                this.b = drawableMutate;
                if (this.A) {
                    drawableMutate.setTintList(this.f);
                }
                if (this.y0) {
                    this.b.setTintMode(this.z);
                }
                if (this.b.isStateful()) {
                    this.b.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.z0;
        if (drawable != null) {
            if (this.C0 || this.D0) {
                Drawable drawableMutate = drawable.mutate();
                this.z0 = drawableMutate;
                if (this.C0) {
                    drawableMutate.setTintList(this.A0);
                }
                if (this.D0) {
                    this.z0.setTintMode(this.B0);
                }
                if (this.z0.isStateful()) {
                    this.z0.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.I0);
        setTextOffInternal(this.K0);
        requestLayout();
    }

    public final void d() {
        if (this.j1 == null && ((tj4) this.i1.b.f).J() && k31.k != null) {
            k31 k31VarA = k31.a();
            int iB = k31VarA.b();
            if (iB == 3 || iB == 0) {
                x31 x31Var = new x31(this);
                this.j1 = x31Var;
                k31VarA.f(x31Var);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = this.X0;
        int i4 = this.Y0;
        int i5 = this.Z0;
        int i6 = this.a1;
        int thumbOffset = getThumbOffset() + i3;
        Drawable drawable = this.b;
        Rect rectB = drawable != null ? tx0.b(drawable) : tx0.c;
        Drawable drawable2 = this.z0;
        Rect rect = this.k1;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i7 = rect.left;
            thumbOffset += i7;
            if (rectB != null) {
                int i8 = rectB.left;
                if (i8 > i7) {
                    i3 += i8 - i7;
                }
                int i9 = rectB.top;
                int i10 = rect.top;
                i = i9 > i10 ? (i9 - i10) + i4 : i4;
                int i11 = rectB.right;
                int i12 = rect.right;
                if (i11 > i12) {
                    i5 -= i11 - i12;
                }
                int i13 = rectB.bottom;
                int i14 = rect.bottom;
                if (i13 > i14) {
                    i2 = i6 - (i13 - i14);
                }
                this.z0.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.z0.setBounds(i3, i, i5, i2);
        }
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i15 = thumbOffset - rect.left;
            int i16 = thumbOffset + this.W0 + rect.right;
            this.b.setBounds(i15, i4, i16, i6);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i15, i4, i16, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
        Drawable drawable2 = this.z0;
        if (drawable2 != null) {
            drawable2.setHotspot(f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.b;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.z0;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        boolean z = pr4.a;
        if (getLayoutDirection() != 1) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.U0;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.G0 : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        boolean z = pr4.a;
        if (getLayoutDirection() == 1) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.U0;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.G0 : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return fx3.P(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.M0;
    }

    public boolean getSplitTrack() {
        return this.H0;
    }

    public int getSwitchMinWidth() {
        return this.F0;
    }

    public int getSwitchPadding() {
        return this.G0;
    }

    public CharSequence getTextOff() {
        return this.K0;
    }

    public CharSequence getTextOn() {
        return this.I0;
    }

    public Drawable getThumbDrawable() {
        return this.b;
    }

    public final float getThumbPosition() {
        return this.T0;
    }

    public int getThumbTextPadding() {
        return this.E0;
    }

    public ColorStateList getThumbTintList() {
        return this.f;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.z;
    }

    public Drawable getTrackDrawable() {
        return this.z0;
    }

    public ColorStateList getTrackTintList() {
        return this.A0;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.B0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.z0;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.h1;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.h1.end();
        this.h1 = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, m1);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.z0;
        Rect rect = this.k1;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.Y0;
        int i2 = this.a1;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.b;
        if (drawable != null) {
            if (!this.H0 || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectB = tx0.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectB.left;
                rect.right -= rectB.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.e1 : this.f1;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.c1;
            ColorStateList colorStateList = this.d1;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i3 + i4) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.I0 : this.K0;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int width;
        int paddingLeft;
        int height;
        int paddingTop;
        super.onLayout(z, i, i2, i3, i4);
        int iMax2 = 0;
        if (this.b != null) {
            Drawable drawable = this.z0;
            Rect rect = this.k1;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectB = tx0.b(this.b);
            iMax = Math.max(0, rectB.left - rect.left);
            iMax2 = Math.max(0, rectB.right - rect.right);
        } else {
            iMax = 0;
        }
        boolean z2 = pr4.a;
        if (getLayoutDirection() == 1) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.U0 + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.U0) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height2 = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i5 = this.V0;
            int i6 = height2 - (i5 / 2);
            height = i5 + i6;
            paddingTop = i6;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.V0 + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.V0;
        }
        this.X0 = paddingLeft;
        this.Y0 = paddingTop;
        this.a1 = height;
        this.Z0 = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int intrinsicHeight2 = 0;
        if (this.M0) {
            StaticLayout staticLayout = this.e1;
            TextPaint textPaint = this.c1;
            if (staticLayout == null) {
                CharSequence charSequence = this.J0;
                this.e1 = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.f1 == null) {
                CharSequence charSequence2 = this.L0;
                this.f1 = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.b;
        Rect rect = this.k1;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.b.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.b.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.W0 = Math.max(this.M0 ? (this.E0 * 2) + Math.max(this.e1.getWidth(), this.f1.getWidth()) : 0, intrinsicWidth);
        Drawable drawable2 = this.z0;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.z0.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.b;
        if (drawable3 != null) {
            Rect rectB = tx0.b(drawable3);
            iMax = Math.max(iMax, rectB.left);
            iMax2 = Math.max(iMax2, rectB.right);
        }
        boolean z = this.b1;
        int iMax3 = this.F0;
        if (z) {
            iMax3 = Math.max(iMax3, (this.W0 * 2) + iMax + iMax2);
        }
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.U0 = iMax3;
        this.V0 = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.I0 : this.K0;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean targetCheckedState;
        VelocityTracker velocityTracker = this.R0;
        velocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int i = this.O0;
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.N0 == 2) {
                    this.N0 = 0;
                    boolean z = motionEvent.getAction() == 1 && isEnabled();
                    boolean zIsChecked = isChecked();
                    if (z) {
                        velocityTracker.computeCurrentVelocity(1000);
                        float xVelocity = velocityTracker.getXVelocity();
                        if (Math.abs(xVelocity) > this.S0) {
                            boolean z2 = pr4.a;
                            targetCheckedState = getLayoutDirection() != 1 ? xVelocity > 0.0f : xVelocity < 0.0f;
                        } else {
                            targetCheckedState = getTargetCheckedState();
                        }
                    } else {
                        targetCheckedState = zIsChecked;
                    }
                    if (targetCheckedState != zIsChecked) {
                        playSoundEffect(0);
                    }
                    setChecked(targetCheckedState);
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.N0 = 0;
                velocityTracker.clear();
            } else if (actionMasked == 2) {
                int i2 = this.N0;
                if (i2 == 1) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float f = i;
                    if (Math.abs(x - this.P0) > f || Math.abs(y - this.Q0) > f) {
                        this.N0 = 2;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        this.P0 = x;
                        this.Q0 = y;
                        return true;
                    }
                } else if (i2 == 2) {
                    float x2 = motionEvent.getX();
                    int thumbScrollRange = getThumbScrollRange();
                    float f2 = x2 - this.P0;
                    float f3 = thumbScrollRange != 0 ? f2 / thumbScrollRange : f2 > 0.0f ? 1.0f : -1.0f;
                    boolean z3 = pr4.a;
                    if (getLayoutDirection() == 1) {
                        f3 = -f3;
                    }
                    float f4 = this.T0;
                    float f5 = f3 + f4;
                    float f6 = f5 >= 0.0f ? f5 > 1.0f ? 1.0f : f5 : 0.0f;
                    if (f6 != f4) {
                        this.P0 = x2;
                        setThumbPosition(f6);
                    }
                    return true;
                }
            } else if (actionMasked == 3) {
            }
        } else {
            float x3 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (isEnabled() && this.b != null) {
                int thumbOffset = getThumbOffset();
                Drawable drawable = this.b;
                Rect rect = this.k1;
                drawable.getPadding(rect);
                int i3 = this.Y0 - i;
                int i4 = (this.X0 + thumbOffset) - i;
                int i5 = this.W0 + i4 + rect.left + rect.right + i;
                int i6 = this.a1 + i;
                if (x3 > i4 && x3 < i5 && y2 > i3 && y2 < i6) {
                    this.N0 = 1;
                    this.P0 = x3;
                    this.Q0 = y2;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object string = this.I0;
                if (string == null) {
                    string = getResources().getString(com.getsurfboard.R.string.abc_capital_on);
                }
                Object obj = string;
                WeakHashMap weakHashMap = wp4.a;
                new ip4(com.getsurfboard.R.id.tag_state_description, CharSequence.class, 64, 30, 2).f(this, obj);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object string2 = this.K0;
            if (string2 == null) {
                string2 = getResources().getString(com.getsurfboard.R.string.abc_capital_off);
            }
            Object obj2 = string2;
            WeakHashMap weakHashMap2 = wp4.a;
            new ip4(com.getsurfboard.R.id.tag_state_description, CharSequence.class, 64, 30, 2).f(this, obj2);
        }
        if (getWindowToken() == null || !isLaidOut()) {
            ObjectAnimator objectAnimator = this.h1;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, l1, zIsChecked ? 1.0f : 0.0f);
        this.h1 = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.h1.setAutoCancel(true);
        this.h1.start();
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(fx3.Q(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
        setTextOnInternal(this.I0);
        setTextOffInternal(this.K0);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z) {
        this.b1 = z;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z) {
        if (this.M0 != z) {
            this.M0 = z;
            requestLayout();
            if (z) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.H0 = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.F0 = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.G0 = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.c1;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.K0;
        if (string == null) {
            string = getResources().getString(com.getsurfboard.R.string.abc_capital_off);
        }
        WeakHashMap weakHashMap = wp4.a;
        new ip4(com.getsurfboard.R.id.tag_state_description, CharSequence.class, 64, 30, 2).f(this, string);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object string = this.I0;
        if (string == null) {
            string = getResources().getString(com.getsurfboard.R.string.abc_capital_on);
        }
        WeakHashMap weakHashMap = wp4.a;
        new ip4(com.getsurfboard.R.id.tag_state_description, CharSequence.class, 64, 30, 2).f(this, string);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f) {
        this.T0 = f;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(vo.r(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.E0 = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f = colorStateList;
        this.A = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.z = mode;
        this.y0 = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.z0;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.z0 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(vo.r(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.A0 = colorStateList;
        this.C0 = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.B0 = mode;
        this.D0 = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.b || drawable == this.z0;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.getsurfboard.R.attr.switchStyle);
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }
}
