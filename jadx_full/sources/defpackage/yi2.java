package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class yi2 extends Drawable implements yu3 {
    public static final Paint W0;
    public static final xi2[] X0;
    public final wu3[] A;
    public final Path A0;
    public final RectF B0;
    public final RectF C0;
    public final Region D0;
    public final Region E0;
    public final Paint F0;
    public final Paint G0;
    public final ju3 H0;
    public final ha1 I0;
    public final y3 J0;
    public PorterDuffColorFilter K0;
    public PorterDuffColorFilter L0;
    public int M0;
    public final RectF N0;
    public boolean O0;
    public boolean P0;
    public ou3 Q0;
    public x04 R0;
    public final w04[] S0;
    public float[] T0;
    public float[] U0;
    public jd V0;
    public final BitSet X;
    public boolean Y;
    public boolean Z;
    public final oj1 b;
    public wi2 f;
    public final Matrix y0;
    public final wu3[] z;
    public final Path z0;

    static {
        Paint paint = new Paint(1);
        W0 = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        X0 = new xi2[4];
        int i = 0;
        while (true) {
            xi2[] xi2VarArr = X0;
            if (i >= xi2VarArr.length) {
                return;
            }
            xi2VarArr[i] = new xi2(i);
            i++;
        }
    }

    public yi2(wi2 wi2Var) {
        this.b = new oj1(11, this);
        this.z = new wu3[4];
        this.A = new wu3[4];
        this.X = new BitSet(8);
        this.y0 = new Matrix();
        this.z0 = new Path();
        this.A0 = new Path();
        this.B0 = new RectF();
        this.C0 = new RectF();
        this.D0 = new Region();
        this.E0 = new Region();
        Paint paint = new Paint(1);
        this.F0 = paint;
        Paint paint2 = new Paint(1);
        this.G0 = paint2;
        this.H0 = new ju3();
        this.J0 = Looper.getMainLooper().getThread() == Thread.currentThread() ? pu3.a : new y3();
        this.N0 = new RectF();
        this.O0 = true;
        this.P0 = true;
        this.S0 = new w04[4];
        this.f = wi2Var;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        x();
        v(getState());
        this.I0 = new ha1(12, this);
    }

    public final void b(RectF rectF, Path path) {
        this.J0.b(this.f.a.d(), this.T0, this.f.i, rectF, this.I0, path);
        if (this.f.h != 1.0f) {
            Matrix matrix = this.y0;
            matrix.reset();
            float f = this.f.h;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.N0, true);
    }

    public final int c(int i) {
        int i2;
        wi2 wi2Var = this.f;
        float f = wi2Var.m + 0.0f + wi2Var.l;
        f21 f21Var = wi2Var.b;
        if (f21Var == null || !f21Var.a || u70.e(i, DnsRecord.CLASS_ANY) != f21Var.d) {
            return i;
        }
        float fMin = (f21Var.e <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int I = n12.I(u70.e(i, DnsRecord.CLASS_ANY), fMin, f21Var.b);
        if (fMin > 0.0f && (i2 = f21Var.c) != 0) {
            I = u70.c(u70.e(i2, f21.f), I);
        }
        return u70.e(I, iAlpha);
    }

    public final void d(Canvas canvas) {
        if (this.X.cardinality() > 0) {
            a1.n("yi2", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.f.p;
        Path path = this.z0;
        ju3 ju3Var = this.H0;
        if (i != 0) {
            canvas.drawPath(path, ju3Var.a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            wu3 wu3Var = this.z[i2];
            int i3 = this.f.o;
            Matrix matrix = wu3.b;
            wu3Var.a(matrix, ju3Var, i3, canvas);
            this.A[i2].a(matrix, ju3Var, this.f.o, canvas);
        }
        if (this.O0) {
            int iSin = (int) (Math.sin(Math.toRadians(0.0d)) * ((double) this.f.p));
            int iCos = (int) (Math.cos(Math.toRadians(0.0d)) * ((double) this.f.p));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, W0);
            canvas.translate(iSin, iCos);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint;
        PorterDuffColorFilter porterDuffColorFilter = this.K0;
        Paint paint2 = this.F0;
        paint2.setColorFilter(porterDuffColorFilter);
        int alpha = paint2.getAlpha();
        int i = this.f.k;
        paint2.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.L0;
        Paint paint3 = this.G0;
        paint3.setColorFilter(porterDuffColorFilter2);
        paint3.setStrokeWidth(this.f.j);
        int alpha2 = paint3.getAlpha();
        int i2 = this.f.k;
        paint3.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        boolean z = j() || !m();
        Paint.Style style = this.f.q;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            boolean z2 = this.Y;
            paint = paint2;
            Path path = this.z0;
            if (z2) {
                if (z) {
                    b(g(), path);
                }
                this.Y = false;
            }
            if (j()) {
                canvas.save();
                canvas.translate((int) (((double) this.f.p) * Math.sin(Math.toRadians(0.0d))), (int) (Math.cos(Math.toRadians(0.0d)) * ((double) this.f.p)));
                if (this.O0) {
                    Rect bounds = getBounds();
                    RectF rectF = this.N0;
                    int iWidth = (int) (rectF.width() - bounds.width());
                    int iHeight = (int) (rectF.height() - bounds.height());
                    if (iWidth < 0 || iHeight < 0) {
                        st4.m(fw.A(iWidth, iHeight, "Invalid shadow bounds. Check that the treatments result in a valid path. extra width: ", " extra height: ", " path bounds: "), rectF);
                        return;
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.f.o * 2) + ((int) rectF.width()) + iWidth, (this.f.o * 2) + ((int) rectF.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    int i3 = bounds.left;
                    int i4 = this.f.o;
                    float f = (i3 - i4) - iWidth;
                    float f2 = (bounds.top - i4) - iHeight;
                    canvas2.translate(-f, -f2);
                    d(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f, f2, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    d(canvas);
                    canvas.restore();
                }
            }
            e(canvas, paint, path, this.f.a.d(), this.T0, g());
        } else {
            paint = paint2;
        }
        if (k()) {
            if (this.Z) {
                ou3 shapeAppearanceModel = getShapeAppearanceModel();
                qy1 qy1VarL = shapeAppearanceModel.l();
                ye0 ye0Var = shapeAppearanceModel.e;
                oj1 oj1Var = this.b;
                qy1VarL.e = oj1Var.w(ye0Var);
                qy1VarL.f = oj1Var.w(shapeAppearanceModel.f);
                qy1VarL.h = oj1Var.w(shapeAppearanceModel.h);
                qy1VarL.g = oj1Var.w(shapeAppearanceModel.g);
                this.Q0 = qy1VarL.b();
                float[] fArr = this.T0;
                if (fArr != null) {
                    if (this.U0 == null) {
                        this.U0 = new float[fArr.length];
                    }
                    float fH = h();
                    int i5 = 0;
                    while (true) {
                        float[] fArr2 = this.T0;
                        if (i5 >= fArr2.length) {
                            break;
                        }
                        this.U0[i5] = Math.max(0.0f, fArr2[i5] - fH);
                        i5++;
                    }
                } else {
                    this.U0 = null;
                }
                if (z) {
                    ou3 ou3Var = this.Q0;
                    float[] fArr3 = this.U0;
                    float f3 = this.f.i;
                    RectF rectFG = g();
                    RectF rectF2 = this.C0;
                    rectF2.set(rectFG);
                    float fH2 = h();
                    rectF2.inset(fH2, fH2);
                    this.J0.b(ou3Var, fArr3, f3, rectF2, null, this.A0);
                }
                this.Z = false;
            }
            f(canvas);
        }
        paint.setAlpha(alpha);
        paint3.setAlpha(alpha2);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(Canvas canvas, Paint paint, Path path, ou3 ou3Var, float[] fArr, RectF rectF) {
        float fA;
        if (fArr == null) {
            fA = ou3Var.k(rectF) ? ou3Var.e.a(rectF) : -1.0f;
        } else if (this.P0) {
            fA = fArr[0];
        }
        if (fA < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f = fA * this.f.i;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public void f(Canvas canvas) {
        ou3 ou3Var = this.Q0;
        float[] fArr = this.U0;
        RectF rectFG = g();
        RectF rectF = this.C0;
        rectF.set(rectFG);
        float fH = h();
        rectF.inset(fH, fH);
        e(canvas, this.G0, this.A0, ou3Var, fArr, rectF);
    }

    public final RectF g() {
        Rect bounds = getBounds();
        RectF rectF = this.B0;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f.k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getOutline(Outline outline) {
        float fA;
        if (this.f.n == 2) {
            return;
        }
        RectF rectFG = g();
        if (rectFG.isEmpty()) {
            return;
        }
        ou3 ou3VarD = this.f.a.d();
        float[] fArr = this.T0;
        if (fArr == null) {
            fA = ou3VarD.k(rectFG) ? ou3VarD.e.a(rectFG) : -1.0f;
        } else if (this.P0) {
            fA = fArr[0];
        }
        if (fA >= 0.0f) {
            outline.setRoundRect(getBounds(), fA * this.f.i);
            return;
        }
        boolean z = this.Y;
        Path path = this.z0;
        if (z) {
            b(rectFG, path);
            this.Y = false;
        }
        v9.w(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f.g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // defpackage.yu3
    public final ou3 getShapeAppearanceModel() {
        return this.f.a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.D0;
        region.set(bounds);
        RectF rectFG = g();
        Path path = this.z0;
        b(rectFG, path);
        Region region2 = this.E0;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final float h() {
        if (k()) {
            return this.G0.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final float i() {
        float[] fArr = this.T0;
        return fArr != null ? fArr[3] : this.f.a.d().e.a(g());
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.Y = true;
        this.Z = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f.e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f.getClass();
        ColorStateList colorStateList2 = this.f.d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f.c;
        return (colorStateList3 != null && colorStateList3.isStateful()) || this.f.a.e();
    }

    public final boolean j() {
        wi2 wi2Var = this.f;
        int i = wi2Var.n;
        if (i == 1 || wi2Var.o <= 0) {
            return false;
        }
        return i == 2 || !(m() || this.z0.isConvex() || Build.VERSION.SDK_INT >= 29);
    }

    public final boolean k() {
        Paint.Style style = this.f.q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.G0.getStrokeWidth() > 0.0f;
    }

    public final void l(Context context) {
        this.f.b = new f21(context);
        y();
    }

    public final boolean m() {
        if (this.f.a.b(getState()).k(g())) {
            return this.T0 == null || this.P0;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f = new wi2(this.f);
        return this;
    }

    public final void n(x04 x04Var) {
        if (this.R0 == x04Var) {
            return;
        }
        this.R0 = x04Var;
        int i = 0;
        while (true) {
            w04[] w04VarArr = this.S0;
            if (i >= w04VarArr.length) {
                w(getState(), true);
                invalidateSelf();
                return;
            }
            if (w04VarArr[i] == null) {
                w04VarArr[i] = new w04(this, X0[i]);
            }
            w04 w04Var = w04VarArr[i];
            x04 x04Var2 = new x04();
            x04Var2.a((float) x04Var.b);
            double d = x04Var.a;
            x04Var2.b((float) (d * d));
            w04Var.m = x04Var2;
            i++;
        }
    }

    public final void o(float f) {
        wi2 wi2Var = this.f;
        if (wi2Var.m != f) {
            wi2Var.m = f;
            y();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.Y = true;
        this.Z = true;
        super.onBoundsChange(rect);
        if (!this.f.a.e() || rect.isEmpty()) {
            return;
        }
        int[] state = getState();
        w04[] w04VarArr = this.S0;
        int length = w04VarArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < length) {
                w04 w04Var = w04VarArr[i];
                if (w04Var != null && w04Var.f) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        w(state, true ^ z);
    }

    @Override // android.graphics.drawable.Drawable, defpackage.nb4
    public boolean onStateChange(int[] iArr) {
        if (this.f.a.e()) {
            w(iArr, false);
        }
        boolean z = v(iArr) || x();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public final void p(ColorStateList colorStateList) {
        wi2 wi2Var = this.f;
        if (wi2Var.c != colorStateList) {
            wi2Var.c = colorStateList;
            onStateChange(getState());
        }
    }

    public final void q(float f) {
        wi2 wi2Var = this.f;
        if (wi2Var.i != f) {
            wi2Var.i = f;
            this.Y = true;
            this.Z = true;
            invalidateSelf();
        }
    }

    public final void r(int i) {
        this.H0.a(i);
        this.f.getClass();
        super.invalidateSelf();
    }

    public final void s() {
        wi2 wi2Var = this.f;
        if (wi2Var.n != 2) {
            wi2Var.n = 2;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        wi2 wi2Var = this.f;
        if (wi2Var.k != i) {
            wi2Var.k = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f.getClass();
        super.invalidateSelf();
    }

    @Override // defpackage.yu3
    public final void setShapeAppearanceModel(ou3 ou3Var) {
        this.f.a = ou3Var;
        this.T0 = null;
        this.U0 = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f.e = colorStateList;
        x();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        wi2 wi2Var = this.f;
        if (wi2Var.f != mode) {
            wi2Var.f = mode;
            x();
            super.invalidateSelf();
        }
    }

    public final void t(int i) {
        wi2 wi2Var = this.f;
        if (wi2Var.p != i) {
            wi2Var.p = i;
            super.invalidateSelf();
        }
    }

    public final void u(nu3 nu3Var) {
        if (nu3Var instanceof ou3) {
            setShapeAppearanceModel((ou3) nu3Var);
            return;
        }
        p24 p24Var = (p24) nu3Var;
        wi2 wi2Var = this.f;
        if (wi2Var.a != p24Var) {
            wi2Var.a = p24Var;
            w(getState(), true);
            invalidateSelf();
        }
    }

    public final boolean v(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f.c == null || color2 == (colorForState2 = this.f.c.getColorForState(iArr, (color2 = (paint2 = this.F0).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.f.d == null || color == (colorForState = this.f.d.getColorForState(iArr, (color = (paint = this.G0).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053 A[EDGE_INSN: B:55:0x0053->B:27:0x0053 BREAK  A[LOOP:0: B:18:0x003a->B:23:0x0044]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w(int[] iArr, boolean z) {
        boolean z2;
        RectF rectFG = g();
        if (!this.f.a.e() || rectFG.isEmpty()) {
            return;
        }
        int i = 0;
        boolean z3 = z | (this.R0 == null);
        if (this.T0 == null) {
            this.T0 = new float[4];
        }
        ou3 ou3VarB = this.f.a.b(iArr);
        float[] fArr = this.T0;
        if (fArr.length <= 1) {
            z2 = !ou3VarB.k(g());
        } else {
            float f = fArr[0];
            for (int i2 = 1; i2 < fArr.length; i2++) {
                if (fArr[i2] != f) {
                    break;
                }
            }
            if (!ou3VarB.k(g())) {
            }
        }
        this.P0 = z2;
        if (!z2) {
            this.Y = true;
            this.Z = true;
        }
        while (i < 4) {
            this.J0.getClass();
            float fA = (i != 1 ? i != 2 ? i != 3 ? ou3VarB.f : ou3VarB.e : ou3VarB.h : ou3VarB.g).a(rectFG);
            if (z3) {
                this.T0[i] = fA;
            }
            w04[] w04VarArr = this.S0;
            w04 w04Var = w04VarArr[i];
            if (w04Var != null) {
                w04Var.a(fA);
                if (z3) {
                    w04VarArr[i].d();
                }
            }
            i++;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    public final boolean x() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.K0;
        PorterDuffColorFilter porterDuffColorFilter3 = this.L0;
        wi2 wi2Var = this.f;
        ColorStateList colorStateList = wi2Var.e;
        PorterDuff.Mode mode = wi2Var.f;
        if (colorStateList == null || mode == null) {
            int color = this.F0.getColor();
            int iC = c(color);
            this.M0 = iC;
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iC2 = c(colorStateList.getColorForState(getState(), 0));
            this.M0 = iC2;
            porterDuffColorFilter = new PorterDuffColorFilter(iC2, mode);
        }
        this.K0 = porterDuffColorFilter;
        this.f.getClass();
        this.L0 = null;
        this.f.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.K0) && Objects.equals(porterDuffColorFilter3, this.L0)) ? false : true;
    }

    public final void y() {
        wi2 wi2Var = this.f;
        float f = wi2Var.m + 0.0f;
        wi2Var.o = (int) Math.ceil(0.75f * f);
        this.f.p = (int) Math.ceil(f * 0.25f);
        x();
        if (j() || !m()) {
            invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public yi2(Context context, AttributeSet attributeSet, int i, int i2) {
        this(ou3.h(context, attributeSet, i, i2).b());
    }

    public yi2(ou3 ou3Var) {
        this(new wi2(ou3Var));
    }

    public yi2(nu3 nu3Var) {
        this(new wi2(nu3Var));
    }

    public yi2() {
        this(new ou3());
    }
}
