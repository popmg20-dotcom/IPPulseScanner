package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import defpackage.co4;
import defpackage.ek0;
import defpackage.fa;
import defpackage.fx3;
import defpackage.jl3;
import defpackage.kb4;
import defpackage.l40;
import defpackage.l72;
import defpackage.ld;
import defpackage.m40;
import defpackage.mb4;
import defpackage.n40;
import defpackage.ni2;
import defpackage.o2;
import defpackage.o40;
import defpackage.ob4;
import defpackage.oi2;
import defpackage.ou3;
import defpackage.p40;
import defpackage.rc3;
import defpackage.rm2;
import defpackage.sn;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vo;
import defpackage.vp1;
import defpackage.wp4;
import defpackage.xm;
import defpackage.yu3;
import io.netty.channel.internal.ChannelUtils;
import io.sentry.android.core.a1;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class Chip extends fa implements o40, yu3, oi2 {
    public static final Rect R0 = new Rect();
    public static final int[] S0 = {R.attr.state_selected};
    public static final int[] T0 = {R.attr.state_checkable};
    public RippleDrawable A0;
    public View.OnClickListener B0;
    public CompoundButton.OnCheckedChangeListener C0;
    public ni2 D0;
    public boolean E0;
    public boolean F0;
    public boolean G0;
    public boolean H0;
    public boolean I0;
    public int J0;
    public int K0;
    public CharSequence L0;
    public final n40 M0;
    public boolean N0;
    public final Rect O0;
    public final RectF P0;
    public final l40 Q0;
    public p40 y0;
    public InsetDrawable z0;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(co4.d0(context, attributeSet, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, com.getsurfboard.R.attr.chipStyle);
        this.O0 = new Rect();
        this.P0 = new RectF();
        this.Q0 = new l40(0, this);
        Context context2 = getContext();
        int i = 1;
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                a1.n("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                vp1.n("Please set left drawable using R.attr#chipIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                vp1.n("Please set start drawable using R.attr#chipIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                vp1.n("Please set end drawable using R.attr#closeIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                vp1.n("Please set end drawable using R.attr#closeIcon.");
                throw null;
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                vp1.n("Chip does not support multi-line text");
                throw null;
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                a1.n("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        p40 p40Var = new p40(context2, attributeSet);
        Context context3 = p40Var.F1;
        int[] iArr = rc3.h;
        TypedArray typedArrayV = fx3.v(context3, attributeSet, iArr, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        p40Var.f2 = typedArrayV.hasValue(39);
        Context context4 = p40Var.F1;
        ColorStateList colorStateListR = l72.r(context4, typedArrayV, 25);
        if (p40Var.Y0 != colorStateListR) {
            p40Var.Y0 = colorStateListR;
            p40Var.onStateChange(p40Var.getState());
        }
        ColorStateList colorStateListR2 = l72.r(context4, typedArrayV, 12);
        if (p40Var.Z0 != colorStateListR2) {
            p40Var.Z0 = colorStateListR2;
            p40Var.onStateChange(p40Var.getState());
        }
        float dimension = typedArrayV.getDimension(20, 0.0f);
        if (p40Var.a1 != dimension) {
            p40Var.a1 = dimension;
            p40Var.invalidateSelf();
            p40Var.G();
        }
        if (typedArrayV.hasValue(13)) {
            p40Var.M(typedArrayV.getDimension(13, 0.0f));
        }
        p40Var.R(l72.r(context4, typedArrayV, 23));
        p40Var.S(typedArrayV.getDimension(24, 0.0f));
        p40Var.c0(l72.r(context4, typedArrayV, 38));
        String text = typedArrayV.getText(5);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(p40Var.f1, text);
        ob4 ob4Var = p40Var.L1;
        if (!zEquals) {
            p40Var.f1 = text;
            ob4Var.e = true;
            p40Var.invalidateSelf();
            p40Var.G();
        }
        kb4 kb4Var = (!typedArrayV.hasValue(0) || (resourceId = typedArrayV.getResourceId(0, 0)) == 0) ? null : new kb4(context4, resourceId);
        kb4Var.l = typedArrayV.getDimension(1, kb4Var.l);
        if (Build.VERSION.SDK_INT >= 26) {
            int i2 = typedArrayV.hasValue(34) ? 34 : 7;
            if (typedArrayV.hasValue(i2)) {
                kb4Var.c = typedArrayV.getString(i2);
            }
        }
        ob4Var.b(kb4Var, context4);
        int i3 = typedArrayV.getInt(3, 0);
        if (i3 == 1) {
            p40Var.c2 = TextUtils.TruncateAt.START;
        } else if (i3 == 2) {
            p40Var.c2 = TextUtils.TruncateAt.MIDDLE;
        } else if (i3 == 3) {
            p40Var.c2 = TextUtils.TruncateAt.END;
        }
        p40Var.Q(typedArrayV.getBoolean(19, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            p40Var.Q(typedArrayV.getBoolean(16, false));
        }
        p40Var.N(l72.u(context4, typedArrayV, 15));
        if (typedArrayV.hasValue(18)) {
            p40Var.P(l72.r(context4, typedArrayV, 18));
        }
        p40Var.O(typedArrayV.getDimension(17, -1.0f));
        p40Var.Z(typedArrayV.getBoolean(32, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            p40Var.Z(typedArrayV.getBoolean(27, false));
        }
        p40Var.T(l72.u(context4, typedArrayV, 26));
        p40Var.Y(l72.r(context4, typedArrayV, 31));
        p40Var.V(typedArrayV.getDimension(29, 0.0f));
        p40Var.I(typedArrayV.getBoolean(6, false));
        p40Var.L(typedArrayV.getBoolean(11, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            p40Var.L(typedArrayV.getBoolean(9, false));
        }
        p40Var.J(l72.u(context4, typedArrayV, 8));
        if (typedArrayV.hasValue(10)) {
            p40Var.K(l72.r(context4, typedArrayV, 10));
        }
        p40Var.v1 = rm2.a(context4, typedArrayV, 41);
        p40Var.w1 = rm2.a(context4, typedArrayV, 35);
        float dimension2 = typedArrayV.getDimension(22, 0.0f);
        if (p40Var.x1 != dimension2) {
            p40Var.x1 = dimension2;
            p40Var.invalidateSelf();
            p40Var.G();
        }
        p40Var.b0(typedArrayV.getDimension(37, 0.0f));
        p40Var.a0(typedArrayV.getDimension(36, 0.0f));
        float dimension3 = typedArrayV.getDimension(43, 0.0f);
        if (p40Var.A1 != dimension3) {
            p40Var.A1 = dimension3;
            p40Var.invalidateSelf();
            p40Var.G();
        }
        float dimension4 = typedArrayV.getDimension(42, 0.0f);
        if (p40Var.B1 != dimension4) {
            p40Var.B1 = dimension4;
            p40Var.invalidateSelf();
            p40Var.G();
        }
        p40Var.W(typedArrayV.getDimension(30, 0.0f));
        p40Var.U(typedArrayV.getDimension(28, 0.0f));
        float dimension5 = typedArrayV.getDimension(14, 0.0f);
        if (p40Var.E1 != dimension5) {
            p40Var.E1 = dimension5;
            p40Var.invalidateSelf();
            p40Var.G();
        }
        p40Var.e2 = typedArrayV.getDimensionPixelSize(4, ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
        typedArrayV.recycle();
        fx3.c(context2, attributeSet, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action);
        fx3.e(context2, attributeSet, iArr, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action);
        this.I0 = typedArrayObtainStyledAttributes.getBoolean(33, false);
        TypedValue typedValueA = ek0.A(context2, com.getsurfboard.R.attr.minTouchTargetSize);
        this.K0 = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(21, (int) ((typedValueA == null || typedValueA.type != 5) ? context2.getResources().getDimension(com.getsurfboard.R.dimen.mtrl_min_touch_target_size) : typedValueA.getDimension(context2.getResources().getDisplayMetrics()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(p40Var);
        p40Var.o(getElevation());
        fx3.c(context2, attributeSet, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action);
        fx3.e(context2, attributeSet, iArr, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(39);
        typedArrayObtainStyledAttributes2.recycle();
        this.M0 = new n40(this, this);
        d();
        if (!zHasValue) {
            setOutlineProvider(new m40(this));
        }
        setChecked(this.E0);
        setText(p40Var.f1);
        setEllipsize(p40Var.c2);
        g();
        if (!this.y0.d2) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        f();
        if (this.I0) {
            setMinHeight(this.K0);
        }
        this.J0 = getLayoutDirection();
        super.setOnCheckedChangeListener(new ld(this, i));
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.P0;
        rectF.setEmpty();
        if (c() && this.B0 != null) {
            p40 p40Var = this.y0;
            Rect bounds = p40Var.getBounds();
            rectF.setEmpty();
            if (p40Var.f0()) {
                float f = p40Var.E1 + p40Var.D1 + p40Var.p1 + p40Var.C1 + p40Var.B1;
                if (p40Var.getLayoutDirection() == 0) {
                    float f2 = bounds.right;
                    rectF.right = f2;
                    rectF.left = f2 - f;
                } else {
                    float f3 = bounds.left;
                    rectF.left = f3;
                    rectF.right = f3 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i = (int) closeIconTouchBounds.left;
        int i2 = (int) closeIconTouchBounds.top;
        int i3 = (int) closeIconTouchBounds.right;
        int i4 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.O0;
        rect.set(i, i2, i3, i4);
        return rect;
    }

    private kb4 getTextAppearance() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.L1.g;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.G0 != z) {
            this.G0 = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.F0 != z) {
            this.F0 = z;
            refreshDrawableState();
        }
    }

    public final void b(int i) {
        this.K0 = i;
        if (!this.I0) {
            InsetDrawable insetDrawable = this.z0;
            if (insetDrawable == null) {
                e();
                return;
            } else {
                if (insetDrawable != null) {
                    this.z0 = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    e();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i - ((int) this.y0.a1));
        int iMax2 = Math.max(0, i - this.y0.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.z0;
            if (insetDrawable2 == null) {
                e();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.z0 = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    e();
                    return;
                }
                return;
            }
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.z0 != null) {
            Rect rect = new Rect();
            this.z0.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                e();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.z0 = new InsetDrawable((Drawable) this.y0, i2, i3, i2, i3);
        e();
    }

    public final boolean c() {
        p40 p40Var = this.y0;
        if (p40Var == null) {
            return false;
        }
        Drawable drawable = p40Var.m1;
        if (drawable == null) {
            drawable = null;
        }
        return drawable != null;
    }

    public final void d() {
        p40 p40Var;
        if (!c() || (p40Var = this.y0) == null || !p40Var.l1 || this.B0 == null) {
            wp4.n(this, null);
            this.N0 = false;
        } else {
            wp4.n(this, this.M0);
            this.N0 = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i;
        if (!this.N0) {
            return super.dispatchHoverEvent(motionEvent);
        }
        n40 n40Var = this.M0;
        AccessibilityManager accessibilityManager = n40Var.h;
        int i2 = 0;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Chip chip = n40Var.n;
                if (chip.c() && chip.getCloseIconTouchBounds().contains(x, y)) {
                    i2 = 1;
                }
                int i3 = n40Var.m;
                if (i3 != i2) {
                    n40Var.m = i2;
                    n40Var.q(i2, 128);
                    n40Var.q(i3, 256);
                    return true;
                }
            } else if (action == 10 && (i = n40Var.m) != Integer.MIN_VALUE) {
                if (i != Integer.MIN_VALUE) {
                    n40Var.m = Integer.MIN_VALUE;
                    n40Var.q(Integer.MIN_VALUE, 128);
                    n40Var.q(i, 256);
                    return true;
                }
            }
        } else if (!super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.N0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        n40 n40Var = this.M0;
        n40Var.getClass();
        boolean zM = false;
        int i = 0;
        zM = false;
        zM = false;
        zM = false;
        zM = false;
        zM = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i2 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i2 = 33;
                                } else if (keyCode == 21) {
                                    i2 = 17;
                                } else if (keyCode != 22) {
                                    i2 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z = false;
                                while (i < repeatCount && n40Var.m(i2, null)) {
                                    i++;
                                    z = true;
                                }
                                zM = z;
                            }
                            break;
                        case 23:
                            if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                                int i3 = n40Var.l;
                                if (i3 != Integer.MIN_VALUE) {
                                    Chip chip = n40Var.n;
                                    if (i3 == 0) {
                                        chip.performClick();
                                    } else if (i3 == 1) {
                                        chip.playSoundEffect(0);
                                        View.OnClickListener onClickListener = chip.B0;
                                        if (onClickListener != null) {
                                            onClickListener.onClick(chip);
                                        }
                                        if (chip.N0) {
                                            chip.M0.q(1, 1);
                                        }
                                    }
                                }
                                zM = true;
                            }
                            break;
                    }
                }
            } else if (keyEvent.hasNoModifiers()) {
                zM = n40Var.m(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                zM = n40Var.m(1, null);
            }
        }
        if (!zM || n40Var.l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // defpackage.fa, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        p40 p40Var = this.y0;
        boolean zX = false;
        int i = 0;
        zX = false;
        if (p40Var != null && p40.F(p40Var.m1)) {
            p40 p40Var2 = this.y0;
            ?? IsEnabled = isEnabled();
            int i2 = IsEnabled;
            if (this.H0) {
                i2 = IsEnabled + 1;
            }
            int i3 = i2;
            if (this.G0) {
                i3 = i2 + 1;
            }
            int i4 = i3;
            if (this.F0) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.H0) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.G0) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.F0) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            zX = p40Var2.X(iArr);
        }
        if (zX) {
            invalidate();
        }
    }

    public final void e() {
        this.A0 = new RippleDrawable(jl3.c(this.y0.e1), getBackgroundDrawable(), null);
        this.y0.getClass();
        setBackground(this.A0);
        f();
    }

    public final void f() {
        p40 p40Var;
        if (TextUtils.isEmpty(getText()) || (p40Var = this.y0) == null) {
            return;
        }
        int iC = (int) (p40Var.C() + p40Var.E1 + p40Var.B1);
        p40 p40Var2 = this.y0;
        int iB = (int) (p40Var2.B() + p40Var2.x1 + p40Var2.A1);
        if (this.z0 != null) {
            Rect rect = new Rect();
            this.z0.getPadding(rect);
            iB += rect.left;
            iC += rect.right;
        }
        setPaddingRelative(iB, getPaddingTop(), iC, getPaddingBottom());
    }

    public final void g() {
        TextPaint paint = getPaint();
        p40 p40Var = this.y0;
        if (p40Var != null) {
            paint.drawableState = p40Var.getState();
        }
        kb4 textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.d(getContext(), paint, this.Q0);
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.L0)) {
            return this.L0;
        }
        p40 p40Var = this.y0;
        if (p40Var == null || !p40Var.r1) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).B0.b) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.z0;
        return insetDrawable == null ? this.y0 : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.t1;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.u1;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.Z0;
        }
        return null;
    }

    public float getChipCornerRadius() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return Math.max(0.0f, p40Var.D());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.y0;
    }

    public float getChipEndPadding() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.E1;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        p40 p40Var = this.y0;
        if (p40Var == null || (drawable = p40Var.h1) == null) {
            return null;
        }
        return drawable;
    }

    public float getChipIconSize() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.j1;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.i1;
        }
        return null;
    }

    public float getChipMinHeight() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.a1;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.x1;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.c1;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.d1;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        p40 p40Var = this.y0;
        if (p40Var == null || (drawable = p40Var.m1) == null) {
            return null;
        }
        return drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.q1;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.D1;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.p1;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.C1;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.o1;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.c2;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.N0) {
            n40 n40Var = this.M0;
            if (n40Var.l == 1 || n40Var.k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    @Override // android.widget.TextView
    public String getFontVariationSettings() {
        p40 p40Var = this.y0;
        if (p40Var == null) {
            return super.getFontVariationSettings();
        }
        kb4 kb4Var = p40Var.L1.g;
        if (kb4Var == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        return kb4Var.c;
    }

    public rm2 getHideMotionSpec() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.w1;
        }
        return null;
    }

    public float getIconEndPadding() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.z1;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.y1;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.e1;
        }
        return null;
    }

    @Override // defpackage.yu3
    public ou3 getShapeAppearanceModel() {
        return this.y0.getShapeAppearanceModel();
    }

    public rm2 getShowMotionSpec() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.v1;
        }
        return null;
    }

    public float getTextEndPadding() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.B1;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            return p40Var.A1;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        uf2.N(this, this.y0);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, S0);
        }
        p40 p40Var = this.y0;
        if (p40Var != null && p40Var.r1) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, T0);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.N0) {
            n40 n40Var = this.M0;
            int i2 = n40Var.l;
            if (i2 != Integer.MIN_VALUE) {
                n40Var.j(i2);
            }
            if (z) {
                n40Var.m(i, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        p40 p40Var = this.y0;
        int i2 = 0;
        accessibilityNodeInfo.setCheckable(p40Var != null && p40Var.r1);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.z) {
                int i3 = 0;
                while (true) {
                    if (i2 >= chipGroup.getChildCount()) {
                        i3 = -1;
                        break;
                    }
                    View childAt = chipGroup.getChildAt(i2);
                    if ((childAt instanceof Chip) && chipGroup.getChildAt(i2).getVisibility() == 0) {
                        if (((Chip) childAt) == this) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    i2++;
                }
                i = i3;
            } else {
                i = -1;
            }
            Object tag = getTag(com.getsurfboard.R.id.row_index_key);
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) o2.a(tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i, false, 1, isChecked()).a);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.J0 != i) {
            this.J0 = i;
            f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.F0) {
                        if (!zContains) {
                            setCloseIconPressed(false);
                        }
                        z = true;
                    }
                }
                z = false;
            } else {
                if (this.F0) {
                    playSoundEffect(0);
                    View.OnClickListener onClickListener = this.B0;
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                    if (this.N0) {
                        this.M0.q(1, 1);
                    }
                    z = true;
                }
                setCloseIconPressed(false);
            }
            z = false;
            setCloseIconPressed(false);
        } else {
            if (zContains) {
                setCloseIconPressed(true);
                z = true;
            }
            z = false;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.L0 = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.A0) {
            super.setBackground(drawable);
        } else {
            a1.n("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        a1.n("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // defpackage.fa, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.A0) {
            super.setBackgroundDrawable(drawable);
        } else {
            a1.n("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // defpackage.fa, android.view.View
    public void setBackgroundResource(int i) {
        a1.n("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        a1.n("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        a1.n("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.I(z);
        }
    }

    public void setCheckableResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.I(p40Var.F1.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        p40 p40Var = this.y0;
        if (p40Var == null) {
            this.E0 = z;
        } else if (p40Var.r1) {
            super.setChecked(z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.J(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.J(vo.r(p40Var.F1, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.K(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.K(v9.g(p40Var.F1, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.L(p40Var.F1.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        p40 p40Var = this.y0;
        if (p40Var == null || p40Var.Z0 == colorStateList) {
            return;
        }
        p40Var.Z0 = colorStateList;
        p40Var.onStateChange(p40Var.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        ColorStateList colorStateListG;
        p40 p40Var = this.y0;
        if (p40Var == null || p40Var.Z0 == (colorStateListG = v9.g(p40Var.F1, i))) {
            return;
        }
        p40Var.Z0 = colorStateListG;
        p40Var.onStateChange(p40Var.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.M(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.M(p40Var.F1.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(p40 p40Var) {
        p40 p40Var2 = this.y0;
        if (p40Var2 != p40Var) {
            if (p40Var2 != null) {
                p40Var2.b2 = new WeakReference(null);
            }
            this.y0 = p40Var;
            p40Var.d2 = false;
            p40Var.b2 = new WeakReference(this);
            b(this.K0);
        }
    }

    public void setChipEndPadding(float f) {
        p40 p40Var = this.y0;
        if (p40Var == null || p40Var.E1 == f) {
            return;
        }
        p40Var.E1 = f;
        p40Var.invalidateSelf();
        p40Var.G();
    }

    public void setChipEndPaddingResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            float dimension = p40Var.F1.getResources().getDimension(i);
            if (p40Var.E1 != dimension) {
                p40Var.E1 = dimension;
                p40Var.invalidateSelf();
                p40Var.G();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.N(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.N(vo.r(p40Var.F1, i));
        }
    }

    public void setChipIconSize(float f) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.O(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.O(p40Var.F1.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.P(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.P(v9.g(p40Var.F1, i));
        }
    }

    public void setChipIconVisible(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.Q(p40Var.F1.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        p40 p40Var = this.y0;
        if (p40Var == null || p40Var.a1 == f) {
            return;
        }
        p40Var.a1 = f;
        p40Var.invalidateSelf();
        p40Var.G();
    }

    public void setChipMinHeightResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            float dimension = p40Var.F1.getResources().getDimension(i);
            if (p40Var.a1 != dimension) {
                p40Var.a1 = dimension;
                p40Var.invalidateSelf();
                p40Var.G();
            }
        }
    }

    public void setChipStartPadding(float f) {
        p40 p40Var = this.y0;
        if (p40Var == null || p40Var.x1 == f) {
            return;
        }
        p40Var.x1 = f;
        p40Var.invalidateSelf();
        p40Var.G();
    }

    public void setChipStartPaddingResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            float dimension = p40Var.F1.getResources().getDimension(i);
            if (p40Var.x1 != dimension) {
                p40Var.x1 = dimension;
                p40Var.invalidateSelf();
                p40Var.G();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.R(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.R(v9.g(p40Var.F1, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.S(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.S(p40Var.F1.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.T(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        p40 p40Var = this.y0;
        if (p40Var == null || p40Var.q1 == charSequence) {
            return;
        }
        String str = xm.b;
        xm xmVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? xm.e : xm.d;
        xmVar.getClass();
        sn snVar = mb4.a;
        p40Var.q1 = xmVar.c(charSequence);
        p40Var.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.U(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.U(p40Var.F1.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.T(vo.r(p40Var.F1, i));
        }
        d();
    }

    public void setCloseIconSize(float f) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.V(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.V(p40Var.F1.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.W(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.W(p40Var.F1.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.Y(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.Y(v9.g(p40Var.F1, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // defpackage.fa, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            vp1.n("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            vp1.n("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // defpackage.fa, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            vp1.n("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            vp1.n("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            vp1.n("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            vp1.n("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            vp1.n("Please set start drawable using R.attr#chipIcon.");
        } else if (i3 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        } else {
            vp1.n("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.o(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.y0 == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            vp1.n("Text within a chip are not allowed to scroll.");
            return;
        }
        super.setEllipsize(truncateAt);
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.c2 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.I0 = z;
        b(this.K0);
    }

    @Override // android.widget.TextView
    public final boolean setFontVariationSettings(String str) {
        super.setFontVariationSettings(str);
        p40 p40Var = this.y0;
        if (p40Var == null) {
            return false;
        }
        kb4 kb4Var = p40Var.L1.g;
        if (kb4Var != null && Build.VERSION.SDK_INT >= 26) {
            kb4Var.c = str;
        }
        g();
        return true;
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            a1.n("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(rm2 rm2Var) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.w1 = rm2Var;
        }
    }

    public void setHideMotionSpecResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.w1 = rm2.b(p40Var.F1, i);
        }
    }

    public void setIconEndPadding(float f) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.a0(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.a0(p40Var.F1.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.b0(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.b0(p40Var.F1.getResources().getDimension(i));
        }
    }

    @Override // defpackage.oi2
    public void setInternalOnCheckedChangeListener(ni2 ni2Var) {
        this.D0 = ni2Var;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.y0 == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
        } else {
            vp1.n("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
        } else {
            vp1.n("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.e2 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
        } else {
            vp1.n("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.C0 = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.B0 = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.c0(colorStateList);
        }
        this.y0.getClass();
        e();
    }

    public void setRippleColorResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.c0(v9.g(p40Var.F1, i));
            this.y0.getClass();
            e();
        }
    }

    @Override // defpackage.yu3
    public void setShapeAppearanceModel(ou3 ou3Var) {
        this.y0.setShapeAppearanceModel(ou3Var);
    }

    public void setShowMotionSpec(rm2 rm2Var) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.v1 = rm2Var;
        }
    }

    public void setShowMotionSpecResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.v1 = rm2.b(p40Var.F1, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
        } else {
            vp1.n("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        p40 p40Var = this.y0;
        if (p40Var == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(p40Var.d2 ? null : charSequence, bufferType);
        p40 p40Var2 = this.y0;
        if (p40Var2 == null || TextUtils.equals(p40Var2.f1, charSequence)) {
            return;
        }
        p40Var2.f1 = charSequence;
        p40Var2.L1.e = true;
        p40Var2.invalidateSelf();
        p40Var2.G();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        p40 p40Var = this.y0;
        if (p40Var != null) {
            Context context2 = p40Var.F1;
            p40Var.L1.b(new kb4(context2, i), context2);
        }
        g();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        p40 p40Var = this.y0;
        if (p40Var == null || p40Var.B1 == f) {
            return;
        }
        p40Var.B1 = f;
        p40Var.invalidateSelf();
        p40Var.G();
    }

    public void setTextEndPaddingResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            float dimension = p40Var.F1.getResources().getDimension(i);
            if (p40Var.B1 != dimension) {
                p40Var.B1 = dimension;
                p40Var.invalidateSelf();
                p40Var.G();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        p40 p40Var = this.y0;
        if (p40Var != null) {
            float fApplyDimension = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
            ob4 ob4Var = p40Var.L1;
            kb4 kb4Var = ob4Var.g;
            if (kb4Var != null) {
                kb4Var.l = fApplyDimension;
                ob4Var.a.setTextSize(fApplyDimension);
                p40Var.a();
            }
        }
        g();
    }

    public void setTextStartPadding(float f) {
        p40 p40Var = this.y0;
        if (p40Var == null || p40Var.A1 == f) {
            return;
        }
        p40Var.A1 = f;
        p40Var.invalidateSelf();
        p40Var.G();
    }

    public void setTextStartPaddingResource(int i) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            float dimension = p40Var.F1.getResources().getDimension(i);
            if (p40Var.A1 != dimension) {
                p40Var.A1 = dimension;
                p40Var.invalidateSelf();
                p40Var.G();
            }
        }
    }

    public void setCloseIconVisible(boolean z) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.Z(z);
        }
        d();
    }

    public void setCheckedIconVisible(boolean z) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.L(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.Q(z);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            vp1.n("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            vp1.n("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            vp1.n("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            vp1.n("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(kb4 kb4Var) {
        p40 p40Var = this.y0;
        if (p40Var != null) {
            p40Var.L1.b(kb4Var, p40Var.F1);
        }
        g();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        p40 p40Var = this.y0;
        if (p40Var != null) {
            Context context = p40Var.F1;
            p40Var.L1.b(new kb4(context, i), context);
        }
        g();
    }

    public Chip(Context context) {
        this(context, null);
    }
}
