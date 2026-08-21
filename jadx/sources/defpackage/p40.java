package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.chip.Chip;
import io.netty.handler.codec.dns.DnsRecord;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p40 extends yi2 implements Drawable.Callback, nb4 {
    public static final int[] g2 = {R.attr.state_enabled};
    public static final ShapeDrawable h2 = new ShapeDrawable(new OvalShape());
    public float A1;
    public float B1;
    public float C1;
    public float D1;
    public float E1;
    public final Context F1;
    public final Paint G1;
    public final Paint.FontMetrics H1;
    public final RectF I1;
    public final PointF J1;
    public final Path K1;
    public final ob4 L1;
    public int M1;
    public int N1;
    public int O1;
    public int P1;
    public int Q1;
    public int R1;
    public boolean S1;
    public int T1;
    public int U1;
    public ColorFilter V1;
    public PorterDuffColorFilter W1;
    public ColorStateList X1;
    public ColorStateList Y0;
    public PorterDuff.Mode Y1;
    public ColorStateList Z0;
    public int[] Z1;
    public float a1;
    public ColorStateList a2;
    public float b1;
    public WeakReference b2;
    public ColorStateList c1;
    public TextUtils.TruncateAt c2;
    public float d1;
    public boolean d2;
    public ColorStateList e1;
    public int e2;
    public CharSequence f1;
    public boolean f2;
    public boolean g1;
    public Drawable h1;
    public ColorStateList i1;
    public float j1;
    public boolean k1;
    public boolean l1;
    public Drawable m1;
    public RippleDrawable n1;
    public ColorStateList o1;
    public float p1;
    public SpannableStringBuilder q1;
    public boolean r1;
    public boolean s1;
    public Drawable t1;
    public ColorStateList u1;
    public rm2 v1;
    public rm2 w1;
    public float x1;
    public float y1;
    public float z1;

    public p40(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.getsurfboard.R.attr.chipStyle, com.getsurfboard.R.style.Widget_MaterialComponents_Chip_Action);
        this.b1 = -1.0f;
        this.G1 = new Paint(1);
        this.H1 = new Paint.FontMetrics();
        this.I1 = new RectF();
        this.J1 = new PointF();
        this.K1 = new Path();
        this.U1 = DnsRecord.CLASS_ANY;
        this.Y1 = PorterDuff.Mode.SRC_IN;
        this.b2 = new WeakReference(null);
        l(context);
        this.F1 = context;
        ob4 ob4Var = new ob4(this);
        this.L1 = ob4Var;
        this.f1 = "";
        ob4Var.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = g2;
        setState(iArr);
        X(iArr);
        this.d2 = true;
        h2.setTint(-1);
    }

    public static boolean E(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean F(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void g0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final void A(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (e0() || d0()) {
            float f = this.x1 + this.y1;
            Drawable drawable = this.S1 ? this.t1 : this.h1;
            float intrinsicWidth = this.j1;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f2 = rect.left + f;
                rectF.left = f2;
                rectF.right = f2 + intrinsicWidth;
            } else {
                float f3 = rect.right - f;
                rectF.right = f3;
                rectF.left = f3 - intrinsicWidth;
            }
            Drawable drawable2 = this.S1 ? this.t1 : this.h1;
            float fCeil = this.j1;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(tj4.y(this.F1, 24));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float B() {
        if (!e0() && !d0()) {
            return 0.0f;
        }
        float f = this.y1;
        Drawable drawable = this.S1 ? this.t1 : this.h1;
        float intrinsicWidth = this.j1;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.z1;
    }

    public final float C() {
        if (f0()) {
            return this.C1 + this.p1 + this.D1;
        }
        return 0.0f;
    }

    public final float D() {
        return this.f2 ? i() : this.b1;
    }

    public final void G() {
        o40 o40Var = (o40) this.b2.get();
        if (o40Var != null) {
            Chip chip = (Chip) o40Var;
            chip.b(chip.K0);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H(int[] r10, int[] r11) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p40.H(int[], int[]):boolean");
    }

    public final void I(boolean z) {
        if (this.r1 != z) {
            this.r1 = z;
            float fB = B();
            if (!z && this.S1) {
                this.S1 = false;
            }
            float fB2 = B();
            invalidateSelf();
            if (fB != fB2) {
                G();
            }
        }
    }

    public final void J(Drawable drawable) {
        if (this.t1 != drawable) {
            float fB = B();
            this.t1 = drawable;
            float fB2 = B();
            g0(this.t1);
            z(this.t1);
            invalidateSelf();
            if (fB != fB2) {
                G();
            }
        }
    }

    public final void K(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.u1 != colorStateList) {
            this.u1 = colorStateList;
            if (this.s1 && (drawable = this.t1) != null && this.r1) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void L(boolean z) {
        if (this.s1 != z) {
            boolean zD0 = d0();
            this.s1 = z;
            boolean zD02 = d0();
            if (zD0 != zD02) {
                Drawable drawable = this.t1;
                if (zD02) {
                    z(drawable);
                } else {
                    g0(drawable);
                }
                invalidateSelf();
                G();
            }
        }
    }

    public final void M(float f) {
        if (this.b1 != f) {
            this.b1 = f;
            setShapeAppearanceModel(getShapeAppearanceModel().a(f));
        }
    }

    public final void N(Drawable drawable) {
        Drawable drawable2 = this.h1;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fB = B();
            this.h1 = drawable != null ? drawable.mutate() : null;
            float fB2 = B();
            g0(drawable2);
            if (e0()) {
                z(this.h1);
            }
            invalidateSelf();
            if (fB != fB2) {
                G();
            }
        }
    }

    public final void O(float f) {
        if (this.j1 != f) {
            float fB = B();
            this.j1 = f;
            float fB2 = B();
            invalidateSelf();
            if (fB != fB2) {
                G();
            }
        }
    }

    public final void P(ColorStateList colorStateList) {
        this.k1 = true;
        if (this.i1 != colorStateList) {
            this.i1 = colorStateList;
            if (e0()) {
                this.h1.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Q(boolean z) {
        if (this.g1 != z) {
            boolean zE0 = e0();
            this.g1 = z;
            boolean zE02 = e0();
            if (zE0 != zE02) {
                Drawable drawable = this.h1;
                if (zE02) {
                    z(drawable);
                } else {
                    g0(drawable);
                }
                invalidateSelf();
                G();
            }
        }
    }

    public final void R(ColorStateList colorStateList) {
        if (this.c1 != colorStateList) {
            this.c1 = colorStateList;
            if (this.f2) {
                wi2 wi2Var = this.f;
                if (wi2Var.d != colorStateList) {
                    wi2Var.d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void S(float f) {
        if (this.d1 != f) {
            this.d1 = f;
            this.G1.setStrokeWidth(f);
            if (this.f2) {
                this.f.j = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void T(Drawable drawable) {
        Drawable drawable2 = this.m1;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fC = C();
            this.m1 = drawable != null ? drawable.mutate() : null;
            this.n1 = new RippleDrawable(jl3.c(this.e1), this.m1, h2);
            float fC2 = C();
            g0(drawable2);
            if (f0()) {
                z(this.m1);
            }
            invalidateSelf();
            if (fC != fC2) {
                G();
            }
        }
    }

    public final void U(float f) {
        if (this.D1 != f) {
            this.D1 = f;
            invalidateSelf();
            if (f0()) {
                G();
            }
        }
    }

    public final void V(float f) {
        if (this.p1 != f) {
            this.p1 = f;
            invalidateSelf();
            if (f0()) {
                G();
            }
        }
    }

    public final void W(float f) {
        if (this.C1 != f) {
            this.C1 = f;
            invalidateSelf();
            if (f0()) {
                G();
            }
        }
    }

    public final boolean X(int[] iArr) {
        if (Arrays.equals(this.Z1, iArr)) {
            return false;
        }
        this.Z1 = iArr;
        if (f0()) {
            return H(getState(), iArr);
        }
        return false;
    }

    public final void Y(ColorStateList colorStateList) {
        if (this.o1 != colorStateList) {
            this.o1 = colorStateList;
            if (f0()) {
                this.m1.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Z(boolean z) {
        if (this.l1 != z) {
            boolean zF0 = f0();
            this.l1 = z;
            boolean zF02 = f0();
            if (zF0 != zF02) {
                Drawable drawable = this.m1;
                if (zF02) {
                    z(drawable);
                } else {
                    g0(drawable);
                }
                invalidateSelf();
                G();
            }
        }
    }

    @Override // defpackage.nb4
    public final void a() {
        G();
        invalidateSelf();
    }

    public final void a0(float f) {
        if (this.z1 != f) {
            float fB = B();
            this.z1 = f;
            float fB2 = B();
            invalidateSelf();
            if (fB != fB2) {
                G();
            }
        }
    }

    public final void b0(float f) {
        if (this.y1 != f) {
            float fB = B();
            this.y1 = f;
            float fB2 = B();
            invalidateSelf();
            if (fB != fB2) {
                G();
            }
        }
    }

    public final void c0(ColorStateList colorStateList) {
        if (this.e1 != colorStateList) {
            this.e1 = colorStateList;
            this.a2 = null;
            onStateChange(getState());
        }
    }

    public final boolean d0() {
        return this.s1 && this.t1 != null && this.S1;
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        float f;
        float f2;
        int i2;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.U1) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z = this.f2;
        Paint paint = this.G1;
        RectF rectF = this.I1;
        if (!z) {
            paint.setColor(this.M1);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, D(), D(), paint);
        }
        if (!this.f2) {
            paint.setColor(this.N1);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.V1;
            if (colorFilter == null) {
                colorFilter = this.W1;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, D(), D(), paint);
        }
        if (this.f2) {
            super.draw(canvas);
        }
        if (this.d1 > 0.0f && !this.f2) {
            paint.setColor(this.P1);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f2) {
                ColorFilter colorFilter2 = this.V1;
                if (colorFilter2 == null) {
                    colorFilter2 = this.W1;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f3 = bounds.left;
            float f4 = this.d1 / 2.0f;
            rectF.set(f3 + f4, bounds.top + f4, bounds.right - f4, bounds.bottom - f4);
            float f5 = this.b1 - (this.d1 / 2.0f);
            canvas2.drawRoundRect(rectF, f5, f5, paint);
        }
        paint.setColor(this.Q1);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.f2) {
            RectF rectF2 = new RectF(bounds);
            ou3 ou3VarD = this.f.a.d();
            float[] fArr = this.T0;
            float f6 = this.f.i;
            ha1 ha1Var = this.I0;
            y3 y3Var = this.J0;
            f = 2.0f;
            Path path = this.K1;
            y3Var.b(ou3VarD, fArr, f6, rectF2, ha1Var, path);
            e(canvas2, paint, path, this.f.a.d(), this.T0, g());
        } else {
            canvas2.drawRoundRect(rectF, D(), D(), paint);
            f = 2.0f;
        }
        if (e0()) {
            A(bounds, rectF);
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas2.translate(f7, f8);
            this.h1.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.h1.draw(canvas2);
            canvas2.translate(-f7, -f8);
        }
        if (d0()) {
            A(bounds, rectF);
            float f9 = rectF.left;
            float f10 = rectF.top;
            canvas2.translate(f9, f10);
            this.t1.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.t1.draw(canvas2);
            canvas2.translate(-f9, -f10);
        }
        if (this.d2 && this.f1 != null) {
            PointF pointF = this.J1;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f1;
            ob4 ob4Var = this.L1;
            if (charSequence != null) {
                float fB = B() + this.x1 + this.A1;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fB;
                } else {
                    pointF.x = bounds.right - fB;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = ob4Var.a;
                Paint.FontMetrics fontMetrics = this.H1;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / f);
            }
            rectF.setEmpty();
            if (this.f1 != null) {
                float fB2 = B() + this.x1 + this.A1;
                float fC = C() + this.E1 + this.B1;
                int layoutDirection = getLayoutDirection();
                int i3 = bounds.left;
                if (layoutDirection == 0) {
                    rectF.left = i3 + fB2;
                    rectF.right = bounds.right - fC;
                } else {
                    rectF.left = i3 + fC;
                    rectF.right = bounds.right - fB2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            kb4 kb4Var = ob4Var.g;
            TextPaint textPaint2 = ob4Var.a;
            if (kb4Var != null) {
                textPaint2.drawableState = getState();
                ob4Var.g.d(this.F1, textPaint2, ob4Var.b);
            }
            textPaint2.setTextAlign(align);
            String string = this.f1.toString();
            if (ob4Var.e) {
                ob4Var.a(string);
                f2 = ob4Var.c;
            } else {
                f2 = ob4Var.c;
            }
            boolean z2 = Math.round(f2) > Math.round(rectF.width());
            if (z2) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i2 = iSave;
            } else {
                i2 = 0;
            }
            CharSequence charSequenceEllipsize = this.f1;
            if (z2 && this.c2 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.c2);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z2) {
                canvas2.restoreToCount(i2);
            }
        }
        if (f0()) {
            rectF.setEmpty();
            if (f0()) {
                float f11 = this.E1 + this.D1;
                if (getLayoutDirection() == 0) {
                    float f12 = bounds.right - f11;
                    rectF.right = f12;
                    rectF.left = f12 - this.p1;
                } else {
                    float f13 = bounds.left + f11;
                    rectF.left = f13;
                    rectF.right = f13 + this.p1;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f14 = this.p1;
                float f15 = fExactCenterY - (f14 / f);
                rectF.top = f15;
                rectF.bottom = f15 + f14;
            }
            float f16 = rectF.left;
            float f17 = rectF.top;
            canvas2.translate(f16, f17);
            this.m1.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.n1.setBounds(this.m1.getBounds());
            this.n1.jumpToCurrentState();
            this.n1.draw(canvas2);
            canvas2.translate(-f16, -f17);
        }
        if (this.U1 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    public final boolean e0() {
        return this.g1 && this.h1 != null;
    }

    public final boolean f0() {
        return this.l1 && this.m1 != null;
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.U1;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.V1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.a1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float fB = B() + this.x1 + this.A1;
        String string = this.f1.toString();
        ob4 ob4Var = this.L1;
        if (ob4Var.e) {
            ob4Var.a(string);
        }
        return Math.min(Math.round(C() + ob4Var.c + fB + this.B1 + this.E1), this.e2);
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.f2) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.a1, this.b1);
        } else {
            outline.setRoundRect(bounds, this.b1);
            outline2 = outline;
        }
        outline2.setAlpha(this.U1 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (E(this.Y0) || E(this.Z0) || E(this.c1)) {
            return true;
        }
        kb4 kb4Var = this.L1.g;
        if (kb4Var == null || (colorStateList = kb4Var.k) == null || !colorStateList.isStateful()) {
            return (this.s1 && this.t1 != null && this.r1) || F(this.h1) || F(this.t1) || E(this.X1);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (e0()) {
            zOnLayoutDirectionChanged |= this.h1.setLayoutDirection(i);
        }
        if (d0()) {
            zOnLayoutDirectionChanged |= this.t1.setLayoutDirection(i);
        }
        if (f0()) {
            zOnLayoutDirectionChanged |= this.m1.setLayoutDirection(i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (e0()) {
            zOnLevelChange |= this.h1.setLevel(i);
        }
        if (d0()) {
            zOnLevelChange |= this.t1.setLevel(i);
        }
        if (f0()) {
            zOnLevelChange |= this.m1.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable, defpackage.nb4
    public final boolean onStateChange(int[] iArr) {
        if (this.f2) {
            super.onStateChange(iArr);
        }
        return H(iArr, this.Z1);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.U1 != i) {
            this.U1 = i;
            invalidateSelf();
        }
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.V1 != colorFilter) {
            this.V1 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.X1 != colorStateList) {
            this.X1 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.Y1 != mode) {
            this.Y1 = mode;
            ColorStateList colorStateList = this.X1;
            this.W1 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (e0()) {
            visible |= this.h1.setVisible(z, z2);
        }
        if (d0()) {
            visible |= this.t1.setVisible(z, z2);
        }
        if (f0()) {
            visible |= this.m1.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void z(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.m1) {
            drawable.setTintList(this.o1);
            if (drawable.isStateful()) {
                drawable.setState(this.Z1);
                return;
            }
            return;
        }
        Drawable drawable2 = this.h1;
        if (drawable == drawable2 && this.k1) {
            drawable2.setTintList(this.i1);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }
}
