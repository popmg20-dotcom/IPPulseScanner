package com.getsurfboard.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import defpackage.d70;
import defpackage.gb4;
import defpackage.ha0;
import defpackage.qc3;
import defpackage.r8;
import defpackage.u70;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SparklineView extends View {
    public static final float[] T0 = {0.25f, 0.5f, 0.75f};
    public final Paint A;
    public final Paint A0;
    public final ArrayList B0;
    public float C0;
    public long D0;
    public boolean E0;
    public float[] F0;
    public float[] G0;
    public final float H0;
    public float I0;
    public float J0;
    public float K0;
    public float L0;
    public float M0;
    public float N0;
    public float O0;
    public boolean P0;
    public float Q0;
    public long R0;
    public final r8 S0;
    public final Path b;
    public final Path f;
    public final Paint y0;
    public final Paint z;
    public final Paint z0;

    /* JADX WARN: Illegal instructions before constructor call */
    public SparklineView(Context context, AttributeSet attributeSet, int i) {
        int i2 = 2;
        attributeSet = (i & 2) != 0 ? null : attributeSet;
        super(context, attributeSet, 0);
        this.b = new Path();
        this.f = new Path();
        Paint paint = new Paint(1);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        this.z = paint;
        this.A = new Paint(1);
        Paint paint2 = new Paint(1);
        this.y0 = paint2;
        Paint paint3 = new Paint(1);
        this.z0 = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(style);
        paint4.setPathEffect(new DashPathEffect(new float[]{12.0f, 12.0f}, 0.0f));
        this.A0 = paint4;
        this.B0 = new ArrayList();
        this.F0 = new float[0];
        this.G0 = new float[0];
        this.H0 = getResources().getDisplayMetrics().density * 4.0f;
        this.I0 = -1.0f;
        this.J0 = -1.0f;
        this.L0 = 1.0f;
        this.N0 = 1.0f;
        this.O0 = Float.NaN;
        this.Q0 = 16.0f;
        this.S0 = new r8(i2, this);
        int iD = ContextUtilsKt.d(context, R.attr.colorPrimary);
        float f = getResources().getDisplayMetrics().density * 2.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qc3.c, 0, 0);
        try {
            paint.setColor(typedArrayObtainStyledAttributes.getColor(0, iD));
            paint.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(1, f));
            typedArrayObtainStyledAttributes.recycle();
            paint4.setColor(u70.e(paint.getColor(), 51));
            paint4.setStrokeWidth(getResources().getDisplayMetrics().density);
            paint2.setColor(paint.getColor());
            paint3.setColor(u70.e(paint.getColor(), 76));
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.B0.size() < 2 || this.E0) {
            return;
        }
        this.E0 = true;
        this.R0 = 0L;
        Choreographer.getInstance().postFrameCallback(this.S0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.E0 = false;
        Choreographer.getInstance().removeFrameCallback(this.S0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        ArrayList arrayList;
        float fH;
        float f2;
        float fT;
        float f3;
        float f4;
        int i;
        int i2;
        float f5;
        ArrayList arrayList2;
        float fFloatValue;
        canvas.getClass();
        super.onDraw(canvas);
        ArrayList arrayList3 = this.B0;
        if (arrayList3.size() < 2) {
            return;
        }
        Paint paint = this.z;
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        float strokeWidth2 = paint.getStrokeWidth() * 4.5f;
        float strokeWidth3 = paint.getStrokeWidth() * 2.0f;
        float fMax = Math.max(strokeWidth2, strokeWidth3);
        float paddingLeft = getPaddingLeft() + strokeWidth;
        float paddingTop = getPaddingTop() + strokeWidth + fMax;
        float width = (((getWidth() - getPaddingRight()) - strokeWidth) - fMax) - paddingLeft;
        float height = ((getHeight() - getPaddingBottom()) - strokeWidth) - fMax;
        float f6 = height - paddingTop;
        if (width <= 0.0f || f6 <= 0.0f) {
            return;
        }
        float f7 = -this.Q0;
        char c = 0;
        float fExp = 1.0f - ((float) Math.exp(f7 / 350.0f));
        float f8 = this.M0;
        float f9 = this.K0;
        float fH2 = ha0.h(f9, f8, fExp, f8);
        this.M0 = fH2;
        float f10 = this.N0;
        this.N0 = ha0.h(this.L0, f10, fExp, f10);
        if (Math.abs(fH2 - f9) < 0.01f) {
            this.M0 = this.K0;
        }
        if (Math.abs(this.N0 - this.L0) < 0.01f) {
            this.N0 = this.L0;
        }
        Object obj = arrayList3.get(arrayList3.size() - 1);
        obj.getClass();
        float fFloatValue2 = ((Number) obj).floatValue();
        float f11 = this.N0;
        float f12 = this.M0;
        float f13 = ((1.0f - ((fFloatValue2 - f12) / (f11 - f12))) * f6) + paddingTop;
        float f14 = paddingTop + f6;
        float fT2 = gb4.t(f13, paddingTop, f14);
        if (Float.isNaN(this.O0)) {
            fH = fT2;
            f = 0.01f;
            arrayList = arrayList3;
        } else {
            float f15 = this.O0;
            f = 0.01f;
            arrayList = arrayList3;
            fH = ha0.h(1.0f, (float) Math.exp(f7 / 150.0f), fT2 - f15, f15);
        }
        this.O0 = fH;
        if (Math.abs(fH - fT2) < f) {
            this.O0 = fT2;
        }
        this.P0 = this.M0 == this.K0 && this.N0 == this.L0 && this.O0 == fT2;
        for (int i3 = 0; i3 < 3; i3++) {
            float f16 = (T0[i3] * f6) + paddingTop;
            canvas.drawLine(paddingLeft, f16, paddingLeft + width, f16, this.A0);
            c = c;
        }
        int size = arrayList.size();
        int i4 = size - 1;
        float f17 = width / i4;
        float f18 = f14;
        if (this.D0 == 0) {
            f2 = strokeWidth;
            fT = 0.0f;
        } else {
            f2 = strokeWidth;
            fT = gb4.t((SystemClock.elapsedRealtime() - this.D0) / 1000.0f, 0.0f, 1.0f);
        }
        Path path = this.b;
        path.reset();
        if (this.F0.length < size) {
            this.F0 = new float[size];
            this.G0 = new float[size];
        }
        float f19 = this.N0 - this.M0;
        int i5 = 0;
        while (i5 < size) {
            int i6 = size;
            if (i5 == 0) {
                fFloatValue = this.C0;
                f5 = f18;
                arrayList2 = arrayList;
            } else {
                f5 = f18;
                arrayList2 = arrayList;
                Object obj2 = arrayList2.get(i5 - 1);
                obj2.getClass();
                fFloatValue = ((Number) obj2).floatValue();
            }
            float f20 = fFloatValue;
            this.F0[i5] = ha0.h(i5, fT, f17, paddingLeft);
            float[] fArr = this.G0;
            float f21 = ((1.0f - ((f20 - this.M0) / f19)) * f6) + paddingTop;
            float f22 = f17;
            float f23 = f5;
            fArr[i5] = gb4.t(f21, paddingTop, f23);
            i5++;
            ArrayList arrayList4 = arrayList2;
            f18 = f23;
            f17 = f22;
            arrayList = arrayList4;
            size = i6;
        }
        int i7 = size;
        float f24 = f17;
        path.moveTo(this.F0[0], this.G0[0]);
        int i8 = 0;
        while (true) {
            f3 = this.H0;
            if (i8 >= i4) {
                break;
            }
            int i9 = i8 + 1;
            float f25 = this.F0[i9];
            float[] fArr2 = this.G0;
            float f26 = fArr2[i8];
            float f27 = fArr2[i9];
            float f28 = f27 - f26;
            if (f28 == 0.0f) {
                path.lineTo(f25, f27);
                i = i4;
                i2 = i9;
            } else {
                i = i4;
                i2 = i9;
                float fMin = Math.min(f3, Math.min(f24 / 2.0f, Math.abs(f28) / 2.0f));
                float f29 = f28 > 0.0f ? 1.0f : -1.0f;
                path.lineTo(f25 - fMin, f26);
                float f30 = f29 * fMin;
                path.quadTo(f25, f26, f25, f26 + f30);
                path.lineTo(f25, f27 - f30);
                path.quadTo(f25, f27, fMin + f25, f27);
            }
            i4 = i;
            i8 = i2;
        }
        int i10 = i4;
        float f31 = paddingLeft + width;
        float[] fArr3 = this.G0;
        float f32 = fArr3[i10];
        float f33 = f32 - fArr3[i7 - 2];
        float[] fArr4 = this.F0;
        float fMin2 = f33 == 0.0f ? fArr4[i10] : Math.min(f3, Math.min(f24 / 2.0f, Math.abs(f33) / 2.0f)) + fArr4[i10];
        float f34 = this.O0;
        float f35 = f34 - f32;
        if (f35 == 0.0f) {
            path.lineTo(f31, f34);
        } else {
            path.lineTo(Math.max(f31 - Math.min(f3, Math.min(f24 / 2.0f, Math.abs(f35) / 2.0f)), fMin2), f32);
            path.quadTo(f31, f32, f31, this.O0);
        }
        canvas.save();
        canvas.clipRect(paddingLeft, 0.0f, f31 + f2, getHeight());
        float f36 = this.I0;
        Paint paint2 = this.A;
        if (f36 == paddingTop) {
            f4 = height;
            if (this.J0 != f4) {
            }
            Path path2 = this.f;
            path2.reset();
            path2.addPath(path);
            path2.lineTo(f31, f4);
            path2.lineTo(this.F0[0], f4);
            path2.close();
            canvas.drawPath(path2, paint2);
            canvas.drawPath(path, paint);
            canvas.restore();
            canvas.drawCircle(f31, this.O0, strokeWidth2, this.z0);
            canvas.drawCircle(f31, this.O0, strokeWidth3, this.y0);
        }
        f4 = height;
        this.I0 = paddingTop;
        this.J0 = f4;
        paint2.setShader(new LinearGradient(0.0f, paddingTop, 0.0f, f4, u70.e(paint.getColor(), 89), u70.e(paint.getColor(), 0), Shader.TileMode.CLAMP));
        Path path22 = this.f;
        path22.reset();
        path22.addPath(path);
        path22.lineTo(f31, f4);
        path22.lineTo(this.F0[0], f4);
        path22.close();
        canvas.drawPath(path22, paint2);
        canvas.drawPath(path, paint);
        canvas.restore();
        canvas.drawCircle(f31, this.O0, strokeWidth2, this.z0);
        canvas.drawCircle(f31, this.O0, strokeWidth3, this.y0);
    }

    public final void setValues(List<Float> list) {
        boolean z;
        list.getClass();
        ArrayList arrayList = this.B0;
        if (arrayList.isEmpty() || list.size() != arrayList.size()) {
            z = false;
            break;
        }
        int size = list.size() - 1;
        int i = 0;
        while (i < size) {
            float fFloatValue = list.get(i).floatValue();
            i++;
            if (fFloatValue != ((Number) arrayList.get(i)).floatValue()) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            Object obj = arrayList.get(0);
            obj.getClass();
            this.C0 = ((Number) obj).floatValue();
            arrayList.clear();
            arrayList.addAll(list);
            this.D0 = SystemClock.elapsedRealtime();
        } else {
            arrayList.clear();
            arrayList.addAll(list);
            Float f = (Float) d70.e0(list);
            this.C0 = f != null ? f.floatValue() : 0.0f;
            this.D0 = 0L;
        }
        float f2 = this.C0;
        Iterator it = arrayList.iterator();
        float f3 = f2;
        while (it.hasNext()) {
            float fFloatValue2 = ((Number) it.next()).floatValue();
            if (fFloatValue2 < f2) {
                f2 = fFloatValue2;
            }
            if (fFloatValue2 > f3) {
                f3 = fFloatValue2;
            }
        }
        if (f2 == f3) {
            float fMax = Math.max(Math.abs(f2) * 0.5f, 1.0f);
            f2 -= fMax;
            f3 += fMax;
        }
        Float fValueOf = Float.valueOf(f2);
        Float fValueOf2 = Float.valueOf(f3);
        float fFloatValue3 = fValueOf.floatValue();
        float fFloatValue4 = fValueOf2.floatValue();
        this.K0 = fFloatValue3;
        this.L0 = fFloatValue4;
        if (!z) {
            this.M0 = fFloatValue3;
            this.N0 = fFloatValue4;
            this.O0 = Float.NaN;
        }
        if (list.size() >= 2 && !this.E0) {
            this.E0 = true;
            this.R0 = 0L;
            Choreographer.getInstance().postFrameCallback(this.S0);
        }
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SparklineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4);
        context.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SparklineView(Context context) {
        this(context, null, 6);
        context.getClass();
    }
}
