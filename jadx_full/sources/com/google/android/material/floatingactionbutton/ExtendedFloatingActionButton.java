package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import defpackage.c91;
import defpackage.co4;
import defpackage.d3;
import defpackage.d91;
import defpackage.dw2;
import defpackage.e91;
import defpackage.ed4;
import defpackage.eg0;
import defpackage.f91;
import defpackage.fx3;
import defpackage.ou3;
import defpackage.pe0;
import defpackage.po0;
import defpackage.qe0;
import defpackage.rc3;
import defpackage.rm2;
import defpackage.te0;
import defpackage.w7;
import defpackage.xe;
import defpackage.xk;
import defpackage.yk;
import defpackage.zf2;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements pe0 {
    public static final xk u1 = new xk(11, Float.class, "width");
    public static final xk v1 = new xk(12, Float.class, "height");
    public static final xk w1 = new xk(13, Float.class, "paddingStart");
    public static final xk x1 = new xk(14, Float.class, "paddingEnd");
    public int e1;
    public boolean f1;
    public final c91 g1;
    public final c91 h1;
    public final e91 i1;
    public final d91 j1;
    public int k1;
    public int l1;
    public int m1;
    public final ExtendedFloatingActionButtonBehavior n1;
    public boolean o1;
    public boolean p1;
    public boolean q1;
    public ColorStateList r1;
    public int s1;
    public int t1;

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, R.attr.extendedFloatingActionButtonStyle, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon), attributeSet, R.attr.extendedFloatingActionButtonStyle);
        boolean z = false;
        this.e1 = 0;
        this.f1 = true;
        int i = 3;
        zf2 zf2Var = new zf2(i, z);
        e91 e91Var = new e91(this, zf2Var);
        this.i1 = e91Var;
        d91 d91Var = new d91(this, zf2Var);
        this.j1 = d91Var;
        this.o1 = true;
        this.p1 = false;
        this.q1 = false;
        Context context2 = getContext();
        this.n1 = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayV = fx3.v(context2, attributeSet, rc3.k, R.attr.extendedFloatingActionButtonStyle, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon, new int[0]);
        rm2 rm2VarA = rm2.a(context2, typedArrayV, 5);
        rm2 rm2VarA2 = rm2.a(context2, typedArrayV, 4);
        rm2 rm2VarA3 = rm2.a(context2, typedArrayV, 2);
        rm2 rm2VarA4 = rm2.a(context2, typedArrayV, 6);
        this.k1 = typedArrayV.getDimensionPixelSize(0, -1);
        int i2 = typedArrayV.getInt(3, 1);
        this.l1 = getPaddingStart();
        this.m1 = getPaddingEnd();
        zf2 zf2Var2 = new zf2(i, z);
        f91 zf2Var3 = new zf2(23, this);
        eg0 eg0Var = new eg0(13, this, zf2Var3, z);
        c91 c91Var = new c91(this, zf2Var2, i2 != 1 ? i2 != 2 ? new ed4(this, eg0Var, zf2Var3, 19, false) : eg0Var : zf2Var3, true);
        this.h1 = c91Var;
        c91 c91Var2 = new c91(this, zf2Var2, new w7(29, this), false);
        this.g1 = c91Var2;
        e91Var.f = rm2VarA;
        d91Var.f = rm2VarA2;
        c91Var.f = rm2VarA3;
        c91Var2.f = rm2VarA4;
        typedArrayV.recycle();
        setShapeAppearanceModel(ou3.i(context2, attributeSet, R.attr.extendedFloatingActionButtonStyle, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon, ou3.m).b());
        this.r1 = getTextColors();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // defpackage.pe0
    public qe0 getBehavior() {
        return this.n1;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i = this.k1;
        if (i >= 0) {
            return i;
        }
        return getIconSize() + (Math.min(getPaddingStart(), getPaddingEnd()) * 2);
    }

    public int getCurrentOriginalTextColor() {
        return this.r1.getColorForState(getDrawableState(), 0);
    }

    public rm2 getExtendMotionSpec() {
        return this.h1.f;
    }

    public rm2 getHideMotionSpec() {
        return this.j1.f;
    }

    public ColorStateList getOriginalTextColor() {
        return this.r1;
    }

    public rm2 getShowMotionSpec() {
        return this.i1.f;
    }

    public rm2 getShrinkMotionSpec() {
        return this.g1.f;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.o1 || !TextUtils.isEmpty(getText()) || getIcon() == null) {
            x();
        } else {
            this.o1 = false;
            this.g1.g();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.q1 = z;
    }

    public void setAnimationEnabled(boolean z) {
        this.f1 = z;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        x();
    }

    public void setCollapsedSize(int i) {
        this.k1 = i;
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence charSequence) {
        super.setContentDescription(charSequence);
        x();
    }

    public void setExtendMotionSpec(rm2 rm2Var) {
        this.h1.f = rm2Var;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(rm2.b(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.o1 == z) {
            return;
        }
        c91 c91Var = z ? this.h1 : this.g1;
        if (c91Var.h()) {
            return;
        }
        c91Var.g();
    }

    public void setHideMotionSpec(rm2 rm2Var) {
        this.j1.f = rm2Var;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(rm2.b(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (!this.o1 || this.p1) {
            return;
        }
        this.l1 = getPaddingStart();
        this.m1 = getPaddingEnd();
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        if (!this.o1 || this.p1) {
            return;
        }
        this.l1 = i;
        this.m1 = i3;
    }

    public void setShowMotionSpec(rm2 rm2Var) {
        this.i1.f = rm2Var;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(rm2.b(getContext(), i));
    }

    public void setShrinkMotionSpec(rm2 rm2Var) {
        this.g1.f = rm2Var;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(rm2.b(getContext(), i));
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        x();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        this.r1 = getTextColors();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v(int i) {
        yk ykVar;
        if (i == 0) {
            ykVar = this.i1;
        } else if (i == 1) {
            ykVar = this.j1;
        } else if (i == 2) {
            ykVar = this.g1;
        } else {
            if (i != 3) {
                xe.q(dw2.A(i, "Unknown strategy type: "));
                return;
            }
            ykVar = this.h1;
        }
        if (ykVar.h()) {
            return;
        }
        if (this.f1) {
            if (!isLaidOut()) {
                int visibility = getVisibility();
                int i2 = this.e1;
                if (visibility == 0 ? i2 == 1 : i2 != 2) {
                    if (this.q1) {
                        if (!isInEditMode()) {
                            if (i == 2) {
                                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                                if (layoutParams != null) {
                                    this.s1 = layoutParams.width;
                                    this.t1 = layoutParams.height;
                                } else {
                                    this.s1 = getWidth();
                                    this.t1 = getHeight();
                                }
                            }
                            measure(0, 0);
                            AnimatorSet animatorSetA = ykVar.a();
                            animatorSetA.addListener(new d3(6, ykVar));
                            Iterator it = ykVar.c.iterator();
                            while (it.hasNext()) {
                                animatorSetA.addListener((Animator.AnimatorListener) it.next());
                            }
                            animatorSetA.start();
                            return;
                        }
                    }
                }
            }
        }
        ykVar.g();
    }

    public final void w(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public final void x() {
        CharSequence text;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (this.o1 || !isClickable()) {
            text = null;
        } else {
            text = getText();
            if (TextUtils.isEmpty(text)) {
                text = getContentDescription();
            }
        }
        if (TextUtils.equals(getTooltipText(), text)) {
            return;
        }
        setTooltipText(text);
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        this.r1 = getTextColors();
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends qe0 {
        public Rect b;
        public final boolean f;
        public final boolean z;

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.l);
            this.f = typedArrayObtainStyledAttributes.getBoolean(0, false);
            this.z = typedArrayObtainStyledAttributes.getBoolean(1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // defpackage.qe0
        public final /* bridge */ /* synthetic */ boolean e(View view, Rect rect) {
            return false;
        }

        @Override // defpackage.qe0
        public final void g(te0 te0Var) {
            if (te0Var.h == 0) {
                te0Var.h = 80;
            }
        }

        @Override // defpackage.qe0
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                w(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof te0 ? ((te0) layoutParams).a instanceof BottomSheetBehavior : false) {
                    x(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // defpackage.qe0
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            ArrayList arrayListK = coordinatorLayout.k(extendedFloatingActionButton);
            int size = arrayListK.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = (View) arrayListK.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof te0 ? ((te0) layoutParams).a instanceof BottomSheetBehavior : false) && x(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (w(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.q(extendedFloatingActionButton, i);
            return true;
        }

        public final boolean w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            te0 te0Var = (te0) extendedFloatingActionButton.getLayoutParams();
            boolean z = this.f;
            boolean z2 = this.z;
            if ((!z && !z2) || te0Var.f != appBarLayout.getId()) {
                return false;
            }
            Rect rect = this.b;
            if (rect == null) {
                rect = new Rect();
                this.b = rect;
            }
            po0.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                int i = z2 ? 2 : 1;
                xk xkVar = ExtendedFloatingActionButton.u1;
                extendedFloatingActionButton.v(i);
            } else {
                int i2 = z2 ? 3 : 0;
                xk xkVar2 = ExtendedFloatingActionButton.u1;
                extendedFloatingActionButton.v(i2);
            }
            return true;
        }

        public final boolean x(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            te0 te0Var = (te0) extendedFloatingActionButton.getLayoutParams();
            boolean z = this.f;
            boolean z2 = this.z;
            if ((!z && !z2) || te0Var.f != view.getId()) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((te0) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                int i = z2 ? 2 : 1;
                xk xkVar = ExtendedFloatingActionButton.u1;
                extendedFloatingActionButton.v(i);
            } else {
                int i2 = z2 ? 3 : 0;
                xk xkVar2 = ExtendedFloatingActionButton.u1;
                extendedFloatingActionButton.v(i2);
            }
            return true;
        }

        public ExtendedFloatingActionButtonBehavior() {
            this.f = false;
            this.z = true;
        }
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }
}
