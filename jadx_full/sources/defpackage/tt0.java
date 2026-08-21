package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tt0 extends vx0 {
    public static final st0 O0 = new st0(0);
    public final ay0 E0;
    public final w04 F0;
    public final yx0 G0;
    public float H0;
    public boolean I0;
    public final ValueAnimator J0;
    public ValueAnimator K0;
    public TimeInterpolator L0;
    public TimeInterpolator M0;
    public TimeInterpolator N0;

    public tt0(Context context, el elVar, ay0 ay0Var) {
        super(context, elVar);
        this.I0 = false;
        this.E0 = ay0Var;
        yx0 yx0Var = new yx0();
        this.G0 = yx0Var;
        yx0Var.h = true;
        w04 w04Var = new w04(this, O0);
        this.F0 = w04Var;
        x04 x04Var = new x04();
        x04Var.a(1.0f);
        x04Var.b(50.0f);
        w04Var.m = x04Var;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.J0 = valueAnimator;
        valueAnimator.setDuration(1000L);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new z3(2, this, elVar));
        if (elVar.b(true) && elVar.m != 0) {
            valueAnimator.start();
        }
        if (this.z0 != 1.0f) {
            this.z0 = 1.0f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.C0)) {
            canvas.save();
            Rect bounds = getBounds();
            float fB = b();
            ObjectAnimator objectAnimator = this.A;
            boolean z = objectAnimator != null && objectAnimator.isRunning();
            ObjectAnimator objectAnimator2 = this.X;
            boolean z2 = objectAnimator2 != null && objectAnimator2.isRunning();
            ay0 ay0Var = this.E0;
            ay0Var.a.d();
            ay0Var.a(canvas, bounds, fB, z, z2);
            float fC = c();
            yx0 yx0Var = this.G0;
            yx0Var.f = fC;
            Paint.Style style = Paint.Style.FILL;
            Paint paint = this.A0;
            paint.setStyle(style);
            paint.setAntiAlias(true);
            el elVar = this.f;
            yx0Var.c = elVar.e[0];
            int iL = elVar.i;
            ay0 ay0Var2 = this.E0;
            if (iL > 0) {
                if (!(ay0Var2 instanceof va2)) {
                    iL = (int) ((tj4.l(yx0Var.b, 0.0f, 0.01f) * iL) / 0.01f);
                }
                this.E0.d(canvas, paint, yx0Var.b, 1.0f, elVar.f, this.B0, iL);
            } else {
                ay0Var2.d(canvas, paint, 0.0f, 1.0f, elVar.f, this.B0, 0);
            }
            int i = this.B0;
            ay0 ay0Var3 = this.E0;
            ay0Var3.c(canvas, paint, yx0Var, i);
            ay0Var3.b(canvas, paint, elVar.e[0], this.B0);
            canvas.restore();
        }
    }

    @Override // defpackage.vx0
    public final boolean e(boolean z, boolean z2, boolean z3) {
        boolean zE = super.e(z, z2, z3);
        u8 u8Var = this.z;
        ContentResolver contentResolver = this.b.getContentResolver();
        u8Var.getClass();
        float fA = u8.a(contentResolver);
        if (fA == 0.0f) {
            this.I0 = true;
            return zE;
        }
        this.I0 = false;
        this.F0.m.b(50.0f / fA);
        return zE;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.E0.e();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.E0.f();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.F0.d();
        this.G0.b = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        float f = i;
        el elVar = this.f;
        float f2 = (f < elVar.o * 10000.0f || f > elVar.p * 10000.0f) ? 0.0f : 1.0f;
        boolean z = this.I0;
        yx0 yx0Var = this.G0;
        w04 w04Var = this.F0;
        if (z) {
            w04Var.d();
            yx0Var.b = f / 10000.0f;
            invalidateSelf();
            yx0Var.e = f2;
            invalidateSelf();
        } else {
            int iWidth = getBounds().width();
            int iHeight = getBounds().height();
            if (iWidth > 0 && iHeight > 0) {
                if (this.E0 instanceof va2) {
                    w04Var.b(10000.0f / iWidth);
                } else {
                    w04Var.b((float) (10000.0d / (((double) Math.min(iHeight, iWidth)) * 3.141592653589793d)));
                }
            }
            w04Var.b = yx0Var.b * 10000.0f;
            w04Var.c = true;
            w04Var.a(f);
        }
        return true;
    }
}
