package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.PathMotion;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ri2 extends Drawable {
    public static final /* synthetic */ int K = 0;
    public static final /* synthetic */ int L = 0;
    public RectF A;
    public float B;
    public float C;
    public float D;
    public final Object E;
    public final Object F;
    public final Object G;
    public final Object H;
    public Object I;
    public Object J;
    public final /* synthetic */ int a = 0;
    public final View b;
    public final RectF c;
    public final ou3 d;
    public final float e;
    public final View f;
    public final RectF g;
    public final ou3 h;
    public final float i;
    public final Paint j;
    public final Paint k;
    public final Paint l;
    public final Paint m;
    public final Paint n;
    public final PathMeasure o;
    public final float p;
    public final float[] q;
    public final boolean r;
    public final float s;
    public final float t;
    public final boolean u;
    public final yi2 v;
    public final RectF w;
    public final RectF x;
    public final RectF y;
    public final RectF z;

    public ri2(PathMotion pathMotion, View view, RectF rectF, ou3 ou3Var, float f, View view2, RectF rectF2, ou3 ou3Var2, float f2, int i, int i2, int i3, int i4, boolean z, boolean z2, ya1 ya1Var, gf1 gf1Var, iv1 iv1Var) {
        Paint paint = new Paint();
        this.j = paint;
        Paint paint2 = new Paint();
        this.k = paint2;
        Paint paint3 = new Paint();
        this.l = paint3;
        this.m = new Paint();
        Paint paint4 = new Paint();
        this.n = paint4;
        this.E = new ih2(0);
        this.q = new float[]{rectF.centerX(), rectF.top};
        yi2 yi2Var = new yi2();
        this.v = yi2Var;
        Paint paint5 = new Paint();
        new Path();
        this.b = view;
        this.c = rectF;
        this.d = ou3Var;
        this.e = f;
        this.f = view2;
        this.g = rectF2;
        this.h = ou3Var2;
        this.i = f2;
        this.r = z;
        this.u = z2;
        this.G = ya1Var;
        this.H = gf1Var;
        this.F = iv1Var;
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.s = r9.widthPixels;
        this.t = r9.heightPixels;
        paint.setColor(i);
        paint2.setColor(i2);
        paint3.setColor(i3);
        yi2Var.p(ColorStateList.valueOf(0));
        yi2Var.s();
        yi2Var.O0 = false;
        yi2Var.r(-7829368);
        RectF rectF3 = new RectF(rectF);
        this.w = rectF3;
        this.x = new RectF(rectF3);
        RectF rectF4 = new RectF(rectF3);
        this.y = rectF4;
        this.z = new RectF(rectF4);
        PointF pointF = new PointF(rectF.centerX(), rectF.top);
        PointF pointF2 = new PointF(rectF2.centerX(), rectF2.top);
        PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointF.x, pointF.y, pointF2.x, pointF2.y), false);
        this.o = pathMeasure;
        this.p = pathMeasure.getLength();
        paint4.setStyle(Paint.Style.FILL);
        RectF rectF5 = fh4.a;
        paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i4, i4, Shader.TileMode.CLAMP));
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(10.0f);
        d(0.0f);
    }

    public final void a(Canvas canvas) {
        int i = this.a;
        View view = this.f;
        RectF rectF = this.y;
        Paint paint = this.l;
        switch (i) {
            case 0:
                c(canvas, paint);
                Rect bounds = getBounds();
                float f = rectF.left;
                float f2 = rectF.top;
                float f3 = ((aw) this.J).b;
                int i2 = ((w90) this.I).b;
                if (i2 > 0) {
                    int iSave = canvas.save();
                    canvas.translate(f, f2);
                    canvas.scale(f3, f3);
                    if (i2 < 255) {
                        RectF rectF2 = fh4.a;
                        rectF2.set(bounds);
                        canvas.saveLayerAlpha(rectF2, i2);
                    }
                    view.draw(canvas);
                    canvas.restoreToCount(iSave);
                    break;
                }
                break;
            default:
                c(canvas, paint);
                Rect bounds2 = getBounds();
                float f4 = rectF.left;
                float f5 = rectF.top;
                float f6 = ((aw) this.J).b;
                int i3 = ((w90) this.I).b;
                if (i3 > 0) {
                    int iSave2 = canvas.save();
                    canvas.translate(f4, f5);
                    canvas.scale(f6, f6);
                    if (i3 < 255) {
                        RectF rectF3 = eh4.a;
                        rectF3.set(bounds2);
                        canvas.saveLayerAlpha(rectF3, i3);
                    }
                    view.draw(canvas);
                    canvas.restoreToCount(iSave2);
                    break;
                }
                break;
        }
    }

    public final void b(Canvas canvas) {
        int i = this.a;
        View view = this.b;
        RectF rectF = this.w;
        Paint paint = this.k;
        switch (i) {
            case 0:
                c(canvas, paint);
                Rect bounds = getBounds();
                float f = rectF.left;
                float f2 = rectF.top;
                float f3 = ((aw) this.J).a;
                int i2 = ((w90) this.I).a;
                if (i2 > 0) {
                    int iSave = canvas.save();
                    canvas.translate(f, f2);
                    canvas.scale(f3, f3);
                    if (i2 < 255) {
                        RectF rectF2 = fh4.a;
                        rectF2.set(bounds);
                        canvas.saveLayerAlpha(rectF2, i2);
                    }
                    view.draw(canvas);
                    canvas.restoreToCount(iSave);
                    break;
                }
                break;
            default:
                c(canvas, paint);
                Rect bounds2 = getBounds();
                float f4 = rectF.left;
                float f5 = rectF.top;
                float f6 = ((aw) this.J).a;
                int i3 = ((w90) this.I).a;
                if (i3 > 0) {
                    int iSave2 = canvas.save();
                    canvas.translate(f4, f5);
                    canvas.scale(f6, f6);
                    if (i3 < 255) {
                        RectF rectF3 = eh4.a;
                        rectF3.set(bounds2);
                        canvas.saveLayerAlpha(rectF3, i3);
                    }
                    view.draw(canvas);
                    canvas.restoreToCount(iSave2);
                    break;
                }
                break;
        }
    }

    public final void c(Canvas canvas, Paint paint) {
        switch (this.a) {
            case 0:
                if (paint.getColor() != 0 && paint.getAlpha() > 0) {
                    canvas.drawRect(getBounds(), paint);
                    break;
                }
                break;
            default:
                if (paint.getColor() != 0 && paint.getAlpha() > 0) {
                    canvas.drawRect(getBounds(), paint);
                    break;
                }
                break;
        }
    }

    public final void d(float f) {
        float f2;
        float fC;
        float f3;
        float f4;
        Paint paint;
        RectF rectF;
        Path path;
        Path path2;
        y3 y3Var;
        float f5;
        float f6;
        float fC2;
        float f7;
        float f8;
        Paint paint2;
        RectF rectF2;
        Path path3;
        Path path4;
        y3 y3Var2;
        float f9;
        int i = this.a;
        boolean z = this.r;
        Paint paint3 = this.n;
        Object obj = this.F;
        float[] fArr = this.q;
        RectF rectF3 = this.w;
        PathMeasure pathMeasure = this.o;
        float f10 = this.p;
        RectF rectF4 = this.c;
        RectF rectF5 = this.g;
        RectF rectF6 = this.y;
        Paint paint4 = this.k;
        Paint paint5 = this.l;
        Object obj2 = this.H;
        switch (i) {
            case 0:
                gf1 gf1Var = (gf1) obj2;
                iv1 iv1Var = (iv1) obj;
                this.D = f;
                if (z) {
                    f2 = 0.0f;
                    fC = fh4.c(0.0f, 255.0f, f);
                } else {
                    f2 = 0.0f;
                    fC = fh4.c(255.0f, 0.0f, f);
                }
                paint3.setAlpha((int) fC);
                pathMeasure.getPosTan(f10 * f, fArr, null);
                float fH = fArr[0];
                float fH2 = fArr[1];
                if (f > 1.0f || f < f2) {
                    if (f > 1.0f) {
                        f4 = (f - 1.0f) / 0.00999999f;
                        f3 = 0.99f;
                    } else {
                        f3 = 0.01f;
                        f4 = (f / 0.01f) * (-1.0f);
                    }
                    paint = paint5;
                    pathMeasure.getPosTan(f10 * f3, fArr, null);
                    float f11 = fArr[0];
                    float f12 = fArr[1];
                    fH = ha0.h(fH, f11, f4, fH);
                    fH2 = ha0.h(fH2, f12, f4, fH2);
                } else {
                    paint = paint5;
                }
                float f13 = fH;
                float f14 = fH2;
                d8 d8Var = (d8) iv1Var.z;
                d8 d8Var2 = (d8) iv1Var.f;
                d8 d8Var3 = (d8) iv1Var.A;
                Paint paint6 = paint;
                aw awVarR = ((gf1) obj2).r(f, d8Var.a, ((d8) iv1Var.z).b, rectF4.width(), rectF4.height(), rectF5.width(), rectF5.height());
                this.J = awVarR;
                float f15 = awVarR.c / 2.0f;
                rectF3.set(f13 - f15, f14, f15 + f13, awVarR.d + f14);
                aw awVar = (aw) this.J;
                float f16 = awVar.e / 2.0f;
                rectF6.set(f13 - f16, f14, f16 + f13, awVar.f + f14);
                RectF rectF7 = this.x;
                rectF7.set(rectF3);
                RectF rectF8 = this.z;
                rectF8.set(rectF6);
                float f17 = d8Var3.a;
                float f18 = d8Var3.b;
                boolean zN = gf1Var.n((aw) this.J);
                RectF rectF9 = zN ? rectF7 : rectF8;
                float fD = fh4.d(0.0f, 1.0f, f17, f18, f, false);
                if (!zN) {
                    fD = 1.0f - fD;
                }
                gf1Var.e(rectF9, fD, (aw) this.J);
                this.A = new RectF(Math.min(rectF7.left, rectF8.left), Math.min(rectF7.top, rectF8.top), Math.max(rectF7.right, rectF8.right), Math.max(rectF7.bottom, rectF8.bottom));
                ih2 ih2Var = (ih2) this.E;
                d8 d8Var4 = (d8) iv1Var.X;
                Path path5 = ih2Var.c;
                Path path6 = ih2Var.b;
                y3 y3Var3 = ih2Var.d;
                float f19 = d8Var4.a;
                float f20 = d8Var4.b;
                ou3 ou3VarB = this.d;
                if (f < f19) {
                    f5 = f;
                    rectF = rectF7;
                    path = path5;
                    path2 = path6;
                    y3Var = y3Var3;
                } else {
                    ou3 ou3Var = this.h;
                    if (f > f20) {
                        f5 = f;
                        rectF = rectF7;
                        path = path5;
                        path2 = path6;
                        y3Var = y3Var3;
                        ou3VarB = ou3Var;
                    } else {
                        ye0 ye0Var = ou3VarB.e;
                        ye0 ye0Var2 = ou3VarB.h;
                        ye0 ye0Var3 = ou3VarB.g;
                        rectF = rectF7;
                        ye0 ye0Var4 = ou3VarB.f;
                        qy1 qy1VarL = ((ye0Var.a(rectF3) == 0.0f && ye0Var4.a(rectF3) == 0.0f && ye0Var3.a(rectF3) == 0.0f && ye0Var2.a(rectF3) == 0.0f) ? ou3Var : ou3VarB).l();
                        path = path5;
                        path2 = path6;
                        y3Var = y3Var3;
                        qy1VarL.e = new a0(fh4.d(ou3VarB.e.a(rectF3), ou3Var.e.a(rectF8), f19, f20, f, false));
                        qy1VarL.f = new a0(fh4.d(ye0Var4.a(rectF3), ou3Var.f.a(rectF8), f19, f20, f, false));
                        qy1VarL.h = new a0(fh4.d(ye0Var2.a(rectF3), ou3Var.h.a(rectF8), f19, f20, f, false));
                        f5 = f;
                        qy1VarL.g = new a0(fh4.d(ye0Var3.a(rectF3), ou3Var.g.a(rectF8), f19, f20, f5, false));
                        ou3VarB = qy1VarL.b();
                    }
                }
                ih2Var.e = ou3VarB;
                y3Var.b(ou3VarB, null, 1.0f, rectF, null, path2);
                Path path7 = path2;
                Path path8 = path;
                y3Var.b(ih2Var.e, null, 1.0f, rectF8, null, path8);
                ih2Var.a.op(path7, path8, Path.Op.UNION);
                this.B = fh4.c(this.e, this.i, f5);
                float fCenterX = ((this.A.centerX() / (this.s / 2.0f)) - 1.0f) * 0.3f;
                float fCenterY = (this.A.centerY() / this.t) * 1.5f;
                float f21 = this.B;
                float f22 = (int) (fCenterY * f21);
                this.C = f22;
                this.m.setShadowLayer(f21, (int) (fCenterX * f21), f22, 754974720);
                this.I = ((ya1) this.G).l(f5, d8Var2.a, d8Var2.b);
                if (paint4.getColor() != 0) {
                    paint4.setAlpha(((w90) this.I).a);
                }
                if (paint6.getColor() != 0) {
                    paint6.setAlpha(((w90) this.I).b);
                }
                invalidateSelf();
                break;
            default:
                hf1 hf1Var = (hf1) obj2;
                iv1 iv1Var2 = (iv1) obj;
                this.D = f;
                if (z) {
                    f6 = 0.0f;
                    fC2 = eh4.c(0.0f, 255.0f, f);
                } else {
                    f6 = 0.0f;
                    fC2 = eh4.c(255.0f, 0.0f, f);
                }
                paint3.setAlpha((int) fC2);
                pathMeasure.getPosTan(f10 * f, fArr, null);
                float fH3 = fArr[0];
                float fH4 = fArr[1];
                if (f > 1.0f || f < f6) {
                    if (f > 1.0f) {
                        f8 = (f - 1.0f) / 0.00999999f;
                        f7 = 0.99f;
                    } else {
                        f7 = 0.01f;
                        f8 = (f / 0.01f) * (-1.0f);
                    }
                    paint2 = paint4;
                    pathMeasure.getPosTan(f10 * f7, fArr, null);
                    float f23 = fArr[0];
                    float f24 = fArr[1];
                    fH3 = ha0.h(fH3, f23, f8, fH3);
                    fH4 = ha0.h(fH4, f24, f8, fH4);
                } else {
                    paint2 = paint4;
                }
                float f25 = fH3;
                float f26 = fH4;
                d8 d8Var5 = (d8) iv1Var2.z;
                d8 d8Var6 = (d8) iv1Var2.f;
                d8 d8Var7 = (d8) iv1Var2.A;
                Paint paint7 = paint2;
                aw awVarI = ((hf1) obj2).i(f, d8Var5.a, ((d8) iv1Var2.z).b, rectF4.width(), rectF4.height(), rectF5.width(), rectF5.height());
                this.J = awVarI;
                float f27 = awVarI.c / 2.0f;
                rectF3.set(f25 - f27, f26, f27 + f25, awVarI.d + f26);
                aw awVar2 = (aw) this.J;
                float f28 = awVar2.e / 2.0f;
                rectF6.set(f25 - f28, f26, f28 + f25, awVar2.f + f26);
                RectF rectF10 = this.x;
                rectF10.set(rectF3);
                RectF rectF11 = this.z;
                rectF11.set(rectF6);
                float f29 = d8Var7.a;
                float f30 = d8Var7.b;
                boolean zD = hf1Var.d((aw) this.J);
                RectF rectF12 = zD ? rectF10 : rectF11;
                float fD2 = eh4.d(0.0f, 1.0f, f29, f30, f, false);
                if (!zD) {
                    fD2 = 1.0f - fD2;
                }
                hf1Var.n(rectF12, fD2, (aw) this.J);
                this.A = new RectF(Math.min(rectF10.left, rectF11.left), Math.min(rectF10.top, rectF11.top), Math.max(rectF10.right, rectF11.right), Math.max(rectF10.bottom, rectF11.bottom));
                ih2 ih2Var2 = (ih2) this.E;
                d8 d8Var8 = (d8) iv1Var2.X;
                Path path9 = ih2Var2.c;
                Path path10 = ih2Var2.b;
                y3 y3Var4 = ih2Var2.d;
                float f31 = d8Var8.a;
                float f32 = d8Var8.b;
                ou3 ou3VarB2 = this.d;
                if (f < f31) {
                    f9 = f;
                    rectF2 = rectF10;
                    path3 = path9;
                    path4 = path10;
                    y3Var2 = y3Var4;
                } else {
                    ou3 ou3Var2 = this.h;
                    if (f > f32) {
                        f9 = f;
                        rectF2 = rectF10;
                        path3 = path9;
                        path4 = path10;
                        y3Var2 = y3Var4;
                        ou3VarB2 = ou3Var2;
                    } else {
                        ye0 ye0Var5 = ou3VarB2.e;
                        ye0 ye0Var6 = ou3VarB2.h;
                        ye0 ye0Var7 = ou3VarB2.g;
                        rectF2 = rectF10;
                        ye0 ye0Var8 = ou3VarB2.f;
                        qy1 qy1VarL2 = ((ye0Var5.a(rectF3) == 0.0f && ye0Var8.a(rectF3) == 0.0f && ye0Var7.a(rectF3) == 0.0f && ye0Var6.a(rectF3) == 0.0f) ? ou3Var2 : ou3VarB2).l();
                        path3 = path9;
                        path4 = path10;
                        y3Var2 = y3Var4;
                        qy1VarL2.e = new a0(eh4.d(ou3VarB2.e.a(rectF3), ou3Var2.e.a(rectF11), f31, f32, f, false));
                        qy1VarL2.f = new a0(eh4.d(ye0Var8.a(rectF3), ou3Var2.f.a(rectF11), f31, f32, f, false));
                        qy1VarL2.h = new a0(eh4.d(ye0Var6.a(rectF3), ou3Var2.h.a(rectF11), f31, f32, f, false));
                        f9 = f;
                        qy1VarL2.g = new a0(eh4.d(ye0Var7.a(rectF3), ou3Var2.g.a(rectF11), f31, f32, f9, false));
                        ou3VarB2 = qy1VarL2.b();
                    }
                }
                ih2Var2.e = ou3VarB2;
                y3Var2.b(ou3VarB2, null, 1.0f, rectF2, null, path4);
                Path path11 = path4;
                Path path12 = path3;
                y3Var2.b(ih2Var2.e, null, 1.0f, rectF11, null, path12);
                ih2Var2.a.op(path11, path12, Path.Op.UNION);
                this.B = eh4.c(this.e, this.i, f9);
                float fCenterX2 = ((this.A.centerX() / (this.s / 2.0f)) - 1.0f) * 0.3f;
                float fCenterY2 = (this.A.centerY() / this.t) * 1.5f;
                float f33 = this.B;
                float f34 = (int) (fCenterY2 * f33);
                this.C = f34;
                this.m.setShadowLayer(f33, (int) (fCenterX2 * f33), f34, 754974720);
                this.I = ((za1) this.G).l(f9, d8Var6.a, d8Var6.b);
                if (paint7.getColor() != 0) {
                    paint7.setAlpha(((w90) this.I).a);
                }
                if (paint5.getColor() != 0) {
                    paint5.setAlpha(((w90) this.I).b);
                }
                invalidateSelf();
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i = this.a;
        Paint paint = this.j;
        yi2 yi2Var = this.v;
        Paint paint2 = this.m;
        boolean z = this.u;
        Paint paint3 = this.n;
        Object obj = this.E;
        switch (i) {
            case 0:
                ih2 ih2Var = (ih2) obj;
                if (paint3.getAlpha() > 0) {
                    canvas.drawRect(getBounds(), paint3);
                }
                if (z && this.B > 0.0f) {
                    canvas.save();
                    canvas.clipPath(ih2Var.a, Region.Op.DIFFERENCE);
                    if (Build.VERSION.SDK_INT > 28) {
                        ou3 ou3Var = ih2Var.e;
                        if (ou3Var.k(this.A)) {
                            float fA = ou3Var.e.a(this.A);
                            canvas.drawRoundRect(this.A, fA, fA, paint2);
                        } else {
                            canvas.drawPath(ih2Var.a, paint2);
                        }
                    } else {
                        RectF rectF = this.A;
                        yi2Var.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        yi2Var.o(this.B);
                        yi2Var.t((int) this.C);
                        yi2Var.setShapeAppearanceModel(ih2Var.e);
                        yi2Var.draw(canvas);
                    }
                    canvas.restore();
                }
                canvas.clipPath(ih2Var.a);
                c(canvas, paint);
                if (!((w90) this.I).c) {
                    a(canvas);
                    b(canvas);
                } else {
                    b(canvas);
                    a(canvas);
                }
                break;
            default:
                ih2 ih2Var2 = (ih2) obj;
                if (paint3.getAlpha() > 0) {
                    canvas.drawRect(getBounds(), paint3);
                }
                if (z && this.B > 0.0f) {
                    canvas.save();
                    canvas.clipPath(ih2Var2.a, Region.Op.DIFFERENCE);
                    if (Build.VERSION.SDK_INT > 28) {
                        ou3 ou3Var2 = ih2Var2.e;
                        if (ou3Var2.k(this.A)) {
                            float fA2 = ou3Var2.e.a(this.A);
                            canvas.drawRoundRect(this.A, fA2, fA2, paint2);
                        } else {
                            canvas.drawPath(ih2Var2.a, paint2);
                        }
                    } else {
                        RectF rectF2 = this.A;
                        yi2Var.setBounds((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                        yi2Var.o(this.B);
                        yi2Var.t((int) this.C);
                        yi2Var.setShapeAppearanceModel(ih2Var2.e);
                        yi2Var.draw(canvas);
                    }
                    canvas.restore();
                }
                canvas.clipPath(ih2Var2.a);
                c(canvas, paint);
                if (!((w90) this.I).c) {
                    a(canvas);
                    b(canvas);
                } else {
                    b(canvas);
                    a(canvas);
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        switch (this.a) {
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Setting alpha on is not supported");
            default:
                throw new UnsupportedOperationException("Setting alpha on is not supported");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException("Setting a color filter is not supported");
            default:
                throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    public ri2(ek0 ek0Var, View view, RectF rectF, ou3 ou3Var, float f, View view2, RectF rectF2, ou3 ou3Var2, float f2, int i, boolean z, boolean z2, za1 za1Var, hf1 hf1Var, iv1 iv1Var) {
        Paint paint = new Paint();
        this.j = paint;
        Paint paint2 = new Paint();
        this.k = paint2;
        Paint paint3 = new Paint();
        this.l = paint3;
        this.m = new Paint();
        Paint paint4 = new Paint();
        this.n = paint4;
        this.E = new ih2(1);
        this.q = new float[]{rectF.centerX(), rectF.top};
        yi2 yi2Var = new yi2();
        this.v = yi2Var;
        Paint paint5 = new Paint();
        new Path();
        this.b = view;
        this.c = rectF;
        this.d = ou3Var;
        this.e = f;
        this.f = view2;
        this.g = rectF2;
        this.h = ou3Var2;
        this.i = f2;
        this.r = z;
        this.u = z2;
        this.G = za1Var;
        this.H = hf1Var;
        this.F = iv1Var;
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.s = r9.widthPixels;
        this.t = r9.heightPixels;
        paint.setColor(0);
        paint2.setColor(0);
        paint3.setColor(0);
        yi2Var.p(ColorStateList.valueOf(0));
        yi2Var.s();
        yi2Var.O0 = false;
        yi2Var.r(-7829368);
        RectF rectF3 = new RectF(rectF);
        this.w = rectF3;
        this.x = new RectF(rectF3);
        RectF rectF4 = new RectF(rectF3);
        this.y = rectF4;
        this.z = new RectF(rectF4);
        PointF pointF = new PointF(rectF.centerX(), rectF.top);
        PointF pointF2 = new PointF(rectF2.centerX(), rectF2.top);
        PathMeasure pathMeasure = new PathMeasure(ek0Var.p(pointF.x, pointF.y, pointF2.x, pointF2.y), false);
        this.o = pathMeasure;
        this.p = pathMeasure.getLength();
        paint4.setStyle(Paint.Style.FILL);
        RectF rectF5 = eh4.a;
        paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i, i, Shader.TileMode.CLAMP));
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(10.0f);
        d(0.0f);
    }
}
