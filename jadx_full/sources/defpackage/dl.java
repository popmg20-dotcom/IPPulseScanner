package defpackage;

import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.getsurfboard.R;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class dl extends ProgressBar {
    public final int A;
    public u8 A0;
    public boolean B0;
    public int C0;
    public boolean D0;
    public final al E0;
    public final bl F0;
    public final bl G0;
    public final cl H0;
    public final cl I0;
    public final el b;
    public int f;
    public final int y0;
    public final boolean z;
    public long z0;

    public dl(Context context, AttributeSet attributeSet, int i, int i2) {
        super(co4.d0(context, attributeSet, i, R.style.Widget_MaterialComponents_ProgressIndicator), attributeSet, i);
        this.z0 = -1L;
        this.B0 = false;
        this.C0 = 4;
        this.E0 = new al(0, this);
        this.F0 = new bl(this, 0);
        this.G0 = new bl(this, 1);
        this.H0 = new cl(this, 0);
        this.I0 = new cl(this, 1);
        Context context2 = getContext();
        this.b = a(context2, attributeSet);
        fx3.c(context2, attributeSet, i, i2);
        int[] iArr = rc3.d;
        fx3.e(context2, attributeSet, iArr, i, i2, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i, i2);
        this.A = typedArrayObtainStyledAttributes.getInt(7, -1);
        this.y0 = Math.min(typedArrayObtainStyledAttributes.getInt(5, -1), 1000);
        typedArrayObtainStyledAttributes.recycle();
        this.A0 = new u8();
        this.z = true;
    }

    private ay0 getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().E0;
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().E0;
    }

    public abstract el a(Context context, AttributeSet attributeSet);

    public final void b() {
        if (getVisibility() != 0) {
            removeCallbacks(this.F0);
            return;
        }
        bl blVar = this.G0;
        removeCallbacks(blVar);
        long jUptimeMillis = SystemClock.uptimeMillis() - this.z0;
        long j = this.y0;
        if (jUptimeMillis >= j) {
            blVar.run();
        } else {
            postDelayed(blVar, j - jUptimeMillis);
        }
    }

    public final void c() {
        if (getProgressDrawable() == null || getIndeterminateDrawable() == null) {
            return;
        }
        getIndeterminateDrawable().F0.q(this.H0);
    }

    public void d(int i) {
        if (!isIndeterminate()) {
            super.setProgress(i);
            if (getProgressDrawable() != null) {
                getProgressDrawable().jumpToCurrentState();
                return;
            }
            return;
        }
        if (getProgressDrawable() != null) {
            this.f = i;
            this.B0 = true;
            if (getIndeterminateDrawable().isVisible()) {
                u8 u8Var = this.A0;
                ContentResolver contentResolver = getContext().getContentResolver();
                u8Var.getClass();
                if (u8.a(contentResolver) != 0.0f) {
                    getIndeterminateDrawable().F0.r();
                    return;
                }
            }
            this.H0.a(getIndeterminateDrawable());
        }
    }

    public final void e() {
        int i = this.A;
        bl blVar = this.F0;
        if (i <= 0) {
            blVar.run();
        } else {
            removeCallbacks(blVar);
            postDelayed(blVar, i);
        }
    }

    public final boolean f() {
        if (!isAttachedToWindow() || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.b.h;
    }

    @Override // android.widget.ProgressBar
    public rz1 getIndeterminateDrawable() {
        return (rz1) super.getIndeterminateDrawable();
    }

    public int[] getIndicatorColor() {
        return this.b.e;
    }

    public int getIndicatorTrackGapSize() {
        return this.b.i;
    }

    @Override // android.widget.ProgressBar
    public tt0 getProgressDrawable() {
        return (tt0) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.b.g;
    }

    public int getTrackColor() {
        return this.b.f;
    }

    public int getTrackCornerRadius() {
        return this.b.b;
    }

    public float getTrackCornerRadiusFraction() {
        return this.b.c;
    }

    public int getTrackThickness() {
        return this.b.a;
    }

    public int getWaveAmplitude() {
        return this.b.l;
    }

    public int getWaveSpeed() {
        return this.b.m;
    }

    public int getWavelengthDeterminate() {
        return this.b.j;
    }

    public int getWavelengthIndeterminate() {
        return this.b.k;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        tt0 progressDrawable = getProgressDrawable();
        cl clVar = this.I0;
        if (progressDrawable != null) {
            tt0 progressDrawable2 = getProgressDrawable();
            ArrayList arrayList = progressDrawable2.Z;
            if (arrayList == null) {
                arrayList = new ArrayList();
                progressDrawable2.Z = arrayList;
            }
            if (!arrayList.contains(clVar)) {
                progressDrawable2.Z.add(clVar);
            }
        }
        if (getIndeterminateDrawable() != null) {
            rz1 indeterminateDrawable = getIndeterminateDrawable();
            ArrayList arrayList2 = indeterminateDrawable.Z;
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                indeterminateDrawable.Z = arrayList2;
            }
            if (!arrayList2.contains(clVar)) {
                indeterminateDrawable.Z.add(clVar);
            }
        }
        if (f()) {
            if (this.y0 > 0) {
                this.z0 = SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.G0);
        removeCallbacks(this.F0);
        ((vx0) getCurrentDrawable()).d(false, false, false);
        rz1 indeterminateDrawable = getIndeterminateDrawable();
        cl clVar = this.I0;
        if (indeterminateDrawable != null) {
            getIndeterminateDrawable().f(clVar);
            getIndeterminateDrawable().F0.z();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().f(clVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        try {
            int iSave = canvas.save();
            if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
                canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            }
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        getCurrentDrawingDelegate().g();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i, int i2) {
        try {
            ay0 currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i2) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        if (this.z) {
            ((vx0) getCurrentDrawable()).d(f(), false, z);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.z) {
            ((vx0) getCurrentDrawable()).d(f(), false, false);
        }
    }

    public void setAnimatorDurationScaleProvider(u8 u8Var) {
        this.A0 = u8Var;
        if (getProgressDrawable() != null) {
            getProgressDrawable().z = u8Var;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().z = u8Var;
        }
    }

    public void setHideAfterMaxProgress(boolean z) {
        if (getProgressDrawable() == null) {
            return;
        }
        al alVar = this.E0;
        if (z) {
            ArrayList arrayList = getProgressDrawable().F0.k;
            if (arrayList.contains(alVar)) {
                return;
            }
            arrayList.add(alVar);
            return;
        }
        ArrayList arrayList2 = getProgressDrawable().F0.k;
        int iIndexOf = arrayList2.indexOf(alVar);
        if (iIndexOf >= 0) {
            arrayList2.set(iIndexOf, null);
        }
    }

    public void setHideAnimationBehavior(int i) {
        this.b.h = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        try {
            if (z == isIndeterminate()) {
                return;
            }
            vx0 vx0Var = (vx0) getCurrentDrawable();
            if (vx0Var != null) {
                vx0Var.d(false, false, false);
            }
            super.setIndeterminate(z);
            vx0 vx0Var2 = (vx0) getCurrentDrawable();
            if (vx0Var2 != null) {
                vx0Var2.d(f(), false, false);
            }
            if ((vx0Var2 instanceof rz1) && f()) {
                ((rz1) vx0Var2).F0.x();
            }
            this.B0 = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIndeterminateAnimatorDurationScale(float f) {
        el elVar = this.b;
        if (elVar.n != f) {
            elVar.n = f;
            getIndeterminateDrawable().F0.n();
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable instanceof rz1) {
            ((vx0) drawable).d(false, false, false);
            super.setIndeterminateDrawable(drawable);
        } else if (this.D0) {
            xe.k("Cannot set framework drawable as indeterminate drawable.");
        } else {
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{n12.z(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.b.e = iArr;
        getIndeterminateDrawable().F0.n();
        invalidate();
    }

    public void setIndicatorTrackGapSize(int i) {
        el elVar = this.b;
        if (elVar.i != i) {
            elVar.i = i;
            elVar.d();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        d(i);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable instanceof tt0) {
            tt0 tt0Var = (tt0) drawable;
            tt0Var.d(false, false, false);
            super.setProgressDrawable(tt0Var);
            tt0Var.setLevel((int) ((getProgress() / getMax()) * 10000.0f));
            return;
        }
        if (this.D0) {
            xe.k("Cannot set framework drawable as progress drawable.");
        } else {
            super.setProgressDrawable(drawable);
        }
    }

    public void setShowAnimationBehavior(int i) {
        this.b.g = i;
        invalidate();
    }

    public void setTrackColor(int i) {
        el elVar = this.b;
        if (elVar.f != i) {
            elVar.f = i;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i) {
        el elVar = this.b;
        if (elVar.b != i) {
            elVar.b = Math.min(i, elVar.a / 2);
            elVar.d = false;
            invalidate();
        }
    }

    public void setTrackCornerRadiusFraction(float f) {
        el elVar = this.b;
        if (elVar.c != f) {
            elVar.c = Math.min(f, 0.5f);
            elVar.d = true;
            invalidate();
        }
    }

    public void setTrackThickness(int i) {
        el elVar = this.b;
        if (elVar.a != i) {
            elVar.a = i;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i) {
        if (i == 0 || i == 4 || i == 8) {
            this.C0 = i;
        } else {
            xe.k("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
    }

    public void setWaveAmplitude(int i) {
        el elVar = this.b;
        if (elVar.l != i) {
            elVar.l = Math.abs(i);
            requestLayout();
        }
    }

    public void setWaveAmplitudeRampProgressMax(float f) {
        tt0 progressDrawable = getProgressDrawable();
        progressDrawable.f.p = f;
        progressDrawable.invalidateSelf();
        invalidate();
    }

    public void setWaveAmplitudeRampProgressMin(float f) {
        tt0 progressDrawable = getProgressDrawable();
        progressDrawable.f.o = f;
        progressDrawable.invalidateSelf();
        invalidate();
    }

    public void setWaveSpeed(int i) {
        el elVar = this.b;
        elVar.m = i;
        tt0 progressDrawable = getProgressDrawable();
        boolean z = elVar.m != 0;
        ValueAnimator valueAnimator = progressDrawable.J0;
        if (z && !valueAnimator.isRunning()) {
            valueAnimator.start();
        } else {
            if (z || !valueAnimator.isRunning()) {
                return;
            }
            valueAnimator.cancel();
        }
    }

    public void setWavelength(int i) {
        setWavelengthDeterminate(i);
        setWavelengthIndeterminate(i);
    }

    public void setWavelengthDeterminate(int i) {
        el elVar = this.b;
        if (elVar.j != i) {
            elVar.j = Math.abs(i);
            if (isIndeterminate()) {
                return;
            }
            requestLayout();
        }
    }

    public void setWavelengthIndeterminate(int i) {
        el elVar = this.b;
        if (elVar.k != i) {
            elVar.k = Math.abs(i);
            if (isIndeterminate()) {
                requestLayout();
            }
        }
    }
}
