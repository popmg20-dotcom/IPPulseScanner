package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class va2 extends ay0 {
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public boolean m;
    public float n;
    public Pair o;

    @Override // defpackage.ay0
    public final void a(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        if (this.f != rect.width()) {
            this.f = rect.width();
            g();
        }
        float fE = e();
        canvas.translate((rect.width() / 2.0f) + rect.left, Math.max(0.0f, (rect.height() - fE) / 2.0f) + (rect.height() / 2.0f) + rect.top);
        eb2 eb2Var = (eb2) this.a;
        if (eb2Var.s) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f2 = this.f / 2.0f;
        float f3 = fE / 2.0f;
        canvas.clipRect(-f2, -f3, f2, f3);
        this.g = eb2Var.a * f;
        this.h = Math.min(r0 / 2, eb2Var.a()) * f;
        this.j = eb2Var.l * f;
        this.i = Math.min(eb2Var.a / 2.0f, eb2Var.e()) * f;
        if (z || z2) {
            if ((z && eb2Var.g == 2) || (z2 && eb2Var.h == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && eb2Var.h != 3)) {
                canvas.translate(0.0f, ((1.0f - f) * eb2Var.a) / 2.0f);
            }
        }
        if (z2 && eb2Var.h == 3) {
            this.n = f;
        } else {
            this.n = 1.0f;
        }
    }

    @Override // defpackage.ay0
    public final void b(Canvas canvas, Paint paint, int i, int i2) {
        int iN = n12.n(i, i2);
        this.m = false;
        eb2 eb2Var = (eb2) this.a;
        int iMin = Math.min(eb2Var.t, eb2Var.a);
        if (iMin <= 0 || iN == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iN);
        Integer num = eb2Var.u;
        float[] fArr = {(this.f / 2.0f) - (num != null ? (eb2Var.t / 2.0f) + num.floatValue() : this.g / 2.0f), 0.0f};
        float f = iMin;
        j(canvas, paint, new zx0(fArr, new float[]{1.0f, 0.0f}), f, f, (this.h * f) / this.g, null, 0.0f, 0.0f, 0.0f, false);
    }

    @Override // defpackage.ay0
    public final void c(Canvas canvas, Paint paint, yx0 yx0Var, int i) {
        int iN = n12.n(yx0Var.c, i);
        this.m = yx0Var.h;
        float f = yx0Var.a;
        float f2 = yx0Var.b;
        int i2 = yx0Var.d;
        i(canvas, paint, f, f2, iN, i2, i2, yx0Var.e, yx0Var.f, true);
    }

    @Override // defpackage.ay0
    public final void d(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        int iN = n12.n(i, i2);
        this.m = false;
        i(canvas, paint, f, f2, iN, i3, i3, 0.0f, 0.0f, false);
    }

    @Override // defpackage.ay0
    public final int e() {
        el elVar = this.a;
        return (((eb2) elVar).l * 2) + ((eb2) elVar).a;
    }

    @Override // defpackage.ay0
    public final int f() {
        return -1;
    }

    @Override // defpackage.ay0
    public final void g() {
        Path path = this.b;
        path.rewind();
        eb2 eb2Var = (eb2) this.a;
        if (eb2Var.b(this.m)) {
            int i = this.m ? eb2Var.j : eb2Var.k;
            float f = this.f;
            int i2 = (int) (f / i);
            this.k = f / i2;
            for (int i3 = 0; i3 <= i2; i3++) {
                int i4 = i3 * 2;
                float f2 = i4 + 1;
                path.cubicTo(i4 + 0.48f, 0.0f, f2 - 0.48f, 1.0f, f2, 1.0f);
                float f3 = f2 + 0.48f;
                float f4 = i4 + 2;
                path.cubicTo(f3, 1.0f, f4 - 0.48f, 0.0f, f4, 0.0f);
            }
            Matrix matrix = this.e;
            matrix.reset();
            matrix.setScale(this.k / 2.0f, -2.0f);
            matrix.postTranslate(0.0f, 1.0f);
            path.transform(matrix);
        } else {
            path.lineTo(this.f, 0.0f);
        }
        this.d.setPath(path, false);
    }

    public final void i(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3, float f3, float f4, boolean z) {
        float fS;
        float fS2;
        eb2 eb2Var;
        float f5;
        Canvas canvas2;
        Pair pair = this.o;
        float fL = tj4.l(f, 0.0f, 1.0f);
        float fL2 = tj4.l(f2, 0.0f, 1.0f);
        float fS3 = fx3.s(1.0f - this.n, 1.0f, fL);
        float fS4 = fx3.s(1.0f - this.n, 1.0f, fL2);
        int iL = (int) ((tj4.l(fS3, 0.0f, 0.01f) * i2) / 0.01f);
        int iL2 = (int) (((1.0f - tj4.l(fS4, 0.99f, 1.0f)) * i3) / 0.01f);
        float f6 = this.f;
        int i4 = (int) ((fS3 * f6) + iL);
        int i5 = (int) ((fS4 * f6) - iL2);
        float f7 = this.h;
        float f8 = this.i;
        if (f7 != f8) {
            float fMax = Math.max(f7, f8);
            float f9 = this.f;
            float f10 = fMax / f9;
            fS = fx3.s(this.h, this.i, tj4.l(i4 / f9, 0.0f, f10) / f10);
            float f11 = this.h;
            float f12 = this.i;
            float f13 = this.f;
            fS2 = fx3.s(f11, f12, tj4.l((f13 - i5) / f13, 0.0f, f10) / f10);
        } else {
            fS = f7;
            fS2 = fS;
        }
        float f14 = (-this.f) / 2.0f;
        eb2 eb2Var2 = (eb2) this.a;
        boolean z2 = eb2Var2.b(this.m) && z && f3 > 0.0f;
        if (i4 <= i5) {
            float f15 = i4 + fS;
            float f16 = i5 - fS2;
            float f17 = fS * 2.0f;
            float f18 = fS2 * 2.0f;
            paint.setColor(i);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.g);
            ((zx0) pair.first).b();
            ((zx0) pair.second).b();
            ((zx0) pair.first).e(f15 + f14);
            ((zx0) pair.second).e(f16 + f14);
            if (i4 == 0 && f16 + fS2 < f15 + fS) {
                zx0 zx0Var = (zx0) pair.first;
                float f19 = this.g;
                j(canvas, paint, zx0Var, f17, f19, fS, (zx0) pair.second, f18, f19, fS2, true);
                return;
            }
            if (f15 - fS > f16 - fS2) {
                zx0 zx0Var2 = (zx0) pair.second;
                float f20 = this.g;
                j(canvas, paint, zx0Var2, f18, f20, fS2, (zx0) pair.first, f17, f20, fS, false);
                return;
            }
            float f21 = fS2;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(eb2Var2.c() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            if (z2) {
                float f22 = this.f;
                float f23 = f15 / f22;
                float f24 = f16 / f22;
                eb2Var = eb2Var2;
                int i6 = this.m ? eb2Var.j : eb2Var.k;
                if (i6 != this.l) {
                    this.l = i6;
                    g();
                }
                Path path = this.c;
                path.rewind();
                float f25 = (-this.f) / 2.0f;
                boolean zB = eb2Var.b(this.m);
                if (zB) {
                    float f26 = this.f;
                    f5 = 1.0f;
                    float f27 = this.k;
                    float f28 = f26 / f27;
                    float f29 = f4 / f28;
                    float f30 = f28 / (f28 + 1.0f);
                    f23 = (f23 + f29) * f30;
                    f24 = (f24 + f29) * f30;
                    f25 -= f27 * f4;
                } else {
                    f5 = 1.0f;
                }
                PathMeasure pathMeasure = this.d;
                float length = pathMeasure.getLength() * f23;
                float length2 = pathMeasure.getLength() * f24;
                pathMeasure.getSegment(length, length2, path, true);
                zx0 zx0Var3 = (zx0) pair.first;
                zx0Var3.b();
                pathMeasure.getPosTan(length, zx0Var3.a, zx0Var3.b);
                zx0 zx0Var4 = (zx0) pair.second;
                zx0Var4.b();
                pathMeasure.getPosTan(length2, zx0Var4.a, zx0Var4.b);
                Matrix matrix = this.e;
                matrix.reset();
                matrix.setTranslate(f25, 0.0f);
                zx0Var3.e(f25);
                zx0Var4.e(f25);
                if (zB) {
                    float f31 = this.j * f3;
                    matrix.postScale(f5, f31);
                    zx0Var3.d(f31);
                    zx0Var4.d(f31);
                }
                path.transform(matrix);
                canvas2 = canvas;
                canvas2.drawPath(path, paint);
            } else {
                float[] fArr = ((zx0) pair.first).a;
                float f32 = fArr[0];
                float f33 = fArr[1];
                float[] fArr2 = ((zx0) pair.second).a;
                canvas.drawLine(f32, f33, fArr2[0], fArr2[1], paint);
                canvas2 = canvas;
                eb2Var = eb2Var2;
            }
            if (eb2Var.c()) {
                return;
            }
            if (f15 > 0.0f && fS > 0.0f) {
                j(canvas2, paint, (zx0) pair.first, f17, this.g, fS, null, 0.0f, 0.0f, 0.0f, false);
            }
            if (f16 >= this.f || f21 <= 0.0f) {
                return;
            }
            j(canvas, paint, (zx0) pair.second, f18, this.g, f21, null, 0.0f, 0.0f, 0.0f, false);
        }
    }

    public final void j(Canvas canvas, Paint paint, zx0 zx0Var, float f, float f2, float f3, zx0 zx0Var2, float f4, float f5, float f6, boolean z) {
        float f7;
        float f8;
        float fMin = Math.min(f2, this.g);
        float f9 = (-f) / 2.0f;
        float f10 = (-fMin) / 2.0f;
        float f11 = f / 2.0f;
        float f12 = fMin / 2.0f;
        RectF rectF = new RectF(f9, f10, f11, f12);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (zx0Var2 != null) {
            float[] fArr = zx0Var2.b;
            float[] fArr2 = zx0Var2.a;
            float fMin2 = Math.min(f5, this.g);
            float fMin3 = Math.min(f4 / 2.0f, (f6 * fMin2) / this.g);
            RectF rectF2 = new RectF();
            if (z) {
                float f13 = (fArr2[0] - fMin3) - (zx0Var.a[0] - f3);
                if (f13 > 0.0f) {
                    zx0Var2.e((-f13) / 2.0f);
                    f8 = f4 + f13;
                } else {
                    f8 = f4;
                }
                rectF2.set(0.0f, f10, f11, f12);
            } else {
                float f14 = (fArr2[0] + fMin3) - (zx0Var.a[0] + f3);
                if (f14 < 0.0f) {
                    zx0Var2.e((-f14) / 2.0f);
                    f7 = f4 - f14;
                } else {
                    f7 = f4;
                }
                rectF2.set(f9, f10, 0.0f, f12);
                f8 = f7;
            }
            RectF rectF3 = new RectF((-f8) / 2.0f, (-fMin2) / 2.0f, f8 / 2.0f, fMin2 / 2.0f);
            canvas.translate(fArr2[0], fArr2[1]);
            canvas.rotate(ay0.h(fArr));
            Path path = new Path();
            path.addRoundRect(rectF3, fMin3, fMin3, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.rotate(-ay0.h(fArr));
            canvas.translate(-fArr2[0], -fArr2[1]);
            float[] fArr3 = zx0Var.a;
            canvas.translate(fArr3[0], fArr3[1]);
            canvas.rotate(ay0.h(zx0Var.b));
            canvas.drawRect(rectF2, paint);
            canvas.drawRoundRect(rectF, f3, f3, paint);
        } else {
            float[] fArr4 = zx0Var.a;
            canvas.translate(fArr4[0], fArr4[1]);
            canvas.rotate(ay0.h(zx0Var.b));
            canvas.drawRoundRect(rectF, f3, f3, paint);
        }
        canvas.restore();
    }
}
