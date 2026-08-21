package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.getsurfboard.R;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class rl extends FrameLayout {
    public static final ql F0 = new ql(0);
    public final float A;
    public final int A0;
    public ColorStateList B0;
    public PorterDuff.Mode C0;
    public Rect D0;
    public boolean E0;
    public sl b;
    public final ou3 f;
    public final float y0;
    public int z;
    public final int z0;

    public rl(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        super(co4.d0(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, rc3.N);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.z = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f = ou3.h(context2, attributeSet, 0, 0).b();
        }
        this.A = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(l72.r(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(tj4.V(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.y0 = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.z0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.A0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        getPaddingEnd();
        setOnTouchListener(F0);
        setFocusable(true);
        if (getBackground() == null) {
            int I = n12.I(n12.A(this, R.attr.colorSurface), getBackgroundOverlayColorAlpha(), n12.A(this, R.attr.colorOnSurface));
            ou3 ou3Var = this.f;
            if (ou3Var != null) {
                ub1 ub1Var = sl.v;
                yi2 yi2Var = new yi2(ou3Var);
                yi2Var.p(ColorStateList.valueOf(I));
                drawable = yi2Var;
            } else {
                Resources resources = getResources();
                ub1 ub1Var2 = sl.v;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(I);
                drawable = gradientDrawable;
            }
            ColorStateList colorStateList = this.B0;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
            setBackground(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBaseTransientBottomBar(sl slVar) {
        this.b = slVar;
    }

    public float getActionTextColorAlpha() {
        return this.y0;
    }

    public int getAnimationMode() {
        return this.z;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.A;
    }

    public int getMaxInlineActionWidth() {
        return this.A0;
    }

    public int getMaxWidth() {
        return this.z0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        sl slVar = this.b;
        if (slVar != null) {
            slVar.b();
        }
        requestApplyInsets();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDetachedFromWindow() {
        /*
            r5 = this;
            super.onDetachedFromWindow()
            sl r5 = r5.b
            if (r5 == 0) goto L3d
            iv1 r0 = defpackage.iv1.q()
            pl r1 = r5.u
            java.lang.Object r2 = r0.f
            monitor-enter(r2)
            boolean r3 = r0.r(r1)     // Catch: java.lang.Throwable -> L3a
            r4 = 1
            if (r3 != 0) goto L2b
            java.lang.Object r0 = r0.X     // Catch: java.lang.Throwable -> L3a
            qy3 r0 = (defpackage.qy3) r0     // Catch: java.lang.Throwable -> L3a
            r3 = 0
            if (r0 == 0) goto L28
            java.lang.ref.WeakReference r0 = r0.a     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L3a
            if (r0 != r1) goto L28
            r0 = r4
            goto L29
        L28:
            r0 = r3
        L29:
            if (r0 == 0) goto L2c
        L2b:
            r3 = r4
        L2c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3a
            if (r3 == 0) goto L3d
            android.os.Handler r0 = defpackage.sl.y
            nl r1 = new nl
            r1.<init>(r5, r4)
            r0.post(r1)
            return
        L3a:
            r5 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3a
            throw r5
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rl.onDetachedFromWindow():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        sl slVar = this.b;
        if (slVar == null || !slVar.r) {
            return;
        }
        slVar.e();
        slVar.r = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.z0;
        if (i3 <= 0 || getMeasuredWidth() <= i3) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, Pow2.MAX_POW2), i2);
    }

    public void setAnimationMode(int i) {
        this.z = i;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.B0 != null) {
            drawable = drawable.mutate();
            drawable.setTintList(this.B0);
            drawable.setTintMode(this.C0);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.B0 = colorStateList;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            drawableMutate.setTintList(colorStateList);
            drawableMutate.setTintMode(this.C0);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.C0 = mode;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            drawableMutate.setTintMode(mode);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (this.E0 || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.D0 = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        sl slVar = this.b;
        if (slVar != null) {
            ub1 ub1Var = sl.v;
            slVar.f();
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : F0);
        super.setOnClickListener(onClickListener);
    }
}
